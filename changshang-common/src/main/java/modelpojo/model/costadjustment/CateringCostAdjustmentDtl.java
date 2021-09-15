package modelpojo.model.costadjustment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:com.quick.clota.commodity.model.costadjustment
 * @ClassName:CateringCostAdjustmentDtl
 * @Description
 * @author: huangpeng
 * @date:2021/3/22 13:56
 */
public class CateringCostAdjustmentDtl implements Serializable {

    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 调整单详情id
     */
    private Integer costDtlId;
    /**
     * 调整单id
     */
    private Integer costId;
    /**
     * 原材料半成品
     */
    private Integer rmDishId;
    /**
     * 原材料半成品单位
     */
    private Integer rmDishUnit;
    /**
     * 调整 数量
     */
    private BigDecimal count;

    /**
     * 类型
     */
    private Integer goodType;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 同步状态
     */
    private Integer syncStatus;

    /**
     * 是否删除，0否，1是
     */
    private Integer isDelete;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getCostDtlId() {
        return costDtlId;
    }

    public void setCostDtlId(Integer costDtlId) {
        this.costDtlId = costDtlId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public Integer getRmDishUnit() {
        return rmDishUnit;
    }

    public void setRmDishUnit(Integer rmDishUnit) {
        this.rmDishUnit = rmDishUnit;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
