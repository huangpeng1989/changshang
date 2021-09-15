package modelpojo.vo.saleablecom;


import modelpojo.vo.cateringBase.PageVo;

import java.io.Serializable;

public class SaleableComPageReceiptsVo extends PageVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**单据编号 */
	private String comBillCode;
	/**单据名称 */
	private String comBillName;		
	/**价格等级 */
	private Integer gradeId;
	/**状态 */
	private Integer  status ;
	/**单据录入开始时间 */
	private String startTime;
	/**单据录入结束时间 */
	private String endTime;

	private String comName;

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComBillCode() {
		return comBillCode;
	}
	public void setComBillCode(String comBillCode) {
		this.comBillCode = comBillCode;
	}
	public String getComBillName() {
		return comBillName;
	}
	public void setComBillName(String comBillName) {
		this.comBillName = comBillName;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
