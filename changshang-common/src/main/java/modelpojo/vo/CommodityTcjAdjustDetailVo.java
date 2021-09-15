package modelpojo.vo;

import modelpojo.model.CommodityTcjAdjustDetail;

import java.math.BigDecimal;

/**
 * 进价调价子表
 */
public class CommodityTcjAdjustDetailVo extends CommodityTcjAdjustDetail {
    private BigDecimal packContent;//包装含量

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }
}
