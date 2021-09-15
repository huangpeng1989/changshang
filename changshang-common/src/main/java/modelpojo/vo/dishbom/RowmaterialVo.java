package modelpojo.vo.dishbom;


import modelpojo.model.CommodityTcbSupplierModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RowmaterialVo implements Serializable{



    private String rmName;

    private String sellModel;

    private Integer rmUnit;

    private String rmUnitName;

    private String typeName;

    private String rmdishId;

    private String rmdishCode;


    private Integer bomDtlType;

    private String bomDtlTypeName;

    private Integer specId;

    private Integer dishSpecId;

    private String specName;

    private String dbStatus;


    private Integer srmId;

    private String srmCode;

    private Integer srmUnit;

    private String rmBarcode;

    private String dishBarcode;

    private BigDecimal taxPaid;

    private List<RowmaterialVo> vo = new ArrayList<>();

    private List<CommodityTcbSupplierModel> list= new ArrayList<>();

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }

    public List<RowmaterialVo> getVo() {
        return vo;
    }

    public void setVo(List<RowmaterialVo> vo) {
        this.vo = vo;
    }

    public List<CommodityTcbSupplierModel> getList() {
        return list;
    }

    public void setList(List<CommodityTcbSupplierModel> list) {
        this.list = list;
    }

    public String getDishBarcode() {
        return dishBarcode;
    }

    public void setDishBarcode(String dishBarcode) {
        this.dishBarcode = dishBarcode;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public Integer getSrmId() {
        return srmId;
    }

    public void setSrmId(Integer srmId) {
        this.srmId = srmId;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }


    public String getRmdishId() {
        return rmdishId;
    }

    public void setRmdishId(String rmdishId) {
        this.rmdishId = rmdishId;
    }

    public String getRmdishCode() {
        return rmdishCode;
    }

    public void setRmdishCode(String rmdishCode) {
        this.rmdishCode = rmdishCode;
    }

    public Integer getBomDtlType() {
        return bomDtlType;
    }

    public void setBomDtlType(Integer bomDtlType) {
        this.bomDtlType = bomDtlType;
    }

    public String getBomDtlTypeName() {
        return bomDtlTypeName;
    }

    public void setBomDtlTypeName(String bomDtlTypeName) {
        this.bomDtlTypeName = bomDtlTypeName;
    }




    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }






}
