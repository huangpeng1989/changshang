package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhRcptRtnBillDtlModel implements Serializable {
    private Long projectRootId;

    private Integer rmId;

    private String rmCode;

    private Integer srmId;

    private String srmCode;

    private Integer srmUnit;

    private BigDecimal srmPackContent;

    private BigDecimal rcptOutCount;

    private BigDecimal rcptInCount;

    private BigDecimal sRcptOutCount;

    private BigDecimal sRcptInCount;

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

    private String state;

    private String remark;

    private Integer isDelete;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;
	
	private Integer fEntryId;

    private Long projectId;

    private Integer rcptBillId;

    private BigDecimal  whStock;

    private Integer goodType;

    //原材料信息
    private String rmBarcode;

    private String rmName;

    private String rmSpec;

    private String typeName;

    private String dishClassName;

    private String dishClassCode;

    //预估含税成本价格
    private BigDecimal taxcostPrice;

    //预估未税成本价格
    private BigDecimal notaxcostPrice;

    private BigDecimal inTaxCostAmount;//归还含税成本价

    private BigDecimal inNotaxCostAmount;//归还未税成本价

    public BigDecimal getInTaxCostAmount() {
        return inTaxCostAmount;
    }

    public void setInTaxCostAmount(BigDecimal inTaxCostAmount) {
        this.inTaxCostAmount = inTaxCostAmount;
    }

    public BigDecimal getInNotaxCostAmount() {
        return inNotaxCostAmount;
    }

    public void setInNotaxCostAmount(BigDecimal inNotaxCostAmount) {
        this.inNotaxCostAmount = inNotaxCostAmount;
    }

    public BigDecimal getTaxcostPrice() {
        return taxcostPrice;
    }

    public void setTaxcostPrice(BigDecimal taxcostPrice) {
        this.taxcostPrice = taxcostPrice;
    }

    public BigDecimal getNotaxcostPrice() {
        return notaxcostPrice;
    }

    public void setNotaxcostPrice(BigDecimal notaxcostPrice) {
        this.notaxcostPrice = notaxcostPrice;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRcptBillId() {
        return rcptBillId;
    }

    public void setRcptBillId(Integer rcptBillId) {
        this.rcptBillId = rcptBillId;
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

    public BigDecimal getSrmPackContent() {
        return srmPackContent;
    }

    public void setSrmPackContent(BigDecimal srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    public BigDecimal getRcptOutCount() {
        return rcptOutCount;
    }

    public void setRcptOutCount(BigDecimal rcptOutCount) {
        this.rcptOutCount = rcptOutCount;
    }

    public BigDecimal getRcptInCount() {
        return rcptInCount;
    }

    public void setRcptInCount(BigDecimal rcptInCount) {
        this.rcptInCount = rcptInCount;
    }

    public BigDecimal getsRcptOutCount() {
        return sRcptOutCount;
    }

    public void setsRcptOutCount(BigDecimal sRcptOutCount) {
        this.sRcptOutCount = sRcptOutCount;
    }

    public BigDecimal getsRcptInCount() {
        return sRcptInCount;
    }

    public void setsRcptInCount(BigDecimal sRcptInCount) {
        this.sRcptInCount = sRcptInCount;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}