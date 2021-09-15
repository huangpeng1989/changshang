package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 原材料供应商表
 */
public class CateringTcbSuppRowmater implements Serializable {

    private static final long serialVersionUID = 5009817422520108156L;
    private Long projectId;

    public String getSupComCode() {
        return supComCode;
    }

    public void setSupComCode(String supComCode) {
        this.supComCode = supComCode;
    }

    private String supComCode;

    private Integer supComId;


    private Integer suppId;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    private String suppName;

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    private String suppCode;

    private Integer rmId;

    private String rmCode;

    private String rmName;

    private BigDecimal taxPaid;

    private BigDecimal noTaxPaid;

    private BigDecimal oldTaxPaid;

    private BigDecimal oldNoTaxPaid;

    private Integer deliveryType;

    private BigDecimal fuTaxCost;

    private Integer isDefault;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Date blTime;

    private Long blEmpId;

    private Integer srmStatus;

    private Integer isDelete;

    //采购含税进价
    private BigDecimal purchaseTaxPaid;
    //采购未税进价
    private BigDecimal purchaseNoTaxPaid;
    //商品合同id
    private Integer contractId;
    //商品合同编号
    private String contractCode;
    //商品合同名称
    private String contractName;
    //进项税
    private String phTax;
    //进项税ID
    private Integer phTaxId;

    //采购含税进价
    private BigDecimal oldPurchaseTaxPaid;
    //采购未税进价
    private BigDecimal oldPurchaseNoTaxPaid;

    public BigDecimal getOldPurchaseTaxPaid() {
        return oldPurchaseTaxPaid;
    }

    public void setOldPurchaseTaxPaid(BigDecimal oldPurchaseTaxPaid) {
        this.oldPurchaseTaxPaid = oldPurchaseTaxPaid;
    }

    public BigDecimal getOldPurchaseNoTaxPaid() {
        return oldPurchaseNoTaxPaid;
    }

    public void setOldPurchaseNoTaxPaid(BigDecimal oldPurchaseNoTaxPaid) {
        this.oldPurchaseNoTaxPaid = oldPurchaseNoTaxPaid;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public BigDecimal getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(BigDecimal purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }

    public BigDecimal getPurchaseNoTaxPaid() {
        return purchaseNoTaxPaid;
    }

    public void setPurchaseNoTaxPaid(BigDecimal purchaseNoTaxPaid) {
        this.purchaseNoTaxPaid = purchaseNoTaxPaid;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    private String createrStr;

    private String  deliveryTypeStr; //送货方式
    private String  isDeleteStr; //状态 1：淘汰 2：正常
    private String  suppType;

    //状态 0：正常 1：淘汰
    private String isNormal;

    public String getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal;
    }

    public BigDecimal getOldTaxPaid() {
        return oldTaxPaid;
    }

    public void setOldTaxPaid(BigDecimal oldTaxPaid) {
        this.oldTaxPaid = oldTaxPaid;
    }

    public BigDecimal getOldNoTaxPaid() {
        return oldNoTaxPaid;
    }

    public void setOldNoTaxPaid(BigDecimal oldNoTaxPaid) {
        this.oldNoTaxPaid = oldNoTaxPaid;
    }

    public String getSuppType() {
        return suppType;
    }

    public void setSuppType(String suppType) {
        this.suppType = suppType;
    }

    public String getIsDeleteStr() {
        return isDeleteStr;
    }

    public void setIsDeleteStr(String isDeleteStr) {
        this.isDeleteStr = isDeleteStr;
    }

    public String getDeliveryTypeStr() {
        return deliveryTypeStr;
    }

    public void setDeliveryTypeStr(String deliveryTypeStr) {
        this.deliveryTypeStr = deliveryTypeStr;
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

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName == null ? null : rmName.trim();
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

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getFuTaxCost() {
        return fuTaxCost;
    }

    public void setFuTaxCost(BigDecimal fuTaxCost) {
        this.fuTaxCost = fuTaxCost;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Integer getSrmStatus() {
        return srmStatus;
    }

    public void setSrmStatus(Integer srmStatus) {
        this.srmStatus = srmStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
