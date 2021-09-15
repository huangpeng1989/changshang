package modelpojo.vo.saleadjust;

import excel.HeadProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 原材料进价调价Execl实体类
 * @Author wenbin.wang
 * @Date 2019-09-09 09:14
 */
public class CateringAdjusrExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*调价开始时间",type = HeadProperty.HeadType.DATE)
    private Date startDate;

    @HeadProperty(name="调价结束时间",type = HeadProperty.HeadType.DATE)
    private Date endDate;

    @HeadProperty(name="*供应商编号",type = HeadProperty.HeadType.STRING)
    private String suppCode;

    @HeadProperty(name="*供应商名称",type = HeadProperty.HeadType.STRING)
    private String suppName;

    @HeadProperty(name="*原材料编号",type = HeadProperty.HeadType.STRING)
    private String  rmCode;

    @HeadProperty(name="*原材料名称",type = HeadProperty.HeadType.STRING)
    private String  rmName;

    @HeadProperty(name="原材料规格",type = HeadProperty.HeadType.STRING)
    private String  sellModel;

    @HeadProperty(name="原材料单位",type = HeadProperty.HeadType.STRING)
    private String  unitName;

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

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
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

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }
}
