package modelpojo.model.promotion.freereduction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.quick.clota.commodity.model.promotion.freepromotion
 * @ClassName:CommodityFreePromotion
 * @Description
 * @author: huangpeng
 * @date:2021/6/1 15:22
 */
public class CatecommFreeReduction implements Serializable {

    private  Long projectId;
    private  Long projectRootId;
    private  Integer freeId;
    private  String freeCode;
    private  String freeName;
    private Integer freeGrade;
    private Date freeStartDay;
    private String freeStartDayStr;
    private  Date freeEndDay;
    private String freeEndDayStr;
    private  String freeCycle;
    private  Integer freeType;
    private  Integer freeStatus;
    private  String freeRemark;
    private  Integer syncStatus;
    private  Integer isDelete;
    private  Long blEmpId;
    private  Integer gzoneId;
    private  Integer goodType;
    private  Date blTime;
    private  Long creater;
    private  Date createdTime;
    private  Long modifier;
    private  Date updatedTime;
    private List<CatecommFreeReductionDtl> dtlList = new ArrayList<>();
    private List<CatecommFreeReductionRule> ruleList = new ArrayList<>();

    public String getFreeStartDayStr() {
        return freeStartDayStr;
    }

    public void setFreeStartDayStr(String freeStartDayStr) {
        this.freeStartDayStr = freeStartDayStr;
    }

    public String getFreeEndDayStr() {
        return freeEndDayStr;
    }

    public void setFreeEndDayStr(String freeEndDayStr) {
        this.freeEndDayStr = freeEndDayStr;
    }

    public List<CatecommFreeReductionDtl> getDtlList() {
        return dtlList;
    }

    public void setDtlList(List<CatecommFreeReductionDtl> dtlList) {
        this.dtlList = dtlList;
    }

    public List<CatecommFreeReductionRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<CatecommFreeReductionRule> ruleList) {
        this.ruleList = ruleList;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
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

    public Integer getFreeId() {
        return freeId;
    }

    public void setFreeId(Integer freeId) {
        this.freeId = freeId;
    }

    public String getFreeCode() {
        return freeCode;
    }

    public void setFreeCode(String freeCode) {
        this.freeCode = freeCode;
    }

    public String getFreeName() {
        return freeName;
    }

    public void setFreeName(String freeName) {
        this.freeName = freeName;
    }

    public Integer getFreeGrade() {
        return freeGrade;
    }

    public void setFreeGrade(Integer freeGrade) {
        this.freeGrade = freeGrade;
    }

    public Date getFreeStartDay() {
        return freeStartDay;
    }

    public void setFreeStartDay(Date freeStartDay) {
        this.freeStartDay = freeStartDay;
    }

    public Date getFreeEndDay() {
        return freeEndDay;
    }

    public void setFreeEndDay(Date freeEndDay) {
        this.freeEndDay = freeEndDay;
    }

    public String getFreeCycle() {
        return freeCycle;
    }

    public void setFreeCycle(String freeCycle) {
        this.freeCycle = freeCycle;
    }

    public Integer getFreeType() {
        return freeType;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public Integer getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(Integer freeStatus) {
        this.freeStatus = freeStatus;
    }

    public String getFreeRemark() {
        return freeRemark;
    }

    public void setFreeRemark(String freeRemark) {
        this.freeRemark = freeRemark;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
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
}
