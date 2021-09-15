package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommoditySaledPdaComDetailModel implements Serializable {
    private Integer saledDishId;

    private String saledDishCode;

    private Integer comId;

    private Integer saleComId;

    private BigDecimal retailPrice;

    private String comBarcode;

    private Integer sellModule;

    private Integer saledComType;

    private int isSaleStatus;

    private int isBind;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private int isDelete;

    private Integer syncStatus;

    private Integer goodType;

    private Integer gzoneId;

    private Long projectId;

    private int saledBillDtlId;

    private BigDecimal oldRetailPrice;

    private Integer updateIndex;

    public Integer getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Integer updateIndex) {
        this.updateIndex = updateIndex;
    }

    public void setIsBind(int isBind) {
        this.isBind = isBind;
    }

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public int getSaledBillDtlId() {
        return saledBillDtlId;
    }

    public void setSaledBillDtlId(int saledBillDtlId) {
        this.saledBillDtlId = saledBillDtlId;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }

    public String getSaledDishCode() {
        return saledDishCode;
    }

    public void setSaledDishCode(String saledDishCode) {
        this.saledDishCode = saledDishCode == null ? null : saledDishCode.trim();
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode == null ? null : comBarcode.trim();
    }

    public Integer getSellModule() {
        return sellModule;
    }

    public void setSellModule(Integer sellModule) {
        this.sellModule = sellModule;
    }

    public Integer getSaledComType() {
        return saledComType;
    }

    public void setSaledComType(Integer saledComType) {
        this.saledComType = saledComType;
    }

    public int getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(int isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    public int getIsBind() {
        return isBind;
    }

    public void setIsBind(Byte isBind) {
        this.isBind = isBind;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }
}