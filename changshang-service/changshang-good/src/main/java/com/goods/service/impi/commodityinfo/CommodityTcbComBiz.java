package com.goods.service.impi.commodityinfo;


import com.alibaba.fastjson.JSON;
import com.changshang.feign.DataDictFeign;
import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.rawmater.RawnaterFeign;
import com.goods.service.allocation.CollarUseService;
import com.goods.service.commodityinfo.CommodityTcbComApi;
import com.google.common.base.Joiner;
import entity.ModelPagedList;
import entity.RedisUtil;
import excel.Excel;
import modelpojo.BasicDataLogStatus;
import modelpojo.DictDataTypeEnum;
import modelpojo.ErrorCode;
import modelpojo.SyncStatus;
import modelpojo.model.*;
import modelpojo.model.account.AccountModel;
import modelpojo.model.contract.CommodityContract;
import modelpojo.vo.*;
import modelpojo.vo.allotBill.ExportCommInfo;
import modelpojo.vo.commodityinfo.CommExeclVo;
import modelpojo.vo.commodityinfo.CommSuppExeclVo;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.QueryBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


@Service
public class CommodityTcbComBiz implements CommodityTcbComApi {
    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    SupplierServiceFeign supplierService;

    @Resource
    private CollarUseService collarUseService;

    @Resource
    private RawnaterFeign rawmaterApi;

    @Autowired
    //private RedisUtil redisUtil;

    @Resource
    private DataDictFeign dataDictApi;

    //查询商品基础信息列表
    @Override
    public ModelPagedList selectCommList(CommodityTcbComVo commodityTcbComVo, Integer pageNo, Integer pageSize, Long projectId) {

        NativeSQLBuilder<CommodityTcbComDto> queryBuilder = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("select ctc.com_name comName,ctc.com_code comCode,ctc.com_id comId, ctc.com_class_code comClassCode,\n" +
                "(select CONCAT(IFNULL(CONCAT((select com_class_name from commodity_tcc_comclass where project_id = " + projectId + " and com_class_id = (select ucom_class_id from commodity_tcc_comclass where project_id = " + projectId + " and  com_class_id = \n" +
                "( select ucom_class_id from commodity_tcc_comclass where project_id = " + projectId + " and  com_class_code = ctc.com_class_code))),'/'),'')" +
                ",IFNULL(CONCAT((select com_class_name from commodity_tcc_comclass where project_id = " + projectId + " and com_class_id = " +
                "   ( select ucom_class_id from commodity_tcc_comclass where project_id = " + projectId + " and  com_class_code = ctc.com_class_code)),'/'),'')" +
                ",(select com_class_name from commodity_tcc_comclass where project_id = " + projectId + " and  com_class_code = ctc.com_class_code))  " +
                "from DUAL) comClassName ,\n" +
                "ctc.sell_model sellModel,(select type_name from catecomm_tss_pubdatadict where type_code=sell_model) sellModelName, " +
                "ctc.sell_status sellStatus,(select type_name from catecomm_tss_pubdatadict where type_code=ctc.sell_status) sellStatusName," +
                " ctc.com_spec comSpec ,ctc.com_unit comUnit ,(select type_name from catecomm_tss_pubdatadict where type_code=com_unit) comUnitName, ctc.created_time createdTime ,\n" +
                "ctc.creater creater ,ctc.modifier modifier ,ctc.updated_time updatedTime,(select nick_name from account where id =ctc.creater  ) createrName,(select nick_name from account where id =ctc.modifier  ) modifierName,ctc.c_status cStatus,(select type_name from catecomm_tss_pubdatadict where type_code=cStatus) cStatusName, ctc.retail_price retailPrice " +
                "from commodity_tcb_com ctc " +
                " where com_id in ( select cts.com_id from commodity_tcb_suppcom  cts LEFT JOIN commodity_tcb_supplier ctsup on cts.supp_id = ctsup.supp_id \n" +
                "                   where 1=1 and cts.project_id =" + projectId + " and  ctsup .project_id =" + projectId +
                "                   and  cts.is_delete =0 and ctsup.is_delete=0  ")
                .appendIfOpt(" and ctsup.supp_code  = #{suppCode}", "suppCode", commodityTcbComVo.getSuppCode()) //供应商编号
                .appendIfOpt(" and ctsup.supp_name like CONCAT('%',#{suppName},'%') ", "suppName", commodityTcbComVo.getSuppName())//供应商名称
                .append(" GROUP BY cts.com_id ) and ctc.is_delete =0 ")
                //.appendIfOpt(" and ctc.com_class_code = #{comClassCode}", "comClassCode", commodityTcbComVo.getComClassCode())//商品分类编号
                .appendIfOpt(" and ctc.project_id = #{projectId}", "projectId", projectId)//公司id
                .appendIfOpt(" and ctc.sell_model   = #{sellModel}", "sellModel", commodityTcbComVo.getSellModel())//经营方式
                .appendIfOpt(" and ctc.sell_status  = #{sellStatus}", "sellStatus", commodityTcbComVo.getSellStatus())//商品销售状态 状态10录入 20审核 100淘汰

                //.appendIfOpt(" and ctc.c_status in (#{scStatus})", "scStatus", commodityTcbComVo.getScStatus())
                // .appendIfOpt(" and ctc.com_name = #{comName}", "comName", commodityTcbComVo.getComName()) //商品名称
                .appendIfOpt(" and ctc.com_name like CONCAT('%',#{comName},'%') ", "comName", commodityTcbComVo.getComName())//商品名称
                .appendIfOpt(" and ctc.com_code like CONCAT('%',#{comCode},'%') ", "comCode", commodityTcbComVo.getComCode()) //商品编号
                // .appendIfOpt(" and sup.suppName  = #{suppName}", "suppName", commodityTcbComVo.getSuppName()) //供应商名称
                .appendIfOpt(" and ctc.com_type  = #{comType}", "comType", commodityTcbComVo.getComType())//商品类型
                .appendIfOpt(" and ctc.com_type2  = #{comType2}", "comType2", commodityTcbComVo.getComType2())
                .appendIfOpt(" and ctc.com_type3  = #{comType3}", "comType3", commodityTcbComVo.getComType3())
                .appendIfOpt(" and ctc.com_type4  = #{comType4}", "comType4", commodityTcbComVo.getComType4())
                .appendIfOpt(" and ctc.com_type5  = #{comType5}", "comType5", commodityTcbComVo.getComType5())
                .appendIfOpt(" and ctc.com_type6  = #{comType6}", "comType6", commodityTcbComVo.getComType6())
                .appendIfOpt(" and ctc.com_type7  = #{comType7}", "comType7", commodityTcbComVo.getComType7())
                .appendIfOpt(" and ctc.com_type8  = #{comType8}", "comType8", commodityTcbComVo.getComType8())
                .appendIfOpt(" and ctc.com_type9  = #{comType9}", "comType9", commodityTcbComVo.getComType9())
                .appendIfOpt(" and ctc.com_type10  = #{comType10}", "comType10", commodityTcbComVo.getComType10())
                .appendIfOpt(" and ctc.com_type11  = #{comType11}", "comType11", commodityTcbComVo.getComType11());
                if(StringUtils.isNotBlank(commodityTcbComVo.getScStatus())){
                    queryBuilder.append("and ctc.c_status  IN ("+commodityTcbComVo.getScStatus()+") ");//可售商品审核状态 3通过
                }
        if (StringUtils.isNotEmpty(commodityTcbComVo.getComClassCode())) {
            //判断是否是第一级分类
            String comClassCode = this.getChildCode(projectId, commodityTcbComVo.getComClassCode());
            //下级分类为空，说明是最后一级
            if (StringUtils.isEmpty(comClassCode)) {
                queryBuilder.append(" and ctc.com_class_code IN (\n" + commodityTcbComVo.getComClassCode() + ")\n");
            }  else {
                //不为空获取二级分类
                String childCode = getChildCode(projectId, commodityTcbComVo.getComClassCode());
                //不为空获取三级分类
                String childLastCode = "";
                if (StringUtils.isNotEmpty(childCode)) {
                    childLastCode = getChildCode(projectId, childCode);
                }

                if(StringUtils.isNotEmpty(childLastCode)){
                    queryBuilder.append(" and ctc.com_class_code IN (\n" + childLastCode + ")\n");
                } else {
                    //isALL代表查全部 如果有值 证明是查包含下级全部 否则只查当前自己这个分类
                    queryBuilder.append(" and ctc.com_class_code IN (\n" + childCode + ")\n");
                }
            }
        }
        queryBuilder.append("order by ctc.created_time desc");
        queryBuilder.setPage(pageNo, pageSize);
        return ModelPagedList.convertToModelPage(autoBaseDao.listPage(queryBuilder));

    }

    /**
     * 获取下级分类
     * @return
     */
    private String getChildCode(Long projectId,String comClassCode){
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(String.class)
                .setSql(" SELECT " +
                        " GROUP_CONCAT(com_class_code SEPARATOR ',') " +
                        " FROM " +
                        " commodity_tcc_comclass " +
                        " WHERE " +
                        " is_delete = 0 " +
                        " AND project_id =  " + projectId +
                        " AND ucom_class_code in ("+comClassCode+")");
        String comCode = (String)autoBaseDao.findOne(queryBuilder);
        return comCode;
    }

    /**
     * 只删除商品销售信息表数据
     *
     * @param commodityTcbComVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteComm(CommodityTcbComVo commodityTcbComVo, Long projectId) {

        //删除主表
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_com set is_delete = 1 WHERE com_id =" + commodityTcbComVo.getComId() + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(queryBuilder);

        //销售信息表
        NativeSQLBuilder comSaled = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_salecom set is_delete = 1 WHERE com_id =" + commodityTcbComVo.getComId() + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comSaled);

        //价格等级表
        NativeSQLBuilder comGrade = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_gradeprice set is_delete = 1 WHERE com_id =" + commodityTcbComVo.getComId() + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comGrade);

        //供应商商品
        NativeSQLBuilder comsupp = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_suppcom set is_delete = 1 WHERE com_id =" + commodityTcbComVo.getComId() + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comsupp);//供应商商品表

        //商品图片表
        NativeSQLBuilder comImg = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_comimgs set is_delete = 1 WHERE com_id =" + commodityTcbComVo.getComId() + "")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        autoBaseDao.nativeExecute(comImg);
        return 1;
    }


    /**
     * 批量修改状态，直接审核通过
     *
     * @param commodityTcbComVoList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void checkComm(List<CommodityTcbComVo> commodityTcbComVoList, Long projectId, Long accountId) throws Exception {
        for (int i = 0; i < commodityTcbComVoList.size(); i++) { //10605
            String status = "";
            boolean flag = false;
            if("10603".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "待审核";
                flag = true;
            }else if("10604".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "审核驳回";
                flag = true;
            }else if("10605".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "审核通过";
                flag = true;
            }else if("10606".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "已淘汰";
            }else if("10607".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "修改待提交";
            }else if("10608".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "修改待审核";
                //根据主商品状态修改销售商品状态
                NativeSQLBuilder queryBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class).setSql("update commodity_tcb_salecom set sc_status = 10603  where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId() +" and sc_status = 10602");
                autoBaseDao.nativeExecute(queryBuilder1);
                //根据主商品状态修改供应商商品状态
                NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update commodity_tcb_suppcom set c_status = 10603 where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId() + " and c_status = 10602");
                autoBaseDao.nativeExecute(queryBuilder2);
            }else if("10609".equals(commodityTcbComVoList.get(i).getScStatus())){
                status = "修改被驳回";
                //根据主商品状态修改销售商品状态
                NativeSQLBuilder queryBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class).setSql("update commodity_tcb_salecom set sc_status = 10604  where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId() +" and (sc_status = 10602 || sc_status =10603)");
                autoBaseDao.nativeExecute(queryBuilder1);
                //根据主商品状态修改供应商商品状态
                NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update commodity_tcb_suppcom set c_status = 10604 where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId() + " and (c_status = 10602 || c_status =10603)");
                autoBaseDao.nativeExecute(queryBuilder2);
            }
            if(flag){
                //根据主商品状态修改销售商品状态
                NativeSQLBuilder queryBuilder1 = NativeSQLBuilder.build(CommodityTcbSalecom.class).setSql("update commodity_tcb_salecom set sc_status = "+commodityTcbComVoList.get(i).getScStatus()+" where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId());
                autoBaseDao.nativeExecute(queryBuilder1);
                //根据主商品状态修改供应商商品状态
                NativeSQLBuilder queryBuilder2 = NativeSQLBuilder.build(CommodityTcbSuppcomModel.class).setSql("update commodity_tcb_suppcom set c_status = "+commodityTcbComVoList.get(i).getScStatus()+" where project_id = "+projectId+" and  com_id =" + commodityTcbComVoList.get(i).getComId());
                autoBaseDao.nativeExecute(queryBuilder2);
            }
            String content = status +"操作，商品编号【"+commodityTcbComVoList.get(i).getComCode()+"】";
            int result = rawmaterApi.saveBasicDataLog(projectId,commodityTcbComVoList.get(i).getComId(),10, BasicDataLogStatus.LOG_INFO,content,accountId);
            if (result <= 0) {
                throw new Exception( ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品基础信息操作日志失败！");
            }
            NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComDto.class).setSql("update commodity_tcb_com " +
                    "set sync_status = " + SyncStatus.NOT_SYNC + " ,c_status =" + commodityTcbComVoList.get(i).getScStatus() + " ,bl_time=now(),updated_time = now(),modifier="+accountId+",bl_emp_id = " + accountId +
                    " WHERE com_id =" + commodityTcbComVoList.get(i).getComId() + "")
                    .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
            autoBaseDao.nativeExecute(queryBuilder);
        }
    }


    /**
     * 查询商品所有分类信息
     *
     * @param projectId
     */
    @Override
    public List<CommodityTccComclassDto> selectComClass(Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTccComclassDto.class).setSql("\n" +
                "select ucom_class_id ucomClassId,com_class_id comClassId,com_class_code comClassCode, com_class_name comClassName ,'1'  dataType " +
                " from commodity_tcc_comclass " +
                " where  is_delete = 0 and  ucom_class_id = 0 and project_id=" + projectId +
                "\n" +
                "union " +
                "\n" +
                "select ct.ucom_class_id ucomClassId,ct.com_class_id comClassId,ct.com_class_code comClassCode, CONCAT(c.com_class_name,'/',ct.com_class_name) comClassName ,'2'  dataType\n" +
                "from commodity_tcc_comclass c , commodity_tcc_comclass ct " +
                "where c.com_class_id = ct.ucom_class_id  " +
                "and  c.is_delete = 0 and ct.is_delete = 0  and c.ucom_class_id = 0 and c.project_id=" + projectId + " and ct.project_id=" + projectId +
                "\n" +
                "union " +
                "\n" +
                "select cts.ucom_class_id ucomClassId,cts.com_class_id comClassId,cts.com_class_code comClassCode, CONCAT(c.com_class_name,'/',ct.com_class_name,'/',cts.com_class_name) comClassName    ,'3'  dataType\n" +
                "from commodity_tcc_comclass c , commodity_tcc_comclass ct , commodity_tcc_comclass cts " +
                "where c.com_class_id = ct.ucom_class_id and ct.com_class_id = cts.ucom_class_id " +
                "and  c.is_delete = 0 and ct.is_delete = 0 and cts.is_delete = 0 and c.ucom_class_id = 0 and c.project_id=" + projectId + " and ct.project_id=" + projectId + " and cts.project_id=" + projectId);

        List<CommodityTccComclassDto> classList = autoBaseDao.listAll(queryBuilder);
        List<CommodityTccComclassDto> copyList = classList.stream().filter(o -> classList.stream().noneMatch(oo -> oo.getUcomClassId().equals(o.getComClassId()))).collect(Collectors.toList());
        return copyList;
    }

    /**
     * 查询全局字典表数据
     *
     * @param projectId
     * @return
     */
    @Override
    public List<CommodityTcbComExportDto> selectPubData(Integer pDictType, Long projectId) {

        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComExportDto.class).setSql("select type_name typeName ,type_code typeCode   " +
                "from catecomm_tss_pubdatadict where p_dict_status = 1 and  p_dict_type =" + pDictType);

        return autoBaseDao.listAll(queryBuilder);
    }


    /**
     * 税率查询
     *
     * @param projectId
     * @return
     */
    @Override
    public List<CommodityTcbComExportDto> selectTsbTax(Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComExportDto.class).setSql("select tax_id taxId ,tax_name taxName  " +
                "from catecomm_tsb_tax where is_delete = 0 and t_status = 0")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);

        return autoBaseDao.listAll(queryBuilder);
    }

    /**
     * 供应商查询
     *
     * @param projectId
     * @return
     */
    @Override
    public List<CommodityTcbComExportDto> selectsupp(Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComExportDto.class).setSql("select supp_id suppId ,supp_name suppName ,supp_code suppCode" +
                " from commodity_tcb_supplier where s_status = 10804 and is_delete = 0 ")
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);

        return autoBaseDao.listAll(queryBuilder);
    }


    /**
     * 可维护字典表
     *
     * @param dicType
     * @param projectId
     * @return
     */
    @Override
    public List<CommodityTcbComExportDto> selectDataDict(Integer dicType, Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CommodityTcbComExportDto.class).setSql("select dict_tp_code dictTpCode  ,dict_tp_value dictTpValue " +
                " from catecomm_tss_datadict where dd_status = 1 and dic_type=" + dicType)
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);

        return autoBaseDao.listAll(queryBuilder);
    }

    /**
     * 商品导入
     *
     * @param excel
     * @param projectId
     * @param accountId
     * @return
     */
    @Override
    //@Transactional(rollbackFor = Exception.class)
    public int importComm(Excel<CommExeclVo> excel, Long projectId, Long accountId) throws Exception {
        if (excel.getData() != null && excel.getData().size() > 2000)
            throw new Exception("上传商品数量大于2000条");


        List<CommodityTcbCom> comList = new ArrayList<CommodityTcbCom>();
        List<CommodityTcbSalecom> salecomList = new ArrayList<CommodityTcbSalecom>();
        List<CommodityTcbGradeprice> gradepriceList = new ArrayList<CommodityTcbGradeprice>();
        List<CommodityTcbSuppcomModel> suppcomModelList = new ArrayList<CommodityTcbSuppcomModel>();

        for (CommExeclVo item : excel.getData()) {

            Integer comId = supplierService.getTableId(projectId, "commodity_tcb_com", 1);
            String barCode = collarUseService.getBarCode(projectId, 10, comId, 0, 0, 1).get("code").toString();
            Integer salecomId = supplierService.getTableId(projectId, "commodity_tcb_salecom", 1);
            Integer suppcomId = supplierService.getTableId(projectId, "commodity_tcb_suppcom", 1);
            Integer gradepriceId = supplierService.getTableId(projectId, "commodity_tcb_gradeprice", 1);

            //重复商品名称， 商品条码  校验   字段非空校验

            if (StringUtils.isBlank(item.getComClassCode())) { //商品分类
                throw new Exception( "商品分类数据为空", null);
            }
            if (StringUtils.isBlank(item.getComName())) { //商品名称
                throw new Exception("商品名称数据为空", null);
            }
            if (StringUtils.isBlank(item.getComAbbreviate())) { //商品简称
                throw new Exception("商品简称数据为空", null);
            }
            if (StringUtils.isBlank(item.getSellModel())) { //经营方式
                throw new Exception( "经营方式数据为空", null);
            }
            if (StringUtils.isBlank(item.getComType())) { //商品类型
                throw new Exception( "商品类型数据为空", null);
            }
            if (StringUtils.isBlank(item.getSellStatus())) { //商品销售状态
                throw new Exception( "商品销售状态数据为空", null);
            }
            if (StringUtils.isBlank(item.getComUnit())) { //商品单位
                throw new Exception( "商品单位数据为空", null);
            }
            if (StringUtils.isBlank(item.getRetailPrice())) { //建议零售价
                throw new Exception("建议零售价数据为空", null);
            }
            if (StringUtils.isBlank(item.getPhTaxId())) { //进项税税率
                throw new Exception( "进项税税率数据为空", null);
            }
            if (StringUtils.isBlank(item.getSlTaxId())) { //销项税税率
                throw new Exception("销项税税率数据为空", null);
            }
//            if (StringUtils.isBlank(item.getSuppName())) { //供应商
//                throw new RpcException(300, "供应商数据为空", null);
//            }
            if (StringUtils.isBlank(item.getTaxPaid())) { //含税进价
                throw new Exception( "含税进价数据为空", null);
            }
            if (StringUtils.isBlank(item.getFuTaxCost())) { //预估含税成本价
                throw new Exception( "预估含税成本价数据为空", null);
            }
            if (StringUtils.isBlank(item.getGradeId())) { //价格等级
                throw new Exception( "价格等级数据为空", null);
            }
            if (StringUtils.isBlank(item.getGradeRetailPrice())) { //零售价
                throw new Exception("零售价数据为空", null);
            }
            if (StringUtils.isBlank(item.getMaxWhCount())) { //最高库存
                throw new Exception("最高库存为空", null);
            }
            if (StringUtils.isBlank(item.getMinWhCount())) { //最低库存
                throw new Exception( "最低库存为空", null);
            }

            List comm = checkComm(item, projectId);
            if (comm != null && comm.size() > 0) {
                throw new Exception( "商品名称：" + item.getComName() + " 已存在", null);
            }

            List saledComm = checkSaledComm(item, projectId);
            if (item.getComBarcode() != null && (saledComm != null && saledComm.size() > 0)) {
                throw new Exception( "商品：" + item.getComName() + " 条码已存在", null);
            }
            //解析数据并插入数据库
            //商品主表=================================================================================
            CommodityTcbCom com = new CommodityTcbCom();

            com.setProjectId(projectId);
            com.setProjectRootId(projectId);
            com.setComId(comId);
            com.setComCode(String.valueOf(com.getComId()));//商品编号
            com.setComName(item.getComName());//商品名称
            com.setComAbbreviate(item.getComAbbreviate());//商品简称


            String[] comUnit = item.getComUnit().split("-");
            com.setComUnit(Integer.parseInt(comUnit[0]));//商品单位
            com.setComSpec(item.getComSpec());//规格

            String[] comClassCode = item.getComClassCode().split("-");
            com.setComClassCode(comClassCode[0]);//商品分类编号

            String[] sellModel = item.getSellModel().split("-");
            com.setSellModel(Integer.parseInt(sellModel[0]));//经营方式

            if (10003 == com.getSellModel()) { //联营
                if (StringUtils.isBlank(item.getDiscountRate())) { //联营折扣率
                    throw new Exception( "联营折扣率为空");
                } else {
                    com.setDiscountRate(new BigDecimal(item.getDiscountRate()));
                }
            }

            com.setManufacturer(item.getManufacturer());//生产厂家

            com.setExpirationDate(Integer.parseInt(item.getExpirationDate()));//保质期

            //产品等级
            if (!StringUtils.isBlank(item.getComGrade())) {
                String[] comGrade = item.getComGrade().split("-");
                com.setComGrade(comGrade[0]);
            }
            com.setMaxWhCount(new BigDecimal(item.getMaxWhCount()));//最高库存数
            com.setMinWhCount(new BigDecimal(item.getMinWhCount()));//最低库存数

            String[] comType = item.getComType().split("-");
            if ("comType".equals(comType[0])) {
                com.setComType((byte) 1);
            } else if ("comType2".equals(comType[0])) {
                com.setComType2((byte) 1);
            } else if ("comType3".equals(comType[0])) {
                com.setComType3((byte) 1);
            } else if ("comType4".equals(comType[0])) {
                com.setComType4((byte) 1);
            } else if ("comType5".equals(comType[0])) {
                com.setComType5((byte) 1);
            } else if ("comType6".equals(comType[0])) {
                com.setComType6((byte) 1);
            } else if ("comType7".equals(comType[0])) {
                com.setComType7((byte) 1);
            } else if ("comType8".equals(comType[0])) {
                com.setComType8((byte) 1);
            } else if ("comType9".equals(comType[0])) {
                com.setComType9((byte) 1);
            } else if ("comType10".equals(comType[0])) {
                com.setComType10((byte) 1);
            } else if ("comType11".equals(comType[0])) {
                com.setComType11((byte) 1);
            }
            com.setComBrand(item.getComBrand());//商品品牌
            com.setRetailPrice(new BigDecimal(item.getRetailPrice()));//建议零售价

            String[] taxId = item.getSlTaxId().split("-");
            com.setSlTaxId(Integer.parseInt(taxId[0]));//销项税

            String[] phTaxId = item.getPhTaxId().split("-");
            com.setPhTaxId(Integer.parseInt(phTaxId[0]));//进项税

            String[] sellStatus = item.getSellStatus().split("-");
            com.setSellStatus(Integer.parseInt(sellStatus[0]));//销售状态
            com.setRemark(item.getRemark());
            com.setDescription(item.getDescription());//说明
            com.setCreater(accountId);
            com.setcStatus(10602);//录入
            com.setModifier(accountId);


            //可售商品表====================================================================================
            CommodityTcbSalecom saleCom = new CommodityTcbSalecom();
            saleCom.setProjectId(projectId);

            saleCom.setComId(com.getComId());//关联商品信息

            saleCom.setComStatus(1);//销售商品状态 1可用
            saleCom.setCreater(accountId);
            saleCom.setComCode(com.getComCode());
            saleCom.setCommSpec(com.getComSpec());
            saleCom.setCommUnit(com.getComUnit());
            //Long barcodeInt = Long.valueOf(barCode);
            //Long aLong = ++barcodeInt;
            saleCom.setComBarcode(barCode);
            saleCom.setSaleCommUnit(com.getComUnit());//缺省信息  销售单位跟商品单位一致
            saleCom.setSaleComId(salecomId);
            saleCom.setIsDefault(10);//缺省
            saleCom.setPackContent(1);//包装含量
            saleCom.setModifier(accountId);
            //商品条码
            if (!StringUtils.isBlank(item.getComBarcode())) {
                saleCom.setComBarcode(item.getComBarcode());
            } else {
                saleCom.setComBarcode(collarUseService.getBarCode(projectId, 10, com.getComId(), 0, 0, 1).get("code").toString());
            }
            //   saleCom.setComBarcode(collarUseService.getBarCode(projectId, 10, com.getComId(), 0, 0, 1).get("code").toString());
            saleCom.setSaleComCode(com.getComCode() + "-01");

            //供应商商品表==================================================================================
            CommodityTcbSuppcomModel suppCom = new CommodityTcbSuppcomModel();
            suppCom.setProjectId(projectId);
            suppCom.setSupComId(suppcomId);

            String[] suppName = item.getSuppName().split("-");
            suppCom.setSuppId(Integer.parseInt(suppName[0]));
            suppCom.setComId(com.getComId());
            suppCom.setComCode(com.getComCode());
            suppCom.setComName(com.getComName());

            //  未税金额：含税金额*含税转未税税比率=未税金额
            //  含税金额：未税金额*未税转含税比率=含税金额

            suppCom.setTaxPaid(new BigDecimal(item.getTaxPaid()));//含税进价

            //计算规则取进项税字段id对应的税率
            CatecommTsbTax catecommTsbTax = getCatecommTsbTax(com.getPhTaxId(), projectId);
            if (catecommTsbTax != null) {

                BigDecimal notax = suppCom.getTaxPaid().multiply(catecommTsbTax.getConToFreeTax());//含税*比例
                BigDecimal newUnTaxPriceIn = notax.setScale(catecommTsbTax.getConToFreeNum(), 6);//需要保留的小数 ，  超过6会抛异常
                suppCom.setNoTaxPaid(newUnTaxPriceIn);//未税进价
            } else {
                throw new Exception( "税率信息不存在");
            }

            suppCom.setDeliveryType(10401);//直送
            suppCom.setIsDefault(10);

            //预估含税成本价
            // if (!StringUtils.isBlank(item.getComBarcode())) {
            suppCom.setFuTaxCost(new BigDecimal(item.getFuTaxCost()));
            //  }
            suppCom.setCreater(accountId);
            suppCom.setcStatus(10602);
            suppCom.setModifier(accountId);

            //价格等级表====================================================================================
            CommodityTcbGradeprice gradePrice = new CommodityTcbGradeprice();

            gradePrice.setProjectId(projectId);
            gradePrice.setGpId(gradepriceId);
            gradePrice.setComId(com.getComId());
            gradePrice.setSaleComId(saleCom.getSaleComId());

            //价格等级id
            String[] gradeId = item.getGradeId().split("-");
            gradePrice.setGradeId(Integer.parseInt(gradeId[0]));

            gradePrice.setRetailPrice(new BigDecimal(item.getGradeRetailPrice()));
            gradePrice.setCreater(accountId);
            gradePrice.setcStatus(1);

            //补充商品另一条等级信息
            CommodityTcbGradeprice nextGrade = gradePrice;
            gradepriceId = supplierService.getTableId(projectId, "commodity_tcb_gradeprice", 1);
            nextGrade.setGpId(gradepriceId);
            nextGrade.setRetailPrice(null);
            nextGrade.setcStatus(0);//0禁用 1启用
            if (gradePrice.getGradeId() == 10001) {//园内
                nextGrade.setGradeId(10002);
            } else { //园外
                nextGrade.setGradeId(10001);
            }
            comList.add(com);
            salecomList.add(saleCom);
            suppcomModelList.add(suppCom);
            gradepriceList.add(gradePrice);
        }

        // 保存商品基础信息
        comList.forEach(a->{
            if (autoBaseDao.save(a) == 0) {
                try {
                    throw new Exception("保存商品基础信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 保存可售商品信息
        salecomList.forEach(b->{
            if (autoBaseDao.save(b) == 0) {
                try {
                    throw new Exception("保存可售商品信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 保存供应商商品信息
        suppcomModelList.forEach(c->{
            if (autoBaseDao.save(c) == 0) {
                try {
                    throw new Exception("保存供应商商品信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 保存价格等级信息
        gradepriceList.forEach(d->{
            if (autoBaseDao.save(d) == 0) {
                try {
                    throw new Exception(" 保存价格等级信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return 1;
    }


    //追加错误信息
    private void appendStr(StringBuffer str,String value){
        if(StringUtils.isNotBlank(str.toString())){
            str.append("、"+value);
        }else{
            str.append(value);
        }
    }

    //判断商品名称是否存在
    private Boolean checkComName(String comName,List<CommodityTcbComImportDto> comList){
        for(CommodityTcbComImportDto com : comList){
            if(comName.equals(com.getComName())){
                return true;
            }
        }
        return false;
    }

    //判断商品条码是否存在
    private Boolean checkComBarcode(String comBarcode,List<CommodityTcbComImportDto> comList){
        for(CommodityTcbComImportDto com : comList){
            if(com.getComBarcode().equals(comBarcode)){
                return true;
            }
        }
        return false;
    }

    /**
     * 商品导入
     * @param excel
     * @param projectId
     * @param accountId
     * @return
     */
    @Override
    public String importPreComm(Excel<CommExeclVo> excel, Long projectId, Long accountId) throws Exception {
        List<CommodityTcbComImportDto> resultList = new ArrayList<CommodityTcbComImportDto>();
        List<CommodityTcbCom> comList = new ArrayList<CommodityTcbCom>();
        List<CommodityTcbSalecom> salecomList = new ArrayList<CommodityTcbSalecom>();
        List<CommodityTcbGradeprice> gradepriceList = new ArrayList<CommodityTcbGradeprice>();
        List<CommodityTcbSuppcomModel> suppcomModelList = new ArrayList<CommodityTcbSuppcomModel>();

        List<CatecommTssDatadictModel> dataDict = getDataDict("价格等级", projectId);
        String comCode = null;
        QueryBuilder<CatecommTssDatadictModel> queryBuilder = QueryBuilder.build(CatecommTssDatadictModel.class).whereEq("project_id", projectId).whereEq("dict_tp_code", 13001);
        CatecommTssDatadictModel data = autoBaseDao.findOne(queryBuilder);
        if(data == null){
            throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "获取项目编码失败！");
        }

        for (CommExeclVo item : excel.getData()) {
            Integer comId = supplierService.getTableId(projectId, "commodity_tcb_com", 1);
            String barCode = collarUseService.getBarCode(projectId, 10, comId, 0, 0, 1).get("code").toString();
            Integer salecomId = supplierService.getTableId(projectId, "commodity_tcb_salecom", 1);
            Integer suppcomId = supplierService.getTableId(projectId, "commodity_tcb_suppcom", 1);
            Integer gradepriceId = supplierService.getTableId(projectId, "commodity_tcb_gradeprice", 1);
            Integer comCodeId = supplierService.getTableId(projectId, "commodity_tcb_com_code", 1);
            CommodityTcbComImportDto tcbComInfo = new CommodityTcbComImportDto();
            StringBuffer reason = new StringBuffer();
            //重复商品名称， 商品条码  校验   字段非空校验
            if (StringUtils.isBlank(item.getComClassCode())) { //商品分类
                appendStr(reason,"商品分类数据为空");
            }else{
                String[] comClassCode = item.getComClassCode().split("-");
                CommodityTccComclassModel comClass = this.getCommodityClass(null,comClassCode[0],projectId);
                if (comClass == null) {
                    appendStr(reason,"分类"+comClassCode[1]+"不存在,请更换分类或下载最新模版");
                }else{
                    List<CommodityTccComclassModel> sonComClasses = this.queryCommodityClassByComcId(comClass.getComClassId(), projectId);
                    if (CollectionUtils.isNotEmpty(sonComClasses)) {
                        appendStr(reason,"分类"+comClassCode[1]+"下已存在子分类,请更换分类下载最新模版");
                    }
                }
            }
            if (StringUtils.isBlank(item.getComName())) { //商品名称
                appendStr(reason,"商品名称数据为空");
            }else{
                //商品名称不为空的时候，去掉空格
                item.setComName(item.getComName().replaceAll("\\s*", ""));
            }
            if (StringUtils.isBlank(item.getComAbbreviate())) { //商品简称
                appendStr(reason,"商品简称数据为空");
            }
            if (StringUtils.isBlank(item.getSellModel())) { //经营方式
                appendStr(reason,"经营方式数据为空");
            }
            if (StringUtils.isBlank(item.getComType())) { //商品类型
                appendStr(reason,"商品类型数据为空");
            }
            if (StringUtils.isBlank(item.getSellStatus())) { //商品销售状态
                appendStr(reason,"商品销售状态数据为空");
            }
            if (StringUtils.isBlank(item.getComUnit())) { //商品单位
                appendStr(reason,"商品单位数据为空");
            }
            if (StringUtils.isBlank(item.getPackContent())) { //商品单位
                appendStr(reason,"商品单位数据为空");
            }
            if (StringUtils.isBlank(item.getRetailPrice())) { //建议零售价
                appendStr(reason,"建议零售价数据为空");
            }
            if (StringUtils.isBlank(item.getPhTaxId())) { //进项税税率
                appendStr(reason,"进项税税率数据为空");
            }
            if (StringUtils.isBlank(item.getComSpec())) { //商品规格
                appendStr(reason,"商品规格数据为空");
            }
            if (StringUtils.isBlank(item.getSlTaxId())) { //销项税税率
                appendStr(reason,"销项税税率数据为空");
            }
//            if (StringUtils.isBlank(item.getSuppName())) { //供应商
//                appendStr(reason,"供应商数据为空");
//            }
//            if (StringUtils.isBlank(item.getPurchaseTaxPaid())) { //含税进价
//                appendStr(reason,"采购含税进价数据为空");
//            }else{
//                tcbComInfo.setTaxPaid(new BigDecimal(item.getPurchaseTaxPaid()));
//            }
//            if (StringUtils.isBlank(item.getFuTaxCost())) { //预估含税成本价
//                appendStr(reason,"预估含税成本价数据为空");
//            }else{
//                tcbComInfo.setFuTaxCost(new BigDecimal(item.getFuTaxCost()));//预估含税成本价
//            }
            if (StringUtils.isBlank(item.getGradeId())) { //价格等级
                appendStr(reason,"价格等级数据为空");
            }
            if (StringUtils.isBlank(item.getGradeRetailPrice())) { //零售价
                appendStr(reason,"零售价数据为空");
            }
            if (StringUtils.isBlank(item.getMaxWhCount())) { //最高库存
                appendStr(reason,"最高库存为空");
            }
            if (StringUtils.isBlank(item.getMinWhCount())) { //最低库存
                appendStr(reason,"最低库存为空");
            }
            if (StringUtils.isNotBlank(item.getPackContent())) {
                BigDecimal packContent = new BigDecimal(item.getPackContent());
                if(packContent.compareTo(new BigDecimal(1)) < 0){
                    appendStr(reason,"包装含量不能少于1");
                }
            }else{
                appendStr(reason,"包装含量为空");
            }
            if(StringUtils.isNotBlank(item.getMaxWhCount()) && StringUtils.isNotBlank(item.getMinWhCount())){
                BigDecimal maxWhCount = new BigDecimal(item.getMaxWhCount());
                BigDecimal minWhCount = new BigDecimal(item.getMinWhCount());
                //判断最低库存是否少于等于最高库存
                if(maxWhCount.compareTo(minWhCount) < 0){
                    appendStr(reason,"最低库存不能大于最高库存");
                }
            }
            List comm = checkComm(item, projectId);
            if (comm != null && comm.size() > 0) {
                appendStr(reason,"商品名称：" + item.getComName() + " 已存在");
            }
            if(StringUtils.isNotBlank(item.getComBarcode())){
                List saledComm = checkSaledComm(item, projectId);
                if (saledComm != null && saledComm.size() > 0) {
                    appendStr(reason,"商品条码：" + item.getComBarcode() + " 已存在");
                }
            }
            String[] sellModel = item.getSellModel().split("-");
            if (10003 == Integer.parseInt(sellModel[0])) { //联营
                if (StringUtils.isBlank(item.getDiscountRate())) { //联营折扣率
                    appendStr(reason,"联营折扣率为空");
                }
            }
            if(checkComName(item.getComName(),resultList)){
                appendStr(reason,"商品名称：" + item.getComName() + " 重复");
            }
            if(checkComBarcode(item.getComBarcode(),resultList)){
                appendStr(reason,"商品条码：" + item.getComBarcode() + " 重复");
            }

            NativeSQLBuilder queryComContract = NativeSQLBuilder.build(CommodityContract.class)
                    .setSql(" SELECT c.*,supp_name contract_supper_name FROM commodity_contract c " +
                            " left join commodity_tcb_supplier s on c.contract_supper = s.supp_id and c.project_id = s.project_id " +
                            " WHERE c.project_id = "+projectId+" " +
                            " AND c.is_delete = 0 AND DATE_FORMAT(now(),'%Y-%m-%d') <= contract_end_time " +
                            " AND contract_code = '" + item.getContractCode() + "' AND contract_stauts = 133003  AND contract_sell_model = "+Integer.parseInt(sellModel[0]));

            CommodityContract commodityContract = (CommodityContract)autoBaseDao.findOne(queryComContract);
            if(commodityContract == null){
                appendStr(reason,"无效的合同编号：" + item.getContractCode());
            }

            tcbComInfo.setComName(item.getComName());
            //商品条码
            if (!StringUtils.isBlank(item.getComBarcode())) {
                tcbComInfo.setComBarcode(item.getComBarcode());
            } else {
                tcbComInfo.setComBarcode(collarUseService.getBarCode(projectId, 10, comId, 0, 0, 1).get("code").toString());
            }
            tcbComInfo.setSellModel(Integer.parseInt(sellModel[0]));
            String[] comUnit = item.getComUnit().split("-");
            tcbComInfo.setComUnit(Integer.parseInt(comUnit[0]));
            tcbComInfo.setComUnitName(comUnit[1]);
            String[] taxId = null;
            String[] phTaxId = null;
            CatecommTsbTax catecommTsbTax = null;
            CatecommTsbTax catecommTsbPhTax = null;
            if(StringUtils.isNotBlank(item.getSlTaxId()) && StringUtils.isNotBlank(item.getPhTaxId())){
                taxId = item.getSlTaxId().split("-");
                phTaxId = item.getPhTaxId().split("-");
                //计算规则取进项税字段id对应的税率
                catecommTsbTax = getCatecommTsbTax(Integer.parseInt(taxId[0]), projectId);
                catecommTsbPhTax = getCatecommTsbTax(Integer.parseInt(phTaxId[0]), projectId);
                if (catecommTsbTax == null || catecommTsbPhTax == null) {
                    appendStr(reason,"税率信息不存在");
                } else{
                    tcbComInfo.setSlTax(item.getSlTaxId());//销项税
                    tcbComInfo.setPhTax(item.getPhTaxId());//进项税
                }
            }
            tcbComInfo.setSuppName(item.getSuppName());
            tcbComInfo.setMessage(reason.toString());
            tcbComInfo.setComName(item.getComName());//商品名称
            if(StringUtils.isBlank(reason.toString())){
                tcbComInfo.setResult(0);
            }else{
                tcbComInfo.setResult(1);
            }
            resultList.add(tcbComInfo);
            if(StringUtils.isNotBlank(tcbComInfo.getMessage())){
                continue;
            }
            //解析数据并插入数据库
            //商品主表=================================================================================
            CommodityTcbCom com = new CommodityTcbCom();

            com.setProjectId(projectId);
            com.setProjectRootId(projectId);
            com.setComId(comId);

            com.setComName(item.getComName());//商品名称
            com.setComAbbreviate(item.getComAbbreviate());//商品简称


            //String[] comUnit = item.getComUnit().split("-");
            com.setComUnit(Integer.parseInt(comUnit[0]));//商品单位
            com.setComSpec(item.getComSpec());//规格

            String[] comClassCode = item.getComClassCode().split("-");
            com.setComClassCode(comClassCode[0]);//商品分类编号


            String endStr = String.format("%05d", comCodeId);
            comCode = data.getDictTpValue() + classStr(comClassCode[0]) + endStr;
            com.setComCode(comCode);//商品编号

            //String[] sellModel = item.getSellModel().split("-");
            com.setSellModel(Integer.parseInt(sellModel[0]));//经营方式

            if (10003 == com.getSellModel()) { //联营
                com.setDiscountRate(new BigDecimal(item.getDiscountRate()));
            }
            com.setManufacturer(item.getManufacturer());//生产厂家
            com.setExpirationDate(Integer.parseInt(item.getExpirationDate()));//保质期

            //产品等级
            if (!StringUtils.isBlank(item.getComGrade())) {
                String[] comGrade = item.getComGrade().split("-");
                com.setComGrade(comGrade[0]);
            }
            com.setMaxWhCount(new BigDecimal(item.getMaxWhCount()));//最高库存数
            com.setMinWhCount(new BigDecimal(item.getMinWhCount()));//最低库存数

            String[] comType = item.getComType().split("-");
            if ("comType".equals(comType[0])) {
                com.setComType((byte) 1);
            } else if ("comType2".equals(comType[0])) {
                com.setComType2((byte) 1);
            } else if ("comType3".equals(comType[0])) {
                com.setComType3((byte) 1);
            } else if ("comType4".equals(comType[0])) {
                com.setComType4((byte) 1);
            } else if ("comType5".equals(comType[0])) {
                com.setComType5((byte) 1);
                if(StringUtils.isNotBlank(item.getIsDeposit())){
                    Integer isDeposit = item.getIsDeposit().equals("是")?1:0;
                    com.setIsDeposit(isDeposit);
                }
            } else if ("comType6".equals(comType[0])) {
                com.setComType6((byte) 1);
            } else if ("comType7".equals(comType[0])) {
                com.setComType7((byte) 1);
            } else if ("comType8".equals(comType[0])) {
                com.setComType8((byte) 1);
            } else if ("comType9".equals(comType[0])) {
                com.setComType9((byte) 1);
            } else if ("comType10".equals(comType[0])) {
                com.setComType10((byte) 1);
            } else if ("comType11".equals(comType[0])) {
                com.setComType11((byte) 1);
            }
            com.setComBrand(item.getComBrand());//商品品牌
            com.setRetailPrice(new BigDecimal(item.getRetailPrice()));//建议零售价

            //String[] taxId = item.getSlTaxId().split("-");
            com.setSlTaxId(Integer.parseInt(taxId[0]));//销项税

            //String[] phTaxId = item.getPhTaxId().split("-");
            com.setPhTaxId(Integer.parseInt(phTaxId[0]));//进项税
            com.setPhTax(phTaxId[1]);
            String[] sellStatus = item.getSellStatus().split("-");
            com.setSellStatus(Integer.parseInt(sellStatus[0]));//销售状态
            com.setRemark(item.getRemark());
            com.setDescription(item.getDescription());//说明
            com.setCreater(accountId);
            com.setcStatus(10602);//录入
            com.setModifier(accountId);


            //可售商品表====================================================================================
            CommodityTcbSalecom saleCom = new CommodityTcbSalecom();
            saleCom.setProjectId(projectId);

            saleCom.setComId(com.getComId());//关联商品信息

            saleCom.setComStatus(1);//销售商品状态 1可用
            saleCom.setCreater(accountId);
            saleCom.setComCode(com.getComCode());
            saleCom.setCommSpec(com.getComSpec());
            saleCom.setCommUnit(com.getComUnit());
//            Long barcodeInt = Long.valueOf(barCode);
//            Long aLong = ++barcodeInt;
            saleCom.setComBarcode(barCode);
            saleCom.setSaleCommUnit(com.getComUnit());//缺省信息  销售单位跟商品单位一致
            saleCom.setSaleComId(salecomId);
            saleCom.setIsDefault(10);//缺省
            saleCom.setPackContent(1);//包装含量
            saleCom.setModifier(accountId);
            saleCom.setScStatus(10602);
            //商品条码
            if (!StringUtils.isBlank(item.getComBarcode())) {
                saleCom.setComBarcode(item.getComBarcode());
            } else {
                saleCom.setComBarcode(collarUseService.getBarCode(projectId, 10, com.getComId(), 0, 0, 1).get("code").toString());
            }
            //   saleCom.setComBarcode(collarUseService.getBarCode(projectId, 10, com.getComId(), 0, 0, 1).get("code").toString());
            saleCom.setSaleComCode(com.getComCode() + "-01");

            //如果包装含量等于一 系统会认定采购单位和商品单位一致
            Integer packContent = Integer.valueOf(item.getPackContent());
            if(packContent == 1){
                saleCom.setIsPurChaseUnit(1);
            }else{
                saleCom.setIsPurChaseUnit(0);

                //新增一条采购包装单位数据
                CommodityTcbSalecom saleCom1 = new CommodityTcbSalecom();
                saleCom1.setProjectId(projectId);
                saleCom1.setComId(com.getComId());//关联商品信息
                saleCom1.setComStatus(1);//销售商品状态 1可用
                saleCom1.setCreater(accountId);
                saleCom1.setSaleComCode(com.getComCode() + "-02");
                saleCom1.setComCode(com.getComCode());
                saleCom1.setCommSpec(com.getComSpec());
                saleCom1.setCommUnit(com.getComUnit());
                String barCode1 = collarUseService.getBarCode(projectId, 10, comId, 0, 0, 1).get("code").toString();
                saleCom1.setComBarcode(barCode1);
                String[] purchaseUnit = item.getPurchaseUnit().split("-");
                saleCom1.setSaleCommUnit(Integer.valueOf(purchaseUnit[0]));//采购单位
                Integer salecomId1 = supplierService.getTableId(projectId, "commodity_tcb_salecom", 1);
                saleCom1.setSaleComId(salecomId1);
                saleCom1.setIsDefault(20);
                saleCom1.setPackContent(packContent);//包装含量
                saleCom1.setModifier(accountId);
                saleCom1.setScStatus(10602);
                saleCom1.setIsPurChaseUnit(1);
                salecomList.add(saleCom1);
            }

            //供应商商品表==================================================================================
            CommodityTcbSuppcomModel suppCom = new CommodityTcbSuppcomModel();
            suppCom.setProjectId(projectId);
            suppCom.setSupComId(suppcomId);
            //suppCom.setC();

            //String[] suppName = item.getSuppName().split("-");
            suppCom.setSuppId(commodityContract.getContractSupper());
            suppCom.setContractCode(commodityContract.getContractCode());
            suppCom.setContractId(commodityContract.getContractId());
            suppCom.setContractName(commodityContract.getContractName());
            suppCom.setComId(com.getComId());
            suppCom.setComCode(com.getComCode());
            suppCom.setComName(com.getComName());
            suppCom.setIsEliminate(1);//默认正常

            //  未税金额：含税金额*含税转未税税比率=未税金额
            //  含税金额：未税金额*未税转含税比率=含税金额

            CatecommTssDatadictDto taxDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.tax_reserved_decimal.getName());
            CatecommTssDatadictDto notaxDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.notax_reserved_decimal.getName());
            CatecommTssDatadictDto taxTotalDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.tax_total_reserved_decimal.getName());
            CatecommTssDatadictDto notaxTotalDataDict = dataDictApi.findDataByCode(DictDataTypeEnum.notax_total_reserved_decimal.getName());

            //采购含税进价
            BigDecimal purchaseTaxPaid = new BigDecimal(item.getPurchaseTaxPaid());
            suppCom.setPurchaseTaxPaid(purchaseTaxPaid);
            suppCom.setOldPurchaseTaxPaid(purchaseTaxPaid);
            //含税进价 = 采购含税进价/包装含量
            BigDecimal taxPaid = new BigDecimal(item.getPurchaseTaxPaid()).divide(new BigDecimal(packContent),Integer.valueOf(taxDataDict.getDictTpValue()),BigDecimal.ROUND_HALF_UP);
            suppCom.setTaxPaid(taxPaid);
            suppCom.setOldTaxPaid(taxPaid);
            if (10003 == com.getSellModel()) { //联营
                suppCom.setDiscountRate(new BigDecimal(item.getDiscountRate()));//联营扣率
            }
            suppCom.setPhTax(phTaxId[1]);
            suppCom.setPhTaxId(Integer.parseInt(phTaxId[0]));//进项税


            //计算规则取进项税字段id对应的税率
            //CatecommTsbTax catecommTsbTax = getCatecommTsbTax(com.getPhTaxId(), projectId);
            if (catecommTsbPhTax != null) {
                Integer taxDecimal = Integer.valueOf(notaxDataDict.getDictTpValue());
                BigDecimal notax = suppCom.getTaxPaid().multiply(catecommTsbPhTax.getConToFreeTax());//含税*比例
                BigDecimal newUnTaxPriceIn = notax.setScale(taxDecimal,BigDecimal.ROUND_HALF_UP);//需要保留的小数 ，  超过6会抛异常
                suppCom.setNoTaxPaid(newUnTaxPriceIn);//未税进价
                suppCom.setOldNoTaxPaid(newUnTaxPriceIn);

                //采购未税进价
                BigDecimal noPurTaxPaid = suppCom.getPurchaseTaxPaid().multiply(catecommTsbPhTax.getConToFreeTax()).setScale(taxDecimal, BigDecimal.ROUND_HALF_UP);
                suppCom.setPurchaseNoTaxPaid(noPurTaxPaid);
                suppCom.setOldPurchaseNoTaxPaid(noPurTaxPaid);
            }

            suppCom.setDeliveryType(10401);//直送
            suppCom.setIsDefault(10);

            //预估含税成本价
            // if (!StringUtils.isBlank(item.getComBarcode())) {
            //预估含税成本价 = 含税进价
            suppCom.setFuTaxCost(taxPaid);
            //  }
            suppCom.setCreater(accountId);
            suppCom.setcStatus(10602);
            suppCom.setModifier(accountId);

            //价格等级表====================================================================================
            CommodityTcbGradeprice gradePrice = new CommodityTcbGradeprice();
            gradePrice.setProjectId(projectId);
            gradePrice.setGpId(gradepriceId);
            gradePrice.setComId(com.getComId());
            gradePrice.setSaleComId(saleCom.getSaleComId());

            //价格等级id
            String[] gradeId = item.getGradeId().split("-");
            gradePrice.setGradeId(Integer.parseInt(gradeId[0]));
            gradePrice.setRetailPrice(new BigDecimal(item.getGradeRetailPrice()));
            gradePrice.setOldRetailPrice(new BigDecimal(item.getGradeRetailPrice()));
            gradePrice.setCreater(accountId);
            gradePrice.setcStatus(1);

            comList.add(com);
            salecomList.add(saleCom);
            suppcomModelList.add(suppCom);
            gradepriceList.add(gradePrice);

            for(CatecommTssDatadictModel dict : dataDict){
                if(dict.getDictTpCode().equals(Integer.parseInt(gradeId[0]))){
                    continue;
                }
                CommodityTcbGradeprice nextGrade = new CommodityTcbGradeprice();
                try {
                    BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                    ConvertUtils.register(new DateConverter(null), Date.class);
                    BeanUtils.copyProperties(nextGrade, gradePrice);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gradepriceId = supplierService.getTableId(projectId, "commodity_tcb_gradeprice", 1);
                nextGrade.setGpId(gradepriceId);
                nextGrade.setRetailPrice(BigDecimal.ZERO);
                nextGrade.setOldRetailPrice(BigDecimal.ZERO);
                nextGrade.setcStatus(0);//0禁用 1启用
                nextGrade.setGradeId(dict.getDictTpCode());
                gradepriceList.add(nextGrade);
            }
        }
        String randomStr = UUID.randomUUID().toString();
        Map map = new HashMap();
        map.put("comList",comList);
        map.put("salecomList",salecomList);
        map.put("suppcomModelList",suppcomModelList);
        map.put("gradepriceList",gradepriceList);
        map.put("resultList",resultList);
       // redisUtil.setForSeconds(randomStr, JSON.toJSONString(map), 30*60L);
        return randomStr;
    }

    public CommodityTccComclassModel getCommodityClass(Integer comcId,String comcCode,Long projectId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                .setSql("select t1.* from commodity_tcc_comclass t1  where t1.is_delete = 0 and t1.project_id = #{projectId}");
        tsbTaxBuild.setValue("projectId",projectId);
        if (comcId != null) {
            tsbTaxBuild.append(" and t1.`com_class_id`=" + comcId + "");
        }
        if (StringUtils.isNotBlank(comcCode)) {
            tsbTaxBuild.append(" and t1.`com_class_code`=" + comcCode + "");
        }
        return (CommodityTccComclassModel) autoBaseDao.findOne(tsbTaxBuild);
    }


    public List<CommodityTccComclassModel> queryCommodityClassByComcId(Integer comcId, Long projectId) {
        NativeSQLBuilder comClass = NativeSQLBuilder.build(CommodityTccComclassModel.class)
                .setSql("SELECT * FROM commodity_tcc_comclass  WHERE ucom_class_id = #{ucomcId} and is_delete=0 and project_id = #{projectId}" );
        comClass.setValue("ucomcId",comcId);
        comClass.setValue("projectId",projectId);
        return autoBaseDao.listAll(comClass);
    }

    private String classStr(String str){
        if(StringUtils.isNotBlank(str)){
            if(str.length() == 2){
                str = str +"0000";
            }else if(str.length() == 4){
                str = str +"00";
            }
        }
        return str;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommodityResponse listImportCom(String redisKey, Integer pageNo, Integer pageSize,Integer type,Long user) {
        Map map = null;//JSON.parseObject(redisUtil.get(redisKey).toString(), HashMap.class);
        List<CommodityTcbComImportDto> resultList = JSON.parseArray(map.get("resultList").toString(),CommodityTcbComImportDto.class);
        CommodityResponse response = new CommodityResponse();
        int total = resultList.size();
        response.setTotal(total);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setCode(100);
        if (type == 1) {
            List<CommodityTcbComImportDto> subItems = resultList.stream().filter(b -> type.intValue() == b.getResult()).collect(Collectors.toList());
            total = subItems.size();
            response.setTotal(total);
            subItems = subItems.size() <= pageSize ? subItems : subItems.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo)));
            response.setResultList(subItems);
            return response;
        }else if(type == 2){
            List<CommodityTcbCom> comList = JSON.parseArray(map.get("comList").toString(),CommodityTcbCom.class);
            List<CommodityTcbSalecom> salecomList = JSON.parseArray(map.get("salecomList").toString(),CommodityTcbSalecom.class);
            List<CommodityTcbSuppcomModel> suppcomModelList = JSON.parseArray(map.get("suppcomModelList").toString(),CommodityTcbSuppcomModel.class);
            List<CommodityTcbGradeprice> gradepriceList = JSON.parseArray(map.get("gradepriceList").toString(),CommodityTcbGradeprice.class);
            // 保存商品基础信息
            comList.forEach(a->{
                if (autoBaseDao.save(a) == 0) {
                    try {
                        throw new Exception(" 保存商品基础信息失败");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int result = rawmaterApi.saveBasicDataLog(a.getProjectId(),a.getComId(),10, BasicDataLogStatus.LOG_INFO,"导入商品，商品编号【"+a.getComCode()+"】",user);
                if (result <= 0) {
                    try {
                        throw new Exception(ErrorCode.RAWMATER_NOT_TO_EXAMINE +  "商品包装信息操作日志失败！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            // 保存可售商品信息
            salecomList.forEach(b->{
                if (autoBaseDao.save(b) == 0) {
                    try {
                        throw new Exception("保存可售商品信息失败");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            // 保存供应商商品信息
            suppcomModelList.forEach(c->{
                if (autoBaseDao.save(c) == 0) {
                    try {
                        throw new Exception("保存供应商商品信息失败");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            // 保存价格等级信息
            gradepriceList.forEach(d->{
                if (autoBaseDao.save(d) == 0) {
                    try {
                        throw new Exception(" 保存价格等级信息失败");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            response.setResultList(resultList);
            return response;
        }else{
            List<CommodityTcbComImportDto> subItems = resultList.size() <= pageSize ? resultList : resultList.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo)));
            response.setResultList(subItems);
            return response;
        }
    }

    public List<CatecommTssDatadictModel> getDataDict(String type, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                .setSql("SELECT * FROM catecomm_tss_datadict \n" +
                        "WHERE dd_status = 1 and project_id =" + projectId + " and dict_name = '" + type + "'" );
        return autoBaseDao.listAll(supplier);
    }

    //校验商品主表数据
    public List checkComm(CommExeclVo info, Long projectId) {
        //删除和销售淘汰商品可重名，其余不行

        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(Object.class).setSql("select * from commodity_tcb_com where is_delete = 0 ")
                .appendIfOpt("and com_name  = #{comName}", "comName", info.getComName())
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        List list = autoBaseDao.listAll(queryBuilder);
        return list;
    }

    //校验可售商品表数据
    public List checkSaledComm(CommExeclVo info, Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(Object.class).setSql("select * from commodity_tcb_salecom where is_delete = 0 ")
                .appendIfOpt("and com_barcode  = #{comBarcode}", "comBarcode", info.getComBarcode())
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        List list = autoBaseDao.listAll(queryBuilder);
        return list;
    }

    //根据税率id查询含税转未税比例
    public CatecommTsbTax getCatecommTsbTax(Integer taxId, Long projectId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CatecommTsbTax.class).setSql("select *from catecomm_tsb_tax where is_delete = 0 and t_status = 0 ")
                .appendIfOpt("and tax_id  = #{taxId}", "taxId", taxId)
                .appendIfOpt("and project_id  = #{projectId}", "projectId", projectId);
        return (CatecommTsbTax) autoBaseDao.findOne(tsbTaxBuild);

    }


    //查询商品基础信息列表
    @Override
    public List<ExportCommInfo> exportCommOut(CommodityTcbComVo info, Long projectId) {

        List<ExportCommInfo>  classCodeList = new ArrayList<>();
        List<String> classCodes = new ArrayList<String>();
        String sql = "";
        if(info.getComClassCode().equals("全部") && info.getComClassId() == 1){
            sql = "select com_class_code from commodity_tcc_comclass where com_class_id IN (select com_class_id from commodity_tcc_comclass where project_id = "+projectId+" and ucom_class_id = "+info.getUcomClassId()+")";
        }else if(info.getComClassCode().equals("全部") && info.getComClassId() == 2){
            sql = "select com_class_code from commodity_tcc_comclass where project_id = "+projectId+" and ucom_class_id = "+info.getUcomClassId();
        }
        if(StringUtils.isNotEmpty(sql)){
            NativeSQLBuilder<ExportCommInfo> queryBuilder = NativeSQLBuilder.build(ExportCommInfo.class).setSql(sql);
            classCodeList = autoBaseDao.listAll(queryBuilder);
            for (ExportCommInfo commInfo: classCodeList) {
                classCodes.add(commInfo.getComClassCode());
            }
        }
        List<String> classCodesThree = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(classCodes)) {
            String join = Joiner.on(",").join(classCodes);
            // 最后一级
            if (info.getComClassCode().equals("全部") && info.getComClassId() == 1) {
                NativeSQLBuilder<String> builder = NativeSQLBuilder.build(String.class)
                        .setSql("select com_class_code from commodity_tcc_comclass where com_class_id IN ( select com_class_id from commodity_tcc_comclass where project_id = "+projectId+"\n"+
                                "\t and ucom_class_code IN ("+join+"))");
                classCodesThree = autoBaseDao.listAll(builder);
                classCodesThree.add(join);
            }
        }

        if (!info.getUcomClassCode().equals("0")) {
            classCodesThree.add(info.getUcomClassCode());
        }


        String classCode = " ( select CONCAT(t2.com_class_name,t2.com_class_code) as first_code from \n" +
                "\t commodity_tcc_comclass t2 where substring(ctc.com_class_code,1,2)  = t2.com_class_code and t2.project_id = "+projectId+"\n" +
                "\t ) first_code,\n" +
                "\t (select CONCAT(t3.com_class_name,t3.com_class_code) as two_code from \n" +
                "\t commodity_tcc_comclass t3 where substring(ctc.com_class_code,1,4)  = t3.com_class_code  and  LENGTH(ctc.com_class_code) >= 4  and t3.project_id = "+projectId+" ) two_code,\n" +
                "\t (select CONCAT(t4.com_class_name,t4.com_class_code) as three_code from\n" +
                " \t commodity_tcc_comclass t4 where substring(ctc.com_class_code,1,6)  = t4.com_class_code  and  LENGTH(ctc.com_class_code) >= 6 and t4.project_id = "+projectId+") three_code ,";


        NativeSQLBuilder<ExportCommInfo> queryBuilder = NativeSQLBuilder.build(ExportCommInfo.class).setSql(
                "select ctc.com_name ,ctc.com_code ,ctc.discount_rate ,ctc.is_deposit," + classCode +
                        "       ctc.com_abbreviate ,ctc.com_spec ,ctc.expiration_date ,ctc.com_brand ,ctc.retail_price ," +
                        "\t    (select type_name from catecomm_tss_pubdatadict where type_code = ctc.c_status) as statusStr," +
                        "       ctc.sell_model ,(select type_name from catecomm_tss_pubdatadict where type_code=ctc.sell_model) sellModelName," +
                        "       CONCAT(IFNULL(CONCAT((case ctc.com_type   when '1' then '正常商品'  else null END),'/'),'')," +
                        "              IFNULL(CONCAT((case ctc.com_type2   when '1' then '大类商品'  else null END),'/'),'')," +
                        "              IFNULL(CONCAT((case ctc.com_type3   when '1' then '称重商品'  else null END),'/'),'')," +
                        "              IFNULL(CONCAT((case ctc.com_type4   when '1' then '赠品'  else null END),'/'),'')," +
                        "              IFNULL(CONCAT((case ctc.com_type5   when '1' then '服务类'  else null END),'/'),'')" +
                        "       ) comType," +
                        "       ctc.sell_status ,(select type_name from catecomm_tss_pubdatadict where type_code=ctc.sell_status) sellStatusName," +
                        "       ctc.com_unit ,(select type_name from catecomm_tss_pubdatadict where type_code=ctc.com_unit) comUnitName," +
                        "       ctc.com_grade ,(select dict_tp_value from catecomm_tss_datadict where dict_tp_code=ctc.com_grade and project_id =" + projectId + ") comGradeName," +
                        "       ctc.ph_tax_id ,(select tax_name from catecomm_tsb_tax where tax_id=ctc.ph_tax_id and project_id =" + projectId + ") phTaxName," +
                        "       ctc.sl_tax_id ,(select tax_name from catecomm_tsb_tax where tax_id=ctc.sl_tax_id and project_id =" + projectId + ") slTaxName," +
                        "       ctc.max_wh_count ,ctc.min_wh_count ,ctc.manufacturer ,ctc.description ," +
                        "       (select type_name from catecomm_tss_pubdatadict where type_code=cts.comm_unit) saleUnitName," +
                        " \n" +
                        "       case cts.com_status   when '0' then '淘汰'  when'1' then '正常' else '其他' END  commStatusName," +
                        "       case cts.sa_is_default   when '10' then '是'  when'20' then '否' else '其他' END  isDefaultNameSale," +
                        "       case supp.su_is_default   when '10' then '是'  when'20' then '否' else '其他' END  isDefaultNameSupp," +
                        "       (select type_name from catecomm_tss_pubdatadict where type_code = cts.sc_status) as saleStatusStr," +
                        "       case supp.is_eliminate   when '0' then '淘汰'  when'1' then '正常' else '其他' END  suppStatusName," +
                        "       (select type_name from catecomm_tss_pubdatadict where type_code = supp.c_status) as suppStatusStr," +
                        "       (select dict_tp_value from catecomm_tss_datadict where dict_tp_code=supp.delivery_type and project_id =" + projectId + ")  deliveryTypeName," +
                        "       cts.*,supp.* " +
                        "from commodity_tcb_com ctc " +
                        "\n" +
                        "LEFT JOIN (select com_id sa_com_id, com_barcode,pack_content,comm_unit,sale_com_code,com_status,sc_status,is_default sa_is_default " +
                        "             from commodity_tcb_salecom where is_default = 10 and project_id =" + projectId + " and is_delete = 0 " +
                        "          ) cts  on ctc.com_id = cts.sa_com_id\n" +
                        "\n" +
                        "LEFT JOIN (select com_id su_com_id ,tax_paid,no_tax_paid,fu_tax_cost,is_default su_is_default,c_status,is_eliminate,supp_name,delivery_type from commodity_tcb_suppcom ctsup  " +
                        "             LEFT JOIN commodity_tcb_supplier csup on ctsup.supp_id = csup.supp_id and  csup.project_id = " + projectId + " and csup.is_delete = 0 " +
                        "           where ctsup.is_default = 10 and ctsup.project_id = " + projectId + " and ctsup.is_delete = 0 " +
                        "          )supp  on ctc.com_id = supp.su_com_id " +
                        "\n" +
                        "where  ctc.is_delete = 0 ");
                if (info.getComClassCode().equals("全部") && info.getComClassId() == 1) {
                    queryBuilder.append(CollectionUtils.isNotEmpty(classCodesThree) ? " and ctc.com_class_code IN ("+Joiner.on(",").join(classCodesThree)+")" : "");
                } else if(info.getComClassCode().equals("全部") && info.getComClassId() == 2){
                    queryBuilder.append(CollectionUtils.isNotEmpty(classCodes) ? " and ctc.com_class_code IN ("+Joiner.on(",").join(classCodes)+")" : "");
                } else if(!info.getComClassCode().equals("全部")) {
                    queryBuilder.append(StringUtils.isNotEmpty(info.getComClassCode()) ? " and ctc.com_class_code IN ("+info.getComClassCode()+")" : "");
                }
                queryBuilder.appendIfOpt(" and ctc.project_id = #{projectId}", "projectId", projectId);//公司id

                queryBuilder.append("order by ctc.created_time desc");

        return autoBaseDao.listAll(queryBuilder);

    }

    @Override
    public AccountModel getAccountObj(Long accountId) {
        QueryBuilder<AccountModel> queryBuilder = QueryBuilder.build(AccountModel.class).whereEq("id", accountId);
        return autoBaseDao.findOne(queryBuilder);
    }

    @Override
    public String importCommSupp(Excel<CommSuppExeclVo> excel, Long projectId, Long projectRootId, Long accountId) {
        List<CommSuppExeclVo> oldExeclVos = excel.getData();
        //去重得到新的数据
        List<CommSuppExeclVo> newExeclVos =  oldExeclVos.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(o -> o.getComCode() + ";" + o.getContractCode()))), ArrayList::new)
        );
        newExeclVos.forEach(x -> {
            if(StringUtils.isEmpty(x.getComCode())){
                try {
                    throw new Exception( "商品编号不能为空");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(StringUtils.isEmpty(x.getComCode())){
                try {
                    throw new Exception("合同编号不能为空");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(StringUtils.isEmpty(x.getComCode())){
                try {
                    throw new Exception("进项税税率不能为空");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(StringUtils.isEmpty(x.getComCode())){
                try {
                    throw new Exception( "采购含税进价不能为空");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return null;
    }


//    public static void main(String[] args) {
//         BigDecimal num = new BigDecimal("8.8495571111");//一般都会这样写最好
//        BigDecimal count = num.setScale(6,5);
//
//        System.out.println(count);//6 返回的是小数点后位数
//    }
}
