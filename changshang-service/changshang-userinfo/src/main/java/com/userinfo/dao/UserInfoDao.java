package com.userinfo.dao;

import modelpojo.AccountLoginVo;
import modelpojo.model.account.AccountModel;
import modelpojo.vo.dataDcit.CatecommTssDatadictDto;
import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @PackageName:com.userinfo.dao
 * @ClassName:UserInfoDao
 * @Description
 * @author: huangpeng
 * @date:2021/9/14 10:28
 */
public interface UserInfoDao  extends Mapper<AccountLoginVo> {

    @SelectProvider(type = DataSQL.class,method = "login")
    public AccountModel login(String userName);
}
