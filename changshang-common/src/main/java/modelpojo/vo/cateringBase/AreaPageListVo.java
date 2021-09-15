package modelpojo.vo.cateringBase;

import java.io.Serializable;

public class AreaPageListVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**营业点id */
	private String gzoneId;
	/**营业点名称 */
	private String gzoneName;
	/**区域类型id */
	private Integer areaTypeId;
	/**营业点编码 */
	private String gzoneCode;
	/**区域类型编号 */
	private String areaTypeCode;
	/**区域类型名称 */
	private String areaTypeName;
	/**楼层 */
	private String dtlLocation;
	/**备注 */
	private String remark;
	/**总记录数 */
	private Integer totalPage;
	/**总记录数 */
	private Integer totalRow;
	
	public String getGzoneId() {
		return gzoneId;
	}
	public void setGzoneId(String gzoneId) {
		this.gzoneId = gzoneId;
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
	public String getAreaTypeCode() {
		return areaTypeCode;
	}
	public void setAreaTypeCode(String areaTypeCode) {
		this.areaTypeCode = areaTypeCode;
	}
	public String getAreaTypeName() {
		return areaTypeName;
	}
	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}
	public String getDtlLocation() {
		return dtlLocation;
	}
	public void setDtlLocation(String dtlLocation) {
		this.dtlLocation = dtlLocation;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	
}
