package modelpojo.vo.caterAdjust;

import modelpojo.model.CateringTcbRowmaterial;

import java.math.BigDecimal;

public class RowmaterilVo extends CateringTcbRowmaterial {

    private String unitName;

    private BigDecimal taxPaid;

    private BigDecimal purchaseTaxPaid;

    public BigDecimal getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(BigDecimal purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}
