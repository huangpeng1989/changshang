package modelpojo.vo.saleadjust;

import entity.ModelPagedList;
import org.lufei.ibatis.mapper.PagedList;

public class ModelPagedListVo<E> extends ModelPagedList {

    private E sum ;

    public E getSum() {
        return sum;
    }

    public void setSum(E sum) {
        this.sum = sum;
    }


    public static ModelPagedListVo convertToModelPage(PagedList pagedList){
        ModelPagedListVo modelPagedList = new ModelPagedListVo();
        if(pagedList != null){
            modelPagedList.setPageSize(pagedList.getPageSize());
            modelPagedList.setTotalPage(pagedList.getTotalPage());
            modelPagedList.setTotalRow(pagedList.getTotalRow());
            modelPagedList.setData(pagedList.getData());
            modelPagedList.setPageNo(pagedList.getPageNo());
        }
        return modelPagedList;
    }
}
