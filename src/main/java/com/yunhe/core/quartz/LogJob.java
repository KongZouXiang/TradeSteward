package com.yunhe.core.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class LogJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // 执行响应的任务.
        System.out.println("HelloJob.execute," + new Date());
    }
}
