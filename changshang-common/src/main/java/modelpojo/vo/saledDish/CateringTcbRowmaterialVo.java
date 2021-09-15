package modelpojo.vo.saledDish;

import modelpojo.model.CateringTcbRowmaterial;

/**
 * @program: phaseiiclota
 * @description:
 * @author: panda
 * @create: 2019-10-24 18:38
 **/
public class CateringTcbRowmaterialVo extends CateringTcbRowmaterial {

    private Integer sellPointId;//营业点id

    public Integer getSellPointId() {
        return sellPointId;
    }

    public void setSellPointId(Integer sellPointId) {
        this.sellPointId = sellPointId;
    }

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
