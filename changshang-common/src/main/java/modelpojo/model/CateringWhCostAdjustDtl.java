package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhCostAdjustDtl implements Serializable {
    private Long projectRootId;

    private Integer rmId;

    private String rmCode;

    private Integer saleRmId;

    private String saleRmCode;

    private Integer saleUnit;

    private BigDecimal salePackContent;

    private BigDecimal havStock;

    private BigDecimal noHavStock;

    private BigDecimal taxPchsPrice;

    private BigDecimal notaxPchsPrice;

    private BigDecimal taxSumPrice;

    private BigDecimal notaxSumPrice;

    private BigDecimal nTaxPchsPrice;

    private BigDecimal nNotaxPchsPrice;

    private BigDecimal nTaxSumPrice;

    private BigDecimal nNotaxSumPrice;

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
	
	 private Integer caBillId;

    private Integer fEntryId;

    private Long projectId;

    private Integer orderCount;

    private BigDecimal giftCount;


    public BigDecimal getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(BigDecimal giftCount) {
        this.giftCount = giftCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getCaBillId() {
        return caBillId;
    }

    public void setCaBillId(Integer caBillId) {
        this.caBillId = caBillId;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
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

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public Integer getSaleRmId() {
        return saleRmId;
    }

    public void setSaleRmId(Integer saleRmId) {
        this.saleRmId = saleRmId;
    }

    public String getSaleRmCode() {
        return saleRmCode;
    }

    public void setSaleRmCode(String saleRmCode) {
        this.saleRmCode = saleRmCode;
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

    public BigDecimal getHavStock() {
        return havStock;
    }

    public void setHavStock(BigDecimal havStock) {
        this.havStock = havStock;
    }

    public BigDecimal getNoHavStock() {
        return noHavStock;
    }

    public void setNoHavStock(BigDecimal noHavStock) {
        this.noHavStock = noHavStock;
    }

    public BigDecimal getTaxPchsPrice() {
        return taxPchsPrice;
    }

    public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
        this.taxPchsPrice = taxPchsPrice;
    }

    public BigDecimal getNotaxPchsPrice() {
        return notaxPchsPrice;
    }

    public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
        this.notaxPchsPrice = notaxPchsPrice;
    }

    public BigDecimal getTaxSumPrice() {
        return taxSumPrice;
    }

    public void setTaxSumPrice(BigDecimal taxSumPrice) {
        this.taxSumPrice = taxSumPrice;
    }

    public BigDecimal getNotaxSumPrice() {
        return notaxSumPrice;
    }

    public void setNotaxSumPrice(BigDecimal notaxSumPrice) {
        this.notaxSumPrice = notaxSumPrice;
    }

    public BigDecimal getnTaxPchsPrice() {
        return nTaxPchsPrice;
    }

    public void setnTaxPchsPrice(BigDecimal nTaxPchsPrice) {
        this.nTaxPchsPrice = nTaxPchsPrice;
    }

    public BigDecimal getnNotaxPchsPrice() {
        return nNotaxPchsPrice;
    }

    public void setnNotaxPchsPrice(BigDecimal nNotaxPchsPrice) {
        this.nNotaxPchsPrice = nNotaxPchsPrice;
    }

    public BigDecimal getnTaxSumPrice() {
        return nTaxSumPrice;
    }

    public void setnTaxSumPrice(BigDecimal nTaxSumPrice) {
        this.nTaxSumPrice = nTaxSumPrice;
    }

    public BigDecimal getnNotaxSumPrice() {
        return nNotaxSumPrice;
    }

    public void setnNotaxSumPrice(BigDecimal nNotaxSumPrice) {
        this.nNotaxSumPrice = nNotaxSumPrice;
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