package com.changshang.feign.allocation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value="goods")
@RequestMapping("/collarUse")
public interface CollarUseFeign {

    @RequestMapping(value = "/getBarCode")
    Map<String, Object> getBarCode(@RequestParam Long projectId,@RequestParam Integer moduleId,@RequestParam Integer primaryKey, @RequestParam Integer billType,@RequestParam Integer billId, @RequestParam Integer resultType);
}
