package com.changshang.feign.dish;

import modelpojo.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @PackageName:com.changshang.feign.dish
 * @ClassName:DishFeign
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 10:38
 */
@FeignClient(value="restaurant")
@RequestMapping("/rawmater")
public interface DishFeign {

    @RequestMapping(value = "/getPeriod")
    public ResponseInfo getPeriod(@RequestParam String type) ;

}
