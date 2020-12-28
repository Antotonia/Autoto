package com.zhangcx.gatewey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWeyMain {
    public static void main(String[] args) {
        SpringApplication.run(GateWeyMain.class,args);
    }
}
