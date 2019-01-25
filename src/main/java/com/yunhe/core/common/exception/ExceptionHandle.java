package com.yunhe.core.common.exception;

import com.yunhe.core.common.state.ExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView handle(Exception e ) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            modelAndView.addObject("code", globalException.getCode());
            modelAndView.addObject("msg", globalException.getMessage());
        }if (e instanceof SpelEvaluationException) {

            GlobalException globalException = (GlobalException) e;

            modelAndView.addObject("code", globalException.getCode());
            modelAndView.addObject("msg", globalException.getMessage());

        } else {
            logger.info("系统异常={}", e);
            e.getClass().getName();
            modelAndView.addObject("code", ExceptionEnum.UNKNOW_ERROR.getCode());
            modelAndView.addObject("msg", ExceptionEnum.UNKNOW_ERROR.getMsg());
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
