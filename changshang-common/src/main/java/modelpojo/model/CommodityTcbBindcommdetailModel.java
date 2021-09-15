package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 捆绑商品明细表
 */
public class CommodityTcbBindcommdetailModel  implements Serializable {
    private int isDelete;//是否删除

    //项目Id
    private Long projectId;
    //捆绑商品Id
    private Integer bindComId;
    //捆绑明细表Id
    private Integer bindComDtlId;
//    //项目根节点
//    private Integer projectRootId;
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
    private Integer saleHackContent;
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
    private Integer bcdStatus;
    //创建人
    private Long creater;
    //修改时间
    private Date updTime;
    //修改人
    private Long modifier;
    //审核时间
    private Date blTime;
    //审核人
    private Long blEmpId;

    //价格配置主键id
    private Integer gpId;

    //价格等级id
    private Integer priceGrade;

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public Integer getPriceGrade() {
        return priceGrade;
    }

    public void setPriceGrade(Integer priceGrade) {
        this.priceGrade = priceGrade;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
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

//    public Integer getProjectRootId() {
//        return projectRootId;
//    }
//
//    public void setProjectRootId(Integer projectRootId) {
//        this.projectRootId = projectRootId;
//    }

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
        this.comCode = comCode;
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
        this.saleComCode = saleComCode;
    }

    public Integer getSaleComId() {
        return saleComId;
    }

    public void setSaleComId(Integer saleComId) {
        this.saleComId = saleComId;
    }

    public Integer getSaleHackContent() {
        return saleHackContent;
    }

    public void setSaleHackContent(Integer saleHackContent) {
        this.saleHackContent = saleHackContent;
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
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBcdStatus() {
        return bcdStatus;
    }

    public void setBcdStatus(Integer bcdStatus) {
        this.bcdStatus = bcdStatus;
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


    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }
}