package modelpojo.vo;

import modelpojo.model.CommodityTcjSaleadjustdetail;


public class CommoditySaleAdjustVo extends CommodityTcjSaleadjustdetail {

    private String adjStatus;

    private String startDate;

    private String endDate;

    private String adjType;

    private String sellModelStr;

    private String saleComCode;

    private String grade;

    private String taxValue;

    public String getSellModelStr() {
        return sellModelStr;
    }

    public void setSellModelStr(String sellModelStr) {
        this.sellModelStr = sellModelStr;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue;
    }

    public String getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(String adjStatus) {
        this.adjStatus = adjStatus;
    }

    public String getAdjType() {
        return adjType;
    }

    public void setAdjType(String adjType) {
        this.adjType = adjType;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
