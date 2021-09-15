package modelpojo.vo.saleadjust;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 菜品导入返回想信息
 * @Author
 * @Date
 */
public class DishesResponse implements Serializable {
    private static final long serialVersionUID = -3990045871417568850L;

    private Integer pageNo;
    private Integer pageSize;
    private Integer total;
    private Integer type;
    private Integer code;
    private List<DishesExeclMessage> execlMessagesList;

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

    public List<DishesExeclMessage> getExeclMessagesList() {
        return execlMessagesList;
    }

    public void setExeclMessagesList(List<DishesExeclMessage> execlMessagesList) {
        this.execlMessagesList = execlMessagesList;
    }
}
