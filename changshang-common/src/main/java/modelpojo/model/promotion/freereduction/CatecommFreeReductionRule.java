package modelpojo.model.promotion.freereduction;

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
public class CatecommFreeReductionRule implements Serializable {
    private  Long projectId;
    private  Long projectRootId;
    private  Integer freeId;
    private  Integer freeRuleId;
    private  BigDecimal fullPrice;
    private  BigDecimal reductionPrice;
    private  Integer isDelete;
    private  Long creater;
    private  Date createdTime;
    private  Long modifier;
    private  Date updatedTime;

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public BigDecimal getReductionPrice() {
        return reductionPrice;
    }

    public void setReductionPrice(BigDecimal reductionPrice) {
        this.reductionPrice = reductionPrice;
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
