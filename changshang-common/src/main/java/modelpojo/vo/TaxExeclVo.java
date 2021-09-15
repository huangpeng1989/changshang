package modelpojo.vo;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-24 16:55
 */
public class TaxExeclVo implements Serializable {
    private static final long serialVersionUID = 1772856296519549213L;

    @HeadProperty(name="*税率",type = HeadProperty.HeadType.STRING)
    private String taxName;


    @HeadProperty(name="*含税转未税比率",type = HeadProperty.HeadType.STRING)
    private String conToFreeTax;

    @HeadProperty(name="*未税转含税比率",type = HeadProperty.HeadType.STRING)
    private String freeToConTax;

    @HeadProperty(name="*含税转未税保留小数点位数",type = HeadProperty.HeadType.STRING)
    private String  conToFreeNum;



    @HeadProperty(name="*未税转含税保留小数点位数",type = HeadProperty.HeadType.STRING)
    private String  freeToConNum;


    @HeadProperty(name="*是否启用",type = HeadProperty.HeadType.STRING)
    private String  tStatusStr;


    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getConToFreeTax() {
        return conToFreeTax;
    }

    public void setConToFreeTax(String conToFreeTax) {
        this.conToFreeTax = conToFreeTax;
    }

    public String getFreeToConTax() {
        return freeToConTax;
    }

    public void setFreeToConTax(String freeToConTax) {
        this.freeToConTax = freeToConTax;
    }

    public String getConToFreeNum() {
        return conToFreeNum;
    }

    public void setConToFreeNum(String conToFreeNum) {
        this.conToFreeNum = conToFreeNum;
    }

    public String getFreeToConNum() {
        return freeToConNum;
    }

    public void setFreeToConNum(String freeToConNum) {
        this.freeToConNum = freeToConNum;
    }

    public String gettStatusStr() {
        return tStatusStr;
    }

    public void settStatusStr(String tStatusStr) {
        this.tStatusStr = tStatusStr;
    }



}
