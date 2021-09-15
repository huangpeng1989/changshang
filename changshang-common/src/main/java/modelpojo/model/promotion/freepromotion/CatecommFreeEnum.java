package modelpojo.model.promotion.freepromotion;

public enum CatecommFreeEnum {
    Free_NEW(177001,"新增成功！"),
    Free_DAI(177002,"提交审核成功！"),
    Free_EFFECTIVE(177003,"审核驳回成功！"),
    Free_REJECT(177004,"未开始！"),
    Free_INVALID(177005,"进行中！"),
    Free_BEEFFECTIVE(177006,"已结束！"),
    Free_VOIDER(177007,"已终止成功！"),
    Free_GO(177008,"审核通过成功！"),
    Free_DELETE(1,"删除成功！"),
    Free_NAME(-1,"促销方案名称已存在！"),
    Free_NO(-1,"没有修改任何促销单据信息！"),
    Free_ERRO(-1,"当前审核日期大于促销单结束日期！"),
    Free_JOB_MESSAGE(100,"修改促销单的状态定时任务执行成功！");

    private  Integer stauts;
    private  String message;

    CatecommFreeEnum(Integer stauts,String message){
        this.message = message;
        this.stauts = stauts;
    }

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
