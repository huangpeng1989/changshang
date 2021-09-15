package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhTransferOrderDtl implements Serializable {
    private static final long serialVersionUID = 8353754029368777100L;
    private Long projectRootId;

     private Integer fEntryId;

    private Integer oRmId;

    private Long projectId;

    private Integer toBillId;


    private String toBillCode;

    private String oRmCode;

    private BigDecimal oTaxCost;

    private BigDecimal oNotaxCost;

    private BigDecimal oTaxCostAmount;

    private BigDecimal oNotaxCostAmount;

    private Integer nRmId;

    private String nRmCode;

    private BigDecimal nTaxCost;

    private BigDecimal nNotaxCost;

    private BigDecimal nTaxCostAmount;

    private BigDecimal nNotaxCostAmount;

    private Byte transferType;

    private Integer batchId;

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
    private BigDecimal toBillCount;

    public BigDecimal getToBillCount() {
        return toBillCount;
    }

    public void setToBillCount(BigDecimal toBillCount) {
        this.toBillCount = toBillCount;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getoRmId() {
        return oRmId;
    }

    public void setoRmId(Integer oRmId) {
        this.oRmId = oRmId;
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

    public String getoRmCode() {
        return oRmCode;
    }

    public void setoRmCode(String oRmCode) {
        this.oRmCode = oRmCode == null ? null : oRmCode.trim();
    }

    public BigDecimal getoTaxCost() {
        return oTaxCost;
    }

    public void setoTaxCost(BigDecimal oTaxCost) {
        this.oTaxCost = oTaxCost;
    }

    public BigDecimal getoNotaxCost() {
        return oNotaxCost;
    }

    public void setoNotaxCost(BigDecimal oNotaxCost) {
        this.oNotaxCost = oNotaxCost;
    }

    public BigDecimal getoTaxCostAmount() {
        return oTaxCostAmount;
    }

    public void setoTaxCostAmount(BigDecimal oTaxCostAmount) {
        this.oTaxCostAmount = oTaxCostAmount;
    }

    public BigDecimal getoNotaxCostAmount() {
        return oNotaxCostAmount;
    }

    public void setoNotaxCostAmount(BigDecimal oNotaxCostAmount) {
        this.oNotaxCostAmount = oNotaxCostAmount;
    }

    public Integer getnRmId() {
        return nRmId;
    }

    public void setnRmId(Integer nRmId) {
        this.nRmId = nRmId;
    }

    public String getnRmCode() {
        return nRmCode;
    }

    public void setnRmCode(String nRmCode) {
        this.nRmCode = nRmCode == null ? null : nRmCode.trim();
    }

    public BigDecimal getnTaxCost() {
        return nTaxCost;
    }

    public void setnTaxCost(BigDecimal nTaxCost) {
        this.nTaxCost = nTaxCost;
    }

    public BigDecimal getnNotaxCost() {
        return nNotaxCost;
    }

    public void setnNotaxCost(BigDecimal nNotaxCost) {
        this.nNotaxCost = nNotaxCost;
    }

    public BigDecimal getnTaxCostAmount() {
        return nTaxCostAmount;
    }

    public void setnTaxCostAmount(BigDecimal nTaxCostAmount) {
        this.nTaxCostAmount = nTaxCostAmount;
    }

    public BigDecimal getnNotaxCostAmount() {
        return nNotaxCostAmount;
    }

    public void setnNotaxCostAmount(BigDecimal nNotaxCostAmount) {
        this.nNotaxCostAmount = nNotaxCostAmount;
    }

    public Byte getTransferType() {
        return transferType;
    }

    public void setTransferType(Byte transferType) {
        this.transferType = transferType;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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
