package com.supper.controller;


import com.supper.service.AreaService;
import com.supper.service.SupplierService;
import modelpojo.AccountBaseConroller;
import modelpojo.ResponseInfo;
import modelpojo.model.CommodityTcbSupplierModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商控制器
 *
 * @author lixiang
 * @Date 2019-08-23 11:14:50
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SupplierService supplierService;

    @Autowired
    AreaService areaApi;

    /**
     * 获取供应商数据列表
     */
    @RequestMapping(value = "/getSuppList")
    @ResponseBody
    public ResponseInfo getSuppList(CommodityTcbSupplierModel query, int pageNo, int pageSize, String orderBy) {
        query.setProjectId(getOrgId());
        query.setProjectRootId(getCompanyId());
        return ResponseInfo.success(supplierService.getSuppList(query, pageNo, pageSize, orderBy));
    }

    /**
     * 获取供应商数据列表
     */
    @RequestMapping(value = "/getSuppContractList")
    @ResponseBody
    public ResponseInfo getSuppContractList(CommodityTcbSupplierModel query,int moduleId, int pageNo, int pageSize, String orderBy) throws Exception {
        query.setProjectId(getOrgId());
        query.setProjectRootId(getCompanyId());
        return ResponseInfo.success(supplierService.getSuppContractList(query, moduleId, pageNo, pageSize, orderBy));
    }


    /**
     * 删除/淘汰供应商接口
     */
    @RequestMapping(value = "/operation")
    @ResponseBody
    public ResponseInfo operation(Integer suppId, String status) {
        try {
            supplierService.operation(suppId, status, getAccountId(), getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 编辑供应商数据查询
     */
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public ResponseInfo selectById(Integer suppId) {
        return ResponseInfo.success(supplierService.queryById(suppId, getOrgId()));
    }


    /**
     * 新增/修改保存供应商
     */
    @RequestMapping(value = "/saveSupplier")
    @ResponseBody
    public ResponseInfo saveSupplier(CommodityTcbSupplierModel commodityTcbSupplier) {
        commodityTcbSupplier.setProjectRootId(getCompanyId());
        commodityTcbSupplier.setProjectId(getOrgId());
        try {
            supplierService.saveSupplier(commodityTcbSupplier, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     *供应商单个/批量审核
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public ResponseInfo examine(String suppIds, String status) {
        try {
            supplierService.examine(suppIds, getAccountId(), status,  getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 查询供应商编号是否重复
     */
    @RequestMapping(value = "/getIsSuppCode")
    @ResponseBody
    public ResponseInfo getIsSuppCode(String suppCode) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        int isRepeatCount = 0;
        if (null != supplierService.getIsSuppCode(suppCode)) {
            isRepeatCount = 1;
        }
        map.put("isRepeatCount", isRepeatCount);
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }


    /**
     * 查询供应商名称是否重复
     */
    @RequestMapping(value = "/checkSupperName")
    @ResponseBody
    public ResponseInfo checkSupperName(String supperName, Integer suppId) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        int isRepeatCount = 0;
        if (null != supplierService.checkSupperName(supperName, getOrgId(), suppId)) {
            isRepeatCount = 1;
        }
        map.put("isRepeatCount", isRepeatCount);
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }

    /**
     * 编辑供应商商品数据查询
     */
    @RequestMapping(value = "/getCommodity")
    @ResponseBody
    public ResponseInfo getCommodity(Integer suppId, int pageNo, int pageSize) {
        return ResponseInfo.success(supplierService.getCommodity(suppId, getOrgId(), pageNo, pageSize));
    }

    /**
     * 编辑供应商原材料数据查询
     */
    @RequestMapping(value = "/getRawmater")
    @ResponseBody
    public ResponseInfo getRawmater(Integer suppId, int pageNo, int pageSize) {
        return ResponseInfo.success(supplierService.getRawmater(suppId, getOrgId(), pageNo, pageSize));
    }

    /**
     * 查询所有供应商数据
     */
    @RequestMapping(value = "/selectSupplier")
    @ResponseBody
    public   List<CommodityTcbSupplierModel>  selectSupplier(Long projectId) {
        return supplierService.selectSupplier(projectId);
    }


    @RequestMapping(value = "/getTableId")
    @ResponseBody
    public Integer getTableId(Long projectId, String tableName, int number){
        return supplierService.getTableId(projectId,tableName,number);
    }

    /**
     * 获取id接口结果集
     * @param projectId 项目id
     * @param tableName 表名
     * @param number 生成id数量
     * @return
     */
    @RequestMapping(value = "/getTableIds")
    @ResponseBody
    List<Integer> getTableIds(Long projectId, String tableName, int number){
        return supplierService.getTableIds(projectId,tableName,number);

    }



    /**
     * 查询所有供应商数据-分页
     * @param suppNameOrCode
     * @return
     */
    @RequestMapping(value = "/selectSupplierByName")
    @ResponseBody
    public ResponseInfo selectSupplierByName(String suppNameOrCode,Integer pageNo,Integer pageSize) {
        return ResponseInfo.success(supplierService.selectSupplierByName(getOrgId(),suppNameOrCode,pageNo,pageSize));
    }

    /**
     *供应商生成编号接口getSuppCode
     */
    @RequestMapping(value = "/getSuppCode")
    @ResponseBody
    public ResponseInfo getSuppCode() {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("suppCode", supplierService.getSuppCode());
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }


    /**
     *1.14	供应商账期查询接口
     */
    @RequestMapping(value = "/getPeriod")
    @ResponseBody
    public ResponseInfo getPeriod() {
        return ResponseInfo.success(supplierService.getPeriod("账期", getOrgId()));
    }


    /**
     *获取省份接口
     */
    @RequestMapping(value = "/getProvinceList")
    @ResponseBody
    public ResponseInfo getProvinceList() {
        return ResponseInfo.success(areaApi.getProvinceList());
    }


    /**
     *获取城市接口
     */
    @RequestMapping(value = "/getCityList")
    @ResponseBody
    public ResponseInfo getCityList(String provinceid) {
        return ResponseInfo.success(areaApi.getCityList(provinceid));
    }


    /**
     *获取区域接口
     */
    @RequestMapping(value = "/getAreaList")
    @ResponseBody
    public ResponseInfo getAreaList(String cityid) {
        return ResponseInfo.success(areaApi.getAreaList(cityid));
    }

}
