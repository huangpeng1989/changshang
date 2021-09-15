package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhIvtSpecBill implements Serializable {

    private Long projectId;

    private Long projectRootId;

    private Integer ivtId;

    private Integer rmId;

    private Integer pSrmId;

    private Integer pSrmUnit;

    private String pSrmCode;

    private BigDecimal pSrmPackContent;

    private String specName;

    private BigDecimal ivtCount;

    private BigDecimal minIvtCount;

    private Integer moduleId;

    private Integer goodType;

    private Integer isDelete;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;


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

    public Integer getIvtId() {
        return ivtId;
    }

    public void setIvtId(Integer ivtId) {
        this.ivtId = ivtId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getpSrmId() {
        return pSrmId;
    }

    public void setpSrmId(Integer pSrmId) {
        this.pSrmId = pSrmId;
    }

    public Integer getpSrmUnit() {
        return pSrmUnit;
    }

    public void setpSrmUnit(Integer pSrmUnit) {
        this.pSrmUnit = pSrmUnit;
    }

    public String getpSrmCode() {
        return pSrmCode;
    }

    public void setpSrmCode(String pSrmCode) {
        this.pSrmCode = pSrmCode;
    }

    public BigDecimal getpSrmPackContent() {
        return pSrmPackContent;
    }

    public void setpSrmPackContent(BigDecimal pSrmPackContent) {
        this.pSrmPackContent = pSrmPackContent;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigDecimal getIvtCount() {
        return ivtCount;
    }

    public void setIvtCount(BigDecimal ivtCount) {
        this.ivtCount = ivtCount;
    }

    public BigDecimal getMinIvtCount() {
        return minIvtCount;
    }

    public void setMinIvtCount(BigDecimal minIvtCount) {
        this.minIvtCount = minIvtCount;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
