package com.changshang.feign.adjust;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="goods")
@RequestMapping("/saleadjust")
public interface SaleadJustFeign {

    @RequestMapping("/sysGetBillCode")
    public String sysGetBillCode(@RequestParam Long projectId,@RequestParam String tableName);
}
