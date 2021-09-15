package modelpojo.vo.cateringcheck;

import java.io.Serializable;

import excel.HeadProperty;

public class SemiFinishedExcelVo implements Serializable{
								
	/**
	 * 
	 */
	private static final long serialVersionUID = 3955181054173919700L;
	//盘点启动单编号
	@HeadProperty(name="盘点启动单编号",type = HeadProperty.HeadType.STRING)
	private String ivtCode;
	//盘点仓库
	@HeadProperty(name="盘点仓库",type = HeadProperty.HeadType.STRING)
	private String whName;
	//盘点启动日期
	@HeadProperty(name="盘点启动日期",type = HeadProperty.HeadType.STRING)
	private String ivtStartDate;
	//半成品编号
	@HeadProperty(name="半成品编号",type = HeadProperty.HeadType.STRING)
	private String rmCode;
	//半成品分类
	@HeadProperty(name="半成品分类",type = HeadProperty.HeadType.STRING)
	private String dishClassName;
	//半成品名称
	@HeadProperty(name="半成品名称",type = HeadProperty.HeadType.STRING)
	private String dishName;
	//半成品单位
	@HeadProperty(name="半成品单位",type = HeadProperty.HeadType.STRING)
	private String rmUnitName;
	@HeadProperty(name="账盘数量",type = HeadProperty.HeadType.STRING)
	private String paperStock;

	@HeadProperty(name="实盘数量",type = HeadProperty.HeadType.STRING)
	private String realStock;


	public String getPaperStock() {
		return paperStock;
	}

	public void setPaperStock(String paperStock) {
		this.paperStock = paperStock;
	}

	public String getIvtCode() {
		return ivtCode;
	}
	public void setIvtCode(String ivtCode) {
		this.ivtCode = ivtCode;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getIvtStartDate() {
		return ivtStartDate;
	}
	public void setIvtStartDate(String ivtStartDate) {
		this.ivtStartDate = ivtStartDate;
	}
	public String getRmCode() {
		return rmCode;
	}
	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
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
	public String getRmUnitName() {
		return rmUnitName;
	}
	public void setRmUnitName(String rmUnitName) {
		this.rmUnitName =  rmUnitName;
	}
	public String getRealStock() {
		return realStock;
	}
	public void setRealStock(String realStock) {
		this.realStock = realStock;
	}
	
}
