package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CateringWhInvtryBillDtl implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 原材料id
     */
    private Integer rmId;

    /**
     * 原材料编号
     */
    private String rmCode;

    /**
     * 原材料分类id
     */
    private Integer rmClassId;

    /**
     * 原材料单位
     */
    private Integer rmUnit;

    /**
     * 原材料包装id
     */
    private Integer srmId;

    /**
     * 原材料包装编码
     */
    private String srmCode;

    /**
     * 原材料包装单位
     */
    private Integer srmUnit;

    /**
     * 销售商品含量
     */
    private BigDecimal srmPackContent;

    /**
     * 账盘库存
     */
    private BigDecimal paperStock;

    /**
     * 账面含税金额
     */
    private BigDecimal pTaxCostAmount;

    /**
     * 账面未税金额
     */
    private BigDecimal pNotaxCostAmount;

    /**
     * 实盘库存
     */
    private BigDecimal realStock;

    /**
     * 盘点差异数量 账盘库存- 实盘库存     取绝对值
     */
    private BigDecimal ivtDftCount;

    /**
     * 是否盈亏  10盘盈  20盘亏 30不盈不亏
     */
    private Byte proLosType;

    /**
     * 实盘含税金额
     */
    private BigDecimal rTaxCostAmount;

    /**
     * 实盘未税金额
     */
    private BigDecimal rNotaxCostAmount;

    /**
     * 批次未税成本价
     */
    private BigDecimal bchNotaxCost;

    /**
     * 批次含税成本价
     */
    private BigDecimal bchTaxCost;

    /**
     * avg含税成本价
     */
    private BigDecimal avgTaxCost;

    /**
     * avg未税成本价
     */
    private BigDecimal avgNotaxCost;

    /**
     * 含税成本价
     */
    private BigDecimal taxCost;

    /**
     * 未税成本价
     */
    private BigDecimal notaxCost;

    /**
     * 含税成本金额
     */
    private BigDecimal taxCostAmount;

    /**
     * 未税成本金额
     */
    private BigDecimal notaxCostAmount;

    /**
     * 批次号
     */
    private Integer batchId;

    /**
     * 说明
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除 0否 1是
     */
    private Byte isDelete;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 同步状态 
     */
    private Integer syncStatus;
	
	   /**
     * 分录号
     */
    private Integer fEntryId;

    /**
     * 盘点单id
     */
    private Integer ivtId;

    /**
     * 
     */
    private Long projectId;
    /**
     * 
     */
    private Integer suppId;
    /**
     * 
     */
    private String suppCode;
    /**
     * 
     */
    private Integer taxId;
    /**
     * 
     */
    private String taxName;
    /**
     * 
     */
    private BigDecimal supTaxCost;
    /**
     * 
     */
    private BigDecimal supNotaxCost;
    /**
     * 
     */
    private Integer goodType;


    private  Integer isInsert;


    public Integer getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Integer isInsert) {
        this.isInsert = isInsert;
    }

    private List<CateringWhIvtSpecBill> utils= new ArrayList<>();

    public List<CateringWhIvtSpecBill> getUtils() {
        return utils;
    }

    public void setUtils(List<CateringWhIvtSpecBill> utils) {
        this.utils = utils;
    }

    public Integer getSuppId() {
		return suppId;
	}

	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public BigDecimal getSupTaxCost() {
		return supTaxCost;
	}

	public void setSupTaxCost(BigDecimal supTaxCost) {
		this.supTaxCost = supTaxCost;
	}

	public BigDecimal getSupNotaxCost() {
		return supNotaxCost;
	}

	public void setSupNotaxCost(BigDecimal supNotaxCost) {
		this.supNotaxCost = supNotaxCost;
	}

	public Integer getGoodType() {
		return goodType;
	}

	public void setGoodType(Integer goodType) {
		this.goodType = goodType;
	}

	/**
     * 分录号
     * @return f_entry_id 分录号
     */
    public Integer getfEntryId() {
        return fEntryId;
    }

    /**
     * 分录号
     * @param fEntryId 分录号
     */
    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    /**
     * 盘点单id
     * @return ivt_id 盘点单id
     */
    public Integer getIvtId() {
        return ivtId;
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
     * 原材料id
     * @return rm_id 原材料id
     */
    public Integer getRmId() {
        return rmId;
    }

    /**
     * 原材料id
     * @param rmId 原材料id
     */
    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    /**
     * 原材料编号
     * @return rm_code 原材料编号
     */
    public String getRmCode() {
        return rmCode;
    }

    /**
     * 原材料编号
     * @param rmCode 原材料编号
     */
    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    /**
     * 原材料分类id
     * @return rm_class_id 原材料分类id
     */
    public Integer getRmClassId() {
        return rmClassId;
    }

    /**
     * 原材料分类id
     * @param rmClassId 原材料分类id
     */
    public void setRmClassId(Integer rmClassId) {
        this.rmClassId = rmClassId;
    }

    /**
     * 原材料单位
     * @return rm_unit 原材料单位
     */
    public Integer getRmUnit() {
        return rmUnit;
    }

    /**
     * 原材料单位
     * @param rmUnit 原材料单位
     */
    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    /**
     * 原材料包装id
     * @return srm_id 原材料包装id
     */
    public Integer getSrmId() {
        return srmId;
    }

    /**
     * 原材料包装id
     * @param srmId 原材料包装id
     */
    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    /**
     * 原材料包装编码
     * @return srm_code 原材料包装编码
     */
    public String getSrmCode() {
        return srmCode;
    }

    /**
     * 原材料包装编码
     * @param srmCode 原材料包装编码
     */
    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode == null ? null : srmCode.trim();
    }

    /**
     * 原材料包装单位
     * @return srm_unit 原材料包装单位
     */
    public Integer getSrmUnit() {
        return srmUnit;
    }

    /**
     * 原材料包装单位
     * @param srmUnit 原材料包装单位
     */
    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    /**
     * 销售商品含量
     * @return srm_pack_content 销售商品含量
     */
    public BigDecimal getSrmPackContent() {
        return srmPackContent;
    }

    /**
     * 销售商品含量
     * @param srmPackContent 销售商品含量
     */
    public void setSrmPackContent(BigDecimal srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    /**
     * 账盘库存
     * @return paper_stock 账盘库存
     */
    public BigDecimal getPaperStock() {
        return paperStock;
    }

    /**
     * 账盘库存
     * @param paperStock 账盘库存
     */
    public void setPaperStock(BigDecimal paperStock) {
        this.paperStock = paperStock;
    }

    /**
     * 账面含税金额
     * @return p_tax_cost_amount 账面含税金额
     */
    public BigDecimal getpTaxCostAmount() {
        return pTaxCostAmount;
    }

    /**
     * 账面含税金额
     * @param pTaxCostAmount 账面含税金额
     */
    public void setpTaxCostAmount(BigDecimal pTaxCostAmount) {
        this.pTaxCostAmount = pTaxCostAmount;
    }

    /**
     * 账面未税金额
     * @return p_notax_cost_amount 账面未税金额
     */
    public BigDecimal getpNotaxCostAmount() {
        return pNotaxCostAmount;
    }

    /**
     * 账面未税金额
     * @param pNotaxCostAmount 账面未税金额
     */
    public void setpNotaxCostAmount(BigDecimal pNotaxCostAmount) {
        this.pNotaxCostAmount = pNotaxCostAmount;
    }

    /**
     * 实盘库存
     * @return real_stock 实盘库存
     */
    public BigDecimal getRealStock() {
        return realStock;
    }

    /**
     * 实盘库存
     * @param realStock 实盘库存
     */
    public void setRealStock(BigDecimal realStock) {
        this.realStock = realStock;
    }

    /**
     * 盘点差异数量 账盘库存- 实盘库存     取绝对值
     * @return ivt_dft_count 盘点差异数量 账盘库存- 实盘库存     取绝对值
     */
    public BigDecimal getIvtDftCount() {
        return ivtDftCount;
    }

    /**
     * 盘点差异数量 账盘库存- 实盘库存     取绝对值
     * @param ivtDftCount 盘点差异数量 账盘库存- 实盘库存     取绝对值
     */
    public void setIvtDftCount(BigDecimal ivtDftCount) {
        this.ivtDftCount = ivtDftCount;
    }

    /**
     * 是否盈亏  10盘盈  20盘亏 30不盈不亏
     * @return pro_los_type 是否盈亏  10盘盈  20盘亏 30不盈不亏
     */
    public Byte getProLosType() {
        return proLosType;
    }

    /**
     * 是否盈亏  10盘盈  20盘亏 30不盈不亏
     * @param proLosType 是否盈亏  10盘盈  20盘亏 30不盈不亏
     */
    public void setProLosType(Byte proLosType) {
        this.proLosType = proLosType;
    }

    /**
     * 实盘含税金额
     * @return r_tax_cost_amount 实盘含税金额
     */
    public BigDecimal getrTaxCostAmount() {
        return rTaxCostAmount;
    }

    /**
     * 实盘含税金额
     * @param rTaxCostAmount 实盘含税金额
     */
    public void setrTaxCostAmount(BigDecimal rTaxCostAmount) {
        this.rTaxCostAmount = rTaxCostAmount;
    }

    /**
     * 实盘未税金额
     * @return r_notax_cost_amount 实盘未税金额
     */
    public BigDecimal getrNotaxCostAmount() {
        return rNotaxCostAmount;
    }

    /**
     * 实盘未税金额
     * @param rNotaxCostAmount 实盘未税金额
     */
    public void setrNotaxCostAmount(BigDecimal rNotaxCostAmount) {
        this.rNotaxCostAmount = rNotaxCostAmount;
    }

    /**
     * 批次未税成本价
     * @return bch_notax_cost 批次未税成本价
     */
    public BigDecimal getBchNotaxCost() {
        return bchNotaxCost;
    }

    /**
     * 批次未税成本价
     * @param bchNotaxCost 批次未税成本价
     */
    public void setBchNotaxCost(BigDecimal bchNotaxCost) {
        this.bchNotaxCost = bchNotaxCost;
    }

    /**
     * 批次含税成本价
     * @return bch_tax_cost 批次含税成本价
     */
    public BigDecimal getBchTaxCost() {
        return bchTaxCost;
    }

    /**
     * 批次含税成本价
     * @param bchTaxCost 批次含税成本价
     */
    public void setBchTaxCost(BigDecimal bchTaxCost) {
        this.bchTaxCost = bchTaxCost;
    }

    /**
     * avg含税成本价
     * @return avg_tax_cost avg含税成本价
     */
    public BigDecimal getAvgTaxCost() {
        return avgTaxCost;
    }

    /**
     * avg含税成本价
     * @param avgTaxCost avg含税成本价
     */
    public void setAvgTaxCost(BigDecimal avgTaxCost) {
        this.avgTaxCost = avgTaxCost;
    }

    /**
     * avg未税成本价
     * @return avg_notax_cost avg未税成本价
     */
    public BigDecimal getAvgNotaxCost() {
        return avgNotaxCost;
    }

    /**
     * avg未税成本价
     * @param avgNotaxCost avg未税成本价
     */
    public void setAvgNotaxCost(BigDecimal avgNotaxCost) {
        this.avgNotaxCost = avgNotaxCost;
    }

    /**
     * 含税成本价
     * @return tax_cost 含税成本价
     */
    public BigDecimal getTaxCost() {
        return taxCost;
    }

    /**
     * 含税成本价
     * @param taxCost 含税成本价
     */
    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    /**
     * 未税成本价
     * @return notax_cost 未税成本价
     */
    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    /**
     * 未税成本价
     * @param notaxCost 未税成本价
     */
    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    /**
     * 含税成本金额
     * @return tax_cost_amount 含税成本金额
     */
    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    /**
     * 含税成本金额
     * @param taxCostAmount 含税成本金额
     */
    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    /**
     * 未税成本金额
     * @return notax_cost_amount 未税成本金额
     */
    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    /**
     * 未税成本金额
     * @param notaxCostAmount 未税成本金额
     */
    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    /**
     * 批次号
     * @return batch_id 批次号
     */
    public Integer getBatchId() {
        return batchId;
    }

    /**
     * 批次号
     * @param batchId 批次号
     */
    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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
}