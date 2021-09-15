package com.goods.controller.allocation;


import com.changshang.feign.DataDictFeign;
import com.changshang.feign.dish.DishFeign;
import com.goods.service.allocation.CollarUseService;
import entity.ModelPagedList;
import modelpojo.AccountBaseConroller;
import modelpojo.GatherUtilExcel;
import modelpojo.ResponseInfo;
import modelpojo.model.CommodityWhRcptRtnBillDtlModel;
import modelpojo.vo.CollarDetailedDto;
import modelpojo.vo.CollarStatisticsDto;
import modelpojo.vo.CollarUseDto;
import modelpojo.vo.CollarUseQuery;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 领用管理控制器
 *
 * @author lixiang
 * @Date 2019-09-17 10:18:50
 */
@Controller
@RequestMapping("/collarUse")
public class CollarUseController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CollarUseService collarUseService;

    @Reference
    DishFeign dishesService;

    private static Integer NUM = 1;

    @Autowired
    DataDictFeign dataDictApi;



    /**
     * 参数设置类型详情查询
     *
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    /**
     * 参数设置查询
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectDataList")
    @ResponseBody
    public ResponseInfo selectDataList(CatecommTssDatadictVo info , Integer pageNo, Integer pageSize ){
        return  dataDictApi.selectDataList(info,pageNo,pageSize);
    }



    /**
     * 领用/归还信息数据列表
     */
    @RequestMapping(value = "/getRcptRtnList")
    @ResponseBody
    public ResponseInfo getRcptRtnList(CollarUseDto query, int pageNo, int pageSize, String orderBy, String type) {
        query.setProjectId(getOrgId());
        query.setProjectRootId(getCompanyId());
        return ResponseInfo.success(collarUseService.getRcptRtnList(query, pageNo, pageSize, orderBy, type, getAccountId()));
    }


    /**
     * 获取条码
     * @param projectId 项目id
     * @param moduleId 10.商品；20.餐饮
     * @param primaryKey 商品主键id /原材料主键id/半成品id    没有 0
     * @param billType  字典   进销存单据类型type_code   没有 0
     * @param billId 进销存单据id    其他传0
     * @param resultType 生成条码的类型 1商品条码  /2原材料条码/3半成品条码 /4进销存单据条码/5.捆绑商品
     * @return
     */
    @RequestMapping(value = "/getBarCode")
    @ResponseBody
    public Map<String, Object> getBarCode(Long projectId, Integer moduleId, Integer primaryKey, Integer billType, Integer billId, Integer resultType){
        return  collarUseService.getBarCode(this.getOrgId(),moduleId,primaryKey,billType,billId,resultType);
    }

    /**
     * 删除领用/归还信息接口
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseInfo delete(Integer rcptBillId, String type) {
        try {
            collarUseService.delete(rcptBillId, getOrgId(), type);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     *领用/归还生成编号接口
     */
    @RequestMapping(value = "/getRcptBillCode")
    @ResponseBody
    public ResponseInfo getRcptBillCode(String type) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rcptBillCode", collarUseService.getRcptBillCode(getOrgId(), type));
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }

    /**
     *领用/归还信息单个/批量审核
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public ResponseInfo examine(String rcptBillIds, String type, String status) {
        try {
            collarUseService.examine(rcptBillIds, getAccountId(), getOrgId(), type, status);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 编辑领用/归还信息数据查询
     */
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public ResponseInfo selectById(Integer rcptBillId, String type) {
        return ResponseInfo.success(collarUseService.queryById(rcptBillId, getOrgId(), type));
    }


    /**
     * 新增/修改保存领用/归还信息
     */
    @RequestMapping(value = "/saveCollar")
    @ResponseBody
    public ResponseInfo saveCollar(@RequestBody CollarUseQuery query) {
        query.setProjectRootId(getCompanyId());
        query.setProjectId(getOrgId());
        try {
            collarUseService.saveCollar(query, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     *获取部门信息
     */
    @RequestMapping(value = "/getOrgInfo")
    @ResponseBody
    public ResponseInfo getOrgInfo(Integer pageNo, Integer pageSize, String orgName) {
        return ResponseInfo.success(collarUseService.getOrgInfo(pageNo, pageSize, orgName, getOrgId()));
    }


    /**
     *通过部门id查询用户
     */
    @RequestMapping(value = "/getAccount")
    @ResponseBody
    public ResponseInfo getAccount(Long orgId) {
        return ResponseInfo.success(collarUseService.getAccount(orgId));
    }



    /**
     * 查询仓库信息
     */
    @RequestMapping(value = "/queryWare")
    @ResponseBody
    public ResponseInfo queryWareByGzoneId(Integer typeCode, String wareName,Integer isPurchaseWh, Integer whClass,Integer ststus,Integer pageNo, Integer pageSize, Integer inventType,Integer jurisdictionType,Integer inventory) {
        return ResponseInfo.success(collarUseService.queryWare(typeCode, wareName, isPurchaseWh, whClass, ststus, getOrgId(), pageNo, pageSize, getAccountId(), inventType,jurisdictionType,inventory));
    }

    /**
     *仓库等级查询接口
     */
    @RequestMapping(value = "/getCompany")
    @ResponseBody
    public ResponseInfo getCompany() {
        return ResponseInfo.success(dishesService.getPeriod("仓库级别"));
    }


    /**
     *选择领用单下拉数据
     */
    @RequestMapping(value = "/getCollarUseList")
    @ResponseBody
    public ResponseInfo getCollarUseList() {
        return ResponseInfo.success(collarUseService.getCollarUseList(getOrgId(), getAccountId()));
    }

    /**
     * 添加领用商品列表接口
     * @param commClassCode
     * @param name
     * @param pageNo
     * @param pageSize
     * @param whId
     * @return
     */
    @RequestMapping(value = "/getSaleComm")
    @ResponseBody
    public ResponseInfo getSaleComm(String commClassCode, String name, Integer whId, Integer pageNo, Integer pageSize, String whStock) {
        return ResponseInfo.success(collarUseService.getSaleComm(commClassCode, name, pageNo, pageSize, getOrgId(), whId, whStock));
    }


    /**
     *@Description 生成领用/归还打印条形码
     *@return
     *@date 2019-09-10 16:20
     *@auther wangwenbin
     */
    @RequestMapping("createCollarUseBarCode")
    @ResponseBody
    public ResponseInfo createReportLossBarCode(String billBarcode) {
        String url = "";
        try{
            url = collarUseService.createReportLossBarCode(billBarcode);
        }catch (Exception e) {
            logger.error("生成领用/归还单打印条形码接口异常"+e.getMessage());
            return ResponseInfo.error(e.getMessage());
        }
        return ResponseInfo.success(url);
    }

    /**
     * 领用报表数据汇总
     */
    @RequestMapping(value = "/collarStatistics")
    @ResponseBody
    public ResponseInfo collarStatistics(CollarDetailedDto query, String type) {
        return ResponseInfo.success(collarUseService.collarStatistics(query, type));
    }

    /**
     * 领用报表数据明细
     */
    @RequestMapping(value = "/collarDetailed")
    @ResponseBody
    public ResponseInfo collarDetailed(CollarDetailedDto query, int pageNo, int pageSize) {
        return ResponseInfo.success(collarUseService.collarDetailed(query, pageNo, pageSize));
    }

    /**
     * 领用报表数据明细合计
     */
    @RequestMapping(value = "/collarDetailedSum")
    @ResponseBody
    public ResponseInfo collarDetailedSum(CollarDetailedDto query) {
        return ResponseInfo.success(collarUseService.collarDetailedSum(query));
    }

    private Integer getDictValue(Integer tyCode,List<CatecommTssDatadictDto> dictList){
        for(CatecommTssDatadictDto obj : dictList) {
            if (obj.getDictTpCode().equals(tyCode)) {
                return Integer.valueOf(obj.getDictTpValue());
            }
        }
        return 6;
    }

    /**
     * 领用/归还excel导出
     */
    @RequestMapping(value = "/excelOut")
    @ResponseBody
    public void excelOut(HttpServletResponse response, HttpServletRequest request, Integer rcptBillId, String type) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String estimate = "预估";

            String fileName = "";

            if ("rcpt".equals(type)) {
                fileName = formatter.format(new Date()) + "_商品领用明细数据" + ".xls";
            } else {
                fileName = formatter.format(new Date()) + "_商品归还明细数据" + ".xls";
            }
            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            CollarUseDto collarUseDto = collarUseService.queryById(rcptBillId, getOrgId(), type);

            BigDecimal rcptCountSum = BigDecimal.ZERO;
            BigDecimal rcptTaxcostPriceSum = new BigDecimal("0");
            BigDecimal rcptNotaxcostPriceSum = new BigDecimal("0");
            BigDecimal taxcostPriceSum = new BigDecimal("0");
            BigDecimal notaxcostPriceSum = new BigDecimal("0");
            BigDecimal taxCostAmountSum = new BigDecimal("0");
            BigDecimal notaxCostAmountSum = new BigDecimal("0");

            CatecommTssDatadictVo infoVo = new CatecommTssDatadictVo();
            infoVo.setDicType("140");
            List<CatecommTssDatadictDto> dictList = dataDictApi.selectDataDetailList(infoVo,1,100000,getOrgId()).getData();
            final int dict1 = getDictValue(14001,dictList);
            final int dict2 = getDictValue(14002,dictList);
            final int dict3 = getDictValue(14003,dictList);
            final int dict4 = getDictValue(14004,dictList);
            final int dict5 = getDictValue(14005,dictList);
            final int dict6 = getDictValue(14006,dictList);
            final int dict7 = getDictValue(14007,dictList);

            List<Object> list = new ArrayList<>();
            NUM = 1;
            for (CommodityWhRcptRtnBillDtlModel a: collarUseDto.getDetailModels()){
                List<Object> info = new ArrayList<>();
                info.add(NUM++);//序号
                info.add(collarUseDto.getRcptBillCode());//领用单编号
                info.add(StringUtils.isNotEmpty(collarUseDto.getWhName()) ? collarUseDto.getWhName() : "");//领用仓库
                info.add(sdf.format(collarUseDto.getRcptTime()));//领用日期
                info.add(StringUtils.isNotEmpty(collarUseDto.getRcptDept()) ? collarUseDto.getRcptDept() : "");//领用部门
                info.add(StringUtils.isNotEmpty(collarUseDto.getRcptEmp()) ? collarUseDto.getRcptEmp() : "");//领用人
                if (("rtn".equals(type))) {
                    info.add(sdf.format(collarUseDto.getRtnTime()));//归还日期
                }
                info.add(StringUtils.isNotEmpty(a.getComCode()) ? a.getComCode() : "");//商品编号
                info.add(StringUtils.isNotEmpty(a.getComName()) ? a.getComName() : "");//商品名称
                info.add(StringUtils.isNotEmpty(a.getTypeName()) ? a.getTypeName() : "");//商品单位
                info.add(StringUtils.isNotEmpty(a.getComSpec()) ? a.getComSpec() : "");//商品规格
                info.add("rcpt".equals(type) ? a.getRcptOutCount().setScale(3, BigDecimal.ROUND_HALF_UP) : a.getRcptInCount().setScale(dict5, BigDecimal.ROUND_HALF_UP));//领用/归还数量
                rcptCountSum = rcptCountSum.add("rcpt".equals(type) ? a.getRcptOutCount() : a.getRcptInCount());
                if ((null != collarUseDto.getRcptBlTime() && new Date().getTime() > collarUseDto.getRcptBlTime().getTime()) && (12603 == collarUseDto.getRcptStatus().intValue() || 12604 == collarUseDto.getRcptStatus().intValue()
                        || 12606 == collarUseDto.getRcptStatus().intValue())) {
                    estimate = "";
                    if (null != a.getTaxCostAmount()) {
                        info.add(a.getTaxCostAmount().compareTo(BigDecimal.ZERO) != 0  ? a.getTaxCostAmount().setScale(dict1, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估含税领用金额
                        rcptTaxcostPriceSum = rcptTaxcostPriceSum.add(a.getTaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxCostAmount() : BigDecimal.ZERO);
                    } else {
                        info.add("0.00");//预估含税领用金额
                    }
                    if (null != a.getNotaxCostAmount()) {
                        info.add(a.getNotaxCostAmount().compareTo(BigDecimal.ZERO) != 0  ? a.getNotaxCostAmount().setScale(dict2, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估未税领用金额
                        rcptNotaxcostPriceSum = rcptNotaxcostPriceSum.add(a.getNotaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxCostAmount() : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估未税领用金额
                    }
                    if (null != a.getTaxCost()) {
                        info.add(a.getTaxCost().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxCost().setScale(dict1, BigDecimal.ROUND_HALF_UP) : "0.00");//预估含税成本
                        taxcostPriceSum = taxcostPriceSum.add(a.getTaxCost().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxCost() : BigDecimal.ZERO);
                    } else {
                        info.add("0.00");//预估含税成本
                    }
                    if (null != a.getNotaxCost()) {
                        info.add(a.getNotaxCost().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxCost().setScale(dict2, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估未税成本
                        notaxcostPriceSum = notaxcostPriceSum.add(a.getNotaxCost().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxCost() : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估未税成本
                    }

                } else {
                    estimate = "预估";
                    if (null != a.getTaxcostPrice()) {
                        info.add(a.getTaxcostPrice().compareTo(BigDecimal.ZERO) != 0  ? a.getTaxcostPrice().multiply(a.getRcptOutCount()).setScale(dict1, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估含税领用金额
                        rcptTaxcostPriceSum = rcptTaxcostPriceSum.add(a.getTaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxcostPrice().multiply(a.getRcptOutCount()) : BigDecimal.ZERO);
                    } else {
                        info.add("0.00");//预估含税领用金额
                    }
                    if (null != a.getNotaxcostPrice()) {
                        info.add(a.getNotaxcostPrice().compareTo(BigDecimal.ZERO) != 0  ? a.getNotaxcostPrice().multiply(a.getRcptOutCount()).setScale(dict2, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估未税领用金额
                        rcptNotaxcostPriceSum = rcptNotaxcostPriceSum.add(a.getNotaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxcostPrice().multiply(a.getRcptOutCount()) : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估未税领用金额
                    }
                    if (null != a.getTaxcostPrice()) {
                        info.add(a.getTaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxcostPrice().setScale(dict1, BigDecimal.ROUND_HALF_UP) : "0.00");//预估含税成本
                        taxcostPriceSum = taxcostPriceSum.add(a.getTaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getTaxcostPrice() : BigDecimal.ZERO);
                    } else {
                        info.add("0.00");//预估含税成本
                    }
                    if (null != a.getNotaxcostPrice()) {
                        info.add(a.getNotaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxcostPrice().setScale(dict2, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估未税成本
                        notaxcostPriceSum = notaxcostPriceSum.add(a.getNotaxcostPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getNotaxcostPrice() : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估未税成本
                    }
                }

                if (StringUtils.isNotEmpty(collarUseDto.getRtnBillCode())) {
                    if (null != a.getInTaxCostAmount()) {
                        info.add(a.getInTaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getInTaxCostAmount().setScale(dict1, BigDecimal.ROUND_HALF_UP) : "0.00");///预估含税未税金额
                        taxCostAmountSum = taxCostAmountSum.add(a.getInTaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getInTaxCostAmount() : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估含税未税金额
                    }

                    if (null != a.getInNotaxCostAmount()) {
                        info.add(a.getInNotaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getInNotaxCostAmount().setScale(dict2, BigDecimal.ROUND_HALF_UP) : "0.0000");//预估未税未税金额
                        notaxCostAmountSum = notaxCostAmountSum.add(a.getInNotaxCostAmount().compareTo(BigDecimal.ZERO) != 0 ? a.getInNotaxCostAmount() : BigDecimal.ZERO);
                    } else {
                        info.add("0.0000");//预估未税未税金额
                    }

                } else {
                    info.add("0.00");//预估含税归还金额
                    info.add("0.0000");//预估未税归还金额

                }

                list.add(info);
            }
            List<Object> infoTotal = new ArrayList<>();
            String title[] = {"序号","领用单编号","领用仓库","领用日期","领用部门","领用人","商品编号","商品名称","商品单位","商品规格","领用数量",
                    estimate +"含税领用金额", estimate +"未税领用金额", estimate +"含税成本", estimate + "未税成本", estimate +"含税归还金额", estimate + "未税归还金额"};
            String rtnTitle[] = {"序号","领用单编号","领用仓库","领用日期","领用部门","领用人","归还日期","商品编号","商品名称","商品单位","商品规格","归还数量",
                    estimate +"含税领用金额", estimate +"未税领用金额", estimate +"含税成本", estimate + "未税成本", estimate +"含税归还金额", estimate + "未税归还金额"};
            for (int i = 0; i < rtnTitle.length; i++) {
                if ("rtn".equals(type)) {
                    if (i < 11) {
                        infoTotal.add("");
                    }
                    else if (i == 11) infoTotal.add(rcptCountSum.setScale(dict6, BigDecimal.ROUND_HALF_UP));
                    else if (i == 12) infoTotal.add(rcptTaxcostPriceSum.setScale(dict3, BigDecimal.ROUND_HALF_UP));
                    else if (i == 13) infoTotal.add(rcptNotaxcostPriceSum.setScale(dict4, BigDecimal.ROUND_HALF_UP));
                    else if (i == 14) infoTotal.add("");
                    else if (i == 15) infoTotal.add("");
                    else if (i == 16) infoTotal.add(taxCostAmountSum.setScale(dict3, BigDecimal.ROUND_HALF_UP));
                    else if (i == 17) infoTotal.add(notaxCostAmountSum.setScale(dict4, BigDecimal.ROUND_HALF_UP));
                } else {
                    if (i < 10) {
                        infoTotal.add("");
                    }
                    else if (i == 10) infoTotal.add(rcptCountSum.setScale(dict6, BigDecimal.ROUND_HALF_UP));
                    else if (i == 11) infoTotal.add(rcptTaxcostPriceSum.setScale(dict3, BigDecimal.ROUND_HALF_UP));
                    else if (i == 12) infoTotal.add(rcptNotaxcostPriceSum.setScale(dict4, BigDecimal.ROUND_HALF_UP));
                    else if (i == 13) infoTotal.add("");
                    else if (i == 14) infoTotal.add("");
                    else if (i == 15) infoTotal.add(taxCostAmountSum.setScale(dict3, BigDecimal.ROUND_HALF_UP));
                    else if (i == 16) infoTotal.add(notaxCostAmountSum.setScale(dict4, BigDecimal.ROUND_HALF_UP));
                }

            }
            list.add(infoTotal);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "rtn".equals(type) ? rtnTitle :title);
            map.put("list", list);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*****
     *
     * @param response
     */
    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response, HttpServletRequest request, String type, String cellName, CollarDetailedDto query, int pageNo, int pageSize, Integer index) {

        try {
            String[] title = cellName.trim().split(",");
            //文件名

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fileName = "";
            if (index == 1) {
                fileName = "商品领用明细数据报表" + ".xls";
            } else {
                fileName = "商品领用汇总数据报表" + ".xls";
            }

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            List<Object> info1 = new ArrayList<>();

            CatecommTssDatadictVo infoVo = new CatecommTssDatadictVo();
            infoVo.setDicType("140");
            List<CatecommTssDatadictDto> dictList = dataDictApi.selectDataDetailList(infoVo,1,100000,getOrgId()).getData();
            final int dict1 = getDictValue(14001,dictList);
            final int dict2 = getDictValue(14002,dictList);
            final int dict3 = getDictValue(14003,dictList);
            final int dict4 = getDictValue(14004,dictList);
            final int dict5 = getDictValue(14005,dictList);
            final int dict6 = getDictValue(14006,dictList);
            final int dict7 = getDictValue(14007,dictList);

            if (index == 1) {
                ModelPagedList<CollarDetailedDto> pagedList  = collarUseService.collarDetailed(query,  pageNo,  pageSize);
                CollarDetailedDto collarDetailedDto = collarUseService.collarDetailedSum(query);
                List<CollarDetailedDto> list = pagedList.getData();
                for (int i = 0; i < list.size(); i++ ) {
                    List<Object> info = new ArrayList<>();
                    for (int j = 0; j < title.length; j++) {
                        String callName = title[j].trim();
                        switch (callName) {
                            case "景区名称":
                                info.add(StringUtils.isNotEmpty(list.get(i).getOrgName()) ? list.get(i).getOrgName() : "");
                                break;
                            case "仓库名称":
                                info.add(StringUtils.isNotEmpty(list.get(i).getWhName()) ? list.get(i).getWhName() : "");
                                break;
                            case "领用部门":
                                info.add(StringUtils.isNotEmpty(list.get(i).getRcptDept()) ? list.get(i).getRcptDept() : "");
                                break;
                            case "领用人":
                                info.add(StringUtils.isNotEmpty(list.get(i).getRcptEmp()) ? list.get(i).getRcptEmp() : "");
                                break;
                            case "集团名称":
//                                info.add(StringUtils.isNotEmpty(list.get(i).getGroupName()) ? list.get(i).getGroupName() : "");
//                                break;
//                            case "公司名称":
//                                info.add(StringUtils.isNotEmpty(list.get(i).getCompanyName()) ? list.get(i).getCompanyName() : "");
//                                break;
                            case "仓库编号":
                                info.add(StringUtils.isNotEmpty(list.get(i).getWhCode()) ? list.get(i).getWhCode() : "");
                                break;
                            case "领用日期":
                                info.add(list.get(i).getRcptTime() != null ? sdf.format(list.get(i).getRcptTime())  : "");
                                break;
                            case "领用单号":
                                info.add(StringUtils.isNotEmpty(list.get(i).getRcptBillCode()) ? list.get(i).getRcptBillCode() : "");
                                break;
                            case "商品名称":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComName()) ? list.get(i).getComName() : "");
                                break;
                            case "商品编号":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComCode()) ? list.get(i).getComCode() : "");
                                break;
                            case "一级分类":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComCodeNameOne()) ? list.get(i).getComCodeNameOne(): "");
                                break;
                            case "二级分类":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComCodeNameSend()) ? list.get(i).getComCodeNameSend(): "");
                                break;
                            case "三级分类":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComCodeNameThree()) ? list.get(i).getComCodeNameThree(): "");
                                break;
                            case "规格":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComSpec()) ? list.get(i).getComSpec() : "");
                                break;
                            case "单位":
                                info.add(StringUtils.isNotEmpty(list.get(i).getComUnitName()) ? list.get(i).getComUnitName() : "");
                                break;
                            case "领用数量":
                                info.add(list.get(i).getRcptOutCount().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getRcptOutCount().setScale(dict5,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "未税成本金额":
                                info.add(list.get(i).getNotaxCostAmount().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getNotaxCostAmount().setScale(dict2,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "含税成本金额":
                                info.add( list.get(i).getTaxCostAmount().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getTaxCostAmount().setScale(dict1,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "进项税税率":
                                info.add(StringUtils.isNotEmpty(list.get(i).getTaxName()) ? list.get(i).getTaxName() : "");
                                break;
                            case "含税成本价":
                                info.add(list.get(i).getTaxCost().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getTaxCost().setScale(dict1,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "未税成本价":
                                info.add(list.get(i).getNotaxCost().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getNotaxCost().setScale(dict2,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                        }
                    }
                    info1.add(info);
                }
                //合计
                List<Object> infoTotal = new ArrayList<>();
                for (int i = 0; i < title.length; i++) {
                    if(title[i].equals("领用数量")){
                        infoTotal.add(collarDetailedDto.getRcptOutCount().compareTo(BigDecimal.ZERO) > 0 ? collarDetailedDto.getRcptOutCount().setScale(dict6, BigDecimal.ROUND_HALF_UP) : 0);
                    } else if (title[i].equals("含税成本金额")) {
                        infoTotal.add(collarDetailedDto.getTaxCostAmount().compareTo(BigDecimal.ZERO) > 0 ? collarDetailedDto.getTaxCostAmount().setScale(dict3,BigDecimal.ROUND_HALF_UP) : 0);
                    } else if (title[i].equals("未税成本金额")) {
                        infoTotal.add(collarDetailedDto.getNotaxCostAmount().compareTo(BigDecimal.ZERO) > 0 ? collarDetailedDto.getNotaxCostAmount().setScale(dict4, BigDecimal.ROUND_HALF_UP) : 0);
                    } else {
                        infoTotal.add("");
                    }
                }
                info1.add(infoTotal);
            } else {
                List<CollarStatisticsDto> list = collarUseService.collarStatistics(query,type);
                for (int i = 0; i < list.size(); i++) {
                    List<Object> info = new ArrayList<>();
                    for (int j = 0; j < title.length; j++) {
                        String callName = title[j].trim();
                        switch (callName) {
                            case "领用人":
                                info.add(StringUtils.isNotEmpty(list.get(i).getRcptEmp()) ? list.get(i).getRcptEmp() : "");
                                break;
                            case "领用部门":
                                info.add(StringUtils.isNotEmpty(list.get(i).getRcptDept()) ? list.get(i).getRcptDept() : "");
                                break;
                            case "领用数量":
                                info.add(list.get(i).getRcptOutCount().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getRcptOutCount().setScale(dict5,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "领用含税成本价总计":
                                info.add(list.get(i).getTaxCost().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getTaxCost().setScale(dict3,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                            case "领用含税成本金额":
                                info.add(list.get(i).getTaxCostAmount().compareTo(BigDecimal.ZERO) > 0 ? list.get(i).getTaxCostAmount().setScale(dict1,BigDecimal.ROUND_HALF_UP) : 0);
                                break;
                        }
                    }
                    info1.add(info);
                }
            }
            Map<String,Object> map= new HashMap<>();
            map.put("title",title);
            map.put("list",info1);
            map.put("fileName",fileName);
            GatherUtilExcel gatherUtil=new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map,wb,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * 批量提交领用单/归还单
     */
    @RequestMapping(value = "/batchCommit")
    @ResponseBody
    public ResponseInfo batchCommit(String rcptBillIds, String type) {
        try {
            collarUseService.batchCommit(rcptBillIds, getOrgId(), type);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

}
