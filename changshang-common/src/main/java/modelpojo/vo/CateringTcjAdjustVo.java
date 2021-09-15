package modelpojo.vo;

import modelpojo.model.CateringTcjAdjust;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-11-21 11:19
 */
public class CateringTcjAdjustVo extends CateringTcjAdjust {

    private String createrStr;
    private String adjStatusStr;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAdjStatusStr() {
        return adjStatusStr;
    }

    public void setAdjStatusStr(String adjStatusStr) {
        this.adjStatusStr = adjStatusStr;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }


}
