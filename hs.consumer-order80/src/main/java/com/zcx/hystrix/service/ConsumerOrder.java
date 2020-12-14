package com.zcx.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "HS-PROVIDER-PAYMENT8001")
public interface ConsumerOrder {
    @GetMapping(value = "/payment/hystrix/ok/{id}",produces = "application/json;charset=UTF-8")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}",produces = "application/json;charset=UTF-8")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
