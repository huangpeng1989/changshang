package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 供应商联营销售单据信息
 * @Author wenbin.wang
 * @Date 2019-12-16 10:31
 */
public class CaterPoolSupplierBillDetailVo implements Serializable {
    private static final long serialVersionUID = 3683888469479506738L;

    private String cateNdealId;  // 销售单号
    private String suppCode;   //供应商编号
    private String suppName;   //供应商名称
    private String dishCode;   //菜品编号
    private String dishName;   //菜品名称


    private String tieupsTaxName;  //联营折扣率
    private BigDecimal salePrice = BigDecimal.ZERO;  //销售单价
    private BigDecimal cateNum = BigDecimal.ZERO;  //销售数量
    private BigDecimal cateAmount = BigDecimal.ZERO;  //含税销售金额
    private BigDecimal notaxAmount = BigDecimal.ZERO;  //未税销售金额

    private BigDecimal tieupsAmount = BigDecimal.ZERO;   //含税扣点金额
    private BigDecimal tieupsNotaxAmount = BigDecimal.ZERO;   //未税扣点金额
    private String ddate;   //交易时间

    public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
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

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getTieupsTaxName() {
        return tieupsTaxName;
    }

    public void setTieupsTaxName(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCateNum() {
        return cateNum;
    }

    public void setCateNum(BigDecimal cateNum) {
        this.cateNum = cateNum;
    }

    public BigDecimal getCateAmount() {
        return cateAmount;
    }

    public void setCateAmount(BigDecimal cateAmount) {
        this.cateAmount = cateAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }

    public BigDecimal getTieupsNotaxAmount() {
        return tieupsNotaxAmount;
    }

    public void setTieupsNotaxAmount(BigDecimal tieupsNotaxAmount) {
        this.tieupsNotaxAmount = tieupsNotaxAmount;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
}
