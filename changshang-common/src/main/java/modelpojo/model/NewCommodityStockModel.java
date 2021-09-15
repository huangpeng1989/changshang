package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/****
 * 库存查询（加权平均）实体类
 */
public class NewCommodityStockModel implements Serializable{

    private String whName;//仓库名

    private String rmBard;// 原材料条码/

    private String rmCode;// rm_code原材料编码/

    private String rmName;// rm_name原材料名称/

    private String rmSpec;// rm_spec原材料规格/

    private String rmUnit;// rm_unit原材料单位/

    private String rmClassCode;// rm_class_code原材料分类/

    private String comBarcode;// 商品条码，

    private String comCode;// 商品编码，

    private String comName;//商品名称，

    private String comSpec;// 商品规格，

    private String comUnit;// 商品单位，

    private String comClassName;///商品分类，

    private String phTaxName;// ph_tax_name进项税税率，

    private String taxName;// tax_name进项税税率，

    private  BigDecimal taxCost;

    private  BigDecimal notaxCost;

    private  BigDecimal noWhStock;

    private BigDecimal qTaxAmount;// q_tax_amount期初含税成本，

    private BigDecimal qNotaxAmount;// q_notax_amount期初未税成本，

    private BigDecimal qStockNum;// q_stock_num期初库存总数量

    private BigDecimal nowStockNum;//now_stock_num当前仓库总数量，

    private BigDecimal notStockNum;//not_stock_num 未结转总数量，

    private BigDecimal acptCount;// acpt_count 验收未结转数量，

    private BigDecimal hcCount;// hc_count红冲未结转数量，

    private BigDecimal whinoutCount;// whinout_count退货未结转数量，

    private BigDecimal allOut;// all_out调出未结转数量，

    private BigDecimal allIn;// all_in调入未结转数量，

    private BigDecimal rcptCount;//rcpt_count领用未结转数量，

    private BigDecimal rtnCount;// rtn_count归还未结转数量，

    private BigDecimal lossCount;// loss_count报损未结转数量，

    private BigDecimal ofCount;// of_count报溢未结转数量，

    private BigDecimal ivtCount;// ivt_count盘点未结转数量，

    private BigDecimal semiCount;//半成品加工未结转数量，

    private BigDecimal tranCount;//转换单未结转数量

    private BigDecimal sellCount;//售卖数量

    private BigDecimal selltCount;// sellt_count消耗数量

    private Integer totalCount;

    private  String sellMode;

    private BigDecimal freezeCount;

    private BigDecimal costAdjustment;//成本调整


    public BigDecimal getCostAdjustment() {
        return costAdjustment;
    }

    public void setCostAdjustment(BigDecimal costAdjustment) {
        this.costAdjustment = costAdjustment;
    }

    public BigDecimal getFreezeCount() {
        return freezeCount;
    }

    public void setFreezeCount(BigDecimal freezeCount) {
        this.freezeCount = freezeCount;
    }

    public String getSellMode() {
        return sellMode;
    }

    public void setSellMode(String sellMode) {
        this.sellMode = sellMode;
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

    public BigDecimal getNoWhStock() {
        return noWhStock;
    }

    public void setNoWhStock(BigDecimal noWhStock) {
        this.noWhStock = noWhStock;
    }

    public BigDecimal getSemiCount() {
        return semiCount;
    }

    public void setSemiCount(BigDecimal semiCount) {
        this.semiCount = semiCount;
    }

    public BigDecimal getTranCount() {
        return tranCount;
    }

    public void setTranCount(BigDecimal tranCount) {
        this.tranCount = tranCount;
    }

    public BigDecimal getSellCount() {
        return sellCount;
    }

    public void setSellCount(BigDecimal sellCount) {
        this.sellCount = sellCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getRmBard() {
        return rmBard;
    }

    public void setRmBard(String rmBard) {
        this.rmBard = rmBard;
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

    public String getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(String rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getPhTaxName() {
        return phTaxName;
    }

    public void setPhTaxName(String phTaxName) {
        this.phTaxName = phTaxName;
    }

    public BigDecimal getqTaxAmount() {
        return qTaxAmount;
    }

    public void setqTaxAmount(BigDecimal qTaxAmount) {
        this.qTaxAmount = qTaxAmount;
    }

    public BigDecimal getqNotaxAmount() {
        return qNotaxAmount;
    }

    public void setqNotaxAmount(BigDecimal qNotaxAmount) {
        this.qNotaxAmount = qNotaxAmount;
    }

    public BigDecimal getqStockNum() {
        return qStockNum;
    }

    public void setqStockNum(BigDecimal qStockNum) {
        this.qStockNum = qStockNum;
    }

    public BigDecimal getNowStockNum() {
        return nowStockNum;
    }

    public void setNowStockNum(BigDecimal nowStockNum) {
        this.nowStockNum = nowStockNum;
    }

    public BigDecimal getNotStockNum() {
        return notStockNum;
    }

    public void setNotStockNum(BigDecimal notStockNum) {
        this.notStockNum = notStockNum;
    }

    public BigDecimal getAcptCount() {
        return acptCount;
    }

    public void setAcptCount(BigDecimal acptCount) {
        this.acptCount = acptCount;
    }

    public BigDecimal getHcCount() {
        return hcCount;
    }

    public void setHcCount(BigDecimal hcCount) {
        this.hcCount = hcCount;
    }

    public BigDecimal getWhinoutCount() {
        return whinoutCount;
    }

    public void setWhinoutCount(BigDecimal whinoutCount) {
        this.whinoutCount = whinoutCount;
    }

    public BigDecimal getAllOut() {
        return allOut;
    }

    public void setAllOut(BigDecimal allOut) {
        this.allOut = allOut;
    }

    public BigDecimal getAllIn() {
        return allIn;
    }

    public void setAllIn(BigDecimal allIn) {
        this.allIn = allIn;
    }

    public BigDecimal getRcptCount() {
        return rcptCount;
    }

    public void setRcptCount(BigDecimal rcptCount) {
        this.rcptCount = rcptCount;
    }

    public BigDecimal getRtnCount() {
        return rtnCount;
    }

    public void setRtnCount(BigDecimal rtnCount) {
        this.rtnCount = rtnCount;
    }

    public BigDecimal getLossCount() {
        return lossCount;
    }

    public void setLossCount(BigDecimal lossCount) {
        this.lossCount = lossCount;
    }

    public BigDecimal getOfCount() {
        return ofCount;
    }

    public void setOfCount(BigDecimal ofCount) {
        this.ofCount = ofCount;
    }

    public BigDecimal getIvtCount() {
        return ivtCount;
    }

    public void setIvtCount(BigDecimal ivtCount) {
        this.ivtCount = ivtCount;
    }

    public BigDecimal getSelltCount() {
        return selltCount;
    }

    public void setSelltCount(BigDecimal selltCount) {
        this.selltCount = selltCount;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }
}
