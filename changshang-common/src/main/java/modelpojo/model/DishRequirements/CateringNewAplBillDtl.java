package modelpojo.model.DishRequirements;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringNewAplBillDtl implements Serializable {



    private Long projectRootId;

    private Long projectId;

    private Integer aplBillId;

    private Integer aplBillDtlId;

    private Integer rmDishId;

    private Integer dishBomId;

    private String rmDishCode;

    private Integer rmDishUnit;

    private String rmDishBarcode;

    private BigDecimal allotNum;

    private BigDecimal aplNum;

    private Integer aplResult;

    private Integer goodType;

    private String rejectResion;

    private String remark;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer specId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAplBillId() {
        return aplBillId;
    }

    public void setAplBillId(Integer aplBillId) {
        this.aplBillId = aplBillId;
    }

    public Integer getAplBillDtlId() {
        return aplBillDtlId;
    }

    public void setAplBillDtlId(Integer aplBillDtlId) {
        this.aplBillDtlId = aplBillDtlId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public String getRmDishCode() {
        return rmDishCode;
    }

    public void setRmDishCode(String rmDishCode) {
        this.rmDishCode = rmDishCode;
    }

    public Integer getRmDishUnit() {
        return rmDishUnit;
    }

    public void setRmDishUnit(Integer rmDishUnit) {
        this.rmDishUnit = rmDishUnit;
    }

    public String getRmDishBarcode() {
        return rmDishBarcode;
    }

    public void setRmDishBarcode(String rmDishBarcode) {
        this.rmDishBarcode = rmDishBarcode;
    }

    public BigDecimal getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(BigDecimal allotNum) {
        this.allotNum = allotNum;
    }

    public BigDecimal getAplNum() {
        return aplNum;
    }

    public void setAplNum(BigDecimal aplNum) {
        this.aplNum = aplNum;
    }

    public Integer getAplResult() {
        return aplResult;
    }

    public void setAplResult(Integer aplResult) {
        this.aplResult = aplResult;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getRejectResion() {
        return rejectResion;
    }

    public void setRejectResion(String rejectResion) {
        this.rejectResion = rejectResion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }
}