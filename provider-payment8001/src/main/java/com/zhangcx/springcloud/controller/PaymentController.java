package com.zhangcx.springcloud.controller;

import com.zhangcx.common.utils.ApiResult;
import com.zhangcx.common.utils.CommonResult;
import com.zhangcx.springcloud.entity.Payment;
import com.zhangcx.springcloud.serivce.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangcx
 * @date 2020/6/27 17:45
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentServiceImpl paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/addPayment")
    public ApiResult addPayment(@RequestParam("serial") String serial){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String createTime = df.format(new Date());

        Payment payment = new Payment();
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        payment.setSerial(serial);
        payment.setCreateTime(createTime);

        int i = paymentService.addPayment(payment);
        if(i != 0){
            return ApiResult.success("success","添加成功 "+"端口："+serverPort+" id:"+id);
        }
        return ApiResult.failure("error");
    }

    @GetMapping("/getPaymentById")
    public ApiResult getPaymentById(@RequestParam("id") String id){
        Payment payment = paymentService.getPaymentById(id);
        return ApiResult.success("查询成功-"+"端口："+serverPort,payment);
    }

    @GetMapping(value = "/timeOutTest")
    public String timeOutTest(){
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
