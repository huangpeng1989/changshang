package modelpojo.vo;

import modelpojo.model.CommodityTcbSalecom;

import java.io.Serializable;


/**
 * 商品销售商品扩展表
 */
public class CommodityTcbSalecomVo extends CommodityTcbSalecom implements Serializable {

    //日志标识
    private String flagType;

    //销售商品单位名称
    private String saleCommUnitName;

    public String getSaleCommUnitName() {
        return saleCommUnitName;
    }

    public void setSaleCommUnitName(String saleCommUnitName) {
        this.saleCommUnitName = saleCommUnitName;
    }

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }


}
