package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 供应商信息 / 单据信息 / 明细数据
 * @Author wenbin.wang
 * @Date 2019-12-16 09:17
 */
public class CaterSupplierBillDetailVo implements Serializable {

    private static final long serialVersionUID = -7781399667033948534L;

    private String suppCode;   //供应商编号
    private String suppName;   //供应商名称
    private String orderComDate;   // 采日期
    private String whinBillCode; //采购编号

    private String rmCode;
    private String rmName;
    private String rmBarcode;
    private String sellModel;
    private String rmUnitName;

    // 原材料一级分类名称
    private String rmClassNameOne;
    private String rmClassCode;

    // 原材料一级分类编号
    private String rmClassCodeOne;

    // 原材料二级分类名称
    private String rmClassNameTwo;

    // 原材料二级分类编号
    private String rmClassCodeTwo;

    // 原材料三级分类名称
    private String rmClassNameThree;

    // 原材料三级分类编号
    private String rmClassCodeThree;

    private BigDecimal orderPageCount = BigDecimal.ZERO;
    private BigDecimal giftPageCount = BigDecimal.ZERO;

    private  BigDecimal taxPchsPrice =BigDecimal.ZERO;

    private  BigDecimal notaxPchsPrice = BigDecimal.ZERO;

    private BigDecimal acptOrderPageCount = BigDecimal.ZERO;
    private BigDecimal acptGiftPageCount = BigDecimal.ZERO;
    private BigDecimal acptTaxPagePrice = BigDecimal.ZERO;
    private BigDecimal acptNoTaxPagePrice = BigDecimal.ZERO;

    private  BigDecimal whInTaxPagePrice= BigDecimal.ZERO;

    private  BigDecimal whInNoTaxPagePrice= BigDecimal.ZERO;


    public BigDecimal getWhInTaxPagePrice() {
        return whInTaxPagePrice;
    }

    public void setWhInTaxPagePrice(BigDecimal whInTaxPagePrice) {
        this.whInTaxPagePrice = whInTaxPagePrice;
    }

    public BigDecimal getWhInNoTaxPagePrice() {
        return whInNoTaxPagePrice;
    }

    public void setWhInNoTaxPagePrice(BigDecimal whInNoTaxPagePrice) {
        this.whInNoTaxPagePrice = whInNoTaxPagePrice;
    }

    private String taxName;

    private  BigDecimal costAmount = BigDecimal.ZERO;

    private String typeName;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getTaxPchsPrice() {
        return taxPchsPrice;
    }

    public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
        this.taxPchsPrice = taxPchsPrice;
    }

    public BigDecimal getNotaxPchsPrice() {
        return notaxPchsPrice;
    }

    public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
        this.notaxPchsPrice = notaxPchsPrice;
    }

    public void setGiftPageCount(BigDecimal giftPageCount) {
        this.giftPageCount = giftPageCount;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getOrderComDate() {
        return orderComDate;
    }

    public void setOrderComDate(String orderComDate) {
        this.orderComDate = orderComDate;
    }

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
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

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getRmClassNameOne() {
        return rmClassNameOne;
    }

    public void setRmClassNameOne(String rmClassNameOne) {
        this.rmClassNameOne = rmClassNameOne;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getRmClassCodeOne() {
        return rmClassCodeOne;
    }

    public void setRmClassCodeOne(String rmClassCodeOne) {
        this.rmClassCodeOne = rmClassCodeOne;
    }

    public String getRmClassNameTwo() {
        return rmClassNameTwo;
    }

    public void setRmClassNameTwo(String rmClassNameTwo) {
        this.rmClassNameTwo = rmClassNameTwo;
    }

    public String getRmClassCodeTwo() {
        return rmClassCodeTwo;
    }

    public void setRmClassCodeTwo(String rmClassCodeTwo) {
        this.rmClassCodeTwo = rmClassCodeTwo;
    }

    public String getRmClassNameThree() {
        return rmClassNameThree;
    }

    public void setRmClassNameThree(String rmClassNameThree) {
        this.rmClassNameThree = rmClassNameThree;
    }

    public String getRmClassCodeThree() {
        return rmClassCodeThree;
    }

    public void setRmClassCodeThree(String rmClassCodeThree) {
        this.rmClassCodeThree = rmClassCodeThree;
    }

    public BigDecimal getOrderPageCount() {
        return orderPageCount;
    }

    public void setOrderPageCount(BigDecimal orderPageCount) {
        this.orderPageCount = orderPageCount;
    }

    public BigDecimal getGiftPageCount() {
        return giftPageCount;
    }

    public void setWhInGiftPageCount(BigDecimal giftPageCount) {
        this.giftPageCount = giftPageCount;
    }

    public BigDecimal getAcptOrderPageCount() {
        return acptOrderPageCount;
    }

    public void setAcptOrderPageCount(BigDecimal acptOrderPageCount) {
        this.acptOrderPageCount = acptOrderPageCount;
    }

    public BigDecimal getAcptGiftPageCount() {
        return acptGiftPageCount;
    }

    public void setAcptGiftPageCount(BigDecimal acptGiftPageCount) {
        this.acptGiftPageCount = acptGiftPageCount;
    }

    public BigDecimal getAcptTaxPagePrice() {
        return acptTaxPagePrice;
    }

    public void setAcptTaxPagePrice(BigDecimal acptTaxPagePrice) {
        this.acptTaxPagePrice = acptTaxPagePrice;
    }

    public BigDecimal getAcptNoTaxPagePrice() {
        return acptNoTaxPagePrice;
    }

    public void setAcptNoTaxPagePrice(BigDecimal acptNoTaxPagePrice) {
        this.acptNoTaxPagePrice = acptNoTaxPagePrice;
    }
}
