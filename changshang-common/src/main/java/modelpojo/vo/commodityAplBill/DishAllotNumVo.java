package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class DishAllotNumVo implements Serializable {

    private Integer rmId;
    private String dishBarcode;
    private String dishName;
    private BigDecimal allotNum;
    private BigDecimal whStock;
    private String dishCode;
    private BigDecimal frozenCount;
    private String aplBillCodes;

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getDishBarcode() {
        return dishBarcode;
    }

    public void setDishBarcode(String dishBarcode) {
        this.dishBarcode = dishBarcode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public BigDecimal getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(BigDecimal allotNum) {
        this.allotNum = allotNum;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public BigDecimal getFrozenCount() {
        return frozenCount;
    }

    public void setFrozenCount(BigDecimal frozenCount) {
        this.frozenCount = frozenCount;
    }

    public String getAplBillCodes() {
        return aplBillCodes;
    }

    public void setAplBillCodes(String aplBillCodes) {
        this.aplBillCodes = aplBillCodes;
    }
}
