package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.util.List;

public class CommdityHcacptVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2873255545280753144L;
	CommdityWhHcacptBill bill;
	List<CommdityWhHcacptBillDtl> billDtllist;
	CommdityHcacptListVo billVo;
	List<CommdityHcacptDtlVo> billDtlVoList;
	
	public CommdityWhHcacptBill getBill() {
		return bill;
	}
	public void setBill(CommdityWhHcacptBill bill) {
		this.bill = bill;
	}
	public List<CommdityWhHcacptBillDtl> getBillDtllist() {
		return billDtllist;
	}
	public void setBillDtllist(List<CommdityWhHcacptBillDtl> billDtllist) {
		this.billDtllist = billDtllist;
	}
	public CommdityHcacptListVo getBillVo() {
		return billVo;
	}
	public void setBillVo(CommdityHcacptListVo billVo) {
		this.billVo = billVo;
	}
	public List<CommdityHcacptDtlVo> getBillDtlVoList() {
		return billDtlVoList;
	}
	public void setBillDtlVoList(List<CommdityHcacptDtlVo> billDtlVoList) {
		this.billDtlVoList = billDtlVoList;
	}
	
}
