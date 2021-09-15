package com.userinfo.service.impi;

import com.userinfo.dao.UserInfoDao;
import com.userinfo.service.AccountApi;
import entity.BCrypt;
import modelpojo.AccountStatus;
import modelpojo.ErrorCode;
import modelpojo.model.account.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ming.jin
 * @Date 2018/8/7
 */
@Service
public class AccountBiz implements AccountApi {

    @Autowired
    UserInfoDao userInfoDao ;

    @Override
    public AccountModel login(String userName, String password) {

        AccountModel account = userInfoDao.login(userName);
        if (account == null) {
            throw new RuntimeException(ErrorCode.ACCOUNT_ERROR);
        }
        if(!BCrypt.checkpw(password,account.getPassword())){
            throw new RuntimeException(ErrorCode.ACCOUNT_PASSWORD);
        }
        if (AccountStatus.INVALID.equals(account.getStatus())) {
            throw new RuntimeException(ErrorCode.ACCOUNT_EXPIRE);
        }
        return account;
    }


}
