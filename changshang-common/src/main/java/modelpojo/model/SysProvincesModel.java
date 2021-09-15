package modelpojo.model;

import java.io.Serializable;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/11
 */
public class SysProvincesModel implements Serializable {
    private static final long serialVersionUID = -8197282360998915850L;
    private Long id;
    private String provinceid;
    private String province;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
