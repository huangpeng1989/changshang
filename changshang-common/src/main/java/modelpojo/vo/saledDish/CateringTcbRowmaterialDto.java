package modelpojo.vo.saledDish;

import modelpojo.model.CateringTcbRowmaterial;

/**
 * @program: phaseiiclota
 * @description:
 * @author: panda
 * @create: 2019-10-24 18:38
 **/
public class CateringTcbRowmaterialDto extends CateringTcbRowmaterial {

    private String rmBarcode;
    private Integer srmUnit;
    private String srmUnitName;
    private String srmCode;

    private Integer isSaleStatus;

    private Integer updateIndex;

    public Integer getIsSaleStatus() {
        return isSaleStatus;
    }

    public void setIsSaleStatus(Integer isSaleStatus) {
        this.isSaleStatus = isSaleStatus;
    }

    public Integer getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Integer updateIndex) {
        this.updateIndex = updateIndex;
    }

    public String getSrmUnitName() {
        return srmUnitName;
    }

    public void setSrmUnitName(String srmUnitName) {
        this.srmUnitName = srmUnitName;
    }

    public String getSrmCode() {
        return srmCode;
    }

    public void setSrmCode(String srmCode) {
        this.srmCode = srmCode;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public Integer getSrmUnit() {
        return srmUnit;
    }

    public void setSrmUnit(Integer srmUnit) {
        this.srmUnit = srmUnit;
    }
}
