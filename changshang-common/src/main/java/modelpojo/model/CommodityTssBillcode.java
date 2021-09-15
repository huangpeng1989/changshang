package modelpojo.model;

import java.util.Date;

/**
 * 单号表
 */
public class CommodityTssBillcode {
    //项目ID
    private Integer projectId;
    //单号名称
    private String billName;
    //最大单号ID
    private Long maxBillId;
    //最大单号
    private String maxBillCode;
    //前缀规则
    private String preRule;
    //后缀规则
    private String posRule;
    //年
    private String year;
    //月
    private String month;
    //日
    private String day;
    //是否打印条码
    private Integer isPrintCode;
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

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public Long getMaxBillId() {
        return maxBillId;
    }

    public void setMaxBillId(Long maxBillId) {
        this.maxBillId = maxBillId;
    }

    public String getMaxBillCode() {
        return maxBillCode;
    }

    public void setMaxBillCode(String maxBillCode) {
        this.maxBillCode = maxBillCode == null ? null : maxBillCode.trim();
    }

    public String getPreRule() {
        return preRule;
    }

    public void setPreRule(String preRule) {
        this.preRule = preRule == null ? null : preRule.trim();
    }

    public String getPosRule() {
        return posRule;
    }

    public void setPosRule(String posRule) {
        this.posRule = posRule == null ? null : posRule.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Integer getIsPrintCode() {
        return isPrintCode;
    }

    public void setIsPrintCode(Integer isPrintCode) {
        this.isPrintCode = isPrintCode;
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