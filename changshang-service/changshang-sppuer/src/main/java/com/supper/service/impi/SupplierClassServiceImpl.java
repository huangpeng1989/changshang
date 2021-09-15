package com.supper.service.impi;


import com.supper.service.SupplierClassService;
import com.supper.service.SupplierService;
import entity.IdWorker;
import entity.TreeRecursion;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.CommodityTcbSupplierModel;
import modelpojo.model.CommodityTccSuppclassModel;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.InsertBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.QueryBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SupplierClassServiceImpl implements SupplierClassService {

    private AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Autowired
    IdWorker idWorker;

    @Resource
    SupplierService supplierService;

    @Override
    public List<CommodityTccSuppclassModel> queryFSuppClass(Long projectId) {
        NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE usupp_id = 0 and is_delete = 0 and project_id=" + projectId);
        return autoBaseDao.listAll(supplierClass);
    }

    @Override
    public List<CommodityTccSuppclassModel> querySSuppClass(Integer uSupperId, Long projectId) {
        NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE usupp_id != 0 and is_delete = 0 and project_id = " + projectId);
        supplierClass.append(uSupperId != 0 ? (" and usupp_id=\n" + uSupperId + "\n") : "");
        return autoBaseDao.listAll(supplierClass);
    }

    @Override
    public List<CommodityTccSuppclassModel> supplierClassTree(Long projectId) {
        List<CommodityTccSuppclassModel> suppClassTree = this.queryFSuppClass(projectId);
        suppClassTree.forEach(a ->
                TreeRecursion.getNodeJson(a, this.querySSuppClass(0, projectId))
        );
        return suppClassTree;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSupplierClass(CommodityTccSuppclassModel commodityTccSuppClass, Long accountId) {
        //查询是否存在重复的名称或者编号
        //新增规则：
        //判断本级
        NativeSQLBuilder selfClassBuild = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE is_delete = 0  and usupp_id ="  + commodityTccSuppClass.getUsuppId() + " and project_id = " + commodityTccSuppClass.getProjectId()) ;
        List<CommodityTccSuppclassModel> selfClass = autoBaseDao.listAll(selfClassBuild);
        int selfClassNum = selfClass.size();
        if (selfClass.size() > 0) {
            selfClass.removeIf(a -> a.getSuppClassName().equals(commodityTccSuppClass.getSuppClassName()) && a.getSuppId().intValue() != commodityTccSuppClass.getSuppId().intValue());
        }
        if (selfClassNum != selfClass.size()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "供应商分类名称已存在！", null);
        }

        //判断上级
        NativeSQLBuilder upperClassBuild = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE is_delete = 0  and supp_id ="  + commodityTccSuppClass.getUsuppId() + " and project_id = " + commodityTccSuppClass.getProjectId()) ;
        CommodityTccSuppclassModel upperClass = (CommodityTccSuppclassModel)autoBaseDao.findOne(upperClassBuild);

        if (upperClass != null) {
            if (upperClass.getSuppClassName().equals(commodityTccSuppClass.getSuppClassName()) && upperClass.getSuppId().intValue() != commodityTccSuppClass.getSuppId().intValue()) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "供应商分类名称已存在！", null);
            }
            // 判断分类上上级名称
            NativeSQLBuilder maxClassBuild = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                    .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE is_delete = 0  and supp_id ="  + upperClass.getUsuppId() + " and project_id = " + commodityTccSuppClass.getProjectId()) ;
            CommodityTccSuppclassModel maxClass = (CommodityTccSuppclassModel)autoBaseDao.findOne(maxClassBuild);
            if (null != maxClass) {
                if (maxClass.getSuppClassName().equals(commodityTccSuppClass.getSuppClassName())) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "供应商分类名称已存在！", null);
                }
            }
        }

        NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE is_delete = 0 and supp_class_name =" + "'" + commodityTccSuppClass.getSuppClassName() + "' AND project_id = " + commodityTccSuppClass.getProjectId() + "\n");
        CommodityTccSuppclassModel oldSuppClass = (CommodityTccSuppclassModel) autoBaseDao.findOne(supplierClass);
        if (null != oldSuppClass && oldSuppClass.getSuppId().intValue() != commodityTccSuppClass.getSuppId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "供应商分类名称已存在！", null);
        }
        NativeSQLBuilder supplierSql = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_suppclass  WHERE is_delete = 0  and project_id = " + commodityTccSuppClass.getProjectId() + "\n" +
                        "and supp_class_code =" + "'" + commodityTccSuppClass.getSuppClassCode() + "'\n");
        CommodityTccSuppclassModel oldSuppNameClass = (CommodityTccSuppclassModel) autoBaseDao.findOne(supplierSql);
        if (null != oldSuppNameClass && oldSuppNameClass.getSuppId().intValue() != commodityTccSuppClass.getSuppId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "供应商分类编号已存在！", null);
        }
        if (0 != commodityTccSuppClass.getSuppId()) {
            commodityTccSuppClass.setUpdatedTime(new Date());
            commodityTccSuppClass.setModifier(accountId);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTccSuppclassModel.class).setBean(commodityTccSuppClass)
                    .whereEq("suppId", commodityTccSuppClass.getSuppId())
                    .whereEq("projectId", commodityTccSuppClass.getProjectId());
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "修改保存失败！", null);
            }
        } else {
            commodityTccSuppClass.setSuppId(supplierService.getTableId(commodityTccSuppClass.getProjectId(), "commodity_tcc_suppclass", 1));
            commodityTccSuppClass.setCreater(accountId);
            InsertBuilder playRulesBuild = InsertBuilder.build(commodityTccSuppClass).optSql();
            if (autoBaseDao.save(playRulesBuild) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "新增保存失败！", null);
            }
        }
    }

    @Override
    public CommodityTccSuppclassModel queryById(Integer suppId, Long projectId) {
        QueryBuilder queryBuilder = QueryBuilder.build(CommodityTccSuppclassModel.class)
                .whereEq("suppId", suppId)
                .whereEq("projectId", projectId);
        return (CommodityTccSuppclassModel) autoBaseDao.findOne(queryBuilder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSupplierClass(String suppClassCode, Long projectId, Long accountId) {
        //判断是否是第一级分类
        String childCode = getChildCode(projectId, suppClassCode);
        //下级分类为空，说明是最后一级，或者没有下级，直接查询判断是否有被商品使用
        if(StringUtils.isEmpty(childCode)){
            this.selectSupps(suppClassCode, projectId);
        }else{
            //不为空判断二级分类是否有被使用
            this.selectSupps(childCode, projectId);
            //二级分类没有被使用，继续获取三级分类
            String childCode1 = getChildCode(projectId, childCode);
            if(StringUtils.isNotEmpty(childCode1)){
                //不为空判断三级分类是否有被使用
                this.selectSupps(childCode1, projectId);
            }
        }
        CommodityTccSuppclassModel commodityTccSuppClass = new CommodityTccSuppclassModel();
        commodityTccSuppClass.setIsDelete(1);
        commodityTccSuppClass.setModifier(accountId);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTccSuppclassModel.class).setBean(commodityTccSuppClass).whereEq("supp_class_code", suppClassCode).whereEq("project_id", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "删除失败！", null);
        }
    }

    private void selectSupps (String suppClassCode, Long projectId) {
        //查询菜品分类是否被关联
        NativeSQLBuilder dishes = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier  WHERE is_delete = 0 AND supp_class_code in (" + suppClassCode + ")");
        dishes.append(" and project_id = " + projectId);
        List<CommodityTcbSupplierModel> dishesModels = autoBaseDao.listAll(dishes);
        if (dishesModels != null && dishesModels.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除分类，已被供应商使用！", null);
        }
    }

    /**
     * 获取下级分类
     * @return
     */
    private String getChildCode(Long projectId, String suppClassCode){
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(String.class)
                .setSql(" SELECT " +
                        " GROUP_CONCAT(supp_class_code SEPARATOR ',') " +
                        " FROM " +
                        " commodity_tcc_suppclass " +
                        " WHERE " +
                        " is_delete = 0 " +
                        " AND project_id =  " + projectId +
                        " AND usupp_class_code in (" + suppClassCode + ")");
        return (String)autoBaseDao.findOne(queryBuilder);
    }

    @Override
    public String getSuppClassCode(Integer uSupperId, Long projectId) {
        if (0 != uSupperId) {
            NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                    .setSql("SELECT * FROM commodity_tcc_suppclass WHERE usupp_id = " + uSupperId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "ORDER BY supp_class_code DESC LIMIT 1");
            CommodityTccSuppclassModel suppClass = (CommodityTccSuppclassModel) autoBaseDao.findOne(supplierClass);
            if (null == suppClass) {
                NativeSQLBuilder supplierFClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                        .setSql("SELECT * FROM commodity_tcc_suppclass WHERE project_id = " + projectId + "\n" +
                                "and supp_id = " + uSupperId + "\n" +
                                "ORDER BY supp_class_code DESC LIMIT 1");
                CommodityTccSuppclassModel suppFClass = (CommodityTccSuppclassModel) autoBaseDao.findOne(supplierFClass);
                return suppFClass.getSuppClassCode() + "01";
            } else {
                String code = suppClass.getSuppClassCode().substring(suppClass.getSuppClassCode().length() -2, suppClass.getSuppClassCode().length());
                Integer classCode = Integer.parseInt(code) + 1;
                if (classCode > 9) {
                    return  suppClass.getUsuppClassCode() + classCode;
                }
                return suppClass.getUsuppClassCode() + "0" + classCode.toString();
            }
        } else {
            NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                    .setSql("SELECT * FROM commodity_tcc_suppclass WHERE usupp_id = " + uSupperId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "ORDER BY supp_class_code DESC LIMIT 1");
            CommodityTccSuppclassModel suppClass = (CommodityTccSuppclassModel) autoBaseDao.findOne(supplierClass);
            if (null == suppClass) {
                return "01";
            } else {
                if (0 == uSupperId) {
                    Integer code = Integer.valueOf(suppClass.getSuppClassCode()) + 1;
                    if (code > 9) {
                        return code.toString();
                    }
                    return "0" + code.toString();
                }
                return suppClass.getSuppClassCode() + "01";
            }
        }
    }
}
