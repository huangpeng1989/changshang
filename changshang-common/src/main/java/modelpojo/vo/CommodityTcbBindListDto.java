package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityTcbBindListDto implements Serializable {

    private String saleComCode;//销售商品编号
    private String comClassCode;//商品分类编号
    private String comCode;//商品编号
    private String comName;//商品名称
    private String sellModel;//经营方式
    private String comSpec;  //规格
    private Integer comUnit; //单位
    private  BigDecimal retailPrice;//原价

    private Integer comId;//商品id
    private Integer saleComBarcode;//商品条码

    //销售商品id
    private Integer saleComId;

    //销售商品包装含量
    private Integer saleHackContent;

    //销售商品单位
    private Integer saleUnit;

    //创建人
    private Long creater;

    //价格配置主键id
    private Integer gpId;

    //价格等级id
    private Integer priceGrade;

    //审核人
    private Long blEmpId;

    private String sellModelName; //code转中文
    private String sellCommName;
    private String gradeName;

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public String getSellCommName() {
        return sellCommName;
    }

    public void setSellCommName(String sellCommName) {
        this.sellCommName = sellCommName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getComId() {
        return comId;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getSaleComBarcode() {
        return saleComBarcode;
    }

    public void setSaleComBarcode(Integer saleComBarcode) {
        this.saleComBarcode = saleComBarcode;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getSaleHackContent() {
        return saleHackContent;
    }

    public void setSaleHackContent(Integer saleHackContent) {
        this.saleHackContent = saleHackContent;
    }

    public Integer getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(Integer saleUnit) {
        this.saleUnit = saleUnit;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public Integer getPriceGrade() {
        return priceGrade;
    }

    public void setPriceGrade(Integer priceGrade) {
        this.priceGrade = priceGrade;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    //审核时间
    private Date blTime;

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }


    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}
