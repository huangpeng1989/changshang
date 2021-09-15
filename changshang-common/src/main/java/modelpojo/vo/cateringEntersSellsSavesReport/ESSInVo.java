package modelpojo.vo.cateringEntersSellsSavesReport;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ESSInVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -904116926927906941L;

	//菜品1、半成品2、原材料3
	private Integer type;
	//分类id
	private Integer classId;
	//编码或名称
	private String codeOrName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date sDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date eDate;
	
	private Integer pageNo;
	
	private Integer pageSize;

	private Integer totalCount;

	private Integer sellModel;

	public Integer getSellModel() {
		return sellModel;
	}

	public void setSellModel(Integer sellModel) {
		this.sellModel = sellModel;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCodeOrName() {
		return codeOrName;
	}

	public void setCodeOrName(String codeOrName) {
		this.codeOrName = codeOrName;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	
	
}
