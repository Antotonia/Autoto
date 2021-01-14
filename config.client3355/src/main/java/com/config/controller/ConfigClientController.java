package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "client")
@RefreshScope //刷新
public class ConfigClientController {
    @Value("${spring.profiles.active}")
    private String active;

    @GetMapping(value = "/getActive")
    public String getActive(){
        return active;
    }
}
