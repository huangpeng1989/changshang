package com.restaurant.service.rawmater;

import entity.ModelPagedList;
import excel.Excel;
import modelpojo.model.CateringTcjAdjust;
import modelpojo.vo.CateringAdjustVo;
import modelpojo.vo.CateringTcbRowmaterialVo;
import modelpojo.vo.CateringTcjAdjustDetailVo;
import modelpojo.vo.CateringTcjAdjustVo;
import modelpojo.vo.caterAdjust.PriceChangeVo;
import modelpojo.vo.caterAdjust.PriceRetrunVo;
import modelpojo.vo.saleadjust.CateringAdjusrExeclVo;

import java.util.List;

/**
 * @Description 原材料进价调价
 * @Author wenbin.wang
 * @Date 2019-11-21 11:06
 */
public interface CaterTcjAdjustApi {

    ModelPagedList<CateringTcjAdjustVo> caterAdjustList(String adjCode, Integer adjStatus, Long projectId, Integer pageNo, Integer pageSize, String rmName);


    void saveCaterAdjust(CateringTcjAdjustVo cateringTcjAdjustVo, Long projectId, Long projectRootId, Long accountId);


    void upCaterAdjust(CateringTcjAdjustVo cateringTcjAdjustVo, Long projectId, Long projectRootId, Long accountId)  throws Exception;

    CateringTcjAdjust getCaterAdjustInfo(Integer adjId, Long projectId);


    void delOrToExamieCaterAdjust(Long projectId, Long projectRootId,Long accountId, String adjId, Integer adjStatus, Integer delete)  throws Exception;

    // 查询可售原材料列表
    ModelPagedList<CateringTcbRowmaterialVo> getCanSaleRowmaterList(String suppKey, String rmClassCode, String rmKey, Long projectId, Integer suppId, Integer pageNo, Integer pageSize);


    // 原材料进价调价导入
    List<PriceRetrunVo> importRawmaterAdjust(Excel<CateringAdjusrExeclVo> excel, Long projectId, Long projectRootId, Long accountId);





    /***原材料进价调价报表列表***/
    ModelPagedList<CateringTcjAdjustDetailVo> rawAdjustReportList(String suppName, String rmKey, String startTime, String endTime, Long projectId, Integer pageNo, Integer pageSize);


    /**
     * 售价调价审核后调用的存储过程
     * @param projectId
     * @param moduleId 10商品 20餐饮
     * @param changeType 1进价 2售价
     * @param adjCode  调价单号
     * @return
     * @throws Exception
     */
    PriceChangeVo callPriceChange(Long projectId, Integer moduleId , Integer changeType , String adjCode);


    /**
     * 售价调价停用调用的存储过程
     * @param projectId
     * @param moduleId 10商品 20餐饮
     * @param changeType 1进价 2售价
     * @param adjCode  调价单号
     * @return
     * @throws Exception
     */
    PriceChangeVo cllPriceChangeBack(Long projectId, Integer moduleId, Integer changeType , String adjCode);

    /**
     * 批量提交
     * @param adjIds
     * @param projectId
     */
    void batchCommit(String adjIds, Long projectId);

    /**
     * 反审操作
     * @param adjId
     * @param projectId
     */
    void counterTrial(Integer adjId, Long projectId, Long accountId);

    /**
     * 查询原材料是否存在 新增、待审核、审核驳回、待生效状态下的税率调整单
     * @param projectId
     * @param rmIds
     * @return
     */
    String getTaxRm(Long projectId, String rmIds, Integer suppId);

    /**
     * 原材料进价调价单excel导出
     * @param projectId
     * @param adjIds
     * @param adjStatus
     * @param adjCode
     * @param rmName
     * @return
     */
    List<CateringAdjustVo> excelOutAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String rmName);

}
