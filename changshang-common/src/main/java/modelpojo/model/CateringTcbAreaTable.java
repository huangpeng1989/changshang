package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcbAreaTable implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectRootId;
    
    private Integer areaTableId;

    private Long projectId;
    
    private String areaTableCode;

    private String areaTableName;

    private Integer areaTypeId;
    
    private Integer sellPointId;

    private Integer numPeople;

    private BigDecimal minExpense;

    private Byte isJoinTable;

    private Byte isMergeTable;

    private Byte isJoin;

    private Integer joinPeopleNum;

    private Byte isUseing;

    private String remark;

    private Date createdTime;

    private Long creater;

    private Long blEmpId;

    private Date blTime;

    private Long modifier;

    private Date updatedTime;
    
    private Byte isDelete;
    
    private Integer syncStatus;
    
    public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public Integer getSellPointId() {
		return sellPointId;
	}

	public void setSellPointId(Integer sellPointId) {
		this.sellPointId = sellPointId;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getAreaTableId() {
		return areaTableId;
	}

	public void setAreaTableId(Integer areaTableId) {
		this.areaTableId = areaTableId;
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

	public String getAreaTableCode() {
        return areaTableCode;
    }

    public void setAreaTableCode(String areaTableCode) {
        this.areaTableCode = areaTableCode == null ? null : areaTableCode.trim();
    }

    public String getAreaTableName() {
        return areaTableName;
    }

    public void setAreaTableName(String areaTableName) {
        this.areaTableName = areaTableName == null ? null : areaTableName.trim();
    }

    public Integer getAreaTypeId() {
        return areaTypeId;
    }

    public void setAreaTypeId(Integer areaTypeId) {
        this.areaTypeId = areaTypeId;
    }

    public Integer getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(Integer numPeople) {
        this.numPeople = numPeople;
    }

    public BigDecimal getMinExpense() {
        return minExpense;
    }

    public void setMinExpense(BigDecimal minExpense) {
        this.minExpense = minExpense;
    }

    public Byte getIsJoinTable() {
        return isJoinTable;
    }

    public void setIsJoinTable(Byte isJoinTable) {
        this.isJoinTable = isJoinTable;
    }

    public Byte getIsMergeTable() {
        return isMergeTable;
    }

    public void setIsMergeTable(Byte isMergeTable) {
        this.isMergeTable = isMergeTable;
    }

    public Byte getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Byte isJoin) {
        this.isJoin = isJoin;
    }

    public Integer getJoinPeopleNum() {
        return joinPeopleNum;
    }

    public void setJoinPeopleNum(Integer joinPeopleNum) {
        this.joinPeopleNum = joinPeopleNum;
    }

    public Byte getIsUseing() {
        return isUseing;
    }

    public void setIsUseing(Byte isUseing) {
        this.isUseing = isUseing;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}