package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringTcjSaleadjustModel implements Serializable {
    private Long projectRootId;

    private String adjCode;

    private Integer goodType;

    private Integer gzoneId;

    private Integer adjType;

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

    private Integer status;

    private int isDelete;

    private Integer syncStatus;
	
	private Integer adjId;

    private Long projectId;

    private String nickName;//录入人中文名称

    private String gzoneName;//营业点名称

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private List<CateringTcjSaleadjustDetailModel> detailModelList;

    private List<SaledDishDto> dishDtos;

    private List<SaledRawDto> rawDtos;

    public List<SaledRawDto> getRawDtos() {
        return rawDtos;
    }

    public void setRawDtos(List<SaledRawDto> rawDtos) {
        this.rawDtos = rawDtos;
    }

    public List<SaledDishDto> getDishDtos() {
        return dishDtos;
    }

    public void setDishDtos(List<SaledDishDto> dishDtos) {
        this.dishDtos = dishDtos;
    }

    public List<CateringTcjSaleadjustDetailModel> getDetailModelList() {
        return detailModelList;
    }

    public void setDetailModelList(List<CateringTcjSaleadjustDetailModel> detailModelList) {
        this.detailModelList = detailModelList;
    }

    public Integer getAdjId() {
        return adjId;
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

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getAdjType() {
        return adjType;
    }

    public void setAdjType(Integer adjType) {
        this.adjType = adjType;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}