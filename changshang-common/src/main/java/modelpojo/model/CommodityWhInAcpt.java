package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommodityWhInAcpt implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 验收单id
     */
    private Integer acptBillId;

    /**
     * 验收单号编号 例:ACPT20190212182332
     */
    private String acptBillCode;

    /**
     * 采购单号
     */
    private String whinBillId;
    

    /**
     * 采购编号
     */
    private String whinBillCode;

    /**
     * 入库仓库id
     */
    private Integer inWhId;

    /**
     * 供应商id
     */
    private Integer suppId;

    /**
     * 供应商编码
     */
    private String suppCode;

    /**
     * 订货日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderComDate;

    /**
     * 预计入库日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pdtWhinDate;

    /**
     * 实际入库日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date realWhinDate;

    /**
     * 验收入库人  人员id
     */
    private Long accepter;

    /**
     * 说明
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 审核人
     */
    private Long blEmpId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 审核时间
     */
    private Date blTime;

    /**
     * 状态 审核状态
     */
    private Integer status;

    /**
     * 是否删除 0否 1是
     */
    private Byte isDelete;

    /**
     * 同步状态
     */
    private Integer syncStatus;
    
    /**
     * 单据条码
     */
    private String billBarcode;
    
    /**
     * 单据条码
     */
    private String billBarImgurl;

    /**
     * 结转状态  未结转12101 结转中12102  已结转12103  默认12101
     */
    private Integer stockStatus;
    
	public String getBillBarImgurl() {
		return billBarImgurl;
	}

	public void setBillBarImgurl(String billBarImgurl) {
		this.billBarImgurl = billBarImgurl;
	}

	public String getBillBarcode() {
		return billBarcode;
	}

	public void setBillBarcode(String billBarcode) {
		this.billBarcode = billBarcode;
	}

	/**
     * 项目id
     * @return project_id 项目id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 项目id
     * @param projectId 项目id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 项目根节点id
     * @return project_root_id 项目根节点id
     */
    public Long getProjectRootId() {
        return projectRootId;
    }

    /**
     * 项目根节点id
     * @param projectRootId 项目根节点id
     */
    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    /**
     * 验收单id
     * @return acpt_bill_id 验收单id
     */
    public Integer getAcptBillId() {
        return acptBillId;
    }

    /**
     * 验收单id
     * @param acptBillId 验收单id
     */
    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
    }

    /**
     * 验收单号编号 例:ACPT20190212182332
     * @return acpt_bill_code 验收单号编号 例:ACPT20190212182332
     */
    public String getAcptBillCode() {
        return acptBillCode;
    }

    /**
     * 验收单号编号 例:ACPT20190212182332
     * @param acptBillCode 验收单号编号 例:ACPT20190212182332
     */
    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode == null ? null : acptBillCode.trim();
    }

    /**
     * 采购单号
     * @return whin_bill_id 采购单号
     */
    public String getWhinBillId() {
        return whinBillId;
    }

    /**
     * 采购单号
     * @param whinBillId 采购单号
     */
    public void setWhinBillId(String whinBillId) {
        this.whinBillId = whinBillId == null ? null : whinBillId.trim();
    }

    /**
     * 采购单号
     * @return whin_bill_code 采购单号
     */
    public String getWhinBillCode() {
        return whinBillCode;
    }

    /**
     * 采购单号
     * @param whinBillCode 采购单号
     */
    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode == null ? null : whinBillCode.trim();
    }

    /**
     * 入库仓库id
     * @return in_wh_id 入库仓库id
     */
    public Integer getInWhId() {
        return inWhId;
    }

    /**
     * 入库仓库id
     * @param inWhId 入库仓库id
     */
    public void setInWhId(Integer inWhId) {
        this.inWhId = inWhId;
    }

    /**
     * 供应商id
     * @return supp_id 供应商id
     */
    public Integer getSuppId() {
        return suppId;
    }

    /**
     * 供应商id
     * @param suppId 供应商id
     */
    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    /**
     * 供应商编码
     * @return supp_code 供应商编码
     */
    public String getSuppCode() {
        return suppCode;
    }

    /**
     * 供应商编码
     * @param suppCode 供应商编码
     */
    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode == null ? null : suppCode.trim();
    }

    /**
     * 订货日期
     * @return order_com_date 订货日期
     */
    public Date getOrderComDate() {
        return orderComDate;
    }

    /**
     * 订货日期
     * @param orderComDate 订货日期
     */
    public void setOrderComDate(Date orderComDate) {
        this.orderComDate = orderComDate;
    }

    /**
     * 预计入库日期
     * @return pdt_whin_date 预计入库日期
     */
    public Date getPdtWhinDate() {
        return pdtWhinDate;
    }

    /**
     * 预计入库日期
     * @param pdtWhinDate 预计入库日期
     */
    public void setPdtWhinDate(Date pdtWhinDate) {
        this.pdtWhinDate = pdtWhinDate;
    }

    /**
     * 实际入库日期
     * @return real_whin_date 实际入库日期
     */
    public Date getRealWhinDate() {
        return realWhinDate;
    }

    /**
     * 实际入库日期
     * @param realWhinDate 实际入库日期
     */
    public void setRealWhinDate(Date realWhinDate) {
        this.realWhinDate = realWhinDate;
    }

    /**
     * 验收入库人  人员id
     * @return accepter 验收入库人  人员id
     */
    public Long getAccepter() {
        return accepter;
    }

    /**
     * 验收入库人  人员id
     * @param accepter 验收入库人  人员id
     */
    public void setAccepter(Long accepter) {
        this.accepter = accepter;
    }

    /**
     * 说明
     * @return state 说明
     */
    public String getState() {
        return state;
    }

    /**
     * 说明
     * @param state 说明
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人
     * @return creater 创建人
     */
    public Long getCreater() {
        return creater;
    }

    /**
     * 创建人
     * @param creater 创建人
     */
    public void setCreater(Long creater) {
        this.creater = creater;
    }

    /**
     * 修改人
     * @return modifier 修改人
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * 修改人
     * @param modifier 修改人
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * 审核人
     * @return bl_emp_id 审核人
     */
    public Long getBlEmpId() {
        return blEmpId;
    }

    /**
     * 审核人
     * @param blEmpId 审核人
     */
    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    /**
     * 创建时间
     * @return created_time 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 修改时间
     * @return updated_time 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 修改时间
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 审核时间
     * @return bl_time 审核时间
     */
    public Date getBlTime() {
        return blTime;
    }

    /**
     * 审核时间
     * @param blTime 审核时间
     */
    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    /**
     * 状态 审核状态
     * @return status 状态 审核状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 审核状态
     * @param status 状态 审核状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否删除 0否 1是
     * @return is_delete 是否删除 0否 1是
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 0否 1是
     * @param isDelete 是否删除 0否 1是
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 同步状态
     * @return sync_status 同步状态
     */
    public Integer getSyncStatus() {
        return syncStatus;
    }

    /**
     * 同步状态
     * @param syncStatus 同步状态
     */
    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    /**
     * 结转状态  未结转12101 结转中12102  已结转12103  默认12101
     * @return stock_status 结转状态  未结转12101 结转中12102  已结转12103  默认12101
     */
    public Integer getStockStatus() {
        return stockStatus;
    }

    /**
     * 结转状态  未结转12101 结转中12102  已结转12103  默认12101
     * @param stockStatus 结转状态  未结转12101 结转中12102  已结转12103  默认12101
     */
    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }
}