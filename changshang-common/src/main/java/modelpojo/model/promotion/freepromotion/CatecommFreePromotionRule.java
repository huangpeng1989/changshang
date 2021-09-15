package modelpojo.model.promotion.freepromotion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:com.quick.clota.commodity.model.promotion.freepromotion
 * @ClassName:CommodityFreePromotionRule
 * @Description
 * @author: huangpeng
 * @date:2021/6/1 16:38
 */
public class CatecommFreePromotionRule implements Serializable {
    private  Long projectId;
    private  Long projectRootId;
    private  Integer freeId;
    private  Integer freeRuleId;
    private  Integer comId;
    private  String comCode;
    private  Integer comUnit;
    private  String comSpec;
    private  String comBarcode;
    private  BigDecimal comRetailPrice;
    private  String comName;
    private  BigDecimal giveNum;
    private  Integer isDelete;
    private  Long creater;
    private  Date createdTime;
    private  Long modifier;
    private  Date updatedTime;
    private Integer goodType;
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

    public Integer getFreeRuleId() {
        return freeRuleId;
    }

    public void setFreeRuleId(Integer freeRuleId) {
        this.freeRuleId = freeRuleId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public BigDecimal getComRetailPrice() {
        return comRetailPrice;
    }

    public void setComRetailPrice(BigDecimal comRetailPrice) {
        this.comRetailPrice = comRetailPrice;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public BigDecimal getGiveNum() {
        return giveNum;
    }

    public void setGiveNum(BigDecimal giveNum) {
        this.giveNum = giveNum;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
}
