package com.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.system.service.DataDictApi;
import entity.ModelPagedList;
import modelpojo.AccountBaseConroller;
import modelpojo.ResponseInfo;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典信息
 */
@Controller
@RequestMapping("/data")
public class DataDictController extends AccountBaseConroller {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DataDictApi dataDictApi;

    /**
     * 参数设置查询
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectDataList")
    @ResponseBody
    public ResponseInfo selectDataList(CatecommTssDatadictVo info , Integer pageNo, Integer pageSize ) {


        try {
            PageInfo<CatecommTssDatadictDto> list = dataDictApi.selectDataList(info,pageNo,pageSize,1264823717716955137L);
            return new ResponseInfo(true,"100","操作成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(false,"300","操作失败","");
        }
    }


    /**
     * 参数设置类型详情查询
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectDataDetailList")
    @ResponseBody
    public ModelPagedList selectDataDetailList(CatecommTssDatadictVo info , Integer pageNo, Integer pageSize,Long companyId ) {

            ModelPagedList list = dataDictApi.selectDataDetailList(info,pageNo,pageSize,getCompanyId());
            return  list;
    }


    /**
     * 进入新增页面，自动生成字典键值
     * @param
     * @return
     */
    @RequestMapping(value = "/makeCode")
    @ResponseBody
    public ResponseInfo makeCode(CatecommTssDatadictVo info  ) {


        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",dataDictApi.makeCode(info));
            return new ResponseInfo(true,"100","操作成功",jsonObject);
        } catch (Exception e) {
            return new ResponseInfo(false,"300","操作失败","");
        }
    }

    /**
     * 参数设置新增
     * @param
     * @return
     */
    @RequestMapping(value = "/addData")
    @ResponseBody
    public ResponseInfo addData(CatecommTssDatadictVo info  ) {
        try {
            dataDictApi.addData(info, getCompanyId(), getAccountId());
        } catch (Exception e) {
            return ResponseInfo.error("300", e.getMessage());
        }
        return ResponseInfo.success(null);
    }


    /**
     * 参数设置编辑
     * @param
     * @return
     */
    @RequestMapping(value = "/updateData")
    @ResponseBody
    public ResponseInfo updateData(CatecommTssDatadictVo info ) {


        try {
            dataDictApi.updateData(info,getCompanyId(),getAccountId());
            return new ResponseInfo(true,"100","操作成功","");
        } catch (Exception e) {
            return new ResponseInfo(false,"300","操作失败","");
        }
    }



    /**
     * 参数设置查看
     * @param
     * @return
     */
    @RequestMapping(value = "/findData")
    @ResponseBody
    public ResponseInfo findData(CatecommTssDatadictVo info ) {


        try {
            CatecommTssDatadictDto result =  dataDictApi.findData(info,getOrgId());
            return new ResponseInfo(true,"100","操作成功",result);
        } catch (Exception e) {
            return new ResponseInfo(false,"300","操作失败","");
        }
    }

    @RequestMapping(value = "/findDataByCode")
    @ResponseBody
    public CatecommTssDatadictDto findDataByCode(Integer dictTpCode) {
            CatecommTssDatadictDto result =  dataDictApi.findDataByCode(dictTpCode,getOrgId());
            return  result;
    }

}
