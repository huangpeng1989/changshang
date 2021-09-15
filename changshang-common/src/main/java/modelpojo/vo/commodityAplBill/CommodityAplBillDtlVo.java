package modelpojo.vo.commodityAplBill;

import java.io.Serializable;

public class CommodityAplBillDtlVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2669879405907504167L;
	//要货单id
	private Integer aplBillId;
	//申请单明细id
	private Integer aplBillDtlId;
	
	private Integer aplResult;
	
	private Integer allotNum; 
	
	private Integer inNum;
	
	private String rejectResion;

	private Integer saleComId;

	private Integer suppId;

	public Integer getAplBillId() {
		return aplBillId;
	}

	public void setAplBillId(Integer aplBillId) {
		this.aplBillId = aplBillId;
	}

	public Integer getAplBillDtlId() {
		return aplBillDtlId;
	}

	public void setAplBillDtlId(Integer aplBillDtlId) {
		this.aplBillDtlId = aplBillDtlId;
	}

	public Integer getAplResult() {
		return aplResult;
	}

	public void setAplResult(Integer aplResult) {
		this.aplResult = aplResult;
	}

	public Integer getAllotNum() {
		return allotNum;
	}

	public void setAllotNum(Integer allotNum) {
		this.allotNum = allotNum;
	}

	public Integer getInNum() {
		return inNum;
	}

	public void setInNum(Integer inNum) {
		this.inNum = inNum;
	}

	public String getRejectResion() {
		return rejectResion;
	}

	public void setRejectResion(String rejectResion) {
		this.rejectResion = rejectResion;
	}

	public Integer getSaleComId() {
		return saleComId;
	}

	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}

	public Integer getSuppId() {
		return suppId;
	}

	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}

}
