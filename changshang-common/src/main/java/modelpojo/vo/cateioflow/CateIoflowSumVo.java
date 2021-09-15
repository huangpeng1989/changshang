package modelpojo.vo.cateioflow;

import java.io.Serializable;

/**
 * @program: phaseiiclota
 * @description:
 * @author: panda
 * @create: 2019-11-15 17:38
 **/
public class CateIoflowSumVo implements Serializable {



    private String whId;//仓库ID/编码

    private String rmName;//原材料名称/编码

    private String dishName;//半成品名称/编码

    private String deal;//流水单号

    private String className;//商品分类ID，逗号分隔	入参格式：'水果类','面包类','坚果类'

    private String classType;//出入库类型ID，逗号分隔

    private String startTime;//开始时间

    private String endTime;//结束时间

    private String rowList;//结束时间

    private String cateType;//类型

    //如果类型是调拨出库，这个就要展示调入仓库，如果类型是调拨入库就要展示调出仓库
    private String inOutWhName;

    public String getInOutWhName() {
        return inOutWhName;
    }

    public void setInOutWhName(String inOutWhName) {
        this.inOutWhName = inOutWhName;
    }

    public String getCateType() {
        return cateType;
    }

    public void setCateType(String cateType) {
        this.cateType = cateType;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }

    public String getWhId() {
        return whId;
    }

    public void setWhId(String whId) {
        this.whId = whId;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
