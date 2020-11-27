package com.zhangcx.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangcx
 * @date 2020/6/28 22:28
 */
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced //@LoadBalanced注解赋予了RestTemplate拥有负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
