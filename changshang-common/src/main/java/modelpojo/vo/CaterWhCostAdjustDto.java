package modelpojo.vo;

import modelpojo.model.CateringWhCostAdjust;

public class CaterWhCostAdjustDto extends CateringWhCostAdjust {
    private String nickName;

    private String statusName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
