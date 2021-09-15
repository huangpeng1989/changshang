package modelpojo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 报损/溢表
 */
public class CommodityWhHandOfLossBill  implements Serializable {
    private static final long serialVersionUID = 1193244608881126759L;
    private Long projectRootId;

     private Integer olBillId;



    private String olBillCode;

    private Date olBillDate;

    private Long olEmpId;

    public String getOlEmpStr() {
        return olEmpStr;
    }

    public void setOlEmpStr(String olEmpStr) {
        this.olEmpStr = olEmpStr;
    }

    private String olEmpStr;

    private String olState;

    private String olRemark;

    private Long olCreater;


    private String  createrStr; //创建人

    private Long olModifier;


    private String modifierStr;  //修改人

    private Long olBlEmpId;

    private Date createdTime;

    private Integer jurisdictionType;

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
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

    private Date updatedTime;

    private Date olBlTime;

    private Integer whId;

    private String whName;  //仓库名称

    private Integer olStatus;

    private Integer billType;

    private Byte isDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    public String getOlBlEmpStr() {
        return olBlEmpStr;
    }

    public void setOlBlEmpStr(String olBlEmpStr) {
        this.olBlEmpStr = olBlEmpStr;
    }

    private String olBlEmpStr;

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode;
    }

    private String billBarcode;  // 单据条码

     private Long projectId;





    private List<CommodityWhHandOfLossBillDtl> reportLossDetailList;

    public String getModifierStr() {
        return modifierStr;
    }

    public void setModifierStr(String modifierStr) {
        this.modifierStr = modifierStr;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }
    public List<CommodityWhHandOfLossBillDtl> getReportLossDetailList() {
        return reportLossDetailList;
    }

    public void setReportLossDetailList(List<CommodityWhHandOfLossBillDtl> reportLossDetailList) {
        this.reportLossDetailList = reportLossDetailList;
    }



    public Integer getOlBillId() {
        return olBillId;
    }

    public void setOlBillId(Integer olBillId) {
        this.olBillId = olBillId;
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

    public String getOlBillCode() {
        return olBillCode;
    }

    public void setOlBillCode(String olBillCode) {
        this.olBillCode = olBillCode == null ? null : olBillCode.trim();
    }

    public Date getOlBillDate() {
        return olBillDate;
    }

    public void setOlBillDate(Date olBillDate) {
        this.olBillDate = olBillDate;
    }

    public Long getOlEmpId() {
        return olEmpId;
    }

    public void setOlEmpId(Long olEmpId) {
        this.olEmpId = olEmpId;
    }

    public String getOlState() {
        return olState;
    }

    public void setOlState(String olState) {
        this.olState = olState == null ? null : olState.trim();
    }

    public String getOlRemark() {
        return olRemark;
    }

    public void setOlRemark(String olRemark) {
        this.olRemark = olRemark == null ? null : olRemark.trim();
    }

    public Long getOlCreater() {
        return olCreater;
    }

    public void setOlCreater(Long olCreater) {
        this.olCreater = olCreater;
    }

    public Long getOlModifier() {
        return olModifier;
    }

    public void setOlModifier(Long olModifier) {
        this.olModifier = olModifier;
    }

    public Long getOlBlEmpId() {
        return olBlEmpId;
    }

    public void setOlBlEmpId(Long olBlEmpId) {
        this.olBlEmpId = olBlEmpId;
    }


    public Date getOlBlTime() {
        return olBlTime;
    }

    public void setOlBlTime(Date olBlTime) {
        this.olBlTime = olBlTime;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getOlStatus() {
        return olStatus;
    }

    public void setOlStatus(Integer olStatus) {
        this.olStatus = olStatus;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }
}
