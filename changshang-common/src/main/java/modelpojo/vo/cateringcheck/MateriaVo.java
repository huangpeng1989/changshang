package modelpojo.vo.cateringcheck;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 餐饮盘点全盘原材料vo对象
 * @author jlw1991@126.com
 *
 */
public class MateriaVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3448812811456580297L;
	//原材料id
	private String rmId;
	//仓库id
	private String whId;
	//原材料编码
	private String rmCode;
	//原材料分类编码
	private String rmClassCode;
	//原材料分类名称
	private String rmcName;
	//原材料名称
	private String rmName;
	//材料名称
	private String typeName;
	//原材料库存
	private BigDecimal whStock;
	//原材料规格
	private String sellModel;
	//原材料单位
	private String rmUnit;
	//供应商id
	private String suppId;
	//供应商编码
	private String suppCode;
	//含税进价
	private String taxPaid;
	//未税进价
	private String noTaxPaid;
	//账面含税金额
	private BigDecimal taxCostAmount; 
	//账面未税金额
	private BigDecimal notaxCostAmount; 
	//税率id
	private String taxId; 
	//税率名称
	private String taxName;
	//包装单位
	private String srmUnit;
	//原材料包装编码
	private String srmCode;
	//原材料包装id
	private String srmId; 
	//原材料分类id
	private String rmcId;
	//包装实盘库存 
	private BigDecimal packStock;
	//包装销售商品含量
	private String packContent;
	
	public String getWhId() {
		return whId;
	}
	public void setWhId(String whId) {
		this.whId = whId;
	}
	public String getRmCode() {
		return rmCode;
	}
	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}
	public String getRmClassCode() {
		return rmClassCode;
	}
	public void setRmClassCode(String rmClassCode) {
		this.rmClassCode = rmClassCode;
	}
	public String getRmcName() {
		return rmcName;
	}
	public void setRmcName(String rmcName) {
		this.rmcName = rmcName;
	}
	public String getRmName() {
		return rmName;
	}
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public BigDecimal getWhStock() {
		return whStock;
	}
	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}
	public String getSellModel() {
		return sellModel;
	}
	public void setSellModel(String sellModel) {
		this.sellModel = sellModel;
	}
	public String getRmUnit() {
		return rmUnit;
	}
	public void setRmUnit(String rmUnit) {
		this.rmUnit = rmUnit;
	}
	public String getSuppId() {
		return suppId;
	}
	public void setSuppId(String suppId) {
		this.suppId = suppId;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
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
	public BigDecimal getTaxCostAmount() {
		return taxCostAmount;
	}
	public void setTaxCostAmount(BigDecimal taxCostAmount) {
		this.taxCostAmount = taxCostAmount;
	}
	public BigDecimal getNotaxCostAmount() {
		return notaxCostAmount;
	}
	public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
		this.notaxCostAmount = notaxCostAmount;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getSrmUnit() {
		return srmUnit;
	}
	public void setSrmUnit(String srmUnit) {
		this.srmUnit = srmUnit;
	}
	public String getRmId() {
		return rmId;
	}
	public void setRmId(String rmId) {
		this.rmId = rmId;
	}
	public String getSrmCode() {
		return srmCode;
	}
	public void setSrmCode(String srmCode) {
		this.srmCode = srmCode;
	}
	public String getSrmId() {
		return srmId;
	}
	public void setSrmId(String srmId) {
		this.srmId = srmId;
	}
	public String getRmcId() {
		return rmcId;
	}
	public void setRmcId(String rmcId) {
		this.rmcId = rmcId;
	}
	public BigDecimal getPackStock() {
		return packStock;
	}
	public void setPackStock(BigDecimal packStock) {
		this.packStock = packStock;
	}
	public String getPackContent() {
		return packContent;
	}
	public void setPackContent(String packContent) {
		this.packContent = packContent;
	}
	
}
