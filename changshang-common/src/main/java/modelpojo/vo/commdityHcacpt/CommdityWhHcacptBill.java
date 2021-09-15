package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommdityWhHcacptBill implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7277846270386145290L;
	private Long projectId;//项目id
	private Long projectRootId;//项目根节点id,
	private Integer hcBillId;//红冲订单id
	private String hcBillCode;//红冲订单编号
	private String acptBillCode;//验收单单号
	private Integer acptBillId;//验收单单号id
	private Integer whId;//入库仓库id
	private String hcEmpName;//红冲人
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date orderComDate;//红冲日期
	private Integer isGift;//有无赠品 0无 1有 默认0
	private Integer hcBillType;//订单类型 字典 正常订单 促销订单
	private String hcBillBarcode;//单据条码
	private Long creater;//创建人
	private Long modifier;//修改人
	private Long blEmpId;//审核人
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date createdTime;//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date updatedTime;//修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date blTime;//审核时间
	private Integer status;//状态 审核状态 待审核14901  审核驳回14902 审核通过14903 已删除14904
	private Integer isDelete;//是否删除 0否 1是
	private Integer syncStatus;//同步状态 10未同步 20同步中 30已同步
	private Integer stockStatus;//结转状态  未结转12101 结转中12102  已结转12103  默认12101
	private String hcBillBarImgurl;//单据条码图片地址
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getProjectRootId() {
		return projectRootId;
	}
	public void setProjectRootId(Long projectRootId) {
		this.projectRootId = projectRootId;
	}
	public Integer getHcBillId() {
		return hcBillId;
	}
	public void setHcBillId(Integer hcBillId) {
		this.hcBillId = hcBillId;
	}
	public String getHcBillCode() {
		return hcBillCode;
	}
	public void setHcBillCode(String hcBillCode) {
		this.hcBillCode = hcBillCode;
	}
	public String getAcptBillCode() {
		return acptBillCode;
	}
	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
	}
	public Integer getAcptBillId() {
		return acptBillId;
	}
	public void setAcptBillId(Integer acptBillId) {
		this.acptBillId = acptBillId;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getHcEmpName() {
		return hcEmpName;
	}
	public void setHcEmpName(String hcEmpName) {
		this.hcEmpName = hcEmpName;
	}
	public Date getOrderComDate() {
		return orderComDate;
	}
	public void setOrderComDate(Date orderComDate) {
		this.orderComDate = orderComDate;
	}
	public Integer getIsGift() {
		return isGift;
	}
	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}
	public Integer getHcBillType() {
		return hcBillType;
	}
	public void setHcBillType(Integer hcBillType) {
		this.hcBillType = hcBillType;
	}
	public String getHcBillBarcode() {
		return hcBillBarcode;
	}
	public void setHcBillBarcode(String hcBillBarcode) {
		this.hcBillBarcode = hcBillBarcode;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
	}
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public Long getBlEmpId() {
		return blEmpId;
	}
	public void setBlEmpId(Long blEmpId) {
		this.blEmpId = blEmpId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Date getBlTime() {
		return blTime;
	}
	public void setBlTime(Date blTime) {
		this.blTime = blTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	public Integer getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(Integer stockStatus) {
		this.stockStatus = stockStatus;
	}
	public String getHcBillBarImgurl() {
		return hcBillBarImgurl;
	}
	public void setHcBillBarImgurl(String hcBillBarImgurl) {
		this.hcBillBarImgurl = hcBillBarImgurl;
	}

}
