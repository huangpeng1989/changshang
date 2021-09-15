package com.goods.service.impi.reportLoss;

import com.changshang.feign.SupplierServiceFeign;

import com.goods.service.reportLoss.FreePromotionApi;
import entity.ModelPagedList;
import modelpojo.model.promotion.freepromotion.CatecommFreeEnum;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotion;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotionDtl;
import modelpojo.model.promotion.freepromotion.CatecommFreePromotionRule;
import modelpojo.model.promotion.freereduction.CatecommFreeReductionDtl;
import modelpojo.model.promotion.periodpromotion.CatecommPeriodPromotionDtl;
import modelpojo.vo.cateringcheck.TaxcostpriceVo;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @PackageName:com.quick.clota.commodity.biz.promotion
 * @ClassName:FreePromotionBiz
 * @Description
 * @author: huangpeng
 * @date:2021/6/1 16:51
 */
@Service
public class FreePromotionBiz implements FreePromotionApi {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();

    @Autowired
    private SupplierServiceFeign supplierService;

    /****
     * @Author huangpeng
     * @Description //查看商品，原材料，菜品满赠促销列表分页页面
     * @Date 11:20 2021/6/2
     * @Param
     * @return
     **/
    public ModelPagedList getFreePromotionList(String freeCode, String freeName, String freeStartDay, String freeEndDay,
                                               Integer goodType, Integer freeStatus, Long projectId, Integer pageNo, Integer pageSize){
        NativeSQLBuilder builder = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                "SELECT \n" +
                "free.`free_id` ,free.`free_code` ,free.`good_type` ,free.`free_status`,\n" +
                "free.free_name ,gzone.gzone_name ,free.`free_end_day` ,free.`free_start_day`,\n" +
                "p.type_name AS goodTypeName,p1.type_name AS freeStatusName,a.nick_name,free.bl_time,free.created_time\n" +
                "FROM `catecomm_free_promotion` free\n" +
                "INNER JOIN `catecomm_tsb_gzone` gzone ON (free.project_id = gzone.project_id AND free.`gzone_id` = gzone.gzone_id )\n" +
                "INNER JOIN `catecomm_tss_pubdatadict` p ON (p.type_code = free.`good_type`)\n" +
                "INNER JOIN `catecomm_tss_pubdatadict` p1 ON (p1.type_code = free.`free_status`)\n" +
                "LEFT JOIN account  a ON (a.id= free.bl_emp_id ) \n" +
                "WHERE free.`project_id` =  "+projectId+" and free.is_delete = 0 \n");
        if(StringUtils.isNotEmpty(freeCode)){
            builder.append(" and free.free_code like '%"+freeCode+"%' \n");
        }
        if(StringUtils.isNotEmpty(freeName)){
            builder.append(" and free.free_name like '%"+freeName+"%' \n");
        }
        if(StringUtils.isNotEmpty(freeStartDay) && StringUtils.isNotEmpty(freeEndDay)){
            builder.append(" and   ( free.free_start_day >='"+freeStartDay+"' and free.free_end_day <= '"+freeEndDay+"' )");
        }
        if(goodType != null){
            builder.append(" and free.good_type = "+goodType+" \n");
        }
        if(freeStatus != null){
            builder.append(" and free.free_status = "+freeStatus+" \n");
        }
        builder.append( " ORDER BY free.created_time DESC");
        builder.setPage(pageNo,pageSize);
        PagedList<TreeMap> pagedList= autoBaseDao.listPage(builder);
        return  ModelPagedList.convertToModelPage(pagedList);
    }

    /***
     * @Author huangpeng
     * @Description //查看商品，原材料，菜品满赠促销单选择的营业点下的对应的可售商品，可售原材料，可售菜品信息
     * @Date 14:39 2021/6/2
     * @Param
     * @return
     **/
    public ModelPagedList getPromotionGoods(Integer gzoneId,Integer goodType,String classCode,String comName,Integer billType,
                                       Long projectId,Integer pageNo,Integer pageSize){
        if(pageNo == null){
            pageNo =1;
        }
        if (pageSize == null){
            pageSize = 10000;
        }
        List<TreeMap> classCods = new ArrayList<>();
        String str = "";
        //如果编码code不为空，查询对应编码分类下的所有商品，原材料，菜品
        if(StringUtils.isNotEmpty(classCode)){
             getCalssCode(goodType,classCode,projectId,classCods);
             str = classCods.stream().map(a->String.valueOf(a.get("classCode"))).collect(Collectors.joining(","));
             if(StringUtils.isNotEmpty(str)){
                 str = classCode +","+str;
             }else{
                 str = classCode;
             }
        }
        StringJoiner sql = new StringJoiner("  \n");
        if(goodType == 11005){
            //goodType为11005时，查询对应营业点下的有效可售商品信息
            sql.add("SELECT dtl.retail_price as com_retail_price,dtl.`com_id`,dtl.com_barcode,c.`com_code`,c.`com_name`,c.`com_spec`,\n" +
                    "c.`com_unit`,pud.`type_name` AS comUnitName,11005 AS goodType\n" +
                    "FROM `commodity_saled_pda_com_detail` dtl \n" +
                    "INNER JOIN `commodity_saled_pda_com` p ON (dtl.`project_id` = p.`project_id` AND dtl.`saled_dish_id` =  p.`saled_bill_id`)\n" +
                    "INNER JOIN `commodity_tcb_com` c ON (c.`project_id` = dtl.`project_id` AND c.`com_id` = dtl.`com_id`)\n" +
                    "INNER JOIN `catecomm_tss_pubdatadict` pud ON (pud.`type_code` = c.`com_unit`)\n" +
                    "WHERE dtl.`project_id` = "+projectId+" AND dtl.`is_delete` = 0 AND dtl.`is_bind` = 0 \n" +
                    "AND p.`saled_dish_status` = 15603 AND dtl.`gzone_id` = "+gzoneId+" AND is_sale_status = 1 \n");
            if(StringUtils.isNotEmpty(str)){
                sql.add(" and c.com_class_code in ("+str+") ");
            }
            if(StringUtils.isNotEmpty(comName)){
                sql.add(" and  (c.com_name  like '%"+comName+"%' or c.com_code like '%"+comName+"%' ) ");
            }
        }else if(goodType == 11004){
            //goodType为11004时，查询对应营业点下的有效可售原材料信息
            sql.add("SELECT dtl.`dish_id` AS comId,11004 AS goodType,r.`rm_code` AS comCode,r.`rm_name` AS comName,r.`rm_unit` AS comUnit,\n" +
                    "r.`sell_model` AS comSpec,pud.`type_name` AS comUnitName,sale.rm_barcode AS comBarcode,price.dict_spec_price AS com_retail_price\n" +
                    "FROM `catering_saled_dish_detail` dtl \n" +
                    "INNER JOIN `catering_saled_dish` saled ON (dtl.`project_id` = saled.`project_id` AND dtl.`saled_dish_id`=  saled.`saled_dish_id`)\n" +
                    "INNER JOIN catering_saled_dish_detail_price price ON (price.`project_id` = dtl.`project_id` AND  dtl.`saled_dish_id` = price.`saled_dish_id` AND dtl.`dish_id` = price.dict_id)\n" +
                    "INNER JOIN `catering_tcb_rowmaterial` r ON (r.`project_id` = dtl.`project_id` AND r.`rm_id` = dtl.`dish_id`)\n" +
                    "INNER JOIN `catering_tcb_sale_rowmater` sale ON (sale.`project_id` = r.`project_id` AND r.`rm_id` = sale.`rm_id` )\n" +
                    "INNER JOIN `catecomm_tss_pubdatadict` pud ON (pud.`type_code` = r.`rm_unit`)\n" +
                    "WHERE dtl.`project_id` = "+projectId+" AND dtl.`is_delete` = 0 \n" +
                    "AND saled.`saled_dish_status` = 11803 AND dtl.`sell_point_id` = "+gzoneId+" AND is_sale_status = 1 \n" +
                    "AND dtl.`good_type` = 11004 AND sale.`is_default` = 1 AND sale.`is_delete` = 0\n" +
                    "AND price.`good_type` = 11004 AND price.`is_delete` = 0");
            if(StringUtils.isNotEmpty(str)){
                sql.add(" and r.rm_class_code in ("+str+") ");
            }
            if(StringUtils.isNotEmpty(comName)){
                sql.add(" and  (r.rm_name  like '%"+comName+"%' or r.rm_name like '%"+comName+"%' ) ");
            }
        }else if(goodType == 11001){
            //goodType为11001时，查询对应营业点下的有效可售菜品信息
            sql.add("SELECT dtl.`dish_id` AS comId,dtl.`good_type` AS goodType,dish.`dish_code` AS comCode,dish.`dish_name` AS comName,dish.`dish_unit` AS comUnit,\n" +
                    "IFNULL(pud1.`dict_tp_value`,'') AS comSpec,pud.`type_name` AS comUnitName,IFNULL(dish.`bar_code`,'') AS comBarcode,pce.dict_spec_price AS com_retail_price \n" +
                    "FROM `catering_saled_dish_detail` dtl \n" +
                    "INNER JOIN `catering_saled_dish` saled ON (dtl.`project_id` = saled.`project_id` AND dtl.`saled_dish_id`=  saled.`saled_dish_id`)\n" +
                    "INNER JOIN catering_saled_dish_detail_price pce ON (pce.`project_id` = dtl.`project_id` AND  dtl.`saled_dish_id` = pce.`saled_dish_id` AND pce.saled_dish_dtl_id = dtl.saled_dish_dtl_id AND dtl.`dish_id` = pce.dict_id)\n" +
                    "INNER JOIN `catering_tcb_dishes` dish ON (dish.`project_id` = dtl.`project_id` AND dish.`dish_id` = dtl.`dish_id`)\n" +
                    "INNER JOIN `catecomm_tss_pubdatadict` pud ON (pud.`type_code` = dish.`dish_unit`)\n" +
                    "LEFT JOIN catering_tcb_dish_spec spec ON  (spec.dish_spec_id = pce.dish_dict_spec_id AND spec.project_id = pce.`project_id` AND pce.`dict_id`=spec.`dish_id` AND spec.`is_delete` = 0 )\n" +
                    "LEFT JOIN `catecomm_tss_datadict` pud1 ON (pud1.`dict_tp_code` = spec.`spec_id` AND pud1.`project_id` = spec.`project_id`)\n" +
                    "WHERE dtl.`project_id` = "+projectId+" AND dtl.`is_delete` = 0 \n" +
                    "AND saled.`saled_dish_status` = 11803 AND dtl.`sell_point_id` = "+gzoneId+" AND dtl.is_sale_status = 1 \n" +
                    "AND dtl.`good_type` != 11004 AND pce.`good_type` != 11004 AND pce.`is_delete` = 0");
            if(StringUtils.isNotEmpty(str)){
                sql.add(" and dish.dish_class_code in ("+str+") ");
            }
            if(StringUtils.isNotEmpty(comName)){
                sql.add(" and  (dish.dish_name  like '%"+comName+"%' or dish.dish_code like '%"+comName+"%' ) ");
            }
        }
        NativeSQLBuilder builder = NativeSQLBuilder.build(TreeMap.class).setSql(sql.toString());
        builder.setPage(pageNo,pageSize);
        PagedList<TreeMap> pagedList= autoBaseDao.listPage(builder);
        if(!pagedList.getData().isEmpty() && billType ==30){
                //当促销单据类型为时段促销时，计算成本，和毛利率
                List<TreeMap> list = new ArrayList<>();
                String ids = pagedList.getData().stream().map(a->String.valueOf(a.get("comId"))).collect(Collectors.joining(","));
                if(goodType == 11005){
                        list= getComCostPrice(projectId,10,goodType,ids);
                }else{
                        list= getComCostPrice(projectId,20,goodType,ids);
                }
                for(TreeMap a :pagedList.getData()){
                    List<TreeMap> treeMaps = list.stream().filter(b ->b.get("comId").equals(a.get("comId"))).collect(Collectors.toList());
                    if(treeMaps.isEmpty()){
                        a.put("comCostPrice","0");
                    }else{
                        a.put("comCostPrice",treeMaps.get(0).get("comCostPrice"));
                    }
                }
                for(TreeMap a :pagedList.getData()){
                            BigDecimal comCostPrice = new BigDecimal(String.valueOf(a.get("comCostPrice"))).setScale(6,BigDecimal.ROUND_DOWN);
                            BigDecimal comRetailPrice = new BigDecimal(String.valueOf(a.get("comRetailPrice")));
                            if (new BigDecimal("0").compareTo(comRetailPrice) != 0) {
                                BigDecimal comInterestRate =(BigDecimal.valueOf(1).subtract(comCostPrice.divide(comRetailPrice,6,BigDecimal.ROUND_DOWN))).multiply(BigDecimal.valueOf(100));
                                a.put("comInterestRate",comInterestRate);
                                a.put("comCostPrice",comCostPrice);
                            } else {
                                a.put("comCostPrice","0");
                                a.put("comInterestRate","0");
                            }
                }
        }
        return  ModelPagedList.convertToModelPage(pagedList);
    }


    /***
     * @Author huangpeng
     * @Description //查看原材料，商品，菜品成本信息
     * @Date 16:53 2021/6/7
     * @Param
     * @return
     **/
    public List<TreeMap> getComCostPrice(Long projectId,Integer moduleId,Integer goodType,String comdId){
        String sql="";
        if(goodType == 11004 || goodType == 11005 || goodType == 11002){
            sql =  "SELECT a.comId,IF(a.taxcostprice = 0.000000000000000000 ,'0',a.taxcostprice) AS `comCostPrice`,\n" +
                    "IF(a.notaxcostprice = 0.000000000000000000 ,'0',a.notaxcostprice) AS notaxcostprice \n" +
                    "FROM  catecomm_cost AS a   \n" +
                    "INNER JOIN(\n" +
                    "SELECT project_ID,comID,good_type,MAX(dtime) AS dtime,module_id\n" +
                    "FROM catecomm_cost \n" +
                    "WHERE module_id="+moduleId+"  AND project_ID="+projectId+" \n" +
                    "GROUP BY project_ID,comID,good_type,module_id\n" +
                    ") AS b \n" +
                    "ON a.project_ID = b.project_ID \n" +
                    "AND a.comID = b.comID \n" +
                    "AND a.dtime=b.dtime\n" +
                    "AND a.good_type = b.good_type \n" +
                    "AND a.module_id = b.module_id\n" +
                    "AND a.module_id="+moduleId+"  AND a.project_ID="+projectId+"\n" +
                    "AND a.good_type ="+goodType+" ";
            if(StringUtils.isNotEmpty(comdId)){
                sql += " and a.comId in ( "+comdId+")";
            }
        }else{
            sql ="select `cost_price` AS comCostPrice,dish_id as comId " +
                 " from v_dish_costamount t8 " +
                 "where project_id = "+projectId+" \n";
            if(StringUtils.isNotEmpty(comdId)){
                sql += " and dish_id in ( "+comdId+")";
            }
        }
        NativeSQLBuilder<TaxcostpriceVo> priceQuery = NativeSQLBuilder.build(TreeMap.class);
        priceQuery.setSql(sql);
        List<TreeMap> priceList = autoBaseDao.listAll(priceQuery);
        return  priceList;
    }


    /****
     * @Author huangpeng
     * @Description //新增编辑商品，原材料，菜品满赠促销单促销单信息
     * @Date 14:30 2021/6/3
     * @Param
     * @return
     **/
    @Transactional(rollbackFor = Exception.class)
    public  String insertFreePromotionInfo(CatecommFreePromotion info, Long projectId, Long accontId) throws Exception {
        NativeSQLBuilder builderCode = NativeSQLBuilder.build(Integer.class).setSql("" +
                "select free_id from catecomm_free_promotion where project_id = "+projectId+" and free_code = '"+info.getFreeCode()+"' and is_delete = 0 ");
        Integer freeId =(Integer) autoBaseDao.findOne(builderCode);
        StringJoiner sql = new StringJoiner(";\n");
        if(freeId == null){
            //验证促销方案是否存在，存在则不进行新增
            NativeSQLBuilder builder = NativeSQLBuilder.build(String.class).setSql("" +
                    "select free_name from catecomm_free_promotion where project_id = "+projectId+" and free_name = '"+info.getFreeName()+"' and is_delete = 0 ");
            String freeName =(String) autoBaseDao.findOne(builder);
            if(StringUtils.isNotEmpty(freeName)){
                throw new Exception(CatecommFreeEnum.Free_NAME.getMessage());
            }
            freeId = supplierService.getTableId(projectId,"catecomm_free_promotion",1);
            //freeId为空就新增
            sql.add("insert into catecomm_free_promotion (free_id,free_code,project_id,project_root_id,free_name,free_grade,free_start_day,free_end_day,free_cycle," +
                    "free_type,free_amount,free_rule_type,free_rule_num,free_rule_optional_num,gzone_id,good_type,free_status,created_time,creater,updated_time,modifier)" +
                    "value ("+freeId+",'"+info.getFreeCode()+"',"+projectId+","+projectId+",'"+info.getFreeName()+"',"+info.getFreeGrade()+",'"+info.getFreeStartDayStr()+"','"+info.getFreeEndDayStr()+"','"+info.getFreeCycle()+"'," +
                    ""+info.getFreeType()+","+info.getFreeAmount()+","+info.getFreeRuleType()+","+info.getFreeRuleNum()+","+info.getFreeRuleOptionalNum()+","+info.getGzoneId()+","+info.getGoodType()+","+info.getFreeStatus()+"," +
                    "NOW(),"+accontId+",NOW(),"+accontId+") ");
        }else{
            //freeId不为空就为修改
            sql.add("update catecomm_free_promotion set " +
                    " free_grade ="+info.getFreeGrade()+" ,free_start_day = '"+info.getFreeStartDayStr()+"' ,free_end_day ='"+info.getFreeEndDayStr()+"' ,free_cycle = '"+info.getFreeCycle()+"' ," +
                    " free_type = "+info.getFreeType()+" ,free_amount = "+info.getFreeAmount()+",free_rule_type = "+info.getFreeRuleType()+" ,free_rule_num = "+info.getFreeRuleNum()+"," +
                    " free_rule_optional_num = "+info.getFreeRuleOptionalNum()+",updated_time = NOW(),modifier ="+accontId+",sync_status = 10 ,free_status = "+info.getFreeStatus()+" " +
                    " where project_id = "+projectId+" and free_id = "+freeId+" ");
            sql.add(" delete from catecomm_free_promotion_dtl where project_id = "+projectId+" and free_id = "+freeId+" ");
            sql.add(" delete from catecomm_free_promotion_rule where project_id = "+projectId+" and free_id = "+freeId+" ");
        }
        //新增促销详情表
        List<Integer> dtlIds = supplierService.getTableIds(projectId,"catecomm_free_promotion_dtl",info.getDtlList().size());
        Integer index = 0;
        for (CatecommFreePromotionDtl item:info.getDtlList()){
            sql.add("insert into catecomm_free_promotion_dtl (project_id,project_root_id,free_id,free_dtl_id,com_id,com_code,com_unit," +
                    "com_spec,com_barcode,com_retail_price,com_name,good_type,created_time,updated_time,creater,modifier) " +
                    "value ("+projectId+","+projectId+","+freeId+","+dtlIds.get(index++)+","+item.getComId()+",'"+item.getComCode()+"',"+item.getComUnit()+"," +
                    "'"+item.getComSpec()+"','"+item.getComBarcode()+"',"+item.getComRetailPrice()+",'"+item.getComName()+"',"+item.getGoodType()+",NOW(),NOW(),"+accontId+","+accontId+") ");
        }
        //新增促销规则详情表
        List<Integer> ruleIds = supplierService.getTableIds(projectId,"catecomm_free_promotion_rule",info.getRuleList().size());
        index =0;
        for (CatecommFreePromotionRule item:info.getRuleList()){
            sql.add("insert into catecomm_free_promotion_rule (project_id,project_root_id,free_id,free_rule_id,com_id,com_code,com_unit," +
                    "com_spec,com_barcode,com_retail_price,com_name,give_num,good_type,created_time,updated_time,creater,modifier) " +
                    "value ("+projectId+","+projectId+","+freeId+","+ruleIds.get(index++)+","+item.getComId()+",'"+item.getComCode()+"',"+item.getComUnit()+"," +
                    "'"+item.getComSpec()+"','"+item.getComBarcode()+"',"+item.getComRetailPrice()+",'"+item.getComName()+"',"+item.getGiveNum()+","+item.getGoodType()+",NOW(),NOW(),"+accontId+","+accontId+") ");
        }
        NativeSQLBuilder updateSql = NativeSQLBuilder.build(Integer.class).setSql(sql.toString());
        autoBaseDao.nativeExecute(updateSql);
        if(info.getFreeStatus() == CatecommFreeEnum.Free_NEW.getStauts()){
            return CatecommFreeEnum.Free_NEW.getMessage();
        }else {
            return CatecommFreeEnum.Free_DAI.getMessage();
        }
    }

    /***
     * @Author huangpeng
     * @Description //根据促销单id查询对应促销单的信息
     * @Date 16:39 2021/6/3
     * @Param
     * @return
     **/
    public TreeMap getFreePromotionInfo(Integer freeId,Long projectId){
        //查询促销主表信息
        NativeSQLBuilder builder = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                "SELECT \n" +
                "free.`good_type`,free.`free_code`,free.`free_name`,free.`free_id`,g.`gzone_name`,\n" +
                "free.`free_amount`,free.`free_cycle`,free.`free_end_day`,free.`free_grade`,free.`free_rule_num`,free.`free_rule_optional_num`,\n" +
                "free.`free_rule_type`,free.`free_start_day`,free.`free_type`,free.`gzone_id`,pub.`type_name` AS freeStatusName\n" +
                "FROM `catecomm_free_promotion` free\n" +
                "INNER JOIN `catecomm_tsb_gzone` g ON (g.`project_id` = free.`project_id` AND g.`gzone_id` = free.`gzone_id`)\n" +
                "INNER JOIN `catecomm_tss_pubdatadict` pub ON (pub.`type_code` = free.`free_status`)\n" +
                "where free.project_id = "+projectId+" and free.free_id = "+freeId+"");
        TreeMap info =(TreeMap) autoBaseDao.findOne(builder);

       //查询促销详情表信息
        NativeSQLBuilder builder1 = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                "SELECT \n" +
                "dtl.`com_id`,dtl.`com_code`,dtl.`com_name`,dtl.`com_barcode`,dtl.`com_retail_price`,\n" +
                "dtl.`com_unit`,dtl.`com_spec`,pub.`type_name` AS comUnitName,dtl.`good_type`\n" +
                "FROM `catecomm_free_promotion_dtl` dtl\n" +
                "INNER JOIN `catecomm_tss_pubdatadict` pub ON (pub.`type_code` = dtl.`com_unit`)\n" +
                "where dtl.project_id = "+projectId+" and dtl.free_id = "+freeId+" and dtl.is_delete = 0 ");
        List<TreeMap> dtlList = autoBaseDao.listAll(builder1);
        info.put("dtlList",dtlList);

        //查询促销规则详情表信息
        NativeSQLBuilder builder2 = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                "SELECT \n" +
                "rule.`com_id`,rule.`com_code`,rule.`com_name`,rule.`com_barcode`,rule.`com_retail_price`,\n" +
                "rule.`com_unit`,rule.`com_spec`,pub.`type_name` AS comUnitName,rule.`good_type`,rule.`give_num`\n" +
                "FROM `catecomm_free_promotion_rule` rule\n" +
                "INNER JOIN `catecomm_tss_pubdatadict` pub ON (pub.`type_code` = rule.`com_unit`) \n" +
                "where rule.project_id = "+projectId+" and rule.free_id = "+freeId+" and rule.is_delete = 0 ");
        List<TreeMap>  ruleList= autoBaseDao.listAll(builder2);
        info.put("ruleList",ruleList);

        //查询促销单对应的审核详情
        NativeSQLBuilder builder3 = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                " SELECT \n" +
                " emp.`bl_time`,emp.`free_id`,emp.`free_status`,a.`nick_name`,pub.`type_name` AS freeStatusName,emp.`free_remark`\n" +
                " FROM `catecomm_free_bl_emp` emp\n" +
                " INNER  JOIN account  a ON (a.id= emp.bl_emp_id ) \n" +
                " INNER JOIN `catecomm_tss_pubdatadict` pub ON (pub.`type_code` = emp.`free_status`)\n" +
                " WHERE emp.`project_id` = "+projectId+" AND emp.`free_id` = "+freeId+" AND emp.`free_type` = 10 \n" +
                " ORDER BY emp.`created_time` DESC ");
        List<TreeMap>  blEmps= autoBaseDao.listAll(builder3);
        info.put("blEmps",blEmps);
        return  info;
    }


    /****
     * @Author huangpeng
     * @Description //修改促销单各种状态
     * @Date 9:46 2021/6/4
     * @Param
     * @return
     **/
    @Transactional(rollbackFor = Exception.class)
    public String updateFreePromotionStatus(Integer freeId,Integer status,String freeStartDay,String freeEndDay,String freeRemark,Long projectId,Long accountId) throws Exception {
        Date end = verificationDate(freeEndDay,"yyyy-MM-dd");
        //当状态为审核通过状态时判断审核时间是否大于促销单结束时期，如果大于，则不能审核通过。
        if(status.equals(CatecommFreeEnum.Free_GO.getStauts())){
            if(end.before(dateNow(new Date()))){
                throw  new Exception(CatecommFreeEnum.Free_ERRO.getMessage());
            }
        }
        String message = "";
        StringJoiner sql = new StringJoiner(" \n");
        sql.add(" update catecomm_free_promotion set updated_time = NOW(), modifier ="+accountId+",sync_status = 10 ");
        if(!status.equals(CatecommFreeEnum.Free_DELETE.getStauts())){
            sql.add(" ,bl_time = NOW() ,bl_emp_id ="+accountId+" ");
            //审核状态不为删除时
            Date date = verificationDate(freeStartDay,"yyyy-MM-dd");
            if(CatecommFreeEnum.Free_GO.getStauts().equals(status)){
                //审核状态为审核通过时
                if(date.before(dateNow(new Date())) || date.equals(dateNow(new Date()))){
                    sql.add(" ,free_start_day = NOW() ,free_status = "+CatecommFreeEnum.Free_INVALID.getStauts()+" ");
                }else{
                    sql.add(" ,free_status = "+CatecommFreeEnum.Free_REJECT.getStauts()+" ");
                }
            }else{
                sql.add(" ,free_status = "+status+" ");
            }
        }else{
            //审核状态为删除时
            message =  CatecommFreeEnum.Free_DELETE.getMessage();
            sql.add(" ,is_delete = "+status+" ");
        }
        sql.add(" where free_id = "+freeId+" and project_id = "+projectId+" and is_delete = 0 ");
        if(status.equals(CatecommFreeEnum.Free_EFFECTIVE.getStauts())
        || status.equals(CatecommFreeEnum.Free_GO.getStauts())){
            //状态为审核通过和审核驳回时
             sql.add( " and free_status = "+CatecommFreeEnum.Free_DAI.getStauts()+" ");
             if(status.equals(CatecommFreeEnum.Free_GO.getStauts())){
                 //状态为审核通过时
                 message = CatecommFreeEnum.Free_GO.getMessage();
             }else{
                 message = CatecommFreeEnum.Free_EFFECTIVE.getMessage();
             }
        }
        if(status.equals(CatecommFreeEnum.Free_VOIDER.getStauts())){
            message =  CatecommFreeEnum.Free_VOIDER.getMessage();
            //审核状态为终止时
            sql.add( " and ( free_status = "+CatecommFreeEnum.Free_REJECT.getStauts()+"" +
                    " || free_status = "+CatecommFreeEnum.Free_INVALID.getStauts()+" ) ");
        }
        NativeSQLBuilder updateSql = NativeSQLBuilder.build(Integer.class).setSql(sql.toString());
        int shu = autoBaseDao.nativeExecute(updateSql);
        if(shu < 1){
            throw  new Exception(CatecommFreeEnum.Free_NO.getMessage());
        }
        if(status.equals(CatecommFreeEnum.Free_DELETE.getStauts())){
            //审核状态为删除时
            NativeSQLBuilder delete = NativeSQLBuilder.build(Integer.class).setSql("" +
                    "update  catecomm_free_promotion_dtl set is_delete = 0 where project_id = "+projectId+" and free_id = "+freeId+" ;" +
                    "update  catecomm_free_promotion_rule set is_delete = 0  where project_id = "+projectId+" and free_id = "+freeId+" ;");
            autoBaseDao.nativeExecute(delete);
        }else{
            //审核状态不为删除时
            Integer empId = supplierService.getTableId(projectId,"catecomm_free_bl_emp",1);
            NativeSQLBuilder insert = NativeSQLBuilder.build(Integer.class).setSql("" +
                    "insert into catecomm_free_bl_emp (project_id,project_root_id,emp_id,free_id,bl_emp_id,bl_time,free_status," +
                    "free_remark,free_type,created_time,updated_time)" +
                    "value ("+projectId+","+projectId+","+empId+","+freeId+","+accountId+",NOW(),"+status+"," +
                    "'"+freeRemark+"',10,NOW(),NOW()) ");
            autoBaseDao.nativeExecute(insert);
        }
        return  message;
    }


    /***
     * @Author huangpeng
     * @Description //查询促销单营业点信息
     * @Date 14:31 2021/6/4
     * @Param
     * @return
     **/
    public  ModelPagedList getFreePromotionGzoneInfo(String codeAndName,Integer goodType,Long projectId,Integer pageNo,Integer pageSize){
        StringJoiner sql=new StringJoiner("\n");

        if(goodType == 11005){
            //按商品方式查
            sql.add("SELECT g.`gzone_name`,g.`gzone_code`,g.`gzone_id`\n" +
                 "FROM `commodity_saled_pda_com` p \n" +
                 "INNER JOIN `catecomm_tsb_gzone` g ON (g.`project_id` = p.`project_id` AND  p.`gzone_id`=g.`gzone_id`)\n" +
                 "WHERE p.`project_id` = "+projectId+" AND p.`is_delete` = 0 \n" +
                 "AND p.`saled_dish_status` = 15603 ");
        }else if(goodType == 11004){
            //按原材料方式查
            sql.add("SELECT g.`gzone_id`,g.`gzone_name`,g.`gzone_code`\n" +
                    "FROM `catering_saled_dish_detail` dtl \n" +
                    "INNER JOIN `catering_saled_dish` saled ON (dtl.`project_id` = saled.`project_id` AND dtl.`saled_dish_id`=  saled.`saled_dish_id`)\n" +
                    "INNER JOIN `catecomm_tsb_gzone` g ON (g.`project_id` = dtl.`project_id` AND g.`gzone_id` = dtl.`sell_point_id`)\n" +
                    "WHERE dtl.`project_id` = "+projectId+" AND dtl.`is_delete` = 0 AND dtl.is_sale_status = 1   AND dtl.`good_type` = 11004 \n" +
                    "AND saled.`saled_dish_status` = 11803 AND saled.`is_delete` = 0\n");
        }else {
            //按菜品查
            sql.add("SELECT g.`gzone_id`,g.`gzone_name`,g.`gzone_code`\n" +
                    "FROM `catering_saled_dish_detail` dtl \n" +
                    "INNER JOIN `catering_saled_dish` saled ON (dtl.`project_id` = saled.`project_id` AND dtl.`saled_dish_id`=  saled.`saled_dish_id`)\n" +
                    "INNER JOIN `catecomm_tsb_gzone` g ON (g.`project_id` = dtl.`project_id` AND g.`gzone_id` = dtl.`sell_point_id`)\n" +
                    "WHERE dtl.`project_id` = "+projectId+" AND dtl.`is_delete` = 0 AND dtl.is_sale_status = 1   AND dtl.`good_type` != 11004 \n" +
                    "AND saled.`saled_dish_status` = 11803 AND saled.`is_delete` = 0\n");
        }
        if(StringUtils.isNotEmpty(codeAndName)){
            sql.add(" and ( g.gzone_name like '%"+codeAndName+"%' || g.`gzone_code` like '%"+codeAndName+"%' )");
        }
        if(goodType == 11004 || goodType == 11001){
            sql.add("GROUP BY dtl.sell_point_id ");
        }
        NativeSQLBuilder builder = NativeSQLBuilder.build(TreeMap.class).setSql(sql.toString());
        builder.setPage(pageNo,pageSize);
        PagedList<TreeMap> pagedList= autoBaseDao.listPage(builder);
        return  ModelPagedList.convertToModelPage(pagedList);
    }




    /****
     * @Author huangpeng
     * @Description //查询对应分类编码下的所有子分类
     * @Date 14:28 2021/6/3
     * @Param
     * @return
     **/
    private void getCalssCode(Integer goodType,String classCode,Long projectId,List<TreeMap> list){
        String sql = "";
        if(goodType == 11005){
            //为商品时查询商品分类
            sql = "SELECT\n" +
                    "com_class_code as classCode \n" +
                    "FROM commodity_tcc_comclass \n" +
                    "WHERE is_delete = 0 AND project_id = "+projectId+" AND ucom_class_code IN ("+classCode+")";
        }else if(goodType == 11004){
            //为原材料时查询原材料分类
            sql = "SELECT\n" +
                    "rmc_code AS classCode \n" +
                    "FROM `catering_tcc_rawmater_class` \n" +
                    "WHERE is_delete = 0 AND project_id = "+projectId+" AND urmc_code IN ("+classCode+")";
        }else if(goodType == 11001){
            //为菜品时查询菜品分类
            sql = "SELECT\n" +
                    "dish_class_code AS classCode \n" +
                    "FROM `catering_tcc_dishes_class` \n" +
                    "WHERE is_delete = 0 AND project_id = "+projectId+" AND udish_class_code IN ("+classCode+")";
        }
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(TreeMap.class).setSql(sql);
        List<TreeMap> treeMaps = autoBaseDao.listAll(nativeSQLBuilder);
        for (TreeMap treeMap:treeMaps
             ) {
            list.add(treeMap);
            getCalssCode(goodType,String.valueOf(treeMap.get("classCode")),projectId,list);
        }
    }


    /****
     * @Author huangpeng
     * @Description //满赠，时段，满减促销定时任务修改促销单的状态定时任务方法
     * @Date 10:55 2021/6/8
     * @Param
     * @return
     **/
    @Transactional(rollbackFor = Exception.class)
    public  String preePromotionJob(){

        //查询满赠，时段，满减促销定时任务修改促销单的状态为未开始，进行中的促销单信息
        NativeSQLBuilder builder = NativeSQLBuilder.build(TreeMap.class).setSql("" +
                "SELECT project_id,'10' AS billType,free_id,free_start_day,free_end_day,free_status FROM `catecomm_free_promotion` \n" +
                "WHERE free_status IN (177004,177005)\n" +
                "UNION ALL\n" +
                "SELECT project_id,'20' AS billType,free_id,free_start_day,free_end_day,free_status FROM `catecomm_free_reduction` \n" +
                "WHERE free_status IN (177004,177005)\n" +
                "UNION ALL\n" +
                "SELECT project_id,'30' AS billType,free_id,free_start_day,free_end_day,free_status FROM `catecomm_period_promotion`\n" +
                "WHERE free_status IN (177004,177005)");
        List<TreeMap> list = autoBaseDao.listAll(builder);
        StringJoiner sql = new StringJoiner(" ;\n");
        //获取当前时间
        Date date = dateNow(new Date());
        for (TreeMap treeMap: list){
            Integer freeStatus = (Integer) treeMap.get("freeStatus");
            Integer billType = Integer.valueOf(treeMap.get("billType").toString());
            Date freeStartDay =(Date) treeMap.get("freeStartDay");
            Date freeEndDay =(Date) treeMap.get("freeEndDay");
            Long projectId =(Long) treeMap.get("projectId");
            Integer freeId = (Integer) treeMap.get("freeId");
            String table="";
            if(billType == 10){
                table = "catecomm_free_promotion";
            }else if(billType == 20){
                table = "catecomm_free_reduction";
            }else{
                table = "catecomm_period_promotion";
            }
            //当单据状态为未进行时
            if(freeStatus == 177004){
                if(freeStartDay.equals(date)){
                    sql.add("update "+table+" set " +
                            " free_status = "+CatecommFreeEnum.Free_INVALID.getStauts()+" ,sync_status = 10 " +
                            " where project_id = "+projectId+" and free_id = "+freeId+" " +
                            " and free_status = "+freeStatus+"");
                }
            }
            //当单据状态为进行中时
            if(freeStatus == 177005){
                if(date.after(freeEndDay)){
                    sql.add("update "+table+" set " +
                            " free_status = "+CatecommFreeEnum.Free_BEEFFECTIVE.getStauts()+" ,sync_status = 10 " +
                            " where project_id = "+projectId+" and free_id = "+freeId+" " +
                            " and free_status = "+freeStatus+"");
                }
            }
        }
        String str = String.valueOf(sql);
        if(StringUtils.isNotEmpty(str)){
            NativeSQLBuilder update = NativeSQLBuilder.build(Integer.class).setSql(str);
            autoBaseDao.nativeExecute(update);
            return CatecommFreeEnum.Free_JOB_MESSAGE.getMessage();
        }else{
            return CatecommFreeEnum.Free_NO.getMessage();
        }
    }

    @Override
    public String isMarketing(Long projectId, String comIds, int goodType, Integer gzoneId) {
        //满赠促销（排除掉已终止、已结束的）
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CatecommFreePromotionRule.class)
                .setSql("select t1.* from catecomm_free_promotion_rule t1\n" +
                        "LEFT JOIN catecomm_free_promotion t2 ON t2.project_id = t1.project_id AND t2.free_id = t1.free_id\n" +
                        "where t1.project_id = " + projectId + " AND t1.is_delete = 0 AND t2.free_status NOT IN(177006,177007) AND t2.is_delete = 0\n " +
                        "AND t1.good_type =  " + goodType + " AND t1.com_id IN (" + comIds + ")");
        sqlBuilder.append(null != gzoneId ? " AND t2.gzone_id = " + gzoneId : "");
        List<CatecommFreePromotionRule> freePromotionRules = autoBaseDao.listAll(sqlBuilder);
        if (null != freePromotionRules && freePromotionRules.size() > 0) {
            List<String> comNameList = freePromotionRules.stream().map(c -> {return c.getComName();}).collect(Collectors.toList());
            comNameList = comNameList.stream().distinct().collect(Collectors.toList());
            String comName = StringUtils.join(comNameList, ',');
            return comName + "，已设置满赠促销赠送，确定要下架吗？";
        }

        NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(CatecommFreePromotionDtl.class)
                .setSql("select t1.* from catecomm_free_promotion_dtl t1\n " +
                        "LEFT JOIN catecomm_free_promotion t2 ON t2.project_id = t1.project_id AND t2.free_id = t1.free_id\n" +
                        "where t1.project_id = " + projectId + " AND t1.is_delete = 0 AND t2.free_status NOT IN(177006,177007) AND t2.is_delete = 0\n " +
                        "AND t1.good_type =  " + goodType + " AND t1.com_id IN (" + comIds + ")");
        sqlBuilder.append(null != gzoneId ? " AND t2.gzone_id = " + gzoneId : "");
        List<CatecommFreePromotionDtl> freePromotionDtls = autoBaseDao.listAll(sqlBuilder1);
        if (null != freePromotionDtls && freePromotionDtls.size() > 0) {
            List<String> comNameList = freePromotionDtls.stream().map(c -> {return c.getComName();}).collect(Collectors.toList());
            comNameList = comNameList.stream().distinct().collect(Collectors.toList());
            String comName = StringUtils.join(comNameList, ',');
            return comName + "，已设置满赠促销，确定要下架吗？";
        }

        //时段促销
        NativeSQLBuilder sqlBuilder2 = NativeSQLBuilder.build(CatecommPeriodPromotionDtl.class)
                .setSql("select t1.* from catecomm_period_promotion_dtl t1\n" +
                        "LEFT JOIN catecomm_period_promotion t2 ON t2.project_id = t1.project_id AND t2.free_id = t1.free_id\n" +
                        "where t1.project_id = " + projectId + " AND t1.is_delete = 0 AND t2.free_status NOT IN(177006,177007) AND t2.is_delete = 0\n " +
                        "AND t1.good_type =  " + goodType + " AND t1.com_id IN (" + comIds + ")");
        sqlBuilder.append(null != gzoneId ? " AND t2.gzone_id = " + gzoneId : "");
        List<CatecommPeriodPromotionDtl> periodPromotionDtls = autoBaseDao.listAll(sqlBuilder2);
        if (null != periodPromotionDtls && periodPromotionDtls.size() > 0) {
            List<String> comNameList = periodPromotionDtls.stream().map(c -> {return c.getComName();}).collect(Collectors.toList());
            comNameList = comNameList.stream().distinct().collect(Collectors.toList());
            String comName = StringUtils.join(comNameList, ',');
            return comName + "，已设置时段促销，确定要下架吗？";
        }
        
        //满减促销
        NativeSQLBuilder sqlBuilder4 = NativeSQLBuilder.build(CatecommFreeReductionDtl.class)
                .setSql("select t1.* from catecomm_free_reduction_dtl t1\n" +
                        "LEFT JOIN catecomm_free_reduction t2 ON t2.project_id = t1.project_id AND t2.free_id = t1.free_id\n" +
                        "where t1.project_id = " + projectId + " AND t1.is_delete = 0 AND t2.free_status NOT IN(177006,177007) AND t2.is_delete = 0\n " +
                        "AND t1.good_type =  " + goodType + " and t1.com_id IN (" + comIds + ")");
        sqlBuilder.append(null != gzoneId ? " AND t2.gzone_id = " + gzoneId : "");
        List<CatecommFreeReductionDtl> freeReductionDtls = autoBaseDao.listAll(sqlBuilder4);
        if (null != freeReductionDtls && freeReductionDtls.size() > 0) {
            List<String> comNameList = freeReductionDtls.stream().map(c -> {return c.getComName();}).collect(Collectors.toList());
            comNameList = comNameList.stream().distinct().collect(Collectors.toList());
            String comName = StringUtils.join(comNameList, ',');
            return comName + "，已设置满减促销，确定要下架吗？";
        }
        return null;
    }


    private Date verificationDate(String date,String formats){
        try {
            SimpleDateFormat format = new SimpleDateFormat(formats);
            format.setLenient(false);
            return format.parse(date);
        }catch (Exception e){
            return  null;
        }
    }
    private Date dateNow(Date date){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            String str = format.format(date);
            return format.parse(str);
        }catch (Exception e){
            return  null;
        }
    }
}
