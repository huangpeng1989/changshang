package modelpojo.vo;


import modelpojo.model.CommodityWhRcptRtnBillDtlModel;
import modelpojo.model.CommodityWhRcptRtnBillModel;

import java.util.List;

public class CollarUseQuery extends CommodityWhRcptRtnBillModel {

    private List<CommodityWhRcptRtnBillDtlModel> detailModels;

    public List<CommodityWhRcptRtnBillDtlModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<CommodityWhRcptRtnBillDtlModel> detailModels) {
        this.detailModels = detailModels;
    }


}
