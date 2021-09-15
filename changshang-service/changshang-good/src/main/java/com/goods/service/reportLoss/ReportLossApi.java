package com.goods.service.reportLoss;



import entity.ModelPagedList;
import modelpojo.model.CatecommTsbWarehouseModel;
import modelpojo.model.CommodityWhHandOfLossBill;
import modelpojo.vo.CommodityLossBillSummaryVo;

import java.util.List;


/**
 * 报损
 */
public interface ReportLossApi {

    /**
     *@Description 报损/溢列表
     *@param mhId  startOlBillDate   endOlBillDate  olBillCode   olStatus   billType   projectId   projectRootId   pageNo   pageSize
     *@return
     *@date 2019-09-17 16:34
     *@auther wangwenbin
     */
    ModelPagedList<CommodityWhHandOfLossBill> reportLossList(Integer mhId, String startOlBillDate, String endOlBillDate, String olBillCode, Integer olStatus, Integer billType, Long projectId, Long projectRootId, Integer pageNo, Integer pageSize, Long accountId);

    /**
     *@Description 修改报损/溢信息
     *@param
     *@return
     *@date 2019-09-17 16:38
     *@auther wangwenbin
     */
    void updateReportLoss(CommodityWhHandOfLossBill lossBill,Long accoutId,Long projectId,Long projectRootId);


    /**
     *@Description 新增报损/溢出单
     *@param  lossBill   projectId   projectRootId
     *@return
     *@date 2019-09-17 16:39
     *@auther wangwenbin
     */
    void addReportLoss(CommodityWhHandOfLossBill lossBill,Long projectId,Long projectRootId,Long accoutId);


    /**
     *@Description 查看报损单/溢信息
     *@param   projectId   projectRootId  billType  olBillId
     *@return
     *@date 2019-09-17 16:42
     *@auther wangwenbin
     */
    CommodityWhHandOfLossBill getReportLossInfo(Long projectId,Long projectRootId,Integer billType,Integer olBillId);


    /**
     *@Description 删除报损/溢单信息
     *@param   projectId  projectRootId   billType   olBillId
     *@return
     *@date 2019-09-17 16:45
     *@auther wangwenbin
     */
    void delReportLoss(Long projectId,Long projectRootId,Integer billType,Integer olBillId,Long accountId);



    /**
     *@Description 审核（批量）报损/溢单信息
     *@param  projectId   projectRootId olStatus   billType  olBillId
     *@return
     *@date 2019-09-17 16:47
     *@auther wangwenbin
     */
    void toExamineReportLoss(Long projectId, Long projectRootId, Integer billType, Integer olStatus, String olBillId, Long accountId) throws Exception;



    /**
     * 生成报损/溢打印条形码
     */
    String createReportLossBarCode(Long projectId,  Long projectRootId,Integer olBillId, Integer billType);


    /**
     *  生成报损/溢生成编号
     * @return
     */
    String getLossBillCode(Long projectId, String type);


    /**
     * 生成条形码---公共方法
     * @param billBarcode  条形码编号
     * @return
     */
    String createBarCode (String billBarcode);


    /**
     *  手工报损/溢报表 or 盘点报损/溢报表
     */
    Object lossBillReportFrom(String projectIds,String type,String orgName, String whKey, String comKey, String billCode, Integer billType, String comClassCode, String createStartTime, String createEndTime, Long accountId, Long projectId, Long projectRootId,Integer pageNo,Integer pageSize);


    /**
     * 手工报损/溢报表 or 盘点报损/溢报表合计信息
     * @param projectIds
     * @param type
     * @param orgName
     * @param whKey
     * @param comKey
     * @param billCode
     * @param billType
     * @param comClassCode
     * @param createdStartTime
     * @param createdEndTime
     * @param accountId
     * @param projectId
     * @param projectRootId
     * @return
     */
    CommodityLossBillSummaryVo lossBillReportFromNum(String projectIds, String type, String orgName, String whKey, String comKey, String billCode, Integer billType, String comClassCode, String createdStartTime, String createdEndTime, Long accountId, Long projectId, Long projectRootId);

    /**
     * 统计手工报损/溢(盘点报损/)汇总数据
     */
    List<CommodityLossBillSummaryVo> lossBillReportSummary(String projectIds,Long projectId,Long projectRootId,String type,Integer billType,String whKey,String comKey,String billCode,String createdStartTime, String createdEndTime,String comClassCode);


    /**
     *
     * @param nodeType   bloc为集团 company为公司
     * @param rootId     集团ID
     * @param parentManageId  公司ID
     * @param projectId
     * @param companyName   公司名称
     * @param orgName       景区名称
     * @param whKey         仓库名称或景区编号
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelPagedList<CatecommTsbWarehouseModel>  warehouseList(String nodeType, Long rootId, Long parentManageId, Long projectId, String companyName, String orgName, String whKey, Integer pageNo, Integer pageSize);

}
