package com.goods.service.reportLoss;


import entity.ModelPagedList;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotion;

import java.util.List;
import java.util.TreeMap;


public interface FreePromotionApi {

    /****
     * @Author huangpeng
     * @Description //查看商品，原材料，菜品满赠促销列表分页页面
     * @Date 11:20 2021/6/2
     * @Param
     * @return
     **/
    public ModelPagedList getFreePromotionList(String freeCode, String freeName, String freeStartDay, String freeEndDay,
                                               Integer goodType, Integer freeStatus, Long projectId, Integer pageNo, Integer pageSize);

    /***
     * @Author huangpeng
     * @Description //查看商品，原材料，菜品满赠促销单选择的营业点下的对应的可售商品，可售原材料，可售菜品信息
     * @Date 14:39 2021/6/2
     * @Param
     * @return
     **/
    public ModelPagedList getPromotionGoods(Integer gzoneId,Integer goodType,String classCode,String comName,Integer billType,
                                       Long projectId,Integer pageNo,Integer pageSize);


    /****
     * @Author huangpeng
     * @Description //新增编辑商品，原材料，菜品满赠促销单促销单信息
     * @Date 14:30 2021/6/3
     * @Param
     * @return
     **/
    public  String insertFreePromotionInfo(CatecommFreePromotion info, Long projectId, Long accontId) throws Exception;


    /***
     * @Author huangpeng
     * @Description //根据促销单id查询对应促销单的信息
     * @Date 16:39 2021/6/3
     * @Param
     * @return
     **/
    public TreeMap getFreePromotionInfo(Integer freeId, Long projectId);


    /****
     * @Author huangpeng
     * @Description //修改促销单各种状态
     * @Date 9:46 2021/6/4
     * @Param
     * @return
     **/
    public String updateFreePromotionStatus(Integer freeId,Integer status,String freeStartDay,String freeEndDay,String freeRemark,Long projectId,Long accountId) throws Exception;


    /***
     * @Author huangpeng
     * @Description //查询促销单营业点信息
     * @Date 14:31 2021/6/4
     * @Param
     * @return
     **/
    public  ModelPagedList getFreePromotionGzoneInfo(String codeAndName,Integer goodType,Long projectId,Integer pageNo,Integer pageSize);


    /***
     * @Author huangpeng
     * @Description //查看原材料，商品成本信息
     * @Date 16:53 2021/6/7
     * @Param
     * @return
     **/
    public List<TreeMap> getComCostPrice(Long projectId, Integer moduleId, Integer goodType, String comdId);


    /****
     * @Author huangpeng
     * @Description //满赠，时段，满减促销定时任务修改促销单的状态定时任务方法
     * @Date 10:55 2021/6/8
     * @Param
     * @return
     **/
    public  String preePromotionJob();

    /**
     * 下架操作时，增加对营销方案参与的商品、原材料、菜品或者赠品进行判断
     * @param projectId
     * @param comIds
     * @param goodType 11003商品； 11004原材料；11001菜品
     */
    String isMarketing(Long projectId, String comIds, int goodType, Integer gzoneId);

}

