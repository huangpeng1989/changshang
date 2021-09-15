package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 售价调价子表
 */
public class CommodityTcjSaleadjustdetail implements Serializable {
    //状态
    private Long projectId;

    //调价单明细id
    private Integer sadId;
    //调价单id
    private Integer adjId;
    //销售商品id
    private Integer saleComId;
    //调价单号
    private String adjCode;
    //商品id
    private Integer comId;
    //供应商编号
    private String suppCode;
    //供应商名称
    private String suppName;
    //经销方式
    private Integer busModel;
    //供应商id
    private Integer suppId;
    //商品编号
    private String comCode;
    //价格等级
    private Integer gradeId;
    //商品包装含量
    private Integer packContent;


    //原毛利率
    private BigDecimal oGroMargin;
    //新毛利率
    private BigDecimal newGroMargin;
    //商品规格单位
    private String specUnit;
    //商品条码
    private String comBarcode;
    //商品零售价旧
    private BigDecimal retailPrice;
    //商品会员价旧
    private BigDecimal memberPrice;
    //商品积分
    private BigDecimal comIntegral;
    //最低销售价格
    private BigDecimal minSalePrice;
    //最高销售价格
    private BigDecimal maxSalePrice;

    private String busModelName;


    //批发价
    private BigDecimal tradePrice;
    //配送价
    private BigDecimal deliveryPrice;
    //商品零售价新
    private BigDecimal newRetailPrice;
    //商品会员价新
    private BigDecimal newMemberPrice;
    //商品积分新
    private BigDecimal newComIntegral;
    //最低销售价格新
    private BigDecimal newMinSalePrice;
    //最高销售价格新
    private BigDecimal newMaxSalePrice;
    //批发价新
    private BigDecimal newTradePrice;
    //配送价新
    private BigDecimal newDeliveryPrice;
    //备注
    private String remark;
    //说明
    private String description;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    private String comName;
    private String gradeName;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getBusModelName() {
        return busModelName;
    }

    public void setBusModelName(String busModelName) {
        this.busModelName = busModelName;
    }
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //状态
    private Integer status;
    //含税进价
    private BigDecimal taxPaid;

    //未含税进价
    private BigDecimal noTaxPaid;

    //价格配置表id
    private Integer gpId;



    private Integer isDelete;


    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public BigDecimal getoGroMargin() {
        return oGroMargin;
    }

    public void setoGroMargin(BigDecimal oGroMargin) {
        this.oGroMargin = oGroMargin;
    }


    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }


    public Integer getSadId() {
        return sadId;
    }

    public void setSadId(Integer sadId) {
        this.sadId = sadId;
    }
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode == null ? null : adjCode.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName == null ? null : suppName.trim();
    }

    public Integer getBusModel() {
        return busModel;
    }

    public void setBusModel(Integer busModel) {
        this.busModel = busModel;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getPackContent() {
        return packContent;
    }

    public void setPackContent(Integer packContent) {
        this.packContent = packContent;
    }



    public BigDecimal getNewGroMargin() {
        return newGroMargin;
    }

    public void setNewGroMargin(BigDecimal newGroMargin) {
        this.newGroMargin = newGroMargin;
    }

    public String getSpecUnit() {
        return specUnit;
    }

    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit == null ? null : specUnit.trim();
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode == null ? null : comBarcode.trim();
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

    public BigDecimal getNewRetailPrice() {
        return newRetailPrice;
    }

    public void setNewRetailPrice(BigDecimal newRetailPrice) {
        this.newRetailPrice = newRetailPrice;
    }

    public BigDecimal getNewMemberPrice() {
        return newMemberPrice;
    }

    public void setNewMemberPrice(BigDecimal newMemberPrice) {
        this.newMemberPrice = newMemberPrice;
    }

    public BigDecimal getNewComIntegral() {
        return newComIntegral;
    }

    public void setNewComIntegral(BigDecimal newComIntegral) {
        this.newComIntegral = newComIntegral;
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

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updatedTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updatedTime = updateTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}