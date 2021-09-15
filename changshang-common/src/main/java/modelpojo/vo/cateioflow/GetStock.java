package modelpojo.vo.cateioflow;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: phaseiiclota
 * @description: 商品流水明细表
 * @author: panda
 * @create: 2019-11-21 18:10
 **/
public class GetStock implements Serializable{

    private String jtName;
    private String cmpName;
    private String orgName;
    private String whName;
    private String whCode;
    private String billCode;
    private String billType;
    private String comCode;
    private String comName;
    private String oneComClass;
    private String twoComClass;
    private String threeComClass;
    private String comSpec;
    private String comUnit;
    private String batchCount;
    private String taxName;
    private String notaxCost;
    private String taxCost;
    private String notaxCostAmount;
    private String taxCostAmount;
    private String saleprice;
    private String saleAmount;
    private String comBarcode;
    private String batchDate;

    private String sumBatchCount;
    private BigDecimal sumTaxCostAmount;
    private BigDecimal sumNotaxCostAmount;


    private String billTypeName;
    private String whCount;

    //如果类型是调拨出库，这个就要展示调入仓库，如果类型是调拨入库就要展示调出仓库
    private String inOutWhName;

    public String getInOutWhName() {
        return inOutWhName;
    }

    public void setInOutWhName(String inOutWhName) {
        this.inOutWhName = inOutWhName;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getWhCount() {
        return whCount;
    }

    public void setWhCount(String whCount) {
        this.whCount = whCount;
    }

    public String getSumBatchCount() {
        return sumBatchCount;
    }

    public void setSumBatchCount(String sumBatchCount) {
        this.sumBatchCount = sumBatchCount;
    }

    public BigDecimal getSumTaxCostAmount() {
        return sumTaxCostAmount;
    }

    public void setSumTaxCostAmount(BigDecimal sumTaxCostAmount) {
        this.sumTaxCostAmount = sumTaxCostAmount;
    }

    public BigDecimal getSumNotaxCostAmount() {
        return sumNotaxCostAmount;
    }

    public void setSumNotaxCostAmount(BigDecimal sumNotaxCostAmount) {
        this.sumNotaxCostAmount = sumNotaxCostAmount;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public String getJtName() {
        return jtName;
    }

    public void setJtName(String jtName) {
        this.jtName = jtName;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
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

    public String getOneComClass() {
        return oneComClass;
    }

    public void setOneComClass(String oneComClass) {
        this.oneComClass = oneComClass;
    }

    public String getTwoComClass() {
        return twoComClass;
    }

    public void setTwoComClass(String twoComClass) {
        this.twoComClass = twoComClass;
    }

    public String getThreeComClass() {
        return threeComClass;
    }

    public void setThreeComClass(String threeComClass) {
        this.threeComClass = threeComClass;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        BigDecimal b = new BigDecimal(batchCount);
        this.batchCount = b.toPlainString();
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(String notaxCost) {
        BigDecimal b = new BigDecimal(notaxCost);
        this.notaxCost = b.toPlainString();
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        BigDecimal b = new BigDecimal(taxCost);

        this.taxCost = b.toPlainString();
    }

    public String getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(String notaxCostAmount) {
        BigDecimal b = new BigDecimal(notaxCostAmount);
        this.notaxCostAmount = b.toPlainString();
    }

    public String getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(String taxCostAmount) {
        BigDecimal b = new BigDecimal(taxCostAmount);
        this.taxCostAmount = b.toPlainString();
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        BigDecimal b = new BigDecimal(saleprice);
        this.saleprice = b.toPlainString();
    }

    public String getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(String saleAmount) {
        BigDecimal b = new BigDecimal(saleAmount);
        this.saleAmount = b.toPlainString();
    }
}
