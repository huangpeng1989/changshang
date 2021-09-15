package modelpojo.vo.cateringcheck;


import modelpojo.model.CateringWhInvtryBillDtl;
import modelpojo.model.CateringWhIvtSpecBill;

import java.util.ArrayList;
import java.util.List;

public class CateringWhInvtryBillDtlVo extends CateringWhInvtryBillDtl {
	
	
	/**
	 * 原材料规格
	 */
	private String sellModel;
	/**
	 * 原材料规格
	 */
	private String rmName;
	/**
	 * 原材料规格
	 */
	private String rmcName;
	/**
	 * 原材料规格
	 */
	private String rmcCode;
	/**
	 * 原材料单位名称
	 */
	private String rmUnitName;
	/**
	 * 原材料是否是辅料,1是0否
	 */
	private Byte specRmType4;
	
	private String rmBarcode;

	private String rmClassCode;

	public String getRmClassCode() {
		return rmClassCode;
	}

	public void setRmClassCode(String rmClassCode) {
		this.rmClassCode = rmClassCode;
	}

	private List<CateringWhIvtSpecBill> utils= new ArrayList<>();

	public List<CateringWhIvtSpecBill> getUtils() {
		return utils;
	}

	public void setUtils(List<CateringWhIvtSpecBill> utils) {
		this.utils = utils;
	}

	public Byte getSpecRmType4() {
		return specRmType4;
	}

	public void setSpecRmType4(Byte specRmType4) {
		this.specRmType4 = specRmType4;
	}

	public String getRmUnitName() {
		return rmUnitName;
	}

	public void setRmUnitName(String rmUnitName) {
		this.rmUnitName = rmUnitName;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getRmcName() {
		return rmcName;
	}

	public void setRmcName(String rmcName) {
		this.rmcName = rmcName;
	}

	public String getRmcCode() {
		return rmcCode;
	}

	public void setRmcCode(String rmcCode) {
		this.rmcCode = rmcCode;
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
	
}
