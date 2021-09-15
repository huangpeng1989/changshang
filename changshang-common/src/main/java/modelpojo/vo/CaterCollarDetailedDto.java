package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CaterCollarDetailedDto implements Serializable {

    private String rcptEmp;//领用人

    private String rcptDept;//领用部门

    private String whName;//仓库名称

    private String whCode;//仓库编号

    private Date rcptTime;

    private String rcptBillCode;

    private String orgName;

    private String rmCode;

    private String rmName;

    private String specCode;

    private String rmUnitName;

    private BigDecimal rcptOutCount;//领用数量

    private BigDecimal taxCost;//领用含税成本价总计

    private BigDecimal taxCostAmount;// 领用含税成本金额

    private String rmCodeNameOne;

    private String rmCodeNameSend;

    private String rmCodeNameThree;

    private Long rcptDeptId;

    private Long rcptEmpId;

    private String goodType;

    private String taxName;

    private BigDecimal notaxCost;

    private BigDecimal notaxCostAmount;

    //页面传值使用
    private String rcptDate;//领用日期

    private String rmClassCode;

    private Long orgId;

    //预估含税成本价格
    private BigDecimal taxcostPrice;

    //预估未税成本价格
    private BigDecimal notaxcostPrice;

    private Integer rmId;

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public BigDecimal getTaxcostPrice() {
        return taxcostPrice;
    }

    public void setTaxcostPrice(BigDecimal taxcostPrice) {
        this.taxcostPrice = taxcostPrice;
    }

    public BigDecimal getNotaxcostPrice() {
        return notaxcostPrice;
    }

    public void setNotaxcostPrice(BigDecimal notaxcostPrice) {
        this.notaxcostPrice = notaxcostPrice;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

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

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Date getRcptTime() {
        return rcptTime;
    }

    public void setRcptTime(Date rcptTime) {
        this.rcptTime = rcptTime;
    }

    public String getRcptBillCode() {
        return rcptBillCode;
    }

    public void setRcptBillCode(String rcptBillCode) {
        this.rcptBillCode = rcptBillCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
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

    public String getRmCodeNameOne() {
        return rmCodeNameOne;
    }

    public void setRmCodeNameOne(String rmCodeNameOne) {
        this.rmCodeNameOne = rmCodeNameOne;
    }

    public String getRmCodeNameSend() {
        return rmCodeNameSend;
    }

    public void setRmCodeNameSend(String rmCodeNameSend) {
        this.rmCodeNameSend = rmCodeNameSend;
    }

    public String getRmCodeNameThree() {
        return rmCodeNameThree;
    }

    public void setRmCodeNameThree(String rmCodeNameThree) {
        this.rmCodeNameThree = rmCodeNameThree;
    }

    public Long getRcptDeptId() {
        return rcptDeptId;
    }

    public void setRcptDeptId(Long rcptDeptId) {
        this.rcptDeptId = rcptDeptId;
    }

    public Long getRcptEmpId() {
        return rcptEmpId;
    }

    public void setRcptEmpId(Long rcptEmpId) {
        this.rcptEmpId = rcptEmpId;
    }

    public String getRcptDate() {
        return rcptDate;
    }

    public void setRcptDate(String rcptDate) {
        this.rcptDate = rcptDate;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }
}
