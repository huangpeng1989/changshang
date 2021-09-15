package modelpojo.model.account;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 *
 * @Author ming.jin
 * @Date 2018/8/7
 */
public class PrivilegeModel implements Serializable{

    private static final long serialVersionUID = -605885037626989975L;

    private String privType;

    private String privCode;

    private String path;

    private String ranges;

    private Long privOrg;

    /**
     * 经营权限manage/财务权限economic
     */
    private String orgType;
    /**
     * 前端选择状态
     */
    private String choseStatus;

    private String linkedPrivCode;
    private String showMenu;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        PrivilegeModel that = (PrivilegeModel) o;

        return new EqualsBuilder()
                .append(privCode, that.privCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(privCode)
                .toHashCode();
    }

    public String getPrivType() {
        return privType;
    }

    public void setPrivType(String privType) {
        this.privType = privType;
    }

    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRanges() {
        return ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public Long getPrivOrg() {
        return privOrg;
    }

    public void setPrivOrg(Long privOrg) {
        this.privOrg = privOrg;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getChoseStatus() {
        return choseStatus;
    }

    public void setChoseStatus(String choseStatus) {
        this.choseStatus = choseStatus;
    }

    public String getLinkedPrivCode() {
        return linkedPrivCode;
    }

    public void setLinkedPrivCode(String linkedPrivCode) {
        this.linkedPrivCode = linkedPrivCode;
    }

    public String getShowMenu() {
        return showMenu;
    }

    public void setShowMenu(String showMenu) {
        this.showMenu = showMenu;
    }
}
