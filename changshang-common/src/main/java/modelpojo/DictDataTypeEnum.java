package modelpojo;


public enum DictDataTypeEnum {


    tax_reserved_decimal(14001,"含税明细金额保留小数位"),

    notax_reserved_decimal(14002,"未税明细金额保留小数点位数"),

    tax_total_reserved_decimal(14003,"含税总计金额保留小数点位数"),

    notax_total_reserved_decimal(14004,"未税总计金额保留小数点位数"),

    num_reserved_decimal(14005,"数量明细保留小数点位数"),

    num_total_reserved_decimal(14006,"数量总计保留小数点位数"),

    count_total_reserved_decimal(14007,"条数保留小数点位数");

    private Integer name;
    private String desc;

    private DictDataTypeEnum(Integer name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
