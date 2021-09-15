package modelpojo.model;

import java.io.Serializable;

/**
 * 商品销售状态调价表
 */
public class CommoditySaleStatusAdjustVo  extends CommoditySaleStatusAdjust implements Serializable{

    private String modifierName;

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }


}