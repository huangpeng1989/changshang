package modelpojo.vo;


import modelpojo.model.promotion.freereduction.CatecommFreeReduction;
import modelpojo.model.promotion.freereduction.CatecommFreeReductionDtl;
import modelpojo.model.promotion.freereduction.CatecommFreeReductionRule;

import java.util.List;

public class FreeReductionVo extends CatecommFreeReduction {

    private List<CatecommFreeReductionDtl> dtlList;

    private List<CatecommFreeReductionRule> ruleList;

    @Override
    public List<CatecommFreeReductionDtl> getDtlList() {
        return dtlList;
    }

    @Override
    public void setDtlList(List<CatecommFreeReductionDtl> dtlList) {
        this.dtlList = dtlList;
    }

    @Override
    public List<CatecommFreeReductionRule> getRuleList() {
        return ruleList;
    }

    @Override
    public void setRuleList(List<CatecommFreeReductionRule> ruleList) {
        this.ruleList = ruleList;
    }
}
