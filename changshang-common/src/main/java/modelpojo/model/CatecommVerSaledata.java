package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CatecommVerSaledata implements Serializable {

    private Long projectId;

    private Integer saleIntDate;

    private Integer gzoneId;

    private BigDecimal dealNum;

    private BigDecimal saleNum;

    private BigDecimal saleAmount;

    private Date saleDate;

    private Date createdTime;

    private Date updatedTime;

    private Date syncTime;

    private Integer moduleId;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSaleIntDate() {
        return saleIntDate;
    }

    public void setSaleIntDate(Integer saleIntDate) {
        this.saleIntDate = saleIntDate;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public BigDecimal getDealNum() {
        return dealNum;
    }

    public void setDealNum(BigDecimal dealNum) {
        this.dealNum = dealNum;
    }

    public BigDecimal getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(BigDecimal saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
