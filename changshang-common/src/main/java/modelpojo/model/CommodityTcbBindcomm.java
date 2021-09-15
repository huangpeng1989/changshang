package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 捆绑商品主表
 */
public class CommodityTcbBindcomm implements Serializable{

    //项目Id
    private Integer projectId;
    //项目根节点id
    private Integer projectRootId;
    //捆绑商品Id
    private Integer bindComId;
    //捆绑商品名称
    private String bindComName;
    //捆绑商品规格
    private String bindComSpec;
    //捆绑商品单位id
    private Integer bindCmoUnit;
    //捆绑零售价
    private BigDecimal bindSellPrice;
    //捆绑商品价格等级id
    private Integer gradeId;
    //捆绑商品条码
    private String bindComBarcode;
    //捆绑商品编码
    private String bindComCode;
    //创建人
    private Long creater;
    //创建时间
    private Date createTime;
    //修改人
    private Long modifier;
    //修改时间
    private Date updTime;
    //审核人
    private Long BLEmpId;
    //审核时间
    private Date BLTime;
    //状态
    private Integer BCStatus;

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

    public Integer getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Integer projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getBindComName() {
        return bindComName;
    }

    public void setBindComName(String bindComName) {
        this.bindComName = bindComName == null ? null : bindComName.trim();
    }

    public String getBindComSpec() {
        return bindComSpec;
    }

    public void setBindComSpec(String bindComSpec) {
        this.bindComSpec = bindComSpec == null ? null : bindComSpec.trim();
    }

    public Integer getBindCmoUnit() {
        return bindCmoUnit;
    }

    public void setBindCmoUnit(Integer bindCmoUnit) {
        this.bindCmoUnit = bindCmoUnit;
    }

    public BigDecimal getBindSellPrice() {
        return bindSellPrice;
    }

    public void setBindSellPrice(BigDecimal bindSellPrice) {
        this.bindSellPrice = bindSellPrice;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getBindComBarcode() {
        return bindComBarcode;
    }

    public void setBindComBarcode(String bindComBarcode) {
        this.bindComBarcode = bindComBarcode == null ? null : bindComBarcode.trim();
    }

    public String getBindComCode() {
        return bindComCode;
    }

    public void setBindComCode(String bindComCode) {
        this.bindComCode = bindComCode == null ? null : bindComCode.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Long getBLEmpId() {
        return BLEmpId;
    }

    public void setBLEmpId(Long BLEmpId) {
        this.BLEmpId = BLEmpId;
    }

    public Date getBLTime() {
        return BLTime;
    }

    public void setBLTime(Date BLTime) {
        this.BLTime = BLTime;
    }

    public Integer getBCStatus() {
        return BCStatus;
    }

    public void setBCStatus(Integer BCStatus) {
        this.BCStatus = BCStatus;
    }
}