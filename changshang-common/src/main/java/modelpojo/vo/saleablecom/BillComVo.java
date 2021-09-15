package modelpojo.vo.saleablecom;

import entity.ModelPagedList;
import modelpojo.model.CommoditySaledComBill;

import java.io.Serializable;
import java.util.List;


public class BillComVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CommoditySaledComBill bill;
	
	private List<SaleableComPageCommodityListVo> comLst;
	private ModelPagedList<SaleableComPageCommodityListVo> comPageLst;

	public ModelPagedList<SaleableComPageCommodityListVo> getComPageLst() {
		return comPageLst;
	}

	public void setComPageLst(ModelPagedList<SaleableComPageCommodityListVo> comPageLst) {
		this.comPageLst = comPageLst;
	}

	public CommoditySaledComBill getBill() {
		return bill;
	}

	public void setBill(CommoditySaledComBill bill) {
		this.bill = bill;
	}

	public List<SaleableComPageCommodityListVo> getComLst() {
		return comLst;
	}

	public void setComLst(List<SaleableComPageCommodityListVo> comLst) {
		this.comLst = comLst;
	}

}
