package com.zcx.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class HsConsumerDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HsConsumerDashboard9001.class,args);
    }
}
