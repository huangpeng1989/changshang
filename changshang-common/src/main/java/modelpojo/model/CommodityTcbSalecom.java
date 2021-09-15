package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品销售信息表
 */
public class CommodityTcbSalecom implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目Id
    private Long projectId;
    //销售商品id
    private Integer saleComId;
    //商品id
    private Integer comId;
    //商品编号
    private String comCode;
    //销售商品编号
    private String saleComCode;
    //销售商品包装含量
    private Integer packContent;
    //销售商品规格
    private String commSpec;
    //销售商品单位
    private Integer saleCommUnit;
    //商品单位
    private Integer commUnit;
    //销售商品条码
    private String comBarcode;
    //销售商品状态
    private Integer comStatus;
    //是否缺省包装
    private Integer isDefault;
    //商品零售价
    private BigDecimal retailPrice;
    //商品会员价
    private BigDecimal memberPrice;
    //商品积分
    private BigDecimal comIntegral;
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
    private Integer scStatus;
    //同步状态
    private Integer syncStatus;
    //是否采购单位 0否1是
    private Integer isPurChaseUnit;

    public Integer getIsPurChaseUnit() {
        return isPurChaseUnit;
    }

    public void setIsPurChaseUnit(Integer isPurChaseUnit) {
        this.isPurChaseUnit = isPurChaseUnit;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public Integer getPackContent() {
        return packContent;
    }

    public void setPackContent(Integer packContent) {
        this.packContent = packContent;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec == null ? null : commSpec.trim();
    }

    public Integer getSaleCommUnit() {
		return saleCommUnit;
	}

	public void setSaleCommUnit(Integer saleCommUnit) {
		this.saleCommUnit = saleCommUnit;
	}

	public Integer getCommUnit() {
		return commUnit;
	}

	public void setCommUnit(Integer commUnit) {
		this.commUnit = commUnit;
	}

	public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode == null ? null : comBarcode.trim();
    }

    public Integer getComStatus() {
        return comStatus;
    }

    public void setComStatus(Integer comStatus) {
        this.comStatus = comStatus;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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

    public BigDecimal getComIntegral() {
        return comIntegral;
    }

    public void setComIntegral(BigDecimal comIntegral) {
        this.comIntegral = comIntegral;
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

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

}