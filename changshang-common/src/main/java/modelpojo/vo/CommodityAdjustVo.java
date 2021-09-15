package modelpojo.vo;


import modelpojo.model.CommodityTcjAdjustDetail;

import java.util.Date;

public class CommodityAdjustVo extends CommodityTcjAdjustDetail {

    private Integer adjStatus;

    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(Integer adjStatus) {
        this.adjStatus = adjStatus;
    }
}
