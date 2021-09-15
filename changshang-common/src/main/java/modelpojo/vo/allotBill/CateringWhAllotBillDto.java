package modelpojo.vo.allotBill;

import java.util.List;

/**
 *调拨出库申请/确认单
 */
public class CateringWhAllotBillDto extends CateringWhAllotBill {


    private List<CateringWhAllotBillDtlDto> commList;// 原材料数据

    private List<CateringWhAllotBillDtlDto> halfList;// 半成品数据

    private String inStatusName;//调入仓库盘点状态

    private String outStatusName;//调出仓库盘点状态


    @Override
    public String getInStatusName() {
        return inStatusName;
    }

    @Override
    public void setInStatusName(String inStatusName) {
        this.inStatusName = inStatusName;
    }

    @Override
    public String getOutStatusName() {
        return outStatusName;
    }

    @Override
    public void setOutStatusName(String outStatusName) {
        this.outStatusName = outStatusName;
    }

    public List<CateringWhAllotBillDtlDto> getHalfList() {
        return halfList;
    }

    public void setHalfList(List<CateringWhAllotBillDtlDto> halfList) {
        this.halfList = halfList;
    }

    public List<CateringWhAllotBillDtlDto> getCommList() {
        return commList;
    }

    public void setCommList(List<CateringWhAllotBillDtlDto> commList) {
        this.commList = commList;
    }
}