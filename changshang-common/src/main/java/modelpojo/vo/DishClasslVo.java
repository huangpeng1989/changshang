package modelpojo.vo;

import excel.HeadProperty;

import java.io.Serializable;

/**
 * @Description 菜品分类Execl实体类
 * @Author lixiang
 * @Date 2020-09-15 15:14
 */
public class DishClasslVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="一级分类",type = HeadProperty.HeadType.STRING)
    private String firstClassName;

    @HeadProperty(name="一级税务编码",type = HeadProperty.HeadType.STRING)
    private String firstTaxCode;

    @HeadProperty(name="二级分类",type = HeadProperty.HeadType.STRING)
    private String secondClassName;

    @HeadProperty(name="二级税务编码",type = HeadProperty.HeadType.STRING)
    private String secondTaxCode;


    @HeadProperty(name="三级分类",type = HeadProperty.HeadType.STRING)
    private String threeClassName;

    @HeadProperty(name="三级税务编码",type = HeadProperty.HeadType.STRING)
    private String threeTaxCode;


    public String getFirstClassName() {
        return firstClassName;
    }

    public void setFirstClassName(String firstClassName) {
        this.firstClassName = firstClassName;
    }

    public String getSecondClassName() {
        return secondClassName;
    }

    public void setSecondClassName(String secondClassName) {
        this.secondClassName = secondClassName;
    }

    public String getThreeClassName() {
        return threeClassName;
    }

    public void setThreeClassName(String threeClassName) {
        this.threeClassName = threeClassName;
    }

    public String getFirstTaxCode() {
        return firstTaxCode;
    }

    public void setFirstTaxCode(String firstTaxCode) {
        this.firstTaxCode = firstTaxCode;
    }

    public String getSecondTaxCode() {
        return secondTaxCode;
    }

    public void setSecondTaxCode(String secondTaxCode) {
        this.secondTaxCode = secondTaxCode;
    }

    public String getThreeTaxCode() {
        return threeTaxCode;
    }

    public void setThreeTaxCode(String threeTaxCode) {
        this.threeTaxCode = threeTaxCode;
    }
}
