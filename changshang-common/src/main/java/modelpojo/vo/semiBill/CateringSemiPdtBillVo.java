package modelpojo.vo.semiBill;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CateringSemiPdtBillVo extends CateringSemiPdtBill {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date startTime;//开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , locale="zh",timezone = "GMT+8")
    private Date endTime;//结束时间

    private String deteilList;//半成品详情

    private String dishName;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    private String rmName;

    private List<CateringSemiPdtBillDtl> cateringSemiPdtBillDtlList;//半成品详情

    public List<CateringSemiPdtBillDtl> getCateringSemiPdtBillDtlList() {
        return cateringSemiPdtBillDtlList;
    }

    public void setCateringSemiPdtBillDtlList(List<CateringSemiPdtBillDtl> cateringSemiPdtBillDtlList) {
        this.cateringSemiPdtBillDtlList = cateringSemiPdtBillDtlList;
    }

    public String getDeteilList() {
        return deteilList;
    }

    public void setDeteilList(String deteilList) {
        this.deteilList = deteilList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
