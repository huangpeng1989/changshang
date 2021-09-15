package modelpojo.vo.cateringcheck;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxcostpriceVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7928993182699193650L;
	private Integer comID;
	private BigDecimal taxcostprice;
	private BigDecimal notaxcostprice;
	
	public Integer getComID() {
		return comID;
	}
	public void setComID(Integer comID) {
		this.comID = comID;
	}
	public BigDecimal getTaxcostprice() {
		return taxcostprice;
	}
	public void setTaxcostprice(BigDecimal taxcostprice) {
		this.taxcostprice = taxcostprice;
	}
	public BigDecimal getNotaxcostprice() {
		return notaxcostprice;
	}
	public void setNotaxcostprice(BigDecimal notaxcostprice) {
		this.notaxcostprice = notaxcostprice;
	}
	
}
