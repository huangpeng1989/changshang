package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityTcbComDto implements Serializable {

    private Integer comId;//公司id
    private String comClassCode;//商品分类
    private Integer sellModel;
    private Integer sellStatus;//销售状态
    private String comSpec;  //规格
    private Integer comUnit; //单位
    private Date createdTime;//录入时间
    private Long creater; //录入人
    private Integer cStatus; //状态
    private  BigDecimal retailPrice;//建议零售价
    private String comName ; //拼音码

    private String comCode ; //商品编码
    private String saleComCode ; //销售商品编码

    private String comClassName ; //code转中文
    private String sellModelName ; //
    private String cStatusName ; //
    private String comUnitName ; //
    private String createrName ; //
    private String sellStatusName ; //

    private Date updatedTime;//修改时间
    private Long modifier;//修改人

    private String modifierName; //

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getSellStatusName() {
        return sellStatusName;
    }

    public void setSellStatusName(String sellStatusName) {
        this.sellStatusName = sellStatusName;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getSellModelName() {
        return sellModelName;
    }

    public void setSellModelName(String sellModelName) {
        this.sellModelName = sellModelName;
    }

    public String getcStatusName() {
        return cStatusName;
    }

    public void setcStatusName(String cStatusName) {
        this.cStatusName = cStatusName;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    private Long projectId ; //项目id


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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }



    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }
}
