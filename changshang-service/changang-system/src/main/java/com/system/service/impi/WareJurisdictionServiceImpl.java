package com.system.service.impi;


import com.changshang.feign.SupplierServiceFeign;

import com.system.service.WareJurisdictionService;
import entity.ModelPagedList;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.CatecommTsbWarehouseModel;
import modelpojo.model.WareJurisdictionInfoModel;
import modelpojo.vo.AccountVo;
import modelpojo.vo.DeptCompanyVo;
import modelpojo.vo.WareJurisdictionInfoVo;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WareJurisdictionServiceImpl implements WareJurisdictionService {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();

    @Resource
    SupplierServiceFeign supplierService;

    @Override
    public List<DeptCompanyVo> getDeptCompany(Long orgId, String accountName) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(DeptCompanyVo.class)
                .setSql("SELECT o.id, o.org_name \n" +
                        "FROM org_info o \n" +
                        "WHERE o.manage_company_id =  " + orgId + "\n" +
                        "and o.node_type = 'department' and o.status = 'open' and o.deleted = 'false'\n");
        List<DeptCompanyVo> deptCompanyVos = autoBaseDao.listAll(sqlBuilder);
        if (null != deptCompanyVos && deptCompanyVos.size() > 0) {
            deptCompanyVos.forEach(a -> {
                NativeSQLBuilder sql = NativeSQLBuilder.build(AccountVo.class)
                        .setSql("SELECT a.id, a.login_name, a.nick_name, c.org_name as dept_name, c.org_name\n" +
                                "FROM account a \n" +
                                "INNER JOIN org_info c on a.org_id = c.id  \n" +
                                "WHERE a.is_deleted = 'false'  \n" +
                                " AND a.org_id = " + orgId + " and dept_id = " + a.getId());
                sql.append(StringUtils.isNotEmpty(accountName) ? " and a.nick_name like " + "'%" + (accountName) + "%'\n" : "");
                List<AccountVo> account = autoBaseDao.listAll(sql);
                if (null != account && account.size() > 0) {
                    a.setAccountVoList(account);
                }

            });

        }
        return deptCompanyVos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWareJurisdiction(WareJurisdictionInfoVo wareJurisdictionInfoVo, Long projectId, Long accountId) {
        //新增/修改之前删除之前保存的权限
        this.deleteAccountIds(wareJurisdictionInfoVo.getAccountIds(), projectId, wareJurisdictionInfoVo.getWhId());
        if (null != wareJurisdictionInfoVo.getWareJurisdictionInfoList() && wareJurisdictionInfoVo.getWareJurisdictionInfoList().size() > 0) {
            wareJurisdictionInfoVo.getWareJurisdictionInfoList().forEach(a -> {
                a.setProjectId(projectId);
                a.setProjectRootId(projectId);
                a.setCreater(accountId);
                a.setModifier(accountId);
                a.setJurisdictionId(supplierService.getTableId(projectId, "ware_jurisdiction_info", 1));
                a.setWhId(wareJurisdictionInfoVo.getWhId());
                if (autoBaseDao.save(a) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存失败！", null);
                }

            });
        }

    }

    @Override
    public WareJurisdictionInfoVo queryById(Integer whId, Long projectId, Integer type) {
        WareJurisdictionInfoVo wareJurisdictionInfoVo = new WareJurisdictionInfoVo();
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class)
                .setSql("SELECT *\n" +
                        "FROM ware_jurisdiction_info \n" +
                        "WHERE wh_id =  " + whId + "\n" +
                        "and project_id = " + projectId);
        sqlBuilder.append(null != type ? " and type = " + type : "");
        List<WareJurisdictionInfoModel> deptCompanyVos = autoBaseDao.listAll(sqlBuilder);
        wareJurisdictionInfoVo.setWareJurisdictionInfoList(deptCompanyVos);
        return wareJurisdictionInfoVo;
    }

    private void deleteAccountIds(List<String> accuntIds, Long projectId, Integer whId) {
        if (null !=  accuntIds &&  accuntIds.size() > 0) {
            List<String> accountIds = accuntIds.stream().map(c -> {return c.toString();}).collect(Collectors.toList());
            accountIds.forEach(a -> {
                //修改之前先删除
                NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class).setSql("DELETE FROM ware_jurisdiction_info \n" +
                        "where project_id = " + projectId + " and account_id = " + a.split("-")[0] + " AND wh_id = " + whId + " and type = " + a.split("-")[1]);
                autoBaseDao.nativeExecute(nativeSQLBuilder);
            });

        }
    }

    private void deleteAccountIds(WareJurisdictionInfoVo wareJurisdictionInfoVo, Long projectId) {
            if (null != wareJurisdictionInfoVo.getWareJurisdictionInfoList() && wareJurisdictionInfoVo.getWareJurisdictionInfoList().size() > 0) {
                List<String> jurisdictionIds = wareJurisdictionInfoVo.getWareJurisdictionInfoList().stream().map(a->{return a.getJurisdictionId().toString();}).collect(Collectors.toList());
                String jurisdictionIdStr = String.join(",", jurisdictionIds);
            //修改之前先删除
            NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class).setSql("DELETE FROM ware_jurisdiction_info \n" +
                    "where project_id = " + projectId + " and jurisdiction_id IN (" + jurisdictionIdStr + ")");
            autoBaseDao.nativeExecute(nativeSQLBuilder);
            }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchWareJurisdiction(WareJurisdictionInfoVo wareJurisdictionInfoVo, Long projectId, Long accountId) {
        //批量保存前先删除对应的权限数据
        List<String> accountIds = wareJurisdictionInfoVo.getWareJurisdictionInfoList().stream().map(c -> {return c.getAccountIdStr();}).collect(Collectors.toList());
        String whIdStr =  StringUtils.join(wareJurisdictionInfoVo.getWhIds(), ",");
        //修改之前先删除
        accountIds.forEach(a -> {
            NativeSQLBuilder builder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class).setSql(
                    "SELECT * FROM ware_jurisdiction_info \n" +
                            "where project_id = " + projectId + " and account_id = " + a.split("-")[0] + " and type = " + a.split("-")[1] +
            " and wh_id IN(" + whIdStr + ")"  );
            List<WareJurisdictionInfoModel> wareJurisdictionInfoModels = autoBaseDao.listAll(builder);
            if (null != wareJurisdictionInfoModels && wareJurisdictionInfoModels.size() > 0) {
                wareJurisdictionInfoModels.forEach(x -> {
                    NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class).setSql("DELETE FROM ware_jurisdiction_info \n" +
                            "where project_id = " + projectId + " and account_id = " + a.split("-")[0] + " and type = " + a.split("-")[1] +
                            " and wh_id IN(" + x.getWhId() + ")" );
                    autoBaseDao.nativeExecute(nativeSQLBuilder);
                });

            }

        });
        wareJurisdictionInfoVo.getWhIds().forEach(x -> {
            if (null != wareJurisdictionInfoVo.getWareJurisdictionInfoList() && wareJurisdictionInfoVo.getWareJurisdictionInfoList().size() > 0) {
                wareJurisdictionInfoVo.getWareJurisdictionInfoList().forEach(y -> {
                    y.setProjectId(projectId);
                    y.setProjectRootId(projectId);
                    y.setCreater(accountId);
                    y.setJurisdictionId(supplierService.getTableId(projectId, "ware_jurisdiction_info", 1));
                    y.setWhId(x);
                    y.setAccountIdStr(null);
                    if (autoBaseDao.save(y) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "批量保存失败！", null);
                    }
                });
            }
        });
    }

    @Override
    public ModelPagedList wareList(String accountName, Integer pageNo, Integer pageSize, Long projectId, Integer whLevel, String whName, String whClass) {
        NativeSQLBuilder builder = NativeSQLBuilder.build(CatecommTsbWarehouseModel.class).setSql(
                "Select w.*,\n " +
                "(select dict_tp_value from catecomm_tss_datadict where project_id = " + projectId + " and dict_tp_code = w.wh_class) as whTypesName, \n" +
                "(SELECT type_name FROM `catecomm_tss_pubdatadict` WHERE   type_code = w.wh_level)  as whClassName,\n" +
                "(CASE WHEN w.up_project_id <> '' THEN (SELECT o.org_name FROM `org_info` o WHERE o.id = w.up_project_id)\n" +
                "WHEN w.up_project_root_id <> '' THEN (SELECT o.org_name FROM `org_info` o WHERE o.id = w.up_project_root_id)\n" +
                "WHEN w.gzone_id <> '' THEN (SELECT g.gzone_name FROM `catecomm_tsb_gzone` g WHERE g.gzone_id = w.gzone_id  AND g.project_id = " + projectId + ") \n" +
                "ELSE '' END ) AS orgName\n" +
                " FROM catecomm_tsb_warehouse w \n" +
                "LEFT JOIN ware_jurisdiction_info info ON info.wh_id = w.wh_id and info.project_id = w.project_id\n " +
                        "LEFT JOIN account t ON t.id = info.account_id\n");


        //按公司查询
        if(whLevel.equals(1)){
            builder.append(" inner join org_info o on (o.id= w.up_project_root_id) \n" +
                    "where 1 = 1 and w.wh_level = 11701 \n");
        }

        //按景区查询
        if(whLevel.equals(2)){
            builder.append(" inner join org_info o on (o.id = w.up_project_id)\n" +
                    "where 1 = 1 and w.wh_level = 11702 \n");
            builder.append(" and o.node_type = 'scenic' \n");
            builder.append(" and w.wh_class = " + whClass + "\n");
        }


        //按营业点查询
        if(whLevel.equals(3)){
            builder.append(" inner join catecomm_tsb_gzone g on (g.gzone_id= w.gzone_id)\n" +
                    "where 1 = 1 and w.wh_level = 11703 and g.project_id = " + projectId + "\n");
            builder.append(" and w.wh_class = " + whClass + "\n");
        }


        builder.append(StringUtils.isNotEmpty(whName) ?" and (w.wh_name like '%" + whName + "%' or w.wh_code like '%" + whName + "%')\n" : "");
        builder.append(StringUtils.isNotEmpty(accountName) ? "and t.nick_name like '%" + accountName + "%' " : "");
        builder.append("  and w.is_start_using = 1 and w.is_delete = 0 and w.project_id= " + projectId + "\n" +
                " GROUP BY w.wh_id\n" +
                "order by w.created_time desc ");
        builder.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(builder));
    }

    @Override
    public String getAccountWareJurisdictions(Long projectId, Long accountId, int type) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(AccountVo.class)
                .setSql("SELECT a.id, a.login_name, a.nick_name, a.dept_id\n" +
                        "FROM account a \n" +
                        "WHERE a.is_deleted = 'false'  \n" +
                        " AND a.org_id = " + projectId + " and a.id = " + accountId);
        AccountVo account = (AccountVo)autoBaseDao.findOne(sql);
        if (null != account && null == account.getDeptID() && "管理员".equals(account.getNickName())) {
            //管理员返回所有权限
            return null;
        }

        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(WareJurisdictionInfoModel.class)
                .setSql("SELECT *\n" +
                        "FROM ware_jurisdiction_info \n" +
                        "WHERE account_id =  " + account.getId() + "\n" +
                        "and project_id = " + projectId + "\n" +
                        " and type = " + type);
        List<WareJurisdictionInfoModel> deptCompanyVos = autoBaseDao.listAll(sqlBuilder);
        if (null == deptCompanyVos || deptCompanyVos.size() == 0) {
            return "0";//无权限返回0
        }
        List<String> whIds = deptCompanyVos.stream().map(c -> {return c.getWhId().toString();}).collect(Collectors.toList());
        return  whIds.stream().collect(Collectors.joining(","));
    }


}
