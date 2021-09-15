package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;

public class BillCheckMthVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String msg;
	/**
	 * 成功true,失败false
	 */
	private Boolean rltcode;
	private String altInBillCode;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getRltcode() {
		return rltcode;
	}
	public void setRltcode(Boolean rltcode) {
		this.rltcode = rltcode;
	}

	public String getAltInBillCode() {
		return altInBillCode;
	}

	public void setAltInBillCode(String altInBillCode) {
		this.altInBillCode = altInBillCode;
	}
}
