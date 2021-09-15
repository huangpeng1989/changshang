package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringWhHcacptBill implements Serializable {

    private static final long serialVersionUID = -6491467939759047249L;
    private Integer hcBillId;

    private Long projectId;


    private Long projectRootId;

    private String hcBillCode;

    private Integer acptBillId;

    private String acptBillCode;

    private Date hcTime;

    private String hcBillBarcode;

    private String hcEmpName;

    private Integer inWhId;


    private Long accepter;
    private String accepterStr;

    private String state;

    private String remark;

    private Long creater;
    private String createrStr;

    private Long modifier;

    private Long blEmpId;
    private String blEmpName;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;
    private String statusStr;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    private String hcBillBarImgurl;

    private Integer paymentDaysId;
    private Date paymentDaysTime;
    private String paymentName;

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





    private String whName;

    public String getBlEmpName() {
        return blEmpName;
    }

    public void setBlEmpName(String blEmpName) {
        this.blEmpName = blEmpName;
    }

    public String getAccepterStr() {
        return accepterStr;
    }

    public void setAccepterStr(String accepterStr) {
        this.accepterStr = accepterStr;
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

    private List<CateringWhHcacptBillDtl> hcacptBillDtlList;

    public List<CateringWhHcacptBillDtl> getHcacptBillDtlList() {
        return hcacptBillDtlList;
    }

    public void setHcacptBillDtlList(List<CateringWhHcacptBillDtl> hcacptBillDtlList) {
        this.hcacptBillDtlList = hcacptBillDtlList;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getHcBillId() {
        return hcBillId;
    }

    public void setHcBillId(Integer hcBillId) {
        this.hcBillId = hcBillId;
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

    public String getHcBillCode() {
        return hcBillCode;
    }

    public void setHcBillCode(String hcBillCode) {
        this.hcBillCode = hcBillCode == null ? null : hcBillCode.trim();
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

    public Date getHcTime() {
        return hcTime;
    }

    public void setHcTime(Date hcTime) {
        this.hcTime = hcTime;
    }

    public String getHcBillBarcode() {
        return hcBillBarcode;
    }

    public void setHcBillBarcode(String hcBillBarcode) {
        this.hcBillBarcode = hcBillBarcode == null ? null : hcBillBarcode.trim();
    }

    public String getHcEmpName() {
        return hcEmpName;
    }

    public void setHcEmpName(String hcEmpName) {
        this.hcEmpName = hcEmpName == null ? null : hcEmpName.trim();
    }

    public Integer getInWhId() {
        return inWhId;
    }

    public void setInWhId(Integer inWhId) {
        this.inWhId = inWhId;
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

    public String getHcBillBarImgurl() {
        return hcBillBarImgurl;
    }

    public void setHcBillBarImgurl(String hcBillBarImgurl) {
        this.hcBillBarImgurl = hcBillBarImgurl == null ? null : hcBillBarImgurl.trim();
    }
}
