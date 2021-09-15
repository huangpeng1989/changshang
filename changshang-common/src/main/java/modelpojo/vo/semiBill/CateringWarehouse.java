package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringWarehouse implements Serializable {

    private Integer rmDishId;//原材料id

    private BigDecimal whStock;//库存数

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }
}