package com.supper.service;

import entity.ModelPagedList;
import modelpojo.model.CatecommTssDatadictModel;
import modelpojo.model.CommodityTcbSupplierModel;
import modelpojo.vo.SupplierDto;

import java.util.List;

/**
 * <p>
 * 供应商服务类
 * </p>
 *
 * @author lixiang
 * @since 2019-08-23
 */
public interface SupplierService {

    /**
     * 供应商数据列表
     * @param query
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList getSuppList(CommodityTcbSupplierModel query, int pageNo, int pageSize, String orderBy);

    /**
     * 供应商数据列表
     * @param query
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList getSuppContractList(CommodityTcbSupplierModel query,int moduleId, int pageNo, int pageSize, String orderBy) throws Exception;

    /**
     * 淘汰/删除供应商
     * @param suppId
     * @param status
     */
    void operation(Integer suppId, String status, Long accountId, Long projectId) throws Exception;

    /**
     * 根据id查询
     * @param suppId
     * @return
     */
    SupplierDto queryById(Integer suppId, Long projectId);

    /**
     * 新增/修改供应商
     *
     * @param commodityTcbSupplier
     */
    void saveSupplier(CommodityTcbSupplierModel commodityTcbSupplier, Long accountId);

    /**
     * 供应商单个/批量审核
     * @param suppIds
     */
    void examine(String suppIds, Long accountId, String status, Long projectId);

    /**
     * 查询是否存在重复的供应商编号
     * @return
     */
    CommodityTcbSupplierModel getIsSuppCode(String suppCode);


    /**
     * 查询是否存在重复的供应商名称
     * @return
     */
    CommodityTcbSupplierModel checkSupperName(String suppName, Long projectId, Integer suppId);

    /**
     * 供应商关联商品查询
     * @param suppId
     * @return
     */
    ModelPagedList getCommodity(Integer suppId, Long projectId, int pageNo, int pageSize);

    /**
     * 供应商关联原材料查询
     * @param suppId
     * @return
     */
    ModelPagedList getRawmater(Integer suppId, Long projectId, int pageNo, int pageSize);

    /**
     * 查询所有的供应商
     * @param projectId
     * @return
     */
    List<CommodityTcbSupplierModel> selectSupplier(Long projectId);

    /**
     *查询所有供应商数据-分页
     * @param projectId
     * @param suppNameOrCode
     * @return
     */
    ModelPagedList<CommodityTcbSupplierModel> selectSupplierByName(Long projectId,String suppNameOrCode,Integer pageNo,Integer pageSize);

    /**
     * 供应商编号生成
     * @return
     */
    String getSuppCode();

    /**
     * 账期查询
     * @return
     */
    List<CatecommTssDatadictModel> getPeriod(String typ, Long projectId);

    /**
     * 获取id接口
     * @param projectId 项目id
     * @param tableName 表名
     * @param number 生成id数量(生成单个ID，默认传1)
     * @return
     */
    Integer getTableId(Long projectId, String tableName, int number);

    /**
     * 获取id接口结果集
     * @param projectId 项目id
     * @param tableName 表名
     * @param number 生成id数量
     * @return
     */
    List<Integer> getTableIds(Long projectId, String tableName, int number);
}
