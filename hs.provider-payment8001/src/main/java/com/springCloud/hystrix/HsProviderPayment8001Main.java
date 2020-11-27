package com.springCloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangcx
 * @date 2020-9-16 16:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HsProviderPayment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(HsProviderPayment8001Main.class,args);
    }
}
