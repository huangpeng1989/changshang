package com.userinfo.controller;

import com.alibaba.fastjson.JSON;
import com.userinfo.service.AccountApi;
import entity.JwtUtil;
import modelpojo.AccountLoginVo;
import modelpojo.ErrorCode;
import modelpojo.ResponseInfo;
import modelpojo.model.account.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @PackageName:com.userinfo.controller
 * @ClassName:UserContoller
 * @Description
 * @author: huangpeng
 * @date:2021/9/14 9:36
 */
@RequestMapping("/user")
@Controller
public class UserContoller {
    @Autowired
    private AccountApi accountApi;

    @ResponseBody
    @RequestMapping("/login")
    public ResponseInfo login(String loginName, String password) {

        try {
            AccountModel loginVo = accountApi.login(loginName, password);
            Map<String,Object> info = new HashMap<String,Object>();
            info.put("username",loginVo.getNickName());
            //生成令牌
            String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(info), null);
            loginVo = new AccountModel();
            loginVo.setJwt(jwt);
            loginVo.setNickName(loginVo.getNickName());
            return ResponseInfo.success(loginVo);
        } catch (Exception e) {
            e.printStackTrace();
            if (ErrorCode.ACCOUNT_ERROR.equals(e.getMessage())) {
                return ResponseInfo.error(ErrorCode.ACCOUNT_ERROR, "账号错误");
            } else if (ErrorCode.ACCOUNT_EXPIRE.equals(e.getMessage())) {
                return ResponseInfo.error(ErrorCode.ACCOUNT_EXPIRE, "账户已失效");
            } else if (ErrorCode.ACCOUNT_PASSWORD.equals(e.getMessage())) {
                return ResponseInfo.error(ErrorCode.ACCOUNT_PASSWORD, "密码错误");
            }  {
                return ResponseInfo.error(ErrorCode.METHOD_EXCEPTION, "接口异常");
            }
        }
    }

}
