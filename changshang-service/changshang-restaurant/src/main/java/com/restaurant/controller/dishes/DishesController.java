package com.restaurant.controller.dishes;


import com.alibaba.fastjson.JSON;

import com.changshang.feign.allocation.CollarUseFeign;
import com.restaurant.service.dishes.DishesService;
import com.restaurant.service.rawmater.RawmaterApi;
import excel.Excel;
import excel.ExcelUtil;
import modelpojo.AccountBaseConroller;
import modelpojo.ErrorCode;
import modelpojo.GatherUtilExcel;
import modelpojo.ResponseInfo;
import modelpojo.model.*;
import modelpojo.vo.DishesDto;
import modelpojo.vo.saleadjust.DishesExeclVo;
import modelpojo.vo.saleadjust.DishesResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 菜品信息管理控制器
 *
 * @author lixiang
 * @Date 2019-09-04 13:14:50
 */
@Controller
@RequestMapping("/dishes")
public class DishesController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DishesService dishesService;

    @Autowired
    CollarUseFeign collarUseService;

    @Autowired
    RawmaterApi rawmaterApi;

    private int NUM = 1;

    /**
     * 菜品信息数据列表
     */
    @RequestMapping(value = "/getDishesList")
    @ResponseBody
    public ResponseInfo getDishesList(DishesDto query, int pageNo, int pageSize, String orderBy) {
        query.setProjectId(getOrgId());
        query.setProjectRootId(getCompanyId());
        return ResponseInfo.success(dishesService.getDishesList(query, pageNo, pageSize, orderBy, 0));
    }


    /**
     * 删除菜品信息接口
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseInfo delete(Integer dishId) {
        try {
            dishesService.delete(dishId, getOrgId(), 0, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 编辑菜品信息数据查询
     */
    @RequestMapping(value = "/selectById")
    @ResponseBody
    public ResponseInfo selectById(Integer dishId) {
        return ResponseInfo.success(dishesService.queryById(dishId, getOrgId(),0));
    }


    /**
     * 新增/修改保存菜品信息
     */
    @RequestMapping(value = "/saveDishes")
    @ResponseBody
    public ResponseInfo saveDishes(@RequestBody DishesDto dishesDto) {
        dishesDto.setProjectRootId(getCompanyId());
        dishesDto.setProjectId(getOrgId());
        try {
            dishesService.saveDishes(dishesDto, getAccountId(), 0);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     *菜品信息单个/批量审核
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public ResponseInfo examine(String dishIds, String status) {
        try {
            dishesService.examine(dishIds, getAccountId(), getOrgId(), status);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     *菜品淘汰
     */
    @RequestMapping(value = "/eliminate")
    @ResponseBody
    public ResponseInfo eliminate(Integer dishId, Integer status) {
        try {
            dishesService.eliminate(dishId, getAccountId(), getOrgId(), status);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }



    /**
     * 查询菜品编号是否重复
     */
    @RequestMapping(value = "/getIsDishCode")
    @ResponseBody
    public ResponseInfo getIsDishCode(String dishCode) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        int isRepeatCount = 0;
        if (null != dishesService.getIsDishCode(dishCode, getOrgId())) {
            isRepeatCount = 1;
        }
        map.put("isRepeatCount", isRepeatCount);
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }


    /**
     * 查询菜品名称是否重复
     */
    @RequestMapping(value = "/checkDishName")
    @ResponseBody
    public ResponseInfo checkDishName(String dishName, Integer dishId,Integer dishType) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        int isRepeatCount = 0;
        if (null != dishesService.checkDishName(dishName, getOrgId(), dishId,dishType)) {
            isRepeatCount = 1;
        }
        map.put("isRepeatCount", isRepeatCount);
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }



    /**
     *菜品生成编号接口
     */
    @RequestMapping(value = "/getDishCode")
    @ResponseBody
    public ResponseInfo getDishCode() {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("dishCode", dishesService.getDishCode());
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }


    /**
     *菜品类型查询接口
     */
    @RequestMapping(value = "/getPeriod")
    @ResponseBody
    public List<CatecommTssPubdatadictModel> getPeriod(String type) {
        return dishesService.getPeriod(type);
    }


    /**
     *菜品规格查询接口
     */
    @RequestMapping(value = "/getPell")
    @ResponseBody
    public ResponseInfo getPell() {
        return ResponseInfo.success(dishesService.getPell("菜品规格", getOrgId()));
    }

    /**
     *菜品单位查询接口
     */
    @RequestMapping(value = "/getCompany")
    @ResponseBody
    public ResponseInfo getCompany() {
        return ResponseInfo.success(dishesService.getPeriod("菜品单位"));
    }

    /**
     *获取税率接口
     */
    @RequestMapping(value = "/getTax")
    @ResponseBody
    public ResponseInfo getTax() {
        return ResponseInfo.success(dishesService.getTax(getOrgId()));
    }

    /**
     *获取口味信息接口
     */
    @RequestMapping(value = "/getDishTasteList")
    @ResponseBody
    public ResponseInfo getDishTasteList(Integer dishId) {
        return ResponseInfo.success(dishesService.getDishTasteList(getOrgId(), dishId));
    }

    /**
     * 新增/修改保存口味
     *//*
    @RequestMapping(value = "/saveDishTaste")
    @ResponseBody
    @NoneLogin
    public ResponseInfo saveDishTaste(CateringTcbDishTasteModel query) {
        query.setProjectId(getOrgId().intValue());
        CateringTcbDishTasteModel cateringTcbDishTasteModel = null;
        try {
            cateringTcbDishTasteModel = dishesService.saveDishTaste(query, getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(cateringTcbDishTasteModel);
    }
*/

    /*    *//**
     * 删除口味接口
     *//*
    @RequestMapping(value = "/deleteDishTaste")
    @ResponseBody
    @NoneLogin
    public ResponseInfo deleteDishTaste(Integer dishTasteId) {
        try {
            dishesService.deleteDishTaste(getOrgId().intValue(), dishTasteId);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }*/

    /**
     * 菜品信息组数据列表
     */
    @RequestMapping(value = "/getDishesGroupList")
    @ResponseBody
    public ResponseInfo getDishesGroupList(DishesDto query) {
        query.setProjectId(getOrgId());
        query.setProjectRootId(getCompanyId());
        return ResponseInfo.success(dishesService.getDishesGroupList(query));
    }

    /**
     *菜品添加备注
     */
    @RequestMapping(value = "/editRemark")
    @ResponseBody
    public ResponseInfo editRemark(CateringTcbDishesModel query) {
        try {
            query.setProjectId(getOrgId());
            query.setModifier(getAccountId());
            dishesService.editRemark(query);
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /*****
     *
     * @param response
     */
    @RequestMapping("/exportDish")
    @ResponseBody
    public  void exportDish(HttpServletResponse response, HttpServletRequest request, String dishIds, DishesDto query) {
        NUM = 1;
        try {
            String loseCellName ="序号,菜品一级分类,菜品二级分类,菜品三级分类,菜品名称,菜品类型,菜品单位,经营方式,Bom信息,口味信息,联营折扣率,联营商家,销项税税率,销售价格-大份,审核状态";
            //List<String> dishId = Arrays.asList(dishIds.split(",")).stream().map(s -> (s.trim())).collect(Collectors.toList());
            query.setProjectId(getOrgId());
            query.setProjectRootId(getCompanyId());
            String[] loseTitle = loseCellName.split(",");
            List<Object> info1 = new ArrayList<>();
            List<DishesDto> dishesDto = dishesService.queryByIds(query, dishIds, 0);
            dishesDto.forEach(a -> {
                List<Object> info = new ArrayList<>();
                info.add(NUM++);
                info.add(StringUtils.isNotEmpty(a.getCateClassNameOne()) ? a.getCateClassNameOne() : "-");
                info.add(StringUtils.isNotEmpty(a.getCateClassNameTwo()) ? a.getCateClassNameTwo() : "-");
                info.add(StringUtils.isNotEmpty(a.getCateClassNameThree()) ? a.getCateClassNameThree() : "-");
                info.add(StringUtils.isNotEmpty(a.getDishName()) ? a.getDishName() : "");
                info.add(StringUtils.isNotEmpty(a.getTypeName()) ? a.getTypeName() : "");
                info.add(StringUtils.isNotEmpty(a.getUnitName()) ? a.getUnitName() : "");
                info.add(StringUtils.isNotEmpty(a.getSellModelName()) ? a.getSellModelName() : "");
                info.add(StringUtils.isNotEmpty(a.getIsBom()) ? a.getIsBom() : "");
                info.add(StringUtils.isNotEmpty(a.getTaste()) ? a.getTaste() : "");
                info.add(null != a.getDiscountRate() && a.getDiscountRate().compareTo(BigDecimal.ZERO) != 0 ? a.getDiscountRate() : "");
                info.add(StringUtils.isNotEmpty(a.getSuppName()) ? a.getSuppName() : "");
                info.add(StringUtils.isNotEmpty(a.getTaxName()) ? a.getTaxName() : "");
                if (StringUtils.isNotEmpty(a.getSpecStr())) {
                    // String[] specs = a.getSpecStr().split(",");
                    info.add(a.getSpecStr().split("-")[1]);
                    /*if (specs.length == 3) {
                        info.add(specs[0].split("-")[1]);
                        info.add(specs[1].split("-")[1]);
                        info.add(specs[2].split("-")[1]);
                    }
                    if (specs.length == 2) {
                        info.add(specs[0].split("-")[1]);
                        info.add(specs[1].split("-")[1]);
                        info.add("-");
                    }
                    if (specs.length == 1) {
                        info.add(specs[0].split("-")[1]);
                        info.add("-");
                        info.add("-");
                    }*/
                } else {
                    info.add(a.getMealPrice() != null && a.getMealPrice().compareTo(BigDecimal.ZERO)!= 0 ? a.getMealPrice() : BigDecimal.ZERO);
                   /* info.add("-");
                    info.add("-");*/
                }
                info.add(a.getStatusName());
                info1.add(info);

            });

            String date = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
            //文件名
            String fileName = "菜品信息_"+date + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }

            Map<String, Object> map = new HashMap<>();
            map.put("title", loseTitle);
            map.put("list", info1);
            map.put("index", 1);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *菜品修改上传图片
     */
    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public ResponseInfo uploadImage(List<CateringTcbDishimgsModel> dishimgsModels) {
        try {
            dishesService.uploadImage(dishimgsModels, getAccountId(), getOrgId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     *菜品生成条码接口
     */
    @RequestMapping(value = "/getBarCode")
    @ResponseBody
    public ResponseInfo getBarCode() {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("barCode", collarUseService.getBarCode(getOrgId(), 20, 0, 1, 0, 4));
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }

    /**
     * 查询菜品条码是否重复
     */
    @RequestMapping(value = "/checkIsBarCode")
    @ResponseBody
    public ResponseInfo checkIsBarCode(String barCode) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String,Object> map = new HashMap<String, Object>();
        int isRepeatCount = 0;
        if (null != dishesService.getIsBarCode(barCode, getOrgId())) {
            isRepeatCount = 1;
        }
        map.put("count", isRepeatCount);
        responseInfo.setData(map);
        responseInfo.setSuccess(true);
        responseInfo.setCode("200");
        return responseInfo;
    }


    /**
     * 菜品 导入模板
     * @param request
     * @param response
     */
    @RequestMapping("/getDishExcelTemplate")
    @ResponseBody
    public void getDishExcelTemplate(HttpServletRequest request, HttpServletResponse response){
        String fileName = "菜品信息(成品)导入模版.xlsx"; //模板名称
        String[] handers = {"*菜品分类","*菜品名称","包装费","*预估价格","*菜品单位","*销项税税率","条码","*经营方式","联营扣率","联营合同编号","标准成本率","口味名称","口味类别","备注"}; //列标题

        //下拉框数据
        List<String[]> downData = new ArrayList<String[]>();


        StringBuffer classReslutBuf = new StringBuffer();
        StringBuffer sellModelBuf = new StringBuffer();
        StringBuffer unitResultBuf = new StringBuffer();
        StringBuffer tsbTaxResultBuf = new StringBuffer();

        // 菜品分类数据（菜品分类编号--菜品分类名称）
        List<CateringTccDishesClassModel> allDisheClass = dishesService.getAllDisheClass(this.getOrgId()); // 最大父类
        if (null != allDisheClass && allDisheClass.size() > 0) {
            allDisheClass.forEach(a -> {
                List<CateringTccDishesClassModel> secondDisheClass = dishesService.queryDishClassByDishClassId(a.getDishId(), this.getOrgId());
                if (null != secondDisheClass && secondDisheClass.size() > 0) {
                    secondDisheClass.forEach(b -> {
                        List<CateringTccDishesClassModel> lastDisheClass = dishesService.queryDishClassByDishClassId(b.getDishId(), this.getOrgId());
                        if (null != lastDisheClass && lastDisheClass.size() > 0) {
                            lastDisheClass.forEach(c -> {
                                classReslutBuf.append(c.getDishClassCode() + "-" + a.getDishClassName() + "/" + b.getDishClassName() + "/" +  c.getDishClassName()).append(",");
                            });
                        } else {
                            classReslutBuf.append(b.getDishClassCode() + "-" + a.getDishClassName() + "/" + b.getDishClassName()).append(",");
                        }

                    });
                } else {
                    classReslutBuf.append(a.getDishClassCode() + "-" + a.getDishClassName()).append(",");
                }
            });
        }

        String s4 = classReslutBuf.toString();
        String[] classReslut = s4.split(",");



        // 经营方式
        sellModelBuf.append("自营").append(",").append("联营");
        String s5 = sellModelBuf.toString();
        String[] sellModelResult = s5.split(",");

        // 菜品单位 （字典表菜品单位编号--字典表菜品单位名称）
        List<CatecommTssPubdatadictModel> pubdatadictModelList = rawmaterApi.queryRmUnit(112);
        pubdatadictModelList.forEach(a->{
            unitResultBuf.append(a.getTypeName()).append(",");
        });
        String s2 = unitResultBuf.toString();
        String[] unitResult = s2.split(",");

        // 销项税税率  （税率表ID--税率表名称）
        List<CatecommTsbTax> tsbTaxList = rawmaterApi.getCatecommTsbTax(null, this.getOrgId());
        tsbTaxList.forEach(a->{
            tsbTaxResultBuf.append(a.getTaxName()).append(",");
        });
        String s = tsbTaxResultBuf.toString();
        String[] tsbTaxResult = s.split(",");

        downData.add(classReslut);
        downData.add(unitResult);   // 菜品单位
        downData.add(tsbTaxResult);   // 销项税税率
        downData.add(sellModelResult);//经营方式

        String [] downRows = {"0","4","5","7"}; //下拉的列序号数组(序号从0开始)

        String name = "菜品(成品)模版";

        try {

            ExcelUtil.createExcelTemplate(fileName, handers, downData, downRows, name,request, response);

        } catch (Exception e) {
            System.out.println("异常捕获 "+e.getMessage());
            log.error("批量导入信息异常：" + e.getMessage());
        }
    }

    /**
     *@Description 预计导入菜品信息
     *@param
     *@return
     *@data 2020-11-27-17:01
     *@auther lixiang
     */
    @ResponseBody
    @RequestMapping("importDishes")
    public ResponseInfo importDishes(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            try {
                Excel<DishesExeclVo> excel = ExcelUtil.resolverExcel(file.getInputStream(), fileName.substring(fileName.lastIndexOf(".") + 1), DishesExeclVo.class);
                if (CollectionUtils.isEmpty(excel.getErrorInfos())) {
                    return ResponseInfo.success(dishesService.preImportDishes(excel, this.getOrgId(), this.getCompanyId(), this.getAccountId()));
                } else {
                    return ResponseInfo.error(ErrorCode.EXCEL_CONTENT_ERROR, JSON.toJSONString(excel.getErrorInfos()));
                }
            } catch (Exception e) {
                logger.error("解析Excel异常:{}", e.getMessage(), e);
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, e.getMessage());
            }
        } else {
            return ResponseInfo.error(ErrorCode.EXCEL_FARMAT_ERROR, "导入文件仅支持Excel文件");
        }
    }


    /**
     *@Description 预计导入菜品信息
     *@param
     *@return
     *@date 20120-11-30 09:00
     *@auther lixiang
     */
    @ResponseBody
    @RequestMapping("listImportDishes")
    public ResponseInfo listImportDishes(String redisKey, Integer pageNo, Integer pageSize, Integer type) {
        DishesResponse execlMessages = null;
        try{
            execlMessages = dishesService.listImportDishes(redisKey, pageNo, pageSize, type, this.getOrgId(), this.getCompanyId(), this.getAccountId());
        }catch (Exception e){
            log.error("菜品预导入列表接口异常" + e.getMessage());
            return ResponseInfo.error("300", "菜品预导入列表接口异常" + e.getMessage());
        }
        return ResponseInfo.success(execlMessages);
    }

    /**
     * 批量提交
     */
    @RequestMapping(value = "/batchCommit")
    @ResponseBody
    public ResponseInfo batchCommit(String dishIds) {
        try {
            dishesService.batchCommit(dishIds, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 反审操作
     */
    @RequestMapping(value = "/counterTrial")
    @ResponseBody
    public ResponseInfo counterTrial(Integer dishId) {
        try {
            dishesService.counterTrial(dishId, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     * 菜品成本对比查询
     */
    @RequestMapping(value = "/dishesCostContrast")
    @ResponseBody
    public ResponseInfo dishesCostContrast(Integer gzoneId,String dishName,Integer pageNo, Integer pageSize) {
        try {
            return ResponseInfo.success(dishesService.dishesCostContrast(getOrgId(), getAccountId(),gzoneId,dishName,pageNo,pageSize));
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
    }

    /**
     * 菜品成本对比导出
     */
    @RequestMapping(value = "/exportDishesCostContrast")
    @ResponseBody
    public void exportDishesCostContrast(HttpServletRequest request, HttpServletResponse response,Integer gzoneId,String dishName) {
        try {
            List<Object> info1 = new ArrayList<>();
            String[] cellName={"序号","营业点编码","营业点名称","菜品编号","菜品名称" ,"成本价","标准售价",
                    "菜品售价","成本率","销项税率"};
            SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
            String feileName = format.format(new Date())+"菜品成本对比报表信息.xls";

            List<TreeMap> list = dishesService.dishesCostContrast(getOrgId(), getAccountId(),gzoneId,dishName,1,1000000).getData();
            Integer index = 0;
            for (TreeMap item : list) {
                index ++;
                List<Object> info = new ArrayList<>();
                info.add(index);
                info.add(item.get("gzoneCode") !=null ? item.get("gzoneCode"):"");
                info.add(item.get("gzoneName") !=null ? item.get("gzoneName"):"");
                info.add(item.get("dishCode") !=null ? item.get("dishCode"):"");
                info.add(item.get("dishName") !=null ? item.get("dishName"):"");
                info.add(item.get("dishSum") !=null ? item.get("dishSum"):"");
                info.add(item.get("standardPrice") !=null ? item.get("standardPrice"):"");
                info.add(item.get("retailPrice") !=null ? item.get("retailPrice"):"");
                info.add(item.get("currentCostRate") !=null ? item.get("currentCostRate"):"");
                info.add(item.get("taxName") !=null ? item.get("taxName"):"");
                info1.add(info);
            }
            Workbook wb = null;
            String extension = feileName.substring(feileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            Map<String,Object> map= new HashMap<>();
            map.put("title",cellName);
            map.put("list",info1);
            map.put("fileName",feileName);
            map.put("index",1);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map,wb,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
