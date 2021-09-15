package entity;

import org.lufei.ibatis.mapper.PagedList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: yu.li
 * @Date: 2018/07/13
 */
public class ModelPagedList<E> implements Serializable{
    private static final long serialVersionUID = 6516770854889429492L;

    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalRow;
    private List<E> data = new ArrayList();

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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public static ModelPagedList convertToModelPage(PagedList pagedList){
        ModelPagedList modelPagedList = new ModelPagedList();
        if(pagedList != null){
            modelPagedList.setPageNo(pagedList.getPageNo());
            modelPagedList.setPageSize(pagedList.getPageSize());
            modelPagedList.setTotalPage(pagedList.getTotalPage());
            modelPagedList.setTotalRow(pagedList.getTotalRow());
            modelPagedList.setData(pagedList.getData());
        }
        return modelPagedList;
    }


}
