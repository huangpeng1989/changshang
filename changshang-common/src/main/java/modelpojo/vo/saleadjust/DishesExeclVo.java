package modelpojo.vo.saleadjust;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * @Description 菜品Execl实体类
 * @Author lixiang
 * @Date 2020-11-27 15:14
 */
public class DishesExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*菜品分类",type = HeadProperty.HeadType.STRING)
    private String dishClassCode;

    @HeadProperty(name="*菜品名称",type = HeadProperty.HeadType.STRING)
    private String dishName;

    @HeadProperty(name="*预估价格",type = HeadProperty.HeadType.STRING)
    private String  retailPrice;

    @HeadProperty(name="*菜品单位",type = HeadProperty.HeadType.STRING)
    private String  dishUnit;

    @HeadProperty(name="*销项税税率",type = HeadProperty.HeadType.STRING)
    private String  saleTaxId;

    @HeadProperty(name="条码",type = HeadProperty.HeadType.STRING)
    private String  barCode;

    @HeadProperty(name="包装费",type = HeadProperty.HeadType.STRING)
    private String  packCost;

    @HeadProperty(name="*经营方式",type = HeadProperty.HeadType.STRING)
    private String sellModel;

    @HeadProperty(name="联营扣率",type = HeadProperty.HeadType.STRING)
    private String discountRate;

    @HeadProperty(name="联营合同编号",type = HeadProperty.HeadType.STRING)
    private String contractCode;

    @HeadProperty(name="标准成本率",type = HeadProperty.HeadType.STRING)
    private String standardCostRate;

    @HeadProperty(name="口味类别",type = HeadProperty.HeadType.STRING)
    private String dishTasteType;

    @HeadProperty(name="口味名称",type = HeadProperty.HeadType.STRING)
    private String dishTasteName;

    @HeadProperty(name="备注",type = HeadProperty.HeadType.STRING)
    private String remark;

    public String getStandardCostRate() {
        return standardCostRate;
    }

    public void setStandardCostRate(String standardCostRate) {
        this.standardCostRate = standardCostRate;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getSaleTaxId() {
        return saleTaxId;
    }

    public void setSaleTaxId(String saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPackCost() {
        return packCost;
    }

    public void setPackCost(String packCost) {
        this.packCost = packCost;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getDishTasteType() {
        return dishTasteType;
    }

    public void setDishTasteType(String dishTasteType) {
        this.dishTasteType = dishTasteType;
    }

    public String getDishTasteName() {
        return dishTasteName;
    }

    public void setDishTasteName(String dishTasteName) {
        this.dishTasteName = dishTasteName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
