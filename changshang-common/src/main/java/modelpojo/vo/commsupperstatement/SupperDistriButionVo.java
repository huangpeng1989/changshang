package modelpojo.vo.commsupperstatement;


import entity.ModelPagedList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupperDistriButionVo  implements Serializable{

    private String suppName;

    private String suppCode;

    private String sellModel;

    private Integer suppId;

    private BigDecimal taxSumPrice = BigDecimal.ZERO;

    private BigDecimal notaxSumPrice= BigDecimal.ZERO;

    private BigDecimal yTaxSumPrice= BigDecimal.ZERO;

    private BigDecimal yNotaxSumPrice= BigDecimal.ZERO;

    private String whinBillCode;

    private Integer whinBillId;

    private Date orderComDate;

    private String comCode;

    private String comName;

    private Integer comClassId;

    private String comSpec;

    private String comBarcode;

    private String comUnit;

    private BigDecimal orderCount= BigDecimal.ZERO;

    private BigDecimal giftCount= BigDecimal.ZERO;

    private BigDecimal yOrderCount= BigDecimal.ZERO;

    private BigDecimal yGiftCount= BigDecimal.ZERO;

    private String oneClassName;

    private String twoClassName;

    private String threeClassName;

    private  BigDecimal taxPchsPrice =BigDecimal.ZERO;

    private  BigDecimal notaxPchsPrice = BigDecimal.ZERO;

    private BigDecimal costAmount = BigDecimal.ZERO;

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public BigDecimal getTaxPchsPrice() {
        return taxPchsPrice;
    }

    public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
        this.taxPchsPrice = taxPchsPrice;
    }

    public BigDecimal getNotaxPchsPrice() {
        return notaxPchsPrice;
    }

    public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
        this.notaxPchsPrice = notaxPchsPrice;
    }

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }


    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(BigDecimal giftCount) {
        this.giftCount = giftCount;
    }

    public BigDecimal getyOrderCount() {
        return yOrderCount;
    }

    public void setyOrderCount(BigDecimal yOrderCount) {
        this.yOrderCount = yOrderCount;
    }

    public BigDecimal getyGiftCount() {
        return yGiftCount;
    }

    public void setyGiftCount(BigDecimal yGiftCount) {
        this.yGiftCount = yGiftCount;
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

    public Date getOrderComDate() {
        return orderComDate;
    }

    public void setOrderComDate(Date orderComDate) {
        this.orderComDate = orderComDate;
    }

    private ModelPagedList modelPagedList=new ModelPagedList();


    public ModelPagedList getModelPagedList() {
        return modelPagedList;
    }

    public void setModelPagedList(ModelPagedList modelPagedList) {
        this.modelPagedList = modelPagedList;
    }

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
    }

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
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

    public BigDecimal getTaxSumPrice() {
        return taxSumPrice;
    }

    public void setTaxSumPrice(BigDecimal taxSumPrice) {
        this.taxSumPrice = taxSumPrice;
    }

    public BigDecimal getNotaxSumPrice() {
        return notaxSumPrice;
    }

    public void setNotaxSumPrice(BigDecimal notaxSumPrice) {
        this.notaxSumPrice = notaxSumPrice;
    }

    public BigDecimal getyTaxSumPrice() {
        return yTaxSumPrice;
    }

    public void setyTaxSumPrice(BigDecimal yTaxSumPrice) {
        this.yTaxSumPrice = yTaxSumPrice;
    }

    public BigDecimal getyNotaxSumPrice() {
        return yNotaxSumPrice;
    }

    public void setyNotaxSumPrice(BigDecimal yNotaxSumPrice) {
        this.yNotaxSumPrice = yNotaxSumPrice;
    }
}
