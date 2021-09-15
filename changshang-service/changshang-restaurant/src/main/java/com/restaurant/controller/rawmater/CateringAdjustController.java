package com.restaurant.controller.rawmater;

import com.restaurant.service.rawmater.CaterTcjAdjustApi;
import com.restaurant.service.rawmater.RawmaterApi;
import entity.ModelPagedList;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.AccountBaseConroller;
import modelpojo.ErrorCode;
import modelpojo.GatherUtilExcel;
import modelpojo.ResponseInfo;
import modelpojo.model.CateringTcbSuppRowmater;
import modelpojo.vo.CateringAdjustVo;
import modelpojo.vo.CateringTcbRowmaterialVo;
import modelpojo.vo.CateringTcjAdjustDetailVo;
import modelpojo.vo.CateringTcjAdjustVo;
import modelpojo.vo.caterAdjust.PriceChangeVo;
import modelpojo.vo.caterAdjust.RowmaterilVo;
import modelpojo.vo.dishbom.RawmaterVo;
import modelpojo.vo.saleadjust.CateringAdjusrExeclVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-11-22 10:44
 */
@RestController
@RequestMapping("/caterAdjust")
public class CateringAdjustController extends AccountBaseConroller {

    private static final Logger log = LoggerFactory.getLogger(CateringAdjustController.class);
    @Autowired
    CaterTcjAdjustApi adjustApi;

    @Autowired
    private RawmaterApi rawmaterApi;

    /**
     *@Description 原材料进价调价列表
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/caterAdjustList")
    @ResponseBody
    public ResponseInfo caterAdjustList(String adjCode, Integer adjStatus, Integer pageNo, Integer pageSize, String rmName){
        ModelPagedList<CateringTcjAdjustVo> commodityTcjAdjustModelPagedList = adjustApi.caterAdjustList(adjCode, adjStatus, this.getOrgId(), pageNo, pageSize, rmName);
        return ResponseInfo.success(commodityTcjAdjustModelPagedList);
    }

    /**
     *@Description 添加原材料进价调价
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/saveCaterAdjust")
    @ResponseBody
    public ResponseInfo saveCaterAdjust(@RequestBody CateringTcjAdjustVo cateringTcjAdjustVo){
        try{
            adjustApi.saveCaterAdjust(cateringTcjAdjustVo,this.getOrgId(),this.getCompanyId(),this.getAccountId());
            return ResponseInfo.success("保存成功");
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
    }


    /**
     * 批量提交
     */
    @RequestMapping(value = "/batchCommit")
    @ResponseBody
    public ResponseInfo batchCommit(String adjIds) {
        try {
            adjustApi.batchCommit(adjIds, getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }



    /**
     *@Description 修改原材料进价调价
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/upCaterAdjust")
    @ResponseBody
    public ResponseInfo upCaterAdjust(@RequestBody CateringTcjAdjustVo cateringTcjAdjustVo){
        try{
            adjustApi.upCaterAdjust(cateringTcjAdjustVo,this.getOrgId(),this.getCompanyId(),this.getAccountId());
            return ResponseInfo.success("修改成功");
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
    }


    /**
     *@Description 查询原材料进价调价信息
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/getCaterAdjustInfo")
    @ResponseBody
    public ResponseInfo getCaterAdjustInfo(Integer adjId){
        return ResponseInfo.success(adjustApi.getCaterAdjustInfo(adjId, this.getOrgId()));
    }


    /**
     *@Description 删除or审核原材料进价调价
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/delOrToExamieCaterAdjust")
    @ResponseBody
    public ResponseInfo delOrToExamieCaterAdjust(String adjId, Integer adjStatus, Integer delete){
        try{
            adjustApi.delOrToExamieCaterAdjust(this.getOrgId(),this.getCompanyId(),this.getAccountId(),adjId,adjStatus,delete);
            return ResponseInfo.success("操作成功");
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }

    }


    /**
     *@Description 查询可售原材料列表
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/getCanSaleRowmaterList")
    @ResponseBody
    public ResponseInfo getCanSaleRowmaterList(String suppKey, String rmClassCode, String rmKey, Integer suppId, Integer pageNo, Integer pageSize){
        ModelPagedList<CateringTcbRowmaterialVo> resultList = null;
        try{
            resultList = adjustApi.getCanSaleRowmaterList(suppKey, rmClassCode, rmKey, this.getOrgId(), suppId, pageNo, pageSize);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(resultList);
    }


    @RequestMapping("/getExcelTemplate")
    @ResponseBody
    public void getExcelTemplate(RawmaterVo rowmaterial, HttpServletRequest request, HttpServletResponse response, Integer suppId){
        String fileName = "原材料进价调价导入模版.xlsx"; //模板名称
        String[] handers = {"*调价开始时间", "调价结束时间", "*供应商编号", "*供应商名称", "*原材料编号", "*原材料名称", "原材料规格", "原材料单位", "原采购含税进价", "原含税进价", "*新采购含税进价"}; //列标题

        /*//下拉框数据
        List<String[]> downData = new ArrayList<String[]>();

        StringBuffer rawReslutBuf = new StringBuffer();
        StringBuffer suppResultBuf = new StringBuffer();


        // 原材料名称
        List<CateringTcbRowmaterial> rawmaterList = rawmaterApi.rawmaterList(this.getOrgId(), suppId);
        rawmaterList.forEach(a->{
            rawReslutBuf.append(a.getRmId()+"-"+a.getRmName()).append(",");
        });
        String s1 = rawReslutBuf.toString();
        String[] rawResult = s1.split(",");

        // 供应商名称 (供应商ID--供应商名称)
        List<CateringTcbSuppRowmater> suppRowmaterList = rawmaterApi.suppRowmaterList(this.getOrgId(), suppId);
        suppRowmaterList.forEach(a->{
            suppResultBuf.append(a.getSuppId() + "-" + a.getSuppName()).append(",");
        });
        String s2 = suppResultBuf.toString();
        String[] supplierResult = s2.split(",");

        downData.add(supplierResult);
        downData.add(rawResult);
        String [] downRows = {"2","3"}; //下拉的列序号数组(序号从0开始)

        String name = "原材料进价调价导入模版";

        try {

            ExcelUtil.createExcelTemplate(fileName, handers, downData, downRows, name,request, response);

        } catch (Exception e) {
            System.out.println("异常捕获 "+e.getMessage());
            log.error("批量导入信息异常：" + e.getMessage());
        }*/
        // 供应商名称 (供应商ID--供应商名称)
        List<CateringTcbSuppRowmater> suppRowmaterList = rawmaterApi.suppRowmaterList(this.getOrgId(), suppId);
        // 原材料名称
        List<RowmaterilVo> rawmaterList = rawmaterApi.rawmaterList(this.getOrgId(), suppId);


        try {

            List<Object> info1 = new ArrayList<>();
            if (null != rawmaterList && rawmaterList.size() > 0) {
                rawmaterList.forEach(a -> {
                    List<Object> info = new ArrayList<>();
                    info.add("");
                    info.add("");
                    info.add(suppRowmaterList.get(0).getSuppCode());
                    info.add(suppRowmaterList.get(0).getSuppName());
                    info.add(a.getRmCode());
                    info.add(a.getRmName());
                    info.add(StringUtils.isNotEmpty(a.getSellModel()) ? a.getSellModel() : "-");
                    info.add(a.getUnitName());
                    info.add(a.getPurchaseTaxPaid() != null && a.getPurchaseTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getPurchaseTaxPaid() : BigDecimal.ZERO);
                    info.add(a.getTaxPaid() != null && a.getTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxPaid() : BigDecimal.ZERO);
                    info.add("");
                    info1.add(info);
                });
            }


            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }

            Map<String, Object> map = new HashMap<>();
            map.put("title", handers);
            map.put("list", info1);
            map.put("index",1);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *@Description 导入原材料信息
     *@param
     *@return
     *@date 2019-09-09 09:00
     *@auther wangwenbin
     */
    @ResponseBody
    @RequestMapping("importRawmater")
    public ResponseInfo importRawmater(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<CateringAdjusrExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".")+1), CateringAdjusrExeclVo.class);
                return ResponseInfo.success(adjustApi.importRawmaterAdjust(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId()));
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }

    }








    /***原材料进价调价报表列表***/
    @RequestMapping("rawAdjustReportList")
    @ResponseBody
    public ResponseInfo rawAdjustReportList(String suppName, String rmKey, String startTime,String endTime,Integer pageNo,Integer pageSize){
        ModelPagedList<CateringTcjAdjustDetailVo> resultList = null;
        try{
            resultList = adjustApi.rawAdjustReportList(suppName,rmKey,startTime,endTime,this.getOrgId(),pageNo,pageSize);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(resultList);
    }


    /**
     * 原材料进价调价execl 导出
     * @return
     */
    @RequestMapping("exportRawAdjustReport")
    @ResponseBody
    public void exportRawAdjustReport(String suppName, String rmKey, String startTime,String endTime,HttpServletResponse response, HttpServletRequest request) {

        try {
            String loseCellName = "供应商编号,供应商名称,原材料编号,原材料名称,含税进价,未税进价,价格生效开始时间,价格生效结束时间";

            String[] title = loseCellName.split(",");

            List<Object> info1 = new ArrayList<>();

            //文件名
            String fileName = "餐饮原材料进价调价报表" + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            ModelPagedList<CateringTcjAdjustDetailVo> data = adjustApi.rawAdjustReportList(suppName, rmKey, startTime, endTime, this.getOrgId(), 1, 1000000);
            List<CateringTcjAdjustDetailVo> list = data.getData();
            for (int i = 0; i < list.size(); i++) {
                List<Object> info = new ArrayList<>();
                for (int j = 0; j < title.length; j++) {
                    String callName = title[j].trim();
                    switch (callName) {
                        case "供应商编号":
                            info.add(StringUtils.isNotEmpty(list.get(i).getSuppCode()) ? list.get(i).getSuppCode() : "");
                            break;
                        case "供应商名称":
                            info.add(StringUtils.isNotEmpty(list.get(i).getSuppName()) ? list.get(i).getSuppName() : "");
                            break;
                        case "原材料编号":
                            info.add(StringUtils.isNotEmpty(list.get(i).getRmCode()) ? list.get(i).getRmCode() : "");
                            break;
                        case "原材料名称":
                            info.add(StringUtils.isNotEmpty(list.get(i).getRmName()) ? list.get(i).getRmName() : "");
                            break;
                        case "含税进价":
                            info.add(list.get(i).getNewTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? list.get(i).getNewTaxPriceIn().setScale(2, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO);
                            break;
                        case "未税进价":
                            info.add(list.get(i).getNewUntaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? list.get(i).getNewUntaxPriceIn().setScale(4, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO);
                            break;
                        case "价格生效开始时间":
                            info.add(StringUtils.isNotEmpty(list.get(i).getStartDate()) ? list.get(i).getStartDate() : "");
                            break;
                        case "价格生效结束时间":
                            info.add(StringUtils.isNotEmpty(list.get(i).getEndDate()) ? list.get(i).getEndDate() : "永久");
                            break;
                    }
                }
                info1.add(info);
            }
                Map<String, Object> map = new HashMap<>();
                map.put("index", "0");
                map.put("title", title);
                map.put("list", info1);
                map.put("fileName", fileName);
                GatherUtilExcel gatherUtil = new GatherUtilExcel();
                gatherUtil.buildExcelDocument(map, wb, request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    /**
     * 反审操作
     */
    @RequestMapping(value = "/counterTrial")
    @ResponseBody
    public ResponseInfo counterTrial(Integer adjId) {
        try {
            adjustApi.counterTrial(adjId, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 查询原材料是否存在 新增、待审核、审核驳回、待生效状态下的税率调整单
     */
    @RequestMapping(value = "/getTaxRm")
    @ResponseBody
    public ResponseInfo getTaxRm(String rmIds, Integer suppId) {
        return ResponseInfo.success(adjustApi.getTaxRm(getOrgId(), rmIds, suppId));
    }

    @RequestMapping("/cllPriceChangeBack")
    @ResponseBody
    public PriceChangeVo cllPriceChangeBack(Integer moduleId, Integer changeType, String adjCode){
        return  adjustApi.cllPriceChangeBack(this.getOrgId(),moduleId,changeType,adjCode);
    }


    /**
     * 原材料进价调价execl 导出
     * @return
     */
    @RequestMapping("excelOutAdjust")
    @ResponseBody
    public void excelOutAdjust(String adjIds, Integer adjStatus, String adjCode, String rmName, HttpServletResponse response, HttpServletRequest request) {
        try {
            String loseCellName = "调价单号,开始日期,结束日期,调价类型,状态,供应商编号,供应商名称,原材料编号,原材料名称,单位,税率,原含税进价,原未税进价,原采购含税进价,原采购未税进价," +
                    "新含税进价,新未税进价,新采购含税进价,新采购未税进价";

            String[] title = loseCellName.split(",");

            List<Object> info1 = new ArrayList<>();

            //文件名
            String fileName = "餐饮原材料进价调价单" + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            List<CateringAdjustVo> cateringAdjustVos = adjustApi.excelOutAdjust(this.getOrgId(), adjIds, adjStatus, adjCode, rmName);
            cateringAdjustVos.forEach(a -> {
                List<Object> info = new ArrayList<>();
                for (int j = 0; j < title.length; j++) {
                    String callName = title[j].trim();
                    switch (callName) {
                        case "调价单号":
                            info.add(a.getAdjCode());
                            break;
                        case "开始日期":
                            info.add(a.getStartDate());
                            break;
                        case "结束日期":
                            info.add(StringUtils.isNotEmpty(a.getEndDate()) ? a.getEndDate() : "-");
                            break;
                        case "调价类型":
                            info.add(a.getAdjType());
                            break;
                        case "状态":
                            info.add(a.getAdjStatus());
                            break;
                        case "供应商编号":
                            info.add(a.getSuppCode());
                            break;
                        case "供应商名称":
                            info.add(a.getSuppName());
                            break;
                        case "原材料编号":
                            info.add(a.getRmCode());
                            break;
                        case "原材料名称":
                            info.add(a.getRmName());
                            break;
                        case "单位":
                            info.add(StringUtils.isNotEmpty(a.getTaxValue()) ? a.getTaxValue() : "");
                            break;
                        case "税率":
                            info.add(StringUtils.isNotEmpty(a.getTaxName()) ? a.getTaxName() : "");
                            break;
                        case "原含税进价":
                            info.add(a.getoTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getoTaxPriceIn() : BigDecimal.ZERO);
                            break;
                        case "原未税进价":
                            info.add(a.getoUntaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getoUntaxPriceIn() : BigDecimal.ZERO);
                            break;
                        case "原采购含税进价":
                            info.add(a.getoPurchaseTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getoPurchaseTaxPaid() : BigDecimal.ZERO);
                            break;
                        case "原采购未税进价":
                            info.add(a.getoPurchaseNoTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getoPurchaseNoTaxPaid() : BigDecimal.ZERO);
                            break;
                        case "新含税进价":
                            info.add(a.getNewTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewTaxPriceIn() : BigDecimal.ZERO);
                            break;
                        case "新未税进价":
                            info.add(a.getNewUntaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewUntaxPriceIn() : BigDecimal.ZERO);
                            break;
                        case "新采购含税进价":
                            info.add(a.getNewPurchaseTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getNewPurchaseTaxPaid() : BigDecimal.ZERO);
                            break;
                        case "新采购未税进价":
                            info.add(a.getNewPurchaseNoTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getNewPurchaseNoTaxPaid() : BigDecimal.ZERO);
                            break;
                    }
                }
                info1.add(info);
            });

            Map<String, Object> map = new HashMap<>();
            map.put("index", "0");
            map.put("title", title);
            map.put("list", info1);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
