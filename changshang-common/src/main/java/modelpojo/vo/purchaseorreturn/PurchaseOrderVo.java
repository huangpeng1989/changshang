package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhIn;
import modelpojo.model.CommodityWhInDtl;

import java.io.Serializable;
import java.util.List;


public class PurchaseOrderVo implements Serializable{

	/**
	 * 
	 */

	
	private CommodityWhIn commodityWhIn;
	private CommodityWhInVo commodityWhInVo;
	private List<CommodityWhInDtl> commodityWhInDtlLst;
	private List<CommodityWhInDtlVo> commodityWhInDtlVoLst;
	
	public CommodityWhInVo getCommodityWhInVo() {
		return commodityWhInVo;
	}
	public void setCommodityWhInVo(CommodityWhInVo commodityWhInVo) {
		this.commodityWhInVo = commodityWhInVo;
	}
	public List<CommodityWhInDtlVo> getCommodityWhInDtlVoLst() {
		return commodityWhInDtlVoLst;
	}
	public void setCommodityWhInDtlVoLst(List<CommodityWhInDtlVo> commodityWhInDtlVoLst) {
		this.commodityWhInDtlVoLst = commodityWhInDtlVoLst;
	}
	public CommodityWhIn getCommodityWhIn() {
		return commodityWhIn;
	}
	public void setCommodityWhIn(CommodityWhIn commodityWhIn) {
		this.commodityWhIn = commodityWhIn;
	}
	public List<CommodityWhInDtl> getCommodityWhInDtlLst() {
		return commodityWhInDtlLst;
	}
	public void setCommodityWhInDtlLst(List<CommodityWhInDtl> commodityWhInDtlLst) {
		this.commodityWhInDtlLst = commodityWhInDtlLst;
	}
	
}
