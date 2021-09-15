package modelpojo.vo.rateAdjust;

import excel.HeadProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品扣率调整单EXECL实体类
 */
public class ComRateAdjustExeclVo implements Serializable {

    private static final long serialVersionUID = 2082646708014580453L;
    @HeadProperty(name="*调价开始时间",type = HeadProperty.HeadType.DATE)
    private Date startDate;

    @HeadProperty(name="*供应商编号",type = HeadProperty.HeadType.STRING)
    private String suppCode;

    @HeadProperty(name="*供应商名称",type = HeadProperty.HeadType.STRING)
    private String suppName;

    @HeadProperty(name="*商品编号",type = HeadProperty.HeadType.STRING)
    private String  comCode;

    @HeadProperty(name="*商品名称",type = HeadProperty.HeadType.STRING)
    private String  comName;

    @HeadProperty(name="原联营扣率",type = HeadProperty.HeadType.STRING)
    private String oldDiscountRate;

    @HeadProperty(name="*新联营扣率",type = HeadProperty.HeadType.STRING)
    private String newDiscountRate;

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
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
