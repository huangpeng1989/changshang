package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityDealInfoDtl implements Serializable {

    private static final long serialVersionUID = -8373860886486175947L;
    private Long comDtlId;

    private String comNdealId;

    private Integer nterminalId;

    private Long projectId;
    private Long projectRootId;

    private Integer gzoneId;

    private Integer comId;

    private Integer comSaleId;

    private String comBarcode;

    private String comSpec;

    private String comClassCode;

    private Integer sellModel;

    private Integer empId;

    private BigDecimal realPrice;

    private BigDecimal salePrice;

    private BigDecimal comNum;

    private Integer comNplanid;

    private BigDecimal comDiscount;

    private BigDecimal dcAmount;

    private BigDecimal dcDtlAmount;

    private BigDecimal comAmount;

    private BigDecimal notaxAmount;

    private Integer taxId;

    private String taxName;

    private BigDecimal taxAmount;

    private BigDecimal gpRate;

    private Byte isBind;

    private Integer bindComId;

    private Byte isReturn;

    private BigDecimal bchTaxCost;

    private BigDecimal bchNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer batchId;

    private Integer suppId;

    private String state;

    private String remark;

    private Byte isDelete;

    private Date comTimestamp;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private Integer comCode;

    private Integer comUnit;

    private Integer parkId;

    private BigDecimal tieupsAmount;

    private BigDecimal pagecount;


    public BigDecimal getPagecount() {
        return pagecount;
    }

    public void setPagecount(BigDecimal pagecount) {
        this.pagecount = pagecount;
    }

     public Long getComDtlId() {
        return comDtlId;
    }

    public void setComDtlId(Long comDtlId) {
        this.comDtlId = comDtlId;
    }

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId == null ? null : comNdealId.trim();
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

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getComSaleId() {
        return comSaleId;
    }

    public void setComSaleId(Integer comSaleId) {
        this.comSaleId = comSaleId;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode == null ? null : comBarcode.trim();
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec == null ? null : comSpec.trim();
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode == null ? null : comClassCode.trim();
    }

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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

    public BigDecimal getComNum() {
        return comNum;
    }

    public void setComNum(BigDecimal comNum) {
        this.comNum = comNum;
    }

    public Integer getComNplanid() {
        return comNplanid;
    }

    public void setComNplanid(Integer comNplanid) {
        this.comNplanid = comNplanid;
    }

    public BigDecimal getComDiscount() {
        return comDiscount;
    }

    public void setComDiscount(BigDecimal comDiscount) {
        this.comDiscount = comDiscount;
    }

    public BigDecimal getDcAmount() {
        return dcAmount;
    }

    public void setDcAmount(BigDecimal dcAmount) {
        this.dcAmount = dcAmount;
    }

    public BigDecimal getDcDtlAmount() {
        return dcDtlAmount;
    }

    public void setDcDtlAmount(BigDecimal dcDtlAmount) {
        this.dcDtlAmount = dcDtlAmount;
    }

    public BigDecimal getComAmount() {
        return comAmount;
    }

    public void setComAmount(BigDecimal comAmount) {
        this.comAmount = comAmount;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
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

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getGpRate() {
        return gpRate;
    }

    public void setGpRate(BigDecimal gpRate) {
        this.gpRate = gpRate;
    }

    public Byte getIsBind() {
        return isBind;
    }

    public void setIsBind(Byte isBind) {
        this.isBind = isBind;
    }

    public Integer getBindComId() {
        return bindComId;
    }

    public void setBindComId(Integer bindComId) {
        this.bindComId = bindComId;
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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
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

    public Date getComTimestamp() {
        return comTimestamp;
    }

    public void setComTimestamp(Date comTimestamp) {
        this.comTimestamp = comTimestamp;
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

    public Integer getComCode() {
        return comCode;
    }

    public void setComCode(Integer comCode) {
        this.comCode = comCode;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }
}
