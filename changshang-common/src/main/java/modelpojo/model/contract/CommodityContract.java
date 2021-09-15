package modelpojo.model.contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-12-31
 */
public class CommodityContract implements Serializable {

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 商品合同id
     **/
    private  Integer contractId;
    /**
     * 项目根节点id
     */
    private Long projectRootId;

    /**
     * 商品合同编号
     */
    private String contractCode;

    /**
     * 原商品合同code编号
     */
    private String oldContractCode;

    /**
     * 商品合同名称
     */
    private String contractName;

    /**
     * 商品纸质合同号
     */
    private String contractNumber;

    /**
     * 商品合同类型
     */
    private String contractType;

    /**
     * 商品合同经营方式
     */
    private String contractSellModel;

    /**
     * 商品合同员id
     */
    private Long contractNick;

    /**
     * 商品合同公司id
     */
    private Long contractOrg;

    /**
     * 商品合同供应商id
     */
    private Integer contractSupper;

    /**
     * 商品合同供应商编码
     */
    private String contractSupperCode;

    /**
     * 商品合同签定人
     */
    private String contractSignedby;

    /**
     * 商品合同签定地址
     */
    private String contractSignedAddress;

    /**
     * 商品合同签定时间
     */
    private Date contractSignedTime;

    /**
     * 商品合同双方签定人
     */
    private String contractDoubleSignedby;

    /**
     * 商品合同有效开始时间
     */
    private Date contractStartTime;

    /**
     * 商品合同有效结束时间
     */
    private Date contractEndTime;

    /**
     * 商品合同经理签字
     */
    private String contractManager;

    /**
     * 商品合同高级经理签字
     */
    private String contractSeniorManager;

    /**
     * 商品合同总经理签字
     */
    private String contractGeneralManager;

    /**
     * 商品合同备注
     */
    private String contractRemark;

    /**
     * 商品合同审核状态
     */
    private Integer contractStauts;

    /**
     * 商品合同创建时间
     */
    private Date createdTime;

    /**
     * 商品合同修改时间
     */
    private Date updatedTime;

    /**
     * 商品合同同步状态
     */
    private Integer syncStatus;

    /**
     * 是否删除，0否，1是
     */
    private Integer isDelete;

    /**
     * 合同审核时间
     */
    private Date contractBlTime;

    /**
     * 合同审核人
     */
    private Long contractBlEmpId;

    /**
     * 合同修改人
     */
    private Long contractModifier;

    /**
     * 合同创建人
     */
    private Long contractCreater;


    /**
     * 营业点id
     */
    private  Integer gonzeId;

    /**
     * 合同终止人
     **/
    private Long contractTerminator;

    /**
     * 合同作废人
     **/
    private Long contractVoider;

    /**
     * 合同清退人
     **/
    private Long contractRetirees;

    /**
     * 合同终止时间
     **/
    private  Date contractTerminatorTime;
    /**
     * 合同作废时间
     **/
    private  Date contractVoiderTime;
    /**
     * 合同清退时间
     **/
    private  Date contractRetireesTime;

    //合同附件集合
    private List<CatecommCntractEnclosure> list = new ArrayList<>();

    public List<CatecommCntractEnclosure> getList() {
        return list;
    }

    public void setList(List<CatecommCntractEnclosure> list) {
        this.list = list;
    }

    public Long getContractTerminator() {
        return contractTerminator;
    }

    public void setContractTerminator(Long contractTerminator) {
        this.contractTerminator = contractTerminator;
    }

    public Long getContractVoider() {
        return contractVoider;
    }

    public void setContractVoider(Long contractVoider) {
        this.contractVoider = contractVoider;
    }

    public Long getContractRetirees() {
        return contractRetirees;
    }

    public void setContractRetirees(Long contractRetirees) {
        this.contractRetirees = contractRetirees;
    }

    public Date getContractTerminatorTime() {
        return contractTerminatorTime;
    }

    public void setContractTerminatorTime(Date contractTerminatorTime) {
        this.contractTerminatorTime = contractTerminatorTime;
    }

    public Date getContractVoiderTime() {
        return contractVoiderTime;
    }

    public void setContractVoiderTime(Date contractVoiderTime) {
        this.contractVoiderTime = contractVoiderTime;
    }

    public Date getContractRetireesTime() {
        return contractRetireesTime;
    }

    public void setContractRetireesTime(Date contractRetireesTime) {
        this.contractRetireesTime = contractRetireesTime;
    }

    public Integer getGonzeId() {
        return gonzeId;
    }

    public void setGonzeId(Integer gonzeId) {
        this.gonzeId = gonzeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getOldContractCode() {
        return oldContractCode;
    }

    public void setOldContractCode(String oldContractCode) {
        this.oldContractCode = oldContractCode == null ? null : oldContractCode.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    public String getContractSellModel() {
        return contractSellModel;
    }

    public void setContractSellModel(String contractSellModel) {
        this.contractSellModel = contractSellModel == null ? null : contractSellModel.trim();
    }

    public Long getContractNick() {
        return contractNick;
    }

    public void setContractNick(Long contractNick) {
        this.contractNick = contractNick;
    }

    public Long getContractOrg() {
        return contractOrg;
    }

    public void setContractOrg(Long contractOrg) {
        this.contractOrg = contractOrg;
    }

    public Integer getContractSupper() {
        return contractSupper;
    }

    public void setContractSupper(Integer contractSupper) {
        this.contractSupper = contractSupper;
    }

    public String getContractSupperCode() {
        return contractSupperCode;
    }

    public void setContractSupperCode(String contractSupperCode) {
        this.contractSupperCode = contractSupperCode == null ? null : contractSupperCode.trim();
    }

    public String getContractSignedby() {
        return contractSignedby;
    }

    public void setContractSignedby(String contractSignedby) {
        this.contractSignedby = contractSignedby == null ? null : contractSignedby.trim();
    }

    public String getContractSignedAddress() {
        return contractSignedAddress;
    }

    public void setContractSignedAddress(String contractSignedAddress) {
        this.contractSignedAddress = contractSignedAddress == null ? null : contractSignedAddress.trim();
    }

    public Date getContractSignedTime() {
        return contractSignedTime;
    }

    public void setContractSignedTime(Date contractSignedTime) {
        this.contractSignedTime = contractSignedTime;
    }

    public String getContractDoubleSignedby() {
        return contractDoubleSignedby;
    }

    public void setContractDoubleSignedby(String contractDoubleSignedby) {
        this.contractDoubleSignedby = contractDoubleSignedby == null ? null : contractDoubleSignedby.trim();
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public String getContractManager() {
        return contractManager;
    }

    public void setContractManager(String contractManager) {
        this.contractManager = contractManager == null ? null : contractManager.trim();
    }

    public String getContractSeniorManager() {
        return contractSeniorManager;
    }

    public void setContractSeniorManager(String contractSeniorManager) {
        this.contractSeniorManager = contractSeniorManager == null ? null : contractSeniorManager.trim();
    }

    public String getContractGeneralManager() {
        return contractGeneralManager;
    }

    public void setContractGeneralManager(String contractGeneralManager) {
        this.contractGeneralManager = contractGeneralManager == null ? null : contractGeneralManager.trim();
    }

    public String getContractRemark() {
        return contractRemark;
    }

    public void setContractRemark(String contractRemark) {
        this.contractRemark = contractRemark == null ? null : contractRemark.trim();
    }

    public Integer getContractStauts() {
        return contractStauts;
    }

    public void setContractStauts(Integer contractStauts) {
        this.contractStauts = contractStauts;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getContractBlTime() {
        return contractBlTime;
    }

    public void setContractBlTime(Date contractBlTime) {
        this.contractBlTime = contractBlTime;
    }

    public Long getContractBlEmpId() {
        return contractBlEmpId;
    }

    public void setContractBlEmpId(Long contractBlEmpId) {
        this.contractBlEmpId = contractBlEmpId;
    }

    public Long getContractModifier() {
        return contractModifier;
    }

    public void setContractModifier(Long contractModifier) {
        this.contractModifier = contractModifier;
    }

    public Long getContractCreater() {
        return contractCreater;
    }

    public void setContractCreater(Long contractCreater) {
        this.contractCreater = contractCreater;
    }
}