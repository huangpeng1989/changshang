package modelpojo.model;

import java.io.Serializable;

/**
 * 商品扣率调价表
 */
public class CommodityRateAdjustVo  extends CommodityRateAdjust implements Serializable{

    private String modifierName;

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }
}