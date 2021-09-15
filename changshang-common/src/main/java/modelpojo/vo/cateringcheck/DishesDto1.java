package modelpojo.vo.cateringcheck;

import java.math.BigDecimal;
import java.util.List;


import modelpojo.model.*;
import modelpojo.vo.DishGroupDto;

public class DishesDto1 extends CateringTcbDishesModel {
    private String dishClassName;

    private String dishClassCode;

    private String typeName;

    private String unitName;

    private String dishSpecs;

    private String nickName;

    private String taxName;

    //菜品组合信息合计字段返回前端展示的三个字段
    private BigDecimal originalPriceTotal;//预估价格合计

    private BigDecimal packagePriceTotal;//套餐价格合计

    private String zoomClassCode;//组合分类编号
    
    /**
     * 仓库id
     */
    private Integer whId;
    
    public Integer getWhId() {
		return whId;
	}

	public void setWhId(Integer whId) {
		this.whId = whId;
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
