package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ComSalePricetDto implements Serializable {

    private String dictValue;

    private String comCode;

    private String comName;

    private String comUnit;//单位

    private String comSpec;//规格

    private BigDecimal taxPaid;//含税进价

    private BigDecimal noTaxPaid;//未税进价

    private Date startDate;

    private Date endDate;


    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
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

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
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
