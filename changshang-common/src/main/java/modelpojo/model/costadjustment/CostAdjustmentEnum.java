package modelpojo.model.costadjustment;

/***
 * @Author huangpeng
 * @Description //餐商税率调整单审核状态
 * @Date 17:26 2021/2/23
 * @Param
 * @return
 **/
public enum CostAdjustmentEnum {

    COST_NEW(166001,"新增成功！"),
    COST_DAI(166002,"提交审核成功！"),
    COST_EFFECTIVE(166003,"审核通过成功！"),
    COST_REJECT(166004,"审核驳回成功！"),
    COST_NO(166004,"没有修改任何单据信息！"),
    COST_WH_INFO(1,"该仓库下还存在没有提交审核或审核通过的成本调整单！"),
    COST_NO_PAYMENT(-1,"当前时间没有有效账期时间！！"),
    COST_DELETE(1,"删除成功！");

    private  Integer stauts;

    private  String message;

    CostAdjustmentEnum(Integer stauts, String message){
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
