package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*****
 * 库存成本调整（加权平均）实体类
 */
public class CommodityWhStockcostchg  implements Serializable{


    private Long projectId;

    private Long projectRootId;

    private Integer schgId;

    private  Integer whId;

    private  Integer comId;

    private  Integer comClass;

    private  String comCode;

    private  String comBarcode;

    private BigDecimal taxCost;


    private  BigDecimal notaxCost;

    private  BigDecimal stockNum;

    private Date chgTime;

    private Date createdTime;

    private Date updatedTime;

    private Integer isDelete;

    private Integer syncStatus;


    private  String whCode;

    private  String comName;

    private String comClassName;

    private Integer comClassId;

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getSchgId() {
        return schgId;
    }

    public void setSchgId(Integer schgId) {
        this.schgId = schgId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getComClass() {
        return comClass;
    }

    public void setComClass(Integer comClass) {
        this.comClass = comClass;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComBarcode() {
        return comBarcode;
    }

    public void setComBarcode(String comBarcode) {
        this.comBarcode = comBarcode;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getNotaxCost() {
        return notaxCost;
    }

    public void setNotaxCost(BigDecimal notaxCost) {
        this.notaxCost = notaxCost;
    }

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

    public Date getChgTime() {
        return chgTime;
    }

    public void setChgTime(Date chgTime) {
        this.chgTime = chgTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
