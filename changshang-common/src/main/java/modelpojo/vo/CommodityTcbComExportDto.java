package modelpojo.vo;


import java.io.Serializable;


/**
 * 附件导出通用返回集
 */
public class CommodityTcbComExportDto implements Serializable {

//    private Integer sellModel ; //经营方式
//    private Integer sellStatus ; //商品销售状态
//    private Integer comUnit ; //商品单位
//    private Integer comGrade ; //产品等级


    private Integer typeCode; //全局字典表code
    private String typeName; //全局字典名称

    private Integer taxId; //进、销项税id
    private String taxName; //项税名称


    private String suppCode; //供应商名称
    private String suppName; //供应商编号
    private String suppId; //供应商id


    private Integer dictTpCode; //可维护字典表code
    private String dictTpValue; //可维护字典名称

    public Integer getDictTpCode() {
        return dictTpCode;
    }

    public void setDictTpCode(Integer dictTpCode) {
        this.dictTpCode = dictTpCode;
    }

    public String getDictTpValue() {
        return dictTpValue;
    }

    public void setDictTpValue(String dictTpValue) {
        this.dictTpValue = dictTpValue;
    }

    public String getSuppId() {
        return suppId;
    }

    public void setSuppId(String suppId) {
        this.suppId = suppId;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
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
}
