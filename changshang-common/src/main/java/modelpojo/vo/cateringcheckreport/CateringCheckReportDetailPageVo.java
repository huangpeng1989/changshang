package modelpojo.vo.cateringcheckreport;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringCheckReportDetailPageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 景区名称
	 */
	private String orgName;
	/**
	 * 仓库名称
	 */
	private String whName;
	/**
	 * 原材料名称
	 */
	private String comName;
	/**
	 * 原材料单位
	 */
	private String comUnitName;
	/**
	 * 集团名称
	 */
	private String rootOrgName;
	/**
	 * 仓库编码
	 */
	private String whCode;
	/**
	 * 单号
	 */
	private String billCode;
	/**
	 * 时间
	 */
	private String batchDate;
	/**
	 * 原材料编码
	 */
	private String comCode;
	/**
	 * 原材料条码
	 */
	private String rmBarcode;
	/**
	 * 损耗数量
	 */
	private String batchCount;
	/**
	 * 一级分类
	 */
	private String fristClass;
	/**
	 * 二级分类
	 */
	private String secondClass;
	/**
	 * 三级分类
	 */
	private String thirdClass;
	/**
	 * 进项税税率
	 */
	private String taxName;
	/**
	 * 未税成本价
	 */
	private String notaxCost;
	/**
	 * 含税成本价
	 */
	private String taxCost;
	/**
	 * 未税损耗金额
	 */
	private String notaxCostAmount;
	/**
	 * 含税损耗金额
	 */
	private String taxCostAmount;


	private Integer billType;

	/**
	 * 盘盈数量
	 */
	private BigDecimal ybatchCount;

	/**
	 * 盘盈数量
	 */
	private BigDecimal ynotaxCostAmount;

	/**
	 * 盘盈数量
	 */
	private BigDecimal ytaxCostAmount;


	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public BigDecimal getYbatchCount() {
		return ybatchCount;
	}

	public void setYbatchCount(BigDecimal ybatchCount) {
		this.ybatchCount = ybatchCount;
	}

	public BigDecimal getYnotaxCostAmount() {
		return ynotaxCostAmount;
	}

	public void setYnotaxCostAmount(BigDecimal ynotaxCostAmount) {
		this.ynotaxCostAmount = ynotaxCostAmount;
	}

	public BigDecimal getYtaxCostAmount() {
		return ytaxCostAmount;
	}

	public void setYtaxCostAmount(BigDecimal ytaxCostAmount) {
		this.ytaxCostAmount = ytaxCostAmount;
	}

	public String getComUnitName() {
		return comUnitName;
	}
	public void setComUnitName(String comUnitName) {
		this.comUnitName = comUnitName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getRootOrgName() {
		return rootOrgName;
	}
	public void setRootOrgName(String rootOrgName) {
		this.rootOrgName = rootOrgName;
	}
	public String getWhCode() {
		return whCode;
	}
	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getRmBarcode() {
		return rmBarcode;
	}
	public void setRmBarcode(String rmBarcode) {
		this.rmBarcode = rmBarcode;
	}
	public String getBatchCount() {
		return batchCount;
	}
	//损耗数量
	public void setBatchCount(String batchCount) {

		this.batchCount = batchCount;
	}
	public String getFristClass() {
		return fristClass;
	}
	public void setFristClass(String fristClass) {
		this.fristClass = fristClass;
	}
	public String getSecondClass() {
		return secondClass;
	}
	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}
	public String getThirdClass() {
		return thirdClass;
	}
	public void setThirdClass(String thirdClass) {
		this.thirdClass = thirdClass;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getNotaxCost() {
		return notaxCost;
	}
	//未税成本价
	public void setNotaxCost(String notaxCost) {

		this.notaxCost = notaxCost;
	}
	public String getTaxCost() {
		return taxCost;
	}
	//含税成本价
	public void setTaxCost(String taxCost) {

		this.taxCost = taxCost;
	}
	public String getNotaxCostAmount() {
		return notaxCostAmount;
	}
	//未税损耗金额
	public void setNotaxCostAmount(String notaxCostAmount) {

		this.notaxCostAmount = notaxCostAmount;
	}
	public String getTaxCostAmount() {
		return taxCostAmount;
	}
	//含税损耗金额
	public void setTaxCostAmount(String taxCostAmount) {

		this.taxCostAmount = taxCostAmount;
	}
	
}
