package modelpojo.vo.commodityinfo;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * 商品供应商Execl实体类
 */
public class CommSuppExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;

    @HeadProperty(name="*商品编号",type = HeadProperty.HeadType.STRING)
    private String comCode;

    @HeadProperty(name="*合同编号",type = HeadProperty.HeadType.STRING)
    private String contractCode;

    @HeadProperty(name="*进项税税率",type = HeadProperty.HeadType.STRING)
    private String  phTaxId;

    @HeadProperty(name="*采购含税进价",type = HeadProperty.HeadType.STRING)
    private String purchaseTaxPaid;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(String phTaxId) {
        this.phTaxId = phTaxId;
    }

    public String getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(String purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }
}
