package modelpojo.vo;

import modelpojo.model.CateringSaledDishDetailModel;
import modelpojo.model.CateringSaledDishDetailPriceModel;
import modelpojo.model.CateringSaledDishModel;

import java.util.List;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-06-05 10:56
 */
public class CateringSaledDishModelVo extends CateringSaledDishModel {

    private List<CateringSaledDishDetailModel> saledDishDetailList;

    private List<CateringSaledDishDetailPriceModel> saledDishDetailPriceList;

    public List<CateringSaledDishDetailModel> getSaledDishDetailList() {
        return saledDishDetailList;
    }

    public void setSaledDishDetailList(List<CateringSaledDishDetailModel> saledDishDetailList) {
        this.saledDishDetailList = saledDishDetailList;
    }

    public List<CateringSaledDishDetailPriceModel> getSaledDishDetailPriceList() {
        return saledDishDetailPriceList;
    }

    public void setSaledDishDetailPriceList(List<CateringSaledDishDetailPriceModel> saledDishDetailPriceList) {
        this.saledDishDetailPriceList = saledDishDetailPriceList;
    }
}
