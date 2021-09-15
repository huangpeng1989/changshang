package modelpojo.vo.commodityAplBill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityAplBillDtlDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5704583127940030460L;
	//要货单id
	private Integer aplBillId;
	//申请单明细id
	private Integer aplBillDtlId;
	//要货单编号
	private String aplBillCode;
	//营业点编号
	private String gzoneCode;
	//营业点名称
	private String gzoneName;
	//商品编号
	private String comCode;
	//商品条码
	private String comBarcode;
	//商品名称
	private String comName;
	//商品单位
	private Integer commUnit;
	//商品单位名称
	private String commUnitName;
	//商品规格
	private String commSpec;
	//要货营业点库存数
	private BigDecimal aplWhStock;
	//处理要货仓库（当前仓库）存数
	private BigDecimal whStock;
	//要货数量
	private BigDecimal aplNum;
	//转调拨数量
	private BigDecimal allotNum;
	//转采购数量
	private BigDecimal inNum;
	//要货结果
	private Integer aplResult;
	//驳回理由
	private String rejectResion;
	//供应商id
	private Integer suppId;
	//要货人
	private Long comEmpId;
	//要货时间（申请时间）
	private Date aplDate;
	//要货仓库
	private Integer aplWhId;
	//处理仓库
	private Integer whId;
	//要货仓库名称
	private String aplWhName;
	//处理要货仓库名称
	private String whName;
	//商品id
	private Integer comId;
	//销售id
	private Integer saleComId;
	//销售单位
	private Integer saleCommUnit;
	//销售商品含量
	private BigDecimal packContent;
	//供应商编码
	private String suppCode;
	//含税进价
	private BigDecimal taxPaid;
	//未税进价
	private BigDecimal noTaxPaid;
	//省
	private String firLocCode;
	//地市
	private String secLocCode;
	//乡镇
	private String thiLocCode;
	//收货地址
	private String dtlLocCode; 
	
	private String suppName;
	
	private Integer isDefaultSuppId;
	
	private String isDefaultSuppName;

	private String saleComCode;
	//税率id
	private Integer taxId;
	//税率名称
	private String taxName;
	
	public Integer getAplBillId() {
		return aplBillId;
	}
	public void setAplBillId(Integer aplBillId) {
		this.aplBillId = aplBillId;
	}
	public Integer getAplBillDtlId() {
		return aplBillDtlId;
	}
	public void setAplBillDtlId(Integer aplBillDtlId) {
		this.aplBillDtlId = aplBillDtlId;
	}
	public String getAplBillCode() {
		return aplBillCode;
	}
	public void setAplBillCode(String aplBillCode) {
		this.aplBillCode = aplBillCode;
	}
	public String getGzoneCode() {
		return gzoneCode;
	}
	public void setGzoneCode(String gzoneCode) {
		this.gzoneCode = gzoneCode;
	}
	public String getGzoneName() {
		return gzoneName;
	}
	public void setGzoneName(String gzoneName) {
		this.gzoneName = gzoneName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComBarcode() {
		return comBarcode;
	}
	public void setComBarcode(String comBarcode) {
		this.comBarcode = comBarcode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Integer getCommUnit() {
		return commUnit;
	}
	public void setCommUnit(Integer commUnit) {
		this.commUnit = commUnit;
	}
	public String getCommSpec() {
		return commSpec;
	}
	public void setCommSpec(String commSpec) {
		this.commSpec = commSpec;
	}
	public BigDecimal getAplWhStock() {
		return aplWhStock;
	}
	public void setAplWhStock(BigDecimal aplWhStock) {
		this.aplWhStock = aplWhStock;
	}
	public BigDecimal getWhStock() {
		return whStock;
	}
	public void setWhStock(BigDecimal whStock) {
		this.whStock = whStock;
	}
	public BigDecimal getAplNum() {
		return aplNum;
	}
	public void setAplNum(BigDecimal aplNum) {
		this.aplNum = aplNum;
	}
	public BigDecimal getAllotNum() {
		return allotNum;
	}
	public void setAllotNum(BigDecimal allotNum) {
		this.allotNum = allotNum;
	}
	public BigDecimal getInNum() {
		return inNum;
	}
	public void setInNum(BigDecimal inNum) {
		this.inNum = inNum;
	}
	public Integer getAplResult() {
		return aplResult;
	}
	public void setAplResult(Integer aplResult) {
		this.aplResult = aplResult;
	}
	public String getRejectResion() {
		return rejectResion;
	}
	public void setRejectResion(String rejectResion) {
		this.rejectResion = rejectResion;
	}
	public Integer getSuppId() {
		return suppId;
	}
	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}
	public Long getComEmpId() {
		return comEmpId;
	}
	public void setComEmpId(Long comEmpId) {
		this.comEmpId = comEmpId;
	}
	public Date getAplDate() {
		return aplDate;
	}
	public void setAplDate(Date aplDate) {
		this.aplDate = aplDate;
	}
	public Integer getAplWhId() {
		return aplWhId;
	}
	public void setAplWhId(Integer aplWhId) {
		this.aplWhId = aplWhId;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public Integer getSaleComId() {
		return saleComId;
	}
	public void setSaleComId(Integer saleComId) {
		this.saleComId = saleComId;
	}
	public Integer getSaleCommUnit() {
		return saleCommUnit;
	}
	public void setSaleCommUnit(Integer saleCommUnit) {
		this.saleCommUnit = saleCommUnit;
	}
	public BigDecimal getPackContent() {
		return packContent;
	}
	public void setPackContent(BigDecimal packContent) {
		this.packContent = packContent;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public BigDecimal getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(BigDecimal taxPaid) {
		this.taxPaid = taxPaid;
	}
	public BigDecimal getNoTaxPaid() {
		return noTaxPaid;
	}
	public void setNoTaxPaid(BigDecimal noTaxPaid) {
		this.noTaxPaid = noTaxPaid;
	}
	public String getFirLocCode() {
		return firLocCode;
	}
	public void setFirLocCode(String firLocCode) {
		this.firLocCode = firLocCode;
	}
	public String getSecLocCode() {
		return secLocCode;
	}
	public void setSecLocCode(String secLocCode) {
		this.secLocCode = secLocCode;
	}
	public String getThiLocCode() {
		return thiLocCode;
	}
	public void setThiLocCode(String thiLocCode) {
		this.thiLocCode = thiLocCode;
	}
	public String getDtlLocCode() {
		return dtlLocCode;
	}
	public void setDtlLocCode(String dtlLocCode) {
		this.dtlLocCode = dtlLocCode;
	}
	public String getAplWhName() {
		return aplWhName;
	}
	public void setAplWhName(String aplWhName) {
		this.aplWhName = aplWhName;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public Integer getIsDefaultSuppId() {
		return isDefaultSuppId;
	}
	public void setIsDefaultSuppId(Integer isDefaultSuppId) {
		this.isDefaultSuppId = isDefaultSuppId;
	}
	public String getIsDefaultSuppName() {
		return isDefaultSuppName;
	}
	public void setIsDefaultSuppName(String isDefaultSuppName) {
		this.isDefaultSuppName = isDefaultSuppName;
	}
	public String getSaleComCode() {
		return saleComCode;
	}
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}
	public String getCommUnitName() {
		return commUnitName;
	}
	public void setCommUnitName(String commUnitName) {
		this.commUnitName = commUnitName;
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

}
