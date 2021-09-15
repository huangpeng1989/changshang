package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CommodityBindCommDetailComDto implements Serializable {


    private Long projectId;// 捆绑商品id


    private String bindComId;//捆绑商品id

    private String bindComCode;//捆绑商品编号

    private String bindComName;//捆绑商品名称

    private String bindComSpec;//商品规格

    private Integer bindComUnit;//捆绑商品单位

    private Integer gradeId;//价格等级

    private BigDecimal bindSellPrice;//捆绑商品零售价

    private String bindComBarcode;//捆绑商品条码

    private Integer bcStatus;//提交状态

    private Date createdTime;//创建时间

    private List<BindCommDetailVo> bindCommDetailVoList;//明细商品集合

    private String unitName;//code转中文

    private String statusName;//

    private String bindComUnitName;//

    private String gradeName;//

    private Long creater;//创建人

    private String createrName;//创建人

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getBindComUnitName() {
        return bindComUnitName;
    }

    public void setBindComUnitName(String bindComUnitName) {
        this.bindComUnitName = bindComUnitName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<BindCommDetailVo> getBindCommDetailVoList() {
        return bindCommDetailVoList;
    }

    public void setBindCommDetailVoList(List<BindCommDetailVo> bindCommDetailVoList) {
        this.bindCommDetailVoList = bindCommDetailVoList;
    }

    public String getBindComId() {
        return bindComId;
    }

    public void setBindComId(String bindComId) {
        this.bindComId = bindComId;
    }

    public String getBindComCode() {
        return bindComCode;
    }

    public void setBindComCode(String bindComCode) {
        this.bindComCode = bindComCode;
    }

    public String getBindComName() {
        return bindComName;
    }

    public void setBindComName(String bindComName) {
        this.bindComName = bindComName;
    }

    public String getBindComSpec() {
        return bindComSpec;
    }

    public void setBindComSpec(String bindComSpec) {
        this.bindComSpec = bindComSpec;
    }

    public Integer getBindComUnit() {
        return bindComUnit;
    }

    public void setBindComUnit(Integer bindComUnit) {
        this.bindComUnit = bindComUnit;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public BigDecimal getBindSellPrice() {
        return bindSellPrice;
    }

    public void setBindSellPrice(BigDecimal bindSellPrice) {
        this.bindSellPrice = bindSellPrice;
    }

    public String getBindComBarcode() {
        return bindComBarcode;
    }

    public void setBindComBarcode(String bindComBarcode) {
        this.bindComBarcode = bindComBarcode;
    }

    public Integer getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(Integer bcStatus) {
        this.bcStatus = bcStatus;
    }
}
