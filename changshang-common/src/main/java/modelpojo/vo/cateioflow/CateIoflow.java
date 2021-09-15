package modelpojo.vo.cateioflow;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: phaseiiclota
 * @description:
 * @author: panda
 * @create: 2019-11-15 17:38
 **/
public class CateIoflow implements Serializable {
    private String congName;//集团名称

    private String companyName;//
    private String parkName;//
    private String whCode;//
    private String goodsType;//
    private String name;//
    private String code;//
    private String suppName;//
    private String suppCode;//
    private String batchDate;//
    private String typeName;//
    private String billCode;//
    private String batchCount;//
    private String price;//
    private String taxName;//
    private String saleAmt;//
    private String sellModel;//
    private String typeName1;//
    private String oneClass;//
    private String twoClass;//
    private String threeClass;//
    private String taxCost;//
    private String notaxCost;//
    private String taxCostAmount;//
    private String notaxCostAmount;//


    private String whName;//


    private String ioNum;//

    //如果类型是调拨出库，这个就要展示调入仓库，如果类型是调拨入库就要展示调出仓库
    private String inOutWhName;

    public String getInOutWhName() {
        return inOutWhName;
    }

    public void setInOutWhName(String inOutWhName) {
        this.inOutWhName = inOutWhName;
    }



    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }


    public String getIoNum() {
        return ioNum;
    }

    public void setIoNum(String ioNum) {
        this.ioNum = ioNum;
    }


    public String getCongName() {
        return congName;
    }

    public void setCongName(String congName) {
        this.congName = congName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }


    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }


    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getSaleAmt() {
        return saleAmt;
    }

    public void setSaleAmt(String saleAmt) {
        this.saleAmt = saleAmt;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getTypeName1() {
        return typeName1;
    }

    public void setTypeName1(String typeName1) {
        this.typeName1 = typeName1;
    }

    public String getOneClass() {
        return oneClass;
    }

    public void setOneClass(String oneClass) {
        this.oneClass = oneClass;
    }

    public String getTwoClass() {
        return twoClass;
    }

    public void setTwoClass(String twoClass) {
        this.twoClass = twoClass;
    }

    public String getThreeClass() {
        return threeClass;
    }

    public void setThreeClass(String threeClass) {
        this.threeClass = threeClass;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        BigDecimal b = new BigDecimal(batchCount);
        this.batchCount = b.toPlainString();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        BigDecimal b = new BigDecimal(price);
        this.price = b.toPlainString();
    }

    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        BigDecimal b = new BigDecimal(taxCost);
        this.taxCost = b.toPlainString();
    }

    public String getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(String notaxCost) {
        BigDecimal b = new BigDecimal(notaxCost);

        this.notaxCost = b.toPlainString();
    }

    public String getTaxCostAmount() {
        return taxCostAmount;
    }

    public void setTaxCostAmount(String taxCostAmount) {
        BigDecimal b = new BigDecimal(taxCostAmount);
        this.taxCostAmount = b.toPlainString();
    }

    public String getNotaxCostAmount() {
        return notaxCostAmount;
    }

    public void setNotaxCostAmount(String notaxCostAmount) {
        BigDecimal b = new BigDecimal(notaxCostAmount);
        this.notaxCostAmount = b.toPlainString();
    }
}
