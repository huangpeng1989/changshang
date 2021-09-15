package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;

public class ProcedureResultVo implements Serializable {

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
	private Boolean resultCode;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getResultCode() {
		return resultCode;
	}

	public void setResultCode(Boolean resultCode) {
		this.resultCode = resultCode;
	}
}
