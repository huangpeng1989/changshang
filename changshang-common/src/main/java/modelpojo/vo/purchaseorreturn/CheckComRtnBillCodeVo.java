package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;
import java.math.BigDecimal;

public class CheckComRtnBillCodeVo implements Serializable{

	/**商品ID */
	private Integer comId;
	/**商品编号 */
	private String comCode;
	/**销售商品单位 */
	private Integer saleCommUnit;
	/**销售商品单位名称 */
	private String saleCommUnitName;
	/**商品名称 */
	private String comName;
	/**包装含量 */
	private BigDecimal packContent;
	/**可退订货数 */
	private BigDecimal returnableOrderCount;
	/**可退赠品数 */
	private BigDecimal returnableGiftCount;
	/**库存数 */
	private BigDecimal whStock;
	/**退货订货数量 */
	private BigDecimal  pOrderPageCount;
	/**退货赠品数量 */
	private BigDecimal  pGiftPageCount;
	/**验收单号 */
	private String acptBillCode;
	/**退货单号 */
	private String rtnBillCodes;
	/**红冲单号 */
	private String hcBillCodes;
	/**冻结数量 */
	private BigDecimal freeaeCount;

	public BigDecimal getFreeaeCount() {
		return freeaeCount;
	}

	public void setFreeaeCount(BigDecimal freeaeCount) {
		this.freeaeCount = freeaeCount;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getHcBillCodes() {
		return hcBillCodes;
	}

	public void setHcBillCodes(String hcBillCodes) {
		this.hcBillCodes = hcBillCodes;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getSaleCommUnit() {
		return saleCommUnit;
	}

	public void setSaleCommUnit(Integer saleCommUnit) {
		this.saleCommUnit = saleCommUnit;
	}

	public String getSaleCommUnitName() {
		return saleCommUnitName;
	}

	public void setSaleCommUnitName(String saleCommUnitName) {
		this.saleCommUnitName = saleCommUnitName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public BigDecimal getPackContent() {
		return packContent;
	}

	public void setPackContent(BigDecimal packContent) {
		this.packContent = packContent;
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

	public BigDecimal getWhStock() {
		return whStock;
	}

	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}

	public BigDecimal getpOrderPageCount() {
		return pOrderPageCount;
	}

	public void setpOrderPageCount(BigDecimal pOrderPageCount) {
		this.pOrderPageCount = pOrderPageCount;
	}

	public BigDecimal getpGiftPageCount() {
		return pGiftPageCount;
	}

	public void setpGiftPageCount(BigDecimal pGiftPageCount) {
		this.pGiftPageCount = pGiftPageCount;
	}

	public String getAcptBillCode() {
		return acptBillCode;
	}

	public void setAcptBillCode(String acptBillCode) {
		this.acptBillCode = acptBillCode;
	}

	public String getRtnBillCodes() {
		return rtnBillCodes;
	}

	public void setRtnBillCodes(String rtnBillCodes) {
		this.rtnBillCodes = rtnBillCodes;
	}
}
