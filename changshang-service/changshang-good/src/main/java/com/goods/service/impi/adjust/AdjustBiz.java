package com.goods.service.impi.adjust;

import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.rawmater.CaterAdjustFeign;
import com.goods.service.adjust.AdjustApi;
import com.goods.service.adjust.SaleadjustApi;

import entity.ModelPagedList;
import excel.Excel;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.model.contract.CommodityContract;
import modelpojo.vo.CommoAdjustVo;
import modelpojo.vo.CommodityTcjAdjustDetailVo;
import modelpojo.vo.CommodityTcjAdjustVo;
import modelpojo.vo.PhTaxVo;
import modelpojo.vo.caterAdjust.PriceChangeVo;
import modelpojo.vo.caterAdjust.PriceRetrunVo;
import modelpojo.vo.commodityinfo.CommodityAdjustExeclVo;
import modelpojo.vo.saleadjust.CommodityVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.lufei.ibatis.builder.InsertBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @Description 进价调价业务层
 * @Author wenbin.wang
 * @Date 2019-08-23 16:56
 */
@Service
public class AdjustBiz implements AdjustApi {
    private static final Logger log = LoggerFactory.getLogger(AdjustBiz.class);


    AutoBaseDao autoBaseDao = new AutoDaoImpl();

    @Autowired
    SupplierServiceFeign supplierService;

    @Autowired
    CaterAdjustFeign caterTcjAdjustApi;

    @Autowired
    SaleadjustApi saleadjustApi;


    /**
     *@Description 进价调价维护列表查询
     *@param    commodityTcjAdjust
     *@return ModelPagedList<CommodityTcjAdjustAdjust>
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    public ModelPagedList<CommodityTcjAdjust> adjustList(CommodityTcjAdjust commodityTcjAdjust, Long projectId, String comName) {
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql("select t1.adj_id,t1.adj_code,t1.adj_type,t1.start_date,t1.end_date,t1.remark,t1.description,t1.created_time,t1.creater,t1.adj_status,\n" +
                        "\t (select t2.type_name from catecomm_tss_pubdatadict t2  where t2.type_code = t1.adj_type) as adjTypeStr,\n" +
                        "\t (select t3.nick_name from account t3 where t1.creater = t3.id) as createrStr\n "+
                        "\t from commodity_tcj_adjust t1 \n" +
                        "INNER JOIN commodity_tcj_adjust_detail t2 ON t2.adj_id = t1.adj_id AND t2.project_id = t1.project_id\n" +
                        "\t INNER JOIN commodity_tcb_com t3 ON t3.com_id = t2.com_id  AND t3.project_id = t1.project_id\n" +
                        "WHERE t1.project_id = " + projectId + " and t1.is_delete = 0");
        nativeSQLBuilder.setValue("projectId", projectId);
        if (StringUtils.isNotBlank(comName)) {
            nativeSQLBuilder.append("and t3.com_name like '%" + comName + "%' \n");
        }
        nativeSQLBuilder.append(StringUtils.isNotBlank(commodityTcjAdjust.getAdjCode()) ? ("and t1.adj_code like\n" + "'%" + (commodityTcjAdjust.getAdjCode()) + "%'\n") : "");
        nativeSQLBuilder.append(commodityTcjAdjust.getAdjStatus() != null ? ("and t1.adj_status =\n" + "'" + (commodityTcjAdjust.getAdjStatus()) + "'\n") : "");
        nativeSQLBuilder.append(" GROUP BY t1.adj_id \n");
        nativeSQLBuilder.append("order by t1.created_time desc");
        nativeSQLBuilder.setPage(commodityTcjAdjust.getPageNo(), commodityTcjAdjust.getPageSize());
        PagedList<CommodityTcjAdjust> commodityTcjAdjustModels = autoBaseDao.listPage(nativeSQLBuilder);
        ModelPagedList modelPagedList = ModelPagedList.convertToModelPage(commodityTcjAdjustModels);
        return modelPagedList;
    }

    /**
     *@Description 查看调价单信息
     *@param adjCode   adjStatus  projectId
     *@return CommodityTcjAdjustAdjustVo
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    public CommodityTcjAdjustVo getAdjustInfo(String adjCode, Long projectId, Long projectRootId) {
        NativeSQLBuilder<CommodityTcjAdjust> query = NativeSQLBuilder.build(CommodityTcjAdjust.class);
        query.setSql("select t1.*,(select t5.type_name from catecomm_tss_pubdatadict t5 where t1.adj_type = t5.type_code)  as adjTypeName from commodity_tcj_adjust t1 where t1.is_delete = 0 and t1.adj_code = #{adjCode} and t1.project_id = #{projectId}");
        query.setValue("adjCode", adjCode);
        query.setValue("projectId", projectId);
        CommodityTcjAdjust commodityTcjAdjust = (CommodityTcjAdjust)autoBaseDao.findOne(query);
        NativeSQLBuilder<CommodityTcjAdjustDetailVo> adjustDetailBuilder = NativeSQLBuilder.build(CommodityTcjAdjustDetailVo.class);
        adjustDetailBuilder.setSql("select t2.*,t1.com_name,t1.com_code,t1.ph_tax,t1.ph_tax_id,t3.supp_name,(select t5.type_name from catecomm_tss_pubdatadict t5 where t2.bus_mode = t5.type_code) as busModeName," +
                "\t(select t5.tax_name from catecomm_tsb_tax t5 where t6.ph_tax_id = t5.tax_id and t1.project_id = t5.project_id) as taxName, sale.pack_content\n " +
                "from commodity_tcj_adjust_detail t2 \n" +
                "INNER join commodity_tcb_com t1 on t2.com_id = t1.com_id and t1.project_id = t2.project_id " +
                "LEFT JOIN  commodity_tcb_suppcom t6 ON t6.com_id = t1.com_id and t6.project_id = t1.project_id AND t6.supp_id = t2.supplier_id\n" +
                "LEFT JOIN commodity_tcb_salecom sale ON sale.project_id = t1.project_id AND sale.com_id = t1.com_id AND sale.is_pur_chase_unit = 1\n" +
                "INNER join commodity_tcb_supplier t3 on t2.supplier_id = t3.supp_id and t2.project_id = t3.project_id\n" +
                "\tand  t2.is_delete = 0 and t2.adj_code = #{adjCode} and t2.project_id = #{projectId}");
        adjustDetailBuilder.setValue("adjCode", adjCode);
        adjustDetailBuilder.setValue("projectId", projectId);
        List<CommodityTcjAdjustDetailVo> adjustDetailList = autoBaseDao.listAll(adjustDetailBuilder);
        BigDecimal one = new BigDecimal(1);

        adjustDetailList.forEach(a->{
            NativeSQLBuilder<CommodityTcbGradeprice> gradepriceBuilder = NativeSQLBuilder.build(CommodityTcbGradeprice.class);
            gradepriceBuilder.setSql("select t1.retail_price from commodity_tcb_gradeprice t1 where  t1.is_delete = 0 and t1.com_id = #{comId}  and t1.project_id=#{projectId}");
            gradepriceBuilder.setValue("comId", a.getComId());
            gradepriceBuilder.setValue("projectId", projectId);
            List<CommodityTcbGradeprice> list = autoBaseDao.listAll(gradepriceBuilder);
            List<BigDecimal> tempList = new ArrayList<BigDecimal>();
            list.forEach(c->{
                tempList.add(c.getRetailPrice());
            });
            List<CatecommTsbTax> tsbTaxInfo = getTsbTaxInfo(a.getTaxId(),null,projectId, projectRootId);

            BigDecimal max = BigDecimal.ZERO;
            BigDecimal min = BigDecimal.ZERO;
            if (CollectionUtils.isNotEmpty(tempList)) {
                if (tempList.size() == 1) {
                    max = Collections.max(tempList);
                }else{
                    max = Collections.max(tempList);
                    min = Collections.min(tempList);
                }
                BigDecimal maxDecimal = BigDecimal.ZERO;
                BigDecimal minDivide = BigDecimal.ZERO;
                String maxGrossInterestRate = "";
                String minGrossInterestRate = "";
                NumberFormat percent = NumberFormat.getPercentInstance();
                if (max.compareTo(BigDecimal.ZERO) > 0 ) {
                    maxDecimal = (one.subtract(a.getOTaxPriceIn().divide(max, tsbTaxInfo.get(0).getConToFreeNum(),RoundingMode.HALF_UP)));
                    maxGrossInterestRate = percent.format(maxDecimal.doubleValue());

                }
                if (min.compareTo(BigDecimal.ZERO) > 0) {
                    minDivide = (one.subtract(a.getOTaxPriceIn().divide(min, tsbTaxInfo.get(0).getConToFreeNum(), RoundingMode.HALF_UP)));
                    minGrossInterestRate = percent.format(minDivide.doubleValue());
                }

                BigDecimal newMaxDivide = BigDecimal.ZERO;
                String newMaxGrossInterestRate = "";
                String newMinGrossInterestRate = "";
                BigDecimal newMinDivide = BigDecimal.ZERO;
                if (a.getNewTaxPriceIn() != null) {
                    if (max.compareTo(BigDecimal.ZERO) > 0 ) {
                        newMaxDivide = (one.subtract(a.getNewTaxPriceIn().divide(max, tsbTaxInfo.get(0).getConToFreeNum(), RoundingMode.HALF_UP)));
                        newMaxGrossInterestRate = percent.format(newMaxDivide.doubleValue());  //新含税进价最高毛利率
                    }
                    if (min.compareTo(BigDecimal.ZERO) > 0) {
                        newMinDivide = (one.subtract(a.getNewTaxPriceIn().divide(min, tsbTaxInfo.get(0).getConToFreeNum(), RoundingMode.HALF_UP)));
                        newMinGrossInterestRate = percent.format(newMinDivide.doubleValue());  // 新含税进价最低毛利率
                    }
                }
                a.setNewMaxGrossInterestRate(newMaxGrossInterestRate);
                a.setNewMinGrossInterestRate(newMinGrossInterestRate);
                a.setMaxRetailPrice(max);
                a.setMinRetailPrice(min);
                a.setMaxGrossInterestRate(maxGrossInterestRate);
                a.setMinGrossInterestRate(minGrossInterestRate);

            }

        });
        CommodityTcjAdjustVo commodityTcbComVo = new CommodityTcjAdjustVo();
        commodityTcbComVo.setCommodityTcjAdjust(commodityTcjAdjust);
        commodityTcbComVo.setCommodityTcjAdjustdetailVos(adjustDetailList);
        return commodityTcbComVo;
    }

    /**
     *@Description 删除调价单维护列表信息
     *@param adjId   adjStatus  projectId
     *@return int
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    public int delAdjust(Integer adjId, Long projectId) {
        Integer update=0;
        try {
            UpdateBuilder builder=UpdateBuilder.build(CommodityTcjAdjust.class).set("isDelete",1).whereEq("projectId",projectId)
                    .whereEq("adjId",adjId);
            update=autoBaseDao.update(builder);
            if(update>0){
                UpdateBuilder builder1=UpdateBuilder.build(CommodityTcjAdjustDetail.class).set("isDelete",1).whereEq("projectId",projectId).whereEq("adjId",adjId);
                update+=autoBaseDao.update(builder1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  update;
    }



    /**
     *@Description 调价单审核
     *@param  adjStatus  projectId
     *@return void
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void toExamineAdjust(String adjId, Integer adjStatus, Long projectId,Long userId) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date toExamineDate = new Date();
        long toExamineTime = toExamineDate.getTime();
        String[] adjIds=adjId.split(",");


        /*审核时间在起止范围内不允许审核，返回错误*/
//        List<String> errorList = new ArrayList<String>();
//        for (int i = 0; i < adjIds.length; i++) {
//            NativeSQLBuilder select = NativeSQLBuilder.build(CommodityTcjAdjust.class)
//                    .setSql("select * from commodity_tcj_adjust where is_delete=0 and project_id = " + projectId + " and adj_id= " + adjIds[i] + "");
//
//            CommodityTcjAdjust adjustModel = (CommodityTcjAdjust) autoBaseDao.findOne(select);
//            Date endDate = adjustModel.getEndDate();
//            Date startDate = adjustModel.getStartDate();
//            if (adjStatus == AdjustStatus.ADJUST_STATUS_AUDIT){
//                if (toExamineDate.compareTo(endDate) < 0) {
//                    errorList.add(adjustModel.getAdjCode());
//                }
//                if (endDate != null) {
//                    if (toExamineDate.compareTo(startDate) > 0 && toExamineDate.compareTo(endDate) < 0) {
//                        errorList.add(adjustModel.getAdjCode());
//                    }
//                } else {
//                    if (toExamineDate.compareTo(startDate) > 0) {
//                        errorList.add(adjustModel.getAdjCode());
//                    }
//                }
//            }
//        }
//        if (CollectionUtils.isNotEmpty(errorList)) {
//            throw new RpcException(300, ErrorCode.ADJUST_NOT_TO_EXAMINE +  "审核时间在起止范围内不允许审核,请更改开始时间后进行审核！调价单号--->"+errorList.toString(),null);
//        }

        /*审核*/
        for (int i = 0; i < adjIds.length; i++ ) {
            NativeSQLBuilder select = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                    .setSql("select * from commodity_tcj_adjust where is_delete=0 and project_id = " + projectId + " and adj_id= " + adjIds[i] + "");

            CommodityTcjAdjust adjustModel = (CommodityTcjAdjust) autoBaseDao.findOne(select);
            Date endDate = adjustModel.getEndDate();
            Date startDate = adjustModel.getStartDate();
            //  审核驳回
            if (adjStatus == AdjustStatus.ADJUST_STATUS_REJECT) {
                adjStatus = AdjustStatus.ADJUST_STATUS_REJECT;
            }
            // 停用
            if (adjStatus == AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED) {
                adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_DEACTIVATED;
                try {
                    //调用存储过程恢复价格
                    PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack( BarCodeConstant.COMMODITY, BarCodeConstant.IN, adjustModel.getAdjCode());
                    Boolean outReturn = billCheckMthVo.getCode();
                    String msg = billCheckMthVo.getMessage();
                    if (!outReturn) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  adjustModel.getAdjCode() + "信息时调用存储过程失败！错误信息是" + msg, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 作废
            if (adjStatus == AdjustStatus.ADJUST_STATUS_ENTERED_INVALID) {
                adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INVALID;
                try {
                    //调用存储过程恢复价格
                    PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack( BarCodeConstant.COMMODITY, BarCodeConstant.IN, adjustModel.getAdjCode());
                    Boolean outReturn = billCheckMthVo.getCode();
                    String msg = billCheckMthVo.getMessage();
                    if (!outReturn) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  adjustModel.getAdjCode() + "信息时调用存储过程失败！错误信息是" + msg, null);
                    }
                    //这里改状态是因为存储过程会将其调为10707 已停用，需再次将状态改为已作废
                    NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcjAdjust.class)
                            .setSql("UPDATE commodity_tcj_adjust SET \n" );
                    supplier.append( "adj_status = 10708\n");
                    supplier.append("WHERE adj_id IN (" + adjIds[i] + ") and project_id = " + projectId);
                    if (autoBaseDao.nativeExecute(supplier) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //  审核通过
            if (adjStatus == AdjustStatus.ADJUST_STATUS_AUDIT) {
                // 审核通过（判断时间-->当前时间小于开始时间）
                if (toExamineTime < startDate.getTime()) {
                    adjStatus = AdjustStatus.ADJUST_STATUS_STAY_TAKE_EFFECT;
                } else {
                    try{
                        // 当前时间大于结束日期（状态改为已失效）
                        if (endDate!= null && sdf.parse(sdf.format(toExamineDate)).compareTo(endDate) > 0) {
                            adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INTO_FORCE;
                        }else{
                            //如果是待审核状态调用存储过程 调用存储过程之前 先将状态改为待生效然后调用存储过程
                            NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                                    .setSql(" UPDATE commodity_tcj_adjust SET \n" );
                            supplier.append(" adj_status = 10704 \n");
                            supplier.append(" WHERE adj_id IN (" + adjIds[i] + ") and project_id = " + projectId);
                            if (autoBaseDao.nativeExecute(supplier) == 0) {
                                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                            }
                            adjStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;
                            PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack(BarCodeConstant.COMMODITY, BarCodeConstant.IN, adjustModel.getAdjCode());
                            Boolean outReturn = billCheckMthVo.getCode();
                            String msg = billCheckMthVo.getMessage();
                            if (!outReturn == true) {
                                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核商品调价单信息时调用存储过程失败！错误信息是" + msg, null);
                            }
                        }
                    }catch(Exception e){
                        throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核商品调价单信息失败！错误信息是" + e.getMessage(), null);
                    }

                    //增加修改对应的供应商设置为默认缺省供应商
                    NativeSQLBuilder adjDetailSql = NativeSQLBuilder.build(CommodityTcjAdjustDetail.class)
                            .setSql("select * from commodity_tcj_adjust_detail where is_delete = 0 and project_id = " + projectId + " and adj_id = " + adjIds[i] + " limit 1");
                    CommodityTcjAdjustDetail adjustDetailModel =  (CommodityTcjAdjustDetail)autoBaseDao.findOne(adjDetailSql);
                    //先查出该供应商关联的所有商品
                    NativeSQLBuilder supComSql = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
                            .setSql("select * from commodity_tcb_suppcom WHERE supp_id =  " + adjustDetailModel.getSupplierId() + " and project_id = " + projectId + "\n" +
                                    "group by com_id");
                    List<CommodityTcbSuppcomModel> suppcomModels =  autoBaseDao.listAll(supComSql);
                    List<String> comIds = suppcomModels.stream().map(a -> {return a.getComId().toString();}).collect(Collectors.toList());
                    String comIdStr = comIds.stream().collect(Collectors.joining(","));

                    //先将这些商品的供应商改为非缺省
                    NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
                            .setSql("UPDATE commodity_tcb_suppcom SET \n" );
                    supplier.append( "is_default = 20\n");
                    supplier.append("WHERE com_id IN (" + comIdStr + ") and project_id = " + projectId);
                    if (autoBaseDao.nativeExecute(supplier) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改商品供应商状态失败！", null);
                    }
                    //再将调价单中的供应商设置为缺省
                    NativeSQLBuilder supplier1 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
                            .setSql("UPDATE commodity_tcb_suppcom SET \n" );
                    supplier1.append( "is_default = 10, sync_status = 10\n");
                    supplier1.append("WHERE com_id IN (" + comIdStr + ") and project_id = " + projectId + " AND supp_id = " + adjustDetailModel.getSupplierId());
                    if (autoBaseDao.nativeExecute(supplier1) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改商品缺省供应商状态失败！", null);
                    }

                    //将主表同步状态修改为待同步
                    NativeSQLBuilder comSql = NativeSQLBuilder.build(CommodityTcbCom.class)
                            .setSql("UPDATE commodity_tcb_com SET \n" );
                    comSql.append( "sync_status = 10\n");
                    comSql.append("WHERE com_id IN (" + comIdStr + ") and project_id = " + projectId);
                    if (autoBaseDao.nativeExecute(comSql) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改商品主表同步状态失败！", null);
                    }
                }
                // 立即执行(改变开始时间)
            }  else if (adjStatus == AdjustStatus.ADJUST_STATUS_IN_FORCE) {
                // 审核时间大于结束时间
                if (endDate != null && toExamineDate.compareTo(endDate) > 0) {
                    adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INTO_FORCE;
                }else{
                    adjStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;
                    String format = sdf.format(toExamineDate);
                    Date parse = null;
                    try {
                        parse = sdf.parse(format);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    adjustModel.setStartDate(parse);
                    // TODO 调用存储过程更改供应商商品表价格（存储过程还没有）
                    PriceChangeVo billCheckMthVo = caterTcjAdjustApi.cllPriceChangeBack(BarCodeConstant.COMMODITY, BarCodeConstant.IN, adjustModel.getAdjCode());
                    Boolean outReturn = billCheckMthVo.getCode();
                    String msg = billCheckMthVo.getMessage();
                    if (!outReturn == true) {
                        throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核商品调价单信息时调用存储过程失败！错误信息是" + msg, null);
                    }
                }
            }
            adjustModel.setAdjStatus(adjStatus);
            adjustModel.setBLEmpId(userId);
            adjustModel.setBLTime(new Date());
            UpdateBuilder adjustBuilder = UpdateBuilder.build(CommodityTcjAdjust.class).setBean(adjustModel).whereEq("project_id", projectId).whereEq("adj_id", adjIds[i]);
            if (autoBaseDao.update(adjustBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核失败！", null);
            }
        }
    }

    private String listToString(List list, char separator) {
        return StringUtils.join(list.toArray(), separator);
    }

    /**
     *@Description 添加调价商品查询
     *@param   projectId comClassCode  comKey
     *@return List 商品信息集合
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    public ModelPagedList<CommodityVo> selectCommodity(Integer comId, String suppCode, Integer comClassCode, String comKey, Long projectId, Long projectRootId, Integer suppId, Integer pageNo, Integer pageSize) {

       /* NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(String.class)
                .setSql("SELECT com_id FROM commodity_tcb_suppcom WHERE is_delete = 0 AND is_eliminate = 1 AND supp_id = " + suppId + " AND project_id = " + projectId);
        List<String> comIds = autoBaseDao.listAll(sqlBuilder);
        String comIdStr = this.listToString(comIds, ',');
        // 过滤掉 新增、待审核、审核驳回、待生效的税率调整单商品
        String newComIdStr = null;
        if (StringUtils.isNotEmpty(comIdStr)) {
            NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(String.class)
                    .setSql("SELECT com_id FROM commodity_ph_tax_dtl WHERE is_delete = 0 AND com_id IN (" + comIdStr + ") AND project_id = " + projectId + " AND ph_status IN (155001, 155002, 155004, 155006)");
            List<String> newComIds = autoBaseDao.listAll(sqlBuilder1);
            newComIdStr = this.listToString(newComIds, ',');
        }*/
        NativeSQLBuilder builder=NativeSQLBuilder.build(CommodityVo.class)
                .setSql("SELECT xin.*, \n" +
                        "(select t1.tax_name from catecomm_tsb_tax t1 where t1.tax_id = xin.ph_tax_id and t1.project_id = xin.project_id) as taxName,p.`supp_code`,p.`supp_name`,\n" +
                        "\t(SELECT d.type_name FROM `catecomm_tss_pubdatadict` d WHERE d.type_code = xin.`busMode`) AS busModelName" + " FROM (\n" +
                        "\tSELECT s.`supp_id`, \n" +
                        "\tc.`com_id`, c.created_time,c.`project_id`,c.sell_model as busMode,c.`com_name`,s.sup_com_id,s.tax_paid,s.no_tax_paid, s.purchase_no_tax_paid, s.purchase_tax_paid, c.com_code,\n" +
                        "\tc.`ph_tax`,s.`ph_tax_id`,c.`com_grade`,c.`com_class_code`, c.com_spec,  sale.pack_content,\n" +
                        "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = sale.sale_comm_unit) AS commUnitName \n" +
                        "FROM `commodity_tcb_com` c \n" +
                        "\tINNER JOIN `commodity_tcb_suppcom` s ON  (c.`com_id`=s.`com_id` and c.project_id = s.project_id and s.is_delete = 0 AND s.is_eliminate = 1 and c.is_delete = 0)\n" +
                        "LEFT JOIN commodity_tcb_salecom sale ON (sale.project_id = c.project_id AND sale.com_id = c.com_id AND sale.is_pur_chase_unit = 1)\n" +
                        "\tWHERE\n" +
                        "\t c.sell_status in(10201,10202,10203) AND c.c_status = 10605\n" );
        builder.append( null != comId ? "and c.com_id = " + comId + "\n" : "\n");
        builder.append("\t AND c.`is_delete`=0 and c.project_id = " + projectId + "  and s.project_id = "+projectId + ") xin\n" +
                "\t INNER JOIN `commodity_tcb_supplier` p\n" +
                "\t ON (p.`supp_id`=xin.`supp_id`  and  p.project_id = xin.project_id)\n"+
                "\t WHERE 1 = 1");
        builder.append(" and p.`project_id` = " + projectId + "\n");
        builder.append(null != suppId ? " and p.supp_id = " + suppId + "\n" : "");
        if (StringUtils.isNotBlank(suppCode)) {
            builder.appendIfOpt(" AND (p.supp_code like CONCAT('%',#{suppCode},'%') or p.supp_name like CONCAT('%',#{suppCode},'%') )", "suppId", suppCode);
        }

        if(comClassCode != null && !"".equals(comClassCode)){
            builder.append(" and xin.com_class_code = "+comClassCode+"");
        }
        if(comKey != null && !"".equals(comKey)){
            builder.append(" and (xin.com_name LIKE '%" + comKey + "%' OR xin.com_code LIKE '%" + comKey + "%')");
        }

        /*if (StringUtils.isNotEmpty(newComIdStr)) {
            builder.append(" AND xin.com_id NOT IN (" + newComIdStr + ")\n");
        }*/

        builder.append(" order by xin.created_time desc");
        builder.setPage(pageNo,pageSize);
        PagedList<CommodityVo> list = autoBaseDao.listPage(builder);
        list.forEach(a->{
            List<BigDecimal> tempList = new ArrayList<BigDecimal>();
            NativeSQLBuilder gradepricBuild = NativeSQLBuilder.build(CommodityTcbGradeprice.class)
                    .setSql("select retail_price from commodity_tcb_gradeprice where is_delete = 0 and project_id = "+projectId+" and com_id ="+a.getComId());
            List<CommodityTcbGradeprice> list1 = autoBaseDao.listAll(gradepricBuild);
            list1.forEach(b->{
                tempList.add(b.getRetailPrice());
            });

            BigDecimal one = new BigDecimal(1);
            // 得到含税税率比信息
            List<CatecommTsbTax> catecommTsbTax = getTsbTaxInfo(a.getPhTaxId(),null,projectId, projectRootId);
            if (CollectionUtils.isEmpty(catecommTsbTax)) {
                throw new RpcException(300,ErrorCode.PRODUCT_NAME_REPEAT +  "税率信息为空", null);
            }

            BigDecimal max = BigDecimal.ZERO;
            BigDecimal min = BigDecimal.ZERO;
            if (CollectionUtils.isNotEmpty(list1)) {
                if (list1.size() == 1) {
                    max = Collections.max(tempList);
                }else{
                    max = Collections.max(tempList);
                    min = Collections.min(tempList);
                }

                BigDecimal maxDecimal = BigDecimal.ZERO;
                BigDecimal minDivide = BigDecimal.ZERO;
                String maxGrossInterestRate = "";
                String minGrossInterestRate = "";
                NumberFormat percent = NumberFormat.getPercentInstance();
                if (max.compareTo(BigDecimal.ZERO) > 0 ) {
                    maxDecimal = (one.subtract(a.getTaxPaid().divide(max, catecommTsbTax.get(0).getConToFreeNum(),RoundingMode.HALF_UP)));
                    maxGrossInterestRate = percent.format(maxDecimal.doubleValue());

                }
                if (min.compareTo(BigDecimal.ZERO) > 0) {
                    minDivide = (one.subtract(a.getTaxPaid().divide(min, catecommTsbTax.get(0).getConToFreeNum(), RoundingMode.HALF_UP)));
                    minGrossInterestRate = percent.format(minDivide.doubleValue());
                }
                a.setMaxRetailPrice(max);
                a.setMinRetailPrice(min);
                a.setMaxGrossInterestRate(maxGrossInterestRate);
                a.setMinGrossInterestRate(minGrossInterestRate);
            }
        });


        return  ModelPagedList.convertToModelPage(list);
    }
    /**
     *@Description 新增调价单-提交审核
     *@param  commodityTcjAdjustVo
     *@return List<CommodityTcbComVo>  商品信息集合
     *@date 2019-08-23 13:10
     *@auther wangwenbin
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int addAdjustToExamine(CommodityTcjAdjustVo commodityTcjAdjustVo,Long userId,Long projectId, Long projectRootId) {

        try{
            // 获取数据
            Integer adjType = commodityTcjAdjustVo.getAdjType();
            Date startDate = commodityTcjAdjustVo.getStartDate();
            Date endDate = commodityTcjAdjustVo.getEndDate();
            String description = commodityTcjAdjustVo.getDescription();

            String remark = commodityTcjAdjustVo.getRemark();
            String adjCode = commodityTcjAdjustVo.getAdjCode();


            //进价调价主表实例化
            CommodityTcjAdjust commodityTcjAdjust = new CommodityTcjAdjust();
            commodityTcjAdjust.setCreater(userId);
            commodityTcjAdjust.setAdjType(adjType);
            commodityTcjAdjust.setStartDate(startDate);
            commodityTcjAdjust.setEndDate(endDate);
            commodityTcjAdjust.setDescription(description);
            commodityTcjAdjust.setIsDelete(0);
            commodityTcjAdjust.setProjectId(projectId);
            commodityTcjAdjust.setProjectRootId(projectRootId);
            commodityTcjAdjust.setRemark(remark);
            commodityTcjAdjust.setAdjStatus(commodityTcjAdjustVo.getAdjStatus());
            //   新增
            Integer adjId = null;
            if (commodityTcjAdjustVo.getAdjId() == null) {
                try {
                    adjId = supplierService.getTableId(projectId,"commodity_tcj_adjust", 1);
                    commodityTcjAdjust.setAdjId(adjId);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                commodityTcjAdjust.setAdjCode(adjCode);
                int save = autoBaseDao.save(commodityTcjAdjust);
                if (save <= 0) {
                    return 0;
                }

            }else{
                if (10102 == commodityTcjAdjustVo.getAdjType()) {
                    NativeSQLBuilder update = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                            .setSql("update commodity_tcj_adjust set end_date = null where  project_id = " + projectId +
                                    "\tand adj_id= " + commodityTcjAdjustVo.getAdjId());
                    autoBaseDao.nativeExecute(update);
                }
                // 编辑
                UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTcjAdjust.class).setBean(commodityTcjAdjust).set("modifier",userId).whereEq("adj_id",commodityTcjAdjustVo.getAdjId()).whereEq("project_id",projectId);
                int update = autoBaseDao.update(updateBuilder);
                if (update <= 0) {
                    return 0;
                }
            }
            // 删除原有的
            NativeSQLBuilder deleteBuild = NativeSQLBuilder.build(CommodityTcjAdjustDetail.class)
                    .setSql("delete from commodity_tcj_adjust_detail where  project_id = " + projectId +
                            "\tand adj_id= " + commodityTcjAdjustVo.getAdjId());
            autoBaseDao.nativeExecute(deleteBuild);
            // 重新添加
            List<CommodityTcjAdjustDetail> commodityTcjAdjustdetailList = commodityTcjAdjustVo.getCommodityTcjAdjustdetailList();
            for (CommodityTcjAdjustDetail a:commodityTcjAdjustdetailList) {

                CommodityTcjAdjustDetail temp = new CommodityTcjAdjustDetail();
                if (commodityTcjAdjustVo.getAdjId() == null) {
                    temp.setAdjId(adjId);
                }else{
                    temp.setAdjId(commodityTcjAdjustVo.getAdjId());
                }
                try {
                    int id =  supplierService.getTableId(projectId,"commodity_tcj_adjust_detail", 1);
                    temp.setAddId(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                temp.setBusMode(a.getBusMode());
                temp.setComId(a.getComId());
                temp.setDescription(a.getDescription());
                temp.setNewGroMargin(a.getNewGroMargin());
//                // 获取税率比信息
//                List<CatecommTsbTax> tsbTaxInfo = getTsbTaxInfo(a.getTaxId(),projectId, projectRootId);
//                // 含税金额：未税金额*未税转含税比率=含税金额
//                BigDecimal newTaxPriceInTemp = a.getNewUnTaxPriceIn().multiply(tsbTaxInfo.get(0).getFreeToConTax());
//                BigDecimal newTaxPriceIn = newTaxPriceInTemp.setScale(tsbTaxInfo.get(0).getFreeToConNum(),BigDecimal.ROUND_HALF_UP);
//                // 未税金额：含税金额*含税转未税税比率=未税金额
//                BigDecimal newUnTaxPriceInTemp = a.getNewTaxPriceIn().multiply(tsbTaxInfo.get(0).getConToFreeTax());
//                BigDecimal newUnTaxPriceIn = newUnTaxPriceInTemp.setScale(tsbTaxInfo.get(0).getConToFreeNum(),BigDecimal.ROUND_HALF_UP);

                temp.setNewTaxPriceIn(a.getNewTaxPriceIn());
                temp.setNewUnTaxPriceIn(a.getNewUnTaxPriceIn());
                temp.setNewPurchaseTaxPaid(a.getNewPurchaseTaxPaid());//含税采购进价
                temp.setNewPurchaseNoTaxPaid(a.getNewPurchaseNoTaxPaid());//未税采购进价
                temp.setoPurchaseNoTaxPaid(a.getoPurchaseNoTaxPaid());//原未税采购进价
                temp.setoPurchaseTaxPaid(a.getoPurchaseTaxPaid());//原未税采购进价
                temp.setOGroMargin(a.getOGroMargin());
                temp.setOTaxPriceIn(a.getOTaxPriceIn());
                temp.setOUnTaxPriceIn(a.getoUnTaxPriceIn());
                temp.setProjectId(projectId);
                temp.setRemark(a.getRemark());
                temp.setSuppCode(a.getSuppCode());
                temp.setSupComId(a.getSupComId());
                temp.setSupplierId(a.getSupplierId());
                temp.setStatus(10);
                temp.setTaxId(a.getTaxId());
                temp.setAdjCode(adjCode);
                temp.setCreater(userId);
                if (commodityTcjAdjustVo.getAdjId() == null) {
                    temp.setCreater(userId);
                    temp.setModifier(userId);
                }else{
                    temp.setModifier(userId);
                    temp.setCreater(userId);
                }
                log.info("进价调价子表信息为"+temp.toString());
                if (autoBaseDao.save(temp) == 0) {
                    throw new RpcException(300,"----保存进价调价子表信息异常",null);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     *@Description 获取税率表信息
     *@param
     *@return CatecommTsbTax
     *@date 2019-09-05 13:32
     *@auther wangwenbin
     */
    @Override
    public List<CatecommTsbTax> getTsbTaxInfo(Integer taxId,Integer status,Long projectId, Long projectRootId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CatecommTsbTax.class)
                .setSql("select t1.* from catecomm_tsb_tax t1 where t1.project_id=#{projectId} and t1.project_root_id=#{projectRootId}");
        tsbTaxBuild.setValue("projectId",projectId);
        tsbTaxBuild.setValue("projectRootId",projectRootId);
        if (taxId == null) {
            tsbTaxBuild.append("and t1.is_delete = 0");
            if (status == null) {
                tsbTaxBuild.append("and t1.t_status = 0 ");
            }
            tsbTaxBuild.append("order by t1.tax_name asc");
        }else{
            tsbTaxBuild.append(" and t1.`tax_id`="+taxId+"");
        }
        List<CatecommTsbTax>  tsbTax = autoBaseDao.listAll(tsbTaxBuild);
        return tsbTax;
    }

    @Override
    public ModelPagedList getCommdidtyAdjust(int pageNo, int pageSize, String comName, String date, String suppName, Long projectId) {
        String beginRcptDate = null;
        String endRcptDate = null;
        if (org.apache.commons.lang.StringUtils.isNotBlank(date)) {
            String[] timeArray = date.split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CommAdjustDto.class)
                .setSql("SELECT \n" +
                        "t3.supp_name,\n" +
                        "t1.supp_code,\n" +
                        "t2.com_code,\n" +
                        "t2.com_name,\n" +
                        "t.start_date, t.end_date, t1.new_tax_price_in, t1.new_un_tax_price_in\n" +
                        "FROM commodity_tcj_adjust t\n" +
                        "LEFT JOIN commodity_tcj_adjust_detail t1 ON t1.project_id = t.project_id AND t1.adj_id = t.adj_id\n" +
                        "LEFT JOIN commodity_tcb_supplier t3 ON t1.supplier_id = t3.supp_id AND t3.project_id = t1.project_id\n" +
                        "LEFT JOIN commodity_tcb_com t2 ON t2.project_id = t.project_id AND t2.com_id = t1.com_id\n" +
                        "WHERE 1 = 1  and t.project_id = " + projectId + "\n");
        sqlBuilder.append(StringUtils.isNotBlank(comName) ? "and (t2.com_name like" + "'%" + (comName) + "%' OR  t2.com_code like" + "'%" + (comName) + "%') \n" : "");
        sqlBuilder.append(StringUtils.isNotBlank(suppName) ? "AND t3.supp_name like" + "'%" + (suppName) + "%'\n" : "");
        sqlBuilder.append(org.apache.commons.lang.StringUtils.isNotBlank(beginRcptDate) ? ("and t.start_date between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
        sqlBuilder.append("ORDER BY t.created_time desc");
        sqlBuilder.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(sqlBuilder));
    }

    @Override
    public List<PriceRetrunVo> importComm(Excel<CommodityAdjustExeclVo> excel, Long projectId, Long projectRootId, Long accountId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            List<PriceRetrunVo> returnList = new ArrayList<>();
            List<CommodityAdjustExeclVo> oldExeclVos = excel.getData();
            oldExeclVos.removeIf(a -> {
                return null == a.getStartDate() && null == a.getEndDate() && org.apache.commons.lang.StringUtils.isEmpty(a.getComName()) && StringUtils.isEmpty(a.getSuppName());
            });
            //去重得到新的数据
            List<CommodityAdjustExeclVo> newExeclVos =  oldExeclVos.stream().collect(
                    collectingAndThen(
                            toCollection(() -> new TreeSet<>(comparing(o -> o.getStartDate() + ";" + o.getEndDate() + ";" + !StringUtils.isBlank(o.getNewPurchaseTaxPaid())))), ArrayList::new)
            );
            newExeclVos.forEach(a -> {
                PriceRetrunVo priceRetrunVo = new PriceRetrunVo();
                if (!StringUtils.isBlank(a.getNewPurchaseTaxPaid())) {
                    CommodityTcjAdjust commodityTcjAdjust = new CommodityTcjAdjust();
                    /**调价开始时间**/
                    Date stratDate = a.getStartDate();
                    if (stratDate == null) {
                        throw new RpcException(300, "请选择必填项-->调价开始时间", null);
                    }
                    //调价结束时间
                    Date endDate = a.getEndDate();
                    try {
                        commodityTcjAdjust.setStartDate(stratDate);
                        commodityTcjAdjust.setEndDate(endDate);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (endDate != null) {
                        commodityTcjAdjust.setAdjType(10101); //区间调价
                    } else {
                        commodityTcjAdjust.setAdjType(10102); //永久调价
                    }

                    Integer adjId = supplierService.getTableId(projectId,"commodity_tcj_adjust", 1);

                    String adjCode = saleadjustApi.sysGetBillCode(projectId, "commodity_tcj_adjust");
                    commodityTcjAdjust.setAdjCode(adjCode);
                    commodityTcjAdjust.setAdjId(adjId);
                    commodityTcjAdjust.setProjectId(projectId);
                    commodityTcjAdjust.setProjectRootId(projectRootId);
                    commodityTcjAdjust.setCreater(accountId);
                    commodityTcjAdjust.setModifier(accountId);
                    commodityTcjAdjust.setAdjStatus(AdjustStatus.ADJUST_STATUS_COMMIT);
                    commodityTcjAdjust.setSyncStatus(SyncStatus.NOT_SYNC);
                    commodityTcjAdjust.setDescription("来源EXCEL导入");

                    if (autoBaseDao.save(commodityTcjAdjust) == 0) {
                        throw new RpcException(300, "保存商品进价调价主表失败", null);
                    } else {
                        priceRetrunVo.setCode(adjCode);
                        priceRetrunVo.setStartDate(sdf.format(stratDate));
                        priceRetrunVo.setEndDate(null == endDate ? "永久" :sdf.format(endDate));
                    }
                    oldExeclVos.forEach(b -> {
                        if (null == b.getStartDate()) {
                            throw new RpcException(300, "请选择必填项-->调价开始时间", null);
                        }
                        if ((!org.apache.commons.lang.StringUtils.isBlank(b.getNewPurchaseTaxPaid()) && b.getStartDate().compareTo(a.getStartDate()) == 0 && null != b.getEndDate() && null != a.getEndDate() && b.getEndDate().compareTo(a.getEndDate()) == 0)
                                || (!org.apache.commons.lang.StringUtils.isBlank(b.getNewPurchaseTaxPaid()) && b.getStartDate().compareTo(a.getStartDate()) == 0 && null == b.getEndDate() && null == a.getEndDate())) {
                            CommodityTcjAdjustDetail detail = new CommodityTcjAdjustDetail();
                            Integer addId = supplierService.getTableId(projectId, "commodity_tcj_adjust_detail", 1);

                            detail.setAddId(addId);

                            /**商品**/
                            String comName = b.getComName();
                            String comCode = b.getComCode();
                          /*  String[] comNameResult = comNameTemp.split("-");
                            String comId = comNameResult[0];
                            String comName = comNameResult[1];*/

                            NativeSQLBuilder sql2 = NativeSQLBuilder.build(CommodityTcbCom.class)
                                    .setSql("select t1.* from commodity_tcb_com t1\n" +
                                            "where t1.com_code = " + comCode + " AND t1.is_delete = 0 AND t1.project_id = " + projectId);
                            CommodityTcbCom tcbCom = (CommodityTcbCom) autoBaseDao.findOne(sql2);
                            if (null == tcbCom) {
                                StringBuffer error = new StringBuffer();
                                throw new RpcException(300, "在系统中未查询到商品编号编号-->" + comCode, null);
                            }


                            /**供应商**/
                            String suppName = b.getSuppName();
                            String suppCode = b.getSuppCode();
                            /*String[] suppResult = suppNameTemp.split("-");
                            String suppId = suppResult[0];
                            String suppName = suppResult[1];*/

                            NativeSQLBuilder sql3 = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                                    .setSql("select t1.* from commodity_tcb_supplier t1\n" +
                                            "where t1.supp_code = " + suppCode + " AND t1.is_delete = 0 AND t1.project_id = " + projectId);
                            CommodityTcbSupplierModel supplierModel = (CommodityTcbSupplierModel) autoBaseDao.findOne(sql3);
                            if (null == supplierModel) {
                                StringBuffer error = new StringBuffer();
                                throw new RpcException(300, "在系统中未查询到供应商编号-->" + suppCode, null);
                            }

                            Integer suppId = supplierModel.getSuppId();
                            Integer comId = tcbCom.getComId();

                            // 查询商品和供应商是否对应
                            NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                                    .setSql("select t1.tax_paid, t1.no_tax_paid, t2.supp_code, t2.supp_id, t1.sup_com_id from commodity_tcb_suppcom t1\n" +
                                            "LEFT JOIN  commodity_tcb_supplier t2 ON t2.supp_id = t1.supp_id AND t2.project_id = t1.project_id\n" +
                                            "where t1.is_eliminate = 1 AND t1.supp_id = " + suppId + " AND t1.com_id = " + comId + " AND t1.is_delete = 0 AND t1.project_id = " + projectId);
                            CateringTcbSuppRowmater suppComm = (CateringTcbSuppRowmater) autoBaseDao.findOne(sqlBuilder);

                            //查询商品含税转未税比率
                            NativeSQLBuilder sql = NativeSQLBuilder.build(BigDecimal.class)
                                    .setSql("SELECT t3.con_to_free_tax FROM commodity_tcb_suppcom t1\n" +
                                            "LEFT JOIN catecomm_tsb_tax t3 ON t1.ph_tax_id = t3.tax_id and t3.project_id = t1.project_id\n" +
                                            "WHERE t1.com_id = " + comId + " AND t1.project_id = " + projectId + " AND t1.supp_id = " + supplierModel.getSuppId()+" and is_eliminate = 1 and t1.is_delete = 0 ");
                            BigDecimal conToFree = (BigDecimal) autoBaseDao.findOne(sql);


                            //查询商品包装含量
                            NativeSQLBuilder sql1 = NativeSQLBuilder.build(BigDecimal.class)
                                    .setSql("SELECT t1.pack_content FROM commodity_tcb_salecom t1\n" +
                                            "WHERE t1.is_pur_chase_unit = 1 AND t1.com_id = " + comId + " AND t1.project_id = " + projectId);
                            BigDecimal packContent = (BigDecimal) autoBaseDao.findOne(sql1);
                            if (null == packContent) {
                                StringBuffer error = new StringBuffer();
                                throw new RpcException(300, "商品名称-->" + comName + "，未查询到采购单位", null);
                            }
                            if (suppComm == null) {
                                StringBuffer error = new StringBuffer();
                                if(tcbCom.getSellModel() != 10003){
                                    //查询供应商是否有有效的合同
                                    NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityContract.class)
                                            .setSql(" SELECT * FROM commodity_contract t1 \n" +
                                                    " WHERE t1.is_delete = 0" );
                                    supplier.append(" and t1.project_id =" + projectId);
                                    supplier.append(" and t1.contract_supper =" + suppId);
                                    supplier.append(" AND DATE_FORMAT(now(),'%Y-%m-%d') BETWEEN DATE_FORMAT(contract_start_time,'%Y-%m-%d') AND DATE_FORMAT(contract_end_time, '%Y-%m-%d') AND contract_stauts = 133003 " +
                                            " order by contract_start_time desc limit 1 ");
                                    CommodityContract commodityContract = (CommodityContract) autoBaseDao.findOne(supplier);
                                    if (null == commodityContract) {
                                        throw new RpcException(300, "供应商-->" + suppName + "，未查询到有效合同", null);
                                    }

                                    Integer supComId = supplierService.getTableId(projectId, "commodity_tcb_suppcom", 1);
                                    //新增供应商信息
                                    CommodityTcbSuppcomModel sup = new CommodityTcbSuppcomModel();
                                    sup.setProjectId(projectId);
                                    sup.setSupComId(supComId);
                                    sup.setComId(comId);
                                    sup.setSuppId(suppId);
                                    sup.setComCode(tcbCom.getComCode());
                                    sup.setComName(tcbCom.getComName());

                                    if(conToFree == null){
                                        //查询原材料含税转未税比率
                                        NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(BigDecimal.class)
                                                .setSql("SELECT t3.con_to_free_tax FROM commodity_tcb_supplier t1\n" +
                                                        "LEFT JOIN catecomm_tsb_tax t3 ON t1.sl_tax_id = t3.tax_id and t3.project_id = t1.project_id\n" +
                                                        "WHERE  t1.is_delete = 0 AND t1.project_id = " + projectId + " and t1.supp_id = " + suppId);
                                        conToFree = (BigDecimal) autoBaseDao.findOne(sqlBuilder1);
                                    }

                                    //新采购含税进价
                                    BigDecimal newPurchaseTaxPriceIn = new BigDecimal(b.getNewPurchaseTaxPaid());
                                    //新采购未税进价
                                    BigDecimal newPurchaseNoTaxPriceIn = newPurchaseTaxPriceIn.multiply(conToFree);
                                    //新含税进价
                                    BigDecimal newTaxPriceIn = newPurchaseTaxPriceIn.divide(packContent, 6, BigDecimal.ROUND_HALF_UP);
                                    //新未税进价
                                    BigDecimal newNoTaxPriceIn = newTaxPriceIn.multiply(conToFree);
                                    sup.setTaxPaid(newTaxPriceIn);
                                    sup.setNoTaxPaid(newNoTaxPriceIn);
                                    sup.setPurchaseTaxPaid(newPurchaseTaxPriceIn);
                                    sup.setPurchaseNoTaxPaid(newPurchaseNoTaxPriceIn);
                                    sup.setDeliveryType(10401);//直送
                                    sup.setFuTaxCost(newTaxPriceIn);
                                    sup.setIsDefault(20);
                                    sup.setRemark("通过进价调价单导入");
                                    sup.setCreater(accountId);
                                    sup.setcStatus(10602);
                                    sup.setModifier(accountId);
                                    sup.setIsEliminate(1);//默认正常
                                    sup.setContractId(commodityContract.getContractId());
                                    sup.setContractCode(commodityContract.getContractCode());
                                    sup.setContractName(commodityContract.getContractName());
                                    if (null == supplierModel.getSlTaxId()) {
                                        throw new RpcException(300, "供应商-->" + suppName + "，税率为空，无法计算导入！", null);
                                    }
                                    sup.setPhTaxId(supplierModel.getSlTaxId());
                                    NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(String.class)
                                            .setSql("select tax_name from catecomm_tsb_tax where\n" +
                                                    " tax_id = "+supplierModel.getSlTaxId()+"  AND project_id = " + projectId);
                                    String taxName = (String) autoBaseDao.findOne(sqlBuilder1);
                                    sup.setPhTax(taxName);
                                    InsertBuilder<CommodityTcbSuppcomModel> insertBuilder2 = InsertBuilder.build(sup).optSql();
                                    autoBaseDao.save(insertBuilder2);

                                    //根据主商品状态
                                    NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update commodity_tcb_com set c_status = 10607,sync_status = " + SyncStatus.NOT_SYNC + " where project_id = "+projectId+" and  com_id =" + comId);
                                    autoBaseDao.nativeExecute(queryBuilder2);

                                    // 查询商品信息
                                    List<CommodityVo> commodity = this.selectCommodity(Integer.valueOf(comId), null, null, null,  projectId,  projectId, null, 1, 100).getData();

                                    detail.setProjectId(projectId);
                                    detail.setSupComId(commodity.get(0).getSupComId());
                                    detail.setSuppCode(commodity.get(0).getSuppCode());
                                    detail.setComId(comId);
                                    detail.setSupplierId(suppId);
                                    detail.setAdjCode(adjCode);
                                    detail.setAdjId(adjId);
                                    detail.setSupplierId(commodity.get(0).getSuppId());
                                    detail.setTaxId(commodity.get(0).getPhTaxId());
                                    detail.setOTaxPriceIn(commodity.get(0).getTaxPaid());
                                    detail.setOUnTaxPriceIn(commodity.get(0).getNoTaxPaid());
                                    detail.setoPurchaseTaxPaid(commodity.get(0).getPurchaseTaxPaid());
                                    detail.setoPurchaseNoTaxPaid(commodity.get(0).getPurchaseNoTaxPaid());
                                    detail.setBusMode(commodity.get(0).getBusMode());
                                    detail.setNewTaxPriceIn(newTaxPriceIn);//含税进价
                                    detail.setNewUnTaxPriceIn(newNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));
                                    detail.setNewPurchaseTaxPaid(newPurchaseTaxPriceIn);//采购含税进价
                                    detail.setNewPurchaseNoTaxPaid(newPurchaseNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));

                                    detail.setCreater(accountId);
                                    detail.setModifier(accountId);
                                    detail.setStatus(AdjustStatus.ADJUST_STATUS_COMMIT);
                                    detail.setSyncStatus(SyncStatus.NOT_SYNC);
                                    if (autoBaseDao.save(detail) == 0) {
                                        throw new RpcException(300, "保存商品进价调价子表失败!", null);
                                    }
                                    //throw new RpcException(300, "商品名称-->" + comName + "和供应商-->" + suppName + "-->不匹配", null);
                                }
                               
                            } else {
                                String msg = this.getTaxCom(projectId, comId.toString(), suppId);
                                if (null != msg) {
                                    throw new RpcException(300, msg, null);
                                }

                                // 查询商品信息
                                List<CommodityVo> commodity = this.selectCommodity(Integer.valueOf(comId), null, null, null,  projectId,  projectId, null, 1, 100).getData();

                                detail.setProjectId(projectId);
                                detail.setSupComId(commodity.get(0).getSupComId());
                                detail.setSuppCode(commodity.get(0).getSuppCode());
                                detail.setComId(comId);
                                detail.setSupplierId(suppId);
                                detail.setAdjCode(adjCode);
                                detail.setAdjId(adjId);
                                detail.setSupplierId(commodity.get(0).getSuppId());
                                detail.setTaxId(commodity.get(0).getPhTaxId());
                                detail.setOTaxPriceIn(commodity.get(0).getTaxPaid());
                                detail.setOUnTaxPriceIn(commodity.get(0).getNoTaxPaid());
                                detail.setoPurchaseTaxPaid(commodity.get(0).getPurchaseTaxPaid());
                                detail.setoPurchaseNoTaxPaid(commodity.get(0).getPurchaseNoTaxPaid());
                                detail.setBusMode(commodity.get(0).getBusMode());

                                //新采购含税进价
                                BigDecimal newPurchaseTaxPriceIn = new BigDecimal(b.getNewPurchaseTaxPaid());
                                //新采购未税进价
                                BigDecimal newPurchaseNoTaxPriceIn = newPurchaseTaxPriceIn.multiply(conToFree);
                                //新含税进价
                                BigDecimal newTaxPriceIn = newPurchaseTaxPriceIn.divide(packContent, 6, BigDecimal.ROUND_HALF_UP);
                                //新未税进价
                                BigDecimal newNoTaxPriceIn = newTaxPriceIn.multiply(conToFree);

                                detail.setNewTaxPriceIn(newTaxPriceIn);//含税进价
                                detail.setNewUnTaxPriceIn(newNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));
                                detail.setNewPurchaseTaxPaid(newPurchaseTaxPriceIn);//采购含税进价
                                detail.setNewPurchaseNoTaxPaid(newPurchaseNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));

                                detail.setCreater(accountId);
                                detail.setModifier(accountId);
                                detail.setStatus(AdjustStatus.ADJUST_STATUS_COMMIT);
                                detail.setSyncStatus(SyncStatus.NOT_SYNC);
                                if (autoBaseDao.save(detail) == 0) {
                                    throw new RpcException(300, "保存商品进价调价子表失败!", null);
                                }
                            }
                        }
                    });
                }
                if (null != priceRetrunVo.getStartDate()) {
                    returnList.add(priceRetrunVo);
                }
            });
            return returnList;
        } catch (Exception e) {
            throw new RpcException(300, e.getMessage(), null);
        }

    }


    @Override
    public void adjustBatchCommit(String adjIds, Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql(" SELECT * FROM commodity_tcj_adjust \n" +
                        " WHERE is_delete = 0 and adj_id IN (" + adjIds + ") and project_id =" + projectId);
        List<CommodityTcjAdjust> adjustModels = autoBaseDao.listAll(sql);
        Integer oldSize = adjustModels.size();
        adjustModels.removeIf(b -> 10700 != b.getAdjStatus().intValue());//排除掉不是新增状态的数据
        if (adjustModels.size() != oldSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在不是新增状态的数据，请重新选择！", null);
        }
        NativeSQLBuilder rcpt = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql("UPDATE commodity_tcj_adjust\n" );
        rcpt.append("SET adj_status = 10702 \n");
        rcpt.append("WHERE adj_id IN(" + adjIds + ")\n");
        rcpt.append("AND project_id = " + projectId);
        if (autoBaseDao.nativeExecute(rcpt) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "批量提交失败！", null);
        }
    }

    @Override
    @Transactional
    public void counterTrial(Integer adjId, Long projectId, Long accountId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql("SELECT * FROM commodity_tcj_adjust\n" +
                        "WHERE is_delete = 0 and adj_id = " + adjId + " and project_id =" + projectId);
        CommodityTcjAdjust adjust = (CommodityTcjAdjust)autoBaseDao.findOne(sql);
        if (10704 != adjust.getAdjStatus()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "只能反审审核通过待生效的单据！", null);
        }

        //修改状态
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcjAdjust.class)
                .setSql("UPDATE commodity_tcj_adjust SET adj_status = 10703,\n" +
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
    public String getTaxCom(Long projectId, String comIds, Integer suppId) {
        NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(PhTaxVo.class)
                .setSql("SELECT t1.com_id, t2.com_ph_code FROM commodity_ph_tax_dtl t1\n" +
                        "INNER JOIN commodity_ph_tax t2 ON t2.project_id = t1.project_id and t1.com_ph_id = t2.com_ph_id \n" +
                        "WHERE t1.is_delete = 0 and  t2.is_delete = 0  AND t1.com_id IN (" + comIds + ") AND t1.project_id = " + projectId + " AND t1.ph_status IN (155001, 155002, 155004, 155006)\n"
                );
        sqlBuilder1.append(" and t2.supp_id = " + suppId);
        List<PhTaxVo> phTaxVos = autoBaseDao.listAll(sqlBuilder1);
        if (null == phTaxVos || phTaxVos.size() == 0) {
            return null;
        }
        List<String> newComIds = phTaxVos.stream().map(c -> {return c.getComId().toString();}).collect(Collectors.toList());
        String newComIdStr = this.listToString(newComIds, ',');

        List<String> comPhCodes = phTaxVos.stream().map(c -> {return c.getComPhCode();}).collect(Collectors.toList());
        //去除重复的调价单号
        comPhCodes = comPhCodes.stream().distinct().collect(Collectors.toList());
        String comPhCodeStr = this.listToString(comPhCodes, ',');
        NativeSQLBuilder sqlBuilder3 = NativeSQLBuilder.build(String.class)
                .setSql("SELECT com_name FROM commodity_tcb_com WHERE is_delete = 0 AND com_id IN (" + newComIdStr + ") AND project_id = " + projectId);
        List<String> comNames = autoBaseDao.listAll(sqlBuilder3);
        if (null != comNames) {
            String comNamesStr = this.listToString(comNames, ',');
            return  "以下商品：" + comNamesStr + ";" +
                    "存在新增、待审核、审核驳回、待生效的税率调整单，" +
                    "商品税率单号为：" + comPhCodeStr  +
                    "。请先处理税率调整单后再添加调价单！";
        }
        return null;
    }

    @Override
    public List<CommoAdjustVo> excelOutComAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String comName) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CommoAdjustVo.class)
                .setSql("select t2.adj_code, t2.start_date, t2.end_date, t3.com_code, t3.com_name, t4.supp_name, t4.supp_code, \n" +
                        "(case when t3.sell_model = 10001 then '经销' \n" +
                        "when t3.sell_model = 10002 then '代销' \n" +
                        "when t3.sell_model = 10003 then '联营'  end) as sellModelStr,\n" +
                        "(case when t2.adj_status = 10700 then '新增' \n" +
                        "when t2.adj_status = 10702 then '待审核' \n" +
                        "when t2.adj_status = 10703 then '审核驳回' \n" +
                        "when t2.adj_status = 10704 then '待生效'\n" +
                        "when t2.adj_status = 10705 then '生效中'\n" +
                        "when t2.adj_status = 10706 then '已失效'\n" +
                        "when t2.adj_status = 10707 then '已停用'\n" +
                        "when t2.adj_status = 10708 then '已作废' end) as adj_status,\n" +
                        "(select tax_name from catecomm_tsb_tax tax where t3.ph_tax_id = tax.tax_id and tax.project_id = t1.project_id) as tax_name,\n" +
                        "(select type_name from catecomm_tss_pubdatadict where catecomm_tss_pubdatadict.type_code = t5.comm_unit ) AS taxValue,\n" +
                        "(case when t2.adj_type = 10101 then '区间调价' else '永久调价' end) AS adj_type,\n" +
                        "t1.o_tax_price_in, t1.o_un_tax_price_in, t1.o_purchase_tax_paid, t1.o_purchase_no_tax_paid,\n" +
                        "t1.new_tax_price_in, t1.new_un_tax_price_in, t1.new_purchase_tax_paid, t1.new_purchase_no_tax_paid\n" +
                        "from  commodity_tcj_adjust_detail t1\n" +
                        "left join  commodity_tcj_adjust t2 on t2.adj_id = t1.adj_id and t2.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_com t3 on t3.com_id = t1.com_id and t3.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_supplier t4 on t4.supp_id = t1.supplier_id and t4.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_salecom t5 on t5.com_id = t3.com_id and t5.project_id = t1.project_id and t5.is_pur_chase_unit = 1\n" +
                        "where  t2.is_delete = 0  and t2.project_id =  " + projectId);
        sqlBuilder.append(org.apache.commons.lang.StringUtils.isNotEmpty(adjIds) ? " AND t2.adj_id IN (" + adjIds + ")\n" : "");
        sqlBuilder.append(null != adjStatus ? " AND t2.adj_status = " + adjStatus : "");
        sqlBuilder.append(org.apache.commons.lang.StringUtils.isNotEmpty(adjCode) ? " AND t2.adj_code like '%" + adjCode + "%' \n" : "");
        sqlBuilder.append(org.apache.commons.lang.StringUtils.isNotEmpty(comName) ? " AND t3.com_name like '%" + comName + "%' \n" : "");
        return autoBaseDao.listAll(sqlBuilder);
    }

}
