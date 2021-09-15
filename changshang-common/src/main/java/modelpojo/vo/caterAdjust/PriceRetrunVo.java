package modelpojo.vo.caterAdjust;

import java.io.Serializable;

/**
 * @Description 调价单审导入模板返回类
 * @Author lixiang
 * @Date 2020-08-16 11:13
 */
public class PriceRetrunVo implements Serializable {

    private static final long serialVersionUID = 485050723199906654L;

    private String message ;

    private String startDate;

    private String endDate;

    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
