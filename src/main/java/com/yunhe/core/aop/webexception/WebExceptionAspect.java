package com.yunhe.core.aop.webexception;

/**
 * <p>
 * AOP异常捕获通知切面
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月10日
 */

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebExceptionAspect {

    public static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);

   /* @Around("execution(public * com.yunhe.*.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Result<?> resultEntity;
        try {
            logger.info("执行Controller开始: " + pjp.getSignature() + " 参数：" + Lists.newArrayList(pjp.getArgs()).toString());
            resultEntity = (Result<?>) pjp.proceed(pjp.getArgs());
            logger.info("执行Controller结束: " + pjp.getSignature() + "， 返回值：" + resultEntity.toString());
            logger.info("耗时：" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) + "(毫秒).");
        } catch (Throwable throwable) {
            resultEntity = handlerException(pjp, throwable);
        }

        return resultEntity;
    }

    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> resultEntity = null;
        if (e instanceof RuntimeException) {
            logger.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            resultEntity = Result.fail(e.getMessage());
        } else {
            logger.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            resultEntity = Result.fail(e.getMessage());
        }

        return resultEntity;
    }*/
}

