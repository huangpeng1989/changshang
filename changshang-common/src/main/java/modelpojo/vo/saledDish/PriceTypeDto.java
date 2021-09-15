package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceTypeDto implements Serializable {



    private Integer dictId;//菜品id

    private BigDecimal dictSpecPrice;//价格

    private BigDecimal retailPrice;//规格表价格

    private Integer dishDictSpecId;//规格表主键id

    private Integer specId;//字典表

    private String dictTpCode;

    private String dictTpValue;

    private Integer dishDetailPriceId;//价格表主键id

    public Integer getDishDetailPriceId() {
        return dishDetailPriceId;
    }

    public void setDishDetailPriceId(Integer dishDetailPriceId) {
        this.dishDetailPriceId = dishDetailPriceId;
    }

    public String getDictTpCode() {
        return dictTpCode;
    }

    public void setDictTpCode(String dictTpCode) {
        this.dictTpCode = dictTpCode;
    }

    public String getDictTpValue() {
        return dictTpValue;
    }

    public void setDictTpValue(String dictTpValue) {
        this.dictTpValue = dictTpValue;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getDishDictSpecId() {
        return dishDictSpecId;
    }

    public void setDishDictSpecId(Integer dishDictSpecId) {
        this.dishDictSpecId = dishDictSpecId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
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