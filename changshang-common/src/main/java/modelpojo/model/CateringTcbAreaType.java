package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringTcbAreaType implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectRootId;
    
    private Integer areaTypeId;

    private Long projectId;

    private String areaTypeCode;

    private String areaTypeName;

    private String dtlLocation;

    private Integer sellPointId;

    private String remark;

    private String state;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Long blEmpId;

    private Date blTime;

    private Byte isDelete;

    private Integer status;
    
    private Integer syncStatus;

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public Integer getAreaTypeId() {
		return areaTypeId;
	}

	public void setAreaTypeId(Integer areaTypeId) {
		this.areaTypeId = areaTypeId;
	}

    public Long getProjectRootId() {
		return projectRootId;
	}

	public void setProjectRootId(Long projectRootId) {
		this.projectRootId = projectRootId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getAreaTypeCode() {
        return areaTypeCode;
    }

    public void setAreaTypeCode(String areaTypeCode) {
        this.areaTypeCode = areaTypeCode == null ? null : areaTypeCode.trim();
    }

    public String getAreaTypeName() {
        return areaTypeName;
    }

    public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName == null ? null : areaTypeName.trim();
    }

    public String getDtlLocation() {
        return dtlLocation;
    }

    public void setDtlLocation(String dtlLocation) {
        this.dtlLocation = dtlLocation == null ? null : dtlLocation.trim();
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}