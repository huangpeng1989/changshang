package modelpojo.model;

import java.io.Serializable;

/**
 * 菜品扣率调价表
 */
public class CateringDishesRateAdjustVo extends CateringDishesRateAdjust implements Serializable{

    private String modifierName;

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }
}