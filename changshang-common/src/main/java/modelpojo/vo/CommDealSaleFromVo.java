package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 商品销售报表返回数据
 * @Author wenbin.wang
 * @Date 2019-12-01 17:42
 */
public class CommDealSaleFromVo implements Serializable {
    private static final long serialVersionUID = 9008123896089673806L;

    // 景区名称
    private String orgName;
    private String payName;
    private String suppName;

    // 集团名称
    private String groupName;
    private String projectId;
    // 商品名称
    private String comName;
    private String comCode;

    // 公司名称
    private String companyName;
    // 时间
    private String createdTime;


    // 商品条码
    private String comBarcode;

    // 商品规格
    private String commSpec;

    // 商品单位名称
    private String commUnitName;

    // 商品一级分类名称
    private String comClassNameOne;
    private String comClassCode;

    // 商品一级分类编号
    private String comClassCodeOne;

    // 商品二级分类名称
    private String comClassNameTwo;

    // 商品二级分类编号
    private String comClassCodeTwo;

    // 商品三级分类名称
    private String comClassNameThree;

    // 商品三级分类编号
    private String comClassCodeThree;

    // 经营方式
    private String sellModel;

    private String gzoneName;
    private String gzoneCode;
    private String comNdealId;
    private Integer isBind;
    private Integer bindComId;
    private BigDecimal comNum = BigDecimal.ZERO;
    private BigDecimal salePrice = BigDecimal.ZERO;
    private BigDecimal money = BigDecimal.ZERO;
    private BigDecimal notaxMoney = BigDecimal.ZERO;
    private BigDecimal taxMoney = BigDecimal.ZERO;
    private BigDecimal tieupsAmount = BigDecimal.ZERO;
    private String comRemark ;
    private BigDecimal comRatePrice = BigDecimal.ZERO;
    private String nterminalName;
    private String empName;
    private String tieupsTaxName;
    private String spmodes;  //付款方式内容

    private BigDecimal taxCostAmount;

    private BigDecimal notaxCostAmount;

    public BigDecimal getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(BigDecimal taxCostAmount) {
        this.taxCostAmount = taxCostAmount;
    }

    public BigDecimal getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
        this.notaxCostAmount = notaxCostAmount;
    }

    public String getSpmodes() {
        return spmodes;
    }

    public void setSpmodes(String spmodes) {
        this.spmodes = spmodes;
    }

    public String getTieupsTaxName() {
        return tieupsTaxName;
    }

    public void setTieupsTaxName(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public BigDecimal getNotaxMoney() {
        return notaxMoney;
    }

    public void setNotaxMoney(BigDecimal notaxMoney) {
        this.notaxMoney = notaxMoney;
    }

    public BigDecimal getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(BigDecimal taxMoney) {
        this.taxMoney = taxMoney;
    }

    private BigDecimal pagecount = BigDecimal.ZERO; //套餐数量

    public Integer getBindComId() {
        return bindComId;
    }

    public void setBindComId(Integer bindComId) {
        this.bindComId = bindComId;
    }

    public BigDecimal getPagecount() {
        return pagecount;
    }

    public void setPagecount(BigDecimal pagecount) {
        this.pagecount = pagecount;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }


    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public String getCommUnitName() {
        return commUnitName;
    }

    public void setCommUnitName(String commUnitName) {
        this.commUnitName = commUnitName;
    }

    public String getComClassNameOne() {
        return comClassNameOne;
    }

    public void setComClassNameOne(String comClassNameOne) {
        this.comClassNameOne = comClassNameOne;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComClassCodeOne() {
        return comClassCodeOne;
    }

    public void setComClassCodeOne(String comClassCodeOne) {
        this.comClassCodeOne = comClassCodeOne;
    }

    public String getComClassNameTwo() {
        return comClassNameTwo;
    }

    public void setComClassNameTwo(String comClassNameTwo) {
        this.comClassNameTwo = comClassNameTwo;
    }

    public String getComClassCodeTwo() {
        return comClassCodeTwo;
    }

    public void setComClassCodeTwo(String comClassCodeTwo) {
        this.comClassCodeTwo = comClassCodeTwo;
    }

    public String getComClassNameThree() {
        return comClassNameThree;
    }

    public void setComClassNameThree(String comClassNameThree) {
        this.comClassNameThree = comClassNameThree;
    }

    public String getComClassCodeThree() {
        return comClassCodeThree;
    }

    public void setComClassCodeThree(String comClassCodeThree) {
        this.comClassCodeThree = comClassCodeThree;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId;
    }

    public Integer getIsBind() {
        return isBind;
    }

    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }

    public BigDecimal getComNum() {
        return comNum;
    }

    public void setComNum(BigDecimal comNum) {
        this.comNum = comNum;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }

    public String getComRemark() {
        return comRemark;
    }

    public void setComRemark(String comRemark) {
        this.comRemark = comRemark;
    }

    public BigDecimal getComRatePrice() {
        return comRatePrice;
    }

    public void setComRatePrice(BigDecimal comRatePrice) {
        this.comRatePrice = comRatePrice;
    }

    public String getNterminalName() {
        return nterminalName;
    }

    public void setNterminalName(String nterminalName) {
        this.nterminalName = nterminalName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
