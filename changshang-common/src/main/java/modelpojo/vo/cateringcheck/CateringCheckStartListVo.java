package modelpojo.vo.cateringcheck;

import modelpojo.model.CateringWhInvtryBill;

public class CateringCheckStartListVo extends CateringWhInvtryBill {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String whName;
	
	private String ivtStartDateStartTime;
	
	private String ivtStartDateEndTime;
	
	private String entryCreatedTimeStartTime;
	
	private String entryCreatedTimeEndTime;
	
	private String entryBillCode;
	
	private Integer entryStatus;
	//查询录入单为1，否则为启动单
	private String type;
	
	private String entryCreaterName;
	private String entryStatusName;
	private String startCreaterName;
	private String startStatusName;
	
	/**
	 * 盘点方式名称
	 */
	private String ivtModeName;

	private String entryName;

	private	String oneEntryName;

	private	String twoEntryName;

	private	String threeEntryName;

	private String updateNowTime;

	private Integer jurisdictionType;

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}

	public String getOneEntryName() {
		return oneEntryName;
	}

	public void setOneEntryName(String oneEntryName) {
		this.oneEntryName = oneEntryName;
	}

	public String getTwoEntryName() {
		return twoEntryName;
	}

	public void setTwoEntryName(String twoEntryName) {
		this.twoEntryName = twoEntryName;
	}

	public String getThreeEntryName() {
		return threeEntryName;
	}

	public void setThreeEntryName(String threeEntryName) {
		this.threeEntryName = threeEntryName;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getUpdateNowTime() {
		return updateNowTime;
	}

	public void setUpdateNowTime(String updateNowTime) {
		this.updateNowTime = updateNowTime;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIvtModeName() {
		return ivtModeName;
	}

	public void setIvtModeName(String ivtModeName) {
		this.ivtModeName = ivtModeName;
	}

	public String getEntryCreaterName() {
		return entryCreaterName;
	}

	public void setEntryCreaterName(String entryCreaterName) {
		this.entryCreaterName = entryCreaterName;
	}

	public String getEntryStatusName() {
		return entryStatusName;
	}

	public void setEntryStatusName(String entryStatusName) {
		this.entryStatusName = entryStatusName;
	}

	public String getStartCreaterName() {
		return startCreaterName;
	}

	public void setStartCreaterName(String startCreaterName) {
		this.startCreaterName = startCreaterName;
	}

	public String getStartStatusName() {
		return startStatusName;
	}

	public void setStartStatusName(String startStatusName) {
		this.startStatusName = startStatusName;
	}

	/**当前页码 */
	private Integer pageNo;
	
	/**每页条数 */
	private Integer pageSize;

	public String getEntryCreatedTimeStartTime() {
		return entryCreatedTimeStartTime;
	}

	public void setEntryCreatedTimeStartTime(String entryCreatedTimeStartTime) {
		this.entryCreatedTimeStartTime = entryCreatedTimeStartTime;
	}

	public String getEntryCreatedTimeEndTime() {
		return entryCreatedTimeEndTime;
	}

	public void setEntryCreatedTimeEndTime(String entryCreatedTimeEndTime) {
		this.entryCreatedTimeEndTime = entryCreatedTimeEndTime;
	}

	public String getEntryBillCode() {
		return entryBillCode;
	}

	public void setEntryBillCode(String entryBillCode) {
		this.entryBillCode = entryBillCode;
	}

	public Integer getEntryStatus() {
		return entryStatus;
	}

	public void setEntryStatus(Integer entryStatus) {
		this.entryStatus = entryStatus;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
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

	public String getIvtStartDateStartTime() {
		return ivtStartDateStartTime;
	}

	public void setIvtStartDateStartTime(String ivtStartDateStartTime) {
		this.ivtStartDateStartTime = ivtStartDateStartTime;
	}

	public String getIvtStartDateEndTime() {
		return ivtStartDateEndTime;
	}

	public void setIvtStartDateEndTime(String ivtStartDateEndTime) {
		this.ivtStartDateEndTime = ivtStartDateEndTime;
	}
	
}
