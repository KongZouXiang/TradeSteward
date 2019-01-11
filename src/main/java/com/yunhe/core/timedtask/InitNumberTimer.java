package com.yunhe.core.timedtask;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

/**
 * <p>
 *     初始化编号设置，每天初始化编号后面累加的数字
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月11日
 */
public class InitNumberTimer {

    private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    /**
     * 每间隔10秒输出时间
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void logTime(){

        /**
         * 要初始化编号的业务
         */


        logger.info("定时任务，现在时间："+System.currentTimeMillis());

    }

}
