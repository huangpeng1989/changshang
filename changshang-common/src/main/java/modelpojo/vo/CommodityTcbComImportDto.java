package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 商品预导入通用返回集
 */
public class CommodityTcbComImportDto implements Serializable {

    //商品名称
    private String comName;
    //商品条码
    private String comBarcode;
    //经营方式
    private Integer sellModel;
    //商品单位
    private Integer comUnit;
    //销项税
    private String slTax;
    //进项税
    private String phTax;
    //供应商名称
    private String suppName;
    //预估含税成本价
    private BigDecimal fuTaxCost;
    //结果
    private Integer result;
    //问题原因
    private String message;

    //商品单位
    private String comUnitName;

    //含税进价
    private BigDecimal taxPaid;

    //合同编号
    private String contractCode;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }


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

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public String getSlTax() {
        return slTax;
    }

    public void setSlTax(String slTax) {
        this.slTax = slTax;
    }

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public BigDecimal getFuTaxCost() {
        return fuTaxCost;
    }

    public void setFuTaxCost(BigDecimal fuTaxCost) {
        this.fuTaxCost = fuTaxCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
