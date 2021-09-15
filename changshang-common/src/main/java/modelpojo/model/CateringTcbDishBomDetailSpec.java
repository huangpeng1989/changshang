package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringTcbDishBomDetailSpec implements Serializable{
    private Integer dishBomSpecId;

    private Integer dishBomDtlId;

    private Integer dishBomId;

    private String dishBomCode;

    private Integer dishSpecId;

    private Integer rmdishId;

    private BigDecimal needCount;

    private BigDecimal lossCount;

    private BigDecimal costSumcount;

    private BigDecimal bomCost;

    private Byte isDelete;

    private Integer dbdsStatus;

	 private Integer dishBomDtlSpecId;

    private Long projectId;

    public Integer getDishBomDtlSpecId() {
        return dishBomDtlSpecId;
    }

    public void setDishBomDtlSpecId(Integer dishBomDtlSpecId) {
        this.dishBomDtlSpecId = dishBomDtlSpecId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getDishBomSpecId() {
        return dishBomSpecId;
    }

    public void setDishBomSpecId(Integer dishBomSpecId) {
        this.dishBomSpecId = dishBomSpecId;
    }

    public Integer getDishBomDtlId() {
        return dishBomDtlId;
    }

    public void setDishBomDtlId(Integer dishBomDtlId) {
        this.dishBomDtlId = dishBomDtlId;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public String getDishBomCode() {
        return dishBomCode;
    }

    public void setDishBomCode(String dishBomCode) {
        this.dishBomCode = dishBomCode == null ? null : dishBomCode.trim();
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public Integer getRmdishId() {
        return rmdishId;
    }

    public void setRmdishId(Integer rmdishId) {
        this.rmdishId = rmdishId;
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
}