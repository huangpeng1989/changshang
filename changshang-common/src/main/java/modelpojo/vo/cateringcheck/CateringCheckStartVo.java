package modelpojo.vo.cateringcheck;

import java.io.Serializable;
import java.util.List;


import modelpojo.model.CateringWhInvtryBill;
import modelpojo.model.CateringWhInvtryBillDtl;

public class CateringCheckStartVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CateringWhInvtryBill cateringWhInvtryBill;
	
	private List<Integer> whIds;
	
	private CateringWhInvtryBillVo cateringWhInvtryBillVo;
	
	private List<CateringWhInvtryBillDtlVo> cateringWhInvtryBillDtlVoLst;
	
	private List<CateringWhInvtryBillDtl> cateringWhInvtryBillDtlLst;
	
	public List<Integer> getWhIds() {
		return whIds;
	}

	public void setWhIds(List<Integer> whIds) {
		this.whIds = whIds;
	}

	public CateringWhInvtryBillVo getCateringWhInvtryBillVo() {
		return cateringWhInvtryBillVo;
	}

	public void setCateringWhInvtryBillVo(CateringWhInvtryBillVo cateringWhInvtryBillVo) {
		this.cateringWhInvtryBillVo = cateringWhInvtryBillVo;
	}

	public CateringWhInvtryBill getCateringWhInvtryBill() {
		return cateringWhInvtryBill;
	}

	public void setCateringWhInvtryBill(CateringWhInvtryBill cateringWhInvtryBill) {
		this.cateringWhInvtryBill = cateringWhInvtryBill;
	}

	public List<CateringWhInvtryBillDtlVo> getCateringWhInvtryBillDtlVoLst() {
		return cateringWhInvtryBillDtlVoLst;
	}

	public void setCateringWhInvtryBillDtlVoLst(List<CateringWhInvtryBillDtlVo> cateringWhInvtryBillDtlVoLst) {
		this.cateringWhInvtryBillDtlVoLst = cateringWhInvtryBillDtlVoLst;
	}

	public List<CateringWhInvtryBillDtl> getCateringWhInvtryBillDtlLst() {
		return cateringWhInvtryBillDtlLst;
	}

	public void setCateringWhInvtryBillDtlLst(List<CateringWhInvtryBillDtl> cateringWhInvtryBillDtlLst) {
		this.cateringWhInvtryBillDtlLst = cateringWhInvtryBillDtlLst;
	}

}
