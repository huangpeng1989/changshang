package com.goods.service.reportLoss;


import entity.ModelPagedList;
import modelpojo.vo.purchaseorreturn.*;

import java.util.List;

public interface ReturnOrderApi {

	BillCheckMthVo saveOrUpdateReturnOrder(ReturnOrderVo purchaseOrderVo, Long user, Long projectRootId, Long projectId) throws Exception;

	ReturnOrderVo getReturnOrder(Integer rtnBillId, Integer whinBillId, Integer acptBillId, Integer whId, Long projectId) throws Exception;

	ModelPagedList<ReturnOrderListVo> listReturnOrder(ReturnOrderListVo purchaseOrderListVo, Long projectId, Long accountId) throws Exception;

	void checkOrDeleteReturnOrder(Integer[] ids, Integer status, Integer delete, Long projectId, Long user) throws Exception;

	/**
	 * @param projectId
	 * @param dealId 单据id
	 * @param flowType 业务类型
	 * @param moduleId 模块ID 商品10 餐饮20
	 * @param blEmpId 审核人id
	 * @return
	 * @throws Exception
	 */
	BillCheckMthVo callBillCheckMth(Long projectId, Integer dealId, Integer flowType, Integer moduleId, Long blEmpId, Integer payMentId);


    ModelPagedList<ReturnableComVo> returnableComList(Long projectId, Integer suppId, String acptBillCode, String comNameOrCode, int pageNo, int pageSize);

	List<CheckComRtnBillCodeVo> checkComRtnBillCode(Long projectId, String rtnBillIds);

}
