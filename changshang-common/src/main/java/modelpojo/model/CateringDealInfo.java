package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringDealInfo implements Serializable {

	 private String cateNdealId;

    private Long projectId;

    private Long projectRootId;

    private Integer nterminalId;

    private Integer cateIsdiscount;

    private Integer cateViptype;

    private BigDecimal cateVipdiscount;

    private BigDecimal cateDc;

    private BigDecimal cateDcAmount;

    private BigDecimal sumAmount;

    private BigDecimal realSumAmount;

    private BigDecimal notaxDcAmount;

    private BigDecimal notaxAmount;

    private BigDecimal notaxRealAmount;

    private Integer empId;

    private String cateRemark;

    private Integer cateNissueId;

    private Long relaDealId;

    private Integer cateIsReturn;

    private Integer intdate;

    private Date ddate;

    private Date cateTimestamp;

    private Integer tableNo;

    private Long dcEmpId;

    private Integer classCount;

    private Integer cateCount;

    private Integer sellTypeNum;

    private Integer gzoneId;

    private Integer billSource;

    private Integer orderStatus;

    private Integer catePeopleNum;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private String gzoneName;

    private String nterminalName;

    private String empName;

    private String dcEmpName;

    private Long parkId;

    private String spmodes;


    public String getSpmodes() {
        return spmodes;
    }

    public void setSpmodes(String spmodes) {
        this.spmodes = spmodes;
    }

 	public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    private BigDecimal tieupsSumAmount;

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getNterminalId() {
        return nterminalId;
    }

    public void setNterminalId(Integer nterminalId) {
        this.nterminalId = nterminalId;
    }

    public Integer getCateIsdiscount() {
        return cateIsdiscount;
    }

    public void setCateIsdiscount(Integer cateIsdiscount) {
        this.cateIsdiscount = cateIsdiscount;
    }

    public Integer getCateViptype() {
        return cateViptype;
    }

    public void setCateViptype(Integer cateViptype) {
        this.cateViptype = cateViptype;
    }

    public BigDecimal getCateVipdiscount() {
        return cateVipdiscount;
    }

    public void setCateVipdiscount(BigDecimal cateVipdiscount) {
        this.cateVipdiscount = cateVipdiscount;
    }

    public BigDecimal getCateDc() {
        return cateDc;
    }

    public void setCateDc(BigDecimal cateDc) {
        this.cateDc = cateDc;
    }

    public BigDecimal getCateDcAmount() {
        return cateDcAmount;
    }

    public void setCateDcAmount(BigDecimal cateDcAmount) {
        this.cateDcAmount = cateDcAmount;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public BigDecimal getRealSumAmount() {
        return realSumAmount;
    }

    public void setRealSumAmount(BigDecimal realSumAmount) {
        this.realSumAmount = realSumAmount;
    }

    public BigDecimal getNotaxDcAmount() {
        return notaxDcAmount;
    }

    public void setNotaxDcAmount(BigDecimal notaxDcAmount) {
        this.notaxDcAmount = notaxDcAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }

    public BigDecimal getNotaxRealAmount() {
        return notaxRealAmount;
    }

    public void setNotaxRealAmount(BigDecimal notaxRealAmount) {
        this.notaxRealAmount = notaxRealAmount;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getCateRemark() {
        return cateRemark;
    }

    public void setCateRemark(String cateRemark) {
        this.cateRemark = cateRemark == null ? null : cateRemark.trim();
    }

    public Integer getCateNissueId() {
        return cateNissueId;
    }

    public void setCateNissueId(Integer cateNissueId) {
        this.cateNissueId = cateNissueId;
    }

    public Long getRelaDealId() {
        return relaDealId;
    }

    public void setRelaDealId(Long relaDealId) {
        this.relaDealId = relaDealId;
    }

    public Integer getCateIsReturn() {
        return cateIsReturn;
    }

    public void setCateIsReturn(Integer cateIsReturn) {
        this.cateIsReturn = cateIsReturn;
    }

    public Integer getIntdate() {
        return intdate;
    }

    public void setIntdate(Integer intdate) {
        this.intdate = intdate;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public Date getCateTimestamp() {
        return cateTimestamp;
    }

    public void setCateTimestamp(Date cateTimestamp) {
        this.cateTimestamp = cateTimestamp;
    }

    public Integer getTableNo() {
        return tableNo;
    }

    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    public Long getDcEmpId() {
        return dcEmpId;
    }

    public void setDcEmpId(Long dcEmpId) {
        this.dcEmpId = dcEmpId;
    }

    public Integer getClassCount() {
        return classCount;
    }

    public void setClassCount(Integer classCount) {
        this.classCount = classCount;
    }

    public Integer getCateCount() {
        return cateCount;
    }

    public void setCateCount(Integer cateCount) {
        this.cateCount = cateCount;
    }

    public Integer getSellTypeNum() {
        return sellTypeNum;
    }

    public void setSellTypeNum(Integer sellTypeNum) {
        this.sellTypeNum = sellTypeNum;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getBillSource() {
        return billSource;
    }

    public void setBillSource(Integer billSource) {
        this.billSource = billSource;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCatePeopleNum() {
        return catePeopleNum;
    }

    public void setCatePeopleNum(Integer catePeopleNum) {
        this.catePeopleNum = catePeopleNum;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName == null ? null : gzoneName.trim();
    }

    public String getNterminalName() {
        return nterminalName;
    }

    public void setNterminalName(String nterminalName) {
        this.nterminalName = nterminalName == null ? null : nterminalName.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getDcEmpName() {
        return dcEmpName;
    }

    public void setDcEmpName(String dcEmpName) {
        this.dcEmpName = dcEmpName == null ? null : dcEmpName.trim();
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public BigDecimal getTieupsSumAmount() {
        return tieupsSumAmount;
    }

    public void setTieupsSumAmount(BigDecimal tieupsSumAmount) {
        this.tieupsSumAmount = tieupsSumAmount;
    }
}
