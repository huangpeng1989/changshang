package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CommodityBindCommDetailComVo implements Serializable {



    private Long projectId;

    private String suppName;//供应商名称

    private String comClassCode; //分类编号

    private String comName;//商品名称

    private Integer dicId;//关联字典表


    //=============================捆绑商品保存数据主表
    private String bindComCode;//捆绑商品编号

    private String bindComName;//捆绑商品名称

    private String bindComSpec;//商品规格

    private Integer bindComUnit;//捆绑商品单位

    private Integer gradeId;//价格等级

    private BigDecimal bindSellPrice;//捆绑商品零售价

    private String bindComBarcode;//捆绑商品条码

    private Integer bcStatus;//提交状态

    private List<BindCommDetailVo> bindCommDetailVoList;//明细商品集合

    private Integer bindComId;//捆绑商品id

    private String bindDetail; //明细数据
    //=============================捆绑商品保存数据主表


    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getBindDetail() {
        return bindDetail;
    }

    public void setBindDetail(String bindDetail) {
        this.bindDetail = bindDetail;
    }

    public Integer getBindComId() {
        return bindComId;
    }

    public void setBindComId(Integer bindComId) {
        this.bindComId = bindComId;
    }

    public List<BindCommDetailVo> getBindCommDetailVoList() {
        return bindCommDetailVoList;
    }

    public void setBindCommDetailVoList(List<BindCommDetailVo> bindCommDetailVoList) {
        this.bindCommDetailVoList = bindCommDetailVoList;
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

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }
}
