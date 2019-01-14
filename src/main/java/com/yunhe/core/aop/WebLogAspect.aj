package com.yunhe.core.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     AOP日志切面
 * </p>
 *@author 孔邹祥
 *@date 2019年1月10日
 */
@Component
@Aspect
public class WebLogAspect {

    Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut(value = "execution(public * com.yunhe.basicdata.controller.*(..))")
    public void webLog(){}

    @Pointcut(value = "execution( public * com.yunhe.core.common.login.controller.LoginController.login(..))")
    public void webLoginLog(){}
    /**
     *
     * @Before 在方法执行之前执行
     *
     * */
    @Before("webLog()")
    public void log() {

        logger.info("log");
        System.out.println("doBefore");
    }
    /**
     *
     * @After 在方法执行之后执行
     *
     * */
    @After("webLoginLog()")
    public void doAfter(){

        logger.info("doAfter");
        System.out.println("doAfter");
    }

}
