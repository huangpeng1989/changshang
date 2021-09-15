package com.restaurant.controller.rawmater;


import com.alibaba.fastjson.JSON;

import com.changshang.feign.DataDictFeign;
import com.changshang.feign.SupplierServiceFeign;
import com.restaurant.service.rawmater.RawmaterApi;
import entity.ModelPagedList;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.vo.CateringTcbRowmaterialVo;
import modelpojo.vo.DishClasslVo;
import modelpojo.vo.RawmaterResponse;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dishbom.RawmaterVo;
import modelpojo.vo.saleadjust.RawmaterExeclVo;
import org.apache.commons.collections.CollectionUtils;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description 原材料controller层
 * @Author wenbin.wangß
 * @Date 2019-09-02 15:03
 */
@Controller
@RequestMapping("/rawmater")
public class RawmaterController extends AccountBaseConroller {

    private static final Logger log = LoggerFactory.getLogger(RawmaterController.class);
    @Reference
    DataDictFeign dataDictApi;
    @Autowired
    private RawmaterApi rawmaterApi;

    @Reference
    private SupplierServiceFeign supplierService;

    /**
     *@Description 查询最大原材料分类父类
     *@param
     *@return rawmaterClasseList
     *@date 2019-09-02 15:09
     *@auther wangwenbin
     */
    @RequestMapping("queryFRawmaterClass")
    @ResponseBody
    public ResponseInfo queryFRawmaterClass(){
        List<CateringTccRawmaterClass> rawmaterClasseList = null;
        try{
            rawmaterClasseList = rawmaterApi.queryFRawmaterClass(this.getOrgId());
        }catch (Exception e){
            log.error("查询最大父类接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success(rawmaterClasseList);
    }

    @RequestMapping("saveBasicDataLog")
    @ResponseBody
    public int saveBasicDataLog(Long projectId,Integer infoId, Integer dataType, Integer logType,  String Content,Long accId) {
        return  rawmaterApi.saveBasicDataLog(this.getOrgId(),infoId,dataType,logType,Content,this.getAccountId());
    }

        @RequestMapping("queryMaxRawmaterClass")
    @ResponseBody
    public ResponseInfo queryMaxRawmaterClass(){
        List<CateringTccRawmaterClass> rawmaterClasseList = null;
        try{
            rawmaterClasseList = rawmaterApi.queryMaxRawmaterClass(this.getOrgId());
        }catch (Exception e){
            log.error("查询最大父类接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success(rawmaterClasseList);
    }

    /**
     * 查询子类接口
     * @param urmcId
     * @param rmcCode
     * @return
     */
    @RequestMapping("getChildrenURmClassTwo")
    @ResponseBody
    public ResponseInfo getChildrenURmClassTwo(Integer urmcId, String rmcCode){
        List<CateringTccRawmaterClass> rawmaterClasseList = null;
        try{
            rawmaterClasseList = rawmaterApi.getChildrenURmClassTwo(urmcId,rmcCode,this.getOrgId());
        }catch (Exception e){
            log.error("查询字类接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success(rawmaterClasseList);
    }



    /**
     *@Description 查询原材料所有子类集合
     *@param urmcId
     *@return   rawmaterSClasseList
     *@date 2019-09-02 15:11
     *@auther wangwenbin
     */
    @RequestMapping("querySRawmaterClass")
    @ResponseBody
    public ResponseInfo querySRawmaterClass(Integer urmcId){
        List<CateringTccRawmaterClass> rawmaterSClasseList = null;
        try{
            rawmaterSClasseList = rawmaterApi.querySRawmaterClass(urmcId,this.getOrgId());
        }catch (Exception e){
            log.error(" 查询原材料所有子类集合接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterSClasseList);
    }


    /**
     *@Description 查询原材料分类树形结构
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("rawmaterClassTree")
    @ResponseBody
    public ResponseInfo rawmaterClassTree(){
        List<CateringTccRawmaterClass> rawmaterSClasseList = null;
        try{
            rawmaterSClasseList = rawmaterApi.rawmaterClassTree(this.getOrgId());
        }catch (Exception e){
            log.error(" 查询原材料分类树形结构接口异常");
            return  ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterSClasseList);
    }

    /**
     *@Description 新增/修改原材料分类
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("saveRawmaterClass")
    @ResponseBody
    public ResponseInfo saveRawmaterClass(CateringTccRawmaterClass rawmaterClass){
        try{
            rawmaterApi.saveRawmaterClass(rawmaterClass,this.getAccountId(),this.getOrgId(),this.getCompanyId());
        }catch (Exception e){
            log.error(" 新增/修改原材料分类接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("成功");
    }

    /**
     *@Description 删除原材料分类
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("deleteRawmaterClass")
    @ResponseBody
    public ResponseInfo deleteRawmaterClass(String rmcCode){
        try{
            rawmaterApi.deleteRawmaterClass(rmcCode,this.getOrgId());
        }catch (Exception e){
            log.error("删除原材料分类接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success("删除成功");
    }

    /**
     *@Description 导入原材料分类
     *@param
     *@return
     *@date 2019-09-15 16:00
     *@auther lixiang
     */
    @ResponseBody
    @RequestMapping("importRawmaterClass")
    public ResponseInfo importRawmaterClass (MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<DishClasslVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), DishClasslVo.class);
                rawmaterApi.importRawmaterClass(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId());
                return ResponseInfo.success(null);
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }

    }


    /**
     * 清除原材料分类税务编码
     */
    @RequestMapping(value = "/clearTaxCode")
    @ResponseBody
    public ResponseInfo clearTaxCode() {
        try {
            rawmaterApi.clearTaxCode(getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     *@Description 原材料列表
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("getRawmaterList")
    @ResponseBody
    public ResponseInfo getRawmaterList(RawmaterVo rowmaterial, Integer pageNo, Integer pageSize, String orderBy){
        ModelPagedList<RawmaterVo> rawmaterList = null;
        try{
            rawmaterList = rawmaterApi.getRawmaterList(rowmaterial, pageNo, pageSize, orderBy, this.getOrgId());
        }catch (Exception e){
            log.error("原材料列表接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterList);
    }

    /**
     *@Description  删除列表中的原材料数据
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("delRawmater")
    @ResponseBody
    public ResponseInfo delRawmater(Integer rmId){
        try{
            rawmaterApi.delRawmater(rmId,this.getAccountId(),this.getOrgId());
        }catch (Exception e){
            log.error(" 删除列表中的原材料数据接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success("删除原材料数据成功");
    }

    /**
     *@Description  查看原材料信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("getRawmaterInfo")
    @ResponseBody
    public ResponseInfo getRawmaterInfo(Integer rmId){
        CateringTcbRowmaterial rawmaterInfo  = null;
        try{
            rawmaterInfo = rawmaterApi.getRawmaterInfo(rmId, this.getOrgId(),this.getCompanyId());
        }catch (Exception e){
            log.error(" 查看原材料信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterInfo);
    }

    /**
     *@Description  修改原材料信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("updateRawmater")
    @ResponseBody
    public ResponseInfo updateRawmater(@RequestBody CateringTcbRowmaterial cateringTcbRowmaterial){
        try{
            rawmaterApi.updateRawmater(cateringTcbRowmaterial,this.getAccountId(),this.getOrgId(),this.getCompanyId());
            return ResponseInfo.success("修改原材料信息成功");
        }catch (Exception e){
            log.error(" 修改原材料信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
    }

    /**
     *@Description  保存原材料信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("saveRawmater")
    @ResponseBody
    public ResponseInfo saveRawmater(@RequestBody CateringTcbRowmaterial cateringTcbRowmaterial){
        try{
            rawmaterApi.saveRawmater(cateringTcbRowmaterial,this.getAccountId(),this.getOrgId(),this.getCompanyId());
        }catch (Exception e){
            log.error(" 添加原材料信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("添加原材料信息成功");
    }


    /**
     *@Description  （修改信息中）删除原材料包装信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("delSaleRowmater")
    @ResponseBody
    public ResponseInfo delSaleRowmater(Integer srmId){
        try{
            rawmaterApi.delSaleRowmater(srmId,this.getAccountId(),this.getOrgId());
        }catch (Exception e){
            log.error(" （修改信息中）删除原材料包装信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("删除原材料包装信息成功");
    }

    /**
     *@Description  （修改信息中）删除原材料供应商信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("delSuppRowmater")
    @ResponseBody
    public ResponseInfo delSuppRowmater(Integer supComId){
        try{
            rawmaterApi.delSuppRowmater(supComId,this.getAccountId(),this.getOrgId());
        }catch (Exception e){
            log.error("（修改信息中）删除原材料供应商信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("删除原材料供应商信息成功");
    }

    /**
     *@Description  查询原材料等级管理
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("getRawmaterGradDict")
    @ResponseBody
    public ResponseInfo getRawmaterGradDict(Integer rmGradeId){
        List<CatecommTssDatadictModel> rawmaterGradDictList= null;
        try{
            rawmaterGradDictList = rawmaterApi.getRawmaterGradDict(rmGradeId,this.getOrgId());
        }catch (Exception e){
            log.error("（查询原材料等级管理信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterGradDictList);
    }




    /**
     *@Description  原材料分类编号生成
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("getRawmaterClassCode")
    @ResponseBody
    public ResponseInfo getRawmaterClassCode(Integer urmcId){
        String rawmaterClassCode = "";
        try{
            rawmaterClassCode = rawmaterApi.getRawmaterClassCode(urmcId,this.getOrgId());
        }catch (Exception e){
            log.error("原材料分类编号生成信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterClassCode);
    }


    /**
     *@Description  审核（批量）原材料
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("toExamineRawmater")
    @ResponseBody
    public ResponseInfo toExamineRawmater(String rmId,Integer cStatus){
        try{
            rawmaterApi.toExamineRawmater(rmId,cStatus,this.getAccountId(),this.getOrgId());
        }catch (Exception e){
            log.error("原材料审核接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("审核成功");
    }


    /**
     *@Description  查询原材料分类信息
     *@param
     *@return
     *@date 2019-09-02 15:12
     *@auther wangwenbin
     */
    @RequestMapping("queryById")
    @ResponseBody
    public ResponseInfo queryById(Integer rmcId){
        CateringTccRawmaterClass rawmaterClass= null;
        try{
             rawmaterClass = rawmaterApi.queryById(rmcId,this.getOrgId());
        }catch (Exception e){
            log.error("查询原材料分类信息接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success(rawmaterClass);
    }

    /**
     * 效验原材料名称唯一性
     * @param rmName
     * @return
     */
    @RequestMapping("rmNameOnlyJudge")
    @ResponseBody
    public ResponseInfo rmNameOnlyJudge(String rmName){
        try{
            return ResponseInfo.success(rawmaterApi.rmNameOnlyJudge(rmName,this.getOrgId()));
        }catch (Exception e){
            log.error("效验原材料名称唯一性接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
    }


    /**
     * 效验原材料编号唯一性
     * @param rmCode
     * @return
     */
    @RequestMapping("rmCodeOnlyJudge")
    @ResponseBody
    public ResponseInfo rmCodeOnlyJudge(String rmCode){
        try{
            rawmaterApi.rmCodeOnlyJudge(rmCode,this.getOrgId());
        }catch (Exception e){
            log.error("效验原材料编号唯一性接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("success");
    }


    @RequestMapping("addOrUpdateRawmaterGradDict")
    @ResponseBody
    public ResponseInfo addOrUpdateRawmaterGradDict(CatecommTssDatadictModel catecommTssDatadictModel){
        try{
            rawmaterApi.addOrUpdateRawmaterGradDict(catecommTssDatadictModel,this.getOrgId(),this.getCompanyId());
        }catch (Exception e){
            log.error("添加原材料等级接口异常");
            return ResponseInfo.error("300",e.getMessage());

        }
        return ResponseInfo.success("添加原材料等级成功");
    }


    /**
     * 查询原材料包装是否被采购
     * @param sRmId
     */
    @RequestMapping("getWhinDataBySrmId")
    @ResponseBody
    public ResponseInfo getWhinDataBySrmId(Integer sRmId){
        List<CateringWhInDtl> whInDtlList = rawmaterApi.getWhinDataBySrmId(this.getOrgId(), sRmId);
        if (CollectionUtils.isNotEmpty(whInDtlList)) {
            return ResponseInfo.error("300","此原材料包装已被采购");
        }
        return ResponseInfo.success("未被采购,可编辑");
    }


    /**
     * @Title: getExcelTemplate
     * @Description: 生成Excel模板并导出
     * @param @param uuid
     * @param @param request
     * @param @param response
     * @param @return
     * @return Data
     * @throws
     */
    @RequestMapping("/getExcelTemplate")
    @ResponseBody
    public void getExcelTemplate(HttpServletRequest request, HttpServletResponse response){

        String fileName = "原材料导入模版.xlsx"; //模板名称
        String[] handers = {"*原材料分类","*原材料名称","*原材料简称","*原材料类型","*是否可售","预估售价","*原材料规格","*原材料单位", "*采购单位", "*包装含量",
                "*保质期","*原材料等级","*销项税税率","*合同编号",
                "*进项税税率", "*采购含税进价","最高库存","最低库存","生产厂家","原材料说明","备注"}; //列标题

        //下拉框数据
        List<String[]> downData = new ArrayList<String[]>();

        StringBuffer classReslutBuf = new StringBuffer();
        StringBuffer rmTypeResultBuf = new StringBuffer();
        StringBuffer rmUnitResultBuf = new StringBuffer();
        StringBuffer gradDictResultBuf = new StringBuffer();
        StringBuffer tsbTaxResultBuf = new StringBuffer();
        StringBuffer isCanSaleBuf = new StringBuffer();
        StringBuffer supplierBuf = new StringBuffer();
        StringBuffer rmPurUnitResultBuf = new StringBuffer(); //采购单位


        // 原材料分类数据（原材料分类编号--原材料分类名称）
        List<CateringTccRawmaterClass> allRawmaterClasses = rawmaterApi.listAllRawmaterClass(this.getOrgId()); // 最大父类
        for (CateringTccRawmaterClass f :allRawmaterClasses) {
            List<CateringTccRawmaterClass> sonRawmaterClasses = rawmaterApi.queryRawmaterClassByRmcId(f.getRmcId(),this.getOrgId());
            // 如果没有子级分类则显示在execl下拉框
            if (CollectionUtils.isEmpty(sonRawmaterClasses)) {
                CateringTccRawmaterClass rawmaterClass = rawmaterApi.getRawmaterClass(f.getRmcId(),"",this.getOrgId());
                classReslutBuf.append(rawmaterClass.getRmcCode() + "-" + rawmaterClass.getRmcName()).append(",");
            }
        }

        String s4 = classReslutBuf.toString();
        String[] classReslut = s4.split(",");

        // 原材料类型  （原材料属性名--原材料类型对应名称）//
        rmTypeResultBuf.append("specRmType-常温").append(",").append("specRmType2-冷冻").append(",").append("specRmType3-生鲜").append(",")
                .append("specRmType4-辅料");
        String s3 = rmTypeResultBuf.toString();
        String[] rmTypeResult = s3.split(",");

        // 是否可售
        isCanSaleBuf.append("是").append(",").append("否");
        String s5 = isCanSaleBuf.toString();
        String[] isCanSaleResult = s5.split(",");

        // 原材料单位 （字典表原材料单位编号--字典表原材料单位名称）
        List<CatecommTssPubdatadictModel> pubdatadictModelList = rawmaterApi.queryRmUnit(112);
        pubdatadictModelList.forEach(a->{
            rmUnitResultBuf.append(a.getTypeCode() +"-"+a.getTypeName()).append(",");
            rmPurUnitResultBuf.append(a.getTypeCode() +"-"+a.getTypeName()).append(",");
        });
        String s2 = rmUnitResultBuf.toString();
        String[] rmPurUnitResult = rmPurUnitResultBuf.toString().split(",");
        String[] rmUnitResult = s2.split(",");
        // 原材料等级  （字典表原材料等级编号--字典表原材料等级名称）
        List<CatecommTssDatadictModel> rawmaterGradDictList = rawmaterApi.getRawmaterGradDict(null,this.getOrgId());
        rawmaterGradDictList.forEach(a->{
            gradDictResultBuf.append(a.getDictTpCode() +"-"+a.getDictTpValue()).append(",");
        });
        String s1 = gradDictResultBuf.toString();
        String[] gradDictResult = s1.split(",");
        // 进项税税率  （税率表ID--税率表名称）
        List<CatecommTsbTax> tsbTaxList = rawmaterApi.getCatecommTsbTax(null,this.getOrgId());
        tsbTaxList.forEach(a->{
            tsbTaxResultBuf.append(a.getTaxId() +"-"+a.getTaxName()).append(",");
        });
        String s = tsbTaxResultBuf.toString();
        String[] tsbTaxResult = s.split(",");

        // 供应商名称 (供应商ID--供应商名称)
        List<CommodityTcbSupplierModel> commodityTcbSupplierModels = supplierService.selectSupplier(this.getOrgId());
        commodityTcbSupplierModels.forEach(a->{
            supplierBuf.append(a.getSuppId() + "-" + a.getSuppName()).append(",");
        });
        String s6 = supplierBuf.toString();
        String[] supplierResult = s6.split(",");

        downData.add(classReslut);
        downData.add(rmTypeResult);
        downData.add(isCanSaleResult);
        downData.add(rmUnitResult);   // 原材料单位
        downData.add(rmPurUnitResult);   // 原材料采购单位
        downData.add(gradDictResult);  // 原材料等级
        downData.add(tsbTaxResult);    //进项税税率
        downData.add(tsbTaxResult);   // 销项税税率
        //downData.add(supplierResult);
        String [] downRows = {"0","3","4","7","8","11","14","12"}; //下拉的列序号数组(序号从0开始)

        String name = "原材料模版";

        try {

            ExcelUtil.createExcelTemplate(fileName, handers, downData, downRows, name,request, response);

        } catch (Exception e) {
            System.out.println("异常捕获 "+e.getMessage());
            log.error("批量导入信息异常：" + e.getMessage());
        }
    }



    /**
     *@Description 预计导入原材料信息
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
                Excel<RawmaterExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".")+1), RawmaterExeclVo.class);
                if (CollectionUtils.isEmpty(excel.getErrorInfos())) {
                    return ResponseInfo.success(rawmaterApi.preImportRawmater(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId()));
                } else {
                    return ResponseInfo.error(ErrorCode.EXCEL_CONTENT_ERROR, JSON.toJSONString(excel.getErrorInfos()));
                }
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }
    }



    /**
     *@Description 预计导入原材料信息
     *@param
     *@return
     *@date 2019-09-09 09:00
     *@auther wangwenbin
     */
    @ResponseBody
    @RequestMapping("listImportRawmater")
    public ResponseInfo listImportRawmater(String redisKey,Integer pageNo,Integer pageSize,Integer type) {
        RawmaterResponse execlMessages = null;
        try{
            execlMessages = rawmaterApi.listImportRawmater(redisKey,pageNo, pageSize, type,this.getOrgId(),this.getCompanyId(),this.getAccountId());
        }catch (Exception e){
            log.error("原材料预导入列表接口异常");
            return ResponseInfo.error("300",e.getMessage());
        }
        return ResponseInfo.success(execlMessages);
    }



    /*****
     *
     * @param response
     */
    @RequestMapping("/exportRawmater")
    @ResponseBody
    public  void exportRawmater(HttpServletResponse response, HttpServletRequest request, String rmcCode,Integer rmcId,Integer urmcId,String urmcCode) {

        try {
            String loseCellName ="原材料编号,原材料名称,原材料一级分类,原材料二级分类,原材料三级分类,原材料简称,原材料类型,原材料可售状态,预估售价,原材料销售状态,原材料规格,原材料单位,保质期,"+
                    "产品等级,进项税税率,销项税税率,最高库存,最低库存,生产厂家,原材料说明,原材料包装编号,原材料包装含量,原材料包装单位,原材料条码,"+
                    "是否为缺省包装,原材料包装状态,是否为进退货包装,原材料包装信息-信息状态,供应商名称,含税进价,未税进价,含税包装价,未税包装价,预估含税成本价,送货类型,原材料供应商状态,是否为缺省供应商,原材料供应商信息-信息状态,主原材料-审核状态";

            String[] loseTitle = loseCellName.split(",");

            List<Object> info1 = new ArrayList<>();
            CatecommTssDatadictDto taxDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.tax_reserved_decimal.getName());
            CatecommTssDatadictDto notaxDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.notax_reserved_decimal.getName());
            CatecommTssDatadictDto numDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.num_reserved_decimal.getName());

            List<CateringTcbRowmaterialVo> rowmaterialList = rawmaterApi.exportRawmater(this.getOrgId(), rmcCode,rmcId,urmcId,urmcCode);
            for (CateringTcbRowmaterialVo rowmaterial:rowmaterialList) {
                StringBuffer specRmType = new StringBuffer();
                List<Object> info = new ArrayList<>();
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmCode()) ? rowmaterial.getRmCode() : "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmName()) ? rowmaterial.getRmName() : "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmClassNameOne()) ? rowmaterial.getRmClassNameOne() : "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmClassNameTwo()) ? rowmaterial.getRmClassNameTwo(): "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmClassNameThree()) ? rowmaterial.getRmClassNameThree() : "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmAbbreviate()) ? rowmaterial.getRmAbbreviate() : "");
                if (rowmaterial.getSpecRmType() == 1) {
                     specRmType.append("常温").append(" ");
                }if (rowmaterial.getSpecRmType2() == 1) {
                    specRmType.append("冷冻").append(" ");
                }if (rowmaterial.getSpecRmType3() == 1) {
                    specRmType.append("生鲜").append(" ");
                } if (rowmaterial.getSpecRmType4() == 1) {
                    specRmType.append("辅料").append(" ");
                }if (rowmaterial.getSpecRmType5() == 1) {
                    specRmType.append("特殊原材料类型5").append(" ");
                }if (rowmaterial.getSpecRmType6() == 1) {
                    specRmType.append("特殊原材料类型6").append(" ");
                }if (rowmaterial.getSpecRmType7() == 1) {
                    specRmType.append("特殊原材料类型7").append(" ");
                }if (rowmaterial.getSpecRmType8() == 1) {
                    specRmType.append("特殊原材料类型8");
                }
                info.add(specRmType);
                info.add(rowmaterial.getIsCanSale() == 1 ?"可售":"不可售");
                info.add((rowmaterial.getPredictPrice() != null && rowmaterial.getPredictPrice().compareTo(BigDecimal.ZERO) > 0) ? rowmaterial.getPredictPrice().setScale(Integer.valueOf(taxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO);
                info.add(StringUtils.isNotBlank(rowmaterial.getSaleStatusName()) ? rowmaterial.getSaleStatusName():"");
                info.add(StringUtils.isNotEmpty(rowmaterial.getSellModel()) ? rowmaterial.getSellModel() : "");
                info.add(StringUtils.isNotEmpty(rowmaterial.getRmUnitName()) ? rowmaterial.getRmUnitName() : "");
                info.add(rowmaterial.getExpirationDate() != null ? rowmaterial.getExpirationDate() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getRmGradeStr()) ? rowmaterial.getRmGradeStr() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getPhTaxName()) ? rowmaterial.getPhTaxName() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getSaleTaxName()) ? rowmaterial.getSaleTaxName() : "");
                info.add(rowmaterial.getMaxWhCount().intValue() != 0 ? rowmaterial.getMaxWhCount().setScale(Integer.valueOf(numDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP) : 0);
                info.add(rowmaterial.getMinWhCount().intValue() != 0 ? rowmaterial.getMinWhCount().setScale(Integer.valueOf(numDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP) : 0);
                info.add(StringUtils.isNotBlank(rowmaterial.getManufacturer()) ? rowmaterial.getManufacturer() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getDescription()) ? rowmaterial.getDescription() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getSrmCode()) ? rowmaterial.getSrmCode() : "");
                info.add(rowmaterial.getSrmPackContent().compareTo(BigDecimal.ZERO) > 0 ? rowmaterial.getSrmPackContent().setScale(Integer.valueOf(numDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP) : 0);
                info.add(StringUtils.isNotBlank(rowmaterial.getSrmUnitName()) ? rowmaterial.getSrmUnitName() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getRmBarcode()) ? rowmaterial.getRmBarcode() : "");
                info.add(rowmaterial.getIsdefault() == 1 ? "是":"否");
                info.add(rowmaterial.getSrmIsDetele() == 1 ? "淘汰":"正常");
                info.add(rowmaterial.getIsInOutSpec() == 1 ? "是":"否");
                info.add(StringUtils.isNotEmpty(rowmaterial.getSrmStatusName()) ? rowmaterial.getSrmStatusName() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getSuppName()) ? rowmaterial.getSuppName() : "");
                info.add(rowmaterial.getTaxPaid().compareTo(BigDecimal.ZERO) > 0 ? rowmaterial.getTaxPaid().setScale(Integer.valueOf(taxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP):0);
                info.add(rowmaterial.getNoTaxPaid().compareTo(BigDecimal.ZERO) > 0 ? rowmaterial.getNoTaxPaid().setScale(Integer.valueOf(notaxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP):0);
                info.add(rowmaterial.getTaxPaid().compareTo(BigDecimal.ZERO) > 0 && rowmaterial.getSrmPackContent().compareTo(BigDecimal.ZERO) > 0? rowmaterial.getTaxPaid().multiply(rowmaterial.getSrmPackContent()).setScale(Integer.valueOf(notaxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP):0);
                info.add(rowmaterial.getNoTaxPaid().compareTo(BigDecimal.ZERO) > 0 && rowmaterial.getSrmPackContent().compareTo(BigDecimal.ZERO) > 0? rowmaterial.getNoTaxPaid().multiply(rowmaterial.getSrmPackContent()).setScale(Integer.valueOf(notaxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP):0);
                info.add(rowmaterial.getFuTaxCost().compareTo(BigDecimal.ZERO) > 0 ? rowmaterial.getFuTaxCost().setScale(Integer.valueOf(taxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP):0);
                info.add(StringUtils.isNotBlank(rowmaterial.getDeliveryTypeName()) ? rowmaterial.getDeliveryTypeName() : "");
                info.add(rowmaterial.getSuppIsDelete() == 1 ? "淘汰":"正常");
                info.add(rowmaterial.getSuppIsdefault() == 1?"是":"否");
                info.add(StringUtils.isNotBlank(rowmaterial.getSupStatusName()) ? rowmaterial.getSupStatusName() : "");
                info.add(StringUtils.isNotBlank(rowmaterial.getStatusStr())? rowmaterial.getStatusStr():"");
                info1.add(info);
            }
            String accountName = rawmaterApi.getAccountName(this.getAccountId());
            String date = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();

            //文件名
            String fileName = "原材料基础信息_"+date+"_"+accountName+"" + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            Map<String,Object> map= new HashMap<>();
            map.put("title",loseTitle);
            map.put("list",info1);
            map.put("index",1);
            map.put("fileName",fileName);
            GatherUtilExcel gatherUtil=new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map,wb,request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询原材料供应商是否被采购
     * @param rmId
     * @param suppId
     * @return
     */
    @RequestMapping("getWhinDataBySupp")
    @ResponseBody
    public ResponseInfo getWhinDataBySupp(Long rmId,Long suppId){
        List<CateringWhInDtl> whInDtlList = rawmaterApi.getWhinDataBySupp(this.getOrgId(), rmId,suppId);
        if (CollectionUtils.isNotEmpty(whInDtlList)) {
            return ResponseInfo.error("300","此原材料包装已被采购");
        }
        return ResponseInfo.success("未被采购,可编辑");
    }


    //原材料反审
    @RequestMapping("rmIntrospection")
    @ResponseBody
    public ResponseInfo rmIntrospection(Long rmId){
        String result = rawmaterApi.isIntrospection(this.getOrgId(),rmId);
        if(result == null){
            Integer size = rawmaterApi.introspection(this.getOrgId(),rmId);
            if(size > 0){
                return new ResponseInfo(true, "100", "操作成功", true);
            }else{
                return new ResponseInfo(true, "100", "原材料反审失败！", false);
            }
        }else{
            return new ResponseInfo(true, "100", result, false);
        }
    }

}
