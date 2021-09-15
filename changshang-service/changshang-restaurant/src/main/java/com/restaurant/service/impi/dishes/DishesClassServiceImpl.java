package com.restaurant.service.impi.dishes;


import com.changshang.feign.SupplierServiceFeign;
import com.restaurant.service.dishes.DishesClassService;
import entity.TreeRecursion;
import excel.Excel;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.CateringTcbDishesModel;
import modelpojo.model.CateringTccDishesClassModel;
import modelpojo.vo.DishClasslVo;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.InsertBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.QueryBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DishesClassServiceImpl implements DishesClassService {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    SupplierServiceFeign supplierService;

    @Override
    public List<CateringTccDishesClassModel> queryFDishesClass(Long projectId) {
        NativeSQLBuilder dishesClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE udish_id = 0 and is_delete = 0 and project_id=" + projectId );
        return autoBaseDao.listAll(dishesClass);
    }

    @Override
    public List<CateringTccDishesClassModel> querySDishesClass(Integer uDishId, Long projectId) {
        NativeSQLBuilder dishesClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE udish_id != 0 and is_delete = 0 and project_id = "  + projectId);
        dishesClass.append(uDishId != 0 ? (" and udish_id=\n" + uDishId + "\n") : "");
        return autoBaseDao.listAll(dishesClass);
    }

    @Override
    public List<CateringTccDishesClassModel> dishesClassTree(Long projectId) {
        List<CateringTccDishesClassModel> dishesClassTree = this.queryFDishesClass(projectId);
        dishesClassTree.forEach(a ->
                TreeRecursion.getDishesClassJson(a, this.querySDishesClass(0, projectId))
        );
        return dishesClassTree;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDishesClass(CateringTccDishesClassModel cateringTccDishesClassModel, Long accountId) {
        //查询是否存在重复的名称
        //新增规则：
        //判断本级
        NativeSQLBuilder selfClassBuild = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0  and udish_id ="  + cateringTccDishesClassModel.getUdishId() + " and project_id = " + cateringTccDishesClassModel.getProjectId()) ;
        List<CateringTccDishesClassModel> selfClass = autoBaseDao.listAll(selfClassBuild);
        int selfClassNum = selfClass.size();
        if (selfClass.size() > 0) {
            selfClass.removeIf(a -> a.getDishClassName().equals(cateringTccDishesClassModel.getDishClassName()) && a.getDishId().intValue() != cateringTccDishesClassModel.getDishId().intValue());
        }
        if (selfClassNum != selfClass.size()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品分类名称已存在！", null);
        }

        NativeSQLBuilder upperClassBuild = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0  and dish_id ="  + cateringTccDishesClassModel.getUdishId() + " and project_id = " + cateringTccDishesClassModel.getProjectId()) ;
        CateringTccDishesClassModel upperClass = (CateringTccDishesClassModel)autoBaseDao.findOne(upperClassBuild);

        if (upperClass != null) {
            if (upperClass.getDishClassName().equals(cateringTccDishesClassModel.getDishClassName())) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品分类名称已存在！", null);
            }
            // 查询分类上上级名称
            NativeSQLBuilder maxClassBuild = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                    .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0  and dish_id ="  + upperClass.getUdishId() +  " and project_id = " + cateringTccDishesClassModel.getProjectId()) ;
            CateringTccDishesClassModel maxClass = (CateringTccDishesClassModel)autoBaseDao.findOne(maxClassBuild);
            if (null != maxClass) {
                if (maxClass.getDishClassName().equals(cateringTccDishesClassModel.getDishClassName())) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品分类名称已存在！", null);
                }
            }

        }
        /*NativeSQLBuilder dishesClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0 and dish_class_name =" + "'" + cateringTccDishesClassModel.getDishClassName() + "'") ;
        CateringTccDishesClassModel oldDishesClass = (CateringTccDishesClassModel)autoBaseDao.findOne(dishesClass);
        if (null != oldDishesClass && oldDishesClass.getDishId().intValue() != cateringTccDishesClassModel.getDishId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品分类名称已存在！", null);
        }*/
        NativeSQLBuilder dishesCodeClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0 and project_id = " + cateringTccDishesClassModel.getProjectId() + "\n" +
                        "and dish_class_code =" + "'" + cateringTccDishesClassModel.getDishClassCode() + "'") ;
        CateringTccDishesClassModel oldDishesCodeClass = (CateringTccDishesClassModel)autoBaseDao.findOne(dishesCodeClass);
        if (null != oldDishesCodeClass && oldDishesCodeClass.getDishId().intValue() != cateringTccDishesClassModel.getDishId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品分类编号已存在！", null);
        }
        cateringTccDishesClassModel.setSyncStatus(10);
        if (0 != cateringTccDishesClassModel.getDishId()) {
            cateringTccDishesClassModel.setUpdatedTime(new Date());
            cateringTccDishesClassModel.setModifier(accountId);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccDishesClassModel.class).setBean(cateringTccDishesClassModel)
                    .whereEq("dishId", cateringTccDishesClassModel.getDishId())
                    .whereEq("projectId", cateringTccDishesClassModel.getProjectId());
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改保存失败！", null);
            }
        } else {
            cateringTccDishesClassModel.setDishId(supplierService.getTableId(cateringTccDishesClassModel.getProjectId(),"catering_tcc_dishes_class", 1));
            cateringTccDishesClassModel.setCreater(accountId);
            cateringTccDishesClassModel.setModifier(accountId);
            InsertBuilder playRulesBuild = InsertBuilder.build(cateringTccDishesClassModel).optSql();
            if (autoBaseDao.save(playRulesBuild) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
            }
        }
    }

    @Override
    public CateringTccDishesClassModel queryById(Integer dishId, Long projectId) {
        QueryBuilder queryBuilder = QueryBuilder.build(CateringTccDishesClassModel.class)
                .whereEq("dishId", dishId).whereEq("projectId", projectId);;
        return (CateringTccDishesClassModel)autoBaseDao.findOne(queryBuilder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDishesClass(String dishClassCode, Long projectId, Long accountId) {
        //判断是否是第一级分类
        String childCode = getChildCode(projectId, dishClassCode);
        //下级分类为空，说明是最后一级，或者没有下级，直接查询判断是否有被商品使用
        if (StringUtils.isEmpty(childCode)) {
            this.selectDishes(dishClassCode, projectId);
        } else {
            //不为空判断二级分类是否有被使用
            this.selectDishes(childCode, projectId);
            //二级分类没有被使用，继续获取三级分类
            String childCode1 = getChildCode(projectId, childCode);
            if(StringUtils.isNotEmpty(childCode1)){
                //不为空判断三级分类是否有被使用
                this.selectDishes(childCode1, projectId);
            }
            //删除子类
            deleteChildCodes(childCode, projectId);
            if (StringUtils.isNotEmpty(childCode1)) {
                deleteChildCodes(childCode1, projectId);
            }
        }
        CateringTccDishesClassModel cateringTccDishesClassModel = new CateringTccDishesClassModel();
        cateringTccDishesClassModel.setIsDelete(1);
        cateringTccDishesClassModel.setSyncStatus(10);
        cateringTccDishesClassModel.setModifier(accountId);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccDishesClassModel.class).setBean(cateringTccDishesClassModel).whereEq("dishClassCode", dishClassCode)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除失败！", null);
        }
    }


    private void deleteChildCodes(String dishClassCodes, Long projectId) {
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("UPDATE catering_tcc_dishes_class SET is_delete = 1,\n" +
                        "sync_status = 10\n" +
                        "WHERE dish_class_code IN ( " + dishClassCodes + ") and project_id =" + projectId);
        //操作
        if (autoBaseDao.nativeExecute(nativeSQLBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除子类时失败！", null);
        }
    }

    private void selectDishes (String dishClassCode, Long projectId) {
        //查询菜品分类是否被关联
        NativeSQLBuilder dishes = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes  WHERE is_delete = 0 AND dish_class_code IN (" + dishClassCode + ")");
        dishes.append(" and project_id = " + projectId);
        List<CateringTcbDishesModel> dishesModels = autoBaseDao.listAll(dishes);
        if (dishesModels != null && dishesModels.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除分类，已被菜品使用！", null);
        }
    }

    /**
     * 获取下级分类
     * @return
     */
    private String getChildCode(Long projectId, String dishClassCode){
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(String.class)
                .setSql(" SELECT " +
                        " GROUP_CONCAT(dish_class_code SEPARATOR ',') " +
                        " FROM " +
                        " catering_tcc_dishes_class " +
                        " WHERE " +
                        " is_delete = 0 " +
                        " AND project_id =  " + projectId +
                        " AND udish_class_code in (" + dishClassCode + ")");
        return (String)autoBaseDao.findOne(queryBuilder);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public String getDishesClassCode(Integer uDishId, Long projectId) {
        if (0 != uDishId) {
            NativeSQLBuilder dishClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                    .setSql("SELECT * FROM catering_tcc_dishes_class WHERE udish_id = " + uDishId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "ORDER BY dish_class_code DESC LIMIT 1" );
            CateringTccDishesClassModel dishesClass = (CateringTccDishesClassModel)autoBaseDao.findOne(dishClass);
            if (null == dishesClass) {
                NativeSQLBuilder disFClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                        .setSql("SELECT * FROM catering_tcc_dishes_class WHERE dish_id = " + uDishId + "\n" +
                                "and project_id = " + projectId + "\n" +
                                "ORDER BY dish_class_code DESC LIMIT 1" );
                CateringTccDishesClassModel dishesFClass = (CateringTccDishesClassModel)autoBaseDao.findOne(disFClass);
                return dishesFClass.getDishClassCode() + "01";
            } else {
                String code = dishesClass.getDishClassCode().substring(dishesClass.getDishClassCode().length() -2, dishesClass.getDishClassCode().length());
                Integer classCode = Integer.parseInt(code) + 1;
                if (classCode > 9) {
                    return  dishesClass.getUdishClassCode() + classCode;
                }
                return dishesClass.getUdishClassCode() + "0" + classCode.toString();
            }
        } else {
            NativeSQLBuilder dishClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                    .setSql("SELECT * FROM catering_tcc_dishes_class WHERE udish_id = " + uDishId + "\n" +
                            "and project_id = " + projectId + "\n" +
                            "ORDER BY dish_class_code DESC LIMIT 1" );
            CateringTccDishesClassModel dishesClass = (CateringTccDishesClassModel)autoBaseDao.findOne(dishClass);
            if (null == dishesClass) {
                return "01";
            } else {
                if (0 == uDishId) {
                    Integer code = Integer.valueOf(dishesClass.getDishClassCode()) + 1;
                    if (code > 9) {
                        return code.toString();
                    }
                    return "0" + code.toString();
                }
                return dishesClass.getDishClassCode() + "01";
            }
        }
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void importDisClass(Excel<DishClasslVo> excel, Long projectId, Long projectRootId, Long accountId) {
        try {
            List<DishClasslVo> execlVos = excel.getData();
            Integer uDishId = 0;
            String uClassCode = "";
            String uClassName = "";

            Integer secondUDishId = 0;
            String secondUClassCode = "";
            String secondUClassName = "";

            for (DishClasslVo vo : execlVos) {
                if (StringUtils.isEmpty(vo.getFirstClassName()) && StringUtils.isEmpty(vo.getSecondClassName()) && StringUtils.isEmpty(vo.getThreeClassName())) {
                    continue;
                }
                if (StringUtils.isEmpty(vo.getFirstClassName())) {
                    throw new RpcException(300, "请选择必填项-->一级分类名称", null);
                }

                String firstClassName = vo.getFirstClassName();
                String firstTaxCode = vo.getFirstTaxCode();


                //查询一级分类名称是否存在
                NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                        .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0 AND udish_id = 0 and dish_class_name = '"  + firstClassName +  "' and project_id = " + projectId) ;
                CateringTccDishesClassModel firstClass = (CateringTccDishesClassModel)autoBaseDao.findOne(sqlBuilder);
                //如果第一级分类名称不存在则创建
                if (null == firstClass) {
                    //查询最大的一级分类编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                            .setSql("SELECT * FROM catering_tcc_dishes_class WHERE udish_id = 0 \n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(dish_class_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccDishesClassModel firstClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);
                    String firstCode = "";
                    //如果是空则表示从未创建过
                    if (null == firstClassModel) {
                        firstCode = "01";
                    } else {
                        Integer code = Integer.valueOf(firstClassModel.getDishClassCode()) + 1;
                        if (code > 9) {
                            firstCode = code.toString();
                        } else {
                            firstCode =  "0" + code.toString();
                        }
                        if (code > 99) {
                            throw new RpcException(300, "一级分类的编号超出范围，无法添加！", null);
                        }

                    }
                    //保存菜品分类
                    CateringTccDishesClassModel newDishesClass = saveDishClass(projectId, accountId, firstCode, firstClassName, null, null, 0, firstTaxCode);
                    //如果编号不为空，则表示当前分类的编号在数据库存在过，没有再次新增
                    if (StringUtils.isEmpty(newDishesClass.getDishClassCode())) {
                        uClassCode = firstCode;
                        uClassName = firstClassName;
                        uDishId = newDishesClass.getDishId();
                    } else {
                        uDishId = newDishesClass.getDishId();
                        uClassCode = newDishesClass.getDishClassCode();
                        uClassName = newDishesClass.getDishClassName();
                    }
                } else {
                    uDishId = firstClass.getDishId();
                    uClassCode = firstClass.getDishClassCode();
                    uClassName = firstClass.getDishClassName();
                    //可能存在修改税务编码
                    if (StringUtils.isNotEmpty(firstTaxCode)) {
                        this.updateTaxCode(firstTaxCode, uDishId, projectId);
                    }
                }

                if (StringUtils.isEmpty(vo.getSecondClassName()) && StringUtils.isNotEmpty(vo.getThreeClassName())) {
                    throw new RpcException(300, "请选择必填项-->数据不完整，请检查数据的完整性", null);
                }
                //二级分类编号
                if (StringUtils.isNotBlank(vo.getSecondClassName())) {
                    String secondClassName = vo.getSecondClassName();
                    String taxCode2 = vo.getSecondTaxCode();

                    String secondCode = "";
                    //查询二级分类最大的编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                            .setSql("SELECT * FROM catering_tcc_dishes_class WHERE udish_id = " + uDishId + "\n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(dish_class_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccDishesClassModel secondClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);
                    if (null == secondClassModel) {
                        secondCode =  uClassCode + "01";
                    } else {
                        String code = secondClassModel.getDishClassCode().substring(secondClassModel.getDishClassCode().length() -2, secondClassModel.getDishClassCode().length());
                        Integer classCode = Integer.parseInt(code) + 1;
                        if (classCode > 9) {
                            secondCode = uClassCode + classCode.toString();
                        } else {
                            secondCode = uClassCode + "0" + classCode.toString();
                        }
                        if (classCode > 99) {
                            throw new RpcException(300, "二级分类的编号超出范围，无法添加！", null);
                        }

                    }

                    CateringTccDishesClassModel newDishesClass = saveDishClass(projectId, accountId, secondCode, secondClassName, uClassCode, uClassName, uDishId, taxCode2);
                    if (StringUtils.isNotEmpty(newDishesClass.getDishClassCode())) {
                        secondUDishId = newDishesClass.getDishId();
                        secondUClassCode = newDishesClass.getDishClassCode();
                        secondUClassName = newDishesClass.getDishClassName();
                    } else {
                        secondUClassName = secondClassName;
                        secondUClassCode = secondCode;
                        secondUDishId = newDishesClass.getDishId();
                    }
                }

                //三级分类编号
                if (StringUtils.isNotBlank(vo.getThreeClassName())) {
                    String threeClassName = vo.getThreeClassName();
                    String taxCode3 = vo.getThreeTaxCode();

                    String threeCode = "";
                    //查询三级分类最大的编号
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                            .setSql("SELECT * FROM catering_tcc_dishes_class WHERE udish_id = " + secondUDishId + "\n" +
                                    "AND project_id = " + projectId + "\n" +
                                    "ORDER BY CONVERT(dish_class_code, SIGNED) DESC LIMIT 1") ;
                    CateringTccDishesClassModel threeClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);
                    if (null == threeClassModel) {
                        threeCode = secondUClassCode + "01";
                    } else {
                        String code = threeClassModel.getDishClassCode().substring(threeClassModel.getDishClassCode().length() -2, threeClassModel.getDishClassCode().length());
                        Integer classCode = Integer.parseInt(code) + 1;
                        if (classCode > 9) {
                            threeCode = secondUClassCode + classCode.toString();
                        } else {
                            threeCode = secondUClassCode + "0" + classCode.toString();
                        }
                        if (classCode > 99) {
                            throw new RpcException(300, "三级分类的编号超出范围，无法添加！", null);
                        }
                    }
                    saveDishClass(projectId, accountId, threeCode, threeClassName, secondUClassCode, secondUClassName, secondUDishId, taxCode3);
                }

            }
        } catch (Exception e) {
            throw new RpcException(300, e.getMessage(), null);
        }
        
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void clearTaxCode(Long projectId) {
        NativeSQLBuilder update = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("UPDATE catering_tcc_dishes_class SET tax_code = null,\n" +
                        "sync_status = 10\n" +
                        "WHERE project_id =" + projectId);
        autoBaseDao.nativeExecute(update);
    }

    private void updateTaxCode(String taxCode, Integer dishId, Long projectId) {
        //可能存在需要修改税务编码
        CateringTccDishesClassModel cateringTccDishesClassModel = new CateringTccDishesClassModel();
        cateringTccDishesClassModel.setSyncStatus(10);
        cateringTccDishesClassModel.setTaxCode(taxCode);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccDishesClassModel.class).setBean(cateringTccDishesClassModel)
                .whereEq("dishId", dishId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改编码保存失败！", null);
        }
    }


    private CateringTccDishesClassModel saveDishClass(Long projectId, Long accountId, String classCode, String className, String uClassCode, String uClassName, Integer uDishId, String taxCode) {
        //查询当前分类是否存在相同名称
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class WHERE is_delete = 0 AND udish_id = " + uDishId + "\n" +
                        "AND project_id = " + projectId + "\n" +
                        "AND dish_class_name = '" + className + "'\n" +
                        "ORDER BY CONVERT(dish_class_code, SIGNED) DESC LIMIT 1") ;
        CateringTccDishesClassModel classModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);
        if (null != classModel) {
            if (StringUtils.isEmpty(taxCode)) {
                return classModel;
            }
            //可能存在需要修改税务编码
            CateringTccDishesClassModel cateringTccDishesClassModel = new CateringTccDishesClassModel();
            cateringTccDishesClassModel.setSyncStatus(10);
            cateringTccDishesClassModel.setTaxCode(taxCode);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTccDishesClassModel.class).setBean(cateringTccDishesClassModel)
                    .whereEq("dishId", classModel.getDishId())
                    .whereEq("projectId", projectId);
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改编码保存失败！", null);
            }
            return classModel;

        }
        CateringTccDishesClassModel dishesClassModel = new CateringTccDishesClassModel();

        dishesClassModel.setProjectId(projectId);
        dishesClassModel.setProjectRootId(projectId);
        dishesClassModel.setDishId(supplierService.getTableId(projectId,"catering_tcc_dishes_class", 1));
        dishesClassModel.setCreater(accountId);
        dishesClassModel.setModifier(accountId);
        dishesClassModel.setDishClassCode(classCode);
        dishesClassModel.setDishClassName(className);
        dishesClassModel.setUdishClassCode(uClassCode);
        dishesClassModel.setUdishId(uDishId);
        dishesClassModel.setUdishClassName(uClassName);
        dishesClassModel.setTaxCode(taxCode);
        dishesClassModel.setSyncStatus(10);
        InsertBuilder playRulesBuild = InsertBuilder.build(dishesClassModel).optSql();
        if (autoBaseDao.save(playRulesBuild) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
        }
        CateringTccDishesClassModel newDishesClass = new CateringTccDishesClassModel();
        newDishesClass.setDishId(dishesClassModel.getDishId());
        return newDishesClass;
    }
}
