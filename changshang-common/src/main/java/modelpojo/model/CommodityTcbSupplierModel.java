package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商信息表
 */
public class CommodityTcbSupplierModel implements Serializable {
    //项目ID
    private Long projectId;
    //供应商ID
    private Integer suppId;
    //项目根节点id
    private Long projectRootId;
    //供应商分类编号
    private String suppClassCode;
    //供应商编号
    private String suppCode;
    //供应商名称
    private String suppName;
    //拼音编码
    private String spellCode;
    //供应商联系人
    private String suppContact;
    //供应商电话
    private String suppPhone;
    //位置编码1
    private String firLocCode;
    //位置编码2
    private String secLocCode;
    //位置编码3
    private String thiLocCode;
    //具体地址
    private String dtlLocCode;
    //经销方式
    private Integer busMode;
    //采购周期
    private String purcCycle;
    //在途天数
    private Integer onDays;
    //联营折扣率
    private BigDecimal discountRate;
    //账期Id(以日为基本单位)
    private Integer payDays;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //修改时间
    private Date updatedTime;
    //审核时间
    private Date blTime;
    //审核人
    private Long blEmpId;
    //修改人
    private Long modifier;
    //状态
    private Integer sStatus;

    private Integer isDelete;

    private Integer syncStatus;

    //税率ID
    private Integer slTaxId;

    private String supper;

    public String getSupper() {
        return supper;
    }

    public void setSupper(String supper) {
        this.supper = supper;
    }

    public Integer getSlTaxId() {
        return slTaxId;
    }

    public void setSlTaxId(Integer slTaxId) {
        this.slTaxId = slTaxId;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getSuppClassCode() {
        return suppClassCode;
    }

    public void setSuppClassCode(String suppClassCode) {
        this.suppClassCode = suppClassCode == null ? null : suppClassCode.trim();
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName == null ? null : suppName.trim();
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode == null ? null : spellCode.trim();
    }

    public String getSuppContact() {
        return suppContact;
    }

    public void setSuppContact(String suppContact) {
        this.suppContact = suppContact == null ? null : suppContact.trim();
    }

    public String getSuppPhone() {
        return suppPhone;
    }

    public void setSuppPhone(String suppPhone) {
        this.suppPhone = suppPhone == null ? null : suppPhone.trim();
    }

    public String getFirLocCode() {
        return firLocCode;
    }

    public void setFirLocCode(String firLocCode) {
        this.firLocCode = firLocCode == null ? null : firLocCode.trim();
    }

    public String getSecLocCode() {
        return secLocCode;
    }

    public void setSecLocCode(String secLocCode) {
        this.secLocCode = secLocCode == null ? null : secLocCode.trim();
    }

    public String getThiLocCode() {
        return thiLocCode;
    }

    public void setThiLocCode(String thiLocCode) {
        this.thiLocCode = thiLocCode == null ? null : thiLocCode.trim();
    }

    public String getDtlLocCode() {
        return dtlLocCode;
    }

    public void setDtlLocCode(String dtlLocCode) {
        this.dtlLocCode = dtlLocCode == null ? null : dtlLocCode.trim();
    }

    public Integer getBusMode() {
        return busMode;
    }

    public void setBusMode(Integer busMode) {
        this.busMode = busMode;
    }

    public String getPurcCycle() {
        return purcCycle;
    }

    public void setPurcCycle(String purcCycle) {
        this.purcCycle = purcCycle == null ? null : purcCycle.trim();
    }

    public Integer getOnDays() {
        return onDays;
    }

    public void setOnDays(Integer onDays) {
        this.onDays = onDays;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getPayDays() {
        return payDays;
    }

    public void setPayDays(Integer payDays) {
        this.payDays = payDays;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
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

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getsStatus() {
        return sStatus;
    }

    public void setsStatus(Integer sStatus) {
        this.sStatus = sStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}