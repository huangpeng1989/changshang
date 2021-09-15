package com.system.dao;

import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @PackageName:com.system.dao
 * @ClassName:DataDictBiz
 * @Description
 * @author: huangpeng
 * @date:2021/9/9 11:15
 */
public interface DataDictDao extends Mapper<CatecommTssDatadictDto> {

    @SelectProvider(type = DataSql.class,method = "selectDataList")
    List<CatecommTssDatadictDto> selectDataList(CatecommTssDatadictVo vo, Long projectId);
}
