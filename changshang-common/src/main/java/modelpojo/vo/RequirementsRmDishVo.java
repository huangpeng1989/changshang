package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class RequirementsRmDishVo  implements Serializable{


    private String typeName;

    private BigDecimal bomCost;

    private BigDecimal dWhStock;

    private BigDecimal yWhStock;

    private String dishName;

    private String dishCode;

    private String dishUnitName;

    private String rejectResion;

    private BigDecimal allotNum;

    private BigDecimal inNum;

    public BigDecimal getInNum() {
        return inNum;
    }

    public void setInNum(BigDecimal inNum) {
        this.inNum = inNum;
    }

    public BigDecimal getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(BigDecimal allotNum) {
        this.allotNum = allotNum;
    }

    public String getRejectResion() {
        return rejectResion;
    }

    public void setRejectResion(String rejectResion) {
        this.rejectResion = rejectResion;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getBomCost() {
        return bomCost;
    }

    public void setBomCost(BigDecimal bomCost) {
        this.bomCost = bomCost;
    }

    public BigDecimal getdWhStock() {
        return dWhStock;
    }

    public void setdWhStock(BigDecimal dWhStock) {
        this.dWhStock = dWhStock;
    }

    public BigDecimal getyWhStock() {
        return yWhStock;
    }

    public void setyWhStock(BigDecimal yWhStock) {
        this.yWhStock = yWhStock;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }
}
