package com.zhangcx.springcloud.dao;

import com.zhangcx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    public int addPayment(@Param("payment") Payment payment);
    public Payment getPaymentById(@Param("id") String id);
}
