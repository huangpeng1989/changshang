package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class CateringWhHandOfLossBillDtl  implements Serializable {

    private static final long serialVersionUID = -3895986996285913677L;
    private Integer fEntryId;

    private Integer olBillId;

    private Long projectId;
    private Long projectRootId;

    private Integer rmId;

    private String rmCode;

    private Integer srmId;

    private String srmCode;

    private Integer srmUnit;


    private String typeName;  //原材料包装单位名称

    private String rmName;  //原材料名称


    private String whStock;  //库存

    public String getRmSpec() {
        return rmSpec;
    }

    public void setRmSpec(String rmSpec) {
        this.rmSpec = rmSpec;
    }

    private String rmSpec;  //原材料规格


    private String rmBarcode;  //原材料条形码

    private BigDecimal srmPackContent;

    private BigDecimal plCount;

    private BigDecimal sPlCount;

    private Integer sSrmId;

    private String sSrmCode;

    private Integer sSrmUnit;

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


    private Integer goodType;



    private Integer suppId;
    private String suppCode;
    private BigDecimal supTaxCost;
    private BigDecimal supNotaxCost;
    private String dishClassCode;
    private String specName;
    private Integer dishBomId;
    private List<TreeMap> bomInfo = new ArrayList<>();

    public List<TreeMap> getBomInfo() {
        return bomInfo;
    }

    public void setBomInfo(List<TreeMap> bomInfo) {
        this.bomInfo = bomInfo;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    private String dishClassName;
    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getWhStock() {
        return whStock;
    }

    public void setWhStock(String whStock) {
        this.whStock = whStock;
    }


    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }



    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode == null ? null : srmCode.trim();
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public BigDecimal getSrmPackContent() {
        return srmPackContent;
    }

    public void setSrmPackContent(BigDecimal srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    public BigDecimal getPlCount() {
        return plCount;
    }

    public void setPlCount(BigDecimal plCount) {
        this.plCount = plCount;
    }

    public BigDecimal getsPlCount() {
        return sPlCount;
    }

    public void setsPlCount(BigDecimal sPlCount) {
        this.sPlCount = sPlCount;
    }

    public Integer getsSrmId() {
        return sSrmId;
    }

    public void setsSrmId(Integer sSrmId) {
        this.sSrmId = sSrmId;
    }

    public String getsSrmCode() {
        return sSrmCode;
    }

    public void setsSrmCode(String sSrmCode) {
        this.sSrmCode = sSrmCode == null ? null : sSrmCode.trim();
    }

    public Integer getsSrmUnit() {
        return sSrmUnit;
    }

    public void setsSrmUnit(Integer sSrmUnit) {
        this.sSrmUnit = sSrmUnit;
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
