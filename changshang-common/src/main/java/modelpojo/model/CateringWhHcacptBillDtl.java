package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhHcacptBillDtl implements Serializable {

    private static final long serialVersionUID = 151476175395873230L;
    private Integer acptBillId;

    private Integer fEntryId;

    private Integer hcBillId;

    private Long projectId;


    private Long projectRootId;

    private String hcBillCode;

    private String acptBillCode;

    private Integer rmId;

    private String rmCode;

    private String rmSpec;

    private String rmBarcode;

    private Integer rmUnit;

    private BigDecimal taxPchsPrice;

    private BigDecimal notaxPchsPrice;

    private BigDecimal taxSumPrice;

    private BigDecimal notaxSumPrice;

    private Integer taxId;

    private String taxName;

    private BigDecimal taxPagePrice;

    private BigDecimal notaxPagePrice;

    private Byte isGift;

    private Integer pSrmId;

    private String pSrmCode;

    private Integer pSrmUnit;

    private BigDecimal pSrmPackContent;

    private BigDecimal hcGOrderCount;

    private BigDecimal hcGGiftCount;

    private BigDecimal oGPageCount;

    private Integer gSrmId;

    private String gSrmCode;

    private Integer gSrmUnit;

    private BigDecimal gSrmPackContent;

    private BigDecimal orderCount;

    private BigDecimal giftCount;

    private BigDecimal oGCount;

    private Integer batchId;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer status;

    private Byte isDelete;

    private String remark;

    private String state;

    private Integer whinStatus;

    private Integer syncStatus;


    private String srmUnitName;
    private String rmName;
    private BigDecimal acptOrderPageCount;
    private BigDecimal acptGiftPageCount;

    private BigDecimal canHcOrderPageCount;//可红冲包装-订货数量

    private BigDecimal canHcGiftPageCount;//可红冲包装-赠品数量

    /**库存 */
    private BigDecimal whStock;
    /**冻结数量 */
    private BigDecimal freeaeCount;

    private Integer contractId;


    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public BigDecimal getFreeaeCount() {
        return freeaeCount;
    }

    public void setFreeaeCount(BigDecimal freeaeCount) {
        this.freeaeCount = freeaeCount;
    }

    public BigDecimal getCanHcOrderPageCount() {
        return canHcOrderPageCount;
    }

    public void setCanHcOrderPageCount(BigDecimal canHcOrderPageCount) {
        this.canHcOrderPageCount = canHcOrderPageCount;
    }

    public BigDecimal getCanHcGiftPageCount() {
        return canHcGiftPageCount;
    }

    public void setCanHcGiftPageCount(BigDecimal canHcGiftPageCount) {
        this.canHcGiftPageCount = canHcGiftPageCount;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public BigDecimal getAcptOrderPageCount() {
        return acptOrderPageCount;
    }

    public void setAcptOrderPageCount(BigDecimal acptOrderPageCount) {
        this.acptOrderPageCount = acptOrderPageCount;
    }

    public BigDecimal getAcptGiftPageCount() {
        return acptGiftPageCount;
    }

    public void setAcptGiftPageCount(BigDecimal acptGiftPageCount) {
        this.acptGiftPageCount = acptGiftPageCount;
    }

    public Integer getAcptBillId() {
        return acptBillId;
    }

    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getHcBillId() {
        return hcBillId;
    }

    public void setHcBillId(Integer hcBillId) {
        this.hcBillId = hcBillId;
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

    public String getHcBillCode() {
        return hcBillCode;
    }

    public void setHcBillCode(String hcBillCode) {
        this.hcBillCode = hcBillCode == null ? null : hcBillCode.trim();
    }

    public String getAcptBillCode() {
        return acptBillCode;
    }

    public void setAcptBillCode(String acptBillCode) {
        this.acptBillCode = acptBillCode == null ? null : acptBillCode.trim();
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
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec == null ? null : rmSpec.trim();
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode == null ? null : rmBarcode.trim();
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
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

    public void setNotaxPagePrice(BigDecimal notaxPagePrice) {
        this.notaxPagePrice = notaxPagePrice;
    }

    public Byte getIsGift() {
        return isGift;
    }

    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    public Integer getpSrmId() {
        return pSrmId;
    }

    public void setpSrmId(Integer pSrmId) {
        this.pSrmId = pSrmId;
    }

    public String getpSrmCode() {
        return pSrmCode;
    }

    public void setpSrmCode(String pSrmCode) {
        this.pSrmCode = pSrmCode == null ? null : pSrmCode.trim();
    }

    public Integer getpSrmUnit() {
        return pSrmUnit;
    }

    public void setpSrmUnit(Integer pSrmUnit) {
        this.pSrmUnit = pSrmUnit;
    }

    public BigDecimal getpSrmPackContent() {
        return pSrmPackContent;
    }

    public void setpSrmPackContent(BigDecimal pSrmPackContent) {
        this.pSrmPackContent = pSrmPackContent;
    }

    public BigDecimal getHcGOrderCount() {
        return hcGOrderCount;
    }

    public void setHcGOrderCount(BigDecimal hcGOrderCount) {
        this.hcGOrderCount = hcGOrderCount;
    }

    public BigDecimal getHcGGiftCount() {
        return hcGGiftCount;
    }

    public void setHcGGiftCount(BigDecimal hcGGiftCount) {
        this.hcGGiftCount = hcGGiftCount;
    }

    public BigDecimal getoGPageCount() {
        return oGPageCount;
    }

    public void setoGPageCount(BigDecimal oGPageCount) {
        this.oGPageCount = oGPageCount;
    }

    public Integer getgSrmId() {
        return gSrmId;
    }

    public void setgSrmId(Integer gSrmId) {
        this.gSrmId = gSrmId;
    }

    public String getgSrmCode() {
        return gSrmCode;
    }

    public void setgSrmCode(String gSrmCode) {
        this.gSrmCode = gSrmCode == null ? null : gSrmCode.trim();
    }

    public Integer getgSrmUnit() {
        return gSrmUnit;
    }

    public void setgSrmUnit(Integer gSrmUnit) {
        this.gSrmUnit = gSrmUnit;
    }

    public BigDecimal getgSrmPackContent() {
        return gSrmPackContent;
    }

    public void setgSrmPackContent(BigDecimal gSrmPackContent) {
        this.gSrmPackContent = gSrmPackContent;
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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public Integer getWhinStatus() {
        return whinStatus;
    }

    public void setWhinStatus(Integer whinStatus) {
        this.whinStatus = whinStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
