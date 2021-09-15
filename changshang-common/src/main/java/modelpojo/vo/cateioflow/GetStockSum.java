package modelpojo.vo.cateioflow;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: phaseiiclota
 * @description: 商品流水总汇表
 * @author: panda
 * @create: 2019-11-21 18:10
 **/
public class GetStockSum implements Serializable{

    private String whName;
    private String billTypeName;
    private String whCount;
    private String batchCount;
    private String taxCost;
    private String taxCostAmount;


    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
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

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        BigDecimal b = new BigDecimal(batchCount);
        this.batchCount = b.toPlainString();
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        BigDecimal b = new BigDecimal(taxCost);
        this.taxCost = b.toPlainString();
    }

    public String getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(String taxCostAmount) {
        BigDecimal b = new BigDecimal(taxCostAmount);
        this.taxCostAmount = b.toPlainString();
    }
}
