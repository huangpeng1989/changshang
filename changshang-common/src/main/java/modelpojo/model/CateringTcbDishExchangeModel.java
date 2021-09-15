package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcbDishExchangeModel implements Serializable {
    private Integer dishExchgDishId;

    private String dishExchgDishCode;

    private String dishExchgDishSaleCode;

    private Integer dishExchgDichSpecId;

    private Integer dishExchgCount;

    private BigDecimal packagePrice;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Integer isDelete;

    private Integer exchgStatus;
	
	 private Integer dishExchgId;

    private Integer dishGroupId;

    private Long projectId;

    private int goodType;//11001成品，11004原材料；

    private Boolean whetherUpdate;//是否更新

    private String exchgDishName;//菜品名称

    public String getExchgDishName() {
        return exchgDishName;
    }

    public void setExchgDishName(String exchgDishName) {
        this.exchgDishName = exchgDishName;
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

    public Integer getDishExchgId() {
        return dishExchgId;
    }

    public void setDishExchgId(Integer dishExchgId) {
        this.dishExchgId = dishExchgId;
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

    public Integer getDishExchgDishId() {
        return dishExchgDishId;
    }

    public void setDishExchgDishId(Integer dishExchgDishId) {
        this.dishExchgDishId = dishExchgDishId;
    }

    public String getDishExchgDishCode() {
        return dishExchgDishCode;
    }

    public void setDishExchgDishCode(String dishExchgDishCode) {
        this.dishExchgDishCode = dishExchgDishCode == null ? null : dishExchgDishCode.trim();
    }

    public String getDishExchgDishSaleCode() {
        return dishExchgDishSaleCode;
    }

    public void setDishExchgDishSaleCode(String dishExchgDishSaleCode) {
        this.dishExchgDishSaleCode = dishExchgDishSaleCode == null ? null : dishExchgDishSaleCode.trim();
    }

    public Integer getDishExchgDichSpecId() {
        return dishExchgDichSpecId;
    }

    public void setDishExchgDichSpecId(Integer dishExchgDichSpecId) {
        this.dishExchgDichSpecId = dishExchgDichSpecId;
    }

    public Integer getDishExchgCount() {
        return dishExchgCount;
    }

    public void setDishExchgCount(Integer dishExchgCount) {
        this.dishExchgCount = dishExchgCount;
    }

    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getExchgStatus() {
        return exchgStatus;
    }

    public void setExchgStatus(Integer exchgStatus) {
        this.exchgStatus = exchgStatus;
    }
}