package modelpojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品基础信息图片
 */
public class CommodityTcbComimgs implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//商品Id
    private Integer comId;
    //图片表Id
    private Integer ciId;
    //项目Id
    private Long projectId;
    //项目根节点Id
    private Integer projectRootId;
    //商品编码
    private String comCode;
    //图片地址
    private String imgUrl;
    //图片名称
    private String imgName;
    //图片备注
    private String imgRemark;
    //添加时间
    private Date addTime;
    //图片类型（封面/内容/...）
    private Integer imgType;
    //排序
    private Integer imgSort;
    //审核时间
    private Date blTime;
    //审核人
    private Long blEmpId;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long updEmpId;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //图片状态
    private Integer imgStatus;
    
    private Integer syncStatus;

    public Date getBlTime() {
		return blTime;
	}

	public void setBlTime(Date blTime) {
		this.blTime = blTime;
	}

	public Long getBlEmpId() {
		return blEmpId;
	}

	public void setBlEmpId(Long blEmpId) {
		this.blEmpId = blEmpId;
	}

	public Integer getComId() {
        return comId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getCiId() {
		return ciId;
	}

	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}

    public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Integer projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark == null ? null : imgRemark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    public Integer getImgSort() {
        return imgSort;
    }

    public void setImgSort(Integer imgSort) {
        this.imgSort = imgSort;
    }


	public Long getUpdEmpId() {
        return updEmpId;
    }

    public void setUpdEmpId(Long updEmpId) {
        this.updEmpId = updEmpId;
    }

    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	
}