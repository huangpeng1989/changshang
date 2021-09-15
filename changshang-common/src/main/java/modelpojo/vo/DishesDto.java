package modelpojo.vo;

import modelpojo.model.*;

import java.math.BigDecimal;
import java.util.List;

public class DishesDto extends CateringTcbDishesModel {
    private String dishClassName;

    private String dishClassCode;

    private String typeName;

    private String unitName;

    private String dishSpecs;

    private String nickName;

    private String taxName;

    private String suppName;

    private Integer goodType;//类型

    private String sellModelName;//经营方式名称

    // 一级分类名称
    private String cateClassNameOne;

    // 二级分类名称
    private String cateClassNameTwo;

    // 三级分类名称
    private String cateClassNameThree;

    private String statusName;//状态中文名称

    private BigDecimal mealPrice;//套餐价格（导出excel用）

    private String specStr;//成品规格价格

    private String taste;//口味

    private String isBom;//是否存在BOM

    private String isAll;//分类是否查全部

    public String getIsAll() {
        return isAll;
    }

    public void setIsAll(String isAll) {
        this.isAll = isAll;
    }

    public String getIsBom() {
        return isBom;
    }

    public void setIsBom(String isBom) {
        this.isBom = isBom;
    }

    public String getSpecStr() {
        return specStr;
    }

    public void setSpecStr(String specStr) {
        this.specStr = specStr;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public BigDecimal getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(BigDecimal mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public String getCateClassNameOne() {
        return cateClassNameOne;
    }

    public void setCateClassNameOne(String cateClassNameOne) {
        this.cateClassNameOne = cateClassNameOne;
    }

    public String getCateClassNameTwo() {
        return cateClassNameTwo;
    }

    public void setCateClassNameTwo(String cateClassNameTwo) {
        this.cateClassNameTwo = cateClassNameTwo;
    }

    public String getCateClassNameThree() {
        return cateClassNameThree;
    }

    public void setCateClassNameThree(String cateClassNameThree) {
        this.cateClassNameThree = cateClassNameThree;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    //菜品组合信息合计字段返回前端展示的三个字段
    private BigDecimal originalPriceTotal;//预估价格合计

    private BigDecimal packagePriceTotal;//套餐价格合计

    private String zoomClassCode;//组合分类编号

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getZoomClassCode() {
        return zoomClassCode;
    }

    public void setZoomClassCode(String zoomClassCode) {
        this.zoomClassCode = zoomClassCode;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getOriginalPriceTotal() {
        return originalPriceTotal;
    }

    public void setOriginalPriceTotal(BigDecimal originalPriceTotal) {
        this.originalPriceTotal = originalPriceTotal;
    }

    public BigDecimal getPackagePriceTotal() {
        return packagePriceTotal;
    }

    public void setPackagePriceTotal(BigDecimal packagePriceTotal) {
        this.packagePriceTotal = packagePriceTotal;
    }



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    List<CateringTcbDishGroupModel> dishGroupModel;//套餐

    List<CateringTcbDishTasteModel> dishTasteModels;//口味

    List<CateringTcbDishSpecModel> dishSpecModels;//规格类型

    List<CateringTcbDishimgsModel> dishimgsModels;//图片信息

    List<DishGroupDto> dishGroupDtos;//套餐组合信息

    CateringDishPoolRelationModel poolRelationModel;//联营供应商信息

    public CateringDishPoolRelationModel getPoolRelationModel() {
        return poolRelationModel;
    }

    public void setPoolRelationModel(CateringDishPoolRelationModel poolRelationModel) {
        this.poolRelationModel = poolRelationModel;
    }

    public List<DishGroupDto> getDishGroupDtos() {
        return dishGroupDtos;
    }

    public void setDishGroupDtos(List<DishGroupDto> dishGroupDtos) {
        this.dishGroupDtos = dishGroupDtos;
    }

    public List<CateringTcbDishimgsModel> getDishimgsModels() {
        return dishimgsModels;
    }

    public void setDishimgsModels(List<CateringTcbDishimgsModel> dishimgsModels) {
        this.dishimgsModels = dishimgsModels;
    }

    public List<CateringTcbDishSpecModel> getDishSpecModels() {
        return dishSpecModels;
    }

    public void setDishSpecModels(List<CateringTcbDishSpecModel> dishSpecModels) {
        this.dishSpecModels = dishSpecModels;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<CateringTcbDishTasteModel> getDishTasteModels() {
        return dishTasteModels;
    }

    public void setDishTasteModels(List<CateringTcbDishTasteModel> dishTasteModels) {
        this.dishTasteModels = dishTasteModels;
    }

    public List<CateringTcbDishGroupModel> getDishGroupModel() {
        return dishGroupModel;
    }

    public void setDishGroupModel(List<CateringTcbDishGroupModel> dishGroupModel) {
        this.dishGroupModel = dishGroupModel;
    }

    public String getDishSpecs() {
        return dishSpecs;
    }

    public void setDishSpecs(String dishSpecs) {
        this.dishSpecs = dishSpecs;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }
}
