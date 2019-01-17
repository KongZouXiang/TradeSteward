package com.yunhe.core.aop.webexception;

import lombok.Data;

/**
 * <p>
 * 返回体报文的实体类
 * </p>
 *
 * @param <T>
 * @author 孔邹祥
 * @date 2016/10/31
 */

@Data
public class Result<T> {

    /**
     * error_code 状态值：0 极为成功，其他数值代表失败
     */
    private Integer code;

    /**
     * error_msg 错误信息，若code为0时，为success
     */
    private String msg;

    /**
     * content 返回体报文的出参，使用泛型兼容不同的类型
     */
    private T data;

}
