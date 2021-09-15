package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 供应商信息 / 单据信息
 * @Author wenbin.wang
 * @Date 2019-12-13 17:49
 */
public class CaterSupplierBillIVo implements Serializable {
    private static final long serialVersionUID = -8491759956719489460L;
    private String suppCode;   //供应商编号
    private String suppName;   //供应商名称
    private String whinBillCode; //采购编号
    private Integer whinBillId;
    private BigDecimal whInTaxPagePrice = BigDecimal.ZERO;  //采购含税金额
    private BigDecimal whInNotaxPagePrice = BigDecimal.ZERO;  // 采购未税金额
    private BigDecimal acptTaxPagePrice = BigDecimal.ZERO;   // 验收含税金额
    private BigDecimal acptNotaxPagePrice = BigDecimal.ZERO;   // 验收未税金额
    private String blTime;   // 采日期
    private String typeName;

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
    }

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
    }

    public BigDecimal getWhInTaxPagePrice() {
        return whInTaxPagePrice;
    }

    public void setWhInTaxPagePrice(BigDecimal whInTaxPagePrice) {
        this.whInTaxPagePrice = whInTaxPagePrice;
    }

    public BigDecimal getWhInNotaxPagePrice() {
        return whInNotaxPagePrice;
    }

    public void setWhInNotaxPagePrice(BigDecimal whInNotaxPagePrice) {
        this.whInNotaxPagePrice = whInNotaxPagePrice;
    }

    public BigDecimal getAcptTaxPagePrice() {
        return acptTaxPagePrice;
    }

    public void setAcptTaxPagePrice(BigDecimal acptTaxPagePrice) {
        this.acptTaxPagePrice = acptTaxPagePrice;
    }

    public BigDecimal getAcptNotaxPagePrice() {
        return acptNotaxPagePrice;
    }

    public void setAcptNotaxPagePrice(BigDecimal acptNotaxPagePrice) {
        this.acptNotaxPagePrice = acptNotaxPagePrice;
    }

    public String getBlTime() {
        return blTime;
    }

    public void setBlTime(String blTime) {
        this.blTime = blTime;
    }
}
