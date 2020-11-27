package com.zhangcx.feign.server;

import com.zhangcx.common.utils.ApiResult;
import com.zhangcx.common.utils.CommonResult;
import com.zhangcx.feign.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "PARMENT-SERVICE")
public interface FergnService {
    @PostMapping(value = "/payment/addPayment",produces = "application/json;charset=UTF-8")
    ApiResult addPayment(@RequestParam("serial") String serial);

    @GetMapping(value = "/payment/getPaymentById", produces = "application/json;charset=UTF-8")
    ApiResult getPaymentById(@RequestParam("id") String id);
}
