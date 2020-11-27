package zookeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zookeeper.config.RestTemplateConfig;

import javax.annotation.Resource;

/**
 * @author zhangcx
 * @date 2020-8-30 13:32
 */
@RestController
@RequestMapping("/comsumer")
public class OrderController {
    private final static String PROVIDER_URL = "http://zk-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zk/comsumer")
    public String getMassageInfo(){
        return restTemplate.getForObject(PROVIDER_URL+"/payment/zk",String.class);
    }
}
