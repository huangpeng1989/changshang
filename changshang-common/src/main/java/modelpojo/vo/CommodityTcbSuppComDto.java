package modelpojo.vo;


import modelpojo.model.CommodityTcbSuppcomModel;

import java.io.Serializable;

public class CommodityTcbSuppComDto extends CommodityTcbSuppcomModel implements Serializable {


   private String suppName;

   private String suppCode;

    private String contractSellModel;

    public String getContractSellModel() {
        return contractSellModel;
    }

    public void setContractSellModel(String contractSellModel) {
        this.contractSellModel = contractSellModel;
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
}
