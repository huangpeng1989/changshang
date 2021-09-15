package modelpojo.vo.cateringBase;

import java.io.Serializable;

public class BatchAddTableVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sellPointId;
	private Integer areaTypeId;
	private Integer startTableNo;
	private Integer quantity;
	
	public Integer getSellPointId() {
		return sellPointId;
	}
	public void setSellPointId(Integer sellPointId) {
		this.sellPointId = sellPointId;
	}
	public Integer getAreaTypeId() {
		return areaTypeId;
	}
	public void setAreaTypeId(Integer areaTypeId) {
		this.areaTypeId = areaTypeId;
	}
	public Integer getStartTableNo() {
		return startTableNo;
	}
	public void setStartTableNo(Integer startTableNo) {
		this.startTableNo = startTableNo;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
