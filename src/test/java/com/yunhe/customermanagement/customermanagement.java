package com.yunhe.customermanagement;

import com.yunhe.core.constant.NumberRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class customermanagement {

    static int a;

    @Test
    public void contextLoads() {

        System.out.println(new NumberRule().XSD_NUMBER);

    }

}

