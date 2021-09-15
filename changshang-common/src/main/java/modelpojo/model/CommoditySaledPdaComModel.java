package modelpojo.model;


import entity.ModelPagedList;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommoditySaledPdaComModel implements Serializable {
    private Long projectRootId;

    private String saledBillCode;

    private String saledBillName;

    private Integer gzoneId;

    private Integer saledDishStatus;

    private int isDelete;

    private String remark;

    private String state;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Long blEmpId;

    private Date blTime;

    private Integer syncStatus;

    private Long projectId;

    private Integer saledBillId;

    private Integer gradeId;

    private String gradeName;

    private String nickName;

    private String date;

    private String gzoneName;

    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private List<CommoditySaledPdaComDetailModel> detailModels;

    private ModelPagedList<SaleComDto> saleComDtos;

    public ModelPagedList<SaleComDto> getSaleComDtos() {
        return saleComDtos;
    }

    public void setSaleComDtos(ModelPagedList<SaleComDto> saleComDtos) {
        this.saleComDtos = saleComDtos;
    }

    public List<CommoditySaledPdaComDetailModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<CommoditySaledPdaComDetailModel> detailModels) {
        this.detailModels = detailModels;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSaledBillId() {
        return saledBillId;
    }

    public void setSaledBillId(Integer saledBillId) {
        this.saledBillId = saledBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getSaledBillCode() {
        return saledBillCode;
    }

    public void setSaledBillCode(String saledBillCode) {
        this.saledBillCode = saledBillCode == null ? null : saledBillCode.trim();
    }

    public String getSaledBillName() {
        return saledBillName;
    }

    public void setSaledBillName(String saledBillName) {
        this.saledBillName = saledBillName == null ? null : saledBillName.trim();
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getSaledDishStatus() {
        return saledDishStatus;
    }

    public void setSaledDishStatus(Integer saledDishStatus) {
        this.saledDishStatus = saledDishStatus;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
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

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}