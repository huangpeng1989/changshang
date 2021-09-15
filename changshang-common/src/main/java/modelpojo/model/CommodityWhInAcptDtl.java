package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityWhInAcptDtl implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * project_id
     */
    private Long projectId;

    /**
     * project_root_id
     */
    private Long projectRootId;

    /**
     * 采购验收入库单id
     */
    private Integer acptBillId;

    /**
     * 分录号 每个订单明细数据从1开始的序号
     */
    private Integer fEntryId;

    /**
     * 商品id
     */
    private Integer comId;

    /**
     * 商品编号
     */
    private String comCode;

    /**
     * 商品规格
     */
    private String comSpec;

    /**
     * 商品单位
     */
    private Integer comUnit;

    /**
     * 验收含税进价   =验收含税包装价/包装含量
     */
    private BigDecimal taxPchsPrice;

    /**
     * 验收未税进价   =验收未税包装价/包装含量
     */
    private BigDecimal notaxPchsPrice;

    /**
     * 验收含税总价   =验收订货数量*验收含税包装进价
     */
    private BigDecimal taxSumPrice;

    /**
     * 验收未税总价  =验收订货数量*验收未税包装价
     */
    private BigDecimal notaxSumPrice;

    /**
     * 验收税率id 关联字典
     */
    private Integer taxId;

    /**
     * 验收税率值
     */
    private String taxName;

    /**
     * 验收含税包装价  =验收含税单价*包装含量
     */
    private BigDecimal taxPagePrice;

    /**
     * 验收未税包装价 =验收未税单价*包装含量
     */
    private BigDecimal notaxPagePrice;

    /**
     * 是否赠品 0否 1是
     */
    private Byte isGift;

    /**
     * 包装-验收销售商品id
     */
    private Integer pSaleComId;

    /**
     * 包装-验收销售商品编码
     */
    private String pSaleComCode;

    /**
     * 包装-验收销售商品单位 字典表
     */
    private Integer pSaleUnit;

    /**
     * 包装-验收销售商品含量
     */
    private Integer pSalePackContent;

    /**
     * 包装-验收订货包装数量
     */
    private BigDecimal orderPageCount;

    /**
     * 包装-验收赠品包装数量
     */
    private BigDecimal giftPageCount;

    /**
     * 包装-验收合计包装数量=订货包装数量+赠品包装数量
     */
    private BigDecimal oGPageCount;

    /**
     * 转换-验收销售商品id
     */
    private Integer gSaleComId;

    /**
     * 转换-验收销售商品编码
     */
    private String gSaleComCode;

    /**
     * 转换-验收销售商品单位 字典表
     */
    private Integer gSaleUnit;

    /**
     * 转换-验收销售商品含量
     */
    private Integer gSalePackContent;

    /**
     * 转换-验收订货数量   =验收订货包装数量*包装含量
     */
    private BigDecimal orderCount;

    /**
     * 转换-验收赠品数量   =验收赠品包装数量*包装含量
     */
    private BigDecimal giftCount;

    /**
     * 转换-验收合计数量=转换-验收赠品数量 +转换-验收赠品数量
     */
    private BigDecimal oGCount;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否删除 0否 1是
     */
    private Byte isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 说明
     */
    private String state;

    /**
     * 入库状态 字典
     */
    private Integer whinStatus;

    /**
     * 同步状态 10未同步 20同步中 30已同步
     */
    private Integer syncStatus;


    private Integer contractId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * project_id
     * @return project_id project_id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * project_id
     * @param projectId project_id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * project_root_id
     * @return project_root_id project_root_id
     */
    public Long getProjectRootId() {
        return projectRootId;
    }

    /**
     * project_root_id
     * @param projectRootId project_root_id
     */
    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    /**
     * 采购验收入库单id
     * @return acpt_bill_id 采购验收入库单id
     */
    public Integer getAcptBillId() {
        return acptBillId;
    }

    /**
     * 采购验收入库单id
     * @param acptBillId 采购验收入库单id
     */
    public void setAcptBillId(Integer acptBillId) {
        this.acptBillId = acptBillId;
    }

    /**
     * 分录号 每个订单明细数据从1开始的序号
     * @return f_entry_id 分录号 每个订单明细数据从1开始的序号
     */
    public Integer getfEntryId() {
        return fEntryId;
    }

    /**
     * 分录号 每个订单明细数据从1开始的序号
     * @param fEntryId 分录号 每个订单明细数据从1开始的序号
     */
    public void setfEntryId(Integer fEntryId) {
        this.fEntryId = fEntryId;
    }

    /**
     * 商品id
     * @return com_id 商品id
     */
    public Integer getComId() {
        return comId;
    }

    /**
     * 商品id
     * @param comId 商品id
     */
    public void setComId(Integer comId) {
        this.comId = comId;
    }

    /**
     * 商品编号
     * @return com_code 商品编号
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * 商品编号
     * @param comCode 商品编号
     */
    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    /**
     * 商品规格
     * @return com_spec 商品规格
     */
    public String getComSpec() {
        return comSpec;
    }

    /**
     * 商品规格
     * @param comSpec 商品规格
     */
    public void setComSpec(String comSpec) {
        this.comSpec = comSpec == null ? null : comSpec.trim();
    }

    /**
     * 商品单位
     * @return com_unit 商品单位
     */
    public Integer getComUnit() {
        return comUnit;
    }

    /**
     * 商品单位
     * @param comUnit 商品单位
     */
    public void setComUnit(Integer comUnit) {
        this.comUnit = comUnit;
    }

    /**
     * 验收含税进价   =验收含税包装价/包装含量
     * @return tax_pchs_price 验收含税进价   =验收含税包装价/包装含量
     */
    public BigDecimal getTaxPchsPrice() {
        return taxPchsPrice;
    }

    /**
     * 验收含税进价   =验收含税包装价/包装含量
     * @param taxPchsPrice 验收含税进价   =验收含税包装价/包装含量
     */
    public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
        this.taxPchsPrice = taxPchsPrice;
    }

    /**
     * 验收未税进价   =验收未税包装价/包装含量
     * @return notax_pchs_price 验收未税进价   =验收未税包装价/包装含量
     */
    public BigDecimal getNotaxPchsPrice() {
        return notaxPchsPrice;
    }

    /**
     * 验收未税进价   =验收未税包装价/包装含量
     * @param notaxPchsPrice 验收未税进价   =验收未税包装价/包装含量
     */
    public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
        this.notaxPchsPrice = notaxPchsPrice;
    }

    /**
     * 验收含税总价   =验收订货数量*验收含税进价
     * @return tax_sum_price 验收含税总价   =验收订货数量*验收含税进价
     */
    public BigDecimal getTaxSumPrice() {
        return taxSumPrice;
    }

    /**
     * 验收含税总价   =验收订货数量*验收含税进价
     * @param taxSumPrice 验收含税总价   =验收订货数量*验收含税进价
     */
    public void setTaxSumPrice(BigDecimal taxSumPrice) {
        this.taxSumPrice = taxSumPrice;
    }

    /**
     * 验收未税总价  =验收订货数量*验收未税进价
     * @return notax_sum_price 验收未税总价  =验收订货数量*验收未税进价
     */
    public BigDecimal getNotaxSumPrice() {
        return notaxSumPrice;
    }

    /**
     * 验收未税总价  =验收订货数量*验收未税进价
     * @param notaxSumPrice 验收未税总价  =验收订货数量*验收未税进价
     */
    public void setNotaxSumPrice(BigDecimal notaxSumPrice) {
        this.notaxSumPrice = notaxSumPrice;
    }

    /**
     * 验收税率id 关联字典
     * @return tax_id 验收税率id 关联字典
     */
    public Integer getTaxId() {
        return taxId;
    }

    /**
     * 验收税率id 关联字典
     * @param taxId 验收税率id 关联字典
     */
    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    /**
     * 验收税率名称
     * @return tax_name 验收税率名称
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * 验收税率名称
     * @param taxName 验收税率名称
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName == null ? null : taxName.trim();
    }

    /**
     * 验收含税包装价  =验收含税进价*包装含量
     * @return tax_page_price 验收含税包装价  =验收含税进价*包装含量
     */
    public BigDecimal getTaxPagePrice() {
        return taxPagePrice;
    }

    /**
     * 验收含税包装价  =验收含税进价*包装含量
     * @param taxPagePrice 验收含税包装价  =验收含税进价*包装含量
     */
    public void setTaxPagePrice(BigDecimal taxPagePrice) {
        this.taxPagePrice = taxPagePrice;
    }

    /**
     * 验收未税包装价 =验收未税进价*包装含量
     * @return notax_page_price 验收未税包装价 =验收未税进价*包装含量
     */
    public BigDecimal getNotaxPagePrice() {
        return notaxPagePrice;
    }

    /**
     * 验收未税包装价 =验收未税进价*包装含量
     * @param notaxPagePrice 验收未税包装价 =验收未税进价*包装含量
     */
    public void setNotaxPagePrice(BigDecimal notaxPagePrice) {
        this.notaxPagePrice = notaxPagePrice;
    }

    /**
     * 是否赠品 0否 1是
     * @return is_gift 是否赠品 0否 1是
     */
    public Byte getIsGift() {
        return isGift;
    }

    /**
     * 是否赠品 0否 1是
     * @param isGift 是否赠品 0否 1是
     */
    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    /**
     * 包装-验收销售商品id
     * @return p_sale_com_id 包装-验收销售商品id
     */
    public Integer getpSaleComId() {
        return pSaleComId;
    }

    /**
     * 包装-验收销售商品id
     * @param pSaleComId 包装-验收销售商品id
     */
    public void setpSaleComId(Integer pSaleComId) {
        this.pSaleComId = pSaleComId;
    }

    /**
     * 包装-验收销售商品编码
     * @return p_sale_com_code 包装-验收销售商品编码
     */
    public String getpSaleComCode() {
        return pSaleComCode;
    }

    /**
     * 包装-验收销售商品编码
     * @param pSaleComCode 包装-验收销售商品编码
     */
    public void setpSaleComCode(String pSaleComCode) {
        this.pSaleComCode = pSaleComCode == null ? null : pSaleComCode.trim();
    }

    /**
     * 包装-验收销售商品单位 字典表
     * @return p_sale_unit 包装-验收销售商品单位 字典表
     */
    public Integer getpSaleUnit() {
        return pSaleUnit;
    }

    /**
     * 包装-验收销售商品单位 字典表
     * @param pSaleUnit 包装-验收销售商品单位 字典表
     */
    public void setpSaleUnit(Integer pSaleUnit) {
        this.pSaleUnit = pSaleUnit;
    }

    /**
     * 包装-验收销售商品含量
     * @return p_sale_pack_content 包装-验收销售商品含量
     */
    public Integer getpSalePackContent() {
        return pSalePackContent;
    }

    /**
     * 包装-验收销售商品含量
     * @param pSalePackContent 包装-验收销售商品含量
     */
    public void setpSalePackContent(Integer pSalePackContent) {
        this.pSalePackContent = pSalePackContent;
    }

    /**
     * 包装-验收订货包装数量=订货数量/包装含量
     * @return order_page_count 包装-验收订货包装数量=订货数量/包装含量
     */
    public BigDecimal getOrderPageCount() {
        return orderPageCount;
    }

    /**
     * 包装-验收订货包装数量=订货数量/包装含量
     * @param orderPageCount 包装-验收订货包装数量=订货数量/包装含量
     */
    public void setOrderPageCount(BigDecimal orderPageCount) {
        this.orderPageCount = orderPageCount;
    }

    /**
     * 包装-验收赠品包装数量=赠品数量/包装含量
     * @return gift_page_count 包装-验收赠品包装数量=赠品数量/包装含量
     */
    public BigDecimal getGiftPageCount() {
        return giftPageCount;
    }

    /**
     * 包装-验收赠品包装数量=赠品数量/包装含量
     * @param giftPageCount 包装-验收赠品包装数量=赠品数量/包装含量
     */
    public void setGiftPageCount(BigDecimal giftPageCount) {
        this.giftPageCount = giftPageCount;
    }

    /**
     * 包装-验收合计包装数量=订货包装数量+赠品包装数量
     * @return o_g_page_count 包装-验收合计包装数量=订货包装数量+赠品包装数量
     */
    public BigDecimal getoGPageCount() {
        return oGPageCount;
    }

    /**
     * 包装-验收合计包装数量=订货包装数量+赠品包装数量
     * @param oGPageCount 包装-验收合计包装数量=订货包装数量+赠品包装数量
     */
    public void setoGPageCount(BigDecimal oGPageCount) {
        this.oGPageCount = oGPageCount;
    }

    /**
     * 转换-验收销售商品id
     * @return g_sale_com_id 转换-验收销售商品id
     */
    public Integer getgSaleComId() {
        return gSaleComId;
    }

    /**
     * 转换-验收销售商品id
     * @param gSaleComId 转换-验收销售商品id
     */
    public void setgSaleComId(Integer gSaleComId) {
        this.gSaleComId = gSaleComId;
    }

    /**
     * 转换-验收销售商品编码
     * @return g_sale_com_code 转换-验收销售商品编码
     */
    public String getgSaleComCode() {
        return gSaleComCode;
    }

    /**
     * 转换-验收销售商品编码
     * @param gSaleComCode 转换-验收销售商品编码
     */
    public void setgSaleComCode(String gSaleComCode) {
        this.gSaleComCode = gSaleComCode == null ? null : gSaleComCode.trim();
    }

    /**
     * 转换-验收销售商品单位 字典表
     * @return g_sale_unit 转换-验收销售商品单位 字典表
     */
    public Integer getgSaleUnit() {
        return gSaleUnit;
    }

    /**
     * 转换-验收销售商品单位 字典表
     * @param gSaleUnit 转换-验收销售商品单位 字典表
     */
    public void setgSaleUnit(Integer gSaleUnit) {
        this.gSaleUnit = gSaleUnit;
    }

    /**
     * 转换-验收销售商品含量
     * @return g_sale_pack_content 转换-验收销售商品含量
     */
    public Integer getgSalePackContent() {
        return gSalePackContent;
    }

    /**
     * 转换-验收销售商品含量
     * @param gSalePackContent 转换-验收销售商品含量
     */
    public void setgSalePackContent(Integer gSalePackContent) {
        this.gSalePackContent = gSalePackContent;
    }

    /**
     * 转换-验收订货数量   =验收订货包装数量*包装含量
     * @return order_count 转换-验收订货数量   =验收订货包装数量*包装含量
     */
    public BigDecimal getOrderCount() {
        return orderCount;
    }

    /**
     * 转换-验收订货数量   =验收订货包装数量*包装含量
     * @param orderCount 转换-验收订货数量   =验收订货包装数量*包装含量
     */
    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    /**
     * 转换-验收赠品数量   =验收赠品包装数量*包装含量
     * @return gift_count 转换-验收赠品数量   =验收赠品包装数量*包装含量
     */
    public BigDecimal getGiftCount() {
        return giftCount;
    }

    /**
     * 转换-验收赠品数量   =验收赠品包装数量*包装含量
     * @param giftCount 转换-验收赠品数量   =验收赠品包装数量*包装含量
     */
    public void setGiftCount(BigDecimal giftCount) {
        this.giftCount = giftCount;
    }

    /**
     * 转换-验收合计数量=验收订货数量 +验收赠品数量
     * @return o_g_count 转换-验收合计数量=验收订货数量 +验收赠品数量
     */
    public BigDecimal getoGCount() {
        return oGCount;
    }

    /**
     * 转换-验收合计数量=验收订货数量 +验收赠品数量
     * @param oGCount 转换-验收合计数量=验收订货数量 +验收赠品数量
     */
    public void setoGCount(BigDecimal oGCount) {
        this.oGCount = oGCount;
    }

    /**
     * 创建人
     * @return creater 创建人
     */
    public Long getCreater() {
        return creater;
    }

    /**
     * 创建人
     * @param creater 创建人
     */
    public void setCreater(Long creater) {
        this.creater = creater;
    }

    /**
     * 修改人
     * @return modifier 修改人
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * 修改人
     * @param modifier 修改人
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * 创建时间
     * @return created_time 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 修改时间
     * @return updated_time 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 修改时间
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否删除 0否 1是
     * @return is_delete 是否删除 0否 1是
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 0否 1是
     * @param isDelete 是否删除 0否 1是
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 说明
     * @return state 说明
     */
    public String getState() {
        return state;
    }

    /**
     * 说明
     * @param state 说明
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 入库状态 字典
     * @return whin_status 入库状态 字典
     */
    public Integer getWhinStatus() {
        return whinStatus;
    }

    /**
     * 入库状态 字典
     * @param whinStatus 入库状态 字典
     */
    public void setWhinStatus(Integer whinStatus) {
        this.whinStatus = whinStatus;
    }

    /**
     * 同步状态 10未同步 20同步中 30已同步
     * @return sync_status 同步状态 10未同步 20同步中 30已同步
     */
    public Integer getSyncStatus() {
        return syncStatus;
    }

    /**
     * 同步状态 10未同步 20同步中 30已同步
     * @param syncStatus 同步状态 10未同步 20同步中 30已同步
     */
    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}