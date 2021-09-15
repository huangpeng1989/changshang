package excel;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 导入Excel列属性
 * Created by dell on 2017/8/30.
 */
public class ColumnAttribute {
    private String field;//对应的属性名称
    private String name;//表头名称
    private HeadProperty.HeadType type;//数据类型
    private String format;//格式，如日期：YYYY-MM-DD，数字：#.00
    private boolean required;//是否必填
    private Integer maxLength;//最大长度
    private String optional;//可选值，如[身份证，护照]
    private Set optionalValue;//可选值Set，如[身份证，护照]
    private String regex;//校验正则表达式
    private String errorMsg;//校验错误提示信息
    private Integer length;//长度

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeadProperty.HeadType getType() {
        return type;
    }

    public void setType(HeadProperty.HeadType type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Set getOptionalValue() {
        if (StringUtils.isNotEmpty(optional)){
            String[]arr = optional.split(",");
            optionalValue = new HashSet(Arrays.asList(arr));
        }
        return optionalValue;
    }

    public void setOptionalValue(Set optionalValue) {
        this.optionalValue = optionalValue;
    }


}
