package modelpojo.vo.saleablecom;

import java.io.Serializable;
import java.util.Date;

public class SaleableComPageReceiptsListVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**单据编号 */
	private String comBillCode;
	/**单据id */
	private Integer comBillId;
	/**销售商品id */
	private Integer saleComId;
	/**单据名称 */
	private String comBillName;
	/**价格等级 */
	private Integer gradeId;
	/**状态 */
	private Integer  status ;
	/**单据录入时间 */
	private Date createdTime;
	/**单据录入人*/
	private Long creater;
	/**单据录入人姓名*/
	private String createrName;

	public Integer getSaleComId() {
		return saleComId;
	}
	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public Integer getComBillId() {
		return comBillId;
	}
	public void setComBillId(Integer comBillId) {
		this.comBillId = comBillId;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
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
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
