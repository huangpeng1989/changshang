package modelpojo.vo.cateringcheck;

import java.io.Serializable;
import java.math.BigDecimal;

public class AuditMOrSfVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4208328677255340770L;
	//原材料编号
	private String rmCode;
	//原材料名称
	private String rmName;
	//原材料单位
	private String unitName;
	//原材料规格
	private String sellModel;
	//实盘数量
	private String realStock;
	//帐盘数量
	private String paperStock;
	//差异数量
	private String ivtDftCount;
	//账面含税金额
	private String ptaxCostAmount;
	//账面未税金额
	private String pNotaxCostAmount;
	//实盘含税金额
	private String rTaxCostAmount;
	//实盘未税金额
	private String rNotaxCostAmount;
	//差异含税金额
	private String diffRTaxCostAmount;
	//差异未税金额
	private String diffRNotaxCostAmount;
	//差异率=差异金额/账盘金额*100%
	private String diffProportion;

	private Integer rmId;

	private BigDecimal taxCost;

	private BigDecimal notaxCost;

	private  Integer proLosType;

	private  Integer isInsert;

	public Integer getIsInsert() {

		return isInsert;
	}

	public void setIsInsert(Integer isInsert) {
		this.isInsert = isInsert;
	}

	public Integer getProLosType() {
		return proLosType;
	}

	public void setProLosType(Integer proLosType) {
		this.proLosType = proLosType;
	}

	public BigDecimal getTaxCost() {
		return taxCost;
	}

	public void setTaxCost(BigDecimal taxCost) {
		this.taxCost = taxCost;
	}

	public BigDecimal getNotaxCost() {
		return notaxCost;
	}

	public void setNotaxCost(BigDecimal notaxCost) {
		this.notaxCost = notaxCost;
	}

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	public String getRmCode() {
		return rmCode;
	}
	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}
	public String getRmName() {
		return rmName;
	}
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getSellModel() {
		return sellModel;
	}
	public void setSellModel(String sellModel) {
		this.sellModel = sellModel;
	}
	public String getRealStock() {
		return realStock;
	}
	public void setRealStock(String realStock) {
        this.realStock = new BigDecimal(realStock).toPlainString();
	}
	public String getPaperStock() {
		return paperStock;
	}
	public void setPaperStock(String paperStock) {
		this.paperStock = new BigDecimal(paperStock).toPlainString();
	}
	public String getIvtDftCount() {
		return ivtDftCount;
	}
	public void setIvtDftCount(String ivtDftCount) {
		this.ivtDftCount = new BigDecimal(ivtDftCount).toPlainString();
	}
	public String getPtaxCostAmount() {
		return ptaxCostAmount;
	}
	public void setPtaxCostAmount(String ptaxCostAmount) {
		this.ptaxCostAmount = new BigDecimal(ptaxCostAmount).toPlainString();
	}
	public String getpNotaxCostAmount() {
		return pNotaxCostAmount;
	}
	public void setpNotaxCostAmount(String pNotaxCostAmount) {
		this.pNotaxCostAmount = new BigDecimal(pNotaxCostAmount).toPlainString();
	}
	public String getrTaxCostAmount() {
		return rTaxCostAmount;
	}
	public void setrTaxCostAmount(String rTaxCostAmount) {
		this.rTaxCostAmount = new BigDecimal(rTaxCostAmount).toPlainString();
	}
	public String getrNotaxCostAmount() {
		return rNotaxCostAmount;
	}
	public void setrNotaxCostAmount(String rNotaxCostAmount) {
		this.rNotaxCostAmount = new BigDecimal(rNotaxCostAmount).toPlainString();
	}
	public String getDiffRTaxCostAmount() {
		return diffRTaxCostAmount;
	}
	public void setDiffRTaxCostAmount(String diffRTaxCostAmount) {
		this.diffRTaxCostAmount = new BigDecimal(diffRTaxCostAmount).toPlainString();
	}
	public String getDiffRNotaxCostAmount() {
		return diffRNotaxCostAmount;
	}
	public void setDiffRNotaxCostAmount(String diffRNotaxCostAmount) {
		this.diffRNotaxCostAmount = new BigDecimal(diffRNotaxCostAmount).toPlainString();
	}
	public String getDiffProportion() {
		return diffProportion;
	}
	public void setDiffProportion(String diffProportion) {
		this.diffProportion = new BigDecimal(diffProportion).toPlainString();
	}
	
}
