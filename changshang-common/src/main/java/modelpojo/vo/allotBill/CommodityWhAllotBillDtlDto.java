package modelpojo.vo.allotBill;

import java.math.BigDecimal;

/**
 * 调拨出库申请/确认单明细表
 */
public class CommodityWhAllotBillDtlDto extends CommodityWhAllotBillDtl  {

    private BigDecimal allotOutNum;  //调出仓库库存

    private BigDecimal allotInNum;//调入仓库库存

    private String comUnitName;//中文装换
    private String comName;//

    private BigDecimal whStock;
    private Integer outWhId;
    private String altInBillCode;

    private String surplusAltOutNum;//剩余可调出数量

    private String surplusAltInNum;//剩余可调入数量

    public String getSurplusAltOutNum() {
        return surplusAltOutNum;
    }

    public void setSurplusAltOutNum(String surplusAltOutNum) {
        this.surplusAltOutNum = surplusAltOutNum;
    }

    public String getSurplusAltInNum() {
        return surplusAltInNum;
    }

    public void setSurplusAltInNum(String surplusAltInNum) {
        this.surplusAltInNum = surplusAltInNum;
    }

    public String getAltInBillCode() {
        return altInBillCode;
    }

    public void setAltInBillCode(String altInBillCode) {
        this.altInBillCode = altInBillCode;
    }


    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public Integer getOutWhId() {
        return outWhId;
    }

    public void setOutWhId(Integer outWhId) {
        this.outWhId = outWhId;
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