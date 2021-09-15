package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceTypeVo implements Serializable {

    private Integer dictId;//菜品id

    private BigDecimal dictSpecPrice;//价格

    private Integer sellPointId;//营业点id

    private Integer dishDictSpecId;//规格表id

    public Integer getDishDictSpecId() {
        return dishDictSpecId;
    }

    public void setDishDictSpecId(Integer dishDictSpecId) {
        this.dishDictSpecId = dishDictSpecId;
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public BigDecimal getDictSpecPrice() {
        return dictSpecPrice;
    }

    public void setDictSpecPrice(BigDecimal dictSpecPrice) {
        this.dictSpecPrice = dictSpecPrice;
    }
}