package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleReportDto implements Serializable {

    private String gzoneCode;

    private String gzoneName;

    private String rmDishCode;

    private String dishName;

    private String dishUnit;

    private BigDecimal retailPrice;//含税销售价格

    private BigDecimal notRetailPrice;//未税销售价格

    private Date startDate;

    private Date endDate;

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getRmDishCode() {
        return rmDishCode;
    }

    public void setRmDishCode(String rmDishCode) {
        this.rmDishCode = rmDishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getNotRetailPrice() {
        return notRetailPrice;
    }

    public void setNotRetailPrice(BigDecimal notRetailPrice) {
        this.notRetailPrice = notRetailPrice;
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