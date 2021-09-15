package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GatherVo implements Serializable {


    private Date startTime;

    private  Integer index;

    private Integer classId;

    private String  orgName;

    private String whName;

    private String whCode;

    private String oneComClass;

    private String twoComClass;

    private String threeComClass;

    private String jTName;

    private String cmpName;

    private String comName;

    private String comCode;

    private String comSpec;

    private String sellModel;

    private String commUnit;


    private String comType;

    private String phTax;

    private BigDecimal etaxCost;

    private  BigDecimal enotaxCost;

    private BigDecimal etaxCostAmount;

    private  BigDecimal enotaxCostAmount;

    private BigDecimal stockNum;

    private  BigDecimal maxWhCount;

    private BigDecimal minWhCount;

    private Integer pageMaxCount;


    private Integer comCount;

    private String earlyWarning;//预警

    public String getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(String earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Integer getPageMaxCount() {
        return pageMaxCount;
    }

    public void setPageMaxCount(Integer pageMaxCount) {
        this.pageMaxCount = pageMaxCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getOneComClass() {
        return oneComClass;
    }

    public void setOneComClass(String oneComClass) {
        this.oneComClass = oneComClass;
    }

    public String getTwoComClass() {
        return twoComClass;
    }

    public void setTwoComClass(String twoComClass) {
        this.twoComClass = twoComClass;
    }

    public String getThreeComClass() {
        return threeComClass;
    }

    public void setThreeComClass(String threeComClass) {
        this.threeComClass = threeComClass;
    }

    public String getjTName() {
        return jTName;
    }

    public void setjTName(String jTName) {
        this.jTName = jTName;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
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

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public BigDecimal getEtaxCost() {
        return etaxCost;
    }

    public void setEtaxCost(BigDecimal etaxCost) {
        this.etaxCost = etaxCost;
    }

    public BigDecimal getEnotaxCost() {
        return enotaxCost;
    }

    public void setEnotaxCost(BigDecimal enotaxCost) {
        this.enotaxCost = enotaxCost;
    }

    public BigDecimal getEtaxCostAmount() {
        return etaxCostAmount;
    }

    public void setEtaxCostAmount(BigDecimal etaxCostAmount) {
        this.etaxCostAmount = etaxCostAmount;
    }

    public BigDecimal getEnotaxCostAmount() {
        return enotaxCostAmount;
    }

    public void setEnotaxCostAmount(BigDecimal enotaxCostAmount) {
        this.enotaxCostAmount = enotaxCostAmount;
    }

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

    public BigDecimal getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(BigDecimal maxWhCount) {
        this.maxWhCount = maxWhCount;
    }

    public BigDecimal getMinWhCount() {
        return minWhCount;
    }

    public void setMinWhCount(BigDecimal minWhCount) {
        this.minWhCount = minWhCount;
    }
}
