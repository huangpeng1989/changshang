package modelpojo.model.DishRequirements;

public enum DishRequirementsEnum {

    REQUIREMENTS_NEW(14406,"新增成功！"),
    REQUIREMENTS_TJCL(14401,"提交处理成功！"),
    REQUIREMENTS_CL(14402,"处理成功！"),
    REQUIREMENTS_DAI(14403,"提交审核成功！"),
    REQUIREMENTS_REJECT(14404,"审核驳回成功！"),
    REQUIREMENTS_ADOPT(14405,"审核通过成功！"),
    REQUIREMENTS_VOIDER(14407,"作废成功！"),
    REQUIREMENTS_NO(-1,"没有进行任何单据操作！"),
    REQUIREMENTS_NO_ALLOT(-1,"没有生成任何调出审请单！"),
    REQUIREMENTS_QT(14602,"前台！"),
    REQUIREMENTS_HT(14601,"后台！"),
    REQUIREMENTS_DELETE(1,"删除成功！"),
    REQUIREMENTS_OUTBARCODE(1,"生成调出单条形码失败！"),
    REQUIREMENTS_INBARCODE(1,"生成调入单条形码失败！"),
    REQUIREMENTS_OUTWHSTOCK(1,"调出仓库库存不足！"),
    REQUIREMENTS_OUTINWHPD(1,"调出调入仓库正中盘点中，无法进行反调拔！"),
    REQUIREMENTS_NOPAYMENT(1,"当前日期没有有效的账期！"),
    REQUIREMENTS_OPPOSITE(1,"反调拔成功！");


    DishRequirementsEnum(Integer stauts, String message){
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
