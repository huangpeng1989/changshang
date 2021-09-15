package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringStockNow implements Serializable {
    private Long projectId;

    private Long projectRootId;

    private Integer whId;

    private Integer rmDishId;

    private String rmCode;

    private BigDecimal whStock;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer srmId;

    private String srmCode;

    private String rmBarcode;

    private Integer srmPackContent;

    private Integer saleTaxId;

    private Integer phTaxId;

    private String rmName;

    private String rmSpec;

    private Integer rmUnit;

    private String typeName;

    private String comClassCode;

    private String suppId;

    private String dishClassCode;

    private String dishName;

    private String dishClassName;

    private BigDecimal packContent;

    //预估含税成本价格
    private BigDecimal taxcostPrice;

    //预估未税成本价格
    private BigDecimal notaxcostPrice;

    public BigDecimal getTaxcostPrice() {
        return taxcostPrice;
    }

    public void setTaxcostPrice(BigDecimal taxcostPrice) {
        this.taxcostPrice = taxcostPrice;
    }

    public BigDecimal getNotaxcostPrice() {
        return notaxcostPrice;
    }

    public void setNotaxcostPrice(BigDecimal notaxcostPrice) {
        this.notaxcostPrice = notaxcostPrice;
    }


    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    private String suppCode;

    public String getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(String noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    private String noTaxPaid;
    private String taxPaid;

    private String phTax;

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getSaleTaxId() {
        return saleTaxId;
    }

    public void setSaleTaxId(Integer saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public Integer getSrmPackContent() {
        return srmPackContent;
    }

    public void setSrmPackContent(Integer srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getSuppId() {
        return suppId;
    }

    public void setSuppId(String suppId) {
        this.suppId = suppId;
    }
}
