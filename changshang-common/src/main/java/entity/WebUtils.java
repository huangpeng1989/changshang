package entity;


import modelpojo.TLHoder;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {


    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) TLHoder.get(REQUEST);
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) TLHoder.get(RESPONSE);
    }

    public static String getParameter(String key) {
        return getRequest().getParameter(key);
    }

    public static String getHead(String key) {
        return StringUtils.isNotBlank(getRequest().getHeader(key)) ? getRequest().getHeader(key) : getRequest().getParameter(key);
    }

    public static <T> T getHeadBean(String key, Class<T> type) {
        String str = getHead(key);
        return (T) JSONObject.toBean(JSONObject.fromObject(str), type);
    }

    public static <T> T getParameterBean(String key, Class<T> type) {
        String str = getParameter(key);
        return (T) JSONObject.toBean(JSONObject.fromObject(str), type);
    }

    public static JSONObject getHeadJson(String key) {
        String str = getHead(key);
        return JSONObject.fromObject(str);
    }

    public static JSONObject getParameterJson(String key) {
        String str = getParameter(key);
        return JSONObject.fromObject(str);
    }

}
