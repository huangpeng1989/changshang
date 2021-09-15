package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringWhTransferOrder implements Serializable {
    private static final long serialVersionUID = 8426285275443572888L;
    private Long projectRootId;

    private String toBillCode;

    private Long projectId;

    private Integer toBillId;

    private Date toDate;

    private Long toEmpId;

    private Integer whId;

    private String remark;

    private String billBarcode;

    private String billBarcodeUrl;

    private String state;

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

    List<CateringWhTransferOrderDtl> transferOrderDtlList;
    List<CateringWhTransferOrderDtlVo> transferOrderDtlVoList;

    public List<CateringWhTransferOrderDtlVo> getTransferOrderDtlVoList() {
        return transferOrderDtlVoList;
    }

    public void setTransferOrderDtlVoList(List<CateringWhTransferOrderDtlVo> transferOrderDtlVoList) {
        this.transferOrderDtlVoList = transferOrderDtlVoList;
    }

    public List<CateringWhTransferOrderDtl> getTransferOrderDtlList() {
        return transferOrderDtlList;
    }

    public void setTransferOrderDtlList(List<CateringWhTransferOrderDtl> transferOrderDtlList) {
        this.transferOrderDtlList = transferOrderDtlList;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getToBillId() {
        return toBillId;
    }

    public void setToBillId(Integer toBillId) {
        this.toBillId = toBillId;
    }
    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getToBillCode() {
        return toBillCode;
    }

    public void setToBillCode(String toBillCode) {
        this.toBillCode = toBillCode == null ? null : toBillCode.trim();
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getToEmpId() {
        return toEmpId;
    }

    public void setToEmpId(Long toEmpId) {
        this.toEmpId = toEmpId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode == null ? null : billBarcode.trim();
    }

    public String getBillBarcodeUrl() {
        return billBarcodeUrl;
    }

    public void setBillBarcodeUrl(String billBarcodeUrl) {
        this.billBarcodeUrl = billBarcodeUrl == null ? null : billBarcodeUrl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
