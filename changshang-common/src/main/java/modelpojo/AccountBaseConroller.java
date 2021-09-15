package modelpojo;

import entity.WebUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by lufei on 2017/6/29.
 */
public class AccountBaseConroller {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 从国际化资源配置文件中根据key获取value  方法一
     *
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        Locale currentLocale = (Locale) TLHoder.get("locale");
        ResourceBundle bundle = ResourceBundle.getBundle("message", currentLocale);
        return bundle.getString(key);
    }

    /**
     * 获取当前账号id
     *
     * @return
     */
    public Long getAccountId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getAccountId();
    }

    /**
     * 获取当前公司id
     *
     * @return
     */
    public Long getCompanyId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getCompanyId();
    }

    public Long getOrgId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getOrganizeId();
    }

    public Long getScenicId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getScenicId();
    }

    public Long getChannelId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getChannelOrgId();
    }

    public String getString(String key) {
        HttpServletRequest request = TLHoder.getBean("request");
        String value = request.getHeader(key);
        if (value == null) {
            value = request.getParameter(key);
        }
        return value;
    }

    /**
     * 会员端 accountId替换会cardId
     * @return
     */
    public Long getCardId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getAccountId();
    }

    /**
     * 会员端 comapnyId替换为memberId
     * @return
     */
    public Long getMemberId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getCompanyId();
    }

    /**
     * 全民营销C端 accountId替换为marketUserId
     * @return
     */
    public Long getMarketUserId() {
        String token = WebUtils.getHead("token");
        if (StringUtils.isBlank(token)) {
            return -1L;
        }
        TokenInfo tokenInfo = TokenInfo.parseToken(token);
        return tokenInfo.getAccountId();
    }

    /**
     * 以joson的string格式传过来的数据，转成javaBean
     *
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getBean(String key, Class<T> type) {
        String value = getString(key);
        JSONObject jsonObject = JSONObject.fromObject(value);
        T t = (T) jsonObject.toBean(jsonObject, type);
        return t;
    }

    /**
     * 从不带key的数据对中取值并转成 javaBean
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> T fromBodyBean(Class<T> type) {
        HttpServletRequest request = TLHoder.getBean("request");
        for (String key : request.getParameterMap().keySet()) {
            if (key.startsWith("{")) {
                JSONObject jsonObject = JSONObject.fromObject(key);
                T t = (T) jsonObject.toBean(jsonObject, type);
                return t;
            }
        }
        return null;
    }


}
