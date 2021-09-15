package modelpojo.vo;

import java.io.Serializable;

/**
 * @Description 餐饮-报损/溢菜品
 * @Author wenbin.wang
 * @Date 2020-04-17 16:34
 */
public class CaterReportLossDishesVo implements Serializable {
    private static final long serialVersionUID = -6550484496002371685L;

    private String dishCode;//菜品编号
    private Integer dishId;//菜品ID
    private String dishName;//菜品名称
    private String dishUnitName;//菜品单位名称
    private Integer dishUnit;//菜品单位ID
    private String specName;//规格名称
    private Integer specId;//规格ID
    private Integer dishBomId;//菜品BOM ID
    private Integer slTaxId;//税率ID
    private Integer saledDishId;//可售菜品id
    private String saledDishCode;//可售菜品编号
    private String costPrice;//菜品成本价
    private String taxCost;//含税成本价
    private String notaxCost;//未税成本价

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public String getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(String notaxCost) {
        this.notaxCost = notaxCost;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        this.taxCost = taxCost;
    }


    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }

    public String getSaledDishCode() {
        return saledDishCode;
    }

    public void setSaledDishCode(String saledDishCode) {
        this.saledDishCode = saledDishCode;
    }

    public Integer getSlTaxId() {
        return slTaxId;
    }

    public void setSlTaxId(Integer slTaxId) {
        this.slTaxId = slTaxId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
    }
}
