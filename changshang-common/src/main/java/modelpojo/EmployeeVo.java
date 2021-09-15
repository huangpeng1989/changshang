package modelpojo;



import java.io.Serializable;
import java.util.List;

/**
 * @Author ming.jin
 * @Date 2018/9/6
 */
public class EmployeeVo implements Serializable{

    private static final long serialVersionUID = 655160933058226006L;

    private Long id;

    private String sex;

    private String birthday;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String districtId;

    private String address;

    private String descript;

    private String nickName;

    private String loginName;

    private String deptName;

    private String orgName;

    private String roleName;

    private String phone;

    private String employeeType;

    private Long deptId;



    /**
     * account表status
     */
    private String status;

    private String password;
    /**
     * 是否限制订单权限
     */
    private String limitOrderPrivilege;

    /**
     * 是否开通手机报权限：true/false
     */
    private String phoneReportPrivilege;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


    public String getLimitOrderPrivilege() {
        return limitOrderPrivilege;
    }

    public void setLimitOrderPrivilege(String limitOrderPrivilege) {
        this.limitOrderPrivilege = limitOrderPrivilege;
    }

    public String getPhoneReportPrivilege() {
        return phoneReportPrivilege;
    }

    public void setPhoneReportPrivilege(String phoneReportPrivilege) {
        this.phoneReportPrivilege = phoneReportPrivilege;
    }
}
