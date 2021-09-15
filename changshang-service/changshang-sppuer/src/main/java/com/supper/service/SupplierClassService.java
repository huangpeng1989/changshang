package com.supper.service;


import modelpojo.model.CommodityTccSuppclassModel;

import java.util.List;

/**
 * <p>
 * 供应商分类 服务类
 * </p>
 *
 * @author lixiang
 * @since 2019-08-23
 */
public interface SupplierClassService {

    /**
     * 查询供应商最大父类
     */
    List<CommodityTccSuppclassModel> queryFSuppClass(Long projectId);

    /**
     * 查询供应商所有子类集合
     */
    List<CommodityTccSuppclassModel> querySSuppClass(Integer uSupperId, Long projectId);

    /**
     * 供应商分类树形结构
     * @return
     */
    List<CommodityTccSuppclassModel> supplierClassTree(Long projectId);

    /**
     * 新增/修改供应商分类
     * @param commodityTccSuppClass
     */
    void saveSupplierClass(CommodityTccSuppclassModel commodityTccSuppClass, Long accountId);

    /**
     * 根据id查询
     * @param suppId
     * @return
     */
    CommodityTccSuppclassModel queryById(Integer suppId, Long projectId);

    /**
     * 删除供应商分类
     * @param suppClassCode
     */
    void deleteSupplierClass(String suppClassCode, Long projectId, Long accountId);

    /**
     * 渠道商分类编号生成
     * @param uSupperId
     * @return
     */
    String getSuppClassCode(Integer uSupperId, Long projectId);
}
