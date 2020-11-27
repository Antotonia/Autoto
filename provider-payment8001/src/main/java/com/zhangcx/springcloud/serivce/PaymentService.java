package com.zhangcx.springcloud.serivce;

import com.zhangcx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangcx
 * @date 2020/6/27 17:41
 */
public interface PaymentService {
    public int addPayment(@Param("payment") Payment payment);
    public Payment getPaymentById(@Param("id") String id);
}
