package com.system.dao;

import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @PackageName:com.system.dao
 * @ClassName:DataSql
 * @Description
 * @author: huangpeng
 * @date:2021/9/9 11:44
 */
public class DataSql {


    public  static String selectDataList(CatecommTssDatadictVo vo, Long projectId){
         StringBuffer buffer = new StringBuffer("\n");
         buffer.append("SELECT dic_type dicType, dict_name dictName FROM catecomm_tss_datadict  WHERE project_id ="+projectId+" ");
         if(StringUtils.isNotEmpty(vo.getDictName())){
             buffer.append(" and dict_name = '"+vo.getDictName()+"'");
         }
         buffer.append(" GROUP BY dic_type");
         return  buffer.toString();
    }
}
