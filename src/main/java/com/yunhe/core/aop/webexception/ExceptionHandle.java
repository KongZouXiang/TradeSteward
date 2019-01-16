package com.yunhe.core.aop.webexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    public String handle(Exception e,  Model model) {

        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            model.addAttribute("code", globalException.getCode());
            model.addAttribute("msg", globalException.getMessage());
        } else {
            logger.info("【系统异常】{}", e);
            model.addAttribute("code", ExceptionEnum.UNKNOW_ERROR.getCode());
            model.addAttribute("msg", ExceptionEnum.UNKNOW_ERROR.getMsg());
        }
        return "error";
    }
}
