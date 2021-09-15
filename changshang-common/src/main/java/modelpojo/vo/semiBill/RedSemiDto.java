package modelpojo.vo.semiBill;

import java.io.Serializable;
import java.util.Date;

public class RedSemiDto implements Serializable {
    private Integer spdtBillId;

    private String spdtBillCode;

    private Date processDate;

    private Integer paymentdaysId;

    private Date paymentdaysDate;

    private Integer whId;

    private String whName;

    private String paymentName;

    private String whCode;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public Integer getSpdtBillId() {
        return spdtBillId;
    }

    public void setSpdtBillId(Integer spdtBillId) {
        this.spdtBillId = spdtBillId;
    }

    public String getSpdtBillCode() {
        return spdtBillCode;
    }

    public void setSpdtBillCode(String spdtBillCode) {
        this.spdtBillCode = spdtBillCode;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Integer getPaymentdaysId() {
        return paymentdaysId;
    }

    public void setPaymentdaysId(Integer paymentdaysId) {
        this.paymentdaysId = paymentdaysId;
    }

    public Date getPaymentdaysDate() {
        return paymentdaysDate;
    }

    public void setPaymentdaysDate(Date paymentdaysDate) {
        this.paymentdaysDate = paymentdaysDate;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
