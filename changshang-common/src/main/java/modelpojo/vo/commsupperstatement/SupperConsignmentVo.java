package modelpojo.vo.commsupperstatement;


import entity.ModelPagedList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupperConsignmentVo implements Serializable{

    private String suppName;

    private String suppCode;

    private String sellModel;

    private Integer suppId;

    private BigDecimal comAmount;

    private BigDecimal notaxAmount;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private BigDecimal comNum;

    private Integer comId;

    private String oneClassName;

    private String twoClassName;

    private String threeClassName;

    private String comSpec;

    private String comName;

    private String comCode;

    private String comBarcode;

    private Integer comClassId;

    private String comUnit;

    private String comNdealId;

    private BigDecimal salePrice;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private Date ddate;

    private BigDecimal ytaxCostAmount;

    private  BigDecimal ynotaxCostAmount;

    private BigDecimal rcptOutCount;

    private String rcptBillCode;

    private String taxName;

    private BigDecimal costAmount;

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }


    public String getRcptBillCode() {
        return rcptBillCode;
    }

    public void setRcptBillCode(String rcptBillCode) {
        this.rcptBillCode = rcptBillCode;
    }

    public BigDecimal getRcptOutCount() {
        return rcptOutCount;
    }

    public void setRcptOutCount(BigDecimal rcptOutCount) {
        this.rcptOutCount = rcptOutCount;
    }

    public BigDecimal getYtaxCostAmount() {
        return ytaxCostAmount;
    }

    public void setYtaxCostAmount(BigDecimal ytaxCostAmount) {
        this.ytaxCostAmount = ytaxCostAmount;
    }

    public BigDecimal getYnotaxCostAmount() {
        return ynotaxCostAmount;
    }

    public void setYnotaxCostAmount(BigDecimal ynotaxCostAmount) {
        this.ynotaxCostAmount = ynotaxCostAmount;
    }

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
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

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public BigDecimal getComNum() {
        return comNum;
    }

    public void setComNum(BigDecimal comNum) {
        this.comNum = comNum;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
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

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    private ModelPagedList modelPagedList=new ModelPagedList();

    public ModelPagedList getModelPagedList() {
        return modelPagedList;
    }

    public void setModelPagedList(ModelPagedList modelPagedList) {
        this.modelPagedList = modelPagedList;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public BigDecimal getComAmount() {
        return comAmount;
    }

    public void setComAmount(BigDecimal comAmount) {
        this.comAmount = comAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
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
}
