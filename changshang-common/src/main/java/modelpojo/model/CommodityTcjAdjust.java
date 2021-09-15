package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 进价调价表
 */
public class CommodityTcjAdjust implements Serializable {
    private static final long serialVersionUID = -6880870860289510610L;
    //项目Id
    private Long projectId;
    //调价单id
    private Integer adjId;
    //调价单号
    private String adjCode;
    //调价方式
    private Integer adjType;

    public String getAdjTypeName() {
        return adjTypeName;
    }

    public void setAdjTypeName(String adjTypeName) {
        this.adjTypeName = adjTypeName;
    }

    private String  adjTypeName;

    public String getAdjTypeStr() {
        return adjTypeStr;
    }

    public void setAdjTypeStr(String adjTypeStr) {
        this.adjTypeStr = adjTypeStr;
    }

    private String adjTypeStr;
    //促销单id
    private Integer promotionId;

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    private Long projectRootId;
    //调价开始日期
    private Date startDate;
    //调价结束日期
    private Date endDate;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updateTime;
    //修改人
    private Long modifier;
    //审核人
    private Long blEmpId;
    //审核时间
    private Date blTime;
    //状态
    private Integer adjStatus;

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    private String createrStr;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer pageNo;
    private Integer pageSize;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    // 是否删除  0否 1是
    private Integer isDelete;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
        this.adjCode = adjCode == null ? null : adjCode.trim();
    }

    public Integer getAdjType() {
        return adjType;
    }

    public void setAdjType(Integer adjType) {
        this.adjType = adjType;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public void setBLEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBLTime(Date BlTime) {
        this.blTime = BlTime;
    }

    public Integer getAdjStatus() {
        return adjStatus;
    }

    public void setAdjStatus(Integer adjStatus) {
        this.adjStatus = adjStatus;
    }
}
