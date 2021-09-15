package modelpojo.vo;


import modelpojo.model.CateringWhInAcpt;
import modelpojo.model.CateringWhInAcptDtl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-10-04 11:41
 */
public class CateringWhInAcptVo extends CateringWhInAcpt {

    private List<CateringWhInAcptDtl> whInAcptDtlList;
    private String statusStr;
    private String inWhName;
    private String suppName;
    private String billType;
    private String billTypeStr;
    private String accepterStr;
    private String createrStr;
    private String blEmpName;
    private String paymentName;
    private String billBarImgUrl;
    private Integer caterStatus;
    private Integer ivtStatus;
    private String whStockUnitName;  //库存的最小原材料单位名称
    private String srmUnitName;  //原材料包装单位名称
    private BigDecimal oGPageCount = BigDecimal.ZERO;  //验收数量
    private BigDecimal orderCount = BigDecimal.ZERO;  //退货数量
    private String rmName;  // 原材料名称
    private String rmBarcode;  //原材料包装条形码
    private BigDecimal whStock = BigDecimal.ZERO;  //库存数量

    private Integer jurisdictionType = 0;//权限类型

    private Integer whId;

    private Date ssbltStartTime;

    private Date ssbltEndTime;

    public Date getSsbltStartTime() {
        return ssbltStartTime;
    }

    public void setSsbltStartTime(Date ssbltStartTime) {
        this.ssbltStartTime = ssbltStartTime;
    }

    public Date getSsbltEndTime() {
        return ssbltEndTime;
    }

    public void setSsbltEndTime(Date ssbltEndTime) {
        this.ssbltEndTime = ssbltEndTime;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public Integer getCaterStatus() {
        return caterStatus;
    }

    public void setCaterStatus(Integer caterStatus) {
        this.caterStatus = caterStatus;
    }

    public Integer getIvtStatus() {
        return ivtStatus;
    }

    public void setIvtStatus(Integer ivtStatus) {
        this.ivtStatus = ivtStatus;
    }

    public String getBillBarImgUrl() {
        return billBarImgUrl;
    }

    public void setBillBarImgUrl(String billBarImgUrl) {
        this.billBarImgUrl = billBarImgUrl;
    }

    public String getBlEmpName() {
        return blEmpName;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public void setBlEmpName(String blEmpName) {
        this.blEmpName = blEmpName;
    }

    public String getWhStockUnitName() {
        return whStockUnitName;
    }

    public void setWhStockUnitName(String whStockUnitName) {
        this.whStockUnitName = whStockUnitName;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public BigDecimal getoGPageCount() {
        return oGPageCount;
    }

    public void setoGPageCount(BigDecimal oGPageCount) {
        this.oGPageCount = oGPageCount;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }











    public List<CateringWhInAcptDtl> getWhInAcptDtlList() {
        return whInAcptDtlList;
    }

    public void setWhInAcptDtlList(List<CateringWhInAcptDtl> whInAcptDtlList) {
        this.whInAcptDtlList = whInAcptDtlList;
    }

    public String getInWhName() {
        return inWhName;
    }

    public void setInWhName(String inWhName) {
        this.inWhName = inWhName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getWhinEndDate() {
        return whinEndDate;
    }

    public void setWhinEndDate(String whinEndDate) {
        this.whinEndDate = whinEndDate;
    }

    private String whinEndDate;  //入库截至日期

    public String getBillTypeStr() {
        return billTypeStr;
    }

    public void setBillTypeStr(String billTypeStr) {
        this.billTypeStr = billTypeStr;
    }

    public String getAccepterStr() {
        return accepterStr;
    }

    public void setAccepterStr(String accepterStr) {
        this.accepterStr = accepterStr;
    }

    public String getCreaterStr() {
        return createrStr;
    }
    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }


    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }


}
