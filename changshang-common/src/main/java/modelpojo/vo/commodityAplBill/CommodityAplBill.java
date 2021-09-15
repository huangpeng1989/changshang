package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommodityAplBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966574790856451430L;
	private Long projectId;
	private Long projectRootId;
	private Integer aplBillId;
	private String aplBillCode;
	private Integer gzoneId;
	private Integer aplWhId;
	private Long comEmpId;
	private Integer whId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aplDate;
	private Integer dealEmpId;
	private String remark;
	private Integer aplStatus;
	
	private Integer tAplBillId;
	private String tAplBillCode;
	private String comEmpName;

	private Integer billSource;

	private String whinBillCode;//采购单号
	private String altOutBillCode;//调出单号

	public String getWhinBillCode() {
		return whinBillCode;
	}

	public void setWhinBillCode(String whinBillCode) {
		this.whinBillCode = whinBillCode;
	}

	public String getAltOutBillCode() {
		return altOutBillCode;
	}

	public void setAltOutBillCode(String altOutBillCode) {
		this.altOutBillCode = altOutBillCode;
	}

	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getProjectRootId() {
		return projectRootId;
	}
	public void setProjectRootId(Long projectRootId) {
		this.projectRootId = projectRootId;
	}
	public Integer getAplBillId() {
		return aplBillId;
	}
	public void setAplBillId(Integer aplBillId) {
		this.aplBillId = aplBillId;
	}
	public String getAplBillCode() {
		return aplBillCode;
	}
	public void setAplBillCode(String aplBillCode) {
		this.aplBillCode = aplBillCode;
	}
	public Integer getGzoneId() {
		return gzoneId;
	}
	public void setGzoneId(Integer gzoneId) {
		this.gzoneId = gzoneId;
	}
	public Integer getAplWhId() {
		return aplWhId;
	}
	public void setAplWhId(Integer aplWhId) {
		this.aplWhId = aplWhId;
	}
	public Long getComEmpId() {
		return comEmpId;
	}
	public void setComEmpId(Long comEmpId ) {
		this.comEmpId = comEmpId;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public Date getAplDate() {
		return aplDate;
	}
	public void setAplDate(Date aplDate) {
		this.aplDate = aplDate;
	}
	public Integer getDealEmpId() {
		return dealEmpId;
	}
	public void setDealEmpId(Integer dealEmpId) {
		this.dealEmpId = dealEmpId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getAplStatus() {
		return aplStatus;
	}
	public void setAplStatus(Integer aplStatus) {
		this.aplStatus = aplStatus;
	}
	public Integer gettAplBillId() {
		return tAplBillId;
	}
	public void settAplBillId(Integer tAplBillId) {
		this.tAplBillId = tAplBillId;
	}
	public String gettAplBillCode() {
		return tAplBillCode;
	}
	public void settAplBillCode(String tAplBillCode) {
		this.tAplBillCode = tAplBillCode;
	}
	public String getComEmpName() {
		return comEmpName;
	}
	public void setComEmpName(String comEmpName) {
		this.comEmpName =  comEmpName;
	}
	public Integer getBillSource() {
		return billSource;
	}
	public void setBillSource(Integer billSource) {
		this.billSource = billSource;
	}

}
