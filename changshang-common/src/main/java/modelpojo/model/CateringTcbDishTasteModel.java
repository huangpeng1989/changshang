package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringTcbDishTasteModel implements Serializable {
    private Integer dishId;

    private String dishCode;

    private String dishTasteType;

    private String dishTasteName;

    private Integer sort;

    private Long creater;

    private Date createdTime;

    private Long moditer;

    private Date updatedTime;

    private Integer dtStatus;

    private Integer isDelete;
	
	private Integer dishTasteId;

    private Long projectId;

    private Boolean whetherUpdate;//是否更新

    public Boolean getWhetherUpdate() {
        return whetherUpdate;
    }

    public void setWhetherUpdate(Boolean whetherUpdate) {
        this.whetherUpdate = whetherUpdate;
    }

    public Integer getDishTasteId() {
        return dishTasteId;
    }

    public void setDishTasteId(Integer dishTasteId) {
        this.dishTasteId = dishTasteId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public String getDishTasteType() {
        return dishTasteType;
    }

    public void setDishTasteType(String dishTasteType) {
        this.dishTasteType = dishTasteType == null ? null : dishTasteType.trim();
    }

    public String getDishTasteName() {
        return dishTasteName;
    }

    public void setDishTasteName(String dishTasteName) {
        this.dishTasteName = dishTasteName == null ? null : dishTasteName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModiter() {
        return moditer;
    }

    public void setModiter(Long moditer) {
        this.moditer = moditer;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(Integer dtStatus) {
        this.dtStatus = dtStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}