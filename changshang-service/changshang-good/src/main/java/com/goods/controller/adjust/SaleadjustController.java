package com.goods.controller.adjust;


import com.goods.service.adjust.SaleadjustApi;
import entity.ModelPagedList;
import modelpojo.AccountBaseConroller;
import modelpojo.GatherUtilExcel;
import modelpojo.ResponseInfo;
import modelpojo.model.ComSalePricetDto;
import modelpojo.model.CommodityTcjSaleadjustModel;
import modelpojo.vo.CommoditySaleAdjustVo;
import modelpojo.vo.saleadjust.PagerObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/*****
 * 商品售价调价Controller
 */
@Controller
@RequestMapping("saleadjust")
public class SaleadjustController extends AccountBaseConroller {

    @Autowired
    private SaleadjustApi saleadjustApi;

    private static Integer NUM = 1;



    /****
     * 售价调价维护列表查询接口
     * @param adjCode
     * @param status
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("saleadjustList")
    @ResponseBody
    public ResponseInfo saleadjustList(String adjCode, Integer status, String comName, Integer pageNo, Integer pageSize){
        PagerObject<CommodityTcjSaleadjustModel> list= saleadjustApi.saleadjustList(adjCode, status, comName, this.getOrgId(), pageNo, pageSize);
        return  ResponseInfo.success(list);
    }

    /*****
     * 根据调价单id和项目id删除对应的调价单
     * @param adjId
     * @return
     */
    @RequestMapping("delAleadjust")
    @ResponseBody
    public ResponseInfo delAleadjust(Integer adjId){
        Integer shu=saleadjustApi.delAleadjust(adjId,this.getOrgId());
        if(shu>0){
            return  ResponseInfo.success("删除成功！");
        }else{
            return  ResponseInfo.success("删除失败！");
        }
    }

    

    /*****
     *  据调价单id和项目id,审核状态来批量修改审梳状态
     * @param adjId
     * @param status
     * @return
     */
    @RequestMapping("examinationAleadjust")
    @ResponseBody
    public ResponseInfo examinationAleadjust(String adjId,  Integer status) {
        String str = "";
        try {
            str = saleadjustApi.examinationAleadjust(adjId, this.getOrgId(), status, this.getAccountId().intValue());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(str);
    }


    /******
     * 根据供应商id，商品分类编码，商品的名称或编码或条码，价格等级id查询对应的商品信息
     * @param comClassCode
     * @param cominfo
     * @param comGrade
     * @return
     */
    @RequestMapping("selectCommodity")
    @ResponseBody
    public ResponseInfo selectCommodity(String comClassCode,String cominfo,Integer comGrade,Integer pageNo,Integer pageSize){
        try {
            return  ResponseInfo.success(saleadjustApi.selectCommodity(comClassCode,cominfo,comGrade,this.getOrgId(), pageNo, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseInfo.success("查询失败："+e);
        }
    }



    /******
     * 新增调价单信息
     * @param info
     * @return
     */
    @RequestMapping("saveSaleadjust")
    @ResponseBody
    public ResponseInfo saveSaleadjust(@RequestBody CommodityTcjSaleadjustModel info){

        try {
            info.setCreater(this.getAccountId());
            info.setModifier(this.getAccountId());
            info.setProjectId(this.getOrgId());
            info.setProjectRootId(this.getCompanyId());
            Integer shu=saleadjustApi.saveSaleadjust(info);
            if(shu>0){
                return  ResponseInfo.success("新增成功！");
            }else{
                return  ResponseInfo.success("新增失败！");
            }
         }  catch (Exception e) {
              e.printStackTrace();
              return  ResponseInfo.success("新增失败！"+e);
         }
    }

    /*****
     * 根据调价售价订id和项目id查询对应的信息
     * @param adjId
     * @return
     */
    @RequestMapping("selectCommodityInfo")
    @ResponseBody
    public ResponseInfo selectCommodityInfo(Integer adjId){
         CommodityTcjSaleadjustModel model=  saleadjustApi.selectCommodityInfo(adjId,this.getOrgId());
         return  ResponseInfo.success(model);

    }



    /*****
     * 根据调价售价单id和项目id修改对应的调价售价单商品信息
     * @param info
     * @return
     */
    @RequestMapping("updeteSaleadjust")
    @ResponseBody
    public ResponseInfo updeteSaleadjust(@RequestBody CommodityTcjSaleadjustModel info){
        try {
            info.setModifier(this.getAccountId());
            info.setCreater(this.getAccountId());
            info.setProjectId(this.getOrgId());
            Integer shu=saleadjustApi.updeteSaleadjust(info);
            if(shu>0){
                return  ResponseInfo.success("修改成功！");
            }else {
                return  ResponseInfo.success("修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseInfo.error("修改失败"+e);
        }
    }

     /*****
     * 根据项目id和表名生成售价，进价单单号
     * @param tableName
     * @return
     */
    @RequestMapping("sysGetBillCode")
    @ResponseBody
    public String sysGetBillCode(Long projectId, String tableName){
        return  saleadjustApi.sysGetBillCode(projectId,tableName);
    }




    /******
     * 查询全局字典表的字典信息
     * @return
     */
    @RequestMapping("selectCateCommTssPubdatadict")
    @ResponseBody
    public ResponseInfo selectCateCommTssPubdatadict(){

        return  ResponseInfo.success(saleadjustApi.selectCatecommTssPubdatadict());
    }


    /******
     * 查询项目字典表的字典信息
     * @return
     */
    @RequestMapping("selectCatecommTssDatadict")
    @ResponseBody
    public ResponseInfo selectCatecommTssDatadict(){
        return  ResponseInfo.success(saleadjustApi.selectCatecommTssDatadict(this.getOrgId()));

    }


    /**
     * 商品售价调价查询报表列表
     *
     */
    @RequestMapping(value = "/getComSalePriceList")
    @ResponseBody
    public ResponseInfo getComSalePriceList(int pageNo, int pageSize, String comName, String date, Integer gradeId) {
        return ResponseInfo.success(saleadjustApi.getComSalePrice(pageNo, pageSize, comName, date, gradeId, getOrgId()));
    }


    /**
     * 商品售价调价报表excel导出
     */
    @RequestMapping(value = "/excelOut")
    @ResponseBody
    public void excelOut(HttpServletResponse response, HttpServletRequest request, String comName, String date, Integer gradeId) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String title[] = {"序号","价格等级","商品编号","商品名称","规格","单位","含税进价","未税进价","价格生效开始时间","价格生效结束时间"};
            String fileName =  formatter.format(new Date()) + "_商品进价明细数据" + ".xls";
            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            ModelPagedList modelPagedList = saleadjustApi.getComSalePrice(1, 100000, comName, date, gradeId, getOrgId());

            List<ComSalePricetDto> lists = modelPagedList.getData();

            List<Object> list = new ArrayList<>();
            NUM = 1;
            lists.forEach(a -> {
                List<Object> info = new ArrayList<>();
                info.add(NUM++);//序号
                info.add(a.getDictValue());
                info.add(a.getComCode());
                info.add(a.getComName());
                info.add(a.getComSpec());
                info.add(a.getComUnit());
                info.add(a.getTaxPaid());
                info.add(a.getNoTaxPaid());
                info.add(sdf.format(a.getStartDate()));
                info.add(null == a.getEndDate() ? "-" : sdf.format(a.getEndDate()));
                list.add(info);
            });
            Map<String, Object> map = new HashMap<>();
            map.put("title", title);
            map.put("list", list);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量提交
     */
    @RequestMapping(value = "/saleadjustBatchCommit")
    @ResponseBody
    public ResponseInfo saleadjustBatchCommit(String adjIds) {
        try {
            saleadjustApi.saleadjustBatchCommit(adjIds, getOrgId());
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
    public ResponseInfo counterTrial(Integer adjId) {
        try {
            saleadjustApi.counterTrial(adjId, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }

    /**
     * 商品售价调价execl 导出
     * @return
     */
    @RequestMapping("excelOutComSaleAdjust")
    @ResponseBody
    public void excelOutSaleAdjust(String adjIds, Integer adjStatus, String adjCode, String comName, HttpServletResponse response, HttpServletRequest request) {
        try {
            String loseCellName = "调价单号,开始日期,结束日期,调价类型,状态,商品编号,商品销售编号,商品名称,经营方式,商品销售单位,价格等级,原销售价格,新销售价格";

            String[] title = loseCellName.split(",");

            List<Object> info1 = new ArrayList<>();

            //文件名
            String fileName =  "商品售价价调价单" + ".xls";

            Workbook wb = null;
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extension.equals("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//创建工作薄
            }
            List<CommoditySaleAdjustVo> cateringAdjustVos = saleadjustApi.excelOutComSaleAdjust(this.getOrgId(), adjIds, adjStatus, adjCode, comName);
            cateringAdjustVos.forEach(a -> {
                List<Object> info = new ArrayList<>();
                info.add(a.getAdjCode());
                info.add(a.getStartDate());
                info.add(StringUtils.isNotEmpty(a.getEndDate()) ? a.getEndDate() : "-");
                info.add(a.getAdjType());
                info.add(a.getAdjStatus());
                info.add(a.getComCode());
                info.add(a.getSaleComCode());
                info.add(a.getComName());
                info.add(a.getSellModelStr());
                info.add(StringUtils.isNotEmpty(a.getTaxValue()) ? a.getTaxValue() : "");
                info.add(a.getGrade());
                info.add(a.getRetailPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getRetailPrice() : BigDecimal.ZERO);
                info.add(a.getNewRetailPrice().compareTo(BigDecimal.ZERO) != 0 ? a.getNewRetailPrice() : BigDecimal.ZERO);
                info1.add(info);
            });

            Map<String, Object> map = new HashMap<>();
            map.put("index", "0");
            map.put("title", title);
            map.put("list", info1);
            map.put("fileName", fileName);
            GatherUtilExcel gatherUtil = new GatherUtilExcel();
            gatherUtil.buildExcelDocument(map, wb, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
