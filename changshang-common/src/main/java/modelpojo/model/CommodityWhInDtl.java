package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityWhInDtl implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long projectId;

    private Long projectRootId;

    private Integer whinBillId;

    private Integer fEntryId;

    private Integer comId;

    private String comCode;

    private String comSpec;

    private Integer comUnit;

    private BigDecimal taxPchsPrice;

    private BigDecimal notaxPchsPrice;

    private BigDecimal taxSumPrice;

    private BigDecimal notaxSumPrice;

    private Integer taxId;

    private String taxName;

    private BigDecimal taxPagePrice;

    private BigDecimal notaxPagePrice;

    private Byte isGift;

    private Integer pSaleComId;

    private String pSaleComCode;

    private Integer pSaleUnit;

    private Integer pSalePackContent;

    private BigDecimal orderPageCount;

    private BigDecimal giftPageCount;

    private BigDecimal oGPageCount;

    private Integer gSaleComId;

    private String gSaleComCode;

    private Integer gSaleUnit;

    private Integer gSalePackContent;

    private BigDecimal orderCount;

    private BigDecimal giftCount;

    private BigDecimal oGCount;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer status;

    private Byte isDelete;

    private String remark;

    private String state;

    private Integer syncStatus;

    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
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

    public BigDecimal getTaxPagePrice() {
        return taxPagePrice;
    }

    public void setTaxPagePrice(BigDecimal taxPagePrice) {
        this.taxPagePrice = taxPagePrice;
    }

    public BigDecimal getNotaxPagePrice() {
        return notaxPagePrice;
    }

    public void setNotaxPagePrice(BigDecimal  notaxPagePrice) {
        this.notaxPagePrice = notaxPagePrice;
    }

    public Byte getIsGift() {
        return isGift;
    }

    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    public Integer getpSaleComId() {
        return pSaleComId;
    }

    public void setpSaleComId(Integer pSaleComId) {
        this.pSaleComId = pSaleComId;
    }

    public String getpSaleComCode() {
        return pSaleComCode;
    }

    public void setpSaleComCode(String pSaleComCode) {
        this.pSaleComCode = pSaleComCode == null ? null : pSaleComCode.trim();
    }

    public Integer getpSaleUnit() {
        return pSaleUnit;
    }

    public void setpSaleUnit(Integer pSaleUnit) {
        this.pSaleUnit = pSaleUnit;
    }

    public Integer getpSalePackContent() {
        return pSalePackContent;
    }

    public void setpSalePackContent(Integer pSalePackContent) {
        this.pSalePackContent = pSalePackContent;
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

    public BigDecimal getoGPageCount() {
        return oGPageCount;
    }

    public void setoGPageCount(BigDecimal oGPageCount) {
        this.oGPageCount = oGPageCount;
    }

    public Integer getgSaleComId() {
        return gSaleComId;
    }

    public void setgSaleComId(Integer gSaleComId) {
        this.gSaleComId = gSaleComId;
    }

    public String getgSaleComCode() {
        return gSaleComCode;
    }

    public void setgSaleComCode(String gSaleComCode) {
        this.gSaleComCode = gSaleComCode == null ? null : gSaleComCode.trim();
    }

    public Integer getgSaleUnit() {
        return gSaleUnit;
    }

    public void setgSaleUnit(Integer gSaleUnit) {
        this.gSaleUnit = gSaleUnit;
    }

    public Integer getgSalePackContent() {
        return gSalePackContent;
    }

    public void setgSalePackContent(Integer gSalePackContent) {
        this.gSalePackContent = gSalePackContent;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(BigDecimal giftCount) {
        this.giftCount = giftCount;
    }

    public BigDecimal getoGCount() {
        return oGCount;
    }

    public void setoGCount(BigDecimal oGCount) {
        this.oGCount = oGCount;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
