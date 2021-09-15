package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 原材料预导入提示
 * @Author wenbin.wang
 * @Date 2020-05-22 10:09
 */
public class RawmaterExeclMessage implements Serializable {
    private static final long serialVersionUID = 544994082653878606L;


    //原材料名称
    private String rmClassCode;
    private String rmName;
    private String rmCode;
    private String rmAbbreviate;

    private String spellCode;

    private String sellModel;

    private String manufacturer;

    private Integer expirationDate;

    private Integer rmGradeId;

    private BigDecimal maxWhCount;

    private BigDecimal minWhCount;
    private BigDecimal costPrice;

    private String phTax;
    private String phTaxIdStr;
    private BigDecimal predictPrice;  // 预估售价

    //原材料条码
    private String rmBarcode;

    //是否可售
    private String  isCanSale;

    //原材料单位
    private String  rmUnitName;
    private Integer  rmUnit;

    //进项税税率
    private String  phTaxId;

    //销项税税率
    private String  saleTaxId;
    private String  SaleTaxIdStr;

    //供应商名称
    private String  suppName;
    private String  suppCode;
    private String  specRmType;

    //含税进价
    private String  taxPaid;

    private String remark;

    private String description;

    // 导入结果
    private String  flag;
    private int  type;

    //问题原因
    private String  message;

    private String  packContent;

    private String purchaseUnit;

    private String contractCode;

    private String purchaseTaxPaid;

    private Integer contractId;

    private Integer contractSupper;

    private String contractName;

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getContractSupper() {
        return contractSupper;
    }

    public void setContractSupper(Integer contractSupper) {
        this.contractSupper = contractSupper;
    }

    public String getPackContent() {
        return packContent;
    }

    public void setPackContent(String packContent) {
        this.packContent = packContent;
    }

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(String purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSaleTaxIdStr() {
        return SaleTaxIdStr;
    }

    public void setSaleTaxIdStr(String saleTaxIdStr) {
        SaleTaxIdStr = saleTaxIdStr;
    }

    public String getPhTaxIdStr() {
        return phTaxIdStr;
    }

    public void setPhTaxIdStr(String phTaxIdStr) {
        this.phTaxIdStr = phTaxIdStr;
    }

    public String getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(String specRmType) {
        this.specRmType = specRmType;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmAbbreviate() {
        return rmAbbreviate;
    }

    public void setRmAbbreviate(String rmAbbreviate) {
        this.rmAbbreviate = rmAbbreviate;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getRmGradeId() {
        return rmGradeId;
    }

    public void setRmGradeId(Integer rmGradeId) {
        this.rmGradeId = rmGradeId;
    }

    public BigDecimal getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(BigDecimal maxWhCount) {
        this.maxWhCount = maxWhCount;
    }

    public BigDecimal getMinWhCount() {
        return minWhCount;
    }

    public void setMinWhCount(BigDecimal minWhCount) {
        this.minWhCount = minWhCount;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public BigDecimal getPredictPrice() {
        return predictPrice;
    }

    public void setPredictPrice(BigDecimal predictPrice) {
        this.predictPrice = predictPrice;
    }


    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getIsCanSale() {
        return isCanSale;
    }

    public void setIsCanSale(String isCanSale) {
        this.isCanSale = isCanSale;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(String phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getSaleTaxId() {
        return saleTaxId;
    }

    public void setSaleTaxId(String saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
