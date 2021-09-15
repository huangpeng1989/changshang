package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-03-24 10:57
 */
public class StorageOrderExportRequestVo implements Serializable {
    private static final long serialVersionUID = -640895450106187617L;

    private Integer acptBillId;
    private Integer whId;

    public Integer getAcptBillId() {
        return acptBillId;
    }

    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }
}
