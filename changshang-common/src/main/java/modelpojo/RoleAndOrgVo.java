package modelpojo;

import modelpojo.model.account.RolePrivModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author bin.yu
 * @create 2018-09-12 17:57
 **/
public class RoleAndOrgVo implements Serializable {

    private static final long serialVersionUID = 2253043987170737012L;

    private Long orgId;
    private String orgName;
    private List<RolePrivModel> rolePrivModels;



    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<RolePrivModel> getRolePrivModels() {
        return rolePrivModels;
    }

    public void setRolePrivModels(List<RolePrivModel> rolePrivModels) {
        this.rolePrivModels = rolePrivModels;
    }
}
