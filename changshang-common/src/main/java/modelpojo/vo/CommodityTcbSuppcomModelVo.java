package modelpojo.vo;

import modelpojo.model.CommodityTcbSuppcomModel;

import java.io.Serializable;


/**
 * 商品供应商商品扩展表
 */
public class CommodityTcbSuppcomModelVo extends CommodityTcbSuppcomModel implements Serializable {

    //日志标识
    private String flagType;

    //供应商名称
    private String suppName;

    //送货类型
    private String deliveryTypeName;

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }
}
