package com.yunhe.activitymanagement;

import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.yunhe.core.numbersetting.constant.NumberRule;
import com.yunhe.core.util.RUDResult;
import com.yunhe.core.util.ResultRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
    ICommodiTytemplateService commodiTytemplateService;


    @Test
    public void contextLoads() {

    }



}