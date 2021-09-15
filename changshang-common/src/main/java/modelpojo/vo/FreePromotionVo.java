package modelpojo.vo;


import modelpojo.model.promotion.freepromotion.CatecommFreePromotion;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotionDtl;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotionRule;

import java.util.List;

public class FreePromotionVo extends CatecommFreePromotion {

    private List<CatecommFreePromotionDtl> dtlList;

    private List<CatecommFreePromotionRule> ruleList;

    @Override
    public List<CatecommFreePromotionDtl> getDtlList() {
        return dtlList;
    }

    @Override
    public void setDtlList(List<CatecommFreePromotionDtl> dtlList) {
        this.dtlList = dtlList;
    }

    @Override
    public List<CatecommFreePromotionRule> getRuleList() {
        return ruleList;
    }

    @Override
    public void setRuleList(List<CatecommFreePromotionRule> ruleList) {
        this.ruleList = ruleList;
    }
}
