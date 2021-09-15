package modelpojo.vo.cateringcheckreport;

import java.io.Serializable;
import java.math.BigDecimal;

public class CateringCheckReportCountPageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 仓库名称
	 */
	private String whName;
	/**
	 * 损耗原材料条数
	 */
	private Integer totalRowmaterCount;
	/**
	 * 损耗数量总计
	 */
	private BigDecimal totalBatchCount;

	/**
	 * 损耗未税成本金额总计
	 */
	private BigDecimal notaxCostAmount;

	/**
	 * 损耗含税成本金额总计
	 */
	private BigDecimal taxCostAmount;


	/**
	 * 损耗原材料条数
	 */
	private Integer ytotalRowmaterCount;
	/**
	 * 损耗数量总计
	 */
	private BigDecimal ytotalBatchCount;

	/**
	 * 损耗含税成本金额总计
	 */
	private BigDecimal ynotaxCostAmount;

	/**
	 * 损耗未税成本金额总计
	 */
	private BigDecimal ytaxCostAmount;

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public Integer getTotalRowmaterCount() {
		return totalRowmaterCount;
	}

	public void setTotalRowmaterCount(Integer totalRowmaterCount) {
		this.totalRowmaterCount = totalRowmaterCount;
	}

	public BigDecimal getTotalBatchCount() {
		return totalBatchCount;
	}

	public void setTotalBatchCount(BigDecimal totalBatchCount) {
		this.totalBatchCount = totalBatchCount;
	}

	public BigDecimal getNotaxCostAmount() {
		return notaxCostAmount;
	}

	public void setNotaxCostAmount(BigDecimal notaxCostAmount) {
		this.notaxCostAmount = notaxCostAmount;
	}

	public BigDecimal getTaxCostAmount() {
		return taxCostAmount;
	}

	public void setTaxCostAmount(BigDecimal taxCostAmount) {
		this.taxCostAmount = taxCostAmount;
	}

	public Integer getYtotalRowmaterCount() {
		return ytotalRowmaterCount;
	}

	public void setYtotalRowmaterCount(Integer ytotalRowmaterCount) {
		this.ytotalRowmaterCount = ytotalRowmaterCount;
	}

	public BigDecimal getYtotalBatchCount() {
		return ytotalBatchCount;
	}

	public void setYtotalBatchCount(BigDecimal ytotalBatchCount) {
		this.ytotalBatchCount = ytotalBatchCount;
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
}
