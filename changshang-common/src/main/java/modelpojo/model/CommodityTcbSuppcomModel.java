package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商商品表
 */
public class CommodityTcbSuppcomModel implements Serializable {
    //项目ID
    private Long projectId;
    //供应商商品ID
    private Integer supComId;
    //供应商ID
    private Integer suppId;
    //商品ID
    private Integer comId;
    //商品编号
    private String comCode;
    //商品名称
    private String comName;
    //含税进价
    private BigDecimal taxPaid;
    //未税进价
    private BigDecimal noTaxPaid;
    //送货类型
    private Integer deliveryType;
    //预估含税成本价
    private BigDecimal fuTaxCost;
    //是否缺省供应商
    private Integer isDefault;
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
    //审核时间
    private Date blTime;
    //审核人
    private Long blEmpId;
    //状态
    private Integer cStatus;

    private Integer isDelete;
    
    private Integer syncStatus;
    //0淘汰 1正常
    private Integer isEliminate;
    //含税进价
    private BigDecimal oldTaxPaid;
    //未税进价
    private BigDecimal oldNoTaxPaid;
    //采购含税进价
    private BigDecimal purchaseTaxPaid;
    //采购未税进价
    private BigDecimal purchaseNoTaxPaid;
    //联营扣率
    private BigDecimal discountRate;
    //商品合同id
    private Integer contractId;
    //商品合同编号
    private String contractCode;
    //商品合同名称
    private String contractName;
    //进项税
    private String phTax;

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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
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

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
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

    public Integer getIsEliminate() {
        return isEliminate;
    }

    public void setIsEliminate(Integer isEliminate) {
        this.isEliminate = isEliminate;
    }

    public Integer getcStatus() {
		return cStatus;
	}

	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	public Integer getSupComId() {
		return supComId;
	}

	public void setSupComId(Integer supComId) {
		this.supComId = supComId;
	}

	public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
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

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
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

    public Integer getScStatus() {
        return cStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.cStatus = scStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
    
}