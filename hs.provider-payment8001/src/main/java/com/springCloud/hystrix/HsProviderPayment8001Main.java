package com.springCloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author zhangcx
 * @date 2020-9-16 16:59
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HsProviderPayment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(HsProviderPayment8001Main.class,args);
    }
}
