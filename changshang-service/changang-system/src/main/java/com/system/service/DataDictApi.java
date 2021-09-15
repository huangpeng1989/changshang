package com.system.service;


import com.github.pagehelper.PageInfo;
import entity.ModelPagedList;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;

public interface DataDictApi {


    PageInfo<CatecommTssDatadictDto> selectDataList(CatecommTssDatadictVo info, Integer pageNo, Integer pageSize, Long projectId);

    ModelPagedList selectDataDetailList(CatecommTssDatadictVo info, Integer pageNo, Integer pageSize, Long projectId);

    String makeCode(CatecommTssDatadictVo info);

    void addData(CatecommTssDatadictVo info,  Long projectId,Long accountId);

    void updateData(CatecommTssDatadictVo info,  Long projectId,Long accountId);

    CatecommTssDatadictDto findData(CatecommTssDatadictVo info, Long projectId);

     CatecommTssDatadictDto findDataByCode(Integer dictTpCode, Long projectId);


    }
