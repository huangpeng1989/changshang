package modelpojo.vo.cateringcheck;


import java.math.BigDecimal;

import modelpojo.model.CateringTcbRowmaterial;

/**
 * @Description 扩展类
 * @Author wenbin.wang
 * @Date 2019-09-02 09:24
 */
public class RawmaterVo1 extends CateringTcbRowmaterial {

    private String suppName;

    private String suppCode;
    
    private BigDecimal taxPaid;
    
    private BigDecimal noTaxPaid;
    
    private Integer suppId;
    
    private String supComCode;
    
    private String taxName;
    
    /**
     * 账盘库存
     */
    private BigDecimal paperStock;
    /**
     * 账面含税金额
     */
    private BigDecimal pTaxCostAmount;
    /**
     * 账面未税金额
     */
    private BigDecimal pNotaxCostAmount;
    /**
     * 原材料条码
     */
    private BigDecimal rmBarcode;
    /**
     * 仓库id
     */
    private Integer whId;
    
	public Integer getWhId() {
		return whId;
	}

	public void setWhId(Integer whId) {
		this.whId = whId;
	}

	public BigDecimal getRmBarcode() {
		return rmBarcode;
	}

	public void setRmBarcode(BigDecimal rmBarcode) {
		this.rmBarcode = rmBarcode;
	}

	public BigDecimal getPaperStock() {
		return paperStock;
	}

	public void setPaperStock(BigDecimal paperStock) {
		this.paperStock = paperStock;
	}

	public BigDecimal getpTaxCostAmount() {
		return pTaxCostAmount;
	}

	public void setpTaxCostAmount(BigDecimal pTaxCostAmount) {
		this.pTaxCostAmount = pTaxCostAmount;
	}

	public BigDecimal getpNotaxCostAmount() {
		return pNotaxCostAmount;
	}

	public void setpNotaxCostAmount(BigDecimal pNotaxCostAmount) {
		this.pNotaxCostAmount = pNotaxCostAmount;
	}

	public String getSupComCode() {
		return supComCode;
	}

	public void setSupComCode(String supComCode) {
		this.supComCode = supComCode;
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

	public Integer getSuppId() {
		return suppId;
	}

	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

    public String getRmcName() {
        return rmcName;
    }

    public void setRmcName(String rmcName) {
        this.rmcName = rmcName;
    }

    private String rmcName;

    public String getRmUnitStr() {
        return rmUnitStr;
    }

    public void setRmUnitStr(String rmUnitStr) {
        this.rmUnitStr = rmUnitStr;
    }

    private String rmUnitStr;//商品单位名称

    private String createrStr;//录入人姓名

    private Integer rmcId;


    private String  rmcIds;





    @Override
    public String getCreaterStr() {
        return createrStr;
    }

    @Override
    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }


    public String getRmcIds() {
        return rmcIds;
    }

    public void setRmcIds(String rmcIds) {
        this.rmcIds = rmcIds;
    }


    public Integer getRmcId() {
        return rmcId;
    }

    public void setRmcId(Integer rmcId) {
        this.rmcId = rmcId;
    }


    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }
}
