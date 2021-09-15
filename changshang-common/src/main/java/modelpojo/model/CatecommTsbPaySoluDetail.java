package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CatecommTsbPaySoluDetail implements Serializable {
    private static final long serialVersionUID = -2513079812439307509L;
    private Long projectRootId;

    private Integer paySoluId;

     private Integer paySoluDetailId;

    private Long projectId;

    private Integer payId;


    private String payName;

    private String payCode;

    private String sort;

    private Byte isDelete;

    private Byte isStartUsing;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer status;

    private Integer syncStatus;



    //支付方式表信息
    private Integer payTypeId;
    private String payTypeName;
    private Integer isJoinPayParm;
    private Integer paySort;
    private Integer payIsStartUsing;


    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public Integer getIsJoinPayParm() {
        return isJoinPayParm;
    }

    public void setIsJoinPayParm(Integer isJoinPayParm) {
        this.isJoinPayParm = isJoinPayParm;
    }

    public Integer getPaySort() {
        return paySort;
    }

    public void setPaySort(Integer paySort) {
        this.paySort = paySort;
    }

    public Integer getPayIsStartUsing() {
        return payIsStartUsing;
    }

    public void setPayIsStartUsing(Integer payIsStartUsing) {
        this.payIsStartUsing = payIsStartUsing;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }


    public Integer getPaySoluDetailId() {
        return paySoluDetailId;
    }

    public void setPaySoluDetailId(Integer paySoluDetailId) {
        this.paySoluDetailId = paySoluDetailId;
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

    public Integer getPaySoluId() {
        return paySoluId;
    }

    public void setPaySoluId(Integer paySoluId) {
        this.paySoluId = paySoluId;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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
