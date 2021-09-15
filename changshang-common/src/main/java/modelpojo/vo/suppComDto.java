package modelpojo.vo;

import modelpojo.model.CommodityTcbSuppcomModel;

import java.math.BigDecimal;

public class suppComDto extends CommodityTcbSuppcomModel {
    private Integer supComId;

    private Integer suppId;

    private BigDecimal taxPaid;

    private BigDecimal noTaxPaid;

    private String unitName;

    private String sellModel;

    private String sellStatus;

    private String comTypeStr;

    private String comClassName;

    private String comSpec;

    private BigDecimal retailPrice;

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(String sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getComTypeStr() {
        return comTypeStr;
    }

    public void setComTypeStr(String comTypeStr) {
        this.comTypeStr = comTypeStr;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getSupComId() {
        return supComId;
    }

    public void setSupComId(Integer supComId) {
        this.supComId = supComId;
    }

    @Override
    public Integer getSuppId() {
        return suppId;
    }

    @Override
    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    @Override
    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    @Override
    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    @Override
    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    @Override
    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

}
