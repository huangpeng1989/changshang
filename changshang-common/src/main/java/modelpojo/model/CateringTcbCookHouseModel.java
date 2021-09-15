package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringTcbCookHouseModel implements Serializable {
    private Long projectRootId;

    private Integer wareHouseId;

    private String wareHouseCode;

    private String cookHouseCode;

    private String cookHouseName;

    private Integer cookHouseType;

    private String dishClassCode;

    private String printerUrl;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Long blEmpId;

    private Date blTime;

    private Integer cookHourseStatus;

    private Byte isDelete;
	
	private Integer cookHouseId;

    private Long projectId;

    private Integer gzoneId;

    private Integer syncStatus;

    private String gzoneName;

    private String whName;

    private Integer isPassDish;//新加字段：是否传菜

    private Integer houseType;//新加字段： 厨房菜品:1.按类型设置，2.按菜品设置

    private Integer printerContent;//打印内容

    public Integer getPrinterContent() {
        return printerContent;
    }

    public void setPrinterContent(Integer printerContent) {
        this.printerContent = printerContent;
    }

    public Integer getIsPassDish() {
        return isPassDish;
    }

    public void setIsPassDish(Integer isPassDish) {
        this.isPassDish = isPassDish;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
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

    public Integer getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(Integer wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getWareHouseCode() {
        return wareHouseCode;
    }

    public void setWareHouseCode(String wareHouseCode) {
        this.wareHouseCode = wareHouseCode;
    }

    public String getCookHouseCode() {
        return cookHouseCode;
    }

    public void setCookHouseCode(String cookHouseCode) {
        this.cookHouseCode = cookHouseCode;
    }

    public String getCookHouseName() {
        return cookHouseName;
    }

    public void setCookHouseName(String cookHouseName) {
        this.cookHouseName = cookHouseName;
    }

    public Integer getCookHouseType() {
        return cookHouseType;
    }

    public void setCookHouseType(Integer cookHouseType) {
        this.cookHouseType = cookHouseType;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getPrinterUrl() {
        return printerUrl;
    }

    public void setPrinterUrl(String printerUrl) {
        this.printerUrl = printerUrl;
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

    public Integer getCookHourseStatus() {
        return cookHourseStatus;
    }

    public void setCookHourseStatus(Integer cookHourseStatus) {
        this.cookHourseStatus = cookHourseStatus;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCookHouseId() {
        return cookHouseId;
    }

    public void setCookHouseId(Integer cookHouseId) {
        this.cookHouseId = cookHouseId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}