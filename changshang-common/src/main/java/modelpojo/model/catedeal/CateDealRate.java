package modelpojo.model.catedeal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 餐饮销售付款表
 */
public class CateDealRate implements Serializable {
    private Long projectRootId;

    private Integer gzoneId;

    private BigDecimal cateSumAmount;

    private BigDecimal cateRatePrice;

    private String cateRemark;

    private Integer cateTableId;

    private Integer catePayterminalId;

    private Integer cateTradeNo;

    private Date cateTimestamp;

    private String cardNo;

    private String srcSys;

	 private String cateNdealId;

    private Integer cateRateId;

    private Integer nterminalId;

    private Long projectId;

    private Date createdTime;

    private Date updatedTime;

    private String nterminalName;

    private Long parkId;

    private Integer payIds;

    private String payMode;

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public Integer getPayIds() {
        return payIds;
    }

    public void setPayIds(Integer payIds) {
        this.payIds = payIds;
    }

    public String getNterminalName() {
        return nterminalName;
    }

    public void setNterminalName(String nterminalName) {
        this.nterminalName = nterminalName;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
    }

    public Integer getCateRateId() {
        return cateRateId;
    }

    public void setCateRateId(Integer cateRateId) {
        this.cateRateId = cateRateId;
    }

    public Integer getNterminalId() {
        return nterminalId;
    }

    public void setNterminalId(Integer nterminalId) {
        this.nterminalId = nterminalId;
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

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public BigDecimal getCateSumAmount() {
        return cateSumAmount;
    }

    public void setCateSumAmount(BigDecimal cateSumAmount) {
        this.cateSumAmount = cateSumAmount;
    }

    public BigDecimal getCateRatePrice() {
        return cateRatePrice;
    }

    public void setCateRatePrice(BigDecimal cateRatePrice) {
        this.cateRatePrice = cateRatePrice;
    }

    public String getCateRemark() {
        return cateRemark;
    }

    public void setCateRemark(String cateRemark) {
        this.cateRemark = cateRemark == null ? null : cateRemark.trim();
    }

    public Integer getCateTableId() {
        return cateTableId;
    }

    public void setCateTableId(Integer cateTableId) {
        this.cateTableId = cateTableId;
    }

    public Integer getCatePayterminalId() {
        return catePayterminalId;
    }

    public void setCatePayterminalId(Integer catePayterminalId) {
        this.catePayterminalId = catePayterminalId;
    }

    public Integer getCateTradeNo() {
        return cateTradeNo;
    }

    public void setCateTradeNo(Integer cateTradeNo) {
        this.cateTradeNo = cateTradeNo;
    }

    public Date getCateTimestamp() {
        return cateTimestamp;
    }

    public void setCateTimestamp(Date cateTimestamp) {
        this.cateTimestamp = cateTimestamp;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getSrcSys() {
        return srcSys;
    }

    public void setSrcSys(String srcSys) {
        this.srcSys = srcSys == null ? null : srcSys.trim();
    }
}