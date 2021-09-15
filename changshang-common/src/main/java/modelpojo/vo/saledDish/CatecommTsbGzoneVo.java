package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商表
 */
public class CatecommTsbGzoneVo implements Serializable
{
    private Long projectRootId;

    private Long projectId;

    private Integer gzoneId;

    private String gzoneCode;

    private String gzoneName;

    private Integer gzoneType;

    private String parkCode;

    private Long parkId;

    private String sate;

    private String remark;

    private Byte useModule;

    private Integer taxId;

    private String taxCost;

    private Integer sellId;

    private String longitudeLatitude;

    private Byte isTablewareCost;

    private BigDecimal packingExpense;

    private Integer payProjectId;

    private String firLocCode;

    private String secLocCode;

    private String thirLocCode;

    private String localDetail;

    private BigDecimal tablewareCost;

    private Byte isDispatching;

    private String diningRoomTag;

    private Integer gradeId;

    private String openCycle;

    private Integer gzoneAreaId;

    private BigDecimal gzoneBuildArea;

    private BigDecimal gzoneUseArea;

    private BigDecimal gzoneRentArea;

    private String leaderPhone;

    private String leaderEmpName;

    private Byte isDelete;

    private Byte isStartUse;

    private Date createdTime;

    private Long creater;

    private Long modifier;

    private Date updatedTime;

    private Long blEmpId;

    private Date blTime;

    private Integer gzoneStatus;

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

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName == null ? null : gzoneName.trim();
    }

    public Integer getGzoneType() {
        return gzoneType;
    }

    public void setGzoneType(Integer gzoneType) {
        this.gzoneType = gzoneType;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode == null ? null : parkCode.trim();
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate == null ? null : sate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getUseModule() {
        return useModule;
    }

    public void setUseModule(Byte useModule) {
        this.useModule = useModule;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        this.taxCost = taxCost == null ? null : taxCost.trim();
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public String getLongitudeLatitude() {
        return longitudeLatitude;
    }

    public void setLongitudeLatitude(String longitudeLatitude) {
        this.longitudeLatitude = longitudeLatitude == null ? null : longitudeLatitude.trim();
    }

    public Byte getIsTablewareCost() {
        return isTablewareCost;
    }

    public void setIsTablewareCost(Byte isTablewareCost) {
        this.isTablewareCost = isTablewareCost;
    }

    public BigDecimal getPackingExpense() {
        return packingExpense;
    }

    public void setPackingExpense(BigDecimal packingExpense) {
        this.packingExpense = packingExpense;
    }

    public Integer getPayProjectId() {
        return payProjectId;
    }

    public void setPayProjectId(Integer payProjectId) {
        this.payProjectId = payProjectId;
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

    public String getThirLocCode() {
        return thirLocCode;
    }

    public void setThirLocCode(String thirLocCode) {
        this.thirLocCode = thirLocCode == null ? null : thirLocCode.trim();
    }

    public String getLocalDetail() {
        return localDetail;
    }

    public void setLocalDetail(String localDetail) {
        this.localDetail = localDetail == null ? null : localDetail.trim();
    }

    public BigDecimal getTablewareCost() {
        return tablewareCost;
    }

    public void setTablewareCost(BigDecimal tablewareCost) {
        this.tablewareCost = tablewareCost;
    }

    public Byte getIsDispatching() {
        return isDispatching;
    }

    public void setIsDispatching(Byte isDispatching) {
        this.isDispatching = isDispatching;
    }

    public String getDiningRoomTag() {
        return diningRoomTag;
    }

    public void setDiningRoomTag(String diningRoomTag) {
        this.diningRoomTag = diningRoomTag == null ? null : diningRoomTag.trim();
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getOpenCycle() {
        return openCycle;
    }

    public void setOpenCycle(String openCycle) {
        this.openCycle = openCycle == null ? null : openCycle.trim();
    }

    public Integer getGzoneAreaId() {
        return gzoneAreaId;
    }

    public void setGzoneAreaId(Integer gzoneAreaId) {
        this.gzoneAreaId = gzoneAreaId;
    }

    public BigDecimal getGzoneBuildArea() {
        return gzoneBuildArea;
    }

    public void setGzoneBuildArea(BigDecimal gzoneBuildArea) {
        this.gzoneBuildArea = gzoneBuildArea;
    }

    public BigDecimal getGzoneUseArea() {
        return gzoneUseArea;
    }

    public void setGzoneUseArea(BigDecimal gzoneUseArea) {
        this.gzoneUseArea = gzoneUseArea;
    }

    public BigDecimal getGzoneRentArea() {
        return gzoneRentArea;
    }

    public void setGzoneRentArea(BigDecimal gzoneRentArea) {
        this.gzoneRentArea = gzoneRentArea;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone == null ? null : leaderPhone.trim();
    }

    public String getLeaderEmpName() {
        return leaderEmpName;
    }

    public void setLeaderEmpName(String leaderEmpName) {
        this.leaderEmpName = leaderEmpName == null ? null : leaderEmpName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsStartUse() {
        return isStartUse;
    }

    public void setIsStartUse(Byte isStartUse) {
        this.isStartUse = isStartUse;
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

    public Integer getGzoneStatus() {
        return gzoneStatus;
    }

    public void setGzoneStatus(Integer gzoneStatus) {
        this.gzoneStatus = gzoneStatus;
    }
}