package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 可售菜品价格表
 */
public class CateringSaledDishDetailPriceModel implements Serializable {
    private Long projectId;

    private Integer dishDetailPriceId;

    private Integer saledDishId;

    private Integer saledDishDtlId;

    private Integer sellPointId;

    private Integer dishDictSpecId;

    private String dishSaleCode;

    private Integer dictId;

    private String dictCode;

    private BigDecimal dictSpecPrice;

    private Byte isDelete;

    private Integer billType;

    private Integer goodType;

    private BigDecimal oldDictSpecPrice;

    public BigDecimal getOldDictSpecPrice() {
        return oldDictSpecPrice;
    }

    public void setOldDictSpecPrice(BigDecimal oldDictSpecPrice) {
        this.oldDictSpecPrice = oldDictSpecPrice;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getDishDetailPriceId() {
        return dishDetailPriceId;
    }


    public void setDishDetailPriceId(Integer dishDetailPriceId) {
        this.dishDetailPriceId = dishDetailPriceId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }

    public Integer getSaledDishDtlId() {
        return saledDishDtlId;
    }

    public void setSaledDishDtlId(Integer saledDishDtlId) {
        this.saledDishDtlId = saledDishDtlId;
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public Integer getDishDictSpecId() {
        return dishDictSpecId;
    }

    public void setDishDictSpecId(Integer dishDictSpecId) {
        this.dishDictSpecId = dishDictSpecId;
    }

    public String getDishSaleCode() {
        return dishSaleCode;
    }

    public void setDishSaleCode(String dishSaleCode) {
        this.dishSaleCode = dishSaleCode == null ? null : dishSaleCode.trim();
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public BigDecimal getDictSpecPrice() {
        return dictSpecPrice;
    }

    public void setDictSpecPrice(BigDecimal dictSpecPrice) {
        this.dictSpecPrice = dictSpecPrice;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}