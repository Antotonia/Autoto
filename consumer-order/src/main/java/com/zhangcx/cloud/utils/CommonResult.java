package com.zhangcx.cloud.utils;

import com.zhangcx.cloud.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangcx
 * @date 2020/6/2715:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;
    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public CommonResult(String message, T date) {
        this.message = message;
        this.date = date;
    }


    public static CommonResult success(String message, Object data){
        return new CommonResult(message,data);
    }

}




