package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description c餐饮-库存损溢
 * @Author wenbin.wang
 * @Date 2019-11-14 15:00
 */
public class CateringLossBillVo implements Serializable {
    private static final long serialVersionUID = -2777853387810067337L;


    // 景区名称
    private String orgName;

    // 仓库名称
    private String whName;

    // 数据类型  11002 半成品 11004 原材料
    private Integer goodType;

    // 类型名称
    private String rmName;

    // 集团名称
    private String groupName;

    // 公司名称
    private String companyName;

    // 仓库编号
    private String whCode;

    // 损溢类型
    private String billTypeName;

    // 损溢编号
    private String billCode;

    // 创建时间
    private String createdTime;

    // 类型条码
    private String rmBarcode;
    // 原材料规格
    private String sellModel;

    // 原材料单位名称
    private String rmUnitName;

    // 特殊原材料类型（字典存储）常温	0否 1是
    private Integer specRmType;

    //冷冻0否 1是
    private Integer specRmType2;
    //生鲜0否 1是
    private Integer specRmType3;
    //辅料	0否 1是
    private Integer specRmType4;
    //特殊原材料类型5	0否 1是
    private Integer specRmType5;
    //特殊原材料类型60否 1是
    private Integer specRmType6;
    //特殊原材料类型70否 1是
    private Integer specRmType7;
    //特殊原材料类型80否 1是
    private Integer specRmType8;

    // 原材料一级分类名称
    private String rmClassNameOne;
    private String rmClassCode;

    // 原材料一级分类编号
    private String rmClassCodeOne;

    // 原材料二级分类名称
    private String rmClassNameTwo;

    // 原材料二级分类编号
    private String rmClassCodeTwo;

    // 原材料三级分类名称
    private String rmClassNameThree;

    // 原材料三级分类编号
    private String rmClassCodeThree;

    // 类型编码
    private String rmCode;

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

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public Integer getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(Integer specRmType) {
        this.specRmType = specRmType;
    }

    public Integer getSpecRmType2() {
        return specRmType2;
    }

    public void setSpecRmType2(Integer specRmType2) {
        this.specRmType2 = specRmType2;
    }

    public Integer getSpecRmType3() {
        return specRmType3;
    }

    public void setSpecRmType3(Integer specRmType3) {
        this.specRmType3 = specRmType3;
    }

    public Integer getSpecRmType4() {
        return specRmType4;
    }

    public void setSpecRmType4(Integer specRmType4) {
        this.specRmType4 = specRmType4;
    }

    public Integer getSpecRmType5() {
        return specRmType5;
    }

    public void setSpecRmType5(Integer specRmType5) {
        this.specRmType5 = specRmType5;
    }

    public Integer getSpecRmType6() {
        return specRmType6;
    }

    public void setSpecRmType6(Integer specRmType6) {
        this.specRmType6 = specRmType6;
    }

    public Integer getSpecRmType7() {
        return specRmType7;
    }

    public void setSpecRmType7(Integer specRmType7) {
        this.specRmType7 = specRmType7;
    }

    public Integer getSpecRmType8() {
        return specRmType8;
    }

    public void setSpecRmType8(Integer specRmType8) {
        this.specRmType8 = specRmType8;
    }

    public String getRmClassNameOne() {
        return rmClassNameOne;
    }

    public void setRmClassNameOne(String rmClassNameOne) {
        this.rmClassNameOne = rmClassNameOne;
    }

    public String getRmClassCodeOne() {
        return rmClassCodeOne;
    }

    public void setRmClassCodeOne(String rmClassCodeOne) {
        this.rmClassCodeOne = rmClassCodeOne;
    }

    public String getRmClassNameTwo() {
        return rmClassNameTwo;
    }

    public void setRmClassNameTwo(String rmClassNameTwo) {
        this.rmClassNameTwo = rmClassNameTwo;
    }

    public String getRmClassCodeTwo() {
        return rmClassCodeTwo;
    }

    public void setRmClassCodeTwo(String rmClassCodeTwo) {
        this.rmClassCodeTwo = rmClassCodeTwo;
    }

    public String getRmClassNameThree() {
        return rmClassNameThree;
    }

    public void setRmClassNameThree(String rmClassNameThree) {
        this.rmClassNameThree = rmClassNameThree;
    }

    public String getRmClassCodeThree() {
        return rmClassCodeThree;
    }

    public void setRmClassCodeThree(String rmClassCodeThree) {
        this.rmClassCodeThree = rmClassCodeThree;
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
}
