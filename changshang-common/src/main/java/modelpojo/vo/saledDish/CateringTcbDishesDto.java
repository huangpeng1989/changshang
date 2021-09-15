package modelpojo.vo.saledDish;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CateringTcbDishesDto implements Serializable {
    private Long projectRootid;

    private String dishCode;

    private String dishName;

    private String dishAbbreviate;

    private String spellCode;

    private String dishClassCode;

    private Integer dishType;

    private Integer dishUnit;

    private BigDecimal retailPrice;

    private BigDecimal costPrice;

    private BigDecimal slTax;

    private Integer slTaxId;

    private Integer weighComWay;

    private Integer sellStatus;

    private Integer sellOut;

    private BigDecimal packCost;

    private Integer isHot;

    private BigDecimal minPetailPrice;
    private Integer transportType;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Long blEmpId;

    private Date blTime;

    private Date updatedTime;

    private Long modifier;

    private Integer cStatus;

    private Integer isDelete;

	private Integer dishId;

    private Long projectId;

    private Integer dictSpecId;

    private Integer saledDishDtlId;//主键id

    private Integer updateIndex;//0 表示原始数据，1表示新增数据

    private Integer whId;

    private Integer isSaleStatus;//是否可售

    private Integer saledDishId;

    private Integer dbStatus;//半成品状态

    private Integer saledDataType;//单据类型

    public Integer getSaledDataType() {
        return saledDataType;
    }

    public void setSaledDataType(Integer saledDataType) {
        this.saledDataType = saledDataType;
    }

    public Integer getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(Integer dbStatus) {
        this.dbStatus = dbStatus;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }

    public Integer getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(Integer isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Integer updateIndex) {
        this.updateIndex = updateIndex;
    }

    private List<PriceTypeDto> priceType;//价格类型
    private String gzoneName;//营业点名称


    private String gzoneCode;//营业点编号

    private String gzoneId;//营业点id
    private String dishDictUnit;//字典表中文转换
    private String dishDictName;//

    private Integer saledDishcomType;// 可售菜品类型

    private String sellModel;// 原材料规格

    private String srmCode;// 原材料包装编号
    private String rmBarcode;// 原材料条码
    private BigDecimal dictSpecPrice;//原材料价格
    private String rmUnitName;//原材料单位中文
    private String dishUnitName;//
    private String dishTypeName;//

    private String isBom;//是否菜品bom

    public String getIsBom() {
        return isBom;
    }

    public void setIsBom(String isBom) {
        this.isBom = isBom;
    }

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public BigDecimal getDictSpecPrice() {
        return dictSpecPrice;
    }

    public void setDictSpecPrice(BigDecimal dictSpecPrice) {
        this.dictSpecPrice = dictSpecPrice;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public Integer getSaledDishcomType() {
        return saledDishcomType;
    }

    public void setSaledDishcomType(Integer saledDishcomType) {
        this.saledDishcomType = saledDishcomType;
    }

    public Integer getSaledDishDtlId() {
        return saledDishDtlId;
    }

    public void setSaledDishDtlId(Integer saledDishDtlId) {
        this.saledDishDtlId = saledDishDtlId;
    }

    public String getDishDictUnit() {
        return dishDictUnit;
    }

    public void setDishDictUnit(String dishDictUnit) {
        this.dishDictUnit = dishDictUnit;
    }

    public String getDishDictName() {
        return dishDictName;
    }

    public void setDishDictName(String dishDictName) {
        this.dishDictName = dishDictName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(String gzoneId) {
        this.gzoneId = gzoneId;
    }

    public List<PriceTypeDto> getPriceType() {
        return priceType;
    }

    public void setPriceType(List<PriceTypeDto> priceType) {
        this.priceType = priceType;
    }

    public Integer getDictSpecId() {
        return dictSpecId;
    }

    public void setDictSpecId(Integer dictSpecId) {
        this.dictSpecId = dictSpecId;
    }

    public Long getProjectRootid() {
        return projectRootid;
    }

    public void setProjectRootid(Long projectRootid) {
        this.projectRootid = projectRootid;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishAbbreviate() {
        return dishAbbreviate;
    }

    public void setDishAbbreviate(String dishAbbreviate) {
        this.dishAbbreviate = dishAbbreviate;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSlTax() {
        return slTax;
    }

    public void setSlTax(BigDecimal slTax) {
        this.slTax = slTax;
    }

    public Integer getSlTaxId() {
        return slTaxId;
    }

    public void setSlTaxId(Integer slTaxId) {
        this.slTaxId = slTaxId;
    }

    public Integer getWeighComWay() {
        return weighComWay;
    }

    public void setWeighComWay(Integer weighComWay) {
        this.weighComWay = weighComWay;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Integer getSellOut() {
        return sellOut;
    }

    public void setSellOut(Integer sellOut) {
        this.sellOut = sellOut;
    }

    public BigDecimal getPackCost() {
        return packCost;
    }

    public void setPackCost(BigDecimal packCost) {
        this.packCost = packCost;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public BigDecimal getMinPetailPrice() {
        return minPetailPrice;
    }

    public void setMinPetailPrice(BigDecimal minPetailPrice) {
        this.minPetailPrice = minPetailPrice;
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
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }


}
