package modelpojo.vo.cateringcheck;

import modelpojo.model.CateringWhInvtryBill;

public class CateringWhInvtryBillVo extends CateringWhInvtryBill {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2306957717404228960L;

	private String whName;
	
	private String startCreaterName;
	
	private String entryBlEmpName;
	
	private Integer isEstimate;

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getStartCreaterName() {
		return startCreaterName;
	}

	public void setStartCreaterName(String startCreaterName) {
		this.startCreaterName = startCreaterName;
	}

	public String getEntryBlEmpName() {
		return entryBlEmpName;
	}

	public void setEntryBlEmpName(String entryBlEmpName) {
		this.entryBlEmpName = entryBlEmpName;
	}

	public Integer getIsEstimate() {
		return isEstimate;
	}

	public void setIsEstimate(Integer isEstimate) {
		this.isEstimate = isEstimate;
	}
	
}
