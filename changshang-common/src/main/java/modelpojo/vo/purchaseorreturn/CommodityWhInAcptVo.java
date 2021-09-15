package modelpojo.vo.purchaseorreturn;


import modelpojo.model.CommodityWhInAcpt;

public class CommodityWhInAcptVo extends CommodityWhInAcpt {

	/**
	 *
	 */


	private String suppName;
	private String whName;
	private String storageStatus;
	private String billTypeName;
	private String accepterName;
	private String createrName;
	private String blEmpName;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String detailLoc;
	private String whinEndDate;

	public String getWhinEndDate() {
		return whinEndDate;
	}

	public void setWhinEndDate(String whinEndDate) {
		this.whinEndDate = whinEndDate;
	}

	public String getDetailLoc() {
		return detailLoc;
	}
	public void setDetailLoc(String detailLoc) {
		this.detailLoc = detailLoc;
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

	public String getAccepterName() {
		return accepterName;
	}
	public void setAccepterName(String accepterName) {
		this.accepterName = accepterName;
	}
	public String getBillTypeName() {
		return billTypeName;
	}
	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
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
