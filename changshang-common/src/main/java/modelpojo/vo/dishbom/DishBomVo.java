package modelpojo.vo.dishbom;

import modelpojo.model.CateringTcbDishBomDetail;

import java.math.BigDecimal;

public class DishBomVo extends CateringTcbDishBomDetail {

    private String dishName;

    private Integer dishType;

    private String dishTypeName;

    private String dishBomCode;

    private Integer dbStatus;

    private String costSumcountStr;

    private BigDecimal lossCount;

    private BigDecimal taxPaidSum;

    private String dbStatusName;

    public Integer getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(Integer dbStatus) {
        this.dbStatus = dbStatus;
    }

    public String getDbStatusName() {
        return dbStatusName;
    }

    public void setDbStatusName(String dbStatusName) {
        this.dbStatusName = dbStatusName;
    }

    public BigDecimal getTaxPaidSum() {
        return taxPaidSum;
    }

    public void setTaxPaidSum(BigDecimal taxPaidSum) {
        this.taxPaidSum = taxPaidSum;
    }

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

    public String getDishBomCode() {
        return dishBomCode;
    }

    public void setDishBomCode(String dishBomCode) {
        this.dishBomCode = dishBomCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public String getCostSumcountStr() {
        return costSumcountStr;
    }

    public void setCostSumcountStr(String costSumcountStr) {
        this.costSumcountStr = costSumcountStr;
    }

    public BigDecimal getLossCount() {
        return lossCount;
    }

    public void setLossCount(BigDecimal lossCount) {
        this.lossCount = lossCount;
    }
}