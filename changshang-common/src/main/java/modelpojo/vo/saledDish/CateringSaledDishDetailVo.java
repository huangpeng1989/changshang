package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 可售菜品明细表
 */
public class CateringSaledDishDetailVo implements Serializable {

    private Long projectId;

    private Integer saledDishDtlId;

    private Integer saledDishId;

    private String saledDishCode;

    private Integer dishId;

    private Integer isDishPageage;//是否套餐

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Integer isDelete;

    private Integer sellOut;

    private Integer saledDishcomType;

    private Integer sellPointId;//=营业点id

    private Integer updateIndex;//'0 表示原始数据，1表示新增数据'

    private Integer isSaleStatus;//是否可售0不可售，1可售

    public Integer getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(Integer isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    List<PriceTypeVo> list; //价格信息详情

    public Integer getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Integer updateIndex) {
        this.updateIndex = updateIndex;
    }

    public List<PriceTypeVo> getList() {
        return list;
    }

    public void setList(List<PriceTypeVo> list) {
        this.list = list;
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public Integer getSaledDishcomType() {
        return saledDishcomType;
    }

    public void setSaledDishcomType(Integer saledDishcomType) {
        this.saledDishcomType = saledDishcomType;
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

    public String getSaledDishCode() {
        return saledDishCode;
    }

    public void setSaledDishCode(String saledDishCode) {
        this.saledDishCode = saledDishCode;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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

    public Integer getIsDishPageage() {
        return isDishPageage;
    }

    public void setIsDishPageage(Integer isDishPageage) {
        this.isDishPageage = isDishPageage;
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
