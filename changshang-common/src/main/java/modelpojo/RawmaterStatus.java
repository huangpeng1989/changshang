package modelpojo;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-05-28 09:39
 */
public class RawmaterStatus {

    /**
     *原材料审核状态 -- 新增
     */
    public final static int RAWMATER_STATUS_ADD=11501 ;

    /**
     *原材料审核状态 -- 待审核
     */
    public final static int RAWMATER_STATUS_AUDIT=11502 ;


    /**
     *原材料审核状态 -- 审核通过
     */
    public final static int RAWMATER_STATUS_ADOPT=11503 ;

    /**
     *原材料审核状态 -- 审核驳回
     */
    public final static int RAWMATER_STATUS_REJECT=11504 ;

    /**
     *原材料审核状态 --  已删除
     */
    public final static int RAWMATER_STATUS_DELETE=11505 ;

    /**
     *原材料审核状态 -- 修改待提交
     */
    public final static int RAWMATER_STATUS_UP_SUBMIT= 11506;


    /**
     *原材料审核状态 -- 修改待审核
     */
    public final static int RAWMATER_STATUS_UP_AUDIT= 11507;

    /**
     *原材料审核状态 -- 修改呗驳回
     */
    public final static int RAWMATER_STATUS_UP_REJECT= 11508;
}
