package modelpojo.vo.commodityAplBill;

import java.io.Serializable;

public class CommodityAplBillDtlSuppVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4546072732998323092L;
	private Integer aplBillDtlId;
	private Integer suppId;
	
	public Integer getAplBillDtlId() {
		return aplBillDtlId;
	}
	public void setAplBillDtlId(Integer aplBillDtlId) {
		this.aplBillDtlId = aplBillDtlId;
	}
	public Integer getSuppId() {
		return suppId;
	}
	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}
	
}
