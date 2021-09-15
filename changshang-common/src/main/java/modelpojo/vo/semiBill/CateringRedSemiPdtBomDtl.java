package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringRedSemiPdtBomDtl implements Serializable {
    private Long projectId;

    private Integer spdtBillId;

    private Integer spdtDtlId;

    private Integer dishId;

    private Integer dishBomId;

    private Integer dishBomDtlId;

    private Integer dishBomSpecId;

    private Integer rmId;

    private Integer srmId;

    private Integer srmUnit;

    private BigDecimal needCount;//标准成本合计

    private BigDecimal lossCount;//实际消耗合计

    private BigDecimal costSumcount;//实际消耗

    private BigDecimal bomCost;//标准成本

    private Date createdTime;

    private Date updatedTime;

    private Byte isDelete;

    private Integer dbdsStatus;

    private Integer syncStatus;

    private Integer oldDishBomId;

    private BigDecimal lossTotalCount;//实际消耗总量

    private BigDecimal needTotalCount;//标准成本总量

    private BigDecimal redNeedCount;//红冲标准成本合计

    private BigDecimal redLossCount;//红冲实际消耗合计

    private BigDecimal redCostSumcount;//红冲实际消耗

    private Integer redBomId;

    public Integer getRedBomId() {
        return redBomId;
    }

    public void setRedBomId(Integer redBomId) {
        this.redBomId = redBomId;
    }

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

    public BigDecimal getLossTotalCount() {
        return lossTotalCount;
    }

    public void setLossTotalCount(BigDecimal lossTotalCount) {
        this.lossTotalCount = lossTotalCount;
    }

    public BigDecimal getNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(BigDecimal needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public Integer getOldDishBomId() {
        return oldDishBomId;
    }

    public void setOldDishBomId(Integer oldDishBomId) {
        this.oldDishBomId = oldDishBomId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSpdtBillId() {
        return spdtBillId;
    }

    public void setSpdtBillId(Integer spdtBillId) {
        this.spdtBillId = spdtBillId;
    }

    public Integer getSpdtDtlId() {
        return spdtDtlId;
    }

    public void setSpdtDtlId(Integer spdtDtlId) {
        this.spdtDtlId = spdtDtlId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
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

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
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

    public BigDecimal getBomCost() {
        return bomCost;
    }

    public void setBomCost(BigDecimal bomCost) {
        this.bomCost = bomCost;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDbdsStatus() {
        return dbdsStatus;
    }

    public void setDbdsStatus(Integer dbdsStatus) {
        this.dbdsStatus = dbdsStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}