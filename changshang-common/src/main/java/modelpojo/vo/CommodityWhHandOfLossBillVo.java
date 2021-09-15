package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 商品报损/溢报表
 * @Author wenbin.wang
 * @Date 2019-09-17 16:53
 */
public class CommodityWhHandOfLossBillVo implements Serializable {
    private static final long serialVersionUID = -6771418453217318150L;

    // 景区名称
    private String orgName;

    // 集团名称
    private String groupName;

    // 仓库名称
    private String whName;

    // 商品名称
    private String comName;

    // 公司名称
    private String companyName;

    // 仓库编号
    private String whCode;

    // 损溢类型
    private String billTypeName;

    // 损溢单号
    private String billCode;

    // 时间
    private String createdTime;

    // 商品编号
    private String commCode;

    // 商品条码
    private String comBarcode;

    // 商品规格
    private String commSpec;

    // 商品单位名称
    private String commUnitName;

    // 商品类型 正常商品 0否 1是
    private Integer comType;

    // 商品类型 大类商品  0否 1是
    private Integer comType2;

    // 称重商品  0否 1是
    private Integer comType3;

    // 原材料  0否 1是
    private Integer comType4;

    // 赠品  0否 1是
    private Integer comType5;

    // 办公用品  0否 1是
    private Integer comType6;

    // 办公设备  0否 1是
    private Integer comType7;

    // 商品类型8  0否 1是
    private Integer comType8;

    //商品类型9  0否 1是
    private Integer comType9;

    // 商品类型10  0否 1是
    private Integer comType10;

    // 商品类型11  0否 1是
    private Integer comType11;

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

    // 损溢数量
    private BigDecimal plCount = BigDecimal.ZERO;

    // 含税损溢金额
    private BigDecimal taxCostAmount = BigDecimal.ZERO;

    // 未税损溢金额
    private BigDecimal notaxCostAmount = BigDecimal.ZERO;

    // 进项税税率名称
    private String taxName;

    // 含税成本价
    private BigDecimal taxCost = BigDecimal.ZERO;


    // 未税成本价
    private BigDecimal noTaxCost = BigDecimal.ZERO;

    private Integer billId;

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
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

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
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

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
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

    public Integer getComType() {
        return comType;
    }

    public void setComType(Integer comType) {
        this.comType = comType;
    }

    public Integer getComType2() {
        return comType2;
    }

    public void setComType2(Integer comType2) {
        this.comType2 = comType2;
    }

    public Integer getComType3() {
        return comType3;
    }

    public void setComType3(Integer comType3) {
        this.comType3 = comType3;
    }

    public Integer getComType4() {
        return comType4;
    }

    public void setComType4(Integer comType4) {
        this.comType4 = comType4;
    }

    public Integer getComType5() {
        return comType5;
    }

    public void setComType5(Integer comType5) {
        this.comType5 = comType5;
    }

    public Integer getComType6() {
        return comType6;
    }

    public void setComType6(Integer comType6) {
        this.comType6 = comType6;
    }

    public Integer getComType7() {
        return comType7;
    }

    public void setComType7(Integer comType7) {
        this.comType7 = comType7;
    }

    public Integer getComType8() {
        return comType8;
    }

    public void setComType8(Integer comType8) {
        this.comType8 = comType8;
    }

    public Integer getComType9() {
        return comType9;
    }

    public void setComType9(Integer comType9) {
        this.comType9 = comType9;
    }

    public Integer getComType10() {
        return comType10;
    }

    public void setComType10(Integer comType10) {
        this.comType10 = comType10;
    }

    public Integer getComType11() {
        return comType11;
    }

    public void setComType11(Integer comType11) {
        this.comType11 = comType11;
    }

    public String getComClassNameOne() {
        return comClassNameOne;
    }

    public void setComClassNameOne(String comClassNameOne) {
        this.comClassNameOne = comClassNameOne;
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

    public BigDecimal getPlCount() {
        return plCount;
    }

    public void setPlCount(BigDecimal plCount) {
        this.plCount = plCount;
    }

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

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNoTaxCost() {
        return noTaxCost;
    }

    public void setNoTaxCost(BigDecimal noTaxCost) {
        this.noTaxCost = noTaxCost;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }



}
