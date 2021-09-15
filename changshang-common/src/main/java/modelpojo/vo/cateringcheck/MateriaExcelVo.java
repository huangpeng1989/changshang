package modelpojo.vo.cateringcheck;

import excel.HeadProperty;

import java.io.Serializable;


public class MateriaExcelVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -607736810553718921L;
	@HeadProperty(name="盘点启动单编号",type = HeadProperty.HeadType.STRING)
	private String ivtCode;
	@HeadProperty(name="盘点启动日期",type = HeadProperty.HeadType.STRING)
	private String ivtStartDate;
	@HeadProperty(name="盘点仓库",type = HeadProperty.HeadType.STRING)
	private String whName;
	@HeadProperty(name="原材料编号",type = HeadProperty.HeadType.STRING)
	private String rmCode;
	@HeadProperty(name="原材料分类",type = HeadProperty.HeadType.STRING)
	private String rmcName;
	@HeadProperty(name="原材料名称",type = HeadProperty.HeadType.STRING)
	private String rmName;
	@HeadProperty(name="原材料单位",type = HeadProperty.HeadType.STRING)
	private String unitName;
	@HeadProperty(name="原材料规格",type = HeadProperty.HeadType.STRING)
	private String sellModel;
	@HeadProperty(name="原材料条码",type = HeadProperty.HeadType.STRING)
	private String rmBarcode;
	@HeadProperty(name="实盘数量",type = HeadProperty.HeadType.STRING)
	private String realStock;
	@HeadProperty(name="账盘数量",type = HeadProperty.HeadType.STRING)
	private String paperStock;

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
	public String getIvtStartDate() {
		return ivtStartDate;
	}
	public void setIvtStartDate(String ivtStartDate) {
		this.ivtStartDate = ivtStartDate;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getRmCode() {
		return rmCode;
	}
	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
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
	public String getRmBarcode() {
		return rmBarcode;
	}
	public void setRmBarcode(String rmBarcode) {
		this.rmBarcode = rmBarcode;
	}
	public String getRealStock() {
		return realStock;
	}
	public void setRealStock(String realStock) {
		this.realStock = realStock;
	}
	
}
