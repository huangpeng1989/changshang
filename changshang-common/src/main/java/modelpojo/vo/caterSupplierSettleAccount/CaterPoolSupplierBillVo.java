package modelpojo.vo.caterSupplierSettleAccount;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-16 10:03
 */
public class CaterPoolSupplierBillVo implements Serializable {


    private static final long serialVersionUID = 2985222051142081382L;


    private String suppCode;   //供应商编号
    private String suppName;   //供应商名称
    private String dishCode;   //菜品编号
    private String dishName;   //菜品名称
    private String dishSpecName;   //菜品规格
    private String dishUnitName;   //菜品单位
    private String dishClassNameOne;   //菜品一级分类名称
    private String dishClassCodeOne;   //菜品一级分类编号
    private String dishClassNameTwo;   //菜品一级分类名称
    private String dishClassCodeTwo;   //菜品一级分类编号
    private String dishClassNameThree;   //菜品三级分类名称
    private String dishClassCodeThree;   //菜品三级分类编号
    private String dishClassCode;   //菜品三级分类编号
    private BigDecimal sumCateNum = BigDecimal.ZERO;   //销售总数量
    private BigDecimal cateAmount = BigDecimal.ZERO;  //含税销售总金额
    private BigDecimal noCateAmount = BigDecimal.ZERO;  //未税销售总金额
    private String tieupsTaxName;  //联营折扣率

    private BigDecimal tieupsAmount = BigDecimal.ZERO;   //含税扣点总金额
    private BigDecimal tieupsNotaxAmount = BigDecimal.ZERO;   //未税扣点总金额


    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
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

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishSpecName() {
        return dishSpecName;
    }

    public void setDishSpecName(String dishSpecName) {
        this.dishSpecName = dishSpecName;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public String getDishClassNameOne() {
        return dishClassNameOne;
    }

    public void setDishClassNameOne(String dishClassNameOne) {
        this.dishClassNameOne = dishClassNameOne;
    }

    public String getDishClassCodeOne() {
        return dishClassCodeOne;
    }

    public void setDishClassCodeOne(String dishClassCodeOne) {
        this.dishClassCodeOne = dishClassCodeOne;
    }

    public String getDishClassNameTwo() {
        return dishClassNameTwo;
    }

    public void setDishClassNameTwo(String dishClassNameTwo) {
        this.dishClassNameTwo = dishClassNameTwo;
    }

    public String getDishClassCodeTwo() {
        return dishClassCodeTwo;
    }

    public void setDishClassCodeTwo(String dishClassCodeTwo) {
        this.dishClassCodeTwo = dishClassCodeTwo;
    }

    public String getDishClassNameThree() {
        return dishClassNameThree;
    }

    public void setDishClassNameThree(String dishClassNameThree) {
        this.dishClassNameThree = dishClassNameThree;
    }

    public String getDishClassCodeThree() {
        return dishClassCodeThree;
    }

    public void setDishClassCodeThree(String dishClassCodeThree) {
        this.dishClassCodeThree = dishClassCodeThree;
    }

    public BigDecimal getSumCateNum() {
        return sumCateNum;
    }

    public void setSumCateNum(BigDecimal sumCateNum) {
        this.sumCateNum = sumCateNum;
    }

    public BigDecimal getCateAmount() {
        return cateAmount;
    }

    public void setCateAmount(BigDecimal cateAmount) {
        this.cateAmount = cateAmount;
    }

    public BigDecimal getNoCateAmount() {
        return noCateAmount;
    }

    public void setNoCateAmount(BigDecimal noCateAmount) {
        this.noCateAmount = noCateAmount;
    }

    public String getTieupsTaxName() {
        return tieupsTaxName;
    }

    public void setTieupsTaxName(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
    }

    public String getTieupsTaxNamet() {
        return tieupsTaxName;
    }

    public void setTieupsTaxNamet(String tieupsTaxName) {
        this.tieupsTaxName = tieupsTaxName;
    }

    public BigDecimal getTieupsAmount() {
        return tieupsAmount;
    }

    public void setTieupsAmount(BigDecimal tieupsAmount) {
        this.tieupsAmount = tieupsAmount;
    }

    public BigDecimal getTieupsNotaxAmount() {
        return tieupsNotaxAmount;
    }

    public void setTieupsNotaxAmount(BigDecimal tieupsNotaxAmount) {
        this.tieupsNotaxAmount = tieupsNotaxAmount;
    }
}
