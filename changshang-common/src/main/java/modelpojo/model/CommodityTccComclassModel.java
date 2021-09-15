package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品分类表
 */
public class CommodityTccComclassModel implements Serializable {

    private static final long serialVersionUID = 5290321141451057263L;

    //项目ID
    private Long projectId;
    //项目根节点Id
    private Long projectRootId;
    //分类ID
    private Integer comClassId;
    //商品分类编号
    private String comClassCode;
    //商品分类名称
    private String comClassName;
    //上级分类ID
    private Integer ucomClassId;
    //上级分类编号
    private String ucomClassCode;
    //上级分类名称
    private String ucomClassName;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //审核人
    private Long blEmpId;
    //审核时间
    private Date blTime;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //状态
    private Integer ccStatus;

    private Integer isDelete;

    //是否同步
    private Integer syncStatus;

    //税务编码
    private String taxCode;

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

    private List<CommodityTccComclassModel> children;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public Integer getUcomClassId() {
        return ucomClassId;
    }

    public void setUcomClassId(Integer ucomClassId) {
        this.ucomClassId = ucomClassId;
    }

    public String getUcomClassCode() {
        return ucomClassCode;
    }

    public void setUcomClassCode(String ucomClassCode) {
        this.ucomClassCode = ucomClassCode;
    }

    public String getUcomClassName() {
        return ucomClassName;
    }

    public void setUcomClassName(String ucomClassName) {
        this.ucomClassName = ucomClassName;
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

    public List<CommodityTccComclassModel> getChildren() {
        return children;
    }

    public void setChildren(List<CommodityTccComclassModel> children) {
        this.children = children;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }
}