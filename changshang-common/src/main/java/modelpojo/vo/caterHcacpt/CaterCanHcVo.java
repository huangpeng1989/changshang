package modelpojo.vo.caterHcacpt;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-19 09:59
 */
public class CaterCanHcVo implements Serializable {
    private static final long serialVersionUID = 3457535794700424291L;


    private Integer rmId;//原材料id
    private BigDecimal pSrmPackContent;

    private String rmBarcode;//原材料条码

    private String rmCode;//原材料编号
    private String rmName;//原材料编号
    private String rmUnitName;//原材料单位

    private String rmSpec;//原材料规格

    private String srmCode;//原材料包装编号

    private BigDecimal returnOrderCount;//退货数量

    private BigDecimal hcOrderPageCount;//红冲订货数量

    private BigDecimal hcGiftPageCount;//红冲赠品数量

    private BigDecimal acptOrderPageCount;//包装-验收订货包装数量（入库）

    private BigDecimal acptGiftPageCount;//包装-验收赠品包装数量（入库）

    private BigDecimal canHcOrderPageCount;//可红冲包装-订货数量

    private BigDecimal canHcGiftPageCount;//可红冲包装-赠品数量

    private BigDecimal whStock;//库存数

    private String msg;//未通过原因
    private Integer pSrmId;//包装ID

    private BigDecimal orderPageCountSum;//已退货总数量
    private BigDecimal giftPageCountSum;//已退货赠品总数量

    public BigDecimal getOrderPageCountSum() {
        return orderPageCountSum;
    }

    public void setOrderPageCountSum(BigDecimal orderPageCountSum) {
        this.orderPageCountSum = orderPageCountSum;
    }

    public BigDecimal getGiftPageCountSum() {
        return giftPageCountSum;
    }

    public void setGiftPageCountSum(BigDecimal giftPageCountSum) {
        this.giftPageCountSum = giftPageCountSum;
    }

    public Integer getpSrmId() {
        return pSrmId;
    }

    public void setpSrmId(Integer pSrmId) {
        this.pSrmId = pSrmId;
    }

    public BigDecimal getpSrmPackContent() {
        return pSrmPackContent;
    }

    public void setpSrmPackContent(BigDecimal pSrmPackContent) {
        this.pSrmPackContent = pSrmPackContent;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
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

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public BigDecimal getReturnOrderCount() {
        return returnOrderCount;
    }

    public void setReturnOrderCount(BigDecimal returnOrderCount) {
        this.returnOrderCount = returnOrderCount;
    }

    public BigDecimal getHcOrderPageCount() {
        return hcOrderPageCount;
    }

    public void setHcOrderPageCount(BigDecimal hcOrderPageCount) {
        this.hcOrderPageCount = hcOrderPageCount;
    }

    public BigDecimal getHcGiftPageCount() {
        return hcGiftPageCount;
    }

    public void setHcGiftPageCount(BigDecimal hcGiftPageCount) {
        this.hcGiftPageCount = hcGiftPageCount;
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

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
