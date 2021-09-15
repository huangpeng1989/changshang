package com.goods.service.adjust;


import entity.ModelPagedList;
import excel.Excel;
import modelpojo.model.CatecommTsbTax;
import modelpojo.model.CommAdjustDto;
import modelpojo.model.CommodityTcjAdjust;
import modelpojo.vo.CommoAdjustVo;
import modelpojo.vo.CommodityTcjAdjustVo;
import modelpojo.vo.caterAdjust.PriceRetrunVo;
import modelpojo.vo.commodityinfo.CommodityAdjustExeclVo;
import modelpojo.vo.saleadjust.CommodityVo;

import java.util.List;


/**
 * 进价调价功能模块接口
 * @Author wenbin.wang
 * @Date 2019/08/23
 */
public interface AdjustApi {

    /**
     *@Description 进价调价维护列表查询
     *@param  commodityTcjAdjust
     *@return ModelPagedList<CommodityTcjAdjustAdjust>
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
   ModelPagedList<CommodityTcjAdjust> adjustList(CommodityTcjAdjust commodityTcjAdjust, Long projectId, String comName);


    /**
     *@Description 查看调价单信息
     *@param adjCode   adjStatus  projectId
     *@return CommodityTcjAdjustAdjustVo
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    CommodityTcjAdjustVo getAdjustInfo(String adjCode, Long projectId, Long projectRootId);


    /**
     *@Description 删除调价单维护列表信息
     *@param adjId   adjStatus  projectId
     *@return int
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    int delAdjust(Integer adjId,Long projectId);

    /**
     *@Description 调价单审核
     *@param  adjStatus  projectId
     *@return void
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    void toExamineAdjust(String adjId,Integer adjStatus,Long projectId,Long userId);


    /**
     *@Description 添加调价商品查询
     *@param  suppCode  projectId comClassCode  comKey
     *@return List<CommodityTcbComVo>  商品信息集合
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    ModelPagedList<CommodityVo> selectCommodity(Integer comId, String suppCode, Integer comClassCode, String comKey, Long projectId, Long projectRootId, Integer suppId, Integer pageNo, Integer pageSize);



    /**
     *@Description 新增调价单-提交审核
     *@param  commodityTcjAdjustVo
     *@return List<CommodityTcbComVo>  商品信息集合
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    int addAdjustToExamine(CommodityTcjAdjustVo commodityTcjAdjustVo,Long userId,Long projectId,Long projectRootId);


    /**
     *@Description 获取税率表信息
     *@param
     *@return CatecommTsbTax
     *@date 2019-09-05 13:32
     *@auther wangwenbin
     */
    List<CatecommTsbTax> getTsbTaxInfo(Integer taxId, Integer status, Long projectId, Long projectRootId);


    /**
     * 商品进价查询报表
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList<CommAdjustDto> getCommdidtyAdjust(int pageNo, int pageSize, String comName, String date, String suppName, Long projectId);


   /**
    * 商品进价调价导入
    * @param excel
    * @param projectId
    * @param projectRootId
    * @param accountId
    * @return
    */
   List<PriceRetrunVo> importComm(Excel<CommodityAdjustExeclVo> excel, Long projectId, Long projectRootId, Long accountId);

    /**
     * 批量提交
     * @param adjIds
     * @param projectId
     */
    void adjustBatchCommit(String adjIds, Long projectId);

    /**
     * 反审操作
     * @param adjId
     * @param projectId
     */
    void counterTrial(Integer adjId, Long projectId, Long accountId);


    /**
     * 查询商品是否存在 新增、待审核、审核驳回、待生效状态下的税率调整单
     * @param projectId
     * @param comIds
     * @return
     */
    String getTaxCom(Long projectId, String comIds, Integer suppId);

   /**
    * 商品进价调价单excel导出
    * @param projectId
    * @param adjIds
    * @param adjStatus
    * @param adjCode
    * @param comName
    * @return
    */
   List<CommoAdjustVo> excelOutComAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String comName);

}
