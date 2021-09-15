package modelpojo.vo;


import modelpojo.model.WareJurisdictionInfoModel;

import java.io.Serializable;
import java.util.List;

public class WareJurisdictionInfoVo implements Serializable {


    private Integer whId;

    private Integer jurisdictionId;

    private List<WareJurisdictionInfoModel> wareJurisdictionInfoList;

    private List<Integer> whIds;

    private List<String> accountIds;

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<Integer> getWhIds() {
        return whIds;
    }

    public void setWhIds(List<Integer> whIds) {
        this.whIds = whIds;
    }

    public List<WareJurisdictionInfoModel> getWareJurisdictionInfoList() {
        return wareJurisdictionInfoList;
    }

    public void setWareJurisdictionInfoList(List<WareJurisdictionInfoModel> wareJurisdictionInfoList) {
        this.wareJurisdictionInfoList = wareJurisdictionInfoList;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(Integer jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
    }
}
