package com.restaurant.service.impi.dishes;


import com.alibaba.fastjson.JSON;

import com.changshang.feign.SupplierServiceFeign;
import com.changshang.feign.allocation.CollarUseFeign;
import com.restaurant.service.dishes.DishesClassService;
import com.restaurant.service.dishes.DishesService;
import com.restaurant.service.rawmater.RawmaterApi;
import entity.GetPell;
import entity.IdWorker;
import entity.ModelPagedList;
import entity.RedisUtil;
import excel.Excel;
import modelpojo.Constant;
import modelpojo.ErrorCode;
import modelpojo.ListIdsToString;
import modelpojo.RpcException;
import modelpojo.model.*;
import modelpojo.model.contract.CateringContract;
import modelpojo.vo.DishExchangeDto;
import modelpojo.vo.DishGroupDto;
import modelpojo.vo.DishesDto;
import modelpojo.vo.DishesSpecDto;
import modelpojo.vo.dishbom.DishBomVo;
import modelpojo.vo.saleadjust.DishesExeclMessage;
import modelpojo.vo.saleadjust.DishesExeclVo;
import modelpojo.vo.saleadjust.DishesResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.lufei.ibatis.builder.DeleteBuilder;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DishesServiceImpl implements DishesService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    AutoBaseDao autoBaseDao = new AutoDaoImpl();


    @Resource
    IdWorker idWorker;

    @Resource
    SupplierServiceFeign supplierService;

    @Resource
    CollarUseFeign collarUseService;

    @Resource
    RawmaterApi rawmaterApi;

    private RedisUtil redisUtil = new RedisUtil();

    @Override
    public ModelPagedList getDishesList(DishesDto query, int pageNo, int pageSize, String orderBy, Integer type) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                .setSql("SELECT * FROM (\n" +
                        "SELECT t1.*, t3.type_name, t4.type_name as unit_name, t5.nick_name,\n " +
                        //"t2.dish_class_name,\n" +
                        "(SELECT t.type_name FROM catecomm_tss_pubdatadict t WHERE t.type_code = t1.sell_model) AS sellModelName,\n" +
                        "(CASE WHEN  t7.db_status = 13903  THEN '存在' ELSE '不存在' END) AS isBom \n" +
                        "FROM catering_tcb_dishes t1 \n" +
                        //"LEFT JOIN catering_tcc_dishes_class t2 ON t2.dish_class_code = t1.dish_class_code  and t2.project_id = t1.project_id \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                        "LEFT JOIN account t5 ON t5.id = t1.creater \n" +
                        "LEFT JOIN catering_tcb_dish_spec t6 ON t6.dish_id = t1.dish_id AND t1.project_id = t6.project_id\n" +
                        "LEFT JOIN catering_tcb_dish_bom t7 ON t7.dish_id = t1.dish_id AND t7.project_id = t1.project_id AND t7.is_delete = 0 AND t7.db_status = 13903\n" +
                        "WHERE t1.is_delete = 0\n");
        supplier.append("and t1.project_id =" + query.getProjectId());
        if (0 == type) {
            supplier.append("and t1.dish_type != 11002\n");
        } else {
            supplier.append("and t1.dish_type = 11002\n");
        }
        supplier.append(null != query.getSellModel() ? ("and t1.sell_model = \n" + (query.getSellModel()) + "\n") : "");

        if (StringUtils.isNotEmpty(query.getDishClassCode())) {
            //判断是否是第一级分类
            String dishClassCode = this.getChildCode(query.getProjectId(), query.getDishClassCode());
            //下级分类为空，说明是最后一级
            if (StringUtils.isEmpty(dishClassCode)) {
                supplier.append(" and t1.dish_class_code IN (\n" + query.getDishClassCode() + ")\n");
            }  else {
                //不为空获取二级分类
                String childCode = getChildCode(query.getProjectId(), query.getDishClassCode());
                //不为空获取三级分类
                String childLastCode = "";
                if (StringUtils.isNotEmpty(childCode)) {
                    childLastCode = getChildCode(query.getProjectId(), childCode);
                }

                if(StringUtils.isNotEmpty(childLastCode)){//将第一级及包含的第二级、第三级分类一起查询
                    supplier.append(" and t1.dish_class_code IN (\n"  + query.getDishClassCode() + "," + childCode + "," + childLastCode + ")\n");
                } else {
                    //isALL代表查全部 如果有值 证明是查包含下级全部 否则只查当前自己这个分类及下面的所有子类
                    supplier.append(" and t1.dish_class_code IN (\n" + query.getDishClassCode() + "," +  childCode + ")\n");
                }
            }
        }
        supplier.append(StringUtils.isNotBlank(query.getDishCode()) ? (" and t1.dish_code = \n" + query.getDishCode() + "\n") : "");
        supplier.append(null != query.getDishType() ? ("and t1.dish_type =\n" + (query.getDishType()) + "\n") : "");
        supplier.append(null != query.getSpecId() ? ("and t6.spec_id = \n" + (query.getSpecId()) + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getDishName()) ? ("and t1.dish_name like\n" + "'%" + (query.getDishName()) + "%'\n") : "");
        supplier.append(null != query.getcStatus() ? ("and t1.c_status =\n" + (query.getcStatus()) + "\n") : "");
        supplier.append("group by t1.dish_id\n");
        supplier.append("order by\n" + (StringUtils.isNotBlank(orderBy) ? ("t1." + orderBy + "\ndesc,") : "")
                + "t1.created_time desc\n");
        supplier.append(") A");
        supplier.append(StringUtils.isNotBlank(query.getIsBom()) ? (" WHERE isBom = '" + query.getIsBom() + "'\n") : "");
        supplier.setPage(pageNo, pageSize);
        PagedList<DishesDto> dishesDtos = autoBaseDao.listPage(supplier);
        dishesDtos.forEach(a -> {
            //查询当前菜品分类编号的上级编号
            NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                    .setSql("SELECT dish_id, dish_class_code, udish_id, udish_class_code, dish_class_name, udish_class_name \n" +
                            "FROM catering_tcc_dishes_class \n" +
                            "WHERE dish_class_code = '" + a.getDishClassCode() + "' and project_id = " + a.getProjectId());
            CateringTccDishesClassModel dishesFClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);

            CateringTccDishesClassModel dishesFMaxClassModel = null;
            //组装最大父级的菜品分类编号
            if (null != dishesFClassModel) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                        .setSql("SELECT dish_id, dish_class_code, dish_class_name, udish_id FROM catering_tcc_dishes_class\n" +
                                "WHERE dish_id = (SELECT dish_id FROM catering_tcc_dishes_class\n" +
                                "WHERE dish_id =" + dishesFClassModel.getUdishId() +" AND project_id =" +  a.getProjectId() + ")\n" +
                                "AND project_id = " +  a.getProjectId());
                dishesFMaxClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sqlMax);
            }

            CateringTccDishesClassModel dishesFMaxMaxClassModel = null;
            if (null != dishesFMaxClassModel && dishesFMaxClassModel.getUdishId().intValue() != 0) {
                NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                        .setSql("SELECT dish_id, dish_class_code, dish_class_name FROM catering_tcc_dishes_class\n" +
                                "WHERE dish_id = (SELECT dish_id FROM catering_tcc_dishes_class\n" +
                                "WHERE dish_id =" + dishesFMaxClassModel.getUdishId() +" AND project_id =" +  a.getProjectId() + ")\n" +
                                "AND project_id = " +  a.getProjectId());
                dishesFMaxMaxClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sqlMax);
            }
            if (null != dishesFMaxMaxClassModel) {
                a.setCateClassNameOne(dishesFMaxMaxClassModel.getDishClassName() + "[" + dishesFMaxMaxClassModel.getDishClassCode() + "]");
                a.setCateClassNameTwo(dishesFMaxClassModel.getDishClassName() + "[" + dishesFMaxClassModel.getDishClassCode() + "]");
                a.setCateClassNameThree(dishesFClassModel.getDishClassName() + "[" + dishesFClassModel.getDishClassCode() + "]");
            }
            if (null == dishesFMaxMaxClassModel && null != dishesFMaxClassModel) {
                a.setCateClassNameOne(dishesFMaxClassModel.getDishClassName() + "[" + dishesFMaxClassModel.getDishClassCode() + "]");
                a.setCateClassNameTwo(dishesFClassModel.getDishClassName() + "[" + dishesFClassModel.getDishClassCode() + "]");
            }
            if (null == dishesFMaxMaxClassModel && null == dishesFMaxClassModel && null != dishesFClassModel) {
                a.setCateClassNameOne(dishesFClassModel.getDishClassName() + "[" + dishesFClassModel.getDishClassCode() + "]");
            }
        });

        //组装信息 半成品不需要组装信息
        if (0 != type) {
            return ModelPagedList.convertToModelPage(dishesDtos);
        }
        return  ModelPagedList.convertToModelPage(assemble(dishesDtos, query));
    }


    /**
     * 获取下级分类
     * @return
     */
    private String getChildCode(Long projectId, String dishClassCode){
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(String.class)
                .setSql(" SELECT " +
                        " GROUP_CONCAT(dish_class_code SEPARATOR ',') " +
                        " FROM " +
                        " catering_tcc_dishes_class " +
                        " WHERE " +
                        " is_delete = 0 " +
                        " AND project_id =  " + projectId +
                        " AND udish_class_code in (" + dishClassCode + ")");
        return (String)autoBaseDao.findOne(queryBuilder);
    }

    private CateringTcbDishGroupModel getGroupPackagePrice (Integer dishId, Long projectId) {
        NativeSQLBuilder dishGroup = NativeSQLBuilder.build(CateringTcbDishGroupModel.class)
                .setSql("SELECT t.dish_id, SUM(t.package_price) AS package_price\n " +
                        "FROM catering_tcb_dish_group t\n" +
                        "WHERE t.dish_id = " + dishId + "\n" +
                        "and t.project_id = " + projectId + "\n" +
                        "GROUP BY t.dish_id");
        return (CateringTcbDishGroupModel)autoBaseDao.findOne(dishGroup);
    }

    //组装信息
    private PagedList<DishesDto> assemble(PagedList<DishesDto> dishesDtos, CateringTcbDishesModel query) {
        //查询菜品销售规格
        List<CateringTcbDishGroupModel> groupModels = new ArrayList<>();
        if (null != dishesDtos && dishesDtos.size() > 0) {

            dishesDtos.stream().forEach(a -> {
                //套餐价格
                if (11003 == a.getDishType()) {
                    CateringTcbDishGroupModel groupModel = getGroupPackagePrice(a.getDishId(), query.getProjectId());
                    a.setDishSpecs(groupModel.getPackagePrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    List<Integer> dishIds = dishesDtos.stream().map(c -> {return c.getDishId();}).collect(Collectors.toList());
                    NativeSQLBuilder disSpe = NativeSQLBuilder.build(CateringTcbDishSpecModel.class)
                            .setSql("SELECT t1.*, t2.dict_tp_value FROM catering_tcb_dish_spec t1\n" +
                                    "LEFT JOIN catecomm_tss_datadict t2 ON t2.dict_tp_code = t1.spec_id  AND t1.project_id = t2.project_id\n" +
                                    "WHERE t1.is_delete = 0 and t2.dd_status = 1\n");
                    disSpe.append("and t1.dish_id in (" + ListIdsToString.getIds(dishIds) + ")\n");
                    disSpe.append("and t1.project_id =" + query.getProjectId() + "\n");
                    disSpe.append(null != query.getSpecId() ? (" and t1.spec_id =\n" + query.getSpecId() + "\n") : "");
                    List<CateringTcbDishSpecModel> dishSpecModels = autoBaseDao.listAll(disSpe);
                    if (dishSpecModels != null  && dishSpecModels.size() > 0) {
                        List<CateringTcbDishSpecModel> subItems = dishSpecModels.stream().filter(b -> a.getDishId().intValue() == b.getDishId().intValue()).collect(Collectors.toList());
                        String spec = "";
                        for (CateringTcbDishSpecModel specModel : subItems) {
                            spec += specModel.getDictTpValue() + specModel.getRetailPrice().setScale(2, BigDecimal.ROUND_HALF_UP) + "/";
                        }
                        a.setDishSpecModels(subItems);
                        a.setDishSpecs(StringUtils.substring(spec, 0, spec.lastIndexOf("/")));
                    }
                }
            });

        }
        return dishesDtos;
    }

    private void operation (Integer dishId, Long projectId, String type) {
        List<CateringTcbDishGroupModel> dishGroupModel = getDishGroup(dishId, projectId);
        if (null != dishGroupModel && dishGroupModel.size() > 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法" + type + "，该菜品已被套餐关联！", null);
        }

        List<CateringTcbDishExchangeModel> exchangeModel = getExchange(dishId, projectId);
        if (null != exchangeModel  && exchangeModel.size() > 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法" + type + "，该菜品已被兑换套餐关联！", null);
        }


        //查询可售菜品是否被关联
        NativeSQLBuilder saledDishDetail = NativeSQLBuilder.build(CateringSaledDishDetailModel.class)
                .setSql("SELECT t2.* FROM catering_saled_dish t1\n " +
                        "LEFT JOIN catering_saled_dish_detail t2 ON t2.project_id = t1.project_id AND t2.saled_dish_id = t1.saled_dish_id\n" +
                        "WHERE t1.saled_dish_status != 11804 AND t1.is_delete = 0 AND t1.bill_type = 12215 AND t2.dish_id =" + dishId + "\n" +
                        "and t1.project_id = " + projectId);
        List<CateringSaledDishDetailModel> detailModels = autoBaseDao.listAll(saledDishDetail);
        if (null != detailModels  && detailModels.size() > 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法" + type + "，已被可售菜品关联！", null);
        }


        NativeSQLBuilder saledDish = NativeSQLBuilder.build(CateringSaledDishModel.class)
                .setSql("SELECT * FROM catering_saled_dish\n" +
                        "WHERE saled_dish_status != 11804 AND is_delete = 0 AND bill_type = 12215 AND dict_id =" + dishId + "\n" +
                        "and project_id = " + projectId);
        List<CateringSaledDishModel> saledDishModels = autoBaseDao.listAll(saledDish);
        if (null != saledDishModels  && saledDishModels.size() > 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "无法" + type + "，已被可售菜品关联！", null);
        }

        //是否关联菜品BOM
        NativeSQLBuilder sql3 = NativeSQLBuilder.build(CateringTcbDishBom.class)
                .setSql("SELECT * FROM catering_tcb_dish_bom\n" +
                        "WHERE db_status != 13906 AND is_delete = 0 \n" +
                        "and dish_id = " + dishId + " and project_id =" + projectId);
        List<CateringTcbDishBom> dishBoms = autoBaseDao.listAll(sql3);
        if (null != dishBoms && dishBoms.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "无法：" + type + "已设置菜品BOM！", null);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer dishId, Long projectId, Integer type, Long accountId) {
        NativeSQLBuilder dishs = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE dish_id =" + dishId + "\n" +
                        "and project_id = " + projectId);
        CateringTcbDishesModel oldDishes = (CateringTcbDishesModel) autoBaseDao.findOne(dishs);
        //查看菜品组成和菜品口味表里是否有绑定关系
        //半成品不用查询菜品套餐关联
        if (0 == type) {
            operation(dishId, projectId, "删除");
        }

        CateringTcbDishesModel cateringTcbDishesModel = new CateringTcbDishesModel();
        cateringTcbDishesModel.setIsDelete(1);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbDishesModel.class).setBean(cateringTcbDishesModel).whereEq("dishId", dishId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "删除失败！", null);
        }
        if (0 == type) {
            String content = "删除操作，菜品编号【" + oldDishes.getDishCode() + "】";
            rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);
        }
    }

    private List<CateringTcbDishGroupModel> getDishGroup (Integer dishId, Long projectId) {
        NativeSQLBuilder dishGroup = NativeSQLBuilder.build(CateringTcbDishGroupModel.class)
                .setSql("SELECT t1.* FROM catering_tcb_dish_group t1\n" +
                        "left join catering_tcb_dishes t2 on t2.dish_id = t1.dish_id and t2.project_id = t1.project_id\n" +
                        "WHERE t2.is_delete = 0 AND t2.c_status != 11109 and t1.pack_dish_id =" + dishId + "\n" +
                        "and t1.project_id = " + projectId);
        return autoBaseDao.listAll(dishGroup);
    }

    private List<DishGroupDto> getDishGroupDto (Integer dishId, Long projectId) {
        NativeSQLBuilder dishGroup = NativeSQLBuilder.build(DishGroupDto.class)
                .setSql("SELECT t.dish_group_id, t.pack_dish_id, t.dish_spec_id, t.dish_sale_code, t.dish_code, t.dish_id,\n" +
                        "t.dish_group_count, t.original_price, t.package_price, t.good_type, t1.dish_name,\n " +
                        "t3.type_name, t4.type_name as unit_name \n " +
                        "FROM catering_tcb_dish_group t\n" +
                        "LEFT JOIN catering_tcb_dishes t1 ON t.pack_dish_id = t1.dish_id AND t.project_id = t1.project_id\n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                        "WHERE t.good_type = 11001 AND t.dish_id = " + dishId + "\n" +
                        "and t.project_id = " + projectId + "\n");
        dishGroup.append("UNION ALL  \n");
        dishGroup.append(
                "SELECT t.dish_group_id, t.pack_dish_id, t.dish_spec_id, t.dish_sale_code, t1.rm_code AS dish_code, t.dish_id,\n" +
                        "t.dish_group_count, t.original_price, t.package_price, t.good_type, \n " +
                        " t1.rm_name AS dish_name, '原材料' AS type_name,\n" +
                        "(SELECT type_name FROM  catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t1.rm_unit) as unit_name  \n" +
                        "FROM catering_tcb_dish_group t \n" +
                        "LEFT JOIN catering_tcb_rowmaterial t1 ON t.pack_dish_id = t1.rm_id AND t.project_id = t1.project_id\n" +
                        "WHERE t.good_type = 11004 AND t.dish_id =  " + dishId + "\n" +
                        "and t.project_id = " + projectId);
        List<DishGroupDto> groupModels = autoBaseDao.listAll(dishGroup);
        //List<DishesDto> dishesDts = getDishDto(dishId, projectId);
        if (groupModels != null  && groupModels.size() > 0) {
            groupModels.stream().forEach(a -> {
                /*List<DishesDto> subItems = dishesDts.stream().filter(b -> a.getDishId().intValue() == b.getDishId().intValue()).collect(Collectors.toList());
                a.setDishCode(subItems.get(0).getDishCode());
                a.setDishName(subItems.get(0).getDishName());
                a.setTypeName(subItems.get(0).getTypeName());
                a.setUnitName(subItems.get(0).getUnitName());*/
                if (null != a.getDishSpecId()) {
                    NativeSQLBuilder dishSpe = NativeSQLBuilder.build(CateringTcbDishSpecModel.class)
                            .setSql("SELECT t1.*, t2.dict_tp_value FROM catering_tcb_dish_spec t1\n" +
                                    "LEFT JOIN catecomm_tss_datadict t2 ON t2.dict_tp_code = t1.spec_id and t2.project_id = t1.project_id\n" +
                                    "WHERE t1.dish_spec_id =" + a.getDishSpecId() + "\n" +
                                    "and t1.project_id = " + projectId + "\n");
                    dishSpe.append("and t2.project_id =" + projectId + " and t2.dd_status = 1");
                    CateringTcbDishSpecModel dishSpecModel = (CateringTcbDishSpecModel)autoBaseDao.findOne(dishSpe);
                    if (null == dishSpecModel) {
                        a.setRetailPrice(BigDecimal.ZERO);
                    } else {
                        a.setRetailPrice(dishSpecModel.getRetailPrice());
                        a.setDictTpValue(dishSpecModel.getDictTpValue());
                    }

                }
            });
        }
        return groupModels;
    }

    /*  private List<DishesDto> getDishDto(Integer dishId, Long projectId) {
          NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                  .setSql("SELECT t1.*, t3.type_name, t4.type_name as unit_name FROM catering_tcb_dishes t1 \n" +
                          "LEFT JOIN catering_tcc_dishes_class t2 ON t2.dish_class_code = t1.dish_class_code and t2.project_id = t1.project_id \n" +
                          "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                          "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                          "WHERE t1.is_delete = 0 and t1.dish_id = " + dishId);
          supplier.append("and t1.project_id =" + projectId);
          return autoBaseDao.listAll(supplier);
      }
  */
    private List<DishExchangeDto> getExchangeDto (Integer groupId, Long projectId, Integer goodType) {
        NativeSQLBuilder exChange = NativeSQLBuilder.build(DishExchangeDto.class)
                .setSql("SELECT t.*, \n");
        if (11001 == goodType) {
            exChange.append("t1.dish_name, t1.dish_code, t3.type_name, t4.type_name as unit_name  FROM catering_tcb_dish_exchange t\n" +
                    "LEFT JOIN catering_tcb_dishes t1 ON t1.dish_id = t.dish_exchg_dish_id and  t1.project_id = t.project_id\n" +
                    "LEFT JOIN catering_tcc_dishes_class t2 ON t2.dish_class_code = t1.dish_class_code and t2.project_id = t1.project_id \n" +
                    "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                    "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                    "WHERE t.dish_group_id =" + groupId + "\n" +
                    "and t.project_id = " + projectId);
        } else {
            exChange.append("t1.rm_name AS dish_name, t1.rm_code AS dish_code, \n" +
                    " '原材料' AS type_name, \n" +
                    "(SELECT type_name FROM  catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t1.rm_unit) as unit_name\n" +
                    "FROM catering_tcb_dish_exchange t\n" +
                    "LEFT JOIN catering_tcb_rowmaterial t1 ON t.dish_exchg_dish_id = t1.rm_id AND t.project_id = t1.project_id\n" +
                    "WHERE t.dish_group_id =" + groupId + "\n" +
                    "and t.project_id = " + projectId);
        }
        List<DishExchangeDto> exchangeDts = autoBaseDao.listAll(exChange);
        //List<DishesDto> dishesDts = getDishDto(dishId, projectId);
        if (exchangeDts != null  && exchangeDts.size() > 0) {
            exchangeDts.stream().forEach(a -> {
              /*  List<DishesDto> subItems = dishesDts.stream().filter(b -> a.getDishExchgDishId().intValue() == b.getDishId().intValue()).collect(Collectors.toList());
                a.setDishCode(subItems.get(0).getDishCode());
                a.setDishName(subItems.get(0).getDishName());
                a.setTypeName(subItems.get(0).getTypeName());
                a.setUnitName(subItems.get(0).getUnitName());*/
                if (null != a.getDishExchgDichSpecId()) {
                    NativeSQLBuilder dishSpe = NativeSQLBuilder.build(CateringTcbDishSpecModel.class)
                            .setSql("SELECT t1.*, t2.dict_tp_value FROM catering_tcb_dish_spec t1\n" +
                                    "LEFT JOIN catecomm_tss_datadict t2 ON t2.dict_tp_code = t1.spec_id and  t2.project_id = t1.project_id\n" +
                                    "WHERE t1.dish_spec_id =" + a.getDishExchgDichSpecId() + "\n" +
                                    "and t1.project_id = " + projectId + "\n");
                    dishSpe.append("and t2.project_id =" + projectId + " and t2.dd_status = 1");
                    CateringTcbDishSpecModel dishSpecModel = (CateringTcbDishSpecModel)autoBaseDao.findOne(dishSpe);
                    a.setRetailPrice(dishSpecModel.getRetailPrice());
                    a.setDictTpValue(dishSpecModel.getDictTpValue());
                }

            });
        }
        return exchangeDts;
    }

    private List<CateringTcbDishExchangeModel> getExchange (Integer dishId, Long projectId) {
        NativeSQLBuilder exChange = NativeSQLBuilder.build(CateringTcbDishExchangeModel.class)
                .setSql("SELECT t1.* FROM catering_tcb_dish_exchange t1\n" +
                        "left join catering_tcb_dishes t2 on t2.dish_id = t1.dish_exchg_dish_id and t2.project_id = t1.project_id\n " +
                        "WHERE t2.is_delete = 0 AND t2.c_status != 11109 AND t1.dish_exchg_dish_id =" + dishId + "\n" +
                        "and t1.project_id = " + projectId);
        return autoBaseDao.listAll(exChange);
    }

    @Override
    public DishesDto queryById(Integer dishId, Long projectId, Integer type) {
        NativeSQLBuilder disSql = NativeSQLBuilder.build(DishesDto.class)
                .setSql("SELECT t1.*, t2.dish_class_name, t3.type_name, t4.type_name as unit_name, t5.tax_name, \n" +
                        "(SELECT supp_name FROM commodity_tcb_supplier WHERE commodity_tcb_supplier.supp_id = t1.supp_id AND commodity_tcb_supplier.project_id = t1.project_id) AS suppName," +
                        "(CASE WHEN t1.c_status = 11101 THEN '新增'\n" +
                        "WHEN t1.c_status = 11102 THEN '待审核'\n" +
                        "WHEN t1.c_status = 11103 THEN '审核通过'\n" +
                        "WHEN t1.c_status = 11104 THEN '审核驳回'\n" +
                        "WHEN t1.c_status = 11109 THEN '淘汰' END) AS statusName,\n" +
                        "(SELECT t.type_name FROM catecomm_tss_pubdatadict t WHERE t.type_code = t1.sell_model) AS sellModelName,\n" +
                        "(CASE WHEN  t7.db_status = 13903  THEN '存在' ELSE '不存在' END) AS isBom\n" +
                        " FROM catering_tcb_dishes t1\n" +
                        "LEFT JOIN catering_tcc_dishes_class t2 ON t2.dish_class_code = t1.dish_class_code and t2.project_id = t1.project_id \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                        "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                        "LEFT JOIN catecomm_tsb_tax t5 ON t5.tax_id = t1.sl_tax_id and t5.is_delete = 0 and t5.project_id = " + projectId + "\n" +
                        "LEFT JOIN catering_tcb_dish_bom t7 ON t7.dish_id = t1.dish_id AND t7.project_id =  t1.project_id AND t7.is_delete = 0 AND t7.db_status = 13903\n" +
                        "WHERE t1.is_delete = 0 and t1.project_id = " + projectId + "\n" +
                        "and t2.is_delete = 0 and t2.project_id = " + projectId + "\n" +
                        "and t1.dish_id = " + dishId
                );
        DishesDto dishesDto = (DishesDto)autoBaseDao.findOne(disSql);

        //查询当前菜品分类编号的上级编号
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT dish_id, dish_class_code, udish_id, udish_class_code \n" +
                        "FROM catering_tcc_dishes_class \n" +
                        "WHERE dish_class_code = '" + dishesDto.getDishClassCode() + "' and project_id = " + projectId);
        CateringTccDishesClassModel dishesFClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sql);

        CateringTccDishesClassModel dishesFMaxClassModel = null;
        //组装最大父级的菜品分类编号
        if (null != dishesFClassModel && dishesFClassModel.getUdishId().intValue() != 0) {
            NativeSQLBuilder sqlMax = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                    .setSql("SELECT dish_id, dish_class_code FROM catering_tcc_dishes_class\n" +
                            "WHERE dish_id = (SELECT udish_id FROM catering_tcc_dishes_class\n" +
                            "WHERE dish_id =" + dishesFClassModel.getUdishId() +" AND project_id =" + projectId + ")\n" +
                            "AND project_id = " + projectId);
            dishesFMaxClassModel = (CateringTccDishesClassModel)autoBaseDao.findOne(sqlMax);
        }
        String zoomClassCode = (null != dishesFMaxClassModel  ? dishesFMaxClassModel.getDishClassCode() + "," : "") +
                (null != dishesFClassModel ?  dishesFClassModel.getUdishClassCode() + ","  : "") +
                dishesDto.getDishClassCode();
        dishesDto.setZoomClassCode(zoomClassCode);
        //半成品没有以下图片套餐信息直接返回
        if (0 != type) {
            return dishesDto;
        }
        //组装口味信息
        dishesDto.setDishTasteModels(this.getDishTasteList(dishesDto.getProjectId(), dishesDto.getDishId()));

        NativeSQLBuilder disSpe = NativeSQLBuilder.build(CateringTcbDishSpecModel.class)
                .setSql("SELECT t1.*, t2.dict_tp_value FROM catering_tcb_dish_spec t1\n" +
                        "LEFT JOIN catecomm_tss_datadict t2 ON t2.dict_tp_code = t1.spec_id  and t2.project_id = t1.project_id \n" +
                        "WHERE t1.is_delete = 0 and t2.dd_status = 1");
        disSpe.append("and t1.project_id =" + projectId);
        disSpe.append("and t1.dish_id =" + dishId);
        disSpe.append("and t2.project_id =" + projectId);

        List<CateringTcbDishSpecModel> dishSpecModels = autoBaseDao.listAll(disSpe);
        if (dishSpecModels != null  && dishSpecModels.size() > 0) {
            String dishSpecs = "";
            for (int k = 0; k < dishSpecModels.size(); k++) {
                if ((k + 1) == dishSpecModels.size()) {
                    dishSpecs += dishSpecModels.get(k).getDictTpValue() ;
                } else {
                    dishSpecs += "" + dishSpecModels.get(k).getDictTpValue() + "/";
                }
            }
            dishesDto.setDishSpecs(dishSpecs);
            dishesDto.setDishSpecModels(dishSpecModels);
        }
        //图片信息组装
        NativeSQLBuilder imgs = NativeSQLBuilder.build(CateringTcbDishimgsModel.class)
                .setSql("SELECT *FROM catering_tcb_dishimgs \n" +
                        "WHERE is_delete = 0");
        imgs.append("and project_id =" + dishesDto.getProjectId());
        imgs.append("and dish_id = " + dishesDto.getDishId());
        dishesDto.setDishimgsModels(autoBaseDao.listAll(imgs));

        if (11003 == dishesDto.getDishType()) {
            //套餐时 查询套餐 和 兑换套餐
            List<DishGroupDto> dishGroupModel = getDishGroupDto(dishId, projectId);
            if (null != dishGroupModel && dishGroupModel.size() > 0) {
                dishGroupModel.forEach(a -> {
                    List<DishExchangeDto> exchangeModel = getExchangeDto(a.getDishGroupId(), projectId, a.getGoodType());
                    if (null != exchangeModel && exchangeModel.size() > 0) {
                        //组装商品套餐和兑换套餐信息
                        a.setDishExchangeDtos(exchangeModel);
                        dishesDto.setDishGroupDtos(dishGroupModel);
                    } else {
                        dishesDto.setDishGroupDtos(dishGroupModel);
                    }
                });
            }
        }

        //组装联营供应商信息
        NativeSQLBuilder builder = NativeSQLBuilder.build(CateringDishPoolRelationModel.class)
                .setSql("SELECT * FROM catering_dish_pool_relation\n" +
                        "WHERE status = " + dishesDto.getcStatus() + " AND is_delete = 0 AND dish_id = " + dishesDto.getDishId() + "\n" +
                        "and project_id = " + dishesDto.getProjectId());
        CateringDishPoolRelationModel poolRelationModel = (CateringDishPoolRelationModel)autoBaseDao.findOne(builder);
        if (null != poolRelationModel) {
            dishesDto.setPoolRelationModel(poolRelationModel);
        }
        return dishesDto;
    }



    @Override
    public List<DishesDto> queryByIds(DishesDto query, String dishIds, Integer type) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                .setSql("SELECT * FROM (\n" +
                        "SELECT t1.*, \n" +
                        "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t1.dish_type)as type_name,\n" +
                        "(SELECT type_name FROM catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t1.dish_unit)as unit_name, \n " +
                        "(SELECT t.type_name FROM catecomm_tss_pubdatadict t WHERE t.type_code = t1.sell_model) AS sellModelName,\n" +
                        "(SELECT tax.tax_name FROM catecomm_tsb_tax tax WHERE tax.tax_id = t1.sl_tax_id and tax.is_delete = 0 and tax.project_id = t1.project_id) AS taxName,\n");
        if (0 == type) {
            supplier.append("(SELECT supp_name FROM commodity_tcb_supplier WHERE commodity_tcb_supplier.supp_id = t1.supp_id AND commodity_tcb_supplier.project_id = t1.project_id) AS suppName," +
                    "(select CONCAT(t2.dish_class_name, t2.dish_class_code) as first_code from  \n" +
                    " catering_tcc_dishes_class t2 where substring(t1.dish_class_code,1,2)  = t2.dish_class_code and t2.project_id = " + query.getProjectId() + ") cateClassNameOne, \n" +
                    "(select CONCAT(t3.dish_class_name, t3.dish_class_code) as two_code from \n" +
                    " catering_tcc_dishes_class t3 where substring(t1.dish_class_code,1,4)  = t3.dish_class_code  and  LENGTH(t1.dish_class_code) >= 4  and t3.project_id = " + query.getProjectId() + ") cateClassNameTwo, \n" +
                    "(select CONCAT(t4.dish_class_name, t4.dish_class_code) as three_code from \n" +
                    " catering_tcc_dishes_class t4 where substring(t1.dish_class_code,1,6)  = t4.dish_class_code  and  LENGTH(t1.dish_class_code) >= 6 and t4.project_id = " + query.getProjectId() + ") cateClassNameThree, \n");
        } else {
            supplier.append("(SELECT dish_class_name FROM catering_tcc_dishes_class WHERE catering_tcc_dishes_class.dish_class_code = t1.dish_class_code AND " +
                    "catering_tcc_dishes_class.project_id = t1.project_id) AS dishClassName,\n");
        }
        supplier.append("(CASE WHEN t1.c_status = 11101 THEN '新增'\n" +
                "WHEN t1.c_status = 11102 THEN '待审核'\n" +
                "WHEN t1.c_status = 11103 THEN '审核通过'\n" +
                "WHEN t1.c_status = 11104 THEN '审核驳回'\n" +
                "WHEN t1.c_status = 11109 THEN '淘汰' END) AS statusName,\n" +
                "  ( SELECT GROUP_CONCAT(a.dish_taste_type, \":\", a.dish_taste_name) AS name \n" +
                "\tFROM catering_tcb_dish_taste a\n" +
                "where a.dish_id = t1.dish_id and a.project_id = " + query.getProjectId() + "\n" +
                "GROUP BY a.dish_id \n" +
                ")as taste,\n" +
                "(SELECT GROUP_CONCAT(b.dict_tp_value, \"-\", a.retail_price) AS name\n" +
                "\tFROM catering_tcb_dish_spec  a\n" +
                "LEFT JOIN catecomm_tss_datadict b ON b.dict_tp_code = a.spec_id  and b.project_id = a.project_id\n" +
                "where a.dish_id = t1.dish_id and a.project_id = " + query.getProjectId() + "\n" +
                "GROUP BY a.dish_id) as specStr,\n" +
                "(CASE WHEN  t7.db_status = 13903  THEN '存在' ELSE '不存在' END) AS isBom \n" +
                "FROM catering_tcb_dishes t1 \n" +
                "LEFT JOIN catering_tcb_dish_bom t7 ON t7.dish_id = t1.dish_id AND t7.project_id = t1.project_id AND t7.is_delete = 0 AND t7.db_status = 13903\n" +
                "WHERE t1.is_delete = 0\n");
        supplier.append("and t1.project_id =" + query.getProjectId());
        if (StringUtils.isNotEmpty(dishIds)) {
            supplier.append("and t1.dish_id IN (" + dishIds + ")\n");
        }
        if (0 == type) {
            supplier.append("and t1.dish_type != 11002\n");
        } else {
            supplier.append("and t1.dish_type = 11002\n");
        }
        supplier.append(null != query.getSellModel() ? ("and t1.sell_model = \n" + (query.getSellModel()) + "\n") : "");
        if (StringUtils.isNotEmpty(query.getDishClassCode())) {
            //判断是否是第一级分类
            String dishClassCode = this.getChildCode(query.getProjectId(), query.getDishClassCode());
            //下级分类为空，说明是最后一级
            if (StringUtils.isNotEmpty(dishClassCode)) {
                //不为空获取三级分类
                String childCode = getChildCode(query.getProjectId(), dishClassCode);
                if(StringUtils.isNotEmpty(childCode) && StringUtils.isNotEmpty(query.getIsAll())){
                    supplier.append(StringUtils.isNotEmpty(query.getIsAll()) ? " and t1.dish_class_code IN (\n" + childCode + ")\n" :" and t1.dish_class_code IN (\n" + query.getDishClassCode() + ")\n");
                } else {
                    //isALL代表查全部 如果有值 证明是查包含下级全部 否则只查当前自己这个分类
                    supplier.append(StringUtils.isNotEmpty(query.getIsAll()) ? " and t1.dish_class_code IN (\n" + dishClassCode + ")\n" :" and t1.dish_class_code IN (\n" + query.getDishClassCode() + ")\n");
                }

            } else {
                supplier.append(" and t1.dish_class_code IN (\n" + query.getDishClassCode() + ")\n");
            }
        }
        supplier.append(StringUtils.isNotBlank(query.getDishCode()) ? (" and t1.dish_code = \n" + query.getDishCode() + "\n") : "");
        supplier.append(null != query.getDishType() ? ("and t1.dish_type =\n" + (query.getDishType()) + "\n") : "");
        supplier.append(null != query.getSpecId() ? ("and t6.spec_id = \n" + (query.getSpecId()) + "\n") : "");
        supplier.append(StringUtils.isNotBlank(query.getDishName()) ? ("and t1.dish_name like\n" + "'%" + (query.getDishName()) + "%'\n") : "");
        supplier.append(null != query.getcStatus() ? ("and t1.c_status =\n" + (query.getcStatus()) + "\n") : "");
        supplier.append("group by t1.dish_id\n");
        supplier.append("order by t1.created_time desc\n");
        supplier.append(") A");
        supplier.append(StringUtils.isNotBlank(query.getIsBom()) ? (" WHERE isBom = '" + query.getIsBom() + "'\n") : "");
        List<DishesDto> dishesDtos = autoBaseDao.listAll(supplier);
        dishesDtos.forEach(a -> {
            if (11003 == a.getDishType()) {
                CateringTcbDishGroupModel dishGroupModel = getGroupPackagePrice(a.getDishId(), query.getProjectId());
                //BigDecimal mealPrice = dishGroupModel.stream().map(b -> {return b.getPackagePrice();}).reduce(BigDecimal.ZERO,BigDecimal::add);
                a.setMealPrice(dishGroupModel.getPackagePrice());
            }

        });
        return dishesDtos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDishes(DishesDto dishesDto, Long accountId, Integer type) {
        NativeSQLBuilder oldDisheSql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT t1.*, (SELECT dish_class_name FROM catering_tcc_dishes_class\n" +
                        "WHERE catering_tcc_dishes_class.project_id = t1.project_id AND catering_tcc_dishes_class.dish_class_code = t1.dish_class_code) AS dishClassName,\n" +
                        "(SELECT type_name FROM catecomm_tss_pubdatadict\n" +
                        "WHERE catecomm_tss_pubdatadict.type_code = t1.dish_unit) AS dishUnitName\n" +
                        "FROM catering_tcb_dishes t1\n" +
                        "WHERE dish_id ='" + dishesDto.getDishId() + "'\n" +
                        "and project_id = " + dishesDto.getProjectId());
        CateringTcbDishesModel oldDisheModel = (CateringTcbDishesModel) autoBaseDao.findOne(oldDisheSql);
        //查询供应商编号是否存在重复
        try {
            DishesDto oldModel = this.getIsDishCode(dishesDto.getDishCode(), dishesDto.getProjectId());
            if (null != oldModel && oldModel.getDishId().intValue() != dishesDto.getDishId().intValue()) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  (0 != type ? "半成品" : "菜品") + "编号已存在！", null);
            }
            DishesDto oldDishes = this.checkDishName(dishesDto.getDishName(), dishesDto.getProjectId(), dishesDto.getDishId(), dishesDto.getDishType());
            if (null != oldDishes && oldDishes.getDishId().intValue() != dishesDto.getDishId().intValue()) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  (0 != type ? "半成品" : "菜品") + "名称已存在！", null);
            }
            CateringTcbDishesModel dishesModel = new CateringTcbDishesModel();
            dishesModel.setProjectId(dishesDto.getProjectId());
            dishesModel.setProjectRootId(dishesDto.getProjectRootId());
            dishesModel.setDishCode(dishesDto.getDishCode());
            dishesModel.setDishName(dishesDto.getDishName());
            dishesModel.setDishAbbreviate(dishesDto.getDishAbbreviate());//菜品简称
            dishesModel.setSpellCode(dishesDto.getSpellCode());
            dishesModel.setDishClassCode(dishesDto.getDishClassCode());
            dishesModel.setDishType(dishesDto.getDishType());//字典表 菜品类型(成品，套餐，半成品)
            dishesModel.setDishUnit(dishesDto.getDishUnit());//菜品单位
            dishesModel.setRetailPrice(dishesDto.getRetailPrice());//建议零售价
            dishesModel.setCostPrice(dishesDto.getCostPrice());//预估成本价
            dishesModel.setSlTaxId(dishesDto.getSlTaxId());//引用税率表id
            dishesModel.setWeighComWay(dishesDto.getWeighComWay());//10 定价 20 任意价 30 定量
            dishesModel.setSellStatus(dishesDto.getSellStatus());//商品销售状态
            dishesModel.setSellOut(dishesDto.getSellOut());//沽清状态
            dishesModel.setPackCost(dishesDto.getPackCost());//打包费
            dishesModel.setIsHot(dishesDto.getIsHot());//是否热卖商品10 是  20否
            dishesModel.setMinPetailPrice(dishesDto.getMinPetailPrice());
            dishesModel.setTransportType(dishesDto.getTransportType());
            dishesModel.setRemark(dishesDto.getRemark());
            dishesModel.setDescription(dishesDto.getDescription());
            dishesModel.setCreater(dishesDto.getCreater());
            dishesModel.setModifier(dishesDto.getModifier());
            dishesModel.setcStatus(dishesDto.getcStatus());
            dishesModel.setSellModel(dishesDto.getSellModel());
            dishesModel.setStandardCostRate(dishesDto.getStandardCostRate());
            if (0 == type) {
                dishesModel.setBarCode(dishesDto.getBarCode());
                //保留之前联营供应商的逻辑 方便线下获取数据
                if (null != dishesDto.getPoolRelationModel()) {
                    if (null == dishesDto.getPoolRelationModel().getSuppCode()) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "合同信息为空，联营菜品必须选择合同信息！", null);
                    }
                    dishesModel.setSuppCode(dishesDto.getPoolRelationModel().getSuppCode());
                    dishesModel.setSuppId(dishesDto.getPoolRelationModel().getSupperId());
                }
                if (15001 == dishesDto.getSellModel()) {
                    //先删除一遍联营商家信息
                    DeleteBuilder relation = DeleteBuilder.build("catering_dish_pool_relation").whereEq("dish_id", dishesDto.getDishId())
                            .whereEq("project_id", dishesDto.getProjectId());
                    autoBaseDao.delete(relation);
                }
            } else {
                dishesModel.setSellModel(0);
            }
            dishesModel.setDiscountRate(dishesDto.getDiscountRate());
            if (0 != dishesDto.getDishId()) {
                dishesModel.setModifier(accountId);
                dishesModel.setCreater(accountId);
                dishesModel.setDishId(dishesDto.getDishId());
                dishesModel.setSyncStatus(10);
                if (11002 == dishesModel.getDishType().intValue()) {
                    dishesModel.setDishBarcode(dishesDto.getDishBarcode());
                }
                UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbDishesModel.class).setBean(dishesModel).whereEq("dishId", dishesModel.getDishId())
                        .whereEq("projectId", dishesDto.getProjectId());
                if (autoBaseDao.update(updateBuilder) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改保存失败！", null);
                }
                dishesModel.setWhetherUpdate(dishesDto.getWhetherUpdate());
                dishesModel.setDishUnitName(dishesDto.getDishUnitName());
                dishesModel.setDishClassName(dishesDto.getDishClassName());
                //保存菜品基础信息日志
                if (0 == type) {
                    addLog(oldDisheModel, dishesModel);
                }
            } else {
                dishesModel.setDishId(supplierService.getTableId(dishesDto.getProjectId(),"catering_tcb_dishes",1));
                //2020/10/29新增菜品条码需求
                if (0 == type && StringUtils.isEmpty(dishesDto.getBarCode()) && 0 == dishesDto.getDishId().intValue()) {
                    Map<String, Object> codeMap = collarUseService.getBarCode(dishesDto.getProjectId(), 10, dishesModel.getDishId(),0, 0, 2);
                    if ((Boolean) codeMap.get("success")) {
                        dishesModel.setBarCode(String.valueOf(codeMap.get("code")));
                    } else {
                        log.info("生成菜品条码失败，原因是：" + codeMap.get("msg"));
                    }
                } else {
                    dishesModel.setBarCode(dishesDto.getBarCode());
                }
                dishesModel.setCreater(accountId);
                dishesModel.setSpellCode(GetPell.getPinYinHeadChar(dishesDto.getDishName()));
                dishesModel.setModifier(accountId);
                if (autoBaseDao.save(dishesModel) == 0) {
                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增保存失败！", null);
                }
                if (0 == type) {
                    String content = "新增菜品，菜品编号【" + dishesModel.getDishCode() + "】";
                    if (null != dishesDto.getPoolRelationModel()) {
                        content += ";联营合同信息为：合同编号【"+ dishesDto.getPoolRelationModel().getContractCode() + "】。";
                    } else {
                        content += "。";
                    }
                    rawmaterApi.saveBasicDataLog(dishesModel.getProjectId(), dishesModel.getDishId(),30, 0, content, accountId);
                }
            }
            dishesDto.setDishId(dishesModel.getDishId());
            if (0 == type) {
                //联营菜品供应商合同信息保存  2021-1-5新增需求
                if (null != dishesDto.getPoolRelationModel()) {
                    //保存前先查询之前是否保存过未审核通过的联营供应商信息，存在则删除
                    NativeSQLBuilder builder = NativeSQLBuilder.build(CateringDishPoolRelationModel.class)
                            .setSql("SELECT * FROM catering_dish_pool_relation\n" +
                                    "WHERE is_delete = 0  AND dish_id =" + dishesDto.getDishId() + "\n" +
                                    "and project_id = " + dishesDto.getProjectId());
                    CateringDishPoolRelationModel oldPoolRelationModel = (CateringDishPoolRelationModel)autoBaseDao.findOne(builder);
                    if (null != oldPoolRelationModel) {
                        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                                .setSql("UPDATE catering_dish_pool_relation SET supp_status = 0, is_delete = 1,\n" +
                                        "sync_status = 10\n" +
                                        "WHERE dish_id  = " + dishesDto.getDishId() + " and project_id =" + dishesDto.getProjectId());
                        //操作
                        if (autoBaseDao.nativeExecute(nativeSQLBuilder) == 0) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改联营数据失败！", null);
                        }
                    }

                    //合同操作日志
                    if (null != dishesDto.getPoolRelationModel().getWhetherUpdate() && dishesDto.getPoolRelationModel().getWhetherUpdate()) {
                        this.addContractLog(oldPoolRelationModel, dishesDto.getPoolRelationModel(), dishesDto.getProjectId(), accountId, dishesDto.getDishId());
                    }
                    dishesDto.getPoolRelationModel().setWhetherUpdate(null);
                    dishesDto.getPoolRelationModel().setProjectRootId(dishesDto.getProjectRootId());
                    dishesDto.getPoolRelationModel().setProjectId(dishesDto.getProjectId());
                    dishesDto.getPoolRelationModel().setRelationId(supplierService.getTableId(dishesDto.getProjectId(), "catering_dish_pool_relation", 1));
                    dishesDto.getPoolRelationModel().setCreater(accountId);
                    dishesDto.getPoolRelationModel().setModifier(accountId);
                    dishesDto.getPoolRelationModel().setDishId(dishesDto.getDishId());
                    dishesDto.getPoolRelationModel().setStatus(dishesDto.getcStatus());//保持和主表状态一致
                    dishesDto.getPoolRelationModel().setSuppStatus(1);
                    dishesDto.getPoolRelationModel().setSyncStatus(10);
                    if (autoBaseDao.save(dishesDto.getPoolRelationModel()) == 0) {
                        throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "保存联营供应商信息失败！", null);
                    }

                }
                //保存（修改）口味信息 -- 主要是保存dishId与菜品绑定
                //绑定前先将之前的绑定数据删除
                if (null != dishesDto.getDishTasteModels()) {
                    NativeSQLBuilder oldDishTasteSql = NativeSQLBuilder.build(CateringTcbDishTasteModel.class)
                            .setSql("SELECT * FROM catering_tcb_dish_taste\n" +
                                    "WHERE dish_id ='" + dishesDto.getDishId() + "'\n" +
                                    "and project_id = " + dishesDto.getProjectId());
                    List<CateringTcbDishTasteModel> oldDishTastes = autoBaseDao.listAll(oldDishTasteSql);
                    DeleteBuilder dishTaste = DeleteBuilder.build("catering_tcb_dish_taste").whereEq("dishId", dishesDto.getDishId())
                            .whereEq("projectId", dishesDto.getProjectId());
                    autoBaseDao.delete(dishTaste);
                    //口味信息日志
                    addTasteLog(oldDishTastes, dishesDto.getDishTasteModels(), dishesDto.getProjectId(), accountId, dishesDto.getDishId());
                    //删除后再做保存
                    dishesDto.getDishTasteModels().forEach(b -> {
                        b.setWhetherUpdate(null);
                        b.setProjectId(dishesDto.getProjectId());
                        b.setModiter(accountId);
                        b.setCreater(accountId);
                        b.setDishId(dishesDto.getDishId());
                        b.setDishTasteId(supplierService.getTableId(dishesDto.getProjectId(), "catering_tcb_dish_taste", 1));
                        if (autoBaseDao.save(b) == 0) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "保存口味信息保存失败！", null);
                        }
                    });

                }

                //保存规格信息
                if (null != dishesDto.getDishSpecModels()) {
                    /*DeleteBuilder spec = DeleteBuilder.build("catering_tcb_dish_spec").whereEq("dish_id", dishesDto.getDishId())
                            .whereEq("project_id", dishesDto.getProjectId());
                    autoBaseDao.delete(spec);*/
                    //删除后再做保存
                    dishesDto.getDishSpecModels().forEach(b -> {
                        if (null != b.getDishSpecId()) {//编辑保存
                            NativeSQLBuilder oldSql = NativeSQLBuilder.build(CateringTcbDishSpecModel.class)
                                    .setSql("SELECT * FROM catering_tcb_dish_spec \n" +
                                            "WHERE project_id = " + dishesDto.getProjectId() + " and dish_id = " + dishesDto.getDishId());
                            CateringTcbDishSpecModel oldSpecModel = (CateringTcbDishSpecModel) autoBaseDao.findOne(oldSql);
                            b.setModifier(accountId);
                            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbDishSpecModel.class)
                                    .setBean(b).whereEq("dishSpecId", b.getDishSpecId())
                                    .whereEq("projectId", dishesDto.getProjectId())
                                    .whereEq("dishId", dishesDto.getDishId());
                            if (autoBaseDao.update(updateBuilder) == 0) {
                                throw new RpcException(300, Constant.EXCEPTIONCODE_BUSINESS + "修改菜品规格数据失败！", null);
                            }
                            this.updateSpecLog(oldSpecModel, b, dishesDto.getDishId(), accountId);
                        } else {

                            b.setProjectId(dishesDto.getProjectId());
                            b.setDishSpecId(supplierService.getTableId(dishesDto.getProjectId(), "catering_tcb_dish_spec", 1));
                            b.setModifier(accountId);
                            b.setCreater(accountId);
                            b.setDishId(dishesDto.getDishId());
                            b.setDictTpValue(null);
                            if (autoBaseDao.save(b) == 0) {
                                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "保存规格信息保存失败！", null);
                            }
                            this.addSpecLog(b, dishesDto.getDishId(), accountId);

                        }
                    });
                }

                //保存图片信息
                if (null != dishesDto.getDishimgsModels()) {
                    DeleteBuilder img = DeleteBuilder.build("catering_tcb_dishimgs").whereEq("dish_id", dishesDto.getDishId())
                            .whereEq("project_id", dishesDto.getProjectId());
                    autoBaseDao.delete(img);
                    //删除后再做保存
                    dishesDto.getDishimgsModels().forEach(b -> {
                        b.setProjectId(dishesDto.getProjectId());
                        b.setCiId(supplierService.getTableId(dishesDto.getProjectId(), "catering_tcb_dishimgs", 1));
                        b.setAddTime(new Date());
                        b.setDishId(dishesDto.getDishId());
                        if (autoBaseDao.save(b) == 0) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "保存图片信息保存失败！", null);
                        }
                    });
                }

                if (11003 == dishesDto.getDishType()) {
                    NativeSQLBuilder groupSql = NativeSQLBuilder.build(CateringTcbDishGroupModel.class)
                            .setSql("SELECT t1.*, (SELECT dish_name FROM catering_tcb_dishes WHERE catering_tcb_dishes.project_id = t1.project_id" +
                                    " AND catering_tcb_dishes.dish_id = t1.pack_dish_id) AS dishName\n" +
                                    " FROM catering_tcb_dish_group t1\n" +
                                    "WHERE t1.dish_id = " + dishesDto.getDishId() + " AND t1.project_id = " + dishesDto.getProjectId());
                    List<CateringTcbDishGroupModel> oldGroupModels = autoBaseDao.listAll(groupSql);
                    oldGroupModels.forEach(a -> {
                        NativeSQLBuilder exchangeSql = NativeSQLBuilder.build(CateringTcbDishExchangeModel.class)
                                .setSql("SELECT t1.*, (SELECT dish_name FROM catering_tcb_dishes WHERE catering_tcb_dishes.project_id = t1.project_id" +
                                        " AND catering_tcb_dishes.dish_id = t1.dish_exchg_dish_id) AS exchgDishName\n" +
                                        " FROM catering_tcb_dish_exchange t1\n" +
                                        "WHERE t1.dish_group_id = " + a.getDishGroupId() + " AND t1.project_id = " + dishesDto.getProjectId());
                        a.setDishExchangeModels(autoBaseDao.listAll(exchangeSql));
                    });
                    //组成菜品兑换菜品日志
                    addGroupLog(oldGroupModels, dishesDto.getDishGroupModel(), dishesDto.getProjectId(), accountId, dishesDto.getDishId(), dishesDto.getDishCode());

                    if (null != oldGroupModels && oldGroupModels.size() > 0) {
                        List<Integer> groupIds = oldGroupModels.stream().map(a->{return a.getDishGroupId();}).collect(Collectors.toList());
                        groupIds.forEach(a -> {
                            DeleteBuilder deleteExChange = DeleteBuilder.build("catering_tcb_dish_exchange").whereEq("dish_group_id", a)
                                    .whereEq("project_id", dishesDto.getProjectId());
                            autoBaseDao.delete(deleteExChange);
                        });

                    }
                    //无论新增修改菜品组合信息 都先把之前的绑定删除，再添加
                    DeleteBuilder dishGroup = DeleteBuilder.build("catering_tcb_dish_group").whereEq("dish_id", dishesDto.getDishId())
                            .whereEq("project_id", dishesDto.getProjectId());
                    autoBaseDao.delete(dishGroup);
                    //保存菜品组合信息
                    dishesDto.getDishGroupModel().forEach(a -> {
                        a.setWhetherUpdate(null);
                        a.setDishName(null);
                        a.setDishId(dishesDto.getDishId());
                        a.setDishCode(a.getDishCode());
                        a.setDishGroupId(supplierService.getTableId(dishesDto.getProjectId(), "catering_tcb_dish_group", 1));
                        a.setProjectId(dishesDto.getProjectId());
                        a.setCreater(accountId);
                        a.setModifier(accountId);
                        if (autoBaseDao.save(a) == 0) {
                            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "菜品组合信息保存失败！", null);
                        }
                        //保存兑换套餐信息
                        a.getDishExchangeModels().forEach(d -> {
                            d.setWhetherUpdate(null);
                            d.setExchgDishName(null);
                            d.setCreater(accountId);
                            d.setProjectId(dishesDto.getProjectId());
                            d.setDishExchgId(supplierService.getTableId(dishesDto.getProjectId(), "catering_tcb_dish_exchange", 1));
                            d.setDishExchgDishCode(dishesDto.getDishCode());
                            //d.setDishExchgDishId(dishesDto.getDishId());
                            d.setModifier(accountId);
                            d.setDishGroupId(a.getDishGroupId());
                            if (autoBaseDao.save(d) == 0) {
                                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "菜品可兑换信息保存失败！", null);
                            }
                        });

                    });

                }
            }
        } catch (Exception e) {
            throw new RpcException(300, "菜品信息保存失败！" + e.getMessage(), null);
        }
    }

    private void addLog(CateringTcbDishesModel oldDisheModel, CateringTcbDishesModel newDishesModel) {
        if (newDishesModel.getWhetherUpdate()) {
            String content = "编辑菜品基础信息：修改前信息为：菜品名称【" + oldDisheModel.getDishName() + "】,包装费【" + oldDisheModel.getPackCost() + "元】," +
                    "菜品单位【" + oldDisheModel.getDishUnitName() + "】,菜品分类【" + oldDisheModel.getDishClassName() + "】,备注【" + oldDisheModel.getRemark() + "】, 标准成本率【" + oldDisheModel.getStandardCostRate() + "%】；" +
                    "修改后信息为：菜品名称【" + newDishesModel.getDishName() + "】,包装费【" + (null != newDishesModel.getPackCost() && newDishesModel.getPackCost().compareTo(BigDecimal.ZERO) != 0 ? newDishesModel.getPackCost() : 0) + "元】," +
                    "菜品单位【" + newDishesModel.getDishUnitName() + "】,菜品分类【" + newDishesModel.getDishClassName() + "】,备注【" + (null != newDishesModel.getRemark() ? newDishesModel.getRemark() : "") + "】, 标准成本率【" + newDishesModel.getStandardCostRate() + "%】。";
            rawmaterApi.saveBasicDataLog(newDishesModel.getProjectId(), newDishesModel.getDishId(), 30, 0, content, newDishesModel.getModifier());
        }

    }

    private String getSpecName(Long projectId, Integer dictTpCode) {
        NativeSQLBuilder dataSql = NativeSQLBuilder.build(String.class)
                .setSql("SELECT dict_tp_value FROM catecomm_tss_datadict \n" +
                        "WHERE dd_status = 1 and project_id = " + projectId + " and dict_tp_code = " + dictTpCode);
       return (String) autoBaseDao.findOne(dataSql);
    }


    private void addSpecLog(CateringTcbDishSpecModel newDishSpecModel, Integer dishId, Long accountId) {
        String newValeName =  this.getSpecName(newDishSpecModel.getProjectId(), newDishSpecModel.getSpecId());
        String content = "新增菜品规格信息：菜品规格【" + newValeName + "】,预估售价【" + newDishSpecModel.getRetailPrice() + "元】," +
                "销售编码为【" + newDishSpecModel.getSaleCode() + "】。";
        rawmaterApi.saveBasicDataLog(newDishSpecModel.getProjectId(), dishId, 30, 0, content, accountId);


    }


    private void updateSpecLog(CateringTcbDishSpecModel oldDishSpecModel, CateringTcbDishSpecModel newDishSpecModel, Integer dishId, Long accountId) {
            String oldValeName =  this.getSpecName(oldDishSpecModel.getProjectId(), oldDishSpecModel.getSpecId());
            String newValeName =  this.getSpecName(newDishSpecModel.getProjectId(), newDishSpecModel.getSpecId());
            String content = "编辑菜品规格信息：修改前信息为：菜品规格【" + oldValeName + "】,预估售价【" + oldDishSpecModel.getRetailPrice() + "元】," +
                    "销售编码为【" + oldDishSpecModel.getSaleCode() + "】;" +
                    "修改后信息为：菜品规格【" + newValeName + "】,预估售价【" + newDishSpecModel.getRetailPrice() + "元】," +
                    "销售编码为【" + newDishSpecModel.getSaleCode() + "】。";
            rawmaterApi.saveBasicDataLog(oldDishSpecModel.getProjectId(), dishId, 30, 0, content, accountId);


    }

    private void addContractLog(CateringDishPoolRelationModel oldPoolRelationModel, CateringDishPoolRelationModel newPoolRelationModel, Long projectId, Long accountId, Integer dishId) {
        String content = "编辑菜品联营合同信息：修改前信息为：合同编号【" + oldPoolRelationModel.getContractCode() + "】," +
                "修改后信息为：合同编号【" + newPoolRelationModel.getContractCode() + "】, 修改前扣率为：" + oldPoolRelationModel.getDiscountRate() + "%，修改后扣率为" + newPoolRelationModel.getDiscountRate() + "%。";
        rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);

    }

    private void addTasteLog(List<CateringTcbDishTasteModel> oldDishTastes, List<CateringTcbDishTasteModel> newDishTastes, Long projectId, Long accountId, Integer dishId) {
        int number = 1;
        if (0 == oldDishTastes.size()) {
            newDishTastes.forEach(a -> {
                String content = "新增菜品口味信息：菜品编号为【" + a.getDishCode() + "】。";
                rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);
            });
            return;
        }
        boolean falg = newDishTastes.stream().anyMatch(a -> a.getWhetherUpdate());
        if (falg) {
            String content = "编辑菜品口味信息：修改前信息为：";
            int num = 0;
            for (CateringTcbDishTasteModel oldDishTaste : oldDishTastes) {
                num ++;
                content += num + ".口味类别为：【" + oldDishTaste.getDishTasteType() + "】,口味名称为：【" + oldDishTaste.getDishTasteName() + "】，";
            }
            num = 0;
            content += "修改后信息为：";
            for (CateringTcbDishTasteModel newDishTaste : newDishTastes) {
                num ++;
                content += num + ".口味类别为：【" + newDishTaste.getDishTasteType() + "】,口味名称为：【" + newDishTaste.getDishTasteName() + "】" + (number != newDishTastes.size() ? "，" : "。");
                number++;
            }
            rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);
        }
    }

    private CateringTcbDishesModel getDishes (Integer dishId, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes  WHERE is_delete = 0 and dish_id ='" + dishId + "'\n" +
                        "and project_id = " + projectId);
        return (CateringTcbDishesModel)autoBaseDao.findOne(supplier);
    }

    private CateringTcbRowmaterial getRowmater (Integer rmId, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbRowmaterial.class)
                .setSql("SELECT * FROM catering_tcb_rowmaterial  WHERE is_delete = 0 and rm_id ='" + rmId + "'\n" +
                        "and project_id = " + projectId);
        return (CateringTcbRowmaterial)autoBaseDao.findOne(supplier);
    }

    private void addGroupLog(List<CateringTcbDishGroupModel> oldGroupModels, List<CateringTcbDishGroupModel> newGroupModels, Long projectId, Long accountId, Integer dishId, String dishCode) {
        if (0 == oldGroupModels.size()) {
            int num = 0;
            int numSeed = 0;

            String content = "新增菜品组成信息：菜品编号为【" + dishCode + "】,";
            for (CateringTcbDishGroupModel newGroupModel : newGroupModels) {
                int number = 1;
                num ++;
                String dishName = 11001 == newGroupModel.getGoodType() ?  getDishes(newGroupModel.getPackDishId(), projectId).getDishName() : getRowmater(newGroupModel.getPackDishId(), projectId).getRmName();
                content += num + ".组成" + (11001 == newGroupModel.getGoodType() ? "菜品" : "原材料") + "为：【" + dishName + "】,套餐价格为：【" + (null != newGroupModel.getPackagePrice() && newGroupModel.getPackagePrice().compareTo(BigDecimal.ZERO) != 0 ? newGroupModel.getPackagePrice() : 0) + "】，";
                for (CateringTcbDishExchangeModel exchangeModel : newGroupModel.getDishExchangeModels()) {
                    String exchangeDishName = 11001 == newGroupModel.getGoodType() ?  getDishes(exchangeModel.getDishExchgDishId(), projectId).getDishName() : getRowmater(exchangeModel.getDishExchgDishId(), projectId).getRmName();
                    numSeed ++;
                    content += numSeed + ".兑换" + (11001 == newGroupModel.getGoodType() ? "菜品" : "原材料") + "为：【" + exchangeDishName + "】,套餐价格为：【" + (null != exchangeModel.getPackagePrice() && exchangeModel.getPackagePrice().compareTo(BigDecimal.ZERO) != 0 ? exchangeModel.getPackagePrice() : 0) + "】"  + (number != newGroupModel.getDishExchangeModels().size() ? "，" : "。");
                    number++;
                }
            }
            rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);
            return;
        }
        boolean falg = newGroupModels.stream().anyMatch(a -> a.getWhetherUpdate());
        if (falg) {
            String content = "编辑菜品组成信息：修改前信息为：";
            int num = 0;
            int numSeed = 0;
            for (CateringTcbDishGroupModel oldGroupModel : oldGroupModels) {
                num ++;
                content += num + ".组成菜品为：【" + oldGroupModel.getDishName() + "】,套餐价格为：【" + (null != oldGroupModel.getPackagePrice() && oldGroupModel.getPackagePrice().compareTo(BigDecimal.ZERO) != 0 ? oldGroupModel.getPackagePrice() : 0) + "】，";
                for (CateringTcbDishExchangeModel oldExchangeModel : oldGroupModel.getDishExchangeModels()) {
                    numSeed ++;
                    content += numSeed + ".兑换菜品为：【" + oldExchangeModel.getExchgDishName() + "】,套餐价格为：【" + (null != oldExchangeModel.getPackagePrice() && oldExchangeModel.getPackagePrice().compareTo(BigDecimal.ZERO) != 0 ? oldExchangeModel.getPackagePrice() : 0) + "】，";
                }
                numSeed = 0;
            }
            num = 0;
            numSeed = 0;
            content += "修改后信息为：";
            for (CateringTcbDishGroupModel newGroupModel : newGroupModels) {
                int number = 1;
                num ++;
                content += num + ".新组成菜品为：【" + newGroupModel.getDishName() + "】,套餐价格为：【" + newGroupModel.getPackagePrice() + "】，";
                for (CateringTcbDishExchangeModel oldExchangeModel : newGroupModel.getDishExchangeModels()) {
                    numSeed ++;
                    content += numSeed + ".兑换菜品为：【" + oldExchangeModel.getExchgDishName() + "】,套餐价格为：【" +  (null != newGroupModel.getPackagePrice() && newGroupModel.getPackagePrice().compareTo(BigDecimal.ZERO) != 0 ? newGroupModel.getPackagePrice() : 0) + "】"  + (number != newGroupModel.getDishExchangeModels().size() ? "，" : "。");
                    number++;
                }
            }
            rawmaterApi.saveBasicDataLog(projectId, dishId, 30, 0, content, accountId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void examine(String dishIds, Long accountId, Long projectId, String status) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id IN (" + dishIds + ") and project_id =" + projectId);
        List<CateringTcbDishesModel> dishesModels = autoBaseDao.listAll(sql);
        int dishesSize = dishesModels.size();
        dishesModels.removeIf(b -> 11103 == b.getcStatus()|| 11104 == b.getcStatus());
        if (dishesModels.size() != dishesSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在已审核的数据，请重新选择！", null);
        }
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("UPDATE catering_tcb_dishes SET c_status = " + status + ",\n" +
                        "bl_emp_id = " + accountId + ",\n" +
                        "sync_status = 10,\n" +
                        "bl_time = NOW()\n" +
                        "WHERE dish_id IN(" + dishIds + ") and project_id =" + projectId);
        //审核通过操作
        if (autoBaseDao.nativeExecute(supplier) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "审核操作失败！", null);
        }
        dishesModels.forEach(a -> {
            if (15002 == a.getSellModel()) {
                //联营供应商数据
                NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                        .setSql("UPDATE catering_dish_pool_relation SET status = " + status + ", \n" +
                                "sync_status = 10\n" +
                                "WHERE is_delete = 0 AND dish_id = " + a.getDishId() + "  and project_id =" + projectId);
                autoBaseDao.nativeExecute(nativeSQLBuilder);
                //审核通过操作
//                if (autoBaseDao.nativeExecute(nativeSQLBuilder) == 0) {
//                    throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改联营数据失败！", null);
//                }
            }
        });

        dishesModels.forEach(a -> {
            String type = "11104".equals(status) ? "审核驳回" : "审核通过";
            String content = type + "操作，菜品编号【" + a.getDishCode() + "】";
            rawmaterApi.saveBasicDataLog(projectId, a.getDishId(), 30, 0, content, accountId);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void eliminate(Integer dishId, Long accountId, Long projectId, Integer status) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id = " + dishId + " and project_id =" + projectId);
        CateringTcbDishesModel dishesModel = (CateringTcbDishesModel) autoBaseDao.findOne(sql);
        if (11103 != dishesModel.getcStatus()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "当前状态不允许淘汰，请重新选择！", null);
        }
        //1.     没有被可售菜品关联的可以被淘汰
        //2.     菜品没有被绑定在套餐里的可以被淘汰
        //3.有无绑定菜品BOM
        operation(dishId, projectId, "淘汰");

        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("UPDATE catering_tcb_dishes SET c_status = " + status + ",\n" +
                        "bl_emp_id = " + accountId + ",\n" +
                        "sync_status = 10,\n" +
                        "bl_time = NOW()\n" +
                        "WHERE dish_id = " + dishId + " and project_id =" + projectId);
        //淘汰操作
        if (autoBaseDao.nativeExecute(supplier) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "淘汰操作失败！", null);
        }

        if (15002 == dishesModel.getSellModel()) {
            //兼容历史数据
            //保存前先查询之前是否保存过未审核通过的联营供应商信息，存在则删除
            NativeSQLBuilder builder = NativeSQLBuilder.build(CateringDishPoolRelationModel.class)
                    .setSql("SELECT * FROM catering_dish_pool_relation\n" +
                            "WHERE is_delete = 0 AND dish_id =" +dishId + "\n" +
                            "and project_id = " + projectId);
            CateringDishPoolRelationModel oldPoolRelationModel = (CateringDishPoolRelationModel)autoBaseDao.findOne(builder);
            if (null == oldPoolRelationModel) {
                return;
            }
            //联营供应商数据
            NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                    .setSql("UPDATE catering_dish_pool_relation SET supp_status = 0, status = " + status + ", \n" +
                            "sync_status = 10\n" +
                            "WHERE is_delete = 0 AND dish_id  =" + dishId + " and project_id =" + projectId);
            //审核通过操作
            if (autoBaseDao.nativeExecute(nativeSQLBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改联营数据失败！", null);
            }
        }

        String content = "淘汰操作，菜品编号【" + dishesModel.getDishCode() + "】";
        rawmaterApi.saveBasicDataLog(projectId, dishesModel.getDishId(),30, 0, content, accountId);

    }


    @Override
    public DishesDto getIsDishCode(String dishCode, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                .setSql("SELECT * FROM catering_tcb_dishes  WHERE c_status != 11109 AND is_delete = 0 and dish_code ='" + dishCode + "'\n" +
                        "and project_id = " + projectId);
        return (DishesDto)autoBaseDao.findOne(supplier);
    }

    @Override
    public DishesDto checkDishName(String suppName, Long projectId, Integer dishId,Integer dishType) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                .setSql("SELECT * FROM catering_tcb_dishes  WHERE c_status != 11109 and dish_type = "+dishType+" AND  is_delete = 0 and dish_name ='" + suppName + "'\n" +
                        "and project_id = " + projectId);
        /*supplier.append(0 != dishId ? ("and dish_id =" + dishId + "\n") : "");*/
        DishesDto dishesDto = (DishesDto)autoBaseDao.findOne(supplier);
        if (null == dishesDto) {
            return null;
        } else {
            if (dishId.intValue() == dishesDto.getDishId().intValue()) {
                return null;
            }
            return  dishesDto;
        }
    }

    @Override
    public String getDishCode() {
        return String.valueOf(idWorker.nextId());
    }

    @Override
    public List<CatecommTssPubdatadictModel> getPeriod(String type) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CatecommTssPubdatadictModel.class)
                .setSql("SELECT * FROM catecomm_tss_pubdatadict \n" +
                        "WHERE p_dict_name = '" + type + "'" );
        return autoBaseDao.listAll(sql);
    }

    @Override
    public List<CatecommTssDatadictModel> getPell(String type, Long projectId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                .setSql("SELECT * FROM catecomm_tss_datadict \n" +
                        "WHERE dd_status = 1 and project_id =" + projectId + " and dict_name = '" + type + "'" );
        return autoBaseDao.listAll(supplier);
    }

    @Override
    public List<CatecommTsbTaxModel> getTax(Long projectId) {
        NativeSQLBuilder tax = NativeSQLBuilder.build(CatecommTsbTaxModel.class)
                .setSql("SELECT * FROM catecomm_tsb_tax \n" +
                        "WHERE is_delete = 0 and t_status = 0 and project_id =" + projectId );
        return autoBaseDao.listAll(tax);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CateringTcbDishTasteModel saveDishTaste(CateringTcbDishTasteModel query, Long accountId) {
        if(0 == query.getDishTasteId()) {
            query.setDishTasteId(supplierService.getTableId(query.getProjectId(),"catering_tcb_dish_taste", 1));
            query.setCreater(accountId);
            query.setModiter(accountId);
            if (autoBaseDao.save(query) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "新增口味信息保存失败！", null);
            }
        } else {
            query.setModiter(accountId);
            query.setModiter(accountId);
            UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbDishTasteModel.class).setBean(query)
                    .whereEq("dishTasteId", query.getDishTasteId()).whereEq("projectId", query.getProjectId());
            if (autoBaseDao.update(updateBuilder) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "修改口味信息保存失败！", null);
            }
        }
        return  query;//将数据返回给前台，保存菜品时候用
    }

    @Override
    public void deleteDishTaste(Long projectId, Integer dishTasteId) {
        CateringTcbDishTasteModel cateringTcbDishTasteModel = new CateringTcbDishTasteModel();
        cateringTcbDishTasteModel.setIsDelete(1);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CateringTcbDishTasteModel.class).setBean(cateringTcbDishTasteModel).whereEq("dishTasteId", dishTasteId)
                .whereEq("projectId", projectId);
        if (autoBaseDao.update(updateBuilder) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "删除口味信息保存失败！", null);
        }
    }

    @Override
    public List<DishesSpecDto> getDishesGroupList(DishesDto query) {
        if (11001 == query.getGoodType()) {
            NativeSQLBuilder supplier = NativeSQLBuilder.build(DishesDto.class)
                    .setSql("SELECT t1.*, t3.type_name, t4.type_name as unit_name, '11001' AS goodType FROM catering_tcb_dishes t1 \n" +
                            "LEFT JOIN catering_tcc_dishes_class t2 ON t2.dish_class_code = t1.dish_class_code \n" +
                            "LEFT JOIN catecomm_tss_pubdatadict t3 ON t3.type_code = t1.dish_type \n" +
                            "LEFT JOIN catecomm_tss_pubdatadict t4 ON t4.type_code = t1.dish_unit \n" +
                            "WHERE t1.is_delete = 0 and t1.dish_type = 11001 and c_status = 11103");
            supplier.append("and t1.project_id =" + query.getProjectId());
            supplier.append(StringUtils.isNotBlank(query.getDishClassCode()) ? (" and t2.dish_class_code =\n" + query.getDishClassCode() + "\n") : "");
            supplier.append(StringUtils.isNotBlank(query.getDishCode()) ? (" and (t1.dish_code = '" + query.getDishCode() + "' OR t1.dish_name like\n" + "'%" + (query.getDishCode()) + "%')\n") : "");
            supplier.setPage(1, 1000);
            PagedList<DishesDto> dishesDtos = autoBaseDao.listPage(supplier);
            if (0 != query.getDishId()) {
                dishesDtos.removeIf(a -> a.getDishId().intValue() == query.getDishId().intValue());
            }
            //组装信息
            return  groupZoom(dishesDtos, query);
        } else {
            //原材料信息
            NativeSQLBuilder rowmaterial = NativeSQLBuilder.build(DishesDto.class)
                    .setSql("SELECT t1.rm_id AS dishId, t1.rm_name AS dishName, t1.rm_code AS dishCode, t2.srm_unit AS dishSpecId, t1.predict_price AS retailPrice,\n" +
                            "(SELECT type_name FROM  catecomm_tss_pubdatadict WHERE catecomm_tss_pubdatadict.type_code = t2.srm_unit) AS unitName, '原材料' AS typeName, '11004' AS goodType \n" +
                            "FROM catering_tcb_rowmaterial t1\n" +
                            "LEFT JOIN catering_tcb_sale_rowmater t2 ON t2.rm_id = t1.rm_id AND t1.project_id = t2.project_id\n" +
                            "WHERE t1.is_can_sale = 1 AND t1.is_delete = 0 AND t1.c_status = 11503 AND t1.project_id = " + query.getProjectId() + "\n" +
                            "AND t2.is_default = 1 AND t2.is_delete = 0\n");
            rowmaterial.append(StringUtils.isNotBlank(query.getDishClassCode()) ? (" and t1.rm_class_code =\n" + query.getDishClassCode() + "\n") : "");
            rowmaterial.append(StringUtils.isNotBlank(query.getDishCode()) ? (" and (t1.rm_code = '" + query.getDishCode() + "' OR t1.rm_name like\n" + "'%" + (query.getDishCode()) + "%')\n") : "");
            if (0 != query.getDishId()) {
                rowmaterial.append("AND t1.rm_id != " + query.getDishId());
            }
            return autoBaseDao.listAll(rowmaterial);
        }
    }


    private List<DishesSpecDto> groupZoom(PagedList<DishesDto> dishesDtos, CateringTcbDishesModel query) {
        //查询菜品销售规格
        List<DishesSpecDto> dishSpecModels = null;
        if (null != dishesDtos && dishesDtos.size() > 0) {
            List<Integer> dishIds = dishesDtos.stream().map(a->{return a.getDishId();}).collect(Collectors.toList());
            NativeSQLBuilder disSpe = NativeSQLBuilder.build(DishesSpecDto.class)
                    .setSql("SELECT t1.*, t2.dict_tp_value FROM catering_tcb_dish_spec t1\n" +
                            "LEFT JOIN catecomm_tss_datadict t2 ON t2.dict_tp_code = t1.spec_id and t2.project_id = t1.project_id\n" +
                            "WHERE t1.is_delete = 0 and t2.dd_status = 1");
            disSpe.append("and t1.project_id =" + query.getProjectId());
            disSpe.append("and t1.dish_id in (" + ListIdsToString.getIds(dishIds) + ")");
            disSpe.append(null != query.getSpecId() ? (" and t1.spec_id =\n" + query.getSpecId() + "\n") : "");
            dishSpecModels = autoBaseDao.listAll(disSpe);
            if (dishSpecModels != null  && dishSpecModels.size() > 0) {
                dishSpecModels.stream().forEach(a -> {
                    List<DishesDto> subItems = dishesDtos.stream().filter(b -> a.getDishId().intValue() == b.getDishId().intValue()).collect(Collectors.toList());
                    a.setDishCode(subItems.get(0).getDishCode());
                    a.setDishId(subItems.get(0).getDishId());
                    a.setDishName(subItems.get(0).getDishName());
                    a.setTypeName(subItems.get(0).getTypeName());
                    a.setUnitName(subItems.get(0).getUnitName());
                    a.setGoodType(subItems.get(0).getGoodType());
                });
            }
        }
        return dishSpecModels;
    }

    @Override
    public List<CateringTcbDishTasteModel> getDishTasteList(Long projectId, Integer dishId) {
        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbDishTasteModel.class)
                .setSql("SELECT * FROM catering_tcb_dish_taste\n" +
                        "WHERE is_delete = 0");
        supplier.append("and project_id =" + projectId);
        supplier.append("and dish_id =" + dishId);
        return autoBaseDao.listAll(supplier);
    }

    @Override
    public void editRemark(CateringTcbDishesModel model) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id = " + model.getDishId() + " and project_id =" + model.getProjectId());
        CateringTcbDishesModel dishesModels = (CateringTcbDishesModel) autoBaseDao.findOne(sql);
        NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class).setSql(
                "update catering_tcb_dishes  SET remark = CONCAT(IFNULL(remark,''), #{remark}) \n" +
                        "where dish_id = #{dishId} and project_id = #{projectId}"
        ).setValue("dishId", model.getDishId())
                .setValue("projectId", model.getProjectId())
                .setValue("remark", model.getRemark());
        autoBaseDao.nativeExecute(sqlBuilder);
        String content = "编辑备注操作：原备注为：【" + dishesModels.getRemark() + "】，改为：【" + model.getRemark() + "】。";
        rawmaterApi.saveBasicDataLog(model.getProjectId(), model.getDishId(), 30, 0, content, model.getModifier());
    }

    @Override
    public boolean checkDishBarcode(String dishBarcode, Long projectId) {
        NativeSQLBuilder dishes = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE dish_barcode ='" + dishBarcode + "'\n" +
                        "and project_id = " + projectId + " and is_delete = 0 and dish_type = 11002");
        if (null == autoBaseDao.findOne(dishes)) {
            return true;
        }
        return false;
    }



    @Override
    public void uploadImage(List<CateringTcbDishimgsModel> dishimgsModels, Long accountId, Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id = " + dishimgsModels.get(0).getDishId() + " and project_id =" + projectId);
        CateringTcbDishesModel dishesModels = (CateringTcbDishesModel) autoBaseDao.findOne(sql);
        if (null != dishesModels) {
            //修改菜品上传的图片,先删除之前的
            DeleteBuilder img = DeleteBuilder.build("catering_tcb_dishimgs").whereEq("dish_id", dishimgsModels.get(0).getDishId())
                    .whereEq("project_id", projectId);
            autoBaseDao.delete(img);
        }
        //删除后再做保存
        dishimgsModels.forEach(b -> {
            b.setCiId(supplierService.getTableId(b.getProjectId(), "catering_tcb_dishimgs", 1));
            b.setProjectId(projectId);
            b.setBlEmpId(accountId);
            b.setModifier(accountId);
            b.setAddTime(new Date());
            b.setDishId(b.getDishId());
            if (autoBaseDao.save(b) == 0) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "图片信息保存失败！", null);
            }
        });
    }

    @Override
    public CateringTcbDishesModel getIsBarCode(String barCode, Long projectId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and bar_code = '" + barCode + "' and project_id =" + projectId);
        return  (CateringTcbDishesModel) autoBaseDao.findOne(sql);
    }

    @Override
    public List<CateringTccDishesClassModel> getAllDisheClass(Long projectId) {
        NativeSQLBuilder dishClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  WHERE is_delete = 0 AND udish_id = 0 and project_id = " + projectId );
        return autoBaseDao.listAll(dishClass);
    }

    @Override
    public List<CateringTccDishesClassModel> queryDishClassByDishClassId(Integer dishClassId, Long projectId) {
        NativeSQLBuilder dishClass = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("SELECT * FROM catering_tcc_dishes_class  \n" +
                        "WHERE udish_id = " + dishClassId + " and is_delete = 0 and project_id = " + projectId);
        return autoBaseDao.listAll(dishClass);
    }

    @Override
    public CateringTccDishesClassModel getDishClass(Integer dishClassId, String dishClassCode, Long projectId) {
        NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CateringTccDishesClassModel.class)
                .setSql("select t1.* from catering_tcc_dishes_class t1  \n" +
                        "where t1.is_delete = 0 and t1.project_id = " + projectId);
        if (null != dishClassId) {
            tsbTaxBuild.append(" and t1.dish_id = " + dishClassId + "");
        }
        if (StringUtils.isNotBlank(dishClassCode)) {
            tsbTaxBuild.append(" and t1.`dish_class_code`= " + dishClassCode + "");
        }

        return (CateringTccDishesClassModel) autoBaseDao.findOne(tsbTaxBuild);
    }

    @Override
    public String preImportDishes(Excel<DishesExeclVo> excel, Long projectId, Long projectRootId, Long accountId) {
        DishesResponse response = new DishesResponse();
        List<DishesExeclMessage> execlMessagesList = new ArrayList<>();
        int type = 0;

        for (DishesExeclVo item : excel.getData()) {
            StringBuilder messageBuf = new StringBuilder();
            DishesExeclMessage execlMessage = new DishesExeclMessage();
            DishesDto newDishesDto = new DishesDto();
            /**菜品分类**/
            String classCodetemp = item.getDishClassCode();
            if (StringUtils.isBlank(classCodetemp)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("菜品分类为空").append(" ");
            } else {
                String[] rmClassCodeResult = classCodetemp.split("-");
                String dishClassCode = rmClassCodeResult[0];
                String dishClassName = rmClassCodeResult[1];
                CateringTccDishesClassModel dishClass = this.getDishClass(null, dishClassCode, projectId);
                if (null == dishClass) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("菜品分类：" + dishClassCode +"-" + dishClassName + "已不存在,请更换分类或下载最新模版").append(" ");
                }
                // 判断是否存在子级
                List<CateringTccDishesClassModel> dishesClasses = this.queryDishClassByDishClassId(dishClass.getDishId(), projectId);
                if (CollectionUtils.isNotEmpty(dishesClasses)) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("菜品分类：" + dishClassCode + "-" + dishClassName + "下已存在子分类,请更换分类下载最新模版").append(" ");
                }
                newDishesDto.setDishClassCode(dishClassCode);//菜品分类
            }

            //菜品名称
            String dishName = item.getDishName();
            if (StringUtils.isBlank(dishName)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("菜品名称为空").append(" ");
            } else {
                dishName.trim();
            }

            List<DishesExeclMessage> subItems = execlMessagesList.stream().filter(b -> dishName.equals(b.getDishName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(subItems)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("execl中菜品名称 [" + dishName + "] 重复,请保证唯一").append(" ");
            }
            DishesDto dishesDto = this.checkDishName(dishName, projectId, 0, 11001);
            if (null != dishesDto) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("菜品名称已存在,请保证唯一").append(" ");
            }
            execlMessage.setDishName(dishName);//菜品名称
            newDishesDto.setDishName(dishName);

            /**菜品单位**/
            String unitStr = item.getDishUnit();
            if (StringUtils.isBlank(unitStr)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("菜品单位为空").append(" ");
            } else {
                //查询单位
                NativeSQLBuilder sqlBuilder = NativeSQLBuilder.build(CatecommTssPubdatadictModel.class)
                        .setSql("SELECT * FROM catecomm_tss_pubdatadict  WHERE p_dict_type = 112 and p_dict_status = 1");
                sqlBuilder.append(" and type_name = '" + unitStr + "' LIMIT 1");
                CatecommTssPubdatadictModel pubdatadictModel = (CatecommTssPubdatadictModel) autoBaseDao.findOne(sqlBuilder);
                if (null == pubdatadictModel) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("菜品单位未在系统中维护，请检查数据").append(" ");
                } else {
                    Integer unit = pubdatadictModel.getTypeCode();
                    newDishesDto.setDishUnit(unit);//单位字典id
                    execlMessage.setUnitName(unitStr);
                }
            }

            /**销项税率**/
            String saleTaxIdStr = item.getSaleTaxId();
            if (StringUtils.isBlank(saleTaxIdStr)){
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("销项税率为空").append(" ");
            } else {
                DecimalFormat df = new DecimalFormat("0%");
                String taxName = null;
                try {
                    taxName = df.format(NumberFormat.getInstance().parse(saleTaxIdStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                NativeSQLBuilder tsbTaxBuild = NativeSQLBuilder.build(CatecommTsbTax.class)
                        .setSql("select t1.* from catecomm_tsb_tax t1  where t1.is_delete = 0 and t1.t_status = 0\n" +
                                "\tand t1.project_id = " + projectId);
                tsbTaxBuild.append(" and t1.`tax_name` = '" + taxName + "' LIMIT 1");
                CatecommTsbTax catecommTsbTax = (CatecommTsbTax) autoBaseDao.findOne(tsbTaxBuild);
                if (null == catecommTsbTax) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("销项税税率未在系统中维护，请检查数据!").append(" ");
                } else {
                    Integer taxId = catecommTsbTax.getTaxId();
                    newDishesDto.setSlTaxId(Integer.valueOf(taxId));//销项税税率
                    execlMessage.setTaxName(taxName);
                }
            }

            /**预估成本价**/
            String retailPrice = item.getRetailPrice();
            if (StringUtils.isBlank(retailPrice)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("预估价格为空").append(",");
            }

            /**经营方式**/
            String sellModelName = item.getSellModel();
            if (StringUtils.isBlank(sellModelName)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("经营方式为空").append(",");
            } else {
                newDishesDto.setSellModel("自营".equals(sellModelName) ? 15001 : 15002);
                execlMessage.setSellModelName(sellModelName);
            }
            //新增合同 联营状态下 联营扣率和联营合同编号必填
            if ("联营".equals(sellModelName)) {
                String contractCode = item.getContractCode();
                String discountRate = item.getDiscountRate();
                if (StringUtils.isEmpty(contractCode)) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("联营状态下联营扣率不能为空").append(",");
                }
                if (StringUtils.isEmpty(discountRate)) {
                    type = 1;
                    execlMessage.setType(type);
                    execlMessage.setFlag("失败");
                    messageBuf.append("联营状态下联营合同编号不能为空").append(",");
                }
                if (StringUtils.isNotEmpty(contractCode)) {
                    //查询合同是否存在且是否为有效合同的联营合同
                    NativeSQLBuilder sql = NativeSQLBuilder.build(CateringContract.class)
                            .setSql("SELECT * from   catering_contract   where  date_format(now(),'%Y-%m-%d') BETWEEN\n" +
                                    "contract_start_time and contract_end_time AND contract_stauts = 133003  AND contract_sell_model = 10003 AND is_delete = 0\n" +
                                    "\tand project_id = " + projectId + " AND contract_code = '" + contractCode + "'");
                    CateringContract cateringContract = (CateringContract) autoBaseDao.findOne(sql);
                    if (null == cateringContract) {
                        type = 1;
                        execlMessage.setType(type);
                        execlMessage.setFlag("失败");
                        messageBuf.append("未查询到相关合同信息或者合同未生效").append(",");
                    } else {
                        newDishesDto.setDiscountRate(new BigDecimal(discountRate));
                        //供应商合同信息
                        CateringDishPoolRelationModel poolRelationModels = new CateringDishPoolRelationModel();
                        poolRelationModels.setContractCode(contractCode);
                        poolRelationModels.setContractName(cateringContract.getContractName());
                        poolRelationModels.setDiscountRate(new BigDecimal(discountRate));
                        poolRelationModels.setSupperId(cateringContract.getContractSupper());
                        poolRelationModels.setProjectId(projectId);
                        poolRelationModels.setProjectRootId(projectRootId);
                        poolRelationModels.setSellModel(15002);
                        poolRelationModels.setStatus(1);
                        poolRelationModels.setSuppCode(cateringContract.getContractSupperCode());
                        newDishesDto.setPoolRelationModel(poolRelationModels);
                    }
                }

            }
            /**标准成本率**/
            String standardCostRate = item.getStandardCostRate();
            /*if ("自营".equals(sellModelName) && StringUtils.isBlank(standardCostRate)) {
                type = 1;
                execlMessage.setType(type);
                execlMessage.setFlag("失败");
                messageBuf.append("自营方式下标准成本率不能空").append(",");
            }*/
            if (!StringUtils.isBlank(standardCostRate)) {
                newDishesDto.setStandardCostRate(new BigDecimal(standardCostRate));
            } else {
                newDishesDto.setStandardCostRate(BigDecimal.ZERO);
            }
            execlMessage.setTypeName("成品");
            newDishesDto.setDishType(11001);
            newDishesDto.setProjectId(projectId);
            newDishesDto.setProjectRootId(projectRootId);
            newDishesDto.setDishId(0);
            //newDishesDto.setSpellCode(GetPell.getPinYinHeadChar(dishesDto.getDishName()));//菜品简称
            newDishesDto.setDishCode(this.getDishCode());//菜品编号
            //newDishesDto.setGoodType(11001);//菜品类型
            newDishesDto.setRemark("来源:excel导入;" + (StringUtils.isNotEmpty(item.getRemark()) ? item.getRemark() : ""));//备注
            newDishesDto.setPackCost(StringUtils.isNotEmpty(item.getPackCost()) ? new BigDecimal(item.getPackCost()) : BigDecimal.ZERO);
            newDishesDto.setcStatus(11101);//状态
            //条码：
            if (StringUtils.isNotEmpty(item.getBarCode())) {
                newDishesDto.setBarCode(item.getBarCode());
            }

            //规格信息
            if (StringUtils.isNotEmpty(retailPrice)) {
                List<CateringTcbDishSpecModel> specModelList = new ArrayList<>();
                CateringTcbDishSpecModel specModel = new CateringTcbDishSpecModel();
                specModel.setRetailPrice(new BigDecimal(retailPrice));
                specModel.setSaleCode(newDishesDto.getDishCode() + "-01");
                specModel.setSpecId(10701);
                specModelList.add(specModel);
                newDishesDto.setDishSpecModels(specModelList);
            }

            //口味信息
            if (StringUtils.isNotEmpty(item.getDishTasteType()) && StringUtils.isNotEmpty(item.getDishTasteName())) {
                List<CateringTcbDishTasteModel> tasteModelList = new ArrayList<>();
                String[] types = item.getDishTasteType().split(";");
                for (int i = 0; i < types.length; i++) {
                    CateringTcbDishTasteModel tasteModel = new CateringTcbDishTasteModel();
                    tasteModel.setDishCode(newDishesDto.getDishCode());
                    tasteModel.setDishTasteType(types[i]);
                    tasteModel.setDishTasteName(item.getDishTasteName());
                    tasteModelList.add(tasteModel);
                }
                newDishesDto.setDishTasteModels(tasteModelList);
            }

            execlMessage.setDishesDto(newDishesDto);

            execlMessage.setMessage(messageBuf.toString());

            execlMessagesList.add(execlMessage);
        }

        response.setCode(100);
        response.setTotal(execlMessagesList.size());
        response.setType(type);
        response.setExeclMessagesList(execlMessagesList);
        String randomStr = UUID.randomUUID().toString();

        redisUtil.setForSeconds(randomStr, JSON.toJSONString(response), 30 * 60L);
        return randomStr;
    }

    private DishesResponse importDishes(List<DishesExeclMessage> dishesExeclMessages, Long projectId, Long projectRootId, Long accountId) {
        DishesResponse response = new DishesResponse();
        dishesExeclMessages.forEach(a -> {
            this.saveDishes(a.getDishesDto(), accountId, 0);
        });

        response.setCode(100);
        return response;
    }

    @Override
    public DishesResponse listImportDishes(String redisKey, Integer pageNo, Integer pageSize, Integer type, Long projectId, Long projectRootId, Long accountId) {
        String execlMessages = (String)redisUtil.get(redisKey);
        DishesResponse response = JSON.parseObject(execlMessages, DishesResponse.class);
        if (response == null) {
            throw new RpcException(300,ErrorCode.PARAM_BLANK + "操作时间已过，请重新导入",null);
        }
        List<DishesExeclMessage> execlMessagesList = response.getExeclMessagesList();
        int total = execlMessagesList.size();
        response.setTotal(total);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        if (1 == type) {
            List<DishesExeclMessage> subItems = execlMessagesList.stream().filter(b -> type.intValue() == b.getType()).collect(Collectors.toList());
            subItems = subItems.size() <= 10 ? subItems : subItems.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo)));
            response.setExeclMessagesList(subItems);
            return response;
        } else if (2 == type){
            return importDishes(execlMessagesList, projectId, projectRootId, accountId);
        } else {
            response.setExeclMessagesList(execlMessagesList.subList(pageSize * (pageNo - 1), ((pageSize * pageNo) > total ? total : (pageSize * pageNo))));
            return response;
        }
    }

    @Override
    public void batchCommit(String dishIds, Long projectId, Long accountId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id IN (" + dishIds + ") and project_id =" + projectId);
        List<CateringTcbDishesModel> adjustModels = autoBaseDao.listAll(sql);
        Integer oldSize = adjustModels.size();
        adjustModels.removeIf(b -> 11101 != b.getcStatus().intValue());//排除掉不是新增状态的数据
        if (adjustModels.size() != oldSize) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "存在不是新增状态的数据，请重新选择！", null);
        }
        NativeSQLBuilder rcpt = NativeSQLBuilder.build(CateringTcjAdjust.class)
                .setSql("UPDATE catering_tcb_dishes\n" );
        rcpt.append("SET c_status = 11102 \n");
        rcpt.append("WHERE dish_id IN(" + dishIds + ")\n");
        rcpt.append("AND project_id = " + projectId);
        if (autoBaseDao.nativeExecute(rcpt) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "批量提交失败！", null);
        }

        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("UPDATE catering_dish_pool_relation SET supp_status = 1, status = 11102, \n" +
                        "sync_status = 10\n" +
                        "WHERE is_delete = 0 AND dish_id IN(" + dishIds + ") and project_id =" + projectId);
        //批量提交操作
        autoBaseDao.nativeExecute(nativeSQLBuilder);

        adjustModels.forEach(a -> {
            String content = "批量提交操作：菜品编号为【" + a.getDishCode() + "】, 菜品名称为：【" + a.getDishName() + "】。";
            rawmaterApi.saveBasicDataLog(projectId, a.getDishId(), 30, 0, content, accountId);
        });

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void counterTrial(Integer dishId, Long projectId, Long accountId) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_tcb_dishes\n" +
                        "WHERE is_delete = 0 and dish_id = " + dishId + " and project_id =" + projectId);
        CateringTcbDishesModel dishesModel = (CateringTcbDishesModel)autoBaseDao.findOne(sql);
        if (11103 != dishesModel.getcStatus()) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "只能反审审核通过的菜品！", null);
        }
        //按菜品设置
        NativeSQLBuilder sql1 = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("SELECT * FROM catering_saled_dish\n" +
                        "WHERE saled_dish_status != 11804 AND bill_type = 12215 AND saled_data_type = 20 AND is_delete = 0 \n" +
                        "and dict_id = " + dishId + " and project_id =" + projectId);
        List<CateringSaledDishModel> saledDishModels = autoBaseDao.listAll(sql1);
        if (null != saledDishModels && saledDishModels.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品：" + dishesModel.getDishName() + "已设置可售，无法反审！", null);
        }
        //按餐厅设置
        NativeSQLBuilder sql2 = NativeSQLBuilder.build(CateringSaledDishDetailModel.class)
                .setSql("SELECT t2.* FROM catering_saled_dish t1\n" +
                        "LEFT JOIN catering_saled_dish_detail t2 ON t2.project_id = t1.project_id AND t2.saled_dish_id = t1.saled_dish_id\n" +
                        "WHERE t1.saled_dish_status != 11804 and t1.bill_type = 12215 AND t1.saled_data_type = 10 AND t1.is_delete = 0 \n" +
                        "and t2.dish_id = " + dishId + " and t1.project_id =" + projectId);
        List<CateringSaledDishDetailModel> saledDishDetailModels = autoBaseDao.listAll(sql2);
        if (null != saledDishDetailModels && saledDishDetailModels.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品：" + dishesModel.getDishName() + "已设置可售，无法反审！", null);
        }
        //是否关联菜品BOM
        NativeSQLBuilder sql3 = NativeSQLBuilder.build(CateringTcbDishBom.class)
                .setSql("SELECT * FROM catering_tcb_dish_bom\n" +
                        "WHERE db_status != 13906 AND is_delete = 0 \n" +
                        "and dish_id = " + dishId + " and project_id =" + projectId);
        List<CateringTcbDishBom> dishBoms = autoBaseDao.listAll(sql3);
        if (null != dishBoms && dishBoms.size() > 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "菜品：" + dishesModel.getDishName() + "已设置菜品BOM，无法反审！", null);
        }
        //修改菜品状态

        NativeSQLBuilder supplier = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("UPDATE catering_tcb_dishes SET c_status = 11104,\n" +
                        "modifier = " + accountId + ",\n" +
                        "sync_status = 10,\n" +
                        "updated_time = NOW()\n" +
                        "WHERE dish_id = " + dishId + " and project_id =" + projectId);
        //反审操作
        if (autoBaseDao.nativeExecute(supplier) == 0) {
            throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT +  "反审操作失败！", null);
        }

        String content = "反审操作，菜品编号【" + dishesModel.getDishCode() + "】";
        rawmaterApi.saveBasicDataLog(projectId, dishesModel.getDishId(),30, 0, content, accountId);

        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CateringTcbDishesModel.class)
                .setSql("UPDATE catering_dish_pool_relation SET supp_status = 0, status = 11104, \n" +
                        "sync_status = 10\n" +
                        "WHERE is_delete = 0 AND dish_id  =" + dishId + " and project_id =" + projectId);
        //审核通过操作
        autoBaseDao.nativeExecute(nativeSQLBuilder);
    }

    /**
     * 菜品成本对比查询
     * @param projectId
     * @param accountId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ModelPagedList<TreeMap> dishesCostContrast( Long projectId, Long accountId,Integer gzoneId,String dishName,Integer pageNo, Integer pageSize) {
        NativeSQLBuilder sql = NativeSQLBuilder.build(TreeMap.class)
                .setSql("SELECT\n" +
                        "\tt1.dish_id dishId,\n" +
                        "\tt2.dish_code dishCode,\n" +
                        "\tt2.dish_name dishName,\n" +
                        "\tt4.tax_name taxName,\n" +
                        "\tt1.retail_price retailPrice,\n" +
                        "\tt3.gzone_id gzoneId,\n" +
                        "\tt3.gzone_code gzoneCode,\n" +
                        "\tt3.gzone_name gzoneName,\n" +
                        "\tstandard_cost_rate standardCostRate,\n" +
                        "\t(\n" +
                        "\t\tSELECT\n" +
                        "\t\t\tGROUP_CONCAT(CONCAT_WS('-',db.rmdish_id,ds.cost_sumcount)  SEPARATOR ',') rmId\n" +
                        "\t\tFROM\n" +
                        "\t\t\tcatering_tcb_dish_bom bom\n" +
                        "\t\tLEFT JOIN catering_tcb_dish_bom_detail db ON bom.project_id = db.project_id\n" +
                        "\t\tAND bom.dish_bom_id = db.dish_bom_id\n" +
                        "\t\tleft join catering_tcb_dish_bom_detail_spec ds on db.project_id = ds.project_id and db.dish_bom_id = ds.dish_bom_id and db.dish_bom_dtl_id = ds.dish_bom_dtl_id\n" +
                        "\t\tWHERE\n" +
                        "\t\t\tdb.project_id = \n" + projectId+
                        "\t\tAND db.bom_dtl_type = 10\n" +
                        "\t\tAND dish_id = t1.dish_id\n" +
                        "\t\tAND db.is_delete = 0 \n" +
                        "\t\tAND bom.db_status != 13906 \n" +
                        "\t) rmId,\n" +
                        "\t(\n" +
                        "\t\tSELECT\n" +
                        "\t\t\tGROUP_CONCAT(CONCAT_WS('-',db.rmdish_id,ds.cost_sumcount)  SEPARATOR ',') rmdishId\n" +
                        "\t\tFROM\n" +
                        "\t\t\tcatering_tcb_dish_bom bom\n" +
                        "\t\tLEFT JOIN catering_tcb_dish_bom_detail db ON bom.project_id = db.project_id\n" +
                        "\t\tAND bom.dish_bom_id = db.dish_bom_id\n" +
                        "\t\tleft join catering_tcb_dish_bom_detail_spec ds on db.project_id = ds.project_id and db.dish_bom_id = ds.dish_bom_id and db.dish_bom_dtl_id = ds.dish_bom_dtl_id\n" +
                        "\t\tWHERE\n" +
                        "\t\t\tdb.project_id = \n"  + projectId+
                        "\t\tAND db.bom_dtl_type = 20\n" +
                        "\t\tAND dish_id = t1.dish_id\n" +
                        "\t\tAND db.is_delete = 0 \n" +
                        "\t\tAND bom.db_status != 13906 \n" +
                        "\t) halfId\n" +
                        "FROM\n" +
                        "\t(\n" +
                        "\t\tSELECT\n" +
                        "\t\t\ta.project_id,\n" +
                        "\t\t\ta.sell_point_id,\n" +
                        "\t\t\tb.dish_id,\n" +
                        "\t\t\td.retail_price\n" +
                        "\t\tFROM\n" +
                        "\t\t\tcatering_saled_dish a\n" +
                        "\t\tLEFT JOIN catering_saled_dish_detail b ON a.project_id = b.project_id\n" +
                        "\t\tAND a.saled_dish_id = b.saled_dish_id\n" +
                        "\t\tLEFT JOIN catering_saled_dish_detail_price c ON b.project_id = c.project_id\n" +
                        "\t\tAND b.saled_dish_id = c.saled_dish_id\n" +
                        "\t\tAND b.saled_dish_dtl_id = c.saled_dish_dtl_id\n" +
                        "\t\tLEFT JOIN catering_tcb_dish_spec d ON c.project_id = d.project_id\n" +
                        "\t\tAND c.dict_id = d.dish_id\n" +
                        "\t\tLEFT JOIN catering_tcb_dishes bb ON bb.project_id = b.project_id\n" +
                        "\t\tAND bb.dish_id = b.dish_id\n" +
                        "\t\tWHERE\n" +
                        "\t\t\ta.project_id = \n" + projectId+
                        "\t\tAND a.saled_dish_status = 11803\n" +
                        "\t\tAND a.is_delete = 0\n" +
                        "\t\tAND b.is_delete = 0\n" +
                        "\t\tAND c.is_delete = 0\n" +
                        "\t\tAND d.is_delete = 0\n" +
                        "\t\tAND d.spec_id = 10701\n" +
                        "\t\tGROUP BY\n" +
                        "\t\t\ta.project_id,\n" +
                        "\t\t\ta.sell_point_id,\n" +
                        "\t\t\tb.dish_id,\n" +
                        "\t\t\td.retail_price\n" +
                        "\t) t1\n" +
                        "LEFT JOIN catering_tcb_dishes t2 ON t1.project_id = t2.project_id\n" +
                        "AND t1.dish_id = t2.dish_id\n" +
                        "LEFT JOIN catecomm_tsb_gzone t3 ON t1.sell_point_id = t3.gzone_id\n" +
                        "AND t1.project_id = t3.project_id\n" +
                        "LEFT JOIN catecomm_tsb_tax t4 ON t2.sl_tax_id = t4.tax_id\n" +
                        "AND t4.project_id = t2.project_id\n" +
                        "where t2.c_status = 11103 and t2.is_delete = 0 and t3.is_delete = 0 and t4.is_delete = 0" +
                        " and t2.project_id = \n" + projectId );
        if (null != gzoneId) {
            sql.append(" and t3.gzone_id = " + gzoneId + "");
        }
        if(StringUtils.isNotBlank(dishName)){
            sql.append(" and ( t2.dish_name like '%"+dishName+"%' or t2.dish_code like '%"+dishName+"%')");
        }
        sql.setPage(pageNo, pageSize);
        PagedList<TreeMap> dishList = autoBaseDao.listPage(sql);
        dishList.forEach(x->{
            BigDecimal dishPrice = BigDecimal.ZERO;
            if(x.get("halfId") !=null){
                StringBuffer sb = new StringBuffer();
                String halfId[] = x.get("halfId").toString().split(",");
                Map map = new HashMap();
                for(String str : halfId){
                    Integer id = Integer.valueOf(str.split("-")[0]);
                    String cost = str.split("-")[1];
                    map.put(id,cost);
                    sb.append(id).append(",");
                }
                String ids = sb.deleteCharAt(sb.length() - 1).toString();
                List<DishBomVo> dishBomList = getDishTaxPaid(ids,projectId);
                for(DishBomVo bom : dishBomList){
                    BigDecimal count = new BigDecimal(map.get(bom.getRmdishId()).toString());
                    dishPrice = dishPrice.add(bom.getTaxPaid().multiply(count));
                }
            }
            BigDecimal rmPrice = BigDecimal.ZERO;
            if(x.get("rmId") !=null){
                StringBuffer sb = new StringBuffer();
                String rmId[] = x.get("rmId").toString().split(",");
                Map map = new HashMap();
                for(String str : rmId){
                    Integer id = Integer.valueOf(str.split("-")[0]);
                    String cost = str.split("-")[1];
                    map.put(id,cost);
                    sb.append(id).append(",");
                }
                String ids = sb.deleteCharAt(sb.length() - 1).toString();
                List<DishBomVo> dishBomList = getRmTaxPaid(ids,projectId);
                for(DishBomVo bom : dishBomList){
                    BigDecimal count = new BigDecimal(map.get(bom.getRmdishId()).toString());
                    dishPrice = dishPrice.add(bom.getTaxPaid().multiply(count));
                }
            }
            //菜品成本总价
            BigDecimal dishSum = dishPrice.add(rmPrice);
            x.put("dishSum",dishSum);
            if(x.get("standardCostRate") !=null){
                BigDecimal standardCostRate = (BigDecimal) x.get("standardCostRate");
                //标准售价
                x.put("standardPrice",dishSum.multiply(standardCostRate).divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP));
                if(x.get("retailPrice") !=null){
                    BigDecimal retailPrice = (BigDecimal) x.get("retailPrice");
                    if(retailPrice.compareTo(BigDecimal.ZERO)==0 || dishSum.compareTo(BigDecimal.ZERO)==0){
                        x.put("currentCostRate","0%");
                    }else{
                        BigDecimal currentCostRate = retailPrice.divide(dishSum,4,BigDecimal.ROUND_HALF_UP);
                        NumberFormat percent = NumberFormat.getPercentInstance();
                        percent.setMaximumFractionDigits(2);
                        //当前成本率
                        x.put("currentCostRate",percent.format(currentCostRate));
                    }
                }
            }
        });
        return ModelPagedList.convertToModelPage(dishList);
    }

    /****
     * @Author huangpeng
     * @Description //查看对应原材料缺省供应商的含税成本进价
     * @Date 9:47 2021/4/14
     * @Param
     * @return
     **/
    public List<DishBomVo> getRmTaxPaid(String rmId,Long pojectId){
        NativeSQLBuilder builder = NativeSQLBuilder.build(DishBomVo.class).setSql("" +
                "SELECT tax_paid,rm_id as rmdishId FROM `catering_tcb_supp_rowmater` \n" +
                "WHERE project_id =  "+pojectId+" \n" +
                "AND is_delete = 0 AND is_default = 1");
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(rmId)){
            builder.append(" and rm_id  IN ( "+rmId+" ) ");
        }
        List<DishBomVo> list = autoBaseDao.listAll(builder);
        return  list;
    }
    /****
     * @Author huangpeng
     * @Description //查看对应半成品的含税成本进价
     * @Date 9:47 2021/4/14
     * @Param
     * @return
     **/
    public  List<DishBomVo> getDishTaxPaid(String dish,Long pojectId){
        NativeSQLBuilder builder = NativeSQLBuilder.build(DishBomVo.class).setSql("" +
                "SELECT a.`taxcostprice` as tax_paid,a.comId as rmdishId FROM  catecomm_cost AS a   \n" +
                "INNER JOIN(\n" +
                "SELECT project_ID,comID,good_type,MAX(dtime) AS dtime,module_id\n" +
                "FROM catecomm_cost \n" +
                "WHERE module_id=20  AND project_ID="+pojectId+"\n" +
                "GROUP BY project_ID,comID,good_type,module_id\n" +
                ") AS b \n" +
                "ON a.project_ID = b.project_ID \n" +
                "AND a.comID = b.comID \n" +
                "AND a.dtime=b.dtime\n" +
                "AND a.good_type = b.good_type \n" +
                "AND a.module_id = b.module_id\n" +
                "AND a.module_id=20  AND a.project_ID="+pojectId+"\n" +
                "AND a.good_type = 11002 ");
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(dish)){
            builder.append(" and a.comId IN ( "+dish+" ) ");
        }
        List<DishBomVo> list = autoBaseDao.listAll(builder);
        return  list;
    }

}
