package com.zcx.hystrix.service.impl;

import com.zcx.hystrix.service.ConsumerOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConsumerOrderImpl implements ConsumerOrder {
    @Resource
    private ConsumerOrder consumerOrder;

    @Override
    public String paymentInfo_OK(Integer id) {
        return consumerOrder.paymentInfo_OK(id);
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return consumerOrder.paymentInfo_TimeOut(id);
    }
}
