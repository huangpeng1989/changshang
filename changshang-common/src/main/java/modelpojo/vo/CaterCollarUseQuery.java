package modelpojo.vo;

import modelpojo.model.CateringWhRcptRtnBillDtlModel;
import modelpojo.model.CateringWhRcptRtnBillModel;

import java.util.List;

public class CaterCollarUseQuery extends CateringWhRcptRtnBillModel {

    private List<CateringWhRcptRtnBillDtlModel> detailModels;

    public List<CateringWhRcptRtnBillDtlModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<CateringWhRcptRtnBillDtlModel> detailModels) {
        this.detailModels = detailModels;
    }


}
