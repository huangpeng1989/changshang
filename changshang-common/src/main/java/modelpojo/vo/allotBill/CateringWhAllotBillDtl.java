package modelpojo.vo.allotBill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhAllotBillDtl implements Serializable {
    private Long projectRootId;

    private Integer rmId;

    private String rmCode;

    private String rmSpec;

    private Integer rmUnit;

    private BigDecimal allotOutCount;

    private BigDecimal allotInCount;

    private Integer srmId;

    private String srmCode;

    private Integer srmUnit;

    private BigDecimal sAllotOutCount;

    private BigDecimal sAllotInCount;

    private Integer sSrmId;

    private String sSrmCode;

    private Integer sSrmUnit;

    private BigDecimal bchTaxCost;

    private BigDecimal bchNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer batchId;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer status;

    private Byte isDelete;

    private String remark;

    private String state;

    private Integer syncStatus;


    private Long projectId;

    private Integer allotBillId;

    private Integer fEntryId;

    private Integer goodType;

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAllotBillId() {
        return allotBillId;
    }

    public void setAllotBillId(Integer allotBillId) {
        this.allotBillId = allotBillId;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec == null ? null : rmSpec.trim();
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public BigDecimal getAllotOutCount() {
        return allotOutCount;
    }

    public void setAllotOutCount(BigDecimal allotOutCount) {
        this.allotOutCount = allotOutCount;
    }

    public BigDecimal getAllotInCount() {
        return allotInCount;
    }

    public void setAllotInCount(BigDecimal allotInCount) {
        this.allotInCount = allotInCount;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode == null ? null : srmCode.trim();
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public BigDecimal getsAllotOutCount() {
        return sAllotOutCount;
    }

    public void setsAllotOutCount(BigDecimal sAllotOutCount) {
        this.sAllotOutCount = sAllotOutCount;
    }

    public BigDecimal getsAllotInCount() {
        return sAllotInCount;
    }

    public void setsAllotInCount(BigDecimal sAllotInCount) {
        this.sAllotInCount = sAllotInCount;
    }

    public Integer getsSrmId() {
        return sSrmId;
    }

    public void setsSrmId(Integer sSrmId) {
        this.sSrmId = sSrmId;
    }

    public String getsSrmCode() {
        return sSrmCode;
    }

    public void setsSrmCode(String sSrmCode) {
        this.sSrmCode = sSrmCode == null ? null : sSrmCode.trim();
    }

    public Integer getsSrmUnit() {
        return sSrmUnit;
    }

    public void setsSrmUnit(Integer sSrmUnit) {
        this.sSrmUnit = sSrmUnit;
    }

    public BigDecimal getBchTaxCost() {
        return bchTaxCost;
    }

    public void setBchTaxCost(BigDecimal bchTaxCost) {
        this.bchTaxCost = bchTaxCost;
    }

    public BigDecimal getBchNotaxCost() {
        return bchNotaxCost;
    }

    public void setBchNotaxCost(BigDecimal bchNotaxCost) {
        this.bchNotaxCost = bchNotaxCost;
    }

    public BigDecimal getAvgTaxCost() {
        return avgTaxCost;
    }

    public void setAvgTaxCost(BigDecimal avgTaxCost) {
        this.avgTaxCost = avgTaxCost;
    }

    public BigDecimal getAvgNotaxCost() {
        return avgNotaxCost;
    }

    public void setAvgNotaxCost(BigDecimal avgNotaxCost) {
        this.avgNotaxCost = avgNotaxCost;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}