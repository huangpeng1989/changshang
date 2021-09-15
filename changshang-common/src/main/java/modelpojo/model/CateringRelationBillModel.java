package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringRelationBillModel implements Serializable {

    private Long projectId;

    private Long projectRootId;

    private Integer aplBillDtlId;

    private  Integer aplBillId;

    private  Integer goodType;

    private Integer comId;


    private BigDecimal count;

    private Integer flowType;

    private Integer rmId;

    private String rmCode;

    private String  rmSpec;

    private Integer rmUnit;

    private Integer suppId;

    private String suppCode;

    private BigDecimal orderCount;

    private String rmName;

    private String suppName;

    private String goodTypeName;

    private String rmUnitName;

    private BigDecimal costSumcount;


    //转采购数量
    private String inNum;
    //调出数量
    private String allotNum;

    public String getInNum() {
        return inNum;
    }

    public void setInNum(String inNum) {
        this.inNum = inNum;
    }

    public String getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(String allotNum) {
        this.allotNum = allotNum;
    }

    public BigDecimal getCostSumcount() {
        return costSumcount;
    }

    public void setCostSumcount(BigDecimal costSumcount) {
        this.costSumcount = costSumcount;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getGoodTypeName() {
        return goodTypeName;
    }

    public void setGoodTypeName(String goodTypeName) {
        this.goodTypeName = goodTypeName;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
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

    public Integer getAplBillDtlId() {
        return aplBillDtlId;
    }

    public void setAplBillDtlId(Integer aplBillDtlId) {
        this.aplBillDtlId = aplBillDtlId;
    }

    public Integer getAplBillId() {
        return aplBillId;
    }

    public void setAplBillId(Integer aplBillId) {
        this.aplBillId = aplBillId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
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
        this.rmCode = rmCode;
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }
}
