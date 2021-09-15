package modelpojo.vo;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CollarDetailedDto implements Serializable {

    private String rcptEmp;//领用人

    private String rcptDept;//领用部门

    private String whName;//仓库名称
    private String whCode;//仓库编号

    private Date rcptTime;//领用时间

    private String rcptBillCode;//领用单编号

    private Long orgId;

    private String comCode;//商品编号

    private String comName;//商品名称

    private String comSpec;//规格

    private String comUnitName;//单位

    private BigDecimal rcptOutCount;//领用数量

    private BigDecimal taxCost;//领用含税成本价总计

    private BigDecimal taxCostAmount;// 领用含税成本金额

    private String comCodeNameOne;//分类1

    private String comCodeNameSend;//分类2

    private String comCodeNameThree;//分类2

    private Long rcptDeptId;//领用部门Id

    private Long rcptEmpId;//领用人ID

    private String orgName;//景区名称

    private String taxName;//税率

    private BigDecimal notaxCost;

    private BigDecimal notaxCostAmount;

    //页面传值使用
    private String rcptDate;//领用日期

    private String comClassCode;

    private Integer comId;

    //预估含税成本价格
    private BigDecimal taxcostPrice;

    //预估未税成本价格
    private BigDecimal notaxcostPrice;

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

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
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

    public String getComCodeNameOne() {
        return comCodeNameOne;
    }

    public void setComCodeNameOne(String comCodeNameOne) {
        this.comCodeNameOne = comCodeNameOne;
    }

    public String getComCodeNameSend() {
        return comCodeNameSend;
    }

    public void setComCodeNameSend(String comCodeNameSend) {
        this.comCodeNameSend = comCodeNameSend;
    }

    public String getComCodeNameThree() {
        return comCodeNameThree;
    }

    public void setComCodeNameThree(String comCodeNameThree) {
        this.comCodeNameThree = comCodeNameThree;
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

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }
}
