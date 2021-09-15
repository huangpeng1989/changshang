package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/****
 * 库存查询（加权平均）实体类
 */
public class VCommodityStockModel implements Serializable{

    private String whName;

    private String comCode;

    private String comBarcode;

    private String comName;

    private String comSpec;

    private String comUnit;

    private String comClassName;

    private String taxName;

    private BigDecimal taxCost;

    private BigDecimal notaxCost;

    private BigDecimal whStock;

    private BigDecimal noWhStock;

    private String suppName;

    private Integer saleComId;

    private Integer saleCommUnit;

    private Integer salePackContent;

    private String saleComCode;

    private Integer comId;

    private BigDecimal qcstock;


    public BigDecimal getQcstock() {
        return qcstock;
    }

    public void setQcstock(BigDecimal qcstock) {
        this.qcstock = qcstock;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    private Integer whId;

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    private String comUnitName;

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    private Integer comClassId;




    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getSaleCommUnit() {
        return saleCommUnit;
    }

    public void setSaleCommUnit(Integer saleCommUnit) {
        this.saleCommUnit = saleCommUnit;
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
        this.saleComCode = saleComCode;
    }




    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    private String suppCode;


    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    private String comClassCode;

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
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

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public BigDecimal getNoWhStock() {
        return noWhStock;
    }

    public void setNoWhStock(BigDecimal noWhStock) {
        this.noWhStock = noWhStock;
    }
}
