package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CateringAplBillDtl implements Serializable {

    private Integer aplBillDtlId;

    private Long projectRootId;

    private Integer comId;

    private String comCode;

    private Integer comUnit;

    private Integer saleComId;

    private String saleComCode;

    private Integer saleComUnit;

    private BigDecimal allotNum;

    private BigDecimal inNum;

    private BigDecimal aplNum;

    private Integer aplResult;

    private Integer goodType;

    private String rejectResion;

    private String remark;

    private String description;

    private Date createdTime;

    private Long creater;

    private Date updatedTime;

    private Long modifier;

    private Byte isDelete;

    private Integer cStatus;

    private Integer syncStatus;

	 private Integer aplBillId;

    private Long projectId;


    private String dishCode;

    private String dishName;

    private String comUnitName;

    private String gzoneName;

    private Integer gzoneId;

    private String gzoneCode;

    private String nickName;

    private Integer aplWhId;

    private String aplDate;

    private String aplBillCode;


    private String rmCode;


    private String rmName;

    private BigDecimal taxPaid;

    private BigDecimal noTaxPaid;

    private String sellModel;

    private Integer countNum;


    private Integer suppId;


    private String suppCode;

    private Integer whId;

    private Integer phTaxId;

    private String aplBillIds;

    private Integer srmId;

    private  String srmCode;

    private Integer srmUnit;

    private String rmBarcode;


    private Integer  tAplBillId;

    private String tAplBillCode;

    private BigDecimal whStock;

    private BigDecimal dWhStock;

    private String aplResultInfo;

    private String xqing;

    private String  suppName;

    private Integer specId;

    private Integer dishSpecId;

    private String specName;

    private BigDecimal fengShu;


    private  Integer inPaymentDaysId;
    private  String  inPaymentName;
    private  Date inPaymentData;

    private BigDecimal sAllotOutCount;

    private BigDecimal shu;

    public BigDecimal getShu() {
        return shu;
    }

    public void setShu(BigDecimal shu) {
        this.shu = shu;
    }

    public BigDecimal getsAllotOutCount() {
        return sAllotOutCount;
    }

    public void setsAllotOutCount(BigDecimal sAllotOutCount) {
        this.sAllotOutCount = sAllotOutCount;
    }

    public Integer getInPaymentDaysId() {
        return inPaymentDaysId;
    }

    public void setInPaymentDaysId(Integer inPaymentDaysId) {
        this.inPaymentDaysId = inPaymentDaysId;
    }

    public String getInPaymentName() {
        return inPaymentName;
    }

    public void setInPaymentName(String inPaymentName) {
        this.inPaymentName = inPaymentName;
    }

    public Date getInPaymentData() {
        return inPaymentData;
    }

    public void setInPaymentData(Date inPaymentData) {
        this.inPaymentData = inPaymentData;
    }

    private List<CateringRelationBillModel> puchase = new ArrayList<>();

    private List<CateringRelationBillModel> allot = new ArrayList<>();


    public List<CateringRelationBillModel> getAllot() {
        return allot;
    }

    public void setAllot(List<CateringRelationBillModel> allot) {
        this.allot = allot;
    }

    public List<CateringRelationBillModel> getPuchase() {
        return puchase;
    }

    public void setPuchase(List<CateringRelationBillModel> puchase) {
        this.puchase = puchase;
    }

    public BigDecimal getFengShu() {
        return fengShu;
    }

    public void setFengShu(BigDecimal fengShu) {
        this.fengShu = fengShu;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getDishSpecId() {
        return dishSpecId;
    }

    public void setDishSpecId(Integer dishSpecId) {
        this.dishSpecId = dishSpecId;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getAplResultInfo() {
        return aplResultInfo;
    }

    public void setAplResultInfo(String aplResultInfo) {
        this.aplResultInfo = aplResultInfo;
    }

    public String getXqing() {
        return xqing;
    }

    public void setXqing(String xqing) {
        this.xqing = xqing;
    }

    private String whName;

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public BigDecimal getdWhStock() {
        return dWhStock;
    }

    public void setdWhStock(BigDecimal dWhStock) {
        this.dWhStock = dWhStock;
    }

    public BigDecimal getWhStock() {
        return whStock;
    }

    public void setWhStock(BigDecimal whStock) {
        this.whStock = whStock;
    }



    public Integer gettAplBillId() {
        return tAplBillId;
    }

    public void settAplBillId(Integer tAplBillId) {
        this.tAplBillId = tAplBillId;
    }

    public String gettAplBillCode() {
        return tAplBillCode;
    }

    public void settAplBillCode(String tAplBillCode) {
        this.tAplBillCode = tAplBillCode;
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

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getAplBillIds() {
        return aplBillIds;
    }

    public void setAplBillIds(String aplBillIds) {
        this.aplBillIds = aplBillIds;
    }

    private BigDecimal packContent;

    public BigDecimal getPackContent() {
        return packContent;
    }

    public void setPackContent(BigDecimal packContent) {
        this.packContent = packContent;
    }

    public Integer getPhTaxId() {
        return phTaxId;
    }

    public void setPhTaxId(Integer phTaxId) {
        this.phTaxId = phTaxId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public BigDecimal getNoTaxPaid() {
        return noTaxPaid;
    }

    public void setNoTaxPaid(BigDecimal noTaxPaid) {
        this.noTaxPaid = noTaxPaid;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

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

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public Integer getAplBillDtlId() {
        return aplBillDtlId;
    }

    public void setAplBillDtlId(Integer aplBillDtlId) {
        this.aplBillDtlId = aplBillDtlId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getComUnitName() {
        return comUnitName;
    }

    public void setComUnitName(String comUnitName) {
        this.comUnitName = comUnitName;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAplWhId() {
        return aplWhId;
    }

    public void setAplWhId(Integer aplWhId) {
        this.aplWhId = aplWhId;
    }

    public String getAplDate() {
        return aplDate;
    }

    public void setAplDate(String aplDate) {
        this.aplDate = aplDate;
    }

    public String getAplBillCode() {
        return aplBillCode;
    }

    public void setAplBillCode(String aplBillCode) {
        this.aplBillCode = aplBillCode;
    }



    public Integer getAplBillId() {
        return aplBillId;
    }

    public void setAplBillId(Integer aplBillId) {
        this.aplBillId = aplBillId;
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
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public Integer getComUnit() {
        return comUnit;
    }

    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public Integer getSaleComUnit() {
        return saleComUnit;
    }

    public void setSaleComUnit(Integer saleComUnit) {
        this.saleComUnit = saleComUnit;
    }

    public BigDecimal getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(BigDecimal allotNum) {
        this.allotNum = allotNum;
    }

    public BigDecimal getInNum() {
        return inNum;
    }

    public void setInNum(BigDecimal inNum) {
        this.inNum = inNum;
    }

    public BigDecimal getAplNum() {
        return aplNum;
    }

    public void setAplNum(BigDecimal aplNum) {
        this.aplNum = aplNum;
    }

    public Integer getAplResult() {
        return aplResult;
    }

    public void setAplResult(Integer aplResult) {
        this.aplResult = aplResult;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getRejectResion() {
        return rejectResion;
    }

    public void setRejectResion(String rejectResion) {
        this.rejectResion = rejectResion == null ? null : rejectResion.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}