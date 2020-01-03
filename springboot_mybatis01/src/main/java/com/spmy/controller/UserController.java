package com.spmy.controller;

import com.spmy.impl.UserImpl;
//import com.spmy.quartz.test.ExcecuteQuartz;
import com.spmy.quartz.test.ExcecuteQuartz;
import com.spmy.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

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
    public Object findById(@RequestParam int id){
        return userImpl.findByIdUser(id);
    }

    @RequestMapping("/set")
    public boolean set(@RequestParam String key,@RequestParam String value){
        return redisUtil.set(key,value);
    }

    @RequestMapping("/get")
    public Object get(@RequestParam String key){
        return redisUtil.get(key);
    }

    //=============================定时任务接口==========================
    @Autowired
    private ExcecuteQuartz excecuteQuartz;
    @RequestMapping("/addJob")
    public String addJob() throws Exception {
        excecuteQuartz.addJob();
        return "success";
    }
    @RequestMapping("/delJob")
    public String delJob() throws Exception {
        excecuteQuartz.delJob("123","12345");
        return "success";
    }

}
