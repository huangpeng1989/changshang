package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CateringTccDishesClassModel implements Serializable {
    private Long projectRootId;

    private String dishClassCode;

    private String dishClassName;

    private Integer udishId;

    private String udishClassCode;

    private String udishClassName;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Long blEmpId;

    private Date blTime;

    private Date updatedTime;

    private Long modifier;

    private Integer ccStatus;

    private Integer isDelete;
	
	private Integer dishId;

    private Long projectId;

    private Integer syncStatus;

    private String taxCode;//新加字段税务编码

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private List<CateringTccDishesClassModel> children;

    public List<CateringTccDishesClassModel> getChildren() {
        return children;
    }

    public void setChildren(List<CateringTccDishesClassModel> children) {
        this.children = children;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode == null ? null : dishClassCode.trim();
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName == null ? null : dishClassName.trim();
    }

    public Integer getUdishId() {
        return udishId;
    }

    public void setUdishId(Integer udishId) {
        this.udishId = udishId;
    }

    public String getUdishClassCode() {
        return udishClassCode;
    }

    public void setUdishClassCode(String udishClassCode) {
        this.udishClassCode = udishClassCode == null ? null : udishClassCode.trim();
    }

    public String getUdishClassName() {
        return udishClassName;
    }

    public void setUdishClassName(String udishClassName) {
        this.udishClassName = udishClassName == null ? null : udishClassName.trim();
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

    public Integer getCcStatus() {
        return ccStatus;
    }

    public void setCcStatus(Integer ccStatus) {
        this.ccStatus = ccStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}