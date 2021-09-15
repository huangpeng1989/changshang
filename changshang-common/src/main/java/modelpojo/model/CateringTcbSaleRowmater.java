package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 原材料包装信息
 */
public class CateringTcbSaleRowmater implements Serializable {

    private static final long serialVersionUID = 7654164068478978956L;
    private Long projectId;

    private Integer srmId;


    private String srmCode;

    private Integer rmId;

    private String rmCode;

    private BigDecimal packContent = BigDecimal.ZERO;

    private Integer srmUnit;

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    private String  srmUnitName;
    private String  isDeleteStr; //状态 1：淘汰 2：正常
    private String saleType;

    private Integer isDefault;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Integer srmStatus;

    private Integer isDelete;

    //是否采购单位 0否1是
    private Integer isPurChaseUnit;

    public Integer getIsPurChaseUnit() {
        return isPurChaseUnit;
    }

    public void setIsPurChaseUnit(Integer isPurChaseUnit) {
        this.isPurChaseUnit = isPurChaseUnit;
    }

    public Integer getIsInOutSpec() {
        return isInOutSpec;
    }

    public void setIsInOutSpec(Integer isInOutSpec) {
        this.isInOutSpec = isInOutSpec;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    private Integer isInOutSpec;
    private String rmBarcode;

    //状态 0：正常 1：淘汰
    private String isNormal;

    public String getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getIsDeleteStr() {
        return isDeleteStr;
    }

    public void setIsDeleteStr(String isDeleteStr) {
        this.isDeleteStr = isDeleteStr;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    private String createrStr;

      public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode == null ? null : srmCode.trim();
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
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getSrmStatus() {
        return srmStatus;
    }

    public void setSrmStatus(Integer srmStatus) {
        this.srmStatus = srmStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
