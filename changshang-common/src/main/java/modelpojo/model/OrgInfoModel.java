package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: yu.li
 * @Date: 2019/07/09
 */
public class OrgInfoModel implements Serializable{
    private Long id;
    private Long orgId;
    private Long companyId;
    private String ruleType;
    private String orgName;

    /**
     * 规则内容
     * [
     {
     "format": "ticket",--业态
     "ruleContent": [
     {
     "name": "teamBookingAuditRules/verifyPriorityRule/otaOrderSms/sms",--规则名称
     "vale": ""--值
     }
     ]
     }
     ]
     */
    private String content;
    private Long createUser;
    private Date createdTime;
    private Long updateUser;
    private Date updatedTime;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
