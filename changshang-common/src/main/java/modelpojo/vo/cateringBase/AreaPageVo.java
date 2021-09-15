package modelpojo.vo.cateringBase;

import java.io.Serializable;

public class AreaPageVo extends PageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**营业点id */
	private Integer sellPointId;
	/**区域类型主键id */
	private Integer areaTypeId;		
	/**营业点名称 */
	private String gzoneName;
	/**营业点编码 */
	private String gzoneCode;
	
	public Integer getSellPointId() {
		return sellPointId;
	}
	public void setSellPointId(Integer sellPointId) {
		this.sellPointId = sellPointId;
	}
	public Integer getAreaTypeId() {
		return areaTypeId;
	}
	public void setAreaTypeId(Integer areaTypeId) {
		this.areaTypeId = areaTypeId;
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
