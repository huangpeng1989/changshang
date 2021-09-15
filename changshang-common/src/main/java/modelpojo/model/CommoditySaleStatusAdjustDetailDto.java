package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品销售状态扩展表
 */
public class CommoditySaleStatusAdjustDetailDto extends CommoditySaleStatusAdjustDetail implements Serializable{

    //库存数量
    private BigDecimal whStock;

    private String modifierName;

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }
}