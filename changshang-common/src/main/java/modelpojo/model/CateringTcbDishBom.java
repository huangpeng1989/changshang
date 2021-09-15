package modelpojo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CateringTcbDishBom  implements Serializable {
    private Long projectRootId;

    private String dishBomCode;

    private Integer dishId;

    private String dishCode;

    private String remark;

    private String state;

    private Byte isDelete;

    private Integer dbStatus;

    private Date createdTime;

    private Long creater;

    private Long blEmpId;

    private Date blTime;

    private Long modifier;

    private Date updatedTime;

    private Integer dishBomId;

    private Long projectId;

    private String dishName;


    private Integer dishType;

    private String statusName;

    private String nickName;

    private  String blEmpName;

    public String getBlEmpName() {
        return blEmpName;
    }

    public void setBlEmpName(String blEmpName) {
        this.blEmpName = blEmpName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    private List<CateringTcbDishBomDetail> dishBomDetail=new ArrayList<CateringTcbDishBomDetail>();


    public List<CateringTcbDishBomDetail> getDishBomDetail() {
        return dishBomDetail;
    }

    public void setDishBomDetail(List<CateringTcbDishBomDetail> dishBomDetail) {
        this.dishBomDetail = dishBomDetail;
    }




    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }




    public Integer getDishBomId() {
        return dishBomId;
    }

    public void setDishBomId(Integer dishBomId) {
        this.dishBomId = dishBomId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getDishBomCode() {
        return dishBomCode;
    }

    public void setDishBomCode(String dishBomCode) {
        this.dishBomCode = dishBomCode == null ? null : dishBomCode.trim();
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(Integer dbStatus) {
        this.dbStatus = dbStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getBlEmpId() {
        return blEmpId;
    }

    public void setBlEmpId(Long blEmpId) {
        this.blEmpId = blEmpId;
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}