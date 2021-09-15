package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;

public class CheckStartVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8782276187274330571L;

	private Boolean status;
	
	private Integer type;
	
	private String code;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
