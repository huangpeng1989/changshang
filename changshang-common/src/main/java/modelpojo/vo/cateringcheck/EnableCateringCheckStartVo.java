package modelpojo.vo.cateringcheck;


import modelpojo.vo.purchaseorreturn.BillCheckMthVo;

public class EnableCateringCheckStartVo extends BillCheckMthVo {
	
	private String acptBillCode;
	
	private String typeName;
	
	private String whName;
	
	private String ivtCode;
	
	private Integer success;
	
	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getIvtCode() {
		return ivtCode;
	}

	public void setIvtCode(String ivtCode) {
		this.ivtCode = ivtCode;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public String getAcptBillCode() {
		return acptBillCode;
	}

	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
