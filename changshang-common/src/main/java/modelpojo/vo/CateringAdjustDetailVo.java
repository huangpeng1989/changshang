package modelpojo.vo;

import modelpojo.model.CateringTcjAdjustDetail;

import java.math.BigDecimal;

public class CateringAdjustDetailVo extends CateringTcjAdjustDetail {
    private String rmUnitName;

    private BigDecimal packContent;

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }
}
