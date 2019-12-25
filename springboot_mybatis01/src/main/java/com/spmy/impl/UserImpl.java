package com.spmy.impl;

import com.spmy.mapper.UserMapper;
import com.spmy.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserImpl {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    private final Logger log = LoggerFactory.getLogger(UserImpl.class);

    public Map<String,Object> findByIdUser(int id){
        String key = "user_" + id;
        Map<Object,Object> redisMap = new HashMap<Object,Object>();
        Map<String,Object> resultMap = new HashMap<String,Object>();
        redisMap = redisUtil.hmget(key);
        if(redisMap.isEmpty()){
            resultMap  = userMapper.findById(id);
            redisUtil.hmset(key,resultMap);
            System.out.println("================================数据库获取");
            return resultMap;
        }else {
            resultMap.put(key, redisMap);
            System.out.println("================================缓存获取");
            return resultMap;
        }
    }
}
