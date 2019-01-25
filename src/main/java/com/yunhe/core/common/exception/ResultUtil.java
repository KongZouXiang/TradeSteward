package com.yunhe.core.common.exception;

import com.yunhe.core.common.state.ExceptionEnum;

/**
 * Demo class
 *
 * @author 孔邹祥
 * @date 2016/10/31
 */
public class ResultUtil {


    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result<Object> success(){
        return success(null);
    }

    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum){
        Result<Object> result = new Result<>();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }

}
