package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaledDishDto  extends CateringTcjSaleadjustDetailModel implements Serializable{

    private int saledDishId;//可售菜品主键ID

    private int dishId;//菜品ID

    private String dishCode;//菜品编号

    private BigDecimal retailPrice;//菜品零售价

    private BigDecimal costPrice;//菜品预估成本

    private String dishTypeStr;//菜品类型

    private String specStr;//菜品规格

    private String dishUnit;//菜品单位

    private String conToFreeTax;//原毛利率

    private String dishName;//菜品名称


    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getConToFreeTax() {
        return conToFreeTax;
    }

    public void setConToFreeTax(String conToFreeTax) {
        this.conToFreeTax = conToFreeTax;
    }

    public int getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(int saledDishId) {
        this.saledDishId = saledDishId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getDishTypeStr() {
        return dishTypeStr;
    }

    public void setDishTypeStr(String dishTypeStr) {
        this.dishTypeStr = dishTypeStr;
    }

    public String getSpecStr() {
        return specStr;
    }

    public void setSpecStr(String specStr) {
        this.specStr = specStr;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }
}
