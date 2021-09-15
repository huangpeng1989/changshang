package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 进价调价子表
 */
public class CommodityTcjAdjustDetail implements Serializable {
    private static final long serialVersionUID = -1612038444523302383L;
    //项目Id
    private Long projectId;
    //调价单id
    private Integer adjId;

    public Integer getSupComId() {
        return supComId;
    }

    @Override
    public String toString() {
        return "CommodityTcjAdjustDetail{" +
                "projectId=" + projectId +
                ", adjId=" + adjId +
                ", supComId=" + supComId +
                ", addId=" + addId +
                ", supplierId=" + supplierId +
                ", protoId=" + protoId +
                ", comId=" + comId +
                ", adjCode='" + adjCode + '\'' +
                ", suppCode='" + suppCode + '\'' +
                ", busMode=" + busMode +
                ", oGroMargin=" + oGroMargin +
                ", newGroMargin=" + newGroMargin +
                ", taxValue=" + taxValue +
                ", taxId=" + taxId +
                ", oTaxPriceIn=" + oTaxPriceIn +
                ", oUntaxPriceIn=" + oUnTaxPriceIn +
                ", newTaxPriceIn=" + newTaxPriceIn +
                ", newUntaxPriceIn=" + newUnTaxPriceIn +
                ", remark='" + remark + '\'' +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", creater=" + creater +
                ", updatedTime=" + updatedTime +
                ", modifier=" + modifier +
                ", status=" + status +
                ", maxRetailPrice=" + maxRetailPrice +
                ", minRetailPrice=" + minRetailPrice +
                ", maxGrossInterestRate='" + maxGrossInterestRate + '\'' +
                ", minGrossInterestRate='" + minGrossInterestRate + '\'' +
                '}';
    }

    public void setSupComId(Integer supComId) {
        this.supComId = supComId;
    }

    private Integer supComId;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    private Integer addId;
    //供应商id
    private Integer supplierId;
    //协议id
    private Integer protoId;
    //商品id
    private Integer comId;
    //调价单号
    private String adjCode;
    //供应商编号
    private String suppCode;
    //经营方式
    private Integer busMode;
    //原毛利率
    private BigDecimal oGroMargin;
    //新毛利率
    private BigDecimal newGroMargin;
    //税率
    private String taxValue;

    private BigDecimal oPurchaseTaxPaid;//原采购含税进价

    private BigDecimal oPurchaseNoTaxPaid;//原采购未税进价

    private BigDecimal newPurchaseTaxPaid;//新采购含税进价

    private BigDecimal newPurchaseNoTaxPaid;//新采购未税进价


    public BigDecimal getoPurchaseTaxPaid() {
        return oPurchaseTaxPaid;
    }

    public void setoPurchaseTaxPaid(BigDecimal oPurchaseTaxPaid) {
        this.oPurchaseTaxPaid = oPurchaseTaxPaid;
    }

    public BigDecimal getoPurchaseNoTaxPaid() {
        return oPurchaseNoTaxPaid;
    }

    public void setoPurchaseNoTaxPaid(BigDecimal oPurchaseNoTaxPaid) {
        this.oPurchaseNoTaxPaid = oPurchaseNoTaxPaid;
    }

    public BigDecimal getNewPurchaseTaxPaid() {
        return newPurchaseTaxPaid;
    }

    public void setNewPurchaseTaxPaid(BigDecimal newPurchaseTaxPaid) {
        this.newPurchaseTaxPaid = newPurchaseTaxPaid;
    }

    public BigDecimal getNewPurchaseNoTaxPaid() {
        return newPurchaseNoTaxPaid;
    }

    public void setNewPurchaseNoTaxPaid(BigDecimal newPurchaseNoTaxPaid) {
        this.newPurchaseNoTaxPaid = newPurchaseNoTaxPaid;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    private String taxName;   //税率名称
    //税率id
    private Integer taxId;
    //原含税进价
    private BigDecimal oTaxPriceIn;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    private String suppName;

    private String comName;

    private String busModeName;
    private String comCode;
    private String phTax;
    private Integer phTaxId;
    public String getBusModeName() {
        return busModeName;
    }

    public void setBusModeName(String busModeName) {
        this.busModeName = busModeName;
    }



    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }



    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }



    public BigDecimal getoUnTaxPriceIn() {
        return oUnTaxPriceIn;
    }

    public void setOUnTaxPriceIn(BigDecimal oUnTaxPriceIn) {
        this.oUnTaxPriceIn = oUnTaxPriceIn;
    }

    //原未税进价
    private BigDecimal oUnTaxPriceIn;
    //新含税进价
    private BigDecimal newTaxPriceIn;
    //新未税进价
    private BigDecimal newUnTaxPriceIn;
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
    private Integer status;

    // 最高价格
    private BigDecimal maxRetailPrice;
    // 最低价格
    private BigDecimal minRetailPrice;

    public String getMaxGrossInterestRate() {
        return maxGrossInterestRate;
    }

    public void setMaxGrossInterestRate(String maxGrossInterestRate) {
        this.maxGrossInterestRate = maxGrossInterestRate;
    }

    public String getMinGrossInterestRate() {
        return minGrossInterestRate;
    }

    public void setMinGrossInterestRate(String minGrossInterestRate) {
        this.minGrossInterestRate = minGrossInterestRate;
    }

    // 最高价格毛利率
    private String maxGrossInterestRate;
    // 最低价格毛利率
    private String minGrossInterestRate;

    public String getNewMaxGrossInterestRate() {
        return newMaxGrossInterestRate;
    }

    public void setNewMaxGrossInterestRate(String newMaxGrossInterestRate) {
        this.newMaxGrossInterestRate = newMaxGrossInterestRate;
    }

    public String getNewMinGrossInterestRate() {
        return newMinGrossInterestRate;
    }

    public void setNewMinGrossInterestRate(String newMinGrossInterestRate) {
        this.newMinGrossInterestRate = newMinGrossInterestRate;
    }

    // 新最高毛利率
    private String newMaxGrossInterestRate;
    // 新最低毛利率
    private String newMinGrossInterestRate;

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;
    public BigDecimal getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(BigDecimal maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public BigDecimal getMinRetailPrice() {
        return minRetailPrice;
    }

    public void setMinRetailPrice(BigDecimal minRetailPrice) {
        this.minRetailPrice = minRetailPrice;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProtoId() {
        return protoId;
    }

    public void setProtoId(Integer protoId) {
        this.protoId = protoId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode == null ? null : adjCode.trim();
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public Integer getBusMode() {
        return busMode;
    }

    public void setBusMode(Integer busMode) {
        this.busMode = busMode;
    }

    public BigDecimal getOGroMargin() {
        return oGroMargin;
    }

    public void setOGroMargin(BigDecimal OGroMargin) {
        this.oGroMargin = OGroMargin;
    }

    public BigDecimal getNewGroMargin() {
        return newGroMargin;
    }

    public void setNewGroMargin(BigDecimal newGroMargin) {
        this.newGroMargin = newGroMargin;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getOTaxPriceIn() {
        return oTaxPriceIn;
    }

    public void setOTaxPriceIn(BigDecimal OTaxPriceIn) {
        this.oTaxPriceIn = OTaxPriceIn;
    }




    public BigDecimal getNewTaxPriceIn() {
        return newTaxPriceIn;
    }

    public void setNewTaxPriceIn(BigDecimal newTaxPriceIn) {
        this.newTaxPriceIn = newTaxPriceIn;
    }

    public BigDecimal getNewUnTaxPriceIn() {
        return newUnTaxPriceIn;
    }

    public void setNewUnTaxPriceIn(BigDecimal newUnTaxPriceIn) {
        this.newUnTaxPriceIn = newUnTaxPriceIn;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
