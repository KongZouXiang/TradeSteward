package com.yunhe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Demo class
 *
 * @author 孔邹祥
 * @date 2016/10/31
 */
@SpringBootApplication
@MapperScan("com.yunhe./**")
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
@EnableScheduling
public class TradestewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradestewardApplication.class, args);
    }

}

