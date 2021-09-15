package com.goods.service.impi.adjust;


import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.rawmater.CaterAdjustFeign;
import com.goods.service.adjust.SaleadjustApi;
import entity.ModelPagedList;
import modelpojo.AdjustStatus;
import modelpojo.BarCodeConstant;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.*;
import modelpojo.vo.CommoditySaleAdjustVo;
import modelpojo.vo.caterAdjust.PriceChangeVo;
import modelpojo.vo.saleadjust.CommodityTcjSaleadjustdetailVo;
import modelpojo.vo.saleadjust.CommodityVo;
import modelpojo.vo.saleadjust.PagerObject;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.DeleteBuilder;
import org.lufei.ibatis.builder.InsertBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SaleadjustBiz implements SaleadjustApi {


    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Autowired
    private SaleadjustManager saleadjustManager;


    @Autowired
    private SupplierServiceFeign supplierService;


    @Autowired
    private CaterAdjustFeign caterTcjAdjustApi;


    /****
     * 售价调价维护列表查询
     * @param adjCode
     * @param status
     * @param projectId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PagerObject<CommodityTcjSaleadjustModel> saleadjustList(String adjCode, Integer status, String comName, Long projectId, Integer pageNo, Integer pageSize) {
        PagerObject<CommodityTcjSaleadjustModel> page=new PagerObject<CommodityTcjSaleadjustModel>();

        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        NativeSQLBuilder builder = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class).append("" +
                "select t1.*,\n" +
                "(select type_name from catecomm_tss_pubdatadict where t1.status = type_code)  as statusName,\n" +
                "(select nick_name from account where id = t1.creater) as nick_name \n");
        builder.append("from commodity_tcj_saleadjust t1\n");
        if(StringUtils.isNotEmpty(comName)) {
            builder.append("left join commodity_tcj_saleadjustdetail t2 on t2.adj_id = t1.adj_id and t2.project_id = t1.project_id\n" +
                    "inner join commodity_tcb_com t3 on t3.com_id = t2.com_id and t3.project_id = t1.project_id\n");
        }

        builder.append("where t1.is_delete=0 and t1.project_id = " + projectId +"\n");

        if(StringUtils.isNotEmpty(comName)) {
            builder.append(" and t3.com_name like '%" + comName + "%'");
        }

        if(adjCode != null && !"".equals(adjCode)){
            builder.append(" and t1.adj_code like '%" + adjCode + "%'");
        }

        if(status != null){
            builder.append("  and t1.status = " + status + "");
        }

        builder.append("  order by t1.created_time desc LIMIT "+(pageNo-1)*pageSize+","+pageSize+"");

        List<CommodityTcjSaleadjustModel> list=autoBaseDao.listAll(builder);
        page.setSize(pageSize);
        page.setRows(list);
        page.setPage(pageNo);
        page.setTotal(saleadjustManager.saleadjustCount(adjCode,status,projectId));
        page.setPageSize(page.getPageSize());
        return page;
    }


    /*****
     * 根据调价单id和项目id删除对应的调价单
     * @param adjId
     * @param projectId
     * @return
     */

    @Override
    public Integer delAleadjust(Integer adjId, Long projectId) {
        Integer shu=0;
        try {

            UpdateBuilder builder=UpdateBuilder.build(CommodityTcjSaleadjustModel.class).set("isDelete",1).set("sync_status",10).whereEq("projectId",projectId)
                    .whereEq("adjId",adjId);
            shu=autoBaseDao.update(builder);
            if(shu>0){
                UpdateBuilder builder1=UpdateBuilder.build(CommodityTcjSaleadjustdetail.class).set("sync_status",10).set("isDelete",1).whereEq("projectId",projectId).whereEq("adjId",adjId);
                shu+=autoBaseDao.update(builder1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  shu;
    }





    /*****
     *  据调价单id和项目id,审核状态来批量修改审梳状态
     * @param adjId
     * @param projectId
     * @param status
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String examinationAleadjust(String adjId, Long projectId, Integer status,Integer userid) {
        StringBuffer buffer = new StringBuffer();
        String message=null;
        try {
            Integer zt=0;
            String[] str=adjId.split(",");
            //判断为审核状态订单号是否有效
//            for(int i=0;i<str.length;i++) {
//                NativeSQLBuilder select = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
//                        .setSql("select * from commodity_tcj_saleadjust where is_delete=0 and project_id = " + projectId + " and adj_id= " + str[i] + "");
//
//                CommodityTcjSaleadjustModel model1 = (CommodityTcjSaleadjustModel) autoBaseDao.listAll(select).get(0);
//                /*允许审核状态 */
//                if (AdjustStatus.ADJUST_STATUS_AUDIT == status  && model1.getStatus() != AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED) {
//
//                        if ((model1.getStartDate().getTime() < new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getTime()))  {
//                            buffer.append("【" + model1.getAdjCode() + "】");
//                        }
//                }
//            }

//            if (buffer.length() > 0) {
//                buffer.append("调价单的当前审核时间大于调价单开始时间，重新编辑审核。");
//            }

//            if (buffer.toString().length() > 0) {
//                return  buffer.toString();
//            }
            StringBuffer buffer1=new StringBuffer();
            for (int i = 0; i < str.length; i++ ) {
                Integer newStatus = 0;

                NativeSQLBuilder select=NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                        .setSql("select * from commodity_tcj_saleadjust where is_delete=0 and project_id = "+projectId+" and adj_id= "+str[i]+"");

                CommodityTcjSaleadjustModel model=(CommodityTcjSaleadjustModel)autoBaseDao.listAll(select).get(0);
                long timestamp = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getTime();

                /*当状态为审核驳回*/
                if(AdjustStatus.ADJUST_STATUS_REJECT==status){
                    newStatus=AdjustStatus.ADJUST_STATUS_REJECT;  //审核驳回
                    message="审核驳回成功！";

                    /*允许审核状态和启用 */
                }else if(AdjustStatus.ADJUST_STATUS_AUDIT==status){
                    /*允许审核状态*/
                    if (model.getStatus() == AdjustStatus.ADJUST_STATUS_AUDIT) {
                        if (model.getStartDate().getTime() > timestamp) {
                            newStatus=AdjustStatus.ADJUST_STATUS_STAY_TAKE_EFFECT;  //待生效
                        } else {
                            newStatus=AdjustStatus.ADJUST_STATUS_IN_FORCE;  //生效中;
                        }
                        message="审核成功！";
                        /*启用状态*/
                    } else if(model.getStatus()==AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED) {

                        if (model.getAdjType().equals(10102)) {
                            if(model.getStartDate().getTime()> timestamp){

                                newStatus = AdjustStatus.ADJUST_STATUS_STAY_TAKE_EFFECT;  //待生效

                            } else if (model.getStartDate().getTime()<= timestamp
                                    ){
                                newStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;//生效中;
                            }
                        }else if(model.getAdjType().equals(10101)){
                            if(model.getStartDate().getTime()> timestamp){

                                newStatus = AdjustStatus.ADJUST_STATUS_STAY_TAKE_EFFECT;  //待生效

                            }else if(model.getStartDate().getTime()<= timestamp &&
                                    model.getEndDate().getTime()>= timestamp
                                    ){
                                newStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;//生效中;
                            }
                        }

                        message="启用成功！";
                    }


                    /*立即执行*/
                } else if (AdjustStatus.ADJUST_STATUS_IN_FORCE == status){
                    zt=status;
                    if(!model.getAdjType().equals(10102) ) {
                        if (model.getEndDate().getTime() <timestamp) {
                            newStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INTO_FORCE;//已失效
                        }else{
                            newStatus=AdjustStatus.ADJUST_STATUS_IN_FORCE;//生效中;
                        }
                    }else{
                        newStatus=AdjustStatus.ADJUST_STATUS_IN_FORCE;//生效中;
                    }
                    message="立即执行成功！";
                    /*停用*/
                } else if (AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED == status) {
                    //调用存储过程恢复价格
                    PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack( BarCodeConstant.COMMODITY, BarCodeConstant.OUT, model.getAdjCode());
                    if (null == billCheckMthVo) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "立即停用失败！调用存储过程失败！" , null);
                    }
                    Boolean outReturn = billCheckMthVo.getCode();
                    String msg = billCheckMthVo.getMessage();
                    if (!outReturn) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "立即停用失败！调用存储过程失败！错误信息是" + msg, null);
                    }
                    newStatus = AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED;//停用
                    message = "停用成功！";
                }

                /*
                 * 如果状态为生效中修改价格配置表中的商品零售价价格
                 */
                if (newStatus == AdjustStatus.ADJUST_STATUS_IN_FORCE ){

                    //如果是待审核状态调用存储过程 调用存储过程之前 先将状态改为待生效然后调用存储过程
                    NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                            .setSql(" UPDATE commodity_tcj_saleadjust SET \n" );
                    supplier.append(" status = 10704\n");
                    supplier.append(" WHERE adj_id IN (" + str[i] + ") and project_id = " + projectId);

                    if (autoBaseDao.nativeExecute(supplier) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                    }

                    PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack( BarCodeConstant.COMMODITY, BarCodeConstant.OUT, model.getAdjCode());
                    Boolean outReturn = billCheckMthVo.getCode();
                    String msg = billCheckMthVo.getMessage();
                    if (!outReturn == true) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "立即执行失败！调用存储过程失败！错误信息是" + msg, null);
                    } else {
                        UpdateBuilder builder=UpdateBuilder.build(CommodityTcjSaleadjustModel.class)
                                .set("blEmpId",userid).set("blTime",new Date()).set("sync_status",10);
                        if(AdjustStatus.ADJUST_STATUS_IN_FORCE == zt){
                             builder.set("start_date",new Date());
                        }
                        builder.whereEq("projectId",projectId).whereEq("adjId",str[i]);
                        autoBaseDao.update(builder);
                        UpdateBuilder builder1 = UpdateBuilder.build(CommodityTcjSaleadjustdetail.class).set("sync_status",10).whereEq("projectId",projectId).whereEq("adjId",str[i]);
                        autoBaseDao.update(builder1);
                        message = "立即执行成功！" + "调用存储过程参数：" + projectId + "," + BarCodeConstant.COMMODITY + "," + BarCodeConstant.OUT + "," + model.getAdjCode();
                    }
                } else {
                     UpdateBuilder builder1 = UpdateBuilder.build(CommodityTcjSaleadjustdetail.class).set("sync_status",10).set("status", newStatus).whereEq("projectId",projectId).whereEq("adjId",str[i]);
                     autoBaseDao.update(builder1);
                     UpdateBuilder builder = UpdateBuilder.build(CommodityTcjSaleadjustModel.class).set("status",newStatus).set("blEmpId",userid).set("blTime",new Date()).set("sync_status",10);
                     if (AdjustStatus.ADJUST_STATUS_IN_FORCE == zt) {
                        builder.set("start_date", new Date());
                      }
                     builder.whereEq("projectId", projectId).whereEq("adjId",str[i]);
                     autoBaseDao.update(builder);
                }
            }
            if(buffer1.toString().length() > 0){
                return buffer1.toString();
            }else {
                return message;
            }
        } catch (Exception e) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  e.getMessage(), null);
        }
    }




    /******
     * 根据供应商id，商品分类编码，商品的名称或编码或条码，价格等级id查询对应的商品信息
     * @param comClassCode
     * @param cominfo
     * @param comGrade
     * @return
     */
    @Override
    public ModelPagedList selectCommodity(String comClassCode, String cominfo, Integer comGrade, Long projectId, Integer pageNo, Integer pageSize){

        /*and s.sc_status=10605*/
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityVo.class)
                .setSql("SELECT xin.*,g.gp_id,g.grade_id,g.retail_price,(1-xin.tax_paid/g.`retail_price`)*100 AS o_gro_margin,\n" +
                        "(SELECT dict_tp_value FROM `catecomm_tss_datadict`  WHERE g.grade_id= dict_tp_code and dd_status=1 and project_id = "+projectId+") AS gradeName\n" +
                        ",(SELECT type_name from catecomm_tss_pubdatadict  where xin.comm_unit = type_code) as commUnit  FROM (\n" +
                        "SELECT s.com_id,s.com_code,s.sale_com_code,s.sale_com_id,s.project_id,s.sale_comm_unit as comm_unit ,\n" +
                        "c.sell_model AS busMode,c.sell_model AS busModel,(p.tax_paid * s.pack_content) as tax_paid,(p.no_tax_paid * s.pack_content) as no_tax_paid,p.supp_id,c.com_class_code,c.com_name,s.com_barcode,\n" +
                        "(SELECT type_name FROM `catecomm_tss_pubdatadict` d WHERE d.type_code =c.`sell_model`) AS busModelName FROM `commodity_tcb_salecom` s\n" +
                        "INNER JOIN `commodity_tcb_com` c ON (c.com_id=s.com_id)\n" +
                        "INNER JOIN `commodity_tcb_suppcom` p ON (p.com_id=s.com_id)\n" +
                        "WHERE c.is_delete=0 AND  c.project_id = "+projectId+" and  s.project_id = "+projectId+" and " +
                        "s.com_status=1 AND s.is_default = 10 and s.is_delete=0 and p.is_delete=0 and p.is_default = 10 and p.project_id="+projectId+ " AND c.sell_status in(10201,10202,10203) AND c.c_status = 10605\n" +
                        ") xin\n" +
                        "INNER JOIN `commodity_tcb_gradeprice` g ON (xin.sale_com_id=g.sale_com_id AND xin.com_id=g.com_id) where 1=1 ");
        if(comClassCode != null && !"".equals(comClassCode)){
            builder.append(" and xin.com_class_code="+comClassCode+"");
        }
        if(cominfo != null && !"".equals(cominfo)){
            builder.append(" and (xin.com_name LIKE '%"+cominfo+"%' OR xin.com_code LIKE '%"+cominfo+"%' OR xin.com_barcode LIKE '%"+cominfo+"%')");
        }

        if(comGrade != null){
            builder.append(" and g.grade_id ="+comGrade+"");
        }
        builder.append(" and xin.project_id="+projectId+" AND g.project_id="+projectId+" and g.c_status = 1 and g.is_delete = 0 ");
        builder.setPage(pageNo,pageSize);
        PagedList<CommodityVo> list = autoBaseDao.listPage(builder);
        ModelPagedList modelPagedList = ModelPagedList.convertToModelPage(list);
        return modelPagedList;
    }



    /******
     * 新增调价单信息
     * @param info
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveSaleadjust( CommodityTcjSaleadjustModel info){

            Integer shu=0;

            info.setAdjId(supplierService.getTableId(info.getProjectId(),"commodity_tcj_saleadjust", 1));
            info.setSyncStatus(10);
            InsertBuilder builder=InsertBuilder.build(info).optSql();

            shu=autoBaseDao.save(builder);

            if(shu>0){

                for (CommodityTcjSaleadjustdetail item:info.getList()
                        ) {
                    CommodityTcbGradeprice gradeprice=saleadjustManager.getGradeprice(item.getGpId(),info.getProjectId());
                    item.setMemberPrice(gradeprice.getMemberPrice()!= null ? gradeprice.getMemberPrice() : new BigDecimal(0));
                    item.setMaxSalePrice(gradeprice.getMaxSalePrice()!= null ? gradeprice.getMaxSalePrice() : new BigDecimal(0));
                    item.setMinSalePrice(gradeprice.getMinSalePrice()!= null ? gradeprice.getMinSalePrice() : new BigDecimal(0));
                    item.setTradePrice(gradeprice.getTradePrice()!= null ? gradeprice.getTradePrice() : new BigDecimal(0));
                    item.setDeliveryPrice(gradeprice.getDeliveryPrice() != null ? gradeprice.getDeliveryPrice() : new BigDecimal(0));
                    CommodityTcbSalecom salecom=saleadjustManager.getSalecomInfo(item.getSaleComId(),info.getProjectId());
                    item.setPackContent(salecom.getPackContent());
                    item.setComBarcode(salecom.getComBarcode());
                    item.setComIntegral(salecom.getComIntegral()!= null ? salecom.getComIntegral() : new BigDecimal(0));
                    item.setModifier(info.getModifier());
                    item.setProjectId(info.getProjectId());
                    item.setCreater(info.getCreater());
                    item.setRemark(info.getRemark());
                    item.setDescription(info.getDescription());
                    item.setStatus(info.getStatus());
                    item.setAdjId(info.getAdjId());
                    item.setSadId(supplierService.getTableId(info.getProjectId(),"commodity_tcj_saleadjustdetail", 1));
                    InsertBuilder builder1=InsertBuilder.build(item).optSql();
                    shu +=autoBaseDao.save(builder1);
                }
            }

        return  shu;
    }

    /*****
     * 根据调价售价订id和项目id查询对应的信息
     * @param adjId
     * @param projectId
     * @return
     */
    @Override
    public CommodityTcjSaleadjustModel selectCommodityInfo(Integer adjId,Long projectId){

        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class).setSql(
                "select * from commodity_tcj_saleadjust where adj_id="+adjId+" and project_id="+projectId+" and is_delete=0");

        List<CommodityTcjSaleadjustModel> model = autoBaseDao.listAll(builder);

        if(!model.isEmpty()){
            NativeSQLBuilder builder1=NativeSQLBuilder.build(CommodityTcjSaleadjustdetailVo.class).setSql(
                    "select *,CONCAT(SUBSTRING(CONCAT(o_gro_margin,'0'),1,LOCATE('.', o_gro_margin)+2),'%') AS oGroMargin," +
                            "CONCAT(SUBSTRING(CONCAT(new_gro_margin,'0'),1,LOCATE('.', new_gro_margin)+2),'%') AS newGroMargin," +
                            "( select com_name from  `commodity_tcb_com`  where commodity_tcb_com.com_id=commodity_tcj_saleadjustdetail.com_id and commodity_tcb_com.project_id="+projectId+") as comName," +
                            "(select dict_tp_value from catecomm_tss_datadict  where grade_id = dict_tp_code and dd_status=1 and project_id =  " +  projectId + ") as gradeName, \n" +
                            "(select catecomm_tss_pubdatadict.type_name from catecomm_tss_pubdatadict  where bus_model = catecomm_tss_pubdatadict.type_code) as busModelName, \n" +
                            "(select sale_com_code from commodity_tcb_salecom where commodity_tcb_salecom.project_id="+projectId+" and commodity_tcb_salecom.sale_com_id= commodity_tcj_saleadjustdetail.sale_com_id) as saleComCode" +
                            " from commodity_tcj_saleadjustdetail where adj_id="+adjId+" and project_id="+projectId+" and is_delete=0");
            List<CommodityTcjSaleadjustdetailVo> list = autoBaseDao.listAll(builder1);
            model.get(0).setListVo(list);
            return  model.get(0);
        }
        return  null;
    }



    /*****
     * 根据调价售价单id和项目id修改对应的调价售价单商品信息
     * @param info
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public Integer updeteSaleadjust(CommodityTcjSaleadjustModel info){

            Integer shu=0;
            UpdateBuilder builder=UpdateBuilder.build(CommodityTcjSaleadjustModel.class).set("sync_status",10).set("adjType",info.getAdjType())
                    .set("startDate",info.getStartDate()).set("remark",info.getRemark()).set("description",info.getDescription())
                    .set("modifier",info.getModifier()).set("status", info.getStatus());
            if(info.getAdjType()==10101){
                builder.set("endDate",info.getEndDate());
            }else if(info.getAdjType()==10102){
                builder.set("endDate",null);
            }
            builder.whereEq("projectId",info.getProjectId()).whereEq("adjId",info.getAdjId());
            shu=autoBaseDao.update(builder);
            if(shu>0){
                //对子表信息进行删除
                DeleteBuilder deleteBuilder = DeleteBuilder.build("commodity_tcj_saleadjustdetail").whereEq("project_id",info.getProjectId())
                        .whereEq("adj_id",info.getAdjId());
                autoBaseDao.delete(deleteBuilder);


                //对子表新增
                for (CommodityTcjSaleadjustdetail item:info.getList()
                        ) {
                        //如果新增的商品在子表中也存在的话那就进行修改
                            CommodityTcbGradeprice gradeprice=saleadjustManager.getGradeprice(item.getGpId(),info.getProjectId());
                            item.setMemberPrice(gradeprice.getMemberPrice()!= null ? gradeprice.getMemberPrice() : new BigDecimal(0));
                            item.setMaxSalePrice(gradeprice.getMaxSalePrice()!= null ? gradeprice.getMaxSalePrice() : new BigDecimal(0));
                            item.setMinSalePrice(gradeprice.getMinSalePrice()!= null ? gradeprice.getMinSalePrice() : new BigDecimal(0));
                            item.setTradePrice(gradeprice.getTradePrice()!= null ? gradeprice.getTradePrice() : new BigDecimal(0));
                            item.setDeliveryPrice(gradeprice.getDeliveryPrice() != null ? gradeprice.getDeliveryPrice() : new BigDecimal(0));
                            CommodityTcbSalecom salecom=saleadjustManager.getSalecomInfo(item.getSaleComId(),info.getProjectId());
                            item.setPackContent(salecom.getPackContent());
                            item.setComBarcode(salecom.getComBarcode());
                            item.setComIntegral(salecom.getComIntegral()!= null ? salecom.getComIntegral() : new BigDecimal(0));
                            item.setCreater(info.getCreater());
                            item.setRemark(info.getRemark());
                            item.setDescription(info.getDescription());
                            item.setAdjId(info.getAdjId());
                            item.setProjectId(info.getProjectId());
                            item.setModifier(info.getModifier());
                            item.setSadId(supplierService.getTableId(info.getProjectId(),"commodity_tcj_saleadjustdetail", 1));
                            item.setStatus(10702);
                            InsertBuilder builder1=InsertBuilder.build(item).optSql();
                            shu +=autoBaseDao.save(builder1);
                        }
            }
        return  shu;
    }


    /*****
     * 根据项目id和表名生成售价，进价单单号
     * @param projectId
     * @param tableName
     * @return
     */
    public String sysGetBillCode(Long projectId, String tableName){

        StringBuffer buffer=new StringBuffer();
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityVo.class).setSql("CALL P_Sys_GetBillCode("+projectId+",'"+tableName+"',@billcode,@billid);" );
        List<CommodityVo> list=autoBaseDao.listAll(builder);

        if(!list.isEmpty()){
            if("commodity_tcj_saleadjust".equals(tableName)){
                buffer.append("USP").append(list.get(0).getBillcode()+list.get(0).getBillid());
            } else if("commodity_tcj_adjust".equals(tableName) || "catering_tcj_adjust".equals(tableName)){
                buffer.append("UPP").append(list.get(0).getBillcode()+list.get(0).getBillid());
            } else  {
                buffer.append(list.get(0).getBillcode());
            }


            return  buffer.toString();
        }
        return  null;
    }


    /******
     * 查询全局字典表的字典信息
     * @return
     */
    public List<CatecommTssPubdatadict> selectCatecommTssPubdatadict(){
          NativeSQLBuilder builder = NativeSQLBuilder.build(CatecommTssPubdatadict.class).setSql("" +
                  "select * from catecomm_tss_pubdatadict where p_dict_status = 1");
          List<CatecommTssPubdatadict> list=autoBaseDao.listAll(builder);
          return  list;
    }

    /******
     * 查询项目字典表的字典信息
     * @return
     */
    public List selectCatecommTssDatadict(Long projectId){
        NativeSQLBuilder builder = NativeSQLBuilder.build(CatecommTssDatadictModel.class).setSql("" +
                "select * from catecomm_tss_datadict where project_id = "+projectId+" and dd_status=1");
        List<CatecommTssPubdatadict> list=autoBaseDao.listAll(builder);
        return  list;
    }

    @Override
    public ModelPagedList<ComSalePricetDto> getComSalePrice(int pageNo, int pageSize, String comName, String date, Integer gradeId, Long projectId) {
        String beginRcptDate = null;
        String endRcptDate = null;
        if (StringUtils.isNotBlank(date)) {
            String[] timeArray = date.split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(ComSalePricetDto.class)
                .setSql("SELECT  \n" +
                                "(SELECT dict_tp_value FROM catecomm_tss_datadict WHERE catecomm_tss_datadict.dict_tp_code = t1.grade_id AND catecomm_tss_datadict.project_id = t1.project_id) AS dictValue,\n" +
                                "t2.com_code,\n" +
                                "t2.com_name, \n" +
                                "t2.com_spec,\n" +
                                "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t2.com_unit ) AS comUnit,\n" +
                                "t.start_date, t.end_date, t1.new_retail_price as tax_paid, t1.no_tax_paid \n" +
                                "FROM commodity_tcj_saleadjust t \n" +
                                "INNER JOIN commodity_tcj_saleadjustdetail t1 ON t1.project_id = t.project_id AND t1.adj_id = t.adj_id \n" +
                                "INNER JOIN commodity_tcb_com t2 ON t2.project_id = t.project_id AND t2.com_id = t1.com_id \n" +
                        "WHERE 1 = 1 and t.project_id = " + projectId + "\n");
        sqlBuilder.append(StringUtils.isNotBlank(comName) ? "and (t2.com_name like" + "'%" + (comName) + "%' OR  t2.com_code like" + "'%" + (comName) + "%') \n" : "");
        sqlBuilder.append(null != gradeId ? "AND t1.grade_id =" + gradeId + "\n" : "");
        sqlBuilder.append(StringUtils.isNotBlank(beginRcptDate) ? ("and t.start_date between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
        sqlBuilder.append("ORDER BY t.created_time desc");
        sqlBuilder.setPage(pageNo, pageSize);
        return this.assembleSaleReportDto(autoBaseDao.listPage(sqlBuilder), projectId);
    }

    @Override
    public void saleadjustBatchCommit(String adjIds, Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                .setSql(" SELECT * FROM commodity_tcj_saleadjust \n" +
                        " WHERE is_delete = 0 and adj_id IN (" + adjIds + ") and project_id =" + projectId);
        List<CommodityTcjSaleadjustModel> adjustModels = autoBaseDao.listAll(sql);
        Integer oldSize = adjustModels.size();
        adjustModels.removeIf(b -> 10700 != b.getStatus().intValue());//排除掉不是新增状态的数据
        if (adjustModels.size() != oldSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在不是新增状态的数据，请重新选择！", null);
        }
        NativeSQLBuilder rcpt = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                .setSql("UPDATE commodity_tcj_saleadjust\n" );
        rcpt.append("SET status = 10702 \n");
        rcpt.append("WHERE adj_id IN(" + adjIds + ")\n");
        rcpt.append("AND project_id = " + projectId);
        if (autoBaseDao.nativeExecute(rcpt) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "批量提交失败！", null);
        }
    }

    @Override
    @Transactional
    public void counterTrial(Integer adjId, Long projectId, Long accountId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                .setSql("SELECT * FROM commodity_tcj_saleadjust\n" +
                        "WHERE is_delete = 0 and adj_id = " + adjId + " and project_id =" + projectId);
        CommodityTcjSaleadjustModel saleadjustModel = (CommodityTcjSaleadjustModel)autoBaseDao.findOne(sql);
        if (10704 != saleadjustModel.getStatus()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "只能反审审核通过待生效的单据！", null);
        }

        //修改状态
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcjSaleadjustModel.class)
                .setSql("UPDATE commodity_tcj_saleadjust SET status = 10703,\n" +
                        "modifier = " + accountId + ",\n" +
                        "sync_status = 10,\n" +
                        "updated_time = NOW()\n" +
                        "WHERE adj_id = " + adjId + " and project_id =" + projectId);
        //反审操作
        if (autoBaseDao.nativeExecute(supplier) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "反审操作失败！", null);
        }


    }

    @Override
    public List<CommoditySaleAdjustVo> excelOutComSaleAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String comName) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CommoditySaleAdjustVo.class)
                .setSql(" select t2.adj_code, t2.start_date, t2.end_date, t3.com_code, t3.com_name,  t5.sale_com_code,\n" +
                        " (case when t1.grade_id = 10001 then '园内' else '园外' end) grade,\n" +
                        " (case when t3.sell_model = 10001 then '经销'  \n" +
                        "  when t3.sell_model = 10002 then '代销' \n" +
                        "     when t3.sell_model = 10003 then '联营'  end) as sellModelStr,\n" +
                        "(case  when t2.status = 10700 then '新增' \n" +
                        "when t2.status = 10702 then '待审核' \n" +
                        "when t2.status = 10703 then '审核驳回' \n" +
                        "when t2.status = 10704 then '待生效'\n" +
                        "when t2.status = 10705 then '生效中'\n" +
                        "when t2.status = 10706 then '已失效' end) as adjStatus,\n" +
                        "(select type_name from catecomm_tss_pubdatadict where catecomm_tss_pubdatadict.type_code = t5.comm_unit ) AS taxValue,\n" +
                        "(case when t2.adj_type = 10101 then '区间调价' else '永久调价' end) AS adj_type,\n" +
                        "t1.retail_price, t1.new_retail_price\n" +
                        "from  commodity_tcj_saleadjustdetail t1\n" +
                        "left join  commodity_tcj_saleadjust t2 on t2.adj_id = t1.adj_id and t2.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_com t3 on t3.com_id = t1.com_id and t3.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_salecom t5 on t5.com_id = t3.com_id and t5.project_id = t1.project_id and t5.is_pur_chase_unit = 1\n" +
                        "where  t2.is_delete = 0  and t2.project_id = " + projectId);
        sqlBuilder.append(StringUtils.isNotEmpty(adjIds) ? " AND t2.adj_id IN (" + adjIds + ")\n" : "");
        sqlBuilder.append(null != adjStatus ? " AND t2.status = " + adjStatus : "");
        sqlBuilder.append(StringUtils.isNotEmpty(adjCode) ? " AND t2.adj_code like '%" + adjCode + "%' \n" : "");
        sqlBuilder.append(StringUtils.isNotEmpty(comName) ? " AND t3.com_name like '%" + comName + "%' \n" : "");
        return autoBaseDao.listAll(sqlBuilder);
    }


    private ModelPagedList assembleSaleReportDto(List<ComSalePricetDto> list, Long projectId) {
        if (null == list && list.size() == 0) {
            return null;
        }
        list.forEach(a -> {
            NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(Map.class)
                    .setSql("SELECT \n" +
                            "(SELECT con_to_free_tax FROM catecomm_tsb_tax WHERE catecomm_tsb_tax.tax_id = t.sl_tax_id AND catecomm_tsb_tax.project_id = t.project_id) AS con_to_free_tax,\n" +
                            "(SELECT con_to_free_num FROM catecomm_tsb_tax WHERE catecomm_tsb_tax.tax_id = t.sl_tax_id AND catecomm_tsb_tax.project_id = t.project_id) AS con_to_free_num\n" +
                            "FROM commodity_tcb_com t WHERE t.com_code = " + a.getComCode() + " AND t.project_id = " + projectId);
            Map<Object, Object> map = (Map) autoBaseDao.findOne(sqlBuilder);
            if (null != map) {
                String conToFreeTax = String.valueOf(map.get("conToFreeTax"));
                Integer conToFreeNum = Integer.valueOf(String.valueOf(map.get("conToFreeNum")));
                a.setNoTaxPaid(a.getTaxPaid().multiply(new BigDecimal(conToFreeTax).setScale(conToFreeNum, BigDecimal.ROUND_HALF_UP)));
            }

        });
        return ModelPagedList.convertToModelPage((PagedList) list);
    }
}
