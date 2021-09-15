package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.util.Date;

/**
 * 可售菜品明细表
 */
public class CateringSaledDishDetailDto implements Serializable {

    private Long projectId;

    private Integer saledDishDtlId;

    private Integer saledDishId;

    private Integer dishId;

    private Integer isDishPageage;

    private Long creater;

    private String createrName;

    private Date updatedTime;

    private Long modifier;

    private Integer isDelete;

    private Integer sellOut;

    private String saledDishCode;//单据编号

    private String saledDishName;//单据名称

    private Integer saledDishStatus;//审核状态

    private Date createdTime; //录入时间

    private Integer saledDishcomType;//可售商品类型'商品 30   /餐饮成品40/ 原材料10/半成品  20',

    private Integer saledDataType;//添加的数据类型（按餐厅  按菜品）

    private Integer sellPointId;

    private String saledName;

    public String getSaledName() {
        return saledName;
    }

    public void setSaledName(String saledName) {
        this.saledName = saledName;
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Integer getSaledDataType() {
        return saledDataType;
    }

    public void setSaledDataType(Integer saledDataType) {
        this.saledDataType = saledDataType;
    }

    public Integer getSaledDishcomType() {
        return saledDishcomType;
    }

    public void setSaledDishcomType(Integer saledDishcomType) {
        this.saledDishcomType = saledDishcomType;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getSaledDishCode() {
        return saledDishCode;
    }

    public void setSaledDishCode(String saledDishCode) {
        this.saledDishCode = saledDishCode;
    }

    public String getSaledDishName() {
        return saledDishName;
    }

    public void setSaledDishName(String saledDishName) {
        this.saledDishName = saledDishName;
    }

    public Integer getSaledDishStatus() {
        return saledDishStatus;
    }

    public void setSaledDishStatus(Integer saledDishStatus) {
        this.saledDishStatus = saledDishStatus;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSaledDishDtlId() {
        return saledDishDtlId;
    }

    public void setSaledDishDtlId(Integer saledDishDtlId) {
        this.saledDishDtlId = saledDishDtlId;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }



    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getIsDishPageage() {
        return isDishPageage;
    }

    public void setIsDishPageage(Integer isDishPageage) {
        this.isDishPageage = isDishPageage;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSellOut() {
        return sellOut;
    }

    public void setSellOut(Integer sellOut) {
        this.sellOut = sellOut;
    }
}