package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class BindCommDetailVo implements Serializable {

     private String comCode;//商品编号

     private String saleComCode;//销售商品编号/销售商品条码

     private String comName;//商品名称

     private String sellModel;//经营方式

     private String comSpec;//规格

     private String comUnit;//单位

     private BigDecimal retailPrice;//原零售价

    private Integer comId;//商品id

    private Integer saleComId;//销售商品id

    private Integer gpId;//价格信息配置主键id

    private Integer priceGrade;//价格等级id

    private Integer bindCount;//捆绑数量
    private BigDecimal bindPrice;//捆绑价
    private BigDecimal oldRetailPrice;//原零售价
    private BigDecimal bindSumPrice;//捆绑总价

    private String sellModelName;//code转中文

    private String commUnitName;

    private String priceGradeName;//价格等级名称

    public String getPriceGradeName() {
        return priceGradeName;
    }

    public void setPriceGradeName(String priceGradeName) {
        this.priceGradeName = priceGradeName;
    }

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public String getCommUnitName() {
        return commUnitName;
    }

    public void setCommUnitName(String commUnitName) {
        this.commUnitName = commUnitName;
    }

    public BigDecimal getBindSumPrice() {
        return bindSumPrice;
    }

    public void setBindSumPrice(BigDecimal bindSumPrice) {
        this.bindSumPrice = bindSumPrice;
    }

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getBindCount() {
        return bindCount;
    }

    public void setBindCount(Integer bindCount) {
        this.bindCount = bindCount;
    }

    public BigDecimal getBindPrice() {
        return bindPrice;
    }

    public void setBindPrice(BigDecimal bindPrice) {
        this.bindPrice = bindPrice;
    }

    //=======================接收


    public Integer getPriceGrade() {
        return priceGrade;
    }

    public void setPriceGrade(Integer priceGrade) {
        this.priceGrade = priceGrade;
    }

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}
