package modelpojo;

import java.io.Serializable;

/**
 * @Author ming.jin
 * @Date 2018/9/8
 */
public class CompanyManagerVo implements Serializable{

    private static final long serialVersionUID = -3496979773054096313L;

    private Long id;

    private String nickName;

    private String loginName;

    private Long orgId;

    private String orgName;

    private String nodeCode;

    private String checkinCode;

    private String telephone;

    private String tex;

    private String email;

    private String province;

    private String city;

    private String district;

    private String address;

    private String smsProvider;

    private Integer smsAmount;

    private String ServiceUser;

    private String parentManage;

    private String parentFinanc;

    private String employeeType;

    private String provinceName;
    private String cityName;
    private String districtName;
    // 全名邀请码
    private String saleCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getCheckinCode() {
        return checkinCode;
    }

    public void setCheckinCode(String checkinCode) {
        this.checkinCode = checkinCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSmsProvider() {
        return smsProvider;
    }

    public void setSmsProvider(String smsProvider) {
        this.smsProvider = smsProvider;
    }

    public Integer getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(Integer smsAmount) {
        this.smsAmount = smsAmount;
    }

    public String getServiceUser() {
        return ServiceUser;
    }

    public void setServiceUser(String serviceUser) {
        ServiceUser = serviceUser;
    }

    public String getParentManage() {
        return parentManage;
    }

    public void setParentManage(String parentManage) {
        this.parentManage = parentManage;
    }

    public String getParentFinanc() {
        return parentFinanc;
    }

    public void setParentFinanc(String parentFinanc) {
        this.parentFinanc = parentFinanc;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }
}
