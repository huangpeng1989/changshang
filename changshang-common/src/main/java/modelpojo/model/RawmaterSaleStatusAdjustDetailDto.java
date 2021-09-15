package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 原材料销售状态调价表子表
 */
public class RawmaterSaleStatusAdjustDetailDto extends RawmaterSaleStatusAdjustDetail  implements Serializable{

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