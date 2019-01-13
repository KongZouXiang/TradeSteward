package com.yunhe.core.timedtask;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * <p>
 *     初始化编号设置，每天初始化编号后面累加的数字
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月11日
 */
@Component
public class InitNumberTimer {



    /**
     * 每间隔10秒输出时间
     */
    @Scheduled(cron = "1 0 0 * * ? ")
    public void logTime(){

        /**
         * 要初始化编号的业务
         */


        for (int i = 0; i <100 ; i++) {
            System.out.println("定时器");
        }

    }

}
