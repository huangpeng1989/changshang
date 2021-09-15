package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaledRawMaterDto extends CateringTcjSaleadjustModel implements Serializable{

    private int srmId;//原材料包装ID

    private int rmId;//= 原材料ID

    private String rmCode;//原材料编号

    private BigDecimal retailPrice;//原材料零售价

    private BigDecimal costPrice;//预估成本

    private String srmCode;//原材料包装编号

    private String rmUnit;//原材料包装单位

    private String conToFreeTax;//原毛利率

    private String rmName;//原材料名称

    private BigDecimal packContent;//原材料包装含量

    private String rmBarcode;//原材料条码

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getConToFreeTax() {
        return conToFreeTax;
    }

    public void setConToFreeTax(String conToFreeTax) {
        this.conToFreeTax = conToFreeTax;
    }

    public int getSrmId() {
        return srmId;
    }

    public void setSrmId(int srmId) {
        this.srmId = srmId;
    }

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public String getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(String rmUnit) {
        this.rmUnit = rmUnit;
    }
}
