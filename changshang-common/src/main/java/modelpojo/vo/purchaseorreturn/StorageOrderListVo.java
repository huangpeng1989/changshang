package modelpojo.vo.purchaseorreturn;

import modelpojo.model.CommodityWhInAcpt;

public class StorageOrderListVo extends CommodityWhInAcpt {

	/**
	 * 
	 */

	
	private String createrName;
	private String whinBillCode;
	private Integer whId;
	private String whName;
	private String realWhinDateStartTime;
	private String realWhinDateEndTime;
	private String statusName;
	private String suppCode;
	private String suppName;
	private Integer suppId;
	/**当前页码 */
	private Integer pageNo;
	/**每页条数 */
	private Integer pageSize;

	private Integer jurisdictionType = 0;//权限类型

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
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
	public Integer getSuppId() {
		return suppId;
	}
	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getWhinBillCode() {
		return whinBillCode;
	}
	public void setWhinBillCode(String whinBillCode) {
		this.whinBillCode = whinBillCode;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getRealWhinDateStartTime() {
		return realWhinDateStartTime;
	}
	public void setRealWhinDateStartTime(String realWhinDateStartTime) {
		this.realWhinDateStartTime = realWhinDateStartTime;
	}
	public String getRealWhinDateEndTime() {
		return realWhinDateEndTime;
	}
	public void setRealWhinDateEndTime(String realWhinDateEndTime) {
		this.realWhinDateEndTime = realWhinDateEndTime;
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
	
}
