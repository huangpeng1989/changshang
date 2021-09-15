package modelpojo.vo.semiBill;

import java.io.Serializable;

public class CateringTcbDishBomDetailVo implements Serializable {

    private String rmIds;//原材料集合

    private Integer gzoneId;//营业点id

    private String DetailList;

    public String getRmIds() {
        return rmIds;
    }

    public void setRmIds(String rmIds) {
        this.rmIds = rmIds;
    }

    public Integer getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(Integer gzoneId) {
        this.gzoneId = gzoneId;
    }

    public String getDetailList() {
        return DetailList;
    }

    public void setDetailList(String detailList) {
        DetailList = detailList;
    }
}