package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CommodityWhInReturn implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectId;

    private Long projectRootId;

    private Integer rtnBillId;

    private String rtnBillCode;

    private Integer acptBillId;

    private String acptBillCode;

    private Integer inWhId;

    private Integer suppId;

    private String suppCode;

    private Date returnTime;

    private Long accepter;

    private String state;

    private String remark;
    
    private String billBarcode;

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
    
    /**
     * 单据条码
     */
    private String billBarImgurl;
    
    public String getBillBarImgurl() {
		return billBarImgurl;
	}

	public void setBillBarImgurl(String billBarImgurl) {
		this.billBarImgurl = billBarImgurl;
	}

	public String getBillBarcode() {
		return billBarcode;
	}

	public void setBillBarcode(String billBarcode) {
		this.billBarcode = billBarcode;
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

    public Integer getRtnBillId() {
        return rtnBillId;
    }

    public void setRtnBillId(Integer rtnBillId) {
        this.rtnBillId = rtnBillId;
    }

    public String getRtnBillCode() {
        return rtnBillCode;
    }

    public void setRtnBillCode(String rtnBillCode) {
        this.rtnBillCode = rtnBillCode == null ? null : rtnBillCode.trim();
    }

    public Integer getAcptBillId() {
        return acptBillId;
    }

    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
    }

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode == null ? null : acptBillCode.trim();
    }

    public Integer getInWhId() {
        return inWhId;
    }

    public void setInWhId(Integer inWhId) {
        this.inWhId = inWhId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Long getAccepter() {
        return accepter;
    }

    public void setAccepter(Long accepter) {
        this.accepter = accepter;
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