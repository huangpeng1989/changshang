package modelpojo.vo;



import modelpojo.model.CateringTcbCookHouseModel;

import java.util.List;

public class CookHouseDto extends CateringTcbCookHouseModel {
    private String dishName;

    private String gzoneName;

    private String gzoneCode;

    private String dictTpName;

    private String typeName;

    private List<DishesVo> detailModels;

    private String cookHouseIds;

    public String getCookHouseIds() {
        return cookHouseIds;
    }

    public void setCookHouseIds(String cookHouseIds) {
        this.cookHouseIds = cookHouseIds;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<DishesVo> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<DishesVo> detailModels) {
        this.detailModels = detailModels;
    }

    public String getDictTpName() {
        return dictTpName;
    }

    public void setDictTpName(String dictTpName) {
        this.dictTpName = dictTpName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
