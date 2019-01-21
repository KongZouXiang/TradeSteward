package com.yunhe.redis;

import com.yunhe.redis.service.RedisService;
import com.yunhe.redis.serviceImpl.RedisServiceImpl;
import com.yunhe.systemsetup.service.impl.EmployServiceImpl;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redistest {
    private JSONObject json= new JSONObject();
    @Autowired
    private RedisServiceImpl redisService;

    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("redis_string_test", "springboot redis test");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = redisService.get("redis_string_test");
        System.out.println(result);
    }



}
