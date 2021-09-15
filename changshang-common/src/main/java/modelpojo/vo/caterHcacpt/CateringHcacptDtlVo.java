package modelpojo.vo.caterHcacpt;

import modelpojo.model.CateringWhHcacptBillDtl;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-19 15:26
 */
public class CateringHcacptDtlVo extends CateringWhHcacptBillDtl {
    private static final long serialVersionUID = 2378245633828825949L;


    private String rmName;//原材料名称
    private String rmUnitName;//原材料单位名称
    private BigDecimal acptOrderPageCount;//包装-验收订货包装数量
    private BigDecimal acptGiftPageCount;//包装-验收赠品包装数量
    private BigDecimal canHcOrderPageCount;//可红冲包装-订货数量
    private BigDecimal canHcGiftPageCount;//可红冲包装-赠品数量

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
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

    public BigDecimal getCanHcOrderPageCount() {
        return canHcOrderPageCount;
    }

    public void setCanHcOrderPageCount(BigDecimal canHcOrderPageCount) {
        this.canHcOrderPageCount = canHcOrderPageCount;
    }

    public BigDecimal getCanHcGiftPageCount() {
        return canHcGiftPageCount;
    }

    public void setCanHcGiftPageCount(BigDecimal canHcGiftPageCount) {
        this.canHcGiftPageCount = canHcGiftPageCount;
    }
}
