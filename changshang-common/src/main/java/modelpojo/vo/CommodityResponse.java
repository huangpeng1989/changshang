package modelpojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-05-23 13:38
 */
public class CommodityResponse implements Serializable {
    private static final long serialVersionUID = -3990045871417568850L;

    private Integer pageNo;
    private Integer pageSize;
    private Integer total;
    private Integer type;
    private Integer code;
    private List<CommodityTcbComImportDto> resultList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<CommodityTcbComImportDto> getResultList() {
        return resultList;
    }

    public void setResultList(List<CommodityTcbComImportDto> resultList) {
        this.resultList = resultList;
    }
}
