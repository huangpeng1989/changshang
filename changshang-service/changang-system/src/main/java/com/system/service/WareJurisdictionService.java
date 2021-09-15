package com.system.service;

import entity.ModelPagedList;
import modelpojo.vo.DeptCompanyVo;
import modelpojo.vo.WareJurisdictionInfoVo;

import java.util.List;

/**
 * 仓库权限
 * @author lixiang
 * @data 2020/10/21
 */
public interface WareJurisdictionService {

    /**
     * 部门组织结构
     * @param orgId
     * @return
     */
    List<DeptCompanyVo> getDeptCompany(Long orgId, String accountName);

    /**
     * 单个仓库设置人员权限
     * @param wareJurisdictionInfoVo
     */
    void saveWareJurisdiction(WareJurisdictionInfoVo wareJurisdictionInfoVo, Long projectId, Long accountId);

    /**
     * 查看详情
     * @param whId
     * @param projectId
     * @return
     */
    WareJurisdictionInfoVo queryById(Integer whId, Long projectId, Integer type);

    /**
     * 批量保存人员权限
     * @param wareJurisdictionInfoVo
     * @param projectId
     * @param accountId
     */
    void saveBatchWareJurisdiction(WareJurisdictionInfoVo wareJurisdictionInfoVo, Long projectId, Long accountId);

    /**
     * 仓库查询
     * @param accountName
     * @param pageSize
     * @param pageNo
     * @param projectId
     * @param whLevel
     * @param whName
     * @return
     */
    ModelPagedList wareList(String accountName, Integer pageNo, Integer pageSize, Long projectId, Integer whLevel, String whName, String whClass);

    /**
     * 通过用户查询仓库权限
     * @param projectId
     * @param accountId
     * @param type 查询类型：1.查询、2.审核
     * @return 仓库IDs
     */
    String getAccountWareJurisdictions(Long projectId, Long accountId, int type);

}
