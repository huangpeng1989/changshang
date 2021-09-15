package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcbDishes  implements Serializable {
    private Integer projectRootid;

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

    private Byte isDelete;

	private Integer dishId;

    private Integer projectId;

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectRootid() {
        return projectRootid;
    }

    public void setProjectRootid(Integer projectRootid) {
        this.projectRootid = projectRootid;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}