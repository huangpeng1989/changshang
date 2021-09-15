package modelpojo.vo.cateioflow;

import java.io.Serializable;

/**
 * @program: phaseiiclota
 * @description: 仓库数据
 * @author: panda
 * @create: 2019-11-19 18:36
 **/
public class House implements Serializable{
    private Integer whId;//

    private String whCode;//

    private String whName;//

    private Integer gzoneId;//

    private Long projectId;//

    private Long upProjectId;//

    private Long upProjectRootId;//

    private Integer whLevel;//

    private String levelName;//

    private Long orgId;//

    private String orgName;//

    private Long companyId;//

    private String companyName;//

    private Long blocId;//

    private String blocName;//

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUpProjectId() {
        return upProjectId;
    }

    public void setUpProjectId(Long upProjectId) {
        this.upProjectId = upProjectId;
    }

    public Long getUpProjectRootId() {
        return upProjectRootId;
    }

    public void setUpProjectRootId(Long upProjectRootId) {
        this.upProjectRootId = upProjectRootId;
    }

    public Integer getWhLevel() {
        return whLevel;
    }

    public void setWhLevel(Integer whLevel) {
        this.whLevel = whLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getBlocId() {
        return blocId;
    }

    public void setBlocId(Long blocId) {
        this.blocId = blocId;
    }

    public String getBlocName() {
        return blocName;
    }

    public void setBlocName(String blocName) {
        this.blocName = blocName;
    }
}
