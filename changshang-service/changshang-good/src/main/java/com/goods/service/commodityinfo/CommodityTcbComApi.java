package com.goods.service.commodityinfo;



import entity.ModelPagedList;
import excel.Excel;
import modelpojo.model.account.AccountModel;
import modelpojo.vo.CommodityResponse;
import modelpojo.vo.CommodityTcbComExportDto;
import modelpojo.vo.CommodityTcbComVo;
import modelpojo.vo.CommodityTccComclassDto;
import modelpojo.vo.allotBill.ExportCommInfo;
import modelpojo.vo.commodityinfo.CommExeclVo;
import modelpojo.vo.commodityinfo.CommSuppExeclVo;

import java.util.List;


public interface CommodityTcbComApi {
    ModelPagedList selectCommList(CommodityTcbComVo commodityTcbComVo, Integer pageNo, Integer pageSize, Long projectId);

    int deleteComm(CommodityTcbComVo commodityTcbComVo ,Long projectId);

    void checkComm(List<CommodityTcbComVo> commodityTcbComVoList,Long projectId,Long accountId) throws Exception;

    List<CommodityTccComclassDto> selectComClass(Long projectId);

    List<CommodityTcbComExportDto> selectPubData(Integer pDictType, Long projectId);

    List<CommodityTcbComExportDto> selectTsbTax(Long projectId);

    List<CommodityTcbComExportDto> selectsupp(Long projectId);

    List<CommodityTcbComExportDto> selectDataDict(Integer dicType,Long projectId);

    int importComm(Excel<CommExeclVo> excel, Long projectId, Long accountId) throws Exception;

    String importPreComm(Excel<CommExeclVo> excel, Long projectId, Long accountId) throws Exception;

    CommodityResponse listImportCom(String redisKey, Integer pageNo, Integer pageSize, Integer type, Long user);

    List<ExportCommInfo> exportCommOut(CommodityTcbComVo info, Long projectId);

    AccountModel getAccountObj(Long accountId);

    String importCommSupp(Excel<CommSuppExeclVo> excel, Long projectId, Long projectRootId, Long accountId);


}
