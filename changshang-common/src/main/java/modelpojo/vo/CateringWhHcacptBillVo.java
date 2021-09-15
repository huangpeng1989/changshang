package modelpojo.vo;

import modelpojo.model.CateringWhHcacptBill;

public class CateringWhHcacptBillVo extends CateringWhHcacptBill {

    private Integer jurisdictionType = 0;//权限类型

    private Integer whId;

    private String suppName;//供应商名称

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

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

}
