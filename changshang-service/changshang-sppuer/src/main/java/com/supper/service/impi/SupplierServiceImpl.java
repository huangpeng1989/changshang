package com.supper.service.impi;


import com.supper.service.SupplierService;
import entity.GetPell;
import entity.IdWorker;
import entity.ModelPagedList;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.*;
import modelpojo.model.contract.CateringContract;
import modelpojo.model.contract.CommodityContract;
import modelpojo.vo.SuppRowmaterDto;
import modelpojo.vo.SupplierDto;
import modelpojo.vo.TableIdDto;
import modelpojo.vo.suppComDto;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    IdWorker idWorker;


    @Override
    public ModelPagedList getSuppList(CommodityTcbSupplierModel query, int pageNo, int pageSize, String orderBy) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(SupplierDto.class)
                .setSql("SELECT t1.*, t2.supp_class_name, t3.dict_tp_value, t5.nick_name, t4.type_name AS statusName FROM commodity_tcb_supplier t1 \n" +
                        "LEFT JOIN commodity_tcc_suppclass t2 ON t2.supp_class_code = t1.supp_class_code and t2.project_id = " + query.getProjectId() + "\n" +
                        "LEFT JOIN catecomm_tss_datadict t3 ON t3.dict_tp_code = t1.pay_days and t3.project_id =" + query.getProjectId() + "\n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.s_status\n" +
                        "LEFT JOIN account t5 ON t5.id = t1.creater \n" +
                        "WHERE t1.is_delete = 0" );
        supplier.append(" and t1.project_id =" + query.getProjectId());
        supplier.append(null != query.getsStatus() ? (" and t1.s_status =\n" + query.getsStatus() + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppCode()) ? (" and t1.supp_code like \n" + "'%"  + query.getSuppCode() + "%'" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppClassCode()) ? (" and t1.supp_class_code =\n" + query.getSuppClassCode() + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppContact()) ? ("and t1.supp_contact like '%" + (query.getSuppContact()) + "%'\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppName()) ? ("and t1.supp_name like '%" + (query.getSuppName()) + "%'" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSupper()) ? (" and (t1.supp_code like  '%"  + query.getSupper() + "%' OR t1.supp_name like" + "'%" + (query.getSupper()) + "%')" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSpellCode()) ? ("and t1.spell_code like\n" + "'%" + (query.getSpellCode()) + "%'\n") : "");
        supplier.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                + "t1.created_time desc");
        supplier.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(supplier));
    }

    @Override
    public ModelPagedList getSuppContractList(CommodityTcbSupplierModel query,int moduleId, int pageNo, int pageSize, String orderBy) throws Exception {
        String tableName = "";
        // 商品10 餐饮20
        if(moduleId == 10){
            tableName = "commodity_contract";
        }else if(moduleId == 20){
            tableName = "catering_contract";
        }
        if (tableName == "") {
            throw new Exception( ErrorCode.PRODUCT_NAME_REPEAT +  "请传入正确的模块ID，商品10 餐饮20！", null);
        }
        NativeSQLBuilder supplier = NativeSQLBuilder.build(SupplierDto.class)
                .setSql("SELECT t1.*, t2.supp_class_name, t3.dict_tp_value, t5.nick_name, t4.type_name AS statusName FROM commodity_tcb_supplier t1 \n" +
                        "LEFT JOIN commodity_tcc_suppclass t2 ON t2.supp_class_code = t1.supp_class_code and t2.project_id = " + query.getProjectId() + "\n" +
                        "LEFT JOIN catecomm_tss_datadict t3 ON t3.dict_tp_code = t1.pay_days and t3.project_id =" + query.getProjectId() + "\n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.s_status\n" +
                        "LEFT JOIN account t5 ON t5.id = t1.creater \n" +
                        "LEFT JOIN "+tableName+" con on t1.supp_id = con.contract_supper and t1.project_id = con.project_id and con.is_delete = 0 \n" +
                        "WHERE t1.is_delete = 0" );
        supplier.append(" and t1.project_id =" + query.getProjectId());
        supplier.append(" AND DATE_FORMAT(now(),'%Y-%m-%d') BETWEEN DATE_FORMAT(contract_start_time,'%Y-%m-%d') AND DATE_FORMAT(contract_end_time, '%Y-%m-%d') AND contract_stauts = 133003 ");
        supplier.append(null != query.getsStatus() ? (" and t1.s_status =\n" + query.getsStatus() + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppCode()) ? (" and t1.supp_code like \n" + "'%"  + query.getSuppCode() + "%'" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppClassCode()) ? (" and t1.supp_class_code =\n" + query.getSuppClassCode() + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppContact()) ? ("and t1.supp_contact like '%" + (query.getSuppContact()) + "%'\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSuppName()) ? ("and t1.supp_name like '%" + (query.getSuppName()) + "%'" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSupper()) ? (" and (t1.supp_code like  '%"  + query.getSupper() + "%' OR t1.supp_name like" + "'%" + (query.getSupper()) + "%')" + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getSpellCode()) ? ("and t1.spell_code like\n" + "'%" + (query.getSpellCode()) + "%'\n") : "");
        supplier.append(" group by project_id,supp_id ");
        supplier.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                + "t1.created_time desc");
        supplier.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(supplier));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void operation(Integer suppId, String status, Long accountId, Long projectId) throws Exception {
        //删除操作--
        NativeSQLBuilder suppCom = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
                .setSql("SELECT t1.* FROM commodity_tcb_suppcom t1 \n" +
                        "LEFT JOIN commodity_tcb_com t2 ON t2.com_id = t1.com_id and t2.project_id = t1.project_id\n" +
                        "WHERE t1.supp_id =" + suppId + " and t1.project_id =" + projectId + "\n" +
                        "and t1.is_delete = 0"
                );
        List<CommodityTcbSuppcomModel> suppComModels = autoBaseDao.listAll(suppCom);
        if (suppComModels != null && suppComModels.size() > 0) {
            throw new Exception( ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除或淘汰供应商，已被在售商品关联！", null);
        }
        NativeSQLBuilder supperRowmater = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class)
                .setSql("SELECT * FROM catering_tcb_supp_rowmater \n" +
                        "WHERE  supp_id =" + suppId + " and project_id =" + projectId
                );
        List<CateringTcbSuppRowmater> suppRowmaters = autoBaseDao.listAll(supperRowmater);
        if (suppRowmaters != null && suppRowmaters.size() > 0) {
            throw new Exception(ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除或淘汰供应商，已被原材料关联！");
        }

        NativeSQLBuilder comContract = NativeSQLBuilder.build(CommodityContract.class)
                .setSql("SELECT * FROM commodity_contract \n" +
                        "WHERE is_delete = 0 AND contract_supper =" + suppId + " and project_id =" + projectId
                );
        List<CommodityContract> commodityContracts = autoBaseDao.listAll(comContract);
        if (commodityContracts != null && commodityContracts.size() > 0) {
            throw new Exception(ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除或淘汰供应商，已被商品合同关联！", null);
        }

        NativeSQLBuilder caterContract = NativeSQLBuilder.build(CateringContract.class)
                .setSql("SELECT * FROM catering_contract \n" +
                        "WHERE is_delete = 0 AND contract_supper =" + suppId + " and project_id =" + projectId
                );
        List<CateringContract> cateringContracts = autoBaseDao.listAll(caterContract);
        if (cateringContracts != null && cateringContracts.size() > 0) {
            throw new Exception(ErrorCode.PRODUCT_NAME_REPEAT +  "无法删除或淘汰供应商，已被餐饮合同关联！", null);
        }
        
        if (autoBaseDao.update(option(suppId, status, accountId, projectId)) == 0) {
            throw new Exception( ErrorCode.PRODUCT_NAME_REPEAT +  ("1".equals(status) ? "删除" : "淘汰" + "失败！"), null);
        }
    }

    @Override
    public SupplierDto queryById(Integer suppId, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(SupplierDto.class)
                .setSql("SELECT t1.*, (select tax_name from catecomm_tsb_tax where catecomm_tsb_tax.tax_id = t1.sl_tax_id and catecomm_tsb_tax.project_id = t1.project_id) AS tax_name, t2.supp_class_name, t3.dict_tp_value, t4.province, t5.city, t6.area FROM commodity_tcb_supplier t1 \n" +
                        "LEFT JOIN sys_provinces t4 ON t4.provinceid = t1.fir_loc_code \n" +
                        "LEFT JOIN sys_cities t5 ON t5.cityid = t1.sec_loc_code \n" +
                        "LEFT JOIN sys_areas t6 ON t6.areaid = t1.thi_loc_code \n" +
                        "LEFT JOIN commodity_tcc_suppclass t2 ON t2.supp_class_code = t1.supp_class_code and t2.project_id = t1.project_id \n" +
                        "LEFT JOIN catecomm_tss_datadict t3 ON t3.dict_tp_code = t1.pay_days and t3.project_id =" + projectId + "\n" +
                        "WHERE t1.is_delete = 0\n" );
        supplier.append(" and t1.project_id =" + projectId + "\n");
        supplier.append(" and t1.supp_id =" + suppId);
        SupplierDto supplierDto = (SupplierDto)autoBaseDao.findOne(supplier);
        //查询当前菜品分类编号的上级编号
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                .setSql("SELECT supp_id, supp_class_code, usupp_id, usupp_class_code \n" +
                        "FROM commodity_tcc_suppclass \n" +
                        "WHERE supp_class_code = '" + supplierDto.getSuppClassCode() + "' and project_id = " + projectId);
        CommodityTccSuppclassModel fClassModel = (CommodityTccSuppclassModel)autoBaseDao.findOne(sql);

        CommodityTccSuppclassModel fMaxClassModel = null;
        //组装最大父级的菜品分类编号
        if (null != fClassModel) {
            NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CommodityTccSuppclassModel.class)
                    .setSql("SELECT supp_id, supp_class_code FROM commodity_tcc_suppclass\n" +
                            "WHERE supp_id = (SELECT usupp_id FROM commodity_tcc_suppclass\n" +
                            "WHERE supp_id =" + fClassModel.getUsuppId() +" AND project_id =" + projectId + ")\n" +
                            "AND project_id = " + projectId);
            fMaxClassModel = (CommodityTccSuppclassModel)autoBaseDao.findOne(sqlMax);
        }
        String zoomClassCode = (null != fMaxClassModel  ? fMaxClassModel.getSuppClassCode() + ","  : "") +
                (null != fClassModel ?  fClassModel.getUsuppClassCode() + ","  : "") +
                supplierDto.getSuppClassCode();
        supplierDto.setZoomClassCode(zoomClassCode);
        return supplierDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSupplier(CommodityTcbSupplierModel commodityTcbSupplier, Long accountId) {
        //查询供应商编号是否存在重复
        CommodityTcbSupplierModel oldModel = this.getIsSuppCode(commodityTcbSupplier.getSuppCode());
        if (null != oldModel && oldModel.getSuppId() != commodityTcbSupplier.getSuppId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "供应商编号已存在！", null);
        }
        CommodityTcbSupplierModel oldSupplier = this.checkSupperName(commodityTcbSupplier.getSuppName(), commodityTcbSupplier.getProjectId(), commodityTcbSupplier.getSuppId());
        if (null != oldSupplier && oldSupplier.getSuppId().intValue() != commodityTcbSupplier.getSuppId().intValue()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "供应商名称已存在！", null);
        }
        if (0 != commodityTcbSupplier.getSuppId()) {
            commodityTcbSupplier.setModifier(accountId);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CommodityTcbSupplierModel.class).set("sync_status",10).setBean(commodityTcbSupplier).whereEq("suppId", commodityTcbSupplier.getSuppId())
                    .whereEq("projectId", commodityTcbSupplier.getProjectId());
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改保存失败！", null);
            }
        } else {
            commodityTcbSupplier.setSuppId(this.getTableId(commodityTcbSupplier.getProjectId(),"commodity_tcb_supplier", 1));
            commodityTcbSupplier.setCreater(accountId);
            commodityTcbSupplier.setsStatus(10802);//录入状态（待审核）
            commodityTcbSupplier.setSpellCode(GetPell.getPinYinHeadChar(commodityTcbSupplier.getSuppName()));
            if (autoBaseDao.save(commodityTcbSupplier) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void examine(String suppIds, Long accountId, String status, Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier\n" +
                        "WHERE is_delete = 0 and supp_id IN (" + suppIds + ") and project_id =" + projectId);
        List<CommodityTcbSupplierModel> supplierModels = autoBaseDao.listAll(sql);
        int supplierSize = supplierModels.size();
        supplierModels.removeIf(b -> 10803 == b.getsStatus()|| 10804 == b.getsStatus());
        if (supplierModels.size() != supplierSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在已审核的数据，请重新选择！", null);
        }
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("UPDATE commodity_tcb_supplier SET sync_status = 10 , s_status = " + status + ",\n" +
                        "bl_emp_id = " + accountId + ",\n" +
                        "bl_time = NOW()\n" +
                        "WHERE supp_id IN (" + suppIds + ") and project_id = " + projectId);

        //审核通过操作
        if (autoBaseDao.nativeExecute(supplier) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
        }

    }

    @Override
    public CommodityTcbSupplierModel getIsSuppCode(String suppCode) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier  WHERE is_delete = 0 and supp_code =" + suppCode);
        return (CommodityTcbSupplierModel)autoBaseDao.findOne(supplier);
    }

    @Override
    public CommodityTcbSupplierModel checkSupperName(String suppName, Long projectId, Integer suppId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier  WHERE is_delete = 0 and supp_name ='" + suppName + "'\n" +
                        "and project_id = " + projectId);
        /*supplier.append(0 != suppId ? ("and supp_id =" + suppId + "\n") : "");*/
        CommodityTcbSupplierModel supplierModel = (CommodityTcbSupplierModel)autoBaseDao.findOne(supplier);
        if (null == supplierModel) {
            return null;
        } else {
            if (suppId.intValue() == supplierModel.getSuppId().intValue()) {
                return null;
            }
            return  supplierModel;
        }
    }

    @Override
    public ModelPagedList getCommodity(Integer suppId, Long projectId, int pageNo, int pageSize) {
        NativeSQLBuilder suppCom = NativeSQLBuilder.build(suppComDto.class)
                .setSql("SELECT t2.*, t1.sup_com_id, t1.supp_id, t1.tax_paid, t1.no_tax_paid, t3.type_name as unitName, t1.fu_tax_cost,\n" +
                        "(SELECT com_class_name FROM commodity_tcc_comclass WHERE com_class_code = t2.com_class_code AND project_id = t1.project_id) AS comClassName,\n" +
                        "CONCAT_WS('/',(CASE WHEN t2.com_type = 1 THEN '正常商品' ELSE NULL END),\n" +
                        "(CASE WHEN t2.com_type2 = 1 THEN '大类商品' ELSE NULL END),\n" +
                        "(CASE WHEN t2.com_type3 = 1 THEN '称重商品' ELSE NULL END),\n" +
                        "(CASE WHEN t2.com_type4 = 1 THEN '赠品' ELSE NULL END),\n" +
                        "(CASE WHEN t2.com_type5 = 1 THEN '服务类' ELSE NULL END)) AS comTypeStr,\n" +
                        "(select type_name from catecomm_tss_pubdatadict where catecomm_tss_pubdatadict.type_code = t2.sell_model) AS sellModel,\n" +
                        "(select type_name from catecomm_tss_pubdatadict where catecomm_tss_pubdatadict.type_code = t2.sell_status) AS sellStatus\n" +
                        "FROM commodity_tcb_suppcom t1  \n" +
                        "LEFT JOIN commodity_tcb_com t2 ON t2.com_id = t1.com_id and t2.project_id = t1.project_id  \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t2.com_unit  \n" +
                        "WHERE t1.supp_id =" + suppId + "\n" +
                        "and t1.c_status = 10605\n" +
                        "and t1.project_id =" + projectId
                );
        suppCom.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(suppCom));
    }

    @Override
    public ModelPagedList getRawmater(Integer suppId, Long projectId, int pageNo, int pageSize) {
        NativeSQLBuilder suppCom = NativeSQLBuilder.build(SuppRowmaterDto.class)
                .setSql(
                        "SELECT t1.rm_code, t1.rm_name, t2.sell_model, t2.rm_class_code, \n" +
                "(SELECT rmc_name FROM catering_tcc_rawmater_class WHERE catering_tcc_rawmater_class.rmc_code = t2.rm_class_code AND catering_tcc_rawmater_class.project_id = t2.project_id) AS rmc_name,\n" +
                "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t2.rm_unit) AS rmUnitName,\n" +
                " t2.spec_rm_type, t2.spec_rm_type2, t2.spec_rm_type3, t2.spec_rm_type4, t2.spec_rm_type5, t2.spec_rm_type6, t2.spec_rm_type7,\n" +
                "t2.spec_rm_type8, t1.tax_paid, t1.no_tax_paid, t1.fu_tax_cost,\n" +
                "(SELECT tax_name FROM catecomm_tsb_tax WHERE t2.ph_tax_id = catecomm_tsb_tax.tax_id AND catecomm_tsb_tax.project_id = t2.project_id) AS tax_name\n" +
                "FROM catering_tcb_supp_rowmater t1\n" +
                "INNER JOIN catering_tcb_rowmaterial t2 ON t2.rm_id = t1.rm_id AND t2.project_id = t1.project_id\n" +
                "WHERE t1.project_id = " + projectId + " AND t2.c_status = 11503  AND t1.supp_id = " + suppId
                );
        suppCom.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(suppCom));
    }

    @Override
    public List<CommodityTcbSupplierModel> selectSupplier(Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier \n" +
                        "WHERE is_delete = 0" );
        supplier.append(" and project_id =" + projectId);
        return autoBaseDao.listAll(supplier);
    }

    @Override
    public ModelPagedList<CommodityTcbSupplierModel> selectSupplierByName(Long projectId, String suppNameOrCode,Integer pageNo,Integer pageSize) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CommodityTcbSupplierModel.class)
                .setSql("SELECT * FROM commodity_tcb_supplier WHERE is_delete = 0 " );
        supplier.append(" and project_id =" + projectId);
        if(StringUtils.isNotBlank(suppNameOrCode)){
            supplier.append(" and ( supp_name like '%"+suppNameOrCode+"%' or supp_code like '%"+suppNameOrCode+"%')" );
        }
        supplier.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(supplier));
    }

    @Override
    public String getSuppCode() {
        return String.valueOf(idWorker.nextId());
    }

    @Override
    public List<CatecommTssDatadictModel> getPeriod(String type, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                .setSql("SELECT * FROM catecomm_tss_datadict \n" +
                        "WHERE dd_status = 1 and dict_name = '" + type + "' AND project_id = " + projectId);
        return autoBaseDao.listAll(supplier);
    }

    @Override
    public Integer getTableId(Long projectId, String tableName, int number) {
        NativeSQLBuilder builder = NativeSQLBuilder.build(TableIdDto.class).setSql(
                "CALL P_Sys_GetMaxId(" + projectId + ",'" + tableName + "',"+ number + ",@num);" );
        List<TableIdDto> tableIdDto = autoBaseDao.listAll(builder);
        if (-1 == Integer.parseInt(tableIdDto.get(0).getId())) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "调用生成ID主键存储过程失败！返回ID为：" + tableIdDto.get(0).getId(), null);
        }
        return Integer.parseInt(tableIdDto.get(0).getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> getTableIds(Long projectId, String tableName, int number) {
        if (number <= 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "数量不能为零！", null);
        }
        NativeSQLBuilder builder = NativeSQLBuilder.build(TableIdDto.class).setSql(
                "CALL P_Sys_GetMaxId(" + projectId + ",'" + tableName + "',"+ number + ",@num);" );
        List<TableIdDto> tableIdDto = autoBaseDao.listAll(builder);
        List<Integer> ids = new ArrayList<>();
        if (1 == number) {
            ids.add(Integer.parseInt(tableIdDto.get(0).getId()));
            return ids;
        }
        for (int i = (number - 1); i < number; i --) {
            if (i == 0) {
                break;
            }
            ids.add(Integer.parseInt(tableIdDto.get(0).getId()) - i);
        }
        ids.add(Integer.parseInt(tableIdDto.get(0).getId()));
        return ids;
    }

    private UpdateBuilder option (Integer suppId, String status, Long accountId, Long projectId){
        CommodityTcbSupplierModel commodityTcbSupplierModel = new CommodityTcbSupplierModel();
        if ("10805".equals(status)) {
            commodityTcbSupplierModel.setsStatus(Integer.valueOf(status));
            commodityTcbSupplierModel.setBlEmpId(accountId);
            commodityTcbSupplierModel.setBlTime(new Date());
        } else {
            commodityTcbSupplierModel.setIsDelete(1);
        }
        commodityTcbSupplierModel.setSyncStatus(10);
        return UpdateBuilder.build(CommodityTcbSupplierModel.class).setBean(commodityTcbSupplierModel).whereEq("suppId", suppId).whereEq("projectId", projectId);
    }


}
