package modelpojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程变量保持者
 * Created by lufei on 2017/3/30.
 */
public class TLHoder {
    //和数据库中的名字配置一致
    private static String currentShema = "company";

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal() {
        protected Map<String, Object> initialValue() {
            return new HashMap();
        }
    };

    public static void put(String key, Object value) {
        threadLocal.get().put(key, value);
    }

    public static Object get(String key) {
        return threadLocal.get().get(key);
    }

    public static String getString(String key) {
        return (String) threadLocal.get().get(key);
    }

    public static Long getLong(String key) {
        return (Long) threadLocal.get().get(key);
    }

    public static Boolean getBool(String key) {
        Boolean value = (Boolean) threadLocal.get().get(key);
        if (value == null) {
            return false;
        }
        return value;
    }

    public static <T> T getBean(String key) {
        Object value = threadLocal.get().get(key);
        return (T) value;
    }


    public static String getCurrentShema() {
        return currentShema;
    }

    public static void setCurrentShema(String currentShema) {
        TLHoder.currentShema = currentShema;
    }
}
