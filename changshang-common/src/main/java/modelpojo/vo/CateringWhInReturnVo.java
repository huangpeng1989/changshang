package modelpojo.vo;
;

import modelpojo.model.CateringWhInReturn;
import modelpojo.model.CateringWhInReturnDtl;

import java.util.List;

public class CateringWhInReturnVo extends CateringWhInReturn {

    private List<CateringWhInReturnDtl> whInReturnDtlList;

    private String realWhinDate;  //实际入库日期


    private String orderComDate;  //订货日期
    private String blEmpName;  //审核人
    private String paymentName;

    private Integer jurisdictionType = 0;//权限类型

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

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getBlEmpName() {
        return blEmpName;
    }

    public void setBlEmpName(String blEmpName) {
        this.blEmpName = blEmpName;
    }

    public String getRealWhinDate() {
        return realWhinDate;
    }

    public void setRealWhinDate(String realWhinDate) {
        this.realWhinDate = realWhinDate;
    }

    public String getOrderComDate() {
        return orderComDate;
    }

    public void setOrderComDate(String orderComDate) {
        this.orderComDate = orderComDate;
    }

    public List<CateringWhInReturnDtl> getWhInReturnDtlList() {
        return whInReturnDtlList;
    }

    public void setWhInReturnDtlList(List<CateringWhInReturnDtl> whInReturnDtlList) {
        this.whInReturnDtlList = whInReturnDtlList;
    }





}
