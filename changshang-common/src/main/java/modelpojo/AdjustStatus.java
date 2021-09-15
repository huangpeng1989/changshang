package modelpojo;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-08-24 10:42
 */
public class AdjustStatus {

    /**
     * 进价调价审核状态 -- 新增
     */
    public final static int ADJUST_STATUS_COMMIT= 10700;

    /**
     * 进价调价审核状态 -- 全部
     */
    public final static int ADJUST_STATUS_WHOLE= 10701;

    /**
     *进价调价审核状态 -- 待审核
     */
    public final static int ADJUST_STATUS_AUDIT=10702 ;

    /**
     *进价调价审核状态 -- 审核驳回
     */
    public final static int ADJUST_STATUS_REJECT=10703 ;

    /**
     *进价调价审核状态 -- 待生效
     */
    public final static int ADJUST_STATUS_STAY_TAKE_EFFECT=10704 ;

    /**
     *进价调价审核状态 -- 生效中
     */
    public final static int ADJUST_STATUS_IN_FORCE= 10705;


    /**
     *进价调价审核状态 -- 已失效
     */
    public final static int ADJUST_STATUS_ENTERED_INTO_FORCE= 10706;

    /**
     *进价调价审核状态 -- 已停用
     */
    public final static int ADJUST_STATUS_ENTERED_DEACTIVATED= 10707;

    /**
     *进价调价审核状态 -- 已作废
     */
    public final static int ADJUST_STATUS_ENTERED_INVALID = 10708;

    /**
     *进价调价审核状态 -- 新增
     */
    public final static int ADJUST_STATUS_ADD = 10700;


    /**
     * 调价类型 -- 永久
     */
    public final static int ADJUST_TYPE_PERMANENT= 10707;


    /**
     * 领用管理-- 审核通过
     */
    public final static int RCPT_TYPE_AUDIT= 12206;

    /**
     * 归还管理-- 审核通过
     */
    public final static int RTN_TYPE_AUDIT= 12207;



    /**
     * 报损/溢单状态 -- 待审核
     */
    public final static int LOSSBILL_TYPE_AUDIT= 12501;

    /**
     * 报损/溢单状态 -- 已驳回
     */
    public final static int LOSSBILL_TYPE_REJECT= 12502;


    /**
     * 报损/溢单状态 -- 已通过
     */
    public final static int LOSSBILL_TYPE_ADOPT= 12503;


    /**
     * 报损/溢单状态 -- 已删除
     */
    public final static int LOSSBILL_TYPE_DELETE= 12504;

}
