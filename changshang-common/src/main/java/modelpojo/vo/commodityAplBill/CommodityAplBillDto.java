package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommodityAplBillDto implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1153090899128476941L;

	//要货单id
	private Integer aplBillId;
	//要货单编号
	private String aplBillCode;
	//要货仓库
	private String aplWhId;
	//处理要货仓库（当前仓库）
	private String whId;
	//营业点编号
	private String gzoneCode;
	//营业点名称
	private String gzoneName;
	//要货人（申请人）
	private String comEmpId;
	//要货日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aplDate;
	//处理日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dealDate;
	//要货单申请状态 已处理 待处理 公共字典
	private String aplStatus;
	//审核状态 字典
	private Integer status;
	//备注
	private String remark;
	//要货仓库名称
	private String aplWhName;
	//处理要货仓库名称
	private String whName;

	private Integer billSource;

	private String comEmpName;

	private String whinBillCode;//采购单号
	private String altOutBillCode;//调出单号

	private Integer jurisdictionType = 0;//权限类型

	public Integer getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Integer jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
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
	public String getAplBillCode() {
		return aplBillCode;
	}
	public void setAplBillCode(String aplBillCode) {
		this.aplBillCode = aplBillCode;
	}
	public String getAplWhId() {
		return aplWhId;
	}
	public void setAplWhId(String aplWhId) {
		this.aplWhId = aplWhId;
	}
	public String getWhId() {
		return whId;
	}
	public void setWhId(String whId) {
		this.whId = whId;
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
	public String getComEmpId() {
		return comEmpId;
	}
	public void setComEmpId(String comEmpId) {
		this.comEmpId = comEmpId;
	}
	public Date getAplDate() {
		return aplDate;
	}
	public void setAplDate(Date aplDate) {
		this.aplDate = aplDate;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public String getAplStatus() {
		return aplStatus;
	}
	public void setAplStatus(String aplStatus) {
		this.aplStatus = aplStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getAplWhName() {
		return aplWhName;
	}
	public void setAplWhName(String aplWhName) {
		this.aplWhName = aplWhName;
	}
	public Integer getBillSource() {
		return billSource;
	}
	public void setBillSource(Integer billSource) {
		this.billSource = billSource;
	}
	public String getComEmpName() {
		return comEmpName;
	}
	public void setComEmpName(String comEmpName) {
		this.comEmpName = comEmpName;
	}
}
