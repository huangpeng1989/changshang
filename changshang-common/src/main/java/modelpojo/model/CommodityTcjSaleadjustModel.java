package modelpojo.model;

import modelpojo.vo.saleadjust.CommodityTcjSaleadjustdetailVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 售价调价主表
 */
public class CommodityTcjSaleadjustModel implements Serializable {
    //状态
    private Long projectId;
    //调价单id
    private Integer adjId;
    //调价单号
    private String adjCode;
    //部门id
    private Integer deptId;
    //调价开始日期
    private Date startDate;
    //调价结束日期
    private Date endDate;
    //备注
    private String remark;
    //说明
    private String description;

   //项目根节点id
    private Long projectRootId;

    //录入时间
    private Date createdTime;

    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //审核人
    private Long blEmpId;

    private Integer isDelete;
    //审核时间
    private Date blTime;
    //状态
    private Integer status;


    //状态名称
    private String statusName;

    //调价类型
    private Integer adjType;


    //售价调价单子表信息集合
    private List<CommodityTcjSaleadjustdetail> list=new ArrayList<>();

    //售价调价单子表信息集合
    private List<CommodityTcjSaleadjustdetailVo> listVo=new ArrayList<>();


    //同步状态
    private Integer syncStatus;


    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public List<CommodityTcjSaleadjustdetailVo> getListVo() {
        return listVo;
    }

    public void setListVo(List<CommodityTcjSaleadjustdetailVo> listVo) {
        this.listVo = listVo;
    }



    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public List<CommodityTcjSaleadjustdetail> getList() {
        return list;
    }

    public void setList(List<CommodityTcjSaleadjustdetail> list) {
        this.list = list;
    }

    public Integer getAdjType() {
        return adjType;
    }

    public void setAdjType(Integer adjType) {
        this.adjType = adjType;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAdjId() {
        return adjId;
    }

    public void setAdjId(Integer adjId) {
        this.adjId = adjId;
    }

    public String getAdjCode() {
        return adjCode;
    }

    public void setAdjCode(String adjCode) {
        this.adjCode = adjCode == null ? null : adjCode.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updatedTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updatedTime = updateTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}