package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringWhHandOfLossBill implements Serializable {

    private static final long serialVersionUID = 6975579402709869569L;
    private Integer olBillId;

    private Long projectId;


    private Long projectRootId;

    private String olBillCode;

    private Date olBillDate;

    private Long olEmpId;
    private String olEmpStr;

    private String olState;

    private String olRemark;

    private Long olCreater;


    private String createrStr;

    private Long olModifier;

    private Long olBlEmpId;

    private Date olCreatedTime;

    private Date olUpdatedTime;

    private Date olBlTime;

    private Integer whId;



    private String whName;

    private Integer olStatus;

    private Integer billType;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    private Integer paymentDaysId;
    private Date paymentDaysTime;
    private String paymentName;

    private Integer jurisdictionType;

    private Integer insertType;

    public Integer getInsertType() {
        return insertType;
    }

    public void setInsertType(Integer insertType) {
        this.insertType = insertType;
    }

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Date getPaymentDaysTime() {
        return paymentDaysTime;
    }

    public void setPaymentDaysTime(Date paymentDaysTime) {
        this.paymentDaysTime = paymentDaysTime;
    }
    public Integer getPaymentDaysId() {
        return paymentDaysId;
    }

    public void setPaymentDaysId(Integer paymentDaysId) {
        this.paymentDaysId = paymentDaysId;
    }


    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    private Integer goodType;
    private String billBarcode;

    public String getOlBlEmpStr() {
        return olBlEmpStr;
    }

    public void setOlBlEmpStr(String olBlEmpStr) {
        this.olBlEmpStr = olBlEmpStr;
    }

    private String olBlEmpStr;

    public String getOlEmpStr() {
        return olEmpStr;
    }

    public void setOlEmpStr(String olEmpStr) {
        this.olEmpStr = olEmpStr;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
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

    private Date createdTime;
    private Date updatedTime;

    private List<CateringWhHandOfLossBillDtl> reportLossDetailList;
    private List<CateringWhHandOfLossBillDtl> dishDetailList;
    private List<CateringWhHandOfLossBillDtl> lossDishes;

    public List<CateringWhHandOfLossBillDtl> getLossDishes() {
        return lossDishes;
    }

    public void setLossDishes(List<CateringWhHandOfLossBillDtl> lossDishes) {
        this.lossDishes = lossDishes;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode;
    }

    public List<CateringWhHandOfLossBillDtl> getReportLossDetailList() {
        return reportLossDetailList;
    }

    public void setReportLossDetailList(List<CateringWhHandOfLossBillDtl> reportLossDetailList) {
        this.reportLossDetailList = reportLossDetailList;
    }

    public List<CateringWhHandOfLossBillDtl> getDishDetailList() {
        return dishDetailList;
    }

    public void setDishDetailList(List<CateringWhHandOfLossBillDtl> dishDetailList) {
        this.dishDetailList = dishDetailList;
    }



     public Integer getOlBillId() {
        return olBillId;
    }

    public void setOlBillId(Integer olBillId) {
        this.olBillId = olBillId;
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

    public String getOlBillCode() {
        return olBillCode;
    }

    public void setOlBillCode(String olBillCode) {
        this.olBillCode = olBillCode == null ? null : olBillCode.trim();
    }

    public Date getOlBillDate() {
        return olBillDate;
    }

    public void setOlBillDate(Date olBillDate) {
        this.olBillDate = olBillDate;
    }

    public Long getOlEmpId() {
        return olEmpId;
    }

    public void setOlEmpId(Long olEmpId) {
        this.olEmpId = olEmpId;
    }

    public String getOlState() {
        return olState;
    }

    public void setOlState(String olState) {
        this.olState = olState == null ? null : olState.trim();
    }

    public String getOlRemark() {
        return olRemark;
    }

    public void setOlRemark(String olRemark) {
        this.olRemark = olRemark == null ? null : olRemark.trim();
    }

    public Long getOlCreater() {
        return olCreater;
    }

    public void setOlCreater(Long olCreater) {
        this.olCreater = olCreater;
    }

    public Long getOlModifier() {
        return olModifier;
    }

    public void setOlModifier(Long olModifier) {
        this.olModifier = olModifier;
    }

    public Long getOlBlEmpId() {
        return olBlEmpId;
    }

    public void setOlBlEmpId(Long olBlEmpId) {
        this.olBlEmpId = olBlEmpId;
    }

    public Date getOlCreatedTime() {
        return olCreatedTime;
    }

    public void setOlCreatedTime(Date olCreatedTime) {
        this.olCreatedTime = olCreatedTime;
    }

    public Date getOlUpdatedTime() {
        return olUpdatedTime;
    }

    public void setOlUpdatedTime(Date olUpdatedTime) {
        this.olUpdatedTime = olUpdatedTime;
    }

    public Date getOlBlTime() {
        return olBlTime;
    }

    public void setOlBlTime(Date olBlTime) {
        this.olBlTime = olBlTime;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getOlStatus() {
        return olStatus;
    }

    public void setOlStatus(Integer olStatus) {
        this.olStatus = olStatus;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
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
