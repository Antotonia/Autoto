package com.zhangcx.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangcx
 * @date 2020/6/2715:41
 */
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;

    public CommonResult(String message) {
        this.message = message;
    }

    public CommonResult(Integer code,String message, T data){
        this.code = code;
        this.message = message;
        this.date = date;
    }


    public static CommonResult success(String message, Object data){
        return new CommonResult(message,data);
    }

    public static CommonResult failure(String message){
        return new CommonResult(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public CommonResult(String message, T date) {
        this.message = message;
        this.date = date;
    }

}
