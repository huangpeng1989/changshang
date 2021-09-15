package modelpojo;


import excel.ExcelUtil;
import modelpojo.model.CommodityWhInvtryBillDtl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GatherUtilExcel extends AbstractXlsxView{

    private static SimpleDateFormat format =   new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public   void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        String fileName = map.get("fileName").toString();
       /* workbook = new XSSFWorkbook();
        fileName = fileName.substring(0,fileName.lastIndexOf("."))+".xlsx";*/
        //列名序列
        String[] title=(String[]) map.get("title");
        //第二步创建sheet
        Sheet hssfSheet = workbook.createSheet(fileName);
        hssfSheet.createFreezePane( 0,1,0,1);
        //设置列
        Row row = hssfSheet.createRow(0);//创建第i行
        //row.setHeightInPoints(50);
        Cell cell;

        for (int i = 0; i < title.length; i++) {

            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);//设置字体大小
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setFontName("黑体");
            cell = row.createCell(i);
            hssfSheet.setColumnWidth(i, title[i].getBytes().length*2*256);
            //hssfSheet.setDefaultRowHeight((short) 266);

            style.setFont(font);
            cell.setCellStyle(style);
            cell.setCellValue(title[i]);
        }

        List<Object> list =(List<Object> ) map.get("list");
        CellStyle style = workbook.createCellStyle();
        Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//粗体显示
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        CellStyle style2 = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        font2.setColor(Font.COLOR_RED);
        font2.setFontHeightInPoints((short) 14);//设置字体大小
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        for (int i = 0; i < list.size(); i++) {
            row = hssfSheet.createRow(i + 1);//创建第i行
            List<Object> info=(List<Object>)list.get(i);
            for (int j = 0; j < info.size(); j++) {
                cell = row.createCell(j);
                if(i==list.size()-1 && map.get("index") == null){
                    style2.setFont(font2);
                    cell.setCellStyle(style2);
                }else{
                    style.setFont(font1);
                    cell.setCellStyle(style);
                }
                if(j==0 && i==list.size()-1 && map.get("index") == null ){
                    cell.setCellValue("合计");
                }else{
                   if(info.get(j) instanceof  BigDecimal || info.get(j) instanceof Integer || info.get(j) instanceof  Double){
                       cell.setCellValue(Double.valueOf(info.get(j).toString()));
                   }else{
                       cell.setCellValue(String.valueOf(info.get(j)));
                   }
                }
            }
            if (map.get("img") != null) {//有图片二维码时，设置行高
                row.setHeightInPoints(100);
            }
        }
        //取图片
        if (map.get("img") != null) {

            List<String> imgs = (List<String>) map.get("img");
            int num = 0;
            for (int k = 0; k < imgs.size(); k++) {
                FileOutputStream fileOut = null;
                BufferedImage bufferImg = null;
                //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
                if (k > 0) {
                    num = num + 1;
                }
                try {
                    ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                    bufferImg = ImageIO.read(new URL(imgs.get(k)));
                    ImageIO.write(bufferImg, "jpg", byteArrayOut);

                    //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
                    Drawing patriarch = hssfSheet.createDrawingPatriarch();
                    //anchor主要用于设置图片的属性
                    HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 4, (1 + num), (short) 4, (1 + num));
                    anchor.setAnchorType(3);
                    //插入图片
                    patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String path = FileUtils.getTempDirectoryPath();//临时文件路径
        File file= new File(path + fileName);//给文件设置绝对路径
        //将文件输出到临时服务器路径
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        //清空输出流
        response.reset();
        String userAgent = request.getHeader("user-agent");
        fileName= URLEncoder.encode(fileName,"UTF-8");
        fileName=new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-disposition", "attachment; filename=" + ExcelUtil.getFileName(userAgent, fileName));
        response.addHeader("Content-Type", "application/octet-stream");

        //文件放入response中
        FileInputStream fin=new FileInputStream(file);
        byte[] tempBytes=new byte[2048];
        while(fin.read(tempBytes)!=-1){
            response.getOutputStream().write(tempBytes);
        }
        response.getOutputStream().close();
    }

    //创建下拉excel文件
    public static void buildSelectExcelDocument(Map<String, Object> map, Workbook workbook,
                                     HttpServletRequest request, HttpServletResponse response,String [] downRows,List<String[]> downData
    ) throws Exception {
        String fileName = map.get("fileName").toString();
        //列名序列
        String[] title=(String[]) map.get("title");
        //第二步创建sheet
        Sheet hssfSheet = workbook.createSheet(fileName);
        hssfSheet.createFreezePane( 0,1,0,1);
        //设置列
        Row row = hssfSheet.createRow(0);//创建第i行
        Cell cell;
        for (int i = 0; i < title.length; i++) {
            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);//设置字体大小
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setFontName("黑体");
            cell = row.createCell(i);
            hssfSheet.setColumnWidth(i, title[i].getBytes().length*2*256);
            style.setFont(font);
            cell.setCellStyle(style);
            cell.setCellValue(title[i]);
        }

        List<Object> list =(List<Object> ) map.get("list");
        CellStyle style = workbook.createCellStyle();
        Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//粗体显示
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        CellStyle style2 = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        font2.setColor(Font.COLOR_RED);
        font2.setFontHeightInPoints((short) 14);//设置字体大小
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        for (int i = 0; i < list.size(); i++) {
            row = hssfSheet.createRow(i + 1);//创建第i行
            List<Object> info=(List<Object>)list.get(i);
            for (int j = 0; j < info.size(); j++) {
                cell = row.createCell(j);
                if(i==list.size()-1 && map.get("index") == null){
                    style2.setFont(font2);
                    cell.setCellStyle(style2);
                }else{
                    style.setFont(font1);
                    cell.setCellStyle(style);
                }
                if(j==0 && i==list.size()-1 && map.get("index") == null ){
                    cell.setCellValue("合计");
                }else{
                    if(info.get(j) instanceof  BigDecimal || info.get(j) instanceof Integer || info.get(j) instanceof  Double){
                        cell.setCellValue(Double.valueOf(info.get(j).toString()));
                    }else{
                        cell.setCellValue(String.valueOf(info.get(j)));
                    }
                }
            }
        }
        for(int r=0;r<downRows.length;r++) {
            String[] dlData = downData.get(r);//获取下拉对象
            int rownum = Integer.parseInt(downRows[r]);
            //255以内的下拉,参数分别是：作用的sheet、下拉内容数组、起始行、终止行、起始列、终止列
            hssfSheet.addValidationData(setDataValidation(hssfSheet, dlData, 1, list.size(), rownum, rownum)); //超过255个报错
        }
        String path = FileUtils.getTempDirectoryPath();//临时文件路径
        File file= new File(path + fileName);//给文件设置绝对路径
        //将文件输出到临时服务器路径
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        //清空输出流
        response.reset();
        String userAgent = request.getHeader("user-agent");
        fileName= URLEncoder.encode(fileName,"UTF-8");
        fileName=new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-disposition", "attachment; filename=" + ExcelUtil.getFileName(userAgent, fileName));
        response.addHeader("Content-Type", "application/octet-stream");
        //文件放入response中
        FileInputStream fin=new FileInputStream(file);
        byte[] tempBytes=new byte[2048];
        while(fin.read(tempBytes)!=-1){
            response.getOutputStream().write(tempBytes);
        }
        response.getOutputStream().close();
    }

   //创建多个sheet的excel文件
    public   void buildExcelDocument( Map<String,Object> titles, Map<String,Object> map,String fileName, Workbook workbook,
                                     HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        int index=0;
        for (Map.Entry<String, Object>  item:map.entrySet()
             ) {
            //列名序列
            String[] title=(String[]) titles.get(item.getKey());
            index ++;
            //第二步创建sheet
            Sheet hssfSheet = workbook.createSheet(item.getKey());
            hssfSheet.createFreezePane( 0,1,0,1);
            //设置列
            Row row = hssfSheet.createRow(0);//创建第i行
            Cell cell;

            for (int i = 0; i < title.length; i++) {

                CellStyle style = workbook.createCellStyle();
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
                Font font = workbook.createFont();
                font.setFontHeightInPoints((short) 14);//设置字体大小
                font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                font.setFontName("黑体");
                cell = row.createCell(i);
                hssfSheet.setColumnWidth(i, title[i].getBytes().length*2*256);
                style.setFont(font);
                cell.setCellStyle(style);
                cell.setCellValue(title[i]);
            }

            List<Object> list =(List<Object> ) item.getValue();
            CellStyle style = workbook.createCellStyle();
            Font font1 = workbook.createFont();
            font1.setFontHeightInPoints((short) 12);//设置字体大小
            font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//粗体显示
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中



            CellStyle style2 = workbook.createCellStyle();
            Font font2 = workbook.createFont();
            font2.setColor(Font.COLOR_RED);
            font2.setFontHeightInPoints((short) 14);//设置字体大小
            font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中



            for (int i = 0; i < list.size(); i++) {
                row = hssfSheet.createRow(i + 1);//创建第i行
                List<Object> info=(List<Object>)list.get(i);
                for (int j = 0; j < info.size(); j++) {

                    cell = row.createCell(j);
                    if(j==0 && i==list.size()-1 ){
                        cell.setCellValue("合计");
                    }else{
                        if(info.get(j) instanceof  BigDecimal || info.get(j) instanceof Integer || info.get(j) instanceof  Double){
                            cell.setCellValue(Double.valueOf(info.get(j).toString()));
                        }else{
                            cell.setCellValue(String.valueOf(info.get(j)));
                        }
                    }
                    if(i==list.size()-1){
                        style2.setFont(font2);
                        cell.setCellStyle(style2);
                    }else{
                        style.setFont(font1);
                        cell.setCellStyle(style);
                    }

                }
            }
        }
        String path = FileUtils.getTempDirectoryPath();//临时文件路径
        File file= new File(path + fileName);//给文件设置绝对路径
        //将文件输出到临时服务器路径
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        //清空输出流
        response.reset();
        String userAgent = request.getHeader("user-agent");
        fileName= URLEncoder.encode(fileName,"UTF-8");
        fileName=new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-disposition", "attachment; filename=" + ExcelUtil.getFileName(userAgent, fileName));
        response.addHeader("Content-Type", "application/octet-stream");

        //文件放入response中
        FileInputStream fin=new FileInputStream(file);
        byte[] tempBytes=new byte[2048];
        while(fin.read(tempBytes)!=-1){
            response.getOutputStream().write(tempBytes);
        }
        response.getOutputStream().close();
    }
    //读取盘点启动单excel文件
    public  Map<String ,Object> readExclInfo(MultipartFile file){
        Map<String ,Object> map=new HashMap<>();
        String message="";
        List<CommodityWhInvtryBillDtl>  list  = new ArrayList<>();

        Sheet sheet = getSheet(file);

        if(sheet != null){
            int rowcount = sheet.getLastRowNum();//逻辑行，包括空行
            int cellcount = sheet.getRow(0).getLastCellNum();//第一行（将来作为字段的行）有多少个单元格
            Row ro = sheet.getRow(0);
            Integer index=0;
            for (int b=0 ;b<cellcount;b++
                    ) {
                String value=getCellValue(ro.getCell(b)).trim();
                if("盘点仓库".equals(value) || "盘点启动日期".equals(value) || "商品编号".equals(value) || "商品分类".equals(value)
                        || "商品条码".equals(value)  || "商品名称".equals(value)  || "商品单位".equals(value)  || "商品规格".equals(value)
                        || "盘点启动单编号".equals(value) || "实盘数量".equals(value) || "账盘数量".equals(value)){
                    index++;
                }
            }
            if(index == 10 || index == 11) {
                for (int i=1;i<=rowcount;i++) {          //这里用最原始的for循环来保证每行都会被读取
                    CommodityWhInvtryBillDtl dtl= new CommodityWhInvtryBillDtl();
                    Row row = sheet.getRow(i);
                    if(null!=row){
                        for (int j=0;j<cellcount;j++) {
                            if(j==1) dtl.setIvtCode(getCellValue(row.getCell(j)));
                            if(j==4) dtl.setComCode(getCellValue(row.getCell(j)));
                            if(j==5) dtl.setComClassName(getCellValue(row.getCell(j)));
                            if(j==6) dtl.setComBarcode(getCellValue(row.getCell(j)));
                            if(j==7) dtl.setComName(getCellValue(row.getCell(j)));
                            if(j==8) dtl.setComUnitName(getCellValue(row.getCell(j)));
                            if(j==9) dtl.setComSpec(getCellValue(row.getCell(j)));//这里也是用for循环，用Cell c:row这样的遍历，空单元格就被抛弃了*/
                            if(index == 11){
                                if(j==10)
                                    dtl.setPaperStock( !getCellValue(row.getCell(j)).equals("") ? BigDecimal.valueOf(Double.valueOf(getCellValue(row.getCell(j)))):BigDecimal.valueOf(0));
                                if(j==11)
                                    dtl.setRealStock( !getCellValue(row.getCell(j)).equals("") ? BigDecimal.valueOf(Double.valueOf(getCellValue(row.getCell(j)))):BigDecimal.valueOf(0));//这里也是用for循环，用Cell c:row这样的遍历，空单元格就被抛弃了*///这里也是用for循环，用Cell c:row这样的遍历，空单元格就被抛弃了*/
                            }else{
                                if(j==10)
                                    dtl.setRealStock( !getCellValue(row.getCell(j)).equals("") ? BigDecimal.valueOf(Double.valueOf(getCellValue(row.getCell(j)))):BigDecimal.valueOf(0));//这里也是用for循环，用Cell c:row这样的遍历，空单元格就被抛弃了*/
                            }
                        }
                        list.add(dtl);
                    }
                }
            }else{
                message="导入的模版格式不正确，请重新导入模版！";
            }
        }else{
              message="您导入的不是Excel文件，请选择正确的Excel文件！";
        }
        map.put("list",list);
        map.put("message",message);
        return  map;
    }
    //读取餐商合同excle文件
    public static   Map<String ,Object> readContractExclInfo(MultipartFile file,String[] heads){
        Map<String ,Object> map=new HashMap<>();
        String message="";
        List<Map>  list  = new ArrayList<>();
        Sheet sheet = getSheet(file);
        if(sheet != null){
            int rowcount = sheet.getLastRowNum();//逻辑行，包括空行
            int cellcount = sheet.getRow(0).getLastCellNum();//第一行（将来作为字段的行）有多少个单元格
            Row ro = sheet.getRow(0);
            Integer index=0;
            if(cellcount == heads.length){
                for (int b=0 ;b<cellcount;b++
                ) {
                    String value = getCellValue(ro.getCell(b)).trim();
                    if(value.equals(heads[b])) index ++;
                }
            }
            if(index == 17){
                for (int i=1;i<=rowcount;i++) {//这里用最原始的for循环来保证每行都会被读取
                    Row row = sheet.getRow(i);
                    if(null!=row){
                        Map<String,Object> info = new HashMap<>();
                        info.put("contractName",getCellValue(row.getCell(0)));
                        info.put("contractNumber",getCellValue(row.getCell(1)));
                        info.put("contractType",getCellValue(row.getCell(2)));
                        info.put("contractSellModel",getCellValue(row.getCell(3)));
                        info.put("contractNick",getCellValue(row.getCell(4)));
                        info.put("contractSupper",getCellValue(row.getCell(5)));
                        info.put("contractSignedby",getCellValue(row.getCell(6)));
                        info.put("contractSignedAddress",getCellValue(row.getCell(7)));
                        info.put("contractSignedTime",getCellValue(row.getCell(8)));
                        info.put("contractDoubleSignedby",getCellValue(row.getCell(9)));
                        info.put("contractStartTime",getCellValue(row.getCell(10)));
                        info.put("contractEndTime",getCellValue(row.getCell(11)));
                        info.put("contractManager",getCellValue(row.getCell(12)));
                        info.put("contractSeniorManager",getCellValue(row.getCell(13)));
                        info.put("contractGeneralManager",getCellValue(row.getCell(14)));
                        info.put("contractRemark",getCellValue(row.getCell(15)));
                        info.put("gonzeId",getCellValue(row.getCell(16)));
                        boolean flage = false;
                        for (Map.Entry<String,Object> item : info.entrySet()){
                            if(item.getValue() != null && String.valueOf(item.getValue()) != ""){
                                flage = true;
                            }
                        }
                        if(flage){
                            list.add(info);
                        }
                    }
                }
            }else{
                    message="导入的模版格式不正确，请重新导入模版！";
            }
        }else{
            message="您导入的不是Excel文件，请选择正确的Excel文件！";
        }
        map.put("message",message);
        map.put("list",list);
        return  map;
    }

    //读取税率调整单excle文件
    public static   Map<String ,Object> readPhTaxExclInfo(MultipartFile file,String[] heads,Integer modle){
        Map<String ,Object> map=new HashMap<>();
        String message="";
        List<Map>  list  = new ArrayList<>();
        Sheet sheet = getSheet(file);
        if(sheet != null){
            int rowcount = sheet.getLastRowNum();//逻辑行，包括空行
            int cellcount = sheet.getRow(0).getLastCellNum();//第一行（将来作为字段的行）有多少个单元格
            Row ro = sheet.getRow(0);
            Integer index=0;
            if(cellcount == heads.length){
                for (int b=0 ;b<cellcount;b++
                ) {
                    String value = getCellValue(ro.getCell(b)).trim();
                    if(value.equals(heads[b].trim())) index ++;
                }
            }
            if(index == 8){
                for (int i=1;i<=rowcount;i++) {//这里用最原始的for循环来保证每行都会被读取
                    Row row = sheet.getRow(i);
                    if(null!=row){
                        Map<String,Object> info = new HashMap<>();
                        if(modle == 20){
                            info.put("startDateStr",getCellValue(row.getCell(0)));
                            info.put("suppName",getCellValue(row.getCell(1)));
                            info.put("comName",getCellValue(row.getCell(2)));
                            info.put("comCode",getCellValue(row.getCell(3)));
                            info.put("saleCommUnitName",getCellValue(row.getCell(4)));
                            info.put("comSpec",getCellValue(row.getCell(5)));
                            info.put("oldPhTax",getCellValue(row.getCell(6)));
                            String phTax = getCellValue(row.getCell(7));
                            info.put("phTax", StringUtils.isNotEmpty(phTax) ? new Double(Double.valueOf(phTax)*100).intValue() + "%" : "");
                        }else {
                            info.put("startDateStr",getCellValue(row.getCell(0)));
                            info.put("suppName",getCellValue(row.getCell(1)));
                            info.put("rmName",getCellValue(row.getCell(2)));
                            info.put("rmCode",getCellValue(row.getCell(3)));
                            info.put("saleCommUnitName",getCellValue(row.getCell(4)));
                            info.put("sellModel",getCellValue(row.getCell(5)));
                            info.put("oldPhTax",getCellValue(row.getCell(6)));
                            String phTax = getCellValue(row.getCell(7));
                            info.put("phTax", StringUtils.isNotEmpty(phTax) ? new Double(Double.valueOf(phTax)*100).intValue() + "%" : "");
                        }
                        list.add(info);
                    }
                }
            }else{
                message="导入的模版格式不正确，请重新导入模版！";
            }
        }else{
            message="您导入的不是Excel文件，请选择正确的Excel文件！";
        }
        map.put("message",message);
        map.put("list",list);
        return  map;
    }



    /****
     * 读取导入的excel信息
     * @return
     */
    private static Sheet  getSheet(MultipartFile file){
        Sheet sheet=null;
        try {
            String fileName=file.getOriginalFilename();
            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")){
                wb = new HSSFWorkbook(file.getInputStream());
            }else if(extension.equals("xlsx")) {
                wb = new XSSFWorkbook(file.getInputStream());//创建工作薄
            }else{
                return  null;
            }
             sheet = wb.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sheet;
    }


    /**
     * 取单元格的值
     */
    private static String getCellValue(Cell c) {
        if (c == null) {
            return "";
        }
        String value = "";
        switch (c.getCellType()){
            case Cell.CELL_TYPE_NUMERIC://数字
                if(DateUtil.isCellDateFormatted(c)){
                    value =format.format(c.getDateCellValue());
                }else{
                    value = c.getNumericCellValue()+"";
                }
                break;
            case Cell.CELL_TYPE_STRING://字符串
                value = c.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN://boolean
                value = c.getBooleanCellValue()+"";
                break;
            case Cell.CELL_TYPE_FORMULA://公式
                value = c.getCellFormula()+"";
                break;
            default:
                value= "";
                break;
        }
        return value;
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

}
