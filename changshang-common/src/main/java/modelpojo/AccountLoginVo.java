package modelpojo;

import modelpojo.model.OrgInfoModel;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ming.jin
 * @Date 2018/8/7
 */
public class AccountLoginVo implements Serializable{

    private String name;

    private String accountType;

    private List<OrgInfoModel> manageOrgs;

    private String token;
    /**
     * token失效时间
     */
    private String tokenFailureTime;
    /**
     * 是否为顶级节点管理员
     */
    private String isRootOrgManager;

    public String getTokenFailureTime() {
        return tokenFailureTime;
    }

    public void setTokenFailureTime(String tokenFailureTime) {
        this.tokenFailureTime = tokenFailureTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrgInfoModel> getManageOrgs() {
        return manageOrgs;
    }

    public void setManageOrgs(List<OrgInfoModel> manageOrgs) {
        this.manageOrgs = manageOrgs;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIsRootOrgManager() {
        return isRootOrgManager;
    }

    public void setIsRootOrgManager(String isRootOrgManager) {
        this.isRootOrgManager = isRootOrgManager;
    }
}
