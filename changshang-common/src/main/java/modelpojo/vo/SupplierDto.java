package modelpojo.vo;

import modelpojo.model.CommodityTcbSupplierModel;

public class SupplierDto extends CommodityTcbSupplierModel {
    private String dictTpValue;

    private String suppClassName;

    private String nickName;

    private String zoomClassCode;

    private String province;

    private String city;

    private String area;

    private String statusName;

    private String taxName;

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZoomClassCode() {
        return zoomClassCode;
    }

    public void setZoomClassCode(String zoomClassCode) {
        this.zoomClassCode = zoomClassCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSuppClassName() {
        return suppClassName;
    }

    public void setSuppClassName(String suppClassName) {
        this.suppClassName = suppClassName;
    }

    public String getDictTpValue() {
        return dictTpValue;
    }

    public void setDictTpValue(String dictTpValue) {
        this.dictTpValue = dictTpValue;
    }
}
