package modelpojo.model;

import java.io.Serializable;

/**
 * 原材料销售状态调价表
 */
public class RawmaterSaleStatusAdjustDetailVo extends RawmaterSaleStatusAdjust  implements Serializable{

    private String modifierName;

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }


}