package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringDealInfoDtl  implements Serializable {

    private static final long serialVersionUID = -980599599720022656L;
    private Long cateDtlId;

    private String cateNdealId;

    private Integer nterminalId;

    private Long projectId;
    private Long projectRootId;

    private Integer rmDishId;

    private Integer comboId;

    private Integer bomId;

    private Integer goodType;

    private Integer selModel;

    private String cateBarcode;

    private String cateClassCode;

    private Integer dishSpecId;

    private Byte isSetMeal;

    private BigDecimal realPrice;

    private BigDecimal salePrice;

    private BigDecimal cateNum;

    private Integer cateNplanId;

    private BigDecimal cateDiscount;

    private BigDecimal dcAmount;

    private BigDecimal cateAmount;

    private BigDecimal notaxAmount;

    private BigDecimal dcDtlAmount;

    private Integer empId;

    private Byte isReturn;

    private BigDecimal bchTaxCost;

    private BigDecimal bchNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private BigDecimal cateRate;

    private Integer batchId;

    private String state;

    private String remark;

    private Date cateTimestamp;

    private Byte isDelete;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private String cateCode;

    private Integer dishSpecName;

    private Integer cateUnit;

    private Long parkId;

    private BigDecimal tieupsAmount;


    private BigDecimal pagecount;

    private Integer suppId;

    private String suppCode;
    private BigDecimal tieupsNotaxAmount;  // 未税扣点金额
    private int tieupsTaxId;   // 税率ID
    private String tieupsTaxName;  //税率名称

    public BigDecimal getTieupsNotaxAmount() {
        return tieupsNotaxAmount;
    }

    public void setTieupsNotaxAmount(BigDecimal tieupsNotaxAmount) {
        this.tieupsNotaxAmount = tieupsNotaxAmount;
    }

    public int getTieupsTaxId() {
        return tieupsTaxId;
    }

    public void setTieupsTaxId(int tieupsTaxId) {
        this.tieupsTaxId = tieupsTaxId;
    }

    public String getTieupsTaxName() {
        return tieupsTaxName;
    }

    public void setTieupsTaxName(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
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

    public BigDecimal getPagecount() {
        return pagecount;
    }

    public void setPagecount(BigDecimal pagecount) {
        this.pagecount = pagecount;
    }

 		public Long getCateDtlId() {
        return cateDtlId;
    }

    public void setCateDtlId(Long cateDtlId) {
        this.cateDtlId = cateDtlId;
    }

    public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
    }

    public Integer getNterminalId() {
        return nterminalId;
    }

    public void setNterminalId(Integer nterminalId) {
        this.nterminalId = nterminalId;
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

    public Integer getRmDishId() {
        return rmDishId;
    }

    public void setRmDishId(Integer rmDishId) {
        this.rmDishId = rmDishId;
    }

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }

    public Integer getBomId() {
        return bomId;
    }

    public void setBomId(Integer bomId) {
        this.bomId = bomId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Integer getSelModel() {
        return selModel;
    }

    public void setSelModel(Integer selModel) {
        this.selModel = selModel;
    }

    public String getCateBarcode() {
        return cateBarcode;
    }

    public void setCateBarcode(String cateBarcode) {
        this.cateBarcode = cateBarcode == null ? null : cateBarcode.trim();
    }

    public String getCateClassCode() {
        return cateClassCode;
    }

    public void setCateClassCode(String cateClassCode) {
        this.cateClassCode = cateClassCode == null ? null : cateClassCode.trim();
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public Byte getIsSetMeal() {
        return isSetMeal;
    }

    public void setIsSetMeal(Byte isSetMeal) {
        this.isSetMeal = isSetMeal;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCateNum() {
        return cateNum;
    }

    public void setCateNum(BigDecimal cateNum) {
        this.cateNum = cateNum;
    }

    public Integer getCateNplanId() {
        return cateNplanId;
    }

    public void setCateNplanId(Integer cateNplanId) {
        this.cateNplanId = cateNplanId;
    }

    public BigDecimal getCateDiscount() {
        return cateDiscount;
    }

    public void setCateDiscount(BigDecimal cateDiscount) {
        this.cateDiscount = cateDiscount;
    }

    public BigDecimal getDcAmount() {
        return dcAmount;
    }

    public void setDcAmount(BigDecimal dcAmount) {
        this.dcAmount = dcAmount;
    }

    public BigDecimal getCateAmount() {
        return cateAmount;
    }

    public void setCateAmount(BigDecimal cateAmount) {
        this.cateAmount = cateAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }

    public BigDecimal getDcDtlAmount() {
        return dcDtlAmount;
    }

    public void setDcDtlAmount(BigDecimal dcDtlAmount) {
        this.dcDtlAmount = dcDtlAmount;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Byte getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Byte isReturn) {
        this.isReturn = isReturn;
    }

    public BigDecimal getBchTaxCost() {
        return bchTaxCost;
    }

    public void setBchTaxCost(BigDecimal bchTaxCost) {
        this.bchTaxCost = bchTaxCost;
    }

    public BigDecimal getBchNotaxCost() {
        return bchNotaxCost;
    }

    public void setBchNotaxCost(BigDecimal bchNotaxCost) {
        this.bchNotaxCost = bchNotaxCost;
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

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public BigDecimal getCateRate() {
        return cateRate;
    }

    public void setCateRate(BigDecimal cateRate) {
        this.cateRate = cateRate;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public Date getCateTimestamp() {
        return cateTimestamp;
    }

    public void setCateTimestamp(Date cateTimestamp) {
        this.cateTimestamp = cateTimestamp;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    public Integer getDishSpecName() {
        return dishSpecName;
    }

    public void setDishSpecName(Integer dishSpecName) {
        this.dishSpecName = dishSpecName;
    }

    public Integer getCateUnit() {
        return cateUnit;
    }

    public void setCateUnit(Integer cateUnit) {
        this.cateUnit = cateUnit;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }
}
