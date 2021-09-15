package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CateringTcbDishGroupModel implements Serializable {
    private Integer packDishId;

    private Integer dishSpecId;

    private String dishSaleCode;

    private String dishCode;

    private Integer dishId;

    private Integer dishGroupCount;

    private BigDecimal originalPrice;

    private BigDecimal packagePrice;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;
	
	private Integer dishGroupId;

    private Long projectId;

    private int goodType;//11001成品，11004原材料；

    private Boolean whetherUpdate;//是否更新

    private String dishName;//菜品中文名称

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Boolean getWhetherUpdate() {
        return whetherUpdate;
    }

    public void setWhetherUpdate(Boolean whetherUpdate) {
        this.whetherUpdate = whetherUpdate;
    }

    public int getGoodType() {
        return goodType;
    }

    public void setGoodType(int goodType) {
        this.goodType = goodType;
    }

    private List<CateringTcbDishExchangeModel> dishExchangeModels;

    public List<CateringTcbDishExchangeModel> getDishExchangeModels() {
        return dishExchangeModels;
    }

    public void setDishExchangeModels(List<CateringTcbDishExchangeModel> dishExchangeModels) {
        this.dishExchangeModels = dishExchangeModels;
    }

    public Integer getDishGroupId() {
        return dishGroupId;
    }

    public void setDishGroupId(Integer dishGroupId) {
        this.dishGroupId = dishGroupId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getPackDishId() {
        return packDishId;
    }

    public void setPackDishId(Integer packDishId) {
        this.packDishId = packDishId;
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public String getDishSaleCode() {
        return dishSaleCode;
    }

    public void setDishSaleCode(String dishSaleCode) {
        this.dishSaleCode = dishSaleCode == null ? null : dishSaleCode.trim();
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDishGroupCount() {
        return dishGroupCount;
    }

    public void setDishGroupCount(Integer dishGroupCount) {
        this.dishGroupCount = dishGroupCount;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
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
}