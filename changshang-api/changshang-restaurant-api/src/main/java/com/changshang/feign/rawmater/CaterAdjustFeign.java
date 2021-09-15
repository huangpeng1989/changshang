package com.changshang.feign.rawmater;

import modelpojo.vo.caterAdjust.PriceChangeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName:com.changshang.feign.rawmater
 * @ClassName:CaterAdjustFeign
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 11:42
 */
@RequestMapping("/caterAdjust")
@FeignClient(value="restaurant")
public interface CaterAdjustFeign {
    @RequestMapping("/cllPriceChangeBack")
    public PriceChangeVo cllPriceChangeBack(@RequestParam Integer moduleId,@RequestParam Integer changeType,@RequestParam String adjCode);
}
