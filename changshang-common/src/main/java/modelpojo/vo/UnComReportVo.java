package modelpojo.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class UnComReportVo  implements Serializable {
    //商品ID
    private Integer comId;
    //商品编号
    private String comCode;
    //商品名称
    private String comName;
    //商品分类
    private Integer comClassCode;
    //规格
    private String comSpec;
    //销售单位
    private Integer comUnit;
    //销售单位名称
    private String comUnitName ;
    //经营方式
    private Integer sellModel;
    //经营方式名称
    private String sellModelName ;
    //库存
    private BigDecimal stockNum;

    private Integer comClassId;

    private String OneClassName;

    private String TwoClassName;

    private String ThreeClassName;

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getOneClassName() {
        return OneClassName;
    }

    public void setOneClassName(String oneClassName) {
        OneClassName = oneClassName;
    }

    public String getTwoClassName() {
        return TwoClassName;
    }

    public void setTwoClassName(String twoClassName) {
        TwoClassName = twoClassName;
    }

    public String getThreeClassName() {
        return ThreeClassName;
    }

    public void setThreeClassName(String threeClassName) {
        ThreeClassName = threeClassName;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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

    public Integer getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(Integer comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }
}
