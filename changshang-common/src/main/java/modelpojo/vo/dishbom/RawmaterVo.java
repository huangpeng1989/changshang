package modelpojo.vo.dishbom;


import modelpojo.model.CateringTcbRowmaterial;

import java.util.List;

/**
 * @Description 扩展类
 * @Author wenbin.wang
 * @Date 2019-09-02 09:24
 */
public class RawmaterVo extends CateringTcbRowmaterial {

    private String suppName;

    private String suppCode;

    public String getPhTaxName() {
        return phTaxName;
    }

    public void setPhTaxName(String phTaxName) {
        this.phTaxName = phTaxName;
    }

    private String phTaxName;

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
    private String modifierStr;//修改人姓名

    public String getcStatusStr() {
        return cStatusStr;
    }

    public void setcStatusStr(String cStatusStr) {
        this.cStatusStr = cStatusStr;
    }

    private String cStatusStr;//原材料状态名称
    private List<String> cStatuss;//原材料状态
    private Integer rmcId;


    private String  rmcIds;

    public List<String> getcStatuss() {
        return cStatuss;
    }

    public void setcStatuss(List<String> cStatuss) {
        this.cStatuss = cStatuss;
    }

    //包装单位
    private Integer  srmId;

    public Integer getSrmId() {
		return srmId;
	}

	public void setSrmId(Integer srmId) {
		this.srmId = srmId;
	}

    public String getModifierStr() {
        return modifierStr;
    }

    public void setModifierStr(String modifierStr) {
        this.modifierStr = modifierStr;
    }

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
