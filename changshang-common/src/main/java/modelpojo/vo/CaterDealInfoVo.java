package modelpojo.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-01 22:48
 */
public class CaterDealInfoVo implements Serializable {
    private static final long serialVersionUID = -6881597228023744916L;

    private String rmcCode;

    private Integer index;
    private Integer goodType;  // 类型 菜品/原材料
    private String projectId;

    private String gzoneId;

    private String rmKey;


    private String createdStartTime;

    private String createdEndTime;
    private String cellName;


    private Integer pageNo;
    private Integer pageSize;

    private String sellModel;


    private Integer type;

    // 交易单号
    private String cateNdealId;

    public String getCateNdealId() {
        return cateNdealId;
    }

    public void setCateNdealId(String cateNdealId) {
        this.cateNdealId = cateNdealId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getRmcCode() {
        return rmcCode;
    }

    public void setRmcCode(String rmcCode) {
        this.rmcCode = rmcCode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(String gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getRmKey() {
        return rmKey;
    }

    public void setRmKey(String rmKey) {
        this.rmKey = rmKey;
    }

    public String getCreatedStartTime() {
        return createdStartTime;
    }

    public void setCreatedStartTime(String createdStartTime) {
        this.createdStartTime = createdStartTime;
    }

    public String getCreatedEndTime() {
        return createdEndTime;
    }

    public void setCreatedEndTime(String createdEndTime) {
        this.createdEndTime = createdEndTime;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
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
}
