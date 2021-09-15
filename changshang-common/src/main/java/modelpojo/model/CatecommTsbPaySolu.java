package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CatecommTsbPaySolu implements Serializable {
    private static final long serialVersionUID = 7964362210025113642L;
    private Long projectRootId;

    private String paySoluCode;

     private Integer paySoluId;

    private Long projectId;

    private String paySoluName;

    private String sort;

    private Byte isStartUsing;

    private Byte isDelete;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Integer syncStatus;


    public List<CatecommTsbPaySoluDetail> getSoluDetailList() {
        return soluDetailList;
    }

    public void setSoluDetailList(List<CatecommTsbPaySoluDetail> soluDetailList) {
        this.soluDetailList = soluDetailList;
    }

    List<CatecommTsbPaySoluDetail> soluDetailList;

    public Integer getPaySoluId() {
        return paySoluId;
    }

    public void setPaySoluId(Integer paySoluId) {
        this.paySoluId = paySoluId;
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

    public String getPaySoluCode() {
        return paySoluCode;
    }

    public void setPaySoluCode(String paySoluCode) {
        this.paySoluCode = paySoluCode == null ? null : paySoluCode.trim();
    }

    public String getPaySoluName() {
        return paySoluName;
    }

    public void setPaySoluName(String paySoluName) {
        this.paySoluName = paySoluName == null ? null : paySoluName.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Byte getIsStartUsing() {
        return isStartUsing;
    }

    public void setIsStartUsing(Byte isStartUsing) {
        this.isStartUsing = isStartUsing;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
