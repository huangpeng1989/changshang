package modelpojo.vo.commodityAplBill;

import java.io.Serializable;

public class GzoneVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8159123885395122295L;
	private Integer gzoneId;
	private String gzoneCode;
	private String gzoneName;
	private Integer whId;
	private String whCode;
	private String whName;
	
	public Integer getGzoneId() {
		return gzoneId;
	}
	public void setGzoneId(Integer gzoneId) {
		this.gzoneId = gzoneId;
	}
	public String getGzoneCode() {
		return gzoneCode;
	}
	public void setGzoneCode(String gzoneCode) {
		this.gzoneCode = gzoneCode;
	}
	public String getGzoneName() {
		return gzoneName;
	}
	public void setGzoneName(String gzoneName) {
		this.gzoneName = gzoneName;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getWhCode() {
		return whCode;
	}
	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	
}
