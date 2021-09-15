package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ComGrossMarginVo implements Serializable {

    private String comName;

    private String comBarcode;

    private String gzoneName;

    private String comCode;

    private String sellModel;

    private String commUnit;

    private Integer comClassId;

    private String orgName;

    private String terminalName;

    private Date ddate;

    private String staxName;

    private String ptaxName;

    private String tieupsTaxName;

    private BigDecimal salePrice;
    //销售含税总金额
    private BigDecimal comAmount;
    //销售未税总金额
    private BigDecimal notaxAmount;

    private String OneClassName;

    private String TwoClassName;

    private String ThreeClassName;
    //含税成本
    private BigDecimal taxCost;
    //未税成本
    private BigDecimal notaxCost;
    //含税总成本
    private BigDecimal taxCostAmount;
    //未税总成本
    private BigDecimal notaxCostAmount;
    //含税毛利
    private BigDecimal mtaxCostAmount;
    //未税毛利
    private BigDecimal mnotaxCostAmount;

    private BigDecimal comNum;

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

    private String suppName;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public BigDecimal getComNum() {
        return comNum;
    }

    public void setComNum(BigDecimal comNum) {
        this.comNum = comNum;
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

    public String getTieupsTaxName() {
        return tieupsTaxName;
    }

    public void setTieupsTaxName(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
    }

    public String getPtaxName() {
        return ptaxName;
    }

    public void setPtaxName(String ptaxName) {
        this.ptaxName = ptaxName;
    }

    public String getOneClassName() {
        return OneClassName;
    }

    public void setOneClassName(String oneClassName) {
        OneClassName = oneClassName;
    }

    public String getTwoClassName() {
        return TwoClassName;
    }

    public void setTwoClassName(String twoClassName) {
        TwoClassName = twoClassName;
    }

    public String getThreeClassName() {
        return ThreeClassName;
    }

    public void setThreeClassName(String threeClassName) {
        ThreeClassName = threeClassName;
    }

    public BigDecimal getComAmount() {
        return comAmount;
    }

    public void setComAmount(BigDecimal comAmount) {
        this.comAmount = comAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }


    public String getStaxName() {
        return staxName;
    }

    public void setStaxName(String staxName) {
        this.staxName = staxName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
}
