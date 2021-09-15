package modelpojo.vo;

import modelpojo.model.CateringTcjAdjustDetail;

import java.util.Date;

public class AdjustVo extends CateringTcjAdjustDetail {

    private Integer adjStatus;

    private Date endDate;

    private String adjCode;

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
