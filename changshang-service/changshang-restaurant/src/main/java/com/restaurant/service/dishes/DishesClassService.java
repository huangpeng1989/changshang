package com.restaurant.service.dishes;


import excel.Excel;
import modelpojo.model.CateringTccDishesClassModel;
import modelpojo.vo.DishClasslVo;

import java.util.List;

/**
 * <p>
 * 菜品分类 服务类
 * </p>
 *
 * @author lixiang
 * @since 2019-09-02
 */
public interface DishesClassService {

    /**
     * 查询菜品分类最大父类
     */
    List<CateringTccDishesClassModel> queryFDishesClass(Long projectId);

    /**
     * 查询菜品分类所有子类集合
     */
    List<CateringTccDishesClassModel> querySDishesClass(Integer uDishId, Long projectId);

    /**
     * 菜品分类树形结构
     * @return
     */
    List<CateringTccDishesClassModel> dishesClassTree(Long projectId);

    /**
     * 新增/修改菜品分类
     * @param cateringTccDishesClassModel
     */
    void saveDishesClass(CateringTccDishesClassModel cateringTccDishesClassModel, Long accountId);

    /**
     * 根据id查询
     * @param dishId
     * @return
     */
    CateringTccDishesClassModel queryById(Integer dishId, Long projectId);

    /**
     * 删除菜品分类
     * @param dishClassCode
     */
    void deleteDishesClass(String dishClassCode, Long projectId, Long accountId);

    /**
     * 菜品分类编号生成
     * @param uDishId
     * @return
     */
    String getDishesClassCode(Integer uDishId, Long projectId);

    /**
     * 菜品分类信息导入
     * @param excel
     * @param projectId
     * @param projectRootId
     * @param accountId
     * @return
     */
    void importDisClass(Excel<DishClasslVo> excel, Long projectId, Long projectRootId, Long accountId);

    /**
     * 一键清空所有税务编码
     * @param projectId
     */
    void clearTaxCode(Long projectId);

}
