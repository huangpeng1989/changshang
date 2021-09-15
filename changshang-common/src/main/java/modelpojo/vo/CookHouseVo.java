package modelpojo.vo;


import modelpojo.model.CateringTcbCookHouseDetailModel;
import modelpojo.model.CateringTcbCookHouseModel;

import java.util.List;

public class CookHouseVo extends CateringTcbCookHouseModel {
    private List<CateringTcbCookHouseDetailModel> detailModels;

    public List<CateringTcbCookHouseDetailModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(List<CateringTcbCookHouseDetailModel> detailModels) {
        this.detailModels = detailModels;
    }
}
