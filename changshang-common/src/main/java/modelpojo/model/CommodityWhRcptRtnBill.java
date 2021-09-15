package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CommodityWhRcptRtnBill implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectRootId;

    private String rcptBillCode;

    private Date rcptTime;

    private Integer rcptDeptId;

    private Long rcptEmpId;

    private String rcptState;

    private String rcptRemark;

    private Long rcptCreater;

    private Long rcptModifier;

    private Long rcptBlEmpId;

    private Date rcptCreatedTime;

    private Date rcptUpdatedTime;

    private Date rcptBlTime;

    private Integer rcptStatus;

    private String rtnBillCode;

    private Date rtnTime;

    private Integer rtnDeptId;

    private Long rtnEmpId;

    private String rtnState;

    private String rtnRemark;

    private Long rtnCreater;

    private Long rtnModifier;

    private Long rtnBlEmpId;

    private Date rtnCreatedTime;

    private Date rtnUpdatedTime;

    private Date rtnBlTime;

    private Integer rtnStatus;

    private Integer rcptRtnWhId;

    private Byte isNeedRtn;

    private Byte rcptIsDelete;

    private Byte rtnIsDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    private Date createdTime;

    private Date updatedTime;
	
	private Long projectId;

    private Integer rcptBillId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRcptBillId() {
        return rcptBillId;
    }

    public void setRcptBillId(Integer rcptBillId) {
        this.rcptBillId = rcptBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getRcptBillCode() {
        return rcptBillCode;
    }

    public void setRcptBillCode(String rcptBillCode) {
        this.rcptBillCode = rcptBillCode == null ? null : rcptBillCode.trim();
    }

    public Date getRcptTime() {
        return rcptTime;
    }

    public void setRcptTime(Date rcptTime) {
        this.rcptTime = rcptTime;
    }

    public Integer getRcptDeptId() {
        return rcptDeptId;
    }

    public void setRcptDeptId(Integer rcptDeptId) {
        this.rcptDeptId = rcptDeptId;
    }

    public Long getRcptEmpId() {
        return rcptEmpId;
    }

    public void setRcptEmpId(Long rcptEmpId) {
        this.rcptEmpId = rcptEmpId;
    }

    public String getRcptState() {
        return rcptState;
    }

    public void setRcptState(String rcptState) {
        this.rcptState = rcptState == null ? null : rcptState.trim();
    }

    public String getRcptRemark() {
        return rcptRemark;
    }

    public void setRcptRemark(String rcptRemark) {
        this.rcptRemark = rcptRemark == null ? null : rcptRemark.trim();
    }

    public Long getRcptCreater() {
        return rcptCreater;
    }

    public void setRcptCreater(Long rcptCreater) {
        this.rcptCreater = rcptCreater;
    }

    public Long getRcptModifier() {
        return rcptModifier;
    }

    public void setRcptModifier(Long rcptModifier) {
        this.rcptModifier = rcptModifier;
    }

    public Long getRcptBlEmpId() {
        return rcptBlEmpId;
    }

    public void setRcptBlEmpId(Long rcptBlEmpId) {
        this.rcptBlEmpId = rcptBlEmpId;
    }

    public Date getRcptCreatedTime() {
        return rcptCreatedTime;
    }

    public void setRcptCreatedTime(Date rcptCreatedTime) {
        this.rcptCreatedTime = rcptCreatedTime;
    }

    public Date getRcptUpdatedTime() {
        return rcptUpdatedTime;
    }

    public void setRcptUpdatedTime(Date rcptUpdatedTime) {
        this.rcptUpdatedTime = rcptUpdatedTime;
    }

    public Date getRcptBlTime() {
        return rcptBlTime;
    }

    public void setRcptBlTime(Date rcptBlTime) {
        this.rcptBlTime = rcptBlTime;
    }

    public Integer getRcptStatus() {
        return rcptStatus;
    }

    public void setRcptStatus(Integer rcptStatus) {
        this.rcptStatus = rcptStatus;
    }

    public String getRtnBillCode() {
        return rtnBillCode;
    }

    public void setRtnBillCode(String rtnBillCode) {
        this.rtnBillCode = rtnBillCode == null ? null : rtnBillCode.trim();
    }

    public Date getRtnTime() {
        return rtnTime;
    }

    public void setRtnTime(Date rtnTime) {
        this.rtnTime = rtnTime;
    }

    public Integer getRtnDeptId() {
        return rtnDeptId;
    }

    public void setRtnDeptId(Integer rtnDeptId) {
        this.rtnDeptId = rtnDeptId;
    }

    public Long getRtnEmpId() {
        return rtnEmpId;
    }

    public void setRtnEmpId(Long rtnEmpId) {
        this.rtnEmpId = rtnEmpId;
    }

    public String getRtnState() {
        return rtnState;
    }

    public void setRtnState(String rtnState) {
        this.rtnState = rtnState == null ? null : rtnState.trim();
    }

    public String getRtnRemark() {
        return rtnRemark;
    }

    public void setRtnRemark(String rtnRemark) {
        this.rtnRemark = rtnRemark == null ? null : rtnRemark.trim();
    }

    public Long getRtnCreater() {
        return rtnCreater;
    }

    public void setRtnCreater(Long rtnCreater) {
        this.rtnCreater = rtnCreater;
    }

    public Long getRtnModifier() {
        return rtnModifier;
    }

    public void setRtnModifier(Long rtnModifier) {
        this.rtnModifier = rtnModifier;
    }

    public Long getRtnBlEmpId() {
        return rtnBlEmpId;
    }

    public void setRtnBlEmpId(Long rtnBlEmpId) {
        this.rtnBlEmpId = rtnBlEmpId;
    }

    public Date getRtnCreatedTime() {
        return rtnCreatedTime;
    }

    public void setRtnCreatedTime(Date rtnCreatedTime) {
        this.rtnCreatedTime = rtnCreatedTime;
    }

    public Date getRtnUpdatedTime() {
        return rtnUpdatedTime;
    }

    public void setRtnUpdatedTime(Date rtnUpdatedTime) {
        this.rtnUpdatedTime = rtnUpdatedTime;
    }

    public Date getRtnBlTime() {
        return rtnBlTime;
    }

    public void setRtnBlTime(Date rtnBlTime) {
        this.rtnBlTime = rtnBlTime;
    }

    public Integer getRtnStatus() {
        return rtnStatus;
    }

    public void setRtnStatus(Integer rtnStatus) {
        this.rtnStatus = rtnStatus;
    }

    public Integer getRcptRtnWhId() {
        return rcptRtnWhId;
    }

    public void setRcptRtnWhId(Integer rcptRtnWhId) {
        this.rcptRtnWhId = rcptRtnWhId;
    }

    public Byte getIsNeedRtn() {
        return isNeedRtn;
    }

    public void setIsNeedRtn(Byte isNeedRtn) {
        this.isNeedRtn = isNeedRtn;
    }

    public Byte getRcptIsDelete() {
        return rcptIsDelete;
    }

    public void setRcptIsDelete(Byte rcptIsDelete) {
        this.rcptIsDelete = rcptIsDelete;
    }

    public Byte getRtnIsDelete() {
        return rtnIsDelete;
    }

    public void setRtnIsDelete(Byte rtnIsDelete) {
        this.rtnIsDelete = rtnIsDelete;
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
}