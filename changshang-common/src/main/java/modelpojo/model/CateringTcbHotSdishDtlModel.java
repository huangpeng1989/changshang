package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringTcbHotSdishDtlModel implements Serializable {

    private static final long serialVersionUID = -5072414114267211723L;
    private Integer gzoneId;

    private Integer hsdDtlId;

    private Long projectId;
    private Long projectRootId;

    private String gzoneCode;

    private Integer rmDishId;

    private String rmDishCode;

    private Integer dishSpecId;

    private Integer specId;

    private Date hsdStartDate;

    private Date hsdEndDate;

    private Byte isFov;

    private BigDecimal hsdScore;

    private Integer goodType;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Byte isDelete;
    private Integer delete;

    private String remark;

    private String state;

    private Integer syncStatus;

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getHsdDtlId() {
        return hsdDtlId;
    }

    public void setHsdDtlId(Integer hsdDtlId) {
        this.hsdDtlId = hsdDtlId;
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

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode == null ? null : gzoneCode.trim();
    }

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public String getRmDishCode() {
        return rmDishCode;
    }

    public void setRmDishCode(String rmDishCode) {
        this.rmDishCode = rmDishCode == null ? null : rmDishCode.trim();
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Date getHsdStartDate() {
        return hsdStartDate;
    }

    public void setHsdStartDate(Date hsdStartDate) {
        this.hsdStartDate = hsdStartDate;
    }

    public Date getHsdEndDate() {
        return hsdEndDate;
    }

    public void setHsdEndDate(Date hsdEndDate) {
        this.hsdEndDate = hsdEndDate;
    }

    public Byte getIsFov() {
        return isFov;
    }

    public void setIsFov(Byte isFov) {
        this.isFov = isFov;
    }

    public BigDecimal getHsdScore() {
        return hsdScore;
    }

    public void setHsdScore(BigDecimal hsdScore) {
        this.hsdScore = hsdScore;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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
