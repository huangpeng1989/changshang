package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringWhInAcpt implements Serializable {

    private static final long serialVersionUID = 717079473714833523L;
    private Integer acptBillId;

    private Long projectId;


    private Long projectRootId;

    private String acptBillCode;

    private String whinBillId;

    private String whinBillCode;

    private Integer inWhId;

    private Integer suppId;

    private String suppCode;

    private Date orderComDate;

    private Date pdtWhinDate;

    private Date realWhinDate;

    private Long accepter;

    private String state;

    private String ivtStatusName;
    private String caterStatusName;

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


    private String billBarcode;
    private String modifierStr;
    private String accepterStr;



    private String createrStr;
    private String statusStr;
    private String suppName;


    private Integer paymentDaysId;

    private Date paymentDaysTime;
    private String paymentName;

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


    public String getAccepterStr() {
        return accepterStr;
    }

    public void setAccepterStr(String accepterStr) {
        this.accepterStr = accepterStr;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getInWhName() {
        return inWhName;
    }

    public void setInWhName(String inWhName) {
        this.inWhName = inWhName;
    }

    private String inWhName;

    public String getModifierStr() {
        return modifierStr;
    }

    public void setModifierStr(String modifierStr) {
        this.modifierStr = modifierStr;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode;
    }


      public Integer getAcptBillId() {
        return acptBillId;
    }

    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
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

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode == null ? null : acptBillCode.trim();
    }

    public String getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(String whinBillId) {
        this.whinBillId = whinBillId == null ? null : whinBillId.trim();
    }

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode == null ? null : whinBillCode.trim();
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

    public Date getOrderComDate() {
        return orderComDate;
    }

    public void setOrderComDate(Date orderComDate) {
        this.orderComDate = orderComDate;
    }

    public Date getPdtWhinDate() {
        return pdtWhinDate;
    }

    public void setPdtWhinDate(Date pdtWhinDate) {
        this.pdtWhinDate = pdtWhinDate;
    }

    public Date getRealWhinDate() {
        return realWhinDate;
    }

    public void setRealWhinDate(Date realWhinDate) {
        this.realWhinDate = realWhinDate;
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
