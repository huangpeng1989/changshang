package modelpojo.model.DishRequirements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CateringNewAplBill implements Serializable {

    private Long projectId;

    private Integer aplBillId;

    private String aplBillIds;

    private Long projectRootId;

    private String aplBillCode;

    private Integer gzoneId;

    private Integer aplWhId;

    private Long comEmpId;

    private Integer whId;

    private Date aplDate;

    private Long dealEmpId;

    private Date dealDate;

    private String rejectResion;

    private String remark;

    private Integer aplStatus;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Integer syncStatus;

    private Long blEmpId;

    private Date blTime;

    private Byte isDelete;

    private Integer status;

    private String comEmpName;

    private Integer billSource;

    private Integer paymentDaysId;

    private String paymentName;

    private Date paymentData;

    private String allotCode;

    private Integer oppositeIsTrue;

    private List<CateringNewAplBillDtl> list = new ArrayList<>();

    public String getAplBillIds() {
        return aplBillIds;
    }

    public void setAplBillIds(String aplBillIds) {
        this.aplBillIds = aplBillIds;
    }

    public List<CateringNewAplBillDtl> getList() {
        return list;
    }

    public void setList(List<CateringNewAplBillDtl> list) {
        this.list = list;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAplBillId() {
        return aplBillId;
    }

    public void setAplBillId(Integer aplBillId) {
        this.aplBillId = aplBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getAplBillCode() {
        return aplBillCode;
    }

    public void setAplBillCode(String aplBillCode) {
        this.aplBillCode = aplBillCode;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getAplWhId() {
        return aplWhId;
    }

    public void setAplWhId(Integer aplWhId) {
        this.aplWhId = aplWhId;
    }

    public Long getComEmpId() {
        return comEmpId;
    }

    public void setComEmpId(Long comEmpId) {
        this.comEmpId = comEmpId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Date getAplDate() {
        return aplDate;
    }

    public void setAplDate(Date aplDate) {
        this.aplDate = aplDate;
    }

    public Long getDealEmpId() {
        return dealEmpId;
    }

    public void setDealEmpId(Long dealEmpId) {
        this.dealEmpId = dealEmpId;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getRejectResion() {
        return rejectResion;
    }

    public void setRejectResion(String rejectResion) {
        this.rejectResion = rejectResion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAplStatus() {
        return aplStatus;
    }

    public void setAplStatus(Integer aplStatus) {
        this.aplStatus = aplStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComEmpName() {
        return comEmpName;
    }

    public void setComEmpName(String comEmpName) {
        this.comEmpName = comEmpName;
    }

    public Integer getBillSource() {
        return billSource;
    }

    public void setBillSource(Integer billSource) {
        this.billSource = billSource;
    }

    public Integer getPaymentDaysId() {
        return paymentDaysId;
    }

    public void setPaymentDaysId(Integer paymentDaysId) {
        this.paymentDaysId = paymentDaysId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Date getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(Date paymentData) {
        this.paymentData = paymentData;
    }

    public String getAllotCode() {
        return allotCode;
    }

    public void setAllotCode(String allotCode) {
        this.allotCode = allotCode;
    }

    public Integer getOppositeIsTrue() {
        return oppositeIsTrue;
    }

    public void setOppositeIsTrue(Integer oppositeIsTrue) {
        this.oppositeIsTrue = oppositeIsTrue;
    }
}