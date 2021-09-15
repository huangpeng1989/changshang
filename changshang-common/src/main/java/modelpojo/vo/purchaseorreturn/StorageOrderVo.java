package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhInAcpt;
import modelpojo.model.CommodityWhInAcptDtl;

import java.io.Serializable;
import java.util.List;


public class StorageOrderVo implements Serializable{

	/**
	 *
	 */


	private CommodityWhInAcpt commodityWhInAcpt;
	private List<CommodityWhInAcptVo> commodityWhInAcptVoList;
	private List<CommodityWhInAcptDtl> commodityWhInAcptDtlLst;
	private List<CommodityWhInAcptDtlVo> commodityWhInAcptDtlVoLst;

	public List<CommodityWhInAcptVo> getCommodityWhInAcptVoList() {
		return commodityWhInAcptVoList;
	}

	public void setCommodityWhInAcptVoList(List<CommodityWhInAcptVo> commodityWhInAcptVoList) {
		this.commodityWhInAcptVoList = commodityWhInAcptVoList;
	}

	public CommodityWhInAcpt getCommodityWhInAcpt() {
		return commodityWhInAcpt;
	}
	public void setCommodityWhInAcpt(CommodityWhInAcpt commodityWhInAcpt) {
		this.commodityWhInAcpt = commodityWhInAcpt;
	}
	public List<CommodityWhInAcptDtl> getCommodityWhInAcptDtlLst() {
		return commodityWhInAcptDtlLst;
	}
	public void setCommodityWhInAcptDtlLst(List<CommodityWhInAcptDtl> commodityWhInAcptDtlLst) {
		this.commodityWhInAcptDtlLst = commodityWhInAcptDtlLst;
	}
	public List<CommodityWhInAcptDtlVo> getCommodityWhInAcptDtlVoLst() {
		return commodityWhInAcptDtlVoLst;
	}
	public void setCommodityWhInAcptDtlVoLst(List<CommodityWhInAcptDtlVo> commodityWhInAcptDtlVoLst) {
		this.commodityWhInAcptDtlVoLst = commodityWhInAcptDtlVoLst;
	}

}
