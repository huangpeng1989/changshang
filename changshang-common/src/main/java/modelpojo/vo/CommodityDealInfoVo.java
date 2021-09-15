package modelpojo.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-12-01 17:12
 */
public class CommodityDealInfoVo implements Serializable {


    private static final long serialVersionUID = -4542179819040023798L;


    private String comClassCode;

    private Integer index;
    private String projectId;

    private String gzoneId;

    private String comKey;
    private String payName;


    private String createdStartTime;

    private String createdEndTime;
    private String cellName;
    private String spmodes;

    private Integer sellMode;

    private Integer pageNo;
    private Integer pageSize;
    private Integer type;

    private String comNdealId;

    public String getComNdealId() {
        return comNdealId;
    }

    public void setComNdealId(String comNdealId) {
        this.comNdealId = comNdealId;
    }

    public String getSpmodes() {
        return spmodes;
    }

    public void setSpmodes(String spmodes) {
        this.spmodes = spmodes;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public String getComKey() {
        return comKey;
    }

    public void setComKey(String comKey) {
        this.comKey = comKey;
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode;
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

    public Integer getSellMode() {
        return sellMode;
    }

    public void setSellMode(Integer sellMode) {
        this.sellMode = sellMode;
    }

}
