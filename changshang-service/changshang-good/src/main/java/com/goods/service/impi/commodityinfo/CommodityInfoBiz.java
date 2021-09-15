package com.goods.service.impi.commodityinfo;


import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.rawmater.RawnaterFeign;
import com.goods.service.allocation.CollarUseService;
import com.goods.service.commodityinfo.CommodityInfoApi;
import entity.ModelPagedList;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.model.contract.CateringContractVo;
import modelpojo.model.contract.CommodityContractVo;
import modelpojo.model.phtax.CommodityPhTaxDtl;
import modelpojo.vo.*;
import modelpojo.vo.commodityinfo.CommodityInfoVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.*;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author XuLuJiao
 *
 * @date 2019年8月26日下午8:14:01
 *
 */
@Service
public class CommodityInfoBiz implements CommodityInfoApi {

	AutoBaseDao autoBaseDao = new AutoDaoImpl();


	@Resource
	private SupplierServiceFeign supplierServiceFeign;

	@Resource
	private CollarUseService CollarUseService;

	@Resource
	private RawnaterFeign rawmaterApi;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveOrUpdateCommodityInfo(CommodityInfoVo commodityInfoVo, Long user, Long projectRootId, Long projectId) throws Exception {
		CommodityTcbCom commodityTcbCom = commodityInfoVo.getCom();
		List<CommodityTcbSalecomVo> saleComInfoLst = commodityInfoVo.getSaleComInfoVoLst();
		List<CommodityTcbSuppcomModelVo> comSupplyInfoLst = commodityInfoVo.getComSupplyInfoVoLst();
		List<CommodityTcbGradepriceVo> commodityTcbGradeprice = commodityInfoVo.getComPriceConfigInfoVoLst();
		List<CommodityTcbComimgs> commodityTcbComimgs = commodityInfoVo.getPicLst();
		//赋值修改人,项目根节点,项目节点,审核人,审核时间
		Date now = new Date();
		commodityTcbCom.setModifier(user);
		commodityTcbCom.setProjectRootId(projectRootId);
		commodityTcbCom.setProjectId(projectId);
		commodityTcbCom.setBlEmpId(user);
		commodityTcbCom.setBlTime(now);
		Integer comId = commodityTcbCom.getComId();
		if (null==comId) {
			commodityTcbCom.setCreater(user);
		}
		if (null!=saleComInfoLst) {
			saleComInfoLst.forEach(x->{
				x.setModifier(user);
				if (null==comId) {
					x.setCreater(user);
				}
				x.setProjectId(projectId);
				//生成销售商品编码
				if(null == x.getComBarcode() || "".equals(x.getComBarcode())){
					Map<String, Object> map = CollarUseService.getBarCode(projectId, 10, x.getSaleComId(), 0, 0, 1);
					String comBarcode = (String) map.get("code");
					x.setComBarcode(comBarcode);
				}
			});
		}
		if (null!=comSupplyInfoLst) {
			comSupplyInfoLst.forEach(x->{
				x.setModifier(user);
				if (null==comId) {
					x.setCreater(user);
				}
				x.setOldTaxPaid(x.getTaxPaid());
				x.setOldNoTaxPaid(x.getNoTaxPaid());
				x.setOldPurchaseTaxPaid(x.getPurchaseTaxPaid());
				x.setOldPurchaseNoTaxPaid(x.getPurchaseNoTaxPaid());
				x.setProjectId(projectId);
				x.setBlEmpId(user);
				x.setBlTime(now);
				if(x.getIsDefault() == 10){
					commodityTcbCom.setPhTaxId(x.getPhTaxId());
					commodityTcbCom.setPhTax(x.getPhTax());
					commodityTcbCom.setDiscountRate(x.getDiscountRate());
				}
			});
		}
		if (null!=commodityTcbGradeprice) {
			commodityTcbGradeprice.forEach(x->{
				x.setModifier(user);
				if (null==comId) {
					x.setCreater(user);
				}
				x.setOldRetailPrice(x.getRetailPrice());
				x.setProjectId(projectId);
			});
		}
		if (null!=commodityTcbComimgs) {
			commodityTcbComimgs.forEach(x->{
				x.setUpdEmpId(user);
				if (null==comId) {
					x.setCreater(user);
				}
				x.setProjectId(projectId);
				x.setBlEmpId(user);
				x.setBlTime(now);
			});
		}
		//新增商品可以直接保存,编辑商品先删后存
		if (null!=comId) {
			//修改商品保存日志
			saveLogInfo(projectId,comId,saleComInfoLst,comSupplyInfoLst,commodityTcbGradeprice,user);
			commodityTcbCom.setProjectId(null);
			commodityTcbCom.setComId(null);
			UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTcbCom.class).setBean(commodityTcbCom).set("sync_status", SyncStatus.NOT_SYNC).whereEq("project_id", projectId).whereEq("com_id", comId);
			autoBaseDao.update(updateBuilder);
			NativeSQLBuilder<CommodityTcbComimgs> updateBuilder4 = NativeSQLBuilder.build(CommodityTcbComimgs.class)
					.setSql("delete from commodity_tcb_comimgs where  project_id = " + projectId +
							"\tand com_id= " + comId);
			autoBaseDao.nativeExecute(updateBuilder4);
		}else {
			//赋值创建人
			Integer comId1 = supplierServiceFeign.getTableId(projectId, "commodity_tcb_com", 1);
			commodityTcbCom.setCreater(user);
			commodityTcbCom.setComId(comId1);
			//新增商品保存日志
			saveLogInfo(projectId,comId1,saleComInfoLst,comSupplyInfoLst,commodityTcbGradeprice,user);
			Integer cStatus = commodityTcbCom.getCStatus();
			String content = "";
			if (cStatus == 10602) {
				content = "新增商品，商品编号【"+commodityTcbCom.getComCode()+"】";
			} else if(cStatus == 10603) {
				content = "提交商品，商品编号【"+commodityTcbCom.getComCode()+"】";
			}
			int result = rawmaterApi.saveBasicDataLog(projectId,comId1,10,BasicDataLogStatus.LOG_INFO,content,user);
			if (result <= 0) {
				throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品包装信息操作日志失败！");
			}
			//保存商品信息
			InsertBuilder<CommodityTcbCom> insertBuilder = InsertBuilder.build(commodityTcbCom).optSql();
			autoBaseDao.save(insertBuilder);
			if (null!=saleComInfoLst) {
				saleComInfoLst.forEach(x->{
					x.setComId(comId1);
					x.setSyncStatus(SyncStatus.NOT_SYNC);
				});
			}
			if (null!=comSupplyInfoLst) {
				comSupplyInfoLst.forEach(x->{
					x.setComId(comId1);
					x.setSyncStatus(SyncStatus.NOT_SYNC);
				});
			}
			if (null!=commodityTcbGradeprice) {
				commodityTcbGradeprice.forEach(x->{
					x.setComId(comId1);
					x.setSyncStatus(SyncStatus.NOT_SYNC);
				});
			}

			if (null!=commodityTcbComimgs) {
				commodityTcbComimgs.forEach(x->{
					x.setComId(comId1);
					x.setSyncStatus(SyncStatus.NOT_SYNC);
				});
			}
		}
		//保存商品销售信息
		if (null!=saleComInfoLst) {
			saleComInfoLst.forEach(x->{
				if(x.getFlagType().equals(FlagTypeEnum.add.getName())){
					//新增包装信息
					addComSaleInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.update.getName())){
                    //如果当前修改的单位是采购单位，将该商品其它的单位全置为非采购单位
                    if(x.getIsPurChaseUnit() == 1){
                        NativeSQLBuilder<CommodityTcbSalecom> updateBuilder2 = NativeSQLBuilder.build(CommodityTcbSalecom.class)
                                .setSql(" UPDATE commodity_tcb_salecom set is_pur_chase_unit = 0  where  project_id = " + projectId +
                                        " and com_id= " + comId);
                        autoBaseDao.nativeExecute(updateBuilder2);
                    }
					//修改包装信息,先删除原有的包装信息
					NativeSQLBuilder<CommodityTcbSalecom> updateBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class)
							.setSql(" delete from commodity_tcb_salecom where  project_id = " + projectId +
									" and com_id= " + comId + " and sale_com_id = " + x.getSaleComId());
					autoBaseDao.nativeExecute(updateBuilder1);
					//然后新增包装信息
					addComSaleInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.del.getName())){
					//删除包装信息
					NativeSQLBuilder<CommodityTcbSalecom> updateBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class)
							.setSql(" delete from commodity_tcb_salecom where  project_id = " + projectId +
									" and com_id= " + comId + " and sale_com_id = " + x.getSaleComId());
					autoBaseDao.nativeExecute(updateBuilder1);
				}
			});
		}
		//保存商品供应商信息
		if (null!=comSupplyInfoLst) {
			comSupplyInfoLst.forEach(x->{
				if(x.getFlagType().equals(FlagTypeEnum.add.getName())){
					//新增供应商信息
					addComSuppInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.update.getName())){
					//修改供应商信息,先删除原有的供应商信息
					NativeSQLBuilder<CommodityTcbSuppcomModel> updateBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
							.setSql(" delete from commodity_tcb_suppcom where  project_id = " + projectId +
									" and com_id= " + comId + " and sup_com_id = " + x.getSupComId());
					autoBaseDao.nativeExecute(updateBuilder2);
					//然后新增供应商信息
					addComSuppInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.del.getName())){
					//删除供应商信息
					NativeSQLBuilder<CommodityTcbSuppcomModel> updateBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
							.setSql(" delete from commodity_tcb_suppcom where  project_id = " + projectId +
									" and com_id= " + comId + " and sup_com_id = " + x.getSupComId());
					autoBaseDao.nativeExecute(updateBuilder2);
				}
			});
		}
		//保存商品价格配置信息
		if (null!=commodityTcbGradeprice) {
			commodityTcbGradeprice.forEach(x->{

				if(x.getFlagType().equals(FlagTypeEnum.add.getName())){
					//新增价格配置信息
					addComPriceInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.update.getName())){
					//修改价格配置信息,先删除原有的价格配置信息
					NativeSQLBuilder<CommodityTcbSuppcomModel> updateBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
							.setSql(" delete from commodity_tcb_gradeprice where  project_id = " + projectId +
									" and com_id= " + comId + " and gp_id = " + x.getGpId());
					autoBaseDao.nativeExecute(updateBuilder2);
					//然后新增价格配置信息
					addComPriceInfo(x);
				}else if(x.getFlagType().equals(FlagTypeEnum.del.getName())){
					//删除价格配置信息
					NativeSQLBuilder<CommodityTcbSuppcomModel> updateBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
							.setSql(" delete from commodity_tcb_gradeprice where  project_id = " + projectId +
									" and com_id= " + comId + " and gp_id = " + x.getGpId());
					autoBaseDao.nativeExecute(updateBuilder2);
				}
			});
		}
		//保存商品图片信息
		if (null!=commodityTcbComimgs) {
			commodityTcbComimgs.forEach(x->{
				InsertBuilder<CommodityTcbComimgs> insertBuilder4 = InsertBuilder.build(x).optSql();
				autoBaseDao.save(insertBuilder4);
			});
		}

	}

	//新增包装信息
	private void addComSaleInfo(CommodityTcbSalecomVo comVO){
		CommodityTcbSalecom sale = new CommodityTcbSalecom();
		try{
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			ConvertUtils.register(new DateConverter(null), Date.class);
			BeanUtils.copyProperties(sale,comVO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		InsertBuilder<CommodityTcbSalecom> insertBuilder1 = InsertBuilder.build(sale).optSql();
		autoBaseDao.save(insertBuilder1);
	}

	//新增供应商信息
	private void addComSuppInfo(CommodityTcbSuppcomModelVo suppVO){
		CommodityTcbSuppcomModel sup = new CommodityTcbSuppcomModel();
		try {
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			ConvertUtils.register(new DateConverter(null), Date.class);
			BeanUtils.copyProperties(sup, suppVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sup.setOldTaxPaid(sup.getTaxPaid());
		sup.setOldNoTaxPaid(sup.getNoTaxPaid());
		sup.setOldPurchaseTaxPaid(sup.getPurchaseTaxPaid());
		sup.setOldPurchaseNoTaxPaid(sup.getPurchaseNoTaxPaid());
		InsertBuilder<CommodityTcbSuppcomModel> insertBuilder2 = InsertBuilder.build(sup).optSql();
		autoBaseDao.save(insertBuilder2);
	}

	private void addComPriceInfo(CommodityTcbGradepriceVo priceVO){
		CommodityTcbGradeprice gradeprice = new CommodityTcbGradeprice();
		try {
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			ConvertUtils.register(new DateConverter(null), Date.class);
			BeanUtils.copyProperties(gradeprice, priceVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		InsertBuilder<CommodityTcbGradeprice> insertBuilder3 = InsertBuilder.build(gradeprice).optSql();
		autoBaseDao.save(insertBuilder3);
	}


	private void saveLogInfo(Long projectId,Integer comId,List<CommodityTcbSalecomVo> saleComInfoLst,List<CommodityTcbSuppcomModelVo> comSupplyInfoLst,List<CommodityTcbGradepriceVo> commodityTcbGradeprice, Long user) throws Exception {
		//保存商品销售日志信息
		if (null!=saleComInfoLst) {
			saleComInfoLst.forEach(x->{
				String content = "";
				String status = x.getComStatus()== 1?"正常":"淘汰";
				String isPurchaseUnit = x.getIsPurChaseUnit()== 1?"是":"否";
				if(x.getFlagType().equals(FlagTypeEnum.add.getName())){
					content = "新增商品包装信息:商品包装编号【"+x.getSaleComCode()+"】,"+"商品包装含量【"+x.getPackContent()+"】,"+"销售商品单位【"+x.getSaleCommUnitName()+"】,"+"商品条码【"+x.getComBarcode()+"】,"+"商品包装状态【"+status+"】,"+"是否采购单位【"+isPurchaseUnit+"】";
				}else if(x.getFlagType().equals(FlagTypeEnum.update.getName())){
					StringBuffer strBuffer = new StringBuffer("编辑商品包装信息:");
					//查询修改前的商品包装信息
					QueryBuilder<CommodityTcbSalecom> queryBuilder = QueryBuilder.build(CommodityTcbSalecom.class).whereEq("project_id", projectId).whereEq("sale_com_id", x.getSaleComId()).whereEq("is_delete", Type.NOT_DELETED);
					CommodityTcbSalecom sale = autoBaseDao.findOne(queryBuilder);
					if(sale == null){
						try {
							throw new Exception( ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品包装信息操作日志失败！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					QueryBuilder<CatecommTssPubdatadict> pubQueryBuilder = QueryBuilder.build(CatecommTssPubdatadict.class).whereEq("type_code", sale.getSaleCommUnit()).whereEq("p_dict_status", 1);
					CatecommTssPubdatadict pub = autoBaseDao.findOne(pubQueryBuilder);
					if(pub == null){
						try {
							throw new Exception( ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品包装信息操作日志失败！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					String saleStatus = sale.getComStatus()== 1?"正常":"淘汰";
					String saleisPurchaseUnit = sale.getIsPurChaseUnit()== 1?"是":"否";
					strBuffer.append("修改前信息为：商品包装编号【"+sale.getSaleComCode()+"】,"+"商品包装含量【"+sale.getPackContent()+"】,"+"销售商品单位【"+pub.getTypeName()+"】,"+"商品条码【"+sale.getComBarcode()+"】,"+"商品包装状态【"+saleStatus+"】,"+"是否采购单位【"+saleisPurchaseUnit+"】");
					strBuffer.append("修改后信息为：商品包装编号【"+x.getSaleComCode()+"】,"+"商品包装含量【"+x.getPackContent()+"】,"+"销售商品单位【"+x.getSaleCommUnitName()+"】,"+"商品条码【"+x.getComBarcode()+"】,"+"商品包装状态【"+status+"】,"+"是否采购单位【"+isPurchaseUnit+"】");
					content = strBuffer.toString();
				}else if(x.getFlagType().equals(FlagTypeEnum.del.getName())){
					content = "删除商品包装信息:商品包装编号【"+x.getSaleComCode()+"】,"+"商品包装含量【"+x.getPackContent()+"】,"+"销售商品单位【"+x.getSaleCommUnitName()+"】,"+"商品条码【"+x.getComBarcode()+"】,"+"商品包装状态【"+status+"】,"+"是否采购单位【"+isPurchaseUnit+"】";
				}
				if(StringUtils.isNotBlank(x.getFlagType())){
					int result = rawmaterApi.saveBasicDataLog(projectId,comId,10, BasicDataLogStatus.LOG_SALE,content,user);
					if (result <= 0) {
						try {
							throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品包装信息操作日志失败！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		//保存商品供应商日志信息
		if (null != comSupplyInfoLst) {
			comSupplyInfoLst.forEach(x->{
				String content = "";
				String status = x.getIsEliminate() == 1?"正常":"淘汰";
				String isDefault = x.getIsDefault() == 10?"缺省":"";
				if(x.getFlagType().equals(FlagTypeEnum.add.getName())){
					content = "新增商品合同信息：合同编号【"+x.getContractCode()+"】,合同名称【"+x.getContractName()+"】,供应商【"+x.getSuppName()+"】"+isDefault+"供应商,"+"采购含税进价【"+x.getPurchaseTaxPaid()+"】,"+"采购未税进价【"+x.getPurchaseNoTaxPaid()+"】,"+"含税进价【"+x.getTaxPaid()+"】,"+"未税进价【"+x.getNoTaxPaid()+"】,"+"预估含税成本价【"+x.getFuTaxCost()+"】,"+"进项税率【"+x.getPhTax()+"】,"+"联营扣率【"+x.getDiscountRate()+"】,"+"送货类型【"+x.getDeliveryTypeName()+"】,"+"商品供应商状态【"+status+"】";
				}else if(x.getFlagType().equals(FlagTypeEnum.update.getName())){
					StringBuffer strBuffer = new StringBuffer("编辑商品合同信息:");
					//查询修改前的商品供应商信息
					NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbSuppcomModelVo.class)
							.setSql("SELECT sup.*, supp.supp_name,dict.dict_tp_value deliveryTypeName FROM commodity_tcb_suppcom sup LEFT JOIN commodity_tcb_supplier supp ON sup.supp_id = supp.supp_id  and sup.project_id = supp.project_id LEFT JOIN catecomm_tss_datadict dict on sup.delivery_type = dict.dict_tp_code  and sup.project_id = dict.project_id where " );
					queryBuilder.appendIfOpt("  sup.project_id = #{projectId}", "projectId", projectId);
					queryBuilder.appendIfOpt("  and sup_com_id = #{supComId}", "supComId", x.getSupComId());
					queryBuilder.appendIfOpt("  and sup.is_delete = #{isDelete}", "isDelete", Type.NOT_DELETED);
					queryBuilder.appendIfOpt("  and supp.is_delete = #{isDelete}", "isDelete", Type.NOT_DELETED);
					CommodityTcbSuppcomModelVo sup = (CommodityTcbSuppcomModelVo)autoBaseDao.findOne(queryBuilder);
					if(sup == null){
						try {
							throw new Exception( ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品合同信息操作日志失败！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					String supStatus = sup.getIsEliminate()== 1?"正常":"淘汰";
					String supIsDefault = sup.getIsDefault() == 10?"缺省":"";
					strBuffer.append("修改前信息为：合同编号【"+sup.getContractCode()+"】,合同名称【"+sup.getContractName()+"】,供应商【"+sup.getSuppName()+"】"+supIsDefault+"供应商,"+"采购含税进价【"+sup.getPurchaseTaxPaid()+"】,"+"采购未税进价【"+sup.getPurchaseNoTaxPaid()+"】,"+"含税进价【"+sup.getTaxPaid()+"】,"+"未税进价【"+sup.getNoTaxPaid()+"】,"+"预估含税成本价【"+sup.getFuTaxCost()+"】,"+"进项税率【"+sup.getPhTax()+"】,"+"联营扣率【"+sup.getDiscountRate()+"】,"+"送货类型【"+sup.getDeliveryTypeName()+"】,"+"商品供应商状态【"+supStatus+"】");
					strBuffer.append("修改后信息为：合同编号【"+x.getContractCode()+"】,合同名称【"+x.getContractName()+"】,供应商【"+x.getSuppName()+"】"+isDefault+"供应商,"+"采购含税进价【"+x.getPurchaseTaxPaid()+"】,"+"采购未税进价【"+x.getPurchaseNoTaxPaid()+"】,"+"含税进价【"+x.getTaxPaid()+"】,"+"未税进价【"+x.getNoTaxPaid()+"】,"+"预估含税成本价【"+x.getFuTaxCost()+"】,"+"进项税率【"+x.getPhTax()+"】,"+"联营扣率【"+x.getDiscountRate()+"】,"+"送货类型【"+x.getDeliveryTypeName()+"】,"+"商品供应商状态【"+status+"】");
					content = strBuffer.toString();
				}else if(x.getFlagType().equals(FlagTypeEnum.del.getName())){
					content = "删除商品合同信息：合同编号【"+x.getContractCode()+"】,合同名称【"+x.getContractName()+"】,供应商【"+x.getSuppName()+"】"+isDefault+"供应商,"+"采购含税进价【"+x.getPurchaseTaxPaid()+"】,"+"采购未税进价【"+x.getPurchaseNoTaxPaid()+"】,"+"含税进价【"+x.getTaxPaid()+"】,"+"未税进价【"+x.getNoTaxPaid()+"】,"+"预估含税成本价【"+x.getFuTaxCost()+"】,"+"进项税率【"+x.getPhTax()+"】,"+"联营扣率【"+x.getDiscountRate()+"】,"+"送货类型【"+x.getDeliveryTypeName()+"】,"+"商品供应商状态【"+status+"】";
				}
				if(StringUtils.isNotBlank(x.getFlagType())) {
					int result = rawmaterApi.saveBasicDataLog(projectId, comId, 10, BasicDataLogStatus.LOG_SUPP, content, user);
					if (result <= 0) {
						try {
							throw new Exception( ErrorCode.RAWMATER_NOT_TO_EXAMINE + "商品合同信息操作日志失败！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		}

		//保存商品价格配置日志信息
		if (null!=commodityTcbGradeprice) {
			StringBuffer strBuffer = new StringBuffer();
			commodityTcbGradeprice.forEach(x->{
				if(StringUtils.isNotBlank(x.getFlagType())){
					String status = x.getcStatus() == 0 ? "不可售":"可售";
					strBuffer.append(" 价格等级【"+x.getGradeName()+"】可售状态【"+status+"】零售价【"+x.getRetailPrice()+"】");
				}
			});
			if(StringUtils.isNotBlank(strBuffer.toString())) {
				int result = rawmaterApi.saveBasicDataLog(projectId,comId,10,BasicDataLogStatus.LOG_PRICE,strBuffer.toString(),user);
				if (result <= 0) {
					throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品价格配置操作日志失败！");
				}
			}
		}
	}

	@Override
	public CommodityInfoVo getCommodityInfo(Integer comId, Long projectId) {
		//查询商品
		QueryBuilder<CommodityTcbCom> query = QueryBuilder.build(CommodityTcbCom.class)
				.whereEq("project_id", projectId)
				.whereEq("com_id", comId)
				.whereEq("is_delete", Type.NOT_DELETED);
		CommodityTcbCom commodityTcbCom = autoBaseDao.findOne(query);
		CommodityInfoVo commodityInfoVo = new CommodityInfoVo();
		commodityInfoVo.setCom(commodityTcbCom);
		//查询商品销售信息
		QueryBuilder<CommodityTcbSalecom> query1 = QueryBuilder.build(CommodityTcbSalecom.class)
				.whereEq("project_id", projectId)
				.whereEq("com_id", comId)
				.whereEq("is_delete", Type.NOT_DELETED);
		List<CommodityTcbSalecom> saleComInfoLst = autoBaseDao.listAll(query1);
		commodityInfoVo.setSaleComInfoLst(saleComInfoLst);
		//查询商品供应商信息
		NativeSQLBuilder<CommodityTcbSuppComDto> query2 = NativeSQLBuilder.build(CommodityTcbSuppComDto.class).setSql("SELECT a.*,b.supp_code,b.supp_name,con.contract_sell_model FROM commodity_tcb_suppcom a LEFT JOIN commodity_tcb_supplier b ON b.project_id="+projectId+" AND a.supp_id=b.supp_id AND b.is_delete="+Type.NOT_DELETED+"" +
				" left join commodity_contract con on a.contract_id = con.contract_id and a.project_id = con.project_id and con.is_delete = 0 " +
				" WHERE a.project_id="+projectId+" AND a.com_id="+comId+" AND a.is_delete="+Type.NOT_DELETED);
		List<CommodityTcbSuppComDto> comSupplyInfoLst = autoBaseDao.listAll(query2);
		commodityInfoVo.setCommodityTcbSuppComDtos(comSupplyInfoLst);
		//查询商品配置信息
		QueryBuilder<CommodityTcbGradeprice> query3 = QueryBuilder.build(CommodityTcbGradeprice.class)
				.whereEq("project_id", projectId)
				.whereEq("com_id", comId)
				.whereIn("sale_com_id", saleComInfoLst.stream().map(CommodityTcbSalecom::getSaleComId).collect(Collectors.toList()))
				.whereEq("is_delete", Type.NOT_DELETED);
		List<CommodityTcbGradeprice> commodityTcbGradeprice = autoBaseDao.listAll(query3);
		commodityInfoVo.setComPriceConfigInfoLst(commodityTcbGradeprice);
		//查询商品图片信息
		QueryBuilder<CommodityTcbComimgs> query4 = QueryBuilder.build(CommodityTcbComimgs.class)
				.whereEq("project_id", projectId)
				.whereEq("com_id", comId)
				.whereEq("is_delete", Type.NOT_DELETED);
		List<CommodityTcbComimgs> commodityTcbComimgLst = autoBaseDao.listAll(query4);
		commodityInfoVo.setPicLst(commodityTcbComimgLst);
		return commodityInfoVo;
	}

	@Override
	public Integer checkComNo(String comCode, Long projectId) {
		CountBuilder<CommodityTcbCom> countBuilder = CountBuilder.build(CommodityTcbCom.class).whereEq("com_code", comCode).whereEq("project_id", projectId).whereEq("is_delete", Type.NOT_DELETED);
		return autoBaseDao.count(countBuilder).intValue();
	}

	@Override
	public Integer checkComName(String comName, Long projectId) {
		CountBuilder<CommodityTcbCom> countBuilder = CountBuilder.build(CommodityTcbCom.class).whereEq("com_name", comName).whereEq("project_id", projectId).whereEq("is_delete", Type.NOT_DELETED);
		return autoBaseDao.count(countBuilder).intValue();
	}

	@Override
	public List<CatecommTsbTax> listTax(Long projectId) {
		QueryBuilder<CatecommTsbTax> query = QueryBuilder.build(CatecommTsbTax.class)
				.whereEq("project_id", projectId)
				.whereEq("is_delete", Type.NOT_DELETED)
				.whereEq("t_status", Type.T_STATUS).orderByAsc("tax_name");
		return autoBaseDao.listAll(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveOrUpdateGrade(CatecommTssDatadictModel catecommTssDatadictModel, Long user, Long projectRootId,
								  Long projectId) throws Exception{
		catecommTssDatadictModel.setModifier(user);
		Integer dictId = catecommTssDatadictModel.getDictId();
		if (null==dictId) {
			catecommTssDatadictModel.setCreater(user);
			catecommTssDatadictModel.setProjectId(projectId);
			catecommTssDatadictModel.setDictId(supplierServiceFeign.getTableId(projectId, "catecomm_tss_datadict", 1));
			catecommTssDatadictModel.setUdictId(1);
			catecommTssDatadictModel.setDicType("101");
			catecommTssDatadictModel.setDictName("产品等级");
			List<CatecommTssDatadictModel> catecommTssDatadictLst = listAllGrade(projectId);
			catecommTssDatadictLst.sort(Comparator.comparing(CatecommTssDatadictModel::getDictTpCode));
			int size = catecommTssDatadictLst.size();
			Integer dictTpCode = null;
			if (size>0) {
				dictTpCode = catecommTssDatadictLst.get(size-1).getDictTpCode()+1;
			}else {
				dictTpCode = 10101;
			}
			catecommTssDatadictModel.setDictTpCode(dictTpCode);
			catecommTssDatadictModel.setDictSort((short) 0);
			catecommTssDatadictModel.setState("这是描述字段");
			catecommTssDatadictModel.setRemark("商品信息维护");
			catecommTssDatadictModel.setDdStatus((short) 1);
			InsertBuilder<CatecommTssDatadictModel> insertBuilder = InsertBuilder.build(catecommTssDatadictModel).optSql();
			autoBaseDao.save(insertBuilder);
		}else {
			catecommTssDatadictModel.setSyncStatus(SyncStatus.NOT_SYNC);
			UpdateBuilder updateBuilder = UpdateBuilder.build(CatecommTssDatadictModel.class).setBean(catecommTssDatadictModel).whereEq("project_id", projectId).whereEq("dict_id", dictId);
			autoBaseDao.update(updateBuilder);
		}
	}

	@Override
	public List<CatecommTssDatadictModel> listGrade(Long projectId) throws Exception {
		QueryBuilder<CatecommTssDatadictModel> query = QueryBuilder.build(CatecommTssDatadictModel.class)
				.whereEq("project_id", projectId)
				.whereEq("dic_type", 101)
				.whereEq("dd_status", Type.DICT_ENABLE);
		return autoBaseDao.listAll(query);
	}

	private List<CatecommTssDatadictModel> listAllGrade(Long projectId) throws Exception {
		QueryBuilder<CatecommTssDatadictModel> query = QueryBuilder.build(CatecommTssDatadictModel.class)
				.whereEq("project_id", projectId)
				.whereEq("dic_type", 101);
		return autoBaseDao.listAll(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteGrade(Integer dictId) {
		UpdateBuilder updateBuilder = UpdateBuilder.build(CatecommTssDatadictModel.class).set("is_delete", Type.DELETED).set("sync_status", SyncStatus.NOT_SYNC).whereEq("dict_id", dictId);
		autoBaseDao.update(updateBuilder);
	}

	/**
	 * 查询商品捆绑纪录
	 * @param projectId
	 * @param comId
	 * @return
	 */
	@Override
	public List<CommodityTcbBindcommdetailModel> seleceListByComId(Long projectId, Long comId) {
		QueryBuilder<CommodityTcbBindcommdetailModel> queryBuilder = QueryBuilder.build(CommodityTcbBindcommdetailModel.class).whereEq("project_id", projectId).whereEq("com_id", comId).whereEq("is_delete", Boolean.FALSE.toString());
		return autoBaseDao.listAll(queryBuilder);
	}

	/**
	 * 查询销售商品采购记录
	 * @param projectId
	 * @param saleComId
	 * @return
	 */
	@Override
	public List<CommodityWhInDtl> selectWhInDtlList(Long projectId, Long saleComId) {
		QueryBuilder<CommodityWhInDtl> queryBuilder = QueryBuilder.build(CommodityWhInDtl.class).whereEq("project_id", projectId).whereEq("p_sale_com_id", saleComId).whereEq("is_delete", Boolean.FALSE.toString());
		return autoBaseDao.listAll(queryBuilder);
	}

	@Override
	public List<BasicDataLogVo> getAllLogOperator(Long projectId, Long dataType, Long infoId) {
		NativeSQLBuilder<BasicDataLogVo> queryBuilder = NativeSQLBuilder.build(BasicDataLogVo.class)
				.setSql("select l.creater,a.nick_name from basic_data_log l left join account a on l.creater = a.id where " );
		queryBuilder.appendIfOpt("  project_id = #{projectId}", "projectId", projectId);
		queryBuilder.appendIfOpt("  and data_type = #{dataType}", "dataType", dataType);
		queryBuilder.appendIfOpt("  and info_id = #{infoId}", "infoId", infoId);
		queryBuilder.append(" group by l.creater,a.nick_name");
		return autoBaseDao.listAll(queryBuilder);
	}

	@Override
	public ModelPagedList getComLogInfo(Long projectId, Long dataType, Long logType, Long creater, Long infoId, Integer pageNo, Integer pageSize) {
		NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(BasicDataLogVo.class)
				.setSql("select l.*,a.nick_name from basic_data_log l left join account a on l.creater = a.id where " );
		queryBuilder.appendIfOpt("  project_id = #{projectId}", "projectId", projectId);
		queryBuilder.appendIfOpt("  and data_type = #{dataType}", "dataType", dataType);
		queryBuilder.appendIfOpt("  and log_tyoe = #{logType}", "logType", logType);
		queryBuilder.appendIfOpt("  and creater = #{creater}", "creater", creater);
		queryBuilder.appendIfOpt("  and info_id = #{infoId}", "infoId", infoId);
		queryBuilder.append(" order by l.updated_time desc ");
		queryBuilder.setPage(pageNo,pageSize);
		return ModelPagedList.convertToModelPage(autoBaseDao.listPage(queryBuilder));
	}

	@Override
	public String generateComCode(Long projectId, String menu, String code) throws Exception {
		String comCode = null;
		QueryBuilder<CatecommTssDatadictModel> queryBuilder = QueryBuilder.build(CatecommTssDatadictModel.class).whereEq("project_id", projectId).whereEq("dict_tp_code", 13001);
		CatecommTssDatadictModel data = autoBaseDao.findOne(queryBuilder);
		if(data == null){
			throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "获取项目编码失败！");
		}
		if(StringUtils.isNotBlank(code)){
			String endStr = String.format("%05d", Integer.valueOf(code));
			comCode = data.getDictTpValue() + menu + endStr;
		}else{
			Integer comCodeId = supplierServiceFeign.getTableId(projectId, "commodity_tcb_com_code", 1);
			String endStr = String.format("%05d", comCodeId);
			comCode = data.getDictTpValue() + menu + endStr;
		}
		return comCode;
	}

	@Override
	public List<CommodityContractVo> getComContractInfoList(Long projectId, String sellMode, String codeOrName, Long suppId) {
		NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityContractVo.class)
				.setSql(" SELECT c.*,supp_name contract_supper_name FROM commodity_contract c " +
						" left join commodity_tcb_supplier s on c.project_id = s.project_id and c.contract_supper = s.supp_id" +
						" WHERE c.project_id = "+projectId+" " +
						" AND c.is_delete = 0 AND DATE_FORMAT(now(),'%Y-%m-%d') <= contract_end_time " +
						" AND contract_sell_model = " + sellMode + " AND contract_stauts = 133003 ");
        if(StringUtils.isNotBlank(codeOrName)){
            queryBuilder.append(" and ( c.contract_code like '%"+codeOrName+"%' or c.contract_name like'%"+codeOrName+"%')");
        }
		if(suppId != null){
			queryBuilder.append(" and c.contract_supper = " + suppId );
		}
        return autoBaseDao.listAll(queryBuilder);
	}

	@Override
	public List<CateringContractVo> getCateContractInfoList(Long projectId, String sellMode, String codeOrName, Long suppId) {
		NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CateringContractVo.class)
				.setSql(" SELECT c.*,supp_name contract_supper_name FROM catering_contract c " +
						" left join commodity_tcb_supplier s on c.project_id = s.project_id and c.contract_supper = s.supp_id" +
						" WHERE c.project_id = "+projectId+" " +
						" AND c.is_delete = 0 AND DATE_FORMAT(now(),'%Y-%m-%d') <= contract_end_time " +
						" AND contract_sell_model = " + sellMode + " AND contract_stauts = 133003 ");
		if(StringUtils.isNotBlank(codeOrName)){
			queryBuilder.append(" and ( c.contract_code like '%"+codeOrName+"%' or c.contract_name like'%"+codeOrName+"%')");
		}
		if(suppId != null){
			queryBuilder.append(" and c.contract_supper = " + suppId );
		}
		return autoBaseDao.listAll(queryBuilder);
	}

	@Override
	public List<CommodityWhInDtl> isPurchaseRecordBySupp(Long projectId, Long comId, Long suppId) {

		NativeSQLBuilder<CommodityWhInDtl> builder = NativeSQLBuilder.build(CommodityWhInDtl.class)
				.setSql("select t2.* from commodity_wh_in t1 INNER JOIN " +
						"\t commodity_wh_in_dtl t2 on t1.whin_bill_id = t2.whin_bill_id and t1.project_id = t2.project_id " +
						"\t where t2.is_delete = 0 AND t2.com_id ="+comId+
						"\t AND t1.is_delete = 0 AND t1.supp_id ="+suppId+
						"\t AND t1.project_id = "+projectId);
		return autoBaseDao.listAll(builder);
	}

	@Override
	public String isIntrospection(Long projectId, Long comId) {
		String result = null;
		NativeSQLBuilder<CommodityWhInDtl> builder = NativeSQLBuilder.build(CommodityWhInDtl.class)
				.setSql("select t2.* from commodity_wh_in t1 INNER JOIN " +
						"\t commodity_wh_in_dtl t2 on t1.whin_bill_id = t2.whin_bill_id and t1.project_id = t2.project_id " +
						"\t where t2.is_delete = 0 AND t2.com_id ="+comId+
						"\t AND t1.is_delete = 0 " +
						"\t AND t1.project_id = "+projectId);
		List<CommodityWhInDtl> list = autoBaseDao.listAll(builder);
		if(list.size()>0){
			result = "该商品存在采购记录，不能反审！";
			return result;
		}
		NativeSQLBuilder<CommodityTcjAdjust> builder1 = NativeSQLBuilder.build(CommodityTcjAdjust.class)
				.setSql(" SELECT * FROM " +
						" commodity_tcj_adjust t1" +
						" LEFT JOIN commodity_tcj_adjust_detail t2 ON t1.project_id = t2.project_id and t1.adj_id = t2.adj_id \n" +
						" where t1.is_delete = 0 and t2.is_delete = 0 and t2.com_id = "+comId+" and t1.project_id = " + projectId );
		List<CommodityTcjAdjust> list1 = autoBaseDao.listAll(builder1);
		if(list1.size()>0){
			result = "该商品存在进价调价记录，不能反审！";
			return result;
		}
		NativeSQLBuilder<CommoditySaledComBill> builder2 = NativeSQLBuilder.build(CommoditySaledComBill.class)
				.setSql(" select * from commodity_saled_com_bill t1\n" +
						" left join commodity_saled_com_bill_detail t2 on t1.project_id = t2.project_id and t1.com_bill_id = t2.com_Bill_id\n" +
						" where t1.is_delete = 0 and t2.is_delete = 0 and t2.com_id = "+comId+" and t1.project_id = " + projectId );
		List<CommoditySaledComBill> list2 = autoBaseDao.listAll(builder2);
		if(list2.size()>0){
			result = "该商品已设置可售商品，不能反审！";
			return result;
		}

		NativeSQLBuilder<CommodityPhTaxDtl> builder4 = NativeSQLBuilder.build(CommodityPhTaxDtl.class)
				.setSql(" select * from commodity_ph_tax_dtl \n" +
						" where is_delete = 0 and com_id = "+comId+" and project_id =" + projectId );
		List<CommodityPhTaxDtl> list4 = autoBaseDao.listAll(builder4);
		if(list4.size()>0){
			result = "该商品已存在税率调整单，不能反审！";
			return result;
		}

		NativeSQLBuilder<CommodityRateAdjustDetail> builder5 = NativeSQLBuilder.build(CommodityRateAdjustDetail.class)
				.setSql(" select * from commodity_rate_adjust_detail \n" +
						" where is_delete = 0 and com_id = "+comId+" and project_id =" + projectId );
		List<CommodityRateAdjustDetail> list5 = autoBaseDao.listAll(builder5);
		if(list5.size()>0){
			result = "该商品已存在扣率调整单，不能反审！";
			return result;
		}

		QueryBuilder<CommodityTcbBindcommdetailModel> builder3 = QueryBuilder.build(CommodityTcbBindcommdetailModel.class).whereEq("project_id", projectId).whereEq("com_id", comId).whereEq("is_delete", Boolean.FALSE.toString());
		List<CommodityTcbBindcommdetailModel> list3 =  autoBaseDao.listAll(builder3);
		if(list3.size()>0){
			result = "该商品已添加捆绑商品，不能反审！";
			return result;
		}
		return result;
	}

	@Override
	@Transactional
	public Integer introspection(Long projectId, Long comId) {
		//修改商品主信息状态
		UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTcbCom.class).set("c_status", 10604).set("sync_status", SyncStatus.NOT_SYNC).whereEq("project_id", projectId).whereEq("com_id", comId);
		autoBaseDao.update(updateBuilder);
		//根据主商品状态修改销售商品状态
		NativeSQLBuilder queryBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class).setSql("update commodity_tcb_salecom set sc_status = 10604  where project_id = "+projectId+" and  com_id =" + comId + " and sc_status = 10605" );
		autoBaseDao.nativeExecute(queryBuilder1);
		//根据主商品状态修改供应商商品状态
		NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update commodity_tcb_suppcom set c_status = 10604 where project_id = "+projectId+" and  com_id =" + comId + " and c_status = 10605" );
		autoBaseDao.nativeExecute(queryBuilder2);
		return 1;
	}

}
