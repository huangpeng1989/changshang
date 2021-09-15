package modelpojo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityWhInvtryBill implements Serializable {
    private Integer whId;
    private Long projectRootId;

    private String ivtCode;

    private Integer startStatus;

    private Long startCreater;

    private Long startModifier;

    private Date startCreatedTime;

    private Date startUpdatedTime;

    private Date  printDate;

    private Byte startIsDelete;

    private String entryBillCode;

    private String startRemark;

    private Date ivtStartDate;

    private Integer ivtMode;

    private Long entryCreater;

    private Long entryModifier;

    private Long entryBlEmpId;

    private Date entryCreatedTime;

    private Date entryUpdatedTime;

    private Date entryBlTime;

    private String entryRemark;

    private Byte entryIsDelete;

    private Integer entryStatus;

    private String state;

	 private Integer ivtId;

    private Long projectId;

    private String whName;

    private String nickName;


    private String comClassCode;

    private String comClassName;

    private String entryStatusName;

    private String ivtModeName;

    private  Date createdDate;

    private Integer comCount;

    private Integer figIndex;

    private String entryBlempName;

    private String billBarcode;

    private String entryName;

    private	String oneEntryName;

    private	String twoEntryName;

    private	String threeEntryName;

    private String updateNowTime;



    private Long oneEntryBlEmpId;

    private Long twoEntryBlEmpId;

    private Long threeEntryBlEmpId;

    private Integer jurisdictionType;

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public Long getOneEntryBlEmpId() {
        return oneEntryBlEmpId;
    }

    public void setOneEntryBlEmpId(Long oneEntryBlEmpId) {
        this.oneEntryBlEmpId = oneEntryBlEmpId;
    }

    public Long getTwoEntryBlEmpId() {
        return twoEntryBlEmpId;
    }

    public void setTwoEntryBlEmpId(Long twoEntryBlEmpId) {
        this.twoEntryBlEmpId = twoEntryBlEmpId;
    }

    public Long getThreeEntryBlEmpId() {
        return threeEntryBlEmpId;
    }

    public void setThreeEntryBlEmpId(Long threeEntryBlEmpId) {
        this.threeEntryBlEmpId = threeEntryBlEmpId;
    }

    public String getOneEntryName() {
        return oneEntryName;
    }

    public void setOneEntryName(String oneEntryName) {
        this.oneEntryName = oneEntryName;
    }

    public String getTwoEntryName() {
        return twoEntryName;
    }

    public void setTwoEntryName(String twoEntryName) {
        this.twoEntryName = twoEntryName;
    }

    public String getThreeEntryName() {
        return threeEntryName;
    }

    public void setThreeEntryName(String threeEntryName) {
        this.threeEntryName = threeEntryName;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getUpdateNowTime() {
        return updateNowTime;
    }

    public void setUpdateNowTime(String updateNowTime) {
        this.updateNowTime = updateNowTime;
    }

    public String getBillBarcode() {
        return billBarcode;
    }

    public void setBillBarcode(String billBarcode) {
        this.billBarcode = billBarcode;
    }

    public String getEntryBlempName() {
        return entryBlempName;
    }

    public void setEntryBlempName(String entryBlempName) {
        this.entryBlempName = entryBlempName;
    }






    public Integer getFigIndex() {
        return figIndex;
    }

    public void setFigIndex(Integer figIndex) {
        this.figIndex = figIndex;
    }
    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }





    public String getIvtModeName() {
        return ivtModeName;
    }

    public void setIvtModeName(String ivtModeName) {
        this.ivtModeName = ivtModeName;
    }





    public String getEntryStatusName() {
        return entryStatusName;
    }

    public void setEntryStatusName(String entryStatusName) {
        this.entryStatusName = entryStatusName;
    }






    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }





    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public List<CommodityWhInvtryBillDtl> getList() {
        return list;
    }

    public void setList(List<CommodityWhInvtryBillDtl> list) {
        this.list = list;
    }

    private List<CommodityWhInvtryBillDtl> list = new ArrayList<>();

    public String getStartStatusName() {
        return startStatusName;
    }

    public void setStartStatusName(String startStatusName) {
        this.startStatusName = startStatusName;
    }

    private String startStatusName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getIvtId() {
        return ivtId;
    }

    public void setIvtId(Integer ivtId) {
        this.ivtId = ivtId;
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

    public String getIvtCode() {
        return ivtCode;
    }

    public void setIvtCode(String ivtCode) {
        this.ivtCode = ivtCode == null ? null : ivtCode.trim();
    }

    public Integer getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    public Long getStartCreater() {
        return startCreater;
    }

    public void setStartCreater(Long startCreater) {
        this.startCreater = startCreater;
    }

    public Long getStartModifier() {
        return startModifier;
    }

    public void setStartModifier(Long startModifier) {
        this.startModifier = startModifier;
    }

    public Date getStartCreatedTime() {
        return startCreatedTime;
    }

    public void setStartCreatedTime(Date startCreatedTime) {
        this.startCreatedTime = startCreatedTime;
    }

    public Date getStartUpdatedTime() {
        return startUpdatedTime;
    }

    public void setStartUpdatedTime(Date startUpdatedTime) {
        this.startUpdatedTime = startUpdatedTime;
    }

    public Byte getStartIsDelete() {
        return startIsDelete;
    }

    public void setStartIsDelete(Byte startIsDelete) {
        this.startIsDelete = startIsDelete;
    }

    public String getEntryBillCode() {
        return entryBillCode;
    }

    public void setEntryBillCode(String entryBillCode) {
        this.entryBillCode = entryBillCode == null ? null : entryBillCode.trim();
    }

    public String getStartRemark() {
        return startRemark;
    }

    public void setStartRemark(String startRemark) {
        this.startRemark = startRemark == null ? null : startRemark.trim();
    }

    public Date getIvtStartDate() {
        return ivtStartDate;
    }

    public void setIvtStartDate(Date ivtStartDate) {
        this.ivtStartDate = ivtStartDate;
    }

    public Integer getIvtMode() {
        return ivtMode;
    }

    public void setIvtMode(Integer ivtMode) {
        this.ivtMode = ivtMode;
    }

    public Long getEntryCreater() {
        return entryCreater;
    }

    public void setEntryCreater(Long entryCreater) {
        this.entryCreater = entryCreater;
    }

    public Long getEntryModifier() {
        return entryModifier;
    }

    public void setEntryModifier(Long entryModifier) {
        this.entryModifier = entryModifier;
    }

    public Long getEntryBlEmpId() {
        return entryBlEmpId;
    }

    public void setEntryBlEmpId(Long entryBlEmpId) {
        this.entryBlEmpId = entryBlEmpId;
    }

    public Date getEntryCreatedTime() {
        return entryCreatedTime;
    }

    public void setEntryCreatedTime(Date entryCreatedTime) {
        this.entryCreatedTime = entryCreatedTime;
    }

    public Date getEntryUpdatedTime() {
        return entryUpdatedTime;
    }

    public void setEntryUpdatedTime(Date entryUpdatedTime) {
        this.entryUpdatedTime = entryUpdatedTime;
    }

    public Date getEntryBlTime() {
        return entryBlTime;
    }

    public void setEntryBlTime(Date entryBlTime) {
        this.entryBlTime = entryBlTime;
    }

    public String getEntryRemark() {
        return entryRemark;
    }

    public void setEntryRemark(String entryRemark) {
        this.entryRemark = entryRemark == null ? null : entryRemark.trim();
    }

    public Byte getEntryIsDelete() {
        return entryIsDelete;
    }

    public void setEntryIsDelete(Byte entryIsDelete) {
        this.entryIsDelete = entryIsDelete;
    }

    public Integer getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}