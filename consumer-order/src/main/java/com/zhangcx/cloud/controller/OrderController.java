package com.zhangcx.cloud.controller;

import com.zhangcx.cloud.entity.Payment;
import com.zhangcx.cloud.utils.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author zhangcx
 * @date 2020/6/28 22:30
 */
@RestController
public class OrderController {
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://PARMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/addPayment", payment,CommonResult.class);
    }

    @RequestMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/"+id,CommonResult.class);
    }

}
