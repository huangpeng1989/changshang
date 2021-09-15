package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐商基础信息操作日志表
 */
public class BasicDataLog implements Serializable {

    private static final long serialVersionUID = 8218351908377260590L;
    private Integer logId;

    private Long projectId;
    private Integer dataType;

    private Integer logTyoe;

    private Integer infoId;

    private String content;

    private Long creater;

    private Date createdTime;
    private Date updatedTime;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getLogTyoe() {
        return logTyoe;
    }

    public void setLogTyoe(Integer logTyoe) {
        this.logTyoe = logTyoe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
}
