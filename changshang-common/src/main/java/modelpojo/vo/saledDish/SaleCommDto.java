package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 供应商表
 */
public class SaleCommDto implements Serializable {


    private String comName;//商品名称

    private String comCode;//商品编号

    private String comClassCode;//商品分类

    private String sellModel;//经营方式

    private String saleComCode;//销售商品编号

    private String comBarcode;//销售商品条码

    private Integer saleComId;//销售商品id

    private BigDecimal retailPrice;//商品零售价

    private Integer comType;//商品类型
    private Integer comType2;//商品类型
    private Integer comType3;//商品类型
    private Integer comType4;//商品类型
    private Integer comType5;//商品类型
    private Integer comType6;//商品类型
    private Integer comType7;//商品类型
    private Integer comType8;//商品类型
    private Integer comType9;//商品类型
    private Integer comType10;//商品类型
    private Integer comType11;//商品类型

    private Integer comUnit;//单位


    public Integer getComType() {
        return comType;
    }

    public void setComType(Integer comType) {
        this.comType = comType;
    }

    public Integer getComType2() {
        return comType2;
    }

    public void setComType2(Integer comType2) {
        this.comType2 = comType2;
    }

    public Integer getComType3() {
        return comType3;
    }

    public void setComType3(Integer comType3) {
        this.comType3 = comType3;
    }

    public Integer getComType4() {
        return comType4;
    }

    public void setComType4(Integer comType4) {
        this.comType4 = comType4;
    }

    public Integer getComType5() {
        return comType5;
    }

    public void setComType5(Integer comType5) {
        this.comType5 = comType5;
    }

    public Integer getComType6() {
        return comType6;
    }

    public void setComType6(Integer comType6) {
        this.comType6 = comType6;
    }

    public Integer getComType7() {
        return comType7;
    }

    public void setComType7(Integer comType7) {
        this.comType7 = comType7;
    }

    public Integer getComType8() {
        return comType8;
    }

    public void setComType8(Integer comType8) {
        this.comType8 = comType8;
    }

    public Integer getComType9() {
        return comType9;
    }

    public void setComType9(Integer comType9) {
        this.comType9 = comType9;
    }

    public Integer getComType10() {
        return comType10;
    }

    public void setComType10(Integer comType10) {
        this.comType10 = comType10;
    }

    public Integer getComType11() {
        return comType11;
    }

    public void setComType11(Integer comType11) {
        this.comType11 = comType11;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }
}