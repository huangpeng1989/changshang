package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommAdjustDto implements Serializable {

    private String suppCode;

    private String suppName;

    private String comCode;

    private String comName;

    private BigDecimal newTaxPriceIn;//含税进价

    private BigDecimal newUnTaxPriceIn;//未税进价

    private Date startDate;

    private Date endDate;

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public BigDecimal getNewTaxPriceIn() {
        return newTaxPriceIn;
    }

    public void setNewTaxPriceIn(BigDecimal newTaxPriceIn) {
        this.newTaxPriceIn = newTaxPriceIn;
    }

    public BigDecimal getNewUnTaxPriceIn() {
        return newUnTaxPriceIn;
    }

    public void setNewUnTaxPriceIn(BigDecimal newUnTaxPriceIn) {
        this.newUnTaxPriceIn = newUnTaxPriceIn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
