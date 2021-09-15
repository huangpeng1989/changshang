package modelpojo.vo.commdityHcacpt;

import java.math.BigDecimal;

public class CommdityHcacptDtlVo extends CommdityWhHcacptBillDtl{

	/**
	 *
	 */
	private static final long serialVersionUID = -1752423261572971074L;
	private String comName;//商品名称
	private String saleUnitName;//销售单位名称
	private String comUnitName;//商品单位名称
	private BigDecimal acptOrderPageCount;//包装-验收订货包装数量
	private BigDecimal acptGiftPageCount;//包装-验收赠品包装数量
	private BigDecimal canOrderPageCount;//可红冲包装-订货数量
	private BigDecimal canGiftPageCount;//可红冲包装-赠品数量
	private BigDecimal hcTaxPchsPrice;//红冲含税金额
	private BigDecimal hcNotaxPchsPrice;//红冲未税金额

	/**库存 */
	private BigDecimal whStock;
	/**冻结数量 */
	private BigDecimal freeaeCount;

	public BigDecimal getWhStock() {
		return whStock;
	}

	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}

	public BigDecimal getFreeaeCount() {
		return freeaeCount;
	}

	public void setFreeaeCount(BigDecimal freeaeCount) {
		this.freeaeCount = freeaeCount;
	}

	public BigDecimal getHcTaxPchsPrice() {
		return hcTaxPchsPrice;
	}

	public void setHcTaxPchsPrice(BigDecimal hcTaxPchsPrice) {
		this.hcTaxPchsPrice = hcTaxPchsPrice;
	}

	public BigDecimal getHcNotaxPchsPrice() {
		return hcNotaxPchsPrice;
	}

	public void setHcNotaxPchsPrice(BigDecimal hcNotaxPchsPrice) {
		this.hcNotaxPchsPrice = hcNotaxPchsPrice;
	}

	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getSaleUnitName() {
		return saleUnitName;
	}
	public void setSaleUnitName(String saleUnitName) {
		this.saleUnitName = saleUnitName;
	}
	public String getComUnitName() {
		return comUnitName;
	}
	public void setComUnitName(String comUnitName) {
		this.comUnitName = comUnitName;
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

}
