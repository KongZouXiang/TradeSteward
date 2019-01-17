package com.yunhe.core.aop.webexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

   @ExceptionHandler(value = Exception.class)
   @ResponseBody
    public Result handle(Exception e){
       if (e instanceof GlobalException) {
           GlobalException globalException = (GlobalException) e;
           return ResultUtil.error(globalException.getCode(), globalException.getMessage());
       }else {
           logger.info("【系统异常】{}",e);
           return ResultUtil.error(-1,"未知错误!");
       }

   }
}
