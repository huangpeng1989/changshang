package com.goods.service.commodityinfo;


import entity.ModelPagedList;
import modelpojo.model.CatecommTsbTax;
import modelpojo.model.CatecommTssDatadictModel;
import modelpojo.model.CommodityTcbBindcommdetailModel;
import modelpojo.model.CommodityWhInDtl;
import modelpojo.model.contract.CateringContractVo;
import modelpojo.model.contract.CommodityContractVo;
import modelpojo.vo.BasicDataLogVo;
import modelpojo.vo.commodityinfo.CommodityInfoVo;

import java.util.List;

/**
 * @author XuLuJiao
 * 
 * @date 2019年8月23日下午3:19:41
 *
 */
public interface CommodityInfoApi {

	void saveOrUpdateCommodityInfo(CommodityInfoVo commodityInfoVo, Long user, Long projectRootId, Long projectId) throws Exception;

	Integer checkComName(String comName, Long projectId) throws Exception;

	Integer checkComNo(String comCode, Long projectId) throws Exception;

	CommodityInfoVo getCommodityInfo(Integer comId, Long projectId) throws Exception;

	List<CatecommTsbTax> listTax(Long long1) throws Exception;

	void saveOrUpdateGrade(CatecommTssDatadictModel catecommTssDatadictModel, Long user, Long projectRootId,
						   Long projectId) throws Exception;

	List<CatecommTssDatadictModel> listGrade(Long projectId) throws Exception;

	void deleteGrade(Integer dictId) throws Exception;

	List<CommodityTcbBindcommdetailModel> seleceListByComId(Long projectId, Long comId);

	List<CommodityWhInDtl> selectWhInDtlList(Long projectId, Long saleComId);

	List<BasicDataLogVo> getAllLogOperator(Long projectId, Long dataType, Long infoId);

	ModelPagedList getComLogInfo(Long projectId, Long dataType, Long logType, Long creater, Long infoId, Integer pageNo, Integer pageSize);

	String generateComCode(Long projectId,String menu,String code) throws Exception;

	List<CommodityContractVo> getComContractInfoList(Long projectId, String sellMode, String codeOrName, Long suppId);

	List<CateringContractVo> getCateContractInfoList(Long projectId, String sellMode, String codeOrName, Long suppId);

	List<CommodityWhInDtl> isPurchaseRecordBySupp(Long projectId, Long comId,Long suppId);

	String isIntrospection(Long projectId, Long comId);

	Integer introspection(Long projectId, Long comId);

}
