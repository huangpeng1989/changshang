package modelpojo.vo.CaterSemibillReportFrom;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-02-20 12:34
 */
public class CaterSemibillReportFromVo implements Serializable {

    private String orgName; // 景区名称

    private String whName; //仓库名称

    private String dishName; //半成品名称

    private String spdtBillCode; //加工单号

    private String createdTime; //时间

    private String dishUnitName; //半成品单位

    private Integer processNum; //加工数量

    private String packer; //包装人

    private String cooker;// 厨师

    private String rmcode;//原材料编号

    private String rmName;//原材料名称

    private String rmUnitName; //原材料单位

    private BigDecimal oldCostSumcount; //原成本

    private BigDecimal costSumcount; //调整后成本
    private BigDecimal lossCount; //偏差系数

    public BigDecimal getLossCount() {
        return lossCount;
    }

    public void setLossCount(BigDecimal lossCount) {
        this.lossCount = lossCount;
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

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getSpdtBillCode() {
        return spdtBillCode;
    }

    public void setSpdtBillCode(String spdtBillCode) {
        this.spdtBillCode = spdtBillCode;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public Integer getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }

    public String getPacker() {
        return packer;
    }

    public void setPacker(String packer) {
        this.packer = packer;
    }

    public String getCooker() {
        return cooker;
    }

    public void setCooker(String cooker) {
        this.cooker = cooker;
    }

    public String getRmcode() {
        return rmcode;
    }

    public void setRmcode(String rmcode) {
        this.rmcode = rmcode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public BigDecimal getOldCostSumcount() {
        return oldCostSumcount;
    }

    public void setOldCostSumcount(BigDecimal oldCostSumcount) {
        this.oldCostSumcount = oldCostSumcount;
    }

    public BigDecimal getCostSumcount() {
        return costSumcount;
    }

    public void setCostSumcount(BigDecimal costSumcount) {
        this.costSumcount = costSumcount;
    }
}
