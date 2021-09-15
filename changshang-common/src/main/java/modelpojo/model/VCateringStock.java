package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VCateringStock implements Serializable {
    private Long projectId;

    private Long projectRootId;

    private BigDecimal whStock;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal taxCost;

    private BigDecimal notaxCostAmount;

    private Integer whId;

    private Integer rmDishId;

    private String rmCode;

    private BigDecimal noWhStock;

    private String whName;

    private String rmBarcode;

    private String rmName;

    private String sellModel;

    private String rmUnit;

    private String rmClassName;

    private String taxName;

    private String suppName;

    private Integer rmId;

    private String rmClassCode;

    private BigDecimal qcStock;

    private  String dishClassCode;

    private BigDecimal qcstock;//期初库存总数量

    private Integer pageCount;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public BigDecimal getQcstock() {
        return qcstock;
    }

    public void setQcstock(BigDecimal qcstock) {
        this.qcstock = qcstock;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public BigDecimal getQcStock() {
        return qcStock;
    }

    public void setQcStock(BigDecimal qcStock) {
        this.qcStock = qcStock;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(String rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getRmClassName() {
        return rmClassName;
    }

    public void setRmClassName(String rmClassName) {
        this.rmClassName = rmClassName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public BigDecimal getNoWhStock() {
        return noWhStock;
    }

    public void setNoWhStock(BigDecimal noWhStock) {
        this.noWhStock =noWhStock;
    }
}