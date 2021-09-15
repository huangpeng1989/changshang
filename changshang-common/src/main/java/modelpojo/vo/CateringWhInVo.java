package modelpojo.vo;

import modelpojo.model.CateringWhIn;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-09 10:40
 */
public class CateringWhInVo extends CateringWhIn {

    private String provinceName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    private String cityName;
    private String areaName;

    private String orgName;

    private Integer jurisdictionType = 0;//权限类型

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
