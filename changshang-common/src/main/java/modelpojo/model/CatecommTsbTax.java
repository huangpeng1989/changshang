package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CatecommTsbTax implements Serializable{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long projectRootId;

    private Long projectId;

    private Integer taxId;

    private String taxName;

    private BigDecimal conToFreeTax;

    private BigDecimal freeToConTax;

    private Byte conToFreeNum;

    private Byte freeToConNum;

    private Integer tStatus;


    private String tStatusStr;  //状态 0：启动  10 禁用

    private Long modifier;

    private Date updatedTime;

    private Long creater;

    private Date createdTime;

    private Date blTime;

    private Long blEmpId;

    private Byte isDelete;

    private Integer syncStatus;

    public String gettStatusStr() {
        return tStatusStr;
    }

    public void settStatusStr(String tStatusStr) {
        this.tStatusStr = tStatusStr;
    }


    public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getTaxId() {
		return taxId;
	}

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName == null ? null : taxName.trim();
    }

    public BigDecimal getConToFreeTax() {
        return conToFreeTax;
    }

    public void setConToFreeTax(BigDecimal conToFreeTax) {
        this.conToFreeTax = conToFreeTax;
    }

    public BigDecimal getFreeToConTax() {
        return freeToConTax;
    }

    public void setFreeToConTax(BigDecimal freeToConTax) {
        this.freeToConTax = freeToConTax;
    }

    public Byte getConToFreeNum() {
        return conToFreeNum;
    }

    public void setConToFreeNum(Byte conToFreeNum) {
        this.conToFreeNum = conToFreeNum;
    }

    public Byte getFreeToConNum() {
        return freeToConNum;
    }

    public void setFreeToConNum(Byte freeToConNum) {
        this.freeToConNum = freeToConNum;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
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

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreateTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
