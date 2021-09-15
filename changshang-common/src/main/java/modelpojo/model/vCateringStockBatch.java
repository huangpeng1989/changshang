package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class vCateringStockBatch implements Serializable {
    private Long projectId;

    private Integer batchId;

    private Integer rmId;

    private String rmCode;

    private String rmName;

    private String suppCode;

    private String suppName;

    private BigDecimal billCount;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private Date blTime;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName == null ? null : rmName.trim();
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName == null ? null : suppName.trim();
    }

    public BigDecimal getBillCount() {
        return billCount;
    }

    public void setBillCount(BigDecimal billCount) {
        this.billCount = billCount;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }
}