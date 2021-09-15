package modelpojo.vo;

import java.io.Serializable;

public class SupplierVo implements Serializable {

    private String suppName; //供应商名称

    private String spellCode;//拼音编码


    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }
}
