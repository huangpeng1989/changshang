package modelpojo.vo.purchaseorreturn;

import java.math.BigDecimal;

import modelpojo.model.CommodityWhInDtl;

public class CommodityWhInDtlVo extends CommodityWhInDtl {

	/**
	 * 
	 */

	
	 /**
	  * 当前仓库总数量
	  */
	 private BigDecimal whStock;
	 /**
	  * 该采购单已入库数
	  */
	 private BigDecimal storageCount;
	 private Integer saleComId;
	 private Integer comId;
	 private Integer gpId;
	 private Integer supComId;
	 private String comName;
	 private String comBarcode;


	 /**
	  * 已入库订货数
	  */
	 private BigDecimal storageOrderCount;
	 /**
	  * 已入库赠品数
	  */
	 private BigDecimal storageGiftCount;
	 /**
	  * 销售商品单位名称
	  */
	 private String saleCommUnitName;
	 /**
	  * 商品单位名称
	  */
	 private String comUnitName;
	 /**
	  * 默认含税进价
	  */
	 private String taxPaid;
	 /**
	  * 默认未税进价
	  */
	 private String noTaxPaid;

	private BigDecimal taxPchsCount;
	private BigDecimal notaxPchsCount;

	public BigDecimal getTaxPchsCount() {
		return taxPchsCount;
	}

	public void setTaxPchsCount(BigDecimal taxPchsCount) {
		this.taxPchsCount = taxPchsCount;
	}

	public BigDecimal getNotaxPchsCount() {
		return notaxPchsCount;
	}

	public void setNotaxPchsCount(BigDecimal notaxPchsCount) {
		this.notaxPchsCount = notaxPchsCount;
	}

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
	public String getSaleCommUnitName() {
		return saleCommUnitName;
	}
	public void setSaleCommUnitName(String saleCommUnitName) {
		this.saleCommUnitName = saleCommUnitName;
	}
	public String getComUnitName() {
		return comUnitName;
	}
	public void setComUnitName(String comUnitName) {
		this.comUnitName = comUnitName;
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
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComBarcode() {
		return comBarcode;
	}
	public void setComBarcode(String comBarcode) {
		this.comBarcode = comBarcode;
	}
	public Integer getSaleComId() {
		return saleComId;
	}
	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
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
	public BigDecimal getStorageCount() {
		return storageCount;
	}
	public void setStorageCount(BigDecimal storageCount) {
		this.storageCount = storageCount;
	}
	public BigDecimal getWhStock() {
		return whStock;
	}
	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}

}
