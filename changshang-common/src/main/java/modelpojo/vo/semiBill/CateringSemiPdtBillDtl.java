package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CateringSemiPdtBillDtl  implements Serializable{
    private Long projectId;

    private Integer spdtDtlId;

    private Integer spdtBillId;

    private Integer dishId;

    private Integer dishUnit;

    private String dishCode;

    private String dishUnitName;

    private String dishName;

    private Integer processNum;

    private Integer dishBomId;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Byte isDelete;

    private String dishBomCode;

    private BigDecimal whStock;//实时库存

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }

    private List<CateringSemiPdtBomDtl> cateringSemiPdtBomDtlList;

    public List<CateringSemiPdtBomDtl> getCateringSemiPdtBomDtlList() {
        return cateringSemiPdtBomDtlList;
    }

    public String getDishBomCode() {
        return dishBomCode;
    }

    public void setDishBomCode(String dishBomCode) {
        this.dishBomCode = dishBomCode;
    }

    public void setCateringSemiPdtBomDtlList(List<CateringSemiPdtBomDtl> cateringSemiPdtBomDtlList) {
        this.cateringSemiPdtBomDtlList = cateringSemiPdtBomDtlList;
    }

    public String getDishUnitName() {
        return dishUnitName;
    }

    public void setDishUnitName(String dishUnitName) {
        this.dishUnitName = dishUnitName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getSpdtDtlId() {
        return spdtDtlId;
    }

    public void setSpdtDtlId(Integer spdtDtlId) {
        this.spdtDtlId = spdtDtlId;
    }

    public Integer getSpdtBillId() {
        return spdtBillId;
    }

    public void setSpdtBillId(Integer spdtBillId) {
        this.spdtBillId = spdtBillId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public Integer getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }

    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
