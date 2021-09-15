package modelpojo.vo;


import modelpojo.model.CateringWhInAcptDtl;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-04 11:41
 */
public class CateringWhInAcptDtlVo extends CateringWhInAcptDtl {


    private String whStockUnitName;  //库存的最小原材料单位名称
    private String srmUnitName;  //原材料包装单位名称
    private Integer whinBillId;
    private String acptBillCode;
    private BigDecimal sumOGPageCount = BigDecimal.ZERO;  //验收总数量 = 验收订单数量+验收赠品数量
    private BigDecimal sumOrderCount= BigDecimal.ZERO;  //验收订货数量
    private BigDecimal sumGiftCount= BigDecimal.ZERO;  //验收赠品数量
    private BigDecimal rtnOGPageCount= BigDecimal.ZERO;  //退货数量
    private BigDecimal hcCount= BigDecimal.ZERO;  //红冲数量

    private BigDecimal whInSumOGPageCount= BigDecimal.ZERO; // 采购总数量
    private BigDecimal whInSumGiftCount= BigDecimal.ZERO; // 采购赠品数量
    private BigDecimal whInSumOrderCount= BigDecimal.ZERO; // 采购订货数量


    private BigDecimal retrievableNumber= BigDecimal.ZERO;  //可退数量
    private BigDecimal whStock= BigDecimal.ZERO;  //库存数量
    public BigDecimal getRetrievableNumber() {
        return retrievableNumber;
    }

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode;
    }

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
    }

    public BigDecimal getHcCount() {
        return hcCount;
    }

    public void setHcCount(BigDecimal hcCount) {
        this.hcCount = hcCount;
    }

    public void setRetrievableNumber(BigDecimal retrievableNumber) {
        this.retrievableNumber = retrievableNumber;
    }
    public BigDecimal getSumOGPageCount() {
        return sumOGPageCount;
    }

    public void setSumOGPageCount(BigDecimal sumOGPageCount) {
        this.sumOGPageCount = sumOGPageCount;
    }

    public BigDecimal getSumGiftCount() {
        return sumGiftCount;
    }

    public void setSumGiftCount(BigDecimal sumGiftCount) {
        this.sumGiftCount = sumGiftCount;
    }

    public BigDecimal getWhInSumOGPageCount() {
        return whInSumOGPageCount;
    }

    public void setWhInSumOGPageCount(BigDecimal whInSumOGPageCount) {
        this.whInSumOGPageCount = whInSumOGPageCount;
    }

    public BigDecimal getWhInSumGiftCount() {
        return whInSumGiftCount;
    }

    public void setWhInSumGiftCount(BigDecimal whInSumGiftCount) {
        this.whInSumGiftCount = whInSumGiftCount;
    }

    public BigDecimal getWhInSumOrderCount() {
        return whInSumOrderCount;
    }

    public void setWhInSumOrderCount(BigDecimal whInSumOrderCount) {
        this.whInSumOrderCount = whInSumOrderCount;
    }


    public BigDecimal getRtnOGPageCount() {
        return rtnOGPageCount;
    }

    public void setRtnOGPageCount(BigDecimal rtnOGPageCount) {
        this.rtnOGPageCount = rtnOGPageCount;
    }

    public BigDecimal getSumOrderCount() {
        return sumOrderCount;
    }

    public void setSumOrderCount(BigDecimal sumOrderCount) {
        this.sumOrderCount = sumOrderCount;
    }

    public String getWhStockUnitName() {
        return whStockUnitName;
    }

    public void setWhStockUnitName(String whStockUnitName) {
        this.whStockUnitName = whStockUnitName;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }



}
