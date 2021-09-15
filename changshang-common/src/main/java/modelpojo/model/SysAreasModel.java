package modelpojo.model;

import java.io.Serializable;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/11
 */
public class SysAreasModel implements Serializable {
    private static final long serialVersionUID = -1969503679124605960L;
    private Long id;
    private String areaid;
    private String area;
    private String cityid;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
