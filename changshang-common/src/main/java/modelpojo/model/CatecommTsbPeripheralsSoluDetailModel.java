package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CatecommTsbPeripheralsSoluDetailModel implements Serializable {
    private Long projectRootId;

    private Integer pSoluId;

    private Integer deviceTypeId;

    private String deviceName;

    private Integer devicePrintCount;

    private String devicePortParam;

    private String devicePort;

    private String deviceParam1;

    private String deviceParam2;

    private String deviceParam3;

    private String deviceParam4;

    private String sort;

    private String state;

    private String remark;

    private Integer isDelete;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    private Long creater;

    private Long modifier;
	
	private Integer pSoluDetailId;

    private Long projectId;

    private String dictTpValue;

    public String getDictTpValue() {
        return dictTpValue;
    }

    public void setDictTpValue(String dictTpValue) {
        this.dictTpValue = dictTpValue;
    }

    public Integer getpSoluDetailId() {
        return pSoluDetailId;
    }

    public void setpSoluDetailId(Integer pSoluDetailId) {
        this.pSoluDetailId = pSoluDetailId;
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

    public Integer getpSoluId() {
        return pSoluId;
    }

    public void setpSoluId(Integer pSoluId) {
        this.pSoluId = pSoluId;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDevicePrintCount() {
        return devicePrintCount;
    }

    public void setDevicePrintCount(Integer devicePrintCount) {
        this.devicePrintCount = devicePrintCount;
    }

    public String getDevicePortParam() {
        return devicePortParam;
    }

    public void setDevicePortParam(String devicePortParam) {
        this.devicePortParam = devicePortParam == null ? null : devicePortParam.trim();
    }

    public String getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(String devicePort) {
        this.devicePort = devicePort == null ? null : devicePort.trim();
    }

    public String getDeviceParam1() {
        return deviceParam1;
    }

    public void setDeviceParam1(String deviceParam1) {
        this.deviceParam1 = deviceParam1 == null ? null : deviceParam1.trim();
    }

    public String getDeviceParam2() {
        return deviceParam2;
    }

    public void setDeviceParam2(String deviceParam2) {
        this.deviceParam2 = deviceParam2 == null ? null : deviceParam2.trim();
    }

    public String getDeviceParam3() {
        return deviceParam3;
    }

    public void setDeviceParam3(String deviceParam3) {
        this.deviceParam3 = deviceParam3 == null ? null : deviceParam3.trim();
    }

    public String getDeviceParam4() {
        return deviceParam4;
    }

    public void setDeviceParam4(String deviceParam4) {
        this.deviceParam4 = deviceParam4 == null ? null : deviceParam4.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}