package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CatecommTsbTerminal implements Serializable {

    private static final long serialVersionUID = -4995236945220997319L;
    private Long projectId;

    private Integer terminalId;

    private Long projectRootId;

    private String terminalCode;

    private String terminalName;

    private Integer gzoneId;



    private String gzoneName;  //营业点名称

    private String gzoneCode;

    private Integer terminalType;

    private String terminalIp;

    private String machName;

    private Integer pSoluId;


    private String pSoluName;  //外设配置名称

    private Byte isDelete;

    private Byte isStartUsing;

    private String sort;

    private String remark;

    private String state;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Integer isMobile;//新增是否移动设备

    public Integer getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Integer isMobile) {
        this.isMobile = isMobile;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    private String statusStr;

    private Integer syncStatus;

    public String getpSoluName() {
        return pSoluName;
    }

    public void setpSoluName(String pSoluName) {
        this.pSoluName = pSoluName;
    }


    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

       public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode == null ? null : gzoneCode.trim();
    }

    public Integer getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public String getTerminalIp() {
        return terminalIp;
    }

    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp == null ? null : terminalIp.trim();
    }

    public String getMachName() {
        return machName;
    }

    public void setMachName(String machName) {
        this.machName = machName == null ? null : machName.trim();
    }

    public Integer getpSoluId() {
        return pSoluId;
    }

    public void setpSoluId(Integer pSoluId) {
        this.pSoluId = pSoluId;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsStartUsing() {
        return isStartUsing;
    }

    public void setIsStartUsing(Byte isStartUsing) {
        this.isStartUsing = isStartUsing;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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
