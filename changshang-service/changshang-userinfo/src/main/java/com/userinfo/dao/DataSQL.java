package com.userinfo.dao;

import modelpojo.vo.dataDcit.CatecommTssDatadictVo;
import org.apache.commons.lang3.StringUtils;

/**
 * @PackageName:com.userinfo.dao
 * @ClassName:DataSQL
 * @Description
 * @author: huangpeng
 * @date:2021/9/14 10:30
 */
public class DataSQL {

    public  static String login(String userName){
        StringBuffer buffer = new StringBuffer("\n");
        buffer.append("SELECT login_name loginName,nick_name nickName, password ,status FROM account  WHERE login_name = '"+userName+"' ");
        return  buffer.toString();
    }
}
