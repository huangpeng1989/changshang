package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 捆绑商品明细表
 */
public class CommodityTcbBindcommdetail implements Serializable{
    //项目Id
    private Integer projectId;
    //捆绑商品Id
    private Integer bindComId;
    //捆绑明细表Id
    private Integer bindComDtlId;
    //项目根节点
    private Integer projectRootId;
    //商品ID
    private Integer comId;
    //商品编码
    private String comCode;
    //商品条码
    private Integer saleComBarcode;
    //销售商品编码
    private String saleComCode;
    //销售商品id
    private Integer saleComId;
    //销售商品包装含量
    private Integer salePackContent;
    //销售商品单位
    private Integer saleUnit;
    //原零售价(商品价格配置的零售价)
    private BigDecimal oldRetailPrice;
    //捆绑数量
    private Integer bindCount;
    //捆绑单价
    private BigDecimal bindPrice;
    //合计金额
    private BigDecimal bindSumPrice;
    //备注
    private String remark;
    //创建时间
    private Date createTime;
    //状态
    private Integer BCDStatus;
    //创建人
    private Long creater;
    //修改时间
    private Date updTime;
    //修改人
    private Long modifier;
    //审核时间
    private Date BLTime;
    //审核人
    private Long BLEmpId;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getBindComId() {
        return bindComId;
    }

    public void setBindComId(Integer bindComId) {
        this.bindComId = bindComId;
    }

    public Integer getBindComDtlId() {
        return bindComDtlId;
    }

    public void setBindComDtlId(Integer bindComDtlId) {
        this.bindComDtlId = bindComDtlId;
    }

    public Integer getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Integer projectRootId) {
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

    public Integer getSaleComBarcode() {
        return saleComBarcode;
    }

    public void setSaleComBarcode(Integer saleComBarcode) {
        this.saleComBarcode = saleComBarcode;
    }

    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode == null ? null : saleComCode.trim();
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getSalePackContent() {
        return salePackContent;
    }

    public void setSalePackContent(Integer salePackContent) {
        this.salePackContent = salePackContent;
    }

    public Integer getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(Integer saleUnit) {
        this.saleUnit = saleUnit;
    }

    public BigDecimal getOldRetailPrice() {
        return oldRetailPrice;
    }

    public void setOldRetailPrice(BigDecimal oldRetailPrice) {
        this.oldRetailPrice = oldRetailPrice;
    }

    public Integer getBindCount() {
        return bindCount;
    }

    public void setBindCount(Integer bindCount) {
        this.bindCount = bindCount;
    }

    public BigDecimal getBindPrice() {
        return bindPrice;
    }

    public void setBindPrice(BigDecimal bindPrice) {
        this.bindPrice = bindPrice;
    }

    public BigDecimal getBindSumPrice() {
        return bindSumPrice;
    }

    public void setBindSumPrice(BigDecimal bindSumPrice) {
        this.bindSumPrice = bindSumPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBCDStatus() {
        return BCDStatus;
    }

    public void setBCDStatus(Integer BCDStatus) {
        this.BCDStatus = BCDStatus;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getBLTime() {
        return BLTime;
    }

    public void setBLTime(Date BLTime) {
        this.BLTime = BLTime;
    }

    public Long getBLEmpId() {
        return BLEmpId;
    }

    public void setBLEmpId(Long BLEmpId) {
        this.BLEmpId = BLEmpId;
    }
}