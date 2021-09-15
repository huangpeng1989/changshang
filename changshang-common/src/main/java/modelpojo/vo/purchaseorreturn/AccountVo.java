package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;

public class AccountVo implements Serializable{
	/**
	 *
	 */

	private Long id;
	private Integer islogin;


	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getIslogin() {
		return islogin;
	}
	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}

}
