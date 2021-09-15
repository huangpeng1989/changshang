package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class AllotNumVo implements Serializable {

    private Integer saleComId;
    private String comBarcode;
    private String comName;
    private BigDecimal allotNum;
    private BigDecimal whStock;
    private String comCode;
    private BigDecimal frozenCount;
    private String aplBillCodes;

    public String getAplBillCodes() {
        return aplBillCodes;
    }

    public void setAplBillCodes(String aplBillCodes) {
        this.aplBillCodes = aplBillCodes;
    }

    public BigDecimal getFrozenCount() {
        return frozenCount;
    }

    public void setFrozenCount(BigDecimal frozenCount) {
        this.frozenCount = frozenCount;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public Integer getSaleComId() {
        return saleComId;
    }
    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }
    public String getComBarcode() {
        return comBarcode;
    }
    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
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

}
