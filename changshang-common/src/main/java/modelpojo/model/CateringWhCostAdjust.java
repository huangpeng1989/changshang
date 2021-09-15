package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringWhCostAdjust implements Serializable {
    private Long projectRootId;

    private String caBillCode;

    private Date adjTime;

    private Integer acptBillId;

    private String acptBillCode;

    private String state;

    private String remark;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Integer isDelete;

    private Integer syncStatus;

    private Integer stockStatus;
	
	 private Integer caBillId;

    private Long projectId;

    private List<CateringWhCostAdjustDtl> adjustDtls;

    public List<CateringWhCostAdjustDtl> getAdjustDtls() {
        return adjustDtls;
    }

    public void setAdjustDtls(List<CateringWhCostAdjustDtl> adjustDtls) {
        this.adjustDtls = adjustDtls;
    }

    public Integer getCaBillId() {
        return caBillId;
    }

    public void setCaBillId(Integer caBillId) {
        this.caBillId = caBillId;
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

    public String getCaBillCode() {
        return caBillCode;
    }

    public void setCaBillCode(String caBillCode) {
        this.caBillCode = caBillCode == null ? null : caBillCode.trim();
    }

    public Date getAdjTime() {
        return adjTime;
    }

    public void setAdjTime(Date adjTime) {
        this.adjTime = adjTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
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