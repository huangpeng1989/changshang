package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhInDtl  implements Serializable {

    private static final long serialVersionUID = -6101039460745822704L;
    private Integer fEntryId;

    private Long projectId;

    private Integer whinBillId;


    private Long projectRootId;

    private Integer rmId;

    private String rmCode;

    private String rmSpec;

    private Integer rmUnit;

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    private String rmName;

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    private String rmBarcode;

    private String srmUnitName;
    private String stockUnitName;

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

    private BigDecimal orderPageCount;

    private BigDecimal giftPageCount ;

    private BigDecimal oGPageCount;

    private Integer gSrmId;

    private String gSrmCode;

    private Integer gSrmUnit;

    private BigDecimal gSrmPackContent;

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

    public String getStockUnitName() {
        return stockUnitName;
    }

    public void setStockUnitName(String stockUnitName) {
        this.stockUnitName = stockUnitName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    private String sellModel;

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    private BigDecimal whStock;

    public Integer getRmDishType() {
        return rmDishType;
    }

    public void setRmDishType(Integer rmDishType) {
        this.rmDishType = rmDishType;
    }

    private Integer rmDishType;


    private BigDecimal sumOGPageCount;
    private BigDecimal acptTaxPchsPrice;  //实际含税进价


    private BigDecimal acptNotaxPchsPrice;  //实际未税进价

    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getAcptTaxPchsPrice() {
        return acptTaxPchsPrice;
    }

    public void setAcptTaxPchsPrice(BigDecimal acptTaxPchsPrice) {
        this.acptTaxPchsPrice = acptTaxPchsPrice;
    }

    public BigDecimal getAcptNotaxPchsPrice() {
        return acptNotaxPchsPrice;
    }

    public void setAcptNotaxPchsPrice(BigDecimal acptNotaxPchsPrice) {
        this.acptNotaxPchsPrice = acptNotaxPchsPrice;
    }

    public BigDecimal getSumOGPageCount() {
        return sumOGPageCount;
    }

    public void setSumOGPageCount(BigDecimal sumOGPageCount) {
        this.sumOGPageCount = sumOGPageCount;
    }


    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
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

    public Integer getWhinBillId() {
        return whinBillId;
    }

    public void setWhinBillId(Integer whinBillId) {
        this.whinBillId = whinBillId;
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
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec == null ? null : rmSpec.trim();
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
