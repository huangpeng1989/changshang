package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringWhIn implements Serializable {

    private static final long serialVersionUID = -4832288467878699811L;
    private Long projectId;

    private Integer whinBillId;
    private Long projectRootId;

    private String whinBillCode;

    private String suppCode;


    private String suppName;

    private Integer suppId;

    private Integer whId;



    private String whName;

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

    private Date ssbltStartTime;

    private Date ssbltEndTime;

    private String billBarcode;

    private String state;

    private String remark;

    private Long creater;
    private String createrStr;

    private Long modifier;
    private String modifierStr;

    private Long blEmpId;

    private String blEmpStr;
    private String ivtStatusName;
    private String caterStatusName;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;
    private Integer caterStatus;
    private Integer ivtStatus;

    private String oldWhinBillCode;

    public String getOldWhinBillCode() {
        return oldWhinBillCode;
    }

    public void setOldWhinBillCode(String oldWhinBillCode) {
        this.oldWhinBillCode = oldWhinBillCode;
    }

    public Integer getCaterStatus() {
        return caterStatus;
    }

    public void setCaterStatus(Integer caterStatus) {
        this.caterStatus = caterStatus;
    }

    public Integer getIvtStatus() {
        return ivtStatus;
    }

    public void setIvtStatus(Integer ivtStatus) {
        this.ivtStatus = ivtStatus;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    private String storageStatus;

    private List<CateringWhInDtl> whInDtlList;

    public String getIvtStatusName() {
        return ivtStatusName;
    }

    public void setIvtStatusName(String ivtStatusName) {
        this.ivtStatusName = ivtStatusName;
    }

    public String getCaterStatusName() {
        return caterStatusName;
    }

    public void setCaterStatusName(String caterStatusName) {
        this.caterStatusName = caterStatusName;
    }

    public String getBlEmpStr() {
        return blEmpStr;
    }

    public void setBlEmpStr(String blEmpStr) {
        this.blEmpStr = blEmpStr;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public List<CateringWhInDtl> getWhInDtlList() {
        return whInDtlList;
    }

    public void setWhInDtlList(List<CateringWhInDtl> whInDtlList) {
        this.whInDtlList = whInDtlList;
    }




    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getModifierStr() {
        return modifierStr;
    }

    public void setModifierStr(String modifierStr) {
        this.modifierStr = modifierStr;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
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

    public Date getSsbltStartTime() {
        return ssbltStartTime;
    }

    public void setSsbltStartTime(Date ssbltStartTime) {
        this.ssbltStartTime = ssbltStartTime;
    }

    public Date getSsbltEndTime() {
        return ssbltEndTime;
    }

    public void setSsbltEndTime(Date ssbltEndTime) {
        this.ssbltEndTime = ssbltEndTime;
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
