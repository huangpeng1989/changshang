package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateGrossMarginVo implements Serializable {

    private String orgName;

    private String gzoneName;

    private String terminalName;

    private Date ddate;

    private String dishName;

    private String dishCode;

    private String dishType;

    private String dishUnit;

    private String dishSpec;

    private String sellModel;

    private String dishClassCode;

    private String slTaxName;

    private BigDecimal salePrice;

    private BigDecimal cateNum;

    private BigDecimal cateAmount;

    private BigDecimal notaxAmount;

    private BigDecimal discountRate;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private String oneClassName;

    private String twoClassName;

    private String threeClassName;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private BigDecimal mtaxCostAmount;

    private BigDecimal mnotaxCostAmount;

    private String rmBarcode;

    //含税毛利率
    private BigDecimal taxGrossProfitRate;
    //未税毛利率
    private BigDecimal noTaxGrossProfitRate;
    //景区/营业点销售含税总金额
    private BigDecimal taxAmountAll;
    //景区/营业点销售未税总金额
    private BigDecimal notaxAmountAll;
    //景区/营业点总含税毛利率
    private BigDecimal taxGrossProfitRateAll;
    //景区/营业点总未税毛利率
    private BigDecimal noTaxGrossProfitRateAll;
    //含税毛利占比
    private BigDecimal taxGrossProfitRateProp;
    //未税毛利占比
    private BigDecimal noTaxGrossProfitRateProp;

    public BigDecimal getTaxGrossProfitRate() {
        return taxGrossProfitRate;
    }

    public void setTaxGrossProfitRate(BigDecimal taxGrossProfitRate) {
        this.taxGrossProfitRate = taxGrossProfitRate;
    }

    public BigDecimal getNoTaxGrossProfitRate() {
        return noTaxGrossProfitRate;
    }

    public void setNoTaxGrossProfitRate(BigDecimal noTaxGrossProfitRate) {
        this.noTaxGrossProfitRate = noTaxGrossProfitRate;
    }

    public BigDecimal getTaxAmountAll() {
        return taxAmountAll;
    }

    public void setTaxAmountAll(BigDecimal taxAmountAll) {
        this.taxAmountAll = taxAmountAll;
    }

    public BigDecimal getNotaxAmountAll() {
        return notaxAmountAll;
    }

    public void setNotaxAmountAll(BigDecimal notaxAmountAll) {
        this.notaxAmountAll = notaxAmountAll;
    }

    public BigDecimal getTaxGrossProfitRateAll() {
        return taxGrossProfitRateAll;
    }

    public void setTaxGrossProfitRateAll(BigDecimal taxGrossProfitRateAll) {
        this.taxGrossProfitRateAll = taxGrossProfitRateAll;
    }

    public BigDecimal getNoTaxGrossProfitRateAll() {
        return noTaxGrossProfitRateAll;
    }

    public void setNoTaxGrossProfitRateAll(BigDecimal noTaxGrossProfitRateAll) {
        this.noTaxGrossProfitRateAll = noTaxGrossProfitRateAll;
    }

    public BigDecimal getTaxGrossProfitRateProp() {
        return taxGrossProfitRateProp;
    }

    public void setTaxGrossProfitRateProp(BigDecimal taxGrossProfitRateProp) {
        this.taxGrossProfitRateProp = taxGrossProfitRateProp;
    }

    public BigDecimal getNoTaxGrossProfitRateProp() {
        return noTaxGrossProfitRateProp;
    }

    public void setNoTaxGrossProfitRateProp(BigDecimal noTaxGrossProfitRateProp) {
        this.noTaxGrossProfitRateProp = noTaxGrossProfitRateProp;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
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

    public BigDecimal getMtaxCostAmount() {
        return mtaxCostAmount;
    }

    public void setMtaxCostAmount(BigDecimal mtaxCostAmount) {
        this.mtaxCostAmount = mtaxCostAmount;
    }

    public BigDecimal getMnotaxCostAmount() {
        return mnotaxCostAmount;
    }

    public void setMnotaxCostAmount(BigDecimal mnotaxCostAmount) {
        this.mnotaxCostAmount = mnotaxCostAmount;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getDishSpec() {
        return dishSpec;
    }

    public void setDishSpec(String dishSpec) {
        this.dishSpec = dishSpec;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getSlTaxName() {
        return slTaxName;
    }

    public void setSlTaxName(String slTaxName) {
        this.slTaxName = slTaxName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCateNum() {
        return cateNum;
    }

    public void setCateNum(BigDecimal cateNum) {
        this.cateNum = cateNum;
    }

    public BigDecimal getCateAmount() {
        return cateAmount;
    }

    public void setCateAmount(BigDecimal cateAmount) {
        this.cateAmount = cateAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public String getOneClassName() {
        return oneClassName;
    }

    public void setOneClassName(String oneClassName) {
        this.oneClassName = oneClassName;
    }

    public String getTwoClassName() {
        return twoClassName;
    }

    public void setTwoClassName(String twoClassName) {
        this.twoClassName = twoClassName;
    }

    public String getThreeClassName() {
        return threeClassName;
    }

    public void setThreeClassName(String threeClassName) {
        this.threeClassName = threeClassName;
    }
}
