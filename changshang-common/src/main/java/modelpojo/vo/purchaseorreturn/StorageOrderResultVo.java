package modelpojo.vo.purchaseorreturn;


import java.io.Serializable;
import java.math.BigDecimal;

public class StorageOrderResultVo implements Serializable{

	//采购单ID
	private Long whinBillId;
	//采购单号
	private String whinBillCode;
	//验收入库ID
	private Long acptBillId;
	//影响的验收入库订单号
	private String acptBillCodes;
	//商品ID
	private Long comId;
	//商品名称
	private String comName;
	//商品编号
	private String comCode;
	//销售商品编号
	private String saleComCode;
	//订货数量
	private BigDecimal acptOrderCount;
	//订货赠送数量
	private BigDecimal acptGiftCount;
	//剩余验收数量
	private BigDecimal surplusOrderCount;
	//剩余验收赠送数量
	private BigDecimal surplusGiftCount;

	public String getAcptBillCodes() {
		return acptBillCodes;
	}

	public void setAcptBillCodes(String acptBillCodes) {
		this.acptBillCodes = acptBillCodes;
	}

	public Long getWhinBillId() {
		return whinBillId;
	}

	public void setWhinBillId(Long whinBillId) {
		this.whinBillId = whinBillId;
	}

	public String getWhinBillCode() {
		return whinBillCode;
	}

	public void setWhinBillCode(String whinBillCode) {
		this.whinBillCode = whinBillCode;
	}

	public Long getAcptBillId() {
		return acptBillId;
	}

	public void setAcptBillId(Long acptBillId) {
		this.acptBillId = acptBillId;
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
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

	public String getSaleComCode() {
		return saleComCode;
	}

	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}

	public BigDecimal getAcptOrderCount() {
		return acptOrderCount;
	}

	public void setAcptOrderCount(BigDecimal acptOrderCount) {
		this.acptOrderCount = acptOrderCount;
	}

	public BigDecimal getAcptGiftCount() {
		return acptGiftCount;
	}

	public void setAcptGiftCount(BigDecimal acptGiftCount) {
		this.acptGiftCount = acptGiftCount;
	}

	public BigDecimal getSurplusOrderCount() {
		return surplusOrderCount;
	}

	public void setSurplusOrderCount(BigDecimal surplusOrderCount) {
		this.surplusOrderCount = surplusOrderCount;
	}

	public BigDecimal getSurplusGiftCount() {
		return surplusGiftCount;
	}

	public void setSurplusGiftCount(BigDecimal surplusGiftCount) {
		this.surplusGiftCount = surplusGiftCount;
	}
}
