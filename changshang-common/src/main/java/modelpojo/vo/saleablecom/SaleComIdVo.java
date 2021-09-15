package modelpojo.vo.saleablecom;

import java.io.Serializable;

public class SaleComIdVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer comBillId;
	
	/**
	 * 通过审核是1
	 */
	private Integer pass;
	public Integer getComBillId() {
		return comBillId;
	}
	public void setComBillId(Integer comBillId) {
		this.comBillId = comBillId;
	}
	public Integer getPass() {
		return pass;
	}
	public void setPass(Integer pass) {
		this.pass = pass;
	}

}
