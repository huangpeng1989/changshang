package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CaterWhinAcptIdComInfo implements Serializable {


     private BigDecimal taxPchsPrice;

    private BigDecimal notaxPchsPrice;

    private BigDecimal orderCount;

    private BigDecimal giftCount;

    private BigDecimal nBachNum;

    private Integer kkcout;

    private  String rmName;

    private  String rmCode;

    private  String rmSpec;

    private  Integer batchId;

    private  Integer rmId;

    private   String rmBarcode;

    private   String rmUnitName;

    private   String taxName;

    private Integer taxId;

    private Integer srmId;

    private String srmCode;

    private String srmUnit;

    private Integer packContent;

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

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public String getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(String srmUnit) {
        this.srmUnit = srmUnit;
    }

    public Integer getPackContent() {
        return packContent;
    }

    public void setPackContent(Integer packContent) {
        this.packContent = packContent;
    }
}
