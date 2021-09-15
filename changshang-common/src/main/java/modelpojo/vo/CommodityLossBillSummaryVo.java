package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 商品报损/溢汇总
 * @Author wenbin.wang
 * @Date 2019-11-13 15:55
 */
public class CommodityLossBillSummaryVo implements Serializable {
    private static final long serialVersionUID = -2746415930379866558L;

    // 仓库名称
    private String whName;

    // 损溢类型名称
    private String billTypeName;

    //  含税损溢金额总额
    private BigDecimal sumTaxCostAmount = BigDecimal.ZERO;

    //  未税损溢金额总额
    private BigDecimal sumNoTaxCostAmount = BigDecimal.ZERO;


    // 损溢条数
    private Integer count;

    // 损溢数量总计
    private BigDecimal plCount;

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPlCount() {
        return plCount;
    }

    public void setPlCount(BigDecimal plCount) {
        this.plCount = plCount;
    }

}
