package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityWhInvtryBillDtl implements Serializable{
    private Integer comId;

    private String comCode;

    private Integer comClassId;

    private Integer comUnit;

    private Integer saleComId;

    private Integer saleComUnit;

    private Integer salePackContent;

    private String saleComCode;

    private BigDecimal paperStock;

    private BigDecimal pTaxCostAmount;

    private BigDecimal pNotaxCostAmount;

    private BigDecimal realStock;

    private BigDecimal ivtDftCount;

    private BigDecimal ivtDftCount1;

    private Byte proLosType;

    private BigDecimal rTaxCostAmount;

    private BigDecimal rNotaxCostAmount;

    private BigDecimal bchNotaxCost;

    private BigDecimal bchTaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer batchId;

    private String state;

    private String remark;

    private Byte isDelete;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

	private Integer fEntryId;

    private Integer ivtId;

    private Long projectId;

    private String comName;

    private String comBarcode;

    private String comClassCode;

    private String comClassName;

    private String comUnitName;
    private String comSpec;

    private String  ivtCode;

    private String yuGu;

    private Integer isInsert;

    private BigDecimal taxcostprice;

    private BigDecimal notaxcostprice;

    private BigDecimal packContent;

    public Integer getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Integer isInsert) {
        this.isInsert = isInsert;
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    private List<CateringWhIvtSpecBill> utils=new ArrayList<>();

    public List<CateringWhIvtSpecBill> getUtils() {
        return utils;
    }

    public void setUtils(List<CateringWhIvtSpecBill> utils) {
        this.utils = utils;
    }

    public BigDecimal getNotaxcostprice() {
        return notaxcostprice;
    }

    public void setNotaxcostprice(BigDecimal notaxcostprice) {
        this.notaxcostprice = notaxcostprice;
    }

    public BigDecimal getTaxcostprice() {
        return taxcostprice;
    }

    public void setTaxcostprice(BigDecimal taxcostprice) {
        this.taxcostprice = taxcostprice;
    }

    public String getYuGu() {
        return yuGu;
    }

    public void setYuGu(String yuGu) {
        this.yuGu = yuGu;
    }

    public BigDecimal getIvtDftCount1() {
        return ivtDftCount1;
    }

    public void setIvtDftCount1(BigDecimal ivtDftCount1) {
        this.ivtDftCount1 = ivtDftCount1;
    }

    public String getIvtCode() {
        return ivtCode;
    }

    public void setIvtCode(String ivtCode) {
        this.ivtCode = ivtCode;
    }

    private  BigDecimal taxPaid;

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    private  BigDecimal noTaxPaid;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }




    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getIvtId() {
        return ivtId;
    }

    public void setIvtId(Integer ivtId) {
        this.ivtId = ivtId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
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

    public Integer getSaleComUnit() {
        return saleComUnit;
    }

    public void setSaleComUnit(Integer saleComUnit) {
        this.saleComUnit = saleComUnit;
    }

    public Integer getSalePackContent() {
        return salePackContent;
    }

    public void setSalePackContent(Integer salePackContent) {
        this.salePackContent = salePackContent;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public BigDecimal getPaperStock() {
        return paperStock;
    }

    public void setPaperStock(BigDecimal paperStock) {
        this.paperStock = paperStock;
    }

    public BigDecimal getpTaxCostAmount() {
        return pTaxCostAmount;
    }

    public void setpTaxCostAmount(BigDecimal pTaxCostAmount) {
        this.pTaxCostAmount = pTaxCostAmount;
    }

    public BigDecimal getpNotaxCostAmount() {
        return pNotaxCostAmount;
    }

    public void setpNotaxCostAmount(BigDecimal pNotaxCostAmount) {
        this.pNotaxCostAmount = pNotaxCostAmount;
    }

    public BigDecimal getRealStock() {
        return realStock;
    }

    public void setRealStock(BigDecimal realStock) {
        this.realStock = realStock;
    }

    public BigDecimal getIvtDftCount() {
        return ivtDftCount;
    }

    public void setIvtDftCount(BigDecimal ivtDftCount) {
        this.ivtDftCount = ivtDftCount;
    }

    public Byte getProLosType() {
        return proLosType;
    }

    public void setProLosType(Byte proLosType) {
        this.proLosType = proLosType;
    }

    public BigDecimal getrTaxCostAmount() {
        return rTaxCostAmount;
    }

    public void setrTaxCostAmount(BigDecimal rTaxCostAmount) {
        this.rTaxCostAmount = rTaxCostAmount;
    }

    public BigDecimal getrNotaxCostAmount() {
        return rNotaxCostAmount;
    }

    public void setrNotaxCostAmount(BigDecimal rNotaxCostAmount) {
        this.rNotaxCostAmount = rNotaxCostAmount;
    }

    public BigDecimal getBchNotaxCost() {
        return bchNotaxCost;
    }

    public void setBchNotaxCost(BigDecimal bchNotaxCost) {
        this.bchNotaxCost = bchNotaxCost;
    }

    public BigDecimal getBchTaxCost() {
        return bchTaxCost;
    }

    public void setBchTaxCost(BigDecimal bchTaxCost) {
        this.bchTaxCost = bchTaxCost;
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