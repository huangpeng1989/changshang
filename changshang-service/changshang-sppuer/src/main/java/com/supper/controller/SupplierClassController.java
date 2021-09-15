package com.supper.controller;

import com.supper.service.SupplierClassService;
import modelpojo.AccountBaseConroller;
import modelpojo.ResponseInfo;
import modelpojo.model.CommodityTccSuppclassModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供应商分类控制器
 *
 * @author lixiang
 * @Date 2019-08-23 11:14:50
 */
@Controller
@RequestMapping("/supplierClass")
public class SupplierClassController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SupplierClassService supplierClassService;

    /**
     * 获取供应商分类树形结构
     */
    @RequestMapping(value = "/supplierClassList")
    @ResponseBody
    public ResponseInfo supplierClassList() {
        return ResponseInfo.success(supplierClassService.supplierClassTree(getOrgId()));
    }


    /**
     * 新增/修改保存供应商分类
     */
    @RequestMapping(value = "/saveSupplierClass")
    @ResponseBody
    public ResponseInfo saveSupplierClass(CommodityTccSuppclassModel commodityTccSuppClass) {
        commodityTccSuppClass.setProjectId(getOrgId());
        commodityTccSuppClass.setProjectRootId(getCompanyId());
        try {
            supplierClassService.saveSupplierClass(commodityTccSuppClass, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 编辑供应商分类数据查询
     */
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public ResponseInfo selectById(Integer supperId) {
        return ResponseInfo.success(supplierClassService.queryById(supperId, getOrgId()));
    }

    /**
     * 供应商分类删除
     */
    @RequestMapping(value = "/delect")
    @ResponseBody
    public ResponseInfo delect(String suppClassCode) {
        try {
            supplierClassService.deleteSupplierClass(suppClassCode, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     * 供应商分类(最大父类)接口
     */
    @RequestMapping(value = "/getFSupplierClass")
    @ResponseBody
    public ResponseInfo getFSupplierClass() {
        return ResponseInfo.success(supplierClassService.queryFSuppClass(getOrgId()));
    }



    /**
     * 供应商分类编号生成接口
     * @param uSupperId 上级分类id
     */
    @RequestMapping(value = "/getSuppClassCode")
    @ResponseBody
    public ResponseInfo getSuppClassCode(Integer uSupperId) {
        return ResponseInfo.success(supplierClassService.getSuppClassCode(uSupperId, getOrgId()));

    }



    /**
     * 获取供应商分类(子类)接口
     *
     */
    @RequestMapping(value = "/getSSupplierClass")
    @ResponseBody
    public ResponseInfo getSSupplierClass(Integer uSupperId) {
        return ResponseInfo.success(supplierClassService.querySSuppClass(uSupperId, getOrgId()));
    }

}
