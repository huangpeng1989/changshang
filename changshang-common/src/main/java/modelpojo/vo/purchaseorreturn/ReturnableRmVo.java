package modelpojo.vo.purchaseorreturn;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReturnableRmVo implements Serializable{

	/**原材料ID */
	private Integer rmId;
	/**原材料单位 */
	private Integer rmUnit;
	/**税率ID */
	private Integer taxId;
	/**原材料名称 */
	private String rmName;
	/**原材料编号 */
	private String rmCode;
	/**原材料规格 */
	private String sellModel;
	/**原材料条码 */
	private String rmBarcode;
	/**销售原材料编号 */
	private Long pSrmId;
	/**销售原材料编号 */
	private String pSrmCode;
	/**销售原材料单位 */
	private Integer pSrmUnit;
	/**销售原材料单位名称 */
	private String pSrmUnitName;
	/**销售原材料包装含量 */
	private BigDecimal pSrmPackContent;
	/**转换后销售原材料编号 */
	private Long gSrmId;
	/**转换后销售原材料编号 */
	private String gSrmCode;
	/**转换后销售原材料单位 */
	private Integer gSrmUnit;
	/**转换后销售原材料包装含量 */
	private String gSrmPackContent;
	/**订货数 */
	private BigDecimal orderPageCount;
	/**赠品数 */
	private BigDecimal giftPageCount;
	/**可退订货数 */
	private BigDecimal returnableOrderCount;
	/**可退赠品数 */
	private BigDecimal returnableGiftCount;
	/**含税价格 */
	private BigDecimal taxPagePrice;
	/**未税价格 */
	private BigDecimal noTaxPagePrice;
	/**税率 */
	private String taxName;

	/**库存 */
	private BigDecimal whStock;
	/**冻结数量 */
	private BigDecimal freeaeCount;

	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

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

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Integer getRmUnit() {
		return rmUnit;
	}

	public void setRmUnit(Integer rmUnit) {
		this.rmUnit = rmUnit;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getSellModel() {
		return sellModel;
	}

	public void setSellModel(String sellModel) {
		this.sellModel = sellModel;
	}

	public String getRmBarcode() {
		return rmBarcode;
	}

	public void setRmBarcode(String rmBarcode) {
		this.rmBarcode = rmBarcode;
	}

	public Long getpSrmId() {
		return pSrmId;
	}

	public void setpSrmId(Long pSrmId) {
		this.pSrmId = pSrmId;
	}

	public String getpSrmCode() {
		return pSrmCode;
	}

	public void setpSrmCode(String pSrmCode) {
		this.pSrmCode = pSrmCode;
	}

	public Integer getpSrmUnit() {
		return pSrmUnit;
	}

	public void setpSrmUnit(Integer pSrmUnit) {
		this.pSrmUnit = pSrmUnit;
	}

	public String getpSrmUnitName() {
		return pSrmUnitName;
	}

	public void setpSrmUnitName(String pSrmUnitName) {
		this.pSrmUnitName = pSrmUnitName;
	}

	public BigDecimal getpSrmPackContent() {
		return pSrmPackContent;
	}

	public void setpSrmPackContent(BigDecimal pSrmPackContent) {
		this.pSrmPackContent = pSrmPackContent;
	}

	public Long getgSrmId() {
		return gSrmId;
	}

	public void setgSrmId(Long gSrmId) {
		this.gSrmId = gSrmId;
	}

	public String getgSrmCode() {
		return gSrmCode;
	}

	public void setgSrmCode(String gSrmCode) {
		this.gSrmCode = gSrmCode;
	}

	public Integer getgSrmUnit() {
		return gSrmUnit;
	}

	public void setgSrmUnit(Integer gSrmUnit) {
		this.gSrmUnit = gSrmUnit;
	}

	public String getgSrmPackContent() {
		return gSrmPackContent;
	}

	public void setgSrmPackContent(String gSrmPackContent) {
		this.gSrmPackContent = gSrmPackContent;
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

	public BigDecimal getTaxPagePrice() {
		return taxPagePrice;
	}

	public void setTaxPagePrice(BigDecimal taxPagePrice) {
		this.taxPagePrice = taxPagePrice;
	}

	public BigDecimal getNoTaxPagePrice() {
		return noTaxPagePrice;
	}

	public void setNoTaxPagePrice(BigDecimal noTaxPagePrice) {
		this.noTaxPagePrice = noTaxPagePrice;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
}
