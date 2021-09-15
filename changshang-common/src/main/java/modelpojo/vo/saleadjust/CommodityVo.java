package modelpojo.vo.saleadjust;

import java.io.Serializable;
import java.math.BigDecimal;

/****
 * 商品信息vo对象
 */
public class CommodityVo implements Serializable {

    //项目ID
    private Long projectId;
    //供应商ID
    private Integer suppId;
    //商品ID
    private Integer comId;
    //商品编号
    private String comCode;

    public String getPhTax() {
        return phTax;
    }

    public void setPhTax(String phTax) {
        this.phTax = phTax;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    private String phTax;
    private Integer phTaxId;

    //销售商品id
    private Integer saleComId;
    //商品名称
    private String comName;
    //含税进价
    private BigDecimal taxPaid;

    //未含税进价
    private BigDecimal noTaxPaid;

    //供应商编号
    private String suppCode;
    //供应商名称
    private String suppName;
    //经销方式id
    private Integer busMode;

    //经营方式名称
    private String busModelName;
    //原毛利率
    private BigDecimal oGroMargin;
    //商品零售价旧
    private BigDecimal retailPrice;


    //销售商品编号
    private String saleComCode;

    //价格等级id
    private Integer gradeId;
    //价格等级
    private String gradeName;
    //商品条码
    private String comBarcode;

    //销售商品单位
    private String commUnit;

    //销售商品单位名称
    private String commUnitName;

    //规格
    private String comSpec;

    //价格配置表id
    private Integer gpId;

    private String billid;

    private String billcode;

    private BigDecimal purchaseTaxPaid;//采购含税进价

    private BigDecimal purchaseNoTaxPaid;//采购未税进价

    private BigDecimal packContent;//包装含量

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public BigDecimal getPurchaseNoTaxPaid() {
        return purchaseNoTaxPaid;
    }

    public void setPurchaseNoTaxPaid(BigDecimal purchaseNoTaxPaid) {
        this.purchaseNoTaxPaid = purchaseNoTaxPaid;
    }

    public BigDecimal getPurchaseTaxPaid() {
        return purchaseTaxPaid;
    }

    public void setPurchaseTaxPaid(BigDecimal purchaseTaxPaid) {
        this.purchaseTaxPaid = purchaseTaxPaid;
    }

    public Integer getSupComId() {
        return supComId;
    }

    public void setSupComId(Integer supComId) {
        this.supComId = supComId;
    }

    private Integer supComId;

    private BigDecimal maxRetailPrice;
    private BigDecimal minRetailPrice;
    private String maxGrossInterestRate;
    private String minGrossInterestRate;

    private Integer busModel;

    private String taxName;  //税率名称

    public String getCommUnitName() {
        return commUnitName;
    }

    public void setCommUnitName(String commUnitName) {
        this.commUnitName = commUnitName;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public Integer getBusModel() {
        return busModel;
    }

    public void setBusModel(Integer busModel) {
        this.busModel = busModel;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    private String createdTime;

    public BigDecimal getoGroMargin() {
        return oGroMargin;
    }

    public void setoGroMargin(BigDecimal oGroMargin) {
        this.oGroMargin = oGroMargin;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }


    public String getCommUnit() {
        return commUnit;
    }

    public void setCommUnit(String commUnit) {
        this.commUnit = commUnit;
    }

    public BigDecimal getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(BigDecimal maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public BigDecimal getMinRetailPrice() {
        return minRetailPrice;
    }

    public void setMinRetailPrice(BigDecimal minRetailPrice) {
        this.minRetailPrice = minRetailPrice;
    }

    public String getMaxGrossInterestRate() {
        return maxGrossInterestRate;
    }

    public void setMaxGrossInterestRate(String maxGrossInterestRate) {
        this.maxGrossInterestRate = maxGrossInterestRate;
    }

    public String getMinGrossInterestRate() {
        return minGrossInterestRate;
    }

    public void setMinGrossInterestRate(String minGrossInterestRate) {
        this.minGrossInterestRate = minGrossInterestRate;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }



    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }


    public String getBusModelName() {
        return busModelName;
    }

    public void setBusModelName(String busModelName) {
        this.busModelName = busModelName;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public Integer getBusMode() {
        return busMode;
    }

    public void setBusMode(Integer busMode) {
        this.busMode = busMode;
    }

    public BigDecimal getOGroMargin() {
        return oGroMargin;
    }

    public void setOGroMargin(BigDecimal OGroMargin) {
        this.oGroMargin = OGroMargin;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }



    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }


}
