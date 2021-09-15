package com.restaurant.controller.dishes;


import com.restaurant.service.dishes.DishesClassService;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.AccountBaseConroller;
import modelpojo.ErrorCode;
import modelpojo.ResponseInfo;
import modelpojo.model.CateringTccDishesClassModel;
import modelpojo.vo.DishClasslVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 菜品分类控制器
 *
 * @author lixiang
 * @Date 2019-09-02 13:14:50
 */
@Controller
@RequestMapping("/dishesClass")
public class DishesClassController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DishesClassService dishesClassService;

    /**
     * 菜品分类树形结构
     */
    @RequestMapping(value = "/dishesClassList")
    @ResponseBody
    public ResponseInfo supplierClassList() {
        return ResponseInfo.success(dishesClassService.dishesClassTree(getOrgId()));
    }


    /**
     * 新增/修改保存菜品分类
     */
    @RequestMapping(value = "/saveDishesClass")
    @ResponseBody
    public ResponseInfo saveSupplierClass(CateringTccDishesClassModel cateringTccDishesClass) {
        cateringTccDishesClass.setProjectId(getOrgId());
        cateringTccDishesClass.setProjectRootId(getCompanyId());
        try {
            dishesClassService.saveDishesClass(cateringTccDishesClass, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 编辑菜品分类数据查询
     */
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public ResponseInfo selectById(Integer dishId) {
        return ResponseInfo.success(dishesClassService.queryById(dishId, getOrgId()));
    }

    /**
     * 菜品分类删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseInfo delete(String dishClassCode) {
        try {
            dishesClassService.deleteDishesClass(dishClassCode, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     * 菜品分类(最大父类)接口
     */
    @RequestMapping(value = "/getFDishesClass")
    @ResponseBody
    public ResponseInfo getFSupplierClass() {
        return ResponseInfo.success(dishesClassService.queryFDishesClass(getOrgId()));
    }



    /**
     * 获取菜品分类(子类)接口
     * @param uDishId 上级分类id
     */
    @RequestMapping(value = "/getSDishesClass")
    @ResponseBody
    public ResponseInfo getSuppClassCode(Integer uDishId) {
        return ResponseInfo.success(dishesClassService.querySDishesClass(uDishId, getOrgId()));
    }



    /**
     * 菜品分类编号生成接口
     */
    @RequestMapping(value = "/getDishesClassCode")
    @ResponseBody
    public ResponseInfo getDishesClassCode(Integer uDishId) {
        return ResponseInfo.success(dishesClassService.getDishesClassCode(uDishId, getOrgId()));
    }


    /**
     *@Description 导入菜品分类
     *@param
     *@return
     *@date 2019-09-15 16:00
     *@auther lixiang
     */
    @ResponseBody
    @RequestMapping("importDisClass")
    public ResponseInfo importDisClass (MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<DishClasslVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), DishClasslVo.class);
                dishesClassService.importDisClass(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId());
                return ResponseInfo.success(null);
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }

    }


    /**
     * 菜品分类税务编码一键清空
     */
    @RequestMapping(value = "/clearTaxCode")
    @ResponseBody
    public ResponseInfo clearTaxCode() {
        try {
            dishesClassService.clearTaxCode(getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

}
