package com.userinfo.service;


import entity.ModelPagedList;
import modelpojo.*;
import modelpojo.model.OrgInfoModel;
import modelpojo.model.account.AccountModel;
import modelpojo.model.account.PrivilegeModel;

import java.util.List;
import java.util.Map;

/**
 * @Author ming.jin
 * @Date 2018/8/7
 */
public interface AccountApi {

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    AccountModel login(String userName, String password);


}
