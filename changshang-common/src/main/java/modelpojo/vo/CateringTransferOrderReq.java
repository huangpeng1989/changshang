package modelpojo.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-04-26 14:05
 */
public class CateringTransferOrderReq implements Serializable {
    private static final long serialVersionUID = -766697235507251984L;

    private String rmName;
    private String rmCode;
    private String rmKey;
    private String rmClassCode;
    private String whStock;
    private String sellModel;
    private Integer specRmType;
    private Integer specRmType2;
    private Integer specRmType3;
    private Integer specRmType4;
    private String specName;
    private String rmBarcode;
    private Integer rmUnit;
    private String rmUnitName;
    private Integer rmId;
    private Integer pageNo;
    private Integer pageSize;
    private Integer whId;
    private Integer type;

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRmClassCode() {
        return rmClassCode;
    }

    public void setRmClassCode(String rmClassCode) {
        this.rmClassCode = rmClassCode;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmKey() {
        return rmKey;
    }

    public void setRmKey(String rmKey) {
        this.rmKey = rmKey;
    }


    public String getWhStock() {
        return whStock;
    }

    public void setWhStock(String whStock) {
        this.whStock = whStock;
    }

    public Integer getSpecRmType() {
        return specRmType;
    }

    public void setSpecRmType(Integer specRmType) {
        this.specRmType = specRmType;
    }

    public Integer getSpecRmType2() {
        return specRmType2;
    }

    public void setSpecRmType2(Integer specRmType2) {
        this.specRmType2 = specRmType2;
    }

    public Integer getSpecRmType3() {
        return specRmType3;
    }

    public void setSpecRmType3(Integer specRmType3) {
        this.specRmType3 = specRmType3;
    }

    public Integer getSpecRmType4() {
        return specRmType4;
    }

    public void setSpecRmType4(Integer specRmType4) {
        this.specRmType4 = specRmType4;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }
}
