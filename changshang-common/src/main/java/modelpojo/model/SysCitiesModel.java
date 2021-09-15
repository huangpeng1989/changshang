package modelpojo.model;

import java.io.Serializable;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/11
 */
public class SysCitiesModel implements Serializable {
    private static final long serialVersionUID = 2852823601370733593L;
    private Long id;
    private String cityid;
    private String city;
    private String provinceid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
