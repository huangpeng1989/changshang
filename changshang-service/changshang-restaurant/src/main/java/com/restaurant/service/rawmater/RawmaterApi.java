package com.restaurant.service.rawmater;


import entity.ModelPagedList;
import excel.Excel;
import modelpojo.model.*;
import modelpojo.vo.CateringTcbRowmaterialVo;
import modelpojo.vo.DishClasslVo;
import modelpojo.vo.RawmaterExeclMessage;
import modelpojo.vo.RawmaterResponse;
import modelpojo.vo.caterAdjust.RowmaterilVo;
import modelpojo.vo.dishbom.RawmaterVo;
import modelpojo.vo.saleadjust.RawmaterExeclVo;

import java.util.List;

/**
 * @Description 原材料
 * @Author wenbin.wang
 * @Date 2019-08-29 15:18
 */
public interface RawmaterApi {


    /**
     * 查询原材料最大父类
     */
    List<CateringTccRawmaterClass> queryFRawmaterClass(Long projectId);


    List<CateringTccRawmaterClass> queryMaxRawmaterClass(Long projectId);


    List<CateringTccRawmaterClass> getChildrenURmClassTwo(Integer urmClassId, String rmcCode,Long projectId);

    /**
     * 查询原材料所有子类集合
     */
    List<CateringTccRawmaterClass> querySRawmaterClass(Integer urmcId,Long projectId);


    /**
     * 根据id查询
     * @param rmcId
     * @return
     */
    CateringTccRawmaterClass queryById(Integer rmcId,Long projectId);


    /**
     * 原材料分类树形结构
     * @param projectId
     * @return
     */
    List<CateringTccRawmaterClass> rawmaterClassTree(Long projectId);

    /**
     * 新增/修改原材料分类
     * @param rawmaterClass
     */
    void saveRawmaterClass(CateringTccRawmaterClass rawmaterClass, Long accountId,Long projectId,Long projectRootId);

    /**
     * 删除原材料分类
     * @param rmcCode
     */
    void deleteRawmaterClass(String rmcCode,Long projectId);


    /**
     * 原材料分类信息导入
     * @param excel
     * @param projectId
     * @param projectRootId
     * @param accountId
     * @return
     */
    void importRawmaterClass(Excel<DishClasslVo> excel, Long projectId, Long projectRootId, Long accountId);

    /**
     * 清除原材料分类税务编码
     * @param projectId
     */
    void clearTaxCode(Long projectId);

    /**
     * 原材料列表
     * @param rowmaterial
     * @param pageNo
     * @param pageSize
     * @param orderBy
     * @return
     */
    ModelPagedList<RawmaterVo> getRawmaterList(RawmaterVo rowmaterial, Integer pageNo, Integer pageSize, String orderBy, Long projectId);

    /**
     * 删除列表中的原材料数据
     * @param rmId
     * @param accountId
     */
    void delRawmater(Integer rmId, Long accountId,Long projectId);


    /**
     * 查看原材料信息
     * @param rmId
     * @param projectId
     * @return
     */
    CateringTcbRowmaterial getRawmaterInfo(Integer rmId, Long projectId, Long projectRootId);

    /**
     * 修改原材料数据
     * @param cateringTcbRowmaterial
     */
    void updateRawmater(CateringTcbRowmaterial cateringTcbRowmaterial,Long accountId,Long projectId,Long projectRootId);


    /**
     * 添加原材料数据
     * @param cateringTcbRowmaterial
     */
    void saveRawmater(CateringTcbRowmaterial cateringTcbRowmaterial,Long accountId,Long projectId,Long projectRootId);


    /**
     * （修改信息中）删除原材料包装信息
     * @param srmId
     */
    void delSaleRowmater(Integer srmId,Long accountId,Long projectId);

    /**
     * （修改信息中）删除原材料供应商信息
     * @param supComId
     */
    void delSuppRowmater(Integer supComId,Long accountId,Long projectId);


    /**
     *     添加原材料数据中-查询原材料等级管理
     */
    List<CatecommTssDatadictModel> getRawmaterGradDict(Integer rmGradeId,Long projectId);



    /**
     * 原材料分类编号生成
     * @param rmcId
     * @return
     */
    String getRawmaterClassCode(Integer rmcId,Long projectId);


    /**
     *
     * @param projectId  项目ID
     * @param dataType  操作基础类型 10:商品 20:原材料
     * @param logType  操作类型 16501:基础信息 16502:包装信息; 16503:供应商;16504:价格配置 (字典表配置)
     * @param Content  操作内容
     * @param accountId 操作人
     */
    int saveBasicDataLog(Long projectId,Integer infoId,Integer dataType,Integer logType,String Content, Long accountId);





    /**
     * 导出-根据ID集合
     * @param rmId
     * @return
     */
    List<RawmaterVo> getRawmaterList(String rmId);


    /**
     * 审核（批量）原材料
     * @param rmId
     */
    void toExamineRawmater(String rmId,Integer cStatus,Long accountId,Long projectId);

    /**
     * 原材料名称唯一性判断
     * @param rmName
     */
    boolean rmNameOnlyJudge(String rmName,Long projectId);/**
     * 原材料编号唯一性判断
     * @param rmCode
     */
    void rmCodeOnlyJudge(String rmCode,Long projectId);

    // 查询是否有子级分类
    List<CateringTccRawmaterClass> queryRawmaterClassByRmcId(Integer rmcId,Long projectId);

    // 查询全部原材料分类
    List<CateringTccRawmaterClass> listAllRawmaterClass(Long projectId);

    // 查询字典表全部原材料单位
    List<CatecommTssPubdatadictModel> queryRmUnit(Integer pDictType);

    // 获取税率信息
    List<CatecommTsbTax> getCatecommTsbTax(Integer taxId, Long projectId);


    // 根据分类ID获取分类信息
    CateringTccRawmaterClass getRawmaterClass(Integer rmcId,String rmClassCode,Long projectId);


    /**
     * 获取缺省原材料包装信息
     * @param projectId
     * @param rmId
     * @return
     */
    CateringTcbSaleRowmater getSaleRowmater(Long projectId, Integer rmId);


    /**
     * 查询原材料包装是否被采购
     * @param projectId
     * @param sRmId
     */
    List<CateringWhInDtl>  getWhinDataBySrmId(Long projectId, Integer sRmId);


    //导入
    RawmaterResponse importRawmater(List<RawmaterExeclMessage> rawmaterExeclList, Long projectId, Long projectRootId, Long accountId);

    //预导入
    String preImportRawmater(Excel<RawmaterExeclVo> excel, Long projectId, Long projectRootId, Long accountId);


    RawmaterResponse listImportRawmater(String redisKey, Integer pageNo, Integer pageSize, Integer type, Long projectId, Long projectRootId, Long accountId);


    void addOrUpdateRawmaterGradDict(CatecommTssDatadictModel catecommTssDatadictModel,Long accountId,Long projectId);



    List<CateringTcbRowmaterialVo> exportRawmater(Long projectId, String rmcCode, Integer rmcId, Integer urmcId, String urmcCode);


    // 查询原材料供应商
    List<CateringTcbSuppRowmater> suppRowmaterList(Long projectId, Integer suppId);




    // 查询原材料
    List<RowmaterilVo> rawmaterList(Long projectId, Integer supperId);

    String getAccountName(Long accountId);

    /**
     * 查询原材料供应商是否被采购
     * @param projectId
     * @param rmId
     * @param suppId
     * @return
     */
    List<CateringWhInDtl>  getWhinDataBySupp(Long projectId, Long rmId,Long suppId);

    String isIntrospection(Long projectId, Long rmId);

    Integer introspection(Long projectId, Long rmId);



}
