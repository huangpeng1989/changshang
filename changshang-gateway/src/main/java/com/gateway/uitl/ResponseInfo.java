package com.gateway.uitl;


import java.io.Serializable;

/**
 * 请求返回信息
 * <p>
 * <typeparam name="LunarCalendar">数据类型</typeparam>
 */
public class ResponseInfo<T> implements Serializable {

    public ResponseInfo() {
    }

    private ResponseInfo(T data) {
        setSuccess(true);
        setData(data);
    }

    private ResponseInfo(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseInfo(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //是否调用成功
    private boolean success;
    //错误码
    private String code = null;//ios 成功：100 失败：300
    //错误信
    private String message = "";
    //数据
    private T data;

    public static <T> ResponseInfo<T> success(T data) {
        ResponseInfo<T> tResponseInfo = new ResponseInfo<>(data);
        tResponseInfo.setCode("100");
        return tResponseInfo;
    }

    public static <T> ResponseInfo<T> error(String message) {
        ResponseInfo<T> tResponseInfo = new ResponseInfo<>(false, message, null);
        tResponseInfo.setCode("300");
        return tResponseInfo;
    }

    public static <T> ResponseInfo<T> error(String code, T data) {
        ResponseInfo<T> tResponseInfo = new ResponseInfo<>(false, "", data);
        tResponseInfo.setCode(code);
        return tResponseInfo;
    }

    public static <T> ResponseInfo<T> error(String code, String message) {
        return new ResponseInfo<>(false, code, message, null);
    }

    public static <T> ResponseInfo<T> error(String code, String message,T data) {
        return new ResponseInfo<>(false, code, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}