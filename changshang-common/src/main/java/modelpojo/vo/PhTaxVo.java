package modelpojo.vo;

import java.io.Serializable;

public class PhTaxVo implements Serializable {

    private String rmPhCode;

    private Integer rmId;

    private Integer comId;

    private String comPhCode;

    public String getComPhCode() {
        return comPhCode;
    }

    public void setComPhCode(String comPhCode) {
        this.comPhCode = comPhCode;
    }

    public String getRmPhCode() {
        return rmPhCode;
    }

    public void setRmPhCode(String rmPhCode) {
        this.rmPhCode = rmPhCode;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }
}
