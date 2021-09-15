package entity;

import java.io.Serializable;

/**
 * @Description:
 * @author: yu.li
 * @Date: 2018/07/13
 */
public class ModelPageRequest<E> implements Serializable{
    private static final long serialVersionUID = 6516770854889429492L;

    private Integer pageNo;
    private Integer pageSize;
    private String orderBy;
    private E data ;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
