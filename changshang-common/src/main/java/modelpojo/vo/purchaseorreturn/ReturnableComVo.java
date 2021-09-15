package modelpojo.vo.purchaseorreturn;


import java.io.Serializable;
import java.math.BigDecimal;

public class ReturnableComVo implements Serializable{

	/**商品ID */
	private Integer comId;
	/**商品单位 */
	private Integer comUnit;
	/**税率ID */
	private Integer taxId;
	/**商品名称 */
	private String comName;
	/**商品编号 */
	private String comCode;
	/**商品规格 */
	private String comSpec;
	/**商品条码 */
	private String comBarcode;
	/**销售商品ID */
	private Long pSaleComId;
	/**销售商品编号 */
	private String pSaleComCode;
	/**销售商品单位 */
	private Integer pSaleCommUnit;
	/**销售商品单位名称 */
	private String pSaleCommUnitName;
	/**销售商品包装含量 */
	private BigDecimal pSalePackContent;
	/**转换后销售商品ID */
	private Long gSaleComId;
	/**转换后销售商品编号 */
	private String gSaleComCode;
	/**转换后销售商品单位 */
	private Integer gSaleCommUnit;
	/**转换后销售商品包装含量 */
	private BigDecimal gSalePackContent;
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

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getComUnit() {
		return comUnit;
	}

	public void setComUnit(Integer comUnit) {
		this.comUnit = comUnit;
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

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
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

	public Long getpSaleComId() {
		return pSaleComId;
	}

	public void setpSaleComId(Long pSaleComId) {
		this.pSaleComId = pSaleComId;
	}

	public String getpSaleComCode() {
		return pSaleComCode;
	}

	public void setpSaleComCode(String pSaleComCode) {
		this.pSaleComCode = pSaleComCode;
	}

	public Integer getpSaleCommUnit() {
		return pSaleCommUnit;
	}

	public void setpSaleCommUnit(Integer pSaleCommUnit) {
		this.pSaleCommUnit = pSaleCommUnit;
	}

	public String getpSaleCommUnitName() {
		return pSaleCommUnitName;
	}

	public void setpSaleCommUnitName(String pSaleCommUnitName) {
		this.pSaleCommUnitName = pSaleCommUnitName;
	}

	public BigDecimal getpSalePackContent() {
		return pSalePackContent;
	}

	public void setpSalePackContent(BigDecimal pSalePackContent) {
		this.pSalePackContent = pSalePackContent;
	}

	public Long getgSaleComId() {
		return gSaleComId;
	}

	public void setgSaleComId(Long gSaleComId) {
		this.gSaleComId = gSaleComId;
	}

	public String getgSaleComCode() {
		return gSaleComCode;
	}

	public void setgSaleComCode(String gSaleComCode) {
		this.gSaleComCode = gSaleComCode;
	}

	public Integer getgSaleCommUnit() {
		return gSaleCommUnit;
	}

	public void setgSaleCommUnit(Integer gSaleCommUnit) {
		this.gSaleCommUnit = gSaleCommUnit;
	}

	public BigDecimal getgSalePackContent() {
		return gSalePackContent;
	}

	public void setgSalePackContent(BigDecimal gSalePackContent) {
		this.gSalePackContent = gSalePackContent;
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
}
