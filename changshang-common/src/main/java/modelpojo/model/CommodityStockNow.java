package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommodityStockNow implements Serializable {
    private Long projectId;

    private Long projectRootId;

    private Integer whId;

    private Integer comId;

    private String comCode;

    private BigDecimal whStock;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer saleComId;

    private String saleComCode;

    private String saleComBarcode;

    private Integer salePackContent;

    private String comName;

    private String comSpec;

    private Integer comUnit;

    private String typeName;

    private String comClassCode;

    private String suppId;

    private String taxName;

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

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    private Integer phTaxId;
    private String phTax;

    private BigDecimal taxPaid;

    private BigDecimal noTaxPaid;

    private String suppCode;

    public String getSuppId() {
        return suppId;
    }

    public void setSuppId(String suppId) {
        this.suppId = suppId;
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

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
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

    public Integer getSalePackContent() {
        return salePackContent;
    }

    public void setSalePackContent(Integer salePackContent) {
        this.salePackContent = salePackContent;
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

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public String getSaleComBarcode() {
        return saleComBarcode;
    }

    public void setSaleComBarcode(String saleComBarcode) {
        this.saleComBarcode = saleComBarcode == null ? null : saleComBarcode.trim();
    }
}
