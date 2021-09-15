package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/****
 * 库存查询线下接口vo类
 */
public class SycnOnlineDataVo implements Serializable {

    private Long projectId;
    private Integer parkId;
    private Integer gzoneId;
    private Integer whId;
    private Integer moduleId;
    private Integer comId;
    private Integer goodType;
    private BigDecimal stcNum;
    private Date lastSyncTime;
    private Long projectRootid;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public BigDecimal getStcNum() {
        return stcNum;
    }

    public void setStcNum(BigDecimal stcNum) {
        this.stcNum = stcNum;
    }

    public Date getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(Date lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public Long getProjectRootid() {
        return projectRootid;
    }

    public void setProjectRootid(Long projectRootid) {
        this.projectRootid = projectRootid;
    }
}
