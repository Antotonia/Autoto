package com.zcx.hystrix.controller;

import com.netflix.discovery.converters.Auto;
import com.zcx.hystrix.service.ConsumerOrder;
import com.zcx.hystrix.service.impl.ConsumerOrderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private ConsumerOrderImpl consumerOrderImpl;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = consumerOrderImpl.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/order/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = consumerOrderImpl.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }
}

