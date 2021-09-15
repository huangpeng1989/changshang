package modelpojo.vo;


import modelpojo.model.CommodityWhRcptRtnBillDtlModel;
import modelpojo.model.CommodityWhRcptRtnBillModel;

import java.util.List;

public class CollarUseDto extends CommodityWhRcptRtnBillModel {
    private String rcptStatusName;//领用状态

    private String rtnStatusName;//归还状态

    private String rcptEmp;//领用人

    private String rtnEmp;//归还人

    private String rcptDept;//领用部门

    private String rtnDept;//归还部门

    private String rcptNickName;//领用录入人

    private String rtnNickName;//归还录入人

    private String whName;//仓库名称

    private String rcptCreaterName;

    private String rtnCreaterName;

    private String rcptBlEmp;

    private String rtnBlEmp;

    private String ivtStatusName;//仓库状态

    private Integer jurisdictionType;//权限类型

    private Integer whId;

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;//查询仓库状态条件

    public String getIvtStatusName() {
        return ivtStatusName;
    }

    public void setIvtStatusName(String ivtStatusName) {
        this.ivtStatusName = ivtStatusName;
    }

    public String getRcptCreaterName() {
        return rcptCreaterName;
    }

    public void setRcptCreaterName(String rcptCreaterName) {
        this.rcptCreaterName = rcptCreaterName;
    }

    public String getRtnCreaterName() {
        return rtnCreaterName;
    }

    public void setRtnCreaterName(String rtnCreaterName) {
        this.rtnCreaterName = rtnCreaterName;
    }

    public String getRcptBlEmp() {
        return rcptBlEmp;
    }

    public void setRcptBlEmp(String rcptBlEmp) {
        this.rcptBlEmp = rcptBlEmp;
    }

    public String getRtnBlEmp() {
        return rtnBlEmp;
    }

    public void setRtnBlEmp(String rtnBlEmp) {
        this.rtnBlEmp = rtnBlEmp;
    }

    //页面传值使用
    private String rcptDate;//领用日期

    private String rtnDate;//归还日期

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getRcptDate() {
        return rcptDate;
    }

    public void setRcptDate(String rcptDate) {
        this.rcptDate = rcptDate;
    }

    public String getRtnDate() {
        return rtnDate;
    }

    public void setRtnDate(String rtnDate) {
        this.rtnDate = rtnDate;
    }

    private List<CommodityWhRcptRtnBillDtlModel> detailModels;

    public List<CommodityWhRcptRtnBillDtlModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<CommodityWhRcptRtnBillDtlModel> detailModels) {
        this.detailModels = detailModels;
    }

    public String getRcptStatusName() {
        return rcptStatusName;
    }

    public void setRcptStatusName(String rcptStatusName) {
        this.rcptStatusName = rcptStatusName;
    }

    public String getRtnStatusName() {
        return rtnStatusName;
    }

    public void setRtnStatusName(String rtnStatusName) {
        this.rtnStatusName = rtnStatusName;
    }

    public String getRcptEmp() {
        return rcptEmp;
    }

    public void setRcptEmp(String rcptEmp) {
        this.rcptEmp = rcptEmp;
    }

    public String getRtnEmp() {
        return rtnEmp;
    }

    public void setRtnEmp(String rtnEmp) {
        this.rtnEmp = rtnEmp;
    }

    public String getRcptDept() {
        return rcptDept;
    }

    public void setRcptDept(String rcptDept) {
        this.rcptDept = rcptDept;
    }

    public String getRtnDept() {
        return rtnDept;
    }

    public void setRtnDept(String rtnDept) {
        this.rtnDept = rtnDept;
    }

    public String getRcptNickName() {
        return rcptNickName;
    }

    public void setRcptNickName(String rcptNickName) {
        this.rcptNickName = rcptNickName;
    }

    public String getRtnNickName() {
        return rtnNickName;
    }

    public void setRtnNickName(String rtnNickName) {
        this.rtnNickName = rtnNickName;
    }
}
