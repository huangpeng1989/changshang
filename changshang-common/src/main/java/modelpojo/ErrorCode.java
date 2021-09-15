package modelpojo;

/**
 * @Author ming.jin
 * @Date 2018/8/23
 */
public class ErrorCode {


    /**
     * 会员等级成长值设置有冲突
     */
    public final static String MEMBER_LEVEL_GROWTH_VALUE = "M001";

    /**
     * 余额不足
     */
    public final static String MEMBER_BALANCE_NOT_ENOUGH = "M002";

    /**
     * 会员等级设置冲突
     */
    public final static String MEMBER_LEVEL_NUM = "M003";

    /**
     * 会员等级名称设置冲突
     */
    public final static String MEMBER_LEVEL_NAME = "M004";

    /**
     * 不允许修改会员的储值、积分、虚拟账户
     */
    public final static String MEMBER_AMOUNT_NOTADJUST = "M005";
    /**
     * 转入转出为同一个账户
     */
    public final static String MEMBER_TRANS_SAME_ACCOUNT = "M006";

    /**
     * 已存在该账户类型
     */
    public final static String MEMBER_EXIST_ACCOUNT_TYPE = "M007";

    /**
     * 已存在会员卡
     */
    public final static String MEMBER_EXIST_CARD = "M008";

    /**
     * 会员卡已冻结
     */
    public final static String MEMBER_CARD_FROZEN = "M009";

    /**
     * 母卡卡已冻结
     */
    public final static String MEMBER_MOTHER_CARD_FROZEN = "M010";

    /**
     * 实体卡已存在
     */
    public final static String MEMBER_ENTITYCARD_EXIT = "M011";

    /**
     * 卡号由大小写字母+阿拉伯数字组成。 上限值60位
     */
    public final static String MEMBER_ENTITYCARD_RULE = "M012";
    /**
     * 该会员等级存在有效卡
     */
    public final static String MEMBER_LEVEL_EXIST_CARD = "M013";

    /**
     * 该会员手机号已存在
     */
    public final static String MEMBER_PHONE_EXIST = "M014";

    /**
     * 实体卡不存在/密码不正确
     */
    public final static String MEMBER_ENTITYCARD_NOTEXIT = "M015";

    /**
     * 单位已存在
     */
    public final static String UNIT_EXIST = "M016";

    /**
     * 异常的商品数量
     */
    public final static String ABNORMAL_GOODS_QUANTITY = "M017";

    /**
     * 会员卡已被使用(消费)
     */
    public final static String MEMBER_CARD_USED = "M018";

    /**
     * 商品库存不足
     */
    public final static String GOODS_NOSTOCK = "M019";

    /**
     * 商品已领取
     */
    public final static String GOODS_EXCHANGED = "M020";

    /**
     * 该会员类别下存在会员
     */
    public final static String MEMBER_TYPE_EXIST_CARD = "M021";

    /**
     * 实体卡-密码卡未设置密码
     */
    public final static String MEMBER_NO_PASSWORD = "M022";

    /**
     * 会员积分不够
     */
    public final static String NO_MORE_SCORE = "M023";

    /**
     * 实体卡-重复
     */
    public final static String MEMBER_ENTITY_REPEAT = "M024";

    /**
     * 会员卡类型已存在
     */
    public final static String MEMBER_CARD_TYPE_EXIST = "M025";

    /**
     * 实体卡已使用
     */
    public final static String MEMBER_ENTITYCARD_USED = "M026";

    /**
     * 实体卡已激活
     */
    public final static String ENTITY_CARD_ACTIVATED = "M027";

    /**
     * 实体卡已挂失
     */
    public final static String MEMBER_ENTITYCARD_LOSSED = "M028";

    /**
     * 副卡持有人已存在会员卡
     */
    public final static String MEMBER_EXIST_ADDITIONAL_CARD = "M029";

    /**
     * 会员已绑定实体卡
     */
    public final static String MEMBER_BANDNING_ENTITY = "M030";

    /**
     * 会员卡退卡失败
     */
    public final static String MEMBER_REFUND_FAIL = "M031";

    /**
     * 设置兑换积分不正确
     */
    public final static String ABNORMAL_SCORE_SET = "M032";

    /**
     * 商品不存在
     */
    public final static String GOODS_NOTEXIST = "M033";

    /**
     * 会员普通实体卡不存在密码
     */
    public final static String MEMBER_ENTITY_COMMON_NOPASS = "M034";

    /**
     * 商品已存在
     */
    public final static String GOODS_EXIST = "M035";
    /**
     * 会员卡不存在
     */
    public final static String MEMBER_CARD_NOT_EXIT = "M036";

    /**
     * 激活失败
     */
    public final static String ACTIVATE_FAILURE = "M038";

    /**
     * 会员已存在
     */
    public final static String MEMBER_EXIST = "M037";
    /**
     * 会员不存在
     */
    public final static String MEMBER_NOT_EXIST = "M039";
    /**
     * 会员订单不存在
     */
    public final static String MEMBER_ORDER_NOT_EXIT = "M040";


    /**
     * 会员订单已退款
     */
    public final static String MEMBER_ORDER_REFUND = "M041";
    /**
     * 会员原订单号为空
     */
    public final static String MEMBER_ORIGINORDERNO_NOT_EXIT = "M042";

    /**
     * 会员原订单号存在多个
     */
    public final static String MEMBER_ORIGINORDERNO_MORE = "M043";


    /**
     * 商品上架数量不足
     */
    public final static String GOODS_NO_SALE_NUM = "M044";
    /**
     * 会员级别有效期设置已存在
     */
    public final static String MEMBER_LEVEL_EFF_EXIT = "M045";
    /**
     * 支付密码为空
     */
    public final static String MEMBER_PAYPWD_EMPTY = "M046";
    /**
     * 支付密码错误
     */
    public final static String MEMBER_PAYPWD_ERROR = "M047";
    /**
     * 支付码失效
     */
    public final static String MEMBER_PAYCODE_INVALID = "M048";
    /**
     * 会员需要注册
     */
    public final static String MEMBER_NO_REGISTER = "M049";
    /**
     * 会员需要购买卡
     */
    public final static String MEMBER_NO_BUY_CARD = "M050";
    /**
     * 无会员卡类型
     */
    public final static String NOT_SET_CARD_TYPE = "M051";
    /**
     * 无微信公众号配置
     */
    public final static String MEMBER_NO_WX_MP_SET = "M052";
    /**
     * 微信公众号配置不全
     */
    public final static String MEMBER_PART_WX_MP_SET = "M053";
    /**
     * 无效的微信卡套
     */
    public final static String MEMBER_INVALID_WX_CARD = "M054";
    /**
     * 支付即会员规则过期
     */
    public final static String MEMBER_PAY_GIFT_CARD_RULE_EXPIRED = "M055";
    /**
     * 无推送卡级
     */
    public final static String MEMBER_NO_PUSH_LEVEL = "M056";

    /**
     * 新卡
     */
    public final static String MEMBER_NEW_CARD = "M057";

    /**
     * 卡券已过期
     */
    public final static String MEMBER_COUPON_EXPIRED = "M058";
    /**
     * 卡券不足
     */
    public final static String MEMBER_COUPON_INSUFFICIENT = "M059";

    /**
     * 会员数据已存在
     */
    public final static String MEMBER_DATA_EXIT = "M060";

    /**
     * 会员积分折扣率 时间重叠
     */
    public final static String MEMBER_DIS_MIX = "M061";

    /**
     * 优惠券已被领取
     */
    public final static String MEMBER_COUPON_RECEIVE = "M062";
    /**
     * 优惠券领取达总上限
     */
    public final static String MEMBER_TOTAL_LIMIT = "M063";
    /**
     * 优惠券领取达每日上限
     */
    public final static String MEMBER_DAY_LIMIT = "M064";

    /**
     * 优惠券已领完
     */
    public final static String MEMBER_COUPON_EMPTY= "M065";
    /**
     * 优惠券未领取或不存在
     */
    public final static String MEMBER_COUPON_NOTEXIST= "M066";

    /**
     * 优惠券未在有效期
     */
    public final static String MEMBER_COUPON_NOTINTIME= "M067";

    /**
     * 优惠券不能再该渠道使用
     */
    public final static String MEMBER_COUPON_NOTINCHANNEL= "M068";

    /**
     * 优惠券不能用于该商品
     */
    public final static String MEMBER_COUPON_NOTINGOOD= "M069";
    /**
     * 优惠券已作废
     */
    public final static String MEMBER_COUPON_CANCEL= "M070";

    /**
     * 商品已用于优惠券
     */
    public final static String MEMBER_GOODS_BANGDING= "M071";

    /**
     * 优惠金额错误
     */
    public final static String MEMBER_COUPON_DISCOUNT_ERROR = "M072";

    /**
     * 未设置支付密码
     */
    public final static String MEMBER_PAYPWD_NOSET = "M080";
    /**
     * 本金金额不为0
     */
    public final static String CORPUS_NOT_ZERO = "M081";


    /**
     * 退款金额与账户内金额不一致
     */
    public final static String INCONSISTENT_AMOUNT = "M082";


    /**
     * 答案错误
     */
    public final static String MEMBER_ANSWER_ERROR = "M083";




    /**
     * 该会员邮箱已存在
     */
    public final static String MEMBER_EMAIL_EXIST = "M084";
    /**
     * 实体卡未开卡
     */
    public final static String MEMBER_ENTITYCARD_NOT_OPEN = "M085";

    /**
     * 储值账户（元） 超过2000
     */
    public final static String MEMBER_ACCOUNT_RECHARGE_MORE2000 = "M086";


    /**
     * 参数为空
     */
    public final static String PARAM_BLANK = "S001";

    /**
     * 接口异常
     */
    public final static String METHOD_EXCEPTION = "S002";

    /**
     * 导入文件仅支持Excel文件
     */
    public final static String EXCEL_FARMAT_ERROR = "S003";

    /**
     * Excel内容格式解析错误
     */
    public final static String EXCEL_CONTENT_ERROR = "S004";

    /**
     * 上传出错
     */
    public final static String UPLOAD_ERROR = "S005";

    /**
     * 账户操作异常
     */
    public final static String ACCOUNT_OPER_EXCEPTION = "S006";

    /**
     * 存在不需删除的财务节点
     */
    public final static String ECONOMIC_EXIST = "S007";

    /**
     * 发送邮件异常
     */
    public final static String SEND_EMAIL_ERROR = "S008";

    /**
     * 存在子类信息导致无法删除
     */
    public final static String DELETE_ERROR_BY_SUB = "S009";

    /**
     * 传参错误
     */
    public final static String PARAM_ERROR = "S010";


    public final static String NO_SERVICE = "S011";

    public final static String ORG_NO_SERVICE = "S012";
    /**
     * 微信请求错误
     */
    public final static String WX_ERROR = "S013";
    /**
     * 微信配置错误
     */
    public final static String WX_MP_SET_ERROR = "S014";

    /**
     * 标签名重复
     */
    public final static String TAG_NAME_EXISIT = "S015";

    /**
     * 标签正在使用
     */
    public final static String TAG_USING = "S016";

    /**
     * 自定义日期名已存在
     */
    public final static String DATE_PLAN_EXISIT = "S017";

    /**
     * 服务过期
     */
    public final static String SERVICE_EXPIRED = "S018";

    /**
     * 未知错误
     */
    public final static String UNKOWN_ERROR = "S019";
    /**
     * 获取redis锁超时
     */
    public final static String REDIS_LOCK_GAIN_TIMEOUT = "S020";

    /**
     * 获取redis锁错误
     */
    public final static String REDIS_LOCK_GAIN_ERROR = "S021";

    /**
     * 账号
     */
    public final static String ACCOUNT_ERROR = "A001";

    /**
     * 账号
     */
    public final static String ACCOUNT_PASSWORD= "A011";

    /**
     * 账户已失效
     */
    public final static String ACCOUNT_EXPIRE = "A002";

    /**
     * 验证码储存为空
     */
    public final static String VERIFICATION_CODE_BLANK = "A003";

    /**
     * 验证码错误
     */
    public final static String VERIFICATION_CODE_ERROR = "A004";

    /**
     * 验证码失效
     */
    public final static String VERIFICATION_CODE_EXPIRE = "A005";

    /**
     * 公司不存在
     */
    public final static String COMPANY_NONE = "A006";

    /**
     * 角色名称已存在
     */
    public final static String ROLE_NAME_EXIST = "A007";

    /**
     * 账号不存在
     */
    public final static String ACCOUNT_NO_EXIST = "A008";

    /**
     * 账户没有权限
     */
    public final static String ACCOUNT_NO_PRIVILEGE = "A009";

    /**
     * 账号名已存在
     */
    public final static String ACCOUNT_EXIST = "A010";

    /**
     * 原密码错误
     */
    public final static String OLD_PASSWORD_ERROR = "A011";

    /**
     * 修改密码太频繁
     */
    public final static String PASSWORD_MODIFY_FREQUENTLY = "A012";

    /**
     * 验证码已使用
     */
    public final static String VERIFICATION_CODE_USED = "A013";
    /**
     * 无手机报权限
     */
    public final static String REPORT_MOBILE_NOACCESS = "A014";

    public final static String SMS_SEND_FREQUENTLY = "A015";


    /**
     * 机构在线账户类型已存在
     */
    public final static String ORG_ONLIE_ACCOUNT_EXIST = "O001";

    /**
     * 该合作伙伴已存在
     */
    public final static String ORG_EXIST_PARTNER = "O002";

    /**
     * 该自营渠道已存在
     */
    public final static String ORG_EXIST_SELF_CHANNLE = "O003";
    /**
     * 该分组已存在
     */
    public final static String GROUP_NAME_EXIST = "O004";

    /**
     * 该机构或上级机构未启用(对不起，您的账号未启用)
     */
    public final static String ORG_UPPER_INVALID = "O005";

    /**
     * 机构名已存在
     */
    public final static String ORG_NAME_EXIST = "O006";

    /**
     * 自营渠道appID重复
     */
    public final static String ORG_SELF_APP_REPEAT = "O007";

    /**
     * 合作伙伴在协议期外
     */
    public final static String ORG_PARTNER_OUT_OF_AGREEMEMNT = "O008";

    /**
     * 不能删除机构
     */
    public final static String ORG_FORBID_DELETE = "O009";

    /**
     * 机构封面不唯一
     */
    public final static String ORG_COVER_NOT_UNIQUE = "O010";
    /**
     * 名字重复
     */
    public final static String NAME_EXIST = "O011";


    /**
     * 更换渠道分类，需删除渠道下的产品 政策
     */
    public final static String ORG_PARTNER_DELETE_PRODUCT = "O013";

    /**
     * 当前渠道分类有关联渠道
     */
    public final static String CHANNEL_SET_EXIST_CHANNEL = "O014";

    /**
     * 当前渠道分类及其子渠道分类有关联渠道
     */
    public final static String CHANNEL_SET_CHILD_EXIST_CHANNEL = "O015";

    /**
     * 当前渠道分类没有有关联渠道
     */
    public final static String CHANNEL_CONN_CLASS = "O016";

    /**
     * 订单金额计算错误
     */
    public final static String ORDER_AMOUNT_ERRER = "OD001";

    /**
     * 上级分销商余额不够
     */
    public final static String ORDER_AMOUNT_LESS = "OD002";

    /**
     * 产品库存不够
     */
    public final static String ORDER_STOCK_LESS = "OD003";

    /**
     * 已取票
     */
    public final static String ORDER_TICKETS_PICKED = "OD004";

    /**
     * 订单未审核
     */
    public final static String ORDER_UNAUDIT = "OD005";

    /**
     * 订单不满足销售规则
     */
    public final static String ORDER_SALE_RULE_ERROR = "OD006";

    /**
     * 退改签中有票不符合退改规则
     */
    public final static String ORDER_REFUND_ALTER_RULE_MISMATCH = "OD007";

    /**
     * 下订单失败
     */
    public final static String ORDER_BOOK_FAIL_RETURNMONEY = "OD008";
    public final static String ORDER_BOOK_FAIL_NORETURNMONEY = "OD009";
    /**
     * 政策库存不足
     */
    public final static String ORDER_POLICY_STOCK_LESS = "OD010";

    /**
     * 没有可取的票
     */
    public final static String ORDER_NO_TICKET_PICK = "OD011";

    /**
     * 团队取票数量错误
     */
    public final static String ORDER_TICKET_COUNT_ERROR = "OD012";

    /**
     * 没有票可以核销
     */
    public final static String ORDER_NO_TICKET_VERFY = "OD013";

    /**
     * 退票数量错误
     */
    public final static String ORDER_REFUND_ERRER = "OD014";

    /**
     * 未查到该订单记录
     */
    public final static String ORDER_NOT_FIND = "OD015";

    /**
     * 没有可以退的票
     */
    public final static String ORDER_NOT_TICKET_REFUND = "OD016";

    /**
     * 订单已支付
     */
    public final static String ORDER_PAID = "OD017";
    /**
     * 订单未支付
     */
    public final static String ORDER_NOT_PAID = "OD018";

    /**
     *
     * 产品已下架（团单线下加人）
     */
    public final static String ORDER_PRODUCT_OFFSALE = "OD019";
    /**
     * 团单已确认
     */
    public final static String ORDER_confirmed = "OD020";

    /**
     * 票已过期（官网当天票不能退）
     */
    public final static String ORDER_TICKETS_EXPIRE = "OD021";

    /**
     * 房价代码被订单使用，不允许删除
     */
    public static final String EXISTING_ORDER = "0D022";
    /**
     * 已入住，不能取消订单
     */
    public static final String CHECK_IN = "0D023";

    /**
     * 政策场次时间重复
     */
    public static final String SESSION_TIME_SAME = "0D024";

    /**
     * 预留配额时间重复
     */
    public static final String QUOTA_RESERVED_TIME_SAME = "0D025";

    /**
     * 预留配额变动
     */
    public static final String QUOTA_RESERVED_CHANGED = "0D026";


    /**
     * 全民营销相关
     *
     */
    /**
     * 账号或密码错误
     */
    public final static String MARKET_USER_ERROR = "MK001";
    /**
     * 用户不存在
     */
    public final static String MARKET_USER_NOEXIST = "MK002";
    /**
     * 身份证错误
     */
    public final static String MARKET_USER_IDNO_ERROR = "MK003";

    /**
     * 终端售价低于销售政策产品单价
     */
    public final static String MARKET_SALE_PRICE_ERROR = "MK004";

    /**
     * 没有可提现金额
     */
    public final static String MARKET_NO_SALARY = "MK005";

    /**
     * 二级订单无数据
     */
    public final static String MARKET_SECOND_ORDER_NODATA = "MK006";

    /**
     * 提现金额有误
     */
    public final static String MARKET_SALARY_ERROR = "MK007";

    /**
     * 营销账户已存在
     */
    public final static String MARKET_USER_EXIT = "MK008";

    /**
     * 营销类别不存在
     */
    public final static String MARKET_TYPE_NOTEXIT = "MK009";

    /**
     * 营销等级设置冲突
     */
    public final static String MARKET_LEVEL_NUM = "MK010";

    /**
     * 营销等级名称设置冲突
     */
    public final static String MARKET_LEVEL_NAME = "MK011";

    /**
     * 营销等级级别与升级金额不同步
     */
    public final static String MARKET_LEVEL_ERROR = "MK012";

    /**
     * 同个用户下存在多个营销类型
     */
    public final static String MARKET_MORE_TYPE = "MK013";

    /**
     * 类别下存在用户
     */
    public final static String MARKET_TYPE_EXIST_USER = "MK016";


    /**
     * 营销用户手机号已存在
     */
    public final static String MARKET_USER_PHONE_EXIT = "MK014";
    /**
     * 账号或密码错误
     */
    public final static String MARKET_USER_OLDPW_ERROR = "MK015";

    /**
     * 景区范围内下的订单
     */
    public final static String MARKET_ORDER_RANGE_IN = "MK017";

    /**
     * 无核销订单
     */
    public final static String MARKET_ORDER_NO_VERIFY = "MK018";

    /**
     * 订单产品数量不正确
     */
    public final static String MARKET_ORDER_QUANTITY_ERROR = "MK019";

    /**
     * 订单未到提现时间
     */
    public final static String MARKET_ORDER_WITHDRAW_TIME = "MK020";

    /**
     * 没有设置收款账户
     */
    public final static String MARKET_ORDER_NOT_ACCOUNT = "MK021";

    /**
     * 支付相关
     */
    /**
     * 支付失败
     */
    public final static String PAY_FAIL = "P001";
    /**
     * 支付状态未知
     */
    public final static String PAY_UNKNOWN = "P002";
    /**
     * 支付交易不存在
     */
    public final static String PAY_TXN_NO_EXIST = "P003";
    /**
     * 验签错误
     */
    public final static String PAY_SIGNATURE_ERROR = "P004";
    /**
     * 公众号appID错误
     */
    public final static String PAY_MP_APPID_ERROR = "P005";

    public final static String PAY_REFUND_ERROR = "P006";

    /**
     * 产品名重复
     */
    public final static String PRODUCT_NAME_REPEAT = "PD001";


    /**
     * 配额调配异常
     */
    public final static String PRODUCT_QUOTA_TRANSFER_ERROR = "PD002";
    /**
     * 配额数量异常
     */
    public final static String PRODUCT_QUOTA_QUANTITY_ERROR = "PD003";

    /**
     * 配额不足
     */
    public final static String PRODUCT_QUOTA_LESS = "PD004";
    /**
     * 阶梯价不存在
     */
    public final static String PRODUCT_QUOTA_LADDER_MISS = "PD005";
    /**
     * 优惠码批次已到上限
     */
    public final static String PROMOTION_CODE_BATCH_LIMIT = "PD006";
    /**
     * 房价代码不存在
     */
    public static final String ROOM_RATE_CODE_NOT_EXIST = "RM001";
    /**
     * 房间未指定入住人
     */
    public static final String ROOM_VISITOR_NOT_EXIST = "RM002";
    /**
     * PMS下单失败
     */
    public static final String ROOM_PMS_ORDER_FAIL = "RM003";
    /**
     * 卡已激活
     */
    public static final String ORDER_CARD_ACTIVED = "C001";
    /**
     * PMS取消订单失败
     */
    public static final String ROOM_PMS_CANCEL_ORDER_FAIL = "RM004";

    /**
     * 套餐库存为空
     */
    public static final String PCK_STOCK_NOT_EXIST = "PCK001";

    /**
     * 套餐库存不足
     */
    public static final String PCK_STOCK_NOT_ENON = "PCK002";

    /**
     * 套餐一级订单信息记录为空
     */
    public static final String PCK_STOCK_NOT_ORDER = "PCK003";

    /**
     * 上级分销产品未开启
     */
    public final static String SUP_CHANNEL_PRODUCT_CLOSED = "O017";

    /**
     * 上级分销佣金已变化
     */
    public final static String SUP_CHANNEL_SALARY_CHANGED = "O018";
    /**
     * 上级分销佣金不足
     */
    public final static String SUP_CHANNEL_SALARY_LESS = "O019";


    /**
     * 未查到该产品记录
     */
    public final static String PRODUCT_NOT_FIND = "PN0019";
    /**
     * 购物车锁定时间未设置
     */
    public static final String CART_LOCK_NOT_SET = "CL001";

    /**
     * 进价调价  -- 当前时间在起止范围内不允许审核
     */
    public static final String ADJUST_NOT_TO_EXAMINE = "AE001";


    /**
     * 原材料添加 -- 原材料信息添加失败
     */
    public static final String RAWMATER_NOT_TO_EXAMINE = "RE001";

    /**
     * 原材料添加 -- 原材料包装信息失败
     */
    public static final String RAWMATER_NOT_TO_SALEROWMATER = "RE002";
    /**
     * 原材料添加 -- 原材料供应商信息失败
     */
    public static final String RAWMATER_NOT_TO_SUPROWMATER = "RE003";


    /**
     * 终端信息
     */
    public static final String TERMINAL_ERROR = "TE001";





}
