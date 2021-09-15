package modelpojo.model.account;


import java.io.Serializable;
import java.util.Date;

/**
 * @Author ming.jin
 * @Date 2018/8/7
 */
public class RolePrivModel implements Serializable{

    private static final long serialVersionUID = 4417000959380253455L;
    private Long id;

    private Long roleId;

    private Long privOrg;

    private String privType;

    private String privCode;

    private String path;

    private String ranges;

    private Long createUser;

    private Date createdTime;

    private Long updateUser;

    private Date updatedTime;

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

    public PrivilegeModel getPrivilegetModel(){
        PrivilegeModel privilege = new PrivilegeModel();
        privilege.setPrivOrg(this.privOrg);
        privilege.setPrivType(this.privType);
        privilege.setPrivCode(this.privCode);
        privilege.setPath(this.path);
        privilege.setRanges(this.ranges);
        privilege.setLinkedPrivCode(this.linkedPrivCode);
        privilege.setChoseStatus(this.choseStatus);
        privilege.setShowMenu(this.showMenu);
        return privilege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivOrg() {
        return privOrg;
    }

    public void setPrivOrg(Long privOrg) {
        this.privOrg = privOrg;
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
