package modelpojo.vo.cateringcheckreport;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CateringCheckReportListVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String whId;
	/**
	 * 仓库
	 */
	private String wh;
	/**
	 * 原材料
	 */
	private String rowmater;
	/**
	 * 单号
	 */
	private String billNo;
	/**
	 * 查询日期开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date queryDateStartTime;
	/**
	 * 查询日期结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date queryDateEndTime;
	/**
	 * 条数
	 */
	private Integer pageSize;
	/**
	 * 页码
	 */
	private Integer pageNo;
	/**
	 * 原材料分类(传最末级code)
	 */
	private String rowmaterClass;
	/**
	 * 项目id集合1,2,3，传当前集团公司以及下属公司id集合
	 */
	private Long[] projectIds;
	
	public String getWh() {
		return wh;
	}
	public void setWh(String wh) {
		this.wh = wh;
	}
	public String getRowmater() {
		return rowmater;
	}
	public void setRowmater(String rowmater) {
		this.rowmater = rowmater;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Date getQueryDateStartTime() {
		return queryDateStartTime;
	}
	public void setQueryDateStartTime(Date queryDateStartTime) {
		this.queryDateStartTime = queryDateStartTime;
	}
	public Date getQueryDateEndTime() {
		return queryDateEndTime;
	}
	public void setQueryDateEndTime(Date queryDateEndTime) {
		this.queryDateEndTime = queryDateEndTime;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getRowmaterClass() {
		return rowmaterClass;
	}
	public void setRowmaterClass(String rowmaterClass) {
		this.rowmaterClass = rowmaterClass;
	}
	public Long[] getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(Long[] projectIds) {
		this.projectIds = projectIds;
	}
	public String getWhId() {
		return whId;
	}
	public void setWhId(String whId) {
		this.whId = whId;
	}
	
}
