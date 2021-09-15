package modelpojo.vo;

import java.io.Serializable;
import java.util.List;

public class DeptCompanyVo implements Serializable {
    private Long id;

    private String orgName;

    private List<AccountVo> accountVoList;

    public List<AccountVo> getAccountVoList() {
        return accountVoList;
    }

    public void setAccountVoList(List<AccountVo> accountVoList) {
        this.accountVoList = accountVoList;
    }

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
}
