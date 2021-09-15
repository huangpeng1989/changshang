package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;
import java.util.List;

import modelpojo.model.CommodityWhInReturn;
import modelpojo.model.CommodityWhInReturnDtl;

public class ReturnOrderVo implements Serializable{

	/**
	 * 
	 */

	
	private CommodityWhInReturn commodityWhInReturn;
	private CommodityWhInReturnVo commodityWhInReturnVo;
	private List<CommodityWhInReturnDtl> commodityWhInReturnDtlLst;
	private List<CommodityWhInReturnDtlVo> commodityWhInReturnDtlVoLst;
	
	public CommodityWhInReturnVo getCommodityWhInReturnVo() {
		return commodityWhInReturnVo;
	}
	public void setCommodityWhInReturnVo(CommodityWhInReturnVo commodityWhInReturnVo) {
		this.commodityWhInReturnVo = commodityWhInReturnVo;
	}
	public CommodityWhInReturn getCommodityWhInReturn() {
		return commodityWhInReturn;
	}
	public void setCommodityWhInReturn(CommodityWhInReturn commodityWhInReturn) {
		this.commodityWhInReturn = commodityWhInReturn;
	}
	public List<CommodityWhInReturnDtl> getCommodityWhInReturnDtlLst() {
		return commodityWhInReturnDtlLst;
	}
	public void setCommodityWhInReturnDtlLst(List<CommodityWhInReturnDtl> commodityWhInReturnDtlLst) {
		this.commodityWhInReturnDtlLst = commodityWhInReturnDtlLst;
	}
	public List<CommodityWhInReturnDtlVo> getCommodityWhInReturnDtlVoLst() {
		return commodityWhInReturnDtlVoLst;
	}
	public void setCommodityWhInReturnDtlVoLst(List<CommodityWhInReturnDtlVo> commodityWhInReturnDtlVoLst) {
		this.commodityWhInReturnDtlVoLst = commodityWhInReturnDtlVoLst;
	}
	
}
