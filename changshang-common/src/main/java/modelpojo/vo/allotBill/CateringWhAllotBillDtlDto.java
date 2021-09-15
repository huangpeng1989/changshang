package modelpojo.vo.allotBill;

import java.math.BigDecimal;

public class CateringWhAllotBillDtlDto extends CateringWhAllotBillDtl {
    private BigDecimal allotOutNum;  //调出仓库库存

    private BigDecimal allotInNum;//调入仓库库存

    private String comUnitName;//中文装换
    private String comName;//
    private String rmBarcode;//
    private String dishClassName;//
    private String dishClassCode;//

    private String srmUnitName;//
    private String sSrmUnitName;//
    private BigDecimal packContent;//

    private String sellModel;//

    private BigDecimal surplusAltOutNum;//剩余可调出数量

    private BigDecimal surplusAltInNum;//剩余可调入数量

    public BigDecimal getSurplusAltOutNum() {
        return surplusAltOutNum;
    }

    public void setSurplusAltOutNum(BigDecimal surplusAltOutNum) {
        this.surplusAltOutNum = surplusAltOutNum;
    }

    public BigDecimal getSurplusAltInNum() {
        return surplusAltInNum;
    }

    public void setSurplusAltInNum(BigDecimal surplusAltInNum) {
        this.surplusAltInNum = surplusAltInNum;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getsSrmUnitName() {
        return sSrmUnitName;
    }

    public void setsSrmUnitName(String sSrmUnitName) {
        this.sSrmUnitName = sSrmUnitName;
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public BigDecimal getAllotOutNum() {
        return allotOutNum;
    }

    public void setAllotOutNum(BigDecimal allotOutNum) {
        this.allotOutNum = allotOutNum;
    }

    public BigDecimal getAllotInNum() {
        return allotInNum;
    }

    public void setAllotInNum(BigDecimal allotInNum) {
        this.allotInNum = allotInNum;
    }

}