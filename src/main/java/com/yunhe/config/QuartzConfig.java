package com.yunhe.config;


import com.yunhe.core.quartz.LogJob;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.io.IOException;

/**
 * <p>
 * Quartz任务调度配置类
 * </p>
 */
@Configuration
public class QuartzConfig {

    /**
     * <p>
     * scheduler任务调度器
     * </p>
     *
     * @return
     * @throws IOException
     * @throws SchedulerException
     */
   /* @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }*/


    /**
     * 1.创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        //关联我们自己的Job类
        factory.setJobClass(LogJob.class);
        return factory;
    }

}
