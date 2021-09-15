package modelpojo.model.costadjustment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:com.quick.clota.commodity.model.costadjustment
 * @ClassName:CateringCostAdjustmentDtl
 * @Description
 * @author: LK
 * @date:2021/3/25 13:56
 */
public class CommodityCostAdjustmentDtl implements Serializable {

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
     * 商品ID
     */
    private Integer comId;
    /**
     * 商品单位
     */
    private Integer comUnit;
    /**
     * 调整 数量
     */
    private BigDecimal count;

    /**
     * 当前库存数量
     */
    private BigDecimal stock;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     *创建人
     */
    private  Long created;

    /**
     *修改人
     */
    private  Long modifier;

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

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }
}
