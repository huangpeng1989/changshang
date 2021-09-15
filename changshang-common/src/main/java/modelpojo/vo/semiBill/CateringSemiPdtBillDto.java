package modelpojo.vo.semiBill;

import java.util.List;

public class CateringSemiPdtBillDto extends CateringSemiPdtBill {

    private String gzoneName ;
    private String gzoneCode ;
    private String statusName ;
    private String createrName ;
    private String blEmpIdName ;
    private String whName ;
    private String whCode ;

    private String paymentName;//账期名称

    private Integer jurisdictionType;//权限类型

    private Integer whId;

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(Integer jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhCode() {

        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getBlEmpIdName() {
        return blEmpIdName;
    }

    public void setBlEmpIdName(String blEmpIdName) {
        this.blEmpIdName = blEmpIdName;
    }

    private List<CateringSemiPdtBillDtl> list;

    public List<CateringSemiPdtBillDtl> getList() {
        return list;
    }

    public void setList(List<CateringSemiPdtBillDtl> list) {
        this.list = list;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }

    public String getGzoneCode() {
        return gzoneCode;
    }

    public void setGzoneCode(String gzoneCode) {
        this.gzoneCode = gzoneCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }
}