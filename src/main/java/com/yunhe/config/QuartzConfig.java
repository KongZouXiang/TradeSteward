package com.yunhe.config;


import com.yunhe.core.quartz.LogJob;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.io.IOException;

/**
 * <p>
 * Quartz任务调度配置类
 * </p>
 */
@Configuration
public class QuartzConfig {


    /**
     * 1.创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        //关联我们自己的Job类
        factory.setJobClass(LogJob.class);
        return factory;
    }

    /**
     * 2.创建Trigger对象 触发器，用于定义任务调度时间规则
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        //关联JobDetail对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        //该参数表示一个执行的毫秒数
        factory.setRepeatInterval(2000);
        //重复次数
        factory.setRepeatCount(1);
        return factory;
    }

    /**
     * <p>
     * scheduler任务调度器
     * </p>
     *
     * @return
     * @throws IOException
     * @throws SchedulerException
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //关联trigger
        factory.setTriggers(simpleTriggerFactoryBean.getObject());

        return factory;
    }

}
