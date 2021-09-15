package modelpojo.vo.cateioflow;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: phaseiiclota
 * @description:
 * @author: panda
 * @create: 2019-11-15 17:38
 **/
public class CateIoflowSum implements Serializable {



    private String whName;//

    private String typeName;//

    private String ioNum;//

    private String taxCost;//

    private String taxCostAmount;//


    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIoNum() {
        return ioNum;
    }

    public void setIoNum(String ioNum) {
        this.ioNum = ioNum;
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        BigDecimal b = new BigDecimal(taxCost);
        this.taxCost = b.toPlainString();;
    }

    public String getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(String taxCostAmount) {
        BigDecimal b = new BigDecimal(taxCostAmount);
        this.taxCostAmount = b.toPlainString();;
    }
}
