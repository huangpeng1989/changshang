package com.restaurant.service.impi.rawmater;

import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.adjust.SaleadJustFeign;
import com.restaurant.service.rawmater.CaterTcjAdjustApi;
import com.restaurant.service.rawmater.RawmaterApi;
import entity.ModelPagedList;
import excel.Excel;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.model.contract.CateringContract;
import modelpojo.vo.*;
import modelpojo.vo.caterAdjust.PriceChangeVo;
import modelpojo.vo.caterAdjust.PriceRetrunVo;
import modelpojo.vo.saleadjust.CateringAdjusrExeclVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2019-11-21 11:09
 */
@Service
public class CaterAdjustBiz implements CaterTcjAdjustApi {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();

    @Autowired
    private SaleadJustFeign saleadjustApi;

    @Autowired
    private RawmaterApi rawmaterApi;
    @Autowired
    private SupplierServiceFeign supplierService;

    private int NUM = 0;


    @Override
    public ModelPagedList<CateringTcjAdjustVo> caterAdjustList(String adjCode, Integer adjStatus, Long projectId, Integer pageNo, Integer pageSize, String rmName) {
        NativeSQLBuilder sqlBuild = NativeSQLBuilder.build(CateringTcjAdjustVo.class)
                .setSql("SELECT t1.adj_id,t1.adj_code,t1.start_date,t1.end_date,t1.description,t1.created_time,t1.adj_status," +
                        "\t (select t3.nick_name FROM account t3 WHERE t1.creater = t3.id) AS createrStr,\n"+
                        "\t (select t2.type_name FROM catecomm_tss_pubdatadict t2  WHERE t2.type_code = t1.adj_status) AS adjStatusStr\n" +
                        "\t FROM catering_tcj_adjust t1 \n" +
                        "INNER JOIN catering_tcj_adjust_detail t2 ON t2.adj_id = t1.adj_id AND t2.project_id = t1.project_id\n" +
                        "\t INNER JOIN catering_tcb_rowmaterial t3 ON t3.rm_id = t2.rm_id  AND t3.project_id = t1.project_id\n" +
                        "where t1.is_delete = 0\n");
        sqlBuild.append("and t1.project_id = " + projectId + "\n");
        if (StringUtils.isNotBlank(adjCode)) {
            sqlBuild.append("and t1.adj_code  like '%"+adjCode+"%' \n");
        }
        if (StringUtils.isNotBlank(rmName)) {
            sqlBuild.append("and t3.rm_name like '%" + rmName + "%' \n");
        }
        if (adjStatus != null) {
            sqlBuild.append(" AND t1.adj_status ="+adjStatus+ "\n");
        }
        sqlBuild.append(" GROUP BY t1.adj_id \n" +
                " ORDER BY t1.created_time DESC");
        sqlBuild.setPage(pageNo,pageSize);
        PagedList<CateringTcjAdjustVo> list = autoBaseDao.listPage(sqlBuild);
        return ModelPagedList.convertToModelPage(list);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void saveCaterAdjust(CateringTcjAdjustVo cateringTcjAdjustVo, Long projectId, Long projectRootId, Long accountId) {
        CateringTcjAdjust temp = new CateringTcjAdjust();
        temp.setProjectId(projectId);
        temp.setProjectRootId(projectRootId);
        Integer adjId = supplierService.getTableId(projectId,"catering_tcj_adjust", 1);
        temp.setAdjId(adjId);
        temp.setAdjCode(cateringTcjAdjustVo.getAdjCode());
        temp.setAdjType(cateringTcjAdjustVo.getAdjType());
        temp.setStartDate(cateringTcjAdjustVo.getStartDate());
        temp.setEndDate(cateringTcjAdjustVo.getEndDate());
        temp.setDescription(cateringTcjAdjustVo.getDescription());
        temp.setRemark(cateringTcjAdjustVo.getRemark());
        temp.setCreater(accountId);
        temp.setAdjStatus(cateringTcjAdjustVo.getAdjStatus());
        temp.setSyncStatus(SyncStatus.NOT_SYNC);
        if (autoBaseDao.save(temp) == 0) {
            throw new RpcException(300,"保存进价调价单信息失败");
        }
        List<CateringTcjAdjustDetail> detailList = cateringTcjAdjustVo.getCaterAdjustDetailList();
        detailList.forEach(a->{
            CateringTcjAdjustDetail adjustDetail = new CateringTcjAdjustDetail();
            adjustDetail.setProjectId(projectId);
            Integer addId = supplierService.getTableId(projectId,"catering_tcj_adjust_detail", 1);
            adjustDetail.setAddId(addId);
            adjustDetail.setAdjId(adjId);
            adjustDetail.setSupComId(a.getSupComId());
            adjustDetail.setAdjCode(cateringTcjAdjustVo.getAdjCode());
            adjustDetail.setSuppCode(a.getSuppCode());
            adjustDetail.setSupplierId(a.getSupplierId());
            adjustDetail.setRmId(a.getRmId());
            adjustDetail.setGoodType(a.getGoodType());
            adjustDetail.setBusMode(a.getBusMode());
            adjustDetail.setTaxId(a.getTaxId());
            adjustDetail.setoTaxPriceIn(a.getoTaxPriceIn());
            adjustDetail.setoUntaxPriceIn(a.getoUntaxPriceIn());
            adjustDetail.setNewTaxPriceIn(a.getNewTaxPriceIn());
            adjustDetail.setNewUntaxPriceIn(a.getNewUntaxPriceIn());
            //采购含税、未税价格 2021-1-7新增
            adjustDetail.setoPurchaseTaxPaid(a.getoPurchaseTaxPaid());//原采购含税进价
            adjustDetail.setoPurchaseNoTaxPaid(a.getoPurchaseNoTaxPaid());//原采购未税进价
            adjustDetail.setNewPurchaseTaxPaid(a.getNewPurchaseTaxPaid());//新采购含税进价
            adjustDetail.setNewPurchaseNoTaxPaid(a.getNewPurchaseNoTaxPaid());//新采购未税进价
            //------
            adjustDetail.setRemark(a.getRemark());
            adjustDetail.setDescription(a.getDescription());
            adjustDetail.setCreater(accountId);
            adjustDetail.setStatus(AdjustStatus.ADJUST_STATUS_AUDIT);
            adjustDetail.setSyncStatus(SyncStatus.NOT_SYNC);
            if (autoBaseDao.save(adjustDetail) == 0) {
                throw new RpcException(300,"保存进价调价单详情信息失败");
            }
        });
    }

    @Override
    public void upCaterAdjust(CateringTcjAdjustVo cateringTcjAdjustVo, Long projectId, Long projectRootId, Long accountId)  throws Exception {
        CateringTcjAdjust temp = new CateringTcjAdjust();
        try{
            BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
            ConvertUtils.register(new DateConverter(null), Date.class);
            BeanUtils.copyProperties(temp,cateringTcjAdjustVo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        temp.setCreater(accountId);
        temp.setModifier(accountId);
        temp.setUpdatedTime(new Date());
        temp.setProjectRootId(projectRootId);
        temp.setProjectId(projectId);
        temp.setAdjStatus(cateringTcjAdjustVo.getStatus());
        if (10102 == cateringTcjAdjustVo.getAdjType()) {
            NativeSQLBuilder update = NativeSQLBuilder.build(CateringTcjAdjust.class)
                    .setSql("update catering_tcj_adjust set end_date = null where  project_id = " + projectId +
                            "\tand adj_id= " + cateringTcjAdjustVo.getAdjId());
            autoBaseDao.nativeExecute(update);
        }

        UpdateBuilder sqlBuild = UpdateBuilder.build(CateringTcjAdjust.class).setBean(temp).whereEq("adjId",cateringTcjAdjustVo.getAdjId()).whereEq("projectId", projectId);
        if (autoBaseDao.update(sqlBuild) == 0) {
            throw new RpcException(300, ErrorCode.TERMINAL_ERROR +  "修改进价调价单信息失败！", null);
        }

        NativeSQLBuilder deleteBuild = NativeSQLBuilder.build(CateringTcjAdjustDetail.class)
                .setSql("delete from catering_tcj_adjust_detail where  project_id = " + projectId +
                        "\tand adj_id= " + cateringTcjAdjustVo.getAdjId());
        autoBaseDao.nativeExecute(deleteBuild);
        List<CateringTcjAdjustDetail> detailList = cateringTcjAdjustVo.getCaterAdjustDetailList();
        detailList.forEach(a->{
            CateringTcjAdjustDetail adjustDetail = new CateringTcjAdjustDetail();
            adjustDetail.setProjectId(projectId);
            Integer addId = supplierService.getTableId(projectId,"catering_tcj_adjust_detail", 1);
            adjustDetail.setAddId(addId);
            adjustDetail.setAdjId(cateringTcjAdjustVo.getAdjId());
            adjustDetail.setSupComId(a.getSupComId());
            adjustDetail.setAdjCode(cateringTcjAdjustVo.getAdjCode());
            adjustDetail.setSuppCode(a.getSuppCode());
            adjustDetail.setSupplierId(a.getSupplierId());
            adjustDetail.setGoodType(a.getGoodType());
            adjustDetail.setRmId(a.getRmId());
            adjustDetail.setBusMode(a.getBusMode());
            adjustDetail.setTaxId(a.getTaxId());
            adjustDetail.setoTaxPriceIn(a.getoTaxPriceIn());
            adjustDetail.setoUntaxPriceIn(a.getoUntaxPriceIn());
            adjustDetail.setNewTaxPriceIn(a.getNewTaxPriceIn());
            adjustDetail.setNewUntaxPriceIn(a.getNewUntaxPriceIn());
            //采购含税、未税价格  2021-1-7新增
            adjustDetail.setoPurchaseTaxPaid(a.getoPurchaseTaxPaid());//原采购含税进价
            adjustDetail.setoPurchaseNoTaxPaid(a.getoPurchaseNoTaxPaid());//原采购未税进价
            adjustDetail.setNewPurchaseTaxPaid(a.getNewPurchaseTaxPaid());//新采购含税进价
            adjustDetail.setNewPurchaseNoTaxPaid(a.getNewPurchaseNoTaxPaid());//新采购未税进价
            //--------
            adjustDetail.setRemark(a.getRemark());
            adjustDetail.setDescription(a.getDescription());
            adjustDetail.setCreater(accountId);
            adjustDetail.setStatus(AdjustStatus.ADJUST_STATUS_AUDIT);
            adjustDetail.setSyncStatus(SyncStatus.NOT_SYNC);
            if (autoBaseDao.save(adjustDetail) == 0) {
                throw new RpcException(300,"保存进价调价单详情信息失败");
            }
        });

    }

    @Override
    public CateringTcjAdjust getCaterAdjustInfo(Integer adjId, Long projectId) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("select t1.* from catering_tcj_adjust t1 where t1.is_delete = 0 and t1.adj_id ="+adjId+" and t1.project_id = "+projectId);
        CateringTcjAdjust adjust = (CateringTcjAdjust)autoBaseDao.findOne(sqlBuilder);
        NativeSQLBuilder detailBuild = NativeSQLBuilder.build(CateringAdjustDetailVo.class)
                .setSql("select t1.*," +
                        "\t t3.supp_name, t2.rm_name, t4.con_to_free_tax, t4.free_to_con_tax, t2.rm_code,\n" +
                        " (SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t5.srm_unit) AS rmUnitName,\n" +
                        "\t t4.tax_name, t5.pack_content\n"+
                        "\t from catering_tcj_adjust_detail t1\n" +
                        "\t INNER JOIN catering_tcb_rowmaterial t2 on t1.rm_id = t2.rm_id and t2.project_id = t1.project_id\n"+
                        "LEFT JOIN  catering_tcb_supp_rowmater t6 ON t6.rm_id = t1.rm_id and t6.project_id = t1.project_id AND t6.supp_id =  t1.supplier_id\n" +
                        "\t LEFT JOIN commodity_tcb_supplier t3 on t3.supp_id = t1.supplier_id and t1.project_id = t3.project_id\n"+
                        "\t LEFT JOIN catering_tcb_sale_rowmater t5 ON t5.rm_id = t2.rm_id and t5.project_id = t1.project_id  AND t5.is_pur_chase_unit = 1\n" +
                        "\t LEFT JOIN catecomm_tsb_tax t4 ON t6.ph_tax_id = t4.tax_id and t4.project_id = t1.project_id\n"+
                        "\t where t6.is_normal = 0 AND t1.project_id = " + projectId + " and t1.adj_id = " + adjId);
        List<CateringAdjustDetailVo> list = autoBaseDao.listAll(detailBuild);
        adjust.setCateringAdjustDetailVoList(list);
        return adjust;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delOrToExamieCaterAdjust(Long projectId, Long projectRootId, Long accountId, String adjId, Integer adjStatus, Integer delete) throws Exception {
        String[] adjIds = adjId.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 审核
        if (delete == null) {
            Date toExamineDate = new Date();
            long toExamineTime = toExamineDate.getTime();

            /*****审核时间在起止范围内不允许审核，返回错误******/
            List<String> errorList = new ArrayList<String>();
            for (int i = 0; i < adjIds.length; i++) {
                NativeSQLBuilder select = NativeSQLBuilder.build(CateringTcjAdjust.class)
                        .setSql("select * from catering_tcj_adjust where is_delete = 0 and project_id = " + projectId + " and adj_id= " + adjIds[i] + "");

                CateringTcjAdjust adjustModel = (CateringTcjAdjust) autoBaseDao.findOne(select);
                Date endDate = adjustModel.getEndDate();
                Date startDate = adjustModel.getStartDate();
                if (adjStatus == AdjustStatus.ADJUST_STATUS_AUDIT){//待审核
                    if (endDate != null && sdf.format(endDate).compareTo(sdf.format(toExamineDate)) < 0) {
                        errorList.add(adjustModel.getAdjCode());
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(errorList)) {
                throw new RpcException(300, ErrorCode.ADJUST_NOT_TO_EXAMINE +  "审核时间在起止范围内不允许审核,请更改开始时间后进行审核！调价单号--->"+errorList.toString(), null);
            }

            /*审核*/
            for (int i = 0; i < adjIds.length; i++) {
                NativeSQLBuilder select = NativeSQLBuilder.build(CateringTcjAdjust.class)
                        .setSql("select * from catering_tcj_adjust where is_delete = 0 and project_id = " + projectId + " and adj_id= " + adjIds[i] + "");
                CateringTcjAdjust adjustModel = (CateringTcjAdjust) autoBaseDao.findOne(select);
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
                        PriceChangeVo billCheckMthVo = cllPriceChangeBack(projectId, BarCodeConstant.CATERING, BarCodeConstant.IN, adjustModel.getAdjCode());
                        Boolean outReturn = billCheckMthVo.getCode();
                        String msg = billCheckMthVo.getMessage();
                        if (!outReturn) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  adjustModel.getAdjCode() + "信息时调用存储过程失败！错误信息是" + msg, null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //  审核通过
                if (adjStatus == AdjustStatus.ADJUST_STATUS_AUDIT) {
                    // 审核通过（判断时间-->当前时间小于开始时间）
                    if (sdf.format(toExamineDate).compareTo(sdf.format(startDate)) < 0) {
                        adjStatus = AdjustStatus.ADJUST_STATUS_STAY_TAKE_EFFECT;
                    } else {
                        // 当前时间大于结束日期（状态改为已失效）
                        if (null != endDate && sdf.format(toExamineDate).compareTo(sdf.format(endDate)) > 0) {
                            adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INTO_FORCE;
                        }
                    }
                    //开始时间大于等于当前时间 应当为生效中
                    if (sdf.format(startDate).compareTo(sdf.format(new Date())) <= 0) {
                        adjStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;
                    }
                    //增加修改对应的供应商设置为默认缺省供应商
                    NativeSQLBuilder adjDetailSql = NativeSQLBuilder.build(CateringTcjAdjustDetail.class)
                            .setSql("select * from catering_tcj_adjust_detail where good_type = 11004 AND is_delete = 0 and project_id = " + projectId + " and adj_id = " + adjIds[i] + " limit 1");
                    CateringTcjAdjustDetail adjustDetailModel =  (CateringTcjAdjustDetail)autoBaseDao.findOne(adjDetailSql);

                    //先查出该供应商关联的所有原材料
                    NativeSQLBuilder supMaterSql = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                            .setSql("select * from catering_tcb_supp_rowmater WHERE supp_id =  " + adjustDetailModel.getSupplierId() + " and project_id = " + projectId + "\n" +
                                    "group by rm_id");
                    List<CateringTcbSuppRowmater> suppRowmaters =  autoBaseDao.listAll(supMaterSql);
                    List<String> rmIds = suppRowmaters.stream().map(a -> {return a.getRmId().toString();}).collect(Collectors.toList());
                    String rmIdStr = rmIds.stream().collect(Collectors.joining(","));

                    //先将这些原材料的供应商改为非缺省
                    NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                            .setSql("UPDATE catering_tcb_supp_rowmater SET \n" );
                    supplier.append( "is_default = 0\n");
                    supplier.append("WHERE rm_id IN(  " + rmIdStr + ") and project_id = " + projectId);
                    if (autoBaseDao.nativeExecute(supplier) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改原材料供应商状态失败！", null);
                    }
                    //再将调价单中的供应商设置为缺省
                    NativeSQLBuilder supplier1 = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                            .setSql("UPDATE catering_tcb_supp_rowmater SET \n" );
                    supplier1.append( "is_default = 1, sync_status = 10\n");
                    supplier1.append("WHERE rm_id IN (" + rmIdStr + ") and project_id = " + projectId + " AND supp_id = " + adjustDetailModel.getSupplierId());
                    if (autoBaseDao.nativeExecute(supplier1) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改原材料缺省供应商状态失败！", null);
                    }
                    //将主表同步状态修改为待同步
                    NativeSQLBuilder rowmaterSql = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                            .setSql("UPDATE catering_tcb_rowmaterial SET \n" );
                    rowmaterSql.append( "sync_status = 10\n");
                    rowmaterSql.append("WHERE rm_id IN (" + rmIdStr + ") and project_id = " + projectId);
                    if (autoBaseDao.nativeExecute(rowmaterSql) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改原材料主表同步状态失败！", null);
                    }
                }
                // 立即执行(改变开始时间)
                if (adjStatus == AdjustStatus.ADJUST_STATUS_IN_FORCE) {
                    // 审核时间大于结束时间
                    if (endDate != null && sdf.format(toExamineDate).compareTo(sdf.format(endDate)) > 0) {
                        adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INTO_FORCE;
                    }else{
                        adjStatus = AdjustStatus.ADJUST_STATUS_IN_FORCE;
                        try {
                            String format = sdf.format(toExamineDate);
                            Date parse = sdf.parse(format);
                            adjustModel.setStartDate(parse);


                            //调用存储过程之前 先将状态改为待生效
                            NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcjAdjust.class)
                                    .setSql("UPDATE catering_tcj_adjust SET \n" );
                            supplier.append( "adj_status = 10704\n");
                            supplier.append("WHERE adj_id IN (" + adjIds[i] + ") and project_id = " + projectId);
                            if (autoBaseDao.nativeExecute(supplier) == 0) {
                                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                            }
                            // 调用存储过程更改供应商商品表价格（存储过程还没有）
                            PriceChangeVo billCheckMthVo = callPriceChange(projectId, BarCodeConstant.CATERING, BarCodeConstant.IN, adjustModel.getAdjCode());
                            Boolean outReturn = billCheckMthVo.getCode();
                            String msg = billCheckMthVo.getMessage();
                            if (!outReturn == true) {
                                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核原材料调价单信息时调用存储过程失败！错误信息是" + msg, null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                adjustModel.setAdjStatus(adjStatus);
                adjustModel.setBlEmpId(accountId);
                adjustModel.setBlTime(new Date());
                UpdateBuilder adjustBuilder = UpdateBuilder.build(CateringTcjAdjust.class).setBean(adjustModel).whereEq("project_id", projectId).whereEq("adj_id", adjIds[i]);
                if (autoBaseDao.update(adjustBuilder) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核失败！", null);
                }
                // 作废
                if (adjStatus == AdjustStatus.ADJUST_STATUS_ENTERED_INVALID) {
                    adjStatus = AdjustStatus.ADJUST_STATUS_ENTERED_INVALID;
                    try {
                        //调用存储过程恢复价格
                        PriceChangeVo billCheckMthVo =cllPriceChangeBack(projectId, BarCodeConstant.CATERING, BarCodeConstant.IN, adjustModel.getAdjCode());
                        Boolean outReturn = billCheckMthVo.getCode();
                        String msg = billCheckMthVo.getMessage();
                        if (!outReturn) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  adjustModel.getAdjCode() + "信息时调用存储过程失败！错误信息是" + msg, null);
                        }
                        //这里改状态是因为存储过程会将其调为10707 已停用，需再次将状态改为已作废
                        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcjAdjust.class)
                                .setSql("UPDATE catering_tcj_adjust SET \n" );
                        supplier.append( "adj_status = 10708\n");
                        supplier.append("WHERE adj_id IN (" + adjIds[i] + ") and project_id = " + projectId);
                        if (autoBaseDao.nativeExecute(supplier) == 0) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
             // 删除
            NativeSQLBuilder select = NativeSQLBuilder.build(CateringTcjAdjust.class)
                    .setSql("select * from catering_tcj_adjust where  is_delete = 0 and project_id = " + projectId +
                            "\t and adj_id= " + adjId + "");
            CateringTcjAdjust adjust = (CateringTcjAdjust)autoBaseDao.findOne(select);
            if (adjust == null) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "调价单信息不存在！id为"+adjust, null);
            }
            adjust.setIsDelete((byte)1);
            adjust.setUpdatedTime(new Date());
            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcjAdjust.class).setBean(adjust).whereEq("adj_id",adjId).whereEq("project_id", projectId);
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除调价单失败！调价单id为"+adjId, null);
            }
        }
    }
    private String listToString(List list, char separator) {
        return StringUtils.join(list.toArray(), separator);
    }

    @Override
    public ModelPagedList<CateringTcbRowmaterialVo> getCanSaleRowmaterList(String suppKey, String rmClassCode, String rmKey, Long projectId, Integer suppId, Integer pageNo, Integer pageSize) {

        /*NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(String.class)
                .setSql("SELECT rm_id FROM catering_tcb_supp_rowmater WHERE is_delete = 0 AND is_normal = 0 AND supp_id = " + suppId + " AND project_id = " + projectId);
        List<String> rmIds = autoBaseDao.listAll(sqlBuilder1);
        String rmIdStr = this.listToString(rmIds, ',');
        String newRmIdStr = null;
        if (StringUtils.isNotEmpty(rmIdStr)) {
            // 过滤掉 新增、待审核、审核驳回、待生效的税率调整单商品
            NativeSQLBuilder sqlBuilder2 = NativeSQLBuilder.build(String.class)
                    .setSql("SELECT rm_id FROM catering_ph_tax_dtl WHERE is_delete = 0 AND rm_id IN (" + rmIdStr + ") AND project_id = " + projectId + " AND ph_status IN (155001, 155002, 155004, 155006)");
            List<String> newRmIds = autoBaseDao.listAll(sqlBuilder2);
            newRmIdStr = this.listToString(newRmIds, ',');
        }*/
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcbRowmaterialVo.class)
                .setSql("select t1.*,\n" +
                        "t2.tax_paid,t2.no_tax_paid,t2.sup_com_id, t2.purchase_tax_paid, t2.purchase_no_tax_paid,\n" +
                        "t5.supp_id,t5.supp_name,t5.supp_code,t3.tax_name,t3.con_to_free_tax,t3.free_to_con_tax, t4.pack_content,\n" +
                        " (SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t4.srm_unit) AS rmUnitName\n" +
                        "\t FROM catering_tcb_rowmaterial t1 \n" +
                        "\tINNER JOIN catering_tcb_supp_rowmater t2 on t1.rm_id = t2.rm_id and t1.project_id = t2.project_id \n" +
                        "\t LEFT JOIN commodity_tcb_supplier t5 on t2.supp_id = t5.supp_id and t2.project_id = t5.project_id \n" +
                        "\t INNER JOIN catering_tcb_sale_rowmater t4 ON t1.rm_id = t4.rm_id AND t1.project_id = t4.project_id AND t4.is_pur_chase_unit = 1\n" +
                        "\t LEFT JOIN catecomm_tsb_tax t3 ON t3.tax_id =  t2.ph_tax_id  and t3.project_id = t2.project_id\n"+
                        "\t WHERE t2.is_normal = 0 AND t1.c_status = 11503 AND t1.is_delete = 0 and t1.project_id = " + projectId + "\n");
        sqlBuilder.append(null != suppId ? " AND t5.supp_id = " + suppId + "\n" : "");
        if (StringUtils.isNotEmpty(suppKey)) {
            sqlBuilder.append(" AND (t5.supp_name like '%" + suppKey + "%' OR t5.supp_code like '%" + suppKey + "%')");
        }
        if (StringUtils.isNotEmpty(rmClassCode)) {
            sqlBuilder.append(" AND t1.rm_class_code = " + rmClassCode);
        }
        if (StringUtils.isNotEmpty(rmKey)) {
            sqlBuilder.append(" AND (t1.rm_name like '%" + rmKey + "%' OR t1.rm_code like '%" + rmKey + "%' OR t4.rm_barcode like '%" + rmKey + "%')");
        }

        /*if (StringUtils.isNotEmpty(newRmIdStr)) {
            sqlBuilder.append(" AND t2.rm_id NOT IN (" + newRmIdStr + ")\n");
        }*/
        sqlBuilder.append("  AND t1.sale_status IN(10201,10202,10203)\n");
        sqlBuilder.setPage(pageNo,pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(sqlBuilder));
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public List<PriceRetrunVo> importRawmaterAdjust(Excel<CateringAdjusrExeclVo> excel, Long projectId, Long projectRootId, Long accountId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            List<PriceRetrunVo> returnList = new ArrayList<>();
            List<CateringAdjusrExeclVo> oldExeclVos = excel.getData();
            oldExeclVos.removeIf(a -> {
                return null == a.getStartDate() && null == a.getEndDate() && StringUtils.isEmpty(a.getRmName()) && StringUtils.isEmpty(a.getSuppName());
            });
            //去重得到新的数据
            List<CateringAdjusrExeclVo> newExeclVos =  oldExeclVos.stream().collect(
                    collectingAndThen(
                            toCollection(() -> new TreeSet<>(comparing(o -> o.getStartDate() + ";" + o.getEndDate() + ";" + !StringUtils.isBlank(o.getNewPurchaseTaxPaid())))), ArrayList::new)
            );
            newExeclVos.forEach(a -> {
                PriceRetrunVo priceRetrunVo = new PriceRetrunVo();
                if (!StringUtils.isBlank(a.getNewPurchaseTaxPaid())) {//新采购含税金额
                    CateringTcjAdjust cateringTcjAdjust = new CateringTcjAdjust();
                    /**调价开始时间**/
                    Date stratDate = a.getStartDate();
                    if (stratDate == null) {
                        throw new RpcException(300, "请选择必填项-->调价开始时间", null);
                    }
                    //调价结束时间
                    Date endDate = a.getEndDate();
                    try {
                        cateringTcjAdjust.setStartDate(stratDate);
                        cateringTcjAdjust.setEndDate(endDate);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (endDate != null) {
                        cateringTcjAdjust.setAdjType(10101); //区间调价
                    } else {
                        cateringTcjAdjust.setAdjType(10102); //永久调价
                    }

                    Integer adjId = supplierService.getTableId(projectId,"catering_tcj_adjust", 1);

                    String adjCode = saleadjustApi.sysGetBillCode(projectId,"catering_tcj_adjust");
                    cateringTcjAdjust.setAdjCode(adjCode);
                    cateringTcjAdjust.setAdjId(adjId);
                    cateringTcjAdjust.setProjectId(projectId);
                    cateringTcjAdjust.setProjectRootId(projectRootId);
                    cateringTcjAdjust.setCreater(accountId);
                    cateringTcjAdjust.setModifier(accountId);
                    cateringTcjAdjust.setAdjStatus(AdjustStatus.ADJUST_STATUS_COMMIT); //新增状态
                    cateringTcjAdjust.setSyncStatus(SyncStatus.NOT_SYNC);
                    cateringTcjAdjust.setDescription("来源EXCEL导入");

                    if (autoBaseDao.save(cateringTcjAdjust) == 0) {
                        throw new RpcException(300, "保存调价主表失败", null);
                    } else {
                        priceRetrunVo.setCode(adjCode);
                        priceRetrunVo.setStartDate(sdf.format(stratDate));
                        priceRetrunVo.setEndDate(null == endDate ? "永久" :sdf.format(endDate));
                    }
                    oldExeclVos.forEach(b -> {
                        if (null == b.getStartDate()) {
                            throw new RpcException(300, "请选择必填项-->调价开始时间", null);
                        }
                        if ((!StringUtils.isBlank(b.getNewPurchaseTaxPaid()) && b.getStartDate().compareTo(a.getStartDate()) == 0 && null != b.getEndDate() && null != a.getEndDate() && b.getEndDate().compareTo(a.getEndDate()) == 0)
                        || (!StringUtils.isBlank(b.getNewPurchaseTaxPaid()) && b.getStartDate().compareTo(a.getStartDate()) == 0 && null == b.getEndDate() && null == a.getEndDate())) {
                            CateringTcjAdjustDetail adjustDetail = new CateringTcjAdjustDetail();
                            Integer addId = supplierService.getTableId(projectId, "catering_tcj_adjust_detail", 1);

                            adjustDetail.setAddId(addId);

                            /**原材料**/
                            String rmName = b.getRmName();
                            String rmCode = b.getRmCode();
                            /*String[] rmNameResult = rmNameTemp.split("-");
                            String rmId = rmNameResult[0];
                            String rmName = rmNameResult[1];*/

                            NativeSQLBuilder sql2 = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                                    .setSql("select t1.* from catering_tcb_rowmaterial t1\n" +
                                            "where t1.rm_code = " + rmCode + " AND t1.is_delete = 0 AND t1.project_id = " + projectId);
                            CateringTcbRowmaterial rowmaterial = (CateringTcbRowmaterial) autoBaseDao.findOne(sql2);
                            if (null == rowmaterial) {
                                StringBuffer error = new StringBuffer();
                                throw new RpcException(300, "在系统中未查询到原材料编号-->" + rmCode, null);
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
                            Integer rmId = rowmaterial.getRmId();

                            // 查询原材料和供应商是否对应
                            NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcbSuppRowmater.class)
                            .setSql("select t1.tax_paid, t1.no_tax_paid, t1.purchase_tax_paid, t1.purchase_no_tax_paid, t2.supp_code, t2.supp_id, t1.sup_com_id from catering_tcb_supp_rowmater t1\n" +
                                    "LEFT JOIN  commodity_tcb_supplier t2 ON t2.supp_id = t1.supp_id AND t2.project_id = t1.project_id\n" +
                                    "where t1.is_normal = 0 AND t1.supp_id = " + suppId + " AND t1.rm_id = " + rmId + " AND t1.is_delete = 0 AND t1.project_id = " + projectId );
                            CateringTcbSuppRowmater suppRowmater = (CateringTcbSuppRowmater) autoBaseDao.findOne(sqlBuilder);

                            //查询原材料含税转未税比率
                            NativeSQLBuilder sql = NativeSQLBuilder.build(BigDecimal.class)
                                    .setSql("SELECT t3.con_to_free_tax FROM catering_tcb_supp_rowmater t1\n" +
                                            "LEFT JOIN catecomm_tsb_tax t3 ON t1.ph_tax_id = t3.tax_id and t3.project_id = t1.project_id\n" +
                                            "WHERE t1.rm_id = " + rmId + " AND t1.project_id = " + projectId + " and t1.supp_id = " + supplierModel.getSuppId()+" and is_normal = 0 and t1.is_delete = 0 ");
                            BigDecimal conToFree = (BigDecimal) autoBaseDao.findOne(sql);

                            //查询原材料包装含量
                            NativeSQLBuilder sql1 = NativeSQLBuilder.build(BigDecimal.class)
                                    .setSql("SELECT t1.pack_content FROM catering_tcb_sale_rowmater t1\n" +
                                            "WHERE t1.is_pur_chase_unit = 1 AND t1.rm_id = " + rmId + " AND t1.project_id = " + projectId);
                            BigDecimal packContent = (BigDecimal) autoBaseDao.findOne(sql1);

                            if (null == packContent) {
                                StringBuffer error = new StringBuffer();
                                throw new RpcException(300, "原材料名称-->" + rmName + "，未查询到采购单位", null);
                            }

                            if (suppRowmater == null) {
                                StringBuffer error = new StringBuffer();
                                //查询供应商是否有有效的合同
                                NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringContract.class)
                                        .setSql(" SELECT * FROM catering_contract t1 \n" +
                                                " WHERE t1.is_delete = 0" );
                                supplier.append(" and t1.project_id =" + projectId);
                                supplier.append(" and t1.contract_supper =" + suppId);
                                supplier.append(" AND DATE_FORMAT(now(),'%Y-%m-%d') BETWEEN DATE_FORMAT(contract_start_time,'%Y-%m-%d') AND DATE_FORMAT(contract_end_time, '%Y-%m-%d') AND contract_stauts = 133003 " +
                                        " order by contract_start_time desc limit 1 ");
                                CateringContract cateringContract = (CateringContract) autoBaseDao.findOne(supplier);
                                if (null == cateringContract) {
                                    throw new RpcException(300, "供应商-->" + suppName + "，未查询到有效合同", null);
                                }

                                Integer supComId = supplierService.getTableId(projectId, "catering_tcb_supp_rowmater", 1);
                                //新增供应商信息
                                CateringTcbSuppRowmater sup = new CateringTcbSuppRowmater();
                                sup.setProjectId(projectId);
                                sup.setSupComId(supComId);
                                sup.setRmId(rmId);
                                sup.setRmCode(rowmaterial.getRmCode());
                                sup.setRmName(rowmaterial.getRmName());
                                sup.setSuppId(suppId);

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
                                sup.setIsDefault(0);
                                sup.setRemark("通过进价调价单导入");
                                sup.setCreater(accountId);
                                sup.setSrmStatus(RawmaterStatus.RAWMATER_STATUS_ADD);
                                sup.setModifier(accountId);
                                sup.setIsNormal("0");//默认正常
                                sup.setContractId(cateringContract.getContractId());
                                sup.setContractCode(cateringContract.getContractCode());
                                sup.setContractName(cateringContract.getContractName());

                                if (null == supplierModel.getSlTaxId()) {
                                    throw new RpcException(300, "供应商-->" + suppName + "，税率为空，无法计算导入！", null);
                                }
                                sup.setPhTaxId(supplierModel.getSlTaxId());
                                NativeSQLBuilder sqlBuilder1 = NativeSQLBuilder.build(String.class)
                                        .setSql("select tax_name from catecomm_tsb_tax where\n" +
                                                " tax_id = "+ supplierModel.getSlTaxId() +"  AND project_id = " + projectId);
                                String taxName = (String) autoBaseDao.findOne(sqlBuilder1);
                                sup.setPhTax(taxName);
                                InsertBuilder<CateringTcbSuppRowmater> insertBuilder2 = InsertBuilder.build(sup).optSql();
                                autoBaseDao.save(insertBuilder2);

                                //根据主商品状态
                                NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update catering_tcb_rowmaterial set c_status = 11506,sync_status = " + SyncStatus.NOT_SYNC + " where project_id = "+projectId+" and  rm_id =" + rmId);
                                autoBaseDao.nativeExecute(queryBuilder2);

                                // 查询原材料信息
                                CateringTcbRowmaterial rawmaterInfo = rawmaterApi.getRawmaterInfo(Integer.valueOf(rmId), projectId, projectRootId);

                                adjustDetail.setProjectId(projectId);
                                adjustDetail.setSupComId(sup.getSupComId());
                                adjustDetail.setSuppCode(sup.getSuppCode());
                                adjustDetail.setRmId(rmId);
                                adjustDetail.setSupplierId(suppId);
                                adjustDetail.setAdjCode(adjCode);
                                adjustDetail.setAdjId(adjId);
                                adjustDetail.setGoodType(11004);
                                adjustDetail.setSupplierId(sup.getSuppId());
                                adjustDetail.setTaxId(rawmaterInfo.getPhTaxId());
                                adjustDetail.setoTaxPriceIn(sup.getTaxPaid());
                                adjustDetail.setoUntaxPriceIn(sup.getNoTaxPaid());
                                adjustDetail.setoPurchaseTaxPaid(sup.getPurchaseTaxPaid());
                                adjustDetail.setoPurchaseNoTaxPaid(sup.getPurchaseNoTaxPaid());
                                adjustDetail.setNewTaxPriceIn(newTaxPriceIn);//含税进价
                                adjustDetail.setNewUntaxPriceIn(newNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));
                                adjustDetail.setNewPurchaseTaxPaid(newPurchaseTaxPriceIn);//采购含税进价
                                adjustDetail.setNewPurchaseNoTaxPaid(newPurchaseNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));
                                adjustDetail.setCreater(accountId);
                                adjustDetail.setModifier(accountId);
                                adjustDetail.setStatus(AdjustStatus.ADJUST_STATUS_COMMIT);
                                adjustDetail.setSyncStatus(SyncStatus.NOT_SYNC);
                                if (autoBaseDao.save(adjustDetail) == 0) {
                                    throw new RpcException(300, "保存原材料进价调价子表失败!", null);
                                }
                                //throw new RpcException(300, "原材料-->" + rmName + "和供应商-->" + suppName + "-->不匹配", null);
                            } else {
                                String msg = this.getTaxRm(projectId, rmId.toString(), suppId);
                                if (null != msg) {
                                    throw new RpcException(300, msg, null);
                                }
                                // 查询原材料信息
                                CateringTcbRowmaterial rawmaterInfo = rawmaterApi.getRawmaterInfo(Integer.valueOf(rmId), projectId, projectRootId);

                                adjustDetail.setProjectId(projectId);
                                adjustDetail.setSupComId(suppRowmater.getSupComId());
                                adjustDetail.setSuppCode(suppRowmater.getSuppCode());
                                adjustDetail.setRmId(rmId);
                                adjustDetail.setSupplierId(suppId);
                                adjustDetail.setAdjCode(adjCode);
                                adjustDetail.setAdjId(adjId);
                                adjustDetail.setGoodType(11004);
                                adjustDetail.setSupplierId(suppRowmater.getSuppId());
                                adjustDetail.setTaxId(rawmaterInfo.getPhTaxId());
                                adjustDetail.setoTaxPriceIn(suppRowmater.getTaxPaid());
                                adjustDetail.setoUntaxPriceIn(suppRowmater.getNoTaxPaid());

                                adjustDetail.setoPurchaseTaxPaid(suppRowmater.getPurchaseTaxPaid());
                                adjustDetail.setoPurchaseNoTaxPaid(suppRowmater.getPurchaseNoTaxPaid());

                                //新采购含税进价
                                BigDecimal newPurchaseTaxPriceIn = new BigDecimal(b.getNewPurchaseTaxPaid());
                                //新采购未税进价
                                BigDecimal newPurchaseNoTaxPriceIn = newPurchaseTaxPriceIn.multiply(conToFree);
                                //新含税进价
                                BigDecimal newTaxPriceIn = newPurchaseTaxPriceIn.divide(packContent, 6, BigDecimal.ROUND_HALF_UP);
                                //新未税进价
                                BigDecimal newNoTaxPriceIn = newTaxPriceIn.multiply(conToFree);

                                adjustDetail.setNewTaxPriceIn(newTaxPriceIn);//含税进价
                                adjustDetail.setNewUntaxPriceIn(newNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));
                                adjustDetail.setNewPurchaseTaxPaid(newPurchaseTaxPriceIn);//采购含税进价
                                adjustDetail.setNewPurchaseNoTaxPaid(newPurchaseNoTaxPriceIn.setScale(6, RoundingMode.HALF_UP));

                                adjustDetail.setCreater(accountId);
                                adjustDetail.setModifier(accountId);
                                adjustDetail.setStatus(AdjustStatus.ADJUST_STATUS_COMMIT);
                                adjustDetail.setSyncStatus(SyncStatus.NOT_SYNC);
                                if (autoBaseDao.save(adjustDetail) == 0) {
                                    throw new RpcException(300, "保存调价子表失败!", null);
                                }
                            }
                        }
                    });
                } else {
                    throw new RpcException(300, "请选择必填项-->新含税采购价", null);
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


    /***原材料进价调价报表***/
    @Override
    public ModelPagedList<CateringTcjAdjustDetailVo> rawAdjustReportList(String suppName, String rmKey, String startTime, String endTime, Long projectId, Integer pageNo, Integer pageSize) {
        NativeSQLBuilder sqlBuild = NativeSQLBuilder.build(CateringTcjAdjustDetailVo.class)
                .setSql("SELECT t3.rm_code,t3.rm_name,t4.supp_code,t4.supp_name,t1.o_tax_price_in,t1.o_untax_price_in,\n" +
                        "\t t1.new_tax_price_in,t1.new_untax_price_in,t2.start_date,t2.end_date\n" +
                        "\t FROM catering_tcj_adjust_detail t1\n" +
                        "\t INNER JOIN catering_tcj_adjust t2 ON t1.adj_id = t2.adj_id AND t1.project_id = t2.project_id and t2.is_delete = 0\n" +
                        "\t INNER JOIN catering_tcb_rowmaterial t3 ON t1.rm_id = t3.rm_id AND t1.project_id = t3.project_id\n" +
                        "\t INNER JOIN commodity_tcb_supplier t4 ON t1.supplier_id = t4.supp_id AND t1.project_id = t4.project_id\n" +
                        "\t where t1.project_id = "+projectId);
        if (StringUtils.isNotBlank(suppName)) {
            sqlBuild.append(" and t4.supp_name  like '%"+suppName+"%' ");
        }
        if (StringUtils.isNotBlank(rmKey)) {
            sqlBuild.append(" and (t3.rm_name like '%"+rmKey+"%' OR t3.rm_code like '"+rmKey+"')");
        }
        if (StringUtils.isNotBlank(startTime)) {
            sqlBuild.append(" and t2.start_date between '" + startTime + "' and '" + endTime + "'");
        }
        sqlBuild.append(" ORDER BY t4.spell_code, t2.start_date DESC");
        sqlBuild.setPage(pageNo,pageSize);
        PagedList<CateringTcjAdjustDetailVo> list = autoBaseDao.listPage(sqlBuild);
        return ModelPagedList.convertToModelPage(list);
    }



    @Override
    public PriceChangeVo callPriceChange(Long projectId, Integer moduleId, Integer changeType, String adjCode) {
        NativeSQLBuilder<PriceChangeVo> query = NativeSQLBuilder.build(PriceChangeVo.class);
        query.setSql("CALL priceChange("+ projectId+","+moduleId+","+changeType+",'"+adjCode+"');");
        PriceChangeVo priceChangeVo = (PriceChangeVo) autoBaseDao.findOne(query);
        return priceChangeVo;
    }

    @Override
    public PriceChangeVo cllPriceChangeBack(Long projectId, Integer moduleId, Integer changeType, String adjCode) {
        NativeSQLBuilder<PriceChangeVo> query = NativeSQLBuilder.build(PriceChangeVo.class);
        query.setSql("CALL priceChangeBack(" + projectId + "," + moduleId + "," + changeType + ",'" + adjCode + "');");
        PriceChangeVo priceChangeVo = (PriceChangeVo) autoBaseDao.findOne(query);
        return priceChangeVo;
    }

    @Override
    public void batchCommit(String adjIds,  Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("SELECT * FROM catering_tcj_adjust\n" +
                        "WHERE is_delete = 0 and adj_id IN (" + adjIds + ") and project_id =" + projectId);
        List<CateringTcjAdjust> adjustModels = autoBaseDao.listAll(sql);
        Integer oldSize = adjustModels.size();
        adjustModels.removeIf(b -> 10700 != b.getAdjStatus().intValue());//排除掉不是新增状态的数据
        if (adjustModels.size() != oldSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在不是新增状态的数据，请重新选择！", null);
        }
        NativeSQLBuilder rcpt = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("UPDATE catering_tcj_adjust\n" );
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
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("SELECT * FROM catering_tcj_adjust\n" +
                        "WHERE is_delete = 0 and adj_id = " + adjId + " and project_id =" + projectId);
        CateringTcjAdjust adjust = (CateringTcjAdjust)autoBaseDao.findOne(sql);
        if (10704 != adjust.getAdjStatus()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "只能反审审核通过待生效的单据！", null);
        }

        //修改状态
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("UPDATE catering_tcj_adjust SET adj_status = 10703,\n" +
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
    public String getTaxRm(Long projectId, String rmIds, Integer suppId) {
        // 过滤掉 新增、待审核、审核驳回、待生效的税率调整单原材料
        NativeSQLBuilder sqlBuilder2 = NativeSQLBuilder.build(PhTaxVo.class)
                .setSql("SELECT t1.rm_id, t2.rm_ph_code FROM catering_ph_tax_dtl t1\n" +
                        "INNER JOIN catering_ph_tax t2 ON t2.project_id = t1.project_id and t1.rm_ph_id = t2.rm_ph_id \n" +
                        "WHERE t1.is_delete = 0 and t2.is_delete = 0 AND t1.rm_id IN (" + rmIds + ") AND t1.project_id = " + projectId + " AND t1.ph_status IN (155001, 155002, 155004, 155006)\n"
                );
        sqlBuilder2.append(" and t2.supp_id = " + suppId);
        List<PhTaxVo> phTaxVos = autoBaseDao.listAll(sqlBuilder2);
        if (null == phTaxVos || phTaxVos.size() == 0) {
            return null;
        }
        List<String> newRmIds = phTaxVos.stream().map(c -> {return c.getRmId().toString();}).collect(Collectors.toList());
        String newRmIdStr = this.listToString(newRmIds, ',');

        List<String> rmPhCodes = phTaxVos.stream().map(c -> {return c.getRmPhCode();}).collect(Collectors.toList());
        //去除重复的调价单号
        rmPhCodes = rmPhCodes.stream().distinct().collect(Collectors.toList());
        String rmPhCodeStr = this.listToString(rmPhCodes, ',');
        NativeSQLBuilder sqlBuilder3 = NativeSQLBuilder.build(String.class)
                .setSql("SELECT rm_Name FROM catering_tcb_rowmaterial WHERE is_delete = 0 AND rm_id IN (" + newRmIdStr + ") AND project_id = " + projectId);
        List<String> rmNames = autoBaseDao.listAll(sqlBuilder3);
        if (null != rmNames) {
            String rmNamesStr = this.listToString(rmNames, ',');
            return  "以下原材料：" + rmNamesStr + ";" +
                    "存在新增、待审核、审核驳回、待生效的税率调整单，" +
                    "原材料税率单号为：" + rmPhCodeStr  +
                    "。请先处理税率调整单后再添加调价单！";
        }
        return null;
    }

    @Override
    public List<CateringAdjustVo> excelOutAdjust(Long projectId, String adjIds, Integer adjStatus, String adjCode, String rmName) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringAdjustVo.class)
                .setSql("select t2.adj_code, t2.start_date, t2.end_date, t3.rm_code, t3.rm_name, t4.supp_name, t4.supp_code,\n" +
                        "(case when t2.adj_status = '10700' then '新增'\n" +
                        "when t2.adj_status = 10702 then '待审核'\n" +
                        "when t2.adj_status = 10703 then '审核驳回' \n" +
                        "when t2.adj_status = 10704 then '待生效'\n" +
                        "when t2.adj_status = 10705 then '生效中'\n" +
                        "when t2.adj_status = 10706 then '已失效'\n" +
                        "when t2.adj_status = 10707 then '已停用'\n" +
                        "when t2.adj_status = 10708 then '已作废' end) as adj_status,\n" +
                        "(select tax_name from catecomm_tsb_tax tax where t3.ph_tax_id = tax.tax_id and tax.project_id = t1.project_id) as tax_name,\n" +
                        "(select type_name from catecomm_tss_pubdatadict where catecomm_tss_pubdatadict.type_code = t5.srm_unit ) AS taxValue,\n" +
                        "(case when t2.adj_type = 10101 then '区间调价' else '永久调价' end) AS adj_type,\n" +
                        "t1.o_tax_price_in, t1.o_untax_price_in, t1.o_purchase_tax_paid, t1.o_purchase_no_tax_paid,\n" +
                        "t1.new_tax_price_in, t1.new_untax_price_in, t1.new_purchase_tax_paid, t1.new_purchase_no_tax_paid\n" +
                        "from  catering_tcj_adjust_detail t1\n" +
                        "left join  catering_tcj_adjust t2 on t2.adj_id = t1.adj_id and t2.project_id = t1.project_id\n" +
                        "inner join catering_tcb_rowmaterial t3 on t3.rm_id = t1.rm_id and t3.project_id = t1.project_id\n" +
                        "inner join commodity_tcb_supplier t4 on t4.supp_id = t1.supplier_id and t4.project_id = t1.project_id\n" +
                        "inner join catering_tcb_sale_rowmater t5 on t5.rm_id = t3.rm_id and t5.project_id = t1.project_id and t5.is_pur_chase_unit = 1\n" +
                        "where  t2.is_delete = 0  and t2.project_id = " + projectId);
        sqlBuilder.append(StringUtils.isNotEmpty(adjIds) ? " AND t2.adj_id IN (" + adjIds + ")\n" : "");
        sqlBuilder.append(null != adjStatus ? " AND t2.adj_status = " + adjStatus : "");
        sqlBuilder.append(StringUtils.isNotEmpty(adjCode) ? " AND t2.adj_code like '%" + adjCode + "%' \n" : "");
        sqlBuilder.append(StringUtils.isNotEmpty(rmName) ? " AND t3.rm_name like '%" + rmName + "%' \n" : "");
        return autoBaseDao.listAll(sqlBuilder);
    }


}
