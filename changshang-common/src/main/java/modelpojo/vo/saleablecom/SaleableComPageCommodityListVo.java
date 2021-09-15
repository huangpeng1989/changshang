package modelpojo.vo.saleablecom;

import modelpojo.model.CommoditySaledComBillDetail;

import java.math.BigDecimal;

public class SaleableComPageCommodityListVo extends CommoditySaledComBillDetail {
	/**
	 *
	 */
	private static final long serialVersionUID = -4962088140063906916L;
	private String comCode;
	private String saleComCode;
	private String comName;
	private String comSpec;
	private Integer comUnit;
	private String comUnitName;
	private String saleCommUnitCode;
	private String taxName;
	private Integer taxId;
	private BigDecimal noTaxPaid;
	private BigDecimal taxPaid;
	private String comType;
	private String comType2;
	private String comType3;
	private String comType4;
	private String comType5;
	private String saleCommUnit;
	private String sellModel;
	private String comBarcode;
	private BigDecimal memberPrice;
	private BigDecimal packContent;
	private Integer saleComId;
	private Integer gpId;
	private Integer supComId;
	private BigDecimal acptTaxPchsPrice;
	private BigDecimal acptNotaxPchsPrice;
	private Byte comSaleStatus;
	/**
	  * 已入库数
	  */
	 private BigDecimal storageCount;
	 /**
	  * 已入库订货数
	  */
	 private BigDecimal storageOrderCount;
	 /**
	  * 已入库赠品数
	  */
	 private BigDecimal storageGiftCount;
	 /**
	  * 订货数
	  */
	 private BigDecimal orderPageCount;
	 /**
	  * 赠品数
	  */
	 private BigDecimal giftPageCount;
	 /**
	  * 当前仓库总数量
	  */
	 private BigDecimal whStock;
	 /**
	  * 该验收单下已退货数量
	  */
	 private BigDecimal alreadyReturn;
	 /**
	  * 该验收单下可退货数量
	  */
	 private BigDecimal returnAble;

	 //红冲数
	 private BigDecimal hcPageCount;


	private String gzoneName;

	//采购含税进价
	private BigDecimal purchaseTaxPaid;
	//采购未税进价
	private BigDecimal purchaseNoTaxPaid;

	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getPurchaseTaxPaid() {
		return purchaseTaxPaid;
	}

	public void setPurchaseTaxPaid(BigDecimal purchaseTaxPaid) {
		this.purchaseTaxPaid = purchaseTaxPaid;
	}

	public BigDecimal getPurchaseNoTaxPaid() {
		return purchaseNoTaxPaid;
	}

	public void setPurchaseNoTaxPaid(BigDecimal purchaseNoTaxPaid) {
		this.purchaseNoTaxPaid = purchaseNoTaxPaid;
	}

	public String getGzoneName() {
		return gzoneName;
	}

	public void setGzoneName(String gzoneName) {
		this.gzoneName = gzoneName;
	}



	public String getComUnitName() {
		return comUnitName;
	}
	public void setComUnitName(String comUnitName) {
		this.comUnitName = comUnitName;
	}
	public String getSaleCommUnitCode() {
		return saleCommUnitCode;
	}
	public void setSaleCommUnitCode(String saleCommUnitCode) {
		this.saleCommUnitCode = saleCommUnitCode;
	}
	public BigDecimal getAcptTaxPchsPrice() {
		return acptTaxPchsPrice;
	}
	public void setAcptTaxPchsPrice(BigDecimal acptTaxPchsPrice) {
		this.acptTaxPchsPrice = acptTaxPchsPrice;
	}
	public BigDecimal getAcptNotaxPchsPrice() {
		return acptNotaxPchsPrice;
	}
	public void setAcptNotaxPchsPrice(BigDecimal acptNotaxPchsPrice) {
		this.acptNotaxPchsPrice = acptNotaxPchsPrice;
	}
	public Integer getTaxId() {
		return taxId;
	}
	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}
	public BigDecimal getReturnAble() {
		return returnAble;
	}
	public void setReturnAble(BigDecimal returnAble) {
		this.returnAble = returnAble;
	}
	public BigDecimal getAlreadyReturn() {
		return alreadyReturn;
	}
	public void setAlreadyReturn(BigDecimal alreadyReturn) {
		this.alreadyReturn = alreadyReturn;
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
	public BigDecimal getStorageOrderCount() {
		return storageOrderCount;
	}
	public void setStorageOrderCount(BigDecimal storageOrderCount) {
		this.storageOrderCount = storageOrderCount;
	}
	public BigDecimal getStorageGiftCount() {
		return storageGiftCount;
	}
	public void setStorageGiftCount(BigDecimal storageGiftCount) {
		this.storageGiftCount = storageGiftCount;
	}
	public Integer getSaleComId() {
		return saleComId;
	}
	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}
	public Integer getGpId() {
		return gpId;
	}
	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}
	public Integer getSupComId() {
		return supComId;
	}
	public void setSupComId(Integer supComId) {
		this.supComId = supComId;
	}
	public BigDecimal getWhStock() {
		return whStock;
	}
	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}
	public BigDecimal getStorageCount() {
		return storageCount;
	}
	public void setStorageCount(BigDecimal storageCount) {
		this.storageCount = storageCount;
	}
	public BigDecimal getPackContent() {
		return packContent;
	}
	public void setPackContent(BigDecimal packContent) {
		this.packContent = packContent;
	}
	public String getComSpec() {
		return comSpec;
	}
	public void setComSpec(String comSpec) {
		this.comSpec = comSpec;
	}
	public Integer getComUnit() {
		return comUnit;
	}
	public void setComUnit(Integer comUnit) {
		this.comUnit = comUnit;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public BigDecimal getNoTaxPaid() {
		return noTaxPaid;
	}
	public void setNoTaxPaid(BigDecimal noTaxPaid) {
		this.noTaxPaid = noTaxPaid;
	}
	public BigDecimal getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(BigDecimal taxPaid) {
		this.taxPaid = taxPaid;
	}
	public String getComType2() {
		return comType2;
	}
	public void setComType2(String comType2) {
		this.comType2 = comType2;
	}
	public String getComType3() {
		return comType3;
	}
	public void setComType3(String comType3) {
		this.comType3 = comType3;
	}
	public String getComType4() {
		return comType4;
	}
	public void setComType4(String comType4) {
		this.comType4 = comType4;
	}
	public String getComType5() {
		return comType5;
	}
	public void setComType5(String comType5) {
		this.comType5 = comType5;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getSaleComCode() {
		return saleComCode;
	}
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getSaleCommUnit() {
		return saleCommUnit;
	}
	public void setSaleCommUnit(String saleCommUnit) {
		this.saleCommUnit = saleCommUnit;
	}
	public String getSellModel() {
		return sellModel;
	}
	public void setSellModel(String sellModel) {
		this.sellModel = sellModel;
	}
	public String getComBarcode() {
		return comBarcode;
	}
	public void setComBarcode(String comBarcode) {
		this.comBarcode = comBarcode;
	}
	public BigDecimal getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}
	public Byte getComSaleStatus() {
		return comSaleStatus;
	}
	public void setComSaleStatus(Byte comSaleStatus) {
		this.comSaleStatus = comSaleStatus;
	}
	public BigDecimal getHcPageCount() {
		return hcPageCount;
	}
	public void setHcPageCount(BigDecimal hcPageCount) {
		this.hcPageCount = hcPageCount;
	}

}
