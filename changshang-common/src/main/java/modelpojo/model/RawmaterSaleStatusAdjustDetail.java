package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 原材料销售状态调价表子表
 */
public class RawmaterSaleStatusAdjustDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	//项目ID
    private Long projectId;
    //项目根节点ID
    private Long projectRootId;
    //调价单子表id
    private Integer addId;
    //调价单id
    private Integer adjId;
    //调价单号
    private String adjCode;
    //原材料主键ID
    private Integer rmId;
    //原材料编号
    private String rmCode;
    //原材料名称
    private String rmName;
    //原销售状态
    private Integer oldSellStatus;
    //新销售状态
    private Integer newSellStatus;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //调价单状态
    private Integer status;
    //是否删除 0否  1是
    private Byte isDelete;
    //同步状态 10未同步 20同步中 30已同步
    private Integer syncStatus;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
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

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public Integer getOldSellStatus() {
        return oldSellStatus;
    }

    public void setOldSellStatus(Integer oldSellStatus) {
        this.oldSellStatus = oldSellStatus;
    }

    public Integer getNewSellStatus() {
        return newSellStatus;
    }

    public void setNewSellStatus(Integer newSellStatus) {
        this.newSellStatus = newSellStatus;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}