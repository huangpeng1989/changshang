package modelpojo.vo;

import modelpojo.model.CateringWhInDtl;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-08 18:27
 */
public class CateringWhInDtlVo extends CateringWhInDtl {

    private Integer saleTaxId;
    private String phTax;
    private Integer phTaxId;
    private String rmClassCode;
    private Integer suppId;
    private String taxPaid;
    private String noTaxPaid;
    private String suppCode;



    private BigDecimal whInSumOrderCount= BigDecimal.ZERO;  // 采购订货数量
    private BigDecimal whInSumGiftCount= BigDecimal.ZERO;   // 采购赠品数量
    private BigDecimal whInSumOGPageCount= BigDecimal.ZERO;   // 采购总数量

    private BigDecimal sumOGPageCount= BigDecimal.ZERO;   // 验收入库总数量
    private BigDecimal sumOrderCount= BigDecimal.ZERO;   //验收入库订单数量
    private BigDecimal sumGiftCount= BigDecimal.ZERO;    // 验收入库赠品数量

    public BigDecimal getSumOrderCount() {
        return sumOrderCount;
    }

    public BigDecimal getSumGiftCount() {
        return sumGiftCount;
    }

    private Integer billType;   // 类型

    public BigDecimal getWhInSumOrderCount() {
        return whInSumOrderCount;
    }

    public void setWhInSumOrderCount(BigDecimal whInSumOrderCount) {
        this.whInSumOrderCount = whInSumOrderCount;
    }

    public BigDecimal getWhInSumGiftCount() {
        return whInSumGiftCount;
    }

    public void setWhInSumGiftCount(BigDecimal whInSumGiftCount) {
        this.whInSumGiftCount = whInSumGiftCount;
    }

    public BigDecimal getWhInSumOGPageCount() {
        return whInSumOGPageCount;
    }

    public void setWhInSumOGPageCount(BigDecimal whInSumOGPageCount) {
        this.whInSumOGPageCount = whInSumOGPageCount;
    }

    public BigDecimal getSumOGPageCount() {
        return sumOGPageCount;
    }

    public void setSumOGPageCount(BigDecimal sumOGPageCount) {
        this.sumOGPageCount = sumOGPageCount;
    }

    public void setSumOrderCount(BigDecimal sumOrderCount) {
        this.sumOrderCount = sumOrderCount;
    }

    public void setSumGiftCount(BigDecimal sumGiftCount) {
        this.sumGiftCount = sumGiftCount;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getSaleTaxId() {
        return saleTaxId;
    }

    public void setSaleTaxId(Integer saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }


    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(String noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }



}
