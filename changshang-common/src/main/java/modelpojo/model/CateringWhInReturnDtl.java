package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CateringWhInReturnDtl  implements Serializable {

    private static final long serialVersionUID = -1571860873229208002L;
    private Long projectId;

    private Integer rtnBillId;


    private Long projectRootId;

    private Integer fEntryId;

    private Integer rmId;

    private String rmCode;

    private String sellModel;

    private Integer rmUnit;

    private BigDecimal sumOGPageCount ;  //验收总数量 = 验收订单数量+验收赠品数量
    private BigDecimal retrievableNumber;  //可退数量
    private BigDecimal rtnOGPageCount;  //退货数量
    private BigDecimal whStock;  //库存数量


    private String whStockUnitName;  //库存数量单位名称





    private String srmUnitName;  //原材料包装单位
    private String rmName;  //原材料名称


    private String rmBarcode;  //原材料条码

    private Integer srmId;

    private String srmCode;

    private Integer srmUnit;

    private BigDecimal srmPackContent;

    private BigDecimal orderCount;

    private Integer gSrmId;

    private String gSrmCode;

    private Integer gSrmUnit;

    private BigDecimal gSrmPackContent;

    private BigDecimal gOrderCount;

    private BigDecimal fifoTaxCost;

    private BigDecimal fifoNotaxCost;

    private BigDecimal avgTaxCost;

    private BigDecimal avgNotaxCost;

    private Integer taxId;

    private String taxName;

    private String state;

    private String remark;

    private Byte isDelete;

    private Long creater;

    private Long modifier;

    private Date createdTime;

    private Date updatedTime;

    private Integer syncStatus;

    private Long pSrmId;//退货销售原材料id

    private String pSrmCode; // 退货销售原材料编码

    private Long pSrmUnit;//退货销售原材料单位 字典表

    private BigDecimal pSrmPackContent;//退货销售原材料含量

    private BigDecimal pOrderPageCount;//退货包装数量

    private BigDecimal pGiftPageCount;//退货赠品包装数量

    private BigDecimal pFifoTaxCost;//退货包装含税价

    private BigDecimal pFifoNotaxCost;//退货包装未税价

    private BigDecimal orderPageCount;//转换后的退货包装数量

    private BigDecimal giftPageCount;//转换后的退货赠品包装数量

    private BigDecimal returnOrderPageCount;//订货数量
    private BigDecimal returnGiftPageCount;//赠品数量
    private BigDecimal returnableOrderCount;//可退货数量
    private BigDecimal returnableGiftCount;//可退赠品数量

    private String pSaleRmUnitName;

    /**冻结数量 */
    private BigDecimal freeaeCount;

    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getFreeaeCount() {
        return freeaeCount;
    }

    public void setFreeaeCount(BigDecimal freeaeCount) {
        this.freeaeCount = freeaeCount;
    }

    public String getpSaleRmUnitName() {
        return pSaleRmUnitName;
    }

    public void setpSaleRmUnitName(String pSaleRmUnitName) {
        this.pSaleRmUnitName = pSaleRmUnitName;
    }

    public BigDecimal getReturnOrderPageCount() {
        return returnOrderPageCount;
    }

    public void setReturnOrderPageCount(BigDecimal returnOrderPageCount) {
        this.returnOrderPageCount = returnOrderPageCount;
    }

    public BigDecimal getReturnGiftPageCount() {
        return returnGiftPageCount;
    }

    public void setReturnGiftPageCount(BigDecimal returnGiftPageCount) {
        this.returnGiftPageCount = returnGiftPageCount;
    }

    public BigDecimal getReturnableOrderCount() {
        return returnableOrderCount;
    }

    public void setReturnableOrderCount(BigDecimal returnableOrderCount) {
        this.returnableOrderCount = returnableOrderCount;
    }

    public BigDecimal getReturnableGiftCount() {
        return returnableGiftCount;
    }

    public void setReturnableGiftCount(BigDecimal returnableGiftCount) {
        this.returnableGiftCount = returnableGiftCount;
    }

    public Long getpSrmId() {
        return pSrmId;
    }

    public void setpSrmId(Long pSrmId) {
        this.pSrmId = pSrmId;
    }

    public String getpSrmCode() {
        return pSrmCode;
    }

    public void setpSrmCode(String pSrmCode) {
        this.pSrmCode = pSrmCode;
    }

    public Long getpSrmUnit() {
        return pSrmUnit;
    }

    public void setpSrmUnit(Long pSrmUnit) {
        this.pSrmUnit = pSrmUnit;
    }

    public BigDecimal getpSrmPackContent() {
        return pSrmPackContent;
    }

    public void setpSrmPackContent(BigDecimal pSrmPackContent) {
        this.pSrmPackContent = pSrmPackContent;
    }

    public BigDecimal getpOrderPageCount() {
        return pOrderPageCount;
    }

    public void setpOrderPageCount(BigDecimal pOrderPageCount) {
        this.pOrderPageCount = pOrderPageCount;
    }

    public BigDecimal getpGiftPageCount() {
        return pGiftPageCount;
    }

    public void setpGiftPageCount(BigDecimal pGiftPageCount) {
        this.pGiftPageCount = pGiftPageCount;
    }

    public BigDecimal getpFifoTaxCost() {
        return pFifoTaxCost;
    }

    public void setpFifoTaxCost(BigDecimal pFifoTaxCost) {
        this.pFifoTaxCost = pFifoTaxCost;
    }

    public BigDecimal getpFifoNotaxCost() {
        return pFifoNotaxCost;
    }

    public void setpFifoNotaxCost(BigDecimal pFifoNotaxCost) {
        this.pFifoNotaxCost = pFifoNotaxCost;
    }

    public BigDecimal getOrderPageCount() {
        return orderPageCount;
    }

    public void setOrderPageCount(BigDecimal orderPageCount) {
        this.orderPageCount = orderPageCount;
    }

    public BigDecimal getGiftPageCount() {
        return giftPageCount;
    }

    public void setGiftPageCount(BigDecimal giftPageCount) {
        this.giftPageCount = giftPageCount;
    }

    public String getWhStockUnitName() {
        return whStockUnitName;
    }

    public void setWhStockUnitName(String whStockUnitName) {
        this.whStockUnitName = whStockUnitName;
    }
    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }
    public BigDecimal getRtnOGPageCount() {
        return rtnOGPageCount;
    }

    public void setRtnOGPageCount(BigDecimal rtnOGPageCount) {
        this.rtnOGPageCount = rtnOGPageCount;
    }

    public BigDecimal getSumOGPageCount() {
        return sumOGPageCount;
    }

    public void setSumOGPageCount(BigDecimal sumOGPageCount) {
        this.sumOGPageCount = sumOGPageCount;
    }

    public BigDecimal getRetrievableNumber() {
        return retrievableNumber;
    }

    public void setRetrievableNumber(BigDecimal retrievableNumber) {
        this.retrievableNumber = retrievableNumber;
    }
    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRtnBillId() {
        return rtnBillId;
    }

    public void setRtnBillId(Integer rtnBillId) {
        this.rtnBillId = rtnBillId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public Integer getfEntryId() {
        return fEntryId;
    }

    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode == null ? null : rmCode.trim();
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel == null ? null : sellModel.trim();
    }

    public Integer getRmUnit() {
        return rmUnit;
    }

    public void setRmUnit(Integer rmUnit) {
        this.rmUnit = rmUnit;
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
        this.srmCode = srmCode == null ? null : srmCode.trim();
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }

    public BigDecimal getSrmPackContent() {
        return srmPackContent;
    }

    public void setSrmPackContent(BigDecimal srmPackContent) {
        this.srmPackContent = srmPackContent;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getgSrmId() {
        return gSrmId;
    }

    public void setgSrmId(Integer gSrmId) {
        this.gSrmId = gSrmId;
    }

    public String getgSrmCode() {
        return gSrmCode;
    }

    public void setgSrmCode(String gSrmCode) {
        this.gSrmCode = gSrmCode == null ? null : gSrmCode.trim();
    }

    public Integer getgSrmUnit() {
        return gSrmUnit;
    }

    public void setgSrmUnit(Integer gSrmUnit) {
        this.gSrmUnit = gSrmUnit;
    }

    public BigDecimal getgSrmPackContent() {
        return gSrmPackContent;
    }

    public void setgSrmPackContent(BigDecimal gSrmPackContent) {
        this.gSrmPackContent = gSrmPackContent;
    }

    public BigDecimal getgOrderCount() {
        return gOrderCount;
    }

    public void setgOrderCount(BigDecimal gOrderCount) {
        this.gOrderCount = gOrderCount;
    }

    public BigDecimal getFifoTaxCost() {
        return fifoTaxCost;
    }

    public void setFifoTaxCost(BigDecimal fifoTaxCost) {
        this.fifoTaxCost = fifoTaxCost;
    }

    public BigDecimal getFifoNotaxCost() {
        return fifoNotaxCost;
    }

    public void setFifoNotaxCost(BigDecimal fifoNotaxCost) {
        this.fifoNotaxCost = fifoNotaxCost;
    }

    public BigDecimal getAvgTaxCost() {
        return avgTaxCost;
    }

    public void setAvgTaxCost(BigDecimal avgTaxCost) {
        this.avgTaxCost = avgTaxCost;
    }

    public BigDecimal getAvgNotaxCost() {
        return avgNotaxCost;
    }

    public void setAvgNotaxCost(BigDecimal avgNotaxCost) {
        this.avgNotaxCost = avgNotaxCost;
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
        this.taxName = taxName == null ? null : taxName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
