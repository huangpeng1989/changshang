package modelpojo.model.contract;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-12-31
 */
public class CatecommCntractEnclosure implements Serializable {

    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 合同附件id
     */
    private Integer cntractEnclosureId;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 合同模块，10餐饮，20，商品
     */
    private Integer contractMode;

    /**
     * 合同附件路径
     */
    private String contractUrl;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 是否删除，0否，1是
     */
    private Integer isDelete;

    /**
     * 合同附件同步状态
     */
    private Integer syncStatus;

    /**
     * 创建人
     */
    private Long modifier;

    /**
     * 修改人
     */
    private Long creater;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getCntractEnclosureId() {
        return cntractEnclosureId;
    }

    public void setCntractEnclosureId(Integer cntractEnclosureId) {
        this.cntractEnclosureId = cntractEnclosureId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getContractMode() {
        return contractMode;
    }

    public void setContractMode(Integer contractMode) {
        this.contractMode = contractMode;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl == null ? null : contractUrl.trim();
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }
}