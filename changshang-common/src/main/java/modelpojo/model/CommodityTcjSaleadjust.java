package modelpojo.model;

import java.util.Date;

/**
 * 售价调价主表
 */
public class CommodityTcjSaleadjust {
    //状态
    private Integer projectId;
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
    //录入时间
    private Date createTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updateTime;
    //修改人
    private Long modifier;
    //审核人
    private Long BLEmpId;
    //审核时间
    private Date BLTime;
    //状态
    private Integer status;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getBLEmpId() {
        return BLEmpId;
    }

    public void setBLEmpId(Long BLEmpId) {
        this.BLEmpId = BLEmpId;
    }

    public Date getBLTime() {
        return BLTime;
    }

    public void setBLTime(Date BLTime) {
        this.BLTime = BLTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
