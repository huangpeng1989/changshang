package modelpojo.model.phtax;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName:com.quick.clota.commodity.model.phtax
 * @ClassName:commodity_ph_tax_dtl
 * @Description 商品税率调整单详情
 * @author: huangpeng
 * @date:2021/2/23 17:20
 */
public class CommodityPhTaxDtl implements Serializable {


    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;
    /**
     * 商品税率调整单详情id
     */
    private  Integer comPhDtlId;
    /**
     * 进项税率id
     */
    private  Integer phTaxId;
    /**
     * 进项税率名称
     */
    private  String phTax;
    /**
     * 商品id
     */
    private  Integer comId;
    /**
     * 商品编码
     */
    private  String comCode;

    /**
     * 商品税率调整单id
     */
    private  Integer comPhId;


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
     * 原进项税率名称
     */
    private  String oldPhTax;

    /**
     * 商品详情状态
     */
    private  Integer phStatus;

    /**
     * 商品采购单位
     */
    private  Integer saleCommUnit;

    public Integer getSaleCommUnit() {
        return saleCommUnit;
    }

    public void setSaleCommUnit(Integer saleCommUnit) {
        this.saleCommUnit = saleCommUnit;
    }

    public String getOldPhTax() {
        return oldPhTax;
    }

    public void setOldPhTax(String oldPhTax) {
        this.oldPhTax = oldPhTax;
    }

    public Integer getPhStatus() {
        return phStatus;
    }

    public void setPhStatus(Integer phStatus) {
        this.phStatus = phStatus;
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

    public Integer getComPhDtlId() {
        return comPhDtlId;
    }

    public void setComPhDtlId(Integer comPhDtlId) {
        this.comPhDtlId = comPhDtlId;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public Integer getComPhId() {
        return comPhId;
    }

    public void setComPhId(Integer comPhId) {
        this.comPhId = comPhId;
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
