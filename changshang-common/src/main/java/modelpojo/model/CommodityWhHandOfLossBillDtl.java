package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 报损/溢详情表
 */
public class CommodityWhHandOfLossBillDtl implements Serializable {
    private static final long serialVersionUID = -6396317415466087303L;
    private Long projectRootId;

     private Integer fEntryId;

    private Integer olBillId;

    private Long projectId;



    private Integer comId;

    private String comCode;

    private Integer saleComId;

    private Integer saleComUnit;

    private Integer salePageContent;

    private BigDecimal plCount;

    private BigDecimal bchTaxCost;

    private BigDecimal bchNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    private Integer batchId;

    private Integer taxId;

    private String taxName;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer status;

    private Byte isDelete;

    private String remark;

    private String state;

    private Integer syncStatus;


    public Integer getPlCountSum() {
        return plCountSum;
    }

    public void setPlCountSum(Integer plCountSum) {
        this.plCountSum = plCountSum;
    }

    private Integer plCountSum;


    private String comSpec;   // 商品规格
    private String comName;   // 商品名称
    private String comUnit;   // 商品单位


    private String commUnitName;   // 商品单位名称
    private String commSpec;   //销售商品规格
    private String commUnit;   //销售商品单位
    private String comBarcode;  // 销售商品条码
    private String taxPaid;  // 含税进价
    private String noTaxPaid;  // 未税进价

    private String whStock;  // 当前仓库总数量

    private Integer packContent;  // 销售商品包装含量



    private Integer suppId;
    private String suppCode;
    private BigDecimal supTaxCost;
    private BigDecimal supNotaxCost;
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


    public String getWhStock() {
        return whStock;
    }

    public void setWhStock(String whStock) {
        this.whStock = whStock;
    }


    public String getCommUnitName() {
        return commUnitName;
    }

    public void setCommUnitName(String commUnitName) {
        this.commUnitName = commUnitName;
    }

    public Integer getPackContent() {
        return packContent;
    }

    public void setPackContent(Integer packContent) {
        this.packContent = packContent;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(String noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }



    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getOlBillId() {
        return olBillId;
    }

    public void setOlBillId(Integer olBillId) {
        this.olBillId = olBillId;
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

    public Integer getSalePageContent() {
        return salePageContent;
    }

    public void setSalePageContent(Integer salePageContent) {
        this.salePageContent = salePageContent;
    }

    public BigDecimal getPlCount() {
        return plCount;
    }

    public void setPlCount(BigDecimal plCount) {
        this.plCount = plCount;
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
