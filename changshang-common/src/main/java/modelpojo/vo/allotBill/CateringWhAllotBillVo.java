package modelpojo.vo.allotBill;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *调拨出库申请/确认单
 */
public class CateringWhAllotBillVo extends CateringWhAllotBill {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date outStartTime;//调出开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date outEndTime;//调出结束时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date inStartTime;//调出开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date inEndTime;//调出结束时间

    private String selectType;//查询类型  0调出申请单   1调入申请单

    private String commList;// 商品数据

    private Integer inStatus;//调入仓库盘点状态

    private Integer outStatus;//调出仓库盘点状态


    private String aplBillCode;//要货单号

    //调入仓库
    private String inWhName;

    //权限仓库
    private Integer whId;

    private Integer jurisdictionType = 0;//权限类型

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


    @Override
    public String getInWhName() {
        return inWhName;
    }

    public void setInWhName(String inWhName) {
        this.inWhName = inWhName;
    }

    public String getAplBillCode() {
        return aplBillCode;
    }

    public void setAplBillCode(String aplBillCode) {
        this.aplBillCode = aplBillCode;
    }

    @Override
    public Integer getInStatus() {
        return inStatus;
    }

    @Override
    public void setInStatus(Integer inStatus) {
        this.inStatus = inStatus;
    }

    @Override
    public Integer getOutStatus() {
        return outStatus;
    }

    @Override
    public void setOutStatus(Integer outStatus) {
        this.outStatus = outStatus;
    }

    public String getCommList() {
        return commList;
    }

    public void setCommList(String commList) {
        this.commList = commList;
    }

    public Date getOutStartTime() {
        return outStartTime;
    }

    public void setOutStartTime(Date outStartTime) {
        this.outStartTime = outStartTime;
    }

    public Date getOutEndTime() {
        return outEndTime;
    }

    public void setOutEndTime(Date outEndTime) {
        this.outEndTime = outEndTime;
    }

    public Date getInStartTime() {
        return inStartTime;
    }

    public void setInStartTime(Date inStartTime) {
        this.inStartTime = inStartTime;
    }

    public Date getInEndTime() {
        return inEndTime;
    }

    public void setInEndTime(Date inEndTime) {
        this.inEndTime = inEndTime;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }
}