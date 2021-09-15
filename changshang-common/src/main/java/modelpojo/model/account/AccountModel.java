package modelpojo.model.account;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author ming.jin
 * @Date 2018/8/7
 */
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 6163519136084317397L;

    private Long id;
    private String loginName;
    private String password;
    private String phone;
    private Long orgId;
    private Long companyId;
    private String accountType;
    private String email;
    private String nickName;
    private String avatar;
    private String source;
    private Long levelId;
    private Date firstLoginTime;
    private Date lastLoginTime;
    private String finishGuide;
    private Long createUser;
    private Date createdTime;
    private Long updateUser;
    private Date updatedTime;
    private String birthday;
    private Long provinceId;
    private Long cityId;
    private Long districtId;
    private String address;
    private String status;
    private String descript;
    private String sex;
    private String isDeleted;
    private Long deptId;
    private  String jwt;


    /**
     * 上次修改密码时间
     */
    private Date lastModifyPwdTime;
    /**
     * 是否限制订单权限: true/false
     */
    private String limitOrderPrivilege;
    /**
     * 是否开通手机报权限：true/false
     */
    private String phoneReportPrivilege;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getFinishGuide() {
        return finishGuide;
    }

    public void setFinishGuide(String finishGuide) {
        this.finishGuide = finishGuide;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getLastModifyPwdTime() {
        return lastModifyPwdTime;
    }

    public void setLastModifyPwdTime(Date lastModifyPwdTime) {
        this.lastModifyPwdTime = lastModifyPwdTime;
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
