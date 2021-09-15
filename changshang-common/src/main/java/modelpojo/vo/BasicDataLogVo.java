package modelpojo.vo;

import modelpojo.model.BasicDataLog;

import java.io.Serializable;

/**
 * 餐商基础信息操作日志扩展类
 */
public class BasicDataLogVo extends BasicDataLog implements Serializable {

    //操作人名称
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
