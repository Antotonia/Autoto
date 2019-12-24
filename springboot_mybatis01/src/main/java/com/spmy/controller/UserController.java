package com.spmy.controller;

import com.spmy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public String testCon(){
        return "success";
    }
    @RequestMapping("/find")
    public Map<String,Object> findByIdUser(@RequestParam int id){
        Map<String,Object> map  = userMapper.findById(id);
        return map;
    }
}
