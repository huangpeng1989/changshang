package modelpojo.vo;

import modelpojo.model.CommodityTcjAdjustDetail;


public class CommoAdjustVo extends CommodityTcjAdjustDetail {

    private String adjStatus;

    private String startDate;

    private String endDate;

    private String adjType;

    private String sellModelStr;

    public String getSellModelStr() {
        return sellModelStr;
    }

    public void setSellModelStr(String sellModelStr) {
        this.sellModelStr = sellModelStr;
    }

    public String getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(String adjStatus) {
        this.adjStatus = adjStatus;
    }

    public String getAdjType() {
        return adjType;
    }

    public void setAdjType(String adjType) {
        this.adjType = adjType;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
