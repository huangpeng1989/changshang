package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhIn;

public class CommodityWhInVo extends CommodityWhIn {

	/**
	 * 
	 */

	
	private String suppName;
	private String whName;
	private String storageStatus;
	private Integer isCheck;
	private String createrName;
	private String blEmpName;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
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
	public Integer getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
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
