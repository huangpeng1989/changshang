package modelpojo.vo.commodityAplBill;

import java.io.Serializable;

public class SuppVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2881506240117300148L;
	
	private Integer isDefault;
	private Integer suppId;
	private String suppName;
	
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getSuppId() {
		return suppId;
	}
	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	
}
