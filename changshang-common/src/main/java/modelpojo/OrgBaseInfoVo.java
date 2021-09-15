package modelpojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/7
 */
public class OrgBaseInfoVo implements Serializable {
    private static final long serialVersionUID = 371581057356248546L;
    /**
     * 公司ID
     */
    private Long id;
    /**
     * 公司名称
     */
    private String orgName;
    /**
     * 状态：启用-open，未启用-close
     */
    private String status;
    /**
     * 公司编码
     */
    private String nodeCode;
    /**
     * 核销编码
     */
    private String checkinCode;
    /**
     * 全民分销编码
     */
    private String saleCode;
    /**
     * 短信服务商
     */
    private String smsProvider;
    /**
     * 管理账号ID
     */
    private Long managerId;
    /**
     * 管理账号
     */
    private String manager;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 联系人
     */
    private String linkName;
    /**
     * 省编码
     */
    private String provinceCode;
    /**
     * 省
     */
    private String province;
    /**
     * 市编码
     */
    private String cityCode;
    /**
     * 市
     */
    private String city;
    /**
     * 县编码
     */
    private String districtCode;
    /**
     * 县
     */
    private String district;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 传真
     */
    private String tex;
    /**
     * 管理上级ID
     */
    private Long parentManageId;
    /**
     * 管理上级
     */
    private String parentManager;
    /**
     * 财务上级ID
     */
    private Long parentEconomicId;
    /**
     * 财务上级
     */
    private String parentEconomic;
    /**
     * 短信余量
     */
    private Integer smsCount;
    /**
     * 短信累计购买量
     */
    private Integer totalSmsCount;
    /**
     * 客服
     */
    private String customerService;

    private String nodeType;

    private Long rootId;

    private Long smsProviderId;

    //外部接口 新增款台信息
    /**
     * 服务器名称
     */
    private String serverUrl;

    /**
     * 销售分组
     */
    private String saleGroupName;

    /**
     * 核销分组
     */
    private String checkGroupName;

    private Boolean disabled;

    private Long manageCompanyId;
    /**
     * ota配置参数
     */
    private String otaParamJson;
    /**
     * 景区介绍
     */
    private String introduction;
    /**
     * 景区地图
     */
    private String locationPic;
    /**
     * 销售人员id
     */
    private Long salerId;
    /**
     * 销售人员
     */
    private String saleman;

    private String isShow;
    /**
     * 企业秘钥
     */
    private String secretCode;


    private List<OrgBaseInfoVo> subNodes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getSmsProvider() {
        return smsProvider;
    }

    public void setSmsProvider(String smsProvider) {
        this.smsProvider = smsProvider;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
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

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getParentManager() {
        return parentManager;
    }

    public void setParentManager(String parentManager) {
        this.parentManager = parentManager;
    }

    public String getParentEconomic() {
        return parentEconomic;
    }

    public void setParentEconomic(String parentEconomic) {
        this.parentEconomic = parentEconomic;
    }

    public Long getParentManageId() {
        return parentManageId;
    }

    public void setParentManageId(Long parentManageId) {
        this.parentManageId = parentManageId;
    }

    public Long getParentEconomicId() {
        return parentEconomicId;
    }

    public void setParentEconomicId(Long parentEconomicId) {
        this.parentEconomicId = parentEconomicId;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public Integer getTotalSmsCount() {
        return totalSmsCount;
    }

    public void setTotalSmsCount(Integer totalSmsCount) {
        this.totalSmsCount = totalSmsCount;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getRootId() {
        return rootId;
    }

    public Long getSmsProviderId() {
        return smsProviderId;
    }

    public void setSmsProviderId(Long smsProviderId) {
        this.smsProviderId = smsProviderId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSaleGroupName() {
        return saleGroupName;
    }

    public void setSaleGroupName(String saleGroupName) {
        this.saleGroupName = saleGroupName;
    }

    public String getCheckGroupName() {
        return checkGroupName;
    }

    public void setCheckGroupName(String checkGroupName) {
        this.checkGroupName = checkGroupName;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<OrgBaseInfoVo> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(List<OrgBaseInfoVo> subNodes) {
        this.subNodes = subNodes;
    }

    public Long getManageCompanyId() {
        return manageCompanyId;
    }

    public void setManageCompanyId(Long manageCompanyId) {
        this.manageCompanyId = manageCompanyId;
    }

    public String getOtaParamJson() {
        return otaParamJson;
    }

    public void setOtaParamJson(String otaParamJson) {
        this.otaParamJson = otaParamJson;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocationPic() {
        return locationPic;
    }

    public void setLocationPic(String locationPic) {
        this.locationPic = locationPic;
    }

    public Long getSalerId() {
        return salerId;
    }

    public void setSalerId(Long salerId) {
        this.salerId = salerId;
    }

    public String getSaleman() {
        return saleman;
    }

    public void setSaleman(String saleman) {
        this.saleman = saleman;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
