package modelpojo.vo.saledDish;

import java.io.Serializable;

/**
 * 供应商表
 */
public class SaleCommVo implements Serializable {


    private String comName;//商品名称

    private String comClassCode;//商品名称

    private String sellModel;//经营方式

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }
}