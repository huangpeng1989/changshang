package modelpojo.vo.commodityinfo;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * 商品Execl实体类
 */
public class CommExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*商品分类",type = HeadProperty.HeadType.STRING)
    private String comClassCode;

    @HeadProperty(name="*商品名称",type = HeadProperty.HeadType.STRING)
    private String comName;

    @HeadProperty(name="*商品简称",type = HeadProperty.HeadType.STRING)
    private String comAbbreviate;

    @HeadProperty(name="*经营方式",type = HeadProperty.HeadType.STRING)
    private String  sellModel;

    @HeadProperty(name="*商品类型",type = HeadProperty.HeadType.STRING)
    private String  comType;

    @HeadProperty(name="*商品销售状态",type = HeadProperty.HeadType.STRING)
    private String sellStatus;

    @HeadProperty(name="*商品规格",type = HeadProperty.HeadType.STRING)
    private String  comSpec;

    @HeadProperty(name="*商品单位",type = HeadProperty.HeadType.STRING)
    private String comUnit;

    @HeadProperty(name="*保质期",type = HeadProperty.HeadType.STRING)
    private String  expirationDate;

    @HeadProperty(name="产品等级",type = HeadProperty.HeadType.STRING)
    private String  comGrade;

    @HeadProperty(name="商品品牌",type = HeadProperty.HeadType.STRING)
    private String  comBrand;

    @HeadProperty(name="*建议零售价",type = HeadProperty.HeadType.STRING)
    private String  retailPrice;

    @HeadProperty(name="*进项税税率",type = HeadProperty.HeadType.STRING)
    private String  phTaxId;

    @HeadProperty(name="*销项税税率",type = HeadProperty.HeadType.STRING)
    private String  slTaxId;

    @HeadProperty(name="*最高库存",type = HeadProperty.HeadType.STRING)
    private String  maxWhCount;

    @HeadProperty(name="*最低库存",type = HeadProperty.HeadType.STRING)
    private String minWhCount;

    @HeadProperty(name="生产厂家",type = HeadProperty.HeadType.STRING)
    private String manufacturer;

    @HeadProperty(name="*包装含量",type = HeadProperty.HeadType.STRING)
    private String packContent;

    @HeadProperty(name="销售商品单位",type = HeadProperty.HeadType.STRING)
    private String saleCommUnit;

    @HeadProperty(name="商品条码",type = HeadProperty.HeadType.STRING)
    private String comBarcode;

    @HeadProperty(name="*供应商",type = HeadProperty.HeadType.STRING)
    private String suppName;

    @HeadProperty(name="*含税进价",type = HeadProperty.HeadType.STRING)
    private String taxPaid;

    @HeadProperty(name="*预估含税成本价",type = HeadProperty.HeadType.STRING)
    private String fuTaxCost;

    @HeadProperty(name="*价格等级",type = HeadProperty.HeadType.STRING)
    private String gradeId;

    @HeadProperty(name="*零售价",type = HeadProperty.HeadType.STRING)
    private String gradeRetailPrice;

    @HeadProperty(name="商品说明",type = HeadProperty.HeadType.STRING)
    private String description;

    @HeadProperty(name="备注",type = HeadProperty.HeadType.STRING)
    private String remark;

    @HeadProperty(name="联营扣率(%)",type = HeadProperty.HeadType.STRING)
    private String discountRate;

    @HeadProperty(name="*采购单位",type = HeadProperty.HeadType.STRING)
    private String purchaseUnit;

    @HeadProperty(name="*合同编号",type = HeadProperty.HeadType.STRING)
    private String contractCode;

    @HeadProperty(name="*采购含税进价",type = HeadProperty.HeadType.STRING)
    private String purchaseTaxPaid;

    @HeadProperty(name="是否押金",type = HeadProperty.HeadType.STRING)
    private String isDeposit;

    public String getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(String isDeposit) {
        this.isDeposit = isDeposit;
    }

    public String getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(String purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
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

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
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
        this.retailPrice = retailPrice;
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

    public String getPackContent() {
        return packContent;
    }

    public void setPackContent(String packContent) {
        this.packContent = packContent;
    }

    public String getSaleCommUnit() {
        return saleCommUnit;
    }

    public void setSaleCommUnit(String saleCommUnit) {
        this.saleCommUnit = saleCommUnit;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
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

    public String getFuTaxCost() {
        return fuTaxCost;
    }

    public void setFuTaxCost(String fuTaxCost) {
        this.fuTaxCost = fuTaxCost;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeRetailPrice() {
        return gradeRetailPrice;
    }

    public void setGradeRetailPrice(String gradeRetailPrice) {
        this.gradeRetailPrice = gradeRetailPrice;
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
}
