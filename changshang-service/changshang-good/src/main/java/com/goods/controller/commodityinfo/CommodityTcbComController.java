package com.goods.controller.commodityinfo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.goods.service.commodityinfo.CommodityTcbComApi;
import entity.ModelPagedList;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.AccountBaseConroller;
import modelpojo.ErrorCode;
import modelpojo.ResponseInfo;
import modelpojo.model.account.AccountModel;
import modelpojo.vo.CommodityResponse;
import modelpojo.vo.CommodityTcbComExportDto;
import modelpojo.vo.CommodityTcbComVo;
import modelpojo.vo.CommodityTccComclassDto;
import modelpojo.vo.allotBill.ExportCommInfo;
import modelpojo.vo.commodityinfo.CommExeclVo;
import modelpojo.vo.commodityinfo.CommSuppExeclVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.apache.poi.hssf.usermodel.HSSFDataFormat.getBuiltinFormat;


@RestController
@RequestMapping("comm")
public class CommodityTcbComController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommodityTcbComApi commodityTcbComApi;

    //查询商品信息列表
    @RequestMapping("selectCommList")
    @ResponseBody
    public ResponseInfo selectCommList(CommodityTcbComVo commodityTcbComVo) {
//        getAccountId();//账号id
//        getCompanyId();//公司id

        try {
            ModelPagedList list = commodityTcbComApi.selectCommList(commodityTcbComVo, commodityTcbComVo.getPageNo(), commodityTcbComVo.getPageSize(), getCompanyId());

            return new ResponseInfo(true, "100", "操作成功", list);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseInfo(false, "300", "操作失败", e.getMessage());

        }


    }

    //查询商品信息列表
    @RequestMapping("deleteComm")
    @ResponseBody
    public ResponseInfo deleteComm(CommodityTcbComVo commodityTcbComVo) {

        try {
            commodityTcbComApi.deleteComm(commodityTcbComVo, getCompanyId());
            return new ResponseInfo(true, "100", "操作成功", "");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseInfo(false, "300", "操作失败", e.getMessage());

        }
    }

    //批量状态审核
    @RequestMapping("checkComm")
    @ResponseBody
    public ResponseInfo checkComm(String detailList) {
        try {
            List<CommodityTcbComVo> infoVo = JSON.parseObject(detailList,
                    new TypeReference<List<CommodityTcbComVo>>() {
                    });

            commodityTcbComApi.checkComm(infoVo, getCompanyId(), getAccountId());
            return new ResponseInfo(true, "100", "操作成功", "");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseInfo(false, "300", "操作失败", e.getMessage());
        }
    }

    @RequestMapping("/getExcelTemplate")
    @ResponseBody
    public void getExcelTemplate(HttpServletRequest request, HttpServletResponse response) {

        String fileName = "商品导入模版.xls"; //模板名称

        String[] handers = {"*商品分类", "*商品名称", "*商品简称", "*经营方式", "*商品类型", "*商品销售状态", "*商品规格",
                "*商品单位", "*采购单位", "*包装含量", "*保质期", "产品等级", "商品品牌", "*建议零售价", "*销项税税率", "*最高库存", "*最低库存", "生产厂家",
                "商品条码", "*合同编号", "联营扣率(%)", "*进项税税率", "*采购含税进价", "*价格等级", "*零售价", "商品说明", "是否押金","备注"}; //列标题

        //下拉框数据
        List<String[]> downData = new ArrayList<String[]>();

        StringBuffer type1 = new StringBuffer(); //商品分类
        StringBuffer type2 = new StringBuffer(); //经营方式
        StringBuffer type3 = new StringBuffer(); //商品类型
        StringBuffer type4 = new StringBuffer(); //商品销售状态
        StringBuffer type5 = new StringBuffer(); //商品单位
        StringBuffer type6 = new StringBuffer(); //产品等级
        StringBuffer type7 = new StringBuffer(); //进项税税率
        StringBuffer type8 = new StringBuffer(); //销项税税率
        //StringBuffer type9 = new StringBuffer(); //供应商编号
        StringBuffer type10 = new StringBuffer();//销售商品单位
        StringBuffer type11 = new StringBuffer();//价格等级

        StringBuffer type12 = new StringBuffer(); //采购单位


        //查询商品分类信息
        List<CommodityTccComclassDto> classList = commodityTcbComApi.selectComClass(getCompanyId());

        for (int i = 0; i < classList.size(); i++) {
            type1.append(classList.get(i).getComClassCode() + "-" + classList.get(i).getComClassName()).append(",");
        }
        String[] reslut1 = type1.toString().split(",");


        //经营方式
        List<CommodityTcbComExportDto> sellModelList = commodityTcbComApi.selectPubData(100, getCompanyId());

        for (int i = 0; i < sellModelList.size(); i++) {
            type2.append(sellModelList.get(i).getTypeCode() + "-" + sellModelList.get(i).getTypeName()).append(",");
        }
        String[] reslut2 = type2.toString().split(",");


        //商品类型
//        type3.append("comType-正常商品").append(",").append("comType2-大类商品").append(",").append("comType3-称重商品").append(",")
//                .append("comType4-原材料").append(",").append("comType5-赠品").append(",").append("comType6-办公用品")
//                .append(",").append("comType7-办公设备").append(",").append("comType8-类型8").append(",")
//                .append("comType9-类型9").append(",").append("comType10-类型10").append(",").append("comType11-类型11");

        type3.append("comType-正常商品").append(",").append("comType2-大类商品").append(",").append("comType3-称重商品").append(",")
                .append("comType4-赠品").append(",").append("comType5-服务类");
        String[] reslut3 = type3.toString().split(",");

        //销售状态
        List<CommodityTcbComExportDto> sellStatusList = commodityTcbComApi.selectPubData(102, getCompanyId());

        for (int i = 0; i < sellStatusList.size(); i++) {
            type4.append(sellStatusList.get(i).getTypeCode() + "-" + sellStatusList.get(i).getTypeName()).append(",");
        }
        String[] reslut4 = type4.toString().split(",");


        //商品单位
        List<CommodityTcbComExportDto> comUnitList = commodityTcbComApi.selectPubData(103, getCompanyId());

        for (int i = 0; i < comUnitList.size(); i++) {
            type5.append(comUnitList.get(i).getTypeCode() + "-" + comUnitList.get(i).getTypeName()).append(",");

            type12.append(comUnitList.get(i).getTypeCode() + "-" + comUnitList.get(i).getTypeName()).append(",");
        }
        String[] reslut5 = type5.toString().split(",");

        String[] reslut12 = type12.toString().split(",");

        //销售商品单位
        //  String[] reslut10 = reslut5;

        //产品等级
        List<CommodityTcbComExportDto> comGradeList = commodityTcbComApi.selectDataDict(101, getCompanyId());

        for (int i = 0; i < comGradeList.size(); i++) {
            type6.append(comGradeList.get(i).getDictTpCode() + "-" + comGradeList.get(i).getDictTpValue()).append(",");
        }
        String[] reslut6 = type6.toString().split(",");


        //进项税税率
        List<CommodityTcbComExportDto> phTaxList = commodityTcbComApi.selectTsbTax(getCompanyId());

        for (int i = 0; i < phTaxList.size(); i++) {
            type7.append(phTaxList.get(i).getTaxId() + "-" + phTaxList.get(i).getTaxName()).append(",");
        }
        String[] reslut7 = type7.toString().split(",");

        //销项税税率
        String[] reslut8 = reslut7;

        //查询供应商
//        List<CommodityTcbComExportDto> suppList = commodityTcbComApi.selectsupp(getCompanyId());
//
//        for (int i = 0; i < suppList.size(); i++) {
//            type9.append(suppList.get(i).getSuppId() + "-" + suppList.get(i).getSuppName()).append(",");
//        }
//        String[] reslut9 = type9.toString().split(",");

        //价格等级
        List<CommodityTcbComExportDto> priceGradeList = commodityTcbComApi.selectDataDict(100, getCompanyId());

        for (int i = 0; i < priceGradeList.size(); i++) {
            type11.append(priceGradeList.get(i).getDictTpCode() + "-" + priceGradeList.get(i).getDictTpValue()).append(",");
        }
        String[] reslut11 = type11.toString().split(",");

        downData.add(reslut1);
        downData.add(reslut2);
        downData.add(reslut3);
        downData.add(reslut4);
        downData.add(reslut5);
        downData.add(reslut6);
        downData.add(reslut7);
        downData.add(reslut8);
        //   downData.add(reslut10);
        //downData.add(reslut9);
        downData.add(reslut11);//与下列数组顺序对应
        downData.add(reslut12);//与下列数组顺序对应

        String[] downRows = {"0", "3", "4", "5", "7", "11", "21", "14", "23", "8"}; //下拉的列序号数组(序号从0开始)

        String name = "商品模版";

        try {

            ExcelUtil.createExcelTemplate(fileName, handers, downData, downRows, name, request, response);

        } catch (Exception e) {
            System.out.println("异常捕获 " + e.getMessage());
            log.error("批量导入信息异常：" + e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("importComm")
    public ResponseInfo importRawmater(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<CommExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), CommExeclVo.class);
                if (CollectionUtils.isEmpty(excel.getErrorInfos())) {
                    int i = commodityTcbComApi.importComm(excel, getCompanyId(), getAccountId());
                } else {
                    return ResponseInfo.error(ErrorCode.EXCEL_CONTENT_ERROR, JSON.toJSONString(excel.getErrorInfos()));
                }
                return ResponseInfo.success("成功导入");
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return new ResponseInfo(false, "300", e.getMessage(), e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }
    }


    @ResponseBody
    @RequestMapping("importPreComm")
    public ResponseInfo importPreComm(MultipartFile file ) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<CommExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), CommExeclVo.class);
                if (CollectionUtils.isEmpty(excel.getErrorInfos())) {
                    String  redisKey = commodityTcbComApi.importPreComm(excel, getCompanyId(), getAccountId());
                    return new ResponseInfo(true, "100", "操作成功", redisKey);
                } else {
                    return ResponseInfo.error(ErrorCode.EXCEL_CONTENT_ERROR, JSON.toJSONString(excel.getErrorInfos()));
                }
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return new ResponseInfo(false, "300", e.getMessage(), e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }
    }

    /**
     *@Description 预计导入商品信息
     *@param
     *@return
     *@date 2020-10-11 10:00
     *@auther LK
     */
    @ResponseBody
    @RequestMapping("listImportCom")
    public ResponseInfo listImportCom(String redisKey,Integer pageNo,Integer pageSize,Integer type) {
        CommodityResponse execlMessages = null;
        try{
            Long user = getAccountId();
            execlMessages = commodityTcbComApi.listImportCom(redisKey,pageNo, pageSize,type,user);
        }catch (Exception e){
            log.error("商品预导入列表接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success(execlMessages);
    }


    //商品基础信息导出
    @RequestMapping("exportCommOut")
    public void exportCommOut(CommodityTcbComVo info,HttpServletRequest request, HttpServletResponse response) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String dateStr = df.format(new Date());

        AccountModel accountModel = commodityTcbComApi.getAccountObj(getAccountId());
        String userName = accountModel.getNickName();
        String fileName = "商品基础信息_"+dateStr+"_"+userName+".xls";

        List<ExportCommInfo> result = commodityTcbComApi.exportCommOut(info, getCompanyId());
        //sheet名
        String sheetName = "商品基础信息";

        //创建HSSFWorkbook
        HSSFWorkbook wb = getHSSFWorkbook(sheetName, result, null);

        //输出Excel文件
        try {
            OutputStream output = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "utf-8"));
            //文件名这里可以改
            response.setContentType("application/msexcel");
            wb.write(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    /**
     * 导出Excel
     *
     * @return
     */
    public HSSFWorkbook getHSSFWorkbook(String sheetName, List<?> info, HSSFWorkbook workbook) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (workbook == null) {
            workbook = new HSSFWorkbook();
        }


        // 设置字体
        HSSFFont headfont = workbook.createFont();
        headfont.setFontName("黑体");
        headfont.setFontHeightInPoints((short) 22);// 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        // 另一个样式
        HSSFCellStyle headstyle = workbook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        headstyle.setLocked(true);
        headstyle.setWrapText(true);// 自动换行
        // 另一个字体样式
        HSSFFont columnHeadFont = workbook.createFont();
        columnHeadFont.setFontName("宋体");
        columnHeadFont.setFontHeightInPoints((short) 16);
        columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 列头的样式
        HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
        columnHeadStyle.setFont(columnHeadFont);
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        columnHeadStyle.setLocked(true);
        columnHeadStyle.setWrapText(true);

        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 10);
        // 普通单元格样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        style.setWrapText(true);

        // 另一个样式
        HSSFCellStyle centerstyle = workbook.createCellStyle();
        centerstyle.setDataFormat(getBuiltinFormat("0.00"));
        centerstyle.setFont(font);
        centerstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        centerstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        centerstyle.setWrapText(true);
        HSSFDataFormat df = workbook.createDataFormat(); // 此处设置数据格式
        centerstyle.setDataFormat(df.getBuiltinFormat("#,#0"));//数据格式只显示整数


        HSSFCellStyle leftstyle = workbook.createCellStyle();
        leftstyle.setFont(font);
        leftstyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居左
        leftstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        leftstyle.setWrapText(true);

        HSSFSheet sheet = workbook.createSheet();


        // 创建第一行
        HSSFRow row0 = sheet.createRow(0);
        // 设置行高
        row0.setHeight((short) 900);
        // 创建第一列
        HSSFCell cell0 = row0.createCell(0);
        cell0.setCellValue(new HSSFRichTextString(sheetName));
        cell0.setCellStyle(headstyle);

        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet.addMergedRegion(range);

        HSSFRow row1 = sheet.createRow(1);
        String[] title = {"商品编号", "商品名称", "商品一级分类", "商品二级分类", "商品三级分类", "商品简称", "经营方式", "联营扣率(%)", "商品类型",
                "商品销售状态", "商品规格", "商品单位", "保质期", "产品等级", "商品品牌", "建议零售价", "进项税税率", "销项税税率"
                , "最高库存", "最低库存", "生产厂家", "商家说明", "销售商品编号", "商品包装含量", "销售商品单位", "商品条码",
                "商品包装状态", "是否为缺省包装", "商品包装信息-信息状态", "供应商名称", "含税进价", "未税进价", "预估含税成本价", "送货类型", "商品供应商状态", "是否为缺省供应商", "商品供应商信息-信息状态","主商品-审核状态","是否押金"};
        String[] data = {"comCode", "comName", "firstCode", "twoCode", "threeCode", "comAbbreviate", "sellModelName", "discountRate", "comType",
                "sellStatusName", "comSpec", "comUnitName", "expirationDate", "comGradeName", "comBrand", "retailPrice"
                , "phTaxName", "slTaxName", "maxWhCount", "minWhCount", "manufacturer", "description", "saleComCode",
                "packContent", "saleUnitName", "comBarcode", "commStatusName", "isDefaultNameSale", "saleStatusStr", "suppName", "taxPaid", "noTaxPaid",
                "fuTaxCost", "deliveryTypeName", "suppStatusName", "isDefaultNameSupp", "suppStatusStr","statusStr","isDeposit"};

        for (int i = 0; i < title.length; i++) {
            // 第二行
            sheet.setColumnWidth(i, 6000); //设置每列的列宽
            row1.setHeight((short) 500);
            HSSFCell cell1 = row1.createCell(i);

            cell1.setCellType(Cell.CELL_TYPE_STRING);

            cell1.setCellValue(title[i]);
            cell1.setCellStyle(columnHeadStyle);
        }
        //第三行开始
        for (int i = 0; i < info.size(); i++) {

            row1 = sheet.createRow(2 + i);
            row1.setHeight((short) 500);

            for (int j = 0; j < data.length; j++) {

                //将内容按顺序赋给对应的列对象
                Class c = info.get(i).getClass();


                try {
                    for (Field field : c.getDeclaredFields()) {
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        // System.out.println(fieldName + "=======================================");
                        if (data[j].equals(fieldName)) {
                            String value = String.valueOf(field.get(info.get(i)) == null ? "" : field.get(info.get(i)));

                            if (Arrays.asList("discountRate","retailPrice", "taxPaid", "fuTaxCost").contains(fieldName)) {
                                if (!"".equals(value)) {
                                    BigDecimal bd = new BigDecimal(value);
                                    //2位，第二个变量是取舍方法(四舍五入)
                                    bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    value = "0.00".equals(bd.toString()) ? "0" : bd.toString();
                                }
                            } else if (Arrays.asList( "noTaxPaid").contains(fieldName)) {
                                if (!"".equals(value)) {
                                    BigDecimal bd = new BigDecimal(value);
                                    //4位
                                    bd = bd.setScale(4, BigDecimal.ROUND_HALF_UP);
                                    value = "0.0000".equals(bd.toString()) ? "0" : bd.toString();
                                }
                            } else if (Arrays.asList("maxWhCount", "minWhCount").contains(fieldName)) {
                                if (!"".equals(value)) {
                                    BigDecimal bd = new BigDecimal(value);
                                    //3位
                                    bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
                                    value = "0.000".equals(bd.toString()) ? "0" : bd.toString();
                                }
                            }else if(Arrays.asList( "isDeposit").contains(fieldName)){
                                if (StringUtils.isNotEmpty(value)) {
                                    value = Integer.valueOf(value) == 0 ? "否" : "是";
                                }
                            }
                            row1.createCell(j).setCellValue(value);
                            // System.out.println(fieldName + "=====================" + value);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return workbook;
    }

    /**
     * 导入商品供应商
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("importCommSupp")
    public ResponseInfo importCommSupp(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<CommSuppExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), CommSuppExeclVo.class);
                return ResponseInfo.success(commodityTcbComApi.importCommSupp(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId()));
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }

    }

}
