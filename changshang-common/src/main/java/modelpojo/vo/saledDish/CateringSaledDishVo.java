package modelpojo.vo.saledDish;


import modelpojo.vo.saleadjust.PagerObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 可售菜品设置主表
 */
public class CateringSaledDishVo implements Serializable {

    private Long projectId;

    private Integer saledDishId;


    private Long projectRootId;

    private String saledDishCode;

    private String saledDishName;

    private Integer sellPointId;

    private Integer saledDishStatus;

    private String saledDishStatusName;

    private Integer isDelete;

    private String remark;

    private String state;

    private Long creater;

    private Date createdTime;

    private Long modifier;

    private Date updatedTime;

    private Long blEmpId;

    private Date blTime;

    private Integer saledDataType;//'录入数据类型 10按餐厅 20按菜品 '

    List<CateringTcbDishesDto> list ;//菜品详情数据

    private PagerObject pagerObject;//新菜品详情数据

    List<SaleCommDto> commList ;//菜品详情数据

    private Integer dishId;//商品id  /菜品id

    private String sellPointName;

    private String dishName;


    private String updateIndex;//0 表示原始数据，1表示新增数据

    public String getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(String updateIndex) {
        this.updateIndex = updateIndex;
    }

    public PagerObject getPagerObject() {
        return pagerObject;
    }

    public void setPagerObject(PagerObject pagerObject) {
        this.pagerObject = pagerObject;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getSellPointName() {
        return sellPointName;
    }

    public void setSellPointName(String sellPointName) {
        this.sellPointName = sellPointName;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public List<SaleCommDto> getCommList() {
        return commList;
    }

    public void setCommList(List<SaleCommDto> commList) {
        this.commList = commList;
    }

    public List<CateringTcbDishesDto> getList() {
        return list;
    }

    public void setList(List<CateringTcbDishesDto> list) {
        this.list = list;
    }

    public String getSaledDishStatusName() {
        return saledDishStatusName;
    }

    public void setSaledDishStatusName(String saledDishStatusName) {
        this.saledDishStatusName = saledDishStatusName;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
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

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public Integer getSaledDishStatus() {
        return saledDishStatus;
    }

    public void setSaledDishStatus(Integer saledDishStatus) {
        this.saledDishStatus = saledDishStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Integer getSaledDataType() {
        return saledDataType;
    }

    public void setSaledDataType(Integer saledDataType) {
        this.saledDataType = saledDataType;
    }
}
