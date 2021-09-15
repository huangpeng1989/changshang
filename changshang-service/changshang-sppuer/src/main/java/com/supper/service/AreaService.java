package com.supper.service;


import modelpojo.model.SysAreasModel;
import modelpojo.model.SysCitiesModel;
import modelpojo.model.SysProvincesModel;

import java.util.List;

/**
 * <h3>description</h3>
 * create by renyu on 2018/9/11
 */
public interface AreaService {
    List<SysProvincesModel> getProvinceList();

    List<SysCitiesModel> getCityList(String provinceid);

    List<SysAreasModel> getAreaList(String cityid);
}
