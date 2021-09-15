package modelpojo.vo.cateringcheck;

import java.io.Serializable;

/**
 * 餐饮盘点全盘半成品vo对象
 * @author jlw1991@126.com
 *
 */
public class SemiFinishedVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7517965980942359483L;
	//仓库id
	private String whId;
	//半成品编码
	private String dishCode;
	//半成品分类编码
	private String dishClassCode;
	//半成品分类名称
	private String dishClassName;
	//半成品名称
	private String dishName;
	//单位名称
	private String typeName;
	//库存
	private String whStock;
	//半成品id
	private String dishId;
	//半成品单位
	private String dishUnit;
	//税率id
	private String taxId; 
	//税率名称
	private String taxName;
	//分类id
	private String dishClassId;
	
	public String getWhId() {
		return whId;
	}
	public void setWhId(String whId) {
		this.whId = whId;
	}
	public String getDishCode() {
		return dishCode;
	}
	public void setDishCode(String dishCode) {
		this.dishCode = dishCode;
	}
	public String getDishClassCode() {
		return dishClassCode;
	}
	public void setDishClassCode(String dishClassCode) {
		this.dishClassCode = dishClassCode;
	}
	public String getDishClassName() {
		return dishClassName;
	}
	public void setDishClassName(String dishClassName) {
		this.dishClassName = dishClassName;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getWhStock() {
		return whStock;
	}
	public void setWhStock(String whStock) {
		this.whStock = whStock;
	}
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getDishUnit() {
		return dishUnit;
	}
	public void setDishUnit(String dishUnit) {
		this.dishUnit = dishUnit;
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
	public String getDishClassId() {
		return dishClassId;
	}
	public void setDishClassId(String dishClassId) {
		this.dishClassId = dishClassId;
	}
	
}
