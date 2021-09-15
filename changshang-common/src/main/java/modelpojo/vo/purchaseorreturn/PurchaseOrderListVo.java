package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhIn;

public class PurchaseOrderListVo extends CommodityWhIn {

	/**
	 * 
	 */

	
	private String billTypeName;
	private String createrName;
	private String suppCode;
	private String suppName;
	private String whName;
	private String storageStatus;
	private String orderStrartTime;
	private String orderEndTime;
	private String submitStrartTime;
	private String submitEndTime;
	private String storagedStrartTime;
	private String storagedEndTime;
	private String statusName;
	/**当前页码 */
	private Integer pageNo;
	/**每页条数 */
	private Integer pageSize;

	private Integer caterStatus;
	private Integer ivtStatus;
	private String ivtStatusName;
	private String caterStatusName;

	private Integer jurisdictionType = 0;//权限类型

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}

	public Integer getCaterStatus() {
		return caterStatus;
	}

	public void setCaterStatus(Integer caterStatus) {
		this.caterStatus = caterStatus;
	}

	public Integer getIvtStatus() {
		return ivtStatus;
	}

	public void setIvtStatus(Integer ivtStatus) {
		this.ivtStatus = ivtStatus;
	}

	public String getIvtStatusName() {
		return ivtStatusName;
	}

	public void setIvtStatusName(String ivtStatusName) {
		this.ivtStatusName = ivtStatusName;
	}

	public String getCaterStatusName() {
		return caterStatusName;
	}

	public void setCaterStatusName(String caterStatusName) {
		this.caterStatusName = caterStatusName;
	}

	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getOrderStrartTime() {
		return orderStrartTime;
	}
	public void setOrderStrartTime(String orderStrartTime) {
		this.orderStrartTime = orderStrartTime;
	}
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	public String getSubmitStrartTime() {
		return submitStrartTime;
	}
	public void setSubmitStrartTime(String submitStrartTime) {
		this.submitStrartTime = submitStrartTime;
	}
	public String getSubmitEndTime() {
		return submitEndTime;
	}
	public void setSubmitEndTime(String submitEndTime) {
		this.submitEndTime = submitEndTime;
	}
	public String getStoragedStrartTime() {
		return storagedStrartTime;
	}
	public void setStoragedStrartTime(String storagedStrartTime) {
		this.storagedStrartTime = storagedStrartTime;
	}
	public String getStoragedEndTime() {
		return storagedEndTime;
	}
	public void setStoragedEndTime(String storagedEndTime) {
		this.storagedEndTime = storagedEndTime;
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
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getBillTypeName() {
		return billTypeName;
	}
	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	
}
