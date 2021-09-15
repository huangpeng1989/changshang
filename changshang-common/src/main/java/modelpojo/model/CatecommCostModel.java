package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CatecommCostModel implements Serializable {
    private Long projectId;

    private Integer comId;

    private Integer goodType;

    private BigDecimal taxcostprice;

    private BigDecimal notaxcostprice;

    private BigDecimal taxcostamount;

    private BigDecimal notaxcostamount;

    private BigDecimal stocknum;

    private BigDecimal qcstocknum;

    private Integer dtime;

    private Integer moduleId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public BigDecimal getTaxcostprice() {
        return taxcostprice;
    }

    public void setTaxcostprice(BigDecimal taxcostprice) {
        this.taxcostprice = taxcostprice;
    }

    public BigDecimal getNotaxcostprice() {
        return notaxcostprice;
    }

    public void setNotaxcostprice(BigDecimal notaxcostprice) {
        this.notaxcostprice = notaxcostprice;
    }

    public BigDecimal getTaxcostamount() {
        return taxcostamount;
    }

    public void setTaxcostamount(BigDecimal taxcostamount) {
        this.taxcostamount = taxcostamount;
    }

    public BigDecimal getNotaxcostamount() {
        return notaxcostamount;
    }

    public void setNotaxcostamount(BigDecimal notaxcostamount) {
        this.notaxcostamount = notaxcostamount;
    }

    public BigDecimal getStocknum() {
        return stocknum;
    }

    public void setStocknum(BigDecimal stocknum) {
        this.stocknum = stocknum;
    }

    public BigDecimal getQcstocknum() {
        return qcstocknum;
    }

    public void setQcstocknum(BigDecimal qcstocknum) {
        this.qcstocknum = qcstocknum;
    }

    public Integer getDtime() {
        return dtime;
    }

    public void setDtime(Integer dtime) {
        this.dtime = dtime;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}