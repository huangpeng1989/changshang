package modelpojo.vo.commodityinfo;

import modelpojo.model.*;
import modelpojo.vo.CommodityTcbGradepriceVo;
import modelpojo.vo.CommodityTcbSalecomVo;
import modelpojo.vo.CommodityTcbSuppComDto;
import modelpojo.vo.CommodityTcbSuppcomModelVo;

import java.io.Serializable;
import java.util.List;


/**
 * @author XuLuJiao
 * 
 * @date 2019年8月23日下午2:24:56
 *
 */
	
public class CommodityInfoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CommodityTcbCom com;
	
	private List<CommodityTcbSalecom> saleComInfoLst;
	
	private List<CommodityTcbSuppcomModel> comSupplyInfoLst;
	
	private List<CommodityTcbGradeprice> comPriceConfigInfoLst;

	private List<CommodityTcbSalecomVo> saleComInfoVoLst;

	private List<CommodityTcbSuppcomModelVo> comSupplyInfoVoLst;

	private List<CommodityTcbGradepriceVo> comPriceConfigInfoVoLst;
	
	private List<CommodityTcbComimgs> picLst;

	private List<CommodityTcbSuppComDto> commodityTcbSuppComDtos; //供应商-商品

	public List<CommodityTcbSuppComDto> getCommodityTcbSuppComDtos() {
		return commodityTcbSuppComDtos;
	}

	public void setCommodityTcbSuppComDtos(List<CommodityTcbSuppComDto> commodityTcbSuppComDtos) {
		this.commodityTcbSuppComDtos = commodityTcbSuppComDtos;
	}

	public CommodityTcbCom getCom() {
		return com;
	}

	public void setCom(CommodityTcbCom com) {
		this.com = com;
	}

	public List<CommodityTcbSalecom> getSaleComInfoLst() {
		return saleComInfoLst;
	}

	public void setSaleComInfoLst(List<CommodityTcbSalecom> saleComInfoLst) {
		this.saleComInfoLst = saleComInfoLst;
	}

	public List<CommodityTcbSuppcomModel> getComSupplyInfoLst() {
		return comSupplyInfoLst;
	}

	public void setComSupplyInfoLst(List<CommodityTcbSuppcomModel> comSupplyInfoLst) {
		this.comSupplyInfoLst = comSupplyInfoLst;
	}

	public List<CommodityTcbGradeprice> getComPriceConfigInfoLst() {
		return comPriceConfigInfoLst;
	}

	public void setComPriceConfigInfoLst(List<CommodityTcbGradeprice> comPriceConfigInfoLst) {
		this.comPriceConfigInfoLst = comPriceConfigInfoLst;
	}

	public List<CommodityTcbSalecomVo> getSaleComInfoVoLst() {
		return saleComInfoVoLst;
	}

	public void setSaleComInfoVoLst(List<CommodityTcbSalecomVo> saleComInfoVoLst) {
		this.saleComInfoVoLst = saleComInfoVoLst;
	}

	public List<CommodityTcbSuppcomModelVo> getComSupplyInfoVoLst() {
		return comSupplyInfoVoLst;
	}

	public void setComSupplyInfoVoLst(List<CommodityTcbSuppcomModelVo> comSupplyInfoVoLst) {
		this.comSupplyInfoVoLst = comSupplyInfoVoLst;
	}

	public List<CommodityTcbGradepriceVo> getComPriceConfigInfoVoLst() {
		return comPriceConfigInfoVoLst;
	}

	public void setComPriceConfigInfoVoLst(List<CommodityTcbGradepriceVo> comPriceConfigInfoVoLst) {
		this.comPriceConfigInfoVoLst = comPriceConfigInfoVoLst;
	}

	public List<CommodityTcbComimgs> getPicLst() {
		return picLst;
	}

	public void setPicLst(List<CommodityTcbComimgs> picLst) {
		this.picLst = picLst;
	}
	
}
