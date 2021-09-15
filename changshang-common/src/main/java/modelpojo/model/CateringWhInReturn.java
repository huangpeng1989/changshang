package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringWhInReturn  implements Serializable {

    private static final long serialVersionUID = -6235777744631750608L;
    private Long projectId;

    private Integer rtnBillId;


    private Long projectRootId;

    private String rtnBillCode;

    private Integer acptBillId;

    private String acptBillCode;

    private Integer inWhId;

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    private String whName;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    private String suppName;

    private Integer suppId;

    private String suppCode;

    private Date returnTime;

    private Long accepter;

    private String state;

    private String remark;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    private String statusStr;

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    private String createrStr;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode;
    }

    private String billBarcode;

    private Integer paymentDaysId;

    private Date paymentDaysTime;

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


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRtnBillId() {
        return rtnBillId;
    }

    public void setRtnBillId(Integer rtnBillId) {
        this.rtnBillId = rtnBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
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
