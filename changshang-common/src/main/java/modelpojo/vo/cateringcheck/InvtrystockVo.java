package modelpojo.vo.cateringcheck;

import java.io.Serializable;

public class InvtrystockVo implements Serializable{
	
	/**
	 * 成功true,失败false
	 */
	private Boolean rscode;
	
	private String msg;

	public Boolean getRscode() {
		return rscode;
	}

	public void setRscode(Boolean rscode) {
		this.rscode = rscode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
