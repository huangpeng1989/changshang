package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhInReturn;

public class CommodityWhInReturnVo extends CommodityWhInReturn {

	/**
	 * 
	 */

	
	private String suppName;
	private String whName;
	private String storageStatus;
	private String createrName;
	private String blEmpName;
	
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getBlEmpName() {
		return blEmpName;
	}
	public void setBlEmpName(String blEmpName) {
		this.blEmpName = blEmpName;
	}
	
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getStorageStatus() {
		return storageStatus;
	}
	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus;
	}

}
