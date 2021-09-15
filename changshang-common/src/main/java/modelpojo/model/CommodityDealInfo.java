package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CommodityDealInfo implements Serializable {

    private static final long serialVersionUID = -4550690345502736392L;
    private List<CommodityDealInfoDtl> dealInfoDtlList;

    private Long projectRootId;
    private String comNdealId;

    private Long projectId;

    private Integer nterminalId;

    private Integer comIsdiscount;

    private Integer comViptype;

    private BigDecimal comVipdiscount;

    private String vipCardno;

    private BigDecimal comDc;

    private BigDecimal comDcAmount;

    private BigDecimal sumAmount;

    private BigDecimal realSumAmount;

    private BigDecimal notaxDcAmount;

    private BigDecimal notaxAmount;

    private BigDecimal notaxRealAmount;

    private Long empId;

    private String comRemark;

    private String comNissueid;

    private String relaDealId;

    private Integer comIsreturn;

    private Integer intdate;

    private Date ddate;

    private Integer comIsdelivery;

    private BigDecimal comDelivery;

    private Long dcEmpId;

    private Integer classCount;

    private Integer comCount;

    private Integer sellTypeNum;

    private Integer gzoneId;

    private Integer billSource;

    private Date comTimestamp;

    private String srcSys;

    private Integer orderStatus;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private String gzoneName;

    private String nterminalName;

    private String empName;

    private String dcEmpName;

    private Integer parkId;

    private BigDecimal tieupsSumAmount;


    private String spmodes;


    public String getSpmodes() {
        return spmodes;
    }

    public void setSpmodes(String spmodes) {
        this.spmodes = spmodes;
    }

    public List<CommodityDealInfoDtl> getDealInfoDtlList() {
        return dealInfoDtlList;
    }

    public void setDealInfoDtlList(List<CommodityDealInfoDtl> dealInfoDtlList) {
        this.dealInfoDtlList = dealInfoDtlList;
    }

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId == null ? null : comNdealId.trim();
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

    public Integer getNterminalId() {
        return nterminalId;
    }

    public void setNterminalId(Integer nterminalId) {
        this.nterminalId = nterminalId;
    }

    public Integer getComIsdiscount() {
        return comIsdiscount;
    }

    public void setComIsdiscount(Integer comIsdiscount) {
        this.comIsdiscount = comIsdiscount;
    }

    public Integer getComViptype() {
        return comViptype;
    }

    public void setComViptype(Integer comViptype) {
        this.comViptype = comViptype;
    }

    public BigDecimal getComVipdiscount() {
        return comVipdiscount;
    }

    public void setComVipdiscount(BigDecimal comVipdiscount) {
        this.comVipdiscount = comVipdiscount;
    }

    public String getVipCardno() {
        return vipCardno;
    }

    public void setVipCardno(String vipCardno) {
        this.vipCardno = vipCardno == null ? null : vipCardno.trim();
    }

    public BigDecimal getComDc() {
        return comDc;
    }

    public void setComDc(BigDecimal comDc) {
        this.comDc = comDc;
    }

    public BigDecimal getComDcAmount() {
        return comDcAmount;
    }

    public void setComDcAmount(BigDecimal comDcAmount) {
        this.comDcAmount = comDcAmount;
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

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getComRemark() {
        return comRemark;
    }

    public void setComRemark(String comRemark) {
        this.comRemark = comRemark == null ? null : comRemark.trim();
    }

    public String getComNissueid() {
        return comNissueid;
    }

    public void setComNissueid(String comNissueid) {
        this.comNissueid = comNissueid == null ? null : comNissueid.trim();
    }

    public String getRelaDealId() {
        return relaDealId;
    }

    public void setRelaDealId(String relaDealId) {
        this.relaDealId = relaDealId == null ? null : relaDealId.trim();
    }

    public Integer getComIsreturn() {
        return comIsreturn;
    }

    public void setComIsreturn(Integer comIsreturn) {
        this.comIsreturn = comIsreturn;
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

    public Integer getComIsdelivery() {
        return comIsdelivery;
    }

    public void setComIsdelivery(Integer comIsdelivery) {
        this.comIsdelivery = comIsdelivery;
    }

    public BigDecimal getComDelivery() {
        return comDelivery;
    }

    public void setComDelivery(BigDecimal comDelivery) {
        this.comDelivery = comDelivery;
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

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
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

    public Date getComTimestamp() {
        return comTimestamp;
    }

    public void setComTimestamp(Date comTimestamp) {
        this.comTimestamp = comTimestamp;
    }

    public String getSrcSys() {
        return srcSys;
    }

    public void setSrcSys(String srcSys) {
        this.srcSys = srcSys == null ? null : srcSys.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public BigDecimal getTieupsSumAmount() {
        return tieupsSumAmount;
    }

    public void setTieupsSumAmount(BigDecimal tieupsSumAmount) {
        this.tieupsSumAmount = tieupsSumAmount;
    }
}
