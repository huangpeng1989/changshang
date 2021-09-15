package modelpojo.model.catedeal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 商品销售付款表
 */
public class ComDealRate implements Serializable {
    private Long projectRootId;

    private Integer payId;

    private Integer gzoneId;

    private BigDecimal comSumamount;

    private BigDecimal comRatePrice;

    private String comRemark;

    private Integer comPayterminalid;

    private Integer comTradeNo;

    private Date comTimestamp;

    private String cardNo;

    private String srcSys;


	private String comNdealId;

    private Integer comRateId;

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

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId;
    }

    public Integer getComRateId() {
        return comRateId;
    }

    public void setComRateId(Integer comRateId) {
        this.comRateId = comRateId;
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

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public BigDecimal getComSumamount() {
        return comSumamount;
    }

    public void setComSumamount(BigDecimal comSumamount) {
        this.comSumamount = comSumamount;
    }

    public BigDecimal getComRatePrice() {
        return comRatePrice;
    }

    public void setComRatePrice(BigDecimal comRatePrice) {
        this.comRatePrice = comRatePrice;
    }

    public String getComRemark() {
        return comRemark;
    }

    public void setComRemark(String comRemark) {
        this.comRemark = comRemark == null ? null : comRemark.trim();
    }

    public Integer getComPayterminalid() {
        return comPayterminalid;
    }

    public void setComPayterminalid(Integer comPayterminalid) {
        this.comPayterminalid = comPayterminalid;
    }

    public Integer getComTradeNo() {
        return comTradeNo;
    }

    public void setComTradeNo(Integer comTradeNo) {
        this.comTradeNo = comTradeNo;
    }

    public Date getComTimestamp() {
        return comTimestamp;
    }

    public void setComTimestamp(Date comTimestamp) {
        this.comTimestamp = comTimestamp;
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