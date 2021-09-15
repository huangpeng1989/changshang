package modelpojo.vo;

import java.io.Serializable;

/**
 * 商品分类表
 */
public class CommodityTccComclassDto implements Serializable {


    //分类ID
    private Integer comClassId;
    //商品分类编号
    private String comClassCode;
    //商品分类名称
    private String comClassName;
    //上级分类ID
    private Integer ucomClassId;

    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public Integer getUcomClassId() {
        return ucomClassId;
    }

    public void setUcomClassId(Integer ucomClassId) {
        this.ucomClassId = ucomClassId;
    }
}