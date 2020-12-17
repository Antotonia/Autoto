package com.zcx.hystrix.service.fallback;

import com.zcx.hystrix.service.ConsumerOrder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOrderFallBack implements ConsumerOrder {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "对方服务已经down机、paymentInfo_OK()方法调用失败";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "对方服务已经down机、paymentInfo_TimeOut()方法调用失败";
    }
}
