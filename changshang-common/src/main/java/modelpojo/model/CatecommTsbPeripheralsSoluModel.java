package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CatecommTsbPeripheralsSoluModel implements Serializable {
    private Long projectRootId;

    private String pSoluCode;

    private String pSoluName;

    private Integer isDelete;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;
	
	private Integer pSoluId;

    private Long projectId;

    private String statusStr;

    private String remark;

    private Integer deviceTypeId;

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    private List<CatecommTsbPeripheralsSoluDetailModel> soluDetailModelList;

    public List<CatecommTsbPeripheralsSoluDetailModel> getSoluDetailModelList() {
        return soluDetailModelList;
    }

    public void setSoluDetailModelList(List<CatecommTsbPeripheralsSoluDetailModel> soluDetailModelList) {
        this.soluDetailModelList = soluDetailModelList;
    }

    public Integer getpSoluId() {
        return pSoluId;
    }

    public void setpSoluId(Integer pSoluId) {
        this.pSoluId = pSoluId;
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

    public String getpSoluCode() {
        return pSoluCode;
    }

    public void setpSoluCode(String pSoluCode) {
        this.pSoluCode = pSoluCode == null ? null : pSoluCode.trim();
    }

    public String getpSoluName() {
        return pSoluName;
    }

    public void setpSoluName(String pSoluName) {
        this.pSoluName = pSoluName == null ? null : pSoluName.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
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
}