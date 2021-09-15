package com.restaurant.service.dishes;


import entity.ModelPagedList;
import excel.Excel;
import modelpojo.model.*;
import modelpojo.vo.DishesDto;
import modelpojo.vo.DishesSpecDto;
import modelpojo.vo.saleadjust.DishesExeclVo;
import modelpojo.vo.saleadjust.DishesResponse;

import java.util.List;
import java.util.TreeMap;

/**
 * <p>
 * 菜品信息服务类
 * </p>
 *
 * @author lixiang
 * @since 2019-09-04
 */
public interface DishesService {

    /**
     * 菜品信息数据列表
     * @param query
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList getDishesList(DishesDto query, int pageNo, int pageSize, String orderBy, Integer type);

    /**
     * 删除菜品信息
     * @param dishId
     */
    void delete(Integer dishId, Long projectId, Integer type, Long accountId);

    /**
     * 根据id查询
     * @param dishId
     * @return
     */
    DishesDto queryById(Integer dishId, Long projectId, Integer type);


    /**
     * 根据ids查询(excel导出)
     * @param dishIds
     * @return
     */
    List<DishesDto> queryByIds(DishesDto query, String dishIds, Integer type);

    /**
     * 新增/修改菜品信息
     *
     * @param dishesDto
     */
    void saveDishes(DishesDto dishesDto, Long accountId, Integer type);

    /**
     * 菜品信息单个/批量审核
     * @param dishIds
     */
    void examine(String dishIds, Long accountId, Long projectId, String status);

    /**
     * 菜品淘汰操作
     * @param dishId
     */
    void eliminate(Integer dishId, Long accountId, Long projectId, Integer status);

    /**
     * 查询是否存在重复的供菜品编号
     * @return
     */
    DishesDto getIsDishCode(String dishCode, Long projectId);


    /**
     * 查询是否存在重复的供菜品名称
     * @return
     */
    DishesDto checkDishName(String dishNanme, Long projectId, Integer dishId,Integer dishType);


    /**
     * 菜品编号生成
     * @return
     */
    String getDishCode();

    /**
     * 获取菜品类型
     * @return
     */
    List<CatecommTssPubdatadictModel> getPeriod(String type);


    /**
     * 获取菜品规格
     * @return
     */
    List<CatecommTssDatadictModel> getPell(String type, Long projectId);

    /**
     * 税率查询
     * @return
     */
    List<CatecommTsbTaxModel> getTax(Long projectId);

    /**
     * 新增/修改口味
     * @param query
     */
    CateringTcbDishTasteModel saveDishTaste(CateringTcbDishTasteModel query, Long accountId);

    /**
     * 删除口味
     * @param projectId
     */
    void deleteDishTaste(Long projectId, Integer dishTasteId);


    /**
     * 添加组成菜品数据列表
     * @param query
     * @return
     */
    List<DishesSpecDto> getDishesGroupList(DishesDto query);

    /**
     * 查询菜品口味
     * @param projectId
     * @return
     */
    List<CateringTcbDishTasteModel> getDishTasteList(Long projectId, Integer dishId);

    /**
     * 菜品添加备注
     * @param query
     */
    void editRemark(CateringTcbDishesModel query);

    /**
     * 半成品条码校验
     * @param dishBarcode
     */
    boolean checkDishBarcode(String dishBarcode, Long projectId);

    /**
     * 菜品修改图片
     * @param dishimgsModels
     */
    void uploadImage(List<CateringTcbDishimgsModel> dishimgsModels, Long accountId, Long projectId);


    /**
     * 查询是否存在重复的菜品条码
     * @return
     */
    CateringTcbDishesModel getIsBarCode(String barCode, Long projectId);


    /**
     * 查询所有菜品分类
     * @param projectId
     * @return
     */
    List<CateringTccDishesClassModel> getAllDisheClass(Long projectId);


    /**
     * 查询是否有子级分类
     * @param projectId
     * @return
     */
    List<CateringTccDishesClassModel> queryDishClassByDishClassId (Integer dishClassId, Long projectId);


    /**
     * 根据分类ID获取分类信息
     * @param projectId
     * @return
     */
    CateringTccDishesClassModel getDishClass(Integer dishClassId, String dishClassCode, Long projectId);


    /**
     * 预导入菜品信息导入
     * @param excel
     * @param projectId
     * @param projectRootId
     * @param accountId
     * @return
     */
    String preImportDishes(Excel<DishesExeclVo> excel, Long projectId, Long projectRootId, Long accountId);

    /**
     * 确认导入菜品
     * @param redisKey
     * @param pageNo
     * @param pageSize
     * @param type
     * @param projectId
     * @param projectRootId
     * @param accountId
     * @return
     */
    DishesResponse listImportDishes(String redisKey, Integer pageNo, Integer pageSize, Integer type, Long projectId, Long projectRootId, Long accountId);

    /**
     * 批量提交
     * @param dishIds,
     * @param projectId
     */
    void batchCommit(String dishIds, Long projectId, Long accountId);

    /**
     * 反审操作
     * @param dishId
     * @param projectId
     */
    void counterTrial(Integer dishId, Long projectId, Long accountId);

    /**
     * 菜品成本对比查询
     * @param projectId
     */
    ModelPagedList<TreeMap> dishesCostContrast(Long projectId, Long accountId, Integer gzoneId, String dishName, Integer pageNo, Integer pageSize);

}
