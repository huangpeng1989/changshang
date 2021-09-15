package modelpojo.vo.cateringBase;

import java.io.Serializable;

public class TablePageListVo extends PageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**营业点id */
	private String sellPointId;
	/**桌台id */
	private Integer areaTableId;
	/**营业点名称 */
	private String gzoneName;
	/**营业点编码 */
	private String gzoneCode;
	/**桌牌号 */
	private String areaTableCode;
	/**桌牌名称 */
	private String areaTableName;
	/**桌类型 */
	private String areaTypeName;
	/**人数 */
	private Integer numPeople;
	/**营业时间 */
	private String canteenTime;
	/**停启状态,0没启用1启用 */
	private Byte isUseing;
	/**支持拼桌 */
	private Byte isJoinTable;
	/**可并桌 */
	private Byte isMergeTable;
	/**可加人,0否1是 */
	private Byte isJoin;
	/**可加人数 */
	private Integer joinPeopleNum;
	/**备注 */
	private String remark;
	
	public String getSellPointId() {
		return sellPointId;
	}
	public void setSellPointId(String sellPointId) {
		this.sellPointId = sellPointId;
	}
	public Integer getAreaTableId() {
		return areaTableId;
	}
	public void setAreaTableId(Integer areaTableId) {
		this.areaTableId = areaTableId;
	}
	public String getGzoneName() {
		return gzoneName;
	}
	public void setGzoneName(String gzoneName) {
		this.gzoneName = gzoneName;
	}
	public String getGzoneCode() {
		return gzoneCode;
	}
	public void setGzoneCode(String gzoneCode) {
		this.gzoneCode = gzoneCode;
	}
	public String getAreaTableCode() {
		return areaTableCode;
	}
	public void setAreaTableCode(String areaTableCode) {
		this.areaTableCode = areaTableCode;
	}
	public String getAreaTableName() {
		return areaTableName;
	}
	public void setAreaTableName(String areaTableName) {
		this.areaTableName = areaTableName;
	}
	public String getAreaTypeName() {
		return areaTypeName;
	}
	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}
	public Integer getNumPeople() {
		return numPeople;
	}
	public void setNumPeople(Integer numPeople) {
		this.numPeople = numPeople;
	}
	public String getCanteenTime() {
		return canteenTime;
	}
	public void setCanteenTime(String canteenTime) {
		this.canteenTime = canteenTime;
	}
	public Byte getIsUseing() {
		return isUseing;
	}
	public void setIsUseing(Byte isUseing) {
		this.isUseing = isUseing;
	}
	public Byte getIsJoinTable() {
		return isJoinTable;
	}
	public void setIsJoinTable(Byte isJoinTable) {
		this.isJoinTable = isJoinTable;
	}
	public Byte getIsMergeTable() {
		return isMergeTable;
	}
	public void setIsMergeTable(Byte isMergeTable) {
		this.isMergeTable = isMergeTable;
	}
	public Byte getIsJoin() {
		return isJoin;
	}
	public void setIsJoin(Byte isJoin) {
		this.isJoin = isJoin;
	}
	public Integer getJoinPeopleNum() {
		return joinPeopleNum;
	}
	public void setJoinPeopleNum(Integer joinPeopleNum) {
		this.joinPeopleNum = joinPeopleNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
