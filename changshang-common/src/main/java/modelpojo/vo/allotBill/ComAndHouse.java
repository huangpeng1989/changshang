package modelpojo.vo.allotBill;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品和库存数据映射表
 */
public class ComAndHouse implements Serializable {

    private Long projectId;

    private Long projectRootId;

    private Integer whIdOut;

    private Integer comId;

    private String comCode;

    private String comName;

    private BigDecimal whStock;//调出库存总数

    private BigDecimal taxCostAmount;//含税成本金额

    private BigDecimal noTaxCostAmount;//未税成本金额

    private String comBarcode;//销售商品条码

    private String saleComCode;//销售商品编码

    private Integer comUnit;//商品单位

    private String comSpec;//商品规格

    private Integer whIdIn;//调入

    private BigDecimal whStockIn;//调入库存总数

    private String comClassCode;//商品分类编号

    private Integer saleComId;//销售商品id

    private Integer saleComUnit;//销售商品单位

    private String comUnitName;//code转中文

    private String maxWhStock;//

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

    public String getMaxWhStock() {
        return maxWhStock;
    }

    public void setMaxWhStock(String maxWhStock) {
        this.maxWhStock = maxWhStock;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
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
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNoTaxCostAmount() {
        return noTaxCostAmount;
    }

    public void setNoTaxCostAmount(BigDecimal noTaxCostAmount) {
        this.noTaxCostAmount = noTaxCostAmount;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
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

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
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
}