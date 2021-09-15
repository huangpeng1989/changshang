package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class CaterRmReportVo implements Serializable {

    //原材料编号
    private String rmCode;
    //原材料条码
    private String rmBarcode;
    //原材料名称
    private String rmName;
    //原材料规格
    private String sellModel;
    // 原材料包装编号
    private String srmCode;
    //采购单号
    private String whinBillCode;
    //验收单号
    private String acptBillCode;
    //税率ID
    private String taxId;
    //税率名称
    private String taxName;
    //订货数量
    private BigDecimal acptOrderCount;
    //本次入库验收数量
    private BigDecimal returnOrderPageCount;
    //采购单位
    private String srmUnitName;
    //预计入库日期
    private String pdtWhinDate;
    //实际入库日期
    private String realWhinDate;
    //过期时间
    private String overdueDate;
    //保质期
    private String expirationDate;


    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
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

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
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

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getAcptOrderCount() {
        return acptOrderCount;
    }

    public void setAcptOrderCount(BigDecimal acptOrderCount) {
        this.acptOrderCount = acptOrderCount;
    }

    public BigDecimal getReturnOrderPageCount() {
        return returnOrderPageCount;
    }

    public void setReturnOrderPageCount(BigDecimal returnOrderPageCount) {
        this.returnOrderPageCount = returnOrderPageCount;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getPdtWhinDate() {
        return pdtWhinDate;
    }

    public void setPdtWhinDate(String pdtWhinDate) {
        this.pdtWhinDate = pdtWhinDate;
    }

    public String getRealWhinDate() {
        return realWhinDate;
    }

    public void setRealWhinDate(String realWhinDate) {
        this.realWhinDate = realWhinDate;
    }

    public String getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
