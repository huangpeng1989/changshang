package modelpojo.vo.cateioflow;

import java.io.Serializable;

/**
 * @program: phaseiiclota
 * @description: 商品流水明细表vo
 * @author: panda
 * @create: 2019-11-21 18:10
 **/
public class GetStockVo implements Serializable{

   private String whId;
   private String startDate;
   private String endDate;
   private String comName;
   private String comClass;
   private String inoutType;
   private String billCode;

   private String rowList;

   private String utilId;

    //如果类型是调拨出库，这个就要展示调入仓库，如果类型是调拨入库就要展示调出仓库
    private String inOutWhName;

    public String getInOutWhName() {
        return inOutWhName;
    }

    public void setInOutWhName(String inOutWhName) {
        this.inOutWhName = inOutWhName;
    }

    public String getUtilId() {
        return utilId;
    }

    public void setUtilId(String utilId) {
        this.utilId = utilId;
    }

    public String getWhId() {
        return whId;
    }

    public void setWhId(String whId) {
        this.whId = whId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComClass() {
        return comClass;
    }

    public void setComClass(String comClass) {
        this.comClass = comClass;
    }

    public String getInoutType() {
        return inoutType;
    }

    public void setInoutType(String inoutType) {
        this.inoutType = inoutType;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }
}
