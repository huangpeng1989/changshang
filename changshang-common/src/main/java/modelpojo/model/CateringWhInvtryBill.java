package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

public class CateringWhInvtryBill implements Serializable{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    private Long projectRootId;

    /**
     * 盘点仓库id
     */
    private Integer whId;

    /**
     * 盘点单单号  调用存储过程生成 单号
     */
    private String ivtCode;

    /**
     * 盘点启动单状态 已启动 已取消
     */
    private Integer startStatus;

    /**
     * 盘点启动单创建人
     */
    private Long startCreater;

    /**
     * 盘点启动单修改人
     */
    private Long startModifier;

    /**
     * 盘点启动单创建时间
     */
    private Date startCreatedTime;

    /**
     * 盘点启动单修改时间
     */
    private Date startUpdatedTime;

    /**
     * 盘点启动单是否删除
     */
    private Byte startIsDelete;

    /**
     * 盘点录入单编号
     */
    private String entryBillCode;

    /**
     * 盘点启动单备注
     */
    private String startRemark;

    /**
     * 盘点启动日期
     */
    private Date ivtStartDate;

    /**
     * 盘点方式 字典
     */
    private Integer ivtMode;

    /**
     * 录入单创建人
     */
    private Long entryCreater;

    /**
     * 录入单修改人
     */
    private Long entryModifier;

    /**
     * 录入单审核人
     */
    private Long entryBlEmpId;

    /**
     * 录入单创建时间
     */
    private Date entryCreatedTime;

    /**
     * 录入单修改时间
     */
    private Date entryUpdatedTime;

    /**
     * 录入单审核时间
     */
    private Date entryBlTime;

    /**
     * 录入单备注
     */
    private String entryRemark;

    /**
     * 盘点录入单是否删除
     */
    private Byte entryIsDelete;

    /**
     * 状态 审核状态 字典
     */
    private Integer entryStatus;

    /**
     * 说明
     */
    private String state;

    /**
     * 盘点单id
     */
    private Integer ivtId;

    /**
     *
     */
    private Long projectId;
    /**
     *盘点录入方式 公共字典表
     */
    private Integer ivtInType;
    
    private String billAddBarcode;
    private String billLossBarcode;
    private String billBarcodeUrl;
    private String billAddBarcodeUrl;
    private String billLossBarcodeUrl;
    private String billBarcode;

    private Integer paymentDaysId;

    private String paymentName;

    private Date accountPeriod;

    public Date getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(Date accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public Integer getPaymentDaysId() {
        return paymentDaysId;
    }

    public void setPaymentDaysId(Integer paymentDaysId) {
        this.paymentDaysId = paymentDaysId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getBillBarcode() {
		return billBarcode;
	}

	public void setBillBarcode(String billBarcode) {
		this.billBarcode = billBarcode;
	}

	public String getBillAddBarcode() {
		return billAddBarcode;
	}

	public void setBillAddBarcode(String billAddBarcode) {
		this.billAddBarcode = billAddBarcode;
	}

	public String getBillLossBarcode() {
		return billLossBarcode;
	}

	public void setBillLossBarcode(String billLossBarcode) {
		this.billLossBarcode = billLossBarcode;
	}

	public String getBillBarcodeUrl() {
		return billBarcodeUrl;
	}

	public void setBillBarcodeUrl(String billBarcodeUrl) {
		this.billBarcodeUrl = billBarcodeUrl;
	}

	public String getBillAddBarcodeUrl() {
		return billAddBarcodeUrl;
	}

	public void setBillAddBarcodeUrl(String billAddBarcodeUrl) {
		this.billAddBarcodeUrl = billAddBarcodeUrl;
	}

	public String getBillLossBarcodeUrl() {
		return billLossBarcodeUrl;
	}

	public void setBillLossBarcodeUrl(String billLossBarcodeUrl) {
		this.billLossBarcodeUrl = billLossBarcodeUrl;
	}

	/**
     * 盘点单id
     * @return ivt_id 盘点单id
     */
    public Integer getIvtId() {
        return ivtId;
    }

    public Integer getIvtInType() {
		return ivtInType;
	}

	public void setIvtInType(Integer ivtInType) {
		this.ivtInType = ivtInType;
	}

	/**
     * 盘点单id
     * @param ivtId 盘点单id
     */
    public void setIvtId(Integer ivtId) {
        this.ivtId = ivtId;
    }

    /**
     *
     * @return project_id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return project_root_id
     */
    public Long getProjectRootId() {
        return projectRootId;
    }

    /**
     *
     * @param projectRootId
     */
    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    /**
     * 盘点仓库id
     * @return wh_id 盘点仓库id
     */
    public Integer getWhId() {
        return whId;
    }

    /**
     * 盘点仓库id
     * @param whId 盘点仓库id
     */
    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    /**
     * 盘点单单号  调用存储过程生成 单号
     * @return ivt_code 盘点单单号  调用存储过程生成 单号
     */
    public String getIvtCode() {
        return ivtCode;
    }

    /**
     * 盘点单单号  调用存储过程生成 单号
     * @param ivtCode 盘点单单号  调用存储过程生成 单号
     */
    public void setIvtCode(String ivtCode) {
        this.ivtCode = ivtCode == null ? null : ivtCode.trim();
    }

    /**
     * 盘点启动单状态 已启动 已取消
     * @return start_status 盘点启动单状态 已启动 已取消
     */
    public Integer getStartStatus() {
        return startStatus;
    }

    /**
     * 盘点启动单状态 已启动 已取消
     * @param startStatus 盘点启动单状态 已启动 已取消
     */
    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    /**
     * 盘点启动单创建人
     * @return start_creater 盘点启动单创建人
     */
    public Long getStartCreater() {
        return startCreater;
    }

    /**
     * 盘点启动单创建人
     * @param startCreater 盘点启动单创建人
     */
    public void setStartCreater(Long startCreater) {
        this.startCreater = startCreater;
    }

    /**
     * 盘点启动单修改人
     * @return start_modifier 盘点启动单修改人
     */
    public Long getStartModifier() {
        return startModifier;
    }

    /**
     * 盘点启动单修改人
     * @param startModifier 盘点启动单修改人
     */
    public void setStartModifier(Long startModifier) {
        this.startModifier = startModifier;
    }

    /**
     * 盘点启动单创建时间
     * @return start_created_time 盘点启动单创建时间
     */
    public Date getStartCreatedTime() {
        return startCreatedTime;
    }

    /**
     * 盘点启动单创建时间
     * @param startCreatedTime 盘点启动单创建时间
     */
    public void setStartCreatedTime(Date startCreatedTime) {
        this.startCreatedTime = startCreatedTime;
    }

    /**
     * 盘点启动单修改时间
     * @return start_updated_time 盘点启动单修改时间
     */
    public Date getStartUpdatedTime() {
        return startUpdatedTime;
    }

    /**
     * 盘点启动单修改时间
     * @param startUpdatedTime 盘点启动单修改时间
     */
    public void setStartUpdatedTime(Date startUpdatedTime) {
        this.startUpdatedTime = startUpdatedTime;
    }

    /**
     * 盘点启动单是否删除
     * @return start_is_delete 盘点启动单是否删除
     */
    public Byte getStartIsDelete() {
        return startIsDelete;
    }

    /**
     * 盘点启动单是否删除
     * @param startIsDelete 盘点启动单是否删除
     */
    public void setStartIsDelete(Byte startIsDelete) {
        this.startIsDelete = startIsDelete;
    }

    /**
     * 盘点录入单编号
     * @return entry_bill_code 盘点录入单编号
     */
    public String getEntryBillCode() {
        return entryBillCode;
    }

    /**
     * 盘点录入单编号
     * @param entryBillCode 盘点录入单编号
     */
    public void setEntryBillCode(String entryBillCode) {
        this.entryBillCode = entryBillCode == null ? null : entryBillCode.trim();
    }

    /**
     * 盘点启动单备注
     * @return start_remark 盘点启动单备注
     */
    public String getStartRemark() {
        return startRemark;
    }

    /**
     * 盘点启动单备注
     * @param startRemark 盘点启动单备注
     */
    public void setStartRemark(String startRemark) {
        this.startRemark = startRemark == null ? null : startRemark.trim();
    }

    /**
     * 盘点启动日期
     * @return ivt_start_date 盘点启动日期
     */
    public Date getIvtStartDate() {
        return ivtStartDate;
    }

    /**
     * 盘点启动日期
     * @param ivtStartDate 盘点启动日期
     */
    public void setIvtStartDate(Date ivtStartDate) {
        this.ivtStartDate = ivtStartDate;
    }

    /**
     * 盘点方式 字典
     * @return ivt_mode 盘点方式 字典
     */
    public Integer getIvtMode() {
        return ivtMode;
    }

    /**
     * 盘点方式 字典
     * @param ivtMode 盘点方式 字典
     */
    public void setIvtMode(Integer ivtMode) {
        this.ivtMode = ivtMode;
    }

    /**
     * 录入单创建人
     * @return entry_creater 录入单创建人
     */
    public Long getEntryCreater() {
        return entryCreater;
    }

    /**
     * 录入单创建人
     * @param entryCreater 录入单创建人
     */
    public void setEntryCreater(Long entryCreater) {
        this.entryCreater = entryCreater;
    }

    /**
     * 录入单修改人
     * @return entry_modifier 录入单修改人
     */
    public Long getEntryModifier() {
        return entryModifier;
    }

    /**
     * 录入单修改人
     * @param entryModifier 录入单修改人
     */
    public void setEntryModifier(Long entryModifier) {
        this.entryModifier = entryModifier;
    }

    /**
     * 录入单审核人
     * @return entry_bl_emp_id 录入单审核人
     */
    public Long getEntryBlEmpId() {
        return entryBlEmpId;
    }

    /**
     * 录入单审核人
     * @param entryBlEmpId 录入单审核人
     */
    public void setEntryBlEmpId(Long entryBlEmpId) {
        this.entryBlEmpId = entryBlEmpId;
    }

    /**
     * 录入单创建时间
     * @return entry_created_time 录入单创建时间
     */
    public Date getEntryCreatedTime() {
        return entryCreatedTime;
    }

    /**
     * 录入单创建时间
     * @param entryCreatedTime 录入单创建时间
     */
    public void setEntryCreatedTime(Date entryCreatedTime) {
        this.entryCreatedTime = entryCreatedTime;
    }

    /**
     * 录入单修改时间
     * @return entry_updated_time 录入单修改时间
     */
    public Date getEntryUpdatedTime() {
        return entryUpdatedTime;
    }

    /**
     * 录入单修改时间
     * @param entryUpdatedTime 录入单修改时间
     */
    public void setEntryUpdatedTime(Date entryUpdatedTime) {
        this.entryUpdatedTime = entryUpdatedTime;
    }

    /**
     * 录入单审核时间
     * @return entry_bl_time 录入单审核时间
     */
    public Date getEntryBlTime() {
        return entryBlTime;
    }

    /**
     * 录入单审核时间
     * @param entryBlTime 录入单审核时间
     */
    public void setEntryBlTime(Date entryBlTime) {
        this.entryBlTime = entryBlTime;
    }

    /**
     * 录入单备注
     * @return entry_remark 录入单备注
     */
    public String getEntryRemark() {
        return entryRemark;
    }

    /**
     * 录入单备注
     * @param entryRemark 录入单备注
     */
    public void setEntryRemark(String entryRemark) {
        this.entryRemark = entryRemark == null ? null : entryRemark.trim();
    }

    /**
     * 盘点录入单是否删除
     * @return entry_is_delete 盘点录入单是否删除
     */
    public Byte getEntryIsDelete() {
        return entryIsDelete;
    }

    /**
     * 盘点录入单是否删除
     * @param entryIsDelete 盘点录入单是否删除
     */
    public void setEntryIsDelete(Byte entryIsDelete) {
        this.entryIsDelete = entryIsDelete;
    }

    /**
     * 状态 审核状态 字典
     * @return entry_status 状态 审核状态 字典
     */
    public Integer getEntryStatus() {
        return entryStatus;
    }

    /**
     * 状态 审核状态 字典
     * @param entryStatus 状态 审核状态 字典
     */
    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
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
}
