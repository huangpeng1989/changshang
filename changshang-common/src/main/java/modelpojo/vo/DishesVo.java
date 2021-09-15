package modelpojo.vo;

import modelpojo.model.CateringTcbCookHouseDetailModel;

public class DishesVo extends CateringTcbCookHouseDetailModel {


    private String typeName;//菜品类型名称

    private String specName;//规格

    private Integer dishSpecId;//规格主键ID

    // 一级分类编号
    private String classCodeOne;

    // 二级分类编号
    private String classCodeTwo;

    // 三级分类编号
    private String classCodeThree;


    private String unitName;


    private Integer gzoneId;


    private Integer houseType;

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public String getClassCodeOne() {
        return classCodeOne;
    }

    public void setClassCodeOne(String classCodeOne) {
        this.classCodeOne = classCodeOne;
    }

    public String getClassCodeTwo() {
        return classCodeTwo;
    }

    public void setClassCodeTwo(String classCodeTwo) {
        this.classCodeTwo = classCodeTwo;
    }

    public String getClassCodeThree() {
        return classCodeThree;
    }

    public void setClassCodeThree(String classCodeThree) {
        this.classCodeThree = classCodeThree;
    }
}
