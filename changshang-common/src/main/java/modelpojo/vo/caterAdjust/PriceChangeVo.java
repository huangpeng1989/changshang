package modelpojo.vo.caterAdjust;

import java.io.Serializable;

/**
 * @Description 调价单审核存储过程返回类
 * @Author wenbin.wang
 * @Date 2020-03-02 11:13
 */
public class PriceChangeVo implements Serializable {

    private static final long serialVersionUID = 485050723199906654L;


    /**
     *
     */
    private String message ;
    private Boolean code;

    private Boolean rscode;

    private String msg;

    public Boolean getRscode() {
        return rscode;
    }

    public void setRscode(Boolean rscode) {
        this.rscode = rscode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }
}
