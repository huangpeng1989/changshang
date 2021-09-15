package modelpojo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CateringAplBill implements Serializable {
    private Long projectRootId;

    private String aplBillCode;

    private Integer gzoneId;

    private Integer aplWhId;

    private Long comEmpId;

    private Integer whId;

    private Date aplDate;

    private String dealEmpId;

    private Date dealDate;

    private String rejectResion;

    private String remark;

    private Integer aplStatus;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Integer syncStatus;

    private Long blEmpId;

    private Date blTime;

    private Byte isDelete;

    private Integer status;

	private Integer aplBillId;

    private Long projectId;

    private String gzoneCode;

    private String gzoneName;

    private String nickName;

    private String aplStatusName;

    private Integer  tAplBillId;

    private String tAplBillCode;

    private  String comEmpName;

    private Integer index;

    private Integer twoIndex;

    private  Integer threeIndex;

    private Integer billSource;

    private String billSourceName;

    private String dishName;

    private String chaiPingName;

    private String whName;

    private Integer paymentDaysId;
    private String paymentName;
    private Date paymentData;


    private String purchaseCode;

    private  String allotCode;

    private Integer jurisdictionType;

    private  Integer oppositeIsTrue;

    private  String aplWhName;

    public String getAplWhName() {
        return aplWhName;
    }

    public void setAplWhName(String aplWhName) {
        this.aplWhName = aplWhName;
    }

    public Integer getOppositeIsTrue() {
        return oppositeIsTrue;
    }

    public void setOppositeIsTrue(Integer oppositeIsTrue) {
        this.oppositeIsTrue = oppositeIsTrue;
    }

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public String getAllotCode() {
        return allotCode;
    }

    public void setAllotCode(String allotCode) {
        this.allotCode = allotCode;
    }

    public Integer getPaymentDaysId() {
        return paymentDaysId;
    }

    public void setPaymentDaysId(Integer paymentDaysId) {
        this.paymentDaysId = paymentDaysId;
    }


    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Date getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(Date paymentData) {
        this.paymentData = paymentData;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getChaiPingName() {
        return chaiPingName;
    }

    public void setChaiPingName(String chaiPingName) {
        this.chaiPingName = chaiPingName;
    }

    public Integer getTwoIndex() {
        return twoIndex;
    }

    public void setTwoIndex(Integer twoIndex) {
        this.twoIndex = twoIndex;
    }

    public Integer getThreeIndex() {
        return threeIndex;
    }

    public void setThreeIndex(Integer threeIndex) {
        this.threeIndex = threeIndex;
    }

    private List<CateringAplBillDtl> list=new ArrayList<>();

    private List<CateringAplBill> bills = new ArrayList<>();


    private List<CateringAplBillDtl> danChenPing=new ArrayList<>();

    private List<CateringAplBillDtl> caiPing = new ArrayList<>();

    public String getBillSourceName() {
        return billSourceName;
    }

    public void setBillSourceName(String billSourceName) {
        this.billSourceName = billSourceName;
    }

    public Integer getBillSource() {
        return billSource;
    }

    public void setBillSource(Integer billSource) {
        this.billSource = billSource;
    }

    public List<CateringAplBillDtl> getDanChenPing() {
        return danChenPing;
    }

    public void setDanChenPing(List<CateringAplBillDtl> danChenPing) {
        this.danChenPing = danChenPing;
    }

    public List<CateringAplBillDtl> getCaiPing() {
        return caiPing;
    }

    public void setCaiPing(List<CateringAplBillDtl> caiPing) {
        this.caiPing = caiPing;
    }

    private String codeName;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer gettAplBillId() {
        return tAplBillId;
    }

    public void settAplBillId(Integer tAplBillId) {
        this.tAplBillId = tAplBillId;
    }

    public String gettAplBillCode() {
        return tAplBillCode;
    }

    public void settAplBillCode(String tAplBillCode) {
        this.tAplBillCode = tAplBillCode;
    }

    public String getComEmpName() {
        return comEmpName;
    }

    public void setComEmpName(String comEmpName) {
        this.comEmpName = comEmpName;
    }


    public List<CateringAplBill> getBills() {
        return bills;
    }

    public void setBills(List<CateringAplBill> bills) {
        this.bills = bills;
    }

    public List<CateringAplBillDtl> getList() {
        return list;
    }

    public void setList(List<CateringAplBillDtl> list) {
        this.list = list;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAplStatusName() {
        return aplStatusName;
    }

    public void setAplStatusName(String aplStatusName) {
        this.aplStatusName = aplStatusName;
    }

    public Integer getAplBillId() {
        return aplBillId;
    }

    public void setAplBillId(Integer aplBillId) {
        this.aplBillId = aplBillId;
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

    public String getAplBillCode() {
        return aplBillCode;
    }

    public void setAplBillCode(String aplBillCode) {
        this.aplBillCode = aplBillCode == null ? null : aplBillCode.trim();
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getAplWhId() {
        return aplWhId;
    }

    public void setAplWhId(Integer aplWhId) {
        this.aplWhId = aplWhId;
    }

    public Long getComEmpId() {
        return comEmpId;
    }

    public void setComEmpId(Long comEmpId) {
        this.comEmpId = comEmpId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Date getAplDate() {
        return aplDate;
    }

    public void setAplDate(Date aplDate) {
        this.aplDate = aplDate;
    }

    public String getDealEmpId() {
        return dealEmpId;
    }

    public void setDealEmpId(String dealEmpId) {
        this.dealEmpId = dealEmpId == null ? null : dealEmpId.trim();
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getRejectResion() {
        return rejectResion;
    }

    public void setRejectResion(String rejectResion) {
        this.rejectResion = rejectResion == null ? null : rejectResion.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAplStatus() {
        return aplStatus;
    }

    public void setAplStatus(Integer aplStatus) {
        this.aplStatus = aplStatus;
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}