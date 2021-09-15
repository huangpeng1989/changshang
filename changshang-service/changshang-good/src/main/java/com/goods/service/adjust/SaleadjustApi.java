package com.goods.service.adjust;


import entity.ModelPagedList;
import modelpojo.model.CatecommTssPubdatadict;
import modelpojo.model.ComSalePricetDto;
import modelpojo.model.CommodityTcjSaleadjustModel;
import modelpojo.vo.CommoditySaleAdjustVo;
import modelpojo.vo.saleadjust.PagerObject;

import java.util.List;


public interface SaleadjustApi {

    /****
     * 售价调价维护列表查询
     * @param adjCode
     * @param status
     * @param projectId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PagerObject<CommodityTcjSaleadjustModel> saleadjustList(String adjCode, Integer status, String comName, Long projectId, Integer pageNo,
                                                                   Integer pageSize);


    /*****
     * 根据调价单id和项目id删除对应的调价单
     * @param adjId
     * @param projectId
     * @return
     */

    public Integer delAleadjust(Integer adjId, Long projectId);






    /*****
     *  据调价单id和项目id,审核状态来批量修改审梳状态
     * @param adjId
     * @param projectId
     * @param status
     * @return
     */
    public String examinationAleadjust(String adjId, Long projectId, Integer status, Integer userid);


    /******
     * 根据供应商id，商品分类编码，商品的名称或编码或条码，价格等级id查询对应的商品信息
     * @param comClassCode
     * @param cominfo
     * @param comGrade
     * @return
     */
    public ModelPagedList selectCommodity(String comClassCode, String cominfo, Integer comGrade, Long projectId, Integer pageNo, Integer pageSize);



    /******
     * 新增调价单信息
     * @param info
     * @return
     */
    public Integer saveSaleadjust(CommodityTcjSaleadjustModel info);



    /*****
     * 根据调价售价订id和项目id查询对应的信息
     * @param adjId
     * @param projectId
     * @return
     */

    CommodityTcjSaleadjustModel selectCommodityInfo(Integer adjId, Long projectId);


    /*****
     * 根据调价售价单id和项目id修改对应的调价售价单商品信息
     * @param info
     * @return
     */
    public Integer updeteSaleadjust( CommodityTcjSaleadjustModel info);


    /*****
     * 根据项目id和表名生成售价，进价单单号
     * @param projectId
     * @param tableName
     * @return
     */
    public String sysGetBillCode(Long projectId, String tableName);


    /******
     * 查询全局字典表的字典信息
     * @return
     */
    public List<CatecommTssPubdatadict> selectCatecommTssPubdatadict();

    /******
     * 查询项目字典表的字典信息
     * @return
     */
    public List selectCatecommTssDatadict(Long projectId);


    /**
     * 商品售价查询报表
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList<ComSalePricetDto> getComSalePrice(int pageNo, int pageSize, String comName, String date, Integer gradeId, Long projectId);


    /**
     * 批量提交
     * @param adjIds
     * @param projectId
     */
    void saleadjustBatchCommit(String adjIds, Long projectId);


    /**
     * 反审操作
     * @param adjId
     * @param projectId
     */
    void counterTrial(Integer adjId, Long projectId, Long accountId);

    /**
     * 商品售价调价单excel导出
     * @param projectId
     * @param adjIds
     * @param adjStatus
     * @param adjCode
     * @param comName
     * @return
     */
    List<CommoditySaleAdjustVo> excelOutComSaleAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String comName);

}
