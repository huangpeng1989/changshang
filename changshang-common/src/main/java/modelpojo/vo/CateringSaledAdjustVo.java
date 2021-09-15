package modelpojo.vo;

import modelpojo.model.CateringTcjSaleadjustDetailModel;


public class CateringSaledAdjustVo extends CateringTcjSaleadjustDetailModel {

    private String startDate;

    private String endDate;

    private String adjType;

    private String dishName;

    private String gzoneName;

    private String dishCode;

    private String dishType;

    private String taxValue;

    private String adjStatus;

    public String getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(String adjStatus) {
        this.adjStatus = adjStatus;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue;
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
