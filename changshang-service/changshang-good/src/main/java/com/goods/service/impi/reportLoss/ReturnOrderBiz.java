package com.goods.service.impi.reportLoss;


import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.WareJurisdictionFeign;
import com.goods.service.allocation.CollarUseService;
import com.goods.service.reportLoss.ReportLossApi;
import com.goods.service.reportLoss.ReturnOrderApi;
import com.google.common.base.Strings;

import entity.ModelPagedList;
import modelpojo.*;
import modelpojo.model.CatecommTssPubdatadictModel;
import modelpojo.model.CatedityPaymentDaysModel;
import modelpojo.model.CommodityWhInReturn;
import modelpojo.model.CommodityWhInReturnDtl;
import modelpojo.model.contract.CommodityContract;
import modelpojo.vo.purchaseorreturn.*;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.DeleteBuilder;
import org.lufei.ibatis.builder.InsertBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ReturnOrderBiz implements ReturnOrderApi {

	AutoBaseDao autoBaseDao = new AutoDaoImpl();


	@Resource
	private SupplierServiceFeign supplierService;

	@Resource
	private CollarUseService collarUseService;

	@Resource
	private ReportLossApi reportLossApi;

	@Resource
	WareJurisdictionFeign wareJurisdictionService;


	@Override
	@Transactional(rollbackFor=Exception.class)
	public BillCheckMthVo saveOrUpdateReturnOrder(ReturnOrderVo returnOrderVo, Long user, Long projectRootId,
												  Long projectId) throws Exception {
		//处理退货单表逻辑
		CommodityWhInReturn commodityWhInReturn = returnOrderVo.getCommodityWhInReturn();
		commodityWhInReturn.setProjectRootId(projectRootId);
		commodityWhInReturn.setModifier(user);
		//commodityWhInReturn.setBlEmpId(user);
		//commodityWhInReturn.setBlTime(new Date());
		commodityWhInReturn.setReturnTime(new Date());
		Integer rtnBillId = commodityWhInReturn.getRtnBillId();
		//如果审核通过由存储过程修改审核状态
		Integer status = commodityWhInReturn.getStatus();
		if (ReturnStatusConstant.RETURN_PASS.equals(status)) {
			commodityWhInReturn.setStatus(ReturnStatusConstant.RETURN_PASSING);
		}
		if(null==rtnBillId) {
			commodityWhInReturn.setProjectId(projectId);
			commodityWhInReturn.setCreater(user);
			rtnBillId = supplierService.getTableId(projectId, "commodity_wh_in_return", 1);
			commodityWhInReturn.setRtnBillId(rtnBillId);
			String billBarcode = collarUseService.getBarCode(projectId, BarCodeConstant.COMMODITY, 0, BarCodeConstant.RETURN, rtnBillId,BarCodeConstant.PAR_RESULTTYPE).get("code").toString();
			commodityWhInReturn.setBillBarcode(billBarcode);
			commodityWhInReturn.setBillBarImgurl(reportLossApi.createBarCode(billBarcode));
			InsertBuilder<CommodityWhInReturn> insertBuilder = InsertBuilder.build(commodityWhInReturn).optSql();
			autoBaseDao.save(insertBuilder);
		}else {
			commodityWhInReturn.setSyncStatus(SyncStatus.NOT_SYNC);
			commodityWhInReturn.setRtnBillId(null);
			UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhInReturn.class).setBean(commodityWhInReturn).whereEq("project_id", projectId).whereEq("rtn_bill_id", rtnBillId);
			autoBaseDao.update(updateBuilder);
			//删除以前的详细表
			DeleteBuilder deleteBuilder = DeleteBuilder.build("commodity_wh_in_return_dtl").whereEq("project_id", projectId).whereEq("rtn_bill_id", rtnBillId);
			autoBaseDao.delete(deleteBuilder);
		}
		//处理退货单详细表逻辑
		List<CommodityWhInReturnDtl> commodityWhInReturnDtlLst = returnOrderVo.getCommodityWhInReturnDtlLst();
		int size = commodityWhInReturnDtlLst.size();
		InsertBuilder<CommodityWhInReturnDtl> insertBuilder;
		CommodityWhInReturnDtl commodityWhInReturnDtl = new CommodityWhInReturnDtl();
		for (int i = 0; i < size; i++) {
			commodityWhInReturnDtl = commodityWhInReturnDtlLst.get(i);
			commodityWhInReturnDtl.setProjectId(projectId);
			commodityWhInReturnDtl.setProjectRootId(projectRootId);
			commodityWhInReturnDtl.setModifier(user);
			commodityWhInReturnDtl.setCreater(user);
			commodityWhInReturnDtl.setRtnBillId(rtnBillId);
			insertBuilder = InsertBuilder.build(commodityWhInReturnDtl).optSql();
			autoBaseDao.save(insertBuilder);
		}
		//审核时存完数据调用存储过程结转库存
		if (ReturnStatusConstant.RETURN_PASS.equals(status)) {
			return callBillCheckMth(projectId, rtnBillId, BarCodeConstant.RETURN, BarCodeConstant.COMMODITY, user,0);
		}
		return null;
	}

	@Override
	public ReturnOrderVo getReturnOrder(Integer rtnBillId,Integer whinBillId,Integer acptBillId, Integer whId, Long projectId) {
		ReturnOrderVo returnOrderVo = new ReturnOrderVo();
		NativeSQLBuilder<CommodityWhInReturnVo> query1 = NativeSQLBuilder.build(CommodityWhInReturnVo.class);
		query1.setSql("SELECT a.*,(SELECT a1.nick_name FROM account a1 JOIN commodity_wh_in_return a2 ON a2.project_id="+projectId+" AND a2.rtn_bill_id="+rtnBillId+" AND a2.creater=a1.id WHERE a1.is_deleted='false') createrName,(SELECT a1.nick_name FROM account a1 JOIN commodity_wh_in_return a2 ON a2.project_id="+projectId+" AND a2.rtn_bill_id="+rtnBillId+" AND a2.bl_emp_id=a1.id WHERE a1.is_deleted='false') blEmpName,b.supp_name,i.wh_name FROM commodity_wh_in_return a LEFT JOIN commodity_tcb_supplier b ON b.project_id="+projectId+" AND a.supp_id=b.supp_id AND b.is_delete="+Type.NOT_DELETED+" LEFT JOIN catecomm_tsb_warehouse i ON i.project_id="+projectId+" AND i.wh_id=a.in_wh_id AND i.is_delete="+Type.NOT_DELETED+" WHERE a.project_id="+projectId+" AND a.rtn_bill_id="+rtnBillId+" AND a.is_delete="+Type.NOT_DELETED);
		CommodityWhInReturnVo commodityWhInReturnVo = null;
		List<CommodityWhInReturnVo> commodityWhInReturnVoLst = autoBaseDao.listAll(query1);
		if (autoBaseDao.listAll(query1).size()>0) {
			commodityWhInReturnVo = commodityWhInReturnVoLst.get(0);
			if(commodityWhInReturnVo != null){
				String billBarImgurl = reportLossApi.createBarCode(commodityWhInReturnVo.getBillBarcode());
				commodityWhInReturnVo.setBillBarImgurl(billBarImgurl);
			}
			returnOrderVo.setCommodityWhInReturnVo(commodityWhInReturnVo);
		}
		NativeSQLBuilder<CommodityWhInReturnDtlVo> query = NativeSQLBuilder.build(CommodityWhInReturnDtlVo.class);
		query.setSql("  SELECT\n" +
				"   b.com_barcode,\n" +
                "   c.com_name,\n" +
				"   d.sup_com_id,\n" +
				"   a.*, \n" +
				"   r.acpt_bill_id,\n" +
				"   r.acpt_bill_code,\n" +
                "   (SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = a.p_sale_unit) AS pSaleCommUnitName,\n" +
				"   f.wh_stock wh_stock\n" +
				"  FROM\n" +
				"   commodity_wh_in_return_dtl a\n" +
				"  LEFT JOIN commodity_wh_in_return r ON r.project_id = a.project_id\n" +
				"  AND r.rtn_bill_id = a.rtn_bill_id\n" +
				"  LEFT JOIN commodity_tcb_salecom b ON b.project_id = a.project_id\n" +
				"  AND a.com_id = b.com_id\n" +
				"  AND a.p_sale_com_id = b.sale_com_id\n" +
				"  AND b.is_delete = 0\n" +
				"  LEFT JOIN commodity_tcb_com c ON c.project_id = a.project_id\n" +
				"  AND a.com_id = c.com_id\n" +
				"  AND c.is_delete = 0\n" +
				"  LEFT JOIN commodity_tcb_suppcom d ON a.com_id = d.com_id\n" +
				"  AND d.is_delete = 0\n" +
				"  AND r.supp_id = d.supp_id\n" +
				"  AND d.project_id = a.project_id\n" +
				"  LEFT JOIN catecomm_tsb_tax e ON e.project_id = a.project_id\n" +
				"  AND c.ph_tax_id = e.tax_id\n" +
				"  AND e.is_delete = 0\n" +
				"  LEFT JOIN v_commodity_stock_now f ON f.com_id = a.com_id\n" +
				"  AND b.sale_com_id = f.sale_com_id\n" +
				"  AND f.project_id = a.project_id\n" +
				"  AND f.wh_id = "+whId+"\n" +
				"  WHERE\n" +
				"   a.is_delete = 0\n" +
				"  AND a.rtn_bill_id = "+rtnBillId+"\n" +
				"  AND a.project_id = "+projectId+" order by f_entry_id");

        List<CommodityWhInReturnDtlVo> commodityWhInReturnDtlVoLst = autoBaseDao.listAll(query);
        Map<Integer, String> dictMap = getPubDictMap();
        if (null!=commodityWhInReturnDtlVoLst) {
        	commodityWhInReturnDtlVoLst.forEach(x->{
        		String comUnitName = dictMap.get(x.getComUnit());
        		x.setComUnitName(comUnitName);
        	});
		}
		ModelPagedList<ReturnableComVo> modelList = returnableComList(projectId,null,commodityWhInReturnVo.getAcptBillCode(),null,1,100000);
		List<ReturnableComVo> returnList = modelList.getData();
		//查询验收单对应的可退数量和可退赠品数量、库存数量、冻结数量
		if(null != commodityWhInReturnDtlVoLst && commodityWhInReturnDtlVoLst.size() > 0 && null != returnList && returnList.size() > 0 ){
			commodityWhInReturnDtlVoLst.forEach(x -> {
				returnList.forEach(k -> {
					if(x.getComId().equals(k.getComId())){
						x.setReturnableGiftCount(k.getReturnableGiftCount());
						x.setReturnableOrderCount(k.getReturnableOrderCount());
						x.setWhStock(k.getWhStock());
						x.setFreeaeCount(k.getFreeaeCount().subtract(x.getOrderCount()));
						x.setReturnOrderPageCount(k.getOrderPageCount());
						x.setReturnableGiftCount(k.getGiftPageCount());
					}
				});
			});
		}
        returnOrderVo.setCommodityWhInReturnDtlVoLst(commodityWhInReturnDtlVoLst);
		return returnOrderVo;
	}

	public Map<Integer, String> getPubDictMap(){
		//查询字典表，用于翻译商品基础信息表的商品类型、经营方式
        NativeSQLBuilder<CatecommTssPubdatadictModel> dictQuery = NativeSQLBuilder.build(CatecommTssPubdatadictModel.class);
        dictQuery.setSql("select type_code, type_name from catecomm_tss_pubdatadict where p_dict_status = "+Type.DICT_ENABLE);
        List<CatecommTssPubdatadictModel> dictList = autoBaseDao.listAll(dictQuery);
        Map<Integer, String> dictMap = new HashMap<Integer, String>();
        for (CatecommTssPubdatadictModel dict : dictList) {
			dictMap.put(dict.getTypeCode(), dict.getTypeName());
		}
        return dictMap;
	}

	@Override
	public ModelPagedList<ReturnOrderListVo> listReturnOrder(ReturnOrderListVo returnOrderListVo, Long projectId,Long accountId) {
		NativeSQLBuilder<ReturnOrderListVo> query = NativeSQLBuilder.build(ReturnOrderListVo.class);
        query.setSql("SELECT a.*,e1.wh_name,d.whin_bill_id,b.type_name status_name,c.nick_name creater_name,d.real_whin_date,e.supp_name,f.order_com_date FROM commodity_wh_in_return a LEFT JOIN catecomm_tss_pubdatadict b ON a.`status` = b.type_code LEFT JOIN account c ON a.creater = c.id AND c.is_deleted='false' LEFT JOIN commodity_wh_in_acpt d ON d.project_id="+projectId+" AND d.acpt_bill_id = a.acpt_bill_id AND d.is_delete="+Type.NOT_DELETED+" LEFT JOIN commodity_tcb_supplier e ON e.project_id="+projectId+" AND a.supp_id = e.supp_id AND e.is_delete="+Type.NOT_DELETED+" LEFT JOIN commodity_wh_in f ON f.project_id="+projectId+" AND f.whin_bill_id=d.whin_bill_id AND f.is_delete="+Type.NOT_DELETED+" LEFT JOIN catecomm_tsb_warehouse e1 ON e1.project_id="+projectId+" AND e1.wh_id=a.in_wh_id AND e1.is_delete="+Type.NOT_DELETED+" WHERE a.is_delete = "+Type.NOT_DELETED+" AND a.project_id ="+projectId);
        Integer inWhId = returnOrderListVo.getInWhId();
        Integer status = returnOrderListVo.getStatus();
        String orderComDateStartTime = returnOrderListVo.getOrderComDateStartTime();
        String orderComDateEndTime = returnOrderListVo.getOrderComDateEndTime();
        String returnTimeStartTime = returnOrderListVo.getReturnTimeStartTime();
        String returnTimeEndTime = returnOrderListVo.getReturnTimeEndTime();
        String realWhinDateStartTime = returnOrderListVo.getRealWhinDateStartTime();
        String realWhinDateEndTime = returnOrderListVo.getRealWhinDateEndTime();
        String suppCode = returnOrderListVo.getSuppCode();
        String suppName = returnOrderListVo.getSuppName();
        String rtnBillCode = returnOrderListVo.getRtnBillCode();
        if (null!=status) {
        	query.appendIfOpt(" and a.status = #{status}", "status" , status);
        }
        if (null!=inWhId) {
        	query.appendIfOpt(" and a.in_whId = #{inWhId}", "inWhId" , inWhId);
        }
        if (!Strings.isNullOrEmpty(orderComDateStartTime)) {
        	query.appendIfOpt(" and a.order_com_date >= #{orderComDateStartTime}", "orderComDateStartTime" , realWhinDateStartTime);
        }
        if (!Strings.isNullOrEmpty(orderComDateEndTime)) {
        	query.appendIfOpt(" and a.order_com_date <= #{orderComDateEndTime}", "orderComDateEndTime" , realWhinDateEndTime);
        }
        if (!Strings.isNullOrEmpty(returnTimeStartTime)) {
        	query.appendIfOpt(" and a.return_time = #{returnTimeStartTime}", "returnTimeStartTime" , returnTimeStartTime);
        }
        if (!Strings.isNullOrEmpty(returnTimeEndTime)) {
        	query.appendIfOpt(" and a.return_time = #{returnTimeEndTime}", "returnTimeEndTime" , returnTimeEndTime);
        }
        if (!Strings.isNullOrEmpty(realWhinDateStartTime)) {
        	query.appendIfOpt(" and a.real_whin_date = #{realWhinDateStartTime}", "realWhinDateStartTime" , realWhinDateStartTime);
        }
        if (!Strings.isNullOrEmpty(realWhinDateEndTime)) {
        	query.appendIfOpt(" and a.real_whin_date = #{realWhinDateEndTime}", "realWhinDateEndTime" , realWhinDateEndTime);
        }
        if (!Strings.isNullOrEmpty(suppName)) {
        	query.appendIfOpt(" and e.supp_name like concat('%',#{suppName},'%')", "suppName" , suppName);
        }
        if (!Strings.isNullOrEmpty(suppCode)) {
        	query.appendIfOpt(" and e.supp_code like concat('%',#{suppCode},'%')", "suppCode" , suppCode);
        }
        if (!Strings.isNullOrEmpty(rtnBillCode)) {
        	query.appendIfOpt(" and a.rtn_bill_code like concat('%',#{rtnBillCode},'%')", "rtnBillCode" , rtnBillCode);
        }
        query.append(" order by a.updated_time desc");
        query.setPage(returnOrderListVo.getPageNo(), returnOrderListVo.getPageSize());

		PagedList<ReturnOrderListVo> pagedList = autoBaseDao.listPage(query);
		for(ReturnOrderListVo vo : pagedList){
			vo.setWhId(vo.getInWhId());
		}
		String whIds = wareJurisdictionService.getAccountWareJurisdictions(projectId, accountId, 2);
		new JurisdictionTypeUtil().getjurisdictionType(pagedList.getData(),whIds);
        return ModelPagedList.convertToModelPage(pagedList);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void checkOrDeleteReturnOrder(Integer[] ids, Integer status, Integer delete, Long projectId, Long user) throws Exception {
		UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhInReturn.class).whereEq("project_id", projectId).whereIn("rtn_bill_id", Arrays.asList(ids));
		if (null!=status) {
			//判断退货单状态是否是待审核
			for (int i = 0; i < ids.length; i++) {
				NativeSQLBuilder select = NativeSQLBuilder.build(CommodityWhInReturn.class)
						.setSql("select * from commodity_wh_in_return where  is_delete=0 and project_id = " + projectId +
								" and rtn_bill_id = '" + ids[i] + "'");
				CommodityWhInReturn lossBill = (CommodityWhInReturn) autoBaseDao.findOne(select);
				if (lossBill.getStatus() != 13301) {
					throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "只能审核待审核的退货单信息！退货单号" + lossBill.getRtnBillCode(), null);
				}
			}
			//如果审核通过由存储过程修改审核状态
			if (ReturnStatusConstant.RETURN_PASS.equals(status)) {
				updateBuilder.set("status", ReturnStatusConstant.RETURN_PASS).set("sync_status", SyncStatus.NOT_SYNC);
			}else {
				updateBuilder.set("status", status).set("sync_status", SyncStatus.NOT_SYNC);
			}
			autoBaseDao.update(updateBuilder);
			//审核通过调用存储过程
			if (ReturnStatusConstant.RETURN_PASS.equals(status)) {
				for (int i = 0; i < ids.length; i++) {
					callBillCheckMth(projectId, ids[i], BarCodeConstant.RETURN, BarCodeConstant.COMMODITY, user,0);
				}
			}
		}
		if (null!=delete) {
			//删除主表
			updateBuilder.set("is_delete", Type.DELETED).set("sync_status", SyncStatus.NOT_SYNC);
			autoBaseDao.update(updateBuilder);
			//删除从表
			updateBuilder = UpdateBuilder.build(CommodityWhInReturnDtl.class).set("is_delete", Type.DELETED).set("sync_status", SyncStatus.NOT_SYNC).whereEq("project_id", projectId).whereIn("rtn_bill_id", Arrays.asList(ids));
			autoBaseDao.update(updateBuilder);
		}
	}

	@Override
	public BillCheckMthVo callBillCheckMth(Long projectId, Integer dealId, Integer flowType, Integer moduleId, Long blEmpId, Integer payMentId){
		//餐饮账期判断是否封账
		if (0 != payMentId) {
			NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CatedityPaymentDaysModel.class)
					.setSql("SELECT * FROM catedity_payment_days\n" +
							"WHERE status = 11809 and payment_days_id =" + payMentId + "\n" +
							"and project_id = " + projectId);
			CatedityPaymentDaysModel paymentDaysModel = (CatedityPaymentDaysModel)autoBaseDao.findOne(sqlBuilder);
			if (null != paymentDaysModel) {
				BillCheckMthVo checkMthVo = new BillCheckMthVo();
				checkMthVo.setRltcode(false);
				checkMthVo.setMsg("当前单据关联的账期已封账！");
				return checkMthVo;
			}

		}
		NativeSQLBuilder<BillCheckMthVo> query = NativeSQLBuilder.build(BillCheckMthVo.class);
        query.setSql("CALL bill_check_mth("+ projectId+","+dealId+","+flowType+","+moduleId+","+blEmpId+")");
		BillCheckMthVo billCheckMthVo = (BillCheckMthVo) autoBaseDao.findOne(query);
		return billCheckMthVo;
	}

	@Override
	public ModelPagedList<ReturnableComVo> returnableComList(Long projectId,Integer suppId, String acptBillCode, String comNameOrCode,int pageNo, int pageSize) {

		if(suppId!=null){
			//判断商品供应商是否存在合同信息
			NativeSQLBuilder queryComContract = NativeSQLBuilder.build(CommodityContract.class)
					.setSql(" SELECT c.*,supp_name contract_supper_name FROM commodity_contract c " +
							" left join commodity_tcb_supplier s on c.contract_supper = s.supp_id and c.project_id = s.project_id " +
							" WHERE c.project_id = "+projectId+" " +
							" AND c.is_delete = 0 AND DATE_FORMAT(now(),'%Y-%m-%d') <= contract_end_time " +
							" AND s.supp_id = " + suppId + " AND contract_stauts = 133003 group by s.supp_id ");
			CommodityContract commodityContract = (CommodityContract)autoBaseDao.findOne(queryComContract);
			if(commodityContract == null){
				throw new RpcException(300, "没有有效的合同信息", null);
			}
		}

		NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(ReturnableComVo.class)
				.setSql("SELECT\n" +
						" con.contract_id,\n" +
						" c.com_id,\n" +
						" c.com_unit,\n" +
						" t.tax_id,\n" +
						" c.com_code,\n" +
						" c.com_name,\n" +
						" c.com_spec,\n" +
						" s.com_barcode,\n" +
						" t.tax_name,\n" +
						" acpt.p_sale_com_id,\n" +
						" s.sale_com_code pSaleComCode,\n" +
						" s.sale_comm_unit pSaleCommUnit,\n" +
						" s.pack_content pSalePackContent,\n" +
						" acpt.g_sale_com_id,\n" +
						" acpt.g_sale_com_code,\n" +
						" acpt.g_sale_unit gSaleCommUnit,\n" +
						" acpt.g_sale_pack_content,\n" +
						" (\n" +
						"  SELECT\n" +
						"   type_name\n" +
						"  FROM\n" +
						"   catecomm_tss_pubdatadict\n" +
						"  WHERE\n" +
						"   catecomm_tss_pubdatadict.type_code = s.sale_comm_unit\n" +
						" ) AS pSaleCommUnitName,\n" +
						" acpt.order_page_count,\n" +
						" acpt.gift_page_count,\n" +
						" re.returnableOrderCount,\n" +
						" re.returnableGiftCount,\n" +
						" f.wh_stock,\n" +
						" IFNULL(v.stock_num,0) freeae_count,\n" +
						" tax_page_price,\n" +
						" notax_page_price\n" +
						"FROM\n" +
						" (\n" +
						"  SELECT\n" +
						"   acpt_bill_code,\n" +
						"   d.project_id,\n" +
						"   f_entry_id,\n" +
						"   d.com_id,\n" +
						"   supp_id,\n" +
						"   g_sale_com_id,\n" +
						" g_sale_com_code,\n" +
						" g_sale_unit,\n" +
						" g_sale_pack_content,\n" +
						"   d.p_sale_com_id,\n" +
						"   a.in_wh_id,\n" +
						"   SUM(order_page_count) order_page_count,\n" +
						"   SUM(gift_page_count) gift_page_count,\n" +
						"   tax_page_price,\n" +
						"   notax_page_price,\n" +
						"   d.tax_id\n" +
						"  FROM\n" +
						"   commodity_wh_in_acpt a\n" +
						"  LEFT JOIN commodity_wh_in_acpt_dtl d ON a.project_id = d.project_id\n" +
						"  AND a.acpt_bill_id = d.acpt_bill_id\n" +
						"  WHERE\n" +
						"   a.is_delete = 0\n" +
						"  AND d.is_delete = 0\n" +
						"  AND d.project_id = "+projectId+"\n" +
						"  AND acpt_bill_code = '"+acptBillCode+"'\n" +
						"  GROUP BY\n" +
						"   acpt_bill_code,\n" +
						"   d.project_id,\n" +
						"   d.com_id,\n" +
						"   d.p_sale_com_id\n" +
						" ) acpt\n" +
						"LEFT JOIN commodity_tcb_com c ON acpt.project_id = c.project_id\n" +
						"AND acpt.com_id = c.com_id\n" +
						"AND c.is_delete = 0\n" +
						"LEFT JOIN commodity_tcb_salecom s ON s.project_id = acpt.project_id\n" +
						"AND acpt.p_sale_com_id = s.sale_com_id\n" +
						"AND s.is_delete = 0\n" +
						"LEFT JOIN catecomm_tsb_tax t ON t.project_id = c.project_id\n" +
						"AND acpt.tax_id = t.tax_id\n" +
						"AND t.is_delete = 0\n" +
						"LEFT JOIN commodity_tcb_suppcom supp ON supp.project_id = acpt.project_id\n" +
						"AND acpt.supp_id = supp.supp_id\n" +
						"AND acpt.com_id = supp.com_id\n" +
						"AND supp.is_delete = 0\n" +
						"LEFT JOIN v_com_returnable_count re ON re.project_id = acpt.project_id\n" +
						"AND re.acpt_bill_code = acpt.acpt_bill_code\n" +
						"AND acpt.p_sale_com_id = re.p_sale_com_id\n" +
						"AND acpt.com_id = re.com_id\n" +
						"left join commodity_contract con on con.project_id = supp.project_id and con.contract_id = supp.contract_id\n" +
						"left join v_commodity_stock_now f ON f.project_id=acpt.project_id AND f.com_id = acpt.com_id AND f.wh_id = acpt.in_wh_id\n" +
						"LEFT JOIN v_commodity_freeze v ON v.project_id = acpt.project_id AND v.com_id = acpt.com_id AND v.wh_id = acpt.in_wh_id\n" +
						"WHERE " );
		queryBuilder.append(" acpt.project_id = "+projectId);
		if(StringUtils.isNotBlank(comNameOrCode)){
			queryBuilder.append(" and ( c.com_name like '%"+comNameOrCode+"%' or c.com_code like'%"+comNameOrCode+"%')");
		}
		queryBuilder.append(" and c.sell_status in(10201,10202,10203) and s.sc_status = 10605 and s.com_status = 1 ");
		//合同必须在有效时间内，且是审核通过状态才能红冲和退货
		queryBuilder.append(" AND con.is_delete = 0 AND (DATE_FORMAT(now(),'%Y-%m-%d') between contract_start_time AND contract_end_time) AND contract_stauts = 133003  order by acpt.f_entry_id");
		queryBuilder.setPage(pageNo,pageSize);
		PagedList pageList = autoBaseDao.listPage(queryBuilder);
		List<ReturnableComVo> returnList = pageList.getData();
		returnList.forEach(x->{
			//库存数量减去冻结数量，实际可用的数量
			BigDecimal stock = x.getWhStock().subtract(x.getFreeaeCount());
			if(stock.compareTo(BigDecimal.ZERO) > 0 ){
				//退货先退赠品数量
				//退货总数量转换成最小单位后的
				BigDecimal reSum = (x.getReturnableGiftCount().add(x.getReturnableOrderCount())).multiply(x.getpSalePackContent());
				//如果退货总数大于库存，表示库存不够
				if(reSum.compareTo(stock) > 0){
					//库存不够并且可退赠品数量大于0，先退赠品
					if(x.getReturnableGiftCount().compareTo(BigDecimal.ZERO)>0){
						//退货赠品总数量转换成最小单位后的
						BigDecimal giftSum = x.getReturnableGiftCount().multiply(x.getpSalePackContent());
						//如果退货赠品总数量大于库存，表示库存不够，可退赠品数为库存数量,可退数量为0
						if(giftSum.compareTo(stock) >= 0){
							x.setReturnableGiftCount(stock.divide(x.getpSalePackContent(),0,BigDecimal.ROUND_DOWN));
							x.setReturnableOrderCount(BigDecimal.ZERO);
						}else{
							x.setReturnableOrderCount((stock.subtract(giftSum)).divide(x.getpSalePackContent(),0,BigDecimal.ROUND_DOWN));
						}
					}else{
						//库存不够且赠品数量为0，可退数量就为库存数量
						x.setReturnableOrderCount(stock.divide(x.getpSalePackContent(),0,BigDecimal.ROUND_DOWN));
					}

				}
			}else{
				//库存不够,可退货订货数量和可退货赠品数量都为0
				x.setReturnableOrderCount(BigDecimal.ZERO);
				x.setReturnableGiftCount(BigDecimal.ZERO);
			}
		});
		return ModelPagedList.convertToModelPage(pageList);

	}

	@Override
	public List<CheckComRtnBillCodeVo> checkComRtnBillCode(Long projectId, String rtnBillIds) {
		NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CheckComRtnBillCodeVo.class)
				.setSql("SELECT\n" +
						" t1.project_id,\n" +
						" c.com_id,\n" +
						" c.com_code,\n" +
						" c.com_name,\n" +
						" s.sale_comm_unit,\n" +
						" (\n" +
						"  SELECT\n" +
						"   type_name\n" +
						"  FROM\n" +
						"   catecomm_tss_pubdatadict\n" +
						"  WHERE\n" +
						"   catecomm_tss_pubdatadict.type_code = s.sale_comm_unit\n" +
						" ) AS saleCommUnitName,\n" +
						" s.pack_content,\n" +
						" t2.returnableOrderCount,\n" +
						" t2.returnableGiftCount,\n" +
						" IFNULL(t3.wh_stock,0) wh_stock,\n" +
						" IFNULL(v.stock_num,0) - IFNULL(t1.order_count, 0) freeae_count,\n" +
						" t1.p_order_page_count,\n" +
						" t1.p_gift_page_count,\n" +
						" t1.order_count,\n" +
						" t1.acpt_bill_code,\n" +
						" t1.rtnBillCodes\n" +
						"FROM\n" +
						" (\n" +
						"  SELECT\n" +
						"   d.project_id,\n" +
						"   d.com_id,\n" +
						"   d.p_sale_com_id,\n" +
						"   r.acpt_bill_code,\n" +
						"   r.acpt_bill_id,\n" +
						"   sum(d.order_count) order_count,\n" +
						"   sum(d.p_order_page_count) p_order_page_count,\n" +
						"   sum(d.p_gift_page_count) p_gift_page_count,\n" +
						"   r.in_wh_id,\n" +
						"   GROUP_CONCAT(\n" +
						"    r.rtn_bill_code SEPARATOR '、'\n" +
						"   ) rtnBillCodes\n" +
						"  FROM\n" +
						"   commodity_wh_in_return r\n" +
						"  LEFT JOIN commodity_wh_in_return_dtl d ON r.project_id = d.project_id\n" +
						"  AND r.rtn_bill_id = d.rtn_bill_id\n" +
						"  WHERE\n" +
						"   r.`status` = 13301\n" +
						"  AND r.is_delete = 0\n" +
						"  AND d.is_delete = 0\n" +
						"  AND r.rtn_bill_id IN ("+rtnBillIds+")\n" +
						"  AND r.project_id = \n" + projectId +
						"  GROUP BY\n" +
						"   d.project_id,\n" +
						"   d.com_id,\n" +
						"   d.p_sale_com_id,\n" +
						"   r.acpt_bill_code\n" +
						" ) t1\n" +
						" LEFT JOIN v_com_returnable_count t2 ON t1.project_id = t2.project_id\n" +
						" AND t1.p_sale_com_id = t2.p_sale_com_id\n" +
						" AND t1.com_id = t2.com_id\n" +
						" AND t1.acpt_bill_code = t2.acpt_bill_code\n" +
						" LEFT JOIN v_commodity_stock_now t3 ON t1.project_id = t3.project_id\n" +
						" AND t1.com_id = t3.com_id\n" +
						" AND t1.in_wh_id = t3.wh_id\n" +
						" LEFT JOIN commodity_tcb_com c ON t1.project_id = c.project_id\n" +
						" AND t1.com_id = c.com_id\n" +
						" AND c.is_delete = 0\n" +
						" LEFT JOIN commodity_tcb_salecom s ON t1.project_id = s.project_id\n" +
						" AND t1.com_id = s.com_id\n" +
						" AND t1.p_sale_com_id = s.sale_com_id\n" +
						" AND s.is_delete = 0\n" +
						" LEFT JOIN v_commodity_freeze v ON v.project_id = t1.project_id AND v.com_id = t1.com_id AND v.wh_id = t1.in_wh_id \n" +
						" WHERE\n" +
						" (\n" +
						"  IFNULL(t1.p_order_page_count, 0) > t2.returnableOrderCount\n" +
						"  OR \n" +
						"  IFNULL(t1.p_gift_page_count, 0) > t2.returnableGiftCount\n" +
						"  OR IFNULL(t1.order_count, 0) > (IFNULL(t3.wh_stock, 0) - (IFNULL(v.stock_num,0) - IFNULL(t1.order_count, 0))) " +
						" )\n" +
						"AND t1.project_id = " + projectId);
		return autoBaseDao.listAll(queryBuilder);
	}


}
