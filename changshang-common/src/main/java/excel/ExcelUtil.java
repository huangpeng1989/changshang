package excel;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.Cell.*;

/**
 * @Author ming.jin
 * @Date 2017/8/8
 */
public class ExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * Create excel 对象.
     *
     * @param <T>       the type parameter
     * @param dataList  the data list
     * @param dataClass the data class
     * @return the excel
     */
    public static <T> Excel<T> createExcelObj(List<T> dataList,Class<T> dataClass){
        Excel<T> excel = new Excel<>();
        excel.setHeads(createExcelHead(dataClass));
        excel.setExtension("xls");
        excel.setSheetName("Sheet1");
        excel.setRowSize(dataList.size()+1);
        excel.setColumnSize(excel.getHeads().size());
        excel.setData(dataList);

        return excel;
    }

    /**
     * 创建excel Workbook对象.
     *
     * @param excel the excel
     */
    public static <T> Workbook createExcel(Excel<T> excel){
        Workbook wb = null;
        if (excel.getExtension().equals("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet sheet = wb.createSheet(excel.getSheetName());
        sheet.setDefaultColumnWidth((short) 20);
        //写标题
        Map<String,Boolean> groupWriteFlag = new HashMap<>();
        int rowIndex = 0;
        Row titleRow = sheet.createRow(rowIndex);
        List<ExcelHead> heads = excel.getHeads();
        heads =heads.stream().sorted(Comparator.comparing(ExcelHead::getWriteSort)).collect(Collectors.toList());
        int columnNum = 0;
        int dataStartRow = excel.getDataStartRow();
        for (ExcelHead head : heads){
            if (!head.getHeadName().contains("|")){
                CellRangeAddress cellRangeAddress =new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), columnNum, columnNum);
                sheet.addMergedRegion(cellRangeAddress);
                Cell cell = titleRow.createCell(columnNum);
                cell.setCellValue(head.getHeadName());

            }else{
                String[] groupArray = head.getHeadName().split("\\|");
                String groupName = groupArray[0];
                if (!MapUtils.getBoolean(groupWriteFlag,groupName,false)){
                    CellRangeAddress cellRangeAddress =new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), columnNum, columnNum+groupArray.length-1);
                    sheet.addMergedRegion(cellRangeAddress);
                    Cell cell = titleRow.createCell(columnNum);
                    cell.setCellValue(groupName);
                    groupWriteFlag.put(groupName,true);
                }

                Row subTitleRow = sheet.getRow(titleRow.getRowNum()+1);
                if (subTitleRow==null){
                    subTitleRow = sheet.createRow(titleRow.getRowNum()+1);
                }
                Cell subTitleCell = subTitleRow.getCell(columnNum);
                if(subTitleCell == null){
                    subTitleCell = subTitleRow.createCell(columnNum);
                }
                subTitleCell.setCellValue(groupArray[1]);
            }
            columnNum++;
        }

        rowIndex=excel.getDataStartRow() + 1;

        //写值

        List<T> dataList = excel.getData();
        int objIndex = 0;
        for(T item:dataList){
            Row dataRow = sheet.createRow(rowIndex);
            int i = 0;
            for (ExcelHead head : heads){
                try {
                    Field field =item.getClass().getDeclaredField(head.getPropertyName());
                    field.setAccessible(true);
                    Object value =field.get(item);
                    Cell cell = dataRow.createCell(i);
                    if (head.getType().equals(HeadProperty.HeadType.STRING)){
                        if (value == null){
                            cell.setCellValue("");
                        }else{
                            cell.setCellValue(value.toString());
                        }
                    }
                    if (head.getType().equals(HeadProperty.HeadType.INT)){
                        if (value == null){
                            cell.setCellValue(0);
                        }else{
                            cell.setCellValue((int)value);
                        }
                    }
                    if (head.getType().equals(HeadProperty.HeadType.DOUBLE)){
                        if (value == null){
                            cell.setCellValue(0.0);
                        }else {
                            cell.setCellValue((double) value);
                        }
                    }
                    if (head.getType().equals(HeadProperty.HeadType.DATE)){
                        if (value == null){
                            cell.setCellValue("");
                        }else {
                            SimpleDateFormat sdf = new SimpleDateFormat(head.getFormat());
                            cell.setCellValue(sdf.format((Date) value));
                        }
                    }

                } catch (NoSuchFieldException e) {
                    logger.error(e.getMessage(),e);
                    throw new RuntimeException("创建excel 出错");
                } catch (IllegalAccessException e) {
                    logger.error(e.getMessage(),e);
                    throw new RuntimeException("创建excel 出错");
                }
                i++;
            }
            rowIndex++;
            objIndex++;

        }

        return wb;
    }

    /**
     * 解析excel文件
     *
     * @param is        the is
     * @param extension the excel扩展名
     * @param dataClass the data class
     * @return the excel
     */
    public static <T> Excel<T> resolverExcel(InputStream is,String extension,Class<T> dataClass){
        Workbook wb = null;
        Excel<T> excel = new Excel<>();
        try {
            if (extension.equals("xls")){
                wb = new HSSFWorkbook(is);
            }else{
                wb = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException("读取Excel出错");
        }
        excel.setExtension(extension);

        //写标题
        List<ExcelHead> heads = createExcelHead(dataClass);
        excel.setHeads(heads);

        Sheet sheet =  wb.getSheetAt(0);
        String sheetName =sheet.getSheetName();

        excel.setSheetName(sheetName);

       /* int num = sheet.getLastRowNum();
        //删除的空行(包含空白行和带有格式的空行)
        int bk = 0;
        //记录空白行的集合
        List<Integer> nums = Lists.newArrayList();
        for (int i = 1; i <= num; i++) {
            Row row = sheet.getRow(i);
            boolean flag = false;
            //带有格式的空白行
            if (row != null) {
                for (Cell cell : row) {
                    //判断该单元格是否为空
                    if (StringUtils.isEmpty(cell.toString())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    nums.add(i);
                    bk++;
                }
                //空白行
            } else {
                nums.add(i);
                bk++;
            }
        }
        //删除无效数据行(空白行,带格式的空白行)
        for (Integer n : nums) {
            if (sheet.getRow(n) != null) {
                sheet.removeRow(sheet.getRow(n));
            }
        }
*/
        excel.setRowSize(sheet.getLastRowNum()+1);

        //构造一个map标题名称对应哪一列
        Map<Integer,ExcelHead> headIndexMap = resolveExcelHeader(excel,heads,sheet);

        //读数据
        List<T> dataList = new ArrayList<>();
        List<Map<String,String>> originDataList = new ArrayList<>();
        for (int i = excel.getDataStartRow();i<excel.getRowSize();i++){
            Row dataRow = sheet.getRow(i);
            Map<String,String> dataMap = new HashMap<>();
            T obj = null;
            try {
                obj = dataClass.newInstance();
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException("在Excel对应的数据类无法初始化");
            }

            for(int j = 0;j<excel.getColumnSize();j++){
                Cell cell = dataRow.getCell(j);
                if (cell == null){
                    continue;
                }
                ExcelHead head =headIndexMap.get(j);

                Field field = null;
                try {
                    field = dataClass.getDeclaredField(head.getPropertyName());
                } catch (NoSuchFieldException e) {
                    logger.error(e.getMessage(),e);
                    throw new RuntimeException("在Excel对应的属性无法初始化");
                }
                field.setAccessible(true);

                dataMap.put(field.getName(),getCellDataToString(cell,head));

                if (head.getType().equals(HeadProperty.HeadType.STRING)){
                    try{
                        if (cell != null) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            field.set(obj,cell.getStringCellValue());
                        }

                    }catch (Exception e){
                        excel.addErrorInfo(createError(i,j,i-excel.getDataStartRow(),head.getHeadName(),"格式错误"));
                    }
                }
                if (head.getType().equals(HeadProperty.HeadType.INT)){
                    try {
                        if (field.getType().equals(Integer.class)) {
                            field.set(obj, ((Double) cell.getNumericCellValue()).intValue());
                        }
                        if (field.getType().equals(Long.class)) {
                            field.set(obj, ((Double) cell.getNumericCellValue()).longValue());
                        }
                    }catch (Exception e){
                        excel.addErrorInfo(createError(i,j,i-excel.getDataStartRow(),head.getHeadName(),"格式错误"));
                    }
                }
                if (head.getType().equals(HeadProperty.HeadType.DOUBLE)){
                    try{
                        field.set(obj,getDoubleValueInCell(cell));
                    }catch (Exception e){
                        excel.addErrorInfo(createError(i,j,i-excel.getDataStartRow(),head.getHeadName(),"格式错误"));
                    }
                }
                if (head.getType().equals(HeadProperty.HeadType.DATE)){
                    try {
                        if(HSSFDateUtil.isCellDateFormatted(cell)){
                            field.set(obj,cell.getDateCellValue());
                        }
                    }catch (Exception e){
                        try {
                            String dateStr = cell.getStringCellValue();
                            if (StringUtils.isNotEmpty(dateStr)) {
                                SimpleDateFormat sdf = new SimpleDateFormat(head.getFormat());
                                field.set(obj, sdf.parse(dateStr));
                            }
                        }catch (Exception ex){
                            excel.addErrorInfo(createError(i,j,i-excel.getDataStartRow(),head.getHeadName(),"格式错误"));
                        }
                    }
                }
            }
            originDataList.add(dataMap);
            dataList.add(obj);
        }
        excel.setOriginData(originDataList);
        excel.setData(dataList);
        return excel;
    }

    private static ExcelErrorInfo createError(int rowNo, int ColumnNo,int objIndex, String headName, String info) {
        ExcelErrorInfo error = new ExcelErrorInfo();
        error.setRowNo(rowNo+1);
        error.setColumnNo(ColumnNo+1);
        error.setObjIndex(objIndex);
        error.setTitleName(headName);
        error.setErrorInfo(info);
        return error;
    }

    /**
     * 解析excel标题头.
     *
     * @param excel the excel
     * @param heads the heads
     * @param sheet the sheet
     * @return the map
     */
    public static Map<Integer,ExcelHead> resolveExcelHeader(Excel excel,List<ExcelHead> heads,Sheet sheet){

        excel.setDataStartRow(1);

        Map<Integer,ExcelHead> headIndexMap = new HashMap<>();

        Row titleRow = sheet.getRow(0);
        excel.setColumnSize(titleRow.getLastCellNum());
        for(int i = 0;i<titleRow.getLastCellNum();i++){
            Cell cell = titleRow.getCell(i);
            String headerName =cell.getStringCellValue();
            //Optional<ExcelHead> head= heads.parallelStream().filter(t->t.getHeadName().equals(headerName)).findFirst();
            List<ExcelHead> findedHeaders = heads.parallelStream().filter(t->t.getHeadName().startsWith(headerName)).collect(Collectors.toList());
            if(findedHeaders.size()==1){
                headIndexMap.put(i,findedHeaders.get(0));
            }else if(findedHeaders.size()>1){
                Row subTitleRow = sheet.getRow(1);
                int max = i+findedHeaders.size();
                for(int j = i;j<max;j++){
                    Cell subCell = subTitleRow.getCell(j);
                    if(subCell!= null){
                        String subHeaderName =subCell.getStringCellValue();
                        Optional<ExcelHead> head= heads.parallelStream().filter(t->t.getHeadName().equals(headerName+"|"+subHeaderName)).findFirst();
                        if (head.isPresent()){
                            headIndexMap.put(j,head.get());
                            excel.setDataStartRow(2);
                        }else{
                            throw new RuntimeException("在Excel中找不到对应的列名"+headerName+"|"+subHeaderName);
                        }
                    }
                }
                i=i+findedHeaders.size()-1;
            }else {
                Optional<ExcelHead> optionHead = heads.stream().filter(t->t.getHeadName().equals(headerName)).findFirst();
                if (!optionHead.isPresent()) {
                    throw new RuntimeException("在Excel中找不到对应的列名" + headerName);
                }
            }
        }

        return headIndexMap;
    }

    /**
     * Create excel 标题头.
     *
     * @param <T>       the type parameter
     * @param dataClass the data class
     * @return the list
     */
    public static <T> List<ExcelHead> createExcelHead(Class<T> dataClass){
        Field[] fields = dataClass.getDeclaredFields();
        List<ExcelHead> heads = new ArrayList<>();
        for (Field field : fields){
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation : annotations) {
                if (annotation instanceof HeadProperty) {
                    HeadProperty property = (HeadProperty) annotation;
                    ExcelHead head = new ExcelHead();
                    head.setHeadName(property.name());
                    head.setPropertyName(field.getName());
                    head.setType(property.type());
                    head.setFormat(property.format());
                    head.setOption(property.option());
                    head.setWriteSort(property.writeSort());
                    heads.add(head);
                }
            }
        }
        return heads;
    }

    public static Workbook createProductExcel(List<String> list, Map<String, Object> map) {
        Excel excel = new Excel<>();
        excel.setHeads(createProductExcelHead(list));
        excel.setExtension("xls");
        excel.setSheetName("Sheet1");
        excel.setRowSize(1);
        excel.setColumnSize(excel.getHeads().size());
        Workbook wb = null;
        if (excel.getExtension().equals("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet sheet = wb.createSheet(excel.getSheetName());
        //写标题
        int rowIndex = 0;
        Row titleRow = sheet.createRow(rowIndex);
        List<ExcelHead> heads = excel.getHeads();
        heads =heads.stream().sorted(Comparator.comparing(ExcelHead::getWriteSort)).collect(Collectors.toList());
        int columnNum = 0;
        for (ExcelHead head : heads){
            CellRangeAddress cellRangeAddress =new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), columnNum, columnNum);
            sheet.addMergedRegion(cellRangeAddress);
            Cell cell = titleRow.createCell(columnNum);
            cell.setCellValue(head.getHeadName());
            columnNum++;
        }
        if (sheet.getRow(rowIndex) != null) {
            int lastRowNo = sheet.getLastRowNum();
            sheet.shiftRows(rowIndex, lastRowNo, 1);
        }
        //添加首行  赋值 SKU 规格选项
        Row firstRow = sheet.createRow(rowIndex);
        CellRangeAddress cellRangeAddress =new CellRangeAddress(firstRow.getRowNum(), firstRow.getRowNum(), 0, columnNum - 1);
        sheet.addMergedRegion(cellRangeAddress);
        Cell cell = firstRow.createCell(0);
        cell.getCellStyle().setAlignment(CellStyle.ALIGN_LEFT);
        cell.getCellStyle().setVerticalAlignment(CellStyle.VERTICAL_TOP);
        cell.getCellStyle().setWrapText(true);
        firstRow.setHeightInPoints(80);
        String name = "";
        for(Map.Entry<String,Object> entry : map.entrySet()) {
            name += entry.getKey();
            List<String> values = (List<String>) entry.getValue();
            name = name +"："+JSONObject.toJSONString(values) + "\n";
        }
        cell.setCellValue(name);
        return wb;
    }

    /**
     *
     * @param list
     * @return
     */
    public static List<ExcelHead> createProductExcelHead(List<String> list){
        List<ExcelHead> heads = new ArrayList<>();
        list.forEach(p ->{
            ExcelHead head = new ExcelHead();
            head.setHeadName(p);
            heads.add(head);
        });
        return heads;
    }

    /**
     * 解析产品导入 Excel
     * @param is
     * @param extension
     * @return
     */
    public static Excel<Map> resolverProductExcel(InputStream is, String extension) {
        Workbook wb = null;
        Excel<Map> excel = new Excel<>();
        try {
            if (extension.equals("xls")){
                wb = new HSSFWorkbook(is);
            }else{
                wb = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException("读取Excel出错");
        }
        excel.setExtension(extension);
        Sheet sheet =  wb.getSheetAt(0);
        String sheetName =sheet.getSheetName();
        excel.setSheetName(sheetName);
        excel.setRowSize(sheet.getLastRowNum()+1);
        excel.setDataStartRow(2);
        List<ExcelHead> heads = new ArrayList<>();
        if(sheet.getLastRowNum() > 0) {
            Row headRow = sheet.getRow(1);
            excel.setColumnSize(headRow.getLastCellNum());
            for(int i = 0;i<headRow.getLastCellNum();i++){
                ExcelHead head = new ExcelHead();
                headRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                head.setHeadName(headRow.getCell(i).getStringCellValue());
                head.setPropertyName(headRow.getCell(i).getStringCellValue());
                head.setType(HeadProperty.HeadType.STRING);
                heads.add(head);
            }
        }
        excel.setHeads(heads);
        //构造一个map标题名称对应哪一列
        Map<Integer,ExcelHead> headIndexMap = resolveProductExcelHeader(excel,heads,sheet);
        //读数据
        List<Map> dataList = new ArrayList<>();
        List<Map<String,String>> originDataList = new ArrayList<>();
        for (int i = excel.getDataStartRow();i<excel.getRowSize();i++){
            Row dataRow = sheet.getRow(i);
            Map<String,String> dataMap = new HashMap<>();
            Map obj = new HashMap();
            for(int j = 0;j<excel.getColumnSize();j++){
                Cell cell = dataRow.getCell(j);
                ExcelHead head =headIndexMap.get(j);
                String  field = head.getPropertyName();
                if(cell == null) {
                    throw new RuntimeException("【"+field+"】列存在空值，请重新编辑EXCEL文件并再次导入");
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                dataMap.put(field,getCellDataToString(cell,head));
                obj.put(field,cell.getStringCellValue());
            }
            originDataList.add(dataMap);
            dataList.add(obj);
        }
        excel.setOriginData(originDataList);
        excel.setData(dataList);
        return excel;
    }

    /**
     * 解析excel标题头.
     *
     * @param excel the excel
     * @param heads the heads
     * @param sheet the sheet
     * @return the map
     */
    public static Map<Integer,ExcelHead> resolveProductExcelHeader(Excel excel,List<ExcelHead> heads,Sheet sheet){
        Map<Integer,ExcelHead> headIndexMap = new HashMap<>();
        Row titleRow = sheet.getRow(1);
        excel.setColumnSize(titleRow.getLastCellNum());
        for(int i = 0;i<titleRow.getLastCellNum();i++){
            Cell cell = titleRow.getCell(i);
            String headerName =cell.getStringCellValue();
            //Optional<ExcelHead> head= heads.parallelStream().filter(t->t.getHeadName().equals(headerName)).findFirst();
            List<ExcelHead> findedHeaders = heads.parallelStream().filter(t->t.getHeadName().startsWith(headerName)).collect(Collectors.toList());
            if(findedHeaders.size()==1){
                headIndexMap.put(i,findedHeaders.get(0));
            }else if(findedHeaders.size()>1){
                Row subTitleRow = sheet.getRow(1);
                int max = i+findedHeaders.size();
                for(int j = i;j<max;j++){
                    Cell subCell = subTitleRow.getCell(j);
                    String subHeaderName =subCell.getStringCellValue();
                    Optional<ExcelHead> head= heads.parallelStream().filter(t->t.getHeadName().equals(headerName+"|"+subHeaderName)).findFirst();
                    if (head.isPresent()){
                        headIndexMap.put(j,head.get());
                        excel.setDataStartRow(2);
                    }else{
                        throw new RuntimeException("在Excel中找不到对应的列名"+headerName+"|"+subHeaderName);
                    }
                }
                i=i+findedHeaders.size()-1;
            }else {
                ExcelHead optionHead = heads.stream().filter(t->t.getHeadName().equals(headerName)).findFirst().get();
                if (!optionHead.isOption()){
                    throw new RuntimeException("在Excel中找不到对应的列名"+headerName);
                }
            }
        }

        return headIndexMap;
    }

    private static String getCellDataToString(Cell cell,ExcelHead head){
        if(cell == null) {
            return "";
        }
        switch (cell.getCellType()){

//            case _NONE:
//                return "";
            case CELL_TYPE_BLANK:
                return "";
            case CELL_TYPE_ERROR:
                return "";
            case CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case CELL_TYPE_BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case CELL_TYPE_FORMULA:
                return Double.toString(cell.getNumericCellValue());
            case CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat sdf = new SimpleDateFormat(head.getFormat());
                    return sdf.format(cell.getDateCellValue());
                }else{
                    return Double.toString(cell.getNumericCellValue());
                }

            default:
                return "";
        }
    }


    private static Double getDoubleValueInCell(Cell cell){
        double result = 0;
        try {
            result =cell.getNumericCellValue();
        }catch (Exception e){
            String str = cell.getStringCellValue();
            result = Double.parseDouble(str);
        }
        return result;
    }

    public static String getFileName(String userAgent, String fileName){
        String encodeName = "";
        try {
            if (userAgent != null && (userAgent.contains("Firefox") || userAgent.contains("Chrome")
                    || userAgent.contains("Safari"))) {
                encodeName= new String((fileName).getBytes(), "ISO8859-1");
            } else {
                encodeName= URLEncoder.encode(fileName,"UTF-8"); //其他浏览器
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeName;
    }

    public static void insertTitleRow(Workbook wb, Excel excel,String title) {
        Sheet sheet = wb.getSheet(excel.getSheetName());
        int insertRowIndex = 0;
        sheet.shiftRows(insertRowIndex, sheet.getLastRowNum(),1,true,false);
        Row row = sheet.createRow(insertRowIndex);
        CellRangeAddress cellRangeAddress =new CellRangeAddress(insertRowIndex, insertRowIndex, 0, excel.getHeads().size()-1);
        sheet.addMergedRegion(cellRangeAddress);
        Cell cell = row.createCell(0);
        cell.setCellValue(title);
    }



    /*******************王文斌*******************/

    /**
     * @Title: createExcelTemplate
     * @Description: 生成Excel导入模板
     * @param @param filePath  Excel文件路径
     * @param @param handers   Excel列标题(数组)
     * @param @param downData  下拉框数据(数组)
     * @param @param downRows  下拉列的序号(数组,序号从0开始)
     * @return void
     * @throws
     */
    public  static void createExcelTemplate(String filePath, String[] handers,
                                            List<String[]> downData, String[] downRows, String name,HttpServletRequest request, HttpServletResponse response){
        Workbook wb = null;
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        if (extension.equals("xls")){
            wb = new HSSFWorkbook();
        }else {
            wb = new XSSFWorkbook();//创建工作薄
        }

        //表头样式
        CellStyle style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER); // 创建一个居中格式
        //字体样式
        Font fontStyle = wb.createFont();
        fontStyle.setFontName("微软雅黑");
        fontStyle.setFontHeightInPoints((short)12);
        fontStyle.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(fontStyle);

        //新建sheet
        Sheet sheet1 = wb.createSheet(name);
        Sheet sheet2 = wb.createSheet("模版说明");


        //生成sheet1内容
        Row rowFirst = sheet1.createRow(0);//第一个sheet的第一行为标题
        //写标题
        for(int i=0;i<handers.length;i++){
            Cell cell = rowFirst.createCell(i); //获取第一行的每个单元格
            sheet1.setColumnWidth(i, 7000); //设置每列的列宽
            cell.setCellStyle(style); //加样式
            cell.setCellValue(handers[i]); //往单元格里写数据
        }

        //设置下拉框数据
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int index = 0;
        Row row = null;
        for(int r=0;r<downRows.length;r++){
            String[] dlData = downData.get(r);//获取下拉对象
            int rownum = Integer.parseInt(downRows[r]);

            if(dlData.length<10){ //255以内的下拉
                //255以内的下拉,参数分别是：作用的sheet、下拉内容数组、起始行、终止行、起始列、终止列
                sheet1.addValidationData(setDataValidation(sheet1, dlData, 1, 50000, rownum ,rownum)); //超过255个报错
            } else { //255以上的下拉，即下拉列表元素很多的情况
                sheet2.setColumnWidth(r, 7000); //设置每列的列宽

                //1、设置有效性
                String strFormula = "模版说明!$"+arr[index]+"$1:$"+arr[index]+"$5000"; //Sheet2第A1到A5000作为下拉列表来源数据
                //设置数据有效性加载在哪个单元格上,参数分别是：从sheet2获取A1到A5000作为一个下拉的数据、起始行、终止行、起始列、终止列
                sheet1.addValidationData(SetDataValidation(wb,strFormula,extension, 1, 5000, rownum, rownum)); //下拉列表元素很多的情况

                for(int j=0;j<dlData.length;j++){
                    if(index==0){ //第1个下拉选项，直接创建行、列
                        row = sheet2.createRow(j); //创建数据行
                        sheet2.setColumnWidth(j, 6000); //设置每列的列宽
                        row.createCell(0).setCellValue(dlData[j]); //设置对应单元格的值

                    } else { //非第1个下拉选项

                        int rowCount = sheet2.getLastRowNum();
                        if(j<=rowCount){ //前面创建过的行，直接获取行，创建列
                            //获取行，创建列
                            sheet2.getRow(j).createCell(index).setCellValue(dlData[j]); //设置对应单元格的值

                        } else { //未创建过的行，直接创建行、创建列
                            sheet2.setColumnWidth(j, 4000); //设置每列的列宽
                            //创建行、创建列
                            sheet2.createRow(j).createCell(index).setCellValue(dlData[j]); //设置对应单元格的值
                        }
                    }
                }

                // 隐藏作为下拉列表值的Sheet
//                wb.setSheetHidden(wb.getSheetIndex("模版说明"), 1);
                index++;


            }
        }

        try {

            File f = new File(filePath); //写文件

            //不存在则新增
//            if(!f.exists()){
//                System.out.println(f.exists());
//                f.mkdirs();
//            }
            if(!f.exists()){
                f.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(f);
            String userAgent = request.getHeader("user-agent");
            response.setHeader("Content-disposition", "attachment; filename=" + ExcelUtil.getFileName(userAgent, filePath));
            response.addHeader("Content-Type", "application/octet-stream");
            OutputStream  os = response.getOutputStream();
            wb.write(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     *
     * @Title: SetDataValidation
     * @Description: 下拉列表元素很多的情况 (255以上的下拉)
     * @param @param strFormula
     * @param @param firstRow   起始行
     * @param @param endRow     终止行
     * @param @param firstCol   起始列
     * @param @param endCol     终止列
     * @param @return
     * @return HSSFDataValidation
     * @throws
     */
    private static DataValidation SetDataValidation(Workbook wb,String strFormula,String extension,
                                                    int firstRow, int endRow, int firstCol, int endCol) {

        // 表示A列1-59行作为下拉列表来源数据
        // String formula = "typelist!$A$1:$A$59" ;
        // 原顺序为 起始行 起始列 终止行 终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);

        if (extension.equals("xls")) {
            DVConstraint constraint = DVConstraint.createFormulaListConstraint(strFormula);
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions,constraint);
            return dataValidation;
        } else if (extension.equals("xlsx")){
            DataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) wb.getSheet("原材料信息"));
            DataValidationConstraint formulaListConstraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.LIST,strFormula);
            DataValidation dataValidation = dvHelper.createValidation(formulaListConstraint, regions);
            return dataValidation;
        }
        return null;
    }




    /**
     *
     * @Title: setDataValidation
     * @Description: 下拉列表元素不多的情况(255以内的下拉)
     * @param @param sheet
     * @param @param textList
     * @param @param firstRow
     * @param @param endRow
     * @param @param firstCol
     * @param @param endCol
     * @param @return
     * @return DataValidation
     * @throws
     */
    private static DataValidation setDataValidation(Sheet sheet, String[] textList, int firstRow, int endRow, int firstCol, int endCol) {

        DataValidationHelper helper = sheet.getDataValidationHelper();
        //加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textList);
        //DVConstraint constraint = new DVConstraint();
        constraint.setExplicitListValues(textList);

        //设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);

        //数据有效性对象
        DataValidation data_validation = helper.createValidation(constraint, regions);
        //DataValidation data_validation = new DataValidation(regions, constraint);

        return data_validation;
    }



    /**
     * @Title: getExcel
     * @Description: 下载指定路径的Excel文件
     * @param @param url 文件路径
     * @param @param fileName  文件名
     * @param @param response
     * @return void
     * @throws
     */
    public static void getExcel(String url, String fileName, HttpServletResponse response, HttpServletRequest request){

        try {

            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");

            //2.设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + encodeChineseDownloadFileName(request, fileName+".xls") +"\"");
//            response.setHeader("Content-Disposition", "attachment;filename="
//                    + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xls"); //中文文件名

            //通过文件路径获得File对象
            File file = new File(url);

            FileInputStream in = new FileInputStream(file);
            //3.通过response获取OutputStream对象(out)
            OutputStream out = new BufferedOutputStream(response.getOutputStream());

            int b = 0;
            byte[] buffer = new byte[2048];
            while ((b=in.read(buffer)) != -1){
                out.write(buffer,0,b); //4.写到输出流(out)中
            }

            in.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
//            log.error("下载Excel模板异常", e);
        }
    }

    /**
     *
     * @Title: encodeChineseDownloadFileName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param request
     * @param @param pFileName
     * @param @return
     * @param @throws UnsupportedEncodingException
     * @return String
     * @throws
     */
    private static String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName)
            throws UnsupportedEncodingException {

        String filename = null;
        String agent = request.getHeader("USER-AGENT");
        //System.out.println("agent==========》"+agent);

        if (null != agent) {
            if (-1 != agent.indexOf("Firefox")) {//Firefox
                filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes(StandardCharsets.UTF_8)))) + "?=";
            } else if (-1 != agent.indexOf("Chrome")) {//Chrome
                filename = new String(pFileName.getBytes(), "ISO8859-1");
            } else {//IE7+
                filename = URLEncoder.encode(pFileName, "UTF-8");
                filename = StringUtils.replace(filename, "+", "%20");//替换空格
            }
        } else {
            filename = pFileName;
        }

        return filename;
    }


    /**
     * @Title: delFile
     * @Description: 删除文件
     * @param @param filePath  文件路径
     * @return void
     * @throws
     */
    public static void delFile(String filePath) {
        File delFile = new File(filePath);
        delFile.delete();
    }






    /********************************测试*********************/
    // 传入下拉列表数组值，构造信息模板
    public static Workbook generateExcel(String[] typeArrays) {
        Workbook wb = new XSSFWorkbook();
        // 创建模板工作表
        Sheet sheet = wb.createSheet("test");
        // 创建下拉列表值存储工作表并设置值
        genearteOtherSheet(wb, typeArrays);

        // 创建模板列信息并绑定下拉列表值
        Row row = sheet.createRow(0);
        // 设置列信息样式 -- 当前样式对于列信息未居中
        setStyle(wb, sheet, 0);
        setStyle(wb, sheet, 1);
        // 绑定列信息
        Cell nameCell = row.createCell(0);
        nameCell.setCellValue("名称");
        Cell typeCell = row.createCell(1);
        typeCell.setCellValue("类型");

        // 设置下拉列表直绑定对哪一页起作用
        sheet.addValidationData(SetDataValidation(wb, "原材料信息!$A$1:$A$" + typeArrays.length, "xls",1, 0, typeArrays.length, 0));

//        // 隐藏作为下拉列表值的Sheet
//        wb.setSheetHidden(wb.getSheetIndex("原材料信息"), 1);

        return wb;
    }

    // 创建下拉列表值存储工作表并设置值
    public static void genearteOtherSheet(Workbook wb, String[] typeArrays) {
        // 创建下拉列表值存储工作表
        Sheet sheet = wb.createSheet("原材料信息");
        // 循环往该sheet中设置添加下拉列表的值
        for (int i = 0; i < typeArrays.length; i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(typeArrays[i]);
        }
    }


    // 设置列信息样式
    public static void setStyle(Workbook wb, Sheet sheet,int colNum) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        DataFormat format = wb.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));

        sheet.setDefaultColumnStyle(colNum, cellStyle);
    }






    public static void main(String[] args) throws Exception {
        List<String> typelist = new ArrayList<String>();
        for (int i = 0; i < 200; i++) {
            typelist.add("今天是星期二天气不是很好你那边呢" + (0 + i));
        }
        String[] typeArrays = typelist.toArray(new String[typelist.size()]);
        Workbook wb = generateExcel(typeArrays);
        File tempFile = new File("/Users/wangwenbin/Downloads/原材料.xlsx");
        OutputStream os = new FileOutputStream(tempFile);

        wb.write(os);
        os.close();
    }


}
