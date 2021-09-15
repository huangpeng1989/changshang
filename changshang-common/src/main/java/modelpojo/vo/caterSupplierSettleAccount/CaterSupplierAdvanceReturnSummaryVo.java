package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 餐饮供应商结账进退货数据汇总
 * @Author wenbin.wang
 * @Date 2019-12-13 16:04
 */
public class CaterSupplierAdvanceReturnSummaryVo implements Serializable {

    private static final long serialVersionUID = -1148760027161421949L;


    private String suppName;
    private String suppCode;
    private String whinBillCode;
    private String blTime;
    private String spellCode;
    private Integer suppId;
    private BigDecimal whInTaxPagePrice = BigDecimal.ZERO;   // 采购含税总金额
    private BigDecimal whInNoTaxPagePrice = BigDecimal.ZERO;  // 采购未税总金额
    private BigDecimal acptNoTaxPagePrice = BigDecimal.ZERO;  // 验收含税总金额
    private BigDecimal acptTaxPagePrice = BigDecimal.ZERO;  // 验收未税总金额

    private  BigDecimal costAmount = BigDecimal.ZERO;

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
    }

    public String getBlTime() {
        return blTime;
    }

    public void setBlTime(String blTime) {
        this.blTime = blTime;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

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

    public BigDecimal getAcptNoTaxPagePrice() {
        return acptNoTaxPagePrice;
    }

    public void setAcptNoTaxPagePrice(BigDecimal acptNoTaxPagePrice) {
        this.acptNoTaxPagePrice = acptNoTaxPagePrice;
    }

    public BigDecimal getAcptTaxPagePrice() {
        return acptTaxPagePrice;
    }

    public void setAcptTaxPagePrice(BigDecimal acptTaxPagePrice) {
        this.acptTaxPagePrice = acptTaxPagePrice;
    }
}
