package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-01 19:40
 */
public class CommDealSaleSummryVo implements Serializable {
    private static final long serialVersionUID = 8642318205966694337L;

    private String gzoneName;
    private BigDecimal countSum = BigDecimal.ZERO;
    private BigDecimal comAmountSum = BigDecimal.ZERO;
    private BigDecimal notaxAmountSum = BigDecimal.ZERO;
    private BigDecimal tieupsAmountSum = BigDecimal.ZERO;

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

    public BigDecimal getComAmountSum() {
        return comAmountSum;
    }

    public void setComAmountSum(BigDecimal comAmountSum) {
        this.comAmountSum = comAmountSum;
    }

    public BigDecimal getNotaxAmountSum() {
        return notaxAmountSum;
    }

    public void setNotaxAmountSum(BigDecimal notaxAmountSum) {
        this.notaxAmountSum = notaxAmountSum;
    }

    public BigDecimal getTieupsAmountSum() {
        return tieupsAmountSum;
    }

    public void setTieupsAmountSum(BigDecimal tieupsAmountSum) {
        this.tieupsAmountSum = tieupsAmountSum;
    }
}
