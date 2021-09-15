package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcbDishesModel implements Serializable {
    private Long projectRootId;

    private String dishCode;

    private String dishName;

    private String dishAbbreviate;

    private String spellCode;

    private String dishClassCode;

    private Integer dishType;

    private Integer dishUnit;

    private BigDecimal retailPrice;

    private BigDecimal costPrice;

    private BigDecimal slTax;

    private Integer slTaxId;

    private Byte weighComWay;

    private Integer sellStatus;

    private Byte sellOut;

    private BigDecimal packCost;

    private Byte isHot;

    private BigDecimal minPetailPrice;

    private Integer transportType;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Long blEmpId;

    private Date blTime;

    private Date updatedTime;

    private Long modifier;

    private Integer cStatus;

    private Integer isDelete;
	
    private Integer dishId;

    private Long projectId;

    private Integer specId;//规格id

    private int syncStatus;

    private String dishBarcode;//半成品条码

    private Integer sellModel;

    private BigDecimal discountRate;

    private int suppId;

    private String suppCode;

    private Boolean whetherUpdate;//是否更新

    private String dishUnitName;//单位中文名称

    private String dishClassName;//菜品分类中文名称

    private String barCode;//条码20201020新增

    private String contractCode;//合同ID

    private String contractName;//合同名称

    private BigDecimal standardCostRate;//标准成本金额百分比


    public BigDecimal getStandardCostRate() {
        return standardCostRate;
    }

    public void setStandardCostRate(BigDecimal standardCostRate) {
        this.standardCostRate = standardCostRate;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }


    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public Boolean getWhetherUpdate() {
        return whetherUpdate;
    }

    public void setWhetherUpdate(Boolean whetherUpdate) {
        this.whetherUpdate = whetherUpdate;
    }

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public int getSuppId() {
        return suppId;
    }

    public void setSuppId(int suppId) {
        this.suppId = suppId;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getDishBarcode() {
        return dishBarcode;
    }

    public void setDishBarcode(String dishBarcode) {
        this.dishBarcode = dishBarcode;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName == null ? null : dishName.trim();
    }

    public String getDishAbbreviate() {
        return dishAbbreviate;
    }

    public void setDishAbbreviate(String dishAbbreviate) {
        this.dishAbbreviate = dishAbbreviate == null ? null : dishAbbreviate.trim();
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode == null ? null : spellCode.trim();
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode == null ? null : dishClassCode.trim();
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSlTax() {
        return slTax;
    }

    public void setSlTax(BigDecimal slTax) {
        this.slTax = slTax;
    }

    public Integer getSlTaxId() {
        return slTaxId;
    }

    public void setSlTaxId(Integer slTaxId) {
        this.slTaxId = slTaxId;
    }

    public Byte getWeighComWay() {
        return weighComWay;
    }

    public void setWeighComWay(Byte weighComWay) {
        this.weighComWay = weighComWay;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Byte getSellOut() {
        return sellOut;
    }

    public void setSellOut(Byte sellOut) {
        this.sellOut = sellOut;
    }

    public BigDecimal getPackCost() {
        return packCost;
    }

    public void setPackCost(BigDecimal packCost) {
        this.packCost = packCost;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public BigDecimal getMinPetailPrice() {
        return minPetailPrice;
    }

    public void setMinPetailPrice(BigDecimal minPetailPrice) {
        this.minPetailPrice = minPetailPrice;
    }

    public Integer getTransportType() {
        return transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}