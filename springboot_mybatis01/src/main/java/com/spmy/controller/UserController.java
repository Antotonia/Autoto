package com.spmy.controller;

import com.spmy.impl.UserImpl;
import com.spmy.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserImpl userImpl;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String testCon(){
        return "success";
    }

    @RequestMapping("/find")
    public Map<String,Object> findById(@RequestParam int id){
        Map<String,Object> map = userImpl.findByIdUser(id);
        return map;
    }

    @RequestMapping("/set")
    public boolean set(@RequestParam String key,@RequestParam String value){
        return redisUtil.set(key,value);
    }

    @RequestMapping("/get")
    public Object get(@RequestParam String key){
        return redisUtil.get(key);
    }

}
