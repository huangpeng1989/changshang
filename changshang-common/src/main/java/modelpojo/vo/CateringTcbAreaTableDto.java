package modelpojo.vo;


import modelpojo.model.CateringTcbAreaTable;

public class CateringTcbAreaTableDto extends CateringTcbAreaTable {
    private String prefix;//前缀

    private String suffix;//后缀

    private Integer numberBegin;//序号开始

    private int num;//生成数量

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getNumberBegin() {
        return numberBegin;
    }

    public void setNumberBegin(Integer numberBegin) {
        this.numberBegin = numberBegin;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
