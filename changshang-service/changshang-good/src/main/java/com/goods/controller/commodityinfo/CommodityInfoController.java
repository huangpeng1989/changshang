package com.goods.controller.commodityinfo;


import com.alibaba.fastjson.JSON;
import com.goods.service.commodityinfo.CommodityInfoApi;
import entity.ModelPagedList;
import modelpojo.AccountBaseConroller;
import modelpojo.ResponseInfo;
import modelpojo.model.CatecommTsbTax;
import modelpojo.model.CatecommTssDatadictModel;
import modelpojo.model.CommodityTcbBindcommdetailModel;
import modelpojo.model.CommodityWhInDtl;
import modelpojo.vo.BasicDataLogVo;
import modelpojo.vo.commodityinfo.CommodityInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("commodityInfo")
public class CommodityInfoController extends AccountBaseConroller {

	@Autowired
	private CommodityInfoApi commodityTcbComApi;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 新增/编辑商品信息
	 * @param commodityInfoVo
	 * @return
	 */
	@RequestMapping("saveOrUpdateCommodityInfo")
	@ResponseBody
	public ResponseInfo saveOrUpdateCommodityInfo(String commodityInfoVo) {
		try {
			Long user = getAccountId();
			Long projectRootId = getCompanyId();
			Long projectId = getOrgId();
			CommodityInfoVo commodityInfoVo1 = JSON.toJavaObject(JSON.parseObject(commodityInfoVo), CommodityInfoVo.class);
			commodityTcbComApi.saveOrUpdateCommodityInfo(commodityInfoVo1 ,user,projectRootId,projectId);
			return ResponseInfo.success(null);
		} catch (Exception e) {
			 logger.error("新增/编辑商品信息失败：{}", e.getMessage(), e);
			 return ResponseInfo.error("新增/编辑商品信息失败"+e.getMessage());
		}
	}

	/**
	 * 查询商品信息
	 * @param comId 商品id
	 * @return
	 */
	@RequestMapping("getCommodityInfo")
	@ResponseBody
	public ResponseInfo getCommodityInfo(Integer comId) {
		CommodityInfoVo commodityInfoVo = null;
		try {
			commodityInfoVo = commodityTcbComApi.getCommodityInfo(comId,getOrgId());
			return ResponseInfo.success(commodityInfoVo);
		} catch (Exception e) {
			logger.error("查询商品信息失败：{}", e.getMessage(), e);
			return ResponseInfo.error("查询商品信息失败"+e.getMessage());
		}
	}

	/**
	 * 商品编号唯一性校验
	 * @param comCode 商品编号
	 * @return
	 */
	@RequestMapping("checkComNo")
	@ResponseBody
	public ResponseInfo checkComNo(String comCode) {
		try {
			boolean unique = commodityTcbComApi.checkComNo(comCode,getOrgId())>0?Boolean.FALSE:Boolean.TRUE;
			return ResponseInfo.success(unique);
		} catch (Exception e) {
			logger.error("商品编号唯一性校验失败：{}", e.getMessage(), e);
			return ResponseInfo.error("商品编号唯一性校验失败"+e.getMessage());
		}
	}

	/**
	 * 商品名称唯一性校验
	 * @param comName 商品名称
	 * @return
	 */
	@RequestMapping("checkComName")
	@ResponseBody
	public ResponseInfo checkComName(String comName) {
		try {
			boolean unique = commodityTcbComApi.checkComName(comName,getOrgId())>0?Boolean.FALSE:Boolean.TRUE;
			return ResponseInfo.success(unique);
		} catch (Exception e) {
			logger.error("商品名称唯一性校验失败：{}", e.getMessage(), e);
			return ResponseInfo.error("商品名称唯一性校验失败"+e.getMessage());
		}
	}


	/**
	 * 查询进销项税率
	 * @return
	 */
	@RequestMapping("listTax")
	@ResponseBody
	public ResponseInfo listTax() {
		try {
			List<CatecommTsbTax> catecommTsbTaxLst = commodityTcbComApi.listTax(getOrgId());
			return ResponseInfo.success(catecommTsbTaxLst);
		} catch (Exception e) {
			logger.error("查询进销项税率失败：{}", e.getMessage(), e);
			return ResponseInfo.error("查询进销项税率失败"+e.getMessage());
		}
	}

	/**
	 * 新增/编辑产品等级
	 * @param catecommTssDatadictModel
	 * @return
	 */
	@RequestMapping("saveOrUpdateGrade")
	@ResponseBody
	public ResponseInfo saveOrUpdateGrade(CatecommTssDatadictModel catecommTssDatadictModel) {
		try {
			Long user = getAccountId();
			Long projectRootId = getCompanyId();
			Long projectId = getOrgId();
			commodityTcbComApi.saveOrUpdateGrade(catecommTssDatadictModel ,user,projectRootId,projectId);
			return ResponseInfo.success(null);
		} catch (Exception e) {
			 logger.error("新增/编辑产品等级失败：{}", e.getMessage(), e);
			 return ResponseInfo.error("新增/编辑产品等级失败"+e.getMessage());
		}
	}

	/**
	 * 查询产品等级列表
	 * @return
	 */
	@RequestMapping("listGrade")
	@ResponseBody
	public ResponseInfo listGrade() {
		try {
			return ResponseInfo.success(commodityTcbComApi.listGrade(getOrgId()));
		} catch (Exception e) {
			 logger.error("查询产品等级列表失败：{}", e.getMessage(), e);
			 return ResponseInfo.error("查询产品等级列表失败"+e.getMessage());
		}
	}

	/**
	 * 删除产品等级
	 * @return
	 */
	@RequestMapping("deleteGrade")
	@ResponseBody
	public ResponseInfo deleteGrade(Integer dictId) {
		try {
			commodityTcbComApi.deleteGrade(dictId);
			return ResponseInfo.success(null);
		} catch (Exception e) {
			logger.error("删除产品等级失败：{}", e.getMessage(), e);
			return ResponseInfo.error("删除产品等级失败"+e.getMessage());
		}
	}

	//判断销售商品是否被捆绑
	@RequestMapping("isPurchaseRecord")
	@ResponseBody
	public ResponseInfo isPurchaseRecord(Long comId) {
		List<CommodityTcbBindcommdetailModel> list = commodityTcbComApi.seleceListByComId(this.getOrgId(),comId);
		if(list.size() > 0){
			return new ResponseInfo(true, "100", "操作成功", true);
		}else{
			return new ResponseInfo(true, "100", "操作成功", false);
		}
	}


	//判断商品是否有采购记录
	@RequestMapping("isBinding")
	@ResponseBody
	public ResponseInfo isBinding(Long saleComId) {
		List<CommodityWhInDtl> list = commodityTcbComApi.selectWhInDtlList(this.getOrgId(),saleComId);
		if(list.size() > 0){
			return new ResponseInfo(true, "100", "操作成功", true);
		}else{
			return new ResponseInfo(true, "100", "操作成功", false);
		}
	}

	/**
	 * 查询日志操作人
	 * @param dataType
	 * @return
	 */
	@RequestMapping("getAllLogOperator")
	@ResponseBody
	public ResponseInfo getAllLogOperator(Long dataType,Long infoId){
		List<BasicDataLogVo> logList = commodityTcbComApi.getAllLogOperator(this.getOrgId(),dataType,infoId);
        List<Map> list = new ArrayList<Map>();
		if(logList.size() > 0){
			logList.forEach(x->{
				Map map = new HashMap();
				if(x.getCreater() == 0){
					map.put("id",x.getCreater());
					map.put("name","定时任务");
				}else{
					map.put("id",x.getCreater());
					map.put("name",x.getNickName());
				}
				list.add(map);
			});
		}
        return new ResponseInfo(true, "100", "操作成功", list);
	}

	/**
	 * 查询日志信息
	 * @param dataType
	 * @param logType
	 * @param creater
	 * @return
	 */
	@RequestMapping("getComLogInfo")
	@ResponseBody
	public ResponseInfo getComLogInfo(Long dataType ,Long logType,Long creater,Long infoId,Integer pageNo,Integer pageSize) {
		ModelPagedList list = commodityTcbComApi.getComLogInfo(this.getOrgId(),dataType,logType,creater,infoId,pageNo,pageSize);
		return new ResponseInfo(true, "100", "操作成功", list);
	}

	/**
	 * 生成商品编号
	 * @param menu
	 * @param code
	 * @return
	 */
	@RequestMapping("generateComCode")
	@ResponseBody
	public ResponseInfo generateComCode(String menu,String code)  {
		try {
			String comCode = commodityTcbComApi.generateComCode(this.getOrgId(),menu,code);
			return new ResponseInfo(true, "100", "操作成功", comCode);
		}catch (Exception e){
			logger.error("生成商品编号失败：{}", e.getMessage(), e);
			return new ResponseInfo(true, "100", "生成商品编号失败", e.getMessage());
		}

	}

	/**
	 * 查询有效的合同信息
	 * @param moduleId 模块ID，10商品 20餐饮
	 * @param sellMode 经营方式
	 * @return
	 */
	@RequestMapping("getContractInfoList")
	@ResponseBody
	public ResponseInfo getContractInfoList(Integer moduleId,String sellMode,String codeOrName,Long suppId){
		try {
			List list = null;
			if(moduleId == 10){
				list = commodityTcbComApi.getComContractInfoList(this.getOrgId(),sellMode,codeOrName,suppId);
			}else if(moduleId == 20){
				list = commodityTcbComApi.getCateContractInfoList(this.getOrgId(),sellMode,codeOrName,suppId);
			}
			return new ResponseInfo(true, "100", "操作成功", list);
		} catch (Exception e) {
			logger.error("查询有效的合同信息失败：{}", e.getMessage(), e);
			return new ResponseInfo(true, "100", "查询有效的合同信息失败", e.getMessage());
		}

	}

	//根据商品和供应商判断是否有采购记录
	@RequestMapping("isPurchaseRecordBySupp")
	@ResponseBody
	public ResponseInfo isPurchaseRecordBySupp(Long comId,Long suppId) {
		List<CommodityWhInDtl> list = commodityTcbComApi.isPurchaseRecordBySupp(this.getOrgId(),comId,suppId);
		if(list.size() > 0){
			return new ResponseInfo(true, "100", "操作成功", true);
		}else{
			return new ResponseInfo(true, "100", "操作成功", false);
		}
	}

	//商品反审
	@RequestMapping("comIntrospection")
	@ResponseBody
	public ResponseInfo comIntrospection(Long comId){
		String result = commodityTcbComApi.isIntrospection(this.getOrgId(),comId);
		if(result == null){
			Integer size = commodityTcbComApi.introspection(this.getOrgId(),comId);
			if(size > 0){
				return new ResponseInfo(true, "100", "操作成功", true);
			}else{
				return new ResponseInfo(true, "100", "商品反审失败！", false);
			}
		}else{
			return new ResponseInfo(true, "100", result, false);
		}
	}

}
