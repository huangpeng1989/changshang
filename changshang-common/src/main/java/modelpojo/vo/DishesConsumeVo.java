package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DishesConsumeVo implements Serializable {

    //景区名称
    private String parkName;
    //营业点名称
    private String gzoneName;
    //销售时间
    private Date sellDate;
    //菜品编号
    private String dishCode;
    //菜品名称
    private String dishName;
    //菜品类型
    private String goodsType;
    //菜品单位
    private String dishUnit;
    //规格
    private String dishSpec;
    //销售数量
    private BigDecimal sellCount;
    //消耗类型
    private String conType;
    //消耗名称
    private String conName;
    //消耗数量
    private BigDecimal conCount;
    //消耗单位
    private String conUnit;
    //含税成本
    private BigDecimal taxConCost;
    //未税成本
    private BigDecimal notaxConCost;
    //含税总成本
    private BigDecimal taxConAmount;
    //未税总成本
    private BigDecimal noTaxConAmount;

    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getDishSpec() {
        return dishSpec;
    }

    public void setDishSpec(String dishSpec) {
        this.dishSpec = dishSpec;
    }

    public BigDecimal getSellCount() {
        return sellCount;
    }

    public void setSellCount(BigDecimal sellCount) {
        this.sellCount = sellCount;
    }

    public String getConType() {
        return conType;
    }

    public void setConType(String conType) {
        this.conType = conType;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public BigDecimal getConCount() {
        return conCount;
    }

    public void setConCount(BigDecimal conCount) {
        this.conCount = conCount;
    }

    public String getConUnit() {
        return conUnit;
    }

    public void setConUnit(String conUnit) {
        this.conUnit = conUnit;
    }

    public BigDecimal getTaxConCost() {
        return taxConCost;
    }

    public void setTaxConCost(BigDecimal taxConCost) {
        this.taxConCost = taxConCost;
    }

    public BigDecimal getNotaxConCost() {
        return notaxConCost;
    }

    public void setNotaxConCost(BigDecimal notaxConCost) {
        this.notaxConCost = notaxConCost;
    }

    public BigDecimal getTaxConAmount() {
        return taxConAmount;
    }

    public void setTaxConAmount(BigDecimal taxConAmount) {
        this.taxConAmount = taxConAmount;
    }

    public BigDecimal getNoTaxConAmount() {
        return noTaxConAmount;
    }

    public void setNoTaxConAmount(BigDecimal noTaxConAmount) {
        this.noTaxConAmount = noTaxConAmount;
    }
}
