package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;
import java.math.BigDecimal;

public class CheckRmRtnBillCodeVo implements Serializable{

	/**原材料ID */
	private Integer rmId;
	/**原材料编号 */
	private String rmCode;
	/**销售原材料单位 */
	private Integer srmUnit;
	/**销售原材料单位名称 */
	private String srmUnitName;
	/**原材料名称 */
	private String rmName;
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

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getHcBillCodes() {
		return hcBillCodes;
	}

	public void setHcBillCodes(String hcBillCodes) {
		this.hcBillCodes = hcBillCodes;
	}

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Integer getSrmUnit() {
		return srmUnit;
	}

	public void setSrmUnit(Integer srmUnit) {
		this.srmUnit = srmUnit;
	}

	public String getSrmUnitName() {
		return srmUnitName;
	}

	public void setSrmUnitName(String srmUnitName) {
		this.srmUnitName = srmUnitName;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
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
