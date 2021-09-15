package modelpojo.vo;

import modelpojo.model.CateringTcbRowmaterial;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-09 14:04
 */
public class CateringTcbRowmaterialVo extends CateringTcbRowmaterial {

    private BigDecimal whStock = BigDecimal.ZERO;


    private String srmUnitName; //原材料包装单位名称
    private String rmUnitName;  //原 材料单位名称
    private String stockUnitName;  //原 材料单位名称
    private Integer isInOutSpec;  //进退货原 材料单位名称
    private String suppName;  //
    private Integer srmId;      // 原材料包装ID
    private Integer suppIsDelete;      // 原材料供应商状态

    private Integer srmUnit;      // 原材料包装单位ID
    private Integer suppId;
    private BigDecimal taxPaid = BigDecimal.ZERO;
    private BigDecimal noTaxPaid = BigDecimal.ZERO;
    private String suppCode;
    private String srmCode;
    private String rmBarcode;  //原材料条码
    private String taxId;
    private String taxName;
    private String phTaxName;  //进项税
    private String saleTaxName; // 销项税
    private String statusStr; // 销项税
    private String srmStatusName; // 原材料销售审核状态
    private String supStatusName; // 原材料供应商审核状态
    private String deliveryTypeName; // 送货类型名称
    private Integer srmIsDetele; // 原材料包装状态
    private String saleStatusName; // 原材料销售状态

    private String rmClassNameOne;
    private String rmClassNameTwo;
    private String rmClassNameThree;

    private BigDecimal fuTaxCost = BigDecimal.ZERO;
    private BigDecimal conToFreeTax = BigDecimal.ZERO;//含税转未税比率
    private BigDecimal freeToConTax = BigDecimal.ZERO;//未税转未税比率
    private Integer suppIsdefault;
    private Integer isdefault;
    private Integer supComId;

    private BigDecimal purchaseTaxPaid;//采购含税进价

    private BigDecimal purchaseNoTaxPaid;//采购未税进价

    private BigDecimal packContent;//包装含量

    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
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

    public String getStockUnitName() {
        return stockUnitName;
    }

    public void setStockUnitName(String stockUnitName) {
        this.stockUnitName = stockUnitName;
    }

    public Integer getSrmIsDetele() {
        return srmIsDetele;
    }

    public void setSrmIsDetele(Integer srmIsDetele) {
        this.srmIsDetele = srmIsDetele;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }

    public String getSrmStatusName() {
        return srmStatusName;
    }

    public void setSrmStatusName(String srmStatusName) {
        this.srmStatusName = srmStatusName;
    }

    public String getSupStatusName() {
        return supStatusName;
    }

    public void setSupStatusName(String supStatusName) {
        this.supStatusName = supStatusName;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public Integer getSuppIsDelete() {
        return suppIsDelete;
    }

    public void setSuppIsDelete(Integer suppIsDelete) {
        this.suppIsDelete = suppIsDelete;
    }

    public BigDecimal getFuTaxCost() {
        return fuTaxCost;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getSupComId() {
        return supComId;
    }

    public void setSupComId(Integer supComId) {
        this.supComId = supComId;
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

    public void setFuTaxCost(BigDecimal fuTaxCost) {
        this.fuTaxCost = fuTaxCost;
    }

    public Integer getSuppIsdefault() {
        return suppIsdefault;
    }

    public void setSuppIsdefault(Integer suppIsdefault) {
        this.suppIsdefault = suppIsdefault;
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    public String getPhTaxName() {
        return phTaxName;
    }

    public void setPhTaxName(String phTaxName) {
        this.phTaxName = phTaxName;
    }

    public String getSaleTaxName() {
        return saleTaxName;
    }

    public void setSaleTaxName(String saleTaxName) {
        this.saleTaxName = saleTaxName;
    }

    public Integer getIsInOutSpec() {
        return isInOutSpec;
    }

    public void setIsInOutSpec(Integer isInOutSpec) {
        this.isInOutSpec = isInOutSpec;
    }

    public String getRmClassNameOne() {
        return rmClassNameOne;
    }

    public void setRmClassNameOne(String rmClassNameOne) {
        this.rmClassNameOne = rmClassNameOne;
    }

    public String getRmClassNameTwo() {
        return rmClassNameTwo;
    }

    public void setRmClassNameTwo(String rmClassNameTwo) {
        this.rmClassNameTwo = rmClassNameTwo;
    }

    public String getRmClassNameThree() {
        return rmClassNameThree;
    }

    public void setRmClassNameThree(String rmClassNameThree) {
        this.rmClassNameThree = rmClassNameThree;
    }


    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }


    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    private BigDecimal srmPackContent = BigDecimal.ZERO;

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public BigDecimal getSrmPackContent() {
        return srmPackContent;
    }

    public void setSrmPackContent(BigDecimal srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
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


    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

}
