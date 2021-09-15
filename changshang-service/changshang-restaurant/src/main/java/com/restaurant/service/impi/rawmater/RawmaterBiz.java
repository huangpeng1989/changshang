package com.restaurant.service.impi.rawmater;

import com.alibaba.fastjson.JSON;
import com.changshang.feign.DataDictFeign;
import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.adjust.AdjustFeign;
import com.changshang.feign.allocation.CollarUseFeign;
import com.google.common.base.Joiner;

import com.restaurant.service.rawmater.RawmaterApi;
import entity.GetPell;
import entity.ModelPagedList;
import entity.RedisUtil;
import entity.TreeRecursion;
import excel.Excel;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.model.account.AccountModel;
import modelpojo.model.contract.CateringContract;
import modelpojo.vo.CateringTcbRowmaterialVo;
import modelpojo.vo.DishClasslVo;
import modelpojo.vo.RawmaterExeclMessage;
import modelpojo.vo.RawmaterResponse;
import modelpojo.vo.caterAdjust.RowmaterilVo;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dishbom.RawmaterVo;
import modelpojo.vo.saleadjust.RawmaterExeclVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.lufei.ibatis.builder.*;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description 原材料业务层
 * @Author wenbin.wang
 * @Date 2019-08-29 19:13
 */
@Service
public class RawmaterBiz implements RawmaterApi {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


     RedisUtil redisUtil = new RedisUtil();

    @Autowired
    SupplierServiceFeign supplierService;


    @Autowired
    CollarUseFeign collarUseService;


    @Autowired
    private AdjustFeign adjustApi;

    @Autowired
    private DataDictFeign dataDictApi;

    /**
     * 查询原材料最大父类
     * @param projectId
     * @return
     */
    @Override
    public List<CateringTccRawmaterClass> queryFRawmaterClass(Long projectId) {
        NativeSQLBuilder rawmaterClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0 and urmc_id = 0 and project_id=" + projectId );
        return autoBaseDao.listAll(rawmaterClass);
    }


    @Override
    public List<CateringTccRawmaterClass> queryMaxRawmaterClass(Long projectId) {
        NativeSQLBuilder rawmaterClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0 and urmc_id = 0 and project_id=" + projectId );
        List<CateringTccRawmaterClass> list = autoBaseDao.listAll(rawmaterClass);
        CateringTccRawmaterClass rawClass = new CateringTccRawmaterClass();
        rawClass.setRmcName("全部");
        rawClass.setRmcCode("全部");
        rawClass.setRmcId(0);
        list.add(0,rawClass);
        return list;
    }



    /*根据分类编号和上级分类ID查询商品分类信息*/
    @Override
    public List<CateringTccRawmaterClass> getChildrenURmClassTwo(Integer urmClassId, String rmcCode,Long projectId) {
        NativeSQLBuilder supplierClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE urmc_id != 0 and is_delete = 0 and project_id = "+projectId);
        supplierClass.append(urmClassId != 0 ? (" and urmc_id=\n" + urmClassId + "\n") : "");
        supplierClass.append(" and urmc_code=\n'" + rmcCode + "'\n");
        List<CateringTccRawmaterClass> comclassModelList = autoBaseDao.listAll(supplierClass);
        CateringTccRawmaterClass comclassModel = new CateringTccRawmaterClass();
        comclassModel.setRmcName("全部");
        comclassModel.setRmcCode("全部");
        if (rmcCode.length() == 2) {
            comclassModel.setRmcId(1);
        } else if (rmcCode.length() == 4) {
            comclassModel.setRmcId(2);
        }

        comclassModelList.add(0,comclassModel);
        return comclassModelList;
    }

    /**
     * 查询原材料所有子类集合
     * @param urmcId
     * @return
     */
    @Override
    public List<CateringTccRawmaterClass> querySRawmaterClass(Integer urmcId,Long projectId) {
        NativeSQLBuilder rawmaterClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE urmc_id != 0 and is_delete = 0 and project_id = "+projectId);
        rawmaterClass.append(urmcId != 0 ? (" and urmc_id=\n" + urmcId + "\n") : "");
        return autoBaseDao.listAll(rawmaterClass);
    }

    @Override
    public CateringTccRawmaterClass queryById(Integer rmcId,Long projectId) {
        QueryBuilder queryBuilder = QueryBuilder.build(CateringTccRawmaterClass.class)
                .whereEq("rmcId", rmcId).whereEq("projectId",projectId);
        return (CateringTccRawmaterClass) autoBaseDao.findOne(queryBuilder);
    }

    /**
     * 原材料分类树形结构
     * @param projectId
     * @return
     */
    @Override
    public List<CateringTccRawmaterClass> rawmaterClassTree(Long projectId) {
        List<CateringTccRawmaterClass> rawmaterTree = this.queryFRawmaterClass(projectId);
        rawmaterTree.forEach(a ->
                TreeRecursion.getNodeJson(a, this.querySRawmaterClass(0,projectId))
        );
        return rawmaterTree;
    }

    /**
     * 新增/修改原材料分类
     * @param rawmaterClass
     * @param accountId
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void saveRawmaterClass(CateringTccRawmaterClass rawmaterClass, Long accountId,Long projectId,Long projectRootId) {

        //查询是否存在重复的名称
        NativeSQLBuilder upperClassBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0  and urmc_id ="  + rawmaterClass.getUrmcId()+  " and project_id = " + projectId) ;
        List<CateringTccRawmaterClass> upperClassList = autoBaseDao.listAll(upperClassBuild);

        int num = upperClassList.size();
        if (num > 0) {
            upperClassList.removeIf(
                    a -> a.getRmcName().equals(rawmaterClass.getRmcName()) && a.getRmcId().intValue() != rawmaterClass.getRmcId().intValue());
        }
        if (num != upperClassList.size()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "原材料分类名称已存在！", null);
        }

        //查询是否存在重复的名称
        NativeSQLBuilder classBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0  and rmc_id ="  + rawmaterClass.getUrmcId() +  " and project_id = " + projectId) ;
        CateringTccRawmaterClass upperClass = (CateringTccRawmaterClass)autoBaseDao.findOne(classBuild);

        if (upperClass != null) {
            if (upperClass.getRmcName().equals(rawmaterClass.getRmcName())) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "原材料分类名称已存在！", null);
            }
            // 查询分类上上级名称
            NativeSQLBuilder maxClassBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                    .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0  and rmc_id ="  + upperClass.getUrmcId() +  " and project_id = " + projectId) ;
            CateringTccRawmaterClass maxClass = (CateringTccRawmaterClass)autoBaseDao.findOne(maxClassBuild);
            if (maxClass != null) {
                if (maxClass.getRmcName().equals(rawmaterClass.getRmcName())){
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "原材料分类名称已存在！", null);
                }
            }
        }

        //查询是否存在重复的分类编号
        NativeSQLBuilder rawmaterCodeClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0 and rmc_code =" + "'" + rawmaterClass.getRmcCode() +"'"+
                        "\tand project_id = " + projectId + "\n" ) ;
        CateringTccRawmaterClass oldRawmaterCodeClass = (CateringTccRawmaterClass)autoBaseDao.findOne(rawmaterCodeClass);
        if (null != oldRawmaterCodeClass && oldRawmaterCodeClass.getRmcId().intValue() != rawmaterClass.getRmcId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "原材料分类编号已存在！", null);
        }
        if (null != rawmaterClass.getRmcId()) {
            rawmaterClass.setUpdatedTime(new Date());
            rawmaterClass.setModifier(accountId);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccRawmaterClass.class).setBean(rawmaterClass).whereEq("rmcId", rawmaterClass.getRmcId())
                    .whereEq("projectId",projectId);
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改保存失败！", null);
            }
        } else {
            rawmaterClass.setRmcId(supplierService.getTableId(projectId,"catering_tcc_rawmater_class", 1));
            rawmaterClass.setCreater(accountId);
            rawmaterClass.setModifier(accountId);
            rawmaterClass.setProjectId(projectId);
            rawmaterClass.setProjectRootId(projectRootId);
            rawmaterClass.setCcStatus(10);
            InsertBuilder playRulesBuild = InsertBuilder.build(rawmaterClass).optSql();
            if (autoBaseDao.save(playRulesBuild) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
            }
        }
    }

    /**
     * 获取下级分类
     * @return
     */
    private String getChildCode(Long projectId,String rmcCode){
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(String.class)
                .setSql(" SELECT " +
                        " GROUP_CONCAT(rmc_code SEPARATOR ',') " +
                        " FROM " +
                        " catering_tcc_rawmater_class " +
                        " WHERE " +
                        " is_delete = 0 " +
                        " AND project_id =  " + projectId +
                        " AND urmc_code in ("+rmcCode+")");
        String comCode = (String)autoBaseDao.findOne(queryBuilder);
        return comCode;
    }

    /**
     * 判断分类是否有关联原材料
     * @param projectId
     * @param rmcCode
     * @return
     */
    private boolean isClassRmFlag(Long projectId,String rmcCode){
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("SELECT * FROM catering_tcb_rowmaterial  WHERE is_delete = 0 AND rm_class_code in (" + rmcCode + ")");
        supplier.append(" and project_id = " + projectId);
        List<CateringTcbRowmaterial> supplierModels = autoBaseDao.listAll(supplier);
        if (null != supplierModels && supplierModels.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     *删除原材料分类
     * @param rmcCode
     */
    @Override
    @Transactional
    public void deleteRawmaterClass(String rmcCode,Long projectId) {
        String childCode = getChildCode(projectId,rmcCode);
        //下级分类为空，说明是最后一级，或者没有下级，直接查询判断是否有被商品使用
        if(StringUtils.isEmpty(childCode)){
            if(isClassRmFlag(projectId,rmcCode)){
                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法删除分类，已被原材料使用！", null);
            }
        }else{
            //不为空判断二级分类是否有被使用
            if(isClassRmFlag(projectId,childCode)){
                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法删除分类，已被原材料使用！", null);
            }else{
                deleteComClass(childCode,projectId);
            }
            //二级分类没有被使用，继续获取三级分类
            String childCode1 = getChildCode(projectId,childCode);
            if(StringUtils.isNotEmpty(childCode1)){
                //不为空判断三级分类是否有被使用
                if(isClassRmFlag(projectId,childCode1)){
                    throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法删除分类，已被原材料使用！", null);
                }else{
                    deleteComClass(childCode1,projectId);
                }
            }
        }
        NativeSQLBuilder rowmaterBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE project_id = "+projectId+" and rmc_code =" + rmcCode);
        CateringTccRawmaterClass rawmaterClass = (CateringTccRawmaterClass)autoBaseDao.findOne(rowmaterBuild);
        rawmaterClass.setIsDelete(1);
        rawmaterClass.setSyncStatus(SyncStatus.NOT_SYNC);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccRawmaterClass.class).setBean(rawmaterClass).whereEq("rmcId", rawmaterClass.getRmcId())
                .whereEq("projectId",projectId);
        UpdateBuilder updateBuilder1 = UpdateBuilder.build(CateringTccRawmaterClass.class).setBean(rawmaterClass).whereEq("rmcId", childCode)
                .whereEq("projectId",projectId);

        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除失败！", null);
        }
    }

    /**
     * 删除子类
     * @param childCode
     * @param projectId
     */
    private void deleteComClass(String childCode,Long projectId){
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("UPDATE catering_tcc_rawmater_class SET is_delete = 1,\n" +
                        "sync_status = 10\n" +
                        "WHERE rmc_code IN ( " + childCode + ") and project_id =" + projectId);
        //操作
        if (autoBaseDao.nativeExecute(nativeSQLBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除子类时失败！", null);
        }
    }

    @Override
    public void importRawmaterClass(Excel<DishClasslVo> excel, Long projectId, Long projectRootId, Long accountId) {
        try {
            List<DishClasslVo> execlVos = excel.getData();
            Integer uRmcId = 0;
            String uClassCode = "";
            String uClassName = "";

            Integer secondURmcId = 0;
            String secondUClassCode = "";
            String secondUClassName = "";

            for (DishClasslVo vo : execlVos) {
                if (StringUtils.isEmpty(vo.getFirstClassName()) && StringUtils.isEmpty(vo.getSecondClassName()) && StringUtils.isEmpty(vo.getThreeClassName())) {
                    continue;
                }
                if (org.apache.commons.lang.StringUtils.isEmpty(vo.getFirstClassName())) {
                    throw new RpcException(300, "请选择必填项-->一级分类名称", null);
                }
                String firstClassName = vo.getFirstClassName();
                String taxCode = vo.getFirstTaxCode();
                //查询一级分类名称是否存在
                NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                        .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete = 0 AND urmc_id = 0 and rmc_name = '"  + firstClassName +  "' and project_id = " + projectId) ;
                CateringTccRawmaterClass firstClass = (CateringTccRawmaterClass)autoBaseDao.findOne(sqlBuilder);
                //如果第一级分类名称不存在则创建
                if (null == firstClass) {

                    //查询最大的一级分类编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                            .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = 0 \n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(rmc_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccRawmaterClass firstClassModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sql);
                    String firstCode = "";
                    //如果是空则表示从未创建过
                    if (null == firstClassModel) {
                        firstCode = "01";
                    } else {
                        Integer code = Integer.valueOf(firstClassModel.getRmcCode()) + 1;
                        if (code > 99) {
                            throw new RpcException(300, "一级分类的编号超出范围，无法添加！", null);
                        }
                        if (code > 9) {
                            firstCode = code.toString();
                        }else{
                            firstCode =  "0" + code.toString();
                        }
                    }
                    //保存菜品分类
                    CateringTccRawmaterClass newRmcClass = saveRawmaterClass(projectId, accountId, firstCode, firstClassName, "0", null, 0,taxCode);
                    //如果编号不为空，则表示当前分类的编号在数据库存在过，没有再次新增
                    if (StringUtils.isNotEmpty(newRmcClass.getRmcCode())) {
                        uRmcId = newRmcClass.getRmcId();
                        uClassCode = newRmcClass.getRmcCode();
                        uClassName = newRmcClass.getRmcName();
                    } else {
                        uClassCode = firstCode;
                        uClassName = firstClassName;
                        uRmcId = newRmcClass.getRmcId();
                    }
                } else {
                    uRmcId = firstClass.getRmcId();
                    uClassCode = firstClass.getRmcCode();
                    uClassName = firstClass.getRmcName();
                    if(StringUtils.isNotEmpty(taxCode)){
                        updateTaxCode(projectId,uRmcId,taxCode);
                    }
                }

                if (StringUtils.isEmpty(vo.getSecondClassName()) && StringUtils.isNotEmpty(vo.getThreeClassName())) {
                    throw new RpcException(300, "请选择必填项-->数据不完整，请检查数据的完整性", null);
                }
                //二级分类编号
                if (StringUtils.isNotBlank(vo.getSecondClassName())) {
                    String sencondClassName =  vo.getSecondClassName();
                    String taxCode2 =  vo.getSecondTaxCode();
                    String secondCode = "";
                    //查询二级分类最大的编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                            .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = " + uRmcId + "\n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(rmc_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccRawmaterClass secondClassModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sql);
                    if (null == secondClassModel) {
                        secondCode =  uClassCode + "01";
                    } else {
                        String code = secondClassModel.getRmcCode().substring(secondClassModel.getRmcCode().length() -2, secondClassModel.getRmcCode().length());
                        Integer classCode = Integer.parseInt(code) + 1;
                        if (classCode > 99) {
                            throw new RpcException(300, "二级分类的编号超出范围，无法添加！", null);
                        }
                        if (classCode > 9) {
                            secondCode = uClassCode + classCode.toString();
                        }else{
                            secondCode = uClassCode + "0" + classCode.toString();
                        }
                    }

                    CateringTccRawmaterClass newRmcClass = saveRawmaterClass(projectId, accountId, secondCode, sencondClassName, uClassCode, uClassName, uRmcId,taxCode2);
                    if (StringUtils.isNotEmpty(newRmcClass.getRmcCode())) {
                        secondURmcId = newRmcClass.getRmcId();
                        secondUClassCode = newRmcClass.getRmcCode();
                        secondUClassName = newRmcClass.getRmcName();
                    } else {
                        secondUClassName = sencondClassName;
                        secondUClassCode = secondCode;
                        secondURmcId = newRmcClass.getRmcId();
                    }
                }

                //三级分类编号
                if (StringUtils.isNotBlank(vo.getThreeClassName())) {
                    String threeClassName =  vo.getThreeClassName();
                    String taxCode3 =  vo.getThreeTaxCode();
                    String threeCode = "";
                    //查询三级分类最大的编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                            .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = " + secondURmcId + "\n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(rmc_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccRawmaterClass threeClassModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sql);
                    if (null == threeClassModel) {
                        threeCode = secondUClassCode + "01";
                    } else {
                        String code = threeClassModel.getRmcCode().substring(threeClassModel.getRmcCode().length() -2, threeClassModel.getRmcCode().length());
                        Integer classCode = Integer.parseInt(code) + 1;
                        if (classCode > 99) {
                            throw new RpcException(300, "三级分类的编号超出范围，无法添加！", null);
                        }
                        if (classCode > 9) {
                            threeCode = secondUClassCode + classCode.toString();
                        }else{
                            threeCode = secondUClassCode + "0" + classCode.toString();
                        }
                    }
                    saveRawmaterClass(projectId, accountId, threeCode, threeClassName, secondUClassCode, secondUClassName, secondURmcId,taxCode3);
                }

            }
        } catch (Exception e) {
            throw new RpcException(300, e.getMessage(), null);
        }
    }

    @Override
    public void clearTaxCode(Long projectId) {
        NativeSQLBuilder update = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("UPDATE catering_tcc_rawmater_class SET tax_code = null,\n" +
                        "sync_status = 10\n" +
                        "WHERE project_id =" + projectId);
        autoBaseDao.nativeExecute(update);
    }


    private CateringTccRawmaterClass saveRawmaterClass(Long projectId, Long accountId, String classCode, String className, String uClassCode, String uClassName, Integer uRmcId,String taxCode) {
        //查询当前分类是否存在相同名称
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = " + uRmcId + "\n" +
                        "AND project_id = " + projectId + "\n" +
                        "AND rmc_name = '" + className + "'\n" +
                        " AND is_delete = 0 " +
                        "ORDER BY CONVERT(rmc_code, SIGNED) DESC LIMIT 1") ;
        CateringTccRawmaterClass classModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sql);
        if (null != classModel) {
            if (StringUtils.isEmpty(taxCode)) {
                return classModel;
            }
            //可能存在需要修改税务编码
            updateTaxCode(projectId,classModel.getRmcId(),taxCode);
            return classModel;
        }
        CateringTccRawmaterClass rawmaterClass = new CateringTccRawmaterClass();
        rawmaterClass.setProjectId(projectId);
        rawmaterClass.setProjectRootId(projectId);
        rawmaterClass.setRmcId(supplierService.getTableId(projectId,"catering_tcc_rawmater_class", 1));
        rawmaterClass.setCreater(accountId);
        rawmaterClass.setModifier(accountId);
        rawmaterClass.setRmcCode(classCode);
        rawmaterClass.setRmcName(className);
        rawmaterClass.setUrmcCode(uClassCode);
        rawmaterClass.setUrmcId(uRmcId);
        rawmaterClass.setUrmcName(uClassName);
        rawmaterClass.setTaxCode(taxCode);
        rawmaterClass.setCcStatus(10);
        InsertBuilder playRulesBuild = InsertBuilder.build(rawmaterClass).optSql();
        if (autoBaseDao.save(playRulesBuild) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
        }
        CateringTccRawmaterClass newRmcClass = new CateringTccRawmaterClass();
        newRmcClass.setRmcId(rawmaterClass.getRmcId());
        return newRmcClass;
    }


    private void updateTaxCode(Long projectId,Integer rmcId,String taxCode){
        CateringTccRawmaterClass cateringTccRawmaterClass = new CateringTccRawmaterClass();
        cateringTccRawmaterClass.setSyncStatus(10);
        cateringTccRawmaterClass.setTaxCode(taxCode);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccRawmaterClass.class).setBean(cateringTccRawmaterClass)
                .whereEq("rmc_id", rmcId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改编码保存失败！", null);
        }
    }

    /**
     * 原材料列表
     * @param rowmaterial  pageNo  pageSize  orderBy  projectId
     * @param pageNo
     * @param pageSize
     * @param orderBy
     * @return
     */
    @Override
    public ModelPagedList<RawmaterVo> getRawmaterList(RawmaterVo rowmaterial, Integer pageNo, Integer pageSize, String orderBy, Long projectId) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(RawmaterVo.class)
                .setSql("select t1.*,t4.urmc_id,t4.rmc_name,(select t6.nick_name from account t6 where t6.id=t1.creater) as createrStr,\n" +
                        "\t (select t8.nick_name from account t8 where t8.id=t1.modifier) as modifierStr,\n" +
                        "\t(select t5.type_name from catecomm_tss_pubdatadict t5 where t1.rm_unit = t5.type_code and t5.p_dict_status = 1) as rmUnitStr,\n" +
                        "\t(select t6.type_name from catecomm_tss_pubdatadict t6 where t1.c_status = t6.type_code and t6.p_dict_status = 1) as cStatusStr\n" +
                        "\tfrom catering_tcb_rowmaterial t1 INNER join \n" +
                        "\tcatering_tcb_supp_rowmater t2 on\n" +
                        "\tt1.rm_code = t2.rm_code and t1.project_id = t2.project_id INNER join\n" +
                        "\tcommodity_tcb_supplier t3 on t2.supp_id = t3.supp_id and t2.project_id = t3.project_id\n" +
                        "\tINNER join catering_tcc_rawmater_class t4 on t4.rmc_code = t1.rm_class_code and t4.project_id = t1.project_id\n" +
                        "\twhere t1.project_id = #{projectId} and t1.is_delete = 0");


        nativeSQLBuilder.setValue("projectId", projectId);
        if (StringUtils.isNotEmpty(rowmaterial.getRmClassCode())) {
            //判断是否是第一级分类
            String rmClassCode = this.getChildCode(projectId, rowmaterial.getRmClassCode());
            //下级分类为空，说明是最后一级
            if (StringUtils.isEmpty(rmClassCode)) {
                nativeSQLBuilder.append(" and t1.rm_class_code IN (\n" + rowmaterial.getRmClassCode() + ")\n");
            }  else {
                //不为空获取二级分类
                String childCode = getChildCode(projectId, rowmaterial.getRmClassCode());
                //不为空获取三级分类
                String childLastCode = "";
                if (StringUtils.isNotEmpty(childCode)) {
                    childLastCode = getChildCode(projectId, childCode);
                }

                if(StringUtils.isNotEmpty(childLastCode)){
                    nativeSQLBuilder.append(" and t1.rm_class_code IN (\n" + childLastCode + ")\n");
                } else {
                    //isALL代表查全部 如果有值 证明是查包含下级全部 否则只查当前自己这个分类
                    nativeSQLBuilder.append(" and t1.rm_class_code IN (\n" + childCode + ")\n");
                }
            }
        }
        //nativeSQLBuilder.append(StringUtils.isNotBlank(rowmaterial.getRmClassCode()) ? ("and t1.rm_class_code =\n" + "'" + (rowmaterial.getRmClassCode()) + "'\n") : "");
        nativeSQLBuilder.append(StringUtils.isNotBlank(rowmaterial.getRmName()) ? ("and t1.rm_name like\n" + "'%" + (rowmaterial.getRmName()) + "%'\n") : "");
        nativeSQLBuilder.append(StringUtils.isNotBlank(rowmaterial.getRmCode()) ? ("and t1.rm_code like\n" + "'%" + (rowmaterial.getRmCode()) + "%'\n") : "");
        nativeSQLBuilder.append(CollectionUtils.isNotEmpty(rowmaterial.getcStatuss()) ? ("and t1.c_status IN\n" + "(" + String.join(",", rowmaterial.getcStatuss()) + ")\n") : "");
        nativeSQLBuilder.append(StringUtils.isNotBlank(rowmaterial.getSuppName()) ? ("and t3.supp_name like\n" + "'%" + (rowmaterial.getSuppName()) + "%'\n") : "");
        nativeSQLBuilder.append(StringUtils.isNotBlank(rowmaterial.getSuppCode()) ? ("and t3.supp_code like\n" + "'%" + (rowmaterial.getSuppCode()) + "%'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getIsCanSale() != null ? ("and t1.is_can_sale =\n" + "'" + (rowmaterial.getIsCanSale()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType() != null ? ("and t1.spec_rm_type =\n" + "'" + (rowmaterial.getSpecRmType()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType2() != null ? ("and t1.spec_rm_type2 =\n" + "'" + (rowmaterial.getSpecRmType2()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType3() != null ? ("and t1.spec_rm_type3 =\n" + "'" + (rowmaterial.getSpecRmType3()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType4() != null ? ("and t1.spec_rm_type4 =\n" + "'" + (rowmaterial.getSpecRmType4()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType5() != null ? ("and t1.spec_rm_type5 =\n" + "'" + (rowmaterial.getSpecRmType5()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType6() != null ? ("and t1.spec_rm_type6 =\n" + "'" + (rowmaterial.getSpecRmType6()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType7() != null ? ("and t1.spec_rm_type7 =\n" + "'" + (rowmaterial.getSpecRmType7()) + "'\n") : "");
        nativeSQLBuilder.append(rowmaterial.getSpecRmType8() != null ? ("and t1.spec_rm_type8 =\n" + "'" + (rowmaterial.getSpecRmType8()) + "'\n") : "");
        nativeSQLBuilder.append("group by t1.rm_id");
        nativeSQLBuilder.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                + "t1.created_time desc");
        nativeSQLBuilder.setPage(pageNo,pageSize);
        PagedList<RawmaterVo> pagedList = autoBaseDao.listPage(nativeSQLBuilder);
        return ModelPagedList.convertToModelPage(pagedList);
    }

    /**
     *删除列表中的原材料数据
     * @param rmId
     * @param accountId
     */
    @Override
    @Transactional
    public void delRawmater(Integer rmId, Long accountId,Long projectId) {
        // 查询原材料是否有库存
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringStockNow.class)
                .setSql("select * from v_catering_stock_now where rm_dish_id = "+rmId+"  and good_type = 11004 and project_id = "+projectId);
        List<CateringStockNow> whStock = autoBaseDao.listAll(nativeSQLBuilder);
        if (CollectionUtils.isNotEmpty(whStock) && whStock.get(0).getWhStock().compareTo(BigDecimal.ZERO) > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除原材料，该原材料还有库存", null);
        }
        NativeSQLBuilder sQLBuilder = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("select * from catering_tcb_rowmaterial where rm_id =  "+rmId+"  and project_id = "+projectId);
        CateringTcbRowmaterial rowmaterial = (CateringTcbRowmaterial)autoBaseDao.findOne(sQLBuilder);
        rowmaterial.setIsDelete(1);
        rowmaterial.setModifier(accountId);
        rowmaterial.setSyncStatus(SyncStatus.NOT_SYNC);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbRowmaterial.class).setBean(rowmaterial).whereEq("rm_id",rmId).whereEq("project_id",projectId);
        autoBaseDao.update(updateBuilder);

        //销售信息表
        NativeSQLBuilder comSaled = NativeSQLBuilder.build(CateringTcbSaleRowmater.class).setSql("update catering_tcb_sale_rowmater set is_delete = 1 WHERE rm_id =" + rmId + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comSaled);

        //供应商表
        NativeSQLBuilder comsupp = NativeSQLBuilder.build(CateringTcbSuppRowmater.class).setSql("update catering_tcb_supp_rowmater set is_delete = 1 WHERE rm_id =" + rmId + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comsupp);
    }

    /**
     * 查看原材料信息
     * @param rmId
     * @param projectId
     * @return
     */
    @Override
    public CateringTcbRowmaterial getRawmaterInfo(Integer rmId, Long projectId,Long projectRootId) {
        NativeSQLBuilder rowmaterialBuild = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("select t1.*,(select t3.nick_name from account t3 where t1.creater = t3.id) as createrStr,\n" +
                        "\t(select t2.dict_tp_value from catecomm_tss_datadict t2 where t2.dict_tp_code = t1.rm_grade_id and t2.project_id = t1.project_id) as rmGradeStr\n " +
                        "\tfrom catering_tcb_rowmaterial t1 where t1.is_delete=0 and t1.project_id = " + projectId + " and rm_id= " + rmId + "");
        CateringTcbRowmaterial rowmaterial = (CateringTcbRowmaterial)autoBaseDao.findOne(rowmaterialBuild);

        //查询当前原材料分类编号的上级编号
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT rmc_id, rmc_code, urmc_id, urmc_code \n" +
                        "FROM catering_tcc_rawmater_class \n" +
                        "WHERE rmc_code = '" + rowmaterial.getRmClassCode() + "' and project_id = " + projectId);
        CateringTccRawmaterClass fClassModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sql);

        CateringTccRawmaterClass fMaxClassModel = null;
        //组装最大父级的原材料分类编号
        if (fClassModel != null) {
            NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                    .setSql("SELECT rmc_id, rmc_code FROM catering_tcc_rawmater_class\n" +
                            "WHERE rmc_id = (SELECT urmc_id FROM catering_tcc_rawmater_class\n" +
                            "WHERE rmc_id =" + fClassModel.getUrmcId() +" AND project_id =" + projectId + ")\n" +
                            "AND project_id = " + projectId);
            fMaxClassModel = (CateringTccRawmaterClass)autoBaseDao.findOne(sqlMax);
        }

        String zoomClassCode = (null != fMaxClassModel  ?  fMaxClassModel.getRmcCode() + ","  : "") +
                (null != fClassModel ? fClassModel.getUrmcCode() + ","  : "") +
                rowmaterial.getRmClassCode();
        rowmaterial.setZoomClassCode(zoomClassCode);

        // 原材料包装信息
        NativeSQLBuilder query = NativeSQLBuilder.build(CateringTcbSaleRowmater.class)
                .setSql("select t1.*,(select t2.type_name from catecomm_tss_pubdatadict t2 where t1.srm_unit = t2.type_code) as srmUnitName,\n" +
                        "\t(select t3.nick_name from account t3 where t1.creater = t3.id) as createrStr,\n"+
                        "\t (CASE WHEN t1.is_normal = 0 THEN '正常' ELSE '淘汰' END) as isDeleteStr"+
                        "\tfrom catering_tcb_sale_rowmater  t1 where  t1.project_id = " + projectId + " and t1.rm_id= " + rmId + "");
        List<CateringTcbSaleRowmater> saleRowmaterlist = autoBaseDao.listAll(query);

        rowmaterial.setSaleRowmaterList(saleRowmaterlist);

        // 原材料供应商信息
        NativeSQLBuilder suppRowmaterBuilder = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                .setSql("select t1.*,t2.supp_code,t2.supp_name," +
                        "\t(select t3.nick_name from account t3 where t1.creater = t3.id) as createrStr,\n"+
                        "\t (CASE WHEN t1.is_normal = 0 THEN '正常' ELSE '淘汰' END) as isDeleteStr,"+
                        "\t(select t4.dict_tp_value from catecomm_tss_datadict t4 where t4.dict_tp_code = t1.delivery_type and t4.project_id = t1.project_id) as deliveryTypeStr\n " +
                        "\tfrom catering_tcb_supp_rowmater t1 inner join commodity_tcb_supplier t2 on t1.supp_id = t2.supp_id and t1.project_id = t2.project_id\n" +
                        "\tand t1.project_id = " + projectId + " and t1.rm_id= " + rmId + "");
        List<CateringTcbSuppRowmater> suppRowmaterlist = autoBaseDao.listAll(suppRowmaterBuilder);

        rowmaterial.setSuppRowmaterList(suppRowmaterlist);

        return rowmaterial;
    }

    /**
     *修改原材料数据
     * @param rowmaterial
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void updateRawmater(CateringTcbRowmaterial rowmaterial,Long accountId,Long projectId,Long projectRootId) {
        Integer rmId = rowmaterial.getRmId();
        String rmCode = rowmaterial.getRmCode();
        NativeSQLBuilder rowmaterialBuild = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("select * from catering_tcb_rowmaterial where is_delete=0 and project_id = " + projectId + " and rm_id= " + rmId + "");
        CateringTcbRowmaterial rowmaterialData = (CateringTcbRowmaterial)autoBaseDao.findOne(rowmaterialBuild);
        rowmaterialData.setRmGradeId(rowmaterial.getRmGradeId());
        rowmaterialData.setRmCode(rmCode);
        String spellCode = GetPell.getPinYinHeadChar(rowmaterial.getRmName());
        rowmaterialData.setSpellCode(spellCode);
        rowmaterialData.setRmName(rowmaterial.getRmName());
        rowmaterialData.setRmAbbreviate(rowmaterial.getRmAbbreviate());
        rowmaterialData.setRmClassCode(rowmaterial.getRmClassCode());
        rowmaterialData.setSellModel(rowmaterial.getSellModel());
        rowmaterialData.setRmUnit(rowmaterial.getRmUnit());
        rowmaterialData.setManufacturer(rowmaterial.getManufacturer());
        rowmaterialData.setExpirationDate(rowmaterial.getExpirationDate());
        rowmaterialData.setSaleTaxId(rowmaterial.getSaleTaxId());
        rowmaterialData.setPhTaxId(rowmaterial.getPhTaxId());
        rowmaterialData.setMaxWhCount(rowmaterial.getMaxWhCount());
        rowmaterialData.setSaleStatus(rowmaterial.getSaleStatus());
        rowmaterialData.setMinWhCount(rowmaterial.getMinWhCount());
        rowmaterialData.setDescription(rowmaterial.getDescription());
        rowmaterialData.setRemark(rowmaterial.getRemark());
        rowmaterialData.setIsCanSale(rowmaterial.getIsCanSale());
        rowmaterialData.setPredictPrice(rowmaterial.getPredictPrice());
        Integer cStatus = rowmaterial.getcStatus();
        rowmaterialData.setcStatus(cStatus);
        rowmaterialData.setSyncStatus(SyncStatus.NOT_SYNC);
        if (null!=rowmaterial.getSuppRowmaterList()) {
            rowmaterial.getSuppRowmaterList().forEach(x->{
                if(x.getIsDefault() == 1){
                    rowmaterialData.setPhTaxId(x.getPhTaxId());
                    rowmaterialData.setPhTax(x.getPhTax());
                }
            });
        }
        UpdateBuilder upRowmaterial = UpdateBuilder.build(CateringTcbRowmaterial.class).setBean(rowmaterialData).whereEq("project_id",projectId).whereEq("rm_id",rmId);
        if (autoBaseDao.update(upRowmaterial) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料信息失败！", null);
        }
        // 添加操作日志
        List<CateringTcbSaleRowmater> saleRowmaterList = rowmaterial.getSaleRowmaterList();
        saleRowmaterList.forEach(a->{
            String saleConTent = "";
            String isPurchaseUnit = a.getIsPurChaseUnit()== 1?"是":"否";
            if (a.getSaleType().equals(FlagTypeEnum.del.getName())) {  // 删除标识
                saleConTent = "删除原材料包装信息：原材料包装编号【" + a.getSrmCode() + "】，原材料包装含量【" + a.getPackContent() + "】，销售原材料单位【" + a.getSrmUnitName() + "】，原材料条码【" + a.getRmBarcode() + "】，原材料包装状态【" + a.getIsDeleteStr() + "】，是否采购单位【" + isPurchaseUnit + "】";
            } else if (a.getSaleType().equals(FlagTypeEnum.add.getName())) {
                saleConTent = "新增原材料包装信息：原材料包装编号【"+a.getSrmCode()+"】，原材料包装含量【"+a.getPackContent()+"】，销售原材料单位【"+a.getSrmUnitName()+"】，原材料条码【"+a.getRmBarcode()+"】，原材料包装状态【"+a.getIsDeleteStr()+"】，是否采购单位【" + isPurchaseUnit + "】";
            } else if (a.getSaleType().equals(FlagTypeEnum.update.getName())) {
                StringBuffer saleContentBuff =  new StringBuffer("编辑原材料包装信息:");
                NativeSQLBuilder oldSaleBuild = NativeSQLBuilder.build(CateringTcbSaleRowmater.class)
                        .setSql("select c.*," +
                                "\t (CASE WHEN c.is_in_out_spec = 1 then '是'   ELSE '否' END) as isInOutSpecStr,\n" +
                                "\t (CASE WHEN c.is_default = 1 then '是'   ELSE '否' END) as isDefaultStr,\n" +
                                "\t (CASE WHEN c.is_normal = 0 then '正常'   ELSE '淘汰' END) as isDeleteStr,\n" +
                                "\t (select type_name from  catecomm_tss_pubdatadict  where srm_status = type_code) as srmStatusStr,\n" +
                                "\t (select type_name from  catecomm_tss_pubdatadict  where srm_unit = type_code) as srmUnitName\n" +
                                "\t from catering_tcb_sale_rowmater c where  c.project_id = " + projectId + " and c.srm_id= " + a.getSrmId() + "");
                CateringTcbSaleRowmater oldSaleRowmater = (CateringTcbSaleRowmater)autoBaseDao.findOne(oldSaleBuild);
                String saleIsPurchaseUnit = oldSaleRowmater.getIsPurChaseUnit()== 1?"是":"否";
                saleContentBuff.append("修改前信息为：原材料包装编号【"+oldSaleRowmater.getSrmCode()+"】，原材料包装含量【"+oldSaleRowmater.getPackContent()+"】，销售原材料单位【"+oldSaleRowmater.getSrmUnitName()+"】，原材料条码【"+oldSaleRowmater.getRmBarcode()+"】，原材料包装状态【"+oldSaleRowmater.getIsDeleteStr()+"]，是否采购单位【" + saleIsPurchaseUnit + "】 --->");
                saleContentBuff.append("修改后信息为：原材料包装编号【"+a.getSrmCode()+"】，原材料包装含量【"+a.getPackContent()+"】，销售原材料单位【"+a.getSrmUnitName()+"】，原材料条码【"+a.getRmBarcode()+"】，原材料包装状态【"+a.getIsDeleteStr()+"】，是否采购单位【" + isPurchaseUnit + "】");
                saleConTent = saleContentBuff.toString();
            }
            if (!a.getSaleType().equals(FlagTypeEnum.no.getName())){
                if (this.saveBasicDataLog(projectId,rmId,20,BasicDataLogStatus.LOG_SALE,saleConTent,accountId) == 0){
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料包装操作日志失败！", null);
                }
            }
        });

        // 添加原材料供应商操作日志信息
        List<CateringTcbSuppRowmater> suppRowmaterList = rowmaterial.getSuppRowmaterList();
        suppRowmaterList.forEach(b->{
            String suppContent = "";
            if (b.getSuppType().equals(FlagTypeEnum.del.getName())) {  // 删除标识
                suppContent = "删除原材料合同信息：合同编号【"+b.getContractCode()+"】,合同名称【"+b.getContractName()+"】,供应商【"+b.getSuppName()+"】缺省供应商，采购含税进价【"+b.getPurchaseTaxPaid()+"】,采购未税进价【"+b.getPurchaseNoTaxPaid()+"】,含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，进项税率【"+b.getPhTax()+"】,送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】";
            }else if (b.getSuppType().equals(FlagTypeEnum.add.getName())) {
                if (b.getIsDefault() == 1) {
                    suppContent = "新增原材料合同信息：合同编号【"+b.getContractCode()+"】,合同名称【"+b.getContractName()+"】,供应商【"+b.getSuppName()+"】缺省供应商，采购含税进价【"+b.getPurchaseTaxPaid()+"】,采购未税进价【"+b.getPurchaseNoTaxPaid()+"】,含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，进项税率【"+b.getPhTax()+"】,送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】";
                } else {
                    suppContent  = "新增原材料合同信息：合同编号【"+b.getContractCode()+"】,合同名称【"+b.getContractName()+"】,供应商【"+b.getSuppName()+"】，采购含税进价【"+b.getPurchaseTaxPaid()+"】,采购未税进价【"+b.getPurchaseNoTaxPaid()+"】,含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，进项税率【"+b.getPhTax()+"】,送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】";
                }
            } else if (b.getSuppType().equals(FlagTypeEnum.update.getName())) {
                StringBuffer suppContentBuff =  new StringBuffer("编辑原材料合同信息:");
                NativeSQLBuilder oldSuppBuild = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                        .setSql("select c.*," +
                                "\t (CASE WHEN c.is_default = 1 then '是'   ELSE '否' END) as isDefaultStr,\n" +
                                "\t (CASE WHEN c.is_normal = 0 then '正常'   ELSE '淘汰' END) as isDeleteStr,\n" +
                                "\t (select supp.supp_name from  commodity_tcb_supplier supp where supp_id = c.supp_id and supp.project_id = c.project_id) as suppName,"+
                                "\t (select type_name from  catecomm_tss_pubdatadict  where c.srm_status = type_code) as srmStatusStr,\n" +
                                "\t (select dict_tp_value from  catecomm_tss_datadict  where c.delivery_type = dict_tp_code and c.project_id = project_id) as deliveryTypeStr\n" +
                                "\t from catering_tcb_supp_rowmater c where  c.project_id = " + projectId + " and c.sup_com_id= " + b.getSupComId() + "");
                CateringTcbSuppRowmater oldSuppRowmater = (CateringTcbSuppRowmater)autoBaseDao.findOne(oldSuppBuild);
                String isDefaulet = "";
                if (b.getIsDefault() == 1 && oldSuppRowmater.getIsDefault() == 0 || b.getIsDefault() == 0 && oldSuppRowmater.getIsDefault() == 1) {
                    isDefaulet = "缺省供应商";
                }
                suppContentBuff.append("修改前信息为：【"+b.getContractCode()+"】,合同名称【"+b.getContractName()+"】,供应商【"+oldSuppRowmater.getSuppName()+"】"+isDefaulet+"，采购含税进价【"+oldSuppRowmater.getPurchaseTaxPaid()+"】,采购未税进价【"+oldSuppRowmater.getPurchaseNoTaxPaid()+"】,含税进价【"+oldSuppRowmater.getTaxPaid()+"】，未税进价【"+oldSuppRowmater.getNoTaxPaid()+"】，预估含税成本价【"+oldSuppRowmater.getFuTaxCost()+"】，进项税率【"+oldSuppRowmater.getPhTax()+"】,送货类型【"+oldSuppRowmater.getDeliveryTypeStr()+"】，原材料供应商状态【"+oldSuppRowmater.getIsDeleteStr()+" --->");
                suppContentBuff.append("修改后信息为：【"+b.getContractCode()+"】,合同名称【"+b.getContractName()+"】,供应商【"+b.getSuppName()+"】"+isDefaulet+"，采购含税进价【"+b.getPurchaseTaxPaid()+"】,采购未税进价【"+b.getPurchaseNoTaxPaid()+"】,含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，进项税率【"+b.getPhTax()+"】,送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】");
                suppContent = suppContentBuff.toString();
            }
            if (!b.getSuppType().equals(FlagTypeEnum.no.getName())) {
                if (this.saveBasicDataLog(projectId,rmId,20,BasicDataLogStatus.LOG_SALE,suppContent,accountId) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料包装操作日志失败！", null);
                }
            }
        });
        // 重新添加原材料包装信息
        for (CateringTcbSaleRowmater a:saleRowmaterList) {
            Integer srmId = a.getSrmId();
            //新增或者修改
            if(a.getSaleType().equals(FlagTypeEnum.add.getName()) || a.getSaleType().equals(FlagTypeEnum.update.getName())){
                // 如果修改先删除原有包装信息
                if(a.getSaleType().equals(FlagTypeEnum.update.getName())){
                    //如果当前修改的单位是采购单位，将该原材料其它的单位全置为非采购单位
                    if(a.getIsPurChaseUnit() == 1){
                        NativeSQLBuilder<CateringTcbSaleRowmater> updateBuilder2 = NativeSQLBuilder.build(CateringTcbSaleRowmater.class)
                                .setSql(" UPDATE catering_tcb_sale_rowmater set is_pur_chase_unit = 0  where  project_id = " + projectId +
                                        " and rm_id= " + rowmaterial.getRmId());
                        autoBaseDao.nativeExecute(updateBuilder2);
                    }
                    DeleteBuilder deleteBuilder = DeleteBuilder.build("catering_tcb_sale_rowmater").whereEq("rm_id",rowmaterial.getRmId())
                            .whereEq("project_id",projectId).whereEq("srm_id",a.getSrmId());
                    autoBaseDao.delete(deleteBuilder);
                }else{
                    srmId = supplierService.getTableId(projectId, "catering_tcb_sale_rowmater", 1);
                }
                CateringTcbSaleRowmater saleRowmater = new CateringTcbSaleRowmater();
                //Integer srmId = supplierService.getTableId(projectId, "catering_tcb_sale_rowmater", 1);
                saleRowmater.setSrmId(srmId);
                if (StringUtils.isBlank(a.getRmBarcode())) {
                    //  调用存储过程生成条形码
                    Map<String, Object> barCodeMap = collarUseService.getBarCode(projectId, 20, srmId, 0, 0,2);
                    if ((boolean)barCodeMap.get("success") == true) {
                        String barCode = (String)barCodeMap.get("code");
                        saleRowmater.setRmBarcode(barCode);
                    }
                }else {
                    saleRowmater.setRmBarcode(a.getRmBarcode());
                }
                saleRowmater.setIsInOutSpec(a.getIsInOutSpec());
                saleRowmater.setProjectId(projectId);
                saleRowmater.setSrmCode(a.getSrmCode());
                saleRowmater.setRmId(rmId);
                saleRowmater.setRmCode(rmCode);
                saleRowmater.setPackContent(a.getPackContent());
                saleRowmater.setSrmUnit(a.getSrmUnit());
                saleRowmater.setIsDefault(a.getIsDefault());
                if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_ADD || cStatus == RawmaterStatus.RAWMATER_STATUS_AUDIT) {
                    saleRowmater.setSrmStatus(rowmaterial.getcStatus());
                } else if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_UP_SUBMIT) {
                    if(a.getSaleType().equals(FlagTypeEnum.add.getName())){
                        saleRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
                    }else if (a.getSaleType().equals(FlagTypeEnum.update.getName())){
                        saleRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_AUDIT);
                    } else {
                        saleRowmater.setSrmStatus(a.getSrmStatus());
                    }
                } else if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_UP_AUDIT) {
                    if (a.getSaleType().equals(FlagTypeEnum.add.getName()) || a.getSaleType().equals(FlagTypeEnum.update.getName()))
                        saleRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_AUDIT);
                    else
                        saleRowmater.setSrmStatus(a.getSrmStatus());
                }
                saleRowmater.setIsDelete(a.getIsDelete());
                saleRowmater.setIsNormal(a.getIsNormal());
                saleRowmater.setModifier(accountId);
                saleRowmater.setCreater(accountId);
                saleRowmater.setIsPurChaseUnit(a.getIsPurChaseUnit());
                if (autoBaseDao.save(saleRowmater) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SALEROWMATER +  "编辑-添加原材料包装信息失败！", null);
                }
            }else if(a.getSaleType().equals(FlagTypeEnum.del.getName())){
                DeleteBuilder deleteBuilder = DeleteBuilder.build("catering_tcb_sale_rowmater").whereEq("rm_id",rowmaterial.getRmId())
                        .whereEq("project_id",projectId).whereEq("srm_id",a.getSrmId());
                autoBaseDao.delete(deleteBuilder);
            }
        }

        //新增编辑原材料供应商信息
        addOrUpdateSuppRowmater(suppRowmaterList,rowmaterial,projectId,accountId);
    }


    private void addOrUpdateSuppRowmater(List<CateringTcbSuppRowmater> suppRowmaterList,CateringTcbRowmaterial rowmaterial,Long projectId,Long accountId) {
        Integer cStatus = rowmaterial.getcStatus();
        for (CateringTcbSuppRowmater b : suppRowmaterList) {
            //新增或者修改
            if(b.getSuppType().equals(FlagTypeEnum.add.getName()) || b.getSuppType().equals(FlagTypeEnum.update.getName())){
                Integer supComId = b.getSupComId();
                // 如果修改先删除原有供应商信息
                if(b.getSuppType().equals(FlagTypeEnum.update.getName())){
                    // 删除原有原材料供应商信息
                    DeleteBuilder deleteBuild1 = DeleteBuilder.build("catering_tcb_supp_rowmater").whereEq("rm_id",rowmaterial.getRmId())
                            .whereEq("project_id",projectId).whereEq("sup_com_id",b.getSupComId());
                    autoBaseDao.delete(deleteBuild1);
                }else{
                    supComId = supplierService.getTableId(projectId, "catering_tcb_supp_rowmater", 1);
                }
                CateringTcbSuppRowmater suppRowmater = new CateringTcbSuppRowmater();
                suppRowmater.setSupComId(supComId);
                suppRowmater.setSupComCode(String.valueOf(supComId));
                suppRowmater.setProjectId(projectId);
                suppRowmater.setRmCode(rowmaterial.getRmCode());
                suppRowmater.setRmId(rowmaterial.getRmId());
                BigDecimal taxPaid = b.getTaxPaid();
                BigDecimal noTaxPaid = b.getNoTaxPaid();
                suppRowmater.setTaxPaid(taxPaid);
                suppRowmater.setOldTaxPaid(taxPaid);
                suppRowmater.setOldNoTaxPaid(noTaxPaid);
                suppRowmater.setPurchaseTaxPaid(b.getPurchaseTaxPaid());
                suppRowmater.setOldPurchaseTaxPaid(b.getPurchaseTaxPaid());
                suppRowmater.setPurchaseNoTaxPaid(b.getPurchaseNoTaxPaid());
                suppRowmater.setOldPurchaseNoTaxPaid(b.getPurchaseNoTaxPaid());
                suppRowmater.setContractId(b.getContractId());
                suppRowmater.setContractCode(b.getContractCode());
                suppRowmater.setContractName(b.getContractName());
                suppRowmater.setPhTax(b.getPhTax());
                suppRowmater.setPhTaxId(b.getPhTaxId());
                suppRowmater.setNoTaxPaid(b.getNoTaxPaid());
                suppRowmater.setFuTaxCost(b.getFuTaxCost());
                suppRowmater.setIsDefault(b.getIsDefault());
                suppRowmater.setSuppId(b.getSuppId());
                suppRowmater.setRmName(rowmaterial.getRmName());
                suppRowmater.setDeliveryType(b.getDeliveryType());
                suppRowmater.setSupComCode(b.getSupComCode());
                if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_ADD || cStatus == RawmaterStatus.RAWMATER_STATUS_AUDIT) {
                    suppRowmater.setSrmStatus(rowmaterial.getcStatus());
                } else if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_UP_SUBMIT) {
                    if(b.getSuppType().equals(FlagTypeEnum.add.getName())){
                        suppRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
                    }else if (b.getSuppType().equals(FlagTypeEnum.update.getName())){
                        suppRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_AUDIT);
                    } else {
                        suppRowmater.setSrmStatus(b.getSrmStatus());
                    }
                } else if (cStatus ==  RawmaterStatus.RAWMATER_STATUS_UP_AUDIT) {
                    if (b.getSuppType().equals(FlagTypeEnum.add.getName()) || b.getSuppType().equals(FlagTypeEnum.update.getName()))
                        suppRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_AUDIT);
                    else
                        suppRowmater.setSrmStatus(b.getSrmStatus());
                }
                suppRowmater.setIsDelete(b.getIsDelete());
                suppRowmater.setIsNormal(b.getIsNormal());
                suppRowmater.setCreater(accountId);
                suppRowmater.setModifier(accountId);
                if (autoBaseDao.save(suppRowmater) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "编辑-添加原材料供应商信息失败！", null);
                }
            }else if(b.getSuppType().equals(FlagTypeEnum.del.getName())){
                // 删除原有原材料供应商信息
                DeleteBuilder deleteBuild1 = DeleteBuilder.build("catering_tcb_supp_rowmater").whereEq("rm_id",rowmaterial.getRmId())
                        .whereEq("project_id",projectId).whereEq("sup_com_id",b.getSupComId());
                autoBaseDao.delete(deleteBuild1);
            }

        }
    }

    /**
     * 添加原材料数据
     * @param rowmaterial
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void saveRawmater(CateringTcbRowmaterial rowmaterial,Long accountId,Long projectId,Long projectRootId) {
        /**原材料信息**/
        CateringTcbRowmaterial rowmaterialTemp = new CateringTcbRowmaterial();
        String rmCode = rowmaterial.getRmCode();
        Integer rmId = null;
        try {
            BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
            ConvertUtils.register(new DateConverter(null), Date.class);
            BeanUtils.copyProperties(rowmaterialTemp, rowmaterial);
            rmId = supplierService.getTableId(projectId,"catering_tcb_rowmaterial", 1);
            rowmaterialTemp.setRmId(rmId);
            String spellCode = GetPell.getPinYinHeadChar(rowmaterial.getRmName());
            rowmaterialTemp.setRmGradeId(rowmaterial.getRmGradeId());
            rowmaterialTemp.setSpellCode(spellCode);
            rowmaterialTemp.setRmCode(rmCode);
            rowmaterialTemp.setCreater(accountId);
            rowmaterialTemp.setModifier(accountId);
            rowmaterialTemp.setProjectId(projectId);
            rowmaterialTemp.setProjectRootId(projectRootId);
            rowmaterialTemp.setSyncStatus(SyncStatus.NOT_SYNC);
            if (null!=rowmaterial.getSuppRowmaterList()) {
                rowmaterial.getSuppRowmaterList().forEach(x->{
                    if(x.getIsDefault() == 1){
                        rowmaterialTemp.setPhTaxId(x.getPhTaxId());
                        rowmaterialTemp.setPhTax(x.getPhTax());
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (autoBaseDao.save(rowmaterialTemp) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料信息失败！", null);
        }
        // 产生日志数据
        String content = "";
        if (rowmaterial.getcStatus() == 11501) {
            content = "新增原材料，原材料编号【"+rmCode+"】";
        } else if(rowmaterial.getcStatus() == 11502) {
            content = "提交原材料，原材料编号【"+rmCode+"】";
        }
        if (this.saveBasicDataLog(projectId,rmId,20,BasicDataLogStatus.LOG_INFO,content,accountId) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料信息操作日志失败！", null);
        }
        // 原材料包装信息
        List<CateringTcbSaleRowmater> saleRowmaterList = rowmaterial.getSaleRowmaterList();
        for (CateringTcbSaleRowmater a:saleRowmaterList) {
            CateringTcbSaleRowmater saleRowmater = new CateringTcbSaleRowmater();
            Integer  srmId = null;
            try {
                srmId = supplierService.getTableId(projectId,"catering_tcb_sale_rowmater", 1);
                saleRowmater.setSrmId(srmId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (StringUtils.isBlank(a.getRmBarcode())) {
                //  调用存储过程生成条形码
                Map<String, Object> barCodeMap = collarUseService.getBarCode(projectId, 20, srmId, 0, 0,2);
                if ((boolean)barCodeMap.get("success") == true) {
                    String barCode = (String)barCodeMap.get("code");
                    saleRowmater.setRmBarcode(barCode);
                }
            }else {
                saleRowmater.setRmBarcode(a.getRmBarcode());
            }
            saleRowmater.setIsInOutSpec(a.getIsInOutSpec());
            saleRowmater.setProjectId(projectId);
            saleRowmater.setSrmCode(a.getSrmCode());
            saleRowmater.setRmId(rmId);
            saleRowmater.setRmCode(rmCode);
            saleRowmater.setPackContent(a.getPackContent());
            saleRowmater.setSrmUnit(a.getSrmUnit());
            saleRowmater.setIsDefault(a.getIsDefault());
            saleRowmater.setModifier(accountId);
            saleRowmater.setCreater(accountId);
            saleRowmater.setSrmStatus(rowmaterial.getcStatus());
            saleRowmater.setIsPurChaseUnit(a.getIsPurChaseUnit());
            saleRowmater.setIsDelete(a.getIsDelete());
            saleRowmater.setIsNormal(a.getIsNormal());
            if (autoBaseDao.save(saleRowmater) == 0) {
                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SALEROWMATER +  "添加原材料包装信息失败！", null);
            }
            // 产生日志数据
            String saleContent = "新增原材料包装信息：原材料包装编号【"+a.getSrmCode()+"】，原材料包装含量【"+a.getPackContent()+"】，销售原材料单位【"+a.getSrmUnitName()+"】，原材料条码【"+a.getRmBarcode()+"】，原材料包装状态【"+a.getIsDeleteStr()+"】";
            if (a.getSaleType() != null) {
                if (this.saveBasicDataLog(projectId,srmId,20,BasicDataLogStatus.LOG_SALE,saleContent,accountId) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料包装操作日志失败！", null);
                }
            }
        }
        // 原材料供应商信息
        List<CateringTcbSuppRowmater> suppRowmaterList = rowmaterial.getSuppRowmaterList();
        for (CateringTcbSuppRowmater b:suppRowmaterList) {
            CateringTcbSuppRowmater  suppRowmater = new CateringTcbSuppRowmater();
            Integer  supComId = null;
            try {
                supComId = supplierService.getTableId(projectId,"catering_tcb_supp_rowmater", 1);
                suppRowmater.setSupComId(supComId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            suppRowmater.setSupComCode(String.valueOf(supComId));
            suppRowmater.setProjectId(projectId);
            suppRowmater.setRmCode(rmCode);
            suppRowmater.setRmId(rmId);
            BigDecimal taxPaid = b.getTaxPaid();
            BigDecimal noTaxPaid = b.getNoTaxPaid();
            suppRowmater.setTaxPaid(taxPaid);
            suppRowmater.setOldTaxPaid(taxPaid);
            suppRowmater.setNoTaxPaid(noTaxPaid);
            suppRowmater.setOldNoTaxPaid(noTaxPaid);
            suppRowmater.setPurchaseTaxPaid(b.getPurchaseTaxPaid());
            suppRowmater.setOldPurchaseTaxPaid(b.getPurchaseTaxPaid());
            suppRowmater.setPurchaseNoTaxPaid(b.getPurchaseNoTaxPaid());
            suppRowmater.setOldPurchaseNoTaxPaid(b.getPurchaseNoTaxPaid());
            suppRowmater.setContractId(b.getContractId());
            suppRowmater.setContractCode(b.getContractCode());
            suppRowmater.setContractName(b.getContractName());
            suppRowmater.setPhTax(b.getPhTax());
            suppRowmater.setPhTaxId(b.getPhTaxId());
            suppRowmater.setFuTaxCost(b.getFuTaxCost());
            suppRowmater.setIsDefault(b.getIsDefault());
            suppRowmater.setSuppId(b.getSuppId());
            suppRowmater.setRmName(rowmaterial.getRmName());
            suppRowmater.setCreater(accountId);
            suppRowmater.setModifier(accountId);
            suppRowmater.setDeliveryType(b.getDeliveryType());
            suppRowmater.setSrmStatus(rowmaterial.getcStatus());
            suppRowmater.setIsDelete(b.getIsDelete());
            suppRowmater.setIsNormal(b.getIsNormal());
            if ( autoBaseDao.save(suppRowmater) == 0) {
                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER +  "添加原材料供应商信息失败！", null);
            }

            // 产生日志数据
            String suppContent = "";
            if (b.getIsDefault() == 1) {
                suppContent = "新增原材料供应商信息：供应商【"+b.getSuppName()+"】缺省供应商，含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】";
            } else {
                suppContent  = "新增原材料供应商信息：供应商【"+b.getSuppName()+"】，含税进价【"+b.getTaxPaid()+"】，未税进价【"+b.getNoTaxPaid()+"】，预估含税成本价【"+b.getFuTaxCost()+"】，送货类型【"+b.getDeliveryTypeStr()+"】，原材料供应商状态【"+b.getIsDeleteStr()+"】";
            }
            if (b.getSuppType() != null) {
                if (this.saveBasicDataLog(projectId,supComId,20,BasicDataLogStatus.LOG_SUPP,suppContent,accountId) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料供应商操作日志失败！", null);
                }
            }

        }
    }

    /**
     *（修改信息中）删除原材料包装信息
     * @param srmId
     */
    @Override
    public void delSaleRowmater(Integer srmId,Long accountId,Long projectId) {
        QueryBuilder<CateringTcbSaleRowmater> queryBuilder = QueryBuilder.build(CateringTcbSaleRowmater.class)
                .whereEq("srm_id",srmId).whereEq("project_id",projectId);
        CateringTcbSaleRowmater saleRowmate = autoBaseDao.findOne(queryBuilder);
        saleRowmate.setIsDelete(1);
        saleRowmate.setModifier(accountId);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbSaleRowmater.class).setBean(saleRowmate).whereEq("srm_id",srmId).whereEq("project_id",projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER +  "删除原材料包装信息失败！", null);
        }
    }

    /**
     * （修改信息中）删除原材料供应商信息
     * @param supComId
     */
    @Override
    public void delSuppRowmater(Integer supComId,Long accountId,Long projectId) {
        QueryBuilder<CateringTcbSuppRowmater> queryBuilder = QueryBuilder.build(CateringTcbSuppRowmater.class)
                .whereEq("sup_com_id",supComId).whereEq("project_id", projectId);
        CateringTcbSuppRowmater suppRowmate = autoBaseDao.findOne(queryBuilder);
        suppRowmate.setIsDelete(1);
        suppRowmate.setModifier(accountId);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbSuppRowmater.class).setBean(suppRowmate).whereEq("sup_com_id",supComId).whereEq("project_id",projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER +  "删除原材料供应商信息失败！", null);
        }
    }

    /**
     * 查询原材料等级管理
     * @param rmGradeId
     * @return
     */
    @Override
    public List<CatecommTssDatadictModel> getRawmaterGradDict(Integer rmGradeId,Long projectId) {
        NativeSQLBuilder<CatecommTssDatadictModel> dictBuild = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                .setSql("select * from catecomm_tss_datadict where dd_status = 1 and project_id="+projectId);
        dictBuild.append(" and dic_type ="+108+"");

        if(rmGradeId != null){
            dictBuild.append(" and dict_tp_code ="+rmGradeId+"");
        }
        return autoBaseDao.listAll(dictBuild);
    }

    /**
     * 查询所有的原材料等级管理不排除禁用的
     * @param rmGradeId
     * @return
     */
    private List<CatecommTssDatadictModel> getAllRawmaterGradDict(Integer rmGradeId,Long projectId) {
        NativeSQLBuilder<CatecommTssDatadictModel> dictBuild = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                .setSql("select * from catecomm_tss_datadict where project_id="+projectId);
        dictBuild.append(" and dic_type ="+108+"");

        if(rmGradeId != null){
            dictBuild.append(" and dict_tp_code ="+rmGradeId+"");
        }
        return autoBaseDao.listAll(dictBuild);
    }


    /*
     *  封装共用（新增-编辑原材料等级）
     */
    @Override
    public void addOrUpdateRawmaterGradDict(CatecommTssDatadictModel catecommTssDatadictModel,Long accountId,Long projectId) {
        catecommTssDatadictModel.setModifier(accountId);
        Integer dictId = catecommTssDatadictModel.getDictId();
        if (null == dictId) {
            catecommTssDatadictModel.setCreater(accountId);
            catecommTssDatadictModel.setProjectId(projectId);
            catecommTssDatadictModel.setDictId(supplierService.getTableId(projectId, "catecomm_tss_datadict", 1));
            catecommTssDatadictModel.setUdictId(1);
            catecommTssDatadictModel.setDicType("108");
            catecommTssDatadictModel.setDictName("原材料等级");
            List<CatecommTssDatadictModel> catecommTssDatadictLst = getAllRawmaterGradDict(null,projectId);
            catecommTssDatadictLst.sort(Comparator.comparing(CatecommTssDatadictModel::getDictTpCode));
            int size = catecommTssDatadictLst.size();
            Integer dictTpCode = null;
            if (size > 0) {
                dictTpCode = catecommTssDatadictLst.get(size - 1).getDictTpCode() + 1;
            } else {
                dictTpCode = 10801;
            }
            catecommTssDatadictModel.setDictTpCode(dictTpCode);
            catecommTssDatadictModel.setDictSort((short) 0);
            catecommTssDatadictModel.setState("这是描述字段");
            catecommTssDatadictModel.setRemark("原材料等级维护");
            catecommTssDatadictModel.setDdStatus((short) 1);
            InsertBuilder<CatecommTssDatadictModel> insertBuilder = InsertBuilder.build(catecommTssDatadictModel).optSql();
            autoBaseDao.save(insertBuilder);
        } else {
            catecommTssDatadictModel.setSyncStatus(SyncStatus.NOT_SYNC);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CatecommTssDatadictModel.class).setBean(catecommTssDatadictModel).whereEq("dict_id", dictId).whereEq("project_id",projectId);
            autoBaseDao.update(updateBuilder);
        }
    }

    /**
     * 原材料分类编号生成
     * @param urmcId
     * @return
     */
    @Override
    public String getRawmaterClassCode(Integer urmcId,Long projectId) {
        if (urmcId != 0) {
            NativeSQLBuilder rawmaterClassBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                    .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = " + urmcId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "\tORDER BY cast(rmc_code as SIGNED INTEGER) desc LIMIT 1" );
            CateringTccRawmaterClass rawmaterClass = (CateringTccRawmaterClass)autoBaseDao.findOne(rawmaterClassBuild);
            if (null == rawmaterClass) {
                NativeSQLBuilder supplierFClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                        .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE project_id = " + projectId + "\n" +
                                "and rmc_id = " + urmcId);
                CateringTccRawmaterClass suppFClass = (CateringTccRawmaterClass) autoBaseDao.findOne(supplierFClass);
                return suppFClass.getRmcCode() + "01";

            } else {
                String code = rawmaterClass.getRmcCode().substring(rawmaterClass.getRmcCode().length() -2);
                Integer classCode = Integer.parseInt(code) + 1;
                if (classCode > 9) {
                    return  rawmaterClass.getUrmcCode() + classCode;
                }
                return rawmaterClass.getUrmcCode() + "0" + classCode.toString();
            }
        } else {
            NativeSQLBuilder rawmaterClassBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                    .setSql("SELECT * FROM catering_tcc_rawmater_class WHERE urmc_id = " + urmcId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "\tORDER BY rmc_code DESC LIMIT 1" );
            CateringTccRawmaterClass rawmaterClass = (CateringTccRawmaterClass)autoBaseDao.findOne(rawmaterClassBuild);
            if (null == rawmaterClass) {
                return "01";
            } else {
                if (0 == urmcId) {
                    Integer code = Integer.valueOf(rawmaterClass.getRmcCode()) + 1;
                    if (code > 9) {
                        return code.toString();
                    }
                    return "0" + code.toString();
                }
                return rawmaterClass.getRmcCode() + "01";
            }

        }


    }

    @Override
    public int saveBasicDataLog(Long projectId,Integer infoId, Integer dataType, Integer logType,  String Content, Long accountId) {
        // 产生日志数据
        BasicDataLog log = new BasicDataLog();
        log.setProjectId(projectId);
        log.setLogId(supplierService.getTableId(projectId,"basic_data_log", 1));
        log.setInfoId(infoId);
        log.setDataType(dataType);
        log.setLogTyoe(logType);
        log.setContent(Content);
        log.setCreater(accountId);
        return autoBaseDao.save(log);
    }

    /**
     * 原材料信息导出
     * @param rmId
     * @return
     */
    @Override
    public List<RawmaterVo> getRawmaterList(String rmId) {
        List<RawmaterVo> rawmaterVoList = null;
        if (StringUtils.isBlank(rmId)) {
            throw new RpcException(300,ErrorCode.PRODUCT_NAME_REPEAT +  "请选择所需要导出的数据", null);
        }
        NativeSQLBuilder select = NativeSQLBuilder.build(RawmaterVo.class)
                .setSql("select t1.*,(select t2.rmc_name from catering_tcc_rawmater_class t2 where t1.rm_class_code = t2.rmc_code) as rmcName\n" +
                        "\t(select t3.dict_tp_value from catecomm_tss_datadict t3 where t3.dict_tp_code = t1.rm_grade_id) as rmGradeStr\n " +
                        "\t(select t4.tax_name from catecomm_tsb_tax t4 where t4.tax_id = t1.ph_tax_Id) as phTaxName\n " +
                        "\t(select t5.type_name from catecomm_tss_pubdatadict t5 where t1.rm_unit = t5.type_code and t5.p_dict_status = 1) as rmUnitStr\n" +
                        "\tfrom catering_tcb_rowmaterial t1\n" +
                        "\twhere t1.is_delete=0  and t1.rm_id IN( " + rmId + ")");
        return autoBaseDao.listAll(select);
    }


    /**
     * 原材料审核
     * @param rmId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void toExamineRawmater(String rmId,Integer cStatus,Long accountId,Long projectId) {
        String[] rmIds=rmId.split(",");
        for (int i=0;i<rmIds.length;i++) {
            NativeSQLBuilder select = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                    .setSql("select * from catering_tcb_rowmaterial where is_delete=0 and project_id = "+projectId+" and rm_id= " + rmIds[i] + "");
            CateringTcbRowmaterial rowmaterial = (CateringTcbRowmaterial)autoBaseDao.findOne(select);
            if (rowmaterial != null) {
                rowmaterial.setModifier(accountId);
                rowmaterial.setcStatus(cStatus);
                UpdateBuilder rowmanterBuild = UpdateBuilder.build(CateringTcbRowmaterial.class).setBean(rowmaterial)
                        .whereEq("rmId", rmIds[i]).whereEq("projectId", projectId);
                if (autoBaseDao.update(rowmanterBuild) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "审核原材料失败", null);
                }
            }
            NativeSQLBuilder saleBuild = NativeSQLBuilder.build(CateringTcbSaleRowmater.class)
                    .setSql("select t1.srm_id,t1.srm_status from catering_tcb_sale_rowmater t1 where t1.project_id = "+projectId+" and t1.rm_id = "+rmIds[i]);
            List<CateringTcbSaleRowmater> saleList = autoBaseDao.listAll(saleBuild);
            NativeSQLBuilder suppBuild = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                    .setSql("select t1.sup_com_id,t1.srm_status from catering_tcb_supp_rowmater t1 where t1.project_id = "+projectId+"  and t1.rm_id = "+rmIds[i]);
            List<CateringTcbSuppRowmater> suppList = autoBaseDao.listAll(suppBuild);
            // 添加操作日志
            String content = "";
            if (cStatus == RawmaterStatus.RAWMATER_STATUS_REJECT) {
                saleList.forEach(sale->{
                    if (sale.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("srm_id",sale.getSrmId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料包装状态失败！", null);
                        };
                    }
                });
                suppList.forEach(supp->{
                    if (supp.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("sup_com_id",supp.getSupComId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料供应商状态失败！", null);
                        };
                    }
                });
                content = "审核驳回操作，原材料编号【"+rowmaterial.getRmCode()+"】";
            } else if(cStatus == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                        .set("srm_status",RawmaterStatus.RAWMATER_STATUS_AUDIT).whereEq("rm_id",rmIds[i]).whereEq("project_id",projectId);
                if (autoBaseDao.update(saleUpBuild) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE + "修改原材料包装状态为待审核失败！", null);
                }
                UpdateBuilder suppUpBuild = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                        .set("srm_status",RawmaterStatus.RAWMATER_STATUS_AUDIT).whereEq("rm_id",rmIds[i]).whereEq("project_id",projectId);
                if (autoBaseDao.update(suppUpBuild) == 0) {
                    throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE + "修改原材料供应商状态为待审核失败！", null);
                }
                content = "提交原材料操作，原材料编号【"+rowmaterial.getRmCode()+"】";
            } else if(cStatus == RawmaterStatus.RAWMATER_STATUS_ADOPT){
                saleList.forEach(sale->{
                    if (sale.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_ADOPT).whereEq("srm_id",sale.getSrmId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料包装状态核通过失败！", null);
                        };
                    }
                });
                suppList.forEach(supp->{
                    if (supp.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_ADOPT).whereEq("sup_com_id",supp.getSupComId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料供应商状态审核通过失败！", null);
                        };
                    }
                });
                content = "审核通过操作，原材料编号【"+rowmaterial.getRmCode()+"】";
            }else if(cStatus == RawmaterStatus.RAWMATER_STATUS_UP_AUDIT){
                saleList.forEach(sale->{
                    if (sale.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_ADD || sale.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_REJECT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_AUDIT).whereEq("srm_id",sale.getSrmId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料包装状态修改待审核失败！", null);
                        };
                    }
                });
                suppList.forEach(supp->{
                    if (supp.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_ADD || supp.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_REJECT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_AUDIT).whereEq("sup_com_id",supp.getSupComId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料供应商状态修改待审核失败！", null);
                        };
                    }
                });
                content = "修改待审核操作，原材料编号【"+rowmaterial.getRmCode()+"】";
            }else if(cStatus == RawmaterStatus.RAWMATER_STATUS_UP_REJECT){
                saleList.forEach(sale->{
                    if (sale.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("srm_id",sale.getSrmId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料包装状态修改被驳回失败！", null);
                        };
                    }
                });
                suppList.forEach(supp->{
                    if (supp.getSrmStatus() == RawmaterStatus.RAWMATER_STATUS_AUDIT){
                        UpdateBuilder saleUpBuild = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("sup_com_id",supp.getSupComId()).whereEq("project_id",projectId);
                        if (autoBaseDao.update(saleUpBuild) == 0){
                            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "修改原材料供应商状态修改被驳回失败！", null);
                        };
                    }
                });
                content = "修改被驳回操作，原材料编号【"+rowmaterial.getRmCode()+"】";
            }
            if (this.saveBasicDataLog(projectId,rowmaterial.getRmId(),20,BasicDataLogStatus.LOG_INFO,content,accountId)== 0) {
                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料操作日志失败！", null);
            }
        }

    }

    /**
     *@Description 原材料名称唯一性判断
     *@param
     *@return
     *@date 2019-09-09 16:24
     *@auther wangwenbin
     */
    @Override
    public boolean rmNameOnlyJudge(String rmName,Long projectId) {
        NativeSQLBuilder rawmaterial = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("SELECT * FROM catering_tcb_rowmaterial  WHERE rm_name = #{rmName} and project_id = #{projectId} and is_delete=0" );
        rawmaterial.setValue("rmName",rmName);
        rawmaterial.setValue("projectId",projectId);
        List<CateringTcbRowmaterial> list = autoBaseDao.listAll(rawmaterial);
        if (CollectionUtils.isNotEmpty(list)) {
            return Boolean.FALSE;
        }else {
            return Boolean.TRUE;
        }
    }


    /**
     *@Description 原材料编号唯一性判断
     *@param
     *@return
     *@date 2019-09-09 16:24
     *@auther wangwenbin
     */
    @Override
    public void rmCodeOnlyJudge(String rmCode,Long projectId) {
        NativeSQLBuilder rawmaterial = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("SELECT * FROM catering_tcb_rowmaterial  WHERE rm_code = #{rmCode} and project_id = #{projectId} and is_delete=0" );
        rawmaterial.setValue("rmCode",rmCode);
        rawmaterial.setValue("projectId",projectId);
        List<CateringTcbRowmaterial> list = autoBaseDao.listAll(rawmaterial);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new RpcException(300,ErrorCode.PRODUCT_NAME_REPEAT +  "原材料编号已存在，请保证唯一", null);
        }

    }

    /**
     *@Description 查询是否有子级分类
     *@param
     *@return
     *@date 2019-09-08 12:56
     *@auther wangwenbin
     */
    @Override
    public List<CateringTccRawmaterClass> queryRawmaterClassByRmcId(Integer rmcId, Long projectId) {
        NativeSQLBuilder rawmaterClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE urmc_id = #{urmcId} and is_delete=0 and project_id = #{projectId}" );
        rawmaterClass.setValue("urmcId",rmcId);
        rawmaterClass.setValue("projectId",projectId);
        return autoBaseDao.listAll(rawmaterClass);
    }

    /**
     *@Description 查询全部分类
     *@param
     *@return
     *@date 2019-09-08 13:01
     *@auther wangwenbin
     */
    @Override
    public List<CateringTccRawmaterClass> listAllRawmaterClass(Long projectId) {
        NativeSQLBuilder rawmaterClass = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("SELECT * FROM catering_tcc_rawmater_class  WHERE is_delete=0 and project_id = "+projectId );
        return autoBaseDao.listAll(rawmaterClass);
    }

    /**
     *@Description 查询字典表全部原材料单位
     *@param
     *@return
     *@date 2019-09-08 13:40
     *@auther wangwenbin
     */
    @Override
    public List<CatecommTssPubdatadictModel> queryRmUnit(Integer pDictType) {
        NativeSQLBuilder pubdatadict = NativeSQLBuilder.build(CatecommTssPubdatadictModel.class)
                .setSql("SELECT * FROM catecomm_tss_pubdatadict  WHERE p_dict_type = "+pDictType+" and p_dict_status=1" );
        return autoBaseDao.listAll(pubdatadict);
    }


    /**
     *@Description 获取税率信息
     *@param
     *@return
     *@date 2019-09-08 13:57
     *@auther wangwenbin
     */
    @Override
    public List<CatecommTsbTax> getCatecommTsbTax(Integer taxId,Long projectId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CatecommTsbTax.class)
                .setSql("select t1.* from catecomm_tsb_tax t1  where t1.is_delete = 0 and t1.t_status = 0\n" +
                        "\tand t1.project_id = "+projectId);
        if(taxId != null){
            tsbTaxBuild.append(" and t1.`tax_id` ="+taxId+"");
        }
        return autoBaseDao.listAll(tsbTaxBuild);
    }

    @Override
    public CateringTccRawmaterClass getRawmaterClass(Integer rmcId,String rmcCode,Long projectId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CateringTccRawmaterClass.class)
                .setSql("select t1.* from catering_tcc_rawmater_class t1  where t1.is_delete = 0 and t1.project_id = #{projectId}");
        tsbTaxBuild.setValue("projectId",projectId);
        if (rmcId != null) {
            tsbTaxBuild.append(" and t1.`rmc_id`=" + rmcId + "");
        }
        if (StringUtils.isNotBlank(rmcCode)) {
            tsbTaxBuild.append(" and t1.`rmc_code`=" + rmcCode + "");
        }

        return (CateringTccRawmaterClass) autoBaseDao.findOne(tsbTaxBuild);
    }

    @Override
    public CateringTcbSaleRowmater getSaleRowmater(Long projectId, Integer rmId) {
        NativeSQLBuilder rmBuildSql = NativeSQLBuilder.build(CateringTcbSaleRowmater.class)
                .setSql("select * from catering_tcb_sale_rowmater where rm_id = "+rmId+
                        "\tand is_default = 1 and project_id = "+projectId+
                        "\t and is_delete = 0");
        return (CateringTcbSaleRowmater)autoBaseDao.findOne(rmBuildSql);
    }




    @Override
    public List<CateringWhInDtl> getWhinDataBySrmId(Long projectId, Integer sRmId) {
        NativeSQLBuilder<CateringWhInDtl> builder = NativeSQLBuilder.build(CateringWhInDtl.class)
                .setSql("select t2.* from catering_wh_in t1 INNER JOIN " +
                        "\t catering_wh_in_dtl t2 on t1.whin_bill_id = t2.whin_bill_id and t1.project_id = t2.project_id " +
                        "\t where t1.is_delete = 0 AND t2.p_srm_id ="+sRmId+
                        "\t AND t1.project_id = "+projectId);
        return autoBaseDao.listAll(builder);
    }


    @Override
    @Transactional(rollbackFor=Exception.class)
    public RawmaterResponse importRawmater(List<RawmaterExeclMessage> rawmaterExeclList, Long projectId, Long projectRootId, Long accountId){
        int num = 0;
        RawmaterResponse response = new RawmaterResponse();
        List<CateringTcbRowmaterial> rowmaterialList = new ArrayList<>();
        List<CateringTcbSaleRowmater> saleRowmaterList = new ArrayList<>();
        List<CateringTcbSuppRowmater> suppRowmaterList = new ArrayList<>();
        for (RawmaterExeclMessage item : rawmaterExeclList) {
            CateringTcbRowmaterial rowmaterial = new CateringTcbRowmaterial();

            rowmaterial.setRmClassCode(item.getRmClassCode());

            /**原材料名称&&拼音编码**/
            String rmName = item.getRmName();
            rowmaterial.setSpellCode(GetPell.getPinYinHeadChar(rmName));
            rowmaterial.setRmName(rmName);
            rowmaterial.setRmAbbreviate(item.getRmAbbreviate());

            /**原材料简称**/
            String rmAbbreviate = item.getRmAbbreviate();
            rowmaterial.setRmAbbreviate(rmAbbreviate);
            /**原材料类型**/
            String specRmType = item.getSpecRmType();
            if (specRmType.equals("specRmType2")){
                rowmaterial.setSpecRmType2((byte)1);
            }else if(specRmType.equals("specRmType3")) {
                rowmaterial.setSpecRmType3((byte)1);
            }else if(specRmType.equals("specRmType4")) {
                rowmaterial.setSpecRmType4((byte)1);
            }else if(specRmType.equals("specRmType5")) {
                rowmaterial.setSpecRmType5((byte)1);
            }else if(specRmType.equals("specRmType6")) {
                rowmaterial.setSpecRmType6((byte)1);
            }else if(specRmType.equals("specRmType7")) {
                rowmaterial.setSpecRmType7((byte)1);
            }else if(specRmType.equals("specRmType8")) {
                rowmaterial.setSpecRmType8((byte)1);
            }else{
                rowmaterial.setSpecRmType((byte)1);
            }

            /**是否可售**/
            if (item.getIsCanSale().equals("是")) {
                rowmaterial.setIsCanSale(1);
                rowmaterial.setPredictPrice(item.getPredictPrice());
            }else{
                rowmaterial.setIsCanSale(0);
                rowmaterial.setPredictPrice(BigDecimal.ZERO);
            }

            /**原材料规格**/
            String sellModel = item.getSellModel();
            rowmaterial.setSellModel(sellModel);

            /**原材料单位**/
            rowmaterial.setRmUnit(item.getRmUnit());
            /**保质期**/
            rowmaterial.setExpirationDate(item.getExpirationDate());
            /**原材料等级**/
            rowmaterial.setRmGradeId(item.getRmGradeId());
            /**进项税税率**/
            rowmaterial.setPhTaxId(Integer.valueOf(item.getPhTaxId()));
            rowmaterial.setPhTax(item.getPhTaxIdStr());

            /**销项税率**/
            rowmaterial.setSaleTaxId(Integer.valueOf(item.getSaleTaxId()));
            /**最高库存**/
            rowmaterial.setMaxWhCount(item.getMaxWhCount());
            /**最低库存**/
            rowmaterial.setMinWhCount(item.getMinWhCount());
            /**生产厂家**/
            rowmaterial.setManufacturer(item.getManufacturer());
            rowmaterial.setDescription(item.getDescription());
            rowmaterial.setRemark(item.getRemark());
            //**生成原材料ID
            Integer rmId = supplierService.getTableId(projectId,"catering_tcb_rowmaterial",1);
            rowmaterial.setRmCode(String.valueOf(rmId));
            rowmaterial.setRmId(rmId);
            rowmaterial.setProjectId(projectId);
            rowmaterial.setCreater(accountId);
            rowmaterial.setModifier(accountId);
            rowmaterial.setProjectRootId(projectRootId);
            rowmaterial.setIsDelete(0);
            rowmaterial.setSaleStatus(10201);
            rowmaterial.setcStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
            rowmaterialList.add(rowmaterial);
            CateringTcbSaleRowmater saleRowmater = new CateringTcbSaleRowmater();
            /**原材料包装单位**/
            saleRowmater.setSrmUnit(Integer.valueOf(item.getRmUnit()));
            /***当前包装与原材料单位转换**/
            saleRowmater.setPackContent(new BigDecimal(1));
            //**生成原材料包装ID
            Integer srmId = supplierService.getTableId(projectId,"catering_tcb_sale_rowmater",1);
            int i = num++;
            saleRowmater.setProjectId(projectId);
            saleRowmater.setSrmCode(rmId+"-"+String.valueOf(i));
            saleRowmater.setSrmId(srmId);
            saleRowmater.setRmId(rmId);
            saleRowmater.setRmCode(String.valueOf(rmId));
            saleRowmater.setCreater(accountId);
            saleRowmater.setModifier(accountId);
            saleRowmater.setIsInOutSpec(1);
            saleRowmater.setIsDefault(1);
            saleRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
            Map<String, Object> barCodeMap = collarUseService.getBarCode(projectId, 20, srmId, 0, 0,2);
            if ((boolean)barCodeMap.get("success") == true) {
                String barCode = (String)barCodeMap.get("code");
                saleRowmater.setRmBarcode(barCode);
            }
            //如果包装含量等于一 系统会认定采购单位和原材料单位一致
            BigDecimal packContent = new BigDecimal(item.getPackContent());
            if(packContent.compareTo(new BigDecimal(1)) == 0){
                saleRowmater.setIsPurChaseUnit(1);
            }else{
                i = num++;
                saleRowmater.setIsPurChaseUnit(0);
                CateringTcbSaleRowmater saleRowmater1 = new CateringTcbSaleRowmater();
                saleRowmater1.setSrmUnit(Integer.valueOf(item.getPurchaseUnit()));
                saleRowmater1.setPackContent(packContent);
                Integer srmId1 = supplierService.getTableId(projectId,"catering_tcb_sale_rowmater",1);
                saleRowmater1.setProjectId(projectId);
                saleRowmater1.setSrmCode(rmId+"-"+String.valueOf(i));
                saleRowmater1.setSrmId(srmId1);
                saleRowmater1.setRmId(rmId);
                saleRowmater1.setRmCode(String.valueOf(rmId));
                saleRowmater1.setCreater(accountId);
                saleRowmater1.setModifier(accountId);
                saleRowmater1.setIsInOutSpec(0);
                saleRowmater1.setIsDefault(0);
                saleRowmater1.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
                saleRowmater1.setIsPurChaseUnit(1);

                Map<String, Object> barCodeMap1 = collarUseService.getBarCode(projectId, 20, srmId1, 0, 0,2);
                if ((boolean)barCodeMap1.get("success") == true) {
                    String barCode1 = (String)barCodeMap1.get("code");
                    saleRowmater1.setRmBarcode(barCode1);
                }

                saleRowmaterList.add(saleRowmater1);
            }
            saleRowmaterList.add(saleRowmater);

            CateringTcbSuppRowmater suppRowmater = new CateringTcbSuppRowmater();
            /**供应商**/
            //suppRowmater.setSuppId(Integer.valueOf(item.getSuppCode()));
            /**采购含税进价**/
            BigDecimal purchaseTaxPaid = new BigDecimal(item.getPurchaseTaxPaid());
            suppRowmater.setPurchaseTaxPaid(purchaseTaxPaid);
            suppRowmater.setOldPurchaseTaxPaid(purchaseTaxPaid);
            /**含税进价**/
            CatecommTssDatadictDto taxDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.tax_reserved_decimal.getName());

            BigDecimal taxPaid = purchaseTaxPaid.divide(packContent,Integer.valueOf(taxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP);
            suppRowmater.setTaxPaid(taxPaid);
            suppRowmater.setOldTaxPaid(taxPaid);
            // 未税金额：含税金额*含税转未税税比率=未税金额
            List<CatecommTsbTax> tsbTaxInfo = adjustApi.getTsbTaxInfo(Integer.valueOf(item.getPhTaxId()),null);
            BigDecimal newUnTaxPriceInTemp = taxPaid.multiply(tsbTaxInfo.get(0).getConToFreeTax());
            BigDecimal newUnTaxPriceIn = newUnTaxPriceInTemp.setScale(tsbTaxInfo.get(0).getConToFreeNum(),BigDecimal.ROUND_HALF_UP);
            suppRowmater.setNoTaxPaid(newUnTaxPriceIn);
            suppRowmater.setOldNoTaxPaid(newUnTaxPriceIn);
            /**采购未税进价**/
            BigDecimal noPurchaseTaxPaid = purchaseTaxPaid.multiply(tsbTaxInfo.get(0).getConToFreeTax()).setScale(tsbTaxInfo.get(0).getConToFreeNum(),BigDecimal.ROUND_HALF_UP);
            suppRowmater.setPurchaseNoTaxPaid(noPurchaseTaxPaid);
            suppRowmater.setOldPurchaseNoTaxPaid(noPurchaseTaxPaid);
            /**预估成本价 = 含税进价 **/
            suppRowmater.setFuTaxCost(taxPaid);
            // **生成原材料供应商ID
            Integer supComId = supplierService.getTableId(projectId,"catering_tcb_supp_rowmater",1);
            suppRowmater.setSupComId(supComId);
            suppRowmater.setProjectId(projectId);
            suppRowmater.setRmId(rmId);
            suppRowmater.setDeliveryType(10401); //配送
            suppRowmater.setRmCode(String.valueOf(rmId));
            suppRowmater.setRmName(rmName);
            suppRowmater.setIsDefault(1);
            suppRowmater.setCreater(accountId);
            suppRowmater.setModifier(accountId);
            suppRowmaterList.add(suppRowmater);
            suppRowmater.setPhTax(item.getPhTaxIdStr());
            suppRowmater.setPhTaxId(Integer.valueOf(item.getPhTaxId()));
            suppRowmater.setContractCode(item.getContractCode());
            suppRowmater.setContractId(item.getContractId());
            suppRowmater.setContractName(item.getContractName());
            suppRowmater.setSuppId(item.getContractSupper());
            suppRowmater.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
        }
        rowmaterialList.forEach(a->{
            if (autoBaseDao.save(a)<=0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存原材料基础信息失败！", null);
            }
            if (this.saveBasicDataLog(projectId,a.getRmId(),20,BasicDataLogStatus.LOG_INFO,"导入原材料,原材料编号["+a.getRmCode()+"]",accountId) == 0) {
                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "添加原材料信息操作日志失败！", null);
            }
        });
        saleRowmaterList.forEach(b->{
            if ( autoBaseDao.save(b)<=0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存原材料包装失败！", null);
            }
        });
        suppRowmaterList.forEach(c->{
            if ( autoBaseDao.save(c)<=0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存原材料供应商失败！", null);
            }
        });
        response.setCode(100);
        return response;
    }


    @Override
    public String preImportRawmater(Excel<RawmaterExeclVo> excel, Long projectId, Long projectRootId, Long accountId) {
        RawmaterResponse response = new RawmaterResponse();
        List<RawmaterExeclMessage> execlMessagesList = new ArrayList<>();
        int type = 0;

        for (RawmaterExeclVo item : excel.getData()) {
            StringBuilder messageBuf = new StringBuilder();
            RawmaterExeclMessage execlMessage = new RawmaterExeclMessage();
            /**原材料分类**/
            String classCodetemp = item.getRmClassCode();
            if (StringUtils.isBlank(classCodetemp)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料分类为空").append(" ");
            } else {
                String[] rmClassCodeResult = classCodetemp.split("-");
                String rmClassCode = rmClassCodeResult[0];
                String rmcName = rmClassCodeResult[1];
                CateringTccRawmaterClass rawmaterClass = this.getRawmaterClass(null,rmClassCode,projectId);
                if (rawmaterClass == null) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("分类"+rmClassCode+"-"+rmcName+"已不存在,请更换分类或下载最新模版").append(" ");
                }else{
                    // 判断是否存在子级
                    List<CateringTccRawmaterClass> sonRawmaterClasses = this.queryRawmaterClassByRmcId(rawmaterClass.getRmcId(), projectId);
                    if (CollectionUtils.isNotEmpty(sonRawmaterClasses)) {
                        type = 1;
                        execlMessage.setType(type);
                        execlMessage.setFlag("失败");
                        messageBuf.append("分类"+rmClassCode+"-"+rmcName+"下已存在子分类,请更换分类下载最新模版").append(" ");
                    }
                }
                execlMessage.setRmClassCode(rmClassCode);
            }

            /**原材料名称&&拼音编码**/
            String rmName = item.getRmName();
            if (StringUtils.isBlank(rmName)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料名称为空").append(" ");
            }

            List<RawmaterExeclMessage> subItems = execlMessagesList.stream().filter(b -> rmName.equals(b.getRmName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(subItems)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("execl中原材料名称 ["+rmName+"] 重复,请保证唯一").append(" ");
            }
            boolean messgae = this.rmNameOnlyJudge(rmName, projectId);
            if (!messgae) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料名称已存在,请保证唯一").append(" ");
            }
            execlMessage.setRmName(rmName);
            /**原材料简称**/
            String rmAbbreviate = item.getRmAbbreviate();
            if (StringUtils.isBlank(rmAbbreviate)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料简称为空").append(" ");
            }
            execlMessage.setRmAbbreviate(rmAbbreviate);
            /**原材料类型**/
            String specRmTypeStr = item.getSpecRmType();
            if (StringUtils.isBlank(specRmTypeStr)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料类型为空").append(" ");
            } else {
                String[] specRmTypeResult = specRmTypeStr.split("-");
                String specRmType = specRmTypeResult[0];
                execlMessage.setSpecRmType(specRmType);
            }

            /**是否可售**/
            String isCanSale = item.getIsCanSale();
            if (StringUtils.isBlank(isCanSale)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("是否可售为空").append(" ");
            }
            execlMessage.setIsCanSale(isCanSale);
            if (StringUtils.isBlank(item.getPredictPrice())) {
                execlMessage.setPredictPrice(BigDecimal.ZERO);
            }else{
                execlMessage.setPredictPrice(new BigDecimal(item.getPredictPrice()));
            }
            /**原材料规格**/
            String sellModel = item.getSellModel();
            if (StringUtils.isBlank(sellModel)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料规格为空").append(" ");
            }
            execlMessage.setSellModel(sellModel);
            /**原材料单位**/
            String rmUnitStr = item.getRmUnit();
            if (StringUtils.isBlank(rmUnitStr)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料单位为空").append(" ");
            } else {
                String[] rmUnitResult = rmUnitStr.split("-");
                String rmUnitName = rmUnitResult[1];
                String rmUnit = rmUnitResult[0];
                execlMessage.setRmUnitName(rmUnitName);
                execlMessage.setRmUnit(Integer.valueOf(rmUnit));
            }
            /**原材料等级**/
            String rmGradeIdStr = item.getRmGradeId();
            if (StringUtils.isBlank(rmGradeIdStr)){
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("原材料等级为空").append(" ");
            } else {
                String[] split = rmGradeIdStr.split("-");
                execlMessage.setRmGradeId(Integer.valueOf(split[0]));
            }
            /**进项税税率**/
            String phTaxIdStr = item.getPhTaxId();
            if (StringUtils.isBlank(phTaxIdStr)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("进项税税率为空").append(" ");
            } else {
                String[] phtaxIdResult = phTaxIdStr.split("-");
                String phtaxIdStr = phtaxIdResult[1];
                String phtaxId = phtaxIdResult[0];
                execlMessage.setPhTaxIdStr(phtaxIdStr);
                execlMessage.setPhTaxId(phtaxId);
            }
            /**销项税率**/
            String saleTaxIdStr = item.getSaleTaxId();
            if (StringUtils.isBlank(saleTaxIdStr)){
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("销项税率为空").append(" ");
            } else {
                String[] saleResult = saleTaxIdStr.split("-");
                String saleIdStr = saleResult[1];
                String saleId = saleResult[0];
                execlMessage.setSaleTaxIdStr(saleIdStr);
                execlMessage.setSaleTaxId(saleId);
            }

            if (StringUtils.isNotBlank(item.getPackContent())) {
                BigDecimal packContent = new BigDecimal(item.getPackContent());
                if(packContent.compareTo(new BigDecimal(1)) < 0){
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("包装含量不能少于1").append(" ");
                }
            }else{
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("包装含量为空").append(" ");
            }

            /**供应商**/
//            String suppNameStr = item.getSuppName();
//            if (StringUtils.isBlank(suppNameStr)) {
//                type = 1;
//                execlMessage.setType(type);
//                execlMessage.setFlag("失败");
//                messageBuf.append("供应商为空").append(" ");
//            } else {
//                String[] suppResult = suppNameStr.split("-");
//                String suppName = suppResult[1];
//                String suppCode = suppResult[0];
//                execlMessage.setSuppName(suppName);
//                execlMessage.setSuppCode(suppCode);
//            }
            /**含税进价**/
//            String taxPaidStr = item.getTaxPaid();
//            if (StringUtils.isBlank(taxPaidStr)) {
//                type = 1;
//                execlMessage.setType(type);
//                execlMessage.setFlag("失败");
//                messageBuf.append("含税进价为空").append(" ");
//            }
//            execlMessage.setTaxPaid(taxPaidStr);
            /**预估成本价**/
//            String costPrice = item.getCostPrice();
//            if (StringUtils.isBlank(costPrice)) {
//                costPrice = "0";
//                type = 1;
//                execlMessage.setType(type);
//                execlMessage.setFlag("失败");
//                messageBuf.append("预估成本价为空").append(",");
//            }
            NativeSQLBuilder queryCateContract = NativeSQLBuilder.build(CateringContract.class)
                    .setSql(" SELECT c.*,supp_name contract_supper_name FROM catering_contract c " +
                            " left join commodity_tcb_supplier s on c.contract_supper = s.supp_id and c.project_id = s.project_id" +
                            " WHERE c.project_id = "+projectId+" " +
                            " AND c.is_delete = 0 AND DATE_FORMAT(now(),'%Y-%m-%d') <= contract_end_time " +
                            " AND contract_code = '" + item.getContractCode() + "' AND contract_stauts = 133003 ");

            CateringContract cateringContract = (CateringContract)autoBaseDao.findOne(queryCateContract);
            if(cateringContract == null){
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("无效的合同编号").append(",");
            }
            execlMessage.setMessage(messageBuf.toString());
//            execlMessage.setTaxPaid(taxPaidStr);
//            execlMessage.setCostPrice(new BigDecimal(costPrice));
//            execlMessage.setSuppName(cateringContract.getS);
//            execlMessage.setSuppCode(suppCode);
            execlMessage.setMaxWhCount(item.getMaxWhCount() != null ? new BigDecimal(item.getMaxWhCount()): BigDecimal.ZERO);
            execlMessage.setMinWhCount(item.getMinWhCount() != null ? new BigDecimal(item.getMinWhCount()): BigDecimal.ZERO);
            execlMessage.setRemark(item.getRemark());
            execlMessage.setDescription(item.getDescription());
            execlMessage.setExpirationDate(Integer.valueOf(item.getExpirationDate()));
            execlMessage.setManufacturer(item.getManufacturer());
            execlMessage.setPackContent(item.getPackContent());
            execlMessage.setContractCode(item.getContractCode());
            if(cateringContract!=null){
                execlMessage.setContractId(cateringContract.getContractId());
                execlMessage.setContractSupper(cateringContract.getContractSupper());
                execlMessage.setContractName(cateringContract.getContractName());
            }
            if (StringUtils.isBlank(item.getPurchaseUnit())) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("采购单位为空").append(" ");
            } else {
                String[] rmUnitResult = item.getPurchaseUnit().split("-");
                execlMessage.setPurchaseUnit(rmUnitResult[0]);
            }
            execlMessage.setPurchaseTaxPaid(item.getPurchaseTaxPaid());
            execlMessagesList.add(execlMessage);
        }
        response.setCode(100);
        response.setTotal(execlMessagesList.size());
        response.setType(type);
        response.setExeclMessagesList(execlMessagesList);
        String randomStr = UUID.randomUUID().toString();

        redisUtil.setForSeconds(randomStr, JSON.toJSONString(response), 30*60L);
        return randomStr;
    }

    @Override
    public RawmaterResponse listImportRawmater(String redisKey, Integer pageNo, Integer pageSize, Integer type, Long projectId, Long projectRootId, Long accountId) {
        String execlMessages = (String)redisUtil.get(redisKey);
        RawmaterResponse response = JSON.parseObject(execlMessages,RawmaterResponse.class);
        if (response == null) {
            throw new RpcException(300,ErrorCode.PARAM_BLANK+"操作时间已过，请重新导入",null);
        }
        List<RawmaterExeclMessage> execlMessagesList = response.getExeclMessagesList();
        int total = execlMessagesList.size();
        response.setTotal(total);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        if (type == 1) {
            List<RawmaterExeclMessage> subItems = execlMessagesList.stream().filter(b -> type.intValue() == b.getType()).collect(Collectors.toList());
            subItems = subItems.size() <= 10 ? subItems : subItems.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo)));
            response.setExeclMessagesList(subItems);
            return response;
        }else if(type == 2){
            return importRawmater(execlMessagesList,projectId,projectRootId,accountId);
        } else {
            response.setExeclMessagesList(execlMessagesList.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo))));
            return response;
        }
    }


    @Override
    public List<CateringTcbRowmaterialVo> exportRawmater(Long projectId, String rmcCode, Integer rmcId, Integer urmcId, String urmcCode) {

        List<CateringTcbRowmaterialVo>  classCodeList = new ArrayList<>();
        List<String> classCodes = new ArrayList<String>();
        if(rmcCode.equals("全部") && rmcId == 1 ||  rmcId == 2) {
            String sql = "select rmc_code as rmClassCode from catering_tcc_rawmater_class where rmc_id IN (select rmc_id from catering_tcc_rawmater_class where project_id = "+projectId+" and urmc_id = "+urmcId+")";
            NativeSQLBuilder<CateringTcbRowmaterialVo> queryBuilder = NativeSQLBuilder.build(CateringTcbRowmaterialVo.class).setSql(sql);
            classCodeList = autoBaseDao.listAll(queryBuilder);
            for (CateringTcbRowmaterialVo rawInfo: classCodeList) {
                classCodes.add(rawInfo.getRmClassCode());
            }
        }
        classCodes.add(urmcCode);// 包括本身
        List<String> classCodesThree = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(classCodes)) {
            String join = Joiner.on(",").join(classCodes);
            // 最后一级
            if (rmcCode.equals("全部") && rmcId == 1) {
                NativeSQLBuilder<String> builder = NativeSQLBuilder.build(String.class)
                        .setSql("select rmc_code from catering_tcc_rawmater_class where rmc_id IN ( select rmc_id from catering_tcc_rawmater_class where project_id = "+projectId+"\n"+
                                "\t and urmc_code IN ("+join+"))");
                classCodesThree = autoBaseDao.listAll(builder);
                classCodesThree.add(join);
            }
        }

        if (!urmcCode.equals("0")) {
            classCodesThree.add(urmcCode);
        }

        NativeSQLBuilder rowmaterialBuild = NativeSQLBuilder.build(CateringTcbRowmaterialVo.class)
                .setSql("select t1.*,t3.srm_code,t3.pack_content as srmPackContent,t3.rm_barcode,t3.is_delete as srmIsDetele,t3.is_default,t3.is_in_out_spec,t6.supp_name,t5.tax_paid,t5.no_tax_paid,t5.is_delete as suppIsDelete,t5.fu_tax_cost,t5.is_default as suppIsdefault,\n" +
                        "\t (select type_name from catecomm_tss_pubdatadict where type_code = t1.c_status) as statusStr," +
                        "\t (select type_name from catecomm_tss_pubdatadict where type_code = t1.sale_status) as saleStatusName," +
                        "\t (select type_name from catecomm_tss_pubdatadict where type_code = t3.srm_status) as srmStatusName," +
                        "\t (select type_name from catecomm_tss_pubdatadict where type_code = t5.srm_status) as supStatusName," +
                        "\t (select dict_tp_value from catecomm_tss_datadict where dict_tp_code = t5.delivery_type and project_id = t5.project_id) as deliveryTypeName," +
                        "\t ( select CONCAT(t2.rmc_name,t2.rmc_code) as first_code from \n" +
                        "\t catering_tcc_rawmater_class t2 where substring(t1.rm_class_code,1,2)  = t2.rmc_code and t2.project_id = " + projectId + "\n" +
                        "\t ) rmClassNameOne,\n" +
                        "\t (select CONCAT(t3.rmc_name,t3.rmc_code) as two_code from \n" +
                        "\t catering_tcc_rawmater_class t3 where substring(t1.rm_class_code,1,4)  = t3.rmc_code  and  LENGTH(t1.rm_class_code) >= 4  and t3.project_id = " + projectId + " ) rmClassNameTwo,\n" +
                        "\t (select CONCAT(t4.rmc_name,t4.rmc_code) as three_code from\n" +
                        "\t catering_tcc_rawmater_class t4 where substring(t1.rm_class_code,1,6)  = t4.rmc_code  and  LENGTH(t1.rm_class_code) >= 6 and t4.project_id = " + projectId + ") rmClassNameThree,\n"+
                        "\t (select t2.dict_tp_value from catecomm_tss_datadict t2 where t2.dict_tp_code = t1.rm_grade_id and t2.project_id = t1.project_id) as rmGradeStr,\n " +
                        "\t (select t9.type_name from catecomm_tss_pubdatadict t9 where t9.type_code = t1.rm_unit) as rmUnitName,\n " +
                        "\t (select t10.type_name from catecomm_tss_pubdatadict t10 where t10.type_code = t3.srm_unit) as srmUnitName,\n " +
                        "\t (select t11.tax_name from catecomm_tsb_tax t11 where t11.tax_id = t1.ph_tax_id and t11.project_id = t1.project_id) as phTaxName,\n " +
                        "\t (select t12.tax_name from catecomm_tsb_tax t12 where t12.tax_id = t1.sale_tax_id and t12.project_id = t1.project_id) as saleTaxName\n " +
                        "\t from catering_tcb_rowmaterial t1\n" +
                        "\t INNER JOIN catering_tcb_sale_rowmater t3 on t1.rm_id = t3.rm_id  and t1.project_id = t3.project_id\n"+
                        "\t INNER JOIN catering_tcb_supp_rowmater t5 on t1.rm_id = t5.rm_id and t1.project_id = t5.project_id\n"+
                        "\t INNER JOIN commodity_tcb_supplier t6 on t5.supp_id = t6.supp_id and t5.project_id = t6.project_id\n"+
                        "\t where t1.is_delete=0 and t1.project_id = " + projectId + "");
        if (rmcCode.equals("全部") && rmcId == 1) {
            rowmaterialBuild.append(CollectionUtils.isNotEmpty(classCodesThree) ? " and t1.rm_class_code IN ("+Joiner.on(",").join(classCodesThree)+")" : "");
        } else if(rmcCode.equals("全部") && rmcId == 2){
            rowmaterialBuild.append(CollectionUtils.isNotEmpty(classCodes) ? " and t1.rm_class_code IN ("+Joiner.on(",").join(classCodes)+")" : "");
        } else if(!rmcCode.equals("全部")) {
            rowmaterialBuild.append(StringUtils.isNotEmpty(rmcCode) ? " and t1.rm_class_code IN ("+rmcCode+")" : "");
        }
        rowmaterialBuild.append(" order by t1.created_time desc");
        List<CateringTcbRowmaterialVo> rowmaterialList = autoBaseDao.listAll(rowmaterialBuild);


        return rowmaterialList;
    }

    @Override
    public List<CateringTcbSuppRowmater> suppRowmaterList(Long projectId, Integer suppId) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                .setSql("select t1.supp_id, t2.supp_code, t2.supp_name from catering_tcb_supp_rowmater t1\n" +
                        " INNER JOIN commodity_tcb_supplier t2 on t1.supp_id = t2.supp_id AND t1.project_id = t2.project_id\n" +
                        " and t1.is_delete = 0\n"+
                        " and t1.project_id = " + projectId + "\n");
        sqlBuilder.append( "AND t1.supp_id =  " + suppId + "\n");
        sqlBuilder.append(" group by t1.supp_id");
        return autoBaseDao.listAll(sqlBuilder);
    }


    @Override
    public List<RowmaterilVo> rawmaterList(Long projectId, Integer supperId) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(RowmaterilVo.class)
                .setSql("select t2.rm_id, t2.rm_code, t2.rm_name, t2.sell_model, t1.tax_paid, t1.purchase_tax_paid,\n" +
                        " (SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t3.srm_unit) AS unitName\n" +
                        "from catering_tcb_supp_rowmater t1 \n" +
                        "LEFT JOIN catering_tcb_rowmaterial t2 ON t2.rm_id = t1.rm_id and t2.project_id = t1.project_id\n" +
                        "LEFT JOIN catering_tcb_sale_rowmater t3 ON t3.rm_id = t1.rm_id and t3.project_id = t1.project_id  AND t3.is_pur_chase_unit = 1\n" +
                        "where t2.c_status = 11503 AND t2.is_delete = 0 and  t1.is_delete = 0 and t2.project_id = " + projectId + "\n" +
                        " AND t1.supp_id = " + supperId);
        return autoBaseDao.listAll(sqlBuilder);
    }

    @Override
    public String getAccountName(Long accountId) {
        NativeSQLBuilder builder = NativeSQLBuilder.build(AccountModel.class)
                .setSql("select nick_name from account where id = " + accountId);
        AccountModel accountModel= (AccountModel)autoBaseDao.findOne(builder);
        return accountModel.getNickName();
    }


    /*方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    private boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    @Override
    public List<CateringWhInDtl> getWhinDataBySupp(Long projectId, Long rmId,Long suppId) {
        NativeSQLBuilder<CateringWhInDtl> builder = NativeSQLBuilder.build(CateringWhInDtl.class)
                .setSql("select t2.* from catering_wh_in t1 INNER JOIN " +
                        "\t catering_wh_in_dtl t2 on t1.whin_bill_id = t2.whin_bill_id and t1.project_id = t2.project_id " +
                        "\t where t2.is_delete = 0 AND t2.rm_id ="+rmId+
                        "\t AND t1.is_delete = 0 AND t1.supp_id ="+suppId+
                        "\t AND t1.project_id = "+projectId);
        return autoBaseDao.listAll(builder);
    }

    @Override
    public String isIntrospection(Long projectId, Long rmId) {
        String result = null;
        NativeSQLBuilder<CommodityWhInDtl> builder = NativeSQLBuilder.build(CommodityWhInDtl.class)
                .setSql("select t2.* from catering_wh_in t1 INNER JOIN " +
                        "\t catering_wh_in_dtl t2 on t1.whin_bill_id = t2.whin_bill_id and t1.project_id = t2.project_id " +
                        "\t where t2.is_delete = 0 AND t2.rm_id ="+rmId+
                        "\t AND t1.is_delete = 0 " +
                        "\t AND t1.project_id = "+projectId);
        List<CommodityWhInDtl> list = autoBaseDao.listAll(builder);
        if(list.size()>0){
            result = "该原材料存在采购记录，不能反审！";
            return result;
        }
        NativeSQLBuilder<CommodityTcjAdjust> builder1 = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql(" SELECT * FROM " +
                        " catering_tcj_adjust t1" +
                        " LEFT JOIN catering_tcj_adjust_detail t2 ON t1.project_id = t2.project_id and t1.adj_id = t2.adj_id \n" +
                        " where t1.is_delete = 0 and t2.is_delete = 0 and t2.rm_id = "+rmId+" and t1.project_id  = " + projectId );
        List<CommodityTcjAdjust> list1 = autoBaseDao.listAll(builder1);
        if(list1.size()>0){
            result = "该原材料存在进价调价记录，不能反审！";
            return result;
        }
        //按菜品设置
        NativeSQLBuilder sql1 = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_saled_dish\n" +
                        "WHERE saled_dish_status != 11804 AND bill_type = 12216 AND saled_data_type = 20 AND is_delete = 0 \n" +
                        "and dict_id = " + rmId + " and project_id =" + projectId);
        List<CateringSaledDishModel> saledDishModels = autoBaseDao.listAll(sql1);
        if (null != saledDishModels && saledDishModels.size() > 0) {
            result = "该原材料已设置可售，不能反审！";
            return result;
        }
        //按餐厅设置
        NativeSQLBuilder sql2 = NativeSQLBuilder.build(CateringSaledDishDetailModel.class)
                .setSql("SELECT t2.* FROM catering_saled_dish t1\n" +
                        "LEFT JOIN catering_saled_dish_detail t2 ON t2.project_id = t1.project_id AND t2.saled_dish_id = t1.saled_dish_id\n" +
                        "WHERE t1.saled_dish_status != 11804 and t1.bill_type = 12216 AND t1.saled_data_type = 10 AND t1.is_delete = 0 \n" +
                        "and t2.dish_id = " + rmId + " and t1.project_id =" + projectId);
        List<CateringSaledDishDetailModel> saledDishDetailModels = autoBaseDao.listAll(sql2);
        if (null != saledDishDetailModels && saledDishDetailModels.size() > 0) {
            result = "该原材料已设置可售，不能反审！";
            return result;
        }
        NativeSQLBuilder<CommoditySaledComBill> builder4 = NativeSQLBuilder.build(CommoditySaledComBill.class)
                .setSql(" select * from catering_ph_tax_dtl \n" +
                        " where is_delete = 0 and rm_id = "+rmId+" and project_id =" + projectId );
        List<CommoditySaledComBill> list4 = autoBaseDao.listAll(builder4);
        if(list4.size()>0){
            result = "该原材料已存在税率调整单，不能反审！";
            return result;
        }

        NativeSQLBuilder<CateringTcbDishBom> builder5 = NativeSQLBuilder.build(CateringTcbDishBom.class)
                .setSql(" select b.* from catering_tcb_dish_bom b " +
                        " left join catering_tcb_dish_bom_detail d on b.project_id = d.project_id and b.dish_bom_id = d.dish_bom_id " +
                        " WHERE " +
                        " d.bom_dtl_type = 10 " +
                        " AND b.db_status != 13906 " +
                        " AND b.is_delete = 0 " +
                        " AND d.is_delete = 0 " +
                        " AND d.rmdish_id = "+rmId+" AND d.project_id = " + projectId );
        List<CateringTcbDishBom> list5 = autoBaseDao.listAll(builder5);
        if(list5.size()>0){
            result = "该原材料已经设置菜品BOM，不能反审！";
            return result;
        }
        return result;
    }

    @Override
    public Integer introspection(Long projectId, Long rmId) {

        //更改原材料主信息状态
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbRowmaterial.class).set("c_status", RawmaterStatus.RAWMATER_STATUS_REJECT).set("sync_status", SyncStatus.NOT_SYNC).whereEq("project_id", projectId).whereEq("rm_id", rmId);
        autoBaseDao.update(updateBuilder);

        //更改原材料包装信息状态
        UpdateBuilder updateBuilder1 = UpdateBuilder.build(CateringTcbSaleRowmater.class)
                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("rm_id",rmId).whereEq("project_id",projectId).whereEq("srm_status",RawmaterStatus.RAWMATER_STATUS_ADOPT);
        autoBaseDao.update(updateBuilder1);

        //更改原材料供应商信息状态
        UpdateBuilder updateBuilder2 = UpdateBuilder.build(CateringTcbSuppRowmater.class)
                .set("srm_status",RawmaterStatus.RAWMATER_STATUS_REJECT).whereEq("rm_id",rmId).whereEq("project_id",projectId).whereEq("srm_status",RawmaterStatus.RAWMATER_STATUS_ADOPT);
        autoBaseDao.update(updateBuilder2);

        return 1;

    }

}
