package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-01 22:58
 */
public class CaterDealFromVo implements Serializable {
    private static final long serialVersionUID = 4382799475270020458L;

    // 营业点名称
    private String gzoneName;
    // 交易单号
    private String cateNdealId;
    // 类型名称
    private String cateName;
    private String comboName; //套餐名称
    // 公司名称
    private String companyName;
    // 景区名称
    private String orgName;
    // 营业点编号
    private String gzoneCode;
    // 类型编号
    private String cateCode;

    // 类型条码
    private String cateBarcode;
    // 类型单位
    private String cateUnitName;

    // 类型规格
    private String cateSpec;

    // 一级分类名称
    private String cateClassNameOne;
    private String cateClassCode;

    // 一级分类编号
    private String cateClassCodeOne;

    // 二级分类名称
    private String cateClassNameTwo;

    // 二级分类编号
    private String cateClassCodeTwo;

    // 三级分类名称
    private String cateClassNameThree;

    // 三级分类编号
    private String cateClassCodeThree;

    // 是否为套餐
    private Integer isSetMeal;
    private BigDecimal pagecount = BigDecimal.ZERO; //套餐数量

    // 销售数量
    private BigDecimal cateNum = BigDecimal.ZERO;
    // 销售单价
    private BigDecimal salePrice = BigDecimal.ZERO;
    // 销售金额
    private BigDecimal money = BigDecimal.ZERO;
    // 扣点金额
    private BigDecimal deductionAmount = BigDecimal.ZERO;
    // 交易 时间
    private String createdTime;
    // 支付类型
    private String payName;
    // 付款方式
    private String cateRemark ;

    private String empName;

    private String nterminalName;






    private BigDecimal cateRatePrice = BigDecimal.ZERO;



    // 集团名称
    private String groupName;

    private String projectId;

    private String  sellModel;
    private String  spmodes;

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

    public BigDecimal getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(BigDecimal deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getSpmodes() {
        return spmodes;
    }

    public void setSpmodes(String spmodes) {
        this.spmodes = spmodes;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public BigDecimal getPagecount() {
        return pagecount;
    }

    public void setPagecount(BigDecimal pagecount) {
        this.pagecount = pagecount;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateBarcode() {
        return cateBarcode;
    }

    public void setCateBarcode(String cateBarcode) {
        this.cateBarcode = cateBarcode;
    }

    public String getCateUnitName() {
        return cateUnitName;
    }

    public void setCateUnitName(String cateUnitName) {
        this.cateUnitName = cateUnitName;
    }

    public String getCateSpec() {
        return cateSpec;
    }

    public void setCateSpec(String cateSpec) {
        this.cateSpec = cateSpec;
    }

    public String getCateClassNameOne() {
        return cateClassNameOne;
    }

    public void setCateClassNameOne(String cateClassNameOne) {
        this.cateClassNameOne = cateClassNameOne;
    }

    public String getCateClassCode() {
        return cateClassCode;
    }

    public void setCateClassCode(String cateClassCode) {
        this.cateClassCode = cateClassCode;
    }

    public String getCateClassCodeOne() {
        return cateClassCodeOne;
    }

    public void setCateClassCodeOne(String cateClassCodeOne) {
        this.cateClassCodeOne = cateClassCodeOne;
    }

    public String getCateClassNameTwo() {
        return cateClassNameTwo;
    }

    public void setCateClassNameTwo(String cateClassNameTwo) {
        this.cateClassNameTwo = cateClassNameTwo;
    }

    public String getCateClassCodeTwo() {
        return cateClassCodeTwo;
    }

    public void setCateClassCodeTwo(String cateClassCodeTwo) {
        this.cateClassCodeTwo = cateClassCodeTwo;
    }

    public String getCateClassNameThree() {
        return cateClassNameThree;
    }

    public void setCateClassNameThree(String cateClassNameThree) {
        this.cateClassNameThree = cateClassNameThree;
    }

    public String getCateClassCodeThree() {
        return cateClassCodeThree;
    }

    public void setCateClassCodeThree(String cateClassCodeThree) {
        this.cateClassCodeThree = cateClassCodeThree;
    }

    public Integer getIsSetMeal() {
        return isSetMeal;
    }

    public void setIsSetMeal(Integer isSetMeal) {
        this.isSetMeal = isSetMeal;
    }

    public BigDecimal getCateNum() {
        return cateNum;
    }

    public void setCateNum(BigDecimal cateNum) {
        this.cateNum = cateNum;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getCateRemark() {
        return cateRemark;
    }

    public void setCateRemark(String cateRemark) {
        this.cateRemark = cateRemark;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getNterminalName() {
        return nterminalName;
    }

    public void setNterminalName(String nterminalName) {
        this.nterminalName = nterminalName;
    }

    public BigDecimal getCateRatePrice() {
        return cateRatePrice;
    }

    public void setCateRatePrice(BigDecimal cateRatePrice) {
        this.cateRatePrice = cateRatePrice;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
