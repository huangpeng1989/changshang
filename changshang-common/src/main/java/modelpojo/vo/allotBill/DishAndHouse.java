package modelpojo.vo.allotBill;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 原材料和库存数据映射表
 */
public class DishAndHouse implements Serializable {

    private Long projectId;

    private Long projectRootId;

    private Integer whIdOut;//调出仓库id

    private Integer rmId;// 原材料主键ID

    private String rmCode;//原材料编号

    private String rmName;//原材料名称

    private BigDecimal whStock;//调出库存总数

    private Integer whIdIn;//调入仓库id

    private BigDecimal whStockIn;//调入库存总数

    private Integer srmUnit;// 原材料包装单位
    private String srmCode;// code
    private String sellModel;//原材料规格

    private Integer srmId;// 原材料包装id
    private String rmClassCode;//原材料分类编号

    private String rmBarcode;//原材料条码

    private String srmUnitName ;//转中文
    private String dishClassName ;//转中文

    private String dishUnitName ;


    private Integer goodType;// 数据类型



    private Integer sSrmId;// 转换原材料包装id

    private String sSrmCode;// 转换原材料包装id
    private Integer sSrmUnit;// 单位
    private String sSrmUnitName;// 单位
    private BigDecimal packContent;// 与最小单位转换数量

    private Integer rmUnit;

    private String maxWhStock;//

    private String altInBillCode;

    private String surplusAltOutNum;//剩余可调出数量

    private String surplusAltInNum;//剩余可调入数量

    public String getSurplusAltOutNum() {
        return surplusAltOutNum;
    }

    public void setSurplusAltOutNum(String surplusAltOutNum) {
        this.surplusAltOutNum = surplusAltOutNum;
    }

    public String getSurplusAltInNum() {
        return surplusAltInNum;
    }

    public void setSurplusAltInNum(String surplusAltInNum) {
        this.surplusAltInNum = surplusAltInNum;
    }

    public String getAltInBillCode() {
        return altInBillCode;
    }

    public void setAltInBillCode(String altInBillCode) {
        this.altInBillCode = altInBillCode;
    }

    public String getMaxWhStock() {
        return maxWhStock;
    }

    public void setMaxWhStock(String maxWhStock) {
        this.maxWhStock = maxWhStock;
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
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
        this.sSrmCode = sSrmCode;
    }

    public Integer getsSrmUnit() {
        return sSrmUnit;
    }

    public void setsSrmUnit(Integer sSrmUnit) {
        this.sSrmUnit = sSrmUnit;
    }

    public String getsSrmUnitName() {
        return sSrmUnitName;
    }

    public void setsSrmUnitName(String sSrmUnitName) {
        this.sSrmUnitName = sSrmUnitName;
    }

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public String getDishClassName() {
        return dishClassName;
    }

    public void setDishClassName(String dishClassName) {
        this.dishClassName = dishClassName;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
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

    public Integer getWhIdOut() {
        return whIdOut;
    }

    public void setWhIdOut(Integer whIdOut) {
        this.whIdOut = whIdOut;
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
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public Integer getWhIdIn() {
        return whIdIn;
    }

    public void setWhIdIn(Integer whIdIn) {
        this.whIdIn = whIdIn;
    }

    public BigDecimal getWhStockIn() {
        return whStockIn;
    }

    public void setWhStockIn(BigDecimal whStockIn) {
        this.whStockIn = whStockIn;
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }
}