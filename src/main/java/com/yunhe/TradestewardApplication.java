package com.yunhe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yunhe.*.dao")
@EnableScheduling
@EnableAspectJAutoProxy
@ComponentScan("com.yunhe.*")
/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class TradestewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradestewardApplication.class, args);


    }

}

