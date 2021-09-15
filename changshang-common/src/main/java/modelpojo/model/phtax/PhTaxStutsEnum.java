package modelpojo.model.phtax;

/***
 * @Author huangpeng
 * @Description //餐商税率调整单审核状态
 * @Date 17:26 2021/2/23
 * @Param
 * @return
 **/
public enum PhTaxStutsEnum {

    PH_TAX_NEW(155001,"新增成功！"),
    PH_TAX_DAI(155002,"提交审核成功！"),
    PH_TAX_EFFECTIVE(155003,"已生效！"),
    PH_TAX_REJECT(155004,"审核驳回成功！"),
    PH_TAX_INVALID(155005,"已失效！"),
    PH_TAX_BEEFFECTIVE(155006,"待生效！"),
    PH_TAX_VOIDER(155007,"已作废成功！"),
    PH_TAX_UPDATE(155008,"编辑成功！"),
    PH_TAX_NOW(155009,"立即生效成功！"),
    PH_TAX_BF_BEEFFECTIVE(155010,"部份失效！"),
    PH_TAX_DELETE(1,"删除成功！"),
    PH_TAX_NOTSELECT(1,"没有任何调整单信息！"),
    PH_TAX_NOTFILE(-2,"请选择调整单excle文件！"),
    CONTRACT_NOIU(-1,"没有修改任何合同单据信息！");


    private  Integer stauts;

    private  String message;

    PhTaxStutsEnum(Integer stauts,String message){
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
