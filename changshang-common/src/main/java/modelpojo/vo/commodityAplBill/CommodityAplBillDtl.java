package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommodityAplBillDtl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8985865721610238289L;
	private Long projectId;
	private Long projectRootId;
	private Integer aplBillId;
	private Integer aplBillDtlId;
	private Integer comId;
	private String comCode;
	private Integer comUnit;
	private Integer saleComId;
	private String saleComCode;
	private Integer saleComUnit;
	private BigDecimal allotNum;
	private BigDecimal inNum;
	private BigDecimal aplNum;
	private Integer remark;
	private Integer description;
	private Integer tAplBillId;
	private String tAplBillCode;
	private Integer billSource;
	
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
	public Integer getAplBillDtlId() {
		return aplBillDtlId;
	}
	public void setAplBillDtlId(Integer aplBillDtlId) {
		this.aplBillDtlId = aplBillDtlId;
	}
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public Integer getComUnit() {
		return comUnit;
	}
	public void setComUnit(Integer comUnit) {
		this.comUnit = comUnit;
	}
	public Integer getSaleComId() {
		return saleComId;
	}
	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}
	public String getSaleComCode() {
		return saleComCode;
	}
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}
	public Integer getSaleComUnit() {
		return saleComUnit;
	}
	public void setSaleComUnit(Integer saleComUnit) {
		this.saleComUnit = saleComUnit;
	}
	public BigDecimal getAllotNum() {
		return allotNum;
	}
	public void setAllotNum(BigDecimal allotNum) {
		this.allotNum = allotNum;
	}
	public BigDecimal getInNum() {
		return inNum;
	}
	public void setInNum(BigDecimal inNum) {
		this.inNum = inNum;
	}
	public BigDecimal getAplNum() {
		return aplNum;
	}
	public void setAplNum(BigDecimal aplNum) {
		this.aplNum = aplNum;
	}
	public Integer getRemark() {
		return remark;
	}
	public void setRemark(Integer remark) {
		this.remark = remark;
	}
	public Integer getDescription() {
		return description;
	}
	public void setDescription(Integer description) {
		this.description = description;
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
		this.tAplBillCode =  tAplBillCode;
	}
	public Integer getBillSource() {
		return billSource;
	}
	public void setBillSource(Integer billSource) {
		this.billSource = billSource;
	}

}
