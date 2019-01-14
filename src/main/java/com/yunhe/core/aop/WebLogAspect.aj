package com.yunhe.core.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

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

    private Logger log = Logger.getLogger("");

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

        log.info("log");
        System.out.println("doBefore");
    }
    /**
     *
     * @After 在方法执行之后执行
     *
     * */
    @After("webLoginLog()")
    public void doAfter(){

        log.info("doAfter");
        System.out.println("doAfter");
    }

}
