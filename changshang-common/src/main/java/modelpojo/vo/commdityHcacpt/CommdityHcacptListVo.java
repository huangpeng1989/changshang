package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommdityHcacptListVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2848887098543175520L;
	private Integer hcBillId;//红冲订单id
	private String hcBillCode;//红冲订单编号
	private String hcEmpName;//红冲人
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date orderComDate;//红冲日期
	private String createrName;//录入人名字（创建人名字）
	private String blEmpName;//审核人名字
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date createdTime;//创建时间
	private Integer status;//状态 审核状态 待审核14901  审核驳回14902 审核通过14903 已删除14904
	private Integer whId;//仓库id
	private String whName;//仓库名称
	private String accepterName;//验收人姓名
	private Integer acptBillId;//验收单id
	private String acptBillCode;//验收单编码
	private String suppName;//供应商名称

	private Integer jurisdictionType;//权限类型

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}
	
	public Integer getHcBillId() {
		return hcBillId;
	}
	public void setHcBillId(Integer hcBillId) {
		this.hcBillId = hcBillId;
	}
	public String getHcBillCode() {
		return hcBillCode;
	}
	public void setHcBillCode(String hcBillCode) {
		this.hcBillCode = hcBillCode;
	}
	public String getHcEmpName() {
		return hcEmpName;
	}
	public void setHcEmpName(String hcEmpName) {
		this.hcEmpName = hcEmpName;
	}
	public Date getOrderComDate() {
		return orderComDate;
	}
	public void setOrderComDate(Date orderComDate) {
		this.orderComDate = orderComDate;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getAccepterName() {
		return accepterName;
	}
	public void setAccepterName(String accepterName) {
		this.accepterName = accepterName;
	}
	public String getAcptBillCode() {
		return acptBillCode;
	}
	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
	}
	public Integer getAcptBillId() {
		return acptBillId;
	}
	public void setAcptBillId(Integer acptBillId) {
		this.acptBillId = acptBillId;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getBlEmpName() {
		return blEmpName;
	}
	public void setBlEmpName(String blEmpName) {
		this.blEmpName = blEmpName;
	}
	
}
