package modelpojo.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class CatecommTsbGzoneBushours implements Serializable{
    private Long projectRootId;

    private Integer gzoneId;

    private String gzBhName;

    private Time gzBhStartTime;

    private Time gzBhEndTime;

    private Byte isDelete;

    private String sort;

    private Byte isStartUse;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Integer syncStatus;

	 private Integer gzBhId;

    private Long projectId;

    public Integer getGzBhId() {
        return gzBhId;
    }

    public void setGzBhId(Integer gzBhId) {
        this.gzBhId = gzBhId;
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

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getGzBhName() {
        return gzBhName;
    }

    public void setGzBhName(String gzBhName) {
        this.gzBhName = gzBhName == null ? null : gzBhName.trim();
    }

    public Time getGzBhStartTime() {
        return gzBhStartTime;
    }

    public void setGzBhStartTime(Time gzBhStartTime) {
        this.gzBhStartTime = gzBhStartTime;
    }

    public Time getGzBhEndTime() {
        return gzBhEndTime;
    }

    public void setGzBhEndTime(Time gzBhEndTime) {
        this.gzBhEndTime = gzBhEndTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Byte getIsStartUse() {
        return isStartUse;
    }

    public void setIsStartUse(Byte isStartUse) {
        this.isStartUse = isStartUse;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}