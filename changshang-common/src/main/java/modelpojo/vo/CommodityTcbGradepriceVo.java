package modelpojo.vo;


import modelpojo.model.CommodityTcbGradeprice;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 商品价格配置扩展表
 */
public class CommodityTcbGradepriceVo extends CommodityTcbGradeprice implements Serializable {

    //项目根节点
    private Integer projectRootId;

    //日志标识
    private String flagType;

    //商品价格等级名称
    private String gradeName;

    private BigDecimal oldRetailPrice;

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Integer projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }

}
