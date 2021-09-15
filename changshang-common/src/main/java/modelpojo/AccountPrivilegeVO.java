package modelpojo;

import modelpojo.model.account.PrivilegeModel;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ming.jin
 * @Date 2018/8/22
 */
public class AccountPrivilegeVO implements Serializable{

    private String orgName;

    private List<PrivilegeModel> privilegeModels;

    private String token;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<PrivilegeModel> getPrivilegeModels() {
        return privilegeModels;
    }

    public void setPrivilegeModels(List<PrivilegeModel> privilegeModels) {
        this.privilegeModels = privilegeModels;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
