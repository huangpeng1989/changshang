package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CatecommTsbPay implements Serializable {
    private static final long serialVersionUID = -4510994939069036826L;
    private Long projectRootId;

      private Integer payId;

    private Long  projectId;

    private String payCode;

    private String payName;

    private String sort;

    private Integer payTypeId;


    private String payTypeName; //付款类型名称

    private Byte isJoinPayParm;

    private Byte isAllowChange;

    private Byte isStartUsing;

    private String remark;

    private String state;

    private Byte isDelete;

    private Long creater;

    private Long modifier;

    private Long blEmpId;

    private Date createdTime;

    private Date updatedTime;

    private Date blTime;

    private Integer status;

    private Integer syncStatus;

    List<CatecommTsbPayDetail> payDetailList;

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }


    public List<CatecommTsbPayDetail> getPayDetailList() {
        return payDetailList;
    }

    public void setPayDetailList(List<CatecommTsbPayDetail> payDetailList) {
        this.payDetailList = payDetailList;
    }


     public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
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

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public Byte getIsJoinPayParm() {
        return isJoinPayParm;
    }

    public void setIsJoinPayParm(Byte isJoinPayParm) {
        this.isJoinPayParm = isJoinPayParm;
    }

    public Byte getIsAllowChange() {
        return isAllowChange;
    }

    public void setIsAllowChange(Byte isAllowChange) {
        this.isAllowChange = isAllowChange;
    }

    public Byte getIsStartUsing() {
        return isStartUsing;
    }

    public void setIsStartUsing(Byte isStartUsing) {
        this.isStartUsing = isStartUsing;
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
