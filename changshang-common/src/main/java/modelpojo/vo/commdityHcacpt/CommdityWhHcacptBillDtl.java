package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommdityWhHcacptBillDtl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2849076014165637825L;
	private Long projectId;//项目id
	private Long projectRootId;//项目根节点id,
	private Integer hcBillId;//红冲验收入库单id
	private String hcBillCode;//红冲验收入库单号
	private String acptBillId;//验收入库单id
	private String acptBillCode;//验收入库单code
	private Integer fEntryId;//分录号 每个订单明细数据从1开始的序号
	private Integer comId;//商品id
	private String comCode;//商品编号
	private String comSpec;//商品规格
	private String comBarcode;//商品条码
	private Integer comUnit;//商品单位
	private BigDecimal taxPchsPrice;//本次红冲商品含税进价   =验收含税包装价/包装含量
	private BigDecimal notaxPchsPrice;//本次红冲商品未税进价   =验收未税包装价/包装含量
	private BigDecimal taxSumPrice;//本次红冲商品含税总价   =验收订货数量*验收含税进价
	private BigDecimal notaxSumPrice;//本次红冲商品未税总价  =验收订货数量*验收未税进价
	private Integer taxId;//本次红冲商品进项税税率id 关联字典
	private String taxName;//本次红冲商品进项税税率名称
	private BigDecimal taxPagePrice;//本次红商品冲含税包装价  =本次红冲含税进价*包装含量
	private BigDecimal notaxPagePrice;//本次红冲商品未税包装价 =验收未税进价*包装含量
	private Integer isGift;//是否含赠品 0否 1是
	private Integer pSaleComId;//包装-本次红冲销售商品id
	private String pSaleComCode;//包装-本次红冲销售商品编码
	private Integer pSaleUnit;//包装-本次红冲销售商品单位 字典表
	private Integer pSalePackContent;//包装-本次红冲销售商品含量
	private BigDecimal orderPageCount;//包装-本次红冲订货包装数量=订货数量/包装含量
	private BigDecimal giftPageCount;//包装-本次红冲赠品包装数量=赠品数量/包装含量
	private BigDecimal oGPageCount;//包装-本次红冲合计包装数量=包装-订货包装数量+包装-赠品包装数量
	private Integer gSaleComId;//转换-本次红冲销售商品id
	private String gSaleComCode;//转换-本次红冲销售商品编码
	private Integer gSaleUnit;//转换-本次红冲销售商品单位 字典表
	private BigDecimal gSalePackContent;//转换-本次红冲销售商品含量
	private BigDecimal orderCount;//转换-本次红冲订货数量   =转换-本次红冲验收订货包装数量*包装含量
	private BigDecimal giftCount;//转换-本次红冲赠品数量   =转换-本次红冲验收赠品包装数量*包装含量
	private BigDecimal oGCount;//转换-本次红冲合计数量=转换-验收订货数量 +转换-验收赠品数量
	private Integer batchId;//批次号
	private Long creater;//创建人
	private Long modifier;//修改人
	private Date createdTime;//创建时间
	private Date updatedTime;//修改时间
	private Integer status;//状态
	private Integer isDelete;//是否删除 0否 1是
	private Integer whinStatus;//入库状态 字典
	private Integer syncStatus;//同步状态 10未同步 20同步中 30已同步
	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getProjectRootId() {
		return projectRootId;
	}
	public void setProjectRootId(Long projectRootId) {
		this.projectRootId = projectRootId;
	}
	public Integer getHcBillId() {
		return hcBillId;
	}
	public void setHcBillId(Integer hcBillId) {
		this.hcBillId = hcBillId;
	}
	public String getHcBillCode() {
		return hcBillCode;
	}
	public void setHcBillCode(String hcBillCode) {
		this.hcBillCode = hcBillCode;
	}
	public String getAcptBillId() {
		return acptBillId;
	}
	public void setAcptBillId(String acptBillId) {
		this.acptBillId = acptBillId;
	}
	public String getAcptBillCode() {
		return acptBillCode;
	}
	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
	}
	public Integer getfEntryId() {
		return fEntryId;
	}
	public void setfEntryId(Integer fEntryId) {
		this.fEntryId = fEntryId;
	}
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComSpec() {
		return comSpec;
	}
	public void setComSpec(String comSpec) {
		this.comSpec = comSpec;
	}
	public String getComBarcode() {
		return comBarcode;
	}
	public void setComBarcode(String comBarcode) {
		this.comBarcode = comBarcode;
	}
	public Integer getComUnit() {
		return comUnit;
	}
	public void setComUnit(Integer comUnit) {
		this.comUnit = comUnit;
	}
	public BigDecimal getTaxPchsPrice() {
		return taxPchsPrice;
	}
	public void setTaxPchsPrice(BigDecimal taxPchsPrice) {
		this.taxPchsPrice = taxPchsPrice;
	}
	public BigDecimal getNotaxPchsPrice() {
		return notaxPchsPrice;
	}
	public void setNotaxPchsPrice(BigDecimal notaxPchsPrice) {
		this.notaxPchsPrice = notaxPchsPrice;
	}
	public BigDecimal getTaxSumPrice() {
		return taxSumPrice;
	}
	public void setTaxSumPrice(BigDecimal taxSumPrice) {
		this.taxSumPrice = taxSumPrice;
	}
	public BigDecimal getNotaxSumPrice() {
		return notaxSumPrice;
	}
	public void setNotaxSumPrice(BigDecimal notaxSumPrice) {
		this.notaxSumPrice = notaxSumPrice;
	}
	public Integer getTaxId() {
		return taxId;
	}
	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public BigDecimal getTaxPagePrice() {
		return taxPagePrice;
	}
	public void setTaxPagePrice(BigDecimal taxPagePrice) {
		this.taxPagePrice = taxPagePrice;
	}
	public BigDecimal getNotaxPagePrice() {
		return notaxPagePrice;
	}
	public void setNotaxPagePrice(BigDecimal notaxPagePrice) {
		this.notaxPagePrice = notaxPagePrice;
	}
	public Integer getIsGift() {
		return isGift;
	}
	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}
	public Integer getpSaleComId() {
		return pSaleComId;
	}
	public void setpSaleComId(Integer pSaleComId) {
		this.pSaleComId = pSaleComId;
	}
	public String getpSaleComCode() {
		return pSaleComCode;
	}
	public void setpSaleComCode(String pSaleComCode) {
		this.pSaleComCode = pSaleComCode;
	}
	public Integer getpSaleUnit() {
		return pSaleUnit;
	}
	public void setpSaleUnit(Integer pSaleUnit) {
		this.pSaleUnit = pSaleUnit;
	}
	public Integer getpSalePackContent() {
		return pSalePackContent;
	}
	public void setpSalePackContent(Integer pSalePackContent) {
		this.pSalePackContent = pSalePackContent;
	}
	public BigDecimal getOrderPageCount() {
		return orderPageCount;
	}
	public void setOrderPageCount(BigDecimal orderPageCount) {
		this.orderPageCount = orderPageCount;
	}
	public BigDecimal getGiftPageCount() {
		return giftPageCount;
	}
	public void setGiftPageCount(BigDecimal giftPageCount) {
		this.giftPageCount = giftPageCount;
	}
	public BigDecimal getoGPageCount() {
		return oGPageCount;
	}
	public void setoGPageCount(BigDecimal oGPageCount) {
		this.oGPageCount = oGPageCount;
	}
	public Integer getgSaleComId() {
		return gSaleComId;
	}
	public void setgSaleComId(Integer gSaleComId) {
		this.gSaleComId = gSaleComId;
	}
	public String getgSaleComCode() {
		return gSaleComCode;
	}
	public void setgSaleComCode(String gSaleComCode) {
		this.gSaleComCode = gSaleComCode;
	}
	public Integer getgSaleUnit() {
		return gSaleUnit;
	}
	public void setgSaleUnit(Integer gSaleUnit) {
		this.gSaleUnit = gSaleUnit;
	}
	public BigDecimal getgSalePackContent() {
		return gSalePackContent;
	}
	public void setgSalePackContent(BigDecimal gSalePackContent) {
		this.gSalePackContent = gSalePackContent;
	}
	public BigDecimal getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(BigDecimal orderCount) {
		this.orderCount = orderCount;
	}
	public BigDecimal getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(BigDecimal giftCount) {
		this.giftCount = giftCount;
	}
	public BigDecimal getoGCount() {
		return oGCount;
	}
	public void setoGCount(BigDecimal oGCount) {
		this.oGCount = oGCount;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
	}
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getWhinStatus() {
		return whinStatus;
	}
	public void setWhinStatus(Integer whinStatus) {
		this.whinStatus = whinStatus;
	}
	public Integer getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

}
