package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品扣率调价表
 */
public class CommodityRateAdjust implements Serializable{

	private static final long serialVersionUID = 1L;
	//项目ID
    private Long projectId;
    //项目根节点ID
    private Long projectRootId;
    //调价单id
    private Integer adjId;
    //调价单号
    private String adjCode;
    //调价开始日期
    private Date startDate;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //审核人
    private Long blEmpId;
    //审核时间
    private Date blTime;
    //调价单状态
    private Integer adjStatus;
    //是否删除 0否  1是
    private Byte isDelete;
    //同步状态 10未同步 20同步中 30已同步
    private Integer syncStatus;

    List<CommodityRateAdjustDetail> comRateAdjustDetailList;

    public List<CommodityRateAdjustDetail> getComRateAdjustDetailList() {
        return comRateAdjustDetailList;
    }

    public void setComRateAdjustDetailList(List<CommodityRateAdjustDetail> comRateAdjustDetailList) {
        this.comRateAdjustDetailList = comRateAdjustDetailList;
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

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Integer getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(Integer adjStatus) {
        this.adjStatus = adjStatus;
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
}