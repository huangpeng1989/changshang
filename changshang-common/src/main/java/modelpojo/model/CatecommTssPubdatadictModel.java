package modelpojo.model;

import java.io.Serializable;

public class CatecommTssPubdatadictModel implements Serializable {
    private static final long serialVersionUID = 3614409332050111991L;
    private Integer typeCode;

    private Integer pDictId;

    private Integer pDictType;

    private String pDictName;

    private String typeName;

    private Integer pDictStatus;

    private String remark;

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

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
        this.pDictName = pDictName == null ? null : pDictName.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }
}
