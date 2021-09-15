package modelpojo.vo;

import modelpojo.model.CateringTcjAdjustDetail;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-02-14 15:41
 */
public class CateringTcjAdjustDetailVo extends CateringTcjAdjustDetail {

    private String suppCode;

    private String suppName;

    private String rmCode;

    private String rmName;

    private String startDate;

    private String endDate;

    @Override
    public String getSuppCode() {
        return suppCode;
    }

    @Override
    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    @Override
    public String getSuppName() {
        return suppName;
    }

    @Override
    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    @Override
    public String getRmName() {
        return rmName;
    }

    @Override
    public void setRmName(String rmName) {
        this.rmName = rmName;
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
}
