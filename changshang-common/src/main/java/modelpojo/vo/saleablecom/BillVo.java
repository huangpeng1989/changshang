package modelpojo.vo.saleablecom;

import modelpojo.model.CommoditySaledComBill;
import modelpojo.model.CommoditySaledComBillDetail;

import java.io.Serializable;
import java.util.List;

public class BillVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CommoditySaledComBill bill;
	
	private List<CommoditySaledComBillDetail> billDetailLst;

	public CommoditySaledComBill getBill() {
		return bill;
	}

	public void setBill(CommoditySaledComBill bill) {
		this.bill = bill;
	}

	public List<CommoditySaledComBillDetail> getBillDetailLst() {
		return billDetailLst;
	}

	public void setBillDetailLst(List<CommoditySaledComBillDetail> billDetailLst) {
		this.billDetailLst = billDetailLst;
	}

}
