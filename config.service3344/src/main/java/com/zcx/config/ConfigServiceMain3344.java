package com.zcx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceMain3344.class,args);
    }
}