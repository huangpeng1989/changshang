package com.supper.service.impi;


import com.supper.service.AreaService;
import modelpojo.model.SysAreasModel;
import modelpojo.model.SysCitiesModel;
import modelpojo.model.SysProvincesModel;
import org.lufei.ibatis.builder.NativeSQLBuilder;
import org.lufei.ibatis.dao.AutoBaseDao;
import org.lufei.ibatis.dao.AutoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/11
 */
@Service
public class AreaServiceImpl implements AreaService {
    private AutoBaseDao autoBaseDao = new AutoDaoImpl();

    @Override
    public List<SysProvincesModel> getProvinceList() {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(SysProvincesModel.class).setSql("SELECT * FROM sys_provinces \n" );
        return autoBaseDao.listAll(queryBuilder);
    }

    @Override
    public List<SysCitiesModel> getCityList(String provinceid) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(SysCitiesModel.class)
                .setSql("SELECT * FROM sys_cities WHERE provinceid = " + provinceid);
        return autoBaseDao.listAll(queryBuilder);
    }

    @Override
    public List<SysAreasModel> getAreaList(String cityid) {
        NativeSQLBuilder queryBuilder = NativeSQLBuilder.build(SysAreasModel.class)
                .setSql("SELECT * FROM sys_areas WHERE cityid = " + cityid);
        return autoBaseDao.listAll(queryBuilder);
    }
}
