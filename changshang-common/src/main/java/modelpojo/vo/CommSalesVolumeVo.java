package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommSalesVolumeVo implements Serializable {

    private String comName;

    private String comCode;

    private String comBarcode;

    private String sellModel;

    private String comUnit;

    private String orgName;

    private String comSpec;

    private String projectId;

    private BigDecimal tieupsAmount;

    private BigDecimal tieupsNotaxAmount;

    private  BigDecimal taxCostAmount;

    private  BigDecimal notaxCostAmount;

    private BigDecimal comNum;

    private BigDecimal salePrice;

    private String isBind;

    private String taxName;

    private  Integer classId;

    private String oneClassName;

    private String twoClassName;

    private String threeClassName;

    private  String gzoneName;

    private String typeName;

    private String classCode;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }

    public BigDecimal getTieupsNotaxAmount() {
        return tieupsNotaxAmount;
    }

    public void setTieupsNotaxAmount(BigDecimal tieupsNotaxAmount) {
        this.tieupsNotaxAmount = tieupsNotaxAmount;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public BigDecimal getComNum() {
        return comNum;
    }

    public void setComNum(BigDecimal comNum) {
        this.comNum = comNum;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getIsBind() {
        return isBind;
    }

    public void setIsBind(String isBind) {
        this.isBind = isBind;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getOneClassName() {
        return oneClassName;
    }

    public void setOneClassName(String oneClassName) {
        this.oneClassName = oneClassName;
    }

    public String getTwoClassName() {
        return twoClassName;
    }

    public void setTwoClassName(String twoClassName) {
        this.twoClassName = twoClassName;
    }

    public String getThreeClassName() {
        return threeClassName;
    }

    public void setThreeClassName(String threeClassName) {
        this.threeClassName = threeClassName;
    }
}
