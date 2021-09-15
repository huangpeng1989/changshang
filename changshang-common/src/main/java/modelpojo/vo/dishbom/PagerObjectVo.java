package modelpojo.vo.dishbom;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerObjectVo<T> implements Serializable
{
    private int page = 1; // 页码 从1开始
    private int size = 10; // 分页大小 默认10
    private List<T> rows = new ArrayList<>(); // 分页数据
    private int total;// 符合查询条件的总条目数
    private int pageSize; //总页数



    public PagerObjectVo() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    @Override
    public String toString() {

        return JSON.toJSONString(this); // 直接转为json输出
    }



    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        //显示分页后总页数 前台类似用 ${page.pageSize} 调用
        int pageCount =  total%size==0?total/size:total/size+1;
        return pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
