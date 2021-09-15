package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SuppRowmaterDto implements Serializable {
    private String rmCode;

    private String rmName;

    private String sellModel;

    private String rmClassCode;

    private String rmcName;

    private String rmUnitName;

    private String specRmType;

    private String specRmType2;

    private String specRmType3;

    private String specRmType4;

    private String specRmType5;

    private String specRmType6;

    private String specRmType7;

    private String specRmType8;

    private BigDecimal taxPaid;

    private BigDecimal noTaxPaid;

    private BigDecimal fuTaxCost;

    private String taxName;

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getRmcName() {
        return rmcName;
    }

    public void setRmcName(String rmcName) {
        this.rmcName = rmcName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(String specRmType) {
        this.specRmType = specRmType;
    }

    public String getSpecRmType2() {
        return specRmType2;
    }

    public void setSpecRmType2(String specRmType2) {
        this.specRmType2 = specRmType2;
    }

    public String getSpecRmType3() {
        return specRmType3;
    }

    public void setSpecRmType3(String specRmType3) {
        this.specRmType3 = specRmType3;
    }

    public String getSpecRmType4() {
        return specRmType4;
    }

    public void setSpecRmType4(String specRmType4) {
        this.specRmType4 = specRmType4;
    }

    public String getSpecRmType5() {
        return specRmType5;
    }

    public void setSpecRmType5(String specRmType5) {
        this.specRmType5 = specRmType5;
    }

    public String getSpecRmType6() {
        return specRmType6;
    }

    public void setSpecRmType6(String specRmType6) {
        this.specRmType6 = specRmType6;
    }

    public String getSpecRmType7() {
        return specRmType7;
    }

    public void setSpecRmType7(String specRmType7) {
        this.specRmType7 = specRmType7;
    }

    public String getSpecRmType8() {
        return specRmType8;
    }

    public void setSpecRmType8(String specRmType8) {
        this.specRmType8 = specRmType8;
    }

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    public BigDecimal getFuTaxCost() {
        return fuTaxCost;
    }

    public void setFuTaxCost(BigDecimal fuTaxCost) {
        this.fuTaxCost = fuTaxCost;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }
}
