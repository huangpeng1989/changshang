package modelpojo.vo.allotBill;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: phaseiiclota
 * @description: 商品基础信息导出模板
 * @author: panda
 * @create: 2019-12-12 17:07
 **/
public class ExportCommInfo implements Serializable{


    private String comName;
    private String comCode ;
    private String firstCode;
    private String twoCode;
    private String threeCode;
    private String comAbbreviate;
    private String discountRate;
    private String sellModel;
    private String comType;
    private String sellStatus;
    private String comSpec;
    private String comUnit;
    private String expirationDate;
    private String comGrade;
    private String comBrand;
    private String retailPrice;
    private String phTaxId;
    private String slTaxId;
    private String maxWhCount;
    private String minWhCount;
    private String manufacturer;
    private String description;
    private String saComId;
    private String comBarcode;
    private String packContent;
    private String commUnit;
    private String saleComCode;
    private String comStatus;
    private String saIsDefault;
    private String taxPaid;
    private String noTaxPaid;
    private String fuTaxCost;
    private String suIsDefault;
    private String suppName;
    private String deliveryType;


    private String sellModelName;
    private String sellStatusName;
    private String comUnitName;
    private String comGradeName;
    private String phTaxName;
    private String slTaxName;
    private String saleUnitName;
    private String commStatusName;
    private String isDefaultNameSale;
    private String isDefaultNameSupp;
    private String deliveryTypeName;


    private String comClassCode;
    private String statusStr;


    private String saleStatusStr;
    private String suppStatusName;
    private String suppStatusStr;

    private String isDeposit;

    public String getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(String isDeposit) {
        this.isDeposit = isDeposit;
    }

    public String getSaleStatusStr() {
        return saleStatusStr;
    }

    public void setSaleStatusStr(String saleStatusStr) {
        this.saleStatusStr = saleStatusStr;
    }

    public String getSuppStatusName() {
        return suppStatusName;
    }

    public void setSuppStatusName(String suppStatusName) {
        this.suppStatusName = suppStatusName;
    }

    public String getSuppStatusStr() {
        return suppStatusStr;
    }

    public void setSuppStatusStr(String suppStatusStr) {
        this.suppStatusStr = suppStatusStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {

        BigDecimal b = new BigDecimal(discountRate);
        this.discountRate = b.toPlainString();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getFirstCode() {
        return firstCode;
    }

    public void setFirstCode(String firstCode) {
        this.firstCode = firstCode;
    }

    public String getTwoCode() {
        return twoCode;
    }

    public void setTwoCode(String twoCode) {
        this.twoCode = twoCode;
    }

    public String getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(String threeCode) {
        this.threeCode = threeCode;
    }

    public String getComAbbreviate() {
        return comAbbreviate;
    }

    public void setComAbbreviate(String comAbbreviate) {
        this.comAbbreviate = comAbbreviate;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(String sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getComGrade() {
        return comGrade;
    }

    public void setComGrade(String comGrade) {
        this.comGrade = comGrade;
    }

    public String getComBrand() {
        return comBrand;
    }

    public void setComBrand(String comBrand) {
        this.comBrand = comBrand;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        BigDecimal b = new BigDecimal(retailPrice);
        this.retailPrice = b.toPlainString();
    }

    public String getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(String phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getSlTaxId() {
        return slTaxId;
    }

    public void setSlTaxId(String slTaxId) {
        this.slTaxId = slTaxId;
    }

    public String getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(String maxWhCount) {
        BigDecimal b = new BigDecimal(maxWhCount);
        this.maxWhCount = b.toPlainString();
    }

    public String getMinWhCount() {
        return minWhCount;
    }

    public void setMinWhCount(String minWhCount) {
        BigDecimal b = new BigDecimal(minWhCount);
        this.minWhCount = b.toPlainString();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSaComId() {
        return saComId;
    }

    public void setSaComId(String saComId) {
        this.saComId = saComId;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getPackContent() {
        return packContent;
    }

    public void setPackContent(String packContent) {
        this.packContent = packContent;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public String getSaIsDefault() {
        return saIsDefault;
    }

    public void setSaIsDefault(String saIsDefault) {
        this.saIsDefault = saIsDefault;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        BigDecimal b = new BigDecimal(taxPaid);
        this.taxPaid = b.toPlainString();
    }

    public String getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(String noTaxPaid) {
        BigDecimal b = new BigDecimal(noTaxPaid);
        this.noTaxPaid = b.toPlainString();
    }

    public String getFuTaxCost() {
        return fuTaxCost;
    }

    public void setFuTaxCost(String fuTaxCost) {
        BigDecimal b = new BigDecimal(fuTaxCost);
        this.fuTaxCost = b.toPlainString();
    }

    public String getSuIsDefault() {
        return suIsDefault;
    }

    public void setSuIsDefault(String suIsDefault) {
        this.suIsDefault = suIsDefault;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public String getSellStatusName() {
        return sellStatusName;
    }

    public void setSellStatusName(String sellStatusName) {
        this.sellStatusName = sellStatusName;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public String getComGradeName() {
        return comGradeName;
    }

    public void setComGradeName(String comGradeName) {
        this.comGradeName = comGradeName;
    }

    public String getPhTaxName() {
        return phTaxName;
    }

    public void setPhTaxName(String phTaxName) {
        this.phTaxName = phTaxName;
    }

    public String getSlTaxName() {
        return slTaxName;
    }

    public void setSlTaxName(String slTaxName) {
        this.slTaxName = slTaxName;
    }

    public String getSaleUnitName() {
        return saleUnitName;
    }

    public void setSaleUnitName(String saleUnitName) {
        this.saleUnitName = saleUnitName;
    }

    public String getCommStatusName() {
        return commStatusName;
    }

    public void setCommStatusName(String commStatusName) {
        this.commStatusName = commStatusName;
    }

    public String getIsDefaultNameSale() {
        return isDefaultNameSale;
    }

    public void setIsDefaultNameSale(String isDefaultNameSale) {
        this.isDefaultNameSale = isDefaultNameSale;
    }

    public String getIsDefaultNameSupp() {
        return isDefaultNameSupp;
    }

    public void setIsDefaultNameSupp(String isDefaultNameSupp) {
        this.isDefaultNameSupp = isDefaultNameSupp;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }
}
