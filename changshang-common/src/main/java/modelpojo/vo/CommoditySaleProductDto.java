package modelpojo.vo;

import java.io.Serializable;

public class CommoditySaleProductDto implements Serializable {

    private String comClassCode;//商品分类编号
    private String comName;//商品名称
    private String createTime;//商品的录入区间日期
    private String suppCode;//供应商编号
    private String suppName;  //供应商名称
    private String queryType; //查询字段类型
    private String transcriptionComName ; //拼音码
    private String whinBillCode ; //采购单号
    private String altInBillCode ; //调入单号
    private Integer type; // 区分按什么查询  0：全部 1:按采购单 2:按调入单  3:按商品名称 4：按商品录入日前 5：按供应商

    private Integer gradeId;//价格等级

    private String comCode;

    public String getWhinBillCode() {
        return whinBillCode;
    }

    public void setWhinBillCode(String whinBillCode) {
        this.whinBillCode = whinBillCode;
    }

    public String getAltInBillCode() {
        return altInBillCode;
    }

    public void setAltInBillCode(String altInBillCode) {
        this.altInBillCode = altInBillCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getTranscriptionComName() {
        return transcriptionComName;
    }

    public void setTranscriptionComName(String transcriptionComName) {
        this.transcriptionComName = transcriptionComName;
    }
}
