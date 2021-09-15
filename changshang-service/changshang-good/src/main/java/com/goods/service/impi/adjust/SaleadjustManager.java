package com.goods.service.impi.adjust;


import modelpojo.model.CommodityTcbGradeprice;
import modelpojo.model.CommodityTcbSalecom;
import modelpojo.model.CommodityTcjSaleadjustModel;
import modelpojo.model.CommodityTcjSaleadjustdetail;
import org.lufei.ibatis.builder.CountBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SaleadjustManager {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    /*****
     * 查询售价调价维护列表数据总条数
     * @param adjCode
     * @param status
     * @param projectId
     * @return
     */
    public Integer saleadjustCount(String adjCode, Integer status, Long projectId){

        CountBuilder  builder=CountBuilder.build(CommodityTcjSaleadjustModel.class).appendWhere("is_delete=0 and project_id = "+projectId+"");

        if(adjCode !=null && !"".equals(adjCode)){
            builder.appendWhere("  adj_code like '%"+adjCode+"%'");
        }

        if(status != null){
            builder.appendWhere(" status = "+status+"");
        }

        BigDecimal count=autoBaseDao.count(builder);

        return  count.intValue();
    }

    /****
     * 根据价格配置id查询对应的商品信息
     * @param gpid
     * @return
     */
    public CommodityTcbGradeprice getGradeprice(Integer gpid, Long projectId){

        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcbGradeprice.class).setSql("select * from commodity_tcb_gradeprice where gp_id="+gpid+" and project_id = "+projectId+"");

        List<CommodityTcbGradeprice> list=autoBaseDao.listAll(builder);
        if(!list.isEmpty()){
            return  list.get(0);
        }
       return  null;
    }

    /****
     * 根据销售商品id查询对应的商品信息
     * @param salecomId
     * @return
     */
    public CommodityTcbSalecom getSalecomInfo(Integer salecomId, Long projectId){

        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcbSalecom.class).setSql("select * from commodity_tcb_salecom where sale_com_id="+salecomId+" and project_id = "+projectId+"");

        List<CommodityTcbSalecom> list=autoBaseDao.listAll(builder);
        if(!list.isEmpty()){
            return  list.get(0);
        }
        return  null;
    }

    /****
     * 根据售价调价维子表id查询对应的商品信息,判断是否存在子表中
     * @param sadId
     * @return
     */
    public boolean getSaleadjustdetail(Integer sadId,Long projectId){
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcjSaleadjustdetail.class).setSql("select * from commodity_tcj_saleadjustdetail where sad_id="+sadId+" and project_id = "+projectId+"");

        List<CommodityTcjSaleadjustdetail> list=autoBaseDao.listAll(builder);
        if(!list.isEmpty()){
            return  false;
        }
        return  true;
    }


    /****
     * 根据售价调价单id和商品销售编查询对应的商品信息,判断是否存在子表中
     * @param adjid
     * @return
     */
    public boolean getInsertSaleadjustdetail(Integer adjid,Integer saleComid,Long projectId){
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcjSaleadjustdetail.class).setSql("select * from commodity_tcj_saleadjustdetail where adj_id="+adjid+" and project_id = "+projectId+"" +
                " and sale_com_id="+saleComid+" and is_delete=0");

        List<CommodityTcjSaleadjustdetail> list=autoBaseDao.listAll(builder);
        if(!list.isEmpty()){
            return  false;
        }
        return  true;
    }



    /****
     * 根据售价调价维id查询对应的商品信息
     * @param adjId
     * @return
     */
    public List getSaleadjustdetailList(Integer adjId,Long projectId){
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcjSaleadjustdetail.class).setSql("select * from commodity_tcj_saleadjustdetail where adj_id="+adjId+" and is_delete=0 and project_id = "+projectId+"");

        List<CommodityTcjSaleadjustdetail> list=autoBaseDao.listAll(builder);
        return  list;
    }

}
