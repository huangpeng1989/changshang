package com.changshang.feign.adjust;

import modelpojo.ResponseInfo;
import modelpojo.model.CatecommTsbTax;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @PackageName:com.changshang.feign.adjust
 * @ClassName:AdjustFeign
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 11:26
 */
@FeignClient(value="goods")
@RequestMapping("/adjust")
public interface AdjustFeign {

    @RequestMapping("/getTsbTaxInfo")
    public List<CatecommTsbTax> getTsbTaxInfo(@RequestParam Integer taxId,@RequestParam Integer status);
}
