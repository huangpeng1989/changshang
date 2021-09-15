package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-07-20 17:40
 */
public class ToExamineRawterAcptResult implements Serializable {
    private static final long serialVersionUID = -6255260060007606957L;

    private String rmCode;
    private String rmName;
    private String pSrmCode;
    private Integer pSrmId;
    private BigDecimal remainingStockIn;  //剩余入库数量
    private BigDecimal remainingStockInGift;  //剩余入库赠品数量
    private BigDecimal orderPageCount;  //入库订货数量
    private BigDecimal orderGiftPageCount;  //入库赠品数量

     private BigDecimal alreadyOrderPageCount;  //已入库订货数量
    private BigDecimal alreadyGiftPageCount;  //已入库赠品数量
    private String whinBillCode;
    private Integer whinBillId;
    private Integer flagOrderCount;  //0：正常 1：超出数量
    private Integer flagGiftCount;
    private String acptBillCode;  //影响验收单

    public Integer getFlagOrderCount() {
        return flagOrderCount;
    }

    public void setFlagOrderCount(Integer flagOrderCount) {
        this.flagOrderCount = flagOrderCount;
    }

    public Integer getFlagGiftCount() {
        return flagGiftCount;
    }

    public void setFlagGiftCount(Integer flagGiftCount) {
        this.flagGiftCount = flagGiftCount;
    }

    public BigDecimal getAlreadyOrderPageCount() {
        return alreadyOrderPageCount;
    }

    public void setAlreadyOrderPageCount(BigDecimal alreadyOrderPageCount) {
        this.alreadyOrderPageCount = alreadyOrderPageCount;
    }

    public BigDecimal getAlreadyGiftPageCount() {
        return alreadyGiftPageCount;
    }

    public void setAlreadyGiftPageCount(BigDecimal alreadyGiftPageCount) {
        this.alreadyGiftPageCount = alreadyGiftPageCount;
    }

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
    }

    public Integer getpSrmId() {
        return pSrmId;
    }

    public void setpSrmId(Integer pSrmId) {
        this.pSrmId = pSrmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getpSrmCode() {
        return pSrmCode;
    }

    public void setpSrmCode(String pSrmCode) {
        this.pSrmCode = pSrmCode;
    }

    public BigDecimal getRemainingStockIn() {
        return remainingStockIn;
    }

    public void setRemainingStockIn(BigDecimal remainingStockIn) {
        this.remainingStockIn = remainingStockIn;
    }

    public BigDecimal getRemainingStockInGift() {
        return remainingStockInGift;
    }

    public void setRemainingStockInGift(BigDecimal remainingStockInGift) {
        this.remainingStockInGift = remainingStockInGift;
    }

    public BigDecimal getOrderPageCount() {
        return orderPageCount;
    }

    public void setOrderPageCount(BigDecimal orderPageCount) {
        this.orderPageCount = orderPageCount;
    }

    public BigDecimal getOrderGiftPageCount() {
        return orderGiftPageCount;
    }

    public void setOrderGiftPageCount(BigDecimal orderGiftPageCount) {
        this.orderGiftPageCount = orderGiftPageCount;
    }

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
    }

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode;
    }
}
