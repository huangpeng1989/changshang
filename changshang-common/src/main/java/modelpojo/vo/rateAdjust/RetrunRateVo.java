package modelpojo.vo.rateAdjust;

import java.io.Serializable;
import java.util.Date;

public class RetrunRateVo implements Serializable {

    private static final long serialVersionUID = 485050723199906654L;

    private String message ;

    private Date startDate;

    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
