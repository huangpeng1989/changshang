package modelpojo.model;

import java.util.Date;

/**
 * 序列号表
 */
public class CommodityTssSerialnumber {
    //项目ID
    private Integer projectId;
    //表名称
    private String tableName;
    //最大编号
    private Long maxNumber;
    //生成类型
    private Byte buildType;
    //说明
    private String state;
    //备注
    private String remark;
    //录入时间
    private Date createTime;
    //录入人
    private Integer creater;
    //修改时间
    private Date updateTime;
    //修改人
    private Integer modifier;
    //状态
    private Short status;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Long maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Byte getBuildType() {
        return buildType;
    }

    public void setBuildType(Byte buildType) {
        this.buildType = buildType;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}