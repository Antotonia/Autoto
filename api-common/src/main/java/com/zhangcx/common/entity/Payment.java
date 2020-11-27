package com.zhangcx.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author zhangcx
 * @date 2020/7/5 17:02
 */
@Data
@AllArgsConstructor //全参
@NoArgsConstructor //空参
public class Payment implements Serializable {
    private long id;
    private String serial;

}
