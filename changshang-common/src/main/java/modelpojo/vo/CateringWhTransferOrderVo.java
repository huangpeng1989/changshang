package modelpojo.vo;


import modelpojo.model.CateringWhTransferOrder;

import java.util.List;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-04-24 09:36
 */
public class CateringWhTransferOrderVo extends CateringWhTransferOrder {


    private String statusStr;
    private String empName;
    private String blEmpName;
    private String createrStr;
    private String whName;

    private Integer jurisdictionType=0;

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    private List<CateringWhTransferOrderVo> transferOrderVoList;

    public String getBlEmpName() {
        return blEmpName;
    }

    public void setBlEmpName(String blEmpName) {
        this.blEmpName = blEmpName;
    }

    public List<CateringWhTransferOrderVo> getTransferOrderVoList() {
        return transferOrderVoList;
    }

    public void setTransferOrderVoList(List<CateringWhTransferOrderVo> transferOrderVoList) {
        this.transferOrderVoList = transferOrderVoList;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

}
