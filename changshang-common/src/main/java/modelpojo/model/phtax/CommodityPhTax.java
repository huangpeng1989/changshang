package modelpojo.model.phtax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.quick.clota.commodity.model.phtax
 * @ClassName:CommodityPhTax
 * @Description 商品税率调整单
 * @author: huangpeng
 * @date:2021/2/23 17:11
 */
public class CommodityPhTax implements Serializable {

    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 商品税率调整单id
     */
    private  Integer comPhId;

    /**
     * 供应商id
     */
    private  Integer suppId;

    /**
     * 调整开始时间
     */
    private  Date startDate;

    /**
     * 调整开始时间
     */
    private String startDateStr;


    /**
     * 备注
     */
    private  String remark;


    /**
     * 说明
     */
    private  String description;
    /**
     * 单号
     */
    private  String comPhCode;

    /**
     *状态
     */
    private Integer  phStatus;

    /**
     *审核时间
     */
    private  Date blTime;
    /**
     *审核人
     */
    private  Long blEmpId;

    /**
     *创建人
     */
    private  Long created;

    /**
     *修改人
     */
    private  Long modifier;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 同步状态
     */
    private Integer syncStatus;

    /**
     * 是否删除，0否，1是
     */
    private Integer isDelete;

    /**
     * 调整单详情集合
     */
    private List<CommodityPhTaxDtl> list = new ArrayList<>();

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public List<CommodityPhTaxDtl> getList() {
        return list;
    }

    public void setList(List<CommodityPhTaxDtl> list) {
        this.list = list;
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

    public Integer getComPhId() {
        return comPhId;
    }

    public void setComPhId(Integer comPhId) {
        this.comPhId = comPhId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public String getComPhCode() {
        return comPhCode;
    }

    public void setComPhCode(String comPhCode) {
        this.comPhCode = comPhCode;
    }

    public Integer getPhStatus() {
        return phStatus;
    }

    public void setPhStatus(Integer phStatus) {
        this.phStatus = phStatus;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
