package com.system.service.impi;


import com.changshang.feign.SupplierServiceFeign;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.dao.DataDictDao;
import com.system.service.DataDictApi;
import entity.ModelPagedList;
import modelpojo.ErrorCode;
import modelpojo.RpcException;
import modelpojo.model.CatecommTssDatadictModel;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.builder.UpdateBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.lufei.ibatis.mapper.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xmlunit.util.Convert;


@Service
public class DataDictBiz implements DataDictApi {

    private AutoBaseDao autoBaseDao= new AutoDaoImpl();

    @Autowired
    private SupplierServiceFeign supplierServiceFeign;

    @Autowired
    private DataDictDao dataDictDao;

    /**
     * 公共字典类型列表查询
     *
     * @param info
     * @param pageNo
     * @param pageSize
     * @param projectId
     * @return
     */
    @Override
    public PageInfo<CatecommTssDatadictDto> selectDataList(CatecommTssDatadictVo info, Integer pageNo, Integer pageSize, Long projectId) {
        //静态分页
        PageHelper.startPage(pageNo,pageSize);
        //分页查询
        return new PageInfo<CatecommTssDatadictDto>(dataDictDao.selectDataList(info,projectId));

    }


    /**
     * 参数设置类型详情查询
     *
     * @param info
     * @param pageNo
     * @param pageSize
     * @param projectId
     * @return
     */
    @Override
    public ModelPagedList selectDataDetailList(CatecommTssDatadictVo info, Integer pageNo, Integer pageSize, Long projectId) {
        //查询所有的类型种类
        NativeSQLBuilder nativeSQLBuilder = NativeSQLBuilder.build(CatecommTssDatadictDto.class).
                setSql("select dict_id dictId, dict_tp_code dictTpCode, dict_tp_value dictTpValue, dict_sort dictSort, " +
                        "state state, dd_status ddStatus from catecomm_tss_datadict where 1=1 ")
                .appendIfOpt(" and dic_type = #{dicType}", "dicType", info.getDicType())
                .appendIfOpt(" and project_id = #{projectId}", "projectId", projectId).append("ORDER BY dict_sort, updated_time desc");

        nativeSQLBuilder.setPage(pageNo, pageSize);
        PagedList pagedList = autoBaseDao.listPage(nativeSQLBuilder);


        return ModelPagedList.convertToModelPage(pagedList);
    }

    /**
     * 自动生成字典键值
     *
     * @param info
     * @return
     */
    @Override
    public String makeCode(CatecommTssDatadictVo info) {
        Integer id = supplierServiceFeign.getTableId(2L, "catecomm_tss_datadict",1);
        String code = info.getDicType().toString() + id;
        return code;
    }

    /**
     * 字典新增
     *
     * @param info
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addData(CatecommTssDatadictVo info, Long projectId, Long accountId) {
        if ("150".equals(info.getDicType())) {
            NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CatecommTssDatadictModel.class)
                    .setSql("select * from catecomm_tss_datadict where dd_status = 1 and project_id = " + projectId + "\n")
                    .append(" and dic_type  = " + info.getDicType());
            CatecommTssDatadictModel oldDatad = (CatecommTssDatadictModel) autoBaseDao.findOne(queryBuilder);
            if (null != oldDatad) {
                throw new RpcException(300, ErrorCode.PRODUCT_NAME_REPEAT + "只能存在一个有效的合同编码规则！", null);
            }
        }
        CatecommTssDatadictModel caterModel = null;
        caterModel.setProjectId(projectId);
        caterModel.setUdictId(1);
        caterModel.setDictId(supplierServiceFeign.getTableId(projectId, "catecomm_tss_datadict",1));
        caterModel.setCreater(accountId);
        autoBaseDao.save(caterModel);
    }

    /**
     * 字典编辑
     *
     * @param info
     * @param projectId
     */
    @Override
    public void updateData(CatecommTssDatadictVo info, Long projectId, Long accountId) {
        CatecommTssDatadictModel caterModel = null;//Convert.convertOnlyMatch(info, CatecommTssDatadictModel.class);
        UpdateBuilder updateBuilder = UpdateBuilder.build(CatecommTssDatadictModel.class).setBean(caterModel).whereEq("projectId", projectId)
                .whereEq("dict_id", info.getDictId());
        autoBaseDao.update(updateBuilder);
    }

    /**
     * 字典查看
     *
     * @param info
     * @param projectId
     * @return
     */
    @Override
    public CatecommTssDatadictDto findData(CatecommTssDatadictVo info, Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CatecommTssDatadictDto.class).setSql("select * from catecomm_tss_datadict where project_id = "+projectId)
                .appendIfOpt("and dict_id  = #{dictId}", "dictId", info.getDictId());
        return (CatecommTssDatadictDto) autoBaseDao.findOne(queryBuilder);
    }

    @Override
    public CatecommTssDatadictDto findDataByCode(Integer dictTpCode, Long projectId) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(CatecommTssDatadictDto.class).setSql("select * from catecomm_tss_datadict where project_id = "+projectId +" and dict_tp_code  = "+dictTpCode+"");
        return (CatecommTssDatadictDto) autoBaseDao.findOne(queryBuilder);
    }

}
