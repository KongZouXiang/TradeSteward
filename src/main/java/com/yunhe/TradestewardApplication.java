package com.yunhe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Demo class
 *
 * @author 孔邹祥
 * @date 2016/10/31
 */
@SpringBootApplication
@MapperScan("com.yunhe.*.dao")
@EnableSwagger2
@EnableScheduling
public class TradestewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradestewardApplication.class, args);
    }

}

