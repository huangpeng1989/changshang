package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CatecommTsbWarehouseModel  implements Serializable {
    private String whCode;

    private Integer gzoneId;

    private String gzoneCode;

    private String buttJointCode;

    private String whName;

    private Integer whClass;

    private Byte isNegatHand;

    private Byte isStartUsing;

    private Byte isPurchaseWh;

    private Integer whXxStatus;

    private Integer whTypes;

    private String whTypesName;

    private String remark;

    private String state;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Long blEmpId;

    private Date blTime;

    private Byte isDelete;

    private Integer status;

	 private Long projectId;

	 private Long projectRootId;

    private Integer whId;
    private Long upProjectId;

    private String errorInfo;

    private Long upProjectRootId;


    private String acptBillCode;

    private String gzoneName;

    private String whClassName;

    private Integer caterStatus;
    private String ivtStatusName;  //商品盘点状态名称
    private String caterStatusName;//餐饮盘点状态名称

    private String statueName;

    public String getStatueName() {
        return statueName;
    }

    public void setStatueName(String statueName) {
        this.statueName = statueName;
    }

    public String getWhClassName() {
        return whClassName;
    }

    public String getIvtStatusName() {
        return ivtStatusName;
    }

    public void setIvtStatusName(String ivtStatusName) {
        this.ivtStatusName = ivtStatusName;
    }

    public String getCaterStatusName() {
        return caterStatusName;
    }

    public void setCaterStatusName(String caterStatusName) {
        this.caterStatusName = caterStatusName;
    }

    public void setWhClassName(String whClassName) {
        this.whClassName = whClassName;
    }

    public String getWhTypesName() {
        return whTypesName;
    }

    public Integer getCaterStatus() {
        return caterStatus;
    }

    public void setCaterStatus(Integer caterStatus) {
        this.caterStatus = caterStatus;
    }

    public void setWhTypesName(String whTypesName) {
        this.whTypesName = whTypesName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode;
    }



    public String getStatusinfo() {
        return statusinfo;
    }

    public void setStatusinfo(String statusinfo) {
        this.statusinfo = statusinfo;
    }

    private String statusinfo;





    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }





    public Integer getIvtStatus() {
        return ivtStatus;
    }

    public void setIvtStatus(Integer ivtStatus) {
        this.ivtStatus = ivtStatus;
    }

    private Integer ivtStatus;

    private String thiLocCode;


    private String firLocCode;

    private String dtlLocCode;

    private Integer whLevel;

    private String orgName;

    private String typeName;//字典名称

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String companyName;
    private String jqName;

    public String getJqName() {
        return jqName;
    }

    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getWhLevel() {
        return whLevel;
    }

    public void setWhLevel(Integer whLevel) {
        this.whLevel = whLevel;
    }

    public String getThiLocCode() {
        return thiLocCode;
    }

    public void setThiLocCode(String thiLocCode) {
        this.thiLocCode = thiLocCode;
    }

    public String getFirLocCode() {
        return firLocCode;
    }

    public void setFirLocCode(String firLocCode) {
        this.firLocCode = firLocCode;
    }

    public String getDtlLocCode() {
        return dtlLocCode;
    }

    public void setDtlLocCode(String dtlLocCode) {
        this.dtlLocCode = dtlLocCode;
    }

    public String getSecLocCode() {
        return secLocCode;
    }

    public void setSecLocCode(String secLocCode) {
        this.secLocCode = secLocCode;
    }

    private String secLocCode;










    public Long getUpProjectRootId() {
        return upProjectRootId;
    }

    public void setUpProjectRootId(Long upProjectRootId) {
        this.upProjectRootId = upProjectRootId;
    }





    public Long getUpProjectId() {
        return upProjectId;
    }

    public void setUpProjectId(Long upProjectId) {
        this.upProjectId = upProjectId;
    }



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

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
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

    public String getButtJointCode() {
        return buttJointCode;
    }

    public void setButtJointCode(String buttJointCode) {
        this.buttJointCode = buttJointCode == null ? null : buttJointCode.trim();
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName == null ? null : whName.trim();
    }

    public Integer getWhClass() {
        return whClass;
    }

    public void setWhClass(Integer whClass) {
        this.whClass = whClass;
    }

    public Byte getIsNegatHand() {
        return isNegatHand;
    }

    public void setIsNegatHand(Byte isNegatHand) {
        this.isNegatHand = isNegatHand;
    }

    public Byte getIsStartUsing() {
        return isStartUsing;
    }

    public void setIsStartUsing(Byte isStartUsing) {
        this.isStartUsing = isStartUsing;
    }

    public Byte getIsPurchaseWh() {
        return isPurchaseWh;
    }

    public void setIsPurchaseWh(Byte isPurchaseWh) {
        this.isPurchaseWh = isPurchaseWh;
    }

    public Integer getWhXxStatus() {
        return whXxStatus;
    }

    public void setWhXxStatus(Integer whXxStatus) {
        this.whXxStatus = whXxStatus;
    }

    public Integer getWhTypes() {
        return whTypes;
    }

    public void setWhTypes(Integer whTypes) {
        this.whTypes = whTypes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
