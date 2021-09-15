package com.system.controller;


import com.system.service.WareJurisdictionService;
import modelpojo.AccountBaseConroller;
import modelpojo.ResponseInfo;
import modelpojo.vo.WareJurisdictionInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*****
 * 仓库设置Controller接口
 */
@Controller
@RequestMapping("/wareJurisdiction")
public class WareJurisdictionController extends AccountBaseConroller {

    @Autowired
    private WareJurisdictionService wareJurisdictionService;

    /**
     * 获取部门人员组织架构
     * @return
     */
    @RequestMapping("/deptCompanyList")
    @ResponseBody
    public ResponseInfo deptCompanyList(String accountName){

         return  ResponseInfo.success(wareJurisdictionService.getDeptCompany(getOrgId(), accountName));
    }


    /**
     * 根据不同的条件查询仓库分页列表信息
     * @param accountName 用户名称
     * @param pageNo
     * @param pageSize
     * @param whLevel 查询方式 1.按公司、2.按景区、3.按营业点
     * @param whName 仓库编码/名称
     * @param whClass 仓库类型（当选择按营业点查询时才传值）
     * @return
     */
    @RequestMapping("/wareList")
    @ResponseBody
    public ResponseInfo wareHouseList(String accountName, Integer pageNo, Integer pageSize, Integer whLevel, String whName, String whClass){
        return  ResponseInfo.success(wareJurisdictionService.wareList(accountName, pageNo, pageSize, this.getOrgId(), whLevel, whName, whClass));
    }

    @RequestMapping("/getAccountWareJurisdictions")
    @ResponseBody
    public String getAccountWareJurisdictions(Long projectId, Long accountId, int type){
        return  wareJurisdictionService.getAccountWareJurisdictions(projectId,accountId,type);
    }
    /**
     * 批量保存人员权限
     */
    @RequestMapping(value = "/saveBatchWareJurisdiction")
    @ResponseBody
    public ResponseInfo saveBatchWareJurisdiction(@RequestBody WareJurisdictionInfoVo wareJurisdictionInfoVo) {
        try {
            wareJurisdictionService.saveBatchWareJurisdiction(wareJurisdictionInfoVo, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     * 单个仓库设置人员权限
     */
    @RequestMapping(value = "/saveWareJurisdiction")
    @ResponseBody
    public ResponseInfo saveWareJurisdiction(@RequestBody WareJurisdictionInfoVo wareJurisdictionInfoVo) {
        try {
            wareJurisdictionService.saveWareJurisdiction(wareJurisdictionInfoVo, getOrgId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }



    /**
     * 查看详情
     */
    @RequestMapping(value = "/queryById")
    @ResponseBody
    public ResponseInfo queryById(Integer whId, Integer type) {
        return ResponseInfo.success(wareJurisdictionService.queryById(whId, getOrgId(), type));
    }

}
