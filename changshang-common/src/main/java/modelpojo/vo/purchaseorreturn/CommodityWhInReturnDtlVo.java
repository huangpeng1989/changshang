package modelpojo.vo.purchaseorreturn;

import java.math.BigDecimal;

import modelpojo.model.CommodityWhInReturnDtl;

public class CommodityWhInReturnDtlVo extends CommodityWhInReturnDtl {

	/**
	* 
	*/

	/**
	 * 本次入库订货数量
	 */
	private BigDecimal returnOrderPageCount;

	/**
	 * 本次入库赠品数量
	 */
	private BigDecimal returnGiftPageCount;
	/**
	 * 该验收单下已退货数量
	 */
	private BigDecimal alreadyReturn;
	/**
	 * 该验收单下可退货数量
	 */
	private BigDecimal returnAble;

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

	//验收单编号
	private String acptBillCode;

	/**可退订货数 */
	private BigDecimal returnableOrderCount;
	/**可退赠品数 */
	private BigDecimal returnableGiftCount;
	/**销售商品单位 */
	private String pSaleCommUnitName;

	/**冻结数量 */
	private BigDecimal freeaeCount;

	public BigDecimal getFreeaeCount() {
		return freeaeCount;
	}

	public void setFreeaeCount(BigDecimal freeaeCount) {
		this.freeaeCount = freeaeCount;
	}

	public String getpSaleCommUnitName() {
		return pSaleCommUnitName;
	}

	public void setpSaleCommUnitName(String pSaleCommUnitName) {
		this.pSaleCommUnitName = pSaleCommUnitName;
	}

	public BigDecimal getReturnableOrderCount() {
		return returnableOrderCount;
	}

	public void setReturnableOrderCount(BigDecimal returnableOrderCount) {
		this.returnableOrderCount = returnableOrderCount;
	}

	public BigDecimal getReturnableGiftCount() {
		return returnableGiftCount;
	}

	public void setReturnableGiftCount(BigDecimal returnableGiftCount) {
		this.returnableGiftCount = returnableGiftCount;
	}

	public String getAcptBillCode() {
		return acptBillCode;
	}

	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
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

	public BigDecimal getReturnOrderPageCount() {
		return returnOrderPageCount;
	}

	public void setReturnOrderPageCount(BigDecimal returnOrderPageCount) {
		this.returnOrderPageCount = returnOrderPageCount;
	}

	public BigDecimal getReturnGiftPageCount() {
		return returnGiftPageCount;
	}

	public void setReturnGiftPageCount(BigDecimal returnGiftPageCount) {
		this.returnGiftPageCount = returnGiftPageCount;
	}

}
