package com.zhangcx.springcloud.serivce.impl;
import com.zhangcx.springcloud.dao.PaymentMapper;
import com.zhangcx.springcloud.entity.Payment;
import com.zhangcx.springcloud.serivce.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author zhangcx
 * @date 2020/6/27 17:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentMapper.getPaymentById(id);
    }
}
