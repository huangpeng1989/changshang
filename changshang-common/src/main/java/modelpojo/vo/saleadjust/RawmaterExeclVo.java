package modelpojo.vo.saleadjust;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * @Description 原材料Execl实体类
 * @Author wenbin.wang
 * @Date 2019-09-09 09:14
 */
public class RawmaterExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*原材料分类",type = HeadProperty.HeadType.STRING)
    private String rmClassCode;

    @HeadProperty(name="*原材料名称",type = HeadProperty.HeadType.STRING)
    private String rmName;

    @HeadProperty(name="*原材料简称",type = HeadProperty.HeadType.STRING)
    private String rmAbbreviate;

    @HeadProperty(name="*原材料类型",type = HeadProperty.HeadType.STRING)
    private String  specRmType;

    public String getCostPrice() {
        return costPrice;
    }

    @HeadProperty(name="*是否可售",type = HeadProperty.HeadType.STRING)
    private String  isCanSale;

    @HeadProperty(name="预估售价",type = HeadProperty.HeadType.STRING)
    private String  predictPrice;

    @HeadProperty(name="*原材料规格",type = HeadProperty.HeadType.STRING)
    private String sellModel;
    @HeadProperty(name="*原材料单位",type = HeadProperty.HeadType.STRING)
    private String  rmUnit;
    @HeadProperty(name="*保质期",type = HeadProperty.HeadType.STRING)
    private String expirationDate;
    @HeadProperty(name="*原材料等级",type = HeadProperty.HeadType.STRING)
    private String  rmGradeId;
    @HeadProperty(name="*进项税税率",type = HeadProperty.HeadType.STRING)
    private String  phTaxId;

    @HeadProperty(name="*销项税税率",type = HeadProperty.HeadType.STRING)
    private String  saleTaxId;
    @HeadProperty(name="*原材料包装单位",type = HeadProperty.HeadType.STRING)
    private String  srmUnit;


    @HeadProperty(name="*包装含量",type = HeadProperty.HeadType.STRING)
    private String  packContent;
    @HeadProperty(name="*供应商名称",type = HeadProperty.HeadType.STRING)
    private String  suppName;
    @HeadProperty(name="*含税进价",type = HeadProperty.HeadType.STRING)
    private String  taxPaid;

    @HeadProperty(name="*预估成本价",type = HeadProperty.HeadType.STRING)
    private String costPrice;
    @HeadProperty(name="最高库存",type = HeadProperty.HeadType.STRING)
    private String maxWhCount;
    @HeadProperty(name="最低库存",type = HeadProperty.HeadType.STRING)
    private String minWhCount;
    @HeadProperty(name="生产厂家",type = HeadProperty.HeadType.STRING)
    private String manufacturer;
    @HeadProperty(name="原材料说明",type = HeadProperty.HeadType.STRING)
    private String description;
    @HeadProperty(name="备注",type = HeadProperty.HeadType.STRING)
    private String remark;

    @HeadProperty(name="*采购单位",type = HeadProperty.HeadType.STRING)
    private String purchaseUnit;

    @HeadProperty(name="*合同编号",type = HeadProperty.HeadType.STRING)
    private String contractCode;

    @HeadProperty(name="*采购含税进价",type = HeadProperty.HeadType.STRING)
    private String purchaseTaxPaid;

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

    public String getSaleTaxId() {
        return saleTaxId;
    }

    public String getPredictPrice() {
        return predictPrice;
    }

    public void setPredictPrice(String predictPrice) {
        this.predictPrice = predictPrice;
    }

    public void setSaleTaxId(String saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

    public String getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(String srmUnit) {
        this.srmUnit = srmUnit;
    }

    public String getPackContent() {
        return packContent;
    }

    public void setPackContent(String packContent) {
        this.packContent = packContent;
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

    public String  getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String  rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmAbbreviate() {
        return rmAbbreviate;
    }

    public void setRmAbbreviate(String rmAbbreviate) {
        this.rmAbbreviate = rmAbbreviate;
    }

    public String  getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(String  specRmType) {
        this.specRmType = specRmType;
    }

    public String getIsCanSale() {
        return isCanSale;
    }

    public void setIsCanSale(String isCanSale) {
        this.isCanSale = isCanSale;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String  getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(String  rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String  getRmGradeId() {
        return rmGradeId;
    }

    public void setRmGradeId(String  rmGradeId) {
        this.rmGradeId = rmGradeId;
    }

    public String  getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(String  phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(String maxWhCount) {
        this.maxWhCount = maxWhCount;
    }

    public String getMinWhCount() {
        return minWhCount;
    }

    public void setMinWhCount(String minWhCount) {
        this.minWhCount = minWhCount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }



}
