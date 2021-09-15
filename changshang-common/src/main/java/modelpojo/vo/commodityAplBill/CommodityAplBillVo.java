package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommodityAplBillVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3784283903216898744L;
	
	private Integer aplBillId;
	//营业点编号
	private String gzoneCode;
	//营业点名称
	private String gzoneName; 
	//状态
	private Integer aplStatus;
	//要货日期begin
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date aplDateBegin; 
	//要货日期end
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date aplDateEnd;
	//处理日期begin
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dealDateBegin; 
	//处理日期end
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dealDateEnd;
	private Integer pageNo; 
	private Integer pageSize;
	private Integer billSource;
	//要货单编号
	private String aplBillCode;
	private String whinBillCode;//采购单号
	private String altOutBillCode;//调出单号
	//处理要货仓库名称
	private String whName;

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getAplBillCode() {
		return aplBillCode;
	}

	public void setAplBillCode(String aplBillCode) {
		this.aplBillCode = aplBillCode;
	}

	public String getWhinBillCode() {
		return whinBillCode;
	}

	public void setWhinBillCode(String whinBillCode) {
		this.whinBillCode = whinBillCode;
	}

	public String getAltOutBillCode() {
		return altOutBillCode;
	}

	public void setAltOutBillCode(String altOutBillCode) {
		this.altOutBillCode = altOutBillCode;
	}

	public Integer getAplBillId() {
		return aplBillId;
	}
	public void setAplBillId(Integer aplBillId) {
		this.aplBillId = aplBillId;
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
	public Integer getAplStatus() {
		return aplStatus;
	}
	public void setAplStatus(Integer aplStatus) {
		this.aplStatus = aplStatus;
	}
	public Date getAplDateBegin() {
		return aplDateBegin;
	}
	public void setAplDateBegin(Date aplDateBegin) {
		this.aplDateBegin = aplDateBegin;
	}
	public Date getAplDateEnd() {
		return aplDateEnd;
	}
	public void setAplDateEnd(Date aplDateEnd) {
		this.aplDateEnd = aplDateEnd;
	}
	public Date getDealDateBegin() {
		return dealDateBegin;
	}
	public void setDealDateBegin(Date dealDateBegin) {
		this.dealDateBegin = dealDateBegin;
	}
	public Date getDealDateEnd() {
		return dealDateEnd;
	}
	public void setDealDateEnd(Date dealDateEnd) {
		this.dealDateEnd = dealDateEnd;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getBillSource() {
		return billSource;
	}
	public void setBillSource(Integer billSource) {
		this.billSource = billSource;
	}

}
