package com.goods.controller.adjust;

import com.goods.service.adjust.AdjustApi;
import entity.ModelPagedList;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.AccountBaseConroller;
import modelpojo.ErrorCode;
import modelpojo.GatherUtilExcel;
import modelpojo.ResponseInfo;
import modelpojo.model.CatecommTsbTax;
import modelpojo.model.CommAdjustDto;
import modelpojo.model.CommodityTcjAdjust;
import modelpojo.vo.CommoAdjustVo;
import modelpojo.vo.CommodityTcjAdjustVo;
import modelpojo.vo.commodityinfo.CommodityAdjustExeclVo;
import modelpojo.vo.dishbom.RawmaterVo;
import modelpojo.vo.saleadjust.CommodityVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description 进价调价
 * @Author wenbin.wang
 * @Date 2019-08-24 11:39
 */
@RestController
@RequestMapping("/adjust")
public class AdjustController extends AccountBaseConroller {

    private static final Logger log = LoggerFactory.getLogger(AdjustController.class);
    @Autowired
    AdjustApi adjustApi;

    private static Integer NUM = 1;

    /**
     *@Description 进价调价列表
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("/adjustList")
    @ResponseBody
    public ResponseInfo adjustList(CommodityTcjAdjust commodityTcjAdjust, String comName){
        Long projectId= this.getOrgId();
        ModelPagedList<CommodityTcjAdjust> commodityTcjAdjustModelPagedList = adjustApi.adjustList(commodityTcjAdjust, projectId, comName);
        return ResponseInfo.success(commodityTcjAdjustModelPagedList);
    }

    /**
     *@Description 查看调价单信息
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("getAdjustInfo")
    @ResponseBody
    public ResponseInfo getAdjustInfo(String adjCode){
        CommodityTcjAdjustVo adjustInfo = adjustApi.getAdjustInfo(adjCode, this.getOrgId(),this.getCompanyId());
        if (adjustInfo == null) {
            return ResponseInfo.error("数据不存在");
        }else{
            return ResponseInfo.success(adjustInfo);
        }

    }
  /**
     *@Description 删除调价单信息
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("delAdjust")
    @ResponseBody
    public ResponseInfo delAdjust(@RequestParam  Integer adjId){
        int i = adjustApi.delAdjust(adjId, this.getOrgId());
        if (i <= 0) {
            return ResponseInfo.error("删除调价单信息失败");
        }else{
            return ResponseInfo.success("删除调价单信息成功");
        }
    }

    /**
     *@Description 审核
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("toExamineAdjust")
    @ResponseBody
    public ResponseInfo toExamineAdjust(@RequestParam String adjId, Integer adjStatus){
        try{
            Long accountId = this.getAccountId();
            adjustApi.toExamineAdjust(adjId, adjStatus, this.getOrgId(), accountId);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success("审核成功");
    }


    /**
     *@Description 添加调价商品查询
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("selectCommodity")
    @ResponseBody
    public ResponseInfo selectCommodity(String suppCode, Integer comClassCode, String comKey, Integer suppId, Integer pageNo, Integer pageSize) {
        ModelPagedList<CommodityVo> list = adjustApi.selectCommodity(null, suppCode, comClassCode, comKey, this.getOrgId(), getCompanyId(), suppId, pageNo, pageSize);
        return ResponseInfo.success(list);
    }

    /**
     * 模板导出
     * @param rowmaterial
     * @param request
     * @param response
     * @param suppId
     */

    @RequestMapping("/getExcelComTemplate")
    @ResponseBody
    public void getExcelComTemplate(RawmaterVo rowmaterial, HttpServletRequest request, HttpServletResponse response, Integer suppId){
        String fileName = "商品进价调价导入模版.xlsx"; //模板名称
        String[] handers = {"*调价开始时间", "调价结束时间",  "*供应商编号", "*供应商名称", "*商品编号", "*商品名称", "商品规格", "商品单位", "原采购含税进价", "原含税进价", "*新采购含税进价"}; //列标题
        List<CommodityVo> list = adjustApi.selectCommodity(null, null, null, null, this.getOrgId(), getCompanyId(), suppId, 1, 10000).getData();

        try {
            List<Object> info1 = new ArrayList<>();
            if (null != list && list.size() > 0) {
                list.forEach(a -> {
                    List<Object> info = new ArrayList<>();
                    info.add("");
                    info.add("");
                    info.add(list.get(0).getSuppCode());
                    info.add(list.get(0).getSuppName());
                    info.add(a.getComCode());
                    info.add(a.getComName());
                    info.add(StringUtils.isNotEmpty(a.getComSpec()) ? a.getComSpec() : "-");
                    info.add(a.getCommUnitName());
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
            map.put("index", 1);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *@Description 导入进价调价商品信息
     *@param
     *@return
     *@date 2019-09-09 09:00
     *@auther wangwenbin
     */
    @ResponseBody
    @RequestMapping("importComm")
    public ResponseInfo importComm(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<CommodityAdjustExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), CommodityAdjustExeclVo.class);
                return ResponseInfo.success(adjustApi.importComm(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId()));
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }

    }

    /**
     *@Description 新增（编辑）进价调价
     *@param
     *@return
     *@date 2019-08-24 11:52
     *@auther wangwenbin
     */
    @RequestMapping("addAdjustToExamine")
    @ResponseBody
    public ResponseInfo addAdjustToExamine(@RequestBody  CommodityTcjAdjustVo commodityTcjAdjustVo) {
        int i = 0;
        try {
            i = adjustApi.addAdjustToExamine(commodityTcjAdjustVo,this.getAccountId(),getOrgId(),this.getCompanyId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseInfo.error("保存失败！原因：" + e.getMessage());
        }
        if (i <= 0) {
            return ResponseInfo.error("保存失败！");
        }else {
            return ResponseInfo.success("保存成功！");
        }
    }


    @RequestMapping("getTsbTaxInfo")
    @ResponseBody
    public  List<CatecommTsbTax> getTsbTaxInfo(Integer taxId,Integer status) {
        List<CatecommTsbTax>  catecommTsbTax = adjustApi.getTsbTaxInfo(taxId,status,getOrgId(),this.getCompanyId());
       return catecommTsbTax;
    }


    /**
     * 商品进价查询报表列表
     *
     */
    @RequestMapping(value = "/getCommdidtyAdjust")
    @ResponseBody
    public ResponseInfo getCommdidtyAdjust(int pageNo, int pageSize, String comName, String date, String suppName) {
        return ResponseInfo.success(adjustApi.getCommdidtyAdjust(pageNo, pageSize, comName, date, suppName, getOrgId()));
    }


    /**
     * 商品进价报表excel导出
     */
    @RequestMapping(value = "/excelOut")
    @ResponseBody
    public void excelOut(HttpServletResponse response, HttpServletRequest request, String comName, String date, String suppName) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String title[] = {"序号","供应商编号","供应商名称","商品编号","商品名称","含税进价","未税进价","价格生效开始时间","价格生效结束时间"};
            String fileName =  formatter.format(new Date()) + "_商品进价明细数据" + ".xls";
            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            ModelPagedList modelPagedList = adjustApi.getCommdidtyAdjust(1, 100000, comName, date, suppName, getOrgId());

            List<CommAdjustDto> lists = modelPagedList.getData();

            List<Object> list = new ArrayList<>();
            NUM = 1;
            lists.forEach(a -> {
                List<Object> info = new ArrayList<>();
                info.add(NUM++);//序号
                info.add(a.getSuppCode());
                info.add(a.getSuppName());
                info.add(a.getComCode());
                info.add(a.getComName());
                info.add(a.getNewTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewTaxPriceIn().setScale(2, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO);
                info.add(a.getNewUnTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewUnTaxPriceIn().setScale(4, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO);
                info.add(sdf.format(a.getStartDate()));
                info.add(null == a.getEndDate() ? "-" : sdf.format(a.getEndDate()));
                list.add(info);
            });
            Map<String, Object> map = new HashMap<>();
            map.put("index", "0");
            map.put("title", title);
            map.put("list", list);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量提交
     */
    @RequestMapping(value = "/adjustBatchCommit")
    @ResponseBody
    public ResponseInfo adjustBatchCommit(String adjIds) {
        try {
            adjustApi.adjustBatchCommit(adjIds, getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
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
     * 查询商品是否存在 新增、待审核、审核驳回、待生效状态下的税率调整单
     */
    @RequestMapping(value = "/getTaxCom")
    @ResponseBody
    public ResponseInfo getTaxCom(String comIds, Integer suppId) {
        return ResponseInfo.success(adjustApi.getTaxCom(getOrgId(), comIds, suppId));
    }


    /**
     * 商品进价调价execl 导出
     * @return
     */
    @RequestMapping("excelOutComAdjust")
    @ResponseBody
    public void excelOutComAdjust(String adjIds, Integer adjStatus, String adjCode, String comName, HttpServletResponse response, HttpServletRequest request) {
        try {
            String loseCellName = "调价单号,开始日期,结束日期,调价类型,状态,供应商编号,供应商名称,商品编号,商品名称,经营方式,单位,税率,原含税进价,原未税进价,原采购含税进价,原采购未税进价," +
                    "新含税进价,新未税进价,新采购含税进价,新采购未税进价";


            String[] title = loseCellName.split(",");

            List<Object> info1 = new ArrayList<>();

            //文件名
            String fileName = "商品进价价调价单" + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            List<CommoAdjustVo> cateringAdjustVos = adjustApi.excelOutComAdjust(this.getOrgId(), adjIds, adjStatus, adjCode, comName);
            cateringAdjustVos.forEach(a -> {
                List<Object> info = new ArrayList<>();
                info.add(a.getAdjCode());
                info.add(a.getStartDate());
                info.add(StringUtils.isNotEmpty(a.getEndDate()) ? a.getEndDate() : "-");
                info.add(a.getAdjType());
                info.add(a.getAdjStatus());
                info.add(a.getSuppCode());
                info.add(a.getSuppName());
                info.add(a.getComCode());
                info.add(a.getComName());
                info.add(a.getSellModelStr());
                info.add(StringUtils.isNotEmpty(a.getTaxValue()) ? a.getTaxValue() : "");
                info.add(a.getTaxName());
                info.add(a.getOTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getOTaxPriceIn() : BigDecimal.ZERO);
                info.add(a.getoUnTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getoUnTaxPriceIn() : BigDecimal.ZERO);
                info.add(a.getoPurchaseTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getoPurchaseTaxPaid() : BigDecimal.ZERO);
                info.add(a.getoPurchaseNoTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getoPurchaseNoTaxPaid() : BigDecimal.ZERO);
                info.add(a.getNewTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewTaxPriceIn() : BigDecimal.ZERO);
                info.add(a.getNewUnTaxPriceIn().compareTo(BigDecimal.ZERO) != 0 ? a.getNewUnTaxPriceIn() : BigDecimal.ZERO);
                info.add(a.getNewPurchaseTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getNewPurchaseTaxPaid() : BigDecimal.ZERO);
                info.add(a.getNewPurchaseNoTaxPaid().compareTo(BigDecimal.ZERO) != 0 ? a.getNewPurchaseNoTaxPaid() : BigDecimal.ZERO);
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
