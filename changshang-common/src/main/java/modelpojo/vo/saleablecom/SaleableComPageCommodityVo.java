package modelpojo.vo.saleablecom;

import modelpojo.vo.cateringBase.PageVo;

import java.io.Serializable;

/**
 * @author XuLuJiao
 * 
 * @date 2019年10月29日上午9:51:27
 *
 */
public class SaleableComPageCommodityVo extends PageVo implements Serializable {

	/**商品名称 */
	private String comName;
	/**商品编号 */
	private String comCode;
	/**商品分类 */
	private String comClassCode;
	/**价格等级 */
	private Integer gradeId;		
	/**销售商品编号 */
	private String saleComCode;
	/**商品条码 */
	private String comBarcode;
	/**可售状态 1启用 0禁用*/
	private Byte isSaleStatus;
	/**仓库id */
	private Integer whId;
	/**采购单id */
	private Integer whinBillId;
	/**验收单id */
	private Integer acptBillId;
	/**查询进销存商品传1 */
	private Integer type;
	/**商品经营方式 */
	private String sellModel;
	
	private Integer supplyId;

	private Integer isDefault;

	private Integer gzoneId;

	private Integer suppId;

	public Integer getGzoneId() {
		return gzoneId;
	}

	public void setGzoneId(Integer gzoneId) {
		this.gzoneId = gzoneId;
	}

	public Integer getSuppId() {
		return suppId;
	}

	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}

	public Byte getIsSaleStatus() {
		return isSaleStatus;
	}
	public void setIsSaleStatus(Byte isSaleStatus) {
		this.isSaleStatus = isSaleStatus;
	}
	public Integer getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}
	public String getSellModel() {
		return sellModel;
	}
	public void setSellModel(String sellModel) {
		this.sellModel = sellModel;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getAcptBillId() {
		return acptBillId;
	}
	public void setAcptBillId(Integer acptBillId) {
		this.acptBillId = acptBillId;
	}
	public Integer getWhinBillId() {
		return whinBillId;
	}
	public void setWhinBillId(Integer whinBillId) {
		this.whinBillId = whinBillId;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getComClassCode() {
		return comClassCode;
	}
	public void setComClassCode(String comClassCode) {
		this.comClassCode = comClassCode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getSaleComCode() {
		return saleComCode;
	}
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}
	public String getComBarcode() {
		return comBarcode;
	}
	public void setComBarcode(String comBarcode) {
		this.comBarcode = comBarcode;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

}
