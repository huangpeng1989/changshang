package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CommoditySaledComBill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer comBillId;

    private Long projectId;
	
    private Long projectRootId;

    private Integer saleComCount;

    private String comBillCode;

    private Integer gradeId;

    private String comBillName;

    private Byte isDelete;

    private String state;

    private String remark;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;
    
    private Integer syncStatus;

    public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public Integer getComBillId() {
		return comBillId;
	}

	public void setComBillId(Integer comBillId) {
		this.comBillId = comBillId;
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

    public Integer getSaleComCount() {
        return saleComCount;
    }

    public void setSaleComCount(Integer saleComCount) {
        this.saleComCount = saleComCount;
    }

    public String getComBillCode() {
        return comBillCode;
    }

    public void setComBillCode(String comBillCode) {
        this.comBillCode = comBillCode == null ? null : comBillCode.trim();
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getComBillName() {
        return comBillName;
    }

    public void setComBillName(String comBillName) {
        this.comBillName = comBillName == null ? null : comBillName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
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

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}