package com.changshang.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName:com.changshang.feign
 * @ClassName:WareJurisdictionFeign
 * @Description
 * @author: huangpeng
 * @date:2021/9/9 13:59
 */
@FeignClient(value="system")
@RequestMapping("/wareJurisdiction")
public interface WareJurisdictionFeign {

    @RequestMapping("/getAccountWareJurisdictions")
    public String getAccountWareJurisdictions(@RequestParam Long projectId, @RequestParam  Long accountId,@RequestParam int type);
}
