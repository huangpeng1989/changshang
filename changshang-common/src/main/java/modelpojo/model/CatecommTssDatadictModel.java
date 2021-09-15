package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表
 */


public class CatecommTssDatadictModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目ID
    private Long projectId;
    //字典ID
    private Integer dictId;
    //上级ID（字典分组上级id为0）
    private Integer udictId;
    //字典类型(3位数字)
    private String dicType;
    //名称
    private String dictName;
    //类型编码（与其他表关联)
    private Integer dictTpCode;
    //类型值
    private String dictTpValue;
    //类型值
    private Integer isDefault;
    //排序
    private Short dictSort;
    //备注
    private String remark;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //修改人
    private Integer syncStatus;
    //状态
    private Short ddStatus;
    //说明
    private String state;

    public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public Integer getDictTpCode() {
		return dictTpCode;
	}

	public void setDictTpCode(Integer dictTpCode) {
		this.dictTpCode = dictTpCode;
	}

	public String getDictTpValue() {
		return dictTpValue;
	}

	public void setDictTpValue(String dictTpValue) {
		this.dictTpValue = dictTpValue;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Short getDictSort() {
		return dictSort;
	}

	public void setDictSort(Short dictSort) {
		this.dictSort = dictSort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getUdictId() {
        return udictId;
    }

    public void setUdictId(Integer udictId) {
        this.udictId = udictId;
    }

    public Short getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(Short ddStatus) {
        this.ddStatus = ddStatus;
    }
}