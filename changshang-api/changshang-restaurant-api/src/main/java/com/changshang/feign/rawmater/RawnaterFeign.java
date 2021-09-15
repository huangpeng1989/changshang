package com.changshang.feign.rawmater;

import entity.ModelPagedList;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @PackageName:com.changshang.feign.rawmater
 * @ClassName:RawnaterFeign
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 9:26
 */
@FeignClient(value="restaurant")
@RequestMapping("/rawmater")
public interface RawnaterFeign {

    @RequestMapping("/saveBasicDataLog")
    int saveBasicDataLog(@RequestParam Long projectId,@RequestParam Integer infoId,@RequestParam Integer dataType,@RequestParam Integer logType,@RequestParam String Content
            ,@RequestParam Long accId);



}