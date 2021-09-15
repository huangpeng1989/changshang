package modelpojo.vo.saledDish;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 可售菜品价格表
 */
public class CateringSaledDishDetailPriceVo implements Serializable {

    private Long projcetId;

    private Integer saledDishId;

    private Integer saledDishDtlId;

    private Integer dictSpecId;

    private Integer dictId;//菜品id dishId字段意思一样，因部分表字段不统一所以有歧异

    private BigDecimal dictSpecPrice;

    private Byte isDelete;

    private String saledDishCode;//单据编号

    private String saledDishName;//单据名称

    private Integer saledDishStatus;//审核状态

    private Integer sellPointId;//营业点id

    private Integer saleNum;//可售菜品条数

    private String dishName;//菜品名称

    private String dishCode;//菜品编号

    private Integer saledDishcomType;//菜品类型

    private Integer dishUnit;//销售单位

    private String dishClassCode;//菜品分类



    private BigDecimal salePriceMax;//销售价格(大份)
    private BigDecimal salePriceMid;//销售价格(中份)
    private BigDecimal salePriceMin;//销售价格(小份)

    private Integer dishId;//可售菜品id


    private String saleDetail;//可售菜品详情List数据


    private Integer dishType;//菜品类型

    private String remark;//备注

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date startDate;//开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , locale="zh",timezone = "GMT+8")
    private Date endDate;//结束事假


    private Integer saledDataType;//数据类型

    private String gzoneCode;//营业点code

    private String gzoneName;//营业点名称

    private String isBom;//是否菜品bom

    private Integer isSaleStatus;//是否可售

    public Integer getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(Integer isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    public String getIsBom() {
        return isBom;
    }

    public void setIsBom(String isBom) {
        this.isBom = isBom;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public Integer getSaledDataType() {
        return saledDataType;
    }

    public void setSaledDataType(Integer saledDataType) {
        this.saledDataType = saledDataType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Long creater;

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public String getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(String saleDetail) {
        this.saleDetail = saleDetail;
    }

    public String getSaledDishCode() {
        return saledDishCode;
    }

    public void setSaledDishCode(String saledDishCode) {
        this.saledDishCode = saledDishCode;
    }

    public String getSaledDishName() {
        return saledDishName;
    }

    public void setSaledDishName(String saledDishName) {
        this.saledDishName = saledDishName;
    }

    public Integer getSaledDishStatus() {
        return saledDishStatus;
    }

    public void setSaledDishStatus(Integer saledDishStatus) {
        this.saledDishStatus = saledDishStatus;
    }

    public Long getProjcetId() {
        return projcetId;
    }

    public void setProjcetId(Long projcetId) {
        this.projcetId = projcetId;
    }

    public Integer getSaledDishId() {
        return saledDishId;
    }

    public void setSaledDishId(Integer saledDishId) {
        this.saledDishId = saledDishId;
    }

    public Integer getSaledDishDtlId() {
        return saledDishDtlId;
    }

    public void setSaledDishDtlId(Integer saledDishDtlId) {
        this.saledDishDtlId = saledDishDtlId;
    }

    public Integer getDictSpecId() {
        return dictSpecId;
    }

    public void setDictSpecId(Integer dictSpecId) {
        this.dictSpecId = dictSpecId;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public BigDecimal getDictSpecPrice() {
        return dictSpecPrice;
    }

    public void setDictSpecPrice(BigDecimal dictSpecPrice) {
        this.dictSpecPrice = dictSpecPrice;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public Integer getSaledDishcomType() {
        return saledDishcomType;
    }

    public void setSaledDishcomType(Integer saledDishcomType) {
        this.saledDishcomType = saledDishcomType;
    }

    public Integer getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(Integer dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getDishClassCode() {
        return dishClassCode;
    }

    public void setDishClassCode(String dishClassCode) {
        this.dishClassCode = dishClassCode;
    }

    public BigDecimal getSalePriceMax() {
        return salePriceMax;
    }

    public void setSalePriceMax(BigDecimal salePriceMax) {
        this.salePriceMax = salePriceMax;
    }

    public BigDecimal getSalePriceMid() {
        return salePriceMid;
    }

    public void setSalePriceMid(BigDecimal salePriceMid) {
        this.salePriceMid = salePriceMid;
    }

    public BigDecimal getSalePriceMin() {
        return salePriceMin;
    }

    public void setSalePriceMin(BigDecimal salePriceMin) {
        this.salePriceMin = salePriceMin;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }
}