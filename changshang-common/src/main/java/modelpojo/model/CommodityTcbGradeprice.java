package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品价格配置信息
 */
public class CommodityTcbGradeprice implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目ID
    private Long projectId;
    //价格配置主键id
    private Integer gpId;
    //商品价格等级ID
    private Integer gradeId;
    //销售商品ID
    private Integer saleComId;

    //商品ID
    private Integer comId;
    //商品零售价
    private BigDecimal retailPrice;
    //商品会员价
    private BigDecimal memberPrice;
    //商品积分
    private Integer commodityIntegral;
    //最低销售价格
    private BigDecimal minSalePrice;
    //最高销售价格
    private BigDecimal maxSalePrice;
    //批发价
    private BigDecimal tradePrice;
    //配送价
    private BigDecimal deliveryPrice;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //状态
    private Integer cStatus;
    
    private Integer syncStatus;

    //历史商品零售价
    private BigDecimal oldRetailPrice;

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getcStatus() {
		return cStatus;
	}

	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	public Integer getGpId() {
		return gpId;
	}

	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}

	public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getCommodityIntegral() {
        return commodityIntegral;
    }

    public void setCommodityIntegral(Integer commodityIntegral) {
        this.commodityIntegral = commodityIntegral;
    }

    public BigDecimal getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(BigDecimal minSalePrice) {
        this.minSalePrice = minSalePrice;
    }

    public BigDecimal getMaxSalePrice() {
        return maxSalePrice;
    }

    public void setMaxSalePrice(BigDecimal maxSalePrice) {
        this.maxSalePrice = maxSalePrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
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

    public Integer getGPStatus() {
        return cStatus;
    }

    public void setGPStatus(Integer GPStatus) {
        this.cStatus = GPStatus;
    }

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

}