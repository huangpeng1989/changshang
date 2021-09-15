package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CateringTcbDishBomDetail  implements Serializable {
    private Integer dishBomId;

    private Integer rmdishId;

    private String rmdishCode;

    private Integer bomDtlType;

    private Integer isDelete;

    private Integer dishBomDtlStatus;

    private String remark;

    private String state;

	private Integer dishBomDtlId;

    private Long projectId;

    private String typeName;

    private  String name;


    private String rmUnitName;

    private BigDecimal costSumcount;


    private String sellModel;//原材料规格

    private BigDecimal taxPaid;

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public BigDecimal getCostSumcount() {
        return costSumcount;
    }

    public void setCostSumcount(BigDecimal costSumcount) {
        this.costSumcount = costSumcount;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    private String classCode;

    public String getTypeNameInfo() {
        return typeNameInfo;
    }

    public void setTypeNameInfo(String typeNameInfo) {
        this.typeNameInfo = typeNameInfo;
    }

    private String typeNameInfo;


    private BigDecimal whStock;

    private List<CateringTcbDishBomDetailSpec> detailSpecs= new ArrayList<CateringTcbDishBomDetailSpec>();


    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public List<CateringTcbDishBomDetailSpec> getDetailSpecs() {
        return detailSpecs;
    }

    public void setDetailSpecs(List<CateringTcbDishBomDetailSpec> detailSpecs) {
        this.detailSpecs = detailSpecs;
    }


    public Integer getDishBomDtlId() {
        return dishBomDtlId;
    }

    public void setDishBomDtlId(Integer dishBomDtlId) {
        this.dishBomDtlId = dishBomDtlId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public Integer getRmdishId() {
        return rmdishId;
    }

    public void setRmdishId(Integer rmdishId) {
        this.rmdishId = rmdishId;
    }

    public String getRmdishCode() {
        return rmdishCode;
    }

    public void setRmdishCode(String rmdishCode) {
        this.rmdishCode = rmdishCode == null ? null : rmdishCode.trim();
    }

    public Integer getBomDtlType() {
        return bomDtlType;
    }

    public void setBomDtlType(Integer bomDtlType) {
        this.bomDtlType = bomDtlType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDishBomDtlStatus() {
        return dishBomDtlStatus;
    }

    public void setDishBomDtlStatus(Integer dishBomDtlStatus) {
        this.dishBomDtlStatus = dishBomDtlStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}