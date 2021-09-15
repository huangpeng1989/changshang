package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 餐饮-损溢报表汇总
 * @Author wenbin.wang
 * @Date 2019-11-19 10:36
 */
public class CateringLossBillSummaryVo implements Serializable {


    private static final long serialVersionUID = -7750962137620871336L;

    private String whName;

    private String billTypeName;

    private Integer goodType;

    private Integer count;

    private BigDecimal plCount = BigDecimal.ZERO;

    //  含税损溢金额总额
    private BigDecimal sumTaxCostAmount = BigDecimal.ZERO;

    //  未税损溢金额总额
    private BigDecimal sumNoTaxCostAmount = BigDecimal.ZERO;


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

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
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
}
