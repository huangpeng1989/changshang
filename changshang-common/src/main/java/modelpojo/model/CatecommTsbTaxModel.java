package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CatecommTsbTaxModel implements Serializable{
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

    private Long modifier;

    private Date updTime;

    private Long creater;

    private Date createTime;

    private Date blTime;

    private Long blEmpId;

    private String isDelete;

    public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getTaxId() {
		return taxId;
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

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}