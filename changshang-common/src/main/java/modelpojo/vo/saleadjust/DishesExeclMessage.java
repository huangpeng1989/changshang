package modelpojo.vo.saleadjust;

import modelpojo.vo.DishesDto;

import java.io.Serializable;

/**
 * @Description 原材料预导入提示
 * @Author wenbin.wang
 * @Date 2020-05-22 10:09
 */
public class DishesExeclMessage implements Serializable {
    private static final long serialVersionUID = 544994082653878606L;

    private String typeName;

    private String unitName;

    private String taxName;

    private String sellModelName;//经营方式名称

    private String dishName;

    private DishesDto dishesDto;
    // 导入结果
    private String  flag;
    private int  type;

    //问题原因
    private String  message;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public DishesDto getDishesDto() {
        return dishesDto;
    }

    public void setDishesDto(DishesDto dishesDto) {
        this.dishesDto = dishesDto;
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

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }


    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }



    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
