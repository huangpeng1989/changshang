package modelpojo.vo.allotBill;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CateringWhAllotBill implements Serializable {
    private Long projectId;

    private Integer allotBillId;

    private Long projectRootId;

    private String altOutBillCode;

    private Integer outWhId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date outTime;

    private Long outEmpId;

    private String outRemark;

    private String outState;

    private Long outCreater;

    private Long outModifier;

    private Long outBlEmpId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date outCreatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date outUpdatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date outBlTime;

    private Byte outIsDelete;

    private String altInBillCode;

    private Integer inWhId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date inTime;

    private Long inEmpId;

    private String inRemark;

    private String inState;

    private Long inCreater;

    private Long inModifier;

    private Long inBlEmpId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date inCreatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date inUpdatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date inBlTime;

    private Byte inIsDelete;

    private Integer syncStatus;

    private Integer stockStatus;

    private Integer outStatus;

    private Integer inStatus;

    private String inBillBarcode;

    private String outBillBarcode;

    private String outWhName;//code转中文
    private String inWhName;//
    private String inStatusName;//
    private String outStatusName;//
    private String outCreaterName;//
    private String inCreaterName;//
    private String inBlEmpIdName;//
    private String outBlEmpIdName;//

    private Integer outIvtStatus;//
    private Integer inIvtStatus;//


    private  Integer outPaymentDaysId;
    private  String  outPaymentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private  Date outPaymentData;


    private  Integer inPaymentDaysId;
    private  String  inPaymentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private  Date inPaymentData;

    public Integer getOutPaymentDaysId() {
        return outPaymentDaysId;
    }

    public void setOutPaymentDaysId(Integer outPaymentDaysId) {
        this.outPaymentDaysId = outPaymentDaysId;
    }

    public String getOutPaymentName() {
        return outPaymentName;
    }

    public void setOutPaymentName(String outPaymentName) {
        this.outPaymentName = outPaymentName;
    }

    public Date getOutPaymentData() {
        return outPaymentData;
    }

    public void setOutPaymentData(Date outPaymentData) {
        this.outPaymentData = outPaymentData;
    }

    public Integer getInPaymentDaysId() {
        return inPaymentDaysId;
    }

    public void setInPaymentDaysId(Integer inPaymentDaysId) {
        this.inPaymentDaysId = inPaymentDaysId;
    }

    public String getInPaymentName() {
        return inPaymentName;
    }

    public void setInPaymentName(String inPaymentName) {
        this.inPaymentName = inPaymentName;
    }

    public Date getInPaymentData() {
        return inPaymentData;
    }

    public void setInPaymentData(Date inPaymentData) {
        this.inPaymentData = inPaymentData;
    }

    public Integer getOutIvtStatus() {
        return outIvtStatus;
    }

    public void setOutIvtStatus(Integer outIvtStatus) {
        this.outIvtStatus = outIvtStatus;
    }

    public Integer getInIvtStatus() {
        return inIvtStatus;
    }

    public void setInIvtStatus(Integer inIvtStatus) {
        this.inIvtStatus = inIvtStatus;
    }

    public String getInBlEmpIdName() {
        return inBlEmpIdName;
    }

    public void setInBlEmpIdName(String inBlEmpIdName) {
        this.inBlEmpIdName = inBlEmpIdName;
    }

    public String getOutBlEmpIdName() {
        return outBlEmpIdName;
    }

    public void setOutBlEmpIdName(String outBlEmpIdName) {
        this.outBlEmpIdName = outBlEmpIdName;
    }

    public String getOutWhName() {
        return outWhName;
    }

    public void setOutWhName(String outWhName) {
        this.outWhName = outWhName;
    }

    public String getInWhName() {
        return inWhName;
    }

    public void setInWhName(String inWhName) {
        this.inWhName = inWhName;
    }

    public String getInStatusName() {
        return inStatusName;
    }

    public void setInStatusName(String inStatusName) {
        this.inStatusName = inStatusName;
    }

    public String getOutStatusName() {
        return outStatusName;
    }

    public void setOutStatusName(String outStatusName) {
        this.outStatusName = outStatusName;
    }

    public String getOutCreaterName() {
        return outCreaterName;
    }

    public void setOutCreaterName(String outCreaterName) {
        this.outCreaterName = outCreaterName;
    }

    public String getInCreaterName() {
        return inCreaterName;
    }

    public void setInCreaterName(String inCreaterName) {
        this.inCreaterName = inCreaterName;
    }

    public String getInBillBarcode() {
        return inBillBarcode;
    }

    public void setInBillBarcode(String inBillBarcode) {
        this.inBillBarcode = inBillBarcode;
    }

    public String getOutBillBarcode() {
        return outBillBarcode;
    }

    public void setOutBillBarcode(String outBillBarcode) {
        this.outBillBarcode = outBillBarcode;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getAllotBillId() {
        return allotBillId;
    }

    public void setAllotBillId(Integer allotBillId) {
        this.allotBillId = allotBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getAltOutBillCode() {
        return altOutBillCode;
    }

    public void setAltOutBillCode(String altOutBillCode) {
        this.altOutBillCode = altOutBillCode == null ? null : altOutBillCode.trim();
    }

    public Integer getOutWhId() {
        return outWhId;
    }

    public void setOutWhId(Integer outWhId) {
        this.outWhId = outWhId;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Long getOutEmpId() {
        return outEmpId;
    }

    public void setOutEmpId(Long outEmpId) {
        this.outEmpId = outEmpId;
    }

    public String getOutRemark() {
        return outRemark;
    }

    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark == null ? null : outRemark.trim();
    }

    public String getOutState() {
        return outState;
    }

    public void setOutState(String outState) {
        this.outState = outState == null ? null : outState.trim();
    }

    public Long getOutCreater() {
        return outCreater;
    }

    public void setOutCreater(Long outCreater) {
        this.outCreater = outCreater;
    }

    public Long getOutModifier() {
        return outModifier;
    }

    public void setOutModifier(Long outModifier) {
        this.outModifier = outModifier;
    }

    public Long getOutBlEmpId() {
        return outBlEmpId;
    }

    public void setOutBlEmpId(Long outBlEmpId) {
        this.outBlEmpId = outBlEmpId;
    }

    public Date getOutCreatedTime() {
        return outCreatedTime;
    }

    public void setOutCreatedTime(Date outCreatedTime) {
        this.outCreatedTime = outCreatedTime;
    }

    public Date getOutUpdatedTime() {
        return outUpdatedTime;
    }

    public void setOutUpdatedTime(Date outUpdatedTime) {
        this.outUpdatedTime = outUpdatedTime;
    }

    public Date getOutBlTime() {
        return outBlTime;
    }

    public void setOutBlTime(Date outBlTime) {
        this.outBlTime = outBlTime;
    }

    public Byte getOutIsDelete() {
        return outIsDelete;
    }

    public void setOutIsDelete(Byte outIsDelete) {
        this.outIsDelete = outIsDelete;
    }

    public String getAltInBillCode() {
        return altInBillCode;
    }

    public void setAltInBillCode(String altInBillCode) {
        this.altInBillCode = altInBillCode == null ? null : altInBillCode.trim();
    }

    public Integer getInWhId() {
        return inWhId;
    }

    public void setInWhId(Integer inWhId) {
        this.inWhId = inWhId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Long getInEmpId() {
        return inEmpId;
    }

    public void setInEmpId(Long inEmpId) {
        this.inEmpId = inEmpId;
    }

    public String getInRemark() {
        return inRemark;
    }

    public void setInRemark(String inRemark) {
        this.inRemark = inRemark == null ? null : inRemark.trim();
    }

    public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState == null ? null : inState.trim();
    }

    public Long getInCreater() {
        return inCreater;
    }

    public void setInCreater(Long inCreater) {
        this.inCreater = inCreater;
    }

    public Long getInModifier() {
        return inModifier;
    }

    public void setInModifier(Long inModifier) {
        this.inModifier = inModifier;
    }

    public Long getInBlEmpId() {
        return inBlEmpId;
    }

    public void setInBlEmpId(Long inBlEmpId) {
        this.inBlEmpId = inBlEmpId;
    }

    public Date getInCreatedTime() {
        return inCreatedTime;
    }

    public void setInCreatedTime(Date inCreatedTime) {
        this.inCreatedTime = inCreatedTime;
    }

    public Date getInUpdatedTime() {
        return inUpdatedTime;
    }

    public void setInUpdatedTime(Date inUpdatedTime) {
        this.inUpdatedTime = inUpdatedTime;
    }

    public Date getInBlTime() {
        return inBlTime;
    }

    public void setInBlTime(Date inBlTime) {
        this.inBlTime = inBlTime;
    }

    public Byte getInIsDelete() {
        return inIsDelete;
    }

    public void setInIsDelete(Byte inIsDelete) {
        this.inIsDelete = inIsDelete;
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

    public Integer getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(Integer outStatus) {
        this.outStatus = outStatus;
    }

    public Integer getInStatus() {
        return inStatus;
    }

    public void setInStatus(Integer inStatus) {
        this.inStatus = inStatus;
    }
}
