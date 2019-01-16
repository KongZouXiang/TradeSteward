package com.yunhe.core.aop.webexception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Demo class
 *
 * @author 孔邹祥
 * @date 2019年1月17日
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException {

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public GlobalException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public GlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

}
