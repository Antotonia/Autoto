package com.zhangcx.feign.controller;

import com.zhangcx.common.utils.ApiResult;
import com.zhangcx.feign.server.FergnService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/feign")
public class FeignController {
    @Resource
    private FergnService fergnService;

    @PostMapping("/addPayment")
    public ApiResult addPayment(@RequestParam("serial") String serial){
        return fergnService.addPayment(serial);
    }

    @GetMapping("/getPaymentById")
    public ApiResult getPaymentById(@RequestParam("id") String id){
        return fergnService.getPaymentById(id);
    }
}
