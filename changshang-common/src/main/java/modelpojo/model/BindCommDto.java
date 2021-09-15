package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BindCommDto implements Serializable {

    private String bindComCode;

    private String bindComName;

    private Integer bindComId;

    private String bindComBarcode;

    private String saleUnit;

    private BigDecimal bindSellPrice;

    private String type;

    private Integer gradeId;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBindComCode() {
        return bindComCode;
    }

    public void setBindComCode(String bindComCode) {
        this.bindComCode = bindComCode;
    }

    public String getBindComName() {
        return bindComName;
    }

    public void setBindComName(String bindComName) {
        this.bindComName = bindComName;
    }

    public Integer getBindComId() {
        return bindComId;
    }

    public void setBindComId(Integer bindComId) {
        this.bindComId = bindComId;
    }

    public String getBindComBarcode() {
        return bindComBarcode;
    }

    public void setBindComBarcode(String bindComBarcode) {
        this.bindComBarcode = bindComBarcode;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public BigDecimal getBindSellPrice() {
        return bindSellPrice;
    }

    public void setBindSellPrice(BigDecimal bindSellPrice) {
        this.bindSellPrice = bindSellPrice;
    }
}
