package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringTcbCookHouseDetailModel implements Serializable {
    private Long projectId;

    private Long projectRootId;

    private Integer cookHouseId;

    private Integer cookHouseDetailId;

    private Integer dishId;

    private String dishName;

    private String dishCode;

    private String dishClassCode;

    private Integer dishType;

    private Integer dishUnit;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Integer isDelete;

    private Integer syncStatus;

    private Integer gzoneId;

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
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

    public Integer getCookHouseId() {
        return cookHouseId;
    }

    public void setCookHouseId(Integer cookHouseId) {
        this.cookHouseId = cookHouseId;
    }

    public Integer getCookHouseDetailId() {
        return cookHouseDetailId;
    }

    public void setCookHouseDetailId(Integer cookHouseDetailId) {
        this.cookHouseDetailId = cookHouseDetailId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}