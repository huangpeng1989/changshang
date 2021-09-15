package com.changshang.feign;

import entity.Result;
import modelpojo.ResponseInfo;
import modelpojo.model.CommodityTcbSupplierModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="supper")
@RequestMapping("/supplier")
public interface SupplierServiceFeign {

    /*
   根据分类的ID 获取到广告列表
    */
    @RequestMapping(value = "/getTableId")
    Integer getTableId(@RequestParam Long projectId,@RequestParam  String tableName,@RequestParam  int number);

    @RequestMapping(value = "/getTableIds")
    List<Integer> getTableIds(@RequestParam Long projectId,@RequestParam  String tableName,@RequestParam  int number);
    /**
     * 查询所有的供应商
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/selectSupplier")
    List<CommodityTcbSupplierModel> selectSupplier(@RequestParam  Long projectId);
}
