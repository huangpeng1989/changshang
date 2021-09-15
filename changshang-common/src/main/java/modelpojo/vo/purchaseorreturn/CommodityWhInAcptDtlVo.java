package modelpojo.vo.purchaseorreturn;

import java.math.BigDecimal;

public class CommodityWhInAcptDtlVo extends CommodityWhInDtlVo {

	/**
	  * 采购单订货数量
	  */
	 private BigDecimal purOrderPageCount;
	 
	 /**
	  * 采购单赠品数量
	  */
	 private BigDecimal purGiftPageCount;
	 /**
	  * 该验收单下已退货数量
	  */
	 private BigDecimal alreadyReturn;
	 /**
	  * 该验收单下可退货数量
	  */
	 private BigDecimal returnAble;
	 /**
	  * 默认含税进价
	  */
	 private String taxPaid;
	 /**
	  * 默认未税进价
	  */
	 private String noTaxPaid;

	public String getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(String taxPaid) {
		this.taxPaid = taxPaid;
	}
	public String getNoTaxPaid() {
		return noTaxPaid;
	}
	public void setNoTaxPaid(String noTaxPaid) {
		this.noTaxPaid = noTaxPaid;
	}
	 
	public BigDecimal getAlreadyReturn() {
		return alreadyReturn;
	}

	public void setAlreadyReturn(BigDecimal alreadyReturn) {
		this.alreadyReturn = alreadyReturn;
	}

	public BigDecimal getReturnAble() {
		return returnAble;
	}

	public void setReturnAble(BigDecimal returnAble) {
		this.returnAble = returnAble;
	}

	public BigDecimal getPurOrderPageCount() {
		return purOrderPageCount;
	}

	public void setPurOrderPageCount(BigDecimal purOrderPageCount) {
		this.purOrderPageCount = purOrderPageCount;
	}

	public BigDecimal getPurGiftPageCount() {
		return purGiftPageCount;
	}

	public void setPurGiftPageCount(BigDecimal purGiftPageCount) {
		this.purGiftPageCount = purGiftPageCount;
	}

}
