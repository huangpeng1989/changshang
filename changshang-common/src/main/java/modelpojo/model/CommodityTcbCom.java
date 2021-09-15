package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品基础信息表
 */
public class CommodityTcbCom implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目ID
    private Long projectId;
    //商品ID
    private Integer comId;
    //项目根节点ID
    private Long projectRootId;
    //商品编号
    private String comCode;
    //商品名称
    private String comName;
    //商品简称
    private String comAbbreviate;
    //拼音编码
    private String spellCode;
    //商品规格
    private String comSpec;
    //商品分类编号
    private String comClassCode;
    //经营方式
    private Integer sellModel;
    //联营折扣率
    private BigDecimal discountRate;
    //商品单位
    private Integer comUnit;
    //生产厂家
    private String manufacturer;
    //保质期
    private Integer expirationDate;
    //商品等级
    private String comGrade;
    //最高库存数量
    private BigDecimal maxWhCount;
    //最低库存数量
    private BigDecimal minWhCount;
    //商品类型
    private Byte comType;
    //商品类型
    private Byte comType2;
    //商品类型
    private Byte comType3;
    //商品类型
    private Byte comType4;
    //商品类型
    private Byte comType5;
    //商品类型
    private Byte comType6;
    //商品类型
    private Byte comType7;
    //商品类型
    private Byte comType8;
    //商品类型
    private Byte comType9;
    //商品类型
    private Byte comType10;
    //商品类型
    private Byte comType11;
    //商品品牌
    private String comBrand;
    //建议零售价
    private BigDecimal retailPrice;
    //预估成本价
    private BigDecimal costPrice;
    //销项税
    private BigDecimal slTax;
    //进项税
    private String phTax;
    //进项税id
    private Integer phTaxId;
    //销项税id
    private Integer slTaxId;
    //是否称重商品定价方式
    private Byte weighComWay;
    //商品销售状态
    private Integer sellStatus;
    //商品图片表id
    private String imageUrl;
    //季节
    private Integer season;
    //是否热卖商品
    private Byte isHot;
    //最低零售价
    private BigDecimal minRetailPrice;
    //送货类型
    private Integer transportType;
    //备注
    private String remark;
    //说明
    private String description;
    //录入时间
    private Date createdTime;
    //录入人
    private Long creater;
    //审核人
    private Long blEmpId;
    //审核时间
    private Date blTime;
    //修改时间
    private Date updatedTime;
    //修改人
    private Long modifier;
    //状态
    private Integer cStatus;
    //是否押金
    private Integer isDeposit;

    public Integer getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(Integer isDeposit) {
        this.isDeposit = isDeposit;
    }

    public Integer getComUnit() {
		return comUnit;
	}

	public void setComUnit(Integer comUnit) {
		this.comUnit = comUnit;
	}
	
	public BigDecimal getSlTax() {
		return slTax;
	}

	public void setSlTax(BigDecimal slTax) {
		this.slTax = slTax;
	}

	public String getPhTax() {
		return phTax;
	}

	public void setPhTax(String phTax) {
		this.phTax = phTax;
	}

	public Integer getPhTaxId() {
		return phTaxId;
	}

	public void setPhTaxId(Integer phTaxId) {
		this.phTaxId = phTaxId;
	}

	public Integer getSlTaxId() {
		return slTaxId;
	}

	public void setSlTaxId(Integer slTaxId) {
		this.slTaxId = slTaxId;
	}

	public Long getBlEmpId() {
		return blEmpId;
	}

	public void setBlEmpId(Long blEmpId) {
		this.blEmpId = blEmpId;
	}

	public Date getBlTime() {
		return blTime;
	}

	public void setBlTime(Date blTime) {
		this.blTime = blTime;
	}

	public Integer getcStatus() {
		return cStatus;
	}

	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Long getProjectRootId() {
        return projectRootId;
    }

    public void setProjectRootId(Long projectRootId) {
        this.projectRootId = projectRootId;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getComAbbreviate() {
        return comAbbreviate;
    }

    public void setComAbbreviate(String comAbbreviate) {
        this.comAbbreviate = comAbbreviate == null ? null : comAbbreviate.trim();
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode == null ? null : spellCode.trim();
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec == null ? null : comSpec.trim();
    }

    public String getComClassCode() {
        return comClassCode;
    }

    public void setComClassCode(String comClassCode) {
        this.comClassCode = comClassCode == null ? null : comClassCode.trim();
    }

    public Integer getSellModel() {
        return sellModel;
    }

    public void setSellModel(Integer sellModel) {
        this.sellModel = sellModel;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getComGrade() {
        return comGrade;
    }

    public void setComGrade(String comGrade) {
        this.comGrade = comGrade;
    }

    public BigDecimal getMaxWhCount() {
        return maxWhCount;
    }

    public void setMaxWhCount(BigDecimal maxWhCount) {
        this.maxWhCount = maxWhCount;
    }

    public BigDecimal getMinWhCount() {
		return minWhCount;
	}

	public void setMinWhCount(BigDecimal minWhCount) {
		this.minWhCount = minWhCount;
	}

	public Byte getComType() {
		return comType;
	}

	public void setComType(Byte comType) {
		this.comType = comType;
	}

	public Byte getComType2() {
		return comType2;
	}

	public void setComType2(Byte comType2) {
		this.comType2 = comType2;
	}

	public Byte getComType3() {
		return comType3;
	}

	public void setComType3(Byte comType3) {
		this.comType3 = comType3;
	}

	public Byte getComType4() {
		return comType4;
	}

	public void setComType4(Byte comType4) {
		this.comType4 = comType4;
	}

	public Byte getComType5() {
		return comType5;
	}

	public void setComType5(Byte comType5) {
		this.comType5 = comType5;
	}

	public Byte getComType6() {
		return comType6;
	}

	public void setComType6(Byte comType6) {
		this.comType6 = comType6;
	}

	public Byte getComType7() {
		return comType7;
	}

	public void setComType7(Byte comType7) {
		this.comType7 = comType7;
	}

	public Byte getComType8() {
		return comType8;
	}

	public void setComType8(Byte comType8) {
		this.comType8 = comType8;
	}

	public Byte getComType9() {
		return comType9;
	}

	public void setComType9(Byte comType9) {
		this.comType9 = comType9;
	}

	public Byte getComType10() {
		return comType10;
	}

	public void setComType10(Byte comType10) {
		this.comType10 = comType10;
	}

	public Byte getComType11() {
		return comType11;
	}

	public void setComType11(Byte comType11) {
		this.comType11 = comType11;
	}

	public String getComBrand() {
        return comBrand;
    }

    public void setComBrand(String comBrand) {
        this.comBrand = comBrand == null ? null : comBrand.trim();
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Byte getWeighComWay() {
        return weighComWay;
    }

    public void setWeighComWay(Byte weighComWay) {
        this.weighComWay = weighComWay;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public BigDecimal getMinRetailPrice() {
        return minRetailPrice;
    }

    public void setMinRetailPrice(BigDecimal minRetailPrice) {
        this.minRetailPrice = minRetailPrice;
    }

    public Integer getTransportType() {
        return transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getCStatus() {
        return cStatus;
    }

    public void setCStatus(Integer CStatus) {
        this.cStatus = CStatus;
    }
}