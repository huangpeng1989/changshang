package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcjSaleadjustDetailModel implements Serializable {
    private String adjCode;

    private Integer rmDishId;

    private String rmDishCode;

    private Integer goodsType;

    private Integer saleRmId;

    private BigDecimal packContent;

    private String comBarcode;

    private String dishSpecId;

    private Byte isDishPageage;

    private BigDecimal retailPrice;

    private BigDecimal newRetailPrice;

    private BigDecimal oGroMargin;

    private BigDecimal newGroMargin;

    private BigDecimal newMinSalePrice;

    private BigDecimal newMaxSalePrice;

    private BigDecimal newTradePrice;

    private BigDecimal newDeliveryPrice;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private int isDelete;

    private Integer status;

    private Integer syncStatus;
	
	private Integer adjId;

    private Long projectId;

    private Integer sadId;

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSadId() {
        return sadId;
    }

    public void setSadId(Integer sadId) {
        this.sadId = sadId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode == null ? null : adjCode.trim();
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public String getRmDishCode() {
        return rmDishCode;
    }

    public void setRmDishCode(String rmDishCode) {
        this.rmDishCode = rmDishCode == null ? null : rmDishCode.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getSaleRmId() {
        return saleRmId;
    }

    public void setSaleRmId(Integer saleRmId) {
        this.saleRmId = saleRmId;
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode == null ? null : comBarcode.trim();
    }

    public String getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(String dishSpecId) {
        this.dishSpecId = dishSpecId == null ? null : dishSpecId.trim();
    }

    public Byte getIsDishPageage() {
        return isDishPageage;
    }

    public void setIsDishPageage(Byte isDishPageage) {
        this.isDishPageage = isDishPageage;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getNewRetailPrice() {
        return newRetailPrice;
    }

    public void setNewRetailPrice(BigDecimal newRetailPrice) {
        this.newRetailPrice = newRetailPrice;
    }

    public BigDecimal getoGroMargin() {
        return oGroMargin;
    }

    public void setoGroMargin(BigDecimal oGroMargin) {
        this.oGroMargin = oGroMargin;
    }

    public BigDecimal getNewGroMargin() {
        return newGroMargin;
    }

    public void setNewGroMargin(BigDecimal newGroMargin) {
        this.newGroMargin = newGroMargin;
    }

    public BigDecimal getNewMinSalePrice() {
        return newMinSalePrice;
    }

    public void setNewMinSalePrice(BigDecimal newMinSalePrice) {
        this.newMinSalePrice = newMinSalePrice;
    }

    public BigDecimal getNewMaxSalePrice() {
        return newMaxSalePrice;
    }

    public void setNewMaxSalePrice(BigDecimal newMaxSalePrice) {
        this.newMaxSalePrice = newMaxSalePrice;
    }

    public BigDecimal getNewTradePrice() {
        return newTradePrice;
    }

    public void setNewTradePrice(BigDecimal newTradePrice) {
        this.newTradePrice = newTradePrice;
    }

    public BigDecimal getNewDeliveryPrice() {
        return newDeliveryPrice;
    }

    public void setNewDeliveryPrice(BigDecimal newDeliveryPrice) {
        this.newDeliveryPrice = newDeliveryPrice;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}