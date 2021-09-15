package modelpojo.vo.saleablecom;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillComDto implements Serializable {
    private String gradeName;

    private String comBillCode;

    private String comBillName;

    private String status;

    private String comCode;

    private String comName;

    private String saleComCode;

    private String comType;

    private String comType2;

    private String comType3;

    private String comType4;

    private String comType5;

    private String comBarcode;

    private String saleCommUnit;

    private String sellModel;

    private BigDecimal retailPrice;

    private String isSaleStatus;

    public String getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(String isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getComBillCode() {
        return comBillCode;
    }

    public void setComBillCode(String comBillCode) {
        this.comBillCode = comBillCode;
    }

    public String getComBillName() {
        return comBillName;
    }

    public void setComBillName(String comBillName) {
        this.comBillName = comBillName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComType2() {
        return comType2;
    }

    public void setComType2(String comType2) {
        this.comType2 = comType2;
    }

    public String getComType3() {
        return comType3;
    }

    public void setComType3(String comType3) {
        this.comType3 = comType3;
    }

    public String getComType4() {
        return comType4;
    }

    public void setComType4(String comType4) {
        this.comType4 = comType4;
    }

    public String getComType5() {
        return comType5;
    }

    public void setComType5(String comType5) {
        this.comType5 = comType5;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getSaleCommUnit() {
        return saleCommUnit;
    }

    public void setSaleCommUnit(String saleCommUnit) {
        this.saleCommUnit = saleCommUnit;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}
