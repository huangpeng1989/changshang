package modelpojo.vo.rateAdjust;


import excel.HeadProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品扣率调整单EXECL实体类
 */
public class DishRateAdjustExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*调价开始时间",type = HeadProperty.HeadType.DATE)
    private Date startDate;

    @HeadProperty(name="*供应商编号",type = HeadProperty.HeadType.STRING)
    private String suppCode;

    @HeadProperty(name="*供应商名称",type = HeadProperty.HeadType.STRING)
    private String suppName;

    @HeadProperty(name="*菜品编号",type = HeadProperty.HeadType.STRING)
    private String  dishCode;

    @HeadProperty(name="*菜品名称",type = HeadProperty.HeadType.STRING)
    private String  dishName;

    @HeadProperty(name="原联营扣率",type = HeadProperty.HeadType.STRING)
    private String oldDiscountRate;

    @HeadProperty(name="*新联营扣率",type = HeadProperty.HeadType.STRING)
    private String newDiscountRate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public String getOldDiscountRate() {
        return oldDiscountRate;
    }

    public void setOldDiscountRate(String oldDiscountRate) {
        this.oldDiscountRate = oldDiscountRate;
    }

    public String getNewDiscountRate() {
        return newDiscountRate;
    }

    public void setNewDiscountRate(String newDiscountRate) {
        this.newDiscountRate = newDiscountRate;
    }
}
