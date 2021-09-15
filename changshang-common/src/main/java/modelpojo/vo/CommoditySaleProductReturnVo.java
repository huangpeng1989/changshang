package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by pandong on 2019/8/27.
 */
public class CommoditySaleProductReturnVo implements Serializable {

    private Integer comId;//商品ID
    private String comCode;//商品编号
    private String saleComCode;//销售商编号
    private String comName;//商品名称
    private String comAbbreviate;//商品简称
    private String comSpec;//商品规格
    private String saleComUnitName;//商品销售单位
    private BigDecimal recommendedRetailPrice;//建议零售价
    private BigDecimal actualSellingPrice;//实际售价
    private BigDecimal expirationDate;//保质期
    private String isOriginalPrice;//是否原价
    private String comBarcode;//条码

    public String getSaleComUnitName() {
        return saleComUnitName;
    }

    public void setSaleComUnitName(String saleComUnitName) {
        this.saleComUnitName = saleComUnitName;
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

    public String getComAbbreviate() {
        return comAbbreviate;
    }

    public void setComAbbreviate(String comAbbreviate) {
        this.comAbbreviate = comAbbreviate;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }



    public void setExpirationDate(BigDecimal expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIsOriginalPrice() {
        return isOriginalPrice;
    }

    public void setIsOriginalPrice(String isOriginalPrice) {
        this.isOriginalPrice = isOriginalPrice;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }


    public BigDecimal getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public void setRecommendedRetailPrice(BigDecimal recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public BigDecimal getActualSellingPrice() {
        return actualSellingPrice;
    }

    public void setActualSellingPrice(BigDecimal actualSellingPrice) {
        this.actualSellingPrice = actualSellingPrice;
    }
}
