package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-01 22:52
 */
public class CaterDealSaleSummryVo implements Serializable {
    private static final long serialVersionUID = -7230422639845813847L;

    private String gzoneName;
    private BigDecimal countSum = BigDecimal.ZERO;
    private BigDecimal cateAmountSum = BigDecimal.ZERO;
    private BigDecimal notaxAmountSum = BigDecimal.ZERO;

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public BigDecimal getCountSum() {
        return countSum;
    }

    public void setCountSum(BigDecimal countSum) {
        this.countSum = countSum;
    }

    public BigDecimal getCateAmountSum() {
        return cateAmountSum;
    }

    public void setCateAmountSum(BigDecimal cateAmountSum) {
        this.cateAmountSum = cateAmountSum;
    }

    public BigDecimal getNotaxAmountSum() {
        return notaxAmountSum;
    }

    public void setNotaxAmountSum(BigDecimal notaxAmountSum) {
        this.notaxAmountSum = notaxAmountSum;
    }
}
