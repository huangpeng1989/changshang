package com.changshang.feign;

import entity.ModelPagedList;
import modelpojo.ResponseInfo;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value="system")
@RequestMapping("/data")
public interface DataDictFeign {


     @RequestMapping(value = "/findDataByCode")
     CatecommTssDatadictDto findDataByCode(@RequestParam Integer dictTpCode);

     /**
      * 参数设置查询
      * @param
      * @param pageNo
      * @param pageSize
      * @return
      */
     @RequestMapping(value = "/selectDataList")
     public ResponseInfo selectDataList(@RequestBody CatecommTssDatadictVo info , @RequestParam  Integer pageNo, @RequestParam Integer pageSize );
     /**
      * 参数设置类型详情查询
      *
      * @param
      * @param pageNo
      * @param pageSize
      * @return
      */
     @RequestMapping(value = "/selectDataDetailList")
     ModelPagedList selectDataDetailList(@RequestParam CatecommTssDatadictVo info,@RequestParam  Integer pageNo,@RequestParam  Integer pageSize,@RequestParam Long companyId);
}
