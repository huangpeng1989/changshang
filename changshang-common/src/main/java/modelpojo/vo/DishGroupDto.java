package modelpojo.vo;

import modelpojo.model.CateringTcbDishGroupModel;

import java.math.BigDecimal;
import java.util.List;

public class DishGroupDto extends CateringTcbDishGroupModel {
    private String dishName;

    private String dishCode;

    private String typeName;

    private String unitName;

    private BigDecimal retailPrice;

    List<DishExchangeDto> dishExchangeDtos;

    private String dictTpValue;

    public String getDictTpValue() {
        return dictTpValue;
    }

    public void setDictTpValue(String dictTpValue) {
        this.dictTpValue = dictTpValue;
    }

    public List<DishExchangeDto> getDishExchangeDtos() {
        return dishExchangeDtos;
    }

    public void setDishExchangeDtos(List<DishExchangeDto> dishExchangeDtos) {
        this.dishExchangeDtos = dishExchangeDtos;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
