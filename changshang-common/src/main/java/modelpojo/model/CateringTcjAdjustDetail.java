package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcjAdjustDetail implements Serializable {

    private static final long serialVersionUID = -2647087854502135677L;
    private Integer addId;

    private Long projectId;
    private Integer supComId;

    private Integer adjId;

    private String adjCode;

    private String suppCode;

    private Integer supplierId;

    private Integer protoId;

    private Integer rmId;

    private Integer goodType;

    private Integer busMode;

    private BigDecimal oGroMargin;

    private BigDecimal newGroMargin;

    private String taxValue;

    private Integer taxId;

    private BigDecimal oTaxPriceIn;

    private BigDecimal oUntaxPriceIn;

    private BigDecimal newTaxPriceIn;

    private BigDecimal newUntaxPriceIn;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Integer status;

    private Byte isDelete;

    private Integer syncStatus;


    private String suppName;
    private String rmName;
    private String taxName;

    private BigDecimal conToFreeTax;//含税转未税比率
    private BigDecimal freeToConTax;//未税转未税比率

    private String rmCode;

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

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public BigDecimal getConToFreeTax() {
        return conToFreeTax;
    }

    public void setConToFreeTax(BigDecimal conToFreeTax) {
        this.conToFreeTax = conToFreeTax;
    }

    public BigDecimal getFreeToConTax() {
        return freeToConTax;
    }

    public void setFreeToConTax(BigDecimal freeToConTax) {
        this.freeToConTax = freeToConTax;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

     public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSupComId() {
        return supComId;
    }

    public void setSupComId(Integer supComId) {
        this.supComId = supComId;
    }

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
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

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getBusMode() {
        return busMode;
    }

    public void setBusMode(Integer busMode) {
        this.busMode = busMode;
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

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue == null ? null : taxValue.trim();
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getoTaxPriceIn() {
        return oTaxPriceIn;
    }

    public void setoTaxPriceIn(BigDecimal oTaxPriceIn) {
        this.oTaxPriceIn = oTaxPriceIn;
    }

    public BigDecimal getoUntaxPriceIn() {
        return oUntaxPriceIn;
    }

    public void setoUntaxPriceIn(BigDecimal oUntaxPriceIn) {
        this.oUntaxPriceIn = oUntaxPriceIn;
    }

    public BigDecimal getNewTaxPriceIn() {
        return newTaxPriceIn;
    }

    public void setNewTaxPriceIn(BigDecimal newTaxPriceIn) {
        this.newTaxPriceIn = newTaxPriceIn;
    }

    public BigDecimal getNewUntaxPriceIn() {
        return newUntaxPriceIn;
    }

    public void setNewUntaxPriceIn(BigDecimal newUntaxPriceIn) {
        this.newUntaxPriceIn = newUntaxPriceIn;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
