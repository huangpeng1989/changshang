package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WhinAcptIdComInfo implements Serializable {


     private BigDecimal taxPchsPrice;

    private BigDecimal notaxPchsPrice;

    private BigDecimal orderCount;

    private BigDecimal giftCount;

    private BigDecimal nBachNum;

    private Integer kkcout;

    private  String comName;

    private  String comCode;

    private  String comSpec;

    private  Integer batchId;

    private  Integer comId;

    private   String comBarcode;

    private   String comUnitName;

    private   String taxName;


    private Integer taxId;


    private Integer saleComId;

    private String saleComCode;

    private String commUnit;

    private Integer packContent;

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
        this.saleComCode = saleComCode;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public Integer getPackContent() {
        return packContent;
    }

    public void setPackContent(Integer packContent) {
        this.packContent = packContent;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getTaxPchsPrice() {
        return taxPchsPrice;
    }

    public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
        this.taxPchsPrice = taxPchsPrice;
    }

    public BigDecimal getNotaxPchsPrice() {
        return notaxPchsPrice;
    }

    public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
        this.notaxPchsPrice = notaxPchsPrice;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(BigDecimal giftCount) {
        this.giftCount = giftCount;
    }

    public BigDecimal getnBachNum() {
        return nBachNum;
    }

    public void setnBachNum(BigDecimal nBachNum) {
        this.nBachNum = nBachNum;
    }

    public Integer getKkcout() {
        return kkcout;
    }

    public void setKkcout(Integer kkcout) {
        this.kkcout = kkcout;
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

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }
}
