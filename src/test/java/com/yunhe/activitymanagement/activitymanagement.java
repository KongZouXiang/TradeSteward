package com.yunhe.activitymanagement;

import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.yunhe.core.redis.RedisService;
import com.yunhe.systemsetup.entity.Employ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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
    RedisService redisService;
    @Resource
    ICommodiTytemplateService commodiTytemplateService;


    @Test
    public void contextLoads() throws Exception {

        Employ employ = new Employ();
        employ.setEmDelInvoice("123");
        employ.setEmEmail("1231");
        //存储一条数据
        redisService.set("employ", employ);

        System.out.println( "************"+redisService.get("employ").toString());
    }



}