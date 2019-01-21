
package com.yunhe.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * AOP日志
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月10日
 */

@Aspect
@Component
public class WebLogAspect {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut(value = "execution(public * com.yunhe.core.common.login.controller.LoginController.login(..))")
    public void webLogin() {
    }

    @Pointcut(value = "execution(public * com.yunhe.*.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * <p>
     * 方法拦截之前开始打印日志
     * </p>
     *
     * @param joinPoint
     */
    @Before(value = "webLog()")
    public void beBefore(JoinPoint joinPoint) {

        logger.info("<--**********************日志开始**************************-->");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

//        URL
        logger.info("URL={}", request.getRequestURL());
//        Method
        logger.info("Method={}", request.getMethod());
//        IP
        logger.info("IP={}", request.getRemoteAddr());
//        类方法
        logger.info("Class_Method={}", joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
//        参数
        logger.info("args={}", joinPoint.getArgs());
//        HTTP请求方法
        logger.info("HTTP_Method", request.getMethod());
        logger.info("<--**********************日志结束**************************-->");
    }


    /**
     * <P>
     * 打印方法返回的结果值
     * </p>
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}

