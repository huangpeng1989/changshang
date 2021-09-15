package modelpojo.vo;

import modelpojo.model.CommodityTcbCom;

import java.io.Serializable;


/**
 * 商品基础信息扩展表
 */
public class CommodityTcbComVo extends CommodityTcbCom implements Serializable {

    //接收
    private Integer pageNo;
    private Integer pageSize;
    private Integer comClassId;
    private Integer ucomClassId;
    private String comClassName;
    private String ucomClassCode;

    public String getUcomClassCode() {
        return ucomClassCode;
    }

    public void setUcomClassCode(String ucomClassCode) {
        this.ucomClassCode = ucomClassCode;
    }

    public String getComClassName() {
        return comClassName;
    }

    public void setComClassName(String comClassName) {
        this.comClassName = comClassName;
    }

    public Integer getComClassId() {
        return comClassId;
    }

    public void setComClassId(Integer comClassId) {
        this.comClassId = comClassId;
    }

    public Integer getUcomClassId() {
        return ucomClassId;
    }

    public void setUcomClassId(Integer ucomClassId) {
        this.ucomClassId = ucomClassId;
    }

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

    //销售商品编号(商品销售信息表)
    private String saleComCode;



    public String getSaleComCode() {
        return saleComCode;
    }

    public void setSaleComCode(String saleComCode) {
        this.saleComCode = saleComCode;
    }




    //项目ID
    private Long projectId;
    //商品分类编号
    private String comClassCode;
    //经营方式
    private Integer sellModel;
    //商品销售状态
    private Integer sellStatus;
    //可售商品审核状态
    private String scStatus;
    //商品名称
    private String comName;
    //商品编号
    private String comCode;
    //供应商名称
    private String suppName;
    //供应商编号
    private  String suppCode;
    //商品类型

    private Integer comId;//商品id
    private int isDelete;//是否删除

    private String spellCode; //拼音编码

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
    }

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }


}
