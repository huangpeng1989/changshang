package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 原材料分类
 */
public class CateringTccRawmaterClass implements Serializable {
    private static final long serialVersionUID = 5290321141451057263L;
    private Long projectId;

    private Integer rmcId;


    private Long projectRootId;

    private String rmcCode;

    private String rmcName;

    private Integer urmcId;

    private String urmcCode;

    private String urmcName;

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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;

    //税务编码
    private String taxCode;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public List<CateringTccRawmaterClass> getChildren() {
        return Children;
    }

    public void setChildren(List<CateringTccRawmaterClass> children) {
        Children = children;
    }

    private List<CateringTccRawmaterClass> Children;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRmcId() {
        return rmcId;
    }

    public void setRmcId(Integer rmcId) {
        this.rmcId = rmcId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getRmcCode() {
        return rmcCode;
    }

    public void setRmcCode(String rmcCode) {
        this.rmcCode = rmcCode == null ? null : rmcCode.trim();
    }

    public String getRmcName() {
        return rmcName;
    }

    public void setRmcName(String rmcName) {
        this.rmcName = rmcName == null ? null : rmcName.trim();
    }

    public Integer getUrmcId() {
        return urmcId;
    }

    public void setUrmcId(Integer urmcId) {
        this.urmcId = urmcId;
    }

    public String getUrmcCode() {
        return urmcCode;
    }

    public void setUrmcCode(String urmcCode) {
        this.urmcCode = urmcCode == null ? null : urmcCode.trim();
    }

    public String getUrmcName() {
        return urmcName;
    }

    public void setUrmcName(String urmcName) {
        this.urmcName = urmcName == null ? null : urmcName.trim();
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
