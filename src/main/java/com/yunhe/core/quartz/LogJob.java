package com.yunhe.core.quartz;

import com.yunhe.systemsetup.dao.SystemLogMapper;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogJob implements Job {

    @Resource
    SystemLogMapper systemLogMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


     /*   String convertString = RUDResult.ConvertString(systemLogMapper.delete(null), ResultRule.DELETE);
        // 执行响应的任务.
        System.out.println(convertString + new Date());*/
    }
}
