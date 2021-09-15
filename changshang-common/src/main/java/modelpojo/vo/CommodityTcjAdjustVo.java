package modelpojo.vo;


import modelpojo.model.CommodityTcjAdjust;
import modelpojo.model.CommodityTcjAdjustDetail;

import java.io.Serializable;
import java.util.List;


public class CommodityTcjAdjustVo extends CommodityTcjAdjust implements Serializable{


    public String getAdjIds() {
        return adjIds;
    }

    public void setAdjIds(String adjIds) {
        this.adjIds = adjIds;
    }

    private String adjIds;
    public CommodityTcjAdjust getCommodityTcjAdjust() {
        return commodityTcjAdjust;
    }

    public void setCommodityTcjAdjust(CommodityTcjAdjust commodityTcjAdjust) {
        this.commodityTcjAdjust = commodityTcjAdjust;
    }

    private CommodityTcjAdjust commodityTcjAdjust;

    // 进价调价字表信息
    private List<CommodityTcjAdjustDetail> commodityTcjAdjustdetailList;

    // 进价调价字表信息
    private List<CommodityTcjAdjustDetailVo> commodityTcjAdjustdetailVos;

    public List<CommodityTcjAdjustDetailVo> getCommodityTcjAdjustdetailVos() {
        return commodityTcjAdjustdetailVos;
    }

    public void setCommodityTcjAdjustdetailVos(List<CommodityTcjAdjustDetailVo> commodityTcjAdjustdetailVos) {
        this.commodityTcjAdjustdetailVos = commodityTcjAdjustdetailVos;
    }

    //
    public List<CommodityTcjAdjustDetail> getCommodityTcjAdjustdetailList() {
        return commodityTcjAdjustdetailList;
    }

    public void setCommodityTcjAdjustdetailList(List<CommodityTcjAdjustDetail> commodityTcjAdjustdetailList) {
        this.commodityTcjAdjustdetailList = commodityTcjAdjustdetailList;
    }




}
