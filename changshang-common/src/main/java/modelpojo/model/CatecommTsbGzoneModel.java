package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 供应商表
 */
public class CatecommTsbGzoneModel implements Serializable
{
    private Long projectRootId;

    private Long projectId;

    private Integer gzoneId;

    private String gzoneCode;

    private String gzoneName;
    private String jqName;
    private String companyName;

    private Integer gzoneType;

    private String parkCode;

    private Long parkId;

    private String sate;

    private String remark;

    private String useModule;

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

    private  String orgName;

    private Integer isNumber;

    private  Integer areaId;

    private Integer isSellMode;//是否联营

    private Integer isPrintdtip;// 是否后厨打印

    private String printip ;//微信点餐地址

    private Integer comDishId;

    public Integer getComDishId() {
        return comDishId;
    }

    public void setComDishId(Integer comDishId) {
        this.comDishId = comDishId;
    }

    public Integer getIsPrintdtip() {
        return isPrintdtip;
    }

    public void setIsPrintdtip(Integer isPrintdtip) {
        this.isPrintdtip = isPrintdtip;
    }

    public String getPrintip() {
        return printip;
    }

    public void setPrintip(String printip) {
        this.printip = printip;
    }

    public Integer getIsSellMode() {
        return isSellMode;
    }

    public void setIsSellMode(Integer isSellMode) {
        this.isSellMode = isSellMode;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getIsNumber() {
        return isNumber;
    }

    public void setIsNumber(Integer isNumber) {
        this.isNumber = isNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJqName() {
        return jqName;
    }

    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    private List<CatecommTsbGzoneImg> gzoneImg=new ArrayList<>();

    private List<CatecommTssTagUseing> tssTagUseings=new ArrayList<>();

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<CatecommTsbGzoneImg> getGzoneImg() {
        return gzoneImg;
    }

    public void setGzoneImg(List<CatecommTsbGzoneImg> gzoneImg) {
        this.gzoneImg = gzoneImg;
    }

    public List<CatecommTssTagUseing> getTssTagUseings() {
        return tssTagUseings;
    }

    public void setTssTagUseings(List<CatecommTssTagUseing> tssTagUseings) {
        this.tssTagUseings = tssTagUseings;
    }

    public List<CatecommTsbGzoneBushours> getGzoneBushours() {
        return gzoneBushours;
    }

    public void setGzoneBushours(List<CatecommTsbGzoneBushours> gzoneBushours) {
        this.gzoneBushours = gzoneBushours;
    }

    private List<CatecommTsbGzoneBushours> gzoneBushours=new ArrayList<>();




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

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
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

    public String getUseModule() {
        return useModule;
    }

    public void setUseModule(String useModule) {
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
