package com.goods.service.impi.reportLoss;


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
import modelpojo.vo.CommodityLossBillSummaryVo;
import modelpojo.vo.CommodityWhHandOfLossBillVo;
import modelpojo.vo.purchaseorreturn.BillCheckMthVo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.QueryBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 报损/溢业务层
 * @Author wenbin.wang
 * @Date 2019-09-17 17:02
 */
@Service
public class ReportLossBiz implements ReportLossApi {

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    SupplierServiceFeign supplierService;

    @Resource
    SaleadjustApi saleadjustApi;

    @Resource
    CollarUseService collarUseService;

    @Resource
    private ReturnOrderApi returnOrderBiz;

    @Resource
    WareJurisdictionFeign wareJurisdictionService;

    @Autowired
    FreePromotionApi freePromotionApi;

    @Override
    public ModelPagedList<CommodityWhHandOfLossBill> reportLossList(Integer mhId, String startOlBillDate, String endOlBillDate,
                                                                    String olBillCode, Integer olStatus, Integer billType, Long projectId,
                                                                    Long projectRootId, Integer pageNo, Integer pageSize,
                                                                    Long accountId) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        NativeSQLBuilder lossBillSql = NativeSQLBuilder.build(CommodityWhHandOfLossBill.class)
                .setSql("select t1.*,(select t2.wh_name from catecomm_tsb_warehouse t2 where t1.wh_id = t2.wh_id" +
                        "\tand t1.project_id = t2.project_id and t2.is_delete = 0) as whName,\n" +
                        "\t(select t3.nick_name from account t3 where t3.id = t1.ol_emp_id) as olEmpStr,\n" +
                        "\t(select t4.nick_name from account t4 where t4.id = t1.ol_creater) as createrStr,\n" +
                        "\t(select t4.nick_name from account t4 where t4.id = t1.ol_bl_emp_id) as olBlEmpStr\n" +
                        "\tfrom commodity_wh_hand_of_loss_bill t1 where t1.is_delete = 0" +
                        "\t and t1.project_id = "+projectId+
                        "\t and t1.project_root_id ="+projectRootId+
                        "\t and t1.bill_type = "+billType);
        if (mhId != null) {
            lossBillSql.append("and t1.wh_id = "+mhId+"");
        }

        // 创建开始时间
        if (StringUtils.isNotBlank(startOlBillDate)  && StringUtils.isNotBlank(endOlBillDate)) {
            lossBillSql.append(" and t1.ol_bill_date between CONCAT('" + startOlBillDate + "',' 00:00:00') and CONCAT('" + endOlBillDate + "',' 23:59:59') ");
        }

        if (StringUtils.isNotBlank(olBillCode) ) {
            lossBillSql.append("and t1.ol_bill_code  like '%"+olBillCode+"%' ");
        }
        if (olStatus != null) {
            lossBillSql.append("and t1.ol_status = "+olStatus+"");
        }
        lossBillSql.append("order by t1.created_time desc");
        lossBillSql.setPage(pageNo,pageSize);
        PagedList<CommodityWhHandOfLossBill> pagedList = autoBaseDao.listPage(lossBillSql);
        String whIds = wareJurisdictionService.getAccountWareJurisdictions(projectId, accountId, 2);
        new JurisdictionTypeUtil().getjurisdictionType(pagedList.getData(),whIds);
        return ModelPagedList.convertToModelPage(pagedList);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void updateReportLoss(CommodityWhHandOfLossBill lossBill, Long accoutId, Long projectId, Long projectRootId) {
        lossBill.setOlModifier(accoutId);
        lossBill.setSyncStatus(10);
        lossBill.setOlStatus(AdjustStatus.LOSSBILL_TYPE_AUDIT);
        UpdateBuilder whHandOfLossBill = UpdateBuilder.build(CommodityWhHandOfLossBill.class).setBean(lossBill).whereEq("olBillId",lossBill.getOlBillId()).whereEq("project_id",projectId);
        if (autoBaseDao.update(whHandOfLossBill) == 0) {
            throw new RpcException(300, ErrorCode.TERMINAL_ERROR +  "修改报损/溢信息失败！", null);
        }
        List<CommodityWhHandOfLossBillDtl> reportLossDetailList = lossBill.getReportLossDetailList();
        NativeSQLBuilder deleteBuild = NativeSQLBuilder.build(CommodityWhHandOfLossBillDtl.class)
                .setSql("delete from commodity_wh_hand_of_loss_bill_dtl where  project_id = " + projectId +
                        "\tand ol_bill_id= " + lossBill.getOlBillId());
        autoBaseDao.nativeExecute(deleteBuild);

        reportLossDetailList.forEach(b->{
            CommodityWhHandOfLossBillDtl lossBillDtl = new CommodityWhHandOfLossBillDtl();
            lossBillDtl.setProjectId(projectId);
            lossBillDtl.setProjectRootId(projectRootId);
            lossBillDtl.setComId(b.getComId());
            lossBillDtl.setComCode(b.getComCode());
            lossBillDtl.setCreater(accoutId);
            lossBillDtl.setModifier(accoutId);
            lossBillDtl.setOlBillId(lossBill.getOlBillId());
            lossBillDtl.setfEntryId(b.getfEntryId());
            lossBillDtl.setSaleComId(b.getSaleComId());
            lossBillDtl.setSaleComUnit(b.getSaleComUnit());
            lossBillDtl.setSalePageContent(b.getSalePageContent());
            lossBillDtl.setPlCount(b.getPlCount());
            lossBillDtl.setTaxCost(b.getTaxCost());
            lossBillDtl.setTaxId(b.getTaxId());
            lossBillDtl.setTaxName(b.getTaxName());
            lossBillDtl.setNotaxCost(b.getNotaxCost());

            // 供应商商品信息
            lossBillDtl.setSuppId(b.getSuppId());
            lossBillDtl.setSuppCode(b.getSuppCode());
            lossBillDtl.setSupTaxCost(b.getSupTaxCost());
            lossBillDtl.setSupNotaxCost(b.getSupNotaxCost());

            lossBillDtl.setTaxCostAmount(b.getTaxCostAmount());
            lossBillDtl.setNotaxCostAmount(b.getNotaxCostAmount());
            lossBillDtl.setSyncStatus(10);
            if (autoBaseDao.save(lossBillDtl) == 0) {
                throw new RpcException(300, ErrorCode.TERMINAL_ERROR +  "修改中--保存报损/溢子表信息失败！", null);
            }
        });


    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void addReportLoss(CommodityWhHandOfLossBill lossBill, Long projectId, Long projectRootId, Long accoutId) {
        lossBill.setProjectId(projectId);
        lossBill.setProjectRootId(projectRootId);
        lossBill.setOlCreater(accoutId);
        lossBill.setOlModifier(accoutId);
        lossBill.setSyncStatus(10);
        lossBill.setOlEmpId(accoutId);
        lossBill.setOlStatus(AdjustStatus.LOSSBILL_TYPE_AUDIT);
        Integer olBillId = supplierService.getTableId(projectId,"commodity_wh_hand_of_loss_bill", 1);
        lossBill.setOlBillId(olBillId);
        if (StringUtils.isBlank(lossBill.getBillBarcode())) {
            Map<String, Object> barCodeMap = collarUseService.getBarCode(projectId, 20, 0, lossBill.getBillType(), olBillId,4);
            if ((boolean)barCodeMap.get("success") == true) {
                String barCode = (String)barCodeMap.get("code");
                lossBill.setBillBarcode(barCode);
            }
        }

        if (autoBaseDao.save(lossBill) == 0) {
            throw new RpcException(300, ErrorCode.TERMINAL_ERROR +  "保存报损/溢信息失败！", null);
        }

        List<CommodityWhHandOfLossBillDtl> reportLossDetailList = lossBill.getReportLossDetailList();
        reportLossDetailList.forEach(b->{
            CommodityWhHandOfLossBillDtl lossBillDtl = new CommodityWhHandOfLossBillDtl();
            lossBillDtl.setProjectId(projectId);
            lossBillDtl.setProjectRootId(projectRootId);
            lossBillDtl.setComId(b.getComId());
            lossBillDtl.setComCode(b.getComCode());
            lossBillDtl.setCreater(accoutId);
            lossBillDtl.setModifier(accoutId);
            lossBillDtl.setOlBillId(olBillId);
            lossBillDtl.setfEntryId(b.getfEntryId());
            lossBillDtl.setSaleComId(b.getSaleComId());
            lossBillDtl.setSaleComUnit(b.getSaleComUnit());
            lossBillDtl.setSalePageContent(b.getSalePageContent());
            lossBillDtl.setPlCount(b.getPlCount());
            lossBillDtl.setTaxId(b.getTaxId());
            lossBillDtl.setTaxName(b.getTaxName());
            lossBillDtl.setSyncStatus(10);
            lossBillDtl.setTaxCost(b.getTaxCost());
            lossBillDtl.setNotaxCost(b.getNotaxCost());
            lossBillDtl.setTaxCostAmount(b.getTaxCostAmount());
            lossBillDtl.setNotaxCostAmount(b.getNotaxCostAmount());
            // 供应商商品信息
            lossBillDtl.setSuppId(b.getSuppId());
            lossBillDtl.setSuppCode(b.getSuppCode());
            lossBillDtl.setSupTaxCost(b.getSupTaxCost());
            lossBillDtl.setSupNotaxCost(b.getSupNotaxCost());
            if (autoBaseDao.save(lossBillDtl) == 0) {
                throw new RpcException(300, ErrorCode.TERMINAL_ERROR +  "保存报损/溢子表信息失败！", null);
            }
        });
    }

    @Override
    public CommodityWhHandOfLossBill getReportLossInfo(Long projectId, Long projectRootId, Integer billType, Integer olBillId) {
        NativeSQLBuilder lossBillSql = NativeSQLBuilder.build(CommodityWhHandOfLossBill.class)
                .setSql("select t1.*,(select t2.wh_name from catecomm_tsb_warehouse t2 where t1.wh_id = t2.wh_id\n" +
                        "\t and t1.project_id = t2.project_id and t2.is_delete = 0) as whName,\n" +
                        "\t (select t3.nick_name from account t3 where t3.id = t1.ol_emp_id) as olEmpStr,\n" +
                        "\t (select t4.nick_name from account t4 where t4.id = t1.ol_bl_emp_id) as olBlEmpStr,\n" +
                        "\t (select t5.nick_name from account t5 where t5.id = t1.ol_emp_id) as createrStr\n" +
                        "\t from commodity_wh_hand_of_loss_bill t1\n"+
                        "\t where t1.is_delete = 0" +
                        "\t and t1.project_id = "+projectId+
                        "\t and t1.project_root_id ="+projectRootId+
                        "\t and t1.ol_bill_id ="+olBillId+
                        "\t and t1.bill_type = "+billType);
        CommodityWhHandOfLossBill lossBill = (CommodityWhHandOfLossBill)autoBaseDao.findOne(lossBillSql);
        String str = getLossBillStats(billType,projectId,olBillId);
        NativeSQLBuilder lossBillDetailSql = NativeSQLBuilder.build(CommodityWhHandOfLossBillDtl.class)
                .setSql("select t4.*,t5.com_spec,t5.com_name,t5.com_unit,t7.comm_spec,t7.comm_unit,t7.com_barcode,\n" +
                        "\t (select t8.type_name from catecomm_tss_pubdatadict t8 where t7.comm_unit = t8.type_code) as commUnitName,\n"+
                        "\t (select t9.tax_name from catecomm_tsb_tax t9 where t4.tax_id = t9.tax_id and t4.project_id = t9.project_id) as taxName,"+
                        "\t t7.pack_content,t6.tax_paid,t6.no_tax_paid,t8.wh_stock\n" +
                        "\t from commodity_wh_hand_of_loss_bill_dtl t4\n" +
                        "\t inner join commodity_tcb_com t5 on t4.com_id = t5.com_id and t4.is_delete = 0 and t4.project_id = t5.project_id\n" +
                        "\t inner join commodity_tcb_suppcom t6 on t4.com_id = t6.com_id and t6.is_default = 10 and t4.project_id = t6.project_id\n" +
                        "\t inner join commodity_tcb_salecom t7 on t4.sale_com_id = t7.sale_com_id and t4.project_id = t7.project_id\n"+
                        "\t LEFT JOIN v_commodity_stock_now t8 on t4.project_id = t8.project_id and t8.wh_id = "+lossBill.getWhId() +
                        "\t and t4.com_id = t8.com_id\n"+
                        "\t WHERE t7.is_default = 10" +
                        "\t and t4.is_delete = 0" +
                        "\t and t4.project_id = "+projectId+
                        "\t and t4.project_root_id ="+projectRootId+
                        "\t and t4.ol_bill_id = "+lossBill.getOlBillId()+
                        "\t group by t4.project_id,t4.project_root_id,t4.ol_bill_id,t4.com_id,t4.com_code,t4.sale_com_id,t4.sale_com_unit,\n" +
                        "\t t4.sale_page_content,t4.tax_cost,t4.notax_cost,t4.tax_cost_amount,t4.notax_cost_amount");
        List<CommodityWhHandOfLossBillDtl> lossBillDtlList = autoBaseDao.listAll(lossBillDetailSql);
        if(StringUtils.isNotEmpty(str) && lossBill.getBillType() == 12209 && "预估".equals(str)){
            lossBill.setStockStatus(12101);
            getCost(projectId, 11005,lossBillDtlList);
        }else if(lossBill.getBillType() == 12209){
            lossBill.setStockStatus(12103);
        }
        lossBill.setReportLossDetailList(lossBillDtlList);
        return lossBill;
    }

    private String getLossBillStats(Integer billType,Long projectId,Integer olBillId){
        NativeSQLBuilder builder=NativeSQLBuilder.build(String.class).setSql(" " +
                "SELECT \n"+
                "CASE WHEN ISNULL(ol_bl_time) OR  ISNULL (ol_status) OR ol_status !=12503 OR (ol_status =12503 AND DATE(NOW()) <= DATE(ol_bl_time))   THEN '预估' ELSE '最终' END AS yuGu\n" +
                "FROM commodity_wh_hand_of_loss_bill WHERE project_id="+projectId+" AND ol_bill_id="+olBillId+" and bill_type = "+billType+"");
        String str=(String)autoBaseDao.findOne(builder);
        return  str;
    }


    /***
     * @Author huangpeng
     * @Description //查询商品成本
     * @Date 16:59 2021/6/22
     * @Param
     * @return
     **/
    public void getCost(Long projectId,Integer goodType,List<CommodityWhHandOfLossBillDtl> list){
        String ids = list.stream().map(a->String.valueOf(a.getComId())).collect(Collectors.joining(","));
        List<TreeMap> cost = freePromotionApi.getComCostPrice(projectId,10,goodType,ids);
        for(CommodityWhHandOfLossBillDtl a :list){
            List<TreeMap> treeMaps = cost.stream().filter(b ->b.get("comId").equals(a.getComId())).collect(Collectors.toList());
            if(!treeMaps.isEmpty()){
                String comCostPrice = treeMaps.get(0).get("comCostPrice").toString();
                String notaxcostprice = treeMaps.get(0).get("notaxcostprice").toString();
                a.setTaxCost(!comCostPrice.equals("0") ? new BigDecimal(comCostPrice).setScale(8,BigDecimal.ROUND_UP):new BigDecimal("0"));
                a.setNotaxCost(!notaxcostprice.equals("0") ? new BigDecimal(notaxcostprice).setScale(8,BigDecimal.ROUND_UP) :new BigDecimal("0"));
                a.setTaxCostAmount(a.getTaxCost().multiply(a.getPlCount()).setScale(8,BigDecimal.ROUND_UP));
                a.setNotaxCostAmount(a.getNotaxCost().multiply(a.getPlCount()).setScale(8,BigDecimal.ROUND_UP));
            }else{
                a.setTaxCost(new BigDecimal("0"));
                a.setNotaxCost(new BigDecimal("0"));
                a.setTaxCostAmount(new BigDecimal("0"));
                a.setNotaxCostAmount(new BigDecimal("0"));
            }
        }
    }

    @Override
    public void delReportLoss(Long projectId, Long projectRootId, Integer billType, Integer olBillId,Long accountId) {
        QueryBuilder<CommodityWhHandOfLossBill> lossBillBuilder = QueryBuilder.build(CommodityWhHandOfLossBill.class)
                .whereEq("ol_bill_id",olBillId).whereEq("project_id",projectId).whereEq("project_root_id",projectRootId)
                .whereEq("bill_type",billType);
        CommodityWhHandOfLossBill lossBill = autoBaseDao.findOne(lossBillBuilder);
        if (lossBill.getOlStatus() == AdjustStatus.LOSSBILL_TYPE_ADOPT) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER +  "不能删除已审核通过的报损/溢单！", null);
        }
        lossBill.setIsDelete((byte) 1);
        lossBill.setOlModifier(accountId);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityWhHandOfLossBill.class).setBean(lossBill).whereEq("ol_bill_id",olBillId).whereEq("project_id",projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER +  "删除报损/溢信息失败！", null);
        }
    }

    @Override
    public void toExamineReportLoss(Long projectId, Long projectRootId, Integer billType, Integer olStatus, String olBillId, Long accountId)throws Exception {
        String[] olBillIds = olBillId.split(",");
        for (int i = 0; i <olBillIds.length ; i++) {
            NativeSQLBuilder select = NativeSQLBuilder.build(CommodityWhHandOfLossBill.class)
                    .setSql("select * from commodity_wh_hand_of_loss_bill where bill_type = " + billType + " and is_delete=0 and project_id = " + projectId +
                            "\tand ol_bill_id= " + olBillIds[i] + "");
            CommodityWhHandOfLossBill lossBill = (CommodityWhHandOfLossBill) autoBaseDao.findOne(select);
            if (lossBill.getOlStatus() != AdjustStatus.LOSSBILL_TYPE_AUDIT) {
                throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "只能审核待审核的报损/溢单信息！", null);
            }
           // 审核通过
            if (AdjustStatus.LOSSBILL_TYPE_ADOPT == olStatus) {
                if (billType.equals(BarCodeConstant.REPORT_LOSS) ) {
                    BillCheckMthVo billCheckMthVo = returnOrderBiz.callBillCheckMth(projectId, Integer.valueOf(olBillIds[i]), BarCodeConstant.REPORT_LOSS, BarCodeConstant.COMMODITY, accountId,0);
                    Boolean rltcode = billCheckMthVo.getRltcode();
                    String msg = billCheckMthVo.getMsg();
                    if (rltcode == false) {
                        throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核报损单信息时调用存储过程失败！错误信息是"+msg, null);
                    }
                } else {
                    BillCheckMthVo billCheckMthVo = returnOrderBiz.callBillCheckMth(projectId, Integer.valueOf(olBillIds[i]), BarCodeConstant.OVERFLOW, BarCodeConstant.COMMODITY, accountId,0);
                    Boolean rltcode = billCheckMthVo.getRltcode();
                    String msg = billCheckMthVo.getMsg();
                    if (rltcode == false) {
                        throw new RpcException(300, ErrorCode.RAWMATER_NOT_TO_SUPROWMATER + "审核报溢单信息时调用存储过程失败！错误信息是"+msg, null);
                    }
                }
            }else { //驳回
                lossBill.setOlBlTime(new Date());
                lossBill.setOlBlEmpId(accountId);
                lossBill.setOlStatus(olStatus);
                UpdateBuilder lossBillBuilder = UpdateBuilder.build(CommodityWhHandOfLossBill.class).setBean(lossBill).whereEq("project_id", projectId)
                        .whereEq("project_root_id", projectRootId).whereEq("ol_bill_id", olBillIds[i]);
                if (autoBaseDao.update(lossBillBuilder) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "审核报损/溢失败！", null);
                }
            }
        }
    }


    @Override
    public String createReportLossBarCode(Long projectId, Long projectRootId,Integer olBillId, Integer billType) {
        try{
            String billBarcode = "";
            CommodityWhHandOfLossBill reportLossInfo = this.getReportLossInfo(projectId, projectRootId, billType, olBillId);
            if (reportLossInfo != null ) {
                 billBarcode = reportLossInfo.getBillBarcode();  //条形码数字
            }
            return this.createBarCode(billBarcode);
        }catch (Exception e) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "生成报损/溢条形码失败！", null);
        }
    }

    @Override
    public String getLossBillCode(Long projectId, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String code = saleadjustApi.sysGetBillCode(projectId, "commodity_wh_hand_of_loss_bill");
        Integer id = supplierService.getTableId(projectId, "commodity_wh_hand_of_loss_bill", 1);
        String date = sdf.format(new Date());
        String str = "ovfl".equals(type) ? "OVFL" : "LOS";
        return  str + date + id;
    }

    /**
     *@Description 生成条形码----公共接口
     *@param   billBarcode   表中的条形码字符串字段
     *@return
     *@date 2019-09-20 10:15
     *@auther wangwenbin
     */
    @Override
    public String createBarCode(String billBarcode) {
        try{
            File file = null;

            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
            String endpoint = "https://oss-cn-beijing.aliyuncs.com";
            String objectName = "clota/" + UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            /*OSSClient ossClient = new OSSClient(endpoint, "LTAI4FcZp6j9XLEhLLcKRZDH", "Yx0641PEJ7UkDW92CcknrpAcGfqvus");
            ossClient.putObject("piaoshangcan-clota", objectName, multipartFile.getInputStream());
            ossClient.shutdown();
*/
            //不存在则新增
            if(!file.exists()){
                file.mkdirs();
            }else{
                file.delete();//删除文件
            }
            return "https://piaoshangcan-clota.oss-cn-beijing.aliyuncs.com"+ "/"+objectName ;
        }catch (Exception e) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "生成条形码失败！", null);
        }

    }

    @Override
    public Object lossBillReportFrom(String projectIds,String type,String orgName, String whKey, String comKey, String billCode, Integer billType,
                                                          String comClassCode, String createdStartTime, String createdEndTime, Long accountId, Long projectId, Long projectRootId,Integer pageNo,Integer pageSize) {
        if (type.equals("lossBill")) {
            NativeSQLBuilder<CommodityWhHandOfLossBillVo> billBuild = NativeSQLBuilder.build(CommodityWhHandOfLossBillVo.class)
                    .setSql( "select t1.pl_count as plCount,t4.com_class_code as comClassCode,t1.ol_bill_id as billId,t1.tax_cost_amount as taxCostAmount,t1.notax_cost_amount as noTaxCostAmount,\n" +
                            "\t t2.ol_bill_code as billCode,\n" +
                            "\t (CASE WHEN t2.bill_type = 12209 THEN '手工报损' WHEN t2.bill_type = 12210 THEN '手工报溢' END) as billTypeName,\n" +
                            "\t t2.created_time as createdTime,t4.com_name as comName,t3.com_barcode as comBarcode,t3.comm_spec as commSpec,t1.com_code as commCode,t4.com_type,t4.com_type2,\n" +
                            "\t t4.com_type3,t4.com_type5,t4.com_type6,t4.com_type7,t4.com_type8,t4.com_type9,t4.com_type10,t4.com_type11,t7.wh_name,t7.wh_code,\n" +
                            "\t (select t8.type_name from catecomm_tss_pubdatadict t8 where t4.sell_model = t8.type_code) as sellModel,\n" +
                            "\t (select t5.tax_name from catecomm_tsb_tax t5 where t4.ph_tax_id = t5.tax_id and t4.project_id = t5.project_id) as taxName,\n" +
                            "\t t1.tax_cost as taxCost,t1.notax_cost as noTaxCost,t6.org_name,t10.org_name as companyName,\n" +
                            "\t (select t9.type_name from catecomm_tss_pubdatadict t9 where t3.comm_unit = t9.type_code) as commUnitName\n"+
                            "\t from commodity_wh_hand_of_loss_bill_dtl t1 \n" +
                            "\t INNER JOIN commodity_wh_hand_of_loss_bill t2 on t1.ol_bill_id = t2.ol_bill_id and t1.project_id = t2.project_id and t2.is_delete = 0 and t2.ol_status = 12503\n" +
                            "\t INNER JOIN commodity_tcb_salecom t3 on t1.sale_com_id = t3.sale_com_id and t1.project_id = t3.project_id\n" +
                            "\t INNER JOIN commodity_tcb_com t4 on t1.com_id = t4.com_id and t1.project_id = t4.project_id"+
                            "\t INNER JOIN catecomm_tsb_warehouse t7 on t2.wh_id = t7.wh_id and t2.project_id = t7.project_id\n"+
                            "\t left JOIN org_info t6 on t7.up_project_id = t6.id and t6.node_type = 'scenic'\n" +
                            "\t left JOIN org_info t10 on t7.up_project_root_id = t10.id and t10.node_type = 'company'\n" +
                            "\t WHERE  t2.is_delete = 0 and t2.ol_status = 12503");
            billBuild.append(" AND t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");

            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                billBuild.append(" and (t4.com_name like '%"+comKey+"%' OR t4.com_code like '"+comKey+"')");
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                billBuild.append(" and t2.ol_bill_code like '%"+billCode+"%'");
            }
            // 损益类型
            if (billType != null) {
                billBuild.append(" and t2.bill_type ="+billType);
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                billBuild.append(" and t4.com_class_code ="+comClassCode);
            }

            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                billBuild.append(" and t2.created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            if (pageNo == null && pageSize == null) {
                List<CommodityWhHandOfLossBillVo> billList = autoBaseDao.listAll(billBuild);
                list(billList,projectIds);
                return billList;
            } else {
                billBuild.setPage(pageNo,pageSize);
                PagedList<CommodityWhHandOfLossBillVo> billPagelist = autoBaseDao.listPage(billBuild);
                list(billPagelist,projectIds);
                return (ModelPagedList<CommodityWhHandOfLossBillVo>)ModelPagedList.convertToModelPage(billPagelist);
            }

        } else {
            NativeSQLBuilder<CommodityWhHandOfLossBillVo> invtryBuild = NativeSQLBuilder.build(CommodityWhHandOfLossBillVo.class)
                    .setSql("select t1.ivt_dft_count as plCount,t4.com_class_code as comClassCode,t2.ivt_id as billId,t1.tax_cost_amount as taxCostAmount,t1.notax_cost_amount as noTaxCostAmount,\n" +
                            "\t t2.ivt_code as billCode,\n" +
                            "\t (CASE WHEN t1.pro_los_type = 10 THEN '盘点报溢' WHEN t1.pro_los_type = 20 THEN '盘点报损' END) as billTypeName,\n" +
                            "\t t2.entry_created_time as createdTime,t4.com_name as comName,t3.com_barcode as comBarcode,t3.comm_spec as commSpec,t1.com_code as commCode,t4.com_type,t4.com_type2,\n" +
                            "\t t4.com_type3,t4.com_type5,t4.com_type6,t4.com_type7,t4.com_type8,t4.com_type9,t4.com_type10,t4.com_type11,t7.wh_name,t7.wh_code,\n" +
                            "\t (select t8.type_name from catecomm_tss_pubdatadict t8 where t4.sell_model = t8.type_code) as sellModel,\n" +
                            "\t (select t5.tax_name from catecomm_tsb_tax t5 where t4.ph_tax_id = t5.tax_id and t4.project_id = t5.project_id) as taxName,\n" +
                            "\t t1.tax_cost as taxCost,t1.notax_cost as noTaxCost,t6.org_name,t10.org_name as companyName,\n" +
                            "\t (select t9.type_name from catecomm_tss_pubdatadict t9 where t3.comm_unit = t9.type_code) as commUnitName\n"+
                            "\t from commodity_wh_invtry_bill_dtl t1 \n" +
                            "\t INNER JOIN commodity_wh_invtry_bill t2 on t1.ivt_id = t2.ivt_id and  t1.project_id = t2.project_id\n" +
                            "\t INNER JOIN commodity_tcb_salecom t3 on t1.sale_com_id = t3.sale_com_id and t1.project_id = t3.project_id\n" +
                            "\t INNER JOIN commodity_tcb_com t4 on t1.com_id = t4.com_id and t1.project_id = t4.project_id\n" +
                            "\t INNER JOIN catecomm_tsb_warehouse t7 on t2.wh_id = t7.wh_id and t2.project_id = t7.project_id\n"+
                            "\t left JOIN org_info t6 on t7.up_project_id = t6.id and t6.node_type = 'scenic'\n" +
                            "\t left JOIN org_info t10 on t7.up_project_root_id = t10.id and t10.node_type = 'company'\n" +
                            "\t WHERE  t2.entry_is_delete = 0 and t2.entry_status = 12804");
            invtryBuild.append(" AND t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");

            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                invtryBuild.append(" and (t4.com_name like '%"+comKey+"%' OR t4.com_code like '"+comKey+"')");
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                invtryBuild.append(" and t2.ivt_code like '%"+billCode+"%'");
            }
            // 损益类型
            if (billType != null) {
                invtryBuild.append(" and t1.pro_los_type ="+billType);
            } else {
                invtryBuild.append(" and t1.pro_los_type IN(10,20)");
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                invtryBuild.append(" and t4.com_class_code ="+comClassCode);
            }

            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                invtryBuild.append(" and t2.entry_created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            if (pageNo == null && pageSize == null) {
                List<CommodityWhHandOfLossBillVo> invtryList = autoBaseDao.listAll(invtryBuild);
                list(invtryList,projectIds);
                return invtryList;
            } else {
                invtryBuild.setPage(pageNo,pageSize);
                PagedList<CommodityWhHandOfLossBillVo> invtryPagelist = autoBaseDao.listPage(invtryBuild);
                list(invtryPagelist,projectIds);
                return (ModelPagedList<CommodityWhHandOfLossBillVo>)ModelPagedList.convertToModelPage(invtryPagelist);
            }
        }


    }



    @Override
    public CommodityLossBillSummaryVo lossBillReportFromNum(String projectIds, String type, String orgName, String whKey, String comKey, String billCode, Integer billType, String comClassCode, String createdStartTime, String createdEndTime, Long accountId, Long projectId, Long projectRootId) {
        // 传lossBill为手工报损
        if (type.equals("lossBill")) {
            NativeSQLBuilder<CommodityLossBillSummaryVo> billBuild = NativeSQLBuilder.build(CommodityLossBillSummaryVo.class)
                    .setSql( "select COUNT(t1.pl_count) as count,SUM(t1.tax_cost_amount) as sumTaxCostAmount,SUM(t1.notax_cost_amount) as sumNotaxCostAmount\n" +
                            " from commodity_wh_hand_of_loss_bill_dtl t1\n" +
                            "INNER JOIN commodity_wh_hand_of_loss_bill t2 on t1.ol_bill_id = t2.ol_bill_id and t1.project_id = t2.project_id and t2.is_delete = 0 and t2.ol_status = 12503\n" +
                            "INNER JOIN commodity_tcb_salecom t3 on t1.sale_com_id = t3.sale_com_id and t1.project_id = t3.project_id\n" +
                            "INNER JOIN commodity_tcb_com t4 on t1.com_id = t4.com_id and t1.project_id = t4.project_id\n" +
                            "INNER JOIN catecomm_tsb_warehouse t7 on t2.wh_id = t7.wh_id and t2.project_id = t7.project_id\n" +
                            "left JOIN org_info t6 on t7.up_project_id = t6.id and t6.node_type = 'scenic'\n" +
                            "left JOIN org_info t10 on t7.up_project_root_id = t10.id and t10.node_type = 'company'\n" +
                            "WHERE  t2.is_delete = 0 and t2.ol_status = 12503");
            billBuild.append(" AND t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");

            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                billBuild.append(" and (t4.com_name like '%"+comKey+"%' OR t4.com_code like '"+comKey+"')");
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                billBuild.append(" and t2.ol_bill_code like '%"+billCode+"%'");
            }
            // 损益类型
            if (billType != null) {
                billBuild.append(" and t2.bill_type ="+billType);
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                billBuild.append(" and t4.com_class_code ="+comClassCode);
            }

            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                billBuild.append(" and t2.created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            CommodityLossBillSummaryVo summaryVo = (CommodityLossBillSummaryVo)autoBaseDao.findOne(billBuild);
            return summaryVo;

        } else {
            NativeSQLBuilder<CommodityLossBillSummaryVo> invtryBuild = NativeSQLBuilder.build(CommodityLossBillSummaryVo.class)
                    .setSql("select COUNT(t1.ivt_dft_count) as count,SUM(t1.tax_cost_amount) as sumTaxCostAmount,SUM(t1.notax_cost_amount) as sumNotaxCostAmount\n" +
                            "from commodity_wh_invtry_bill_dtl t1\n" +
                            "INNER JOIN commodity_wh_invtry_bill t2 on t1.ivt_id = t2.ivt_id and  t1.project_id = t2.project_id\n" +
                            "INNER JOIN commodity_tcb_salecom t3 on t1.sale_com_id = t3.sale_com_id and t1.project_id = t3.project_id\n" +
                            "INNER JOIN commodity_tcb_com t4 on t1.com_id = t4.com_id and t1.project_id = t4.project_id\n" +
                            "INNER JOIN catecomm_tsb_warehouse t7 on t2.wh_id = t7.wh_id and t2.project_id = t7.project_id\n" +
                            "left JOIN org_info t6 on t7.up_project_id = t6.id and t6.node_type = 'scenic'\n" +
                            "left JOIN org_info t10 on t7.up_project_root_id = t10.id and t10.node_type = 'company'\n" +
                            "WHERE  t2.entry_is_delete = 0 and t2.entry_status = 12804");
            invtryBuild.append(" AND t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");

            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                invtryBuild.append(" and (t4.com_name like '%"+comKey+"%' OR t4.com_code like '"+comKey+"')");
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                invtryBuild.append(" and t2.ivt_code like '%"+billCode+"%'");
            }
            // 损益类型
            if (billType != null) {
                invtryBuild.append(" and t1.pro_los_type ="+billType);
            } else {
                invtryBuild.append(" and t1.pro_los_type IN(10,20)");
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                invtryBuild.append(" and t4.com_class_code ="+comClassCode);
            }

            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                invtryBuild.append(" and t2.entry_created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            CommodityLossBillSummaryVo summaryVo = (CommodityLossBillSummaryVo)autoBaseDao.findOne(invtryBuild);
            return summaryVo;
        }

    }


    @Override
    public List<CommodityLossBillSummaryVo> lossBillReportSummary(String projectIds,Long projectId,Long projectRootId,String type,Integer billType,String whKey,String comKey,String billCode,String createdStartTime, String createdEndTime,String comClassCode) {
        if (type.equals("lossBill")) {
            NativeSQLBuilder<CommodityLossBillSummaryVo> build = NativeSQLBuilder.build(CommodityLossBillSummaryVo.class)
                    .setSql("select  t3.wh_name,t1.ol_bill_id,\n" +
                            "\t (CASE WHEN t2.bill_type = 12209 THEN '手工报损' WHEN t2.bill_type = 12210 THEN '手工报溢' END) as billTypeName,\n" +
                            "\t count(t1.ol_bill_id) as count,sum(t1.tax_cost_amount) as sumTaxCostAmount,sum(t1.notax_cost_amount) as sumNoTaxCostAmount,\n" +
                            "\t sum(t1.pl_count) as plCount from commodity_wh_hand_of_loss_bill_dtl t1 INNER JOIN commodity_wh_hand_of_loss_bill t2 on t1.ol_bill_id = t2.ol_bill_id\n" +
                            "\t and t1.project_id = t2.project_id \n" +
                            "\t INNER JOIN catecomm_tsb_warehouse t3 on t2.wh_id = t3.wh_id and t2.project_id = t3.project_id\n" +
                            "\t INNER JOIN commodity_tcb_salecom t4 on t1.sale_com_id = t4.sale_com_id and t1.project_id = t4.project_id\n" +
                            "\t INNER JOIN commodity_tcb_com t5 on t1.com_id = t5.com_id and t1.project_id = t5.project_id\n" +
                            "\t WHERE t2.is_delete = 0 AND t2.ol_status = 12503");
            build.append(" and t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");
            if (billType != null) {
                build.append(" and t2.bill_type = "+billType);
            }
            // 仓库名称or编号
            if (StringUtils.isNotBlank(whKey)) {
                build.append(" and t3.wh_id  IN ( " + whKey + ")");
            }
            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                build.append(" and (t5.com_name like '%"+comKey+"%' OR t5.com_code like '"+comKey+"')");
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                build.append(" and t5.com_class_code ="+comClassCode);
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                build.append(" and t2.ol_bill_code like '%"+billCode+"%'");
            }

            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                build.append(" and t2.created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            build.append("group by t2.wh_id");
            return autoBaseDao.listAll(build);
        } else {
            NativeSQLBuilder<CommodityLossBillSummaryVo> build = NativeSQLBuilder.build(CommodityLossBillSummaryVo.class)
                    .setSql("select  t3.wh_name,\n" +
                            "\t (CASE WHEN t1.pro_los_type = 10 THEN '盘点报溢' WHEN t1.pro_los_type = 20 THEN '盘点报损'  END) as billTypeName,\n" +
                            "\t count(t1.ivt_id) as count,sum(t1.tax_cost_amount) as sumTaxCostAmount,sum(t1.notax_cost_amount) as sumNoTaxCostAmount,\n" +
                            "\t sum(t1.ivt_dft_count) as plCount  from commodity_wh_invtry_bill_dtl t1 INNER JOIN commodity_wh_invtry_bill t2\n" +
                            "\t on t1.ivt_id = t2.ivt_id and t1.project_id = t2.project_id \n" +
                            "\t INNER JOIN catecomm_tsb_warehouse t3 on t2.wh_id = t3.wh_id and t2.project_id = t3.project_id\n" +
                            "\t INNER JOIN commodity_tcb_salecom t4 on t1.sale_com_id = t4.sale_com_id and t1.project_id = t4.project_id\n" +
                            "\t INNER JOIN commodity_tcb_com t5 on t1.com_id = t5.com_id and t1.project_id = t5.project_id\n" +
                            "\t WHERE t2.entry_is_delete = 0 AND t2.entry_status = 12804");
            build.append(" and t2.project_id IN (" + projectIds+") and t2.wh_id IN ( " + whKey + ")");

            // 商品名称or编号
            if (StringUtils.isNotBlank(comKey)) {
                build.append(" and (t4.com_name like '%"+comKey+"%' OR t4.com_code like '"+comKey+"')");
            }
            // 编号
            if (StringUtils.isNotBlank(billCode)) {
                build.append(" and t2.ivt_code like '%"+billCode+"%'");
            }
            // 损益类型
            if (billType != null) {
                build.append(" and t1.pro_los_type ="+billType);
            } else {
                build.append(" and t1.pro_los_type IN(10,20)");
            }
            // 商品分类编号
            if (StringUtils.isNotBlank(comClassCode)) {
                build.append(" and t5.com_class_code ="+comClassCode);
            }
            // 创建开始时间
            if (StringUtils.isNotBlank(createdStartTime)  && StringUtils.isNotBlank(createdEndTime)) {
                build.append(" and t2.entry_created_time between CONCAT('" + createdStartTime + "',' 00:00:00') and CONCAT('" + createdEndTime + "',' 23:59:59') ");
            }

            build.append("group by t2.wh_id");
            return autoBaseDao.listAll(build);
        }
    }

    @Override
    public ModelPagedList<CatecommTsbWarehouseModel> warehouseList(String nodeType, Long rootId, Long parentManageId, Long projectId, String companyName, String orgName, String whKey, Integer pageNo, Integer pageSize) {

        if (nodeType.equals("bloc")) {
            // 集团下的公司
            Map<String,Object> resultMap  = getProjectIds(rootId);
            String ids = (String) resultMap.get("ids");
            String warehouseSql = "select t1.*,t2.org_name as companyName,t3.org_name as orgName "+
                    "\t from catecomm_tsb_warehouse t1 INNER JOIN org_info t2 on t1.project_id = t2.id" +
                    "\t left JOIN org_info t3 on t1.up_project_id = t3.id\n"+
                    "\t where t3.node_type = 'scenic' and t1.project_id IN ("+ ids +")";

            // 集团-公司下面的仓库
            NativeSQLBuilder<CatecommTsbWarehouseModel> warehouseBuilder = NativeSQLBuilder.build(CatecommTsbWarehouseModel.class)
                    .setSql(warehouseSql);
            if (StringUtils.isNotBlank(companyName)) {
                warehouseBuilder.append(" and t2.node_type = 'company' and t2.org_name like '%"+companyName+"%'");
            }
            if (StringUtils.isNotBlank(orgName)) {
                warehouseBuilder.append(" and t3.node_type = 'scenic' and t3.org_name like '%"+orgName+"%'");
            }
            if (StringUtils.isNotBlank(whKey)) {
                warehouseBuilder.append(" and (t1.wh_name like '%"+whKey+"%' OR t1.wh_code like '"+whKey+"')");
            }
            warehouseBuilder.setPage(pageNo,pageSize);
            PagedList list = autoBaseDao.listPage(warehouseBuilder);
            list.add(resultMap);
            return ModelPagedList.convertToModelPage(list);

        } else  {
            // 公司下面的仓库
            NativeSQLBuilder<CatecommTsbWarehouseModel> companySqlBuilder = NativeSQLBuilder.build(CatecommTsbWarehouseModel.class)
                    .setSql("select t1.*,t2.org_name as companyName,t3.org_name as orgName,t6.org_name as jqName\n"+
                            "\t from catecomm_tsb_warehouse t1 INNER JOIN org_info t2 on t1.project_id = t2.id\n"+
                            "\t left JOIN org_info t3 on t1.up_project_id = t3.id\n"+
                            "\t left join catecomm_tsb_gzone t4 on t1.project_id=t4.project_id and t1.gzone_id=t4.gzone_id and t1.wh_level=11703\n"+
                            "\t left join org_info t6 on t4.park_id = t6.id\n"+
                            "\t where  t1.project_id = "+projectId);
            if (StringUtils.isNotBlank(companyName)) {
                companySqlBuilder.append(" and t2.node_type = 'company' and t2.org_name like '%"+companyName+"%'");
            }
            if (StringUtils.isNotBlank(orgName)) {
                companySqlBuilder.append(" and t6.node_type = 'scenic' and t6.org_name like '%"+orgName+"%'");
            }
            if (StringUtils.isNotBlank(whKey)) {
                companySqlBuilder.append(" and (t1.wh_name like '%"+whKey+"%' OR t1.wh_code like '"+whKey+"')");
            }
            companySqlBuilder.setPage(pageNo,pageSize);
            PagedList<CatecommTsbWarehouseModel>  companyList = autoBaseDao.listPage(companySqlBuilder);
            return ModelPagedList.convertToModelPage(companyList);
        }
    }



    // 查询集团下的公司ID
    private Map<String,Object> getProjectIds(Long rootId) {
        Map<String,Object> resultMap = new HashMap<>();
            // 查询集团信息
            NativeSQLBuilder<OrgInfoModel> build = NativeSQLBuilder.build(OrgInfoModel.class)
                    .setSql("select org_name from org_info where node_type = 'bloc' and  id = " + rootId);
            OrgInfoModel rootInfo = (OrgInfoModel) autoBaseDao.findOne(build);
            resultMap.put("rootName", rootInfo.getOrgName());

            // 集团下面公司
            NativeSQLBuilder<OrgInfoModel> blocBuild = NativeSQLBuilder.build(OrgInfoModel.class)
                    .setSql("select id from org_info where node_type = 'company' and  root_id = " + rootId);
            List<OrgInfoModel> companyList = autoBaseDao.listAll(blocBuild);
            StringBuffer ids = new StringBuffer();
            // 公司下面的景区
            companyList.forEach(a -> {
                if (ids.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                    ids.append(",");
                }
                ids.append(a.getId());
            });
            resultMap.put("ids",ids.toString());
            return resultMap;
    }


    private void list(List<CommodityWhHandOfLossBillVo> list,String projectId){
        list.forEach(a -> {
            //查询当前商品分类编号的上级编号
            NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                    .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id, ucom_class_code \n" +
                            "FROM commodity_tcc_comclass \n" +
                            "WHERE com_class_code = '" + a.getComClassCode() + "' and project_id in("+projectId+")" );
            CommodityTccComclassModel comFClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sql);

            CommodityTccComclassModel comFMaxClassModel = null;
            //组装最大父级的商品分类编号
            if (null != comFClassModel && comFClassModel.getUcomClassId().intValue() != 0) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                        .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id = (SELECT com_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id =" + comFClassModel.getUcomClassId() +" and project_id in("+projectId+")) and project_id in("+projectId+")");
                comFMaxClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sqlMax);
            }
            CommodityTccComclassModel comFMaxMaxClassModel = null;
            if (null != comFMaxClassModel && comFMaxClassModel.getUcomClassId().intValue() != 0) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                        .setSql("SELECT com_class_id, com_class_code, com_class_name, ucom_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id = (SELECT com_class_id FROM commodity_tcc_comclass\n" +
                                "WHERE com_class_id =" + comFMaxClassModel.getUcomClassId() +" and project_id in("+projectId+")) and project_id in("+projectId+")");
                comFMaxMaxClassModel = (CommodityTccComclassModel)autoBaseDao.findOne(sqlMax);
            }
            if (null != comFMaxMaxClassModel) {
                a.setComClassCodeOne(comFMaxMaxClassModel.getComClassCode());
                a.setComClassNameOne(comFMaxMaxClassModel.getComClassName());
                a.setComClassCodeTwo(comFMaxClassModel.getComClassCode());
                a.setComClassNameTwo(comFMaxClassModel.getComClassName());
                a.setComClassCodeThree(comFClassModel.getComClassCode());
                a.setComClassNameThree(comFClassModel.getComClassName());

            }
            if (null == comFMaxMaxClassModel && null != comFMaxClassModel) {
                a.setComClassCodeOne(comFMaxClassModel.getComClassCode());
                a.setComClassNameOne(comFMaxClassModel.getComClassName());
                a.setComClassCodeTwo(comFClassModel.getComClassCode());
                a.setComClassNameTwo(comFClassModel.getComClassName());
            }
            if (null == comFMaxMaxClassModel && null == comFMaxClassModel && null != comFClassModel) {
                a.setComClassCodeOne(comFClassModel.getComClassCode());
                a.setComClassNameOne(comFClassModel.getComClassName());
            }
        });
    }

}
