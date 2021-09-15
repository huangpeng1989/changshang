package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommoditySaledComBillDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer comBillDetailId;

    private Long projectId;
	
    private Long projectRootId;

    private Integer comBillId;

    private Integer comId;

    private Integer gradeId;
    
    private Integer gpId;
    
    private Integer saleComId;

    private BigDecimal retailPrice;

    private Byte isSaleStatus;

    private Byte isDelete;

    private Integer status;

    private Long creater;

    private Date createdTime;

    private Date updatedTime;

    private Long modifier;

    private String remark;

    private String state;
    
    private Integer syncStatus;

    private BigDecimal oldRetailPrice;

    private Integer updateIndex;//0 表示原始数据，1表示新增数据

    public Integer getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Integer updateIndex) {
        this.updateIndex = updateIndex;
    }

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getSaleComId() {
		return saleComId;
	}

	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}

	public Integer getGpId() {
		return gpId;
	}

	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}

	public Integer getComBillDetailId() {
		return comBillDetailId;
	}

	public void setComBillDetailId(Integer comBillDetailId) {
		this.comBillDetailId = comBillDetailId;
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

    public Integer getComBillId() {
        return comBillId;
    }

    public void setComBillId(Integer comBillId) {
        this.comBillId = comBillId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Byte getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(Byte isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
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

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

}