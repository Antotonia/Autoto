package com.zcx.hystrix.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private ConsumerOrderImpl consumerOrderImpl;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/order/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = consumerOrderImpl.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/order/hystrix/timeout/{id}")
    @HystrixCommand
    /*@HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int i = 10/0;
        String result = consumerOrderImpl.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }

    //特定方法fallback
    public String paymentInfoTimeOutFallback(Integer id){
        return "8001系统繁忙、或者程序异常、请稍后重试！id="+id;
    }

    //全局fallback
    public String globalFallback(){
        return "Global这是全局的fallback";
    }
}

