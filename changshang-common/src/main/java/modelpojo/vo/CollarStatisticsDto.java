package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class CollarStatisticsDto implements Serializable {

    private String rcptEmp;//领用人

    private String rcptDept;//领用部门

    private BigDecimal rcptOutCount;//领用数量

    private BigDecimal taxCost;//领用含税成本价总计

    private BigDecimal taxCostAmount;// 领用含税成本金额

    public String getRcptEmp() {
        return rcptEmp;
    }

    public void setRcptEmp(String rcptEmp) {
        this.rcptEmp = rcptEmp;
    }

    public String getRcptDept() {
        return rcptDept;
    }

    public void setRcptDept(String rcptDept) {
        this.rcptDept = rcptDept;
    }

    public BigDecimal getRcptOutCount() {
        return rcptOutCount;
    }

    public void setRcptOutCount(BigDecimal rcptOutCount) {
        this.rcptOutCount = rcptOutCount;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }
}
