package modelpojo.model;

import modelpojo.vo.CateringAdjustDetailVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringTcjAdjust implements Serializable {

    private static final long serialVersionUID = 7585428103173394975L;
    private Integer adjId;

    private Long projectId;
    private Long projectRootId;

    private String adjCode;

    private Integer adjType;

    private Integer promotionId;

    private Date startDate;

    private Date endDate;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Long blEmpId;

    private Date blTime;

    private Integer adjStatus;

    private Byte isDelete;

    private Integer syncStatus;


    List<CateringTcjAdjustDetail> caterAdjustDetailList;

    List<CateringAdjustDetailVo> CateringAdjustDetailVoList;

    public List<CateringAdjustDetailVo> getCateringAdjustDetailVoList() {
        return CateringAdjustDetailVoList;
    }

    public void setCateringAdjustDetailVoList(List<CateringAdjustDetailVo> cateringAdjustDetailVoList) {
        CateringAdjustDetailVoList = cateringAdjustDetailVoList;
    }

    public Integer getAdjId() {
        return adjId;
    }

    public List<CateringTcjAdjustDetail> getCaterAdjustDetailList() {
        return caterAdjustDetailList;
    }

    public void setCaterAdjustDetailList(List<CateringTcjAdjustDetail> caterAdjustDetailList) {
        this.caterAdjustDetailList = caterAdjustDetailList;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
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
