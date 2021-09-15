package modelpojo;

public class Type {
	
	public static final Integer DELETED = 1;
	
	public static final Integer NOT_DELETED = 0;
	
	public static final Integer DEFALUT = 10;
	
	public static final Integer NOT_DEFALUT = 20;
	
	/**
	 * 字典表启用状态
	 */
	public static final Integer DICT_ENABLE = 1;
	
	/**
	 *原材料
	 */
	public static final Integer ROWMATERIAL = 11004;
	
	/**
	 *半成品
	 */
	public static final Integer SEMI_FINISHED = 11002;
	
	/**
	 * 税率启用状态
	 */
	public static final Integer T_STATUS = 0;
	
	/**
	 * 商品要货单
	 */
	//从表要货结果：通过
	public static final Integer APL_RESULT_THROUGH = 14501;
	//主表状态：审核通过
	public static final Integer APL_STATUS_APPROVED = 14404;
	//主表状态：待审核
	public static final Integer APL_STATUS_WAITAUDIT = 14402;
	//主表状态：待处理
	public static final Integer APL_STATUS_PENDING =  14401;
	//主表状态：新增
	public static final Integer APL_STATUS_NEW = 14406 ;
	
}
