package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 原材料信息表
 */
public class CateringTcbRowmaterial implements Serializable {

    private static final long serialVersionUID = 3485911201868121333L;
    private Long projectId;

    private Integer rmId;


    private Long projectRootId;

    private String rmCode;

    private String rmName;

    private String rmAbbreviate;

    private String spellCode;

    private String rmClassCode;

    private String sellModel;

    private Integer rmUnit;

    private String manufacturer;

    private Integer expirationDate;

    private Integer rmGradeId;

    public Integer getIsCanSale() {
        return isCanSale;
    }

    public void setIsCanSale(Integer isCanSale) {
        this.isCanSale = isCanSale;
    }

    private Integer isCanSale;

    public String getRmGradeStr() {
        return rmGradeStr;
    }

    public void setRmGradeStr(String rmGradeStr) {
        this.rmGradeStr = rmGradeStr;
    }

    private String rmGradeStr; //原材料等级

    private BigDecimal maxWhCount;

    private BigDecimal minWhCount;

    private Byte specRmType8;

    private Byte specRmType7;

    private Byte specRmType6;

    private Byte specRmType5;

    private Byte specRmType4;

    private Byte specRmType3;

    private Byte specRmType2;

    private Byte specRmType;

    private BigDecimal costPrice;

    private String phTax;
    private BigDecimal predictPrice;  // 预估售价
    private Integer saleStatus;  // 原材料销售状态

    private Integer phTaxId;

    private Integer saleTaxId;

    private Integer transportType;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    private String createrStr;

    private Long blEmpId;

    private Date blTime;

    private Date updatedTime;

    private Long modifier;

    private Integer cStatus;

    private Integer isDelete;

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getPredictPrice() {
        return predictPrice;
    }

    public void setPredictPrice(BigDecimal predictPrice) {
        this.predictPrice = predictPrice;
    }


    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    private Integer syncStatus;

    public String getZoomClassCode() {
        return zoomClassCode;
    }

    public void setZoomClassCode(String zoomClassCode) {
        this.zoomClassCode = zoomClassCode;
    }

    private String zoomClassCode;  //组装分类编号

    // 原材料包装集合
    private List<CateringTcbSaleRowmater> saleRowmaterList;

    // 原材料供应商集合
    private List<CateringTcbSuppRowmater> suppRowmaterList;


    public List<CatecommTssDatadictModel> getDatadictList() {
        return datadictList;
    }

    public void setDatadictList(List<CatecommTssDatadictModel> datadictList) {
        this.datadictList = datadictList;
    }

    private List<CatecommTssDatadictModel> datadictList;

    public List<CateringTcbSaleRowmater> getSaleRowmaterList() {
        return saleRowmaterList;
    }

    public void setSaleRowmaterList(List<CateringTcbSaleRowmater> saleRowmaterList) {
        this.saleRowmaterList = saleRowmaterList;
    }

    public List<CateringTcbSuppRowmater> getSuppRowmaterList() {
        return suppRowmaterList;
    }

    public void setSuppRowmaterList(List<CateringTcbSuppRowmater> suppRowmaterList) {
        this.suppRowmaterList = suppRowmaterList;
    }

     public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName == null ? null : rmName.trim();
    }

    public String getRmAbbreviate() {
        return rmAbbreviate;
    }

    public void setRmAbbreviate(String rmAbbreviate) {
        this.rmAbbreviate = rmAbbreviate == null ? null : rmAbbreviate.trim();
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode == null ? null : spellCode.trim();
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode == null ? null : rmClassCode.trim();
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel == null ? null : sellModel.trim();
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getRmGradeId() {
        return rmGradeId;
    }

    public void setRmGradeId(Integer rmGradeId) {
        this.rmGradeId = rmGradeId;
    }

    public BigDecimal getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(BigDecimal maxWhCount) {
        this.maxWhCount = maxWhCount;
    }

    public BigDecimal getMinWhCount() {
        return minWhCount;
    }

    public void setMinWhCount(BigDecimal minWhCount) {
        this.minWhCount = minWhCount;
    }

    public Byte getSpecRmType8() {
        return specRmType8;
    }

    public void setSpecRmType8(Byte specRmType8) {
        this.specRmType8 = specRmType8;
    }

    public Byte getSpecRmType7() {
        return specRmType7;
    }

    public void setSpecRmType7(Byte specRmType7) {
        this.specRmType7 = specRmType7;
    }

    public Byte getSpecRmType6() {
        return specRmType6;
    }

    public void setSpecRmType6(Byte specRmType6) {
        this.specRmType6 = specRmType6;
    }

    public Byte getSpecRmType5() {
        return specRmType5;
    }

    public void setSpecRmType5(Byte specRmType5) {
        this.specRmType5 = specRmType5;
    }

    public Byte getSpecRmType4() {
        return specRmType4;
    }

    public void setSpecRmType4(Byte specRmType4) {
        this.specRmType4 = specRmType4;
    }

    public Byte getSpecRmType3() {
        return specRmType3;
    }

    public void setSpecRmType3(Byte specRmType3) {
        this.specRmType3 = specRmType3;
    }

    public Byte getSpecRmType2() {
        return specRmType2;
    }

    public void setSpecRmType2(Byte specRmType2) {
        this.specRmType2 = specRmType2;
    }

    public Byte getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(Byte specRmType) {
        this.specRmType = specRmType;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public Integer getTransportType() {
        return transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSaleTaxId() {
        return saleTaxId;
    }

    public void setSaleTaxId(Integer saleTaxId) {
        this.saleTaxId = saleTaxId;
    }

}
