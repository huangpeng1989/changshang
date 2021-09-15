package modelpojo.model.contract;

public enum ContractStutsEnum {

    CONTRACT_NEW(133001,"新增成功！"),
    CONTRACT_DAI(133002,"提交审核成功！"),
    CONTRACT_ADOPT(133003,"审核通过成功！"),
    CONTRACT_REJECT(133004,"审核驳回成功！"),
    CONTRACT_VOIDER(133005,"已作废成功！"),
    CONTRACT_TERMINNATORB(133006,"已终止成功！"),
    CONTRACT_RETIREES(133007,"已清退成功！"),
    CONTRACT_DELETE(1,"删除成功！"),
    CONTRACT_UPDAE(1,"没有修改任何合同单据信息！"),
    CONTRACT_BATCHINSETT(1,"批量新增合同成功！"),
    CONTRACT_NAME(1,"合同名称在数据库中已经存在！"),
    CONTRACT_NOTSELECT(1,"没有查到任何单据信息！"),
    CONTRACT_NOTFILE(0,"请选择合同excle文件！"),
    CONTRACT_NOTENC(0,"合同不存在任何附件！"),
    CONTRACT_JOB(1,"没有回填任何商品合同供应商信息！"),
    CONTRACT_RMJOB(1,"没有回填任何原材料合同供应商信息！"),
    CONTRACT_DISHJOB(1,"没有回填任何菜品合同供应商信息！"),
    CONTRACT_ElIMINATASTATUS(1,"没有扫描任何商品基础信息的合同是否到期"),
    CONTRACT_RMElIMINATASTATUS(1,"没有扫描任何原材料基础信息的合同是否到期"),
    CONTRACT_DISHElIMINATASTATUS(1,"没有扫描任何原材料基础信息的合同是否到期");







    ContractStutsEnum(Integer stauts,String message){
         this.message = message;
         this.stauts = stauts;
    }

    private  Integer stauts;

    private  String message;

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
