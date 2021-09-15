package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 供应商分类表
 */
public class CommodityTccSuppclassModel implements Serializable {
    //项目ID
    private Long projectId;

    //项目根节点id
    private Long projectRootId;

    //供应商分类ID
    private Integer suppId;
    //供应商分类编号
    private String suppClassCode;
    //供应商分类名称
    private String suppClassName;
    //上级分类ID
    private Integer usuppId;
    //上级分类编号
    private String usuppClassCode;
    //上级分类名称
    private String usuppClassName;
    //备注
    private String remark;
    //备注
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
    private Long blEmpID;
    //审核时间
    private Date blTime;
    //状态
    private Integer scStatus;

    private Integer isDelete;

    private List<CommodityTccSuppclassModel> Children;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getSuppClassCode() {
        return suppClassCode;
    }

    public void setSuppClassCode(String suppClassCode) {
        this.suppClassCode = suppClassCode;
    }

    public String getSuppClassName() {
        return suppClassName;
    }

    public void setSuppClassName(String suppClassName) {
        this.suppClassName = suppClassName;
    }

    public Integer getUsuppId() {
        return usuppId;
    }

    public void setUsuppId(Integer usuppId) {
        this.usuppId = usuppId;
    }

    public String getUsuppClassCode() {
        return usuppClassCode;
    }

    public void setUsuppClassCode(String usuppClassCode) {
        this.usuppClassCode = usuppClassCode;
    }

    public String getUsuppClassName() {
        return usuppClassName;
    }

    public void setUsuppClassName(String usuppClassName) {
        this.usuppClassName = usuppClassName;
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

    public Long getBlEmpID() {
        return blEmpID;
    }

    public void setBlEmpID(Long blEmpID) {
        this.blEmpID = blEmpID;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<CommodityTccSuppclassModel> getChildren() {
        return Children;
    }

    public void setChildren(List<CommodityTccSuppclassModel> children) {
        Children = children;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }
}