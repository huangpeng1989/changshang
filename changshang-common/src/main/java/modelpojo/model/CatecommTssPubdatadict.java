package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-08-27 18:49
 */
public class CatecommTssPubdatadict implements Serializable {
    private static final long serialVersionUID = 7806155473712555892L;

    private Integer pDictId;
    private Integer pDictType;
    private String pDictName;

    public Integer getpDictId() {
        return pDictId;
    }

    public void setpDictId(Integer pDictId) {
        this.pDictId = pDictId;
    }

    public Integer getpDictType() {
        return pDictType;
    }

    public void setpDictType(Integer pDictType) {
        this.pDictType = pDictType;
    }

    public String getpDictName() {
        return pDictName;
    }

    public void setpDictName(String pDictName) {
        this.pDictName = pDictName;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getpDictStatus() {
        return pDictStatus;
    }

    public void setpDictStatus(Integer pDictStatus) {
        this.pDictStatus = pDictStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Integer typeCode;
    private String typeName;
    private Integer pDictStatus;
    private String remark;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    private Date createdTime;

    private Date updatedTime;
}
