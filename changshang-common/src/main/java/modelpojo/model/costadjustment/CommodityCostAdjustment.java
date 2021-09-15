package modelpojo.model.costadjustment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.quick.clota.commodity.model.costadjustment
 * @ClassName:CaterCostAdjustment
 * @Description
 * @author: LK
 * @date:2021/3/25 13:49
 */
public class CommodityCostAdjustment implements Serializable {

    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 调整单id
     */
    private Integer costId;

    /**
     * 调整单编码
     */
    private String costCode;

    /**
     * 调整单仓库
     */
    private Integer whId;

    /**
     * 调整人
     */
    private Long costEmpId;

    /**
     * 调整日期
     */
    private Date costDate;

    /**
     * 账期id
     */
    private Integer paymentDaysId;

    /**
     * 账期名称
     */
    private String paymentName;

    private Date paymentDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 说明
     */
    private String stats;


    /**
     * 审核状态
     */
    private Integer costStatus;

    /**
     *审核时间
     */
    private Date blTime;
    /**
     *审核人
     */
    private  Long blEmpId;

    /**
     *创建人
     */
    private  Long created;

    /**
     *修改人
     */
    private  Long modifier;

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

    private List<CommodityCostAdjustmentDtl> list = new ArrayList<>();

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public List<CommodityCostAdjustmentDtl> getList() {
        return list;
    }

    public void setList(List<CommodityCostAdjustmentDtl> list) {
        this.list = list;
    }

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

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Long getCostEmpId() {
        return costEmpId;
    }

    public void setCostEmpId(Long costEmpId) {
        this.costEmpId = costEmpId;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    public Integer getPaymentDaysId() {
        return paymentDaysId;
    }

    public void setPaymentDaysId(Integer paymentDaysId) {
        this.paymentDaysId = paymentDaysId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public Integer getCostStatus() {
        return costStatus;
    }

    public void setCostStatus(Integer costStatus) {
        this.costStatus = costStatus;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
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
