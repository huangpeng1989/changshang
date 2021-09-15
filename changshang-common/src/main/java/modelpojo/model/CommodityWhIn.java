package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommodityWhIn implements Serializable {
    /**
	 * 
	 */


	private Integer whinBillId;

    private Long projectId;

    private Long projectRootId;

    private String whinBillCode;

    private String suppCode;

    private Integer suppId;

    private Integer whId;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderComDate;

    private Date whinPlanDate;

    private Date whinEndDate;

    private String firLocCode;

    private String secLocCode;

    private String thrLocCode;

    private String detailLoc;

    private Byte isGift;

    private Integer billType;

    private Integer pmtTheme;

    private String billBarcode;
    
    private String billBarImgurl;

    private String state;

    private String remark;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;
    
	private String storageStatus;
	
    public String getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus;
	}

	public String getBillBarImgurl() {
		return billBarImgurl;
	}

	public void setBillBarImgurl(String billBarImgurl) {
		this.billBarImgurl = billBarImgurl;
	}

	public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
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

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode == null ? null : whinBillCode.trim();
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Date getOrderComDate() {
        return orderComDate;
    }

    public void setOrderComDate(Date orderComDate) {
        this.orderComDate = orderComDate;
    }

    public Date getWhinPlanDate() {
        return whinPlanDate;
    }

    public void setWhinPlanDate(Date whinPlanDate) {
        this.whinPlanDate = whinPlanDate;
    }

    public Date getWhinEndDate() {
        return whinEndDate;
    }

    public void setWhinEndDate(Date whinEndDate) {
        this.whinEndDate = whinEndDate;
    }

    public String getFirLocCode() {
        return firLocCode;
    }

    public void setFirLocCode(String firLocCode) {
        this.firLocCode = firLocCode == null ? null : firLocCode.trim();
    }

    public String getSecLocCode() {
        return secLocCode;
    }

    public void setSecLocCode(String secLocCode) {
        this.secLocCode = secLocCode == null ? null : secLocCode.trim();
    }

    public String getThrLocCode() {
        return thrLocCode;
    }

    public void setThrLocCode(String thrLocCode) {
        this.thrLocCode = thrLocCode == null ? null : thrLocCode.trim();
    }

    public String getDetailLoc() {
        return detailLoc;
    }

    public void setDetailLoc(String detailLoc) {
        this.detailLoc = detailLoc == null ? null : detailLoc.trim();
    }

    public Byte getIsGift() {
        return isGift;
    }

    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getPmtTheme() {
        return pmtTheme;
    }

    public void setPmtTheme(Integer pmtTheme) {
        this.pmtTheme = pmtTheme;
    }

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode == null ? null : billBarcode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }
}