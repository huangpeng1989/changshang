package modelpojo.vo.cateringBase;

import java.io.Serializable;

public class TablePageVo extends PageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**桌台id */
	private Integer areaTableId;		
	/**营业点名称 */
	private String gzoneName;
	/**营业点编码 */
	private String gzoneCode;
	
	public Integer getAreaTableId() {
		return areaTableId;
	}
	public void setAreaTableId(Integer areaTableId) {
		this.areaTableId = areaTableId;
	}
	public String getGzoneName() {
		return gzoneName;
	}
	public void setGzoneName(String gzoneName) {
		this.gzoneName = gzoneName;
	}
	public String getGzoneCode() {
		return gzoneCode;
	}
	public void setGzoneCode(String gzoneCode) {
		this.gzoneCode = gzoneCode;
	}

}
