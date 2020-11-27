package com.zhangcx.common.utils;


import java.io.Serializable;

public class ApiResult implements Serializable {
    private static final String SUCCESS = "0";
    private static final String DEFAULT_FAIL = "1";
    protected String code = SUCCESS;
    protected String msg;
    private Object data;

    public ApiResult() {
    }
    public ApiResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ApiResult(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }
    public static ApiResult success(String msg, Object data) {
        return new ApiResult(msg,data);
    }
    public static ApiResult success() {
        return success(null,null);
    }
    public static ApiResult success(Object data) {
        return success(null,data);
    }
    public static ApiResult success(String msg) {
        return success(msg,null);
    }



    public static ApiResult failure(String code, String msg, Object data) {
        return new ApiResult(code, msg, data);
    }
    public static ApiResult failure() {
        return failure(DEFAULT_FAIL, null,null);
    }
    public static ApiResult failure(String msg) {
        return failure(DEFAULT_FAIL, msg,null);
    }
    public static ApiResult failure(int code, String msg) {
        return failure(code + "", msg,null);
    }
    public boolean hasError() {
        return !compareString(this.code,SUCCESS);
    }

    /**
     * 比较两个字符串是否相等
     * @param a
     * @param b
     * @return
     */
    private static boolean compareString(String a,String b){
        return null != a && a.equals(b);
    }

    public String getCode() {
        return code;
    }

    public ApiResult setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ApiResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public ApiResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
