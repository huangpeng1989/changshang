package com.goods.service.impi.allocation;


import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.WareJurisdictionFeign;
import com.goods.service.adjust.SaleadjustApi;
import com.goods.service.allocation.CollarUseService;
import com.goods.service.reportLoss.FreePromotionApi;
import com.goods.service.reportLoss.ReportLossApi;
import com.goods.service.reportLoss.ReturnOrderApi;
import entity.ModelPagedList;
import modelpojo.*;
import modelpojo.model.*;
import modelpojo.model.account.AccountModel;
import modelpojo.vo.*;
import modelpojo.vo.purchaseorreturn.BillCheckMthVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.DeleteBuilder;
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
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CollarUseServiceImpl implements CollarUseService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Long ORGID = 0L;

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    SaleadjustApi saleadjustApi;

    @Resource
    SupplierServiceFeign supplierService;

    @Resource
    ReportLossApi reportLossApi;

    @Resource
    ReturnOrderApi returnOrderBiz;

    @Resource
    WareJurisdictionFeign wareJurisdictionService;
    @Autowired
    FreePromotionApi freePromotionApi;


    @Override
    public ModelPagedList getRcptRtnList(CollarUseDto query, int pageNo, int pageSize, String orderBy, String type, Long accountId) {
        String whIds = wareJurisdictionService.getAccountWareJurisdictions(query.getProjectId(), accountId, 2);
        String beginRcptDate = null;
        String endRcptDate = null;
        if (StringUtils.isNotBlank(query.getRcptDate())) {
            String[] timeArray = query.getRcptDate().split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }

        String beginRtnDate = null;
        String endRtnDate = null;
        if (StringUtils.isNotBlank(query.getRtnDate())) {
            String[] timeArray = query.getRtnDate().split(" ");
            beginRtnDate = timeArray[0];
            endRtnDate = timeArray[1];
        }

        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CollarUseDto.class)
                .setSql("SELECT t1.*, \n" );
        if ("rcpt".equals(type)) {
            sqlBuilder.append("t3.type_name as rcpt_status_name, t4.nick_name as rcpt_emp, t5.nick_name as rcpt_nick_name, t6.org_name as rcpt_dept, t7.wh_name, t7.wh_id\n");
            sqlBuilder.append("FROM commodity_wh_rcpt_rtn_bill t1\n" +
                    "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.rcpt_status \n" +
                    "LEFT JOIN account t4 ON t4.id = t1.rcpt_emp_id \n" +
                    "LEFT JOIN account t5 ON t5.id = t1.rcpt_creater\n" +
                    "LEFT JOIN org_info t6 ON t6.id = t1.rcpt_dept_id\n" +
                    "LEFT JOIN catecomm_tsb_warehouse t7 ON t7.wh_id = t1.rcpt_rtn_wh_id  AND t7.project_id = t1.project_id\n");
                    //"LEFT JOIN ware_jurisdiction_info t8 ON t8.wh_id = t7.wh_id AND t8.project_id = t1.project_id AND t8.type = 2 AND t8.account_id = " + accountId);
            sqlBuilder.append("WHERE t1.project_id =" + query.getProjectId() + " and t1.rcpt_is_delete = 0");
            sqlBuilder.append(StringUtils.isNotBlank(beginRcptDate) ? ("and t1.rcpt_time between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
            sqlBuilder.append(null != query.getRcptRtnWhId() ? (" and t1.rcpt_rtn_wh_id =\n" + query.getRcptRtnWhId() + "\n") : "");
            sqlBuilder.append(StringUtils.isNotBlank(query.getRcptEmp()) ? ("and t4.nick_name like\n" + "'%" + (query.getRcptEmp()) + "%'\n") : "");
            sqlBuilder.append(StringUtils.isNotBlank(query.getRcptBillCode()) ? ("and t1.rcpt_bill_code like\n" + "'%" + (query.getRcptBillCode()) + "%'\n") : "");
            sqlBuilder.append(null != query.getRcptStatus() ? ("and t1.rcpt_status =\n" + (query.getRcptStatus()) + "\n") : "");
            sqlBuilder.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                    + "t1.rcpt_created_time desc");
        } else {
            sqlBuilder.append("t3.type_name as rtn_status_name, t4.nick_name as rtn_emp, t5.nick_name as rtn_nick_name, t6.org_name as rtn_dept, t7.wh_name,\n" +
                    "(SELECT nick_name FROM account WHERE account.id = t1.rcpt_emp_id) AS rcpt_emp,\n" +
            "(SELECT org_name FROM org_info WHERE org_info.id = t1.rcpt_dept_id) AS rcpt_dept, t7.wh_id\n");
            sqlBuilder.append("FROM commodity_wh_rcpt_rtn_bill t1\n" +
                    "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.rtn_status \n" +
                    "LEFT JOIN account t4 ON t4.id = t1.rtn_emp_id \n" +
                    "LEFT JOIN account t5 ON t5.id = t1.rtn_creater \n" +
                    "LEFT JOIN org_info t6 ON t6.id = t1.rtn_dept_id\n" +
                    "LEFT JOIN catecomm_tsb_warehouse t7 ON t7.wh_id = t1.rcpt_rtn_wh_id AND t7.project_id = t1.project_id\n");
            //"LEFT JOIN ware_jurisdiction_info t8 ON t8.wh_id = t7.wh_id AND t8.project_id = t1.project_id AND t8.type = 2 AND t8.account_id = " + accountId);
            sqlBuilder.append("WHERE t1.project_id =" + query.getProjectId() + " and t1.rtn_is_delete = 0 AND t1.rtn_status != 0");
            sqlBuilder.append(StringUtils.isNotBlank(beginRtnDate) ? ("and t1.rtn_time between CONCAT('" + beginRtnDate + "',' 00:00:00') and CONCAT('" + endRtnDate + "',' 23:59:59') ") : "");
            sqlBuilder.append(null != query.getRcptRtnWhId() ? (" and t1.rcpt_rtn_wh_id =\n" + query.getRcptRtnWhId() + "\n") : "");
            sqlBuilder.append(StringUtils.isNotBlank(query.getRtnEmp()) ? ("and t4.nick_name like\n" + "'%" + (query.getRtnEmp()) + "%'\n") : "");
            sqlBuilder.append(StringUtils.isNotBlank(query.getRcptBillCode()) ? ("and t1.rcpt_bill_code like\n" + "'%" + (query.getRcptBillCode()) + "%'\n") : "");
            sqlBuilder.append(StringUtils.isNotBlank(query.getRtnBillCode()) ? ("and t1.rtn_bill_code like\n" + "'%" + (query.getRtnBillCode()) + "%'\n") : "");
            sqlBuilder.append(null != query.getRtnStatus() ? ("and t1.rtn_status =\n" + (query.getRtnStatus()) + "\n") : "");
            sqlBuilder.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                    + "t1.rtn_created_time desc");
        }
        sqlBuilder.setPage(pageNo, pageSize);

        List<CaterCollarUseDto> list = autoBaseDao.listPage(sqlBuilder);
        new JurisdictionTypeUtil().getjurisdictionType(list, whIds);
        return ModelPagedList.convertToModelPage((PagedList) list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer rcptBillId, Long projectId, String type) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                .setSql("SELECT * FROM commodity_wh_rcpt_rtn_bill\n" +
                        "WHERE rcpt_bill_id =" + rcptBillId + "\n" +
                        "and project_id = " + projectId);
        CommodityWhRcptRtnBillModel rcptRtnBillModel = (CommodityWhRcptRtnBillModel)autoBaseDao.findOne(sqlBuilder);
        if ("rcpt".equals(type)) {//领用单
            if (1 == rcptRtnBillModel.getIsNeedRtn().intValue() && 12603 == rcptRtnBillModel.getRcptStatus().intValue()) {
                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "需要归还的领用单无法删除！", null);
            }
            if (12603 == rcptRtnBillModel.getRcptStatus().intValue()) {
                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "审核通过的领用单无法删除！", null);
            }
            rcptRtnBillModel.setRcptIsDelete(1);
        } else {//归还单
            if (12703 == rcptRtnBillModel.getRtnStatus()) {
                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "审核通过的归还单无法删除！", null);
            }
            rcptRtnBillModel.setRtnIsDelete(1);
        }
        UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhRcptRtnBillModel.class).setBean(rcptRtnBillModel).whereEq("rcptBillId", rcptBillId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "删除失败！", null);
        }
        CommodityWhRcptRtnBillDtlModel commodityWhAllotBillDtlModel = new CommodityWhRcptRtnBillDtlModel();
        commodityWhAllotBillDtlModel.setRcptBillId(rcptRtnBillModel.getRcptBillId());
        commodityWhAllotBillDtlModel.setIsDelete(1);
        UpdateBuilder updateDetailBuilder = UpdateBuilder.build(CommodityWhRcptRtnBillDtlModel.class).setBean(commodityWhAllotBillDtlModel).whereEq("rcptBillId", rcptBillId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateDetailBuilder) == 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "删除详情信息失败！", null);
        }
    }

    @Override
    public String getRcptBillCode(Long projectId, String type) {
        String code = saleadjustApi.sysGetBillCode(projectId, "commodity_wh_rcpt_rtn_bill");
        Integer id = supplierService.getTableId(projectId, "commodity_wh_rcpt_rtn_bill", 1);
        String str = "rcpt".equals(type) ? "RCPT" : "RTN";
        return str  + code + id;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void examine(String allotBillIds, Long accountId, Long projectId, String type, String status) {
        try {
            String auditStatus = status;
            NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                    .setSql("SELECT * FROM commodity_wh_rcpt_rtn_bill\n" +
                            "WHERE" +  ("rcpt".equals(type) ? "\nrcpt_is_delete = 0\n" : "\nrtn_is_delete = 0\n") +
                            "and rcpt_bill_id IN (" + allotBillIds + ") and project_id =" + projectId);
            List<CommodityWhRcptRtnBillModel> billModels = autoBaseDao.listAll(sql);
            int size = billModels.size();
            if ("rcpt".equals(type)) {
                billModels.removeIf(b -> 12602 == b.getRcptStatus()|| 12603 == b.getRcptStatus() || 12604 == b.getRcptStatus());
                if (billModels.size() != size) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "领用单存在已审核过的数据，请重新选择！", null);
                }
            } else {
                billModels.removeIf(b -> 12702 == b.getRtnStatus()|| 12703 == b.getRtnStatus());
                if (billModels.size() != size) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "归还单存在已审核过的数据，请重新选择！", null);
                }
            }

            for (CommodityWhRcptRtnBillModel model : billModels ) {
                if (1 == model.getIsNeedRtn() && "rcpt".equals(type) && "12603".equals(status)) {
                    status = "12604";
                }

                NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                        .setSql("UPDATE commodity_wh_rcpt_rtn_bill\n" +
                                ("rcpt".equals(type) ? "SET rcpt_status = " + status + ",\n" : "SET rtn_status = " + status + ",\n") +
                                ("rcpt".equals(type) ? "rcpt_bl_emp_id = " + accountId + ",\n" : "rtn_bl_emp_id = " + accountId + ",\n"));
                if (1 == model.getIsNeedRtn() && "rtn".equals(type) && "12703".equals(status)) {
                    supplier.append("rcpt_status = 12606,\n");
                }
                supplier.append("rcpt".equals(type) ? "rcpt_bl_time = NOW()\n" : "rtn_bl_time = NOW()\n");
                supplier.append("WHERE rcpt_bill_id = " + model.getRcptBillId() + " and project_id =" + projectId);

                //审核通过操作
                if (autoBaseDao.nativeExecute(supplier) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
                }

                if ("12603".equals(auditStatus) || "12703".equals(auditStatus)) {
                    if ("rcpt".equals(type)) {
                        BillCheckMthVo billCheckMthVo = returnOrderBiz.callBillCheckMth(projectId, model.getRcptBillId(), AdjustStatus.RCPT_TYPE_AUDIT, BarCodeConstant.COMMODITY, accountId, 0);
                        Boolean resultCode = billCheckMthVo.getRltcode();
                        String msg = billCheckMthVo.getMsg();
                        if (resultCode == false) {
                            throw new RpcException(300, "审核领用单信息时调用存储过程失败！错误信息是" + msg, null);
                        }
                    } else {
                        BillCheckMthVo billCheckMthVo = returnOrderBiz.callBillCheckMth(projectId, model.getRcptBillId(), AdjustStatus.RTN_TYPE_AUDIT, BarCodeConstant.COMMODITY, accountId, 0);
                        Boolean resultCode = billCheckMthVo.getRltcode();
                        String msg = billCheckMthVo.getMsg();
                        if (resultCode == false) {
                            throw new RpcException(300, "审核归还单信息时调用存储过程失败！错误信息是" + msg, null);
                        }
                    }
                }
            }
        }catch (Exception e) {
            throw new RpcException(300, "审核失败！错误信息是" + e.getMessage(), null);
        }


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCollar(CollarUseQuery query, Long accountId) {
        CommodityWhRcptRtnBillModel model = new CommodityWhRcptRtnBillModel();
        CommodityWhRcptRtnBillModel oldModel = this.checkCode(query);
        if (null != oldModel && oldModel.getRcptBillId().intValue() != query.getRcptBillId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  ("rcpt".equals(query.getType()) ? "领用单" : "归还单") + "编号已存在！", null);
        }
        try {
            ConvertUtils.register(new DateConverter(null), Date.class);
            BeanUtils.copyProperties(model, query);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if ("rcpt".equals(query.getType())) {
            model.setType(null);
            //model.setRcptStatus(12601);
            model.setRtnDeptId(model.getRcptDeptId());
            if (0 == model.getRcptBillId()) {
                model.setRcptCreater(accountId);
                model.setRcptCreatedTime(new Date());
                model.setRcptBillId(supplierService.getTableId(model.getProjectId(), "commodity_wh_rcpt_rtn_bill", 1));
                Map<String, Object> codeMap = this.getBarCode(model.getProjectId(), 10, 0,12206, model.getRcptBillId(), 4);
                if ((Boolean) codeMap.get("success")) {
                    model.setRcptBillBarcode(codeMap.get("code").toString());
                } else {
                    log.info("生成商品领用单条码失败，原因是：" + codeMap.get("msg"));
                }
                if (autoBaseDao.save(model) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存领用单失败！", null);
                }
            } else {
                model.setType(null);
                //避免修改录入人
                model.setRcptCreater(null);
                model.setRcptModifier(accountId);
                model.setRtnUpdatedTime(new Date());
                model.setRtnIsDelete(0);
                UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhRcptRtnBillModel.class).setBean(model).whereEq("rcptBillId", query.getRcptBillId())
                        .whereEq("projectId", model.getProjectId());
                if (autoBaseDao.update(updateBuilder) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改领用单保存失败！", null);
                }
            }
        } else {
            CommodityWhRcptRtnBillModel rtnModel = new CommodityWhRcptRtnBillModel();
            rtnModel.setRtnCreater(accountId);
            rtnModel.setRtnCreatedTime(new Date());
            rtnModel.setRtnModifier(accountId);
            rtnModel.setRtnUpdatedTime(new Date());
            //rtnModel.setRtnStatus(12701);
            rtnModel.setRtnStatus(model.getRtnStatus());
            rtnModel.setRtnBillCode(model.getRtnBillCode());
            rtnModel.setRcptBillId(model.getRcptBillId());
            rtnModel.setRtnTime(model.getRtnTime());
            rtnModel.setRtnRemark(model.getRtnRemark());
            rtnModel.setRtnEmpId(model.getRtnEmpId());
            rtnModel.setRtnDeptId(model.getRtnDeptId());
            rtnModel.setRtnIsDelete(0);
            Map<String, Object> codeMap = this.getBarCode(model.getProjectId(), 10, 0,12207, model.getRcptBillId(), 4);
            if ((Boolean) codeMap.get("success")) {
                model.setRtnBillBarcode(codeMap.get("code").toString());
            } else {
                log.info("生成商品归还单条码失败，原因是：" + codeMap.get("msg"));
            }
            rtnModel.setType(null);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhRcptRtnBillModel.class).setBean(rtnModel).whereEq("rcptBillId", query.getRcptBillId())
                    .whereEq("projectId", query.getProjectId());
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存归还单失败！", null);
            }

        }
        if (null != query.getDetailModels() && "rcpt".equals(query.getType())) {
            //删除子表之前的绑定关系
            DeleteBuilder detail = DeleteBuilder.build("commodity_wh_rcpt_rtn_bill_dtl").whereEq("rcpt_bill_id", query.getRcptBillId())
                    .whereEq("project_id", query.getProjectId());
            autoBaseDao.delete(detail);
            //删除后再做保存
            query.getDetailModels().forEach(b -> {
                b.setProjectId(model.getProjectId());
                b.setProjectRootId(model.getProjectRootId());
                b.setRcptBillId(model.getRcptBillId());
                b.setModifier(accountId);
                b.setCreater(accountId);
                if (autoBaseDao.save(b) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "保存详情信息失败！", null);
                }
            });
        } else {
            query.getDetailModels().forEach(b -> {
                NativeSQLBuilder updateBuilder = NativeSQLBuilder.build(CommodityWhRcptRtnBillDtlModel.class).setSql("update commodity_wh_rcpt_rtn_bill_dtl set rcpt_in_count = " + b.getRcptInCount() + "\n");
                updateBuilder.append("where project_id = " + query.getProjectId() + " and rcpt_bill_id = " + query.getRcptBillId() + " and com_id = " + b.getComId());
                if (autoBaseDao.nativeExecute(updateBuilder) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "保存归还单详情失败！", null);
                }
            });
        }
    }

    @Override
    public Map<String, Object> getBarCode(Long projectId, Integer moduleId, Integer primaryKey, Integer billType, Integer billId, Integer resultType) {
        Map<String, Object> map = new HashMap<>();
        NativeSQLBuilder builder = NativeSQLBuilder.build(BarCodeVo.class).setSql(
                "CALL Spt_ArtiBarCode_GeneChk (" + projectId + "," + moduleId + "," + primaryKey + "," + billType + "," +
                        billId + ",@num,@num2," + resultType + ");");

        BarCodeVo barCodeVos =  (BarCodeVo)autoBaseDao.findOne(builder);
        if (null == barCodeVos) {
            map.put("success", false);
            map.put("msg", "生成条码失败！");
        } else {
            if (barCodeVos.getCode().length() != 13) {
                map.put("success", false);
                map.put("msg", "生成条码失败,条码长度错误！");
            }
            map.put("success", true);
            map.put("code",  barCodeVos.getCode());
        }
        return map;
    }

    @Override
    public CollarUseDto queryById(Integer rcptBillId, Long projectId, String type) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CollarUseDto.class)
                .setSql("SELECT commodity_wh_rcpt_rtn_bill.*,\n" +
                        "(select wh_name from catecomm_tsb_warehouse where catecomm_tsb_warehouse.wh_id =  commodity_wh_rcpt_rtn_bill.rcpt_rtn_wh_id " +
                        " and catecomm_tsb_warehouse.project_id = "+projectId+" ) as whName, \n");
            sql.append("(select nick_name from account where commodity_wh_rcpt_rtn_bill.rcpt_emp_id =  account.id ) as rcptEmp,\n " +
                    "(select org_name from org_info where commodity_wh_rcpt_rtn_bill.rcpt_dept_id =  org_info.id and node_type='department' ) as rcptDept, \n");
            sql.append("(select nick_name from account where commodity_wh_rcpt_rtn_bill.rtn_emp_id =  account.id ) as rtnEmp, \n" +
                    "(select org_name from org_info where commodity_wh_rcpt_rtn_bill.rtn_dept_id =  org_info.id and node_type='department' ) as rtnDept, \n");

            sql.append("(select nick_name from account where commodity_wh_rcpt_rtn_bill.rcpt_creater =  account.id ) as rcptCreaterName,\n " +
                    "(select nick_name from account where commodity_wh_rcpt_rtn_bill.rtn_creater =  account.id) as rtnCreaterName, \n");

            sql.append("(select nick_name from account where commodity_wh_rcpt_rtn_bill.rcpt_bl_emp_id =  account.id ) as rcptBlEmp,\n " +
                    "(select nick_name from account where commodity_wh_rcpt_rtn_bill.rtn_bl_emp_id =  account.id) as rtnBlEmp \n");
            sql.append("FROM commodity_wh_rcpt_rtn_bill\n" +
                "WHERE  project_id = " + projectId + "\n" +
                "and rcpt_bill_id = " + rcptBillId + "\n" +
                (("rcpt".equals(type)) ? ("and rcpt_is_delete = 0") : ("and rtn_is_delete = 0")));
        CollarUseDto collarUseDto = (CollarUseDto) autoBaseDao.findOne(sql);
        return this.getDetail(collarUseDto);
    }

    @Override
    public ModelPagedList getOrgInfo(Integer pageNo, Integer pageSize, String name, Long orgId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(OrgInfoModel.class)
                .setSql("SELECT * FROM org_info \n" +
                "where node_type = 'department'\n");
        sql.append(StringUtils.isNotBlank(name) ? ("and org_name like\n" + "'%" + (name) + "%'\n") : "\n");
        sql.append("and manage_company_id = " + orgId);
        sql.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(sql));
    }

    @Override
    public List<AccountModel> getAccount(Long orgId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(AccountModel.class)
                .setSql("SELECT * FROM account \n" +
                        "WHERE dept_id = " + orgId);
        return autoBaseDao.listAll(sql);
    }

    @Override
    public ModelPagedList queryWare(Integer typeCode, String wareName, Integer isPurchaseWh, Integer whClass, Integer ststus, Long projectId, Integer pageNo, Integer pageSize, Long accountId, Integer inventType,Integer jurisdictionType,Integer inventory) {
        String whIds = wareJurisdictionService.getAccountWareJurisdictions(projectId, accountId, 1);
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CatecommTsbWarehouseModel.class)
                .setSql("SELECT t1.*,(CASE WHEN t1.ivt_status = 13803 THEN '商品-盘点启动中' ELSE '商品-未盘点' END) as ivtStatusName,\n" +
                        "\t (CASE WHEN t1.cater_status = 13801 THEN '餐饮-盘点启动中' ELSE '餐饮-未盘点' END) as caterStatusName,\n" +
                        "\t t2.type_name, t3.dict_tp_value as whClassName \n" +
                        "FROM catecomm_tsb_warehouse t1\n" +
                        "\t LEFT JOIN catecomm_tss_pubdatadict t2 ON t2.type_code = t1.wh_level\n" +
                        "\t LEFT JOIN catecomm_tss_datadict t3 ON t3.dict_tp_code = t1.wh_class AND t1.project_id = t3.project_id\n");
        if (null != inventType) {
            //判断是否过滤盘点中的仓库
            if(null == inventory){
                //10代表餐饮 20代表商品
                sqlBuilder.append(inventType == 10 ? " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级餐饮仓库' || t3.dict_tp_value = '营业点级餐饮仓库' ) \n"
                        : " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级商品仓库' || t3.dict_tp_value = '营业点级商品仓库' ) \n");
            }else{
                //10代表餐饮 20代表商品
                sqlBuilder.append(inventType == 10 ? " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级餐饮仓库' || t3.dict_tp_value = '营业点级餐饮仓库' ) \n"
                        : " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级商品仓库' || t3.dict_tp_value = '营业点级商品仓库' ) \n");
            }
        }
        sqlBuilder.append("\t WHERE t1.project_id = "+projectId+" and t1.is_delete = 0  and t1.is_start_using = 1 \n");
        sqlBuilder.append(StringUtils.isNotBlank(wareName) ? ("and t1.wh_name like\n" + "'%" + (wareName) + "%'\n") : "");
        sqlBuilder.append((null != typeCode) ? ("and t1.wh_level =" +  (typeCode) + "") : "");
        sqlBuilder.append((null != whClass) ? ("and t1.wh_class =" +  (whClass) + "") : "");
        if (ststus != null) {
            if (ststus == 13800 ) {  //餐饮未盘点
              sqlBuilder.append(" and ((t1.cater_status = 13802 OR t1.cater_status is null) and (t1.ivt_status = 13804 OR t1.ivt_status is null))\n");
            } else {
                sqlBuilder.append(" and ((t1.ivt_status = "+ststus+" OR t1.cater_status = "+ststus+"))\n");
            }
        }
        if (null != isPurchaseWh) {
            sqlBuilder.append(" and t1.is_purchase_wh = 1\n");
        }
        if (null != inventType) {
            //判断是否过滤盘点中的仓库
            if(null == inventory){
                //10代表餐饮 20代表商品
                sqlBuilder.append(inventType == 10 ? " and (t1.cater_status = 13802 or isnull(t1.cater_status))  \n"
                        : " and (t1.ivt_status = 13804 or isnull(t1.ivt_status)) \n");
            } /*else {
                //10代表餐饮 20代表商品
                sqlBuilder.append(inventType == 10 ? " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级餐饮仓库' || t3.dict_tp_value = '营业点级餐饮仓库' ) \n"
                        : " and (t3.dict_tp_value = '公司级仓库' || t3.dict_tp_value = '景区级商品仓库' || t3.dict_tp_value = '营业点级商品仓库' ) \n");
            }*/
        }

        //jurisdictionType为空时，控制仓库查询权限
        if(null == jurisdictionType){
            sqlBuilder.append(StringUtils.isNotEmpty(whIds) ? " and t1.wh_id IN( " + whIds + ")" : "");
        }
        sqlBuilder.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(sqlBuilder));
    }

    @Override
    public List<CommodityWhRcptRtnBillModel> getCollarUseList(Long projectId, Long accountId) {
        String whIds = wareJurisdictionService.getAccountWareJurisdictions(projectId, accountId, 1);
        NativeSQLBuilder sql = NativeSQLBuilder.build(CollarUseDto.class)
                .setSql("SELECT rcpt_bill_id, rcpt_bill_code FROM commodity_wh_rcpt_rtn_bill\n" +
                        "WHERE rcpt_is_delete = 0 and project_id = " + projectId + "\n" +
                "and rcpt_status = 12604 and (rtn_bill_code is null or rtn_is_delete = 1)");
        sql.append(StringUtils.isNotEmpty(whIds) ? "and rcpt_rtn_wh_id IN( " + whIds + ")" : " ");
        return autoBaseDao.listAll(sql);
    }

    @Override
    public ModelPagedList getSaleComm(String commClassCode, String name, Integer pageNo, Integer pageSize, Long projectId, Integer whId, String whStock) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CommodityStockNow.class)
                .setSql("SELECT t1.*,\n" );
        sqlBuilder.append("t2.com_name, t2.com_spec, t2.ph_tax_id, t2.ph_tax, t2.com_unit, t3.type_name, t2.com_class_code,\n");
        sqlBuilder.append("(SELECT tax_name FROM catecomm_tsb_tax WHERE t2.ph_tax_id = catecomm_tsb_tax.tax_id AND catecomm_tsb_tax.project_id = t2.project_id) AS tax_name,\n");
        sqlBuilder.append("t4.supp_id, t4.tax_paid, t4.no_tax_paid, t5.supp_code\n");
        sqlBuilder.append("FROM v_commodity_stock_now t1\n");
        sqlBuilder.append("INNER JOIN commodity_tcb_com t2 ON t2.com_id = t1.com_id and t1.project_id = t2.project_id\n");
        sqlBuilder.append("INNER JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t2.com_unit \n");
        sqlBuilder.append("LEFT JOIN commodity_tcb_suppcom t4 ON t4.com_id = t1.com_id and t1.project_id = t4.project_id\n");
        sqlBuilder.append("INNER JOIN commodity_tcb_salecom t6 ON t6.sale_com_id = t1.sale_com_id and t6.com_status = 1 and t6.sc_status = 10605 and t1.project_id = t6.project_id\n");
        sqlBuilder.append("INNER JOIN commodity_tcb_supplier t5 ON t5.supp_id = t4.supp_id and t1.project_id = t5.project_id\n");
        sqlBuilder.append("WHERE t1.project_id = " + projectId +  " and t1.wh_id =" + whId +"\n");
        sqlBuilder.append("and t2.is_delete = 0\n");
        sqlBuilder.append("and t6.is_default = 10\n");
        sqlBuilder.append("and t4.is_default = 10 and t4.is_delete = 0 \n");
        sqlBuilder.append("and t2.sell_status in(10201,10202,10203) \n");
        sqlBuilder.append(StringUtils.isNotBlank(commClassCode) ? ("and t2.com_class_code like '%"  + (commClassCode) + "%'\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(name) ? ("and (t2.com_name like" + "'%" + (name) + "%' OR t1.com_code like" + "'%" + (name) + "%')\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(whStock) ? ("AND t1.wh_stock >= " + Integer.valueOf(whStock) + "\n") : "");
        sqlBuilder.append(" group by t1.com_id");
        sqlBuilder.setPage(pageNo, pageSize);
        PagedList<CommodityStockNow> list = autoBaseDao.listPage(sqlBuilder);
        //2020-02-03新增需求
        if (null != list && list.size() > 0) {
            getCost(projectId,11005,list.getData());
            /*list.forEach(a -> {
                CatecommCostModel costModel = getCost(a.getComId(), a.getProjectId(),11005);
                if (null != costModel) {
                    a.setTaxcostPrice(costModel.getTaxcostprice());
                    a.setNotaxcostPrice(costModel.getNotaxcostprice());
                }
            });*/
        }
        return ModelPagedList.convertToModelPage(list);
    }

    /***
     * @Author huangpeng
     * @Description //查询原材料，半成品成本
     * @Date 16:59 2021/6/22
     * @Param
     * @return
     **/
    private void getCost(Long projectId,Integer goodType,List<CommodityStockNow> list){
        String ids = list.stream().map(a->String.valueOf(a.getComId())).collect(Collectors.joining(","));
        List<TreeMap> cost = freePromotionApi.getComCostPrice(projectId,10,goodType,ids);
        for(CommodityStockNow a :list){
            List<TreeMap> treeMaps = cost.stream().filter(b ->b.get("comId").equals(a.getComId())).collect(Collectors.toList());
            if(!treeMaps.isEmpty()){
                String comCostPrice = treeMaps.get(0).get("comCostPrice").toString();
                String notaxcostprice = treeMaps.get(0).get("notaxcostprice").toString();
                a.setTaxcostPrice(!comCostPrice.equals("0") ? new BigDecimal(comCostPrice).setScale(8,BigDecimal.ROUND_UP):new BigDecimal("0"));
                a.setNotaxcostPrice(!notaxcostprice.equals("0") ? new BigDecimal(notaxcostprice).setScale(8,BigDecimal.ROUND_UP) :new BigDecimal("0"));
            }else{
                a.setTaxcostPrice(new BigDecimal("0"));
                a.setNotaxcostPrice(new BigDecimal("0"));
            }
        }
    }

    private CatecommCostModel getCost(Integer comId, Long projectId, int goodType) {
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CatecommCostModel.class)
                .setSql("select  taxcostprice AS taxcostPrice,  notaxcostprice AS notaxcostPrice, MAX(dtime) AS dtime  from catecomm_cost \n" +
                        "where dtime<DateDiff(date_sub(now(),interval 1 day) ,'2000-01-01')\n" +
                        "and module_id = 10 and good_type = " + goodType + " AND comID = " + comId + " AND project_ID= " + projectId);
        return (CatecommCostModel)autoBaseDao.findOne(sqlBuilder);
    }


    @Override
    public String createReportLossBarCode(String billBarcode) {
        try {
            return reportLossApi.createBarCode(billBarcode);
        }catch (Exception e) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "生成报损/溢条形码失败！", null);
        }
    }

    @Override
    public List<CollarStatisticsDto> collarStatistics(CollarDetailedDto query, String type) {
        String beginRcptDate = null;
        String endRcptDate = null;
        if (StringUtils.isNotBlank(query.getRcptDate())) {
            String[] timeArray = query.getRcptDate().split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CollarStatisticsDto.class)
                .setSql("SELECT (CASE WHEN t2.rcpt_out_count = 0 THEN 0 ELSE SUM(t2.rcpt_out_count) END)  AS rcpt_out_count,\n" +
                        "(CASE WHEN t2.tax_cost = 0 THEN 0 ELSE SUM(t2.tax_cost) END) AS tax_cost,\n" +
                        "(CASE WHEN t2.tax_cost = 0 THEN 0 ELSE SUM(t2.tax_cost_amount) END)  AS tax_cost_amount,\n");
        sqlBuilder.append(("emp".equals(type)) ? ("(SELECT nick_name FROM account WHERE id = t1.rcpt_emp_id) AS rcptEmp\n") : ("(SELECT org_name FROM org_info WHERE id = t1.rcpt_dept_id) AS rcptDept\n"));
        sqlBuilder.append("FROM commodity_wh_rcpt_rtn_bill t1\n" +
                "LEFT JOIN commodity_wh_rcpt_rtn_bill_dtl t2 ON t2.rcpt_bill_id = t1.rcpt_bill_id AND t2.project_id = t1.project_id\n" +
                "LEFT JOIN commodity_tcb_com t3 ON t3.com_id = t2.com_id AND t3.project_id = t2.project_id\n" +
                "LEFT JOIN org_info t4 ON t4.id = t2.project_id\n" +
                "LEFT JOIN catecomm_tsb_warehouse t5 ON t5.wh_id = t1.rcpt_rtn_wh_id AND t5.project_id = t2.project_id\n" +
                "LEFT JOIN org_info t6 ON t6.id = t1.rcpt_dept_id\n" +
                "WHERE t1.rcpt_is_delete = 0 \n");
        sqlBuilder.append(" and t2.project_id IN (" + query.getOrgId() +") and t1.rcpt_rtn_wh_id IN ( " + query.getWhName() + ")");
        sqlBuilder.append(StringUtils.isNotBlank(beginRcptDate) ? ("and t1.rcpt_time between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
        sqlBuilder.append(null != query.getRcptDeptId() ? ("and t1.rcpt_dept_id =\n" + (query.getRcptDeptId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getOrgName()) ? ("and t4.org_name like\n" + "'%" + (query.getOrgName()) + "%'\n") : "");
        sqlBuilder.append(null != query.getRcptEmpId() ? ("and t1.rcpt_emp_id =\n" + (query.getRcptEmpId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComName()) ? ("and (t3.com_name like" + "'%" + (query.getComName()) + "%' OR t3.com_code like" + "'%" + (query.getComName()) + "%')\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComClassCode()) ? ("and t3.com_class_code like\n" + "'%" + (query.getComClassCode()) + "%'\n") : "");
        sqlBuilder.append(("emp".equals(type)) ? ("GROUP BY t1.rcpt_emp_id") : ("GROUP BY t1.rcpt_dept_id"));
        return autoBaseDao.listAll(sqlBuilder);
    }

    @Override
    public ModelPagedList collarDetailed(CollarDetailedDto query, int pageNo, int pageSize) {
        String beginRcptDate = null;
        String endRcptDate = null;
        if (StringUtils.isNotBlank(query.getRcptDate())) {
            String[] timeArray = query.getRcptDate().split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }

        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CollarDetailedDto.class)
                .setSql("SELECT \n" +
                        "t3.com_id,\n" +
                        "t4.org_name,\n" +
                        "t5.wh_code,\n"+
                        "t5.wh_name,\n" +
                        "t6.org_name AS rcptDept,\n" +
                        "t7.nick_name AS rcptEmp,\n" +
                        "t1.rcpt_time AS rcpt_time, t1.rcpt_bill_code, t2.com_code, \n" +
                        "t3.com_class_code, t3.com_name, t3.com_spec, \n" +
                        "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t3.com_unit) AS comUnitName,\n" +
                        "(SELECT tax_name FROM catecomm_tsb_tax WHERE t3.ph_tax_id = catecomm_tsb_tax.tax_id AND catecomm_tsb_tax.project_id = t3.project_id) AS tax_name,\n" +
                        "t2.rcpt_out_count, t2.tax_cost, t2.tax_cost_amount, t2.notax_cost, t2.notax_cost_amount\n" +
                        "FROM  \n" +
                        "commodity_wh_rcpt_rtn_bill t1 \n" +
                        "LEFT JOIN commodity_wh_rcpt_rtn_bill_dtl t2 ON t2.rcpt_bill_id = t1.rcpt_bill_id AND t2.project_id = t1.project_id\n" +
                        "LEFT JOIN commodity_tcb_com t3 ON t3.com_id = t2.com_id AND t3.project_id = t2.project_id\n" +
                        "LEFT JOIN org_info t4 ON t4.id = t2.project_id\n" +
                        "LEFT JOIN catecomm_tsb_warehouse t5 ON t5.wh_id = t1.rcpt_rtn_wh_id AND t5.project_id = t2.project_id\n" +
                        "LEFT JOIN org_info t6 ON t6.id = t1.rcpt_dept_id\n" +
                        "LEFT JOIN account t7 ON t7.id = t1.rcpt_emp_id\n" +
                        "WHERE t1.rcpt_is_delete = 0\n");
        sqlBuilder.append(" and t2.project_id IN (" + query.getOrgId()+") and t1.rcpt_rtn_wh_id IN ( " + query.getWhName() + ")");
        sqlBuilder.append(StringUtils.isNotBlank(beginRcptDate) ? ("and t1.rcpt_time between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
        sqlBuilder.append(null != query.getRcptDeptId() ? ("and t1.rcpt_dept_id =\n" + (query.getRcptDeptId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getOrgName()) ? ("and t4.org_name like\n" + "'%" + (query.getOrgName()) + "%'\n") : "");
        sqlBuilder.append(null != query.getRcptEmpId() ? ("and t1.rcpt_emp_id =\n" + (query.getRcptEmpId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComName()) ? ("and (t3.com_name like" + "'%" + (query.getComName()) + "%' OR t3.com_code like" + "'%" + (query.getComName()) + "%')\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComClassCode()) ? ("and t3.com_class_code like\n" + "'%" + (query.getComClassCode()) + "%'\n") : "");
        sqlBuilder.append("ORDER BY t3.com_class_code DESC");
        sqlBuilder.setPage(pageNo, pageSize);

        PagedList<CollarDetailedDto> list = autoBaseDao.listPage(sqlBuilder);
        list.forEach(a -> {
            //2020-02-03新增需求
            CatecommCostModel costModel = getCost(a.getComId(), query.getOrgId(), 11005);
            if (null != costModel) {
                a.setTaxcostPrice(costModel.getTaxcostprice());
                a.setNotaxcostPrice(costModel.getNotaxcostprice());
            }
            //查询当前商品分类编号的上级编号
            NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                    .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id, ucom_class_code \n" +
                            "FROM commodity_tcc_comclass \n" +
                            "WHERE com_class_code = '" + a.getComClassCode() + "' and project_id = " + query.getOrgId());
            CommodityTccComclassModel comFClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sql);

            CommodityTccComclassModel comFMaxClassModel = null;
            //组装最大父级的商品分类编号
            if (null != comFClassModel && comFClassModel.getUcomClassId().intValue() != 0) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                        .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id = (SELECT com_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id =" + comFClassModel.getUcomClassId() +" AND project_id =" + query.getOrgId() + ")\n" +
                "AND project_id = " + query.getOrgId());
                comFMaxClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sqlMax);
            }
            CommodityTccComclassModel comFMaxMaxClassModel = null;
            if (null != comFMaxClassModel && comFMaxClassModel.getUcomClassId().intValue() != 0) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                        .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id = (SELECT com_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id =" + comFMaxClassModel.getUcomClassId() +" AND project_id =" + query.getOrgId() + ")\n" +
                                "AND project_id = " + query.getOrgId());
                comFMaxMaxClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sqlMax);
            }
            if (null != comFMaxMaxClassModel) {
                a.setComCodeNameOne(comFMaxMaxClassModel.getComClassName() + "[" + comFMaxMaxClassModel.getComClassCode() + "]");
                a.setComCodeNameSend(comFMaxClassModel.getComClassName() + "[" + comFMaxClassModel.getComClassCode() + "]");
                a.setComCodeNameThree(comFClassModel.getComClassName() + "[" + comFClassModel.getComClassCode() + "]");
            }
            if (null == comFMaxMaxClassModel && null != comFMaxClassModel) {
                a.setComCodeNameOne(comFMaxClassModel.getComClassName() + "[" + comFMaxClassModel.getComClassCode() + "]");
                a.setComCodeNameSend(comFClassModel.getComClassName() + "[" + comFClassModel.getComClassCode() + "]");
            }
            if (null == comFMaxMaxClassModel && null == comFMaxClassModel && null != comFClassModel) {
                a.setComCodeNameOne(comFClassModel.getComClassName() + "[" + comFClassModel.getComClassName() + "]");
            }
        });

        return ModelPagedList.convertToModelPage(list);
    }

    @Override
    public CollarDetailedDto collarDetailedSum(CollarDetailedDto query) {
        String beginRcptDate = null;
        String endRcptDate = null;
        if (StringUtils.isNotBlank(query.getRcptDate())) {
            String[] timeArray = query.getRcptDate().split(" ");
            beginRcptDate = timeArray[0];
            endRcptDate = timeArray[1];
        }

        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CollarDetailedDto.class)
                .setSql("SELECT  \n" +
                        "SUM(t2.rcpt_out_count) AS rcpt_out_count, SUM(t2.tax_cost_amount) AS tax_cost_amount, SUM(t2.notax_cost_amount) AS notax_cost_amount \n" +
                        "FROM  \n" +
                        "commodity_wh_rcpt_rtn_bill t1  \n" +
                        "LEFT JOIN commodity_wh_rcpt_rtn_bill_dtl t2 ON t2.rcpt_bill_id = t1.rcpt_bill_id AND t2.project_id = t1.project_id\n" +
                        "LEFT JOIN commodity_tcb_com t3 ON t3.com_id = t2.com_id AND t3.project_id = t2.project_id\n" +
                        "LEFT JOIN org_info t4 ON t4.id = t2.project_id \n" +
                        "LEFT JOIN catecomm_tsb_warehouse t5 ON t5.wh_id = t1.rcpt_rtn_wh_id AND t5.project_id = t2.project_id \n" +
                        "LEFT JOIN org_info t6 ON t6.id = t1.rcpt_dept_id \n" +
                        "LEFT JOIN account t7 ON t7.id = t1.rcpt_emp_id \n" +
                        "WHERE t1.rcpt_is_delete = 0");
        sqlBuilder.append(" and t2.project_id IN (" + query.getOrgId()+") and t1.rcpt_rtn_wh_id IN ( " + query.getWhName() + ")");
        sqlBuilder.append(StringUtils.isNotBlank(beginRcptDate) ? ("and t1.rcpt_time between CONCAT('" + beginRcptDate + "',' 00:00:00') and CONCAT('" + endRcptDate + "',' 23:59:59') ") : "");
        sqlBuilder.append(null != query.getRcptDeptId() ? ("and t1.rcpt_dept_id =\n" + (query.getRcptDeptId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getOrgName()) ? ("and t4.org_name like\n" + "'%" + (query.getOrgName()) + "%'\n") : "");
        sqlBuilder.append(null != query.getRcptEmpId() ? ("and t1.rcpt_emp_id =\n" + (query.getRcptEmpId()) + "\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComName()) ? ("and (t3.com_name like" + "'%" + (query.getComName()) + "%' OR t3.com_code like" + "'%" + (query.getComName()) + "%')\n") : "");
        sqlBuilder.append(StringUtils.isNotBlank(query.getComClassCode()) ? ("and t3.com_class_code like\n" + "'%" + (query.getComClassCode()) + "%'\n") : "");
        return (CollarDetailedDto) autoBaseDao.findOne(sqlBuilder);
    }

    private CommodityWhRcptRtnBillModel checkCode(CollarUseQuery query) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                .setSql("SELECT * FROM commodity_wh_rcpt_rtn_bill  WHERE\n" +
                        ("rcpt".equals(query.getType()) ? "rcpt_bill_code = '" + query.getRcptBillCode() + "'\n" : "rtn_bill_code = '" + query.getRtnBillCode() + "'\n") +
                        "and project_id = " + query.getProjectId());
        return (CommodityWhRcptRtnBillModel)autoBaseDao.findOne(supplier);
    }

    public List<OrgInfoModel> queryByOrg(Long orgId, String nodeType) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(OrgInfoModel.class)
                .setSql("SELECT * FROM org_info  WHERE\n" +
                        "manage_company_id = " + orgId + " and node_type = '" + nodeType + "' and deleted = 'false'");
        return autoBaseDao.listAll(queryBuilder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchCommit(String rcptBillIds, Long projectId, String type) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                .setSql("SELECT * FROM commodity_wh_rcpt_rtn_bill  WHERE\n" +
                        "rcpt_bill_id IN(" + rcptBillIds + ")\n" +
                        "and project_id = " + projectId);
        List<CommodityWhRcptRtnBillModel> rcptRtnBillModels = autoBaseDao.listAll(supplier);
        Integer oldSize = rcptRtnBillModels.size();
        rcptRtnBillModels.removeIf("rcpt".equals(type) ? b -> 12607 != b.getRcptStatus().intValue() : b -> 12707 != b.getRtnStatus().intValue());//排除掉不是新增状态的数据
        if (rcptRtnBillModels.size() != oldSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在不是新增状态的数据，请重新选择！", null);
        }
        NativeSQLBuilder rcpt = NativeSQLBuilder.build(CommodityWhRcptRtnBillModel.class)
                .setSql("UPDATE commodity_wh_rcpt_rtn_bill\n" );
        rcpt.append("rcpt".equals(type) ? "SET rcpt_status = 12601 \n" : "SET rtn_status = 12701 \n");
        rcpt.append("WHERE rcpt_bill_id IN(" + rcptBillIds + ")\n");
        rcpt.append("AND project_id = " + projectId);
        if (autoBaseDao.nativeExecute(rcpt) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "批量提交失败！", null);
        }
    }

    private CollarUseDto getDetail(CollarUseDto rcptDto) {
        NativeSQLBuilder disSpe = NativeSQLBuilder.build(CommodityWhRcptRtnBillDtlModel.class)
                .setSql("SELECT t1.*, t3.com_id, t2.wh_stock, t3.com_name, t3.com_spec, t4.type_name, t2.sale_com_barcode \n" +
                        "FROM commodity_wh_rcpt_rtn_bill_dtl t1\n" +
                        "LEFT JOIN v_commodity_stock_now t2  ON t2.com_id = t1.com_id and t2.project_id = t1.project_id and t2.wh_id = "+ rcptDto.getRcptRtnWhId() + "\n" +
                        "INNER JOIN commodity_tcb_com t3 ON t3.com_id = t1.com_id and t3.project_id = t1.project_id\n" +
                        "INNER JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t3.com_unit \n" +
                        "WHERE t1.is_delete = 0 \n");
        disSpe.append("and t1.project_id =" + rcptDto.getProjectId() +"\n");
        disSpe.append("and t1.rcpt_bill_id = " +  rcptDto.getRcptBillId() +"\n");
        disSpe.append("GROUP BY t1.project_id, t1.rcpt_bill_id, t1.project_root_id, t1.com_code, t1.com_id, t1.sale_com_id, \n" +
                "    t1.sale_com_unit, t1.sale_pack_content, t1.sale_com_code, t1.rcpt_out_count, t1.rcpt_in_count, t1.bch_tax_cost, \n" +
                "    t1.bch_notax_cost, t1.avg_tax_cost, t1.avg_notax_cost, t1.tax_cost, t1.notax_cost, t1.tax_cost_amount, \n" +
                "    t1.notax_cost_amount, t1.batch_id, t1.is_delete, t1.creater, t1.modifier");
        List<CommodityWhRcptRtnBillDtlModel> dtlModels = autoBaseDao.listAll(disSpe);
        //2020-02-03新增需求
        if (null != dtlModels && dtlModels.size() > 0) {
            dtlModels.forEach(b -> {
                CatecommCostModel costModel = getCost(b.getComId(), b.getProjectId(),11005);
                if (null != costModel) {
                    b.setNotaxcostPrice(costModel.getNotaxcostprice());
                    b.setTaxcostPrice(costModel.getTaxcostprice());
                }
            });
        }
        rcptDto.setDetailModels(dtlModels);
        return  rcptDto;
    }
}
