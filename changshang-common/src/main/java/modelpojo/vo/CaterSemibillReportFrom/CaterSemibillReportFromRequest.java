package modelpojo.vo.CaterSemibillReportFrom;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-02-21 14:04
 */
public class CaterSemibillReportFromRequest implements Serializable {

    private Integer whId;

    private Integer dishType;

    private String rmKey;

    private String dishKey;

    private String spdtBillCode;

    private String packer; //包装人

    private String cooker;// 厨师

     private String  startTime; //开始时间

    private  String endTime;// 结束时间


    private  Integer earlyWarning;// 预警

    private Integer pageNo;

    private Integer pageSize;

    private  Long projectId;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getDishKey() {
        return dishKey;
    }

    public void setDishKey(String dishKey) {
        this.dishKey = dishKey;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public String getRmKey() {
        return rmKey;
    }

    public void setRmKey(String rmKey) {
        this.rmKey = rmKey;
    }

    public String getSpdtBillCode() {
        return spdtBillCode;
    }

    public void setSpdtBillCode(String spdtBillCode) {
        this.spdtBillCode = spdtBillCode;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(Integer earlyWarning) {
        this.earlyWarning = earlyWarning;
    }
}
