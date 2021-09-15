package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 供应商联营销售汇总
 * @Author wenbin.wang
 * @Date 2019-12-16 09:34
 */
public class CaterPoolSupplierSummaryVo implements Serializable {
    private static final long serialVersionUID = 5959868928794486259L;

    private String suppCode;   //供应商编号
    private String suppName;   //供应商名称
    private String selModel;   //经营方式
    private String spellCode;   //经营方式
    private BigDecimal sumTaxCostAmount= BigDecimal.ZERO;   //销售含税总金额
    private BigDecimal sumNoTaxCostAmount= BigDecimal.ZERO;   //销售未税总金额
    private BigDecimal sumTaxCateDisAmount= BigDecimal.ZERO;   //含税扣点总金额
    private BigDecimal sumNoTaxCateDisAmount = BigDecimal.ZERO;   //未税扣点总金额
    private BigDecimal taxCost = BigDecimal.ZERO;   //供应商结账含税扣点总金额
    private BigDecimal notaxCost = BigDecimal.ZERO;   //供应商结账含税扣点总金额

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
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

    public String getSelModel() {
        return selModel;
    }

    public void setSelModel(String selModel) {
        this.selModel = selModel;
    }

    public BigDecimal getSumTaxCostAmount() {
        return sumTaxCostAmount;
    }

    public void setSumTaxCostAmount(BigDecimal sumTaxCostAmount) {
        this.sumTaxCostAmount = sumTaxCostAmount;
    }

    public BigDecimal getSumNoTaxCostAmount() {
        return sumNoTaxCostAmount;
    }

    public void setSumNoTaxCostAmount(BigDecimal sumNoTaxCostAmount) {
        this.sumNoTaxCostAmount = sumNoTaxCostAmount;
    }

    public BigDecimal getSumTaxCateDisAmount() {
        return sumTaxCateDisAmount;
    }

    public void setSumTaxCateDisAmount(BigDecimal sumTaxCateDisAmount) {
        this.sumTaxCateDisAmount = sumTaxCateDisAmount;
    }

    public BigDecimal getSumNoTaxCateDisAmount() {
        return sumNoTaxCateDisAmount;
    }

    public void setSumNoTaxCateDisAmount(BigDecimal sumNoTaxCateDisAmount) {
        this.sumNoTaxCateDisAmount = sumNoTaxCateDisAmount;
    }
}
