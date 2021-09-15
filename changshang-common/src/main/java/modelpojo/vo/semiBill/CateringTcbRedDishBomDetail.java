package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringTcbRedDishBomDetail implements Serializable {
    private Integer dishBomId;

    private Integer rmId;

    private String rmCode;

    private String rmName;

    private Integer rmUnit;//最小单位

    private String rmUnitName;

    private BigDecimal needCount;//标准成本合计

    private BigDecimal lossCount;//实际消耗合计

    private BigDecimal costSumcount;//实际消耗

    private Integer gzoneId;//营业点id
    private Integer dishBomSpecId;//弃用
    private Integer dishBomDtlId;//菜品bom明细表id

    private BigDecimal bomCost; //标准成本

    //新加需求
    private BigDecimal whStock;//当前仓库总数量

    private String explain;//说明

    //8月新加字段
    private BigDecimal needTotalCount;//标准成本总量

    private BigDecimal lossTotalCount;//实际消耗总量

    private BigDecimal redNeedCount; //红冲标准成本合计

    private BigDecimal redLossCount; //红冲实际消耗合计

    private BigDecimal redCostSumcount; //红冲实际消耗

    public BigDecimal getRedNeedCount() {
        return redNeedCount;
    }

    public void setRedNeedCount(BigDecimal redNeedCount) {
        this.redNeedCount = redNeedCount;
    }

    public BigDecimal getRedLossCount() {
        return redLossCount;
    }

    public void setRedLossCount(BigDecimal redLossCount) {
        this.redLossCount = redLossCount;
    }

    public BigDecimal getRedCostSumcount() {
        return redCostSumcount;
    }

    public void setRedCostSumcount(BigDecimal redCostSumcount) {
        this.redCostSumcount = redCostSumcount;
    }

    public BigDecimal getNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(BigDecimal needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public BigDecimal getLossTotalCount() {
        return lossTotalCount;
    }

    public void setLossTotalCount(BigDecimal lossTotalCount) {
        this.lossTotalCount = lossTotalCount;
    }

    public BigDecimal getBomCost() {
        return bomCost;
    }

    public void setBomCost(BigDecimal bomCost) {
        this.bomCost = bomCost;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getDishBomDtlId() {
        return dishBomDtlId;
    }

    public void setDishBomDtlId(Integer dishBomDtlId) {
        this.dishBomDtlId = dishBomDtlId;
    }

    public Integer getDishBomSpecId() {
        return dishBomSpecId;
    }

    public void setDishBomSpecId(Integer dishBomSpecId) {
        this.dishBomSpecId = dishBomSpecId;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
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

    public BigDecimal getNeedCount() {
        return needCount;
    }

    public void setNeedCount(BigDecimal needCount) {
        this.needCount = needCount;
    }

    public BigDecimal getLossCount() {
        return lossCount;
    }

    public void setLossCount(BigDecimal lossCount) {
        this.lossCount = lossCount;
    }

    public BigDecimal getCostSumcount() {
        return costSumcount;
    }

    public void setCostSumcount(BigDecimal costSumcount) {
        this.costSumcount = costSumcount;
    }
}
