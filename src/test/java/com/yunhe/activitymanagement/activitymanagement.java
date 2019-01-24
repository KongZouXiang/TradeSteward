package com.yunhe.activitymanagement;

import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 刘栋
 * @date 2019/1/9 16:52
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class activitymanagement {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    ICommodiTytemplateService commodiTytemplateService;


    @Test
    public void contextLoads() {

        ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
        //存储一条数据
        valueStr.set("goodsProdu","长安");
        System.out.println( valueStr.get("goodsProdu"));
    }



}