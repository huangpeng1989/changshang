package modelpojo.vo.semiBill;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CateringRedSemiPdtBill implements Serializable {
    private Long projectRootId;

    private Long projectId;

    private Integer spdtBillId;

    private String spdtBillCode;

    private Integer whId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date redDate;

    private String remark;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date blTime;

    private Byte isDelete;

    private Integer status;

    private String billBarcode;

    private int paymentdaysId;

    private Date paymentdaysDate;

    private String redDashedCode;//半成品加工红冲单单号

    public String getRedDashedCode() {
        return redDashedCode;
    }

    public void setRedDashedCode(String redDashedCode) {
        this.redDashedCode = redDashedCode;
    }

    public int getPaymentdaysId() {
        return paymentdaysId;
    }

    public void setPaymentdaysId(int paymentdaysId) {
        this.paymentdaysId = paymentdaysId;
    }

    public Date getPaymentdaysDate() {
        return paymentdaysDate;
    }

    public void setPaymentdaysDate(Date paymentdaysDate) {
        this.paymentdaysDate = paymentdaysDate;
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

    public Integer getSpdtBillId() {
        return spdtBillId;
    }

    public void setSpdtBillId(Integer spdtBillId) {
        this.spdtBillId = spdtBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getSpdtBillCode() {
        return spdtBillCode;
    }

    public void setSpdtBillCode(String spdtBillCode) {
        this.spdtBillCode = spdtBillCode == null ? null : spdtBillCode.trim();
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Date getRedDate() {
        return redDate;
    }

    public void setRedDate(Date redDate) {
        this.redDate = redDate;
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
}