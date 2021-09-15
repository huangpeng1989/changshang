package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityWhInReturnDtl implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectId;

    private Long projectRootId;

    private Integer rtnBillId;

    private Integer fEntryId;

    private Integer comId;

    private String comCode;

    private String comSpec;

    private Integer comUnit;

    private Integer saleComId;

    private String saleComCode;

    private Integer saleUnit;

    private BigDecimal salePackContent;

    private BigDecimal orderCount;

    private BigDecimal fifoTaxCost;

    private BigDecimal fifoNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private Integer taxId;

    private String taxName;

    private String state;

    private String remark;

    private Byte isDelete;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private Long pSaleComId;//退货销售商品id

    private String pSaleComCode; // 退货销售商品编码

    private Long pSaleUnit;//退货销售商品单位 字典表

    private BigDecimal pSalePackContent;//退货销售商品含量

    private BigDecimal pOrderPageCount;//退货包装数量

    private BigDecimal pGiftPageCount;//退货赠品包装数量

    private BigDecimal pFifoTaxCost;//退货包装含税价

    private BigDecimal pFifoNotaxCost;//退货包装未税价

    private BigDecimal orderPageCount;//转换后的退货包装数量

    private BigDecimal giftPageCount;//转换后的退货赠品包装数量

    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Long getpSaleComId() {
        return pSaleComId;
    }

    public void setpSaleComId(Long pSaleComId) {
        this.pSaleComId = pSaleComId;
    }

    public String getpSaleComCode() {
        return pSaleComCode;
    }

    public void setpSaleComCode(String pSaleComCode) {
        this.pSaleComCode = pSaleComCode;
    }

    public Long getpSaleUnit() {
        return pSaleUnit;
    }

    public void setpSaleUnit(Long pSaleUnit) {
        this.pSaleUnit = pSaleUnit;
    }

    public BigDecimal getpSalePackContent() {
        return pSalePackContent;
    }

    public void setpSalePackContent(BigDecimal pSalePackContent) {
        this.pSalePackContent = pSalePackContent;
    }

    public BigDecimal getpOrderPageCount() {
        return pOrderPageCount;
    }

    public void setpOrderPageCount(BigDecimal pOrderPageCount) {
        this.pOrderPageCount = pOrderPageCount;
    }

    public BigDecimal getpGiftPageCount() {
        return pGiftPageCount;
    }

    public void setpGiftPageCount(BigDecimal pGiftPageCount) {
        this.pGiftPageCount = pGiftPageCount;
    }

    public BigDecimal getpFifoTaxCost() {
        return pFifoTaxCost;
    }

    public void setpFifoTaxCost(BigDecimal pFifoTaxCost) {
        this.pFifoTaxCost = pFifoTaxCost;
    }

    public BigDecimal getpFifoNotaxCost() {
        return pFifoNotaxCost;
    }

    public void setpFifoNotaxCost(BigDecimal pFifoNotaxCost) {
        this.pFifoNotaxCost = pFifoNotaxCost;
    }

    public BigDecimal getOrderPageCount() {
        return orderPageCount;
    }

    public void setOrderPageCount(BigDecimal orderPageCount) {
        this.orderPageCount = orderPageCount;
    }

    public BigDecimal getGiftPageCount() {
        return giftPageCount;
    }

    public void setGiftPageCount(BigDecimal giftPageCount) {
        this.giftPageCount = giftPageCount;
    }

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

    public Integer getRtnBillId() {
        return rtnBillId;
    }

    public void setRtnBillId(Integer rtnBillId) {
        this.rtnBillId = rtnBillId;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec == null ? null : comSpec.trim();
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public Integer getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(Integer saleUnit) {
        this.saleUnit = saleUnit;
    }

    public BigDecimal getSalePackContent() {
        return salePackContent;
    }

    public void setSalePackContent(BigDecimal salePackContent) {
        this.salePackContent = salePackContent;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getFifoTaxCost() {
        return fifoTaxCost;
    }

    public void setFifoTaxCost(BigDecimal fifoTaxCost) {
        this.fifoTaxCost = fifoTaxCost;
    }

    public BigDecimal getFifoNotaxCost() {
        return fifoNotaxCost;
    }

    public void setFifoNotaxCost(BigDecimal fifoNotaxCost) {
        this.fifoNotaxCost = fifoNotaxCost;
    }

    public BigDecimal getAvgTaxCost() {
        return avgTaxCost;
    }

    public void setAvgTaxCost(BigDecimal avgTaxCost) {
        this.avgTaxCost = avgTaxCost;
    }

    public BigDecimal getAvgNotaxCost() {
        return avgNotaxCost;
    }

    public void setAvgNotaxCost(BigDecimal avgNotaxCost) {
        this.avgNotaxCost = avgNotaxCost;
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
        this.taxName = taxName == null ? null : taxName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}