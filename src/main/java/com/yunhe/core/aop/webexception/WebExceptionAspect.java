package com.yunhe.core.aop.webexception;

/**
 * <p>
 * AOP异常捕获通知切面
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月10日
 */

import com.yunhe.core.common.exception.ExceptionHandle;
import com.yunhe.core.common.exception.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class WebExceptionAspect {

    public static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);

    @Resource
    ExceptionHandle exceptionHandle;

    @Pointcut(value = "execution(public * com.yunhe.*.controller.*.*(..))")
    public void exceptionLogin() {
    }

    @Around("exceptionLogin()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Result result = null;

        try {
        } catch (Exception e) {
            return exceptionHandle.handle(e);
        }
        if(result == null){

            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

}

