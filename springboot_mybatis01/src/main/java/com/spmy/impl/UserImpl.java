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
import java.util.Timer;

@Component
public class UserImpl {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Resource
    private RedisUtil redisUtil;

    private final Logger log = LoggerFactory.getLogger(UserImpl.class);
    private int i = 1;
    private Timer timer = new Timer();
    public Map<Object,Object> findByIdUser(int id) {
//        Map<Object, Object> map = userMapper.findById(id);
//        return map;
        String key = "user_" + id;
        Map<Object, Object> map = new HashMap<Object, Object>();
        map = redisUtil.hmget(key);
        if (map.isEmpty()) {
            System.out.println("================================数据库获取");
            map = userMapper.findById(id);
            redisUtil.hmset(key, map);
            return map;
        } else {
            System.out.println("================================缓存获取");
            return map;
        }
    }
}
