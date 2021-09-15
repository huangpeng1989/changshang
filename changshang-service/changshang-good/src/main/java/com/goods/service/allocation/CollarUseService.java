package com.goods.service.allocation;




import entity.ModelPagedList;
import modelpojo.model.CommodityWhRcptRtnBillModel;
import modelpojo.model.OrgInfoModel;
import modelpojo.model.account.AccountModel;
import modelpojo.vo.CollarDetailedDto;
import modelpojo.vo.CollarStatisticsDto;
import modelpojo.vo.CollarUseDto;
import modelpojo.vo.CollarUseQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 领用管理服务类
 * </p>
 *
 * @author lixiang
 * @since 2019-09-16
 */
public interface CollarUseService {

    /**
     * 领用/归还信息数据列表
     * @param query
     * @param pageNo
     * @param pageSize
     * @param orderBy
     * @return
     */
    ModelPagedList getRcptRtnList(CollarUseDto query, int pageNo, int pageSize, String orderBy, String type, Long accountId);

    /**
     * 删除领用/归还信息
     * @param rcptBillId
     */
    void delete(Integer rcptBillId, Long projectId, String type);

    /**
     * 领用/归还生成编号
     * @return
     */
    String getRcptBillCode(Long projectId, String type);

    /**
     * 领用/归还信息单个/批量审核
     * @param rpctBillIds
     * @param accountId
     * @param projectId
     * @param type
     */
    void examine(String rpctBillIds, Long accountId, Long projectId, String type, String status);


    /**
     * 新增/修改领用/归还数据
     * @param query
     */
    void saveCollar(CollarUseQuery query, Long accountId);

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
    Map<String, Object> getBarCode(Long projectId, Integer moduleId, Integer primaryKey, Integer billType, Integer billId, Integer resultType);

    /**
     * 根据id查询
     * @param rcptBillId
     * @return
     */
    CollarUseDto queryById(Integer rcptBillId, Long projectId, String type);


    /**
     * 获取部门
     * @return
     */
    ModelPagedList getOrgInfo(Integer pageNo, Integer pageSize, String name, Long orgId);


    /**
     * 获取部门下的人员信息
     * @return
     */
    List<AccountModel> getAccount(Long orgId);


    /* 查询仓库信息
     * @param gzoneId
     * @return
     */
    ModelPagedList queryWare(Integer typeCode, String wareName, Integer isPurchaseWh, Integer whClass, Integer ststus, Long projectId, Integer pageNo, Integer pageSize, Long accountId, Integer inventType,Integer jurisdictionType,Integer inventory);

    /**
     * 选择领用单下拉数据
     * @param projectId
     * @return
     */
    List<CommodityWhRcptRtnBillModel> getCollarUseList(Long projectId, Long accountId);

    /**
     * 添加领用商品/添加报损商品/调出商品
     * @param commClassCode 商品分类编号(条件搜索 可为空)
     * @param name 商品编码/商品名称模糊搜索(条件搜索 可为空)
     * @param pageNo 分页参数(必传)
     * @param pageSize 分页参数(必传)
     * @param projectId 项目ID(必传)
     * @param whId 仓库ID(必传)
     * @return ModelPagedList
     */
    ModelPagedList getSaleComm(String commClassCode, String name, Integer pageNo, Integer pageSize, Long projectId, Integer whId, String whStock);

    /**
     * 生成领用/归还打印条形码
     */
    String createReportLossBarCode(String billBarcode);


    /**
     * 领用报表数据汇总
     * @param type
     * @return
     */
    List<CollarStatisticsDto> collarStatistics(CollarDetailedDto query, String type);


    /**
     * 领用报表数据汇总
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList collarDetailed(CollarDetailedDto query, int pageNo, int pageSize);


    /**
     * 领用报表数据汇总合计
     * @return
     */
    CollarDetailedDto collarDetailedSum(CollarDetailedDto query);

    /**
     * 查询景区
     * @param orgId
     * @param ruleType
     * @return
     */
    List<OrgInfoModel> queryByOrg(Long orgId, String ruleType);

    /**
     * 批量提交审核
     * @param rcptBillIds
     */
    void batchCommit(String rcptBillIds, Long projectId, String type);
}
