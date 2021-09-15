package modelpojo.vo.cateringHotSdish;

import modelpojo.model.CateringTcbHotSdishDtlModel;

import java.util.List;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-03-03 18:19
 */
public class CaterHotSdishVo extends CateringTcbHotSdishDtlModel {

    private String createrStr;
    private String modifierStr;
    private String gzoneName;
    private String dishName;
    private Integer delete;

    private List<CateringTcbHotSdishDtlModel> hotSdishList;

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public List<CateringTcbHotSdishDtlModel> getHotSdishList() {
        return hotSdishList;
    }

    public void setHotSdishList(List<CateringTcbHotSdishDtlModel> hotSdishList) {
        this.hotSdishList = hotSdishList;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCreaterStr() {
        return createrStr;
    }

    public void setCreaterStr(String createrStr) {
        this.createrStr = createrStr;
    }

    public String getModifierStr() {
        return modifierStr;
    }

    public void setModifierStr(String modifierStr) {
        this.modifierStr = modifierStr;
    }

    public String getGzoneName() {
        return gzoneName;
    }

    public void setGzoneName(String gzoneName) {
        this.gzoneName = gzoneName;
    }
}
