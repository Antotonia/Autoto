package com.zcx.stream.controller;

import com.zcx.stream.server.SendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private SendService sendService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return sendService.send();
    }
}
