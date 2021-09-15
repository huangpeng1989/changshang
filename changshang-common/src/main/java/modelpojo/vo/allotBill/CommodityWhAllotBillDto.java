package modelpojo.vo.allotBill;

import java.util.List;

/**
 *调拨出库申请/确认单
 */
public class CommodityWhAllotBillDto extends CommodityWhAllotBill {


    private List<CommodityWhAllotBillDtlDto> commList;// 商品数据

    public List<CommodityWhAllotBillDtlDto> getCommList() {
        return commList;
    }

    public void setCommList(List<CommodityWhAllotBillDtlDto> commList) {
        this.commList = commList;
    }
}