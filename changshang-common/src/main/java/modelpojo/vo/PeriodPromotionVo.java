package modelpojo.vo;

import modelpojo.model.promotion.periodpromotion.CatecommPeriodPromotion;
import modelpojo.model.promotion.periodpromotion.CatecommPeriodPromotionDtl;

import java.util.List;

public class PeriodPromotionVo extends CatecommPeriodPromotion {

    private List<CatecommPeriodPromotionDtl> dtlList;

    public List<CatecommPeriodPromotionDtl> getDtlList() {
        return dtlList;
    }

    public void setDtlList(List<CatecommPeriodPromotionDtl> dtlList) {
        this.dtlList = dtlList;
    }
}
