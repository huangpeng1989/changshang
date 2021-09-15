package modelpojo.vo.purchaseorreturn;


import modelpojo.model.CommodityWhInReturn;

public class ReturnOrderListVo extends CommodityWhInReturn {

	/**
	 * 
	 */

	
	private String createrName;
	private String whName;
	private Integer whId;
	private String orderComDateStartTime;
	private String orderComDateEndTime;
	private String returnTimeStartTime;
	private String returnTimeEndTime;
	private String realWhinDateStartTime;
	private String realWhinDateEndTime;
	private String orderComDate;
	private String realWhinDate;
	private String suppName;
	private String statusName;
	/**当前页码 */
	private Integer pageNo;
	/**每页条数 */
	private Integer pageSize;
	private Integer whinBillId;

	private Integer jurisdictionType = 0;//权限类型

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}
	
	public String getOrderComDate() {
		return orderComDate;
	}
	public void setOrderComDate(String orderComDate) {
		this.orderComDate = orderComDate;
	}
	public String getRealWhinDate() {
		return realWhinDate;
	}
	public void setRealWhinDate(String realWhinDate) {
		this.realWhinDate = realWhinDate;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public Integer getWhinBillId() {
		return whinBillId;
	}
	public void setWhinBillId(Integer whinBillId) {
		this.whinBillId = whinBillId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getOrderComDateStartTime() {
		return orderComDateStartTime;
	}
	public void setOrderComDateStartTime(String orderComDateStartTime) {
		this.orderComDateStartTime = orderComDateStartTime;
	}
	public String getOrderComDateEndTime() {
		return orderComDateEndTime;
	}
	public void setOrderComDateEndTime(String orderComDateEndTime) {
		this.orderComDateEndTime = orderComDateEndTime;
	}
	public String getReturnTimeStartTime() {
		return returnTimeStartTime;
	}
	public void setReturnTimeStartTime(String returnTimeStartTime) {
		this.returnTimeStartTime = returnTimeStartTime;
	}
	public String getReturnTimeEndTime() {
		return returnTimeEndTime;
	}
	public void setReturnTimeEndTime(String returnTimeEndTime) {
		this.returnTimeEndTime = returnTimeEndTime;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
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
