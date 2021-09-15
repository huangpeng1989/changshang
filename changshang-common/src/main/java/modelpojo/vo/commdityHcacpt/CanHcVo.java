package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.math.BigDecimal;

public class CanHcVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1508809652994987767L;

	private Integer comId;//商品id
	
	private Integer saleComId;//销售商品id

	private BigDecimal salePackContent;//销售商品包装含量
	
	private BigDecimal orderCount;//退货数量
	
	private BigDecimal orderPageCount;//包装-验收订货包装数量（红冲）
	
	private BigDecimal giftPageCount;//包装-验收赠品包装数量（红冲）
	
	private BigDecimal acptOrderPageCount;//包装-验收订货包装数量（入库）
	
	private BigDecimal acptGiftPageCount;//包装-验收赠品包装数量（入库）
	
	private BigDecimal canOrderPageCount;//可红冲包装-订货数量
	
	private BigDecimal canGiftPageCount;//可红冲包装-赠品数量
	
	private BigDecimal whStock;//库存数
	
	private String comCode;//商品编号
	
	private String comSpec;//商品规格
	
	private String comBarcode;//商品条码
	
	private String paleComCode;//销售商品编码
	
	private String comName;//商品名称
	
	private String msg;//未通过原因

	private BigDecimal orderPageCountSum;//已退货总数量
	private BigDecimal giftPageCountSum;//已退货赠品总数量

	public BigDecimal getOrderPageCountSum() {
		return orderPageCountSum;
	}

	public void setOrderPageCountSum(BigDecimal orderPageCountSum) {
		this.orderPageCountSum = orderPageCountSum;
	}

	public BigDecimal getGiftPageCountSum() {
		return giftPageCountSum;
	}

	public void setGiftPageCountSum(BigDecimal giftPageCountSum) {
		this.giftPageCountSum = giftPageCountSum;
	}

	public BigDecimal getSalePackContent() {
		return salePackContent;
	}

	public void setSalePackContent(BigDecimal salePackContent) {
		this.salePackContent = salePackContent;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getSaleComId() {
		return saleComId;
	}

	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}

	public BigDecimal getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(BigDecimal orderCount) {
		this.orderCount = orderCount;
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

	public BigDecimal getAcptOrderPageCount() {
		return acptOrderPageCount;
	}

	public void setAcptOrderPageCount(BigDecimal acptOrderPageCount) {
		this.acptOrderPageCount = acptOrderPageCount;
	}

	public BigDecimal getAcptGiftPageCount() {
		return acptGiftPageCount;
	}

	public void setAcptGiftPageCount(BigDecimal acptGiftPageCount) {
		this.acptGiftPageCount = acptGiftPageCount;
	}

	public BigDecimal getCanOrderPageCount() {
		return canOrderPageCount;
	}

	public void setCanOrderPageCount(BigDecimal canOrderPageCount) {
		this.canOrderPageCount = canOrderPageCount;
	}

	public BigDecimal getCanGiftPageCount() {
		return canGiftPageCount;
	}

	public void setCanGiftPageCount(BigDecimal canGiftPageCount) {
		this.canGiftPageCount = canGiftPageCount;
	}

	public BigDecimal getWhStock() {
		return whStock;
	}

	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
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

	public String getPaleComCode() {
		return paleComCode;
	}

	public void setPaleComCode(String paleComCode) {
		this.paleComCode = paleComCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
