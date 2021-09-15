package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmAllotNumVo implements Serializable {

    private Integer sRmId;
    private String rmBarcode;
    private String rmName;
    private BigDecimal allotNum;
    private BigDecimal whStock;
    private String rmCode;
    private BigDecimal frozenCount;
    private String aplBillCodes;

    public Integer getsRmId() {
        return sRmId;
    }

    public void setsRmId(Integer sRmId) {
        this.sRmId = sRmId;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
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

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
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
