package modelpojo.vo.commodityinfo;

import excel.HeadProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 商品进价调价Execl实体类
 * @Author lixiang
 * @Date 2020-08-20 09:14
 */
public class CommodityAdjustExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*调价开始时间",type = HeadProperty.HeadType.DATE)
    private Date startDate;

    @HeadProperty(name="调价结束时间",type = HeadProperty.HeadType.DATE)
    private Date endDate;

    @HeadProperty(name="*供应商编号",type = HeadProperty.HeadType.STRING)
    private String suppCode;

    @HeadProperty(name="*供应商名称",type = HeadProperty.HeadType.STRING)
    private String suppName;

    @HeadProperty(name="*商品编号",type = HeadProperty.HeadType.STRING)
    private String  comCode;

    @HeadProperty(name="*商品名称",type = HeadProperty.HeadType.STRING)
    private String  comName;

    @HeadProperty(name="商品规格",type = HeadProperty.HeadType.STRING)
    private String  comSpec;

    @HeadProperty(name="商品单位",type = HeadProperty.HeadType.STRING)
    private String  comUnitName;

    @HeadProperty(name="原采购含税进价",type = HeadProperty.HeadType.STRING)
    private String  purchaseTaxPaid;

    @HeadProperty(name="原含税进价",type = HeadProperty.HeadType.STRING)
    private String  taxPaid;

    @HeadProperty(name="*新采购含税进价",type = HeadProperty.HeadType.STRING)
    private String  newPurchaseTaxPaid;

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
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

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(String purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }

    public String getNewPurchaseTaxPaid() {
        return newPurchaseTaxPaid;
    }

    public void setNewPurchaseTaxPaid(String newPurchaseTaxPaid) {
        this.newPurchaseTaxPaid = newPurchaseTaxPaid;
    }
}
